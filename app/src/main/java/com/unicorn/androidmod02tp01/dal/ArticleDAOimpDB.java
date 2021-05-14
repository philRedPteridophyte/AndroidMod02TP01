package com.unicorn.androidmod02tp01.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unicorn.androidmod02tp01.dal.helper.BaseContrat;
import com.unicorn.androidmod02tp01.dal.helper.DatabaseHelper;
import com.unicorn.androidmod02tp01.model.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleDAOimpDB {

    public static Article insert(Context context, Article article) throws DALException {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(BaseContrat.ArticleContrat.COLONNE_LABEL, article.getLabel());
        values.put(BaseContrat.ArticleContrat.COLONNE_PRICE, article.getPrice());
        values.put(BaseContrat.ArticleContrat.COLONNE_DESCRIPTION, article.getDescription());
        values.put(BaseContrat.ArticleContrat.COLONNE_RATING, article.getRating());
        values.put(BaseContrat.ArticleContrat.COLONNE_URL, article.getUrl());
        values.put(BaseContrat.ArticleContrat.COLONNE_BAUGHT, article.isBought());

        article.setId(db.insert(
                BaseContrat.ArticleContrat.TABLE_ARTICLE
                , null
                , values));

        return article;
    }

    public static List<Article> getArticles(Context context, EArticleSort sort) throws DALException {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String tri = null;
        switch (sort){
            case ASC:
                tri = BaseContrat.ArticleContrat.COLONNE_LABEL + " ASC " ;
                break;
            case DESC:
                tri = BaseContrat.ArticleContrat.COLONNE_LABEL + " DESC " ;
                break;
            default:
            case NONE:
                tri = null;
                break;
        }

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
                throw new DALException();
            }
            finally
            {
                cursor.close();
            }
        }
        return listeArticles;
    }

    public static Article getArticle(Context context, Article _article) throws DALException {
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        Cursor cursor = db.query(
                false // true si SELECT DISTINCT
                ,BaseContrat.ArticleContrat.TABLE_ARTICLE // table sur laquelle faire la requète
                ,null // colonnes à retourner
                , BaseContrat.ArticleContrat._ID + "=?" // colonnes pour la clause WHERE
                ,new String[]{String.valueOf(_article.getId())}// valeurs pour la clause WHERE
                ,null // GROUP BY (inactif)
                ,null // HAVING (inactif)
                ,null // ordre de tri
                ,null); // LIMIT (inactif)

        if (cursor != null)
        {
            try
            {
                cursor.moveToNext();

                _article.setId(cursor.getLong(cursor.getColumnIndex(BaseContrat.ArticleContrat._ID)));
                _article.setLabel(cursor.getString(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_LABEL)));
                _article.setPrice(cursor.getDouble(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_PRICE)));
                _article.setDescription(cursor.getString(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_DESCRIPTION)));
                _article.setRating(cursor.getFloat(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_RATING)));
                _article.setUrl(cursor.getString(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_URL)));
                _article.setBought(cursor.getInt(cursor.getColumnIndex(BaseContrat.ArticleContrat.COLONNE_BAUGHT)) > 0);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                throw new DALException();
            }
            finally
            {
                cursor.close();
            }
        }
        return _article;
    }
}
