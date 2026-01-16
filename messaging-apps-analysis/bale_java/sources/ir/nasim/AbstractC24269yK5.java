package ir.nasim;

import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC24269yK5;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.OA2;

/* renamed from: ir.nasim.yK5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24269yK5 {

    /* renamed from: ir.nasim.yK5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.two_f_a_setting, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.yK5$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ boolean d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ UA2 g;

        b(String str, String str2, UA2 ua2, boolean z, UA2 ua22, SA2 sa2, UA2 ua23) {
            this.a = str;
            this.b = str2;
            this.c = ua2;
            this.d = z;
            this.e = ua22;
            this.f = sa2;
            this.g = ua23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean d(UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$isEmailValid");
            AbstractC13042fc3.i(str, "$email");
            return !((Boolean) ua2.invoke(str)).booleanValue();
        }

        private static final boolean f(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(boolean z, String str, UA2 ua2, Context context, SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6) {
            AbstractC13042fc3.i(str, "$email");
            AbstractC13042fc3.i(context, "$context");
            AbstractC13042fc3.i(interfaceC9664aL6, "$isInValidEmail$delegate");
            if (z) {
                return C19938rB7.a;
            }
            if (str.length() == 0) {
                String string = context.getString(QD5.req_email_for_two_f_a);
                AbstractC13042fc3.h(string, "getString(...)");
                ua2.invoke(string);
            } else if (f(interfaceC9664aL6)) {
                String string2 = context.getString(QD5.recovery_email_inc_two_f_a);
                AbstractC13042fc3.h(string2, "getString(...)");
                ua2.invoke(string2);
            } else {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "it");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarM, g10.a(interfaceC22053ub1, i3).r(), null, 2, null);
            String str = this.a;
            final String str2 = this.b;
            UA2 ua2 = this.c;
            final boolean z = this.d;
            final UA2 ua22 = this.e;
            final SA2 sa2 = this.f;
            final UA2 ua23 = this.g;
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(hVar.h(aVar, aVar2.m()), g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null);
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(48)), interfaceC22053ub1, 6);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            String strC = UY6.c(QD5.email_two_f_a_button, interfaceC22053ub1, 0);
            long jF = g10.a(interfaceC22053ub1, i3).F();
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1, i3).l();
            C6399Nk7.a aVar4 = C6399Nk7.b;
            AbstractC9339Zm7.b(strC, eVarH, jF, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : aVar4.a(), (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub1, 48, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i3).b().c()), interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarH2 = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            String strC2 = UY6.c(QD5.email_two_f_a_set_desc, interfaceC22053ub1, 0);
            long jZ = g10.a(interfaceC22053ub1, i3).z();
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1, i3).a();
            AbstractC9339Zm7.b(strC2, eVarH2, jZ, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : aVar4.a(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1, 48, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i3).b().e()), interfaceC22053ub1, 0);
            AbstractC8426Vx4.e0(str2, ua2, UY6.c(QD5.email_header, interfaceC22053ub1, 0), "example@gmail.com", androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), null, false, false, null, null, (str == null || str.length() == 0) ? new AbstractC14472hy4.d(null, null, null, 7, null) : new AbstractC14472hy4.a(Integer.valueOf(AbstractC21822uB5.danger), str, null, 4, null), new C21605tp3(0, null, C22785vp3.b.c(), S33.b.b(), null, null, null, 115, null), null, true, 0, 0, null, null, false, true, null, true, interfaceC22053ub1, 27648, AbstractC14472hy4.a | 805309488, 48, 1561568);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarH3 = androidx.compose.foundation.layout.t.h(hVar.h(aVar, aVar2.b()), 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.a(), aVar2.g(), interfaceC22053ub1, 54);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH3);
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            interfaceC22053ub1.W(1163566548);
            boolean zV = interfaceC22053ub1.V(str2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.zK5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(AbstractC24269yK5.b.d(ua23, str2));
                    }
                });
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
            interfaceC22053ub1.Q();
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i3).A(), interfaceC22053ub1, 6, 2);
            final Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
            androidx.compose.ui.e eVarH4 = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i3).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(1163586805);
            boolean zA = interfaceC22053ub1.a(z) | interfaceC22053ub1.V(str2) | interfaceC22053ub1.V(ua22) | interfaceC22053ub1.D(context) | interfaceC22053ub1.V(interfaceC9664aL6) | interfaceC22053ub1.V(sa2);
            Object objB2 = interfaceC22053ub1.B();
            if (zA || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.AK5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24269yK5.b.h(z, str2, ua22, context, sa2, interfaceC9664aL6);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa22 = (SA2) objB2;
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarH4, sa22, z ? OA2.a.b : str2.length() == 0 ? OA2.b.a.c : OA2.b.C0545b.c, null, UY6.c(QD5.create_group_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, OA2.a << 6, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(ir.nasim.SA2 r32, ir.nasim.SA2 r33, final java.lang.String r34, final ir.nasim.UA2 r35, java.lang.String r36, ir.nasim.UA2 r37, final ir.nasim.UA2 r38, final boolean r39, ir.nasim.InterfaceC22053ub1 r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24269yK5.e(ir.nasim.SA2, ir.nasim.SA2, java.lang.String, ir.nasim.UA2, java.lang.String, ir.nasim.UA2, ir.nasim.UA2, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(SA2 sa2, SA2 sa22, String str, UA2 ua2, String str2, UA2 ua22, UA2 ua23, boolean z, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$email");
        AbstractC13042fc3.i(ua2, "$onEmailChange");
        AbstractC13042fc3.i(ua23, "$isEmailValid");
        e(sa2, sa22, str, ua2, str2, ua22, ua23, z, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
