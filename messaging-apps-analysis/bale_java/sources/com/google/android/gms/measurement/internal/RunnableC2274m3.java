package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Gm8;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.m3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC2274m3 implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ zzq d;
    final /* synthetic */ boolean e;
    final /* synthetic */ C2308t3 f;

    RunnableC2274m3(C2308t3 c2308t3, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar, boolean z) {
        this.f = c2308t3;
        this.a = atomicReference;
        this.b = str2;
        this.c = str3;
        this.d = zzqVar;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        C2308t3 c2308t3;
        Gm8 gm8;
        synchronized (this.a) {
            try {
                try {
                    c2308t3 = this.f;
                    gm8 = c2308t3.d;
                } catch (RemoteException e) {
                    this.f.a.b().r().d("(legacy) Failed to get user properties; remote exception", null, this.b, e);
                    this.a.set(Collections.emptyList());
                    atomicReference = this.a;
                }
                if (gm8 == null) {
                    c2308t3.a.b().r().d("(legacy) Failed to get user properties; not connected to service", null, this.b, this.c);
                    this.a.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    AbstractC3795Cj5.j(this.d);
                    this.a.set(gm8.M0(this.b, this.c, this.e, this.d));
                } else {
                    this.a.set(gm8.l1(null, this.b, this.c, this.e));
                }
                this.f.E();
                atomicReference = this.a;
                atomicReference.notify();
            } finally {
                this.a.notify();
            }
        }
    }
}
