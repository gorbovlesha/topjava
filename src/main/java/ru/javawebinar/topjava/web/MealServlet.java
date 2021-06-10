package ru.javawebinar.topjava.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.InMemoryUserMealRepository;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    private MealRepository repository;

    @Override
    public void init() throws ServletException {
        super.init();
        repository = new InMemoryUserMealRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");
        String action = req.getParameter("action");
        if (action == null) {
            log.info("getAll");
            req.setAttribute("mealsList",
                    MealsUtil.getMealsDTO(repository.getAll(), 2000));
            req.getRequestDispatcher("/mealList.jsp").forward(req, resp);
        } else if(action.equals("delete")) {
            int id = getId(req);
            log.info("delete{}", id);
            repository.delete(id);
            resp.sendRedirect("meals");
        } else {
            final Meal meal = action.equals("create") ?
                    new Meal(LocalDateTime.now(), "", 1000) :
                    repository.get(getId(req));
            req.setAttribute("meal", meal);
            req.getRequestDispatcher("mealEdit.jsp").forward(req, resp);
        }


    }
    private int getId(HttpServletRequest request) {
        return 0;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("post meals validation");
        req.setCharacterEncoding("UTF8");
        String id = req.getParameter("id");

        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(req.getParameter("dateTime")),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("calories")));
        log.info(meal.isNew() ? "Create{}" : "Update{}", meal);
        repository.save(meal);
        resp.sendRedirect("meals");

    }
    private boolean requestIsValid(final HttpServletRequest req) {
        final String description = req.getParameter("description");
        final String calories = req.getParameter("calories");
        final String localDateTime = req.getParameter("localDateTime");

        return description != null && description.length() > 0 &&
                calories != null && calories.length() > 0 &&
                localDateTime != null && localDateTime.length() > 0;

    }
}
