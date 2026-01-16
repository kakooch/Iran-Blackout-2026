package org.xbill.DNS.config;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import ir.nasim.OI3;
import ir.nasim.RI3;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Iterator;
import lombok.Generated;

/* loaded from: classes8.dex */
public class AndroidResolverConfigProvider extends BaseResolverConfigProvider {

    @Generated
    private static final OI3 log = RI3.i(AndroidResolverConfigProvider.class);
    private static Context context = null;

    public static void setContext(Context context2) {
        context = context2;
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public void initialize() throws InitializationException {
        LinkProperties linkProperties;
        reset();
        Context context2 = context;
        if (context2 == null) {
            throw new InitializationException("Context must be initialized by calling setContext");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService(ConnectivityManager.class);
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null) {
            return;
        }
        Iterator<InetAddress> it = linkProperties.getDnsServers().iterator();
        while (it.hasNext()) {
            addNameserver(new InetSocketAddress(it.next(), 53));
        }
        parseSearchPathList(linkProperties.getDomains(), ",");
    }

    @Override // org.xbill.DNS.config.ResolverConfigProvider
    public boolean isEnabled() {
        return System.getProperty("java.vendor").contains("Android");
    }
}
