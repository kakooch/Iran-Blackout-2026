package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.ik0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14938ik0 {
    private static final float a = C17784nZ1.q(16);
    private static final float b = C17784nZ1.q(56);
    private static final float c = C17784nZ1.q(125);

    /* renamed from: ir.nasim.ik0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(EnumC18483ok0 enumC18483ok0) {
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.ik0$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ EnumC18483ok0 e;
        final /* synthetic */ WH1 f;
        final /* synthetic */ InterfaceC5766Kt g;
        final /* synthetic */ UA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC18483ok0 enumC18483ok0, WH1 wh1, InterfaceC5766Kt interfaceC5766Kt, UA2 ua2) {
            super(0);
            this.e = enumC18483ok0;
            this.f = wh1;
            this.g = interfaceC5766Kt;
            this.h = ua2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C16119kk0 invoke() {
            return new C16119kk0(this.e, this.f, this.g, this.h);
        }
    }

    public static final C15528jk0 c(C16119kk0 c16119kk0, C19982rG6 c19982rG6, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 1) != 0) {
            c16119kk0 = d(EnumC18483ok0.a, null, null, interfaceC22053ub1, 6, 6);
        }
        if ((i2 & 2) != 0) {
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C19982rG6();
                interfaceC22053ub1.s(objB);
            }
            c19982rG6 = (C19982rG6) objB;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1022285988, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:266)");
        }
        boolean z = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(c16119kk0)) || (i & 6) == 4) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(c19982rG6)) || (i & 48) == 32);
        Object objB2 = interfaceC22053ub1.B();
        if (z || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new C15528jk0(c16119kk0, c19982rG6);
            interfaceC22053ub1.s(objB2);
        }
        C15528jk0 c15528jk0 = (C15528jk0) objB2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c15528jk0;
    }

    public static final C16119kk0 d(EnumC18483ok0 enumC18483ok0, InterfaceC5766Kt interfaceC5766Kt, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            interfaceC5766Kt = C14328hk0.a.a();
        }
        if ((i2 & 4) != 0) {
            ua2 = a.e;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:224)");
        }
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        Object[] objArr = {interfaceC5766Kt};
        InterfaceC8230Vb6 interfaceC8230Vb6A = C16119kk0.b.a(interfaceC5766Kt, ua2, wh1);
        boolean zV = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(enumC18483ok0)) || (i & 6) == 4) | interfaceC22053ub1.V(wh1) | interfaceC22053ub1.D(interfaceC5766Kt) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.V(ua2)) || (i & 384) == 256);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new b(enumC18483ok0, wh1, interfaceC5766Kt, ua2);
            interfaceC22053ub1.s(objB);
        }
        C16119kk0 c16119kk0 = (C16119kk0) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c16119kk0;
    }
}
