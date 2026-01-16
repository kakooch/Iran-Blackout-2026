package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;
import ir.nasim.InterfaceC19683ql8;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.measurement.internal.l3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2269l3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ zzq c;
    final /* synthetic */ InterfaceC19683ql8 d;
    final /* synthetic */ C2308t3 e;

    RunnableC2269l3(C2308t3 c2308t3, String str, String str2, zzq zzqVar, InterfaceC19683ql8 interfaceC19683ql8) {
        this.e = c2308t3;
        this.a = str;
        this.b = str2;
        this.c = zzqVar;
        this.d = interfaceC19683ql8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        H1 h1;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                C2308t3 c2308t3 = this.e;
                Gm8 gm8 = c2308t3.d;
                if (gm8 == null) {
                    c2308t3.a.b().r().c("Failed to get conditional properties; not connected to service", this.a, this.b);
                    h1 = this.e.a;
                } else {
                    AbstractC3795Cj5.j(this.c);
                    arrayList = f4.v(gm8.S1(this.a, this.b, this.c));
                    this.e.E();
                    h1 = this.e.a;
                }
            } catch (RemoteException e) {
                this.e.a.b().r().d("Failed to get conditional properties; remote exception", this.a, this.b, e);
                h1 = this.e.a;
            }
            h1.N().E(this.d, arrayList);
        } catch (Throwable th) {
            this.e.a.N().E(this.d, arrayList);
            throw th;
        }
    }
}
