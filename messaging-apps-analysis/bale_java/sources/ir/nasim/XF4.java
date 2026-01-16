package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.google.android.gms.tasks.Task;
import ir.nasim.C13245fu;
import ir.nasim.IM4;
import ir.nasim.XF4;
import ir.nasim.authenticator.ui.OtpReceiver;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class XF4 {

    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ EnumC10827cG4 a;
        final /* synthetic */ SA2 b;

        b(EnumC10827cG4 enumC10827cG4, SA2 sa2) {
            this.a = enumC10827cG4;
            this.b = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(this.a.j(), interfaceC22053ub1, 0), null, this.b, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ C19391qG6 a;

        c(C19391qG6 c19391qG6) {
            this.a = c19391qG6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC18209oG6.b(this.a, null, C10740c71.a.a(), interfaceC22053ub1, 390, 2);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ C11591dG4 a;
        final /* synthetic */ EnumC10827cG4 b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ InterfaceC9102Ym4 f;

        d(C11591dG4 c11591dG4, EnumC10827cG4 enumC10827cG4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC9664aL6 interfaceC9664aL63, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = c11591dG4;
            this.b = enumC10827cG4;
            this.c = interfaceC9664aL6;
            this.d = interfaceC9664aL62;
            this.e = interfaceC9664aL63;
            this.f = interfaceC9102Ym4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C11591dG4 c11591dG4, String str) {
            AbstractC13042fc3.i(str, "pass");
            c11591dG4.l1(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C11591dG4 c11591dG4) {
            c11591dG4.x1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C11591dG4 c11591dG4, EnumC10827cG4 enumC10827cG4) {
            AbstractC13042fc3.i(enumC10827cG4, "$otpScreenType");
            c11591dG4.o1(enumC10827cG4);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogDismissed$delegate");
            AbstractC13042fc3.i(interfaceC9664aL6, "$currentOnAuthorizeCompleted$delegate");
            XF4.z(interfaceC9102Ym4, true);
            XF4.x(interfaceC9664aL6).invoke();
            return C19938rB7.a;
        }

        public final void f(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i |= interfaceC22053ub1.V(ts4) ? 4 : 2;
            }
            if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C15843kG4 c15843kG4I = XF4.I(this.d);
            interfaceC22053ub1.W(726538207);
            boolean zD = interfaceC22053ub1.D(this.a);
            final C11591dG4 c11591dG4 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.YF4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return XF4.d.h(c11591dG4, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(726541426);
            boolean zD2 = interfaceC22053ub1.D(this.a);
            final C11591dG4 c11591dG42 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.ZF4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return XF4.d.i(c11591dG42);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(726544318);
            boolean zD3 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b);
            final C11591dG4 c11591dG43 = this.a;
            final EnumC10827cG4 enumC10827cG4 = this.b;
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.aG4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return XF4.d.k(c11591dG43, enumC10827cG4);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            XF4.q(c15843kG4I, ts4, ua2, sa2, (SA2) objB3, interfaceC22053ub1, (i << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0);
            if (XF4.B(this.e)) {
                String strE = XF4.I(this.d).e();
                if (strE == null) {
                    strE = "";
                }
                interfaceC22053ub1.W(726552973);
                boolean zV = interfaceC22053ub1.V(this.c);
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.f;
                final InterfaceC9664aL6 interfaceC9664aL6 = this.c;
                Object objB4 = interfaceC22053ub1.B();
                if (zV || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.bG4
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return XF4.d.n(interfaceC9102Ym4, interfaceC9664aL6);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                AbstractC22223us1.c(strE, (SA2) objB4, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            f((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11591dG4 c;
        final /* synthetic */ TR d;
        final /* synthetic */ EnumC10827cG4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C11591dG4 c11591dG4, TR tr, EnumC10827cG4 enumC10827cG4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11591dG4;
            this.d = tr;
            this.e = enumC10827cG4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.u1(this.d);
            this.c.t1(this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC9664aL6 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC9664aL6;
            this.d = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new f(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            String strE;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (XF4.I(this.c).c() && ((strE = XF4.I(this.c).e()) == null || strE.length() == 0)) {
                XF4.x(this.d).invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11591dG4 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C11591dG4 c11591dG4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11591dG4;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (XF4.I(this.d).j()) {
                XF4.C(this.e).invoke();
                this.c.v1();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11591dG4 c;
        final /* synthetic */ InterfaceC9664aL6 d;
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C11591dG4 c11591dG4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11591dG4;
            this.d = interfaceC9664aL6;
            this.e = interfaceC9664aL62;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new h(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (XF4.I(this.d).k()) {
                XF4.D(this.e).invoke();
                this.c.w1();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C19391qG6 c;
        final /* synthetic */ String d;
        final /* synthetic */ C11591dG4 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C19391qG6 c19391qG6, String str, C11591dG4 c11591dG4, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c19391qG6;
            this.d = str;
            this.e = c11591dG4;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new i(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19391qG6 c19391qG6 = this.c;
                String str = this.d;
                this.b = 1;
                if (C19391qG6.f(c19391qG6, str, null, false, null, this, 14, null) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.e.m1(this.f);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class j implements KV1 {
        final /* synthetic */ Context a;
        final /* synthetic */ OtpReceiver b;

        public j(Context context, OtpReceiver otpReceiver) {
            this.a = context;
            this.b = otpReceiver;
        }

        @Override // ir.nasim.KV1
        public void dispose() {
            this.a.unregisterReceiver(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A(InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9102Ym4 interfaceC9102Ym4) {
        String strE;
        AbstractC13042fc3.i(interfaceC9664aL6, "$uiState$delegate");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isDialogDismissed$delegate");
        return (!I(interfaceC9664aL6).c() || (strE = I(interfaceC9664aL6).e()) == null || strE.length() == 0 || y(interfaceC9102Ym4)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 C(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 D(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(EnumC10827cG4 enumC10827cG4, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, C11591dG4 c11591dG4, TR tr, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(enumC10827cG4, "$otpScreenType");
        AbstractC13042fc3.i(tr, "$sourceType");
        v(enumC10827cG4, eVar, sa2, sa22, sa23, sa24, c11591dG4, tr, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15843kG4 I(InterfaceC9664aL6 interfaceC9664aL6) {
        return (C15843kG4) interfaceC9664aL6.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void J(final ir.nasim.ZY0 r38, final ir.nasim.IM4 r39, final ir.nasim.SA2 r40, ir.nasim.InterfaceC22053ub1 r41, final int r42) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XF4.J(ir.nasim.ZY0, ir.nasim.IM4, ir.nasim.SA2, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(ZY0 zy0, IM4 im4, SA2 sa2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(zy0, "$this_OtpState");
        AbstractC13042fc3.i(im4, "$otpCodeState");
        AbstractC13042fc3.i(sa2, "$onResendOtpClicked");
        J(zy0, im4, sa2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v7 ??, still in use, count: 1, list:
          (r0v7 ?? I:java.lang.Object) from 0x0197: INVOKE (r10v0 ?? I:ir.nasim.ub1), (r0v7 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:408)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    private static final void L(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v7 ??, still in use, count: 1, list:
          (r0v7 ?? I:java.lang.Object) from 0x0197: INVOKE (r10v0 ?? I:ir.nasim.ub1), (r0v7 ?? I:java.lang.Object) INTERFACE call: ir.nasim.ub1.s(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:408)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r40v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    private static final String M(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    private static final void N(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 O(String str, Context context, final UA2 ua2, final SA2 sa2, final InterfaceC9102Ym4 interfaceC9102Ym4, LV1 lv1) {
        AbstractC13042fc3.i(str, "$otpPattern");
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(sa2, "$confirmOtp");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$value$delegate");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        Pattern patternCompile = Pattern.compile(str, 0);
        AbstractC13042fc3.h(patternCompile, "compile(...)");
        OtpReceiver otpReceiver = new OtpReceiver(patternCompile, new UA2() { // from class: ir.nasim.KF4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XF4.P(ua2, sa2, interfaceC9102Ym4, (String) obj);
            }
        });
        otpReceiver.a(context);
        return new j(context, otpReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(UA2 ua2, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(sa2, "$confirmOtp");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$value$delegate");
        AbstractC13042fc3.i(str, "otp");
        N(interfaceC9102Ym4, str);
        ua2.invoke(M(interfaceC9102Ym4));
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(int i2, UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$value$delegate");
        AbstractC13042fc3.i(str, "newValue");
        N(interfaceC9102Ym4, AbstractC22039uZ6.A1(AbstractC20762sZ6.n1(str).toString(), i2));
        ua2.invoke(M(interfaceC9102Ym4));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R(int i2, String str, SA2 sa2, AbstractC14472hy4 abstractC14472hy4, int i3, int i4, UA2 ua2, androidx.compose.ui.e eVar, int i5, int i6, InterfaceC22053ub1 interfaceC22053ub1, int i7) {
        AbstractC13042fc3.i(str, "$otpPattern");
        AbstractC13042fc3.i(sa2, "$confirmOtp");
        AbstractC13042fc3.i(abstractC14472hy4, "$state");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        L(i2, str, sa2, abstractC14472hy4, i3, i4, ua2, eVar, interfaceC22053ub1, QJ5.a(i5 | 1), i6);
        return C19938rB7.a;
    }

    public static final void S(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-858943428);
        if (i2 == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C10740c71.a.c(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.QF4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return XF4.T(i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T(int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        S(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final String b0(String str, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "string");
        interfaceC22053ub1.W(-632199741);
        String strG = XY6.g((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()), str);
        interfaceC22053ub1.Q();
        return strG;
    }

    private static final C13245fu c0(IM4.b bVar, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        interfaceC22053ub1.W(-1774776243);
        C13245fu.b bVar2 = new C13245fu.b(0, 1, null);
        interfaceC22053ub1.W(322223865);
        int iN = bVar2.n(new C12863fI6(G10.a.a(interfaceC22053ub1, G10.b).I(), 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65534, (ED1) null));
        try {
            bVar2.h(UY6.d(AbstractC24800zD5.features_authenticator_forgot_password_new_request_timeout_seconds, new Object[]{b0(String.valueOf(bVar.a()), interfaceC22053ub1, 0)}, interfaceC22053ub1, 0));
            C19938rB7 c19938rB7 = C19938rB7.a;
            bVar2.l(iN);
            interfaceC22053ub1.Q();
            bVar2.h(Separators.SP);
            bVar2.h(UY6.c(AbstractC24800zD5.features_authenticator_forgot_password_new_request_timeout, interfaceC22053ub1, 0));
            C13245fu c13245fuO = bVar2.o();
            interfaceC22053ub1.Q();
            return c13245fuO;
        } catch (Throwable th) {
            bVar2.l(iN);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void q(final ir.nasim.C15843kG4 r42, ir.nasim.TS4 r43, ir.nasim.UA2 r44, ir.nasim.SA2 r45, ir.nasim.SA2 r46, ir.nasim.InterfaceC22053ub1 r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 983
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XF4.q(ir.nasim.kG4, ir.nasim.TS4, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(C15843kG4 c15843kG4, TS4 ts4, UA2 ua2, SA2 sa2, SA2 sa22, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(c15843kG4, "$uiState");
        q(c15843kG4, ts4, ua2, sa2, sa22, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void v(final ir.nasim.EnumC10827cG4 r29, androidx.compose.ui.e r30, ir.nasim.SA2 r31, ir.nasim.SA2 r32, ir.nasim.SA2 r33, ir.nasim.SA2 r34, ir.nasim.C11591dG4 r35, final ir.nasim.TR r36, ir.nasim.InterfaceC22053ub1 r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XF4.v(ir.nasim.cG4, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.dG4, ir.nasim.TR, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 x(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }

    private static final boolean y(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C11591dG4 c;
        final /* synthetic */ EnumC10827cG4 d;
        final /* synthetic */ Context e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C11591dG4 c11591dG4, EnumC10827cG4 enumC10827cG4, Context context, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c11591dG4;
            this.d = enumC10827cG4;
            this.e = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(Void r0) {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void G(UA2 ua2, Object obj) {
            ua2.invoke(obj);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.o1(this.d);
            Task taskZ = SF6.b(this.e).z();
            final UA2 ua2 = new UA2() { // from class: ir.nasim.UF4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj2) {
                    return XF4.a.D((Void) obj2);
                }
            };
            taskZ.f(new InterfaceC13497gK4() { // from class: ir.nasim.VF4
                @Override // ir.nasim.InterfaceC13497gK4
                public final void onSuccess(Object obj2) {
                    XF4.a.G(ua2, obj2);
                }
            }).d(new InterfaceC14681iJ4() { // from class: ir.nasim.WF4
                @Override // ir.nasim.InterfaceC14681iJ4
                public final void a(Exception exc) {
                    XF4.a.H(exc);
                }
            });
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(Exception exc) {
        }
    }
}
