package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC8727Xb3;

/* renamed from: ir.nasim.Vw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C8416Vw3 implements InterfaceC8182Uw3 {
    private final C19206px3 a;
    private final C7709Sw3 b;
    private final androidx.compose.foundation.lazy.a c;
    private final InterfaceC22264uw3 d;

    /* renamed from: ir.nasim.Vw3$a */
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
                AbstractC5138Ib1.Q(-824725566, i, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:82)");
            }
            C7709Sw3 c7709Sw3 = C8416Vw3.this.b;
            int i2 = this.f;
            C8416Vw3 c8416Vw3 = C8416Vw3.this;
            InterfaceC8727Xb3.a aVar = c7709Sw3.j().get(i2);
            ((C7475Rw3) aVar.c()).a().e(c8416Vw3.g(), Integer.valueOf(i2 - aVar.b()), interfaceC22053ub1, 0);
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

    public C8416Vw3(C19206px3 c19206px3, C7709Sw3 c7709Sw3, androidx.compose.foundation.lazy.a aVar, InterfaceC22264uw3 interfaceC22264uw3) {
        this.a = c19206px3;
        this.b = c7709Sw3;
        this.c = aVar;
        this.d = interfaceC22264uw3;
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public int a() {
        return this.b.k();
    }

    @Override // ir.nasim.InterfaceC8182Uw3
    public InterfaceC22264uw3 b() {
        return this.d;
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

    @Override // ir.nasim.InterfaceC8182Uw3
    public AbstractC18977pa3 e() {
        return this.b.m();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C8416Vw3) {
            return AbstractC13042fc3.d(this.b, ((C8416Vw3) obj).b);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public Object f(int i) {
        return this.b.i(i);
    }

    @Override // ir.nasim.InterfaceC8182Uw3
    public androidx.compose.foundation.lazy.a g() {
        return this.c;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC20397rw3
    public void i(int i, Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(-462424778);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-462424778, i2, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:80)");
        }
        AbstractC4612Fw3.a(obj, i, this.a.A(), AbstractC19242q11.e(-824725566, true, new a(i), interfaceC22053ub1, 54), interfaceC22053ub1, ((i2 >> 3) & 14) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER | ((i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
    }
}
