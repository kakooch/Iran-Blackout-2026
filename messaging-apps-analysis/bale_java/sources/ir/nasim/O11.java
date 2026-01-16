package ir.nasim;

import ir.nasim.AbstractC24975zX0;

/* loaded from: classes6.dex */
public final class O11 {
    public static final O11 a = new O11();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-917589055, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(2008917631, false, b.a);

    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11456d23.a(XQ7.b(C12700f33.k, AbstractC19936rB5.ba_dialog_info, interfaceC22053ub1, 6), null, null, null, null, 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, G10.a.a(interfaceC22053ub1, G10.b).B(), 0, 2, null), interfaceC22053ub1, 48, 60);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC19555qZ.c0(LD5.app_update_required_dialog_message, interfaceC22053ub1, 0);
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
