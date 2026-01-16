package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.C5;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.X03;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public abstract class C5 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e a;
        final /* synthetic */ InterfaceC10031ax6 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ X03.a e;
        final /* synthetic */ UA2 f;

        a(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, SA2 sa2, SA2 sa22, X03.a aVar, UA2 ua2) {
            this.a = eVar;
            this.b = interfaceC10031ax6;
            this.c = sa2;
            this.d = sa22;
            this.e = aVar;
            this.f = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onBannerClick");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(UA2 ua2, X03.a aVar) {
            AbstractC13042fc3.i(ua2, "$callback");
            AbstractC13042fc3.i(aVar, "$contentType");
            ua2.invoke(aVar);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onBannerClick");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v51, types: [androidx.compose.ui.e] */
        /* JADX WARN: Type inference failed for: r52v0, types: [ir.nasim.ub1] */
        public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            e.a aVar;
            G10 g10;
            int i2;
            int i3;
            final X03.a aVar2;
            e.a aVarF;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarA = FV0.a(this.a, this.b);
            G10 g102 = G10.a;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(eVarA, g102.a(interfaceC22053ub1, 6).r(), this.b);
            interfaceC22053ub1.W(1190313277);
            boolean zV = interfaceC22053ub1.V(this.c);
            final SA2 sa2 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.z5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C5.a.f(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarC, false, null, null, (SA2) objB, 7, null);
            InterfaceC10031ax6 interfaceC10031ax6 = this.b;
            final SA2 sa22 = this.c;
            SA2 sa23 = this.d;
            X03.a aVar3 = this.e;
            final UA2 ua2 = this.f;
            InterfaceC12529em.a aVar4 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar4.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
            InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar5.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar5.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar5.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar5.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            e.a aVar6 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = hVar.h(androidx.compose.foundation.b.d(FV0.a(androidx.compose.foundation.layout.t.f(aVar6, 0.0f, 1, null), interfaceC10031ax6), g102.a(interfaceC22053ub1, 6).r(), null, 2, null), aVar4.e());
            interfaceC22053ub1.W(2079475516);
            boolean zV2 = interfaceC22053ub1.V(sa22);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.A5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C5.a.i(sa22);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB2, 7, null), g102.c(interfaceC22053ub1, 6).b().n(), 0.0f, g102.c(interfaceC22053ub1, 6).b().u(), 0.0f, 10, null);
            InterfaceC12529em.c cVarI = aVar4.i();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
            SA2 sa2A2 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar5.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar5.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar5.f());
            M66 m66 = M66.a;
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar4.e(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, aVar6);
            SA2 sa2A3 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar5.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar6, g102.c(interfaceC22053ub1, 6).b().b());
            TU.m(aVar3.a(), new UU(false, null, null, null, aVar3.e(), 0, false, WKSRecord.Service.SUNRPC, null), eVarI, g102.c(interfaceC22053ub1, 6).b().t(), 0.0f, 0.0f, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarB = L66.b(m66, androidx.compose.foundation.layout.q.m(aVar6, g102.c(interfaceC22053ub1, 6).b().u(), 0.0f, g102.c(interfaceC22053ub1, 6).b().a(), 0.0f, 10, null), 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar4.k(), interfaceC22053ub1, 0);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
            SA2 sa2A4 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3A, aVar5.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar5.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar5.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar6, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar4.i(), interfaceC22053ub1, 48);
            int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH2);
            SA2 sa2A5 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A5, interfaceC10970cW3B2, aVar5.e());
            DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B5 = aVar5.b();
            if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
            }
            DG7.c(interfaceC22053ub1A5, eVarE5, aVar5.f());
            AbstractC23365wn7.a aVar7 = AbstractC23365wn7.a;
            int iB = aVar7.b();
            C6399Nk7.a aVar8 = C6399Nk7.b;
            int iF = aVar8.f();
            AbstractC9339Zm7.b(aVar3.e(), aVar6, g102.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, iB, false, 1, 0, null, g102.d(interfaceC22053ub1, 6).m(), interfaceC22053ub1, 48, 3120, 54776);
            interfaceC22053ub1.W(-1381291615);
            if (aVar3.f()) {
                g10 = g102;
                i2 = 6;
                aVar = aVar6;
                i3 = 0;
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, 6).b().n()), interfaceC22053ub1, 0);
                AbstractC11456d23.b(FV4.c(AbstractC24188yB5.blue_tick, interfaceC22053ub1, 0), UY6.c(UD5.core_ui_verified_badge, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.m(aVar, g10.c(interfaceC22053ub1, 6).b().f()), null, null, 0.0f, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            } else {
                aVar = aVar6;
                g10 = g102;
                i2 = 6;
                i3 = 0;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().u()), interfaceC22053ub1, i3);
            androidx.compose.ui.e eVarH3 = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B3 = J66.b(c24254yJ.g(), aVar4.i(), interfaceC22053ub1, 48);
            int iA6 = AbstractC6797Pa1.a(interfaceC22053ub1, i3);
            InterfaceC11819dc1 interfaceC11819dc1Q6 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE6 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH3);
            SA2 sa2A6 = aVar5.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A6);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A6 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A6, interfaceC10970cW3B3, aVar5.e());
            DG7.c(interfaceC22053ub1A6, interfaceC11819dc1Q6, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B6 = aVar5.b();
            if (interfaceC22053ub1A6.h() || !AbstractC13042fc3.d(interfaceC22053ub1A6.B(), Integer.valueOf(iA6))) {
                interfaceC22053ub1A6.s(Integer.valueOf(iA6));
                interfaceC22053ub1A6.v(Integer.valueOf(iA6), interfaceC14603iB2B6);
            }
            DG7.c(interfaceC22053ub1A6, eVarE6, aVar5.f());
            int iB2 = aVar7.b();
            int iF2 = aVar8.f();
            e.a aVar9 = aVar;
            G10 g103 = g10;
            AbstractC9339Zm7.b(aVar3.c(), aVar9, g10.a(interfaceC22053ub1, i2).B(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF2), 0L, iB2, false, 1, 0, null, g10.d(interfaceC22053ub1, i2).c(), interfaceC22053ub1, 48, 3120, 54776);
            ZH6.a(L66.b(m66, aVar9, 1.0f, false, 2, null), interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-1381246750);
            if (ua2 == null) {
                aVar2 = aVar3;
                aVarF = null;
            } else {
                interfaceC22053ub1.W(2142218782);
                aVar2 = aVar3;
                boolean zV3 = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(aVar2);
                Object objB3 = interfaceC22053ub1.B();
                if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.B5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C5.a.h(ua2, aVar2);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                aVarF = androidx.compose.foundation.e.f(aVar9, false, null, null, (SA2) objB3, 7, null);
            }
            interfaceC22053ub1.Q();
            if (aVarF == null) {
                aVarF = aVar9;
            }
            InterfaceC10970cW3 interfaceC10970cW3B4 = J66.b(c24254yJ.b(), aVar4.i(), interfaceC22053ub1, 54);
            int iA7 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q7 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE7 = androidx.compose.ui.c.e(interfaceC22053ub1, aVarF);
            SA2 sa2A7 = aVar5.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A7);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A7 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A7, interfaceC10970cW3B4, aVar5.e());
            DG7.c(interfaceC22053ub1A7, interfaceC11819dc1Q7, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B7 = aVar5.b();
            if (interfaceC22053ub1A7.h() || !AbstractC13042fc3.d(interfaceC22053ub1A7.B(), Integer.valueOf(iA7))) {
                interfaceC22053ub1A7.s(Integer.valueOf(iA7));
                interfaceC22053ub1A7.v(Integer.valueOf(iA7), interfaceC14603iB2B7);
            }
            DG7.c(interfaceC22053ub1A7, eVarE7, aVar5.f());
            String strB = aVar2.b();
            C9348Zn7 c9348Zn7D = g103.d(interfaceC22053ub1, 6).d();
            int iF3 = aVar8.f();
            AbstractC24508yk0.d(strB, null, g103.a(interfaceC22053ub1, 6).I(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF3), 0L, 0, false, 0, 0, null, c9348Zn7D, C17784nZ1.j(g103.c(interfaceC22053ub1, 6).b().e()), interfaceC22053ub1, 0, 0, 65018);
            AbstractC24077y03.a(FN1.d(EnumC23487x03.t, interfaceC22053ub1, 6), null, AbstractC18394ob1.d(androidx.compose.foundation.layout.t.m(aVar9, g103.c(interfaceC22053ub1, 6).b().h()), false, 1, null), g103.a(interfaceC22053ub1, 6).I(), interfaceC22053ub1, 48, 0);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
            interfaceC22053ub1.W(2079621035);
            if (sa23 != null) {
                androidx.compose.ui.e eVarF2 = androidx.compose.foundation.e.f(hVar.h(androidx.compose.foundation.layout.q.i(aVar9, g103.c(interfaceC22053ub1, 6).b().u()), C22297v0.a.e()), false, null, null, sa23, 7, null);
                AbstractC24077y03.b(FV4.c(AbstractC24188yB5.close, interfaceC22053ub1, 0), UY6.c(UD5.close_content_description, interfaceC22053ub1, 0), eVarF2, g103.b(interfaceC22053ub1, 6).g(), interfaceC22053ub1, 0, 0);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.compose.ui.e r16, ir.nasim.InterfaceC10031ax6 r17, final ir.nasim.SA2 r18, ir.nasim.SA2 r19, ir.nasim.UA2 r20, final ir.nasim.X03.a r21, ir.nasim.InterfaceC22053ub1 r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C5.c(androidx.compose.ui.e, ir.nasim.ax6, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.X03$a, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, SA2 sa2, SA2 sa22, UA2 ua2, X03.a aVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBannerClick");
        AbstractC13042fc3.i(aVar, "$contentType");
        c(eVar, interfaceC10031ax6, sa2, sa22, ua2, aVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void e(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1439041845);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C22309v11.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.x5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C5.f(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        e(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
