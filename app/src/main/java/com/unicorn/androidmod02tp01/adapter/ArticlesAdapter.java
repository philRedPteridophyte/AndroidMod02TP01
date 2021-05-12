package com.unicorn.androidmod02tp01.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.activity.ArticleDetailActivity;
import com.unicorn.androidmod02tp01.activity.ListeArticlesActivity;
import com.unicorn.androidmod02tp01.fragment.DetailArticleFragment;
import com.unicorn.androidmod02tp01.model.Article;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>{

    private static final String TAG = "ArticlesAdapter";
    private List<Article> articles;
    private ListeArticlesActivity activity;

    public ArticlesAdapter(List<Article> articles, ListeArticlesActivity activity)
    {
        Log.v(TAG, "ArticlesAdapter: ");
        this.articles = articles;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v(TAG, "onCreateViewHolder: ");
        View viewArticle = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_article, parent, false);
        return new ArticleViewHolder(viewArticle);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesAdapter.ArticleViewHolder holder, int position) {
        Log.v(TAG, "onBindViewHolder: ");
        holder.getTextViewArticleLabel().setText(articles.get(position).getLabel());
        holder.getRatingBarArticleRating().setRating(articles.get(position).getRating());
    }

    @Override
    public int getItemCount()
    {
        return articles.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewArticleLabel;
        private RatingBar ratingBarArticleRating;


        public TextView getTextViewArticleLabel() {
            return textViewArticleLabel;
        }

        public void setTextViewArticleLabel(TextView textViewArticleLabel) {
            this.textViewArticleLabel = textViewArticleLabel;
        }

        public RatingBar getRatingBarArticleRating() {
            return ratingBarArticleRating;
        }

        public void setRatingBarArticleRating(RatingBar ratingBarArticleRating) {
            this.ratingBarArticleRating = ratingBarArticleRating;
        }

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewArticleLabel = itemView.findViewById(R.id.article_item_libelle_article);
            ratingBarArticleRating = itemView.findViewById(R.id.article_item_rating);

            itemView.setOnClickListener( v -> {
                Article article = articles.get(getAdapterPosition());

                if(activity.findViewById(R.id.artcile_detail_container) != null){
                    DetailArticleFragment fragment = new DetailArticleFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(DetailArticleFragment.EXTRA_ARTICLE,article);
                    fragment.setArguments(bundle);

                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.artcile_detail_container,fragment,"tagdetail");
                    transaction.commit();
                }
                else{
                    Intent intent = new Intent(itemView.getContext(), ArticleDetailActivity.class);
                    intent.putExtra(ArticleDetailActivity.EXTRA_ARTICLE, article);
                    itemView.getContext().startActivity(intent);
                }
            });




        }
    }

}
