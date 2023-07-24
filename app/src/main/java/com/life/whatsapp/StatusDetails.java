package com.life.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StatusDetails extends AppCompatActivity {


    TextView statusUser;
    ImageView  statusImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_details);

         getSupportActionBar().hide();
         statusUser = findViewById(R.id.statusUser);
        statusImg = findViewById(R.id.statusImg);
          String name = getIntent().getStringExtra("name");
          String image = getIntent().getStringExtra("image");
          statusUser.setText(name);
          if (image.equals("suhani")){
              statusImg.setImageDrawable(getResources().getDrawable(R.drawable.g1));
          } else if(image.equals("surabhi")){
              statusImg.setImageDrawable(getResources().getDrawable(R.drawable.g2));
          }





    }
}