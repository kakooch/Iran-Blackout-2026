package ir.nasim;

/* renamed from: ir.nasim.mV3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17159mV3 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(c.e);

    /* renamed from: ir.nasim.mV3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C5828Kz7 e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C5828Kz7 c5828Kz7, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = c5828Kz7;
            this.f = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1066563262, i, -1, "androidx.compose.material3.MaterialTheme.<anonymous> (MaterialTheme.kt:68)");
            }
            AbstractC9339Zm7.a(this.e.a(), this.f, interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mV3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ XX0 e;
        final /* synthetic */ C5107Hx6 f;
        final /* synthetic */ C5828Kz7 g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(XX0 xx0, C5107Hx6 c5107Hx6, C5828Kz7 c5828Kz7, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = xx0;
            this.f = c5107Hx6;
            this.g = c5828Kz7;
            this.h = interfaceC14603iB2;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC17159mV3.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mV3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.XX0 r9, ir.nasim.C5107Hx6 r10, ir.nasim.C5828Kz7 r11, ir.nasim.InterfaceC14603iB2 r12, ir.nasim.InterfaceC22053ub1 r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC17159mV3.a(ir.nasim.XX0, ir.nasim.Hx6, ir.nasim.Kz7, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    public static final C6426Nn7 b(XX0 xx0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1866455512, i, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        }
        long jC = xx0.C();
        boolean zF = interfaceC22053ub1.f(jC);
        Object objB = interfaceC22053ub1.B();
        if (zF || objB == InterfaceC22053ub1.a.a()) {
            objB = new C6426Nn7(jC, C24381yX0.o(jC, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            interfaceC22053ub1.s(objB);
        }
        C6426Nn7 c6426Nn7 = (C6426Nn7) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c6426Nn7;
    }
}
