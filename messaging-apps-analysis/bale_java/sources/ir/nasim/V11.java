package ir.nasim;

import androidx.compose.ui.e;

/* loaded from: classes5.dex */
public final class V11 {
    public static final V11 a = new V11();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(1387222255, false, a.a);

    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(l66, "$this$Button");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(l66) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            AbstractC24077y03.b(FV4.c(KB5.call_bar_default_icon, interfaceC22053ub1, 0), "avatar", l66.c(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar, 0.0f, C17784nZ1.q(1), C17784nZ1.q(8), 0.0f, 9, null), C17784nZ1.q(16)), InterfaceC12529em.a.i()), WX0.a(TA5.color3, interfaceC22053ub1, 0), interfaceC22053ub1, 48, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.call_bar_join, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, 0.0f, C17784nZ1.q(2), 7, null), WX0.a(TA5.color3_2, interfaceC22053ub1, 0), AbstractC13784go7.g(14), null, null, M10.p(), 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 3120, 0, 130992);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
