package com.example.alis.exemplu.ui;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alis.exemplu.R;
import com.example.alis.exemplu.model.User;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alis on 12/5/2017.
 */

public class UserListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<User> names;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listusers);


        recyclerView=findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new UserAdapter(names);
        recyclerView.setAdapter(adapter);
    }

}
