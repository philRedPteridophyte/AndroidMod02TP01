package com.unicorn.androidmod02tp01;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.unicorn.androidmod02tp01.model.Article;

public class MainActivity extends AppCompatActivity {

    protected TextView textViewLabel;
    protected TextView textViewPrice;
    protected TextView textViewDescription;
    protected RatingBar ratingBarRating;

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLabel = (TextView)findViewById(R.id.mainactivity_item_title);
        textViewPrice = (TextView)findViewById(R.id.mainactivity_item_price);
        textViewDescription = (TextView)findViewById(R.id.mainactivity_item_info);
        ratingBarRating = (RatingBar)findViewById(R.id.mainactivity_item_rating);

        article = new Article(
                1
                ,"Pain au Chocolat"
                ,1.0d
                ,"Une viennoiserie au beurre et au chocolat"
                ,4f
        );

        textViewLabel.setText(article.getLabel());
        textViewPrice.setText(article.getPrice().toString());
        textViewDescription.setText(article.getDescription());
        ratingBarRating.setRating(article.getRating());
    }


    public void onClickBtnInternet(View view){
        Toast.makeText(this, "http://androidApp.local/Article/" + article.getId(),Toast.LENGTH_SHORT).show();
    }

}