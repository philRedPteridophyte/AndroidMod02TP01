package com.unicorn.androidmod02tp01.viewmodel;

import android.view.View;
import android.widget.Toast;

import com.unicorn.androidmod02tp01.model.Article;

import lombok.Data;

@Data
public class ArticleVM {

    private Article article;

    public void onClickUrl(View view) {
        Toast.makeText(view.getContext(), this.article.getUrl(), Toast.LENGTH_LONG).show();
    }

    public void onClickToggle(View view) {
        article.setBought(!article.isBought());
        Toast.makeText(view.getContext(), String.format("Article %s is %s", article.getLabel(), article.isBought() ? "bought" : "not bought"), Toast.LENGTH_LONG).show();
    }

}
