package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import androidx.compose.ui.e;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC14677iJ0;
import ir.nasim.AbstractC17531n73;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;

/* renamed from: ir.nasim.n73, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC17531n73 {

    /* renamed from: ir.nasim.n73$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.n73$a$a, reason: collision with other inner class name */
        static final class C1407a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            C1407a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC20434s03.a(this.a, null, false, null, null, C10730c61.a.b(), interfaceC22053ub1, 196608, 30);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.h(C10730c61.a.a(), null, AbstractC19242q11.e(-1639527842, true, new C1407a(this.a), interfaceC22053ub1, 54), null, null, null, null, interfaceC22053ub1, 390, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.n73$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C8588Wp4 a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ boolean i;

        b(C8588Wp4 c8588Wp4, String str, String str2, String str3, String str4, String str5, UA2 ua2, UA2 ua22, boolean z) {
            this.a = c8588Wp4;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = ua2;
            this.h = ua22;
            this.i = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final ir.nasim.C19938rB7 d(java.lang.String r8, java.lang.String r9, ir.nasim.UA2 r10, ir.nasim.ZY0 r11, ir.nasim.InterfaceC9102Ym4 r12) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC17531n73.b.d(java.lang.String, java.lang.String, ir.nasim.UA2, ir.nasim.ZY0, ir.nasim.Ym4):ir.nasim.rB7");
        }

        private static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        private static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC20600sH6 interfaceC20600sH6, C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
            AbstractC13042fc3.i(c8588Wp4, "$navHostController");
            if (interfaceC20600sH6 != null) {
                interfaceC20600sH6.b();
            }
            androidx.navigation.e.S(c8588Wp4, AbstractC14677iJ0.b.a.b.a(), null, null, 6, null);
            return C19938rB7.a;
        }

        public final void c(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValue");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(1445561);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new androidx.compose.ui.focus.m();
                interfaceC22053ub1.s(objB);
            }
            androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1447410);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1.s(objB2);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1.Q();
            final InterfaceC20600sH6 interfaceC20600sH6 = (InterfaceC20600sH6) interfaceC22053ub1.H(AbstractC13040fc1.r());
            interfaceC22053ub1.W(1452962);
            final C8588Wp4 c8588Wp4 = this.a;
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.p73
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC17531n73.b.i(interfaceC20600sH6, c8588Wp4);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa2 = (SA2) objB3;
            interfaceC22053ub1.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(eVarM, g10.a(interfaceC22053ub1, i3).r(), null, 2, null);
            String str = this.b;
            final String str2 = this.c;
            String str3 = this.d;
            final String str4 = this.e;
            String str5 = this.f;
            UA2 ua2 = this.g;
            final UA2 ua22 = this.h;
            boolean z = this.i;
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(hVar.h(aVar2, aVar3.m()), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null);
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar3.g(), interfaceC22053ub1, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
            SA2 sa2A2 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar4.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar4.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar4.f());
            final C9784aZ0 c9784aZ0 = C9784aZ0.a;
            String strC = UY6.c(QD5.change_phone_number_desc, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(aVar2, g10.c(interfaceC22053ub1, i3).b().c());
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1, i3).b();
            AbstractC9339Zm7.b(strC, eVarI, g10.a(interfaceC22053ub1, i3).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7B.b((16744447 & 1) != 0 ? c9348Zn7B.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7B.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7B.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7B.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7B.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7B.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7B.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7B.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7B.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7B.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7B.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7B.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7B.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7B.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7B.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7B.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7B.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7B.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7B.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7B.c : null, (16744447 & 1048576) != 0 ? c9348Zn7B.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7B.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7B.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7B.b.k() : null), interfaceC22053ub1, 0, 0, 65528);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i3).b().c()), interfaceC22053ub1, 0);
            AbstractC18534op1.h(androidx.compose.foundation.layout.q.k(aVar2, g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null), str, str2, str3, sa2, interfaceC22053ub1, 24576, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i3).b().h()), interfaceC22053ub1, 0);
            interfaceC22053ub1.W(774982993);
            AbstractC14472hy4 aVar5 = (str4.length() == 0 && f(interfaceC9102Ym4)) ? new AbstractC14472hy4.a(Integer.valueOf(AbstractC21822uB5.danger), UY6.c(QD5.phone_number_req, interfaceC22053ub1, 0), null, 4, null) : (str5 == null || str5.length() == 0) ? new AbstractC14472hy4.d(null, null, null, 7, null) : new AbstractC14472hy4.a(Integer.valueOf(AbstractC21822uB5.danger), str5, null, 4, null);
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.A(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar2, g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null), 0.0f, 1, null), str4, ua2, str2, null, true, 0, 0, false, aVar5, mVar, sa2, null, false, interfaceC22053ub1, (AbstractC14472hy4.a << 27) | 196608, 54, 12752);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(hVar.h(aVar2, aVar3.b()), 0.0f, 1, null), g10.a(interfaceC22053ub1, i3).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.a(), aVar3.g(), interfaceC22053ub1, 54);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD2);
            SA2 sa2A3 = aVar4.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A2, aVar4.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar4.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar4.f());
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i3).A(), interfaceC22053ub1, 6, 2);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar2, g10.c(interfaceC22053ub1, i3).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(775041361);
            boolean zV = interfaceC22053ub1.V(str2) | interfaceC22053ub1.V(str4) | interfaceC22053ub1.V(ua22);
            Object objB4 = interfaceC22053ub1.B();
            if (zV || objB4 == aVar.a()) {
                Object obj = new SA2() { // from class: ir.nasim.q73
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC17531n73.b.d(str2, str4, ua22, c9784aZ0, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(obj);
                objB4 = obj;
            }
            SA2 sa22 = (SA2) objB4;
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarH, sa22, z ? OA2.a.b : str4.length() == 0 ? OA2.b.a.c : OA2.b.C0545b.c, null, UY6.c(QD5.create_group_button, interfaceC22053ub1, 0), null, interfaceC22053ub1, OA2.a << 6, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final SA2 sa2, final C8588Wp4 c8588Wp4, final String str, final String str2, final String str3, final String str4, final String str5, final UA2 ua2, final UA2 ua22, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(sa2, "onBack");
        AbstractC13042fc3.i(c8588Wp4, "navHostController");
        AbstractC13042fc3.i(str, "countryName");
        AbstractC13042fc3.i(str2, "countryCode");
        AbstractC13042fc3.i(str5, "phoneNumber");
        AbstractC13042fc3.i(ua2, "onPhoneNumberChanged");
        AbstractC13042fc3.i(ua22, "onStartClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-974050536);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(c8588Wp4) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(str3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(str5) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua22) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-133932068, true, new a(sa2), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1420728409, true, new b(c8588Wp4, str, str2, str3, str5, str4, ua2, ua22, z), interfaceC22053ub12, 54), interfaceC22053ub12, 805306422, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.j73
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17531n73.c(sa2, c8588Wp4, str, str2, str3, str4, str5, ua2, ua22, z, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(SA2 sa2, C8588Wp4 c8588Wp4, String str, String str2, String str3, String str4, String str5, UA2 ua2, UA2 ua22, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onBack");
        AbstractC13042fc3.i(c8588Wp4, "$navHostController");
        AbstractC13042fc3.i(str, "$countryName");
        AbstractC13042fc3.i(str2, "$countryCode");
        AbstractC13042fc3.i(str5, "$phoneNumber");
        AbstractC13042fc3.i(ua2, "$onPhoneNumberChanged");
        AbstractC13042fc3.i(ua22, "$onStartClicked");
        b(sa2, c8588Wp4, str, str2, str3, str4, str5, ua2, ua22, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
