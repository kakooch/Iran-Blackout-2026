package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.pz6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC19227pz6 {
    private static final float a = C17784nZ1.q(22);
    private static final InterfaceC5766Kt b = AbstractC5999Lt.l(300, 0, T22.d(), 2, null);

    /* renamed from: ir.nasim.pz6$a */
    public static final class a implements InterfaceC24572yq4 {
        final /* synthetic */ C19818qz6 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ EnumC24286yM4 c;

        a(C19818qz6 c19818qz6, UA2 ua2, EnumC24286yM4 enumC24286yM4) {
            this.a = c19818qz6;
            this.b = ua2;
            this.c = enumC24286yM4;
        }

        private final float a(long j) {
            return this.c == EnumC24286yM4.b ? ZG4.m(j) : ZG4.n(j);
        }

        private final long b(float f) {
            EnumC24286yM4 enumC24286yM4 = this.c;
            float f2 = enumC24286yM4 == EnumC24286yM4.b ? f : 0.0f;
            if (enumC24286yM4 != EnumC24286yM4.a) {
                f = 0.0f;
            }
            return AbstractC10836cH4.a(f2, f);
        }

        private final float c(long j) {
            return this.c == EnumC24286yM4.b ? C17718nR7.h(j) : C17718nR7.i(j);
        }

        @Override // ir.nasim.InterfaceC24572yq4
        public long H0(long j, long j2, int i) {
            return AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.c()) ? b(this.a.d().n(a(j2))) : ZG4.b.c();
        }

        @Override // ir.nasim.InterfaceC24572yq4
        public Object i0(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            this.b.invoke(AbstractC6392Nk0.c(c(j2)));
            return C17718nR7.b(j2);
        }

        @Override // ir.nasim.InterfaceC24572yq4
        public long s1(long j, int i) {
            float fA = a(j);
            return (fA >= 0.0f || !AbstractC4559Fq4.e(i, AbstractC4559Fq4.a.c())) ? ZG4.b.c() : b(this.a.d().n(fA));
        }

        @Override // ir.nasim.InterfaceC24572yq4
        public Object w0(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            float fC = c(j);
            float fM = this.a.m();
            float fD = this.a.d().o().d();
            if (fC >= 0.0f || fM <= fD) {
                j = C17718nR7.b.a();
            } else {
                this.b.invoke(AbstractC6392Nk0.c(fC));
            }
            return C17718nR7.b(j);
        }
    }

    /* renamed from: ir.nasim.pz6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(EnumC20427rz6 enumC20427rz6) {
            return Boolean.TRUE;
        }
    }

    /* renamed from: ir.nasim.pz6$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ WH1 f;
        final /* synthetic */ EnumC20427rz6 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, WH1 wh1, EnumC20427rz6 enumC20427rz6, UA2 ua2, boolean z2) {
            super(0);
            this.e = z;
            this.f = wh1;
            this.g = enumC20427rz6;
            this.h = ua2;
            this.i = z2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C19818qz6 invoke() {
            return new C19818qz6(this.e, this.f, this.g, this.h, this.i);
        }
    }

    public static final InterfaceC24572yq4 a(C19818qz6 c19818qz6, EnumC24286yM4 enumC24286yM4, UA2 ua2) {
        return new a(c19818qz6, ua2, enumC24286yM4);
    }

    public static final C19818qz6 d(boolean z, UA2 ua2, EnumC20427rz6 enumC20427rz6, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        boolean z3 = (i2 & 1) != 0 ? false : z;
        UA2 ua22 = (i2 & 2) != 0 ? b.e : ua2;
        EnumC20427rz6 enumC20427rz62 = (i2 & 4) != 0 ? EnumC20427rz6.Hidden : enumC20427rz6;
        boolean z4 = (i2 & 8) != 0 ? false : z2;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1032784200, i, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:407)");
        }
        WH1 wh1 = (WH1) interfaceC22053ub1.H(AbstractC13040fc1.g());
        Object[] objArr = {Boolean.valueOf(z3), ua22, Boolean.valueOf(z4)};
        InterfaceC8230Vb6 interfaceC8230Vb6A = C19818qz6.d.a(z3, ua22, wh1, z4);
        boolean zV = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.a(z3)) || (i & 6) == 4) | interfaceC22053ub1.V(wh1) | ((((i & 896) ^ 384) > 256 && interfaceC22053ub1.V(enumC20427rz62)) || (i & 384) == 256) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(ua22)) || (i & 48) == 32) | ((((i & 7168) ^ SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) > 2048 && interfaceC22053ub1.a(z4)) || (i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 2048);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new c(z3, wh1, enumC20427rz62, ua22, z4);
            interfaceC22053ub1.s(objB);
        }
        C19818qz6 c19818qz6 = (C19818qz6) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1, 0, 4);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c19818qz6;
    }
}
