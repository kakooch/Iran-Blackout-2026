package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.e71, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12147e71 {
    public static final C12147e71 a = new C12147e71();
    public static InterfaceC15796kB2 b = AbstractC19242q11.c(1193672037, false, a.a);

    /* renamed from: ir.nasim.e71$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarB = InterfaceC6988Pv3.b(interfaceC6988Pv3, aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            String strC = UY6.c(AbstractC12217eE5.contacts_search_empty_list_title, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            AbstractC9105Ym7.b(strC, androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i3).b().c()), g10.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).a(), interfaceC22053ub1, 0, 0, 65528);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public final InterfaceC15796kB2 a() {
        return b;
    }
}
