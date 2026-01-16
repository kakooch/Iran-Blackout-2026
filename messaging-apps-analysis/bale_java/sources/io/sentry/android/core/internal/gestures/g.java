package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.gov.nist.core.Separators;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import io.sentry.B1;
import io.sentry.C3106e;
import io.sentry.D1;
import io.sentry.I;
import io.sentry.InterfaceC3127i0;
import io.sentry.O3;
import io.sentry.W3;
import io.sentry.X;
import io.sentry.Y2;
import io.sentry.Y3;
import io.sentry.Z;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.b;
import io.sentry.util.F;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class g implements GestureDetector.OnGestureListener {
    private final WeakReference a;
    private final Z b;
    private final SentryAndroidOptions c;
    private io.sentry.internal.gestures.b d = null;
    private InterfaceC3127i0 e = null;
    private b f = b.Unknown;
    private final c g = new c(null);

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.Click.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.Scroll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.Swipe.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.Unknown.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private enum b {
        Click,
        Scroll,
        Swipe,
        Unknown
    }

    public g(Activity activity, Z z, SentryAndroidOptions sentryAndroidOptions) {
        this.a = new WeakReference(activity);
        this.b = z;
        this.c = sentryAndroidOptions;
    }

    private void e(io.sentry.internal.gestures.b bVar, b bVar2, Map map, MotionEvent motionEvent) {
        if (this.c.isEnableUserInteractionBreadcrumbs()) {
            String strJ = j(bVar2);
            I i = new I();
            i.k("android:motionEvent", motionEvent);
            i.k("android:view", bVar.f());
            this.b.b(C3106e.E(strJ, bVar.d(), bVar.a(), bVar.e(), map), i);
        }
    }

    private View h(String str) {
        Activity activity = (Activity) this.a.get();
        if (activity == null) {
            this.c.getLogger().c(Y2.DEBUG, "Activity is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            this.c.getLogger().c(Y2.DEBUG, "Window is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        this.c.getLogger().c(Y2.DEBUG, "DecorView is null in " + str + ". No breadcrumb captured.", new Object[0]);
        return null;
    }

    private String i(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private static String j(b bVar) {
        int i = a.a[bVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE : "swipe" : "scroll" : "click";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(X x, InterfaceC3127i0 interfaceC3127i0, InterfaceC3127i0 interfaceC3127i02) {
        if (interfaceC3127i02 == null) {
            x.t(interfaceC3127i0);
        } else {
            this.c.getLogger().c(Y2.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", interfaceC3127i0.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(X x, InterfaceC3127i0 interfaceC3127i0) {
        if (interfaceC3127i0 == this.e) {
            x.w();
        }
    }

    private void p(io.sentry.internal.gestures.b bVar, b bVar2) {
        boolean z = bVar2 == b.Click || !(bVar2 == this.f && bVar.equals(this.d));
        if (!this.c.isTracingEnabled() || !this.c.isEnableUserInteractionTracing()) {
            if (z) {
                if (this.c.isEnableAutoTraceIdGeneration()) {
                    F.k(this.b);
                }
                this.d = bVar;
                this.f = bVar2;
                return;
            }
            return;
        }
        Activity activity = (Activity) this.a.get();
        if (activity == null) {
            this.c.getLogger().c(Y2.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        String strB = bVar.b();
        InterfaceC3127i0 interfaceC3127i0 = this.e;
        if (interfaceC3127i0 != null) {
            if (!z && !interfaceC3127i0.k()) {
                this.c.getLogger().c(Y2.DEBUG, "The view with id: " + strB + " already has an ongoing transaction assigned. Rescheduling finish", new Object[0]);
                if (this.c.getIdleTimeout() != null) {
                    this.e.d();
                    return;
                }
                return;
            }
            q(O3.OK);
        }
        String str = i(activity) + Separators.DOT + strB;
        String str2 = "ui.action." + j(bVar2);
        Y3 y3 = new Y3();
        y3.v(true);
        long deadlineTimeout = this.c.getDeadlineTimeout();
        y3.s(deadlineTimeout <= 0 ? null : Long.valueOf(deadlineTimeout));
        y3.t(this.c.getIdleTimeout());
        y3.i(true);
        y3.g("auto.ui.gesture_listener." + bVar.c());
        final InterfaceC3127i0 interfaceC3127i0K = this.b.K(new W3(str, io.sentry.protocol.F.COMPONENT, str2), y3);
        this.b.z(new D1() { // from class: io.sentry.android.core.internal.gestures.d
            @Override // io.sentry.D1
            public final void a(X x) {
                this.a.m(interfaceC3127i0K, x);
            }
        });
        this.e = interfaceC3127i0K;
        this.d = bVar;
        this.f = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void m(final X x, final InterfaceC3127i0 interfaceC3127i0) {
        x.F(new B1.c() { // from class: io.sentry.android.core.internal.gestures.e
            @Override // io.sentry.B1.c
            public final void a(InterfaceC3127i0 interfaceC3127i02) {
                this.a.k(x, interfaceC3127i0, interfaceC3127i02);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void n(final X x) {
        x.F(new B1.c() { // from class: io.sentry.android.core.internal.gestures.f
            @Override // io.sentry.B1.c
            public final void a(InterfaceC3127i0 interfaceC3127i0) {
                this.a.l(x, interfaceC3127i0);
            }
        });
    }

    public void o(MotionEvent motionEvent) {
        View viewH = h("onUp");
        io.sentry.internal.gestures.b bVar = this.g.b;
        if (viewH == null || bVar == null) {
            return;
        }
        if (this.g.a == b.Unknown) {
            this.c.getLogger().c(Y2.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
            return;
        }
        e(bVar, this.g.a, Collections.singletonMap("direction", this.g.i(motionEvent)), motionEvent);
        p(bVar, this.g.a);
        this.g.j();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.g.j();
        this.g.c = motionEvent.getX();
        this.g.d = motionEvent.getY();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.g.a = b.Swipe;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View viewH = h("onScroll");
        if (viewH != null && motionEvent != null && this.g.a == b.Unknown) {
            io.sentry.internal.gestures.b bVarA = i.a(this.c, viewH, motionEvent.getX(), motionEvent.getY(), b.a.SCROLLABLE);
            if (bVarA == null) {
                this.c.getLogger().c(Y2.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                this.g.a = b.Scroll;
                return false;
            }
            this.c.getLogger().c(Y2.DEBUG, "Scroll target found: " + bVarA.b(), new Object[0]);
            this.g.k(bVarA);
            this.g.a = b.Scroll;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View viewH = h("onSingleTapUp");
        if (viewH != null && motionEvent != null) {
            io.sentry.internal.gestures.b bVarA = i.a(this.c, viewH, motionEvent.getX(), motionEvent.getY(), b.a.CLICKABLE);
            if (bVarA == null) {
                this.c.getLogger().c(Y2.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            b bVar = b.Click;
            e(bVarA, bVar, Collections.emptyMap(), motionEvent);
            p(bVarA, bVar);
        }
        return false;
    }

    void q(O3 o3) {
        InterfaceC3127i0 interfaceC3127i0 = this.e;
        if (interfaceC3127i0 != null) {
            if (interfaceC3127i0.j() == null) {
                this.e.r(o3);
            } else {
                this.e.m();
            }
        }
        this.b.z(new D1() { // from class: io.sentry.android.core.internal.gestures.c
            @Override // io.sentry.D1
            public final void a(X x) {
                this.a.n(x);
            }
        });
        this.e = null;
        if (this.d != null) {
            this.d = null;
        }
        this.f = b.Unknown;
    }

    private static final class c {
        private b a;
        private io.sentry.internal.gestures.b b;
        private float c;
        private float d;

        private c() {
            this.a = b.Unknown;
            this.c = 0.0f;
            this.d = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String i(MotionEvent motionEvent) {
            float x = motionEvent.getX() - this.c;
            float y = motionEvent.getY() - this.d;
            return Math.abs(x) > Math.abs(y) ? x > 0.0f ? "right" : "left" : y > 0.0f ? "down" : "up";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            this.b = null;
            this.a = b.Unknown;
            this.c = 0.0f;
            this.d = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(io.sentry.internal.gestures.b bVar) {
            this.b = bVar;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }
}
