package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.jT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15369jT4 {
    public static final C15369jT4 a = new C15369jT4();

    /* renamed from: ir.nasim.jT4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ GT4 e;
        final /* synthetic */ EnumC12613eu3 f;
        final /* synthetic */ float g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GT4 gt4, EnumC12613eu3 enumC12613eu3, float f) {
            super(3);
            this.e = gt4;
            this.f = enumC12613eu3;
            this.g = f;
        }

        public final Float a(float f, float f2, float f3) {
            return Float.valueOf(ET4.c(this.e, this.f, this.g, f, f2, f3));
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a(((Number) obj).floatValue(), ((Number) obj2).floatValue(), ((Number) obj3).floatValue());
        }
    }

    private C15369jT4() {
    }

    public final InterfaceC4031Dj7 a(GT4 gt4, CT4 ct4, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt, float f, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        boolean z = true;
        if ((i2 & 2) != 0) {
            ct4 = CT4.a.a(1);
        }
        if ((i2 & 4) != 0) {
            interfaceC10163bB1 = LI6.b(interfaceC22053ub1, 0);
        }
        if ((i2 & 8) != 0) {
            interfaceC5766Kt = AbstractC5999Lt.j(0.0f, 400.0f, Float.valueOf(IY7.b(C15431ja3.a)), 1, null);
        }
        if ((i2 & 16) != 0) {
            f = 0.5f;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1559769181, i, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:383)");
        }
        if (!(0.0f <= f && f <= 1.0f)) {
            P73.a("snapPositionalThreshold should be a number between 0 and 1. You've specified " + f);
        }
        Object obj = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1.H(AbstractC13040fc1.n());
        boolean zV = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(gt4)) || (i & 6) == 4) | interfaceC22053ub1.V(interfaceC10163bB1) | interfaceC22053ub1.V(interfaceC5766Kt);
        if ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) <= 32 || !interfaceC22053ub1.V(ct4)) && (i & 48) != 32) {
            z = false;
        }
        boolean zV2 = zV | z | interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(enumC12613eu3);
        Object objB = interfaceC22053ub1.B();
        if (zV2 || objB == InterfaceC22053ub1.a.a()) {
            objB = AG6.o(ET4.a(gt4, ct4, new a(gt4, enumC12613eu3, f)), interfaceC10163bB1, interfaceC5766Kt);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC4031Dj7 interfaceC4031Dj7 = (InterfaceC4031Dj7) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC4031Dj7;
    }

    public final InterfaceC24572yq4 b(GT4 gt4, EnumC24286yM4 enumC24286yM4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(877583120, i, -1, "androidx.compose.foundation.pager.PagerDefaults.pageNestedScrollConnection (Pager.kt:432)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(gt4)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(enumC24286yM4)) || (i & 48) == 32);
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new FE1(gt4, enumC24286yM4);
            interfaceC22053ub1.s(objB);
        }
        FE1 fe1 = (FE1) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return fe1;
    }
}
