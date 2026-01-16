package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.F65;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* loaded from: classes6.dex */
public abstract class F65 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;
        final /* synthetic */ UA2 c;

        a(String str, boolean z, UA2 ua2) {
            this.a = str;
            this.b = z;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC9102Ym4 d(String str) {
            AbstractC13042fc3.i(str, "$personalName");
            return AbstractC13472gH6.d(str, null, 2, null);
        }

        private static final String f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return (String) interfaceC9102Ym4.getValue();
        }

        private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            interfaceC9102Ym4.setValue(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
            AbstractC13042fc3.i(ua2, "$onNameChanged");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$name$delegate");
            AbstractC13042fc3.i(str, "it");
            ua2.invoke(str);
            h(interfaceC9102Ym4, str);
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14472hy4 cVar;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1, i2).r(), null, 2, null), g10.c(interfaceC22053ub1, i2).b().e());
            final String str = this.a;
            boolean z = this.b;
            final UA2 ua2 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1.W(-917463312);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar3 = InterfaceC22053ub1.a;
            if (objB == aVar3.a()) {
                objB = new androidx.compose.ui.focus.m();
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) objB;
            interfaceC22053ub1.Q();
            Object[] objArr = new Object[0];
            interfaceC22053ub1.W(-917461037);
            boolean zV = interfaceC22053ub1.V(str);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar3.a()) {
                objB2 = new SA2() { // from class: ir.nasim.D65
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return F65.a.d(str);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB2, interfaceC22053ub1, 0, 6);
            boolean z2 = !z;
            String strF = f(interfaceC9102Ym4);
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.n.a(androidx.compose.foundation.j.b(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), false, null, 3, null), mVar);
            String strC = UY6.c(HD5.group_set_personal_title_access, interfaceC22053ub1, 0);
            String strC2 = UY6.c(HD5.group_set_personal_name_place_holder, interfaceC22053ub1, 0);
            if (z) {
                interfaceC22053ub1.W(1624152650);
                interfaceC22053ub1.Q();
                cVar = new AbstractC14472hy4.d(null, null, null, 7, null);
            } else if (f(interfaceC9102Ym4).length() > 30) {
                interfaceC22053ub1.W(1624262731);
                cVar = new AbstractC14472hy4.a(Integer.valueOf(AbstractC17572nB5.danger), UY6.c(HD5.personal_name_limit_error_create_group, interfaceC22053ub1, 0), 30);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1624527285);
                cVar = new AbstractC14472hy4.c(Integer.valueOf(KB5.icon_danger_circle), UY6.c(AbstractC12217eE5.personal_name_success_state, interfaceC22053ub1, 0), 30);
                interfaceC22053ub1.Q();
            }
            AbstractC14472hy4 abstractC14472hy4 = cVar;
            interfaceC22053ub1.W(-917455382);
            boolean zV2 = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(interfaceC9102Ym4);
            Object objB3 = interfaceC22053ub1.B();
            if (zV2 || objB3 == aVar3.a()) {
                objB3 = new UA2() { // from class: ir.nasim.E65
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return F65.a.i(ua2, interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.e0(strF, (UA2) objB3, strC, strC2, eVarA, null, z2, false, null, null, abstractC14472hy4, null, null, true, 0, 0, null, null, false, false, null, false, interfaceC22053ub1, 0, AbstractC14472hy4.a | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 4184992);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;

        b(UA2 ua2, String str, boolean z) {
            this.a = ua2;
            this.b = str;
            this.c = z;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            UA2 ua2 = this.a;
            String str = this.b;
            if (str == null) {
                str = "";
            }
            F65.b(ua2, str, this.c, interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final UA2 ua2, final String str, boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        final boolean z2;
        AbstractC13042fc3.i(ua2, "onNameChanged");
        AbstractC13042fc3.i(str, "personalName");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(516116637);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(ua2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            z2 = z;
        } else {
            boolean z3 = i4 != 0 ? false : z;
            M10.f(false, AbstractC19242q11.e(912247192, true, new a(str, z3, ua2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
            z2 = z3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.C65
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return F65.c(ua2, str, z2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(UA2 ua2, String str, boolean z, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onNameChanged");
        AbstractC13042fc3.i(str, "$personalName");
        b(ua2, str, z, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void d(ComposeView composeView, UA2 ua2, String str, boolean z) {
        AbstractC13042fc3.i(composeView, "composeView");
        AbstractC13042fc3.i(ua2, "onNameChanged");
        composeView.setContent(AbstractC19242q11.c(912980855, true, new b(ua2, str, z)));
    }
}
