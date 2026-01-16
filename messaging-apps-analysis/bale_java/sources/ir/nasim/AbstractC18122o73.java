package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Resources;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC18122o73;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.LP;
import ir.nasim.OA2;
import ir.nasim.VI3;

/* renamed from: ir.nasim.o73, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC18122o73 {

    /* renamed from: ir.nasim.o73$a */
    static final class a implements PointerInputEventHandler {
        final /* synthetic */ InterfaceC3630Br2 a;

        a(InterfaceC3630Br2 interfaceC3630Br2) {
            this.a = interfaceC3630Br2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(InterfaceC3630Br2 interfaceC3630Br2, ZG4 zg4) {
            AbstractC13042fc3.i(interfaceC3630Br2, "$localFocusManager");
            InterfaceC3630Br2.m(interfaceC3630Br2, false, 1, null);
            return C19938rB7.a;
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
            final InterfaceC3630Br2 interfaceC3630Br2 = this.a;
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.m73
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC18122o73.a.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o73$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.o73$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            /* renamed from: ir.nasim.o73$b$a$a, reason: collision with other inner class name */
            static final class C1419a implements InterfaceC15796kB2 {
                final /* synthetic */ SA2 a;

                C1419a(SA2 sa2) {
                    this.a = sa2;
                }

                public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(l66, "$this$CenterAlignedTopAppBar");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                    } else {
                        AbstractC16288l12.f(this.a, false, false, interfaceC22053ub1, 432, 0);
                    }
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                ED.a(C10114b61.a.a(), null, null, AbstractC19242q11.e(995132313, true, new C1419a(this.a), interfaceC22053ub1, 54), 0.0f, null, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).r(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 3078, 182);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(-670235767, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.o73$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC16978mB2 c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC20600sH6 g;
        final /* synthetic */ C8588Wp4 h;
        final /* synthetic */ LP i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ androidx.compose.ui.focus.m k;
        final /* synthetic */ InterfaceC9102Ym4 l;
        final /* synthetic */ InterfaceC9102Ym4 m;

        c(String str, String str2, InterfaceC16978mB2 interfaceC16978mB2, String str3, String str4, boolean z, InterfaceC20600sH6 interfaceC20600sH6, C8588Wp4 c8588Wp4, LP lp, UA2 ua2, androidx.compose.ui.focus.m mVar, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42) {
            this.a = str;
            this.b = str2;
            this.c = interfaceC16978mB2;
            this.d = str3;
            this.e = str4;
            this.f = z;
            this.g = interfaceC20600sH6;
            this.h = c8588Wp4;
            this.i = lp;
            this.j = ua2;
            this.k = mVar;
            this.l = interfaceC9102Ym4;
            this.m = interfaceC9102Ym42;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(InterfaceC20600sH6 interfaceC20600sH6, C8588Wp4 c8588Wp4) throws Resources.NotFoundException {
            AbstractC13042fc3.i(c8588Wp4, "$navHostController");
            if (interfaceC20600sH6 != null) {
                interfaceC20600sH6.b();
            }
            androidx.navigation.e.S(c8588Wp4, VI3.d.a.b.a(), null, null, 6, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final ir.nasim.C19938rB7 h(java.lang.String r8, java.lang.String r9, ir.nasim.InterfaceC16978mB2 r10, java.lang.String r11, java.lang.String r12, ir.nasim.ZY0 r13, ir.nasim.InterfaceC9102Ym4 r14, ir.nasim.InterfaceC9102Ym4 r15) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC18122o73.c.h(java.lang.String, java.lang.String, ir.nasim.mB2, java.lang.String, java.lang.String, ir.nasim.ZY0, ir.nasim.Ym4, ir.nasim.Ym4):ir.nasim.rB7");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$synced$delegate");
            AbstractC18122o73.g(interfaceC9102Ym4, z);
            return C19938rB7.a;
        }

        public final void d(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC14472hy4 dVar;
            final InterfaceC9102Ym4 interfaceC9102Ym4;
            AbstractC13042fc3.i(ts4, "paddingValues");
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
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.b.d(eVarF, g10.a(interfaceC22053ub1, i3).r(), null, 2, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar2.g();
            final String str = this.a;
            final String str2 = this.b;
            final InterfaceC16978mB2 interfaceC16978mB2 = this.c;
            final String str3 = this.d;
            final String str4 = this.e;
            boolean z = this.f;
            final InterfaceC20600sH6 interfaceC20600sH6 = this.g;
            final C8588Wp4 c8588Wp4 = this.h;
            LP lp = this.i;
            UA2 ua2 = this.j;
            androidx.compose.ui.focus.m mVar = this.k;
            final InterfaceC9102Ym4 interfaceC9102Ym42 = this.l;
            InterfaceC9102Ym4 interfaceC9102Ym43 = this.m;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, bVarG, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            final C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1.W(-552751310);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar4 = InterfaceC22053ub1.a;
            if (objB == aVar4.a()) {
                objB = new SA2() { // from class: ir.nasim.r73
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18122o73.c.f(interfaceC20600sH6, c8588Wp4);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(60)), interfaceC22053ub1, 6);
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(ZY0.b(c9784aZ0, aVar, 1.0f, false, 2, null), AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1), false, null, false, 14, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.h(), aVar2.g(), interfaceC22053ub1, 54);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            AbstractC9339Zm7.b(UY6.c(AbstractC24206yD5.phone, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i3).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).l(), interfaceC22053ub1, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i3).b().c()), interfaceC22053ub1, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC24206yD5.phone_country, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).b(), interfaceC22053ub1, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i3).b().c()), interfaceC22053ub1, 0);
            AbstractC18534op1.h(androidx.compose.foundation.layout.q.k(aVar, g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null), str3, str, str4, sa2, interfaceC22053ub1, 24576, 0);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar, g10.c(interfaceC22053ub1, i3).b().h()), interfaceC22053ub1, 0);
            if (str2.length() == 0 && AbstractC18122o73.d(interfaceC9102Ym42)) {
                interfaceC22053ub1.W(1466336803);
                dVar = new AbstractC14472hy4.a(Integer.valueOf(IB5.danger), UY6.c(AbstractC24206yD5.phone_number_req, interfaceC22053ub1, 0), null, 4, null);
                interfaceC22053ub1.Q();
            } else if (lp instanceof LP.a) {
                interfaceC22053ub1.W(1466596986);
                LP.a aVar5 = (LP.a) lp;
                Integer numD = aVar5.d();
                String strC = numD == null ? null : UY6.c(numD.intValue(), interfaceC22053ub1, 0);
                if (strC == null) {
                    strC = aVar5.e();
                }
                dVar = new AbstractC14472hy4.a(Integer.valueOf(IB5.danger), strC, null, 4, null);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(1466919572);
                interfaceC22053ub1.Q();
                dVar = new AbstractC14472hy4.d(null, null, null, 7, null);
            }
            AbstractC8426Vx4.A(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar, g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null), 0.0f, 1, null), str2, ua2, str, null, true, 0, 0, false, dVar, mVar, sa2, "PHONE_TEXT_FIELD_LOGIN_TAG", true, interfaceC22053ub1, (AbstractC14472hy4.a << 27) | 196608, 3510, 464);
            interfaceC22053ub1.W(-91206304);
            if (C13923h3.a.t()) {
                int i4 = AbstractC24206yD5.sync_contacts;
                boolean zF = AbstractC18122o73.f(interfaceC9102Ym43);
                interfaceC22053ub1.W(-91201788);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar4.a()) {
                    interfaceC9102Ym4 = interfaceC9102Ym43;
                    objB2 = new UA2() { // from class: ir.nasim.s73
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC18122o73.c.i(interfaceC9102Ym4, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                } else {
                    interfaceC9102Ym4 = interfaceC9102Ym43;
                }
                interfaceC22053ub1.Q();
                AbstractC18122o73.i(new C17720nS0(i4, zF, false, null, (UA2) objB2, 12, null), interfaceC22053ub1, C17720nS0.f);
            } else {
                interfaceC9102Ym4 = interfaceC9102Ym43;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g10.a(interfaceC22053ub1, i3).A(), interfaceC22053ub1, 6, 2);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i3).b().c()), 0.0f, 1, null);
            interfaceC22053ub1.W(-552631200);
            boolean zV = interfaceC22053ub1.V(str) | interfaceC22053ub1.V(str2) | interfaceC22053ub1.V(interfaceC16978mB2) | interfaceC22053ub1.V(str3) | interfaceC22053ub1.V(str4);
            Object objB3 = interfaceC22053ub1.B();
            if (zV || objB3 == aVar4.a()) {
                final InterfaceC9102Ym4 interfaceC9102Ym44 = interfaceC9102Ym4;
                objB3 = new SA2() { // from class: ir.nasim.t73
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC18122o73.c.h(str, str2, interfaceC16978mB2, str3, str4, c9784aZ0, interfaceC9102Ym42, interfaceC9102Ym44);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa22 = (SA2) objB3;
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarH, sa22, z ? OA2.a.b : str2.length() == 0 ? OA2.b.a.c : OA2.b.C0545b.c, null, UY6.c(AbstractC24206yD5.create_group_button, interfaceC22053ub1, 0), "PHONE_BUTTON_LOGIN_TAG", interfaceC22053ub1, (OA2.a << 6) | 196608, 8);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(final C8588Wp4 c8588Wp4, final String str, final String str2, final String str3, final String str4, final UA2 ua2, final InterfaceC16978mB2 interfaceC16978mB2, final LP lp, final boolean z, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c8588Wp4, "navHostController");
        AbstractC13042fc3.i(str, "countryName");
        AbstractC13042fc3.i(str2, "countryCode");
        AbstractC13042fc3.i(str4, "phoneNumber");
        AbstractC13042fc3.i(ua2, "onPhoneNumberChanged");
        AbstractC13042fc3.i(interfaceC16978mB2, "onStartAuthClicked");
        AbstractC13042fc3.i(lp, "error");
        AbstractC13042fc3.i(sa2, "onSaveLogsClicked");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1815196155);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c8588Wp4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(str3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.V(str4) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC16978mB2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(lp) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            InterfaceC20600sH6 interfaceC20600sH6 = (InterfaceC20600sH6) interfaceC22053ub1J.H(AbstractC13040fc1.r());
            InterfaceC3630Br2 interfaceC3630Br2 = (InterfaceC3630Br2) interfaceC22053ub1J.H(AbstractC13040fc1.h());
            interfaceC22053ub1J.W(-1847124878);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                InterfaceC9102Ym4 interfaceC9102Ym4D = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
                interfaceC22053ub1J.s(interfaceC9102Ym4D);
                objB = interfaceC9102Ym4D;
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1847122799);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
                interfaceC22053ub1J.s(objB2);
            }
            InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-1847120543);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar.a()) {
                objB3 = new androidx.compose.ui.focus.m();
                interfaceC22053ub1J.s(objB3);
            }
            androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) objB3;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(-1847116251);
            boolean zD = interfaceC22053ub1J.D(interfaceC3630Br2);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD || objB4 == aVar.a()) {
                objB4 = new a(interfaceC3630Br2);
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(AbstractC21071t37.c(eVarF, c19938rB7, (PointerInputEventHandler) objB4), AbstractC19242q11.e(-975077687, true, new b(sa2), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(2033093268, true, new c(str2, str4, interfaceC16978mB2, str, str3, z, interfaceC20600sH6, c8588Wp4, lp, ua2, mVar, interfaceC9102Ym4, interfaceC9102Ym42), interfaceC22053ub12, 54), interfaceC22053ub12, 805306416, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.k73
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18122o73.h(c8588Wp4, str, str2, str3, str4, ua2, interfaceC16978mB2, lp, z, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(C8588Wp4 c8588Wp4, String str, String str2, String str3, String str4, UA2 ua2, InterfaceC16978mB2 interfaceC16978mB2, LP lp, boolean z, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c8588Wp4, "$navHostController");
        AbstractC13042fc3.i(str, "$countryName");
        AbstractC13042fc3.i(str2, "$countryCode");
        AbstractC13042fc3.i(str4, "$phoneNumber");
        AbstractC13042fc3.i(ua2, "$onPhoneNumberChanged");
        AbstractC13042fc3.i(interfaceC16978mB2, "$onStartAuthClicked");
        AbstractC13042fc3.i(lp, "$error");
        AbstractC13042fc3.i(sa2, "$onSaveLogsClicked");
        c(c8588Wp4, str, str2, str3, str4, ua2, interfaceC16978mB2, lp, z, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void i(final C17720nS0 c17720nS0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c17720nS0, "checkBoxItem");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-967664113);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c17720nS0) : interfaceC22053ub1J.D(c17720nS0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            QX.e(c17720nS0, null, interfaceC22053ub1J, (i2 & 14) | C17720nS0.f, 2);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.l73
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC18122o73.j(c17720nS0, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C17720nS0 c17720nS0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c17720nS0, "$checkBoxItem");
        i(c17720nS0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
