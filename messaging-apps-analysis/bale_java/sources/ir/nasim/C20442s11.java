package ir.nasim;

import ir.nasim.C20442s11;

/* renamed from: ir.nasim.s11, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20442s11 {
    public static final C20442s11 a = new C20442s11();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-625342199, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1038480175, false, b.a);
    public static InterfaceC14603iB2 d = AbstractC19242q11.c(-1431237844, false, c.a);
    public static InterfaceC14603iB2 e = AbstractC19242q11.c(-1743049075, false, d.a);

    /* renamed from: ir.nasim.s11$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(InterfaceC15254jG6 interfaceC15254jG6, boolean z) {
            AbstractC13042fc3.i(interfaceC15254jG6, "$snackBar");
            interfaceC15254jG6.dismiss();
            return C19938rB7.a;
        }

        public final void b(final InterfaceC15254jG6 interfaceC15254jG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC15254jG6, "snackBar");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(interfaceC15254jG6) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strB = interfaceC15254jG6.a().b();
            interfaceC22053ub1.W(26376540);
            boolean z = (i & 14) == 4;
            Object objB = interfaceC22053ub1.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.r11
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20442s11.a.c(interfaceC15254jG6, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10984cY.c(strB, null, null, 0, (UA2) objB, interfaceC22053ub1, 0, 14);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC15254jG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s11$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(AbstractC19861r4.I0(), interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), G10.a.a(interfaceC22053ub1, G10.b).B(), interfaceC22053ub1, 432, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s11$c */
    static final class c implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC24077y03.b(FV4.c(AbstractC21822uB5.arrow_left, interfaceC22053ub1, 0), UY6.c(QD5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), G10.a.b(interfaceC22053ub1, G10.b).i(), interfaceC22053ub1, 384, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.s11$d */
    static final class d implements InterfaceC14603iB2 {
        public static final d a = new d();

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC24077y03.b(FV4.c(AbstractC21822uB5.more_menu, interfaceC22053ub1, 0), UY6.c(QD5.account_info_more_menu_content_description, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, C17784nZ1.q(24)), G10.a.b(interfaceC22053ub1, G10.b).i(), interfaceC22053ub1, 384, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC14603iB2 c() {
        return d;
    }

    public final InterfaceC14603iB2 d() {
        return e;
    }
}
