package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import ir.nasim.AbstractBinderC15536jk8;
import ir.nasim.InterfaceC17309mk8;

/* renamed from: com.google.android.gms.measurement.internal.s1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ServiceConnectionC2301s1 implements ServiceConnection {
    private final String a;
    final /* synthetic */ C2306t1 b;

    ServiceConnectionC2301s1(C2306t1 c2306t1, String str) {
        this.b = c2306t1;
        this.a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.b.a.b().w().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            InterfaceC17309mk8 interfaceC17309mk8C2 = AbstractBinderC15536jk8.C2(iBinder);
            if (interfaceC17309mk8C2 == null) {
                this.b.a.b().w().a("Install Referrer Service implementation was not found");
            } else {
                this.b.a.b().v().a("Install Referrer Service connected");
                this.b.a.a().z(new RunnableC2296r1(this, interfaceC17309mk8C2, this));
            }
        } catch (RuntimeException e) {
            this.b.a.b().w().b("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.b.a.b().v().a("Install Referrer Service disconnected");
    }
}
