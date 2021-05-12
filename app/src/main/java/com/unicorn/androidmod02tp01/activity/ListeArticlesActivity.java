package com.unicorn.androidmod02tp01.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.adapter.ArticlesAdapter;
import com.unicorn.androidmod02tp01.model.Article;
import com.unicorn.androidmod02tp01.viewmodel.ListArticleActivityVM;

import java.util.ArrayList;
import java.util.List;

public class ListeArticlesActivity extends AppCompatActivity {

    private static final String TAG = "ListeArticlesActivity: ";
    private ListArticleActivityVM viewmodel;
    RecyclerView rv;
    ArticlesAdapter articlesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ;
        setContentView(R.layout.activity_liste_articles);

        rv = this.findViewById(R.id.article_liste_recycle_view);

        rv.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        List<Article> articles = new ArrayList<>();// = ArticleDAOimpDB.getListeArticles(this);
        articles.add(new Article(
                1
                ,"Pain au Chocolat"
                ,1.0d
                ,"Une viennoiserie au beurre et au chocolat"
                ,4f
                ,"https://"
                ,false
        ));
        articles.add(new Article(
                1
                ,"Pain au Raisin"
                ,1.7d
                ,"Une viennoiserie au beurre et au raisins"
                ,3.9f
                ,"https://"
                ,false
        ));
        articles.add(new Article(
                1
                ,"Croissant"
                ,0.6d
                ,"Une viennoiserie au beurre"
                ,4.5f
                ,"https://"
                ,false
        ));

        articlesAdapter = new ArticlesAdapter(articles, this);
        rv.setAdapter(articlesAdapter);
        setSupportActionBar(findViewById(R.id.articles_toolbar));

/*
        ActivityListeArticlesBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_liste_articles);
        this.viewmodel = new ListArticleActivityVM();
        Article article;
        this.viewmodel.getArticles().add( new Article(
                1
                ,"Pain au Chocolat"
                ,1.0d
                ,"Une viennoiserie au beurre et au chocolat"
                ,4f
                ,"https://"
                ,false
        ));
        this.viewmodel.getArticles().add( new Article(
                1
                ,"Pain au Raisin"
                ,1.7d
                ,"Une viennoiserie au beurre et au raisins"
                ,3.9f
                ,"https://"
                ,false
        ));
        this.viewmodel.getArticles().add( new Article(
                1
                ,"Croissant"
                ,0.6d
                ,"Une viennoiserie au beurre"
                ,4.5f
                ,"https://"
                ,false
        ));
        this.viewmodel.setActivity(this);

        this.viewmodel.init();

        binding.setViewmodel(this.viewmodel);



 */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.v(TAG, "onCreateOptionsMenu: ");
        getMenuInflater().inflate(R.menu.menu_liste_article,menu);
        return true;
    }
}