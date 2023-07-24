package com.life.whatsapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.life.whatsapp.R;
import com.life.whatsapp.StatusDetails;
import com.life.whatsapp.databinding.FragmentChatsBinding;
import com.life.whatsapp.databinding.FragmentStatusBinding;


public class StatusFragment extends Fragment {
     FragmentStatusBinding  binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentStatusBinding.inflate(inflater, container, false);

        binding.linearSuhani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StatusDetails.class);
                intent.putExtra("name","Suhani");
                intent.putExtra("image","suhani");
                startActivity(intent);
            }
        });

        binding.linearSurabhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StatusDetails.class);
                intent.putExtra("name","Surabhi");
                intent.putExtra("image","surabhi");
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}