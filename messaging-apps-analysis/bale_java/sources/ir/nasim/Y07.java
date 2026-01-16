package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Configuration;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC10254bL2;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.JK4;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public abstract class Y07 {

    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ JK4 a;
        final /* synthetic */ C25038zd6 b;

        /* renamed from: ir.nasim.Y07$a$a, reason: collision with other inner class name */
        static final class C0781a implements InterfaceC14603iB2 {
            public static final C0781a a = new C0781a();

            C0781a() {
            }

            public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-1334232575);
                String strC = UY6.c(KD5.core_ui_start_bot, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return strC;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        static final class b implements InterfaceC14603iB2 {
            public static final b a = new b();

            b() {
            }

            public final String a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                interfaceC22053ub1.W(-808300039);
                String strC = UY6.c(KD5.core_ui_is_done, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
                return strC;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            }
        }

        a(JK4 jk4, C25038zd6 c25038zd6) {
            this.a = jk4;
            this.b = c25038zd6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C25038zd6 c25038zd6, Q07 q07) {
            AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
            AbstractC13042fc3.i(q07, "$item");
            c25038zd6.f().invoke(q07.d());
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C25038zd6 c25038zd6, Q07 q07) {
            AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
            AbstractC13042fc3.i(q07, "$item");
            c25038zd6.f().invoke(q07.d());
            return C19938rB7.a;
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(ir.nasim.InterfaceC19187pv3 r25, int r26, ir.nasim.InterfaceC22053ub1 r27, int r28) {
            /*
                Method dump skipped, instructions count: 450
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.Y07.a.c(ir.nasim.pv3, int, ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            c((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ JK4 a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ExPeerType.values().length];
                try {
                    iArr[ExPeerType.BOT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ExPeerType.GROUP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        b(JK4 jk4) {
            this.a = jk4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Q07 q07 = (Q07) AbstractC15401jX0.s0(((JK4.b.c) this.a.e()).d());
            if (q07 != null) {
                ExPeerType peerType = q07.d().getPeerData().getPeerType();
                int i3 = peerType == null ? -1 : a.a[peerType.ordinal()];
                i2 = (i3 == 1 || i3 != 2) ? KD5.features_onboarding_suggested_bots : KD5.features_onboarding_suggested_groups;
            } else {
                i2 = KD5.features_onboarding_suggested_bots;
            }
            String strC = UY6.c(i2, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i4 = G10.b;
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i4).G(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i4).l(), interfaceC22053ub1, 0, 0, 65530);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ JK4 a;
        final /* synthetic */ C25038zd6 b;

        c(JK4 jk4, C25038zd6 c25038zd6) {
            this.a = jk4;
            this.b = c25038zd6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                if (this.a.d() instanceof OnboardingSpot.SignUp) {
                    return;
                }
                AbstractC20434s03.a(this.b.e(), null, false, null, null, Z91.a.a(), interfaceC22053ub1, 196608, 30);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void f(androidx.compose.ui.e eVar, final int i, final JK4 jk4, final C25038zd6 c25038zd6, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(jk4, "uiState");
        AbstractC13042fc3.i(c25038zd6, "screenDelegate");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1506096735);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            eVar2 = eVar;
        } else if ((i2 & 6) == 0) {
            eVar2 = eVar;
            i4 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i2;
        } else {
            eVar2 = eVar;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(jk4) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(c25038zd6) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            InterfaceC10254bL2.b bVar = new InterfaceC10254bL2.b(i);
            G10 g10 = G10.a;
            int i6 = G10.b;
            TS4 ts4A = androidx.compose.foundation.layout.q.a(g10.c(interfaceC22053ub1J, i6).b().c());
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1J, i6).b().c());
            C24254yJ.f fVarO2 = c24254yJ.o(g10.c(interfaceC22053ub1J, i6).b().c());
            interfaceC22053ub1J.W(1129997087);
            boolean zD = interfaceC22053ub1J.D(jk4) | ((i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | ((i4 & 7168) == 2048);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.U07
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Y07.g(jk4, i, c25038zd6, (InterfaceC4369Ev3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC15050iv3.a(bVar, eVar3, null, ts4A, false, fVarO, fVarO2, null, false, null, (UA2) objB, interfaceC22053ub1J, (i4 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 916);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.V07
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Y07.h(eVar3, i, jk4, c25038zd6, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(JK4 jk4, int i, C25038zd6 c25038zd6, InterfaceC4369Ev3 interfaceC4369Ev3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        AbstractC13042fc3.i(interfaceC4369Ev3, "$this$LazyVerticalGrid");
        JK4.a aVarC = jk4.c();
        if (aVarC instanceof JK4.a.b) {
            int i2 = i * 4;
            for (int i3 = 0; i3 < i2; i3++) {
                InterfaceC4369Ev3.b(interfaceC4369Ev3, null, null, null, Z91.a.b(), 7, null);
            }
        } else {
            if (!(aVarC instanceof JK4.a.C0443a)) {
                throw new NoWhenBranchMatchedException();
            }
            InterfaceC4369Ev3.h(interfaceC4369Ev3, ((JK4.b.c) jk4.e()).d().size(), null, null, null, AbstractC19242q11.c(-781908963, true, new a(jk4, c25038zd6)), 14, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.compose.ui.e eVar, int i, JK4 jk4, C25038zd6 c25038zd6, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        f(eVar, i, jk4, c25038zd6, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void i(final JK4 jk4, final C25038zd6 c25038zd6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(jk4, "uiState");
        AbstractC13042fc3.i(c25038zd6, "screenDelegate");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1821386295);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(jk4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c25038zd6) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            int i3 = ((Configuration) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.f())).orientation == 2 ? 5 : 3;
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1J, i4).r(), null, 2, null);
            C24254yJ.m mVarH = C24254yJ.a.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC21639ts7.h(AbstractC19242q11.e(788726385, true, new b(jk4), interfaceC22053ub1J, 54), null, AbstractC19242q11.e(-1141775441, true, new c(jk4, c25038zd6), interfaceC22053ub1J, 54), null, null, null, null, interfaceC22053ub1J, 390, 122);
            int i5 = i2 << 6;
            f(ZY0.b(c9784aZ0, aVar, 1.0f, false, 2, null), i3, jk4, c25038zd6, interfaceC22053ub1J, (i5 & 896) | (i5 & 7168), 0);
            interfaceC22053ub1J.W(1444798448);
            if (jk4.d() instanceof OnboardingSpot.SignUp) {
                androidx.compose.ui.e eVarI = AbstractC18394ob1.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i4).A(), 0.0f, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
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
                interfaceC22053ub12 = interfaceC22053ub1J;
                AbstractC17932no0.y(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1J, i4).b().c()), 0.0f, 1, null), c25038zd6.e(), InterfaceC19114po0.b.c.a, null, UY6.c(KD5.features_onboarding_enter_bale, interfaceC22053ub1J, 0), null, interfaceC22053ub12, InterfaceC19114po0.b.c.b << 6, 40);
                interfaceC22053ub12.u();
            } else {
                interfaceC22053ub12 = interfaceC22053ub1J;
            }
            interfaceC22053ub12.Q();
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.T07
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Y07.j(jk4, c25038zd6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(JK4 jk4, C25038zd6 c25038zd6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        i(jk4, c25038zd6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void k(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1228021874);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, Z91.a.d(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.S07
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Y07.l(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        k(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1057589945);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, Z91.a.c(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.R07
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return Y07.n(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        m(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
