package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC7003Px0;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Px0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7003Px0 {

    /* renamed from: ir.nasim.Px0$a */
    static final class a implements InterfaceC14603iB2 {
        public static final a a = new a();

        a() {
        }

        public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-90813846);
            A98 a98G = AbstractC21393ta8.g(C8062Uj0.a.g(interfaceC22053ub1, 6), AbstractC23236wa8.a.e());
            interfaceC22053ub1.Q();
            return a98G;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.Px0$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC13346g43 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ UA2 c;

        /* renamed from: ir.nasim.Px0$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ AbstractC5803Kx0 a;

            a(AbstractC5803Kx0 abstractC5803Kx0) {
                this.a = abstractC5803Kx0;
            }

            public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(eVar, "it");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    this.a.c().invoke(interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(InterfaceC13346g43 interfaceC13346g43, SA2 sa2, UA2 ua2) {
            this.a = interfaceC13346g43;
            this.b = sa2;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onDismissRequest");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(UA2 ua2, AbstractC5803Kx0 abstractC5803Kx0) {
            AbstractC13042fc3.i(ua2, "$onUiAction");
            AbstractC13042fc3.i(abstractC5803Kx0, "$option");
            ua2.invoke(abstractC5803Kx0.d());
            return C19938rB7.a;
        }

        public final void c(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            float fQ = C17784nZ1.q((float) 17.61d);
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarH, fQ, g10.c(interfaceC22053ub1, i2).b().f());
            final SA2 sa2 = this.b;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
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
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC9339Zm7.b(UY6.c(BD5.call_button_more, interfaceC22053ub1, 0), hVar.h(aVar, aVar2.e()), g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65016);
            int i3 = 0;
            EV4 ev4C = FV4.c(KB5.cross_search, interfaceC22053ub1, 0);
            String strC = UY6.c(AbstractC12217eE5.dialog_negative_button_cancel, interfaceC22053ub1, 0);
            float f = 13;
            androidx.compose.ui.e eVarH2 = hVar.h(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), aVar2.f());
            interfaceC22053ub1.W(995454583);
            boolean zV = interfaceC22053ub1.V(sa2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Qx0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7003Px0.b.d(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC11456d23.b(ev4C, strC, androidx.compose.foundation.e.f(eVarH2, false, null, null, (SA2) objB, 7, null), null, null, 0.0f, null, interfaceC22053ub1, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
            Object obj = null;
            boolean z = true;
            float f2 = 0.0f;
            float f3 = 1;
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f3)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
            InterfaceC13346g43<AbstractC5803Kx0> interfaceC13346g43 = this.a;
            final UA2 ua2 = this.c;
            for (final AbstractC5803Kx0 abstractC5803Kx0 : interfaceC13346g43) {
                String strC2 = UY6.c(abstractC5803Kx0.b(), interfaceC22053ub1, i3);
                int iA2 = abstractC5803Kx0.a();
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1187929865, z, new a(abstractC5803Kx0), interfaceC22053ub1, 54);
                interfaceC22053ub1.W(995473972);
                boolean zV2 = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.D(abstractC5803Kx0);
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Rx0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC7003Px0.b.f(ua2, abstractC5803Kx0);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                Object obj2 = obj;
                float f4 = f3;
                float f5 = f2;
                AbstractC16797ls7.i(strC2, iA2, null, null, null, interfaceC18060o11E, null, (SA2) objB2, null, false, interfaceC22053ub1, 196608, 860);
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, f5, 1, obj2), C17784nZ1.q(f4)), 0.0f, G10.a.a(interfaceC22053ub1, G10.b).A(), interfaceC22053ub1, 6, 2);
                f2 = f5;
                z = true;
                obj = obj2;
                ua2 = ua2;
                f3 = f4;
                i3 = 0;
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final InterfaceC13346g43 interfaceC13346g43, final SA2 sa2, final C19818qz6 c19818qz6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(interfaceC13346g43, "options");
        AbstractC13042fc3.i(sa2, "onDismissRequest");
        AbstractC13042fc3.i(c19818qz6, "bottomSheetState");
        AbstractC13042fc3.i(ua2, "onUiAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-877656653);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(interfaceC13346g43) : interfaceC22053ub1J.D(interfaceC13346g43) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(c19818qz6) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            long jM = G10.a.a(interfaceC22053ub1J, G10.b).M();
            interfaceC22053ub1J.W(-1229780639);
            boolean z = (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Nx0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7003Px0.d(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9273Zf4.a((SA2) objB, null, c19818qz6, 0.0f, null, jM, 0L, 0.0f, 0L, null, a.a, null, AbstractC19242q11.e(1329449910, true, new b(interfaceC13346g43, sa2, ua2), interfaceC22053ub1J, 54), interfaceC22053ub12, (i3 & 896) | 805306368, 384, 2522);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ox0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7003Px0.e(interfaceC13346g43, sa2, c19818qz6, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(InterfaceC13346g43 interfaceC13346g43, SA2 sa2, C19818qz6 c19818qz6, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC13346g43, "$options");
        AbstractC13042fc3.i(sa2, "$onDismissRequest");
        AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
        AbstractC13042fc3.i(ua2, "$onUiAction");
        c(interfaceC13346g43, sa2, c19818qz6, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
