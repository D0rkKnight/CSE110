package com.example.lab6;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.lang.reflect.Type;

@Entity(tableName = "todo_list_item")
public class TodoListItem {
    // 1. Public fields
    @PrimaryKey(autoGenerate = true)
    public long id = 0;

    @NonNull
    public String text;
    public boolean completed;
    public int order;

    // 2. Constructor matching fields above
    public TodoListItem(String text, boolean completed, int order) {
        this.text = text;
        this.completed = completed;
        this.order = order;
    }

    // 3. Factory method for loading our JSON
    public static List<TodoListItem> loadJSON(Context context, String path) {
        try {
            InputStream input = context.getAssets().open(path);
            Reader reader = new InputStreamReader(input);
            Gson gson = new Gson();
            Type type = new TypeToken<List<TodoListItem>>(){}.getType();
            return gson.fromJson(reader, type);

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public String toString() {
        return "TodoListItem{" +
                "text='" + text + '\'' +
                ", completed=" + completed +
                ", order=" + order +
                '}';
    }
}
