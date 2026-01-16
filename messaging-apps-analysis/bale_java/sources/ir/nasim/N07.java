package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.C24254yJ;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public abstract class N07 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ String b;
        final /* synthetic */ EV4 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC19114po0 e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ boolean h;

        a(boolean z, String str, EV4 ev4, SA2 sa2, InterfaceC19114po0 interfaceC19114po0, String str2, String str3, boolean z2) {
            this.a = z;
            this.b = str;
            this.c = ev4;
            this.d = sa2;
            this.e = interfaceC19114po0;
            this.f = str2;
            this.g = str3;
            this.h = z2;
        }

        public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            e.a aVar;
            int i2;
            int i3;
            AbstractC13042fc3.i(zy0, "$this$Card");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(209219437);
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
            if (this.a) {
                eVarH = androidx.compose.foundation.layout.q.k(eVarH, 0.0f, G10.a.c(interfaceC22053ub1, 6).b().u(), 1, null);
            }
            interfaceC22053ub1.Q();
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.f fVarB = c24254yJ.b();
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar3.i();
            String str = this.b;
            EV4 ev4 = this.c;
            SA2 sa2 = this.d;
            InterfaceC19114po0 interfaceC19114po0 = this.e;
            String str2 = this.f;
            String str3 = this.g;
            boolean z = this.h;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarB, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            M66 m66 = M66.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.e(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
            SA2 sa2A2 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            G10 g10 = G10.a;
            TU.m(ev4, new UU(false, null, null, null, str, 0, false, WKSRecord.Service.SUNRPC, null), androidx.compose.foundation.layout.q.i(aVar2, g10.c(interfaceC22053ub1, 6).b().b()), g10.c(interfaceC22053ub1, 6).b().p(), 0.0f, 0.0f, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, 0.0f, g10.c(interfaceC22053ub1, 6).b().u(), g10.c(interfaceC22053ub1, 6).b().b(), g10.c(interfaceC22053ub1, 6).b().u(), 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar3.i(), interfaceC22053ub1, 48);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            SA2 sa2A3 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar4.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
            androidx.compose.ui.e eVarB = L66.b(m66, aVar2, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar3.k(), interfaceC22053ub1, 0);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
            SA2 sa2A4 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar4.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar4.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B3 = J66.b(c24254yJ.g(), aVar3.i(), interfaceC22053ub1, 48);
            int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH2);
            SA2 sa2A5 = aVar4.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A5);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A5, interfaceC10970cW3B3, aVar4.e());
            DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B5 = aVar4.b();
            if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
            }
            DG7.c(interfaceC22053ub1A5, eVarE5, aVar4.f());
            AbstractC24077y03.b(FV4.c(AbstractC24188yB5.bot, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.m(aVar2, g10.c(interfaceC22053ub1, 6).b().h()), g10.a(interfaceC22053ub1, 6).F(), interfaceC22053ub1, 48, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, 6).b().n()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarA = m66.a(aVar2, 1.0f, false);
            AbstractC23365wn7.a aVar5 = AbstractC23365wn7.a;
            int iB = aVar5.b();
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, 6).a();
            C6399Nk7.a aVar6 = C6399Nk7.b;
            AbstractC9339Zm7.b(str, eVarA, g10.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(aVar6.f()), 0L, iB, false, 1, 0, null, c9348Zn7A, interfaceC22053ub1, 0, 3120, 54776);
            interfaceC22053ub1.W(-347766614);
            if (z) {
                i3 = 6;
                aVar = aVar2;
                i2 = 0;
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, 6).b().n()), interfaceC22053ub1, 0);
                AbstractC11456d23.b(FV4.c(AbstractC24188yB5.blue_tick, interfaceC22053ub1, 0), UY6.c(UD5.core_ui_verified_badge, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.m(aVar, g10.c(interfaceC22053ub1, 6).b().f()), null, null, 0.0f, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            } else {
                aVar = aVar2;
                i2 = 0;
                i3 = 6;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i3).b().r()), interfaceC22053ub1, i2);
            androidx.compose.ui.e eVarH3 = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            e.a aVar7 = aVar;
            AbstractC9339Zm7.b(str3 == null ? "" : str3, eVarH3, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, C6399Nk7.h(aVar6.f()), 0L, aVar5.b(), false, 1, 0, null, g10.d(interfaceC22053ub1, i3).c(), interfaceC22053ub1, 48, 3120, 54776);
            interfaceC22053ub1.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar7, g10.c(interfaceC22053ub1, 6).b().u()), interfaceC22053ub1, 0);
            AbstractC17932no0.Q(sa2, interfaceC19114po0, str2, androidx.compose.foundation.layout.t.G(aVar7, null, true, 1, null), null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 16);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(androidx.compose.ui.e r32, final ir.nasim.EV4 r33, final java.lang.String r34, final java.lang.String r35, final ir.nasim.InterfaceC19114po0 r36, final java.lang.String r37, final boolean r38, boolean r39, ir.nasim.SA2 r40, ir.nasim.SA2 r41, ir.nasim.InterfaceC22053ub1 r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.N07.e(androidx.compose.ui.e, ir.nasim.EV4, java.lang.String, java.lang.String, ir.nasim.po0, java.lang.String, boolean, boolean, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.compose.ui.e eVar, EV4 ev4, String str, String str2, InterfaceC19114po0 interfaceC19114po0, String str3, boolean z, boolean z2, SA2 sa2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ev4, "$avatarPainter");
        AbstractC13042fc3.i(str, "$name");
        AbstractC13042fc3.i(interfaceC19114po0, "$buttonStates");
        AbstractC13042fc3.i(str3, "$buttonText");
        e(eVar, ev4, str, str2, interfaceC19114po0, str3, z, z2, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void i(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(658558407);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, X91.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.J07
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return N07.j(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        i(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
