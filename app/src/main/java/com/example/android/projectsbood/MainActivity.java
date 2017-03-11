package com.example.android.projectsbood;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.projectsbood.Data.ProjectContract;
import com.example.android.projectsbood.Data.ProjectContract.ProjectEntry;
import com.example.android.projectsbood.Data.ProjectDBHelper;

public class MainActivity extends AppCompatActivity {

    ProjectDBHelper mDbhelper;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_create_database:
                addARow();
                displayDatabaseInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //Adding a menu to left corner

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true; // For this moment to work always
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbhelper = new ProjectDBHelper(this);
        displayDatabaseInfo();
    }


    private void displayDatabaseInfo() {
        ProjectDBHelper mDbHelper = new ProjectDBHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM Project"
        Cursor cursor = db.rawQuery("SELECT * FROM " + ProjectEntry.TABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            TextView displayView = (TextView) findViewById(R.id.text_view_num);
            displayView.setText("Number of rows in pets database table: " + cursor.getCount());
        } finally {
            cursor.close();
        }
    }

    private void addARow(){

        SQLiteDatabase db;
        db = mDbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(ProjectContract.ProjectEntry._ID, 1);
        values.put(ProjectContract.ProjectEntry.NAME, "Zoloti Vorota");
        values.put(ProjectContract.ProjectEntry.TIME_READY, "1997");
        values.put(ProjectContract.ProjectEntry.GEO, "Kyiv");
        values.put(ProjectContract.ProjectEntry._ID_BOODCOMPANY , 1);
        values.put(ProjectContract.ProjectEntry._ID_DISTRICT, 1);
        long newRowId = db.insert(ProjectEntry.TABLE_NAME, null, values);

    }
}
