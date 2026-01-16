package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.nv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18005nv3 implements InterfaceC17414mv3 {
    private final C6021Lv3 a;
    private final C16232kv3 b;
    private final InterfaceC22264uw3 c;

    /* renamed from: ir.nasim.nv3$a */
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
                AbstractC5138Ib1.Q(726189336, i, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item.<anonymous> (LazyGridItemProvider.kt:83)");
            }
            C16232kv3 c16232kv3 = C18005nv3.this.b;
            int i2 = this.f;
            InterfaceC8727Xb3.a aVar = c16232kv3.j().get(i2);
            ((C15641jv3) aVar.c()).a().e(C19778qv3.a, Integer.valueOf(i2 - aVar.b()), interfaceC22053ub1, 6);
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

    public C18005nv3(C6021Lv3 c6021Lv3, C16232kv3 c16232kv3, InterfaceC22264uw3 interfaceC22264uw3) {
        this.a = c6021Lv3;
        this.b = c16232kv3;
        this.c = interfaceC22264uw3;
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public int a() {
        return this.b.k();
    }

    @Override // ir.nasim.InterfaceC17414mv3
    public InterfaceC22264uw3 b() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public int c(Object obj) {
        return b().c(obj);
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public Object d(int i) {
        Object objD = b().d(i);
        return objD == null ? this.b.l(i) : objD;
    }

    @Override // ir.nasim.InterfaceC17414mv3
    public AbstractC18977pa3 e() {
        return this.b.n();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C18005nv3) {
            return AbstractC13042fc3.d(this.b, ((C18005nv3) obj).b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public Object f(int i) {
        return this.b.i(i);
    }

    @Override // ir.nasim.InterfaceC17414mv3
    public C5788Kv3 h() {
        return this.b.p();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public void i(int i, Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(1493551140);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1493551140, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:81)");
        }
        AbstractC4612Fw3.a(obj, i, this.a.x(), AbstractC19242q11.e(726189336, true, new a(i), interfaceC22053ub1, 54), interfaceC22053ub1, ((i2 >> 3) & 14) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER | ((i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }
}
