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
public class NetworkManagerAbove26 implements NetworkManagerInterface {
    private ConnectivityManager mConnectivityManager;
    private AndroidPlatformHelper mHelper;
    private boolean mWifiOnly;
    private Network mNetworkAvailable = null;
    private Network mLastNetworkAvailable = null;
    private ConnectivityManager.NetworkCallback mNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: org.linphone.core.tools.network.NetworkManagerAbove26.1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkInfo networkInfo = NetworkManagerAbove26.this.mConnectivityManager.getNetworkInfo(network);
            if (networkInfo == null) {
                Log.e("[Platform Helper] [Network Manager 26] A network should be available but getNetworkInfo failed.");
                return;
            }
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("[Platform Helper] [Network Manager 26] A network is available: ");
            sb.append(networkInfo.getTypeName());
            sb.append(", wifi only is ");
            sb.append(NetworkManagerAbove26.this.mWifiOnly ? "enabled" : "disabled");
            objArr[0] = sb.toString();
            Log.i(objArr);
            if (!NetworkManagerAbove26.this.mWifiOnly || networkInfo.getType() == 1 || networkInfo.getType() == 9) {
                NetworkManagerAbove26.this.mNetworkAvailable = network;
                NetworkManagerAbove26.this.mHelper.updateNetworkReachability();
            } else {
                Log.i("[Platform Helper] [Network Manager 26] Network isn't wifi and wifi only mode is enabled");
                if (NetworkManagerAbove26.this.mWifiOnly) {
                    NetworkManagerAbove26.this.mLastNetworkAvailable = network;
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Log.i("[Platform Helper] [Network Manager 26] A network has been lost");
            if (NetworkManagerAbove26.this.mNetworkAvailable != null && NetworkManagerAbove26.this.mNetworkAvailable.equals(network)) {
                NetworkManagerAbove26.this.mNetworkAvailable = null;
            }
            if (NetworkManagerAbove26.this.mLastNetworkAvailable != null && NetworkManagerAbove26.this.mLastNetworkAvailable.equals(network)) {
                NetworkManagerAbove26.this.mLastNetworkAvailable = null;
            }
            NetworkManagerAbove26.this.mHelper.updateNetworkReachability();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                Log.e("[Platform Helper] [Network Manager 26] onCapabilitiesChanged called with null networkCapabilities, skipping...");
                return;
            }
            if (networkCapabilities.hasTransport(1)) {
                Log.d("[Platform Helper] [Network Manager 26] onCapabilitiesChanged " + networkCapabilities.toString());
                return;
            }
            Log.i("[Platform Helper] [Network Manager 26] onCapabilitiesChanged " + networkCapabilities.toString());
            NetworkManagerAbove26.this.mHelper.updateNetworkReachability();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (linkProperties == null) {
                Log.e("[Platform Helper] [Network Manager 26] onLinkPropertiesChanged called with null linkProperties, skipping...");
                return;
            }
            Log.i("[Platform Helper] [Network Manager 26] onLinkPropertiesChanged " + linkProperties.toString());
            NetworkManagerAbove26.this.updateDnsServers();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i) {
            Log.i("[Platform Helper] [Network Manager 26] onLosing");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            Log.i("[Platform Helper] [Network Manager 26] onUnavailable");
        }
    };

    public NetworkManagerAbove26(AndroidPlatformHelper androidPlatformHelper, ConnectivityManager connectivityManager, boolean z) {
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
            Log.i("[Platform Helper] [Network Manager 26] Wifi only mode enabled and current network isn't wifi or ethernet");
            this.mLastNetworkAvailable = this.mNetworkAvailable;
            this.mNetworkAvailable = null;
            return;
        }
        if (z || this.mNetworkAvailable != null) {
            return;
        }
        Log.i("[Platform Helper] [Network Manager 26] Wifi only mode disabled, restoring previous network");
        this.mNetworkAvailable = this.mLastNetworkAvailable;
        this.mLastNetworkAvailable = null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public void registerNetworkCallbacks(Context context) {
        int iCheckPermission = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName());
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("[Platform Helper] [Network Manager 26] ACCESS_NETWORK_STATE permission is ");
        sb.append(iCheckPermission == 0 ? "granted" : "denied");
        objArr[0] = sb.toString();
        Log.i(objArr);
        if (iCheckPermission == 0) {
            this.mConnectivityManager.registerDefaultNetworkCallback(this.mNetworkCallback, this.mHelper.getHandler());
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
        Log.i("[Platform Helper] [Network Manager 26] getActiveNetwork() returned null, using getActiveNetworkInfo() instead");
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
            Log.w("[Platform Helper] [Network Manager 26] Device is restricting metered network activity while application is running on background, data saver is probably ON");
            if (this.mConnectivityManager.isActiveNetworkMetered() && this.mHelper.isInBackground()) {
                Log.w("[Platform Helper] [Network Manager 26] Considering network is not reachable due to background restrictions!");
                return false;
            }
            Log.i("[Platform Helper] [Network Manager 26] Active network not metered, considering network is reachable");
        }
        return this.mNetworkAvailable != null;
    }

    @Override // org.linphone.core.tools.network.NetworkManagerInterface
    public boolean hasHttpProxy(Context context) {
        ProxyInfo defaultProxy = this.mConnectivityManager.getDefaultProxy();
        if (defaultProxy == null || defaultProxy.getHost() == null) {
            return false;
        }
        Log.i("[Platform Helper] [Network Manager 26] The active network is using an http proxy: " + defaultProxy.toString());
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
        Network[] networkArr;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<String> arrayList3 = new ArrayList<>();
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager != null) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            int i = 1;
            if (activeNetwork == null) {
                if (this.mNetworkAvailable == null) {
                    Log.e("[Platform Helper] [Network Manager 26] Active network is null and no available network has been stored!");
                } else {
                    Log.w("[Platform Helper] [Network Manager 26] Active network is null, using stored available network");
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
                        if (arrayList.contains(hostAddress) || arrayList3.contains(hostAddress)) {
                            network = activeNetwork;
                            networkArr = allNetworks;
                        } else {
                            String typeName = networkInfo.getTypeName();
                            if (activeNetwork != null && network2.equals(activeNetwork)) {
                                network = activeNetwork;
                                Object[] objArr = new Object[i];
                                objArr[0] = "[Platform Helper] [Network Manager 26] Found DNS host " + hostAddress + " from active network " + typeName;
                                Log.i(objArr);
                                arrayList3.add(hostAddress);
                            } else {
                                network = activeNetwork;
                                if (networkInfo.getType() == 0) {
                                    Log.i("[Platform Helper] [Network Manager 26] Found DNS host " + hostAddress + " from mobile network");
                                    arrayList2.add(hostAddress);
                                } else if (zHasLinkPropertiesDefaultRoute) {
                                    networkArr = allNetworks;
                                    Log.i("[Platform Helper] [Network Manager 26] Found DNS host " + hostAddress + " from network " + typeName + " with default route");
                                    arrayList.add(0, hostAddress);
                                } else {
                                    networkArr = allNetworks;
                                    Log.i("[Platform Helper] [Network Manager 26] Found DNS host " + hostAddress + " from network " + typeName);
                                    arrayList.add(hostAddress);
                                }
                            }
                            networkArr = allNetworks;
                        }
                        activeNetwork = network;
                        allNetworks = networkArr;
                        i = 1;
                    }
                }
                i2++;
                activeNetwork = activeNetwork;
                allNetworks = allNetworks;
                i = 1;
            }
        }
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        this.mHelper.updateDnsServers(arrayList3);
    }
}
