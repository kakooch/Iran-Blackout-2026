package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC5008Hm6;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Hm6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5008Hm6 {

    /* renamed from: ir.nasim.Hm6$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ C20996sx3 a;
        final /* synthetic */ UA2 b;

        a(C20996sx3 c20996sx3, UA2 ua2) {
            this.a = c20996sx3;
            this.b = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, C22613vY c22613vY) {
            AbstractC13042fc3.i(ua2, "$addToSelectedContact");
            AbstractC13042fc3.i(c22613vY, "contact");
            ua2.invoke(c22613vY);
            return C19938rB7.a;
        }

        public final void b(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
            if ((i2 & 48) == 0) {
                i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
            } else {
                i3 = i2;
            }
            if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C20996sx3 c20996sx3 = this.a;
            final UA2 ua2 = this.b;
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
            C22613vY c22613vY = (C22613vY) c20996sx3.f(i);
            interfaceC22053ub1.W(945764560);
            if (c22613vY != null) {
                interfaceC22053ub1.W(-482363949);
                boolean zV = interfaceC22053ub1.V(ua2);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Gm6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC5008Hm6.a.c(ua2, (C22613vY) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC15479jf1.d(c22613vY, (UA2) objB, interfaceC22053ub1, 0);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(945770002);
            if (i < c20996sx3.g() - 1) {
                AbstractC9758aW1.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), WX0.a(TA5.color1, interfaceC22053ub1, 0), 0.0f, 0.0f, interfaceC22053ub1, 6, 12);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Hm6$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC9664aL6 a;

        b(InterfaceC9664aL6 interfaceC9664aL6) {
            this.a = interfaceC9664aL6;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5008Hm6.g(this.a)) {
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(78)), WX0.a(TA5.color4, interfaceC22053ub1, 0), null, 2, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            float f = 0;
            float f2 = 12;
            ZH6.a(androidx.compose.foundation.layout.h.a.h(androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(14)), WX0.a(TA5.color3, interfaceC22053ub1, 0), N46.e(C17784nZ1.q(f), C17784nZ1.q(f), C17784nZ1.q(f2), C17784nZ1.q(f2))), aVar2.m()), interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(final C20996sx3 c20996sx3, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c20996sx3, "pagingItems");
        AbstractC13042fc3.i(ua2, "addToSelectedContact");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2121080553);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c20996sx3) : interfaceC22053ub1J.D(c20996sx3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C19206px3 c19206px3B = AbstractC19797qx3.b(0, 0, interfaceC22053ub1J, 0, 3);
            final C13628gZ0 c13628gZ0I = c20996sx3.i();
            int iG = c20996sx3.g();
            interfaceC22053ub1J.W(1973660328);
            boolean zE = interfaceC22053ub1J.e(iG);
            Object objB = interfaceC22053ub1J.B();
            if (zE || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.Cm6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(AbstractC5008Hm6.f(c20996sx3, c13628gZ0I));
                    }
                });
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1973668757);
            if (g(interfaceC9664aL6)) {
                AbstractC12453ee3.b(interfaceC22053ub1J, 0);
            }
            interfaceC22053ub1J.Q();
            float f = 16;
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.C(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, C17784nZ1.q(f), 0.0f, C17784nZ1.q(f), 0.0f, 10, null), 0.0f, 1, null), null, false, 3, null), WX0.a(TA5.color3, interfaceC22053ub1J, 0), N46.d(C17784nZ1.q(12)));
            interfaceC22053ub1J.W(1973683010);
            boolean zV = ((i2 & 14) == 4 || ((i2 & 8) != 0 && interfaceC22053ub1J.D(c20996sx3))) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.V(interfaceC9664aL6);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Dm6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5008Hm6.h(c20996sx3, ua2, interfaceC9664aL6, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVarC, c19206px3B, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1J, 0, 508);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Em6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5008Hm6.j(c20996sx3, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(C20996sx3 c20996sx3, C13628gZ0 c13628gZ0) {
        AbstractC13042fc3.i(c20996sx3, "$pagingItems");
        AbstractC13042fc3.i(c13628gZ0, "$loadState");
        return (c20996sx3.g() != 0 || (c13628gZ0.d() instanceof AbstractC13460gG3.b) || (c13628gZ0.c() instanceof AbstractC13460gG3.b) || (c13628gZ0.a() instanceof AbstractC13460gG3.b)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(C20996sx3 c20996sx3, UA2 ua2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c20996sx3, "$pagingItems");
        AbstractC13042fc3.i(ua2, "$addToSelectedContact");
        AbstractC13042fc3.i(interfaceC9664aL6, "$isEmpty$delegate");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.g(interfaceC15069ix3, c20996sx3.g(), AbstractC13259fv3.a(c20996sx3, new UA2() { // from class: ir.nasim.Fm6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC5008Hm6.i((C22613vY) obj);
            }
        }), null, AbstractC19242q11.c(-1232221387, true, new a(c20996sx3, ua2)), 4, null);
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-623160340, true, new b(interfaceC9664aL6)), 3, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(C22613vY c22613vY) {
        AbstractC13042fc3.i(c22613vY, "it");
        return Integer.valueOf(c22613vY.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C20996sx3 c20996sx3, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c20996sx3, "$pagingItems");
        AbstractC13042fc3.i(ua2, "$addToSelectedContact");
        e(c20996sx3, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
