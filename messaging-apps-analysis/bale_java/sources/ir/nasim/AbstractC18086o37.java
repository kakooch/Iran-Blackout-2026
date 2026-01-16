package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.o37, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC18086o37 {

    /* renamed from: ir.nasim.o37$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ InterfaceC5342Ix7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC5342Ix7 interfaceC5342Ix7) {
            super(1);
            this.e = interfaceC14603iB2;
            this.f = interfaceC5342Ix7;
        }

        public final void a(C5064Ht c5064Ht) {
            this.e.invoke(c5064Ht.e(), this.f.b().invoke(c5064Ht.g()));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o37$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int f;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC18086o37.c(null, null, 0L, null, this);
        }
    }

    /* renamed from: ir.nasim.o37$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ Object f;
        final /* synthetic */ InterfaceC24597yt g;
        final /* synthetic */ AbstractC8151Ut h;
        final /* synthetic */ C6233Mt i;
        final /* synthetic */ float j;
        final /* synthetic */ UA2 k;

        /* renamed from: ir.nasim.o37$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ C6233Mt e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6233Mt c6233Mt) {
                super(0);
                this.e = c6233Mt;
            }

            public final void a() {
                this.e.E(false);
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C12889fL5 c12889fL5, Object obj, InterfaceC24597yt interfaceC24597yt, AbstractC8151Ut abstractC8151Ut, C6233Mt c6233Mt, float f, UA2 ua2) {
            super(1);
            this.e = c12889fL5;
            this.f = obj;
            this.g = interfaceC24597yt;
            this.h = abstractC8151Ut;
            this.i = c6233Mt;
            this.j = f;
            this.k = ua2;
        }

        public final void a(long j) {
            C12889fL5 c12889fL5 = this.e;
            C5064Ht c5064Ht = new C5064Ht(this.f, this.g.e(), this.h, j, this.g.g(), j, true, new a(this.i));
            AbstractC18086o37.m(c5064Ht, j, this.j, this.g, this.i, this.k);
            c12889fL5.a = c5064Ht;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).longValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o37$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C6233Mt e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C6233Mt c6233Mt) {
            super(0);
            this.e = c6233Mt;
        }

        public final void a() {
            this.e.E(false);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o37$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ float f;
        final /* synthetic */ InterfaceC24597yt g;
        final /* synthetic */ C6233Mt h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C12889fL5 c12889fL5, float f, InterfaceC24597yt interfaceC24597yt, C6233Mt c6233Mt, UA2 ua2) {
            super(1);
            this.e = c12889fL5;
            this.f = f;
            this.g = interfaceC24597yt;
            this.h = c6233Mt;
            this.i = ua2;
        }

        public final void a(long j) {
            Object obj = this.e.a;
            AbstractC13042fc3.f(obj);
            AbstractC18086o37.m((C5064Ht) obj, j, this.f, this.g, this.h, this.i);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).longValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o37$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final Object a(long j) {
            return this.e.invoke(Long.valueOf(j));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).longValue());
        }
    }

    public static final Object b(float f2, float f3, float f4, InterfaceC5766Kt interfaceC5766Kt, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = d(PQ7.d(C9361Zp2.a), AbstractC6392Nk0.c(f2), AbstractC6392Nk0.c(f3), AbstractC6392Nk0.c(f4), interfaceC5766Kt, interfaceC14603iB2, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(ir.nasim.C6233Mt r25, ir.nasim.InterfaceC24597yt r26, long r27, ir.nasim.UA2 r29, ir.nasim.InterfaceC20295rm1 r30) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18086o37.c(ir.nasim.Mt, ir.nasim.yt, long, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    public static final Object d(InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, Object obj2, Object obj3, InterfaceC5766Kt interfaceC5766Kt, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC8151Ut abstractC8151UtG;
        if (obj3 == null || (abstractC8151UtG = (AbstractC8151Ut) interfaceC5342Ix7.a().invoke(obj3)) == null) {
            abstractC8151UtG = AbstractC8385Vt.g((AbstractC8151Ut) interfaceC5342Ix7.a().invoke(obj));
        }
        Object objF = f(new C6233Mt(interfaceC5342Ix7, obj, abstractC8151UtG, 0L, 0L, false, 56, null), new C23915xj7(interfaceC5766Kt, interfaceC5342Ix7, obj, obj2, abstractC8151UtG), 0L, new a(interfaceC14603iB2, interfaceC5342Ix7), interfaceC20295rm1, 2, null);
        return objF == AbstractC14862ic3.e() ? objF : C19938rB7.a;
    }

    public static /* synthetic */ Object e(float f2, float f3, float f4, InterfaceC5766Kt interfaceC5766Kt, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        float f5 = (i2 & 4) != 0 ? 0.0f : f4;
        if ((i2 & 8) != 0) {
            interfaceC5766Kt = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
        }
        return b(f2, f3, f5, interfaceC5766Kt, interfaceC14603iB2, interfaceC20295rm1);
    }

    public static /* synthetic */ Object f(C6233Mt c6233Mt, InterfaceC24597yt interfaceC24597yt, long j, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Long.MIN_VALUE;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            ua2 = c.e;
        }
        return c(c6233Mt, interfaceC24597yt, j2, ua2, interfaceC20295rm1);
    }

    public static final Object g(C6233Mt c6233Mt, InterfaceC10163bB1 interfaceC10163bB1, boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = c(c6233Mt, new C9569aB1(interfaceC10163bB1, c6233Mt.j(), c6233Mt.getValue(), c6233Mt.A()), z ? c6233Mt.i() : Long.MIN_VALUE, ua2, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    public static /* synthetic */ Object h(C6233Mt c6233Mt, InterfaceC10163bB1 interfaceC10163bB1, boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            ua2 = g.e;
        }
        return g(c6233Mt, interfaceC10163bB1, z, ua2, interfaceC20295rm1);
    }

    public static final Object i(C6233Mt c6233Mt, Object obj, InterfaceC5766Kt interfaceC5766Kt, boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = c(c6233Mt, new C23915xj7(interfaceC5766Kt, c6233Mt.j(), c6233Mt.getValue(), obj, c6233Mt.A()), z ? c6233Mt.i() : Long.MIN_VALUE, ua2, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    public static /* synthetic */ Object j(C6233Mt c6233Mt, Object obj, InterfaceC5766Kt interfaceC5766Kt, boolean z, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            interfaceC5766Kt = AbstractC5999Lt.j(0.0f, 0.0f, null, 7, null);
        }
        InterfaceC5766Kt interfaceC5766Kt2 = interfaceC5766Kt;
        if ((i2 & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            ua2 = h.e;
        }
        return i(c6233Mt, obj, interfaceC5766Kt2, z2, ua2, interfaceC20295rm1);
    }

    private static final Object k(InterfaceC24597yt interfaceC24597yt, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return interfaceC24597yt.a() ? AbstractC19885r63.a(ua2, interfaceC20295rm1) : AbstractC16704lj4.c(new i(ua2), interfaceC20295rm1);
    }

    private static final void l(C5064Ht c5064Ht, long j, long j2, InterfaceC24597yt interfaceC24597yt, C6233Mt c6233Mt, UA2 ua2) {
        c5064Ht.j(j);
        c5064Ht.l(interfaceC24597yt.f(j2));
        c5064Ht.m(interfaceC24597yt.b(j2));
        if (interfaceC24597yt.c(j2)) {
            c5064Ht.i(c5064Ht.c());
            c5064Ht.k(false);
        }
        o(c5064Ht, c6233Mt);
        ua2.invoke(c5064Ht);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(C5064Ht c5064Ht, long j, float f2, InterfaceC24597yt interfaceC24597yt, C6233Mt c6233Mt, UA2 ua2) {
        l(c5064Ht, j, f2 == 0.0f ? interfaceC24597yt.d() : (long) ((j - c5064Ht.d()) / f2), interfaceC24597yt, c6233Mt, ua2);
    }

    public static final float n(InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC9309Zj4 interfaceC9309Zj4 = (InterfaceC9309Zj4) interfaceC11938do1.a(InterfaceC9309Zj4.p0);
        float fZ = interfaceC9309Zj4 != null ? interfaceC9309Zj4.z() : 1.0f;
        if (!(fZ >= 0.0f)) {
            AbstractC5448Jj5.b("negative scale factor");
        }
        return fZ;
    }

    public static final void o(C5064Ht c5064Ht, C6233Mt c6233Mt) {
        c6233Mt.F(c5064Ht.e());
        AbstractC8385Vt.f(c6233Mt.A(), c5064Ht.g());
        c6233Mt.C(c5064Ht.b());
        c6233Mt.D(c5064Ht.c());
        c6233Mt.E(c5064Ht.h());
    }

    /* renamed from: ir.nasim.o37$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }

        public final void a(C5064Ht c5064Ht) {
        }
    }

    /* renamed from: ir.nasim.o37$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        g() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }

        public final void a(C5064Ht c5064Ht) {
        }
    }

    /* renamed from: ir.nasim.o37$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        public static final h e = new h();

        h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C5064Ht) obj);
            return C19938rB7.a;
        }

        public final void a(C5064Ht c5064Ht) {
        }
    }
}
