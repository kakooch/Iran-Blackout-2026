package ir.nasim;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* renamed from: ir.nasim.sr4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20939sr4 extends AbstractC15469je1 {
    static final String j = HI3.f("NetworkStateTracker");
    private final ConnectivityManager g;
    private b h;
    private a i;

    /* renamed from: ir.nasim.sr4$a */
    private class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            HI3.c().a(C20939sr4.j, "Network broadcast received", new Throwable[0]);
            C20939sr4 c20939sr4 = C20939sr4.this;
            c20939sr4.d(c20939sr4.g());
        }
    }

    /* renamed from: ir.nasim.sr4$b */
    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            HI3.c().a(C20939sr4.j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            C20939sr4 c20939sr4 = C20939sr4.this;
            c20939sr4.d(c20939sr4.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            HI3.c().a(C20939sr4.j, "Network connection lost", new Throwable[0]);
            C20939sr4 c20939sr4 = C20939sr4.this;
            c20939sr4.d(c20939sr4.g());
        }
    }

    public C20939sr4(Context context, InterfaceC5684Kj7 interfaceC5684Kj7) {
        super(context, interfaceC5684Kj7);
        this.g = (ConnectivityManager) this.b.getSystemService("connectivity");
        if (j()) {
            this.h = new b();
        } else {
            this.i = new a();
        }
    }

    private static boolean j() {
        return true;
    }

    @Override // ir.nasim.AbstractC15469je1
    public void e() {
        if (!j()) {
            HI3.c().a(j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            HI3.c().a(j, "Registering network callback", new Throwable[0]);
            this.g.registerDefaultNetworkCallback(this.h);
        } catch (IllegalArgumentException | SecurityException e) {
            HI3.c().b(j, "Received exception while registering network callback", e);
        }
    }

    @Override // ir.nasim.AbstractC15469je1
    public void f() {
        if (!j()) {
            HI3.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.i);
            return;
        }
        try {
            HI3.c().a(j, "Unregistering network callback", new Throwable[0]);
            this.g.unregisterNetworkCallback(this.h);
        } catch (IllegalArgumentException | SecurityException e) {
            HI3.c().b(j, "Received exception while unregistering network callback", e);
        }
    }

    C20348rr4 g() {
        NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        boolean z = false;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zI = i();
        boolean zA = AbstractC4205Ed1.a(this.g);
        if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
            z = true;
        }
        return new C20348rr4(z2, zI, zA, z);
    }

    @Override // ir.nasim.AbstractC15469je1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C20348rr4 b() {
        return g();
    }

    boolean i() {
        try {
            NetworkCapabilities networkCapabilities = this.g.getNetworkCapabilities(this.g.getActiveNetwork());
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            HI3.c().b(j, "Unable to validate active network", e);
            return false;
        }
    }
}
