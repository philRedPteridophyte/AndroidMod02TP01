package com.unicorn.androidmod02tp01.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.fragment.DetailArticleFragment;
import com.unicorn.androidmod02tp01.generated.callback.OnClickListener;
import com.unicorn.androidmod02tp01.model.Article;

public class ArticleDetailActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLE = "article";
    private static final String TAG = "ArticleDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Article article = (Article)getIntent().getSerializableExtra(EXTRA_ARTICLE);

        DetailArticleFragment fragment = new DetailArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailArticleFragment.EXTRA_ARTICLE, article);
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.artcile_detail_container,fragment, "tagdetail");
        transaction.commit();

        setSupportActionBar(findViewById(R.id.article_detail_toolbar));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info_article,menu);
        return true;
    }

}