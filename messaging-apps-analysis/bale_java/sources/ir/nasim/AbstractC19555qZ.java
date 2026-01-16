package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import androidx.compose.ui.e;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.qZ, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC19555qZ {
    private static final float a = C17784nZ1.q(336);

    /* renamed from: ir.nasim.qZ$a */
    static final class a implements InterfaceC15796kB2 {
        public static final a a = new a();

        a() {
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(-1142572637);
            G10 g10 = G10.a;
            androidx.compose.ui.e eVarA = androidx.compose.foundation.layout.t.A(androidx.compose.foundation.b.d(FV0.a(eVar, N46.d(g10.c(interfaceC22053ub1, 6).a().b())), g10.a(interfaceC22053ub1, 6).M(), null, 2, null), AbstractC19555qZ.a, 0.0f, 2, null);
            interfaceC22053ub1.Q();
            return eVarA;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final void A0(final C23546x62 c23546x62, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c23546x62, "title");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-723219031);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c23546x62) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            G10 g10 = G10.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            C62.d(c23546x62, null, g10.a(interfaceC22053ub1J, 6).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, 6).l(), 0, null, interfaceC22053ub12, i2 & 14, 0, 458746);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.fZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.E0(c23546x62, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void B0(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "title");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-216549839);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            G10 g10 = G10.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1J, 6).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, 6).l(), interfaceC22053ub12, i2 & 14, 0, 65530);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ZY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.D0(str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void C(final ZY0 zy0, final InterfaceC14603iB2 interfaceC14603iB2, final AbstractC10289bP1.a aVar, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(547861022);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(aVar) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(zy0.a(androidx.compose.ui.e.a, 1.0f, false), aVar.a(interfaceC22053ub1J, (i2 >> 6) & 14));
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i2 >> 3) & 14));
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.WY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.D(zy0, interfaceC14603iB2, aVar, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C0(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        z0(i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(ZY0 zy0, InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.a aVar, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(zy0, "$this_DialogBody");
        AbstractC13042fc3.i(interfaceC14603iB2, "$body");
        AbstractC13042fc3.i(aVar, "$paddingValues");
        C(zy0, interfaceC14603iB2, aVar, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D0(String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$title");
        B0(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void E(final InterfaceC14603iB2 interfaceC14603iB2, final AbstractC10289bP1.b bVar, final InterfaceC14603iB2 interfaceC14603iB22, final AbstractC10289bP1.a aVar, final InterfaceC19114po0 interfaceC19114po0, final SA2 sa2, final int i, final InterfaceC19114po0 interfaceC19114po02, final SA2 sa22, final int i2, androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        InterfaceC22053ub1 interfaceC22053ub12;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(interfaceC14603iB2, "title");
        AbstractC13042fc3.i(bVar, "titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "body");
        AbstractC13042fc3.i(aVar, "bodyPadding");
        AbstractC13042fc3.i(interfaceC19114po0, "startButtonStates");
        AbstractC13042fc3.i(sa2, "startOnButtonClicked");
        AbstractC13042fc3.i(interfaceC19114po02, "endButtonStates");
        AbstractC13042fc3.i(sa22, "endOnButtonClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-578407103);
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= interfaceC22053ub1J.V(bVar) ? 32 : 16;
        }
        if ((i5 & 4) != 0) {
            i6 |= 384;
        } else if ((i3 & 384) == 0) {
            i6 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 256 : 128;
        }
        if ((i5 & 8) != 0) {
            i6 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i6 |= interfaceC22053ub1J.V(aVar) ? 2048 : 1024;
        }
        if ((i5 & 16) != 0) {
            i6 |= 24576;
        } else if ((i3 & 24576) == 0) {
            i6 |= (32768 & i3) == 0 ? interfaceC22053ub1J.V(interfaceC19114po0) : interfaceC22053ub1J.D(interfaceC19114po0) ? 16384 : 8192;
        }
        if ((i5 & 32) != 0) {
            i6 |= 196608;
        } else if ((i3 & 196608) == 0) {
            i6 |= interfaceC22053ub1J.D(sa2) ? 131072 : 65536;
        }
        if ((i5 & 64) != 0) {
            i6 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            i6 |= interfaceC22053ub1J.e(i) ? 1048576 : 524288;
        }
        if ((i5 & 128) != 0) {
            i6 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            i6 |= (16777216 & i3) == 0 ? interfaceC22053ub1J.V(interfaceC19114po02) : interfaceC22053ub1J.D(interfaceC19114po02) ? 8388608 : 4194304;
        }
        if ((i5 & 256) != 0) {
            i6 |= 100663296;
        } else if ((i3 & 100663296) == 0) {
            i6 |= interfaceC22053ub1J.D(sa22) ? 67108864 : 33554432;
        }
        if ((i5 & 512) != 0) {
            i6 |= 805306368;
        } else if ((i3 & 805306368) == 0) {
            i6 |= interfaceC22053ub1J.e(i2) ? 536870912 : 268435456;
        }
        int i8 = i5 & 1024;
        if (i8 != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = i4 | (interfaceC22053ub1J.V(eVar) ? 4 : 2);
        } else {
            i7 = i4;
        }
        if ((i6 & 306783379) == 306783378 && (i7 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar3 = i8 != 0 ? androidx.compose.ui.e.a : eVar;
            interfaceC22053ub12 = interfaceC22053ub1J;
            F(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, interfaceC19114po0, sa2, UY6.c(i, interfaceC22053ub1J, (i6 >> 18) & 14), interfaceC19114po02, sa22, UY6.c(i2, interfaceC22053ub1J, (i6 >> 27) & 14), eVar3, interfaceC22053ub12, (i6 & 14) | (i6 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (458752 & i6) | (29360128 & i6) | (i6 & 234881024), i7 & 14, 0);
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.nZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.G(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, interfaceC19114po0, sa2, i, interfaceC19114po02, sa22, i2, eVar2, i3, i4, i5, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E0(C23546x62 c23546x62, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c23546x62, "$title");
        A0(c23546x62, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void F(final InterfaceC14603iB2 interfaceC14603iB2, final AbstractC10289bP1.b bVar, final InterfaceC14603iB2 interfaceC14603iB22, final AbstractC10289bP1.a aVar, final InterfaceC19114po0 interfaceC19114po0, final SA2 sa2, final String str, final InterfaceC19114po0 interfaceC19114po02, final SA2 sa22, final String str2, androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub12;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(interfaceC14603iB2, "title");
        AbstractC13042fc3.i(bVar, "titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "body");
        AbstractC13042fc3.i(aVar, "bodyPadding");
        AbstractC13042fc3.i(interfaceC19114po0, "startButtonStates");
        AbstractC13042fc3.i(sa2, "startOnButtonClicked");
        AbstractC13042fc3.i(str, "startButtonText");
        AbstractC13042fc3.i(interfaceC19114po02, "endButtonStates");
        AbstractC13042fc3.i(sa22, "endOnButtonClicked");
        AbstractC13042fc3.i(str2, "endButtonText");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1298511101);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(bVar) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(aVar) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= (32768 & i) == 0 ? interfaceC22053ub1J.V(interfaceC19114po0) : interfaceC22053ub1J.D(interfaceC19114po0) ? 16384 : 8192;
        }
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i & 196608) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 131072 : 65536;
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 1048576 : 524288;
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i4 |= (16777216 & i) == 0 ? interfaceC22053ub1J.V(interfaceC19114po02) : interfaceC22053ub1J.D(interfaceC19114po02) ? 8388608 : 4194304;
        }
        if ((i3 & 256) != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i4 |= interfaceC22053ub1J.D(sa22) ? 67108864 : 33554432;
        }
        if ((i3 & 512) != 0) {
            i4 |= 805306368;
        } else if ((i & 805306368) == 0) {
            i4 |= interfaceC22053ub1J.V(str2) ? 536870912 : 268435456;
        }
        int i6 = i3 & 1024;
        if (i6 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = i2 | (interfaceC22053ub1J.V(eVar) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            androidx.compose.ui.e eVar3 = i6 != 0 ? androidx.compose.ui.e.a : eVar;
            androidx.compose.ui.e eVarG0 = G0(eVar3);
            androidx.compose.ui.e eVar4 = eVar3;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarG0);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            p0(interfaceC14603iB2, bVar, interfaceC22053ub1J, (i4 & 14) | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            int i7 = i4 >> 3;
            C(c9784aZ0, interfaceC14603iB22, aVar, interfaceC22053ub1J, (i7 & 896) | (i7 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | 6);
            int i8 = i4 >> 15;
            int i9 = i4 >> 9;
            int i10 = i4 >> 12;
            interfaceC22053ub12 = interfaceC22053ub1J;
            r0(sa2, interfaceC19114po0, str, sa22, interfaceC19114po02, str2, interfaceC22053ub12, (i8 & 7168) | (i8 & 14) | (i9 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i10 & 896) | (57344 & i9) | (i10 & 458752));
            interfaceC22053ub12.u();
            eVar2 = eVar4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.lZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.H(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, interfaceC19114po0, sa2, str, interfaceC19114po02, sa22, str2, eVar2, i, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, InterfaceC14603iB2 interfaceC14603iB22, AbstractC10289bP1.a aVar, InterfaceC19114po0 interfaceC19114po0, SA2 sa2, int i, InterfaceC19114po0 interfaceC19114po02, SA2 sa22, int i2, androidx.compose.ui.e eVar, int i3, int i4, int i5, InterfaceC22053ub1 interfaceC22053ub1, int i6) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "$body");
        AbstractC13042fc3.i(aVar, "$bodyPadding");
        AbstractC13042fc3.i(interfaceC19114po0, "$startButtonStates");
        AbstractC13042fc3.i(sa2, "$startOnButtonClicked");
        AbstractC13042fc3.i(interfaceC19114po02, "$endButtonStates");
        AbstractC13042fc3.i(sa22, "$endOnButtonClicked");
        E(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, interfaceC19114po0, sa2, i, interfaceC19114po02, sa22, i2, eVar, interfaceC22053ub1, QJ5.a(i3 | 1), QJ5.a(i4), i5);
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e G0(androidx.compose.ui.e eVar) {
        AbstractC13042fc3.i(eVar, "<this>");
        return androidx.compose.ui.c.c(eVar, null, a.a, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, InterfaceC14603iB2 interfaceC14603iB22, AbstractC10289bP1.a aVar, InterfaceC19114po0 interfaceC19114po0, SA2 sa2, String str, InterfaceC19114po0 interfaceC19114po02, SA2 sa22, String str2, androidx.compose.ui.e eVar, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "$body");
        AbstractC13042fc3.i(aVar, "$bodyPadding");
        AbstractC13042fc3.i(interfaceC19114po0, "$startButtonStates");
        AbstractC13042fc3.i(sa2, "$startOnButtonClicked");
        AbstractC13042fc3.i(str, "$startButtonText");
        AbstractC13042fc3.i(interfaceC19114po02, "$endButtonStates");
        AbstractC13042fc3.i(sa22, "$endOnButtonClicked");
        AbstractC13042fc3.i(str2, "$endButtonText");
        F(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, interfaceC19114po0, sa2, str, interfaceC19114po02, sa22, str2, eVar, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2), i3);
        return C19938rB7.a;
    }

    private static final String H0(Context context, String str) {
        if (!context.getResources().getBoolean(AbstractC22999wA5.is_right_to_left)) {
            return str == null ? "" : str;
        }
        if (str != null) {
            str = AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(str, "1", "۱", false, 4, null), "2", "۲", false, 4, null), "3", "۳", false, 4, null), "4", "۴", false, 4, null), "5", "۵", false, 4, null), "6", "۶", false, 4, null), "7", "۷", false, 4, null), "8", "۸", false, 4, null), "9", "۹", false, 4, null), "0", "۰", false, 4, null);
        }
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void I(final ir.nasim.InterfaceC14603iB2 r45, final ir.nasim.AbstractC10289bP1.b r46, final ir.nasim.InterfaceC14603iB2 r47, final ir.nasim.AbstractC10289bP1.a r48, final ir.nasim.InterfaceC19114po0 r49, final ir.nasim.UA2 r50, final java.lang.String r51, final ir.nasim.InterfaceC19114po0 r52, final ir.nasim.SA2 r53, final java.lang.String r54, androidx.compose.ui.e r55, final java.lang.String r56, boolean r57, ir.nasim.InterfaceC22053ub1 r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instructions count: 1145
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19555qZ.I(ir.nasim.iB2, ir.nasim.bP1$b, ir.nasim.iB2, ir.nasim.bP1$a, ir.nasim.po0, ir.nasim.UA2, java.lang.String, ir.nasim.po0, ir.nasim.SA2, java.lang.String, androidx.compose.ui.e, java.lang.String, boolean, ir.nasim.ub1, int, int, int):void");
    }

    private static final boolean J(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void K(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$checked$delegate");
        K(interfaceC9102Ym4, !J(interfaceC9102Ym4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 M(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(ua2, "$startOnButtonClicked");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$checked$delegate");
        ua2.invoke(Boolean.valueOf(J(interfaceC9102Ym4)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, InterfaceC14603iB2 interfaceC14603iB22, AbstractC10289bP1.a aVar, InterfaceC19114po0 interfaceC19114po0, UA2 ua2, String str, InterfaceC19114po0 interfaceC19114po02, SA2 sa2, String str2, androidx.compose.ui.e eVar, String str3, boolean z, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "$body");
        AbstractC13042fc3.i(aVar, "$bodyPadding");
        AbstractC13042fc3.i(interfaceC19114po0, "$startButtonStates");
        AbstractC13042fc3.i(ua2, "$startOnButtonClicked");
        AbstractC13042fc3.i(str, "$startButtonText");
        AbstractC13042fc3.i(interfaceC19114po02, "$endButtonStates");
        AbstractC13042fc3.i(sa2, "$endOnButtonClicked");
        AbstractC13042fc3.i(str2, "$endButtonText");
        AbstractC13042fc3.i(str3, "$checkboxText");
        I(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, interfaceC19114po0, ua2, str, interfaceC19114po02, sa2, str2, eVar, str3, z, interfaceC22053ub1, QJ5.a(i | 1), QJ5.a(i2), i3);
        return C19938rB7.a;
    }

    public static final void O(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2100608666);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C13324g21 c13324g21 = C13324g21.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c13324g21.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c13324g21.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1J.W(1871252297);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = new UA2() { // from class: ir.nasim.RY
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19555qZ.P(((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1J.Q();
            String strC = UY6.c(AD5.preview_yes, interfaceC22053ub1J, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1J.W(1871257664);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar2.a()) {
                objB2 = new SA2() { // from class: ir.nasim.SY
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19555qZ.Q();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            I(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, ua2, strC, c1454b, (SA2) objB2, UY6.c(AD5.preview_no, interfaceC22053ub1J, 0), androidx.compose.ui.e.a, UY6.c(AD5.preview_check_box_text, interfaceC22053ub1J, 0), false, interfaceC22053ub1J, 113470902, 6, 4096);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.TY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.R(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        O(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b1 A[PHI: r5
      0x00b1: PHI (r5v28 int) = (r5v0 int), (r5v6 int), (r5v7 int) binds: [B:55:0x00af, B:65:0x00c9, B:64:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void S(final ir.nasim.InterfaceC14603iB2 r22, final ir.nasim.AbstractC10289bP1.b r23, final ir.nasim.InterfaceC14603iB2 r24, final ir.nasim.AbstractC10289bP1.a r25, androidx.compose.ui.e r26, ir.nasim.InterfaceC19114po0 r27, final ir.nasim.SA2 r28, final int r29, ir.nasim.InterfaceC22053ub1 r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19555qZ.S(ir.nasim.iB2, ir.nasim.bP1$b, ir.nasim.iB2, ir.nasim.bP1$a, androidx.compose.ui.e, ir.nasim.po0, ir.nasim.SA2, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6 A[PHI: r14
      0x00b6: PHI (r14v28 int) = (r14v0 int), (r14v6 int), (r14v7 int) binds: [B:55:0x00b4, B:65:0x00ce, B:64:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void T(final ir.nasim.InterfaceC14603iB2 r17, final ir.nasim.AbstractC10289bP1.b r18, final ir.nasim.InterfaceC14603iB2 r19, final ir.nasim.AbstractC10289bP1.a r20, androidx.compose.ui.e r21, ir.nasim.InterfaceC19114po0 r22, final ir.nasim.SA2 r23, final java.lang.String r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19555qZ.T(ir.nasim.iB2, ir.nasim.bP1$b, ir.nasim.iB2, ir.nasim.bP1$a, androidx.compose.ui.e, ir.nasim.po0, ir.nasim.SA2, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, InterfaceC14603iB2 interfaceC14603iB22, AbstractC10289bP1.a aVar, androidx.compose.ui.e eVar, InterfaceC19114po0 interfaceC19114po0, SA2 sa2, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "$body");
        AbstractC13042fc3.i(aVar, "$bodyPadding");
        AbstractC13042fc3.i(sa2, "$onButtonClicked");
        S(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, eVar, interfaceC19114po0, sa2, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, InterfaceC14603iB2 interfaceC14603iB22, AbstractC10289bP1.a aVar, androidx.compose.ui.e eVar, InterfaceC19114po0 interfaceC19114po0, SA2 sa2, String str, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "$body");
        AbstractC13042fc3.i(aVar, "$bodyPadding");
        AbstractC13042fc3.i(sa2, "$onButtonClicked");
        AbstractC13042fc3.i(str, "$buttonText");
        T(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, eVar, interfaceC19114po0, sa2, str, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cc A[PHI: r21
      0x00cc: PHI (r21v23 int) = (r21v4 int), (r21v10 int), (r21v11 int) binds: [B:56:0x00ca, B:66:0x00e7, B:65:0x00e4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void W(final ir.nasim.InterfaceC14603iB2 r39, final ir.nasim.AbstractC10289bP1.b r40, final ir.nasim.InterfaceC14603iB2 r41, final ir.nasim.AbstractC10289bP1.a r42, androidx.compose.ui.e r43, ir.nasim.InterfaceC19114po0 r44, final ir.nasim.UA2 r45, final java.lang.String r46, final java.lang.String r47, ir.nasim.InterfaceC22053ub1 r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 938
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19555qZ.W(ir.nasim.iB2, ir.nasim.bP1$b, ir.nasim.iB2, ir.nasim.bP1$a, androidx.compose.ui.e, ir.nasim.po0, ir.nasim.UA2, java.lang.String, java.lang.String, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(ua2, "$onButtonClicked");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$checked$delegate");
        ua2.invoke(Boolean.valueOf(a0(interfaceC9102Ym4)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$checked$delegate");
        b0(interfaceC9102Ym4, !a0(interfaceC9102Ym4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, InterfaceC14603iB2 interfaceC14603iB22, AbstractC10289bP1.a aVar, androidx.compose.ui.e eVar, InterfaceC19114po0 interfaceC19114po0, UA2 ua2, String str, String str2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$titlePaddingValues");
        AbstractC13042fc3.i(interfaceC14603iB22, "$body");
        AbstractC13042fc3.i(aVar, "$bodyPadding");
        AbstractC13042fc3.i(ua2, "$onButtonClicked");
        AbstractC13042fc3.i(str, "$buttonText");
        AbstractC13042fc3.i(str2, "$checkboxText");
        W(interfaceC14603iB2, bVar, interfaceC14603iB22, aVar, eVar, interfaceC19114po0, ua2, str, str2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final boolean a0(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void b0(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    public static final void c0(final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1935883147);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e0(UY6.c(i, interfaceC22053ub1J, i3 & 14), interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.f0(i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void d0(final C23546x62 c23546x62, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c23546x62, "emojiString");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(913252461);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c23546x62) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            G10 g10 = G10.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            C62.d(c23546x62, null, g10.a(interfaceC22053ub1J, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, 6).b(), 0, null, interfaceC22053ub12, i2 & 14, 0, 458234);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.eZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.h0(c23546x62, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void e0(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(245725421);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            G10 g10 = G10.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1J, 6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, 6).b(), interfaceC22053ub12, i2 & 14, 0, 65018);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.kZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.g0(str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f0(int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        c0(i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g0(String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$text");
        e0(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h0(C23546x62 c23546x62, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c23546x62, "$emojiString");
        d0(c23546x62, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i0(final java.lang.String r46, final java.lang.String r47, final ir.nasim.UA2 r48, final java.lang.String r49, final java.lang.String r50, java.lang.Integer r51, ir.nasim.InterfaceC22053ub1 r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19555qZ.i0(java.lang.String, java.lang.String, ir.nasim.UA2, java.lang.String, java.lang.String, java.lang.Integer, ir.nasim.ub1, int, int):void");
    }

    private static final int j0(InterfaceC17916nm4 interfaceC17916nm4) {
        return interfaceC17916nm4.d();
    }

    private static final void k0(InterfaceC17916nm4 interfaceC17916nm4, int i) {
        interfaceC17916nm4.h(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l0(Integer num, UA2 ua2, InterfaceC17916nm4 interfaceC17916nm4, String str) {
        String strSubstring;
        AbstractC13042fc3.i(ua2, "$onInputTextChanged");
        AbstractC13042fc3.i(interfaceC17916nm4, "$charsCount$delegate");
        AbstractC13042fc3.i(str, ParameterNames.TEXT);
        if (num != null) {
            int iIntValue = num.intValue();
            if (str.length() > iIntValue) {
                strSubstring = str.substring(0, iIntValue);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
            } else {
                strSubstring = str;
            }
            if (strSubstring != null) {
                str = strSubstring;
            }
        }
        k0(interfaceC17916nm4, str.length());
        ua2.invoke(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(String str, String str2, UA2 ua2, String str3, String str4, Integer num, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$description");
        AbstractC13042fc3.i(str2, "$inputText");
        AbstractC13042fc3.i(ua2, "$onInputTextChanged");
        AbstractC13042fc3.i(str3, "$label");
        AbstractC13042fc3.i(str4, "$placeholder");
        i0(str, str2, ua2, str3, str4, num, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void n0(final String str, final EV4 ev4, final String str2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(str, "description");
        AbstractC13042fc3.i(ev4, "painter");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2034899554);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ev4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C24254yJ.f fVarB = C24254yJ.a.b();
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            e0(str, interfaceC22053ub1J, i2 & 14);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, G10.a.c(interfaceC22053ub1J, 6).b().c()), interfaceC22053ub1J, 0);
            int i3 = i2 >> 3;
            AbstractC11456d23.b(ev4, str2, null, null, null, 0.0f, null, interfaceC22053ub1J, (i3 & 14) | (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER), 124);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.OY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.o0(str, ev4, str2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0(String str, EV4 ev4, String str2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$description");
        AbstractC13042fc3.i(ev4, "$painter");
        n0(str, ev4, str2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void p0(final InterfaceC14603iB2 interfaceC14603iB2, final AbstractC10289bP1.b bVar, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1172527056);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(bVar) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C24254yJ.f fVarB = C24254yJ.a.b();
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar.g();
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar2);
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
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(aVar2, bVar.a(interfaceC22053ub1J, (i2 >> 3) & 14));
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf(i2 & 14));
            interfaceC22053ub1J.u();
            ZV1.b(androidx.compose.foundation.layout.t.i(aVar2, C17784nZ1.q(1)), 0.0f, G10.a.a(interfaceC22053ub1J, 6).C(), interfaceC22053ub1J, 6, 2);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.XY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.q0(interfaceC14603iB2, bVar, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q0(InterfaceC14603iB2 interfaceC14603iB2, AbstractC10289bP1.b bVar, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$title");
        AbstractC13042fc3.i(bVar, "$paddingValues");
        p0(interfaceC14603iB2, bVar, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void r0(final SA2 sa2, final InterfaceC19114po0 interfaceC19114po0, final String str, final SA2 sa22, final InterfaceC19114po0 interfaceC19114po02, final String str2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1798127557);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(interfaceC19114po0) : interfaceC22053ub1J.D(interfaceC19114po0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? interfaceC22053ub1J.V(interfaceC19114po02) : interfaceC22053ub1J.D(interfaceC19114po02) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((74899 & i3) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1J, 6).b().c());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.e(), InterfaceC12529em.a.i(), interfaceC22053ub1J, 54);
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
            M66 m66 = M66.a;
            AbstractC17932no0.A(sa2, interfaceC19114po0, str, L66.b(m66, aVar, 0.5f, false, 2, null), null, null, interfaceC22053ub1J, (i3 & 14) | 24576 | (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 896), 32);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1J, 6).b().c()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 0.5f, false, 2, null);
            int i4 = i3 >> 9;
            AbstractC17932no0.A(sa22, interfaceC19114po02, str2, eVarB, null, null, interfaceC22053ub1J, (i4 & 14) | 24576 | (i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i4 & 896), 32);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.VY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.s0(sa2, interfaceC19114po0, str, sa22, interfaceC19114po02, str2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s0(SA2 sa2, InterfaceC19114po0 interfaceC19114po0, String str, SA2 sa22, InterfaceC19114po0 interfaceC19114po02, String str2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$startButtonClicked");
        AbstractC13042fc3.i(interfaceC19114po0, "$startButtonStates");
        AbstractC13042fc3.i(str, "$startButtonText");
        AbstractC13042fc3.i(sa22, "$endButtonClicked");
        AbstractC13042fc3.i(interfaceC19114po02, "$endButtonStates");
        AbstractC13042fc3.i(str2, "$endButtonText");
        r0(sa2, interfaceC19114po0, str, sa22, interfaceC19114po02, str2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void t0(androidx.compose.ui.e eVar, final EV4 ev4, final String str, final long j, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(ev4, "painter");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2074436770);
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
            i3 |= interfaceC22053ub1J.D(ev4) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.f(j) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            androidx.compose.ui.e eVar4 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.b(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar4);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            float f = 48;
            androidx.compose.ui.e eVarX = androidx.compose.foundation.layout.t.x(androidx.compose.ui.e.a, C17784nZ1.q(f), C17784nZ1.q(f), 0.0f, 0.0f, 12, null);
            int i5 = i3 >> 3;
            AbstractC24077y03.b(ev4, str, eVarX, j, interfaceC22053ub1J, (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i5 & 14) | 384 | (i3 & 7168), 0);
            interfaceC22053ub1J.u();
            eVar3 = eVar4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.YY
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.u0(eVar3, ev4, str, j, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u0(androidx.compose.ui.e eVar, EV4 ev4, String str, long j, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ev4, "$painter");
        t0(eVar, ev4, str, j, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v0(final java.lang.String r27, androidx.compose.ui.e r28, final ir.nasim.EV4 r29, final java.lang.String r30, final long r31, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19555qZ.v0(java.lang.String, androidx.compose.ui.e, ir.nasim.EV4, java.lang.String, long, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(String str, androidx.compose.ui.e eVar, EV4 ev4, String str2, long j, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(ev4, "$painter");
        v0(str, eVar, ev4, str2, j, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final void x0(final SA2 sa2, final InterfaceC19114po0 interfaceC19114po0, final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1714097937);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? interfaceC22053ub1J.V(interfaceC19114po0) : interfaceC22053ub1J.D(interfaceC19114po0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC17932no0.A(sa2, interfaceC19114po0, str, androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub1J, 6).b().c()), 0.0f, 1, null), null, null, interfaceC22053ub1J, (i2 & 14) | 24576 | (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i2 & 896), 32);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.aZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.y0(sa2, interfaceC19114po0, str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y0(SA2 sa2, InterfaceC19114po0 interfaceC19114po0, String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onButtonClicked");
        AbstractC13042fc3.i(interfaceC19114po0, "$buttonStates");
        AbstractC13042fc3.i(str, "$buttonText");
        x0(sa2, interfaceC19114po0, str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void z0(final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2105617841);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.e(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            B0(UY6.c(i, interfaceC22053ub1J, i3 & 14), interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.iZ
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19555qZ.C0(i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
