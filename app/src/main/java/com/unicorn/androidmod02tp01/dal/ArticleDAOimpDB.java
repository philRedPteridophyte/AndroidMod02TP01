package com.unicorn.androidmod02tp01.dal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unicorn.androidmod02tp01.dal.helper.BaseContrat;
import com.unicorn.androidmod02tp01.dal.helper.DatabaseHelper;
import com.unicorn.androidmod02tp01.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleDAOimpDB {
    public static List<Article> getListeArticles(Context context)
    {
        // récupération de la base de données :
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // tri :
        String tri = BaseContrat.ArticleContrat.COLONNE_LABEL + " ASC " ;

        // requête :
        Cursor cursor = db.query(
                false, // true si SELECT DISTINCT
                BaseContrat.ArticleContrat.TABLE_ARTICLE, // table sur laquelle faire la requète
                null, // colonnes à retourner
                null, // colonnes pour la clause WHERE
                null, // valeurs pour la clause WHERE
                null, // GROUP BY (inactif)
                null, // HAVING (inactif)
                tri, // ordre de tri
                null); // LIMIT (inactif)

        List<Article> listeArticles = new ArrayList<>();
        if (cursor != null)
        {
            try
            {
                while (cursor.moveToNext())
                {
                    // conversion des données remontées en un objet métier :
                    listeArticles.add(new Article(
                            cursor.getLong(cursor.getColumnIndex(BaseContrat.ArticleContrat._ID)),
                            cursor.getString(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_LABEL)),
                            cursor.getDouble(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_PRICE)),
                            cursor.getString(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_DESCRIPTION)),
                            cursor.getFloat(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_RATING)),
                            cursor.getString(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_URL)),
                            cursor.getInt(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_BAUGHT)) > 0
                    ));
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
            finally
            {
                cursor.close();
            }
        }
        return listeArticles;
    }
}
