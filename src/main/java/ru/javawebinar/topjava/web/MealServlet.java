package ru.javawebinar.topjava.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");

        List<MealTo> mealsList = MealsUtil.getMealsDTO();
        req.setAttribute("mealsList", mealsList);
        req.getRequestDispatcher("/meals.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("post meals validation");
        req.setCharacterEncoding("UTF8");

        if (requestIsValid(req)) {
            doGet(req, resp);
        }
        final String description = req.getParameter("description");
        final String calories = req.getParameter("calories");
        final String localDateTime = req.getParameter("localDateTime");

        System.out.println(description);
        System.out.println(calories);
        System.out.println(localDateTime);

        final Meal meal = new Meal(LocalDateTime.parse(localDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                description,
                Integer.parseInt(calories));
        MealsUtil.addNewMeal(meal);
        doGet(req, resp);

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
