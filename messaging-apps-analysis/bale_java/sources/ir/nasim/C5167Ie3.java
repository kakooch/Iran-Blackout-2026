package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* renamed from: ir.nasim.Ie3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C5167Ie3 {
    public final boolean a(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("connectivity");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasTransport(4);
    }
}
