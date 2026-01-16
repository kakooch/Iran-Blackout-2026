package ir.nasim;

/* renamed from: ir.nasim.ob1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18394ob1 {

    /* renamed from: ir.nasim.ob1$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(1277348883);
            if (interfaceC22053ub1.H(AbstractC13040fc1.n()) != EnumC12613eu3.b || !this.a) {
                interfaceC22053ub1.Q();
                return eVar;
            }
            androidx.compose.ui.e eVarB = AbstractC18409oc6.b(eVar, -1.0f, 1.0f);
            interfaceC22053ub1.Q();
            return eVarB;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, boolean z) {
        AbstractC13042fc3.i(eVar, "<this>");
        return androidx.compose.ui.c.c(eVar, null, new a(z), 1, null);
    }

    public static /* synthetic */ androidx.compose.ui.e d(androidx.compose.ui.e eVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return c(eVar, z);
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, final long j, final float f, final float f2) {
        AbstractC13042fc3.i(eVar, "$this$customBottomBorder");
        return eVar.i(androidx.compose.ui.draw.b.b(androidx.compose.ui.e.a, new UA2() { // from class: ir.nasim.lb1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC18394ob1.g(j, f, f2, (InterfaceC17460n02) obj);
            }
        }));
    }

    public static /* synthetic */ androidx.compose.ui.e f(androidx.compose.ui.e eVar, long j, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C17784nZ1.q(1);
        }
        if ((i & 4) != 0) {
            f2 = C17784nZ1.q(0);
        }
        return e(eVar, j, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(long j, float f, float f2, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        k(j, interfaceC17460n02.w1(f), interfaceC17460n02.w1(f2), interfaceC17460n02);
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e h(androidx.compose.ui.e eVar, final long j, final float f) {
        AbstractC13042fc3.i(eVar, "$this$customTopBorder");
        return eVar.i(androidx.compose.ui.draw.b.b(androidx.compose.ui.e.a, new UA2() { // from class: ir.nasim.nb1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC18394ob1.j(j, f, (InterfaceC17460n02) obj);
            }
        }));
    }

    public static /* synthetic */ androidx.compose.ui.e i(androidx.compose.ui.e eVar, long j, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = C17784nZ1.q(1);
        }
        return h(eVar, j, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(long j, float f, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(0.0f) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32))) << 32)), interfaceC17460n02.w1(f), 0, null, 0.0f, null, 0, 496, null);
        return C19938rB7.a;
    }

    private static final void k(long j, float f, float f2, InterfaceC17460n02 interfaceC17460n02) {
        float f3;
        float f4;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - (f / 2);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
        if (interfaceC17460n02.getLayoutDirection() == EnumC12613eu3.b) {
            f4 = fIntBitsToFloat2 - f2;
            f3 = 0.0f;
        } else {
            f3 = fIntBitsToFloat2;
            f4 = f2;
        }
        InterfaceC17460n02.V0(interfaceC17460n02, j, ZG4.e((Float.floatToRawIntBits(f4) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L)), ZG4.e((Float.floatToRawIntBits(f3) << 32) | (4294967295L & Float.floatToRawIntBits(fIntBitsToFloat))), f, 0, null, 0.0f, null, 0, 496, null);
    }

    public static final long l(float f, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-773844605);
        long jT = ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).T(f);
        interfaceC22053ub1.Q();
        return jT;
    }
}
