package com.life.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import com.life.whatsapp.Adapters.FragmentsAdapter;
import com.life.whatsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  ActivityMainBinding binding;
  FirebaseAuth auth;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth =FirebaseAuth.getInstance();

          binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
          binding.tablayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.settings:
                Intent i =new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(i);
//                Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.groupChat:
                Intent intentt =new Intent(MainActivity.this,GroupChatActivity.class);
                startActivity(intentt);
                break;

            case R.id.logout:
                auth.signOut();
                Intent intent =new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}