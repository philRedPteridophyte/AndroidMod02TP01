package com.unicorn.androidmod02tp01.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.unicorn.androidmod02tp01.databinding.ActivityMainBinding;
import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.model.Article;
import com.unicorn.androidmod02tp01.viewmodel.ArticleVM;

public class MainActivity extends AppCompatActivity {


    private ArticleVM viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.viewmodel = new ArticleVM();
        Article article;
        this.viewmodel.setArticle( new Article(
                1
                ,"Pain au Chocolat"
                ,1.0d
                ,"Une viennoiserie au beurre et au chocolat"
                ,4f
                ,"https://"
                ,false
        ));
        binding.setViewmodel(this.viewmodel);


    }

}