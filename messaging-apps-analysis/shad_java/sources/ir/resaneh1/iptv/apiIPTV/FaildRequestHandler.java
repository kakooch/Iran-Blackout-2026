package ir.resaneh1.iptv.apiIPTV;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FaildRequestHandler {
    static FaildRequestHandler instance;
    ArrayList<CallbackWithRetry> callbackWithRetries = new ArrayList<>();

    void showDialogIsNecessary(Context context, String str) {
    }

    public static FaildRequestHandler getInstance() {
        if (instance == null) {
            instance = new FaildRequestHandler();
        }
        return instance;
    }

    public static boolean isConnectedToInternet(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ShowNetwrokConnectionProblemDialog(Context context, CallbackWithRetry callbackWithRetry) {
        this.callbackWithRetries.add(callbackWithRetry);
        MyLog.e("add to", "call back" + this.callbackWithRetries.size());
        if (context != null) {
            showDialogIsNecessary(context, context.getString(R.string.conneciton_internet_failed_message));
        }
    }

    public void ShowServerProblemDialog(Context context, CallbackWithRetry callbackWithRetry) {
        this.callbackWithRetries.add(callbackWithRetry);
        MyLog.e("add to", "call back" + this.callbackWithRetries.size());
        if (context != null) {
            showDialogIsNecessary(context, context.getString(R.string.conneciton_server_failed_message));
        }
    }
}
