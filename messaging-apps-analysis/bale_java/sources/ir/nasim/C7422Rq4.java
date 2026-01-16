package ir.nasim;

import android.net.ConnectivityManager;
import android.net.NetworkRequest;

/* renamed from: ir.nasim.Rq4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C7422Rq4 implements InterfaceC7188Qq4 {
    private final ConnectivityManager a;

    public C7422Rq4(ConnectivityManager connectivityManager) {
        AbstractC13042fc3.i(connectivityManager, "connectivityManager");
        this.a = connectivityManager;
    }

    @Override // ir.nasim.InterfaceC7188Qq4
    public void a(ConnectivityManager.NetworkCallback networkCallback) {
        AbstractC13042fc3.i(networkCallback, "networkCallback");
        this.a.unregisterNetworkCallback(networkCallback);
    }

    @Override // ir.nasim.InterfaceC7188Qq4
    public void b(NetworkRequest networkRequest, ConnectivityManager.NetworkCallback networkCallback) {
        AbstractC13042fc3.i(networkRequest, "networkRequest");
        AbstractC13042fc3.i(networkCallback, "networkCallback");
        this.a.registerNetworkCallback(networkRequest, networkCallback);
    }
}
