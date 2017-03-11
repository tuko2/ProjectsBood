package com.example.android.projectsbood.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.projectsbood.Data.ProjectContract;
import com.example.android.projectsbood.Data.ProjectContract.ProjectEntry;
import static android.os.FileObserver.CREATE;

/**
 * Provides commands for working with DB.
 */

public class ProjectDBHelper extends SQLiteOpenHelper{


    static final  String DATABASE_NAME = "Project.db";

    private static final int DATABASE_VERSION = 1;

    final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + ProjectContract.ProjectEntry.TABLE_NAME;

    public ProjectDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating a String constant for SQL Query
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE_PROJECT = "CREATE TABLE " + ProjectContract.ProjectEntry.TABLE_NAME + "("
                + ProjectContract.ProjectEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ProjectContract.ProjectEntry.NAME + " TEXT, "
                + ProjectContract.ProjectEntry.TIME_READY + " TEXT, "
                + ProjectContract.ProjectEntry.GEO + " TEXT, "
                + ProjectContract.ProjectEntry._ID_BOODCOMPANY + " INTEGER, "
                + ProjectContract.ProjectEntry._ID_DISTRICT + " INTEGER" + ");";



        //Execute SQL Command
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_PROJECT);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int version1, int version2) {
        //Still version 1

    }
}
