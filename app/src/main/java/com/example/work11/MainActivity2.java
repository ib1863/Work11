package com.example.work11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * The type Main activity 2.
 *
 * @author Idan Bunkin <idan.bunkin@gmail.com>
 * @version 1
 * @since 13 /02/2023 (the date of the package the class was added) Credit screen
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        menu.add(0,0,200,"Return");

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String st = item.getTitle().toString();
        if(st.equals("Return"))
        {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        return true;
    }

}