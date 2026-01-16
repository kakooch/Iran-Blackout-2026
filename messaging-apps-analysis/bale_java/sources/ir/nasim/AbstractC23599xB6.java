package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.xB6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23599xB6 {

    /* renamed from: ir.nasim.xB6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(2);
            this.e = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(419974943, i, -1, "com.airbnb.android.showkase.ui.ShowkaseErrorScreen.<anonymous>.<anonymous> (ShowkaseErrorScreen.kt:17)");
            }
            AbstractC9105Ym7.b(this.e, androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, IT1.a()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 48, 0, 131068);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.xB6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ String e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, int i) {
            super(2);
            this.e = str;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC23599xB6.a(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(String str, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "errorText");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(594388046);
        if ((i & 14) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(594388046, i2, -1, "com.airbnb.android.showkase.ui.ShowkaseErrorScreen (ShowkaseErrorScreen.kt:12)");
            }
            C24254yJ.f fVarB = C24254yJ.a.b();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.layout.t.d(aVar, 0.0f, 1, null);
            interfaceC22053ub1J.A(-483455358);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, InterfaceC12529em.a.k(), interfaceC22053ub1J, 6);
            interfaceC22053ub1J.A(-1323940314);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            InterfaceC15796kB2 interfaceC15796kB2D = AbstractC19768qu3.d(eVarD);
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC15796kB2D.q(C12827fE6.a(C12827fE6.b(interfaceC22053ub1J)), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.A(2058660585);
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC21194tG6.c(androidx.compose.foundation.layout.q.i(aVar, IT1.c()), null, false, null, 0L, 0L, 0.0f, AbstractC19242q11.b(interfaceC22053ub1J, 419974943, true, new a(str)), interfaceC22053ub1J, 12582918, 126);
            interfaceC22053ub12.U();
            interfaceC22053ub12.u();
            interfaceC22053ub12.U();
            interfaceC22053ub12.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(str, i));
        }
    }
}
