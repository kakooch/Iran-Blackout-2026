package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.KeyEvent;
import java.util.List;

/* renamed from: ir.nasim.fm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C13173fm7 {
    private final C6542Ny3 a;
    private final C19101pm7 b;
    private final C23945xm7 c;
    private final boolean d;
    private final boolean e;
    private final C4067Dn7 f;
    private final InterfaceC11600dH4 g;
    private final C14612iB7 h;
    private final LA1 i;
    private final InterfaceC3838Co3 j;
    private final UA2 k;
    private final int l;

    /* renamed from: ir.nasim.fm7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ EnumC18526oo3 e;
        final /* synthetic */ C13173fm7 f;
        final /* synthetic */ C9663aL5 g;

        /* renamed from: ir.nasim.fm7$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            public static final a e = new a();

            a() {
                super(1);
            }

            public final void a(C16146km7 c16146km7) {
                c16146km7.A();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C16146km7) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.fm7$b$b, reason: collision with other inner class name */
        static final class C1240b extends AbstractC8614Ws3 implements UA2 {
            public static final C1240b e = new C1240b();

            C1240b() {
                super(1);
            }

            public final void a(C16146km7 c16146km7) {
                c16146km7.I();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C16146km7) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.fm7$b$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            public static final c e = new c();

            c() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18081o32 invoke(C16146km7 c16146km7) {
                return new KH1(C4301En7.i(c16146km7.u()) - c16146km7.q(), 0);
            }
        }

        /* renamed from: ir.nasim.fm7$b$d */
        static final class d extends AbstractC8614Ws3 implements UA2 {
            public static final d e = new d();

            d() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18081o32 invoke(C16146km7 c16146km7) {
                int iL = c16146km7.l();
                if (iL != -1) {
                    return new KH1(0, iL - C4301En7.i(c16146km7.u()));
                }
                return null;
            }
        }

        /* renamed from: ir.nasim.fm7$b$e */
        static final class e extends AbstractC8614Ws3 implements UA2 {
            public static final e e = new e();

            e() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18081o32 invoke(C16146km7 c16146km7) {
                Integer numT = c16146km7.t();
                if (numT == null) {
                    return null;
                }
                return new KH1(C4301En7.i(c16146km7.u()) - numT.intValue(), 0);
            }
        }

        /* renamed from: ir.nasim.fm7$b$f */
        static final class f extends AbstractC8614Ws3 implements UA2 {
            public static final f e = new f();

            f() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18081o32 invoke(C16146km7 c16146km7) {
                Integer numM = c16146km7.m();
                if (numM != null) {
                    return new KH1(0, numM.intValue() - C4301En7.i(c16146km7.u()));
                }
                return null;
            }
        }

        /* renamed from: ir.nasim.fm7$b$g */
        static final class g extends AbstractC8614Ws3 implements UA2 {
            public static final g e = new g();

            g() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18081o32 invoke(C16146km7 c16146km7) {
                Integer numI = c16146km7.i();
                if (numI == null) {
                    return null;
                }
                return new KH1(C4301En7.i(c16146km7.u()) - numI.intValue(), 0);
            }
        }

        /* renamed from: ir.nasim.fm7$b$h */
        static final class h extends AbstractC8614Ws3 implements UA2 {
            public static final h e = new h();

            h() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18081o32 invoke(C16146km7 c16146km7) {
                Integer numF = c16146km7.f();
                if (numF != null) {
                    return new KH1(0, numF.intValue() - C4301En7.i(c16146km7.u()));
                }
                return null;
            }
        }

        /* renamed from: ir.nasim.fm7$b$i */
        public /* synthetic */ class i {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC18526oo3.values().length];
                try {
                    iArr[EnumC18526oo3.r.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC18526oo3.s.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC18526oo3.t.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC18526oo3.b.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EnumC18526oo3.c.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[EnumC18526oo3.e.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[EnumC18526oo3.d.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[EnumC18526oo3.g.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[EnumC18526oo3.f.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[EnumC18526oo3.l.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[EnumC18526oo3.m.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[EnumC18526oo3.n.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                try {
                    iArr[EnumC18526oo3.o.ordinal()] = 13;
                } catch (NoSuchFieldError unused13) {
                }
                try {
                    iArr[EnumC18526oo3.h.ordinal()] = 14;
                } catch (NoSuchFieldError unused14) {
                }
                try {
                    iArr[EnumC18526oo3.i.ordinal()] = 15;
                } catch (NoSuchFieldError unused15) {
                }
                try {
                    iArr[EnumC18526oo3.j.ordinal()] = 16;
                } catch (NoSuchFieldError unused16) {
                }
                try {
                    iArr[EnumC18526oo3.k.ordinal()] = 17;
                } catch (NoSuchFieldError unused17) {
                }
                try {
                    iArr[EnumC18526oo3.p.ordinal()] = 18;
                } catch (NoSuchFieldError unused18) {
                }
                try {
                    iArr[EnumC18526oo3.q.ordinal()] = 19;
                } catch (NoSuchFieldError unused19) {
                }
                try {
                    iArr[EnumC18526oo3.u.ordinal()] = 20;
                } catch (NoSuchFieldError unused20) {
                }
                try {
                    iArr[EnumC18526oo3.v.ordinal()] = 21;
                } catch (NoSuchFieldError unused21) {
                }
                try {
                    iArr[EnumC18526oo3.w.ordinal()] = 22;
                } catch (NoSuchFieldError unused22) {
                }
                try {
                    iArr[EnumC18526oo3.x.ordinal()] = 23;
                } catch (NoSuchFieldError unused23) {
                }
                try {
                    iArr[EnumC18526oo3.y.ordinal()] = 24;
                } catch (NoSuchFieldError unused24) {
                }
                try {
                    iArr[EnumC18526oo3.z.ordinal()] = 25;
                } catch (NoSuchFieldError unused25) {
                }
                try {
                    iArr[EnumC18526oo3.J0.ordinal()] = 26;
                } catch (NoSuchFieldError unused26) {
                }
                try {
                    iArr[EnumC18526oo3.K0.ordinal()] = 27;
                } catch (NoSuchFieldError unused27) {
                }
                try {
                    iArr[EnumC18526oo3.A.ordinal()] = 28;
                } catch (NoSuchFieldError unused28) {
                }
                try {
                    iArr[EnumC18526oo3.B.ordinal()] = 29;
                } catch (NoSuchFieldError unused29) {
                }
                try {
                    iArr[EnumC18526oo3.D.ordinal()] = 30;
                } catch (NoSuchFieldError unused30) {
                }
                try {
                    iArr[EnumC18526oo3.A0.ordinal()] = 31;
                } catch (NoSuchFieldError unused31) {
                }
                try {
                    iArr[EnumC18526oo3.B0.ordinal()] = 32;
                } catch (NoSuchFieldError unused32) {
                }
                try {
                    iArr[EnumC18526oo3.D0.ordinal()] = 33;
                } catch (NoSuchFieldError unused33) {
                }
                try {
                    iArr[EnumC18526oo3.C0.ordinal()] = 34;
                } catch (NoSuchFieldError unused34) {
                }
                try {
                    iArr[EnumC18526oo3.E0.ordinal()] = 35;
                } catch (NoSuchFieldError unused35) {
                }
                try {
                    iArr[EnumC18526oo3.F0.ordinal()] = 36;
                } catch (NoSuchFieldError unused36) {
                }
                try {
                    iArr[EnumC18526oo3.G0.ordinal()] = 37;
                } catch (NoSuchFieldError unused37) {
                }
                try {
                    iArr[EnumC18526oo3.H0.ordinal()] = 38;
                } catch (NoSuchFieldError unused38) {
                }
                try {
                    iArr[EnumC18526oo3.G.ordinal()] = 39;
                } catch (NoSuchFieldError unused39) {
                }
                try {
                    iArr[EnumC18526oo3.H.ordinal()] = 40;
                } catch (NoSuchFieldError unused40) {
                }
                try {
                    iArr[EnumC18526oo3.J.ordinal()] = 41;
                } catch (NoSuchFieldError unused41) {
                }
                try {
                    iArr[EnumC18526oo3.Y.ordinal()] = 42;
                } catch (NoSuchFieldError unused42) {
                }
                try {
                    iArr[EnumC18526oo3.Z.ordinal()] = 43;
                } catch (NoSuchFieldError unused43) {
                }
                try {
                    iArr[EnumC18526oo3.z0.ordinal()] = 44;
                } catch (NoSuchFieldError unused44) {
                }
                try {
                    iArr[EnumC18526oo3.I0.ordinal()] = 45;
                } catch (NoSuchFieldError unused45) {
                }
                try {
                    iArr[EnumC18526oo3.L0.ordinal()] = 46;
                } catch (NoSuchFieldError unused46) {
                }
                try {
                    iArr[EnumC18526oo3.M0.ordinal()] = 47;
                } catch (NoSuchFieldError unused47) {
                }
                try {
                    iArr[EnumC18526oo3.N0.ordinal()] = 48;
                } catch (NoSuchFieldError unused48) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC18526oo3 enumC18526oo3, C13173fm7 c13173fm7, C9663aL5 c9663aL5) {
            super(1);
            this.e = enumC18526oo3;
            this.f = c13173fm7;
            this.g = c9663aL5;
        }

        public final void a(C16146km7 c16146km7) {
            C23945xm7 c23945xm7G;
            C23945xm7 c23945xm7C;
            switch (i.a[this.e.ordinal()]) {
                case 1:
                    this.f.h().q(false);
                    break;
                case 2:
                    this.f.h().Z();
                    break;
                case 3:
                    this.f.h().u();
                    break;
                case 4:
                    c16146km7.b(a.e);
                    break;
                case 5:
                    c16146km7.c(C1240b.e);
                    break;
                case 6:
                    c16146km7.B();
                    break;
                case 7:
                    c16146km7.J();
                    break;
                case 8:
                    c16146km7.G();
                    break;
                case 9:
                    c16146km7.D();
                    break;
                case 10:
                    c16146km7.Q();
                    break;
                case 11:
                    c16146km7.z();
                    break;
                case 12:
                    c16146km7.c0();
                    break;
                case 13:
                    c16146km7.b0();
                    break;
                case 14:
                    c16146km7.P();
                    break;
                case 15:
                    c16146km7.M();
                    break;
                case 16:
                    c16146km7.N();
                    break;
                case 17:
                    c16146km7.O();
                    break;
                case 18:
                    c16146km7.L();
                    break;
                case 19:
                    c16146km7.K();
                    break;
                case 20:
                    List listY = c16146km7.Y(c.e);
                    if (listY != null) {
                        this.f.f(listY);
                        break;
                    }
                    break;
                case 21:
                    List listY2 = c16146km7.Y(d.e);
                    if (listY2 != null) {
                        this.f.f(listY2);
                        break;
                    }
                    break;
                case 22:
                    List listY3 = c16146km7.Y(e.e);
                    if (listY3 != null) {
                        this.f.f(listY3);
                        break;
                    }
                    break;
                case 23:
                    List listY4 = c16146km7.Y(f.e);
                    if (listY4 != null) {
                        this.f.f(listY4);
                        break;
                    }
                    break;
                case 24:
                    List listY5 = c16146km7.Y(g.e);
                    if (listY5 != null) {
                        this.f.f(listY5);
                        break;
                    }
                    break;
                case 25:
                    List listY6 = c16146km7.Y(h.e);
                    if (listY6 != null) {
                        this.f.f(listY6);
                        break;
                    }
                    break;
                case 26:
                    if (!this.f.i()) {
                        this.f.e(new UZ0(Separators.RETURN, 1));
                        break;
                    } else {
                        this.f.j().n().invoke(S33.j(this.f.l));
                        break;
                    }
                case 27:
                    if (!this.f.i()) {
                        this.f.e(new UZ0(Separators.HT, 1));
                        break;
                    } else {
                        this.g.a = false;
                        break;
                    }
                case 28:
                    c16146km7.R();
                    break;
                case 29:
                    ((C16146km7) c16146km7.A()).S();
                    break;
                case 30:
                    ((C16146km7) c16146km7.I()).S();
                    break;
                case 31:
                    ((C16146km7) c16146km7.B()).S();
                    break;
                case 32:
                    ((C16146km7) c16146km7.J()).S();
                    break;
                case 33:
                    ((C16146km7) c16146km7.G()).S();
                    break;
                case 34:
                    ((C16146km7) c16146km7.D()).S();
                    break;
                case 35:
                    ((C16146km7) c16146km7.P()).S();
                    break;
                case 36:
                    ((C16146km7) c16146km7.M()).S();
                    break;
                case 37:
                    ((C16146km7) c16146km7.N()).S();
                    break;
                case 38:
                    ((C16146km7) c16146km7.O()).S();
                    break;
                case 39:
                    ((C16146km7) c16146km7.Q()).S();
                    break;
                case 40:
                    ((C16146km7) c16146km7.z()).S();
                    break;
                case 41:
                    c16146km7.c0().S();
                    break;
                case 42:
                    c16146km7.b0().S();
                    break;
                case 43:
                    ((C16146km7) c16146km7.L()).S();
                    break;
                case 44:
                    ((C16146km7) c16146km7.K()).S();
                    break;
                case 45:
                    c16146km7.d();
                    break;
                case 46:
                    C14612iB7 c14612iB7K = this.f.k();
                    if (c14612iB7K != null) {
                        c14612iB7K.b(c16146km7.Z());
                    }
                    C14612iB7 c14612iB7K2 = this.f.k();
                    if (c14612iB7K2 != null && (c23945xm7G = c14612iB7K2.g()) != null) {
                        this.f.k.invoke(c23945xm7G);
                        break;
                    }
                    break;
                case 47:
                    C14612iB7 c14612iB7K3 = this.f.k();
                    if (c14612iB7K3 != null && (c23945xm7C = c14612iB7K3.c()) != null) {
                        this.f.k.invoke(c23945xm7C);
                        break;
                    }
                    break;
                case 48:
                    AbstractC22185uo3.b();
                    break;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C16146km7) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ C13173fm7(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, C23945xm7 c23945xm7, boolean z, boolean z2, C4067Dn7 c4067Dn7, InterfaceC11600dH4 interfaceC11600dH4, C14612iB7 c14612iB7, LA1 la1, InterfaceC3838Co3 interfaceC3838Co3, UA2 ua2, int i, ED1 ed1) {
        this(c6542Ny3, c19101pm7, c23945xm7, z, z2, c4067Dn7, interfaceC11600dH4, c14612iB7, la1, interfaceC3838Co3, ua2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(InterfaceC18081o32 interfaceC18081o32) {
        f(AbstractC9766aX0.e(interfaceC18081o32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(List list) {
        C11475d42 c11475d42P = this.a.p();
        List listP1 = AbstractC15401jX0.p1(list);
        listP1.add(0, new C4539Fo2());
        this.k.invoke(c11475d42P.b(listP1));
    }

    private final void g(UA2 ua2) {
        C16146km7 c16146km7 = new C16146km7(this.c, this.g, this.a.l(), this.f);
        ua2.invoke(c16146km7);
        if (C4301En7.g(c16146km7.u(), this.c.g()) && AbstractC13042fc3.d(c16146km7.e(), this.c.e())) {
            return;
        }
        this.k.invoke(c16146km7.Z());
    }

    private final UZ0 m(KeyEvent keyEvent) {
        Integer numA;
        if (AbstractC14357hm7.a(keyEvent) && (numA = this.i.a(keyEvent)) != null) {
            return new UZ0(KY6.a(new StringBuilder(), numA.intValue()).toString(), 1);
        }
        return null;
    }

    public final C19101pm7 h() {
        return this.b;
    }

    public final boolean i() {
        return this.e;
    }

    public final C6542Ny3 j() {
        return this.a;
    }

    public final C14612iB7 k() {
        return this.h;
    }

    public final boolean l(KeyEvent keyEvent) {
        EnumC18526oo3 enumC18526oo3A;
        UZ0 uz0M = m(keyEvent);
        if (uz0M != null) {
            if (!this.d) {
                return false;
            }
            e(uz0M);
            this.f.b();
            return true;
        }
        if (!AbstractC22775vo3.e(AbstractC23371wo3.b(keyEvent), AbstractC22775vo3.a.a()) || (enumC18526oo3A = this.j.a(keyEvent)) == null || (enumC18526oo3A.j() && !this.d)) {
            return false;
        }
        C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = true;
        g(new b(enumC18526oo3A, this, c9663aL5));
        C14612iB7 c14612iB7 = this.h;
        if (c14612iB7 != null) {
            c14612iB7.a();
        }
        return c9663aL5.a;
    }

    private C13173fm7(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, C23945xm7 c23945xm7, boolean z, boolean z2, C4067Dn7 c4067Dn7, InterfaceC11600dH4 interfaceC11600dH4, C14612iB7 c14612iB7, LA1 la1, InterfaceC3838Co3 interfaceC3838Co3, UA2 ua2, int i) {
        this.a = c6542Ny3;
        this.b = c19101pm7;
        this.c = c23945xm7;
        this.d = z;
        this.e = z2;
        this.f = c4067Dn7;
        this.g = interfaceC11600dH4;
        this.h = c14612iB7;
        this.i = la1;
        this.j = interfaceC3838Co3;
        this.k = ua2;
        this.l = i;
    }

    public /* synthetic */ C13173fm7(C6542Ny3 c6542Ny3, C19101pm7 c19101pm7, C23945xm7 c23945xm7, boolean z, boolean z2, C4067Dn7 c4067Dn7, InterfaceC11600dH4 interfaceC11600dH4, C14612iB7 c14612iB7, LA1 la1, InterfaceC3838Co3 interfaceC3838Co3, UA2 ua2, int i, int i2, ED1 ed1) {
        this(c6542Ny3, c19101pm7, (i2 & 4) != 0 ? new C23945xm7((String) null, 0L, (C4301En7) null, 7, (ED1) null) : c23945xm7, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? false : z2, c4067Dn7, (i2 & 64) != 0 ? InterfaceC11600dH4.a.a() : interfaceC11600dH4, (i2 & 128) != 0 ? null : c14612iB7, la1, (i2 & 512) != 0 ? AbstractC4306Eo3.a() : interfaceC3838Co3, (i2 & 1024) != 0 ? a.e : ua2, i, null);
    }

    /* renamed from: ir.nasim.fm7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23945xm7) obj);
            return C19938rB7.a;
        }

        public final void a(C23945xm7 c23945xm7) {
        }
    }
}
