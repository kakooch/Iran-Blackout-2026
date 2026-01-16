package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Rz3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC7502Rz3 {

    /* renamed from: ir.nasim.Rz3$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ L66 a;
        final /* synthetic */ InterfaceC7975Tz3 b;
        final /* synthetic */ float c;

        a(L66 l66, InterfaceC7975Tz3 interfaceC7975Tz3, float f) {
            this.a = l66;
            this.b = interfaceC7975Tz3;
            this.c = f;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC10011av5.g(this.c, L66.b(this.a, androidx.compose.ui.e.a, 1.0f, false, 2, null), this.b.a(interfaceC22053ub1, 0), G10.a.a(interfaceC22053ub1, 6).E(), AbstractC24405yZ6.a.b(), interfaceC22053ub1, 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Rz3$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC7975Tz3 a;

        b(InterfaceC7975Tz3 interfaceC7975Tz3) {
            this.a = interfaceC7975Tz3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC24077y03.b(FV4.c(this.a.b(), interfaceC22053ub1, 0), "", null, G10.a.a(interfaceC22053ub1, 6).B(), interfaceC22053ub1, 48, 4);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(androidx.compose.ui.e eVar, final float f, final String str, final InterfaceC7975Tz3 interfaceC7975Tz3, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        G10 g10;
        int i4;
        int i5;
        androidx.compose.ui.e eVar3;
        androidx.compose.ui.e eVar4;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "progressLabel");
        AbstractC13042fc3.i(interfaceC7975Tz3, "linearProgressState");
        AbstractC13042fc3.i(ua2, "handleUiAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1959398511);
        int i6 = i2 & 1;
        if (i6 != 0) {
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
            i3 |= interfaceC22053ub1J.c(f) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= (i & 4096) == 0 ? interfaceC22053ub1J.V(interfaceC7975Tz3) : interfaceC22053ub1J.D(interfaceC7975Tz3) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 16384 : 8192;
        }
        int i7 = i3;
        if ((i7 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar4 = eVar2;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar5 = i6 != 0 ? androidx.compose.ui.e.a : eVar2;
            C19111pn7 c19111pn7A = AbstractC19702qn7.a(0, interfaceC22053ub1J, 0, 1);
            G10 g102 = G10.a;
            C9348Zn7 c9348Zn7E = g102.d(interfaceC22053ub1J, 6).e();
            interfaceC22053ub1J.W(-2059106784);
            boolean z = (i7 & 896) == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                g10 = g102;
                i4 = 1;
                i5 = 0;
                eVar3 = eVar5;
                String str2 = (String) AbstractC15401jX0.t0(AbstractC20762sZ6.N0(str, new String[]{Separators.SLASH}, false, 0, 6, null), 1);
                if (str2 == null) {
                    str2 = "";
                }
                objB = c19111pn7A.a(str2 + Separators.SLASH + str2, (1020 & 2) != 0 ? C9348Zn7.d.a() : c9348Zn7E, (1020 & 4) != 0 ? AbstractC23365wn7.a.a() : 0, (1020 & 8) != 0, (1020 & 16) != 0 ? Integer.MAX_VALUE : 0, (1020 & 32) != 0 ? AbstractC19606qe1.b(0, 0, 0, 0, 15, null) : 0L, (1020 & 64) != 0 ? c19111pn7A.c : null, (1020 & 128) != 0 ? c19111pn7A.b : null, (1020 & 256) != 0 ? c19111pn7A.a : null, (1020 & 512) != 0 ? false : false);
                interfaceC22053ub1J.s(objB);
            } else {
                g10 = g102;
                i4 = 1;
                i5 = 0;
                eVar3 = eVar5;
            }
            C13774gn7 c13774gn7 = (C13774gn7) objB;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(eVar3, 0.0f, i4, null), C17784nZ1.q(i5));
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, i5);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            M66 m66 = M66.a;
            e.a aVar2 = androidx.compose.ui.e.a;
            interfaceC22053ub1J.W(-2035365900);
            float fV = C17784nZ1.j(C17784nZ1.q(((WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g())).D((int) (c13774gn7.B() >> 32)) + g10.c(interfaceC22053ub1J, 6).b().u())).v();
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(aVar2, fV);
            C9348Zn7 c9348Zn7E2 = g10.d(interfaceC22053ub1J, 6).e();
            eVar4 = eVar3;
            G10 g103 = g10;
            AbstractC9339Zm7.b(str, eVarY, g10.a(interfaceC22053ub1J, 6).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7E2.b((16744447 & 1) != 0 ? c9348Zn7E2.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7E2.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7E2.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7E2.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7E2.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7E2.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7E2.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7E2.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7E2.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7E2.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7E2.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7E2.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7E2.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7E2.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7E2.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7E2.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7E2.b.i() : C4049Dl7.b.a(), (16744447 & 131072) != 0 ? c9348Zn7E2.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7E2.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7E2.c : null, (16744447 & 1048576) != 0 ? c9348Zn7E2.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7E2.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7E2.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7E2.b.k() : null), interfaceC22053ub1J, (i7 >> 6) & 14, 0, 65528);
            interfaceC22053ub12 = interfaceC22053ub1J;
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, g103.c(interfaceC22053ub12, 6).b().u()), interfaceC22053ub12, 0);
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-1723933715, true, new a(m66, interfaceC7975Tz3, f), interfaceC22053ub12, 54), interfaceC22053ub12, C7252Qx5.i | 48);
            androidx.compose.ui.e eVarI2 = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.t(aVar2, g103.c(interfaceC22053ub12, 6).b().m()), g103.c(interfaceC22053ub12, 6).b().r());
            interfaceC22053ub12.W(-2035333806);
            boolean z2 = ((57344 & i7) == 16384) | ((i7 & 7168) == 2048 || ((i7 & 4096) != 0 && interfaceC22053ub12.D(interfaceC7975Tz3)));
            Object objB2 = interfaceC22053ub12.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Pz3
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC7502Rz3.e(ua2, interfaceC7975Tz3);
                    }
                };
                interfaceC22053ub12.s(objB2);
            }
            interfaceC22053ub12.Q();
            AbstractC20434s03.a((SA2) objB2, eVarI2, false, null, null, AbstractC19242q11.e(-1735837968, true, new b(interfaceC7975Tz3), interfaceC22053ub12, 54), interfaceC22053ub12, 196608, 28);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            final androidx.compose.ui.e eVar6 = eVar4;
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Qz3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7502Rz3.f(eVar6, f, str, interfaceC7975Tz3, ua2, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(UA2 ua2, InterfaceC7975Tz3 interfaceC7975Tz3) {
        AbstractC13042fc3.i(ua2, "$handleUiAction");
        AbstractC13042fc3.i(interfaceC7975Tz3, "$linearProgressState");
        ua2.invoke(interfaceC7975Tz3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(androidx.compose.ui.e eVar, float f, String str, InterfaceC7975Tz3 interfaceC7975Tz3, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$progressLabel");
        AbstractC13042fc3.i(interfaceC7975Tz3, "$linearProgressState");
        AbstractC13042fc3.i(ua2, "$handleUiAction");
        d(eVar, f, str, interfaceC7975Tz3, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void g(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1866092769);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C20492s61.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Oz3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC7502Rz3.h(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        g(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
