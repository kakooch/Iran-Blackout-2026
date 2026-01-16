package org.linphone.core.tools.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.ProxyInfo;
import android.net.RouteInfo;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.linphone.core.tools.AndroidPlatformHelper;
import org.linphone.core.tools.Log;

/* loaded from: classes3.dex */
public class NetworkManagerAbove24 implements NetworkManagerInterface {
    private ConnectivityManager mConnectivityManager;
    private AndroidPlatformHelper mHelper;
    private boolean mWifiOnly;
    private Network mNetworkAvailable = null;
    private Network mLastNetworkAvailable = null;
    private ConnectivityManager.NetworkCallback mNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(final Network network) {
            NetworkManagerAbove24.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1.1
                @Override // java.lang.Runnable
                public void run() {
                    NetworkInfo networkInfo = NetworkManagerAbove24.this.mConnectivityManager.getNetworkInfo(network);
                    if (networkInfo == null) {
                        Log.e("[Platform Helper] [Network Manager 24] A network should be available but getNetworkInfo failed.");
                        return;
                    }
                    Object[] objArr = new Object[1];
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Platform Helper] [Network Manager 24] A network is available: ");
                    sb.append(networkInfo.getTypeName());
                    sb.append(", wifi only is ");
                    sb.append(NetworkManagerAbove24.this.mWifiOnly ? "enabled" : "disabled");
                    objArr[0] = sb.toString();
                    Log.i(objArr);
                    if (!NetworkManagerAbove24.this.mWifiOnly || networkInfo.getType() == 1 || networkInfo.getType() == 9) {
                        NetworkManagerAbove24.this.mNetworkAvailable = network;
                        NetworkManagerAbove24.this.mHelper.updateNetworkReachability();
                    } else {
                        Log.i("[Platform Helper] [Network Manager 24] Network isn't wifi and wifi only mode is enabled");
                        if (NetworkManagerAbove24.this.mWifiOnly) {
                            NetworkManagerAbove24.this.mLastNetworkAvailable = network;
                        }
                    }
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network network) {
            NetworkManagerAbove24.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Platform Helper] [Network Manager 24] A network has been lost");
                    if (NetworkManagerAbove24.this.mNetworkAvailable != null && NetworkManagerAbove24.this.mNetworkAvailable.equals(network)) {
                        NetworkManagerAbove24.this.mNetworkAvailable = null;
                    }
                    if (NetworkManagerAbove24.this.mLastNetworkAvailable != null && NetworkManagerAbove24.this.mLastNetworkAvailable.equals(network)) {
                        NetworkManagerAbove24.this.mLastNetworkAvailable = null;
                    }
                    NetworkManagerAbove24.this.mHelper.updateNetworkReachability();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, final NetworkCapabilities networkCapabilities) {
            NetworkManagerAbove24.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1.3
                @Override // java.lang.Runnable
                public void run() {
                    NetworkCapabilities networkCapabilities2 = networkCapabilities;
                    if (networkCapabilities2 == null) {
                        Log.e("[Platform Helper] [Network Manager 24] onCapabilitiesChanged called with null networkCapabilities, skipping...");
                        return;
                    }
                    if (networkCapabilities2.hasTransport(1)) {
                        Log.d("[Platform Helper] [Network Manager 24] onCapabilitiesChanged " + networkCapabilities.toString());
                        return;
                    }
                    Log.i("[Platform Helper] [Network Manager 24] onCapabilitiesChanged " + networkCapabilities.toString());
                    NetworkManagerAbove24.this.mHelper.updateNetworkReachability();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, final LinkProperties linkProperties) {
            NetworkManagerAbove24.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (linkProperties == null) {
                        Log.e("[Platform Helper] [Network Manager 24] onLinkPropertiesChanged called with null linkProperties, skipping...");
                        return;
                    }
                    Log.i("[Platform Helper] [Network Manager 24] onLinkPropertiesChanged " + linkProperties.toString());
                    NetworkManagerAbove24.this.updateDnsServers();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            NetworkManagerAbove24.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1.5
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Platform Helper] [Network Manager 24] onLosing");
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            NetworkManagerAbove24.this.mHelper.getHandler().post(new Runnable() { // from class: org.linphone.core.tools.network.NetworkManagerAbove24.1.6
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("[Platform Helper] [Network Manager 24] onUnavailable");
                }
            });
        }
    };

    public NetworkManagerAbove24(AndroidPlatformHelper androidPlatformHelper, ConnectivityManager connectivityManager, boolean z) {
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
            Log.i("[Platform Helper] [Network Manager 24] Wifi only mode enabled and current network isn't wifi or ethernet");
            this.mLastNetworkAvailable = this.mNetworkAvailable;
            this.mNetworkAvailable = null;
            return;
        }
        if (z || this.mNetworkAvailable != null) {
            return;
        }
        Log.i("[Platform Helper] [Network Manager 24] Wifi only mode disabled, restoring previous network");
        this.mNetworkAvailable = this.mLastNetworkAvailable;
        this.mLastNetworkAvailable = null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void registerNetworkCallbacks(Context context) {
        int iCheckPermission = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName());
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("[Platform Helper] [Network Manager 24] ACCESS_NETWORK_STATE permission is ");
        sb.append(iCheckPermission == 0 ? "granted" : "denied");
        objArr[0] = sb.toString();
        Log.i(objArr);
        if (iCheckPermission == 0) {
            this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback);
        }
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
        Network activeNetwork = this.mConnectivityManager.getActiveNetwork();
        if (activeNetwork != null) {
            return this.mConnectivityManager.getNetworkInfo(activeNetwork);
        }
        Log.i("[Platform Helper] [Network Manager 24] getActiveNetwork() returned null, using getActiveNetworkInfo() instead");
        return this.mConnectivityManager.getActiveNetworkInfo();
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public Network getActiveNetwork() {
        Network network = this.mNetworkAvailable;
        return network != null ? network : this.mConnectivityManager.getActiveNetwork();
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public boolean isCurrentlyConnected(Context context) {
        if (this.mConnectivityManager.getRestrictBackgroundStatus() == 3) {
            Log.w("[Platform Helper] [Network Manager 24] Device is restricting metered network activity while application is running on background");
            if (this.mConnectivityManager.isActiveNetworkMetered() && this.mHelper.isInBackground()) {
                Log.w("[Platform Helper] [Network Manager 24] Device is in background, returning false");
                return false;
            }
        }
        return this.mNetworkAvailable != null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public boolean hasHttpProxy(Context context) {
        ProxyInfo defaultProxy = this.mConnectivityManager.getDefaultProxy();
        if (defaultProxy == null || defaultProxy.getHost() == null) {
            return false;
        }
        Log.i("[Platform Helper] [Network Manager 24] The active network is using a http proxy: " + defaultProxy.toString());
        return true;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public String getProxyHost(Context context) {
        return this.mConnectivityManager.getDefaultProxy().getHost();
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public int getProxyPort(Context context) {
        return this.mConnectivityManager.getDefaultProxy().getPort();
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
        Network network;
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager != null) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            int i = 1;
            if (activeNetwork == null) {
                if (this.mNetworkAvailable == null) {
                    Log.e("[Platform Helper] [Network Manager 24] Active network is null and no available network has been stored!");
                } else {
                    Log.w("[Platform Helper] [Network Manager 24] Active network is null, using stored available network");
                    activeNetwork = this.mNetworkAvailable;
                }
            }
            Network[] allNetworks = this.mConnectivityManager.getAllNetworks();
            int length = allNetworks.length;
            int i2 = 0;
            while (i2 < length) {
                Network network2 = allNetworks[i2];
                NetworkInfo networkInfo = this.mConnectivityManager.getNetworkInfo(network2);
                if (networkInfo != null && (linkProperties = this.mConnectivityManager.getLinkProperties(network2)) != null) {
                    List<InetAddress> dnsServers = linkProperties.getDnsServers();
                    boolean zHasLinkPropertiesDefaultRoute = hasLinkPropertiesDefaultRoute(linkProperties);
                    Iterator<InetAddress> it = dnsServers.iterator();
                    while (it.hasNext()) {
                        String hostAddress = it.next().getHostAddress();
                        if (arrayList.contains(hostAddress) || arrayList2.contains(hostAddress)) {
                            network = activeNetwork;
                        } else {
                            String typeName = networkInfo.getTypeName();
                            if (network2.equals(activeNetwork)) {
                                Object[] objArr = new Object[i];
                                objArr[0] = "[Platform Helper] [Network Manager 24] Found DNS host " + hostAddress + " from active network " + typeName;
                                Log.i(objArr);
                                arrayList2.add(hostAddress);
                                network = activeNetwork;
                            } else if (zHasLinkPropertiesDefaultRoute) {
                                network = activeNetwork;
                                Log.i("[Platform Helper] [Network Manager 24] Found DNS host " + hostAddress + " from network " + typeName + " with default route");
                                arrayList.add(0, hostAddress);
                            } else {
                                network = activeNetwork;
                                Log.i("[Platform Helper] [Network Manager 24] Found DNS host " + hostAddress + " from network " + typeName);
                                arrayList.add(hostAddress);
                            }
                        }
                        activeNetwork = network;
                        i = 1;
                    }
                }
                i2++;
                activeNetwork = activeNetwork;
                i = 1;
            }
        }
        arrayList2.addAll(arrayList);
        this.mHelper.updateDnsServers(arrayList2);
    }
}
