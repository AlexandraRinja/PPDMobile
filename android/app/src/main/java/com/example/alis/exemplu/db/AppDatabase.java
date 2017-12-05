package com.example.alis.exemplu.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.alis.exemplu.dao.RecipeDao;
import com.example.alis.exemplu.dao.UserDao;
import com.example.alis.exemplu.model.Recipe;
import com.example.alis.exemplu.model.User;

/**
 * Created by Alis on 12/5/2017.
 */
@Database(entities = {User.class, Recipe.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract RecipeDao recipeDao();
}
