package com.example.alis.exemplu.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.alis.exemplu.model.User;

import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

@Dao
public interface UserDao {
    @Query("Select * from user")
    List<User> getAll();

    @Insert
    void add(User... users);

    @Query("Select * from user where user.email like :email")
    User findUser(String email);
}
