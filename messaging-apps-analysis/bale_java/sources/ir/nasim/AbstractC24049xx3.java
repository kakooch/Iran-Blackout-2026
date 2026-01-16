package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.xx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC24049xx3 {

    /* renamed from: ir.nasim.xx3$a */
    public static final class a implements InterfaceC6030Lw3 {
        final /* synthetic */ C6021Lv3 a;

        a(C6021Lv3 c6021Lv3) {
            this.a = c6021Lv3;
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public int a() {
            return this.a.u().e() + this.a.u().c();
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public float b() {
            return androidx.compose.foundation.lazy.layout.f.a(this.a.p(), this.a.q(), this.a.e());
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public Object c(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objG = C6021Lv3.G(this.a, i, 0, interfaceC20295rm1, 2, null);
            return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public OW0 d() {
            return new OW0(-1, -1);
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public int e() {
            return (int) (this.a.u().a() == EnumC24286yM4.a ? this.a.u().b() & 4294967295L : this.a.u().b() >> 32);
        }

        @Override // ir.nasim.InterfaceC6030Lw3
        public float f() {
            return androidx.compose.foundation.lazy.layout.f.b(this.a.p(), this.a.q());
        }
    }

    public static final InterfaceC6030Lw3 a(C6021Lv3 c6021Lv3, boolean z, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1247008005, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridSemanticState (LazySemantics.kt:31)");
        }
        boolean z2 = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(c6021Lv3)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.a(z)) || (i & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(c6021Lv3);
            interfaceC22053ub1.s(objB);
        }
        a aVar = (a) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return aVar;
    }
}
