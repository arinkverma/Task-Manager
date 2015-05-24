package com.example.simrandeep.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by simrandeep on 9/5/15.
 */
public class CreateTask extends Activity {
    private ArrayList<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_create);
        Button btn = (Button) findViewById(R.id.createTask);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAndSaveTask();
            }
        });
    }

    private void createAndSaveTask() {
        String title = ((EditText)findViewById(R.id.editText)).getText().toString();
        String category = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String description = ((EditText)findViewById(R.id.editText3)).getText().toString();
        String separator = "||";
        String item = title + separator + category + separator + description;
        items.add(item);
        writeItems(items);
        gotoMainActivity();
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(CreateTask.this, MainActivity.class);
        startActivity(intent);
    }

    private void writeItems(ArrayList<String> items) {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo3.txt");
        try {
            FileUtils.writeLines(todoFile, items, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
