package com.example.work11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The type Main activity.
 *
 * @author Idan Bunkin <idan.bunkin@gmail.com>
 * @version 1
 * @since 13 /02/2023 (the date of the package the class was added) counter and an edit text, the info is saved in a file and when the program opening its putting the last info
 */
public class MainActivity extends AppCompatActivity {


    Button countClick, resetClicks, saveAll;

    EditText enterText;


    TextView showCount;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countClick = (Button) findViewById(R.id.button);
        resetClicks = (Button) findViewById(R.id.button2);
        saveAll = (Button) findViewById(R.id.button3);
        enterText = (EditText) findViewById(R.id.editTextTextPersonName);
        showCount = (TextView) findViewById(R.id.textView);

        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        String text = settings.getString("Text", "SOMETHING NOT WORKING!!!");
        count = settings.getInt("Count", -1);
        enterText.setText(text);
        showCount.setText(Integer.toString(count));

    }

    /**
     * Counter.
     *
     * @param view the view
     */
    public void counter(View view) {
        count++;
        showCount.setText(Integer.toString(count));
    }

    /**
     * Reset.
     *
     * @param view the view
     */
    public void reset(View view) {
        count = 0;
    }

    /**
     * Exit and save.
     *
     * @param view the view
     */
    public void ExitAndSave(View view) {
        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Text", String.valueOf(enterText.getText()));
        editor.putInt("Count", count);
        editor.commit();
        super.finish();
        System.exit(0);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String st = item.getTitle().toString();
        if(st.equals("Credits"))
        {
            Intent si = new Intent(this, MainActivity2.class);
            startActivity(si);
        }
        return true;
    }

}