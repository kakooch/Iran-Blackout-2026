package ir.nasim;

import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC13313g10;
import ir.nasim.AbstractC7190Qq6;
import ir.nasim.C24111y37;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.W23;

/* renamed from: ir.nasim.g10, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC13313g10 {

    /* renamed from: ir.nasim.g10$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        public final void a(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$Card");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            coil.compose.d.a(new W23.a((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).d(this.a).e(new C24111y37.b(false, 1, null)).a(), null, androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16)), C17784nZ1.q(28)), null, null, null, null, 0.0f, null, 0, false, null, interfaceC22053ub1, 432, 0, 4088);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.g10$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            String strV = XY6.v(String.valueOf(this.a));
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strV, null, g10.a(interfaceC22053ub1, i2).G(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).p(), interfaceC22053ub1, 0, 0, 65530);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.g10$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;

        c(SA2 sa2) {
            this.a = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onClick");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(eVar, "$this$composed");
            interfaceC22053ub1.W(-840598233);
            interfaceC22053ub1.W(1994827860);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
            interfaceC22053ub1.Q();
            InterfaceC17521n63 interfaceC17521n63F = androidx.compose.material.a.f(true, 0.0f, 0L, 6, null);
            interfaceC22053ub1.W(1994829722);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.h10
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13313g10.c.c(sa2);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(eVar, interfaceC18507om4, interfaceC17521n63F, false, null, null, (SA2) objB2, 28, null);
            interfaceC22053ub1.Q();
            return eVarD;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        z(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void B(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1984539235);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            s(interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Y00
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13313g10.C(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        B(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e D(androidx.compose.ui.e eVar, SA2 sa2) {
        AbstractC13042fc3.i(eVar, "<this>");
        AbstractC13042fc3.i(sa2, "onClick");
        return androidx.compose.ui.c.c(eVar, null, new c(sa2), 1, null);
    }

    public static final void l(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(512441977);
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
            androidx.compose.ui.e eVar4 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            C24254yJ.m mVarH = C24254yJ.a.h();
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar4);
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
            e.a aVar3 = androidx.compose.ui.e.a;
            float f = 34;
            float f2 = 18;
            float f3 = 8;
            float f4 = 0;
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.foundation.layout.t.v(aVar3, C17784nZ1.q(f), C17784nZ1.q(f2)), N46.e(C17784nZ1.q(f3), C17784nZ1.q(f3), C17784nZ1.q(f3), C17784nZ1.q(f4)));
            G10 g10 = G10.a;
            int i5 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarA, g10.a(interfaceC22053ub1J, i5).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
            androidx.compose.ui.e eVar5 = eVar4;
            SA2 sa2A2 = aVar2.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar2.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.b.d(FV0.a(androidx.compose.foundation.layout.t.v(aVar3, C17784nZ1.q(f), C17784nZ1.q(f2)), N46.e(C17784nZ1.q(f3), C17784nZ1.q(f3), C17784nZ1.q(f3), C17784nZ1.q(f4))), g10.a(interfaceC22053ub1J, i5).f(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar.e(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD2);
            SA2 sa2A3 = aVar2.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar2.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar2.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar2.f());
            eVar3 = eVar5;
            AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.badge_new, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i5).e(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i5).i(), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            float f5 = 3;
            final float fQ = C17784nZ1.q(f5);
            final long jE = g10.a(interfaceC22053ub1J, i5).e();
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar3, C17784nZ1.q(f)), C17784nZ1.q(f5));
            interfaceC22053ub1J.W(-1498064968);
            boolean zF = interfaceC22053ub1J.f(jE);
            Object objB = interfaceC22053ub1J.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Z00
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC13313g10.m(jE, fQ, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC22443vF0.a(eVarI, (UA2) objB, interfaceC22053ub1J, 6);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.a10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13313g10.n(eVar3, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(long j, float f, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        V05 v05A = AbstractC21611tq.a();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
        v05A.a(fIntBitsToFloat2 - interfaceC17460n02.w1(f), -0.3f);
        v05A.c(fIntBitsToFloat2, -0.3f);
        v05A.c(fIntBitsToFloat2 - interfaceC17460n02.w1(f), fIntBitsToFloat);
        InterfaceC17460n02.X0(interfaceC17460n02, v05A, j, 0.0f, null, null, 0, 60, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        l(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0320  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final java.lang.String r28, final java.lang.String r29, ir.nasim.SA2 r30, ir.nasim.AbstractC7190Qq6 r31, ir.nasim.InterfaceC22053ub1 r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC13313g10.o(java.lang.String, java.lang.String, ir.nasim.SA2, ir.nasim.Qq6, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(SA2 sa2) {
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(String str, String str2, SA2 sa2, AbstractC7190Qq6 abstractC7190Qq6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(str2, "$iconUrl");
        o(str, str2, sa2, abstractC7190Qq6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void s(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-975293607);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), bVarG, interfaceC22053ub1J, 48);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            float f = 60;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar, 0.0f, 0.0f, 0.0f, C17784nZ1.q(6), 7, null), C17784nZ1.q(f)), N46.d(C17784nZ1.q(14))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.v(aVar, C17784nZ1.q(f), C17784nZ1.q(18)), N46.d(C17784nZ1.q(8))), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.b10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13313g10.t(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        s(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void u(androidx.compose.ui.e eVar, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        androidx.compose.ui.e eVar2;
        int i4;
        final androidx.compose.ui.e eVar3;
        long jI;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1021126579);
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
        if ((2 & i3) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i5 != 0 ? androidx.compose.ui.e.a : eVar2;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(eVar3, C17784nZ1.q(20));
            float fQ = C17784nZ1.q(1);
            G10 g10 = G10.a;
            int i6 = G10.b;
            float f = 5;
            androidx.compose.ui.e eVarA = FV0.a(AbstractC9287Zh0.f(eVarT, fQ, g10.a(interfaceC22053ub1J, i6).B(), N46.d(C17784nZ1.q(f))), N46.d(C17784nZ1.q(f)));
            if (i == 0) {
                interfaceC22053ub1J.W(-1981303807);
                jI = g10.a(interfaceC22053ub1J, i6).y();
            } else {
                interfaceC22053ub1J.W(-1981302747);
                jI = g10.a(interfaceC22053ub1J, i6).I();
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarA, jI, null, 2, null);
            interfaceC22053ub1J.W(-1981300059);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1981297203);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.c10
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13313g10.v();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.e.d(eVarD, interfaceC18507om4, null, false, null, null, (SA2) objB2, 28, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD2);
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
            AbstractC22231ut.f(i > 0, null, androidx.compose.animation.f.o(null, 0.0f, 3, null), androidx.compose.animation.f.q(null, 0.0f, 3, null), null, AbstractC19242q11.e(-1652299503, true, new b(i), interfaceC22053ub1J, 54), interfaceC22053ub1J, 200064, 18);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.d10
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13313g10.w(eVar3, i, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(androidx.compose.ui.e eVar, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        u(eVar, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void x(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-364705547);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            u(null, 4, interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.V00
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13313g10.y(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        x(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void z(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(309911434);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            o("other services", "", null, AbstractC7190Qq6.b.a, interfaceC22053ub1J, 3126, 4);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.X00
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13313g10.A(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
