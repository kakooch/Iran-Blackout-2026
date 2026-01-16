package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.h31, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C13925h31 {
    public static final C13925h31 a = new C13925h31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(833275103, false, a.a);

    /* renamed from: ir.nasim.h31$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.v0(UY6.c(AbstractC24800zD5.password_changed_successfully, interfaceC22053ub1, 0), null, FV4.c(JB5.tick_done, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).L(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
            }
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
}
