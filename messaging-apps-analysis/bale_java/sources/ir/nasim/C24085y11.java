package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.C24085y11;

/* renamed from: ir.nasim.y11, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24085y11 {
    public static final C24085y11 a = new C24085y11();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(-784381590, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(627322795, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-1621017923, false, c.a);

    /* renamed from: ir.nasim.y11$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(ED5.add_contact, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).G(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65530);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.y11$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.b(FV4.c(AbstractC24188yB5.arrow_left, interfaceC22053ub1, 0), UY6.c(UD5.bale_toolbar_navigation_back_icon_content_description, interfaceC22053ub1, 0), AbstractC18394ob1.d(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), false, 1, null), g10.a(interfaceC22053ub1, i2).G(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.y11$c */
    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(G8 g8) {
            AbstractC13042fc3.i(g8, "it");
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
            I8 i8 = new I8(null, null, null, null, false, 31, null);
            interfaceC22053ub1.W(1443559121);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.z11
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C24085y11.c.c((G8) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC24153y8.e(c8588Wp4E, i8, (UA2) objB, interfaceC22053ub1, 384);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC14603iB2 c() {
        return d;
    }
}
