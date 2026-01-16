package org.linphone.core.tools.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import java.util.ArrayList;
import org.linphone.core.tools.AndroidPlatformHelper;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class NetworkManager extends BroadcastReceiver implements NetworkManagerInterface {
    private ConnectivityManager mConnectivityManager;
    private AndroidPlatformHelper mHelper;
    private IntentFilter mNetworkIntentFilter;
    private boolean mWifiOnly;

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public Network getActiveNetwork() {
        return null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public String getProxyHost(Context context) {
        return null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public int getProxyPort(Context context) {
        return 0;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public boolean hasHttpProxy(Context context) {
        return false;
    }

    public NetworkManager(AndroidPlatformHelper androidPlatformHelper, ConnectivityManager connectivityManager, boolean z) {
        this.mConnectivityManager = connectivityManager;
        this.mWifiOnly = z;
        this.mHelper = androidPlatformHelper;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("[Platform Helper] [Network Manager] Broadcast receiver called");
        AndroidPlatformHelper androidPlatformHelper = this.mHelper;
        if (androidPlatformHelper != null) {
            androidPlatformHelper.updateNetworkReachability();
        }
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void setWifiOnly(boolean z) {
        this.mWifiOnly = z;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void registerNetworkCallbacks(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.mNetworkIntentFilter = intentFilter;
        context.registerReceiver(this, intentFilter);
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void unregisterNetworkCallbacks(Context context) {
        context.unregisterReceiver(this);
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public NetworkInfo getActiveNetworkInfo() {
        return this.mConnectivityManager.getActiveNetworkInfo();
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public boolean isCurrentlyConnected(Context context) {
        for (NetworkInfo networkInfo : this.mConnectivityManager.getAllNetworkInfo()) {
            Log.i("[Platform Helper] [Network Manager] Found network type: " + networkInfo.getTypeName() + ", isConnectedOrConnecting() = " + networkInfo.isConnectedOrConnecting());
            if (networkInfo.isConnectedOrConnecting()) {
                Log.i("[Platform Helper] [Network Manager] Network state is " + networkInfo.getState() + " / " + networkInfo.getDetailedState());
                if ((networkInfo.getType() == 1 && networkInfo.getType() == 9) || !this.mWifiOnly) {
                    return true;
                }
                Log.i("[Platform Helper] [Network Manager] Wifi only mode enabled, skipping");
            }
        }
        return false;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void updateDnsServers() {
        this.mHelper.updateDnsServers(new ArrayList<>());
    }
}
