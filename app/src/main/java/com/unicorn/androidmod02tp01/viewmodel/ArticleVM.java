package com.unicorn.androidmod02tp01.viewmodel;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.unicorn.androidmod02tp01.activity.InfoUrlActivity;
import com.unicorn.androidmod02tp01.model.Article;

import lombok.Data;

@Data
public class ArticleVM {

    private Article article;

    public void onClickUrl(View view) {
        Intent intent = new Intent(view.getContext(), InfoUrlActivity.class);
        intent.putExtra("data", article);
        view.getContext().startActivity(intent);
    }

    public void onClickToggle(View view) {
        article.setBought(!article.isBought());
        Toast.makeText(view.getContext(), String.format("Article %s is %s", article.getLabel(), article.isBought() ? "bought" : "not bought"), Toast.LENGTH_LONG).show();
    }

}
