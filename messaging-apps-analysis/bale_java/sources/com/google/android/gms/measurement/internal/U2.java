package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;
import ir.nasim.InterfaceC19683ql8;
import java.util.List;

/* loaded from: classes3.dex */
final class U2 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ zzq c;
    final /* synthetic */ boolean d;
    final /* synthetic */ InterfaceC19683ql8 e;
    final /* synthetic */ C2308t3 f;

    U2(C2308t3 c2308t3, String str, String str2, zzq zzqVar, boolean z, InterfaceC19683ql8 interfaceC19683ql8) {
        this.f = c2308t3;
        this.a = str;
        this.b = str2;
        this.c = zzqVar;
        this.d = z;
        this.e = interfaceC19683ql8;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Bundle bundle;
        RemoteException e;
        Bundle bundle2 = new Bundle();
        try {
            try {
                C2308t3 c2308t3 = this.f;
                Gm8 gm8 = c2308t3.d;
                if (gm8 == null) {
                    c2308t3.a.b().r().c("Failed to get user properties; not connected to service", this.a, this.b);
                    this.f.a.N().F(this.e, bundle2);
                    return;
                }
                AbstractC3795Cj5.j(this.c);
                List<zzkw> listM0 = gm8.M0(this.a, this.b, this.d, this.c);
                bundle = new Bundle();
                if (listM0 != null) {
                    for (zzkw zzkwVar : listM0) {
                        String str = zzkwVar.e;
                        if (str != null) {
                            bundle.putString(zzkwVar.b, str);
                        } else {
                            Long l = zzkwVar.d;
                            if (l != null) {
                                bundle.putLong(zzkwVar.b, l.longValue());
                            } else {
                                Double d = zzkwVar.g;
                                if (d != null) {
                                    bundle.putDouble(zzkwVar.b, d.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    this.f.E();
                    this.f.a.N().F(this.e, bundle);
                } catch (RemoteException e2) {
                    e = e2;
                    this.f.a.b().r().c("Failed to get user properties; remote exception", this.a, e);
                    this.f.a.N().F(this.e, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle2 = bundle;
                this.f.a.N().F(this.e, bundle2);
                throw th;
            }
        } catch (RemoteException e3) {
            bundle = bundle2;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            this.f.a.N().F(this.e, bundle2);
            throw th;
        }
    }
}
