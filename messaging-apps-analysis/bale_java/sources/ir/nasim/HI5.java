package ir.nasim;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import ir.nasim.InterfaceC16193kr4;

/* loaded from: classes2.dex */
final class HI5 implements InterfaceC16193kr4 {
    private final ConnectivityManager a;
    private final InterfaceC16193kr4.a b;
    private final a c;

    public static final class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            HI5.this.d(network, true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            HI5.this.d(network, false);
        }
    }

    public HI5(ConnectivityManager connectivityManager, InterfaceC16193kr4.a aVar) {
        this.a = connectivityManager;
        this.b = aVar;
        a aVar2 = new a();
        this.c = aVar2;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar2);
    }

    private final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.a.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Network network, boolean z) {
        Network[] allNetworks = this.a.getAllNetworks();
        int length = allNetworks.length;
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Network network2 = allNetworks[i];
            if (AbstractC13042fc3.d(network2, network) ? z : c(network2)) {
                z2 = true;
                break;
            }
            i++;
        }
        this.b.a(z2);
    }

    @Override // ir.nasim.InterfaceC16193kr4
    public boolean a() {
        for (Network network : this.a.getAllNetworks()) {
            if (c(network)) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC16193kr4
    public void shutdown() {
        this.a.unregisterNetworkCallback(this.c);
    }
}
