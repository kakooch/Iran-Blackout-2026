package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.C2060d;
import ir.nasim.C13695gf8;
import ir.nasim.C4982Hj7;

/* loaded from: classes3.dex */
public final class G extends C {
    public final C2060d.a c;

    public G(C2060d.a aVar, C4982Hj7 c4982Hj7) {
        super(4, c4982Hj7);
        this.c = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.H
    public final /* bridge */ /* synthetic */ void d(C2068l c2068l, boolean z) {
    }

    @Override // ir.nasim.AbstractC12468ef8
    public final boolean f(s sVar) {
        C13695gf8 c13695gf8 = (C13695gf8) sVar.t().get(this.c);
        return c13695gf8 != null && c13695gf8.a.f();
    }

    @Override // ir.nasim.AbstractC12468ef8
    public final Feature[] g(s sVar) {
        C13695gf8 c13695gf8 = (C13695gf8) sVar.t().get(this.c);
        if (c13695gf8 == null) {
            return null;
        }
        return c13695gf8.a.c();
    }

    @Override // com.google.android.gms.common.api.internal.C
    public final void h(s sVar) {
        C13695gf8 c13695gf8 = (C13695gf8) sVar.t().remove(this.c);
        if (c13695gf8 == null) {
            this.b.e(Boolean.FALSE);
        } else {
            c13695gf8.b.b(sVar.r(), this.b);
            c13695gf8.a.a();
        }
    }
}
