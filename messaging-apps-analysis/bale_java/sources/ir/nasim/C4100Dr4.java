package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/* renamed from: ir.nasim.Dr4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4100Dr4 {
    public static final C4100Dr4 a = new C4100Dr4();

    private C4100Dr4() {
    }

    public static final boolean a(Context context) {
        NetworkCapabilities networkCapabilities;
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    public static final boolean b(Context context) {
        NetworkCapabilities networkCapabilities;
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public static final boolean c() throws IOException {
        AbstractC20507s76.l();
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("8.8.8.8", 53), 1500);
            socket.close();
            return true;
        } catch (Exception e) {
            C19406qI3.c("NetworkUtils", " no connection available by ping", e);
            return false;
        }
    }
}
