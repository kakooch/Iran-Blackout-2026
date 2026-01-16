package ir.nasim;

/* renamed from: ir.nasim.te5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21430te5 implements InterfaceC14195hW3 {
    private int a;
    private int b;
    private long c;
    private long d = AbstractC22087ue5.b;
    private long e = C22045ua3.b.b();

    /* renamed from: ir.nasim.te5$a */
    public static abstract class a {
        private boolean a;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void f(AbstractC21430te5 abstractC21430te5) {
            if (abstractC21430te5 instanceof InterfaceC14942ik4) {
                ((InterfaceC14942ik4) abstractC21430te5).O(this.a);
            }
        }

        public static /* synthetic */ void h(a aVar, AbstractC21430te5 abstractC21430te5, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            aVar.g(abstractC21430te5, i, i2, f);
        }

        public static /* synthetic */ void j(a aVar, AbstractC21430te5 abstractC21430te5, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            aVar.i(abstractC21430te5, j, f);
        }

        public static /* synthetic */ void l(a aVar, AbstractC21430te5 abstractC21430te5, int i, int i2, float f, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            aVar.k(abstractC21430te5, i, i2, f);
        }

        public static /* synthetic */ void n(a aVar, AbstractC21430te5 abstractC21430te5, long j, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            aVar.m(abstractC21430te5, j, f);
        }

        public static /* synthetic */ void p(a aVar, AbstractC21430te5 abstractC21430te5, int i, int i2, float f, UA2 ua2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i3 & 8) != 0) {
                ua2 = AbstractC22087ue5.a;
            }
            aVar.o(abstractC21430te5, i, i2, f2, ua2);
        }

        public static /* synthetic */ void s(a aVar, AbstractC21430te5 abstractC21430te5, long j, float f, UA2 ua2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                ua2 = AbstractC22087ue5.a;
            }
            aVar.q(abstractC21430te5, j, f2, ua2);
        }

        public static /* synthetic */ void t(a aVar, AbstractC21430te5 abstractC21430te5, long j, C21226tK2 c21226tK2, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            aVar.r(abstractC21430te5, j, c21226tK2, f);
        }

        public static /* synthetic */ void v(a aVar, AbstractC21430te5 abstractC21430te5, int i, int i2, float f, UA2 ua2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i3 & 4) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i3 & 8) != 0) {
                ua2 = AbstractC22087ue5.a;
            }
            aVar.u(abstractC21430te5, i, i2, f2, ua2);
        }

        public static /* synthetic */ void y(a aVar, AbstractC21430te5 abstractC21430te5, long j, float f, UA2 ua2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                ua2 = AbstractC22087ue5.a;
            }
            aVar.w(abstractC21430te5, j, f2, ua2);
        }

        public static /* synthetic */ void z(a aVar, AbstractC21430te5 abstractC21430te5, long j, C21226tK2 c21226tK2, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            aVar.x(abstractC21430te5, j, c21226tK2, f);
        }

        public final void A(UA2 ua2) {
            this.a = true;
            ua2.invoke(this);
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract EnumC12613eu3 d();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int e();

        public final void g(AbstractC21430te5 abstractC21430te5, int i, int i2, float f) {
            long jF = C22045ua3.f((i2 & 4294967295L) | (i << 32));
            f(abstractC21430te5);
            abstractC21430te5.U0(C22045ua3.o(jF, abstractC21430te5.e), f, null);
        }

        public final void i(AbstractC21430te5 abstractC21430te5, long j, float f) {
            f(abstractC21430te5);
            abstractC21430te5.U0(C22045ua3.o(j, abstractC21430te5.e), f, null);
        }

        public final void k(AbstractC21430te5 abstractC21430te5, int i, int i2, float f) {
            long jF = C22045ua3.f((i << 32) | (i2 & 4294967295L));
            if (d() == EnumC12613eu3.a || e() == 0) {
                f(abstractC21430te5);
                abstractC21430te5.U0(C22045ua3.o(jF, abstractC21430te5.e), f, null);
            } else {
                long jF2 = C22045ua3.f((((e() - abstractC21430te5.P0()) - C22045ua3.k(jF)) << 32) | (C22045ua3.l(jF) & 4294967295L));
                f(abstractC21430te5);
                abstractC21430te5.U0(C22045ua3.o(jF2, abstractC21430te5.e), f, null);
            }
        }

        public final void m(AbstractC21430te5 abstractC21430te5, long j, float f) {
            if (d() == EnumC12613eu3.a || e() == 0) {
                f(abstractC21430te5);
                abstractC21430te5.U0(C22045ua3.o(j, abstractC21430te5.e), f, null);
                return;
            }
            long jF = C22045ua3.f((C22045ua3.l(j) & 4294967295L) | (((e() - abstractC21430te5.P0()) - C22045ua3.k(j)) << 32));
            f(abstractC21430te5);
            abstractC21430te5.U0(C22045ua3.o(jF, abstractC21430te5.e), f, null);
        }

        public final void o(AbstractC21430te5 abstractC21430te5, int i, int i2, float f, UA2 ua2) {
            long jF = C22045ua3.f((i << 32) | (i2 & 4294967295L));
            if (d() == EnumC12613eu3.a || e() == 0) {
                f(abstractC21430te5);
                abstractC21430te5.U0(C22045ua3.o(jF, abstractC21430te5.e), f, ua2);
            } else {
                long jF2 = C22045ua3.f((((e() - abstractC21430te5.P0()) - C22045ua3.k(jF)) << 32) | (C22045ua3.l(jF) & 4294967295L));
                f(abstractC21430te5);
                abstractC21430te5.U0(C22045ua3.o(jF2, abstractC21430te5.e), f, ua2);
            }
        }

        public final void q(AbstractC21430te5 abstractC21430te5, long j, float f, UA2 ua2) {
            if (d() == EnumC12613eu3.a || e() == 0) {
                f(abstractC21430te5);
                abstractC21430te5.U0(C22045ua3.o(j, abstractC21430te5.e), f, ua2);
                return;
            }
            long jF = C22045ua3.f((C22045ua3.l(j) & 4294967295L) | (((e() - abstractC21430te5.P0()) - C22045ua3.k(j)) << 32));
            f(abstractC21430te5);
            abstractC21430te5.U0(C22045ua3.o(jF, abstractC21430te5.e), f, ua2);
        }

        public final void r(AbstractC21430te5 abstractC21430te5, long j, C21226tK2 c21226tK2, float f) {
            if (d() == EnumC12613eu3.a || e() == 0) {
                f(abstractC21430te5);
                abstractC21430te5.W0(C22045ua3.o(j, abstractC21430te5.e), f, c21226tK2);
                return;
            }
            long jF = C22045ua3.f((C22045ua3.l(j) & 4294967295L) | (((e() - abstractC21430te5.P0()) - C22045ua3.k(j)) << 32));
            f(abstractC21430te5);
            abstractC21430te5.W0(C22045ua3.o(jF, abstractC21430te5.e), f, c21226tK2);
        }

        public final void u(AbstractC21430te5 abstractC21430te5, int i, int i2, float f, UA2 ua2) {
            long jF = C22045ua3.f((i2 & 4294967295L) | (i << 32));
            f(abstractC21430te5);
            abstractC21430te5.U0(C22045ua3.o(jF, abstractC21430te5.e), f, ua2);
        }

        public final void w(AbstractC21430te5 abstractC21430te5, long j, float f, UA2 ua2) {
            f(abstractC21430te5);
            abstractC21430te5.U0(C22045ua3.o(j, abstractC21430te5.e), f, ua2);
        }

        public final void x(AbstractC21430te5 abstractC21430te5, long j, C21226tK2 c21226tK2, float f) {
            f(abstractC21430te5);
            abstractC21430te5.W0(C22045ua3.o(j, abstractC21430te5.e), f, c21226tK2);
        }
    }

    public AbstractC21430te5() {
        long j = 0;
        this.c = C4414Fa3.c((j & 4294967295L) | (j << 32));
    }

    private final void T0() {
        this.a = AbstractC23053wG5.m((int) (this.c >> 32), C17833ne1.n(this.d), C17833ne1.l(this.d));
        this.b = AbstractC23053wG5.m((int) (this.c & 4294967295L), C17833ne1.m(this.d), C17833ne1.k(this.d));
        int i = this.a;
        long j = this.c;
        this.e = C22045ua3.f((((i - ((int) (j >> 32))) / 2) << 32) | (4294967295L & ((r0 - ((int) (j & 4294967295L))) / 2)));
    }

    public final int A0() {
        return this.b;
    }

    public int F0() {
        return (int) (this.c & 4294967295L);
    }

    protected final long H0() {
        return this.c;
    }

    public int N0() {
        return (int) (this.c >> 32);
    }

    protected final long O0() {
        return this.d;
    }

    public final int P0() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void U0(long j, float f, UA2 ua2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0(long j, float f, C21226tK2 c21226tK2) {
        U0(j, f, null);
    }

    protected final void Y0(long j) {
        if (C4414Fa3.e(this.c, j)) {
            return;
        }
        this.c = j;
        T0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b1(long j) {
        if (C17833ne1.f(this.d, j)) {
            return;
        }
        this.d = j;
        T0();
    }

    protected final long x0() {
        return this.e;
    }
}
