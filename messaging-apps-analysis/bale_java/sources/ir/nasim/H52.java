package ir.nasim;

/* loaded from: classes.dex */
public abstract class H52 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(b.e);
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.d(null, a.e, 1, null);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        public final float a() {
            return C17784nZ1.q(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return C17784nZ1.j(a());
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G52 invoke() {
            return OD1.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b(long j, float f, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1613340891, i, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:85)");
        }
        long jO = C24381yX0.o(VY0.b(j, interfaceC22053ub1, i & 14), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jO;
    }

    public static final AbstractC6535Nx5 c() {
        return b;
    }

    public static final AbstractC6535Nx5 d() {
        return a;
    }
}
