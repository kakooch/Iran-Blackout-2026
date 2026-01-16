package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.r0;
import ir.nasim.InterfaceC3919Cx3;
import java.util.List;

/* renamed from: com.google.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2385i implements d0 {
    private final AbstractC2384h a;
    private int b;
    private int c;
    private int d = 0;

    /* renamed from: com.google.protobuf.i$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r0.b.s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r0.b.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r0.b.k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r0.b.o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r0.b.f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private C2385i(AbstractC2384h abstractC2384h) {
        AbstractC2384h abstractC2384h2 = (AbstractC2384h) B.b(abstractC2384h, "input");
        this.a = abstractC2384h2;
        abstractC2384h2.d = this;
    }

    public static C2385i P(AbstractC2384h abstractC2384h) {
        C2385i c2385i = abstractC2384h.d;
        return c2385i != null ? c2385i : new C2385i(abstractC2384h);
    }

    private void Q(Object obj, e0 e0Var, C2394s c2394s) {
        int i = this.c;
        this.c = r0.c(r0.a(this.b), 4);
        try {
            e0Var.i(obj, this, c2394s);
            if (this.b == this.c) {
            } else {
                throw InvalidProtocolBufferException.j();
            }
        } finally {
            this.c = i;
        }
    }

    private void R(Object obj, e0 e0Var, C2394s c2394s) throws InvalidProtocolBufferException {
        int iK = this.a.K();
        AbstractC2384h abstractC2384h = this.a;
        if (abstractC2384h.a >= abstractC2384h.b) {
            throw InvalidProtocolBufferException.k();
        }
        int iP = abstractC2384h.p(iK);
        this.a.a++;
        e0Var.i(obj, this, c2394s);
        this.a.a(0);
        r5.a--;
        this.a.o(iP);
    }

    private Object S(r0.b bVar, Class cls, C2394s c2394s) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(d());
            case 2:
                return n();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(j());
            case 5:
                return Integer.valueOf(t());
            case 6:
                return Long.valueOf(a());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(o());
            case 9:
                return Long.valueOf(G());
            case 10:
                return M(cls, c2394s);
            case 11:
                return Integer.valueOf(D());
            case 12:
                return Long.valueOf(e());
            case 13:
                return Integer.valueOf(k());
            case 14:
                return Long.valueOf(x());
            case 15:
                return H();
            case 16:
                return Integer.valueOf(g());
            case 17:
                return Long.valueOf(r());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private Object T(e0 e0Var, C2394s c2394s) {
        Object objD = e0Var.d();
        Q(objD, e0Var, c2394s);
        e0Var.e(objD);
        return objD;
    }

    private Object U(e0 e0Var, C2394s c2394s) throws InvalidProtocolBufferException {
        Object objD = e0Var.d();
        R(objD, e0Var, c2394s);
        e0Var.e(objD);
        return objD;
    }

    private void W(int i) throws InvalidProtocolBufferException {
        if (this.a.f() != i) {
            throw InvalidProtocolBufferException.p();
        }
    }

    private void X(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if (r0.b(this.b) != i) {
            throw InvalidProtocolBufferException.e();
        }
    }

    private void Y(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.j();
        }
    }

    private void Z(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.j();
        }
    }

    @Override // com.google.protobuf.d0
    public void A(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(list, false);
    }

    @Override // com.google.protobuf.d0
    public void B(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof C2400y)) {
            int iB = r0.b(this.b);
            if (iB == 2) {
                int iK = this.a.K();
                Y(iK);
                int iF = this.a.f() + iK;
                do {
                    list.add(Float.valueOf(this.a.w()));
                } while (this.a.f() < iF);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Float.valueOf(this.a.w()));
                if (this.a.g()) {
                    return;
                } else {
                    iJ = this.a.J();
                }
            } while (iJ == this.b);
            this.d = iJ;
            return;
        }
        C2400y c2400y = (C2400y) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 2) {
            int iK2 = this.a.K();
            Y(iK2);
            int iF2 = this.a.f() + iK2;
            do {
                c2400y.M(this.a.w());
            } while (this.a.f() < iF2);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            c2400y.M(this.a.w());
            if (this.a.g()) {
                return;
            } else {
                iJ2 = this.a.J();
            }
        } while (iJ2 == this.b);
        this.d = iJ2;
    }

    @Override // com.google.protobuf.d0
    public boolean C() {
        int i;
        if (this.a.g() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.M(i);
    }

    @Override // com.google.protobuf.d0
    public int D() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(5);
        return this.a.D();
    }

    @Override // com.google.protobuf.d0
    public void E(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iJ;
        if (r0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(n());
            if (this.a.g()) {
                return;
            } else {
                iJ = this.a.J();
            }
        } while (iJ == this.b);
        this.d = iJ;
    }

    @Override // com.google.protobuf.d0
    public void F(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof C2392p)) {
            int iB = r0.b(this.b);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.a.s()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iK = this.a.K();
            Z(iK);
            int iF = this.a.f() + iK;
            do {
                list.add(Double.valueOf(this.a.s()));
            } while (this.a.f() < iF);
            return;
        }
        C2392p c2392p = (C2392p) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 1) {
            do {
                c2392p.s1(this.a.s());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iK2 = this.a.K();
        Z(iK2);
        int iF2 = this.a.f() + iK2;
        do {
            c2392p.s1(this.a.s());
        } while (this.a.f() < iF2);
    }

    @Override // com.google.protobuf.d0
    public long G() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.z();
    }

    @Override // com.google.protobuf.d0
    public String H() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(2);
        return this.a.I();
    }

    @Override // com.google.protobuf.d0
    public void I(List list, e0 e0Var, C2394s c2394s) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iJ;
        if (r0.b(this.b) != 3) {
            throw InvalidProtocolBufferException.e();
        }
        int i = this.b;
        do {
            list.add(T(e0Var, c2394s));
            if (this.a.g() || this.d != 0) {
                return;
            } else {
                iJ = this.a.J();
            }
        } while (iJ == i);
        this.d = iJ;
    }

    @Override // com.google.protobuf.d0
    public void J(List list, e0 e0Var, C2394s c2394s) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iJ;
        if (r0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int i = this.b;
        do {
            list.add(U(e0Var, c2394s));
            if (this.a.g() || this.d != 0) {
                return;
            } else {
                iJ = this.a.J();
            }
        } while (iJ == i);
        this.d = iJ;
    }

    @Override // com.google.protobuf.d0
    public Object K(Class cls, C2394s c2394s) throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(3);
        return T(a0.a().c(cls), c2394s);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.a.o(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // com.google.protobuf.d0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(java.util.Map r8, com.google.protobuf.I.a r9, com.google.protobuf.C2394s r10) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r7 = this;
            r0 = 2
            r7.X(r0)
            com.google.protobuf.h r1 = r7.a
            int r1 = r1.K()
            com.google.protobuf.h r2 = r7.a
            int r1 = r2.p(r1)
            java.lang.Object r2 = r9.b
            java.lang.Object r3 = r9.d
        L14:
            int r4 = r7.z()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            com.google.protobuf.h r5 = r7.a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.g()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.InvalidProtocolBufferException r4 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            com.google.protobuf.r0$b r4 = r9.c     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r5 = r9.d     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.S(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            com.google.protobuf.r0$b r4 = r9.a     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.S(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            com.google.protobuf.InvalidProtocolBufferException r8 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            com.google.protobuf.h r8 = r7.a
            r8.o(r1)
            return
        L67:
            com.google.protobuf.h r9 = r7.a
            r9.o(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C2385i.L(java.util.Map, com.google.protobuf.I$a, com.google.protobuf.s):void");
    }

    @Override // com.google.protobuf.d0
    public Object M(Class cls, C2394s c2394s) throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(2);
        return U(a0.a().c(cls), c2394s);
    }

    @Override // com.google.protobuf.d0
    public void N(Object obj, e0 e0Var, C2394s c2394s) throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(3);
        Q(obj, e0Var, c2394s);
    }

    @Override // com.google.protobuf.d0
    public void O(Object obj, e0 e0Var, C2394s c2394s) throws InvalidProtocolBufferException {
        X(2);
        R(obj, e0Var, c2394s);
    }

    public void V(List list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iJ;
        int iJ2;
        if (r0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        if (!(list instanceof InterfaceC3919Cx3) || z) {
            do {
                list.add(z ? H() : y());
                if (this.a.g()) {
                    return;
                } else {
                    iJ = this.a.J();
                }
            } while (iJ == this.b);
            this.d = iJ;
            return;
        }
        InterfaceC3919Cx3 interfaceC3919Cx3 = (InterfaceC3919Cx3) list;
        do {
            interfaceC3919Cx3.X(n());
            if (this.a.g()) {
                return;
            } else {
                iJ2 = this.a.J();
            }
        } while (iJ2 == this.b);
        this.d = iJ2;
    }

    @Override // com.google.protobuf.d0
    public long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(1);
        return this.a.v();
    }

    @Override // com.google.protobuf.d0
    public void b(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof A)) {
            int iB = r0.b(this.b);
            if (iB == 2) {
                int iK = this.a.K();
                Y(iK);
                int iF = this.a.f() + iK;
                do {
                    list.add(Integer.valueOf(this.a.D()));
                } while (this.a.f() < iF);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.a.D()));
                if (this.a.g()) {
                    return;
                } else {
                    iJ = this.a.J();
                }
            } while (iJ == this.b);
            this.d = iJ;
            return;
        }
        A a2 = (A) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 2) {
            int iK2 = this.a.K();
            Y(iK2);
            int iF2 = this.a.f() + iK2;
            do {
                a2.b1(this.a.D());
            } while (this.a.f() < iF2);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            a2.b1(this.a.D());
            if (this.a.g()) {
                return;
            } else {
                iJ2 = this.a.J();
            }
        } while (iJ2 == this.b);
        this.d = iJ2;
    }

    @Override // com.google.protobuf.d0
    public void c(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof G)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.a.G()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Long.valueOf(this.a.G()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        G g = (G) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                g.l1(this.a.G());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            g.l1(this.a.G());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public boolean d() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.q();
    }

    @Override // com.google.protobuf.d0
    public long e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(1);
        return this.a.E();
    }

    @Override // com.google.protobuf.d0
    public void f(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof G)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.a.L()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Long.valueOf(this.a.L()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        G g = (G) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                g.l1(this.a.L());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            g.l1(this.a.L());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public int g() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.K();
    }

    @Override // com.google.protobuf.d0
    public int getTag() {
        return this.b;
    }

    @Override // com.google.protobuf.d0
    public void h(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof G)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.a.z()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Long.valueOf(this.a.z()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        G g = (G) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                g.l1(this.a.z());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            g.l1(this.a.z());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public void i(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof A)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.t()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Integer.valueOf(this.a.t()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        A a2 = (A) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                a2.b1(this.a.t());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            a2.b1(this.a.t());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public int j() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.t();
    }

    @Override // com.google.protobuf.d0
    public int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.F();
    }

    @Override // com.google.protobuf.d0
    public void l(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof C2382f)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.q()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Boolean.valueOf(this.a.q()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        C2382f c2382f = (C2382f) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                c2382f.o(this.a.q());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            c2382f.o(this.a.q());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public void m(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(list, true);
    }

    @Override // com.google.protobuf.d0
    public AbstractC2383g n() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(2);
        return this.a.r();
    }

    @Override // com.google.protobuf.d0
    public int o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.y();
    }

    @Override // com.google.protobuf.d0
    public void p(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof G)) {
            int iB = r0.b(this.b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.a.v()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iK = this.a.K();
            Z(iK);
            int iF = this.a.f() + iK;
            do {
                list.add(Long.valueOf(this.a.v()));
            } while (this.a.f() < iF);
            return;
        }
        G g = (G) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 1) {
            do {
                g.l1(this.a.v());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iK2 = this.a.K();
        Z(iK2);
        int iF2 = this.a.f() + iK2;
        do {
            g.l1(this.a.v());
        } while (this.a.f() < iF2);
    }

    @Override // com.google.protobuf.d0
    public void q(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof A)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.F()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Integer.valueOf(this.a.F()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        A a2 = (A) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                a2.b1(this.a.F());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            a2.b1(this.a.F());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public long r() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.L();
    }

    @Override // com.google.protobuf.d0
    public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(1);
        return this.a.s();
    }

    @Override // com.google.protobuf.d0
    public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(5);
        return this.a.w();
    }

    @Override // com.google.protobuf.d0
    public void s(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof A)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.K()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Integer.valueOf(this.a.K()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        A a2 = (A) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                a2.b1(this.a.K());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            a2.b1(this.a.K());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public int t() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(5);
        return this.a.u();
    }

    @Override // com.google.protobuf.d0
    public void u(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof G)) {
            int iB = r0.b(this.b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.a.E()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iK = this.a.K();
            Z(iK);
            int iF = this.a.f() + iK;
            do {
                list.add(Long.valueOf(this.a.E()));
            } while (this.a.f() < iF);
            return;
        }
        G g = (G) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 1) {
            do {
                g.l1(this.a.E());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iK2 = this.a.K();
        Z(iK2);
        int iF2 = this.a.f() + iK2;
        do {
            g.l1(this.a.E());
        } while (this.a.f() < iF2);
    }

    @Override // com.google.protobuf.d0
    public void v(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof A)) {
            int iB = r0.b(this.b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.a.y()));
                    if (this.a.g()) {
                        return;
                    } else {
                        iJ = this.a.J();
                    }
                } while (iJ == this.b);
                this.d = iJ;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.a.f() + this.a.K();
            do {
                list.add(Integer.valueOf(this.a.y()));
            } while (this.a.f() < iF);
            W(iF);
            return;
        }
        A a2 = (A) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 0) {
            do {
                a2.b1(this.a.y());
                if (this.a.g()) {
                    return;
                } else {
                    iJ2 = this.a.J();
                }
            } while (iJ2 == this.b);
            this.d = iJ2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.a.f() + this.a.K();
        do {
            a2.b1(this.a.y());
        } while (this.a.f() < iF2);
        W(iF2);
    }

    @Override // com.google.protobuf.d0
    public void w(List list) throws InvalidProtocolBufferException {
        int iJ;
        int iJ2;
        if (!(list instanceof A)) {
            int iB = r0.b(this.b);
            if (iB == 2) {
                int iK = this.a.K();
                Y(iK);
                int iF = this.a.f() + iK;
                do {
                    list.add(Integer.valueOf(this.a.u()));
                } while (this.a.f() < iF);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.a.u()));
                if (this.a.g()) {
                    return;
                } else {
                    iJ = this.a.J();
                }
            } while (iJ == this.b);
            this.d = iJ;
            return;
        }
        A a2 = (A) list;
        int iB2 = r0.b(this.b);
        if (iB2 == 2) {
            int iK2 = this.a.K();
            Y(iK2);
            int iF2 = this.a.f() + iK2;
            do {
                a2.b1(this.a.u());
            } while (this.a.f() < iF2);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            a2.b1(this.a.u());
            if (this.a.g()) {
                return;
            } else {
                iJ2 = this.a.J();
            }
        } while (iJ2 == this.b);
        this.d = iJ2;
    }

    @Override // com.google.protobuf.d0
    public long x() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(0);
        return this.a.G();
    }

    @Override // com.google.protobuf.d0
    public String y() throws InvalidProtocolBufferException.InvalidWireTypeException {
        X(2);
        return this.a.H();
    }

    @Override // com.google.protobuf.d0
    public int z() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.J();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return r0.a(i2);
    }
}
