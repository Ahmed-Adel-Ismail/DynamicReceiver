package com.broadcasts.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.broadcasts.annotations.BroadcastReceiverActions;
import com.broadcasts.receivers.DynamicReceiver;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION = "com.broadcasts.app.ACTION";
    private static final String PERMISSION = "com.broadcasts.app.PERMISSION";

    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = DynamicReceiver.with(new MyReceiver())
                .register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sendBroadcast(new Intent(ACTION));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }



    @BroadcastReceiverActions(ACTION)
    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, "broadcast received", Toast.LENGTH_SHORT).show();
        }
    }


}
