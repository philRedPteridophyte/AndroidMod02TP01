package com.unicorn.androidmod02tp01.dal.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context)
    {
        super(context, "articles.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + BaseContrat.ArticleContrat.TABLE_ARTICLE + " ("
                + BaseContrat.ArticleContrat._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BaseContrat.ArticleContrat.COLONNE_LABEL + " TEXT NOT NULL, "
                + BaseContrat.ArticleContrat.COLONNE_PRICE + " NUMBER NOT NULL, "
                + BaseContrat.ArticleContrat.COLONNE_DESCRIPTION + " TEXT NOT NULL, "
                + BaseContrat.ArticleContrat.COLONNE_RATING + " NUMBER NOT NULL, "
                + BaseContrat.ArticleContrat.COLONNE_URL + " TEXT NOT NULL, "
                + BaseContrat.ArticleContrat.COLONNE_BAUGHT + " NUMBER NOT NULL "
                + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}
