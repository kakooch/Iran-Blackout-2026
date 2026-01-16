package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* renamed from: ir.nasim.g71, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13374g71 {
    public static final C13374g71 a = new C13374g71();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-66202666, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-68037032, false, b.a);

    /* renamed from: ir.nasim.g71$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.v0(UY6.c(AbstractC12217eE5.title_remove_custom_tag, interfaceC22053ub1, 0), null, FV4.c(KB5.alert, interfaceC22053ub1, 0), null, G10.a.a(interfaceC22053ub1, G10.b).t(), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.g71$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(AbstractC12217eE5.description_remove_custom_tag, interfaceC22053ub1, 0);
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
