package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.AbstractC13406gA3;
import ir.nasim.C13245fu;
import ir.nasim.C6399Nk7;
import ir.nasim.EP7;

/* loaded from: classes7.dex */
public abstract class EP7 {

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
            Object objK = AbstractC20271rj7.k(interfaceC9049Yg5, null, null, null, new UA2() { // from class: ir.nasim.DP7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return EP7.a.b(interfaceC3630Br2, (ZG4) obj);
                }
            }, interfaceC20295rm1, 7, null);
            return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ String a;
        final /* synthetic */ androidx.navigation.e b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ UA2 e;
        final /* synthetic */ int f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ UA2 h;
        final /* synthetic */ long i;
        final /* synthetic */ UA2 j;
        final /* synthetic */ boolean k;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SA2 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = sa2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:12:0x002b). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r5.b
                    r2 = 1
                    if (r1 == 0) goto L17
                    if (r1 != r2) goto Lf
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L2b
                Lf:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L17:
                    ir.nasim.AbstractC10685c16.b(r6)
                L1a:
                    ir.nasim.Q12$a r6 = ir.nasim.Q12.b
                    ir.nasim.W12 r6 = ir.nasim.W12.e
                    long r3 = ir.nasim.T12.s(r2, r6)
                    r5.b = r2
                    java.lang.Object r6 = ir.nasim.HG1.c(r3, r5)
                    if (r6 != r0) goto L2b
                    return r0
                L2b:
                    ir.nasim.SA2 r6 = r5.c
                    r6.invoke()
                    goto L1a
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EP7.b.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(String str, androidx.navigation.e eVar, String str2, String str3, UA2 ua2, int i, SA2 sa2, UA2 ua22, long j, UA2 ua23, boolean z) {
            this.a = str;
            this.b = eVar;
            this.c = str2;
            this.d = str3;
            this.e = ua2;
            this.f = i;
            this.g = sa2;
            this.h = ua22;
            this.i = j;
            this.j = ua23;
            this.k = z;
        }

        private static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(UA2 ua2, long j) {
            AbstractC13042fc3.i(ua2, "$requestNewCode");
            ua2.invoke(Long.valueOf(j));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(InterfaceC20600sH6 interfaceC20600sH6, InterfaceC10566bp3 interfaceC10566bp3) {
            AbstractC13042fc3.i(interfaceC10566bp3, "$this$KeyboardActions");
            if (interfaceC20600sH6 != null) {
                interfaceC20600sH6.b();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(String str, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(str, "$code");
            AbstractC13042fc3.i(ua2, "$validateCode");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$emptyCode$delegate");
            if (str.length() == 0) {
                n(interfaceC9102Ym4, true);
            } else {
                ua2.invoke(GY6.b(AbstractC20762sZ6.n1(str).toString()));
            }
            return C19938rB7.a;
        }

        private static final void n(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x060a  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x061c  */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0620  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0289  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x030e  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0460  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0568  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0574  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0578  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x05a5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(ir.nasim.TS4 r84, ir.nasim.InterfaceC22053ub1 r85, int r86) {
            /*
                Method dump skipped, instructions count: 1606
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.EP7.b.d(ir.nasim.TS4, ir.nasim.ub1, int):void");
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final String str, final androidx.navigation.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1621082256);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(eVar) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C13245fu.b bVar = new C13245fu.b(0, 1, null);
            bVar.h(str);
            OU3 ou3C = C20644sM5.c(new C20644sM5("\\d+"), str, 0, 2, null);
            if (ou3C != null) {
                bVar.b(new C12863fI6(0L, 0L, C4593Fu2.b.c(), (C3418Au2) null, (C3657Bu2) null, C21216tJ1.a.e(), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, new C19620qf5(), (AbstractC18051o02) null, 49115, (ED1) null), ou3C.c().o(), ou3C.c().t() + 1);
            }
            C13245fu c13245fuO = bVar.o();
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().c(), 0.0f, 8, null);
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1J, i3).b();
            C6399Nk7.a aVar2 = C6399Nk7.b;
            AbstractC9339Zm7.c(c13245fuO, eVarM, g10.a(interfaceC22053ub1J, i3).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, c9348Zn7B.b((16744447 & 1) != 0 ? c9348Zn7B.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7B.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7B.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7B.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7B.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7B.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7B.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7B.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7B.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7B.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7B.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7B.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7B.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7B.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7B.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7B.b.h() : aVar2.a(), (16744447 & 65536) != 0 ? c9348Zn7B.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7B.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7B.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7B.c : null, (16744447 & 1048576) != 0 ? c9348Zn7B.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7B.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7B.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7B.b.k() : null), interfaceC22053ub1J, 0, 0, 131064);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(9)), interfaceC22053ub1J, 6);
            String strC = UY6.c(AbstractC12217eE5.messages_action_edit, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(-1884935330);
            C13245fu.b bVar2 = new C13245fu.b(0, 1, null);
            String strC2 = UY6.c(AbstractC12217eE5.messages_action_edit, interfaceC22053ub1J, 0);
            String str2 = UY6.c(AbstractC12217eE5.is_numbr_wrong, interfaceC22053ub1J, 0) + "  " + UY6.c(AbstractC12217eE5.messages_action_edit, interfaceC22053ub1J, 0);
            int iN = bVar2.n(new C12863fI6(g10.a(interfaceC22053ub1J, i3).B(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
            try {
                bVar2.h(str2);
                C19938rB7 c19938rB7 = C19938rB7.a;
                bVar2.l(iN);
                C17929nn7 c17929nn7 = new C17929nn7(new C12863fI6(g10.a(interfaceC22053ub1J, i3).I(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null), null, null, null, 14, null);
                interfaceC22053ub1J.W(1030493565);
                boolean zD = interfaceC22053ub1J.D(eVar);
                Object objB = interfaceC22053ub1J.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new InterfaceC16379lA3() { // from class: ir.nasim.zP7
                        @Override // ir.nasim.InterfaceC16379lA3
                        public final void a(AbstractC13406gA3 abstractC13406gA3) {
                            EP7.e(eVar, abstractC13406gA3);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                bVar2.a(new AbstractC13406gA3.a(strC, c17929nn7, (InterfaceC16379lA3) objB), AbstractC20762sZ6.l0(str2, strC2, 0, false, 6, null), AbstractC20762sZ6.l0(str2, strC2, 0, false, 6, null) + strC2.length());
                C13245fu c13245fuO2 = bVar2.o();
                interfaceC22053ub1J.Q();
                C9348Zn7 c9348Zn7O = g10.d(interfaceC22053ub1J, i3).o();
                AbstractC9339Zm7.c(c13245fuO2, null, g10.a(interfaceC22053ub1J, i3).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, c9348Zn7O.b((16744447 & 1) != 0 ? c9348Zn7O.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7O.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7O.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7O.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7O.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7O.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7O.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7O.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7O.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7O.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7O.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7O.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7O.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7O.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7O.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7O.b.h() : aVar2.a(), (16744447 & 65536) != 0 ? c9348Zn7O.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7O.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7O.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7O.c : null, (16744447 & 1048576) != 0 ? c9348Zn7O.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7O.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7O.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7O.b.k() : null), interfaceC22053ub1J, 0, 0, 131066);
            } catch (Throwable th) {
                bVar2.l(iN);
                throw th;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.BP7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return EP7.f(str, eVar, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(androidx.navigation.e eVar, AbstractC13406gA3 abstractC13406gA3) {
        AbstractC13042fc3.i(eVar, "$navController");
        AbstractC13042fc3.i(abstractC13406gA3, "it");
        eVar.V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(String str, androidx.navigation.e eVar, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$textTitle");
        AbstractC13042fc3.i(eVar, "$navController");
        d(str, eVar, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void g(final androidx.navigation.e eVar, final String str, final String str2, final UA2 ua2, final int i, final SA2 sa2, final UA2 ua22, final long j, final String str3, final boolean z, final UA2 ua23, InterfaceC22053ub1 interfaceC22053ub1, final int i2, final int i3) {
        int i4;
        int i5;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(str, "textTitle");
        AbstractC13042fc3.i(str2, "code");
        AbstractC13042fc3.i(ua2, "onCodeChanged");
        AbstractC13042fc3.i(sa2, "onCountDown");
        AbstractC13042fc3.i(ua22, "requestNewCode");
        AbstractC13042fc3.i(ua23, "validateCode");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-557573300);
        if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.D(eVar) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(str2) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(sa2) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(ua22) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i4 |= interfaceC22053ub1J.f(j) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i4 |= interfaceC22053ub1J.V(str3) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= interfaceC22053ub1J.a(z) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (interfaceC22053ub1J.D(ua23) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) == 306783378 && (i5 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            InterfaceC3630Br2 interfaceC3630Br2 = (InterfaceC3630Br2) interfaceC22053ub1J.H(AbstractC13040fc1.h());
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            C19938rB7 c19938rB7 = C19938rB7.a;
            interfaceC22053ub1J.W(1733320841);
            boolean zD = interfaceC22053ub1J.D(interfaceC3630Br2);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(interfaceC3630Br2);
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(AbstractC21071t37.c(eVarF, c19938rB7, (PointerInputEventHandler) objB), C3944Da1.a.b(), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(120754397, true, new b(str, eVar, str2, str3, ua2, i, sa2, ua22, j, ua23, z), interfaceC22053ub12, 54), interfaceC22053ub12, 805306416, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.CP7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return EP7.h(eVar, str, str2, ua2, i, sa2, ua22, j, str3, z, ua23, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.navigation.e eVar, String str, String str2, UA2 ua2, int i, SA2 sa2, UA2 ua22, long j, String str3, boolean z, UA2 ua23, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(eVar, "$navController");
        AbstractC13042fc3.i(str, "$textTitle");
        AbstractC13042fc3.i(str2, "$code");
        AbstractC13042fc3.i(ua2, "$onCodeChanged");
        AbstractC13042fc3.i(sa2, "$onCountDown");
        AbstractC13042fc3.i(ua22, "$requestNewCode");
        AbstractC13042fc3.i(ua23, "$validateCode");
        g(eVar, str, str2, ua2, i, sa2, ua22, j, str3, z, ua23, interfaceC22053ub1, QJ5.a(i2 | 1), QJ5.a(i3));
        return C19938rB7.a;
    }
}
