package com.example.recyclerviewinfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView Iv_Detail;
    TextView TV_Heroes_Name,TV_Heroes_Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Iv_Detail = findViewById(R.id.iv_detail);
        TV_Heroes_Name = findViewById(R.id.heroes_name);
        TV_Heroes_Desc = findViewById(R.id.heroes_description);

        getIncomingIntent();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void getIncomingIntent(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int ivThumb = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(ivThumb).into(Iv_Detail);
            String getDesc = bundle.getString("deskripsi");
            String getTitle = bundle.getString("nama");

            TV_Heroes_Desc.setText(getDesc);
            TV_Heroes_Name.setText(getTitle);





        }


    }
}

