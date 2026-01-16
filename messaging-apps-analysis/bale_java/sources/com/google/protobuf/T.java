package com.google.protobuf;

import com.google.protobuf.C;
import com.google.protobuf.C2399x;
import com.google.protobuf.r0;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class T implements e0 {
    private final P a;
    private final l0 b;
    private final boolean c;
    private final AbstractC2395t d;

    private T(l0 l0Var, AbstractC2395t abstractC2395t, P p) {
        this.b = l0Var;
        this.c = abstractC2395t.e(p);
        this.d = abstractC2395t;
        this.a = p;
    }

    private int k(l0 l0Var, Object obj) {
        return l0Var.i(l0Var.g(obj));
    }

    private void l(l0 l0Var, AbstractC2395t abstractC2395t, Object obj, d0 d0Var, C2394s c2394s) {
        Object objF = l0Var.f(obj);
        C2399x c2399xD = abstractC2395t.d(obj);
        while (d0Var.z() != Integer.MAX_VALUE) {
            try {
                if (!n(d0Var, c2394s, abstractC2395t, c2399xD, l0Var, objF)) {
                    return;
                }
            } finally {
                l0Var.o(obj, objF);
            }
        }
    }

    static T m(l0 l0Var, AbstractC2395t abstractC2395t, P p) {
        return new T(l0Var, abstractC2395t, p);
    }

    private boolean n(d0 d0Var, C2394s c2394s, AbstractC2395t abstractC2395t, C2399x c2399x, l0 l0Var, Object obj) throws InvalidProtocolBufferException {
        int tag = d0Var.getTag();
        if (tag != r0.a) {
            if (r0.b(tag) != 2) {
                return d0Var.C();
            }
            Object objB = abstractC2395t.b(c2394s, this.a, r0.a(tag));
            if (objB == null) {
                return l0Var.m(obj, d0Var);
            }
            abstractC2395t.h(d0Var, objB, c2394s, c2399x);
            return true;
        }
        Object objB2 = null;
        int iG = 0;
        AbstractC2383g abstractC2383gN = null;
        while (d0Var.z() != Integer.MAX_VALUE) {
            int tag2 = d0Var.getTag();
            if (tag2 == r0.c) {
                iG = d0Var.g();
                objB2 = abstractC2395t.b(c2394s, this.a, iG);
            } else if (tag2 == r0.d) {
                if (objB2 != null) {
                    abstractC2395t.h(d0Var, objB2, c2394s, c2399x);
                } else {
                    abstractC2383gN = d0Var.n();
                }
            } else if (!d0Var.C()) {
                break;
            }
        }
        if (d0Var.getTag() != r0.b) {
            throw InvalidProtocolBufferException.b();
        }
        if (abstractC2383gN != null) {
            if (objB2 != null) {
                abstractC2395t.i(abstractC2383gN, objB2, c2394s, c2399x);
            } else {
                l0Var.d(obj, iG, abstractC2383gN);
            }
        }
        return true;
    }

    private void o(l0 l0Var, Object obj, s0 s0Var) {
        l0Var.s(l0Var.g(obj), s0Var);
    }

    @Override // com.google.protobuf.e0
    public void a(Object obj, Object obj2) {
        g0.G(this.b, obj, obj2);
        if (this.c) {
            g0.E(this.d, obj, obj2);
        }
    }

    @Override // com.google.protobuf.e0
    public int b(Object obj) {
        int iHashCode = this.b.g(obj).hashCode();
        return this.c ? (iHashCode * 53) + this.d.c(obj).hashCode() : iHashCode;
    }

    @Override // com.google.protobuf.e0
    public boolean c(Object obj, Object obj2) {
        if (!this.b.g(obj).equals(this.b.g(obj2))) {
            return false;
        }
        if (this.c) {
            return this.d.c(obj).equals(this.d.c(obj2));
        }
        return true;
    }

    @Override // com.google.protobuf.e0
    public Object d() {
        P p = this.a;
        return p instanceof GeneratedMessageLite ? ((GeneratedMessageLite) p).newMutableInstance() : p.newBuilderForType().j();
    }

    @Override // com.google.protobuf.e0
    public void e(Object obj) {
        this.b.j(obj);
        this.d.f(obj);
    }

    @Override // com.google.protobuf.e0
    public final boolean f(Object obj) {
        return this.d.c(obj).s();
    }

    @Override // com.google.protobuf.e0
    public int g(Object obj) {
        int iK = k(this.b, obj);
        return this.c ? iK + this.d.c(obj).j() : iK;
    }

    @Override // com.google.protobuf.e0
    public void h(Object obj, s0 s0Var) {
        Iterator itW = this.d.c(obj).w();
        while (itW.hasNext()) {
            Map.Entry entry = (Map.Entry) itW.next();
            C2399x.b bVar = (C2399x.b) entry.getKey();
            if (bVar.k() != r0.c.MESSAGE || bVar.b() || bVar.f()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof C.a) {
                bVar.getNumber();
                ((C.a) entry).a();
                throw null;
            }
            s0Var.b(bVar.getNumber(), entry.getValue());
        }
        o(this.b, obj, s0Var);
    }

    @Override // com.google.protobuf.e0
    public void i(Object obj, d0 d0Var, C2394s c2394s) {
        l(this.b, this.d, obj, d0Var, c2394s);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb A[EDGE_INSN: B:58:0x00cb->B:34:0x00cb BREAK  A[LOOP:1: B:18:0x006d->B:61:0x006d], SYNTHETIC] */
    @Override // com.google.protobuf.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.protobuf.AbstractC2381e.b r15) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r10 = this;
            r0 = r11
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.m0 r1 = r0.unknownFields
            com.google.protobuf.m0 r2 = com.google.protobuf.m0.c()
            if (r1 != r2) goto L11
            com.google.protobuf.m0 r1 = com.google.protobuf.m0.o()
            r0.unknownFields = r1
        L11:
            com.google.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.protobuf.x r11 = r11.ensureExtensionsAreMutable()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.protobuf.AbstractC2381e.I(r12, r13, r15)
            int r13 = r15.a
            int r3 = com.google.protobuf.r0.a
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.protobuf.r0.b(r13)
            if (r3 != r5) goto L66
            com.google.protobuf.t r2 = r10.d
            com.google.protobuf.s r3 = r15.d
            com.google.protobuf.P r5 = r10.a
            int r6 = com.google.protobuf.r0.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.protobuf.GeneratedMessageLite$f r8 = (com.google.protobuf.GeneratedMessageLite.f) r8
            if (r8 == 0) goto L5c
            com.google.protobuf.a0 r13 = com.google.protobuf.a0.a()
            com.google.protobuf.P r2 = r8.e()
            java.lang.Class r2 = r2.getClass()
            com.google.protobuf.e0 r13 = r13.c(r2)
            int r13 = com.google.protobuf.AbstractC2381e.p(r13, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$e r2 = r8.d
            java.lang.Object r3 = r15.c
            r11.C(r2, r3)
        L5a:
            r2 = r8
            goto L19
        L5c:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.protobuf.AbstractC2381e.G(r2, r3, r4, r5, r6, r7)
            goto L5a
        L66:
            int r13 = com.google.protobuf.AbstractC2381e.P(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.protobuf.AbstractC2381e.I(r12, r4, r15)
            int r6 = r15.a
            int r7 = com.google.protobuf.r0.a(r6)
            int r8 = com.google.protobuf.r0.b(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.protobuf.a0 r6 = com.google.protobuf.a0.a()
            com.google.protobuf.P r7 = r2.e()
            java.lang.Class r7 = r7.getClass()
            com.google.protobuf.e0 r6 = r6.c(r7)
            int r4 = com.google.protobuf.AbstractC2381e.p(r6, r12, r4, r14, r15)
            com.google.protobuf.GeneratedMessageLite$e r6 = r2.d
            java.lang.Object r7 = r15.c
            r11.C(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.protobuf.AbstractC2381e.b(r12, r4, r15)
            java.lang.Object r3 = r15.c
            com.google.protobuf.g r3 = (com.google.protobuf.AbstractC2383g) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.protobuf.AbstractC2381e.I(r12, r4, r15)
            int r13 = r15.a
            com.google.protobuf.t r2 = r10.d
            com.google.protobuf.s r6 = r15.d
            com.google.protobuf.P r7 = r10.a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.protobuf.GeneratedMessageLite$f r2 = (com.google.protobuf.GeneratedMessageLite.f) r2
            goto L6d
        Lc1:
            int r7 = com.google.protobuf.r0.b
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.protobuf.AbstractC2381e.P(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.protobuf.r0.c(r13, r5)
            r1.r(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.protobuf.InvalidProtocolBufferException r11 = com.google.protobuf.InvalidProtocolBufferException.j()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.T.j(java.lang.Object, byte[], int, int, com.google.protobuf.e$b):void");
    }
}
