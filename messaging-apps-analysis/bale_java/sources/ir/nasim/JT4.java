package ir.nasim;

/* loaded from: classes2.dex */
public abstract class JT4 {

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i) {
            super(0);
            this.e = i;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final HT4 invoke() {
            return new HT4(this.e);
        }
    }

    public static final HT4 a(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2, int i3) {
        interfaceC22053ub1.A(1352421093);
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1352421093, i2, -1, "com.google.accompanist.pager.rememberPagerState (PagerState.kt:56)");
        }
        Object[] objArr = new Object[0];
        InterfaceC8230Vb6 interfaceC8230Vb6A = HT4.h.a();
        Integer numValueOf = Integer.valueOf(i);
        interfaceC22053ub1.A(1157296644);
        boolean zV = interfaceC22053ub1.V(numValueOf);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(i);
            interfaceC22053ub1.s(objB);
        }
        interfaceC22053ub1.U();
        HT4 ht4 = (HT4) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 72, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return ht4;
    }
}
