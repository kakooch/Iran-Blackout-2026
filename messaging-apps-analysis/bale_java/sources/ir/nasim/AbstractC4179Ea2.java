package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Configuration;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.AbstractC4179Ea2;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Ea2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4179Ea2 {

    /* renamed from: ir.nasim.Ea2$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ O37 a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ C20158ra2 d;
        final /* synthetic */ long e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ InterfaceC9102Ym4 h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ SA2 k;

        /* renamed from: ir.nasim.Ea2$a$a, reason: collision with other inner class name */
        static final class C0343a implements InterfaceC15796kB2 {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ C20158ra2 c;
            final /* synthetic */ long d;
            final /* synthetic */ boolean e;
            final /* synthetic */ boolean f;
            final /* synthetic */ InterfaceC9102Ym4 g;
            final /* synthetic */ SA2 h;
            final /* synthetic */ SA2 i;
            final /* synthetic */ SA2 j;

            C0343a(String str, String str2, C20158ra2 c20158ra2, long j, boolean z, boolean z2, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, SA2 sa22, SA2 sa23) {
                this.a = str;
                this.b = str2;
                this.c = c20158ra2;
                this.d = j;
                this.e = z;
                this.f = z2;
                this.g = interfaceC9102Ym4;
                this.h = sa2;
                this.i = sa22;
                this.j = sa23;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(sa2, "$onCountDownTimerEnded");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible$delegate");
                AbstractC4179Ea2.h(interfaceC9102Ym4, false);
                sa2.invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(sa2, "$onCloseOrDismiss");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible$delegate");
                AbstractC4179Ea2.h(interfaceC9102Ym4, false);
                sa2.invoke();
                return C19938rB7.a;
            }

            public final void c(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(l66, "$this$SwipeToDismissBox");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                String str = this.a;
                String str2 = this.b;
                C20158ra2 c20158ra2 = this.c;
                long j = this.d;
                boolean z = this.e;
                boolean z2 = this.f;
                interfaceC22053ub1.W(-80251584);
                boolean zV = interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(this.h);
                final SA2 sa2 = this.h;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.g;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Ca2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC4179Ea2.a.C0343a.d(sa2, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa22 = (SA2) objB;
                interfaceC22053ub1.Q();
                SA2 sa23 = this.i;
                interfaceC22053ub1.W(-80245669);
                boolean zV2 = interfaceC22053ub1.V(this.g) | interfaceC22053ub1.V(this.j);
                final SA2 sa24 = this.j;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.g;
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Da2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC4179Ea2.a.C0343a.f(sa24, interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC4179Ea2.n(str, str2, c20158ra2, j, z, z2, sa22, sa23, (SA2) objB2, interfaceC22053ub1, 0, 0);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                c((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(O37 o37, String str, String str2, C20158ra2 c20158ra2, long j, boolean z, boolean z2, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa2, SA2 sa22, SA2 sa23) {
            this.a = o37;
            this.b = str;
            this.c = str2;
            this.d = c20158ra2;
            this.e = j;
            this.f = z;
            this.g = z2;
            this.h = interfaceC9102Ym4;
            this.i = sa2;
            this.j = sa22;
            this.k = sa23;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            N37.a(this.a, C24125y51.a.a(), null, false, false, false, AbstractC19242q11.e(371819480, true, new C0343a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k), interfaceC22053ub1, 54), interfaceC22053ub1, O37.d | 1572912, 60);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ea2$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ C20158ra2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ boolean c;
        final /* synthetic */ long d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ String i;

        /* renamed from: ir.nasim.Ea2$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                AbstractC13042fc3.i(l66, "$this$Button");
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(l66) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC9339Zm7.b(this.a, l66.c(androidx.compose.ui.e.a, InterfaceC12529em.a.i()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, G10.b).p(), interfaceC22053ub1, 0, 0, 65532);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(C20158ra2 c20158ra2, SA2 sa2, boolean z, long j, SA2 sa22, boolean z2, String str, SA2 sa23, String str2) {
            this.a = c20158ra2;
            this.b = sa2;
            this.c = z;
            this.d = j;
            this.e = sa22;
            this.f = z2;
            this.g = str;
            this.h = sa23;
            this.i = str2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            boolean z;
            C20158ra2 c20158ra2;
            String str;
            M66 m66;
            int i2;
            int i3;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), this.a.a(interfaceC22053ub1, 0), null, 2, null), false, null, null, this.b, 7, null);
            C20158ra2 c20158ra22 = this.a;
            boolean z2 = this.c;
            long j = this.d;
            SA2 sa2 = this.e;
            boolean z3 = this.f;
            String str2 = this.g;
            SA2 sa22 = this.b;
            SA2 sa23 = this.h;
            String str3 = this.i;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), c20158ra22.b(interfaceC22053ub1, 0), null, 2, null);
            EV4 ev4C = FV4.c(z2 ? AbstractC24188yB5.event_bar_sketch_timer_right : AbstractC24188yB5.event_bar_sketch_simple_right, interfaceC22053ub1, 0);
            AbstractC24975zX0.a aVar4 = AbstractC24975zX0.b;
            AbstractC24975zX0 abstractC24975zX0B = AbstractC24975zX0.a.b(aVar4, c20158ra22.e(interfaceC22053ub1, 0), 0, 2, null);
            C22297v0 c22297v0 = C22297v0.a;
            androidx.compose.ui.e eVarB = androidx.compose.ui.draw.d.b(androidx.compose.ui.draw.d.b(eVarD, ev4C, false, c22297v0.b(), null, 0.0f, abstractC24975zX0B, 26, null), FV4.c(z2 ? AbstractC24188yB5.event_bar_sketch_timer_left : AbstractC24188yB5.event_bar_sketch_simple_left, interfaceC22053ub1, 0), false, c22297v0.a(), null, 0.0f, AbstractC24975zX0.a.b(aVar4, c20158ra22.e(interfaceC22053ub1, 0), 0, 2, null), 26, null);
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar2.e(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
            SA2 sa2A2 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A2);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i4 = G10.b;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(eVarH, g10.c(interfaceC22053ub1, i4).b().e(), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.p(g10.c(interfaceC22053ub1, i4).b().u(), aVar2.g()), aVar2.i(), interfaceC22053ub1, 48);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
            SA2 sa2A3 = aVar3.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A3);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            M66 m662 = M66.a;
            if (z2) {
                interfaceC22053ub1.W(-1695159593);
                str = str2;
                z = z3;
                c20158ra2 = c20158ra22;
                m66 = m662;
                i2 = 0;
                AbstractC8342Vo1.c(j - System.currentTimeMillis(), androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.c(aVar, c20158ra22.e(interfaceC22053ub1, 0), N46.g()), g10.c(interfaceC22053ub1, i4).b().u(), g10.c(interfaceC22053ub1, i4).b().n()), g10.d(interfaceC22053ub1, i4).k(), C6399Nk7.h(C6399Nk7.b.a()), g10.a(interfaceC22053ub1, i4).F(), sa2, interfaceC22053ub1, 0, 0);
                interfaceC22053ub1.Q();
                i3 = i4;
            } else {
                z = z3;
                c20158ra2 = c20158ra22;
                str = str2;
                m66 = m662;
                i2 = 0;
                if (z) {
                    interfaceC22053ub1.W(-1694201197);
                    i3 = i4;
                    AbstractC11456d23.b(FV4.c(KB5.ic_bale, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.m(aVar, g10.c(interfaceC22053ub1, i3).b().f()), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                    interfaceC22053ub1.Q();
                } else {
                    i3 = i4;
                    interfaceC22053ub1.W(-1693891755);
                    interfaceC22053ub1.Q();
                }
            }
            androidx.compose.ui.e eVarB2 = L66.b(m66, aVar, 1.0f, false, 2, null);
            C9348Zn7 c9348Zn7C = g10.d(interfaceC22053ub1, i3).c();
            C6399Nk7.a aVar5 = C6399Nk7.b;
            C20158ra2 c20158ra23 = c20158ra2;
            int i5 = i3;
            AbstractC9339Zm7.b(str, eVarB2, c20158ra23.f(interfaceC22053ub1, i2), 0L, null, null, null, 0L, null, C6399Nk7.h(z ? aVar5.f() : aVar5.a()), 0L, AbstractC23365wn7.a.b(), false, 1, 0, null, c9348Zn7C, interfaceC22053ub1, 0, 3120, 54776);
            AbstractC16159ko0.a(sa22, androidx.compose.foundation.layout.t.s(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i5).b().l()), C17784nZ1.q(46), 0.0f, 2, null), false, N46.d(g10.c(interfaceC22053ub1, i5).a().d()), C6679On0.a.b(g10.a(interfaceC22053ub1, i5).M(), c20158ra23.c(interfaceC22053ub1, 0), 0L, 0L, interfaceC22053ub1, C6679On0.o << 12, 12), null, AbstractC11256ci0.a(C17784nZ1.q(1), c20158ra23.c(interfaceC22053ub1, 0)), androidx.compose.foundation.layout.q.b(g10.c(interfaceC22053ub1, i5).b().u(), g10.c(interfaceC22053ub1, i5).b().r()), null, AbstractC19242q11.e(603995075, true, new a(str3), interfaceC22053ub1, 54), interfaceC22053ub1, 805306368, 292);
            AbstractC13303g00.c(androidx.compose.foundation.layout.t.m(aVar, g10.c(interfaceC22053ub1, i5).b().f()), FV4.c(AbstractC24188yB5.close, interfaceC22053ub1, 0), 0.0f, c20158ra23.d(interfaceC22053ub1, 0), null, null, sa23, interfaceC22053ub1, 0, 52);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void f(final String str, final String str2, final C20158ra2 c20158ra2, final long j, final boolean z, boolean z2, final SA2 sa2, final SA2 sa22, final SA2 sa23, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub12;
        final boolean z3;
        AbstractC13042fc3.i(str, "eventTitleText");
        AbstractC13042fc3.i(str2, "eventButtonText");
        AbstractC13042fc3.i(c20158ra2, "eventBarColors");
        AbstractC13042fc3.i(sa2, "onCountDownTimerEnded");
        AbstractC13042fc3.i(sa22, "onEventBarClick");
        AbstractC13042fc3.i(sa23, "onCloseOrDismiss");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(43284035);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(c20158ra2) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.f(j) ? 2048 : 1024;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 16384 : 8192;
        }
        int i4 = i2 & 32;
        if (i4 != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= interfaceC22053ub1J.a(z2) ? 131072 : 65536;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 1048576 : 524288;
        }
        if ((i2 & 128) != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i3 |= interfaceC22053ub1J.D(sa22) ? 8388608 : 4194304;
        }
        if ((i2 & 256) != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i3 |= interfaceC22053ub1J.D(sa23) ? 67108864 : 33554432;
        }
        if ((38347923 & i3) == 38347922 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
            z3 = z2;
        } else {
            boolean z4 = i4 != 0 ? false : z2;
            final int i5 = ((Configuration) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.f())).screenWidthDp;
            interfaceC22053ub1J.W(1982576791);
            boolean z5 = (458752 & i3) == 131072;
            Object objB = interfaceC22053ub1J.B();
            if (z5 || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1982581721);
            final WH1 wh1 = (WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g());
            interfaceC22053ub1J.W(725077465);
            boolean zV = interfaceC22053ub1J.V(wh1) | interfaceC22053ub1J.e(i5);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.ya2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Float.valueOf(AbstractC4179Ea2.i(wh1, i5, ((Float) obj).floatValue()));
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            UA2 ua2 = (UA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1982584833);
            boolean zV2 = ((i3 & 234881024) == 67108864) | interfaceC22053ub1J.V(interfaceC9102Ym4);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.za2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AbstractC4179Ea2.j(sa23, interfaceC9102Ym4, (P37) obj));
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC22231ut.f(g(interfaceC9102Ym4), null, null, androidx.compose.animation.f.y(null, null, false, null, 15, null).c(androidx.compose.animation.f.q(null, 0.0f, 3, null)), null, AbstractC19242q11.e(-79568101, true, new a(N37.c(null, (UA2) objB3, ua2, interfaceC22053ub1J, 0, 1), str, str2, c20158ra2, j, z, z4, interfaceC9102Ym4, sa2, sa22, sa23), interfaceC22053ub12, 54), interfaceC22053ub12, 199680, 22);
            z3 = z4;
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Aa2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4179Ea2.k(str, str2, c20158ra2, j, z, z3, sa2, sa22, sa23, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float i(WH1 wh1, int i, float f) {
        AbstractC13042fc3.i(wh1, "$this_with");
        return wh1.w1(C17784nZ1.q(i)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, P37 p37) {
        AbstractC13042fc3.i(sa2, "$onCloseOrDismiss");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible$delegate");
        AbstractC13042fc3.i(p37, "it");
        if (p37 != P37.StartToEnd && p37 != P37.EndToStart) {
            return false;
        }
        h(interfaceC9102Ym4, false);
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(String str, String str2, C20158ra2 c20158ra2, long j, boolean z, boolean z2, SA2 sa2, SA2 sa22, SA2 sa23, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$eventTitleText");
        AbstractC13042fc3.i(str2, "$eventButtonText");
        AbstractC13042fc3.i(c20158ra2, "$eventBarColors");
        AbstractC13042fc3.i(sa2, "$onCountDownTimerEnded");
        AbstractC13042fc3.i(sa22, "$onEventBarClick");
        AbstractC13042fc3.i(sa23, "$onCloseOrDismiss");
        f(str, str2, c20158ra2, j, z, z2, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void l(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1369579216);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24125y51.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xa2
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4179Ea2.m(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        l(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(final java.lang.String r17, final java.lang.String r18, final ir.nasim.C20158ra2 r19, final long r20, final boolean r22, boolean r23, final ir.nasim.SA2 r24, final ir.nasim.SA2 r25, final ir.nasim.SA2 r26, ir.nasim.InterfaceC22053ub1 r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4179Ea2.n(java.lang.String, java.lang.String, ir.nasim.ra2, long, boolean, boolean, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(String str, String str2, C20158ra2 c20158ra2, long j, boolean z, boolean z2, SA2 sa2, SA2 sa22, SA2 sa23, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$eventTitleText");
        AbstractC13042fc3.i(str2, "$eventButtonText");
        AbstractC13042fc3.i(c20158ra2, "$eventBarColors");
        AbstractC13042fc3.i(sa2, "$onCountDownTimerEnded");
        AbstractC13042fc3.i(sa22, "$onEventBarClick");
        AbstractC13042fc3.i(sa23, "$onCloseClick");
        n(str, str2, c20158ra2, j, z, z2, sa2, sa22, sa23, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
