package ir.nasim;

import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC16030kb1;

/* loaded from: classes6.dex */
public final class X21 {
    public static final X21 a = new X21();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-1494243230, false, a.a);

    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$Card");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar, 0.0f, C17784nZ1.q(8), 0.0f, 0.0f, 13, null), C17784nZ1.q(50)), N46.g()), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.v(androidx.compose.foundation.layout.q.m(aVar, 0.0f, C17784nZ1.q(12), 0.0f, 0.0f, 13, null), C17784nZ1.q(72), C17784nZ1.q(20)), N46.d(C17784nZ1.q(10))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
