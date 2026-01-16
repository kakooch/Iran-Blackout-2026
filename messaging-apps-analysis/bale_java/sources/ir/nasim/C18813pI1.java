package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import ir.nasim.InterfaceC19404qI1;

/* renamed from: ir.nasim.pI1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18813pI1 extends AbstractC15299jL6 implements InterfaceC19404qI1 {
    private final SA2 b;
    private final ZG6 c;
    private a d = new a(androidx.compose.runtime.snapshots.j.I().i());

    /* renamed from: ir.nasim.pI1$a */
    public static final class a extends AbstractC16481lL6 implements InterfaceC19404qI1.a {
        public static final C1441a h = new C1441a(null);
        public static final int i = 8;
        private static final Object j = new Object();
        private long c;
        private int d;
        private AbstractC21192tG4 e;
        private Object f;
        private int g;

        /* renamed from: ir.nasim.pI1$a$a, reason: collision with other inner class name */
        public static final class C1441a {
            private C1441a() {
            }

            public final Object a() {
                return a.j;
            }

            public /* synthetic */ C1441a(ED1 ed1) {
                this();
            }
        }

        public a(long j2) {
            super(j2);
            this.e = AbstractC21866uG4.a();
            this.f = j;
        }

        @Override // ir.nasim.InterfaceC19404qI1.a
        public Object a() {
            return this.f;
        }

        @Override // ir.nasim.InterfaceC19404qI1.a
        public AbstractC21192tG4 b() {
            return this.e;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public void c(AbstractC16481lL6 abstractC16481lL6) {
            AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            a aVar = (a) abstractC16481lL6;
            m(aVar.b());
            this.f = aVar.f;
            this.g = aVar.g;
        }

        @Override // ir.nasim.AbstractC16481lL6
        public AbstractC16481lL6 d(long j2) {
            return new a(j2);
        }

        public final Object j() {
            return this.f;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean k(ir.nasim.InterfaceC19404qI1 r6, androidx.compose.runtime.snapshots.g r7) {
            /*
                r5 = this;
                java.lang.Object r0 = androidx.compose.runtime.snapshots.j.J()
                monitor-enter(r0)
                long r1 = r5.c     // Catch: java.lang.Throwable -> L1c
                long r3 = r7.i()     // Catch: java.lang.Throwable -> L1c
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                r2 = 1
                r3 = 0
                if (r1 != 0) goto L1e
                int r1 = r5.d     // Catch: java.lang.Throwable -> L1c
                int r4 = r7.j()     // Catch: java.lang.Throwable -> L1c
                if (r1 == r4) goto L1a
                goto L1e
            L1a:
                r1 = r3
                goto L1f
            L1c:
                r6 = move-exception
                goto L4f
            L1e:
                r1 = r2
            L1f:
                monitor-exit(r0)
                java.lang.Object r0 = r5.f
                java.lang.Object r4 = ir.nasim.C18813pI1.a.j
                if (r0 == r4) goto L31
                if (r1 == 0) goto L32
                int r0 = r5.g
                int r6 = r5.l(r6, r7)
                if (r0 != r6) goto L31
                goto L32
            L31:
                r2 = r3
            L32:
                if (r2 == 0) goto L4e
                if (r1 == 0) goto L4e
                java.lang.Object r6 = androidx.compose.runtime.snapshots.j.J()
                monitor-enter(r6)
                long r0 = r7.i()     // Catch: java.lang.Throwable -> L4b
                r5.c = r0     // Catch: java.lang.Throwable -> L4b
                int r7 = r7.j()     // Catch: java.lang.Throwable -> L4b
                r5.d = r7     // Catch: java.lang.Throwable -> L4b
                ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r6)
                goto L4e
            L4b:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            L4e:
                return r2
            L4f:
                monitor-exit(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18813pI1.a.k(ir.nasim.qI1, androidx.compose.runtime.snapshots.g):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: all -> 0x0079, LOOP:1: B:14:0x0039->B:38:0x00a5, LOOP_END, TryCatch #1 {all -> 0x0079, blocks: (B:11:0x002c, B:14:0x0039, B:16:0x0049, B:18:0x0055, B:20:0x005f, B:32:0x0099, B:23:0x006e, B:25:0x0072, B:29:0x0083, B:28:0x007b, B:40:0x00a9, B:38:0x00a5), top: B:56:0x002c }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00a1 A[EDGE_INSN: B:59:0x00a1->B:36:0x00a1 BREAK  A[LOOP:1: B:14:0x0039->B:38:0x00a5], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int l(ir.nasim.InterfaceC19404qI1 r23, androidx.compose.runtime.snapshots.g r24) {
            /*
                Method dump skipped, instructions count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18813pI1.a.l(ir.nasim.qI1, androidx.compose.runtime.snapshots.g):int");
        }

        public void m(AbstractC21192tG4 abstractC21192tG4) {
            this.e = abstractC21192tG4;
        }

        public final void n(Object obj) {
            this.f = obj;
        }

        public final void o(int i2) {
            this.g = i2;
        }

        public final void p(long j2) {
            this.c = j2;
        }

        public final void q(int i2) {
            this.d = i2;
        }
    }

    /* renamed from: ir.nasim.pI1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C3478Ba3 f;
        final /* synthetic */ C3348Am4 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C3478Ba3 c3478Ba3, C3348Am4 c3348Am4, int i) {
            super(1);
            this.f = c3478Ba3;
            this.g = c3348Am4;
            this.h = i;
        }

        public final void a(Object obj) {
            if (obj == C18813pI1.this) {
                throw new IllegalStateException("A derived state calculation cannot read itself".toString());
            }
            if (obj instanceof InterfaceC14710iL6) {
                int iA = this.f.a();
                C3348Am4 c3348Am4 = this.g;
                c3348Am4.u(obj, Math.min(iA - this.h, c3348Am4.e(obj, Integer.MAX_VALUE)));
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    public C18813pI1(SA2 sa2, ZG6 zg6) {
        this.b = sa2;
        this.c = zg6;
    }

    /* JADX WARN: Finally extract failed */
    private final a C(a aVar, androidx.compose.runtime.snapshots.g gVar, boolean z, SA2 sa2) {
        g.a aVar2;
        ZG6 zg6C;
        int i;
        int i2;
        a aVar3 = aVar;
        int i3 = 1;
        if (!aVar3.k(this, gVar)) {
            int i4 = 0;
            C3348Am4 c3348Am4 = new C3348Am4(0, 1, null);
            C3478Ba3 c3478Ba3 = (C3478Ba3) AbstractC10838cH6.a.a();
            if (c3478Ba3 == null) {
                c3478Ba3 = new C3478Ba3(0);
                AbstractC10838cH6.a.b(c3478Ba3);
            }
            int iA = c3478Ba3.a();
            C12544en4 c12544en4C = AbstractC10222bH6.c();
            Object[] objArr = c12544en4C.a;
            int iO = c12544en4C.o();
            for (int i5 = 0; i5 < iO; i5++) {
                ((InterfaceC19995rI1) objArr[i5]).b(this);
            }
            try {
                c3478Ba3.b(iA + 1);
                Object objG = androidx.compose.runtime.snapshots.g.e.g(new b(c3478Ba3, c3348Am4, iA), null, sa2);
                c3478Ba3.b(iA);
                Object[] objArr2 = c12544en4C.a;
                int iO2 = c12544en4C.o();
                while (i4 < iO2) {
                    ((InterfaceC19995rI1) objArr2[i4]).a(this);
                    i4++;
                }
                synchronized (androidx.compose.runtime.snapshots.j.J()) {
                    try {
                        aVar2 = androidx.compose.runtime.snapshots.g.e;
                        androidx.compose.runtime.snapshots.g gVarC = aVar2.c();
                        if (aVar.j() == a.h.a() || (zg6C = c()) == null || !zg6C.b(objG, aVar.j())) {
                            aVar3 = (a) androidx.compose.runtime.snapshots.j.O(this.d, this, gVarC);
                            aVar3.m(c3348Am4);
                            aVar3.o(aVar3.l(this, gVarC));
                            aVar3.n(objG);
                        } else {
                            aVar3.m(c3348Am4);
                            aVar3.o(aVar3.l(this, gVarC));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                C3478Ba3 c3478Ba32 = (C3478Ba3) AbstractC10838cH6.a.a();
                if (c3478Ba32 != null && c3478Ba32.a() == 0) {
                    aVar2.f();
                    synchronized (androidx.compose.runtime.snapshots.j.J()) {
                        androidx.compose.runtime.snapshots.g gVarC2 = aVar2.c();
                        aVar3.p(gVarC2.i());
                        aVar3.q(gVarC2.j());
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                }
                return aVar3;
            } catch (Throwable th2) {
                Object[] objArr3 = c12544en4C.a;
                int iO3 = c12544en4C.o();
                while (i4 < iO3) {
                    ((InterfaceC19995rI1) objArr3[i4]).a(this);
                    i4++;
                }
                throw th2;
            }
        }
        if (z) {
            C12544en4 c12544en4C2 = AbstractC10222bH6.c();
            Object[] objArr4 = c12544en4C2.a;
            int iO4 = c12544en4C2.o();
            for (int i6 = 0; i6 < iO4; i6++) {
                ((InterfaceC19995rI1) objArr4[i6]).b(this);
            }
            try {
                AbstractC21192tG4 abstractC21192tG4B = aVar.b();
                C3478Ba3 c3478Ba33 = (C3478Ba3) AbstractC10838cH6.a.a();
                if (c3478Ba33 == null) {
                    c3478Ba33 = new C3478Ba3(0);
                    AbstractC10838cH6.a.b(c3478Ba33);
                }
                int iA2 = c3478Ba33.a();
                Object[] objArr5 = abstractC21192tG4B.b;
                int[] iArr = abstractC21192tG4B.c;
                long[] jArr = abstractC21192tG4B.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i7 = 0;
                    while (true) {
                        long j = jArr[i7];
                        long[] jArr2 = jArr;
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i8 = 8;
                            int i9 = 8 - ((~(i7 - length)) >>> 31);
                            int i10 = 0;
                            while (i10 < i9) {
                                if ((j & 255) < 128) {
                                    int i11 = (i7 << 3) + i10;
                                    InterfaceC14710iL6 interfaceC14710iL6 = (InterfaceC14710iL6) objArr5[i11];
                                    c3478Ba33.b(iA2 + iArr[i11]);
                                    UA2 ua2G = gVar.g();
                                    if (ua2G != null) {
                                        ua2G.invoke(interfaceC14710iL6);
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = i8;
                                }
                                j >>= i2;
                                i10++;
                                i8 = i2;
                                i3 = 1;
                            }
                            int i12 = i8;
                            i = i3;
                            if (i9 != i12) {
                                break;
                            }
                        } else {
                            i = i3;
                        }
                        if (i7 == length) {
                            break;
                        }
                        i7 += i;
                        i3 = i;
                        jArr = jArr2;
                    }
                }
                c3478Ba33.b(iA2);
                C19938rB7 c19938rB72 = C19938rB7.a;
                Object[] objArr6 = c12544en4C2.a;
                int iO5 = c12544en4C2.o();
                for (int i13 = 0; i13 < iO5; i13++) {
                    ((InterfaceC19995rI1) objArr6[i13]).a(this);
                }
            } catch (Throwable th3) {
                Object[] objArr7 = c12544en4C2.a;
                int iO6 = c12544en4C2.o();
                for (int i14 = 0; i14 < iO6; i14++) {
                    ((InterfaceC19995rI1) objArr7[i14]).a(this);
                }
                throw th3;
            }
        }
        return aVar3;
    }

    private final String D() {
        a aVar = (a) androidx.compose.runtime.snapshots.j.G(this.d);
        return aVar.k(this, androidx.compose.runtime.snapshots.g.e.c()) ? String.valueOf(aVar.j()) : "<Not calculated>";
    }

    public final AbstractC16481lL6 B(androidx.compose.runtime.snapshots.g gVar) {
        return C((a) androidx.compose.runtime.snapshots.j.H(this.d, gVar), gVar, false, this.b);
    }

    @Override // ir.nasim.InterfaceC19404qI1
    public ZG6 c() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC9664aL6
    public Object getValue() {
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        UA2 ua2G = aVar.c().g();
        if (ua2G != null) {
            ua2G.invoke(this);
        }
        androidx.compose.runtime.snapshots.g gVarC = aVar.c();
        return C((a) androidx.compose.runtime.snapshots.j.H(this.d, gVarC), gVarC, true, this.b).j();
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public void i(AbstractC16481lL6 abstractC16481lL6) {
        AbstractC13042fc3.g(abstractC16481lL6, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.d = (a) abstractC16481lL6;
    }

    @Override // ir.nasim.InterfaceC14710iL6
    public AbstractC16481lL6 j() {
        return this.d;
    }

    public String toString() {
        return "DerivedState(value=" + D() + ")@" + hashCode();
    }

    @Override // ir.nasim.InterfaceC19404qI1
    public InterfaceC19404qI1.a y() {
        androidx.compose.runtime.snapshots.g gVarC = androidx.compose.runtime.snapshots.g.e.c();
        return C((a) androidx.compose.runtime.snapshots.j.H(this.d, gVarC), gVarC, false, this.b);
    }
}
