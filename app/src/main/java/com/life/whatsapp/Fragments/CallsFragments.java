package com.life.whatsapp.Fragments;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.life.whatsapp.CallActivity;
import com.life.whatsapp.R;
import com.life.whatsapp.VideoCallActivity;
import com.life.whatsapp.databinding.FragmentCallsFragmentsBinding;
import com.life.whatsapp.databinding.FragmentStatusBinding;
import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;


public class CallsFragments extends Fragment {

    FragmentCallsFragmentsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentCallsFragmentsBinding.inflate(inflater, container, false);

        binding.idsuhani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService("suhani");
                Intent intent = new Intent(getActivity(), CallActivity.class);
                intent.putExtra("userID","suhani");
                startActivity(intent);
            }
        });

        binding.idamit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService("amit");
                Intent intent = new Intent(getActivity(), CallActivity.class);
                intent.putExtra("userID","amit");
                startActivity(intent);
            }
        });



        return binding.getRoot();
    }

    void startService(String userId){
        Application application = getActivity().getApplication() ; // Android's application context
        long appID = 1478389405;   // yourAppID
        String appSign = "730c8bb96718ee09230e3748dadbcb24fe5b25ed70abc670ad7a266a250dae6b"  ;// yourAppSign
        //  String userID =; // yourUserID, userID should only contain numbers, English characters, and '_'.
        String userName =userId;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInvitationService.init(getActivity().getApplication(), appID, appSign, userId, userName,callInvitationConfig);
    }

}