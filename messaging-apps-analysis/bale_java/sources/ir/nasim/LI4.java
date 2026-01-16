package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.LI4;

/* loaded from: classes5.dex */
public abstract class LI4 {

    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ NI4 a;
        final /* synthetic */ boolean b;
        final /* synthetic */ androidx.compose.ui.e c;
        final /* synthetic */ UA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ long f;
        final /* synthetic */ boolean g;
        final /* synthetic */ SA2 h;

        a(NI4 ni4, boolean z, androidx.compose.ui.e eVar, UA2 ua2, SA2 sa2, long j, boolean z2, SA2 sa22) {
            this.a = ni4;
            this.b = z;
            this.c = eVar;
            this.d = ua2;
            this.e = sa2;
            this.f = j;
            this.g = z2;
            this.h = sa22;
        }

        private static final QI4 b(InterfaceC9664aL6 interfaceC9664aL6) {
            return (QI4) interfaceC9664aL6.getValue();
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.P0(), null, null, null, interfaceC22053ub1, 0, 7);
            androidx.compose.ui.e eVar = (this.b && b(interfaceC9664aL6C).b().isEmpty()) ? androidx.compose.ui.e.a : this.c;
            C24254yJ.f fVarB = C24254yJ.a.b();
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            UA2 ua2 = this.d;
            SA2 sa2 = this.e;
            long j = this.f;
            boolean z = this.g;
            boolean z2 = this.b;
            SA2 sa22 = this.h;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC12364eV.b(b(interfaceC9664aL6C), ua2, sa2, j, z, z2, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.W(-2020165477);
            if (b(interfaceC9664aL6C).a() != -1) {
                if (z2 && b(interfaceC9664aL6C).b().isEmpty()) {
                    interfaceC22053ub1.W(1799478979);
                    LI4.g(sa22, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(1799561811);
                    TI4.b(b(interfaceC9664aL6C), interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                }
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        b(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$showPermissionDialog");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarL = androidx.compose.foundation.layout.q.l(aVar, g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().e(), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().c());
            C24254yJ.m mVarH = C24254yJ.a.h();
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            final SA2 sa2 = this.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarL);
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
            AbstractC9105Ym7.b(UY6.c(AbstractC12217eE5.contacts_permission_needed_btn, interfaceC22053ub1, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65534);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().e()), interfaceC22053ub1, 0);
            AbstractC9105Ym7.b(UY6.c(AbstractC12217eE5.on_boarding_contact_permission, interfaceC22053ub1, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).d(), interfaceC22053ub1, 0, 0, 65534);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i2).b().h()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), 0.0f, C17784nZ1.q(312), 1, null);
            InterfaceC19114po0.b.a aVar3 = InterfaceC19114po0.b.a.a;
            String strC = UY6.c(AbstractC12217eE5.create_group_button, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-51549857);
            boolean zV = interfaceC22053ub1.V(sa2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.MI4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return LI4.b.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.A((SA2) objB, aVar3, strC, eVarA, null, null, interfaceC22053ub1, (InterfaceC19114po0.b.a.b << 3) | 27648, 32);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final androidx.compose.ui.e eVar, final SA2 sa2, final UA2 ua2, NI4 ni4, long j, boolean z, boolean z2, SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        NI4 ni42;
        long j2;
        final boolean z3;
        boolean z4;
        SA2 sa23;
        int i4;
        NI4 ni43;
        SA2 sa24;
        NI4 ni44;
        boolean z5;
        boolean z6;
        long j3;
        final SA2 sa25;
        final NI4 ni45;
        final long j4;
        final boolean z7;
        AbstractC13042fc3.i(eVar, "modifier");
        AbstractC13042fc3.i(sa2, "showContactFragment");
        AbstractC13042fc3.i(ua2, "showStoryFragment");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1291361946);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            if ((i2 & 8) == 0) {
                ni42 = ni4;
                int i5 = interfaceC22053ub1J.D(ni42) ? 2048 : 1024;
                i3 |= i5;
            } else {
                ni42 = ni4;
            }
            i3 |= i5;
        } else {
            ni42 = ni4;
        }
        if ((i & 24576) == 0) {
            j2 = j;
            i3 |= ((i2 & 16) == 0 && interfaceC22053ub1J.f(j2)) ? 16384 : 8192;
        } else {
            j2 = j;
        }
        int i6 = i2 & 32;
        if (i6 != 0) {
            i3 |= 196608;
            z3 = z;
        } else {
            z3 = z;
            if ((196608 & i) == 0) {
                i3 |= interfaceC22053ub1J.a(z3) ? 131072 : 65536;
            }
        }
        int i7 = i2 & 64;
        if (i7 != 0) {
            i3 |= 1572864;
            z4 = z2;
        } else {
            z4 = z2;
            if ((1572864 & i) == 0) {
                i3 |= interfaceC22053ub1J.a(z4) ? 1048576 : 524288;
            }
        }
        int i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
            sa23 = sa22;
        } else {
            sa23 = sa22;
            if ((12582912 & i) == 0) {
                i3 |= interfaceC22053ub1J.D(sa23) ? 8388608 : 4194304;
            }
        }
        if ((i3 & 4793491) == 4793490 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            SA2 sa26 = sa23;
            ni45 = ni42;
            long j5 = j2;
            sa25 = sa26;
            z7 = z4;
            j4 = j5;
        } else {
            interfaceC22053ub1J.E();
            if ((i & 1) == 0 || interfaceC22053ub1J.O()) {
                if ((i2 & 8) != 0) {
                    interfaceC22053ub1J.A(1729797275);
                    InterfaceC15408jX7 interfaceC15408jX7A = C24834zH3.a.a(interfaceC22053ub1J, 6);
                    if (interfaceC15408jX7A == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    i4 = i8;
                    VW7 vw7C = ZW7.c(AbstractC10882cM5.b(NI4.class), interfaceC15408jX7A, null, null, interfaceC15408jX7A instanceof androidx.lifecycle.h ? ((androidx.lifecycle.h) interfaceC15408jX7A).p3() : AbstractC20375ru1.a.b, interfaceC22053ub1J, 0, 0);
                    interfaceC22053ub1J.U();
                    ni43 = (NI4) vw7C;
                } else {
                    i4 = i8;
                    ni43 = ni42;
                }
                long jA = (i2 & 16) != 0 ? WX0.a(TA5.background_2, interfaceC22053ub1J, 0) : j;
                boolean z8 = i6 != 0 ? true : z;
                boolean z9 = i7 == 0 ? z2 : false;
                if (i4 != 0) {
                    interfaceC22053ub1J.W(-866007723);
                    Object objB = interfaceC22053ub1J.B();
                    if (objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.II4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return LI4.e();
                            }
                        };
                        interfaceC22053ub1J.s(objB);
                    }
                    interfaceC22053ub1J.Q();
                    ni44 = ni43;
                    z5 = z8;
                    z6 = z9;
                    j3 = jA;
                    sa24 = (SA2) objB;
                } else {
                    sa24 = sa22;
                    ni44 = ni43;
                    z5 = z8;
                    z6 = z9;
                    j3 = jA;
                }
            } else {
                interfaceC22053ub1J.L();
                ni44 = ni42;
                sa24 = sa23;
                z6 = z4;
                z5 = z3;
                j3 = j2;
            }
            interfaceC22053ub1J.w();
            sa25 = sa24;
            AbstractC11024cc1.a(AndroidCompositionLocals_androidKt.g().d(new C16731lm1((Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g()), AbstractC23035wE5.Theme_Bale_Base)), AbstractC19242q11.e(1469539878, true, new a(ni44, z6, eVar, ua2, sa2, j3, z5, sa25), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            ni45 = ni44;
            j4 = j3;
            z3 = z5;
            z7 = z6;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.JI4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LI4.f(eVar, sa2, ua2, ni45, j4, z3, z7, sa25, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(androidx.compose.ui.e eVar, SA2 sa2, UA2 ua2, NI4 ni4, long j, boolean z, boolean z2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(eVar, "$modifier");
        AbstractC13042fc3.i(sa2, "$showContactFragment");
        AbstractC13042fc3.i(ua2, "$showStoryFragment");
        d(eVar, sa2, ua2, ni4, j, z, z2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(694879078);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            G10 g10 = G10.a;
            int i3 = G10.b;
            E27.a(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, g10.c(interfaceC22053ub1J, i3).b().c()), N46.d(C17784nZ1.q(14)), g10.a(interfaceC22053ub1J, i3).w(), 0L, AbstractC11256ci0.a(C17784nZ1.q(1), g10.a(interfaceC22053ub1J, i3).C()), 0.0f, AbstractC19242q11.e(916729514, true, new b(sa2), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1572864, 40);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.KI4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return LI4.h(sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$showPermissionDialog");
        g(sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
