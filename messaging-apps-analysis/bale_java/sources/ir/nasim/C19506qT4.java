package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.qT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19506qT4 implements InterfaceC20397rw3 {
    private final GT4 a;
    private final AbstractC17424mw3 b;
    private final InterfaceC22264uw3 c;
    private final C23759xT4 d = C23759xT4.a;

    /* renamed from: ir.nasim.qT4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i) {
            super(2);
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1142237095, i, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item.<anonymous> (LazyLayoutPager.kt:212)");
            }
            AbstractC17424mw3 abstractC17424mw3 = C19506qT4.this.b;
            int i2 = this.f;
            C19506qT4 c19506qT4 = C19506qT4.this;
            InterfaceC8727Xb3.a aVar = abstractC17424mw3.j().get(i2);
            ((C16551lT4) aVar.c()).a().e(c19506qT4.d, Integer.valueOf(i2 - aVar.b()), interfaceC22053ub1, 0);
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

    public C19506qT4(GT4 gt4, AbstractC17424mw3 abstractC17424mw3, InterfaceC22264uw3 interfaceC22264uw3) {
        this.a = gt4;
        this.b = abstractC17424mw3;
        this.c = interfaceC22264uw3;
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public int a() {
        return this.b.k();
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public int c(Object obj) {
        return this.c.c(obj);
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public Object d(int i) {
        Object objD = this.c.d(i);
        return objD == null ? this.b.l(i) : objD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C19506qT4) {
            return AbstractC13042fc3.d(this.b, ((C19506qT4) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public void i(int i, Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(-1201380429);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1201380429, i2, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item (LazyLayoutPager.kt:210)");
        }
        AbstractC4612Fw3.a(obj, i, this.a.L(), AbstractC19242q11.e(1142237095, true, new a(i), interfaceC22053ub1, 54), interfaceC22053ub1, ((i2 >> 3) & 14) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER | ((i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }
}
