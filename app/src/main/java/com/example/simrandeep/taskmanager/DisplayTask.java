package com.example.simrandeep.taskmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by simrandeep on 11/5/15.
 */
public class DisplayTask extends Activity {
    ArrayList<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_display);
        readItems();
        int position = getIntent().getExtras().getInt("position");
        String item = items.get(position);
        String separator = "(\\|\\|)";
        String[]itemArray = item.split(separator);
        TextView title = (TextView)findViewById(R.id.title);
        TextView category = (TextView)findViewById(R.id.category);
        TextView description = (TextView)findViewById(R.id.description);
        title.setText(itemArray[0]);
        category.setText(itemArray[1]);
        description.setText(itemArray[2]);
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo3.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }
}
