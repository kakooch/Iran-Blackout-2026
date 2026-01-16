package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import ir.nasim.AbstractBinderC23306wh8;
import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public final class q extends AbstractBinderC23306wh8 {
    private b a;
    private final int h;

    public q(b bVar, int i) {
        this.a = bVar;
        this.h = i;
    }

    @Override // ir.nasim.NZ2
    public final void D1(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // ir.nasim.NZ2
    public final void r0(int i, IBinder iBinder, Bundle bundle) {
        AbstractC3795Cj5.k(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.N(i, iBinder, bundle, this.h);
        this.a = null;
    }

    @Override // ir.nasim.NZ2
    public final void s2(int i, IBinder iBinder, zzk zzkVar) {
        b bVar = this.a;
        AbstractC3795Cj5.k(bVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC3795Cj5.j(zzkVar);
        b.c0(bVar, zzkVar);
        r0(i, iBinder, zzkVar.a);
    }
}
