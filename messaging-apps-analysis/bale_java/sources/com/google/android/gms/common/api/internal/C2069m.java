package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C9205Yy;
import ir.nasim.InterfaceC16269kz3;
import ir.nasim.PJ;

/* renamed from: com.google.android.gms.common.api.internal.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2069m extends L {
    private final PJ f;
    private final C2059c g;

    C2069m(InterfaceC16269kz3 interfaceC16269kz3, C2059c c2059c, com.google.android.gms.common.a aVar) {
        super(interfaceC16269kz3, aVar);
        this.f = new PJ();
        this.g = c2059c;
        this.a.b0("ConnectionlessLifecycleHelper", this);
    }

    public static void u(Activity activity, C2059c c2059c, C9205Yy c9205Yy) {
        InterfaceC16269kz3 interfaceC16269kz3C = LifecycleCallback.c(activity);
        C2069m c2069m = (C2069m) interfaceC16269kz3C.f1("ConnectionlessLifecycleHelper", C2069m.class);
        if (c2069m == null) {
            c2069m = new C2069m(interfaceC16269kz3C, c2059c, com.google.android.gms.common.a.m());
        }
        AbstractC3795Cj5.k(c9205Yy, "ApiKey cannot be null");
        c2069m.f.add(c9205Yy);
        c2059c.d(c2069m);
    }

    private final void v() {
        if (this.f.isEmpty()) {
            return;
        }
        this.g.d(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void h() {
        super.h();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.L, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void j() {
        super.j();
        v();
    }

    @Override // com.google.android.gms.common.api.internal.L, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        this.g.e(this);
    }

    @Override // com.google.android.gms.common.api.internal.L
    protected final void m(ConnectionResult connectionResult, int i) {
        this.g.J(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.L
    protected final void n() {
        this.g.b();
    }

    final PJ t() {
        return this.f;
    }
}
