package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC8486We1;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.We1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC8486We1 {

    /* renamed from: ir.nasim.We1$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ ZN2 b;

        a(SA2 sa2, ZN2 zn2) {
            this.a = sa2;
            this.b = zn2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onClick");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            interfaceC22053ub1.W(-967366871);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ve1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8486We1.a.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(eVarF, g10.c(interfaceC22053ub1, i2).b().e());
            C24254yJ.e eVarG = C24254yJ.a.g();
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            ZN2 zn2 = this.b;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
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
            AbstractC24077y03.b(FV4.c(KB5.link, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 48, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().e()), interfaceC22053ub1, 0);
            String strA = AbstractC5969Lp4.a(UY6.c(AbstractC12217eE5.contact_invite, interfaceC22053ub1, 0), zn2);
            AbstractC13042fc3.h(strA, "formatGroupType(...)");
            AbstractC9339Zm7.b(strA, null, g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).m(), interfaceC22053ub1, 0, 0, 65018);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.We1$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;

        b(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onClick");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            interfaceC22053ub1.W(-1636595841);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Xe1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC8486We1.b.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(eVarF, g10.c(interfaceC22053ub1, i2).b().e());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
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
            AbstractC24077y03.b(FV4.c(KB5.briefcase, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().j()), g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 48, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().e()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.organization_title_desc, interfaceC22053ub1, 0), eVarB, g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).m(), interfaceC22053ub1, 0, 0, 65016);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().e()), interfaceC22053ub1, 0);
            AbstractC24077y03.b(FV4.c(KB5.simple_arrow_left, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().f()), g10.a(interfaceC22053ub1, i2).B(), interfaceC22053ub1, 48, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(InterfaceC15069ix3 interfaceC15069ix3, ZN2 zn2, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC15069ix3, "<this>");
        AbstractC13042fc3.i(zn2, "groupType");
        AbstractC13042fc3.i(sa2, "onClick");
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1622082628, true, new a(sa2, zn2)), 3, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C21739u31.a.a(), 3, null);
    }

    public static final void b(InterfaceC15069ix3 interfaceC15069ix3, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC15069ix3, "<this>");
        AbstractC13042fc3.i(sa2, "onClick");
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1208867551, true, new b(sa2)), 3, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C21739u31.a.b(), 3, null);
    }
}
