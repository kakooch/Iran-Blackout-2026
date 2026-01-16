package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.C2060d;
import ir.nasim.C13695gf8;
import ir.nasim.C4982Hj7;

/* loaded from: classes3.dex */
public final class E extends C {
    public final C13695gf8 c;

    public E(C13695gf8 c13695gf8, C4982Hj7 c4982Hj7) {
        super(3, c4982Hj7);
        this.c = c13695gf8;
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final /* bridge */ /* synthetic */ void d(C2068l c2068l, boolean z) {
    }

    @Override // ir.nasim.AbstractC12468ef8
    public final boolean f(s sVar) {
        return this.c.a.f();
    }

    @Override // ir.nasim.AbstractC12468ef8
    public final Feature[] g(s sVar) {
        return this.c.a.c();
    }

    @Override // com.google.android.gms.common.api.internal.C
    public final void h(s sVar) {
        this.c.a.d(sVar.r(), this.b);
        C2060d.a aVarB = this.c.a.b();
        if (aVarB != null) {
            sVar.t().put(aVarB, this.c);
        }
    }
}
