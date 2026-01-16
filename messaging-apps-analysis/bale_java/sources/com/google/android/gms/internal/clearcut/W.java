package com.google.android.gms.internal.clearcut;

import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC20302rm8;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class W implements InterfaceC2082f0 {
    private final InterfaceC20302rm8 a;
    private final l0 b;
    private final boolean c;
    private final AbstractC2095t d;

    private W(l0 l0Var, AbstractC2095t abstractC2095t, InterfaceC20302rm8 interfaceC20302rm8) {
        this.b = l0Var;
        this.c = abstractC2095t.g(interfaceC20302rm8);
        this.d = abstractC2095t;
        this.a = interfaceC20302rm8;
    }

    static W j(l0 l0Var, AbstractC2095t abstractC2095t, InterfaceC20302rm8 interfaceC20302rm8) {
        return new W(l0Var, abstractC2095t, interfaceC20302rm8);
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final void a(Object obj) {
        this.b.d(obj);
        this.d.f(obj);
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final int b(Object obj) {
        int iHashCode = this.b.k(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.b(obj).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final boolean c(Object obj, Object obj2) {
        if (!this.b.k(obj).equals(this.b.k(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.b(obj).equals(this.d.b(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final Object d() {
        return this.a.d().s0();
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final void e(Object obj, v0 v0Var) {
        Iterator itE = this.d.b(obj).e();
        if (itE.hasNext()) {
            AbstractC18350oW3.a(((Map.Entry) itE.next()).getKey());
            throw null;
        }
        l0 l0Var = this.b;
        l0Var.e(l0Var.k(obj), v0Var);
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final boolean f(Object obj) {
        return this.d.b(obj).d();
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final void g(Object obj, Object obj2) {
        h0.i(this.b, obj, obj2);
        if (this.c) {
            h0.g(this.d, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    public final int h(Object obj) {
        l0 l0Var = this.b;
        int iL = l0Var.l(l0Var.k(obj));
        return this.c ? iL + this.d.b(obj).h() : iL;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0061 A[EDGE_INSN: B:49:0x0061->B:27:0x0061 BREAK  A[LOOP:1: B:14:0x0032->B:52:0x0032], SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.InterfaceC2082f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.Object r8, byte[] r9, int r10, int r11, com.google.android.gms.internal.clearcut.C2079e r12) throws com.google.android.gms.internal.clearcut.zzco {
        /*
            r7 = this;
            com.google.android.gms.internal.clearcut.z r8 = (com.google.android.gms.internal.clearcut.AbstractC2101z) r8
            com.google.android.gms.internal.clearcut.m0 r0 = r8.zzjp
            com.google.android.gms.internal.clearcut.m0 r1 = com.google.android.gms.internal.clearcut.m0.h()
            if (r0 != r1) goto L10
            com.google.android.gms.internal.clearcut.m0 r0 = com.google.android.gms.internal.clearcut.m0.i()
            r8.zzjp = r0
        L10:
            r8 = r0
        L11:
            if (r10 >= r11) goto L6b
            int r2 = com.google.android.gms.internal.clearcut.AbstractC2077d.e(r9, r10, r12)
            int r0 = r12.a
            r10 = 11
            r1 = 2
            if (r0 == r10) goto L30
            r10 = r0 & 7
            if (r10 != r1) goto L2b
            r1 = r9
            r3 = r11
            r4 = r8
            r5 = r12
            int r10 = com.google.android.gms.internal.clearcut.AbstractC2077d.b(r0, r1, r2, r3, r4, r5)
            goto L11
        L2b:
            int r10 = com.google.android.gms.internal.clearcut.AbstractC2077d.a(r0, r9, r2, r11, r12)
            goto L11
        L30:
            r10 = 0
            r0 = 0
        L32:
            if (r2 >= r11) goto L61
            int r2 = com.google.android.gms.internal.clearcut.AbstractC2077d.e(r9, r2, r12)
            int r3 = r12.a
            int r4 = r3 >>> 3
            r5 = r3 & 7
            if (r4 == r1) goto L4f
            r6 = 3
            if (r4 == r6) goto L44
            goto L58
        L44:
            if (r5 != r1) goto L58
            int r2 = com.google.android.gms.internal.clearcut.AbstractC2077d.m(r9, r2, r12)
            java.lang.Object r0 = r12.c
            com.google.android.gms.internal.clearcut.f r0 = (com.google.android.gms.internal.clearcut.AbstractC2081f) r0
            goto L32
        L4f:
            if (r5 != 0) goto L58
            int r2 = com.google.android.gms.internal.clearcut.AbstractC2077d.e(r9, r2, r12)
            int r10 = r12.a
            goto L32
        L58:
            r4 = 12
            if (r3 == r4) goto L61
            int r2 = com.google.android.gms.internal.clearcut.AbstractC2077d.a(r3, r9, r2, r11, r12)
            goto L32
        L61:
            if (r0 == 0) goto L69
            int r10 = r10 << 3
            r10 = r10 | r1
            r8.e(r10, r0)
        L69:
            r10 = r2
            goto L11
        L6b:
            if (r10 != r11) goto L6e
            return
        L6e:
            com.google.android.gms.internal.clearcut.zzco r8 = com.google.android.gms.internal.clearcut.zzco.d()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.W.i(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.e):void");
    }
}
