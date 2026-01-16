package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C16872m05;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.TR;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006%²\u0006\u000e\u0010!\u001a\u0004\u0018\u00010 8\nX\u008a\u0084\u0002²\u0006\f\u0010#\u001a\u00020\"8\nX\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u00020\"8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/m05;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/w05;", "h1", "Lir/nasim/Yu3;", "T9", "()Lir/nasim/w05;", "viewModel", "Lir/nasim/wR;", "i1", "Lir/nasim/wR;", "S9", "()Lir/nasim/wR;", "setAuthNavigator", "(Lir/nasim/wR;)V", "authNavigator", "j1", "a", "", "snackBarMessage", "", "isFingerPrintEnabled", "isPasswordEnabled", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.m05, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C16872m05 extends AbstractC21360tX2 {

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int k1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC23146wR authNavigator;

    /* renamed from: ir.nasim.m05$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C16872m05 a() {
            C16872m05 c16872m05 = new C16872m05();
            c16872m05.a8(new Bundle());
            return c16872m05;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.m05$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.m05$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C16872m05 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            /* renamed from: ir.nasim.m05$b$a$a, reason: collision with other inner class name */
            static final class C1393a implements InterfaceC14603iB2 {
                final /* synthetic */ C16872m05 a;

                C1393a(C16872m05 c16872m05) {
                    this.a = c16872m05;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C16872m05 c16872m05) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    c16872m05.Q7().onBackPressed();
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String strC = UY6.c(QD5.password_header, interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(1587978040);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C16872m05 c16872m05 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.n05
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C16872m05.b.a.C1393a.c(c16872m05);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC21639ts7.i(strC, null, (SA2) objB, null, null, null, null, interfaceC22053ub1, 0, 122);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.m05$b$a$b, reason: collision with other inner class name */
            static final class C1394b implements InterfaceC15796kB2 {
                final /* synthetic */ InterfaceC9664aL6 a;
                final /* synthetic */ C16872m05 b;

                /* renamed from: ir.nasim.m05$b$a$b$a, reason: collision with other inner class name */
                static final class C1395a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    final /* synthetic */ C16872m05 c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1395a(C16872m05 c16872m05, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.c = c16872m05;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1395a(this.c, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            this.b = 1;
                            if (HG1.b(2000L, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        this.c.T9().c1(null);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1395a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                C1394b(InterfaceC9664aL6 interfaceC9664aL6, C16872m05 c16872m05) {
                    this.a = interfaceC9664aL6;
                    this.b = c16872m05;
                }

                public final void a(C19982rG6 c19982rG6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(c19982rG6, "it");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    Integer numC = b.c(this.a);
                    if (numC == null) {
                        return;
                    }
                    C16872m05 c16872m05 = this.b;
                    int iIntValue = numC.intValue();
                    Integer numValueOf = Integer.valueOf(iIntValue);
                    interfaceC22053ub1.W(-709416095);
                    boolean zD = interfaceC22053ub1.D(c16872m05);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C1395a(c16872m05, null);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(numValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
                    AbstractC10984cY.c(UY6.c(iIntValue, interfaceC22053ub1, 0), null, null, 0, null, interfaceC22053ub1, 0, 30);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((C19982rG6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.m05$b$a$c */
            static final class c implements InterfaceC15796kB2 {
                final /* synthetic */ C16872m05 a;

                /* renamed from: ir.nasim.m05$b$a$c$a, reason: collision with other inner class name */
                /* synthetic */ class C1396a extends EB2 implements SA2 {
                    C1396a(Object obj) {
                        super(0, obj, C22899w05.class, "toggleFingerPrint", "toggleFingerPrint()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((C22899w05) this.receiver).Y0();
                    }
                }

                c(C16872m05 c16872m05) {
                    this.a = c16872m05;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 A(C16872m05 c16872m05) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    c16872m05.Q7().onBackPressed();
                    c16872m05.T9().c1(Integer.valueOf(QD5.password_changed_successfully));
                    c16872m05.T9().b1(true);
                    c16872m05.T9().Z0(true);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 B(C16872m05 c16872m05) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    c16872m05.T9().b1(false);
                    c16872m05.T9().Z0(false);
                    return C19938rB7.a;
                }

                private static final boolean o(InterfaceC9664aL6 interfaceC9664aL6) {
                    return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final NV1 p(final C16872m05 c16872m05, final InterfaceC9664aL6 interfaceC9664aL6) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    AbstractC13042fc3.i(interfaceC9664aL6, "$isPasswordEnabled$delegate");
                    return c16872m05.T9().S0().s(new UA2() { // from class: ir.nasim.o05
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C16872m05.b.a.c.t(c16872m05, interfaceC9664aL6, (Throwable) obj);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 t(final C16872m05 c16872m05, final InterfaceC9664aL6 interfaceC9664aL6, Throwable th) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    AbstractC13042fc3.i(interfaceC9664aL6, "$isPasswordEnabled$delegate");
                    C22042ua0.A9(c16872m05, ((Boolean) c16872m05.T9().X0().getValue()).booleanValue() ? InterfaceC23146wR.c(c16872m05.S9(), "AuthenticationResult_Key", new TR.b(AbstractC17026mG5.a.f()), false, false, new SA2() { // from class: ir.nasim.r05
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C16872m05.b.a.c.v(c16872m05, interfaceC9664aL6);
                        }
                    }, 8, null) : InterfaceC23146wR.a(c16872m05.S9(), "AuthenticationResult_Key", new TR.b(AbstractC17026mG5.a.f()), true, false, new SA2() { // from class: ir.nasim.s05
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C16872m05.b.a.c.w(c16872m05);
                        }
                    }, 8, null), false, null, 6, null);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 v(C16872m05 c16872m05, InterfaceC9664aL6 interfaceC9664aL6) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    AbstractC13042fc3.i(interfaceC9664aL6, "$isPasswordEnabled$delegate");
                    c16872m05.T9().a1();
                    c16872m05.T9().Z0(!y(interfaceC9664aL6));
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 w(C16872m05 c16872m05) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    c16872m05.T9().Z0(true);
                    c16872m05.T9().b1(true);
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 x(SA2 sa2, boolean z) {
                    AbstractC13042fc3.i(sa2, "$onDisablePasswordClick");
                    sa2.invoke();
                    return C19938rB7.a;
                }

                private static final boolean y(InterfaceC9664aL6 interfaceC9664aL6) {
                    return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 z(final C16872m05 c16872m05) {
                    AbstractC13042fc3.i(c16872m05, "this$0");
                    C22042ua0.A9(c16872m05, c16872m05.S9().h(new SA2() { // from class: ir.nasim.p05
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C16872m05.b.a.c.A(c16872m05);
                        }
                    }, new TR.d(AbstractC17026mG5.a.f()), "AuthenticationResult_Key", new SA2() { // from class: ir.nasim.q05
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C16872m05.b.a.c.B(c16872m05);
                        }
                    }), false, null, 6, null);
                    return C19938rB7.a;
                }

                public final void n(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(ts4, "it");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    Context contextS7 = this.a.S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    interfaceC22053ub1.W(1588006882);
                    Object objB = interfaceC22053ub1.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB == aVar.a()) {
                        objB = C4071Do2.b.a(contextS7);
                        interfaceC22053ub1.s(objB);
                    }
                    C4071Do2 c4071Do2 = (C4071Do2) objB;
                    interfaceC22053ub1.Q();
                    boolean z = false;
                    InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a.T9().W0(), null, interfaceC22053ub1, 0, 1);
                    final InterfaceC9664aL6 interfaceC9664aL6B2 = AbstractC10222bH6.b(this.a.T9().V0(), null, interfaceC22053ub1, 0, 1);
                    interfaceC22053ub1.W(1588017229);
                    Object objB2 = interfaceC22053ub1.B();
                    if (objB2 == aVar.a()) {
                        if (c4071Do2.d() && c4071Do2.c()) {
                            z = true;
                        }
                        objB2 = Boolean.valueOf(z);
                        interfaceC22053ub1.s(objB2);
                    }
                    boolean zBooleanValue = ((Boolean) objB2).booleanValue();
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1588025206);
                    final C16872m05 c16872m05 = this.a;
                    Object objB3 = interfaceC22053ub1.B();
                    if (objB3 == aVar.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.t05
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C16872m05.b.a.c.z(c16872m05);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    SA2 sa2 = (SA2) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1588068235);
                    final C16872m05 c16872m052 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (objB4 == aVar.a()) {
                        objB4 = new SA2() { // from class: ir.nasim.u05
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C16872m05.b.a.c.p(c16872m052, interfaceC9664aL6B2);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    final SA2 sa22 = (SA2) objB4;
                    interfaceC22053ub1.Q();
                    boolean zO = o(interfaceC9664aL6B);
                    C22899w05 c22899w05T9 = this.a.T9();
                    interfaceC22053ub1.W(1588148395);
                    boolean zD = interfaceC22053ub1.D(c22899w05T9);
                    Object objB5 = interfaceC22053ub1.B();
                    if (zD || objB5 == aVar.a()) {
                        objB5 = new C1396a(c22899w05T9);
                        interfaceC22053ub1.s(objB5);
                    }
                    interfaceC22053ub1.Q();
                    boolean zY = y(interfaceC9664aL6B2);
                    SA2 sa23 = (SA2) ((InterfaceC16733lm3) objB5);
                    interfaceC22053ub1.W(1588151179);
                    Object objB6 = interfaceC22053ub1.B();
                    if (objB6 == aVar.a()) {
                        objB6 = new UA2() { // from class: ir.nasim.v05
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C16872m05.b.a.c.x(sa22, ((Boolean) obj).booleanValue());
                            }
                        };
                        interfaceC22053ub1.s(objB6);
                    }
                    interfaceC22053ub1.Q();
                    P05.h(null, zBooleanValue, zO, zY, sa23, sa2, (UA2) objB6, interfaceC22053ub1, 1769520, 1);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    n((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            a(C16872m05 c16872m05, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c16872m05;
                this.b = interfaceC9664aL6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC10439bc6.a(null, null, AbstractC19242q11.e(609424192, true, new C1393a(this.a), interfaceC22053ub1, 54), null, AbstractC19242q11.e(-656610764, true, new C1394b(this.b, this.a), interfaceC22053ub1, 54), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, AbstractC19242q11.e(-1645354183, true, new c(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 24960, 12582912, 131051);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Integer c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (Integer) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(905800315, true, new a(C16872m05.this, AbstractC10222bH6.b(C16872m05.this.T9().U0(), null, interfaceC22053ub1, 0, 1)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.m05$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.m05$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.m05$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.m05$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.m05$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C16872m05() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C22899w05.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        super.Q6(inflater, container, savedInstanceState);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1528919680, true, new b()));
        return composeView;
    }

    public final InterfaceC23146wR S9() {
        InterfaceC23146wR interfaceC23146wR = this.authNavigator;
        if (interfaceC23146wR != null) {
            return interfaceC23146wR;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }

    public final C22899w05 T9() {
        return (C22899w05) this.viewModel.getValue();
    }
}
