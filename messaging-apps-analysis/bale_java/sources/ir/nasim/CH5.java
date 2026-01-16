package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.C24254yJ;
import ir.nasim.CH5;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.R62;
import java.util.Map;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class CH5 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ int a;
        final /* synthetic */ C20996sx3 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ Map f;

        /* renamed from: ir.nasim.CH5$a$a, reason: collision with other inner class name */
        static final class C0307a implements InterfaceC14603iB2 {
            final /* synthetic */ C20996sx3 a;
            final /* synthetic */ UA2 b;
            final /* synthetic */ Map c;
            final /* synthetic */ boolean d;
            final /* synthetic */ SA2 e;

            /* renamed from: ir.nasim.CH5$a$a$a, reason: collision with other inner class name */
            static final class C0308a implements InterfaceC16978mB2 {
                final /* synthetic */ C20996sx3 a;
                final /* synthetic */ UA2 b;

                C0308a(C20996sx3 c20996sx3, UA2 ua2) {
                    this.a = c20996sx3;
                    this.b = ua2;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                    if ((i2 & 48) == 0) {
                        i2 |= interfaceC22053ub1.e(i) ? 32 : 16;
                    }
                    if ((i2 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    DH5 dh5 = (DH5) this.a.f(i);
                    if (dh5 == null) {
                        return;
                    }
                    CH5.r(dh5, this.b, interfaceC22053ub1, 0, 0);
                }

                @Override // ir.nasim.InterfaceC16978mB2
                public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                    a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.CH5$a$a$b */
            static final class b implements InterfaceC15796kB2 {
                final /* synthetic */ int a;
                final /* synthetic */ String b;

                b(int i, String str) {
                    this.a = i;
                    this.b = str;
                }

                public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
                    AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        CH5.p(this.a, this.b, interfaceC22053ub1, 0);
                    }
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) throws Resources.NotFoundException {
                    a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            C0307a(C20996sx3 c20996sx3, UA2 ua2, Map map, boolean z, SA2 sa2) {
                this.a = c20996sx3;
                this.b = ua2;
                this.c = map;
                this.d = z;
                this.e = sa2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(C20996sx3 c20996sx3, Map map, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
                AbstractC13042fc3.i(c20996sx3, "$model");
                AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
                InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.BH5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return CH5.a.C0307a.f((DH5) obj);
                    }
                }), null, AbstractC19242q11.c(371860971, true, new C0308a(c20996sx3, ua2)), 4, null);
                for (Map.Entry entry : map.entrySet()) {
                    InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-1018376487, true, new b(((Number) entry.getValue()).intValue(), (String) entry.getKey())), 3, null);
                }
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Object f(DH5 dh5) {
                AbstractC13042fc3.i(dh5, "it");
                return Integer.valueOf(dh5.e());
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C20996sx3 c20996sx3 = this.a;
                final UA2 ua2 = this.b;
                final Map map = this.c;
                boolean z = this.d;
                SA2 sa2 = this.e;
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
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
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(aVar, 0.0f, C17784nZ1.q(316), 1, null);
                interfaceC22053ub1.W(2044176210);
                boolean zD = interfaceC22053ub1.D(c20996sx3) | interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(map);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.AH5
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return CH5.a.C0307a.d(c20996sx3, map, ua2, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarK, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 6, 510);
                interfaceC22053ub1.W(2044193925);
                if (z) {
                    CH5.m(sa2, interfaceC22053ub1, 0);
                }
                interfaceC22053ub1.Q();
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(int i, C20996sx3 c20996sx3, boolean z, SA2 sa2, UA2 ua2, Map map) {
            this.a = i;
            this.b = c20996sx3;
            this.c = z;
            this.d = sa2;
            this.e = ua2;
            this.f = map;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int i2 = this.a;
            boolean z = this.b.i().d() instanceof AbstractC13460gG3.b;
            boolean z2 = this.c;
            SA2 sa2 = this.d;
            CH5.z(i2, z, z2, sa2, AbstractC19242q11.e(-40746241, true, new C0307a(this.b, this.e, this.f, z2, sa2), interfaceC22053ub1, 54), interfaceC22053ub1, 24576, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(int i, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, i, null, null, R81.a.a(), 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(int i, boolean z, boolean z2, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$contentAfterLoading");
        z(i, z, z2, sa2, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(344448481);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f = Type.TSIG;
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(aVar, 0.0f, C17784nZ1.q(f), 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            ZV1.b(eVarA, g10.c(interfaceC22053ub1J, i3).b().e(), g10.a(interfaceC22053ub1J, i3).A(), interfaceC22053ub1J, 6, 0);
            interfaceC22053ub1J.W(-30808395);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.tH5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return CH5.n(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.A(androidx.compose.foundation.e.f(aVar, false, null, null, (SA2) objB, 7, null), 0.0f, C17784nZ1.q(f), 1, null), g10.c(interfaceC22053ub1J, i3).b().c());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.c(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            AbstractC9339Zm7.b(UY6.c(DD5.submit_return, interfaceC22053ub1J, 0), L66.b(M66.a, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.b()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i3).b(), interfaceC22053ub1J, 0, 0, 65016);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().c()), interfaceC22053ub1J, 0);
            AbstractC24077y03.b(FV4.c(AbstractC15208jB5.arrow_right, interfaceC22053ub1J, 0), null, G46.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().j()), 180.0f), g10.a(interfaceC22053ub1J, i3).B(), interfaceC22053ub1J, 48, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.uH5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return CH5.o(sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onBackButtonClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBackButtonClicked");
        m(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final int i, final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i2) throws Resources.NotFoundException {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-769455902);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        int i4 = i3;
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(aVar, 0.0f, C17784nZ1.q(Type.TSIG), 1, null);
            G10 g10 = G10.a;
            int i5 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarA, g10.c(interfaceC22053ub1J, i5).b().c(), g10.c(interfaceC22053ub1J, i5).b().d());
            C24254yJ.e eVarG = C24254yJ.a.g();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.i(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(28)), N46.g()), g10.a(interfaceC22053ub1J, i5).m(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.e(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            SA2 sa2A2 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC24077y03.b(FV4.c(AbstractC15208jB5.bold_profile, interfaceC22053ub1J, 0), null, FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q((float) 15.6d)), N46.g()), g10.a(interfaceC22053ub1J, i5).r(), interfaceC22053ub1J, 48, 0);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i5).b().u()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(XY6.v(String.valueOf(i)) + Separators.SP + UY6.a(AbstractC16999mD5.other_people_in_reaction_list, i, interfaceC22053ub1J, (i4 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1J, i5).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).b(), interfaceC22053ub1J, 0, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i5).b().u()), interfaceC22053ub1J, 0);
            R62.b bVarA = R62.A(str);
            interfaceC22053ub1J.W(-1919467626);
            if (bVarA != null) {
                AbstractC11456d23.b(C02.e(bVarA, interfaceC22053ub1J, R62.b.h), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i5).b().j()), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.vH5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return CH5.q(i, str, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(int i, String str, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) throws Resources.NotFoundException {
        AbstractC13042fc3.i(str, "$reactionCode");
        p(i, str, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r(final ir.nasim.DH5 r35, ir.nasim.UA2 r36, ir.nasim.InterfaceC22053ub1 r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CH5.r(ir.nasim.DH5, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(int i) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(UA2 ua2, DH5 dh5) {
        AbstractC13042fc3.i(dh5, "$it");
        ua2.invoke(Integer.valueOf(dh5.e()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(DH5 dh5, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(dh5, "$it");
        r(dh5, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(final androidx.compose.ui.e r29, final ir.nasim.C20996sx3 r30, java.util.Map r31, boolean r32, ir.nasim.SA2 r33, ir.nasim.UA2 r34, int r35, ir.nasim.InterfaceC22053ub1 r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CH5.v(androidx.compose.ui.e, ir.nasim.sx3, java.util.Map, boolean, ir.nasim.SA2, ir.nasim.UA2, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(int i) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(androidx.compose.ui.e eVar, C20996sx3 c20996sx3, Map map, boolean z, SA2 sa2, UA2 ua2, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(c20996sx3, "$model");
        v(eVar, c20996sx3, map, z, sa2, ua2, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void z(final int r22, final boolean r23, boolean r24, ir.nasim.SA2 r25, final ir.nasim.InterfaceC14603iB2 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.CH5.z(int, boolean, boolean, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }
}
