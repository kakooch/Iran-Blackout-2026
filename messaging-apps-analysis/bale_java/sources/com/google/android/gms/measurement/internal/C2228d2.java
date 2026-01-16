package com.google.android.gms.measurement.internal;

import android.util.Log;
import ir.nasim.InterfaceC12548en8;

/* renamed from: com.google.android.gms.measurement.internal.d2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2228d2 implements InterfaceC12548en8 {
    final /* synthetic */ H1 a;

    C2228d2(C2233e2 c2233e2, H1 h1) {
        this.a = h1;
    }

    @Override // ir.nasim.InterfaceC12548en8
    public final boolean zza() {
        return this.a.q() && Log.isLoggable(this.a.b().C(), 3);
    }
}
