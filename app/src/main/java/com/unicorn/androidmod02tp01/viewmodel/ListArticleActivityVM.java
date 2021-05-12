package com.unicorn.androidmod02tp01.viewmodel;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.activity.ListeArticlesActivity;
import com.unicorn.androidmod02tp01.activity.MainActivity;
import com.unicorn.androidmod02tp01.adapter.ArticlesAdapter;
import com.unicorn.androidmod02tp01.dal.ArticleDAOimpDB;
import com.unicorn.androidmod02tp01.model.Article;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ListArticleActivityVM {

    List<Article> articles;
    ListeArticlesActivity activity;
    RecyclerView rv;
    ArticlesAdapter articlesAdapter;

    public ListArticleActivityVM() {

    }

    public void init(){
        rv = activity.findViewById(R.id.article_liste_recycle_view);

        rv.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        rv.setLayoutManager(layoutManager);

        //articles = ArticleDAOimpDB.getListeArticles(activity);

        articlesAdapter = new ArticlesAdapter(articles, activity);
        rv.setAdapter(articlesAdapter);

    }


    public List<Article> getArticles() {
        if(articles == null){
            articles = new ArrayList<Article>();
        }
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
