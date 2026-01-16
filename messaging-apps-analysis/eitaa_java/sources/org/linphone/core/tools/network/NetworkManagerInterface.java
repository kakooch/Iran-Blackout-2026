package org.linphone.core.tools.network;

import android.content.Context;
import android.net.Network;
import android.net.NetworkInfo;

/* loaded from: classes3.dex */
public interface NetworkManagerInterface {
    Network getActiveNetwork();

    NetworkInfo getActiveNetworkInfo();

    String getProxyHost(Context context);

    int getProxyPort(Context context);

    boolean hasHttpProxy(Context context);

    boolean isCurrentlyConnected(Context context);

    void registerNetworkCallbacks(Context context);

    void setWifiOnly(boolean z);

    void unregisterNetworkCallbacks(Context context);

    void updateDnsServers();
}
