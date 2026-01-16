package androidx.compose.ui.platform;

import android.R;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC11305cn;
import ir.nasim.AbstractC12806fC3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13192fo6;
import ir.nasim.AbstractC14977io;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18977pa3;
import ir.nasim.AbstractC19568qa3;
import ir.nasim.AbstractC20768sa3;
import ir.nasim.AbstractC21388ta3;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22421vC5;
import ir.nasim.AbstractC5719Kn6;
import ir.nasim.AbstractC8104Un6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.B26;
import ir.nasim.C13245fu;
import ir.nasim.C13774gn7;
import ir.nasim.C15552jm4;
import ir.nasim.C16734lm4;
import ir.nasim.C17325mm4;
import ir.nasim.C18367oY2;
import ir.nasim.C19409qI6;
import ir.nasim.C19938rB7;
import ir.nasim.C20450s2;
import ir.nasim.C22317v2;
import ir.nasim.C23001wA7;
import ir.nasim.C3419Au3;
import ir.nasim.C4301En7;
import ir.nasim.C5485Jn6;
import ir.nasim.C5629Kd6;
import ir.nasim.C7631Sn6;
import ir.nasim.C7870Tn6;
import ir.nasim.C8338Vn6;
import ir.nasim.C8482Wd6;
import ir.nasim.C8838Xn6;
import ir.nasim.CK5;
import ir.nasim.DJ0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC17639nJ0;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC23714xO4;
import ir.nasim.InterfaceC24683z2;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.PJ;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.X2;
import ir.nasim.Y2;
import ir.nasim.ZG4;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* loaded from: classes2.dex */
public final class h extends C22317v2 {
    public static final d Q = new d(null);
    public static final int R = 8;
    private static final AbstractC18977pa3 S = AbstractC19568qa3.c(AbstractC22421vC5.accessibility_custom_action_0, AbstractC22421vC5.accessibility_custom_action_1, AbstractC22421vC5.accessibility_custom_action_2, AbstractC22421vC5.accessibility_custom_action_3, AbstractC22421vC5.accessibility_custom_action_4, AbstractC22421vC5.accessibility_custom_action_5, AbstractC22421vC5.accessibility_custom_action_6, AbstractC22421vC5.accessibility_custom_action_7, AbstractC22421vC5.accessibility_custom_action_8, AbstractC22421vC5.accessibility_custom_action_9, AbstractC22421vC5.accessibility_custom_action_10, AbstractC22421vC5.accessibility_custom_action_11, AbstractC22421vC5.accessibility_custom_action_12, AbstractC22421vC5.accessibility_custom_action_13, AbstractC22421vC5.accessibility_custom_action_14, AbstractC22421vC5.accessibility_custom_action_15, AbstractC22421vC5.accessibility_custom_action_16, AbstractC22421vC5.accessibility_custom_action_17, AbstractC22421vC5.accessibility_custom_action_18, AbstractC22421vC5.accessibility_custom_action_19, AbstractC22421vC5.accessibility_custom_action_20, AbstractC22421vC5.accessibility_custom_action_21, AbstractC22421vC5.accessibility_custom_action_22, AbstractC22421vC5.accessibility_custom_action_23, AbstractC22421vC5.accessibility_custom_action_24, AbstractC22421vC5.accessibility_custom_action_25, AbstractC22421vC5.accessibility_custom_action_26, AbstractC22421vC5.accessibility_custom_action_27, AbstractC22421vC5.accessibility_custom_action_28, AbstractC22421vC5.accessibility_custom_action_29, AbstractC22421vC5.accessibility_custom_action_30, AbstractC22421vC5.accessibility_custom_action_31);
    private final InterfaceC17639nJ0 A;
    private boolean B;
    private f C;
    private AbstractC20768sa3 D;
    private C17325mm4 E;
    private C15552jm4 F;
    private C15552jm4 G;
    private final String H;
    private final String I;
    private final C23001wA7 J;
    private C16734lm4 K;
    private C7870Tn6 L;
    private boolean M;
    private final Runnable N;
    private final List O;
    private final UA2 P;
    private final AndroidComposeView d;
    private int e = RecyclerView.UNDEFINED_DURATION;
    private UA2 f = new C0066h();
    private final AccessibilityManager g;
    private boolean h;
    private long i;
    private final AccessibilityManager.AccessibilityStateChangeListener j;
    private final AccessibilityManager.TouchExplorationStateChangeListener k;
    private List l;
    private final Handler m;
    private e n;
    private int o;
    private int p;
    private X2 q;
    private X2 r;
    private boolean s;
    private final C16734lm4 t;
    private final C16734lm4 u;
    private C19409qI6 v;
    private C19409qI6 w;
    private int x;
    private Integer y;
    private final PJ z;

    public static final class a implements View.OnAttachStateChangeListener {
        a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            AccessibilityManager accessibilityManager = h.this.g;
            h hVar = h.this;
            accessibilityManager.addAccessibilityStateChangeListener(hVar.j);
            accessibilityManager.addTouchExplorationStateChangeListener(hVar.k);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            h.this.m.removeCallbacks(h.this.N);
            AccessibilityManager accessibilityManager = h.this.g;
            h hVar = h.this;
            accessibilityManager.removeAccessibilityStateChangeListener(hVar.j);
            accessibilityManager.removeTouchExplorationStateChangeListener(hVar.k);
        }
    }

    private static final class b {
        public static final b a = new b();

        private b() {
        }

        public static final void a(X2 x2, C7631Sn6 c7631Sn6) {
            C20450s2 c20450s2;
            if (!AbstractC14977io.o(c7631Sn6) || (c20450s2 = (C20450s2) AbstractC5719Kn6.a(c7631Sn6.w(), C5485Jn6.a.x())) == null) {
                return;
            }
            x2.b(new X2.a(R.id.accessibilityActionSetProgress, c20450s2.b()));
        }
    }

    private static final class c {
        public static final c a = new c();

        private c() {
        }

        public static final void a(X2 x2, C7631Sn6 c7631Sn6) {
            B26 b26 = (B26) AbstractC5719Kn6.a(c7631Sn6.w(), C8838Xn6.a.C());
            if (AbstractC14977io.o(c7631Sn6)) {
                if (b26 == null ? false : B26.m(b26.p(), B26.b.b())) {
                    return;
                }
                SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
                C5485Jn6 c5485Jn6 = C5485Jn6.a;
                C20450s2 c20450s2 = (C20450s2) AbstractC5719Kn6.a(semanticsConfigurationW, c5485Jn6.r());
                if (c20450s2 != null) {
                    x2.b(new X2.a(R.id.accessibilityActionPageUp, c20450s2.b()));
                }
                C20450s2 c20450s22 = (C20450s2) AbstractC5719Kn6.a(c7631Sn6.w(), c5485Jn6.o());
                if (c20450s22 != null) {
                    x2.b(new X2.a(R.id.accessibilityActionPageDown, c20450s22.b()));
                }
                C20450s2 c20450s23 = (C20450s2) AbstractC5719Kn6.a(c7631Sn6.w(), c5485Jn6.p());
                if (c20450s23 != null) {
                    x2.b(new X2.a(R.id.accessibilityActionPageLeft, c20450s23.b()));
                }
                C20450s2 c20450s24 = (C20450s2) AbstractC5719Kn6.a(c7631Sn6.w(), c5485Jn6.q());
                if (c20450s24 != null) {
                    x2.b(new X2.a(R.id.accessibilityActionPageRight, c20450s24.b()));
                }
            }
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(ED1 ed1) {
            this();
        }
    }

    private final class e extends Y2 {
        public e() {
        }

        @Override // ir.nasim.Y2
        public void a(int i, X2 x2, String str, Bundle bundle) {
            h.this.M(i, x2, str, bundle);
        }

        @Override // ir.nasim.Y2
        public X2 b(int i) {
            X2 x2U = h.this.U(i);
            h hVar = h.this;
            if (hVar.s) {
                if (i == hVar.o) {
                    hVar.q = x2U;
                }
                if (i == hVar.p) {
                    hVar.r = x2U;
                }
            }
            return x2U;
        }

        @Override // ir.nasim.Y2
        public X2 d(int i) {
            if (i == 1) {
                if (h.this.p == Integer.MIN_VALUE) {
                    return null;
                }
                return b(h.this.p);
            }
            if (i == 2) {
                return b(h.this.o);
            }
            throw new IllegalArgumentException("Unknown focus type: " + i);
        }

        @Override // ir.nasim.Y2
        public boolean f(int i, int i2, Bundle bundle) {
            return h.this.r0(i, i2, bundle);
        }
    }

    private static final class f {
        private final C7631Sn6 a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private final long f;

        public f(C7631Sn6 c7631Sn6, int i, int i2, int i3, int i4, long j) {
            this.a = c7631Sn6;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = j;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.d;
        }

        public final int c() {
            return this.c;
        }

        public final C7631Sn6 d() {
            return this.a;
        }

        public final int e() {
            return this.e;
        }

        public final long f() {
            return this.f;
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return h.this.O(this);
        }
    }

    /* renamed from: androidx.compose.ui.platform.h$h, reason: collision with other inner class name */
    static final class C0066h extends AbstractC8614Ws3 implements UA2 {
        C0066h() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(h.this.i0().getParent().requestSendAccessibilityEvent(h.this.i0(), accessibilityEvent));
        }
    }

    static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C8482Wd6 e;
        final /* synthetic */ h f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C8482Wd6 c8482Wd6, h hVar) {
            super(0);
            this.e = c8482Wd6;
            this.f = hVar;
        }

        public final void a() {
            C7631Sn6 c7631Sn6B;
            C3419Au3 c3419Au3Q;
            C5629Kd6 c5629Kd6A = this.e.a();
            C5629Kd6 c5629Kd6E = this.e.e();
            Float fB = this.e.b();
            Float fC = this.e.c();
            float fFloatValue = (c5629Kd6A == null || fB == null) ? 0.0f : ((Number) c5629Kd6A.c().invoke()).floatValue() - fB.floatValue();
            float fFloatValue2 = (c5629Kd6E == null || fC == null) ? 0.0f : ((Number) c5629Kd6E.c().invoke()).floatValue() - fC.floatValue();
            if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                int iB0 = this.f.B0(this.e.d());
                C8338Vn6 c8338Vn6 = (C8338Vn6) this.f.a0().b(this.f.o);
                if (c8338Vn6 != null) {
                    h hVar = this.f;
                    try {
                        X2 x2 = hVar.q;
                        if (x2 != null) {
                            x2.l0(hVar.N(c8338Vn6));
                            C19938rB7 c19938rB7 = C19938rB7.a;
                        }
                    } catch (IllegalStateException unused) {
                        C19938rB7 c19938rB72 = C19938rB7.a;
                    }
                }
                C8338Vn6 c8338Vn62 = (C8338Vn6) this.f.a0().b(this.f.p);
                if (c8338Vn62 != null) {
                    h hVar2 = this.f;
                    try {
                        X2 x22 = hVar2.r;
                        if (x22 != null) {
                            x22.l0(hVar2.N(c8338Vn62));
                            C19938rB7 c19938rB73 = C19938rB7.a;
                        }
                    } catch (IllegalStateException unused2) {
                        C19938rB7 c19938rB74 = C19938rB7.a;
                    }
                }
                this.f.i0().invalidate();
                C8338Vn6 c8338Vn63 = (C8338Vn6) this.f.a0().b(iB0);
                if (c8338Vn63 != null && (c7631Sn6B = c8338Vn63.b()) != null && (c3419Au3Q = c7631Sn6B.q()) != null) {
                    h hVar3 = this.f;
                    if (c5629Kd6A != null) {
                        hVar3.t.r(iB0, c5629Kd6A);
                    }
                    if (c5629Kd6E != null) {
                        hVar3.u.r(iB0, c5629Kd6E);
                    }
                    hVar3.o0(c3419Au3Q);
                }
            }
            if (c5629Kd6A != null) {
                this.e.g((Float) c5629Kd6A.c().invoke());
            }
            if (c5629Kd6E != null) {
                this.e.h((Float) c5629Kd6E.c().invoke());
            }
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class j extends AbstractC8614Ws3 implements UA2 {
        j() {
            super(1);
        }

        public final void a(C8482Wd6 c8482Wd6) {
            h.this.z0(c8482Wd6);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C8482Wd6) obj);
            return C19938rB7.a;
        }
    }

    static final class k extends AbstractC8614Ws3 implements UA2 {
        public static final k e = new k();

        k() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C3419Au3 c3419Au3) {
            SemanticsConfiguration semanticsConfigurationE = c3419Au3.e();
            boolean z = false;
            if (semanticsConfigurationE != null && semanticsConfigurationE.C()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    static final class l extends AbstractC8614Ws3 implements UA2 {
        public static final l e = new l();

        l() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(C3419Au3 c3419Au3) {
            return Boolean.valueOf(c3419Au3.t0().q(AbstractC9572aB4.a(8)));
        }
    }

    public h(AndroidComposeView androidComposeView) {
        this.d = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.g = accessibilityManager;
        this.i = 100L;
        this.j = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: ir.nasim.eo
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                androidx.compose.ui.platform.h.X(this.a, z);
            }
        };
        this.k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: ir.nasim.fo
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                androidx.compose.ui.platform.h.R0(this.a, z);
            }
        };
        this.l = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.m = new Handler(Looper.getMainLooper());
        this.n = new e();
        this.o = RecyclerView.UNDEFINED_DURATION;
        this.p = RecyclerView.UNDEFINED_DURATION;
        this.t = new C16734lm4(0, 1, null);
        this.u = new C16734lm4(0, 1, null);
        this.v = new C19409qI6(0, 1, null);
        this.w = new C19409qI6(0, 1, null);
        this.x = -1;
        this.z = new PJ(0, 1, null);
        this.A = DJ0.b(1, null, null, 6, null);
        this.B = true;
        this.D = AbstractC21388ta3.b();
        this.E = new C17325mm4(0, 1, null);
        this.F = new C15552jm4(0, 1, null);
        this.G = new C15552jm4(0, 1, null);
        this.H = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.I = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.J = new C23001wA7();
        this.K = AbstractC21388ta3.c();
        this.L = new C7870Tn6(androidComposeView.getSemanticsOwner().d(), AbstractC21388ta3.b());
        androidComposeView.addOnAttachStateChangeListener(new a());
        this.N = new Runnable() { // from class: ir.nasim.go
            @Override // java.lang.Runnable
            public final void run() {
                androidx.compose.ui.platform.h.A0(this.a);
            }
        };
        this.O = new ArrayList();
        this.P = new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(h hVar) {
        Trace.beginSection("measureAndLayout");
        try {
            InterfaceC23714xO4.B(hVar.d, false, 1, null);
            C19938rB7 c19938rB7 = C19938rB7.a;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                hVar.R();
                Trace.endSection();
                hVar.M = false;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B0(int i2) {
        if (i2 == this.d.getSemanticsOwner().d().o()) {
            return -1;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void C0(ir.nasim.C7631Sn6 r17, ir.nasim.C7870Tn6 r18) {
        /*
            r16 = this;
            r0 = r16
            ir.nasim.mm4 r1 = ir.nasim.AbstractC4180Ea3.b()
            java.util.List r2 = r17.t()
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r4 = 0
            r5 = r4
        L13:
            if (r5 >= r3) goto L49
            java.lang.Object r6 = r2.get(r5)
            ir.nasim.Sn6 r6 = (ir.nasim.C7631Sn6) r6
            ir.nasim.sa3 r7 = r16.a0()
            int r8 = r6.o()
            boolean r7 = r7.a(r8)
            if (r7 == 0) goto L46
            ir.nasim.mm4 r7 = r18.a()
            int r8 = r6.o()
            boolean r7 = r7.a(r8)
            if (r7 != 0) goto L3f
            ir.nasim.Au3 r1 = r17.q()
            r0.o0(r1)
            return
        L3f:
            int r6 = r6.o()
            r1.g(r6)
        L46:
            int r5 = r5 + 1
            goto L13
        L49:
            ir.nasim.mm4 r2 = r18.a()
            int[] r3 = r2.b
            long[] r2 = r2.a
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L9a
            r6 = r4
        L57:
            r7 = r2[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L95
            int r9 = r6 - r5
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = r4
        L71:
            if (r11 >= r9) goto L93
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L8f
            int r12 = r6 << 3
            int r12 = r12 + r11
            r12 = r3[r12]
            boolean r12 = r1.a(r12)
            if (r12 != 0) goto L8f
            ir.nasim.Au3 r1 = r17.q()
            r0.o0(r1)
            return
        L8f:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L71
        L93:
            if (r9 != r10) goto L9a
        L95:
            if (r6 == r5) goto L9a
            int r6 = r6 + 1
            goto L57
        L9a:
            java.util.List r1 = r17.t()
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
        La5:
            if (r4 >= r2) goto Ld0
            java.lang.Object r3 = r1.get(r4)
            ir.nasim.Sn6 r3 = (ir.nasim.C7631Sn6) r3
            ir.nasim.sa3 r5 = r16.a0()
            int r6 = r3.o()
            boolean r5 = r5.a(r6)
            if (r5 == 0) goto Lcd
            ir.nasim.lm4 r5 = r0.K
            int r6 = r3.o()
            java.lang.Object r5 = r5.b(r6)
            ir.nasim.AbstractC13042fc3.f(r5)
            ir.nasim.Tn6 r5 = (ir.nasim.C7870Tn6) r5
            r0.C0(r3, r5)
        Lcd:
            int r4 = r4 + 1
            goto La5
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.C0(ir.nasim.Sn6, ir.nasim.Tn6):void");
    }

    private final boolean D0(AccessibilityEvent accessibilityEvent) {
        if (!m0()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.s = true;
        }
        try {
            return ((Boolean) this.f.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.s = false;
        }
    }

    private final boolean E0(int i2, int i3, Integer num, List list) {
        if (i2 == Integer.MIN_VALUE || !m0()) {
            return false;
        }
        AccessibilityEvent accessibilityEventT = T(i2, i3);
        if (num != null) {
            accessibilityEventT.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventT.setContentDescription(AbstractC12806fC3.e(list, ",", null, null, 0, null, null, 62, null));
        }
        return D0(accessibilityEventT);
    }

    static /* synthetic */ boolean F0(h hVar, int i2, int i3, Integer num, List list, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            num = null;
        }
        if ((i4 & 8) != 0) {
            list = null;
        }
        return hVar.E0(i2, i3, num, list);
    }

    private final void G0(int i2, int i3, String str) {
        AccessibilityEvent accessibilityEventT = T(B0(i2), 32);
        accessibilityEventT.setContentChangeTypes(i3);
        if (str != null) {
            accessibilityEventT.getText().add(str);
        }
        D0(accessibilityEventT);
    }

    private final void H0(int i2) {
        f fVar = this.C;
        if (fVar != null) {
            if (i2 != fVar.d().o()) {
                return;
            }
            if (SystemClock.uptimeMillis() - fVar.f() <= 1000) {
                AccessibilityEvent accessibilityEventT = T(B0(fVar.d().o()), 131072);
                accessibilityEventT.setFromIndex(fVar.b());
                accessibilityEventT.setToIndex(fVar.e());
                accessibilityEventT.setAction(fVar.a());
                accessibilityEventT.setMovementGranularity(fVar.c());
                accessibilityEventT.getText().add(f0(fVar.d()));
                D0(accessibilityEventT);
            }
        }
        this.C = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x069d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void I0(ir.nasim.AbstractC20768sa3 r55) {
        /*
            Method dump skipped, instructions count: 1768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.I0(ir.nasim.sa3):void");
    }

    private final void J0(C3419Au3 c3419Au3, C17325mm4 c17325mm4) {
        SemanticsConfiguration semanticsConfigurationE;
        C3419Au3 c3419Au3Q;
        if (c3419Au3.b() && !this.d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(c3419Au3)) {
            if (!c3419Au3.t0().q(AbstractC9572aB4.a(8))) {
                c3419Au3 = AbstractC14977io.q(c3419Au3, l.e);
            }
            if (c3419Au3 == null || (semanticsConfigurationE = c3419Au3.e()) == null) {
                return;
            }
            if (!semanticsConfigurationE.C() && (c3419Au3Q = AbstractC14977io.q(c3419Au3, k.e)) != null) {
                c3419Au3 = c3419Au3Q;
            }
            int iD = c3419Au3.d();
            if (c17325mm4.g(iD)) {
                F0(this, B0(iD), 2048, 1, null, 8, null);
            }
        }
    }

    private final void K0(C3419Au3 c3419Au3) {
        if (c3419Au3.b() && !this.d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(c3419Au3)) {
            int iD = c3419Au3.d();
            C5629Kd6 c5629Kd6 = (C5629Kd6) this.t.b(iD);
            C5629Kd6 c5629Kd62 = (C5629Kd6) this.u.b(iD);
            if (c5629Kd6 == null && c5629Kd62 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventT = T(iD, 4096);
            if (c5629Kd6 != null) {
                accessibilityEventT.setScrollX((int) ((Number) c5629Kd6.c().invoke()).floatValue());
                accessibilityEventT.setMaxScrollX((int) ((Number) c5629Kd6.a().invoke()).floatValue());
            }
            if (c5629Kd62 != null) {
                accessibilityEventT.setScrollY((int) ((Number) c5629Kd62.c().invoke()).floatValue());
                accessibilityEventT.setMaxScrollY((int) ((Number) c5629Kd62.a().invoke()).floatValue());
            }
            D0(accessibilityEventT);
        }
    }

    private final boolean L0(C7631Sn6 c7631Sn6, int i2, int i3, boolean z) {
        String strF0;
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C5485Jn6 c5485Jn6 = C5485Jn6.a;
        if (semanticsConfigurationW.i(c5485Jn6.y()) && AbstractC14977io.o(c7631Sn6)) {
            InterfaceC15796kB2 interfaceC15796kB2 = (InterfaceC15796kB2) ((C20450s2) c7631Sn6.w().t(c5485Jn6.y())).a();
            if (interfaceC15796kB2 != null) {
                return ((Boolean) interfaceC15796kB2.q(Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z))).booleanValue();
            }
            return false;
        }
        if ((i2 == i3 && i3 == this.x) || (strF0 = f0(c7631Sn6)) == null) {
            return false;
        }
        if (i2 < 0 || i2 != i3 || i3 > strF0.length()) {
            i2 = -1;
        }
        this.x = i2;
        boolean z2 = strF0.length() > 0;
        D0(V(B0(c7631Sn6.o()), z2 ? Integer.valueOf(this.x) : null, z2 ? Integer.valueOf(this.x) : null, z2 ? Integer.valueOf(strF0.length()) : null, strF0));
        H0(c7631Sn6.o());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int i2, X2 x2, String str, Bundle bundle) {
        C7631Sn6 c7631Sn6B;
        C8338Vn6 c8338Vn6 = (C8338Vn6) a0().b(i2);
        if (c8338Vn6 == null || (c7631Sn6B = c8338Vn6.b()) == null) {
            return;
        }
        String strF0 = f0(c7631Sn6B);
        if (AbstractC13042fc3.d(str, this.H)) {
            int iE = this.F.e(i2, -1);
            if (iE != -1) {
                x2.v().putInt(str, iE);
                return;
            }
            return;
        }
        if (AbstractC13042fc3.d(str, this.I)) {
            int iE2 = this.G.e(i2, -1);
            if (iE2 != -1) {
                x2.v().putInt(str, iE2);
                return;
            }
            return;
        }
        if (!c7631Sn6B.w().i(C5485Jn6.a.i()) || bundle == null || !AbstractC13042fc3.d(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            SemanticsConfiguration semanticsConfigurationW = c7631Sn6B.w();
            C8838Xn6 c8838Xn6 = C8838Xn6.a;
            if (!semanticsConfigurationW.i(c8838Xn6.G()) || bundle == null || !AbstractC13042fc3.d(str, "androidx.compose.ui.semantics.testTag")) {
                if (AbstractC13042fc3.d(str, "androidx.compose.ui.semantics.id")) {
                    x2.v().putInt(str, c7631Sn6B.o());
                    return;
                }
                return;
            } else {
                String str2 = (String) AbstractC5719Kn6.a(c7631Sn6B.w(), c8838Xn6.G());
                if (str2 != null) {
                    x2.v().putCharSequence(str, str2);
                    return;
                }
                return;
            }
        }
        int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i4 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i4 > 0 && i3 >= 0) {
            if (i3 < (strF0 != null ? strF0.length() : Integer.MAX_VALUE)) {
                C13774gn7 c13774gn7E = AbstractC13192fo6.e(c7631Sn6B.w());
                if (c13774gn7E == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = i3 + i5;
                    if (i6 >= c13774gn7E.l().j().length()) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(P0(c7631Sn6B, c13774gn7E.d(i6)));
                    }
                }
                x2.v().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                return;
            }
        }
        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
    }

    private final void M0(C7631Sn6 c7631Sn6, X2 x2) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        if (semanticsConfigurationW.i(c8838Xn6.h())) {
            x2.u0(true);
            x2.y0((CharSequence) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect N(C8338Vn6 c8338Vn6) {
        Rect rectA = c8338Vn6.a();
        AndroidComposeView androidComposeView = this.d;
        float f2 = rectA.left;
        float f3 = rectA.top;
        long jU = androidComposeView.u(ZG4.e((Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)));
        AndroidComposeView androidComposeView2 = this.d;
        float f4 = rectA.right;
        float f5 = rectA.bottom;
        long jU2 = androidComposeView2.u(ZG4.e((Float.floatToRawIntBits(f4) << 32) | (Float.floatToRawIntBits(f5) & 4294967295L)));
        return new Rect((int) Math.floor(Float.intBitsToFloat((int) (jU >> 32))), (int) Math.floor(Float.intBitsToFloat((int) (jU & 4294967295L))), (int) Math.ceil(Float.intBitsToFloat((int) (jU2 >> 32))), (int) Math.ceil(Float.intBitsToFloat((int) (jU2 & 4294967295L))));
    }

    private final void O0(C7631Sn6 c7631Sn6, X2 x2) {
        C13245fu c13245fuU = AbstractC14977io.u(c7631Sn6);
        x2.X0(c13245fuU != null ? Q0(c13245fuU) : null);
    }

    private final RectF P0(C7631Sn6 c7631Sn6, CK5 ck5) {
        if (c7631Sn6 == null) {
            return null;
        }
        CK5 ck5S = ck5.s(c7631Sn6.s());
        CK5 ck5I = c7631Sn6.i();
        CK5 ck5O = ck5S.q(ck5I) ? ck5S.o(ck5I) : null;
        if (ck5O == null) {
            return null;
        }
        AndroidComposeView androidComposeView = this.d;
        float fI = ck5O.i();
        long jU = androidComposeView.u(ZG4.e((Float.floatToRawIntBits(ck5O.l()) & 4294967295L) | (Float.floatToRawIntBits(fI) << 32)));
        long jU2 = this.d.u(ZG4.e((Float.floatToRawIntBits(ck5O.j()) << 32) | (Float.floatToRawIntBits(ck5O.e()) & 4294967295L)));
        return new RectF(Float.intBitsToFloat((int) (jU >> 32)), Float.intBitsToFloat((int) (jU & 4294967295L)), Float.intBitsToFloat((int) (jU2 >> 32)), Float.intBitsToFloat((int) (jU2 & 4294967295L)));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean Q(ir.nasim.AbstractC20768sa3 r21, boolean r22, int r23, long r24) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.Q(ir.nasim.sa3, boolean, int, long):boolean");
    }

    private final SpannableString Q0(C13245fu c13245fu) {
        return (SpannableString) T0(AbstractC11305cn.b(c13245fu, this.d.getDensity(), this.d.getFontFamilyResolver(), this.J), 100000);
    }

    private final void R() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (m0()) {
                C0(this.d.getSemanticsOwner().d(), this.L);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                I0(a0());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    V0();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(h hVar, boolean z) {
        hVar.l = hVar.g.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean S(int i2) {
        if (!k0(i2)) {
            return false;
        }
        this.o = RecyclerView.UNDEFINED_DURATION;
        this.q = null;
        this.d.invalidate();
        F0(this, i2, 65536, null, null, 12, null);
        return true;
    }

    private final boolean S0(C7631Sn6 c7631Sn6, int i2, boolean z, boolean z2) {
        int iZ;
        int i3;
        int iO = c7631Sn6.o();
        Integer num = this.y;
        if (num == null || iO != num.intValue()) {
            this.x = -1;
            this.y = Integer.valueOf(c7631Sn6.o());
        }
        String strF0 = f0(c7631Sn6);
        boolean z3 = false;
        if (strF0 != null && strF0.length() != 0) {
            InterfaceC24683z2 interfaceC24683z2G0 = g0(c7631Sn6, i2);
            if (interfaceC24683z2G0 == null) {
                return false;
            }
            int iY = Y(c7631Sn6);
            if (iY == -1) {
                iY = z ? 0 : strF0.length();
            }
            int[] iArrA = z ? interfaceC24683z2G0.a(iY) : interfaceC24683z2G0.b(iY);
            if (iArrA == null) {
                return false;
            }
            int i4 = iArrA[0];
            z3 = true;
            int i5 = iArrA[1];
            if (z2 && l0(c7631Sn6)) {
                iZ = Z(c7631Sn6);
                if (iZ == -1) {
                    iZ = z ? i4 : i5;
                }
                i3 = z ? i5 : i4;
            } else {
                iZ = z ? i5 : i4;
                i3 = iZ;
            }
            this.C = new f(c7631Sn6, z ? 256 : 512, i2, i4, i5, SystemClock.uptimeMillis());
            L0(c7631Sn6, iZ, i3, true);
        }
        return z3;
    }

    private final AccessibilityEvent T(int i2, int i3) {
        C8338Vn6 c8338Vn6;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i3);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        accessibilityEventObtain.setPackageName(this.d.getContext().getPackageName());
        accessibilityEventObtain.setSource(this.d, i2);
        if (m0() && (c8338Vn6 = (C8338Vn6) a0().b(i2)) != null) {
            accessibilityEventObtain.setPassword(c8338Vn6.b().w().i(C8838Xn6.a.A()));
        }
        return accessibilityEventObtain;
    }

    private final CharSequence T0(CharSequence charSequence, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        if (charSequence == null || charSequence.length() == 0 || charSequence.length() <= i2) {
            return charSequence;
        }
        int i3 = i2 - 1;
        if (Character.isHighSurrogate(charSequence.charAt(i3)) && Character.isLowSurrogate(charSequence.charAt(i2))) {
            i2 = i3;
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(0, i2);
        AbstractC13042fc3.g(charSequenceSubSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return charSequenceSubSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final X2 U(int i2) {
        InterfaceC18633oz3 interfaceC18633oz3A;
        androidx.lifecycle.j lifecycle;
        AndroidComposeView.C1928b viewTreeOwners = this.d.getViewTreeOwners();
        if (((viewTreeOwners == null || (interfaceC18633oz3A = viewTreeOwners.a()) == null || (lifecycle = interfaceC18633oz3A.getLifecycle()) == null) ? null : lifecycle.b()) == j.b.DESTROYED) {
            return null;
        }
        X2 x2A0 = X2.a0();
        C8338Vn6 c8338Vn6 = (C8338Vn6) a0().b(i2);
        if (c8338Vn6 == null) {
            return null;
        }
        C7631Sn6 c7631Sn6B = c8338Vn6.b();
        if (i2 == -1) {
            ViewParent parentForAccessibility = this.d.getParentForAccessibility();
            x2A0.L0(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            C7631Sn6 c7631Sn6R = c7631Sn6B.r();
            Integer numValueOf = c7631Sn6R != null ? Integer.valueOf(c7631Sn6R.o()) : null;
            if (numValueOf == null) {
                M73.c("semanticsNode " + i2 + " has null parent");
                throw new KotlinNothingValueException();
            }
            int iIntValue = numValueOf.intValue();
            x2A0.M0(this.d, iIntValue != this.d.getSemanticsOwner().d().o() ? iIntValue : -1);
        }
        x2A0.V0(this.d, i2);
        x2A0.l0(N(c8338Vn6));
        u0(i2, x2A0, c7631Sn6B);
        return x2A0;
    }

    private final void U0(int i2) {
        int i3 = this.e;
        if (i3 == i2) {
            return;
        }
        this.e = i2;
        F0(this, i2, 128, null, null, 12, null);
        F0(this, i3, 256, null, null, 12, null);
    }

    private final AccessibilityEvent V(int i2, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventT = T(i2, 8192);
        if (num != null) {
            accessibilityEventT.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventT.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventT.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventT.getText().add(charSequence);
        }
        return accessibilityEventT;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void V0() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.V0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(h hVar, boolean z) {
        hVar.l = z ? hVar.g.getEnabledAccessibilityServiceList(-1) : AbstractC10360bX0.m();
    }

    private final int Y(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        return (semanticsConfigurationW.i(c8838Xn6.d()) || !c7631Sn6.w().i(c8838Xn6.I())) ? this.x : C4301En7.i(((C4301En7) c7631Sn6.w().t(c8838Xn6.I())).r());
    }

    private final int Z(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        return (semanticsConfigurationW.i(c8838Xn6.d()) || !c7631Sn6.w().i(c8838Xn6.I())) ? this.x : C4301En7.n(((C4301En7) c7631Sn6.w().t(c8838Xn6.I())).r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AbstractC20768sa3 a0() {
        if (this.B) {
            this.B = false;
            this.D = AbstractC13192fo6.b(this.d.getSemanticsOwner());
            if (m0()) {
                AbstractC14977io.z(this.D, this.F, this.G, this.d.getContext().getResources());
            }
        }
        return this.D;
    }

    private final String f0(C7631Sn6 c7631Sn6) {
        C13245fu c13245fu;
        if (c7631Sn6 == null) {
            return null;
        }
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        if (semanticsConfigurationW.i(c8838Xn6.d())) {
            return AbstractC12806fC3.e((List) c7631Sn6.w().t(c8838Xn6.d()), ",", null, null, 0, null, null, 62, null);
        }
        if (c7631Sn6.w().i(c8838Xn6.g())) {
            C13245fu c13245fuH0 = h0(c7631Sn6.w());
            if (c13245fuH0 != null) {
                return c13245fuH0.k();
            }
            return null;
        }
        List list = (List) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.H());
        if (list == null || (c13245fu = (C13245fu) AbstractC15401jX0.s0(list)) == null) {
            return null;
        }
        return c13245fu.k();
    }

    private final InterfaceC24683z2 g0(C7631Sn6 c7631Sn6, int i2) {
        String strF0;
        C13774gn7 c13774gn7E;
        if (c7631Sn6 == null || (strF0 = f0(c7631Sn6)) == null || strF0.length() == 0) {
            return null;
        }
        if (i2 == 1) {
            androidx.compose.ui.platform.b bVarA = androidx.compose.ui.platform.b.d.a(this.d.getContext().getResources().getConfiguration().locale);
            bVarA.e(strF0);
            return bVarA;
        }
        if (i2 == 2) {
            androidx.compose.ui.platform.f fVarA = androidx.compose.ui.platform.f.d.a(this.d.getContext().getResources().getConfiguration().locale);
            fVarA.e(strF0);
            return fVarA;
        }
        if (i2 != 4) {
            if (i2 == 8) {
                androidx.compose.ui.platform.e eVarA = androidx.compose.ui.platform.e.c.a();
                eVarA.e(strF0);
                return eVarA;
            }
            if (i2 != 16) {
                return null;
            }
        }
        if (!c7631Sn6.w().i(C5485Jn6.a.i()) || (c13774gn7E = AbstractC13192fo6.e(c7631Sn6.w())) == null) {
            return null;
        }
        if (i2 == 4) {
            androidx.compose.ui.platform.c cVarA = androidx.compose.ui.platform.c.d.a();
            cVarA.j(strF0, c13774gn7E);
            return cVarA;
        }
        androidx.compose.ui.platform.d dVarA = androidx.compose.ui.platform.d.f.a();
        dVarA.j(strF0, c13774gn7E, c7631Sn6);
        return dVarA;
    }

    private final C13245fu h0(SemanticsConfiguration semanticsConfiguration) {
        return (C13245fu) AbstractC5719Kn6.a(semanticsConfiguration, C8838Xn6.a.g());
    }

    private final boolean k0(int i2) {
        return this.o == i2;
    }

    private final boolean l0(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        return !semanticsConfigurationW.i(c8838Xn6.d()) && c7631Sn6.w().i(c8838Xn6.g());
    }

    private final boolean n0() {
        return this.h || (this.g.isEnabled() && this.g.isTouchExplorationEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(C3419Au3 c3419Au3) {
        if (this.z.add(c3419Au3)) {
            this.A.h(C19938rB7.a);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:89:0x0191
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0190 -> B:89:0x0191). Please report as a decompilation issue!!! */
    public final boolean r0(int r17, int r18, android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 1858
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.r0(int, int, android.os.Bundle):boolean");
    }

    private static final boolean s0(C5629Kd6 c5629Kd6, float f2) {
        return (f2 < 0.0f && ((Number) c5629Kd6.c().invoke()).floatValue() > 0.0f) || (f2 > 0.0f && ((Number) c5629Kd6.c().invoke()).floatValue() < ((Number) c5629Kd6.a().invoke()).floatValue());
    }

    private static final float t0(float f2, float f3) {
        if (Math.signum(f2) == Math.signum(f3)) {
            return Math.abs(f2) < Math.abs(f3) ? f2 : f3;
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x032a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void u0(int r17, ir.nasim.X2 r18, ir.nasim.C7631Sn6 r19) {
        /*
            Method dump skipped, instructions count: 2098
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.u0(int, ir.nasim.X2, ir.nasim.Sn6):void");
    }

    private static final boolean v0(C5629Kd6 c5629Kd6) {
        return (((Number) c5629Kd6.c().invoke()).floatValue() > 0.0f && !c5629Kd6.b()) || (((Number) c5629Kd6.c().invoke()).floatValue() < ((Number) c5629Kd6.a().invoke()).floatValue() && c5629Kd6.b());
    }

    private static final boolean w0(C5629Kd6 c5629Kd6) {
        return (((Number) c5629Kd6.c().invoke()).floatValue() < ((Number) c5629Kd6.a().invoke()).floatValue() && !c5629Kd6.b()) || (((Number) c5629Kd6.c().invoke()).floatValue() > 0.0f && c5629Kd6.b());
    }

    private final boolean x0(int i2, List list) {
        boolean z;
        C8482Wd6 c8482Wd6A = AbstractC13192fo6.a(list, i2);
        if (c8482Wd6A != null) {
            z = false;
        } else {
            c8482Wd6A = new C8482Wd6(i2, this.O, null, null, null, null);
            z = true;
        }
        this.O.add(c8482Wd6A);
        return z;
    }

    private final boolean y0(int i2) {
        if (!n0() || k0(i2)) {
            return false;
        }
        int i3 = this.o;
        if (i3 != Integer.MIN_VALUE) {
            F0(this, i3, 65536, null, null, 12, null);
        }
        this.o = i2;
        this.d.invalidate();
        F0(this, i2, 32768, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(C8482Wd6 c8482Wd6) {
        if (c8482Wd6.Z0()) {
            this.d.getSnapshotObserver().i(c8482Wd6, this.P, new i(c8482Wd6, this));
        }
    }

    public final void N0(long j2) {
        this.i = j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f A[Catch: all -> 0x003a, TryCatch #1 {all -> 0x003a, blocks: (B:13:0x0035, B:25:0x0065, B:29:0x0077, B:31:0x007f, B:33:0x0088, B:35:0x0091, B:36:0x00a2, B:38:0x00a9, B:39:0x00b2, B:20:0x0051), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00cf -> B:14:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(ir.nasim.InterfaceC20295rm1 r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.h.O(ir.nasim.rm1):java.lang.Object");
    }

    public final boolean P(boolean z, int i2, long j2) {
        if (AbstractC13042fc3.d(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return Q(a0(), z, i2, j2);
        }
        return false;
    }

    public final boolean W(MotionEvent motionEvent) {
        if (!n0()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iJ0 = j0(motionEvent.getX(), motionEvent.getY());
            boolean zDispatchGenericMotionEvent = this.d.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            U0(iJ0);
            if (iJ0 == Integer.MIN_VALUE) {
                return zDispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.e == Integer.MIN_VALUE) {
            return this.d.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
        }
        U0(RecyclerView.UNDEFINED_DURATION);
        return true;
    }

    @Override // ir.nasim.C22317v2
    public Y2 b(View view) {
        return this.n;
    }

    public final String b0() {
        return this.I;
    }

    public final String c0() {
        return this.H;
    }

    public final C15552jm4 d0() {
        return this.G;
    }

    public final C15552jm4 e0() {
        return this.F;
    }

    public final AndroidComposeView i0() {
        return this.d;
    }

    public final int j0(float f2, float f3) {
        int iB0;
        InterfaceC23714xO4.B(this.d, false, 1, null);
        C18367oY2 c18367oY2 = new C18367oY2();
        C3419Au3.K0(this.d.getRoot(), ZG4.e((Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)), c18367oY2, 0, false, 12, null);
        int iO = AbstractC10360bX0.o(c18367oY2);
        while (true) {
            iB0 = RecyclerView.UNDEFINED_DURATION;
            if (-1 >= iO) {
                break;
            }
            C3419Au3 c3419Au3O = KG1.o(c18367oY2.get(iO));
            if (this.d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(c3419Au3O) != null) {
                return RecyclerView.UNDEFINED_DURATION;
            }
            if (c3419Au3O.t0().q(AbstractC9572aB4.a(8))) {
                iB0 = B0(c3419Au3O.d());
                C7631Sn6 c7631Sn6A = AbstractC8104Un6.a(c3419Au3O, false);
                if (AbstractC13192fo6.g(c7631Sn6A) && !c7631Sn6A.n().i(C8838Xn6.a.w())) {
                    break;
                }
            }
            iO--;
        }
        return iB0;
    }

    public final boolean m0() {
        if (this.h) {
            return true;
        }
        return this.g.isEnabled() && (this.l.isEmpty() ^ true);
    }

    public final void p0(C3419Au3 c3419Au3) {
        this.B = true;
        if (m0()) {
            o0(c3419Au3);
        }
    }

    public final void q0() {
        this.B = true;
        if (!m0() || this.M) {
            return;
        }
        this.M = true;
        this.m.post(this.N);
    }
}
