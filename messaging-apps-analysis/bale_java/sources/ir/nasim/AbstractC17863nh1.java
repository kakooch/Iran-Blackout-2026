package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC23365wn7;
import ir.nasim.C24254yJ;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.nh1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC17863nh1 {

    /* renamed from: ir.nasim.nh1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            G10 g10 = G10.a;
            int i2 = G10.b;
            C9348Zn7 c9348Zn7J = g10.d(interfaceC22053ub1, i2).j();
            AbstractC9339Zm7.b(this.a, null, g10.a(interfaceC22053ub1, i2).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7J, interfaceC22053ub1, 0, 0, 65530);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void g(final EV4 ev4, final String str, final String str2, final int i, final int i2, final InterfaceC4027Dj3 interfaceC4027Dj3, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i3) {
        int i4;
        AbstractC13042fc3.i(ev4, "channelAvatarPainter");
        AbstractC13042fc3.i(str, "channelName");
        AbstractC13042fc3.i(str2, "channelFormattedMemberCount");
        AbstractC13042fc3.i(interfaceC4027Dj3, "joinButtonStatus");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1757468488);
        if ((i3 & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(ev4) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.e(i2) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC4027Dj3) ? 131072 : 65536;
        }
        if ((1572864 & i3) == 0) {
            i4 |= interfaceC22053ub1J.a(z) ? 1048576 : 524288;
        }
        int i5 = i4;
        if ((i5 & 599187) == 599186 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i6 = G10.b;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1J, i6).r(), null, 2, null), 0.0f, 1, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.f fVarB = c24254yJ.b();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(fVarB, aVar2.i(), interfaceC22053ub1J, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.e(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1J, i6).b().e());
            interfaceC22053ub1J = interfaceC22053ub1J;
            TU.m(ev4, new UU(false, null, null, null, str, 0, false, WKSRecord.Service.SUNRPC, null), eVarI, 0.0f, 0.0f, 0.0f, null, interfaceC22053ub1J, i5 & 14, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            interfaceC22053ub1J.u();
            androidx.compose.ui.e eVarF = AbstractC18394ob1.f(L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1J, i6).A(), 0.0f, 0.0f, 6, null);
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1J, i6).b().e(), g10.c(interfaceC22053ub1J, i6).b().e(), g10.c(interfaceC22053ub1J, i6).b().e(), 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1J, 48);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM);
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
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3B2, aVar3.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar3.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar3.f());
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1J, 0);
            int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
            SA2 sa2A5 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A5);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A5, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B5 = aVar3.b();
            if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
            }
            DG7.c(interfaceC22053ub1A5, eVarE5, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3B3 = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1J, 48);
            int iA6 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q6 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE6 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH2);
            SA2 sa2A6 = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A6);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A6 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A6, interfaceC10970cW3B3, aVar3.e());
            DG7.c(interfaceC22053ub1A6, interfaceC11819dc1Q6, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B6 = aVar3.b();
            if (interfaceC22053ub1A6.h() || !AbstractC13042fc3.d(interfaceC22053ub1A6.B(), Integer.valueOf(iA6))) {
                interfaceC22053ub1A6.s(Integer.valueOf(iA6));
                interfaceC22053ub1A6.v(Integer.valueOf(iA6), interfaceC14603iB2B6);
            }
            DG7.c(interfaceC22053ub1A6, eVarE6, aVar3.f());
            AbstractC24077y03.b(FV4.c(AbstractC24188yB5.tv, interfaceC22053ub1J, 0), null, androidx.compose.foundation.layout.t.m(aVar, C17784nZ1.q(20)), g10.a(interfaceC22053ub1J, i6).F(), interfaceC22053ub1J, 432, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i6).b().n()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarA = m66.a(aVar, 1.0f, false);
            AbstractC23365wn7.a aVar4 = AbstractC23365wn7.a;
            int iB = aVar4.b();
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1J, i6).l();
            C6399Nk7.a aVar5 = C6399Nk7.b;
            AbstractC9339Zm7.b(str, eVarA, g10.a(interfaceC22053ub1J, i6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(aVar5.f()), 0L, iB, false, 1, 0, null, c9348Zn7L, interfaceC22053ub1J, (i5 >> 3) & 14, 3120, 54776);
            interfaceC22053ub1J.W(-1924150734);
            if (z) {
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i6).b().n()), interfaceC22053ub1J, 0);
                AbstractC11456d23.b(FV4.c(AbstractC24188yB5.blue_tick, interfaceC22053ub1J, 0), UY6.c(UD5.core_ui_verified_channel_badge, interfaceC22053ub1J, 0), androidx.compose.foundation.layout.t.m(aVar, C17784nZ1.q(18)), null, null, 0.0f, null, interfaceC22053ub1J, 384, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            }
            interfaceC22053ub1J.Q();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i6).b().n()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b("|", null, g10.a(interfaceC22053ub1J, i6).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i6).j(), interfaceC22053ub1J, 6, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i6).b().n()), interfaceC22053ub1J, 0);
            AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(1825583225, true, new a(str2), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i6).b().n()), interfaceC22053ub1J, 0);
            AbstractC9339Zm7.b(UY6.c(UD5.core_ui_member, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i6).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i6).j(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(5)), interfaceC22053ub1J, 6);
            AbstractC9339Zm7.b(UY6.d(i2, new Object[]{AbstractC12152e76.d(String.valueOf(i), interfaceC22053ub1J, 0)}, interfaceC22053ub1J, (i5 >> 12) & 14), androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1J, i6).z(), 0L, null, null, null, 0L, null, C6399Nk7.h(aVar5.f()), 0L, aVar4.b(), false, 0, 0, null, g10.d(interfaceC22053ub1J, i6).e(), interfaceC22053ub1J, 48, 48, 62968);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i6).b().u()), interfaceC22053ub1J, 0);
            AbstractC3559Bj3.e(interfaceC4027Dj3, false, interfaceC22053ub1J, (i5 >> 15) & 14, 2);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.lh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17863nh1.h(ev4, str, str2, i, i2, interfaceC4027Dj3, z, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(EV4 ev4, String str, String str2, int i, int i2, InterfaceC4027Dj3 interfaceC4027Dj3, boolean z, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(ev4, "$channelAvatarPainter");
        AbstractC13042fc3.i(str, "$channelName");
        AbstractC13042fc3.i(str2, "$channelFormattedMemberCount");
        AbstractC13042fc3.i(interfaceC4027Dj3, "$joinButtonStatus");
        g(ev4, str, str2, i, i2, interfaceC4027Dj3, z, interfaceC22053ub1, QJ5.a(i3 | 1));
        return C19938rB7.a;
    }

    public static final void i(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(690934860);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24695z31.a.c(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.kh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17863nh1.j(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        i(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void k(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1383042042);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24695z31.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.hh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17863nh1.l(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
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
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-747620100);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, g10.a(interfaceC22053ub1J, i2).r(), null, 2, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1J, i2).b().e());
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.b(), aVar2.i(), interfaceC22053ub1J, 54);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            M66 m66 = M66.a;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.m(aVar, C17784nZ1.q(50)), N46.g()), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i2).b().e()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarB = L66.b(m66, aVar, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1J, 0);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.l(androidx.compose.foundation.layout.t.q(aVar, C17784nZ1.q(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER)), C17784nZ1.q(20)), N46.b(100)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i2).b().c()), interfaceC22053ub1J, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.l(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(18)), N46.b(100)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i2).b().e()), interfaceC22053ub1J, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.l(androidx.compose.foundation.layout.t.q(aVar, C17784nZ1.q(48)), C17784nZ1.q(24)), N46.b(100)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.mh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17863nh1.n(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        m(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void o(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-826179677);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24695z31.a.f(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.jh1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17863nh1.p(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        o(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void q(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-134072495);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24695z31.a.e(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ih1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17863nh1.r(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        q(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
