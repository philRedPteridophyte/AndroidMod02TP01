package com.unicorn.androidmod02tp01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.unicorn.androidmod02tp01.R;

public class ConfigurationActivity extends AppCompatActivity {

    public static final String PREFERENCES_CONFIG = "articles_config";
    public static final String PREFERENCES_KEY_SORT_PRICE = "articles_config_sort_price";
    public static final String PREFERENCES_KEY_DEFAULT_PRICE = "articles_config_default_price";
    private static final String TAG = "ConfigurationActivity";

    private Switch sortPriceSw;
    private EditText defaultPriceE;


    private boolean sortPrice;
    private int defaultPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        sortPriceSw = findViewById(R.id.config_sort_switch);
        defaultPriceE = findViewById(R.id.config_default_price_edit);
        sortPrice = false;
        defaultPrice = 0;

        sortPriceSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                try{
                    SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_CONFIG, MODE_PRIVATE).edit();
                    editor.putBoolean(PREFERENCES_KEY_SORT_PRICE,sortPriceSw.isChecked());
                    editor.apply();
                }catch (Exception e){
                    Log.e(TAG, "sortPriceSw.setOnCheckedChangeListener: " + e.getMessage());
                }
            }
        });

        try{
            SharedPreferences pref = getSharedPreferences(PREFERENCES_CONFIG,MODE_PRIVATE);
            sortPrice = pref.getBoolean(PREFERENCES_KEY_SORT_PRICE,false);
            defaultPrice = pref.getInt(PREFERENCES_KEY_DEFAULT_PRICE, 0);


        }catch (Exception e){
            Log.e(TAG, "onCreate: " + e.getMessage());
        }
        sortPriceSw.setChecked(sortPrice);
        defaultPriceE.setText(String.valueOf(defaultPrice));

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        try{
            SharedPreferences.Editor editor = getSharedPreferences(PREFERENCES_CONFIG, MODE_PRIVATE).edit();
            editor.putInt(PREFERENCES_KEY_DEFAULT_PRICE, Integer.parseInt(defaultPriceE.getText().toString()));
            editor.putBoolean(PREFERENCES_KEY_SORT_PRICE,sortPriceSw.isChecked());
            editor.apply();
        }catch (Exception e){
            Log.e(TAG, "onDestroy: " + e.getMessage());
        }
    }

}