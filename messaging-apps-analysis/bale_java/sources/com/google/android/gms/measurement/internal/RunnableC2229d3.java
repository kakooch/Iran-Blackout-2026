package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.Gm8;
import ir.nasim.InterfaceC19683ql8;

/* renamed from: com.google.android.gms.measurement.internal.d3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2229d3 implements Runnable {
    final /* synthetic */ zzaw a;
    final /* synthetic */ String b;
    final /* synthetic */ InterfaceC19683ql8 c;
    final /* synthetic */ C2308t3 d;

    RunnableC2229d3(C2308t3 c2308t3, zzaw zzawVar, String str, InterfaceC19683ql8 interfaceC19683ql8) {
        this.d = c2308t3;
        this.a = zzawVar;
        this.b = str;
        this.c = interfaceC19683ql8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        H1 h1;
        byte[] bArrR1 = null;
        try {
            try {
                C2308t3 c2308t3 = this.d;
                Gm8 gm8 = c2308t3.d;
                if (gm8 == null) {
                    c2308t3.a.b().r().a("Discarding data. Failed to send event to service to bundle");
                    h1 = this.d.a;
                } else {
                    bArrR1 = gm8.r1(this.a, this.b);
                    this.d.E();
                    h1 = this.d.a;
                }
            } catch (RemoteException e) {
                this.d.a.b().r().b("Failed to send event to the service to bundle", e);
                h1 = this.d.a;
            }
            h1.N().G(this.c, bArrR1);
        } catch (Throwable th) {
            this.d.a.N().G(this.c, bArrR1);
            throw th;
        }
    }
}
