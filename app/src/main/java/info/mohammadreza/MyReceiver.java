package info.mohammadreza;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (checkNetWork(context)) {
            Toast.makeText(context, "You are connect.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "You are not connect.", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean checkNetWork(Context context) {
        try {
            ConnectivityManager conManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = conManager.getActiveNetworkInfo();

            return (nInfo != null && nInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }
}