package com.life.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class CallActivity extends AppCompatActivity {

    EditText  editcall;
    ZegoSendCallInvitationButton voiceBtn,Videobtn;
    Button makecall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        editcall = findViewById(R.id.editcall);
        voiceBtn = findViewById(R.id.voiceBtn);
        Videobtn = findViewById(R.id.Videobtn);
        makecall = findViewById(R.id.makecall);

        String userid = getIntent().getStringExtra("userID");
       // editcall.setText(userid);

        String targetUserId =  editcall.getText().toString().trim();
//        makecall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setVoicecall(targetUserId);
//                setVideocall(targetUserId);
//            }
//        });
        editcall.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String targetUserId =  editcall.getText().toString().trim();
                setVoicecall(targetUserId);
                setVideocall(targetUserId);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    void setVoicecall(String targetUserId){

        Videobtn.setIsVideoCall(false);
        Videobtn.setResourceID("zego_uikit_call");
        Videobtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserId)));

    }

    void setVideocall(String targetUserId){
        Videobtn.setIsVideoCall(true);
        Videobtn.setResourceID("zego_uikit_call");
        Videobtn.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserId)));

    }
}