package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.S9;

/* loaded from: classes4.dex */
public abstract class S9 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC9102Ym4 c;

        a(UA2 ua2, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = ua2;
            this.b = sa2;
            this.c = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(ua2, "$setSeenAddMemberShowInChat");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isAddMemberEnabled$delegate");
            S9.d(interfaceC9102Ym4, false);
            ua2.invoke(Boolean.FALSE);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$showAddMemberFragment");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1, i2).w(), null, 2, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar2.g();
            final UA2 ua2 = this.a;
            final SA2 sa2 = this.b;
            final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i2).b().u()), interfaceC22053ub1, 0);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            M66 m66 = M66.a;
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1, i2).b().r()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().m());
            interfaceC22053ub1.W(1054457830);
            boolean zV = interfaceC22053ub1.V(ua2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Q9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S9.a.d(ua2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.e(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
            SA2 sa2A3 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A3);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC24077y03.b(FV4.c(AbstractC15208jB5.close, interfaceC22053ub1, 0), UY6.c(DD5.dialog_negative_button_cancel, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 0, 4);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            interfaceC22053ub1.W(1054482730);
            Object objB2 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB2 == aVar4.a()) {
                objB2 = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1054486689);
            boolean zV2 = interfaceC22053ub1.V(sa2);
            Object objB3 = interfaceC22053ub1.B();
            if (zV2 || objB3 == aVar4.a()) {
                objB3 = new SA2() { // from class: ir.nasim.R9
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return S9.a.f(sa2);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.e.d(eVarB, interfaceC18507om4, null, false, null, null, (SA2) objB3, 28, null);
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.b(), aVar2.i(), interfaceC22053ub1, 54);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD2);
            SA2 sa2A4 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A4);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3B2, aVar3.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar3.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar3.f());
            AbstractC24077y03.b(FV4.c(AbstractC15208jB5.add_user, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).I(), interfaceC22053ub1, 48, 0);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1, i2).b().u()), interfaceC22053ub1, 0);
            AbstractC9339Zm7.b(UY6.c(DD5.group_add_title, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i2).I(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).o(), interfaceC22053ub1, 0, 0, 65530);
            interfaceC22053ub1.u();
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(42.0f)), interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i2).b().u()), interfaceC22053ub1, 0);
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1.0f)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final boolean z, final UA2 ua2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(ua2, "setSeenAddMemberShowInChat");
        AbstractC13042fc3.i(sa2, "showAddMemberFragment");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-308424456);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            interfaceC22053ub1J.W(-1031186344);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC13472gH6.d(Boolean.valueOf(z), null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            if (c(interfaceC9102Ym4)) {
                M10.f(false, AbstractC19242q11.e(-1868608456, true, new a(ua2, sa2, interfaceC9102Ym4), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.P9
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return S9.e(z, ua2, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean c(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(boolean z, UA2 ua2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ua2, "$setSeenAddMemberShowInChat");
        AbstractC13042fc3.i(sa2, "$showAddMemberFragment");
        b(z, ua2, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
