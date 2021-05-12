package com.unicorn.androidmod02tp01.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.model.Article;


public class DetailArticleFragment extends Fragment {

    public static final String EXTRA_ARTICLE = "article";

    private Article article;

    private TextView labelTV;
    private TextView priceTV;
    private RatingBar ratingRB;
    private TextView descriptionTV;
    private ImageButton urlBtn;
    private ToggleButton baughtTBtn;

    public DetailArticleFragment() {
        super(R.layout.fragment_detail_article);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        labelTV = (TextView)getView().findViewById(R.id.article_item_title);
        priceTV = (TextView)getView().findViewById(R.id.article_item_price);
        ratingRB = (RatingBar) getView().findViewById(R.id.article_item_rating);
        descriptionTV = (TextView)getView().findViewById(R.id.article_item_info);
        urlBtn = (ImageButton) getView().findViewById(R.id.article_button_url);
        baughtTBtn = (ToggleButton)getView().findViewById(R.id.article_togglebutton_bought);


        if(getArguments() != null && getView() != null){
            //get serialized article
            article = (Article)getArguments().getSerializable(EXTRA_ARTICLE);
            //map to view
            labelTV.setText(article.getLabel());
            priceTV.setText(article.getPrice().toString());
            ratingRB.setRating(article.getRating());
            descriptionTV.setText(article.getDescription());
            baughtTBtn.setChecked(article.isBought());
        }
    }
}