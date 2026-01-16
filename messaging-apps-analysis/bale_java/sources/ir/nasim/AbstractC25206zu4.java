package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import androidx.compose.ui.e;
import ir.nasim.C24254yJ;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.zu4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC25206zu4 {
    public static final void e(androidx.compose.ui.e eVar, final List list, final int i, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        final androidx.compose.ui.e eVar2;
        AbstractC13042fc3.i(ua2, "onClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-174222727);
        if ((i3 & 2) != 0) {
            i4 = i2 | 48;
        } else if ((i2 & 48) == 0) {
            i4 = (interfaceC22053ub1J.D(list) ? 32 : 16) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i4 & 1169) == 1168 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar2 = eVar;
        } else {
            androidx.compose.ui.e eVar3 = (i3 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
            if (list != null) {
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                interfaceC22053ub1J.W(-989695702);
                boolean zD = ((i4 & 7168) == 2048) | interfaceC22053ub1J.D(list);
                Object objB = interfaceC22053ub1J.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.wu4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC25206zu4.f(ua2, list);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.e eVarG = c24254yJ.g();
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.l(), interfaceC22053ub1J, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
                String str = UY6.c(AbstractC12217eE5.common_groups, interfaceC22053ub1J, 0) + " : ";
                G10 g10 = G10.a;
                int i5 = G10.b;
                C9348Zn7 c9348Zn7E = g10.d(interfaceC22053ub1J, i5).e();
                C9348Zn7 c9348Zn7B = c9348Zn7E.b((16744447 & 1) != 0 ? c9348Zn7E.a.g() : g10.a(interfaceC22053ub1J, i5).w(), (16744447 & 2) != 0 ? c9348Zn7E.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7E.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7E.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7E.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7E.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7E.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7E.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7E.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7E.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7E.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7E.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7E.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7E.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7E.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7E.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7E.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7E.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7E.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7E.c : null, (16744447 & 1048576) != 0 ? c9348Zn7E.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7E.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7E.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7E.b.k() : null);
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(L66.b(m66, aVar, 1.0f, false, 2, null), 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i5).b().r(), 0.0f, 11, null);
                C6399Nk7.a aVar4 = C6399Nk7.b;
                int i6 = 0;
                AbstractC9339Zm7.b(str, eVarM, 0L, 0L, null, null, null, 0L, null, C6399Nk7.h(aVar4.b()), 0L, 0, false, 0, 0, null, c9348Zn7B, interfaceC22053ub1J, 0, 0, 65020);
                androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar2.l(), interfaceC22053ub1J, 0);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B2, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                String str2 = XY6.v(String.valueOf(i)) + Separators.SP + UY6.c(AbstractC12217eE5.group, interfaceC22053ub1J, 0);
                C9348Zn7 c9348Zn7N = g10.d(interfaceC22053ub1J, i5).n();
                AbstractC9339Zm7.b(str2, androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i5).b().r(), 0.0f, 11, null), 0L, 0L, null, null, null, 0L, null, C6399Nk7.h(aVar4.f()), 0L, 0, false, 0, 0, null, c9348Zn7N.b((16744447 & 1) != 0 ? c9348Zn7N.a.g() : g10.a(interfaceC22053ub1J, i5).G(), (16744447 & 2) != 0 ? c9348Zn7N.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7N.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7N.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7N.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7N.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7N.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7N.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7N.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7N.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7N.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7N.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7N.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7N.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7N.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7N.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7N.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7N.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7N.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7N.c : null, (16744447 & 1048576) != 0 ? c9348Zn7N.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7N.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7N.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7N.b.k() : null), interfaceC22053ub1J, 0, 0, 65020);
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(24));
                InterfaceC10970cW3 interfaceC10970cW3B3 = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1J, 48);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
                SA2 sa2A3 = aVar3.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A3);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B3, aVar3.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
                float fQ = C17784nZ1.q(20);
                float fQ2 = C17784nZ1.q(12);
                List listF1 = AbstractC15401jX0.f1(list, 3);
                androidx.compose.ui.e eVarY = androidx.compose.foundation.layout.t.y(aVar, C17784nZ1.q(C17784nZ1.q((listF1.size() - 1) * fQ2) + fQ));
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
                int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarY);
                SA2 sa2A4 = aVar3.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A4);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A4, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B4 = aVar3.b();
                if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                    interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                    interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
                }
                DG7.c(interfaceC22053ub1A4, eVarE4, aVar3.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                interfaceC22053ub1J.W(1080212772);
                for (Object obj : listF1) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        AbstractC10360bX0.w();
                    }
                    C14697iL2 c14697iL2 = (C14697iL2) obj;
                    interfaceC22053ub1J.W(1080214854);
                    if (c14697iL2 != null) {
                        float f = i6;
                        TU.m(AvatarAsyncImagePainterKt.h(c14697iL2.h0(), null, false, 0, interfaceC22053ub1J, 0, 14), new UU(false, null, null, null, c14697iL2.G0(), 0, false, WKSRecord.Service.SUNRPC, null), Ac8.a(androidx.compose.foundation.layout.n.c(androidx.compose.ui.e.a, C17784nZ1.q(f * fQ2), 0.0f, 2, null), f), fQ, 0.0f, 0.0f, null, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                    interfaceC22053ub1J.Q();
                    i6 = i7;
                }
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.u();
                AbstractC24077y03.a(XQ7.b(C12700f33.k, KB5.simple_arrow_left, interfaceC22053ub1J, 6), null, G46.a(androidx.compose.ui.e.a, JF5.g() ? 0.0f : 180.0f), G10.a.a(interfaceC22053ub1J, G10.b).G(), interfaceC22053ub1J, 48, 0);
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.u();
                C19938rB7 c19938rB72 = C19938rB7.a;
            }
            eVar2 = eVar3;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xu4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return AbstractC25206zu4.g(eVar2, list, i, ua2, i2, i3, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(UA2 ua2, List list) {
        AbstractC13042fc3.i(ua2, "$onClick");
        ua2.invoke(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(androidx.compose.ui.e eVar, List list, int i, UA2 ua2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(ua2, "$onClick");
        e(eVar, list, i, ua2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void h(final String str, final String str2, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "value");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1128247788);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            String str3 = str + (z ? " : " : "");
            G10 g10 = G10.a;
            int i4 = G10.b;
            C9348Zn7 c9348Zn7E = g10.d(interfaceC22053ub1J, i4).e();
            C9348Zn7 c9348Zn7B = c9348Zn7E.b((16744447 & 1) != 0 ? c9348Zn7E.a.g() : g10.a(interfaceC22053ub1J, i4).w(), (16744447 & 2) != 0 ? c9348Zn7E.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7E.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7E.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7E.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7E.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7E.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7E.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7E.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7E.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7E.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7E.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7E.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7E.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7E.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7E.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7E.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7E.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7E.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7E.c : null, (16744447 & 1048576) != 0 ? c9348Zn7E.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7E.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7E.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7E.b.k() : null);
            androidx.compose.ui.e eVarB = L66.b(m66, androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, g10.c(interfaceC22053ub1J, i4).b().r(), 0.0f, 11, null), 1.0f, false, 2, null);
            C6399Nk7.a aVar3 = C6399Nk7.b;
            AbstractC9339Zm7.b(str3, eVarB, 0L, 0L, null, null, null, 0L, null, C6399Nk7.h(aVar3.b()), 0L, 0, false, 0, 0, null, c9348Zn7B, interfaceC22053ub1J, 0, 0, 65020);
            C9348Zn7 c9348Zn7N = g10.d(interfaceC22053ub1J, i4).n();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str2, L66.b(m66, aVar, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, C6399Nk7.h(aVar3.f()), 0L, 0, false, 0, 0, null, c9348Zn7N.b((16744447 & 1) != 0 ? c9348Zn7N.a.g() : g10.a(interfaceC22053ub1J, i4).G(), (16744447 & 2) != 0 ? c9348Zn7N.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7N.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7N.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7N.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7N.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7N.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7N.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7N.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7N.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7N.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7N.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7N.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7N.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7N.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7N.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7N.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7N.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7N.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7N.c : null, (16744447 & 1048576) != 0 ? c9348Zn7N.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7N.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7N.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7N.b.k() : null), interfaceC22053ub12, (i3 >> 3) & 14, 0, 65020);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yu4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC25206zu4.i(str, str2, z, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(String str, String str2, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$value");
        h(str, str2, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final ir.nasim.C8894Xu r72, final java.util.List r73, final ir.nasim.UA2 r74, final java.lang.String r75, ir.nasim.InterfaceC22053ub1 r76, final int r77) {
        /*
            Method dump skipped, instructions count: 1295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC25206zu4.j(ir.nasim.Xu, java.util.List, ir.nasim.UA2, java.lang.String, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(C8894Xu c8894Xu, List list, UA2 ua2, String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ua2, "$onClick");
        j(c8894Xu, list, ua2, str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final XV4 l(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (OU3 ou3 : C20644sM5.e(new C20644sM5("fa=([^,]+), en=([^)]+)"), str, 0, 2, null)) {
            String str2 = (String) ou3.b().get(1);
            String str3 = (String) ou3.b().get(2);
            arrayList.add(str2);
            arrayList2.add(str3);
        }
        return AbstractC4616Fw7.a(AbstractC15401jX0.p1(arrayList), AbstractC15401jX0.p1(arrayList2));
    }
}
