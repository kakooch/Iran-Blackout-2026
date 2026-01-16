package ir.nasim;

/* renamed from: ir.nasim.kT4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15960kT4 {
    public static final C15960kT4 a = new C15960kT4();
    private static final UA2 b = a.e;
    private static final InterfaceC15796kB2 c = b.e;

    /* renamed from: ir.nasim.kT4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke(LG6 lg6) {
            AbstractC13042fc3.i(lg6, "layoutInfo");
            return Float.valueOf(lg6.f() - lg6.g());
        }
    }

    /* renamed from: ir.nasim.kT4$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final b e = new b();

        b() {
            super(3);
        }

        public final Integer a(LG6 lg6, int i, int i2) {
            AbstractC13042fc3.i(lg6, "layoutInfo");
            return Integer.valueOf(AbstractC23053wG5.m(AbstractC23053wG5.m(i2, i - 1, i + 1), 0, lg6.h() - 1));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((LG6) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        }
    }

    private C15960kT4() {
    }

    public final InterfaceC7645Sp2 a(HT4 ht4, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, float f, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(ht4, "state");
        interfaceC22053ub1.A(132228799);
        InterfaceC10163bB1 interfaceC10163bB1B = (i2 & 2) != 0 ? LI6.b(interfaceC22053ub1, 0) : interfaceC10163bB1;
        InterfaceC5766Kt interfaceC5766KtB = (i2 & 4) != 0 ? JG6.a.b() : interfaceC5766Kt;
        float fQ = (i2 & 8) != 0 ? C17784nZ1.q(0) : f;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(132228799, i, -1, "com.google.accompanist.pager.PagerDefaults.flingBehavior (Pager.kt:178)");
        }
        InterfaceC7645Sp2 interfaceC7645Sp2B = b(ht4, interfaceC10163bB1B, interfaceC5766KtB, fQ, c, interfaceC22053ub1, (i & 14) | 576 | (i & 7168) | ((i << 3) & 458752), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return interfaceC7645Sp2B;
    }

    public final InterfaceC7645Sp2 b(HT4 ht4, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, float f, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        AbstractC13042fc3.i(ht4, "state");
        AbstractC13042fc3.i(interfaceC15796kB2, "snapIndex");
        interfaceC22053ub1.A(-776119664);
        InterfaceC10163bB1 interfaceC10163bB1B = (i2 & 2) != 0 ? LI6.b(interfaceC22053ub1, 0) : interfaceC10163bB1;
        InterfaceC5766Kt interfaceC5766KtB = (i2 & 4) != 0 ? JG6.a.b() : interfaceC5766Kt;
        float fQ = (i2 & 8) != 0 ? C17784nZ1.q(0) : f;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-776119664, i, -1, "com.google.accompanist.pager.PagerDefaults.flingBehavior (Pager.kt:148)");
        }
        IG6 ig6B = AbstractC9191Yw3.b(ht4.o(), DG6.a.b(), fQ, interfaceC10163bB1B, interfaceC5766KtB, interfaceC15796kB2, interfaceC22053ub1, ((i >> 3) & 896) | 36864 | ((i << 3) & 458752), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return ig6B;
    }
}
