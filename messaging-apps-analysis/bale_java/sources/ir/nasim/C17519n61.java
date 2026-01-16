package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC4027Dj3;

/* renamed from: ir.nasim.n61, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17519n61 {
    public static final C17519n61 a = new C17519n61();
    public static InterfaceC14603iB2 b = AbstractC19242q11.c(1035678102, false, a.a);

    /* renamed from: ir.nasim.n61$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar.g();
            C24254yJ.m mVarQ = C24254yJ.a.q(C17784nZ1.q(4), aVar.i());
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarQ, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC3559Bj3.e(new InterfaceC4027Dj3.c(null, null, null, 7, null), false, interfaceC22053ub1, 0, 2);
            AbstractC3559Bj3.e(new InterfaceC4027Dj3.b(null, null, 3, null), false, interfaceC22053ub1, 0, 2);
            AbstractC3559Bj3.e(new InterfaceC4027Dj3.a(null, 0, null, 7, null), false, interfaceC22053ub1, 0, 2);
            AbstractC3559Bj3.e(new InterfaceC4027Dj3.c(null, null, null, 7, null), true, interfaceC22053ub1, 48, 0);
            AbstractC3559Bj3.e(new InterfaceC4027Dj3.b(null, null, 3, null), true, interfaceC22053ub1, 48, 0);
            AbstractC3559Bj3.e(new InterfaceC4027Dj3.a(null, 0, null, 7, null), true, interfaceC22053ub1, 48, 0);
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
}
