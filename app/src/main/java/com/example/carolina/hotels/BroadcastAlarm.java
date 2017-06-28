package com.example.carolina.hotels;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by carolina on 27/06/17.
 */

public class BroadcastAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm set", Toast.LENGTH_LONG).show();
    }
}
