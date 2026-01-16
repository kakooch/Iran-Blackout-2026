package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.compose.ui.platform.AbstractComposeView;
import ir.nasim.C8764Xf4;

/* renamed from: ir.nasim.Xf4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C8764Xf4 extends AbstractComposeView {
    private final Window i;
    private final boolean j;
    private final SA2 k;
    private final C15607js l;
    private final InterfaceC20315ro1 m;
    private final InterfaceC9102Ym4 n;
    private Object o;
    private boolean p;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.Xf4$a */
    static final class a {
        public static final a a = new a();

        private a() {
        }

        public static final OnBackInvokedCallback b(final SA2 sa2) {
            return new OnBackInvokedCallback() { // from class: ir.nasim.Wf4
                public final void onBackInvoked() {
                    C8764Xf4.a.c(sa2);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SA2 sa2) {
            sa2.invoke();
        }

        public static final void d(View view, Object obj) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(0, (OnBackInvokedCallback) obj);
        }

        public static final void e(View view, Object obj) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (!(obj instanceof OnBackInvokedCallback) || (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj);
        }
    }

    /* renamed from: ir.nasim.Xf4$b */
    private static final class b {
        public static final b a = new b();

        /* renamed from: ir.nasim.Xf4$b$a */
        public static final class a implements OnBackAnimationCallback {
            final /* synthetic */ InterfaceC20315ro1 a;
            final /* synthetic */ C15607js b;
            final /* synthetic */ SA2 c;

            /* renamed from: ir.nasim.Xf4$b$a$a, reason: collision with other inner class name */
            static final class C0758a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C15607js c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0758a(C15607js c15607js, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c15607js;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0758a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C15607js c15607js = this.c;
                        Float fC = AbstractC6392Nk0.c(0.0f);
                        this.b = 1;
                        if (C15607js.h(c15607js, fC, null, null, null, this, 14, null) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0758a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Xf4$b$a$b, reason: collision with other inner class name */
            static final class C0759b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C15607js c;
                final /* synthetic */ BackEvent d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0759b(C15607js c15607js, BackEvent backEvent, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c15607js;
                    this.d = backEvent;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0759b(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C15607js c15607js = this.c;
                        Float fC = AbstractC6392Nk0.c(C12515ek5.a.a(this.d.getProgress()));
                        this.b = 1;
                        if (c15607js.x(fC, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0759b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Xf4$b$a$c */
            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C15607js c;
                final /* synthetic */ BackEvent d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C15607js c15607js, BackEvent backEvent, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c15607js;
                    this.d = backEvent;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new c(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C15607js c15607js = this.c;
                        Float fC = AbstractC6392Nk0.c(C12515ek5.a.a(this.d.getProgress()));
                        this.b = 1;
                        if (c15607js.x(fC, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(InterfaceC20315ro1 interfaceC20315ro1, C15607js c15607js, SA2 sa2) {
                this.a = interfaceC20315ro1;
                this.b = c15607js;
                this.c = sa2;
            }

            public void onBackCancelled() {
                AbstractC10533bm0.d(this.a, null, null, new C0758a(this.b, null), 3, null);
            }

            public void onBackInvoked() {
                this.c.invoke();
            }

            public void onBackProgressed(BackEvent backEvent) {
                AbstractC10533bm0.d(this.a, null, null, new C0759b(this.b, backEvent, null), 3, null);
            }

            public void onBackStarted(BackEvent backEvent) {
                AbstractC10533bm0.d(this.a, null, null, new c(this.b, backEvent, null), 3, null);
            }
        }

        private b() {
        }

        public static final OnBackAnimationCallback a(SA2 sa2, C15607js c15607js, InterfaceC20315ro1 interfaceC20315ro1) {
            return new a(interfaceC20315ro1, c15607js, sa2);
        }
    }

    /* renamed from: ir.nasim.Xf4$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i) {
            super(2);
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C8764Xf4.this.d(interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public C8764Xf4(Context context, Window window, boolean z, SA2 sa2, C15607js c15607js, InterfaceC20315ro1 interfaceC20315ro1) {
        super(context, null, 0, 6, null);
        this.i = window;
        this.j = z;
        this.k = sa2;
        this.l = c15607js;
        this.m = interfaceC20315ro1;
        this.n = AbstractC13472gH6.d(G61.a.a(), null, 2, null);
    }

    private final InterfaceC14603iB2 getContent() {
        return (InterfaceC14603iB2) this.n.getValue();
    }

    private final void n() {
        int i;
        if (!this.j || (i = Build.VERSION.SDK_INT) < 33) {
            return;
        }
        if (this.o == null) {
            this.o = i >= 34 ? SD.a(b.a(this.k, this.l, this.m)) : a.b(this.k);
        }
        a.d(this, this.o);
    }

    private final void o() {
        if (Build.VERSION.SDK_INT >= 33) {
            a.e(this, this.o);
        }
        this.o = null;
    }

    private final void setContent(InterfaceC14603iB2 interfaceC14603iB2) {
        this.n.setValue(interfaceC14603iB2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(576708319);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(576708319, i2, -1, "androidx.compose.material3.ModalBottomSheetDialogLayout.Content (ModalBottomSheet.android.kt:352)");
            }
            getContent().invoke(interfaceC22053ub1J, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(i));
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.p;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    public final void setContent(AbstractC7050Qb1 abstractC7050Qb1, InterfaceC14603iB2 interfaceC14603iB2) {
        setParentCompositionContext(abstractC7050Qb1);
        setContent(interfaceC14603iB2);
        this.p = true;
        g();
    }
}
