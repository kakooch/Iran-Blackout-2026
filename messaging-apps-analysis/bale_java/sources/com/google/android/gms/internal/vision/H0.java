package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC18561or8;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class H0 implements P0 {
    private final InterfaceC18561or8 a;
    private final f1 b;
    private final boolean c;
    private final AbstractC2166d0 d;

    private H0(f1 f1Var, AbstractC2166d0 abstractC2166d0, InterfaceC18561or8 interfaceC18561or8) {
        this.b = f1Var;
        this.c = abstractC2166d0.d(interfaceC18561or8);
        this.d = abstractC2166d0;
        this.a = interfaceC18561or8;
    }

    static H0 g(f1 f1Var, AbstractC2166d0 abstractC2166d0, InterfaceC18561or8 interfaceC18561or8) {
        return new H0(f1Var, abstractC2166d0, interfaceC18561or8);
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final void a(Object obj) {
        this.b.j(obj);
        this.d.f(obj);
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final boolean b(Object obj) {
        return this.d.b(obj).m();
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final boolean c(Object obj, Object obj2) {
        if (!this.b.f(obj).equals(this.b.f(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(obj).equals(this.d.b(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final void d(Object obj, Object obj2) {
        Q0.o(this.b, obj, obj2);
        if (this.c) {
            Q0.m(this.d, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final void e(Object obj, q1 q1Var) {
        Iterator itJ = this.d.b(obj).j();
        if (itJ.hasNext()) {
            AbstractC18350oW3.a(((Map.Entry) itJ.next()).getKey());
            throw null;
        }
        f1 f1Var = this.b;
        f1Var.g(f1Var.f(obj), q1Var);
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final void f(Object obj, byte[] bArr, int i, int i2, H h) {
        AbstractC2178j0 abstractC2178j0 = (AbstractC2178j0) obj;
        if (abstractC2178j0.zzb == h1.a()) {
            abstractC2178j0.zzb = h1.g();
        }
        AbstractC18350oW3.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final int h(Object obj) {
        int iHashCode = this.b.f(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.b(obj).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final int i(Object obj) {
        f1 f1Var = this.b;
        int iK = f1Var.k(f1Var.f(obj));
        return this.c ? iK + this.d.b(obj).n() : iK;
    }

    @Override // com.google.android.gms.internal.vision.P0
    public final Object zza() {
        return this.a.i().g();
    }
}
