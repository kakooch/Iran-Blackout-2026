package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.m31, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C16898m31 {
    public static final C16898m31 a = new C16898m31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(2087423781, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(147501073, false, b.a);
    public static InterfaceC15796kB2 d = AbstractC19242q11.c(-1141016969, false, c.a);

    /* renamed from: ir.nasim.m31$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC24077y03.b(FV4.c(IB5.arrow_left, interfaceC22053ub1, 0), UY6.c(AbstractC24206yD5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).D(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.m31$b */
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
            AbstractC24077y03.b(FV4.c(IB5.search, interfaceC22053ub1, 0), UY6.c(AbstractC24206yD5.search_hint_chat, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).D(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.m31$c */
    static final class c implements InterfaceC15796kB2 {
        public static final c a = new c();

        c() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, G10.a.a(interfaceC22053ub1, G10.b).A(), interfaceC22053ub1, 6, 2);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC14603iB2 a() {
        return b;
    }

    public final InterfaceC14603iB2 b() {
        return c;
    }

    public final InterfaceC15796kB2 c() {
        return d;
    }
}
