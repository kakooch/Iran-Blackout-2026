package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.i71, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14563i71 {
    public static final C14563i71 a = new C14563i71();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1495726580, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(2023120630, false, b.a);

    /* renamed from: ir.nasim.i71$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.v0(UY6.c(LD5.passport_creation_success_dialog_title, interfaceC22053ub1, 0), null, FV4.c(KB5.ic_success_dialog, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).I(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.i71$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(LD5.passport_creation_success_dialog_description, interfaceC22053ub1, 0);
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

    public final InterfaceC14603iB2 b() {
        return c;
    }
}
