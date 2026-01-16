package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.g0;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.InterfaceC4387Ex3;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1939h implements U {
    private final AbstractC1938g a;
    private int b;
    private int c;
    private int d = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.h$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g0.b.values().length];
            a = iArr;
            try {
                iArr[g0.b.j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g0.b.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g0.b.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g0.b.p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[g0.b.i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[g0.b.h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[g0.b.d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[g0.b.g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g0.b.e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g0.b.m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[g0.b.q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[g0.b.r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[g0.b.s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[g0.b.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[g0.b.k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[g0.b.o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[g0.b.f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private C1939h(AbstractC1938g abstractC1938g) {
        AbstractC1938g abstractC1938g2 = (AbstractC1938g) AbstractC1952v.b(abstractC1938g, "input");
        this.a = abstractC1938g2;
        abstractC1938g2.d = this;
    }

    public static C1939h N(AbstractC1938g abstractC1938g) {
        C1939h c1939h = abstractC1938g.d;
        return c1939h != null ? c1939h : new C1939h(abstractC1938g);
    }

    private Object O(g0.b bVar, Class cls, C1944m c1944m) {
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
                return R(cls, c1944m);
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
                throw new RuntimeException("unsupported field type.");
        }
    }

    private Object P(V v, C1944m c1944m) {
        int i = this.c;
        this.c = g0.c(g0.a(this.b), 4);
        try {
            Object objD = v.d();
            v.h(objD, this, c1944m);
            v.e(objD);
            if (this.b == this.c) {
                return objD;
            }
            throw InvalidProtocolBufferException.g();
        } finally {
            this.c = i;
        }
    }

    private Object Q(V v, C1944m c1944m) throws InvalidProtocolBufferException {
        int iC = this.a.C();
        AbstractC1938g abstractC1938g = this.a;
        if (abstractC1938g.a >= abstractC1938g.b) {
            throw InvalidProtocolBufferException.j();
        }
        int iL = abstractC1938g.l(iC);
        Object objD = v.d();
        this.a.a++;
        v.h(objD, this, c1944m);
        v.e(objD);
        this.a.a(0);
        r5.a--;
        this.a.k(iL);
        return objD;
    }

    private void T(int i) throws InvalidProtocolBufferException {
        if (this.a.d() != i) {
            throw InvalidProtocolBufferException.m();
        }
    }

    private void U(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if (g0.b(this.b) != i) {
            throw InvalidProtocolBufferException.d();
        }
    }

    private void V(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    private void W(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void A(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void B(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof r) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 != 2) {
                if (iB2 != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                this.a.s();
                throw null;
            }
            V(this.a.C());
            this.a.d();
            this.a.s();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 2) {
            int iC = this.a.C();
            V(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Float.valueOf(this.a.s()));
            } while (this.a.d() < iD);
            return;
        }
        if (iB3 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Float.valueOf(this.a.s()));
            if (this.a.e()) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == this.b);
        this.d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public boolean C() {
        int i;
        if (this.a.e() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.E(i);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int D() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(5);
        return this.a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void E(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        if (g0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(n());
            if (this.a.e()) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == this.b);
        this.d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void F(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1941j) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 1) {
                this.a.o();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            W(this.a.C());
            this.a.d();
            this.a.o();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 1) {
            do {
                list.add(Double.valueOf(this.a.o()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC = this.a.C();
        W(iC);
        int iD = this.a.d() + iC;
        do {
            list.add(Double.valueOf(this.a.o()));
        } while (this.a.d() < iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public long G() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public String H() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return this.a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public Object I(V v, C1944m c1944m) throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return Q(v, c1944m);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void J(List list, V v, C1944m c1944m) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        if (g0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int i = this.b;
        do {
            list.add(Q(v, c1944m));
            if (this.a.e() || this.d != 0) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == i);
        this.d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public Object K(V v, C1944m c1944m) throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(3);
        return P(v, c1944m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.a.k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.U
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(java.util.Map r8, androidx.datastore.preferences.protobuf.B.a r9, androidx.datastore.preferences.protobuf.C1944m r10) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r7 = this;
            r0 = 2
            r7.U(r0)
            androidx.datastore.preferences.protobuf.g r1 = r7.a
            int r1 = r1.C()
            androidx.datastore.preferences.protobuf.g r2 = r7.a
            int r1 = r2.l(r1)
            java.lang.Object r2 = r9.b
            java.lang.Object r3 = r9.d
        L14:
            int r4 = r7.z()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.g r5 = r7.a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.g0$b r4 = r9.c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r5 = r9.d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.O(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.g0$b r4 = r9.a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.O(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.C()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.g r8 = r7.a
            r8.k(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.g r9 = r7.a
            r9.k(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C1939h.L(java.util.Map, androidx.datastore.preferences.protobuf.B$a, androidx.datastore.preferences.protobuf.m):void");
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void M(List list, V v, C1944m c1944m) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        if (g0.b(this.b) != 3) {
            throw InvalidProtocolBufferException.d();
        }
        int i = this.b;
        do {
            list.add(P(v, c1944m));
            if (this.a.e() || this.d != 0) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == i);
        this.d = iB;
    }

    public Object R(Class cls, C1944m c1944m) throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return Q(Q.a().c(cls), c1944m);
    }

    public void S(List list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iB;
        int iB2;
        if (g0.b(this.b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        if (!(list instanceof InterfaceC4387Ex3) || z) {
            do {
                list.add(z ? H() : y());
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        InterfaceC4387Ex3 interfaceC4387Ex3 = (InterfaceC4387Ex3) list;
        do {
            interfaceC4387Ex3.h1(n());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.b);
        this.d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(1);
        return this.a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void b(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1951u) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 != 2) {
                if (iB2 != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                this.a.v();
                throw null;
            }
            V(this.a.C());
            this.a.d();
            this.a.v();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 2) {
            int iC = this.a.C();
            V(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Integer.valueOf(this.a.v()));
            } while (this.a.d() < iD);
            return;
        }
        if (iB3 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Integer.valueOf(this.a.v()));
            if (this.a.e()) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == this.b);
        this.d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void c(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1956z) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.y();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.y();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Long.valueOf(this.a.y()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Long.valueOf(this.a.y()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public boolean d() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public long e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(1);
        return this.a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void f(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1956z) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.D();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.D();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Long.valueOf(this.a.D()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Long.valueOf(this.a.D()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int g() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.C();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int getTag() {
        return this.b;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void h(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1956z) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.u();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.u();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Long.valueOf(this.a.u()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Long.valueOf(this.a.u()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void i(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1951u) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.p();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.p();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Integer.valueOf(this.a.p()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.p()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int j() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void l(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1936e) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.m();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.m();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Boolean.valueOf(this.a.m()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Boolean.valueOf(this.a.m()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void m(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        S(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public AbstractC1937f n() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return this.a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void p(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1956z) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 1) {
                this.a.r();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            W(this.a.C());
            this.a.d();
            this.a.r();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 1) {
            do {
                list.add(Long.valueOf(this.a.r()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC = this.a.C();
        W(iC);
        int iD = this.a.d() + iC;
        do {
            list.add(Long.valueOf(this.a.r()));
        } while (this.a.d() < iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void q(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1951u) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.x();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.x();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Integer.valueOf(this.a.x()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.x()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public long r() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(1);
        return this.a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(5);
        return this.a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void s(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1951u) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.C();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.C();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Integer.valueOf(this.a.C()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.C()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int t() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(5);
        return this.a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void u(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1956z) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 1) {
                this.a.w();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            W(this.a.C());
            this.a.d();
            this.a.w();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 1) {
            do {
                list.add(Long.valueOf(this.a.w()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC = this.a.C();
        W(iC);
        int iD = this.a.d() + iC;
        do {
            list.add(Long.valueOf(this.a.w()));
        } while (this.a.d() < iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void v(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1951u) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 == 0) {
                this.a.t();
                throw null;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            this.a.C();
            this.a.d();
            this.a.t();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 0) {
            do {
                list.add(Integer.valueOf(this.a.t()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.b);
            this.d = iB;
            return;
        }
        if (iB3 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD = this.a.d() + this.a.C();
        do {
            list.add(Integer.valueOf(this.a.t()));
        } while (this.a.d() < iD);
        T(iD);
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public void w(List list) throws InvalidProtocolBufferException {
        int iB;
        if (list instanceof AbstractC1951u) {
            AbstractC18350oW3.a(list);
            int iB2 = g0.b(this.b);
            if (iB2 != 2) {
                if (iB2 != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                this.a.q();
                throw null;
            }
            V(this.a.C());
            this.a.d();
            this.a.q();
            throw null;
        }
        int iB3 = g0.b(this.b);
        if (iB3 == 2) {
            int iC = this.a.C();
            V(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Integer.valueOf(this.a.q()));
            } while (this.a.d() < iD);
            return;
        }
        if (iB3 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(Integer.valueOf(this.a.q()));
            if (this.a.e()) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == this.b);
        this.d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public long x() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(0);
        return this.a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public String y() throws InvalidProtocolBufferException.InvalidWireTypeException {
        U(2);
        return this.a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.U
    public int z() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.B();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return g0.a(i2);
    }
}
