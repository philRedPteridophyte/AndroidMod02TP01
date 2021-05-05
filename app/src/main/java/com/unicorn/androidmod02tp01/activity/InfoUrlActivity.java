package com.unicorn.androidmod02tp01.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.unicorn.androidmod02tp01.R;
import com.unicorn.androidmod02tp01.databinding.ActivityMainBinding;
import com.unicorn.androidmod02tp01.databinding.ActivityInfoUrlBinding;
import com.unicorn.androidmod02tp01.model.Article;
import com.unicorn.androidmod02tp01.viewmodel.ArticleVM;
import com.unicorn.androidmod02tp01.viewmodel.InfoUrlActivityVM;

public class InfoUrlActivity extends AppCompatActivity {

    private static final String TAG = "InfoUrlActivity";
    private InfoUrlActivityVM viewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityInfoUrlBinding  binding = DataBindingUtil.setContentView(this, R.layout.activity_info_url);

        this.viewmodel = new InfoUrlActivityVM();
        Article article = null;
        if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("data")) {
            try{
                viewmodel.setArticle((Article) this.getIntent().getSerializableExtra("data"));
            }catch (Exception e){
                Log.e(TAG, e.getMessage());
            }
        }
        binding.setViewmodel(this.viewmodel);

    }

}