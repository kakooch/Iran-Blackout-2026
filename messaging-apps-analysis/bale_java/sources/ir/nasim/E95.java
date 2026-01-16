package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC6747Ou5;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.W23;

/* loaded from: classes4.dex */
public abstract class E95 {
    public static final void e(final AbstractC6747Ou5 abstractC6747Ou5, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        androidx.compose.foundation.layout.h hVar;
        e.a aVar;
        AbstractC13042fc3.i(abstractC6747Ou5, "profile");
        AbstractC13042fc3.i(sa2, "onPickPhoto");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1446957830);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(abstractC6747Ou5) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final String strC = UY6.c(AbstractC12217eE5.settings_profile_picker_desc, interfaceC22053ub1J, 0);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(76));
            interfaceC22053ub1J.W(589304001);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
            if (objB == aVar3.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(589305767);
            int i3 = i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            boolean z = i3 == 32;
            Object objB2 = interfaceC22053ub1J.B();
            if (z || objB2 == aVar3.a()) {
                objB2 = new SA2() { // from class: ir.nasim.A95
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return E95.g(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(eVarT, interfaceC18507om4, null, false, null, null, (SA2) objB2, 28, null);
            interfaceC22053ub1J.W(589308150);
            boolean zV = (i3 == 32) | interfaceC22053ub1J.V(strC);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV || objB3 == aVar3.a()) {
                objB3 = new UA2() { // from class: ir.nasim.B95
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return E95.h(strC, sa2, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD2 = AbstractC6919Pn6.d(eVarD, false, (UA2) objB3, 1, null);
            InterfaceC12529em.a aVar4 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar4.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD2);
            InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar5.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar5.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar5.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar5.f());
            androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
            if (abstractC6747Ou5 instanceof AbstractC6747Ou5.b) {
                interfaceC22053ub1J.W(73208337);
                androidx.compose.ui.e eVarH = hVar2.h(androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(72)), aVar4.n());
                G10 g10 = G10.a;
                int i4 = G10.b;
                androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(eVarH, g10.a(interfaceC22053ub1J, i4).C(), N46.g());
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar4.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
                SA2 sa2A2 = aVar5.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A2);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar5.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar5.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar5.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar5.f());
                AbstractC24077y03.b(FV4.c(KB5.bold_profile, interfaceC22053ub1J, 0), null, hVar2.h(androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(38)), aVar4.e()), g10.a(interfaceC22053ub1J, i4).G(), interfaceC22053ub1J, 48, 0);
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
                hVar = hVar2;
                aVar = aVar2;
            } else if (abstractC6747Ou5 instanceof AbstractC6747Ou5.a) {
                interfaceC22053ub1J.W(1942044867);
                String strA = ((AbstractC6747Ou5.a) abstractC6747Ou5).a();
                if (strA == null) {
                    hVar = hVar2;
                    aVar = aVar2;
                } else {
                    hVar = hVar2;
                    aVar = aVar2;
                    coil.compose.d.a(new W23.a((Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g())).d(strA).c(true).a(), null, FV0.a(hVar2.h(androidx.compose.foundation.layout.t.t(aVar2, C17784nZ1.q(72)), aVar4.n()), N46.g()), null, null, null, InterfaceC13157fl1.a.a(), 0.0f, null, 0, false, null, interfaceC22053ub1J, 1572912, 0, 4024);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                interfaceC22053ub1J.Q();
            } else {
                hVar = hVar2;
                aVar = aVar2;
                interfaceC22053ub1J.W(74381129);
                interfaceC22053ub1J.Q();
            }
            androidx.compose.foundation.layout.h hVar3 = hVar;
            e.a aVar6 = aVar;
            androidx.compose.ui.e eVarH2 = hVar3.h(aVar6, aVar4.d());
            G10 g102 = G10.a;
            int i5 = G10.b;
            float f = (float) 1.5d;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(AbstractC9287Zh0.f(eVarH2, C17784nZ1.q(f), g102.a(interfaceC22053ub1J, i5).r(), N46.b(50)), C17784nZ1.q(f));
            InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(aVar4.e(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            SA2 sa2A3 = aVar5.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G3, aVar5.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
            AbstractC24077y03.b(FV4.c(KB5.add_photo, interfaceC22053ub1J, 0), null, hVar3.h(androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.b.c(aVar6, g102.a(interfaceC22053ub1J, i5).I(), N46.g()), g102.c(interfaceC22053ub1J, i5).b().k()), g102.c(interfaceC22053ub1J, i5).b().r()), aVar4.e()), g102.a(interfaceC22053ub1J, i5).G(), interfaceC22053ub1J, 48, 0);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.C95
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return E95.f(abstractC6747Ou5, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(AbstractC6747Ou5 abstractC6747Ou5, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(abstractC6747Ou5, "$profile");
        AbstractC13042fc3.i(sa2, "$onPickPhoto");
        e(abstractC6747Ou5, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onPickPhoto");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(String str, final SA2 sa2, InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(str, "$contentDescriptionPhotoPicker");
        AbstractC13042fc3.i(sa2, "$onPickPhoto");
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        AbstractC9939ao6.e0(interfaceC11943do6, str);
        AbstractC9939ao6.p0(interfaceC11943do6, B26.b.a());
        AbstractC9939ao6.B(interfaceC11943do6, null, new SA2() { // from class: ir.nasim.D95
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(E95.i(sa2));
            }
        }, 1, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onPickPhoto");
        sa2.invoke();
        return true;
    }
}
