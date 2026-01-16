package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.NK3;

/* renamed from: ir.nasim.c31, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10700c31 {
    public static final C10700c31 a = new C10700c31();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1548771145, false, a.a);
    public static InterfaceC14603iB2 c = AbstractC19242q11.c(-1392831687, false, b.a);

    /* renamed from: ir.nasim.c31$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.c31$b */
    static final class b implements InterfaceC14603iB2 {
        public static final b a = new b();

        b() {
        }

        private static final C23677xK3 b(LK3 lk3) {
            return (C23677xK3) lk3.getValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            LK3 lk3R = WM5.r(NK3.b.a(NK3.b.b(AbstractC19954rD5.animated_recording)), null, null, null, null, null, interfaceC22053ub1, 0, 62);
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarE = androidx.compose.foundation.layout.t.E(androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, 0.0f, g10.c(interfaceC22053ub1, i2).b().b(), 7, null), null, false, 3, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarE);
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
            DG7.c(interfaceC22053ub1A, eVarE2, aVar2.f());
            M66 m66 = M66.a;
            AbstractC15878kK3.a(b(lk3R), androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(30)), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, interfaceC22053ub1, 1572912, 0, 0, 4194236);
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.call_recording, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1, i2).b().b(), 0.0f, 11, null), g10.a(interfaceC22053ub1, i2).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).n(), interfaceC22053ub1, 0, 0, 65528);
            interfaceC22053ub1.u();
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
