package ir.nasim;

import android.graphics.Color;
import ir.nasim.AbstractC4354Et6;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Et6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC4354Et6 {

    /* renamed from: ir.nasim.Et6$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ AbstractC12710f43 a;
        final /* synthetic */ UA2 b;

        a(AbstractC12710f43 abstractC12710f43, UA2 ua2) {
            this.a = abstractC12710f43;
            this.b = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, C12596es6 c12596es6) {
            AbstractC13042fc3.i(ua2, "$onServiceShortcutClicked");
            AbstractC13042fc3.f(c12596es6);
            ua2.invoke(c12596es6);
            return C19938rB7.a;
        }

        public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$Card");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), C17784nZ1.q(12), 0.0f, 2, null);
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C24254yJ.f fVarE = C24254yJ.a.e();
            AbstractC12710f43<C12596es6> abstractC12710f43 = this.a;
            final UA2 ua2 = this.b;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarE, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            interfaceC22053ub1.W(1105888034);
            if (abstractC12710f43 != null) {
                for (final C12596es6 c12596es6 : abstractC12710f43) {
                    interfaceC22053ub1.F(-723735251, Integer.valueOf(c12596es6.e()));
                    String strF = c12596es6.f();
                    String strD = c12596es6.d();
                    String strC = c12596es6.c();
                    long jB = DX0.b(Color.parseColor(c12596es6.b()));
                    long jB2 = DX0.b(Color.parseColor(c12596es6.a()));
                    interfaceC22053ub1.W(-723720536);
                    boolean zV = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(c12596es6);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Dt6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC4354Et6.a.c(ua2, c12596es6);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC7505Rz6.k(strF, strD, strC, jB, jB2, (SA2) objB, interfaceC22053ub1, 0, 0);
                    interfaceC22053ub1.T();
                }
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(androidx.compose.ui.e eVar, final AbstractC12710f43 abstractC12710f43, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(ua2, "onServiceShortcutClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(883828976);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(abstractC12710f43) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            PG0.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null), C17784nZ1.q(88)), N46.d(C17784nZ1.q(14)), MG0.a.b(G10.a.a(interfaceC22053ub1J, G10.b).y(), 0L, 0L, 0L, interfaceC22053ub1J, MG0.b << 12, 14), null, null, AbstractC19242q11.e(1936451390, true, new a(abstractC12710f43, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 196608, 24);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Bt6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4354Et6.d(eVar3, abstractC12710f43, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(androidx.compose.ui.e eVar, AbstractC12710f43 abstractC12710f43, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onServiceShortcutClicked");
        c(eVar, abstractC12710f43, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void e(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1160398480);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null), C17784nZ1.q(88));
            float fQ = C17784nZ1.q(1);
            G10 g10 = G10.a;
            int i5 = G10.b;
            PG0.a(eVarI, N46.d(C17784nZ1.q(14)), MG0.a.b(g10.a(interfaceC22053ub1J, i5).r(), 0L, 0L, 0L, interfaceC22053ub1J, MG0.b << 12, 14), null, AbstractC11256ci0.a(fQ, g10.a(interfaceC22053ub1J, i5).A()), C19322q91.a.a(), interfaceC22053ub1J, 196608, 8);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ct6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4354Et6.f(eVar3, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        e(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
