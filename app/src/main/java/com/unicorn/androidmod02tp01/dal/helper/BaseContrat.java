package com.unicorn.androidmod02tp01.dal.helper;

import android.provider.BaseColumns;

public class BaseContrat {

    private BaseContrat() {}

    // contenu de la table "courses" :
    public static class ArticleContrat implements BaseColumns
    {
        public static final String TABLE_ARTICLE = "article";
        public static final String COLONNE_LABEL = "label";
        public static final String COLONNE_PRICE = "price";
        public static final String COLONNE_DESCRIPTION = "description";
        public static final String COLONNE_RATING = "rating";
        public static final String COLONNE_URL = "url";
        public static final String COLONNE_BAUGHT = "bought";
    }
}
