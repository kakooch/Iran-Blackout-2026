package ir.nasim;

/* renamed from: ir.nasim.Rm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7381Rm {
    public static final C7381Rm a = new C7381Rm();
    private static final InterfaceC15796kB2[][] b = {new InterfaceC15796kB2[]{g.e, h.e}, new InterfaceC15796kB2[]{i.e, j.e}};
    private static final InterfaceC14603iB2[][] c = {new InterfaceC14603iB2[]{c.e, d.e}, new InterfaceC14603iB2[]{e.e, f.e}};
    private static final InterfaceC14603iB2 d = b.e;

    /* renamed from: ir.nasim.Rm$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12613eu3.values().length];
            iArr[EnumC12613eu3.a.ordinal()] = 1;
            iArr[EnumC12613eu3.b.ordinal()] = 2;
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Rm$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 invoke(C13060fe1 c13060fe1, Object obj) {
            AbstractC13042fc3.i(c13060fe1, "$this$null");
            AbstractC13042fc3.i(obj, "other");
            c13060fe1.T(null);
            c13060fe1.S(null);
            c13060fe1.j(null);
            c13060fe1.i(null);
            C13060fe1 c13060fe1G = c13060fe1.g(obj);
            AbstractC13042fc3.h(c13060fe1G, "baselineToBaseline(other)");
            return c13060fe1G;
        }
    }

    /* renamed from: ir.nasim.Rm$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 invoke(C13060fe1 c13060fe1, Object obj) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            c13060fe1.S(null);
            c13060fe1.g(null);
            C13060fe1 c13060fe1T = c13060fe1.T(obj);
            AbstractC13042fc3.h(c13060fe1T, "topToTop(other)");
            return c13060fe1T;
        }
    }

    /* renamed from: ir.nasim.Rm$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 invoke(C13060fe1 c13060fe1, Object obj) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            c13060fe1.T(null);
            c13060fe1.g(null);
            C13060fe1 c13060fe1S = c13060fe1.S(obj);
            AbstractC13042fc3.h(c13060fe1S, "topToBottom(other)");
            return c13060fe1S;
        }
    }

    /* renamed from: ir.nasim.Rm$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 invoke(C13060fe1 c13060fe1, Object obj) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            c13060fe1.i(null);
            c13060fe1.g(null);
            C13060fe1 c13060fe1J = c13060fe1.j(obj);
            AbstractC13042fc3.h(c13060fe1J, "bottomToTop(other)");
            return c13060fe1J;
        }
    }

    /* renamed from: ir.nasim.Rm$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final f e = new f();

        f() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 invoke(C13060fe1 c13060fe1, Object obj) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            c13060fe1.j(null);
            c13060fe1.g(null);
            C13060fe1 c13060fe1I = c13060fe1.i(obj);
            AbstractC13042fc3.h(c13060fe1I, "bottomToBottom(other)");
            return c13060fe1I;
        }
    }

    /* renamed from: ir.nasim.Rm$g */
    static final class g extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final g e = new g();

        g() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 q(C13060fe1 c13060fe1, Object obj, EnumC12613eu3 enumC12613eu3) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
            C7381Rm.a.c(c13060fe1, enumC12613eu3);
            C13060fe1 c13060fe1Y = c13060fe1.y(obj);
            AbstractC13042fc3.h(c13060fe1Y, "leftToLeft(other)");
            return c13060fe1Y;
        }
    }

    /* renamed from: ir.nasim.Rm$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final h e = new h();

        h() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 q(C13060fe1 c13060fe1, Object obj, EnumC12613eu3 enumC12613eu3) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
            C7381Rm.a.c(c13060fe1, enumC12613eu3);
            C13060fe1 c13060fe1Z = c13060fe1.z(obj);
            AbstractC13042fc3.h(c13060fe1Z, "leftToRight(other)");
            return c13060fe1Z;
        }
    }

    /* renamed from: ir.nasim.Rm$i */
    static final class i extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final i e = new i();

        i() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 q(C13060fe1 c13060fe1, Object obj, EnumC12613eu3 enumC12613eu3) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
            C7381Rm.a.d(c13060fe1, enumC12613eu3);
            C13060fe1 c13060fe1F = c13060fe1.F(obj);
            AbstractC13042fc3.h(c13060fe1F, "rightToLeft(other)");
            return c13060fe1F;
        }
    }

    /* renamed from: ir.nasim.Rm$j */
    static final class j extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final j e = new j();

        j() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C13060fe1 q(C13060fe1 c13060fe1, Object obj, EnumC12613eu3 enumC12613eu3) {
            AbstractC13042fc3.i(c13060fe1, "$this$arrayOf");
            AbstractC13042fc3.i(obj, "other");
            AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
            C7381Rm.a.d(c13060fe1, enumC12613eu3);
            C13060fe1 c13060fe1G = c13060fe1.G(obj);
            AbstractC13042fc3.h(c13060fe1G, "rightToRight(other)");
            return c13060fe1G;
        }
    }

    private C7381Rm() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(C13060fe1 c13060fe1, EnumC12613eu3 enumC12613eu3) {
        c13060fe1.y(null);
        c13060fe1.z(null);
        int i2 = a.a[enumC12613eu3.ordinal()];
        if (i2 == 1) {
            c13060fe1.Q(null);
            c13060fe1.P(null);
        } else {
            if (i2 != 2) {
                return;
            }
            c13060fe1.r(null);
            c13060fe1.q(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(C13060fe1 c13060fe1, EnumC12613eu3 enumC12613eu3) {
        c13060fe1.F(null);
        c13060fe1.G(null);
        int i2 = a.a[enumC12613eu3.ordinal()];
        if (i2 == 1) {
            c13060fe1.r(null);
            c13060fe1.q(null);
        } else {
            if (i2 != 2) {
                return;
            }
            c13060fe1.Q(null);
            c13060fe1.P(null);
        }
    }

    public final InterfaceC14603iB2[][] e() {
        return c;
    }

    public final InterfaceC15796kB2[][] f() {
        return b;
    }

    public final int g(int i2, EnumC12613eu3 enumC12613eu3) {
        AbstractC13042fc3.i(enumC12613eu3, "layoutDirection");
        return i2 >= 0 ? i2 : enumC12613eu3 == EnumC12613eu3.a ? i2 + 2 : (-i2) - 1;
    }
}
