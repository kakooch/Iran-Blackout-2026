package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
final class U3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b = "_err";
    final /* synthetic */ Bundle c;
    final /* synthetic */ V3 d;

    U3(V3 v3, String str, String str2, Bundle bundle) {
        this.d = v3;
        this.a = str;
        this.c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a.k((zzaw) AbstractC3795Cj5.j(this.d.a.h0().w0(this.a, this.b, this.c, "auto", this.d.a.c().currentTimeMillis(), false, true)), this.a);
    }
}
