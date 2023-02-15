package com.example.lab6;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class TodoDatabaseTest {
    private TodoListItemDao dao;
    private TodoDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, TodoDatabase.class)
                .allowMainThreadQueries()
                .build();
        dao = db.todoListItemDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

}
