package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.k1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2262k1 extends BroadcastReceiver {
    private final Y3 a;
    private boolean b;
    private boolean c;

    C2262k1(Y3 y3) {
        AbstractC3795Cj5.j(y3);
        this.a = y3;
    }

    public final void b() {
        this.a.g();
        this.a.a().h();
        if (this.b) {
            return;
        }
        this.a.f().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.c = this.a.Y().m();
        this.a.b().v().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.c));
        this.b = true;
    }

    public final void c() {
        this.a.g();
        this.a.a().h();
        this.a.a().h();
        if (this.b) {
            this.a.b().v().a("Unregistering connectivity change receiver");
            this.b = false;
            this.c = false;
            try {
                this.a.f().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.a.b().r().b("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.g();
        String action = intent.getAction();
        this.a.b().v().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.a.b().w().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM = this.a.Y().m();
        if (this.c != zM) {
            this.c = zM;
            this.a.a().z(new RunnableC2257j1(this, zM));
        }
    }
}
