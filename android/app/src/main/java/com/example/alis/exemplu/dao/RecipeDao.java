package com.example.alis.exemplu.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alis.exemplu.model.Recipe;

import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */
@Dao
public interface RecipeDao {
    @Query("Select * from recipe user_id where user_id != :userId")
    List<Recipe> getAll(int userId);

    @Query("Select * from recipe where user_id like :userId")
    List<Recipe> getAllById(int userId);

    @Insert
    void add(Recipe... recipes);

    @Delete
    void delete(Recipe... recipe);

    @Update
    void update(Recipe... recipe);
}
