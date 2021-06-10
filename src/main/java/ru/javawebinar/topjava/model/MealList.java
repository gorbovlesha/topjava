package ru.javawebinar.topjava.model;

import java.util.List;

public class MealList {
    private static List<Meal> allMeals;



    public static List<Meal> getAllMeals() {
        return allMeals;
    }

    public static void addMeal(Meal meal) {
        allMeals.add(meal);
    }

    public static void updateMeal(Meal meal) {

    }
}
