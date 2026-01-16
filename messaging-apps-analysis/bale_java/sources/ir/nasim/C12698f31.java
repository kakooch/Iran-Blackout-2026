package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.f31, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12698f31 {
    public static final C12698f31 a = new C12698f31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-1606399194, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(672725195, false, b.a);

    /* renamed from: ir.nasim.f31$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC24667z03.b(FV4.c(KB5.ic_change_camera_new, interfaceC22053ub1, 0), UY6.c(BD5.content_description_switch_camera, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 4);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.f31$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC24667z03.b(FV4.c(KB5.ic_action_navigation_arrow_back, interfaceC22053ub1, 0), UY6.c(BD5.content_description_back, interfaceC22053ub1, 0), null, C24381yX0.b.i(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 4);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }
}
