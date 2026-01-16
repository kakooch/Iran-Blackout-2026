package ir.nasim;

import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.InterfaceC16030kb1;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.Ga1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4661Ga1 {
    public static final C4661Ga1 a = new C4661Ga1();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(-333061095, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(1985498926, false, b.a);

    /* renamed from: ir.nasim.Ga1$a */
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
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.v(aVar, C17784nZ1.q(286), C17784nZ1.q(56)), C17784nZ1.q(12), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.e(), InterfaceC12529em.a.i(), interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            float f = 10;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.v(aVar, C17784nZ1.q(Type.EUI48), C17784nZ1.q(24)), N46.d(C17784nZ1.q(f))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.v(aVar, C17784nZ1.q(80), C17784nZ1.q(16)), N46.d(C17784nZ1.q(f))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ga1$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC10081b28.o(new QJ2(false, null, false, 6, null), null, null, null, null, interfaceC22053ub1, 6, 30);
            }
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
}
