package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.FG6;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IT4 {
    private static final float a = C17784nZ1.q(56);
    private static final C21326tT4 b = new C21326tT4(AbstractC10360bX0.m(), 0, 0, 0, EnumC24286yM4.b, 0, 0, false, 0, null, null, 0.0f, 0, false, FG6.b.a, new a(), false, null, null, AbstractC20906so1.a(C18712p72.a), 393216, null);
    private static final b c = new b();

    public static final class b implements WH1 {
        private final float a = 1.0f;
        private final float b = 1.0f;

        b() {
        }

        @Override // ir.nasim.WH1
        public float getDensity() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float t1() {
            return this.b;
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C10873cL5 e;
        final /* synthetic */ InterfaceC5563Jw3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C10873cL5 c10873cL5, InterfaceC5563Jw3 interfaceC5563Jw3) {
            super(2);
            this.e = c10873cL5;
            this.f = interfaceC5563Jw3;
        }

        public final void a(float f, float f2) {
            this.e.a += this.f.e(f - this.e.a);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).floatValue(), ((Number) obj2).floatValue());
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ int e;
        final /* synthetic */ float f;
        final /* synthetic */ SA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, float f, SA2 sa2) {
            super(0);
            this.e = i;
            this.f = f;
            this.g = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GE1 invoke() {
            return new GE1(this.e, this.f, this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(InterfaceC5563Jw3 interfaceC5563Jw3, int i, float f, InterfaceC5766Kt interfaceC5766Kt, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        interfaceC14603iB2.invoke(interfaceC5563Jw3, AbstractC6392Nk0.d(i));
        boolean z = i > interfaceC5563Jw3.h();
        int iB = (interfaceC5563Jw3.b() - interfaceC5563Jw3.h()) + 1;
        if (((z && i > interfaceC5563Jw3.b()) || (!z && i < interfaceC5563Jw3.h())) && Math.abs(i - interfaceC5563Jw3.h()) >= 3) {
            interfaceC5563Jw3.c(z ? AbstractC23053wG5.e(i - iB, interfaceC5563Jw3.h()) : AbstractC23053wG5.i(iB + i, interfaceC5563Jw3.h()), 0);
        }
        Object objE = AbstractC18086o37.e(0.0f, InterfaceC5563Jw3.d(interfaceC5563Jw3, i, 0, 2, null) + f, 0.0f, interfaceC5766Kt, new c(new C10873cL5(), interfaceC5563Jw3), interfaceC20295rm1, 4, null);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public static final Object e(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
        if (gt4.v() + 1 >= gt4.H()) {
            return C19938rB7.a;
        }
        Object objN = GT4.n(gt4, gt4.v() + 1, 0.0f, null, interfaceC20295rm1, 6, null);
        return objN == AbstractC14862ic3.e() ? objN : C19938rB7.a;
    }

    public static final Object f(GT4 gt4, InterfaceC20295rm1 interfaceC20295rm1) {
        if (gt4.v() - 1 < 0) {
            return C19938rB7.a;
        }
        Object objN = GT4.n(gt4, gt4.v() - 1, 0.0f, null, interfaceC20295rm1, 6, null);
        return objN == AbstractC14862ic3.e() ? objN : C19938rB7.a;
    }

    public static final long g(InterfaceC17733nT4 interfaceC17733nT4, int i) {
        long jL = (((i * (interfaceC17733nT4.l() + interfaceC17733nT4.h())) + interfaceC17733nT4.e()) + interfaceC17733nT4.c()) - interfaceC17733nT4.l();
        int iB = (int) (interfaceC17733nT4.a() == EnumC24286yM4.b ? interfaceC17733nT4.b() >> 32 : interfaceC17733nT4.b() & 4294967295L);
        return AbstractC23053wG5.f(jL - (iB - AbstractC23053wG5.m(interfaceC17733nT4.n().a(iB, interfaceC17733nT4.h(), interfaceC17733nT4.e(), interfaceC17733nT4.c(), i - 1, i), 0, iB)), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long h(C21326tT4 c21326tT4, int i) {
        int iB = (int) (c21326tT4.a() == EnumC24286yM4.b ? c21326tT4.b() >> 32 : c21326tT4.b() & 4294967295L);
        return AbstractC23053wG5.m(c21326tT4.n().a(iB, c21326tT4.h(), c21326tT4.e(), c21326tT4.c(), 0, i), 0, iB);
    }

    public static final float i() {
        return a;
    }

    public static final C21326tT4 j() {
        return b;
    }

    public static final GT4 k(int i, float f, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            f = 0.0f;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1210768637, i2, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:87)");
        }
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = GE1.M.a();
        boolean z = ((((i2 & 14) ^ 6) > 4 && interfaceC22053ub1.e(i)) || (i2 & 6) == 4) | ((((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.c(f)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && interfaceC22053ub1.V(sa2)) || (i2 & 384) == 256);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new d(i, f, sa2);
            interfaceC22053ub1.s(objB);
        }
        GE1 ge1 = (GE1) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        ge1.q0().setValue(sa2);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return ge1;
    }

    public static final class a implements InterfaceC11734dW3 {
        private final int a;
        private final int b;
        private final Map c = AbstractC20051rO3.k();

        a() {
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public int getHeight() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public int getWidth() {
            return this.a;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public Map t() {
            return this.c;
        }

        @Override // ir.nasim.InterfaceC11734dW3
        public void j() {
        }
    }
}
