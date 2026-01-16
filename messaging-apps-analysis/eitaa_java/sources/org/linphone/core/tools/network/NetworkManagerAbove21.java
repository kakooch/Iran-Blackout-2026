package org.linphone.core.tools.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.RouteInfo;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linphone.core.tools.AndroidPlatformHelper;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class NetworkManagerAbove21 implements NetworkManagerInterface {
    private ConnectivityManager mConnectivityManager;
    private AndroidPlatformHelper mHelper;
    private boolean mWifiOnly;
    private Network mNetworkAvailable = null;
    private Network mLastNetworkAvailable = null;
    private ConnectivityManager.NetworkCallback mNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(final Network network) {
            NetworkManagerAbove21.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1.1
                @Override // java.lang.Runnable
                public void run() {
                    NetworkInfo networkInfo = NetworkManagerAbove21.this.mConnectivityManager.getNetworkInfo(network);
                    if (networkInfo == null) {
                        Log.e("[Platform Helper] [Network Manager 21] A network should be available but getNetworkInfo failed.");
                        return;
                    }
                    Object[] objArr = new Object[1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Platform Helper] [Network Manager 21] A network is available: ");
                    sb.append(networkInfo.getTypeName());
                    sb.append(", wifi only is ");
                    sb.append(NetworkManagerAbove21.this.mWifiOnly ? "enabled" : "disabled");
                    objArr[0] = sb.toString();
                    Log.i(objArr);
                    if (!NetworkManagerAbove21.this.mWifiOnly || networkInfo.getType() == 1 || networkInfo.getType() == 9) {
                        NetworkManagerAbove21.this.mNetworkAvailable = network;
                        NetworkManagerAbove21.this.mHelper.updateNetworkReachability();
                    } else {
                        Log.i("[Platform Helper] [Network Manager 21] Network isn't wifi and wifi only mode is enabled");
                        if (NetworkManagerAbove21.this.mWifiOnly) {
                            NetworkManagerAbove21.this.mLastNetworkAvailable = network;
                        }
                    }
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            NetworkManagerAbove21.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Platform Helper] [Network Manager 21] A network has been lost");
                    if (NetworkManagerAbove21.this.mNetworkAvailable != null && NetworkManagerAbove21.this.mNetworkAvailable.equals(network)) {
                        NetworkManagerAbove21.this.mNetworkAvailable = null;
                    }
                    if (NetworkManagerAbove21.this.mLastNetworkAvailable != null && NetworkManagerAbove21.this.mLastNetworkAvailable.equals(network)) {
                        NetworkManagerAbove21.this.mLastNetworkAvailable = null;
                    }
                    NetworkManagerAbove21.this.mHelper.updateNetworkReachability();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, final NetworkCapabilities networkCapabilities) {
            NetworkManagerAbove21.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1.3
                @Override // java.lang.Runnable
                public void run() {
                    NetworkCapabilities networkCapabilities2 = networkCapabilities;
                    if (networkCapabilities2 == null) {
                        Log.e("[Platform Helper] [Network Manager 21] onCapabilitiesChanged called with null networkCapabilities, skipping...");
                        return;
                    }
                    if (networkCapabilities2.hasTransport(1)) {
                        Log.d("[Platform Helper] [Network Manager 21] onCapabilitiesChanged " + networkCapabilities.toString());
                        return;
                    }
                    Log.i("[Platform Helper] [Network Manager 21] onCapabilitiesChanged " + networkCapabilities.toString());
                    NetworkManagerAbove21.this.mHelper.updateNetworkReachability();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, final LinkProperties linkProperties) {
            NetworkManagerAbove21.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (linkProperties == null) {
                        Log.e("[Platform Helper] [Network Manager 21] onLinkPropertiesChanged called with null linkProperties, skipping...");
                        return;
                    }
                    Log.i("[Platform Helper] [Network Manager 21] onLinkPropertiesChanged " + linkProperties.toString());
                    NetworkManagerAbove21.this.updateDnsServers();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            NetworkManagerAbove21.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1.5
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Platform Helper] [Network Manager 21] onLosing");
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            NetworkManagerAbove21.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove21.1.6
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Platform Helper] [Network Manager 21] onUnavailable");
                }
            });
        }
    };

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

    public NetworkManagerAbove21(AndroidPlatformHelper androidPlatformHelper, ConnectivityManager connectivityManager, boolean z) {
        this.mHelper = androidPlatformHelper;
        this.mConnectivityManager = connectivityManager;
        this.mWifiOnly = z;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void setWifiOnly(boolean z) {
        Network network;
        this.mWifiOnly = z;
        if (z && (network = this.mNetworkAvailable) != null) {
            NetworkInfo networkInfo = this.mConnectivityManager.getNetworkInfo(network);
            if (networkInfo == null || networkInfo.getType() == 1 || networkInfo.getType() == 9) {
                return;
            }
            Log.i("[Platform Helper] [Network Manager 21] Wifi only mode enabled and current network isn't wifi or ethernet");
            this.mLastNetworkAvailable = this.mNetworkAvailable;
            this.mNetworkAvailable = null;
            return;
        }
        if (z || this.mNetworkAvailable != null) {
            return;
        }
        Log.i("[Platform Helper] [Network Manager 21] Wifi only mode disabled, restoring previous network");
        this.mNetworkAvailable = this.mLastNetworkAvailable;
        this.mLastNetworkAvailable = null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void registerNetworkCallbacks(Context context) {
        this.mConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.mNetworkCallback);
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void unregisterNetworkCallbacks(Context context) {
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public NetworkInfo getActiveNetworkInfo() {
        Network network = this.mNetworkAvailable;
        if (network != null) {
            return this.mConnectivityManager.getNetworkInfo(network);
        }
        return this.mConnectivityManager.getActiveNetworkInfo();
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public Network getActiveNetwork() {
        return this.mNetworkAvailable;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public boolean isCurrentlyConnected(Context context) {
        return this.mNetworkAvailable != null;
    }

    private boolean hasLinkPropertiesDefaultRoute(LinkProperties linkProperties) {
        if (linkProperties == null) {
            return false;
        }
        Iterator<RouteInfo> it = linkProperties.getRoutes().iterator();
        while (it.hasNext()) {
            if (it.next().isDefaultRoute()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void updateDnsServers() {
        LinkProperties linkProperties;
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
            int length = allNetworks.length;
            char c = 0;
            int i = 0;
            while (i < length) {
                Network network = allNetworks[i];
                NetworkInfo networkInfo = this.mConnectivityManager.getNetworkInfo(network);
                if (networkInfo != null && (linkProperties = this.mConnectivityManager.getLinkProperties(network)) != null) {
                    List<InetAddress> dnsServers = linkProperties.getDnsServers();
                    boolean zHasLinkPropertiesDefaultRoute = hasLinkPropertiesDefaultRoute(linkProperties);
                    Iterator<InetAddress> it = dnsServers.iterator();
                    while (it.hasNext()) {
                        String hostAddress = it.next().getHostAddress();
                        if (!arrayList.contains(hostAddress) && !arrayList2.contains(hostAddress)) {
                            String typeName = networkInfo.getTypeName();
                            if (networkInfo.equals(activeNetworkInfo)) {
                                Object[] objArr = new Object[1];
                                objArr[c] = "[Platform Helper] [Network Manager 21] Found DNS host " + hostAddress + " from active network " + typeName;
                                Log.i(objArr);
                                arrayList2.add(hostAddress);
                            } else if (zHasLinkPropertiesDefaultRoute) {
                                Log.i("[Platform Helper] [Network Manager 21] Found DNS host " + hostAddress + " from network " + typeName + " with default route");
                                arrayList.add(0, hostAddress);
                            } else {
                                Log.i("[Platform Helper] [Network Manager 21] Found DNS host " + hostAddress + " from network " + typeName);
                                arrayList.add(hostAddress);
                            }
                        }
                        c = 0;
                    }
                }
                i++;
                c = 0;
            }
        }
        arrayList2.addAll(arrayList);
        this.mHelper.updateDnsServers(arrayList2);
    }
}
