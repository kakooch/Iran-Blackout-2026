package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* renamed from: ir.nasim.eq, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12569eq implements InterfaceC13220fr4 {
    private final Context a;

    public C12569eq(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    @Override // ir.nasim.InterfaceC13220fr4
    public EnumC22216ur4 a() {
        Object systemService = this.a.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return EnumC22216ur4.h;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return EnumC22216ur4.h;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return networkCapabilities == null ? EnumC22216ur4.h : networkCapabilities.hasTransport(1) ? EnumC22216ur4.b : networkCapabilities.hasTransport(3) ? EnumC22216ur4.c : networkCapabilities.hasTransport(0) ? EnumC22216ur4.d : networkCapabilities.hasTransport(4) ? EnumC22216ur4.e : networkCapabilities.hasTransport(2) ? EnumC22216ur4.f : networkCapabilities.hasTransport(5) ? EnumC22216ur4.g : networkCapabilities.hasTransport(6) ? EnumC22216ur4.g : networkCapabilities.hasTransport(8) ? EnumC22216ur4.g : EnumC22216ur4.h;
    }
}
