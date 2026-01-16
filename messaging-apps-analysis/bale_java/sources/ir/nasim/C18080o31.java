package ir.nasim;

import androidx.compose.ui.e;

/* renamed from: ir.nasim.o31, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18080o31 {
    public static final C18080o31 a = new C18080o31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(681295796, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(1352507091, false, b.a);

    /* renamed from: ir.nasim.o31$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(AbstractC24206yD5.settings_lang, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65018);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o31$b */
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
            AbstractC24077y03.b(FV4.c(IB5.arrow_left, interfaceC22053ub1, 0), UY6.c(AbstractC24206yD5.submit_return, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).D(), interfaceC22053ub1, 0, 0);
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
