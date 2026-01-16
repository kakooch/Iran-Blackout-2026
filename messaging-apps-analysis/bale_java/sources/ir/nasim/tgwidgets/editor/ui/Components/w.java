package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.os.Build;
import android.util.Property;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC13799gq2;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C16463lJ6;
import ir.nasim.C17645nJ6;
import ir.nasim.FT7;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.Components.B;
import ir.nasim.tgwidgets.editor.ui.Components.I;
import ir.nasim.tgwidgets.editor.ui.Components.m;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class w {
    private static final AbstractC13799gq2 S = new B("pipX", new B.a() { // from class: ir.nasim.ge5
        @Override // ir.nasim.tgwidgets.editor.ui.Components.B.a
        public final float get(Object obj) {
            return ((ir.nasim.tgwidgets.editor.ui.Components.w) obj).v;
        }
    }, new B.b() { // from class: ir.nasim.he5
        @Override // ir.nasim.tgwidgets.editor.ui.Components.B.b
        public final void a(Object obj, float f2) {
            ir.nasim.tgwidgets.editor.ui.Components.w.S0((ir.nasim.tgwidgets.editor.ui.Components.w) obj, f2);
        }
    });
    private static final AbstractC13799gq2 T = new B("pipY", new B.a() { // from class: ir.nasim.ie5
        @Override // ir.nasim.tgwidgets.editor.ui.Components.B.a
        public final float get(Object obj) {
            return ((ir.nasim.tgwidgets.editor.ui.Components.w) obj).w;
        }
    }, new B.b() { // from class: ir.nasim.je5
        @Override // ir.nasim.tgwidgets.editor.ui.Components.B.b
        public final void a(Object obj, float f2) {
            ir.nasim.tgwidgets.editor.ui.Components.w.U0((ir.nasim.tgwidgets.editor.ui.Components.w) obj, f2);
        }
    });
    private static w U = new w();
    private boolean A;
    private int C;
    private int D;
    private PhotoViewer E;
    private ImageView F;
    private boolean G;
    private float H;
    private float I;
    private k J;
    private boolean K;
    private boolean L;
    private boolean N;
    private boolean Q;
    private WindowManager c;
    private WindowManager.LayoutParams d;
    private ViewGroup e;
    private FrameLayout f;
    private View g;
    private FrameLayout h;
    private boolean i;
    private PhotoViewerWebView j;
    private ScaleGestureDetector k;
    private m l;
    private boolean m;
    private boolean n;
    private View o;
    private boolean p;
    private ValueAnimator q;
    private j r;
    private int s;
    private int t;
    private float v;
    private float w;
    private C16463lJ6 x;
    private C16463lJ6 y;
    private Float z;
    private float a = 0.75f;
    private float b = 1.4f;
    private float u = 1.0f;
    private I B = new I(false);
    private Runnable M = new Runnable() { // from class: ir.nasim.le5
        @Override // java.lang.Runnable
        public final void run() {
            this.a.K0();
        }
    };
    private float[] O = new float[2];
    private Runnable P = new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.v
        @Override // java.lang.Runnable
        public final void run() {
            this.a.X0();
        }
    };
    private Runnable R = new Runnable() { // from class: ir.nasim.me5
        @Override // java.lang.Runnable
        public final void run() {
            this.a.L0();
        }
    };

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.q = null;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            w.this.W0();
        }
    }

    class c implements ScaleGestureDetector.OnScaleGestureListener {

        class a implements AbstractC12098e22.q {
            final /* synthetic */ List a;

            a(List list) {
                this.a = list;
            }

            @Override // ir.nasim.AbstractC12098e22.q
            public void a(AbstractC12098e22 abstractC12098e22, boolean z, float f, float f2) {
                abstractC12098e22.i(this);
                this.a.add((C16463lJ6) abstractC12098e22);
                if (this.a.size() == 2) {
                    c.this.d();
                }
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            w.this.e.invalidate();
            w.this.f.requestLayout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            w wVar = w.this;
            WindowManager.LayoutParams layoutParams = wVar.d;
            int iH0 = (int) (w.this.H0() * w.this.u);
            layoutParams.width = iH0;
            wVar.s = iH0;
            w wVar2 = w.this;
            WindowManager.LayoutParams layoutParams2 = wVar2.d;
            int iF0 = (int) (w.this.F0() * w.this.u);
            layoutParams2.height = iF0;
            wVar2.t = iF0;
            try {
                w.this.c.updateViewLayout(w.this.e, w.this.d);
            } catch (IllegalArgumentException unused) {
            }
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            w wVar = w.this;
            wVar.u = AbstractC22000uV3.a(wVar.u * scaleGestureDetector.getScaleFactor(), w.this.a, w.this.b);
            w.this.s = (int) (r0.H0() * w.this.u);
            w.this.t = (int) (r0.F0() * w.this.u);
            AbstractC21455b.m1(new Runnable() { // from class: ir.nasim.tgwidgets.editor.ui.Components.x
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c();
                }
            });
            float F = scaleGestureDetector.getFocusX() >= ((float) AbstractC21455b.h.x) / 2.0f ? (r1 - w.this.s) - AbstractC21455b.F(16.0f) : AbstractC21455b.F(16.0f);
            if (w.this.x.h()) {
                w.this.x.x().e(F);
            } else {
                ((C16463lJ6) w.this.x.p(w.this.v)).x().e(F);
            }
            w.this.x.s();
            float fA = AbstractC22000uV3.a(scaleGestureDetector.getFocusY() - (w.this.t / 2.0f), AbstractC21455b.F(16.0f), (AbstractC21455b.h.y - w.this.t) - AbstractC21455b.F(16.0f));
            if (w.this.y.h()) {
                w.this.y.x().e(fA);
            } else {
                ((C16463lJ6) w.this.y.p(w.this.w)).x().e(fA);
            }
            w.this.y.s();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (w.this.m) {
                w.this.m = false;
                w.this.N = false;
                w.this.u0();
                AbstractC21455b.t(w.this.P);
            }
            w.this.n = true;
            w.this.d.width = (int) (w.this.H0() * w.this.b);
            w.this.d.height = (int) (w.this.F0() * w.this.b);
            w.this.c.updateViewLayout(w.this.e, w.this.d);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (!w.this.x.h() && !w.this.y.h()) {
                d();
                return;
            }
            ArrayList arrayList = new ArrayList();
            a aVar = new a(arrayList);
            if (w.this.x.h()) {
                w.this.x.b(aVar);
            } else {
                arrayList.add(w.this.x);
            }
            if (w.this.y.h()) {
                w.this.y.b(aVar);
            } else {
                arrayList.add(w.this.y);
            }
        }
    }

    class d extends m.c {
        private float a;
        private float b;
        final /* synthetic */ int c;

        d(int i) {
            this.c = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(float f, AbstractC12098e22 abstractC12098e22, boolean z, float f2, float f3) {
            if (z) {
                return;
            }
            w.this.x.x().e(f + (w.this.s / 2.0f) >= ((float) AbstractC21455b.h.x) / 2.0f ? (r3 - w.this.s) - AbstractC21455b.F(16.0f) : AbstractC21455b.F(16.0f));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.m.c
        public boolean a(MotionEvent motionEvent) {
            if (w.this.E == null) {
                return false;
            }
            if ((w.this.E.p8() == null && w.this.j == null) || w.this.K || w.this.G || w.this.m || w.this.k.isInProgress() || !w.this.N) {
                return false;
            }
            return w.this.A0() != -9223372036854775807L && w.this.B0() >= 15000;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean z;
            if (w.this.E != null && ((w.this.E.p8() != null || w.this.j != null) && !w.this.K && !w.this.G && !w.this.m && !w.this.k.isInProgress() && w.this.N)) {
                w.this.E.p8();
                boolean z2 = motionEvent.getX() >= (((float) w.this.H0()) * w.this.u) * 0.5f;
                long jA0 = w.this.A0();
                long jB0 = w.this.B0();
                if (jA0 != -9223372036854775807L && jB0 >= 15000) {
                    long j = z2 ? jA0 + 10000 : jA0 - 10000;
                    if (jA0 != j) {
                        if (j > jB0) {
                            z = true;
                            j = jB0;
                        } else if (j < 0) {
                            z = j >= -9000;
                            j = 0;
                        } else {
                            z = true;
                        }
                        if (z) {
                            w.this.B.f(true);
                            w.this.B.e(!z2);
                            w.this.B.a(10000L);
                            w.this.g1(j);
                            w.this.d1(z2 ? 10000L : -10000L, j / jB0, true);
                            if (!w.this.p) {
                                w wVar = w.this;
                                wVar.p = true;
                                wVar.m1(true);
                                if (!w.this.Q) {
                                    w.this.Q = true;
                                    AbstractC21455b.n1(w.this.R, 2500L);
                                }
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (w.this.p) {
                for (int i = 1; i < w.this.f.getChildCount(); i++) {
                    View childAt = w.this.f.getChildAt(i);
                    if (childAt.dispatchTouchEvent(motionEvent)) {
                        w.this.o = childAt;
                        return true;
                    }
                }
            }
            this.a = w.this.v;
            this.b = w.this.w;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!w.this.m || w.this.n) {
                return false;
            }
            ((C16463lJ6) ((C16463lJ6) w.this.x.q(f)).p(w.this.v)).x().e((w.this.v + (w.this.s / 2.0f)) + (f / 7.0f) >= ((float) AbstractC21455b.h.x) / 2.0f ? (r0 - w.this.s) - AbstractC21455b.F(16.0f) : AbstractC21455b.F(16.0f));
            w.this.x.s();
            ((C16463lJ6) ((C16463lJ6) w.this.y.q(f)).p(w.this.w)).x().e(AbstractC22000uV3.a(w.this.w + (f2 / 10.0f), AbstractC21455b.F(16.0f), (AbstractC21455b.h.y - w.this.t) - AbstractC21455b.F(16.0f)));
            w.this.y.s();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int iF;
            if (!w.this.m && w.this.q == null && !w.this.n && (Math.abs(f) >= this.c || Math.abs(f2) >= this.c)) {
                w.this.m = true;
                w.this.x.d();
                w.this.y.d();
                w.this.N = false;
                w.this.u0();
                AbstractC21455b.t(w.this.P);
            }
            if (w.this.m) {
                float f3 = w.this.v;
                final float rawX = (this.a + motionEvent2.getRawX()) - motionEvent.getRawX();
                w.this.w = (this.b + motionEvent2.getRawY()) - motionEvent.getRawY();
                if (rawX <= (-w.this.s) * 0.25f || rawX >= AbstractC21455b.h.x - (w.this.s * 0.75f)) {
                    if (!w.this.L) {
                        C17645nJ6 c17645nJ6X = ((C16463lJ6) w.this.x.p(f3)).x();
                        float f4 = rawX + (w.this.s / 2.0f);
                        int iF2 = AbstractC21455b.h.x;
                        if (f4 >= iF2 / 2.0f) {
                            iF = AbstractC21455b.F(16.0f);
                        } else {
                            iF2 = AbstractC21455b.F(16.0f);
                            iF = w.this.s;
                        }
                        c17645nJ6X.e(iF2 - iF);
                        w.this.x.s();
                    }
                    w.this.L = true;
                } else if (w.this.L) {
                    if (w.this.L) {
                        w.this.x.b(new AbstractC12098e22.q() { // from class: ir.nasim.tgwidgets.editor.ui.Components.y
                            @Override // ir.nasim.AbstractC12098e22.q
                            public final void a(AbstractC12098e22 abstractC12098e22, boolean z, float f5, float f6) {
                                this.a.c(rawX, abstractC12098e22, z, f5, f6);
                            }
                        });
                        ((C16463lJ6) w.this.x.p(f3)).x().e(rawX);
                        w.this.x.s();
                    }
                    w.this.L = false;
                } else {
                    if (w.this.x.h()) {
                        w.this.x.x().e(rawX);
                    } else {
                        WindowManager.LayoutParams layoutParams = w.this.d;
                        w.this.v = rawX;
                        layoutParams.x = (int) rawX;
                        w.this.D0().i(rawX);
                    }
                    w.this.d.y = (int) w.this.w;
                    w.this.D0().j(w.this.w);
                    w.this.c.updateViewLayout(w.this.e, w.this.d);
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (w.this.q != null) {
                return true;
            }
            if (w.this.Q) {
                AbstractC21455b.t(w.this.R);
                w.this.Q = false;
            }
            w.this.p = !r4.p;
            w wVar = w.this;
            wVar.m1(wVar.p);
            if (w.this.p && !w.this.Q) {
                AbstractC21455b.n1(w.this.R, 2500L);
                w.this.Q = true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return !a(motionEvent) ? onSingleTapConfirmed(motionEvent) : super.onSingleTapUp(motionEvent);
        }
    }

    class e extends FrameLayout {
        private Path a;

        e(Context context) {
            super(context);
            this.a = new Path();
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 || actionMasked == 5) {
                if (motionEvent.getPointerCount() == 1) {
                    w.this.N = true;
                    w.this.O = new float[]{motionEvent.getX(), motionEvent.getY()};
                    AbstractC21455b.n1(w.this.P, 500L);
                } else {
                    w.this.N = false;
                    w.this.u0();
                    AbstractC21455b.t(w.this.P);
                }
            }
            if (actionMasked == 1 || actionMasked == 3 || actionMasked == 6) {
                w.this.N = false;
                w.this.u0();
                AbstractC21455b.t(w.this.P);
            }
            if (w.this.o != null) {
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.offsetLocation(w.this.o.getX(), w.this.o.getY());
                boolean zDispatchTouchEvent = w.this.o.dispatchTouchEvent(motionEvent);
                motionEventObtain.recycle();
                if (actionMasked == 1 || actionMasked == 3 || actionMasked == 6) {
                    w.this.o = null;
                }
                if (zDispatchTouchEvent) {
                    return true;
                }
            }
            MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
            motionEventObtain2.offsetLocation(motionEvent.getRawX() - motionEvent.getX(), motionEvent.getRawY() - motionEvent.getY());
            boolean zOnTouchEvent = w.this.k.onTouchEvent(motionEventObtain2);
            motionEventObtain2.recycle();
            boolean z = !w.this.k.isInProgress() && w.this.l.a(motionEvent);
            if (actionMasked == 1 || actionMasked == 3 || actionMasked == 6) {
                w.this.m = false;
                w.this.n = false;
                if (w.this.L) {
                    w.this.L = false;
                    w.y0();
                } else {
                    if (!w.this.x.h()) {
                        ((C16463lJ6) w.this.x.p(w.this.v)).x().e(w.this.v + (w.this.s / 2.0f) >= ((float) AbstractC21455b.h.x) / 2.0f ? (r5 - w.this.s) - AbstractC21455b.F(16.0f) : AbstractC21455b.F(16.0f));
                        w.this.x.s();
                    }
                    if (!w.this.y.h()) {
                        ((C16463lJ6) w.this.y.p(w.this.w)).x().e(AbstractC22000uV3.a(w.this.w, AbstractC21455b.F(16.0f), (AbstractC21455b.h.y - w.this.t) - AbstractC21455b.F(16.0f)));
                        w.this.y.s();
                    }
                }
            }
            return zOnTouchEvent || z;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            super.draw(canvas);
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            AbstractC21455b.v(getContext(), configuration);
            w.this.r = null;
            if (w.this.s == w.this.H0() * w.this.u && w.this.t == w.this.F0() * w.this.u) {
                return;
            }
            WindowManager.LayoutParams layoutParams = w.this.d;
            w wVar = w.this;
            int iH0 = (int) (wVar.H0() * w.this.u);
            wVar.s = iH0;
            layoutParams.width = iH0;
            WindowManager.LayoutParams layoutParams2 = w.this.d;
            w wVar2 = w.this;
            int iF0 = (int) (wVar2.F0() * w.this.u);
            wVar2.t = iF0;
            layoutParams2.height = iF0;
            w.this.c.updateViewLayout(w.this.e, w.this.d);
            C17645nJ6 c17645nJ6X = ((C16463lJ6) w.this.x.p(w.this.v)).x();
            float fH0 = w.this.v + ((w.this.H0() * w.this.u) / 2.0f);
            int i = AbstractC21455b.h.x;
            c17645nJ6X.e(fH0 >= ((float) i) / 2.0f ? (i - (w.this.H0() * w.this.u)) - AbstractC21455b.F(16.0f) : AbstractC21455b.F(16.0f));
            w.this.x.s();
            ((C16463lJ6) w.this.y.p(w.this.w)).x().e(AbstractC22000uV3.a(w.this.w, AbstractC21455b.F(16.0f), (AbstractC21455b.h.y - (w.this.F0() * w.this.u)) - AbstractC21455b.F(16.0f)));
            w.this.y.s();
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.a.rewind();
            RectF rectF = AbstractC21455b.x;
            rectF.set(0.0f, 0.0f, i, i2);
            this.a.addRoundRect(rectF, AbstractC21455b.F(10.0f), AbstractC21455b.F(10.0f), Path.Direction.CW);
        }
    }

    class f extends ViewGroup {
        f(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.scale(w.this.s / w.this.f.getWidth(), w.this.t / w.this.f.getHeight());
            super.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            w.this.f.layout(0, 0, w.this.s, w.this.t);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            w.this.f.measure(View.MeasureSpec.makeMeasureSpec(w.this.s, 1073741824), View.MeasureSpec.makeMeasureSpec(w.this.t, 1073741824));
        }
    }

    class g extends ViewOutlineProvider {
        g() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), AbstractC21455b.F(10.0f));
        }
    }

    class h implements I.a {
        h() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.I.a
        public void a() {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.I.a
        public void invalidate() {
            w.this.h.invalidate();
        }
    }

    class i extends FrameLayout {
        i(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (w.this.B.c()) {
                w.this.B.setBounds(getLeft(), getTop(), getRight(), getBottom());
                w.this.B.draw(canvas);
            }
        }
    }

    private static final class j {
        private SharedPreferences a;

        /* JADX INFO: Access modifiers changed from: private */
        public float f() {
            return this.a.getFloat("x", -1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float g() {
            return this.a.getFloat("y", -1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float h() {
            return this.a.getFloat("scale_factor", 1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(float f) {
            this.a.edit().putFloat("x", f).apply();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(float f) {
            this.a.edit().putFloat("y", f).apply();
        }

        private j(int i, int i2) {
            this.a = AbstractC14047hG.a.getSharedPreferences("pip_layout_" + i + "_" + i2, 0);
        }
    }

    private final class k extends View {
        private Paint a;
        private Paint b;

        public k(Context context) {
            super(context);
            this.a = new Paint();
            this.b = new Paint();
            this.a.setColor(-1);
            Paint paint = this.a;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            Paint paint2 = this.a;
            Paint.Cap cap = Paint.Cap.ROUND;
            paint2.setStrokeCap(cap);
            this.a.setStrokeWidth(AbstractC21455b.F(2.0f));
            this.b.setColor(this.a.getColor());
            this.b.setAlpha((int) (this.a.getAlpha() * 0.3f));
            this.b.setStyle(style);
            this.b.setStrokeCap(cap);
            this.b.setStrokeWidth(AbstractC21455b.F(2.0f));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (!w.this.i || (w.this.j != null && w.this.j.H())) {
                int width = getWidth();
                int iF = AbstractC21455b.F(10.0f);
                float f = (width - iF) - iF;
                int i = ((int) (w.this.H * f)) + iF;
                float height = getHeight() - AbstractC21455b.F(8.0f);
                if (w.this.I != 0.0f) {
                    float f2 = iF;
                    canvas.drawLine(f2, height, f2 + (f * w.this.I), height, this.b);
                }
                canvas.drawLine(iF, height, i, height, this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A0() {
        if (this.j != null) {
            return r0.getCurrentPosition();
        }
        FT7 ft7P8 = this.E.p8();
        if (ft7P8 == null) {
            return 0L;
        }
        return ft7P8.s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long B0() {
        if (this.j != null) {
            return r0.getVideoDuration();
        }
        FT7 ft7P8 = this.E.p8();
        if (ft7P8 == null) {
            return 0L;
        }
        return ft7P8.u1();
    }

    public static View C0() {
        return U.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j D0() {
        if (this.r == null) {
            Point point = AbstractC21455b.h;
            this.r = new j(point.x, point.y);
        }
        return this.r;
    }

    private float E0() {
        if (this.z == null) {
            this.z = Float.valueOf(this.D / this.C);
            Point point = AbstractC21455b.h;
            this.b = (Math.min(point.x, point.y) - AbstractC21455b.F(32.0f)) / H0();
            this.B.g(this.z.floatValue() < 1.0f ? 0.6f : 0.45f);
        }
        return this.z.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F0() {
        return G0(E0());
    }

    private static int G0(float f2) {
        return (int) (I0(f2) * f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H0() {
        return I0(E0());
    }

    private static int I0(float f2) {
        float fMin;
        float f3;
        if (f2 >= 1.0f) {
            Point point = AbstractC21455b.h;
            fMin = Math.min(point.x, point.y);
            f3 = 0.35f;
        } else {
            Point point2 = AbstractC21455b.h;
            fMin = Math.min(point2.x, point2.y);
            f3 = 0.6f;
        }
        return (int) (fMin * f3);
    }

    public static boolean J0() {
        return U.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        PhotoViewer photoViewer = this.E;
        if (photoViewer == null) {
            return;
        }
        if (this.j != null) {
            this.H = r1.getCurrentPosition() / this.j.getVideoDuration();
            this.I = this.j.getBufferedPosition();
        } else {
            if (photoViewer.p8() == null) {
                return;
            }
            float fB0 = B0();
            this.H = r0.s1() / fB0;
            this.I = r0.q1() / fB0;
        }
        this.J.invalidate();
        AbstractC21455b.n1(this.M, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0() {
        PhotoViewer photoViewer = this.E;
        if (photoViewer != null && photoViewer.q8().a > 0) {
            AbstractC21455b.n1(this.R, 1500L);
            return;
        }
        this.p = false;
        m1(false);
        this.Q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(View view) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) view.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
            int i2 = runningAppProcesses.get(0).importance;
        }
        PhotoViewer photoViewer = this.E;
        if (photoViewer != null) {
            photoViewer.Q7();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(View view) {
        PhotoViewer photoViewer = this.E;
        if (photoViewer == null) {
            return;
        }
        PhotoViewerWebView photoViewerWebView = this.j;
        if (photoViewerWebView == null) {
            FT7 ft7P8 = photoViewer.p8();
            if (ft7P8 == null) {
                return;
            }
            if (ft7P8.A1()) {
                ft7P8.D1();
            } else {
                ft7P8.E1();
            }
        } else if (photoViewerWebView.K()) {
            this.j.P();
        } else {
            this.j.Q();
        }
        n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(AbstractC12098e22 abstractC12098e22, boolean z, float f2, float f3) {
        D0().i(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(AbstractC12098e22 abstractC12098e22, boolean z, float f2, float f3) {
        D0().j(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S0(w wVar, float f2) {
        WindowManager.LayoutParams layoutParams = wVar.d;
        wVar.v = f2;
        layoutParams.x = (int) f2;
        try {
            wVar.c.updateViewLayout(wVar.e, layoutParams);
        } catch (IllegalArgumentException unused) {
            wVar.x.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U0(w wVar, float f2) {
        WindowManager.LayoutParams layoutParams = wVar.d;
        wVar.w = f2;
        layoutParams.y = (int) f2;
        try {
            wVar.c.updateViewLayout(wVar.e, layoutParams);
        } catch (IllegalArgumentException unused) {
            wVar.y.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(ValueAnimator valueAnimator) {
        this.h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        try {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null && viewGroup.getParent() != null) {
                this.c.removeViewImmediate(this.e);
            }
        } catch (Exception unused) {
        }
        PhotoViewerWebView photoViewerWebView = this.j;
        if (photoViewerWebView != null) {
            photoViewerWebView.X();
        }
        this.J = null;
        this.g = null;
        this.E = null;
        this.j = null;
        this.o = null;
        this.m = false;
        this.A = false;
        this.K = false;
        this.N = false;
        u0();
        AbstractC21455b.t(this.P);
    }

    public static void Y0() {
        U.Z0();
    }

    private void Z0() {
        this.B.h(false);
    }

    public static void a1(boolean z) {
        U.b1(z);
    }

    private void b1(boolean z) {
        this.B.f(false);
        this.B.e(!z);
        this.B.h(true);
        k kVar = this.J;
        if (kVar != null) {
            kVar.invalidate();
        }
        FrameLayout frameLayout = this.h;
        if (frameLayout != null) {
            frameLayout.invalidate();
        }
    }

    public static void c1(long j2, float f2, boolean z) {
        U.d1(j2, f2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(long j2, float f2, boolean z) {
        this.B.i(0L);
        if (z) {
            this.H = f2;
            k kVar = this.J;
            if (kVar != null) {
                kVar.invalidate();
            }
            FrameLayout frameLayout = this.h;
            if (frameLayout != null) {
                frameLayout.invalidate();
            }
        }
    }

    public static void e1() {
        U.f1();
    }

    private void f1() {
        k kVar;
        if (!this.A || (kVar = this.J) == null) {
            return;
        }
        this.G = true;
        this.H = 0.0f;
        this.I = 0.0f;
        if (kVar != null) {
            kVar.invalidate();
        }
        o1();
        AbstractC21455b.t(this.M);
        if (this.p) {
            return;
        }
        m1(true);
        AbstractC21455b.t(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(long j2) {
        PhotoViewerWebView photoViewerWebView = this.j;
        if (photoViewerWebView != null) {
            photoViewerWebView.V(j2);
            return;
        }
        FT7 ft7P8 = this.E.p8();
        if (ft7P8 == null) {
            return;
        }
        ft7P8.I1(j2);
    }

    public static void h1(float f2) {
        w wVar = U;
        wVar.I = f2;
        k kVar = wVar.J;
        if (kVar != null) {
            kVar.invalidate();
        }
    }

    public static void i1(PhotoViewer photoViewer) {
        w wVar = U;
        wVar.E = photoViewer;
        wVar.o1();
    }

    public static boolean j1(boolean z, Activity activity, View view, int i2, int i3, boolean z2) {
        return k1(z, activity, null, view, i2, i3, z2);
    }

    public static boolean k1(boolean z, Activity activity, PhotoViewerWebView photoViewerWebView, View view, int i2, int i3, boolean z2) {
        return U.l1(z, activity, view, photoViewerWebView, i2, i3, z2);
    }

    private boolean l1(boolean z, Activity activity, View view, PhotoViewerWebView photoViewerWebView, int i2, int i3, boolean z2) {
        PhotoViewerWebView photoViewerWebView2;
        if (this.A) {
            return false;
        }
        this.A = true;
        this.C = i2;
        this.D = i3;
        this.z = null;
        if (photoViewerWebView == null || !photoViewerWebView.H()) {
            this.j = null;
        } else {
            this.j = photoViewerWebView;
            photoViewerWebView.F();
        }
        float f2 = D0().f();
        float fG = D0().g();
        this.u = D0().h();
        this.s = (int) (H0() * this.u);
        this.t = (int) (F0() * this.u);
        this.p = false;
        this.x = (C16463lJ6) new C16463lJ6(this, S).A(new C17645nJ6().d(0.75f).f(650.0f)).b(new AbstractC12098e22.q() { // from class: ir.nasim.ne5
            @Override // ir.nasim.AbstractC12098e22.q
            public final void a(AbstractC12098e22 abstractC12098e22, boolean z3, float f3, float f4) {
                this.a.O0(abstractC12098e22, z3, f3, f4);
            }
        });
        this.y = (C16463lJ6) new C16463lJ6(this, T).A(new C17645nJ6().d(0.75f).f(650.0f)).b(new AbstractC12098e22.q() { // from class: ir.nasim.ce5
            @Override // ir.nasim.AbstractC12098e22.q
            public final void a(AbstractC12098e22 abstractC12098e22, boolean z3, float f3, float f4) {
                this.a.P0(abstractC12098e22, z3, f3, f4);
            }
        });
        Context context = AbstractC14047hG.a;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, new c());
        this.k = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.k.setStylusScaleEnabled(false);
        this.l = new m(context, new d(scaledTouchSlop));
        this.f = new e(context);
        f fVar = new f(context);
        this.e = fVar;
        fVar.addView(this.f, AbstractC13840gu3.b(-1, -1.0f));
        this.f.setOutlineProvider(new g());
        this.f.setClipToOutline(true);
        this.f.setBackgroundColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.ae));
        this.g = view;
        if (view.getParent() != null) {
            ((ViewGroup) this.g.getParent()).removeView(this.g);
        }
        this.f.addView(this.g, AbstractC13840gu3.b(-1, -1.0f));
        this.B.d(new h());
        i iVar = new i(context);
        this.h = iVar;
        iVar.setWillNotDraw(false);
        this.h.setAlpha(0.0f);
        View view2 = new View(context);
        view2.setBackgroundColor(1275068416);
        this.h.addView(view2, AbstractC13840gu3.b(-1, -1.0f));
        int iF = AbstractC21455b.F(8.0f);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(AbstractC23598xB5.pip_video_close);
        int i4 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.be;
        int iI0 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i4);
        PorterDuff.Mode mode = PorterDuff.Mode.MULTIPLY;
        imageView.setColorFilter(iI0, mode);
        int i5 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.S4;
        imageView.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i5)));
        imageView.setPadding(iF, iF, iF, iF);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.de5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ir.nasim.tgwidgets.editor.ui.Components.w.y0();
            }
        });
        float f3 = 38;
        float f4 = 4;
        this.h.addView(imageView, AbstractC13840gu3.c(38, f3, 5, 0.0f, f4, f4, 0.0f));
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(AbstractC23598xB5.pip_video_expand);
        imageView2.setColorFilter(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i4), mode);
        imageView2.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i5)));
        imageView2.setPadding(iF, iF, iF, iF);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ee5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.a.M0(view3);
            }
        });
        this.h.addView(imageView2, AbstractC13840gu3.c(38, f3, 5, 0.0f, f4, 48, 0.0f));
        ImageView imageView3 = new ImageView(context);
        this.F = imageView3;
        imageView3.setColorFilter(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i4), mode);
        this.F.setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y(ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(i5)));
        this.F.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fe5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.a.N0(view3);
            }
        });
        View view3 = this.g;
        boolean z3 = (view3 instanceof WebView) || (view3 instanceof PhotoViewerWebView);
        this.i = z3;
        this.F.setVisibility((!z3 || ((photoViewerWebView2 = this.j) != null && photoViewerWebView2.H())) ? 0 : 8);
        this.h.addView(this.F, AbstractC13840gu3.d(38, 38, 17));
        k kVar = new k(context);
        this.J = kVar;
        this.h.addView(kVar, AbstractC13840gu3.b(-1, -1.0f));
        this.f.addView(this.h, AbstractC13840gu3.b(-1, -1.0f));
        this.c = (WindowManager) (z ? activity : AbstractC14047hG.a).getSystemService("window");
        WindowManager.LayoutParams layoutParamsV0 = v0(z);
        this.d = layoutParamsV0;
        int i6 = this.s;
        layoutParamsV0.width = i6;
        layoutParamsV0.height = this.t;
        if (f2 != -1.0f) {
            float F = f2 + (i6 / 2.0f) >= ((float) AbstractC21455b.h.x) / 2.0f ? (r6 - i6) - AbstractC21455b.F(16.0f) : AbstractC21455b.F(16.0f);
            this.v = F;
            layoutParamsV0.x = (int) F;
        } else {
            float F2 = (AbstractC21455b.h.x - i6) - AbstractC21455b.F(16.0f);
            this.v = F2;
            layoutParamsV0.x = (int) F2;
        }
        if (fG != -1.0f) {
            WindowManager.LayoutParams layoutParams = this.d;
            float fA = AbstractC22000uV3.a(fG, AbstractC21455b.F(16.0f), (AbstractC21455b.h.y - AbstractC21455b.F(16.0f)) - this.t);
            this.w = fA;
            layoutParams.y = (int) fA;
        } else {
            WindowManager.LayoutParams layoutParams2 = this.d;
            float F3 = AbstractC21455b.F(16.0f);
            this.w = F3;
            layoutParams2.y = (int) F3;
        }
        WindowManager.LayoutParams layoutParams3 = this.d;
        layoutParams3.dimAmount = 0.0f;
        layoutParams3.flags = 520;
        if (z2) {
            this.c.addView(this.e, layoutParams3);
        } else {
            this.e.setAlpha(0.0f);
            this.e.setScaleX(0.1f);
            this.e.setScaleY(0.1f);
            this.c.addView(this.e, this.d);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(250L);
            animatorSet.setInterpolator(InterpolatorC12631ew1.f);
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.e, (Property<ViewGroup, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.e, (Property<ViewGroup, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.e, (Property<ViewGroup, Float>) View.SCALE_Y, 1.0f));
            animatorSet.start();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(boolean z) {
        ValueAnimator duration = ValueAnimator.ofFloat(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f).setDuration(200L);
        this.q = duration;
        duration.setInterpolator(InterpolatorC12631ew1.f);
        this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.ke5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.V0(valueAnimator);
            }
        });
        this.q.addListener(new a());
        this.q.start();
    }

    public static void n1() {
        U.o1();
    }

    private void o1() {
        boolean zA1;
        PhotoViewer photoViewer = this.E;
        if (photoViewer == null || this.F == null) {
            return;
        }
        PhotoViewerWebView photoViewerWebView = this.j;
        if (photoViewerWebView != null) {
            zA1 = photoViewerWebView.K();
        } else {
            FT7 ft7P8 = photoViewer.p8();
            if (ft7P8 == null) {
                return;
            } else {
                zA1 = ft7P8.A1();
            }
        }
        AbstractC21455b.t(this.M);
        if (zA1) {
            this.F.setImageResource(AbstractC23598xB5.pip_pause_large);
            AbstractC21455b.n1(this.M, 500L);
        } else if (this.G) {
            this.F.setImageResource(AbstractC23598xB5.pip_replay_large);
        } else {
            this.F.setImageResource(AbstractC23598xB5.pip_play_large);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        PhotoViewer photoViewer = this.E;
        if (photoViewer != null && photoViewer.q8().a > 0) {
            this.E.q8().o();
        }
    }

    private WindowManager.LayoutParams v0(boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 51;
        layoutParams.format = -3;
        if (z || !AbstractC21455b.x(AbstractC14047hG.a)) {
            layoutParams.type = 99;
        } else if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.flags = 520;
        return layoutParams;
    }

    public static void w0() {
        x0(false);
    }

    public static void x0(boolean z) {
        U.z0(z);
    }

    public static void y0() {
        PhotoViewer photoViewer = U.E;
        if (photoViewer != null) {
            photoViewer.J7();
            MediaController.Y().M0();
        }
        w0();
    }

    private void z0(boolean z) {
        if (this.K) {
            return;
        }
        this.K = true;
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.Q) {
            AbstractC21455b.t(this.R);
            this.Q = false;
        }
        C16463lJ6 c16463lJ6 = this.x;
        if (c16463lJ6 != null) {
            c16463lJ6.d();
            this.y.d();
        }
        if (z || this.e == null) {
            AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.be5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.W0();
                }
            }, 100L);
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.setInterpolator(InterpolatorC12631ew1.f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.e, (Property<ViewGroup, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.e, (Property<ViewGroup, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.e, (Property<ViewGroup, Float>) View.SCALE_Y, 0.1f));
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    protected void X0() {
        PhotoViewer photoViewer = this.E;
        if (photoViewer != null) {
            if ((photoViewer.p8() == null && this.j == null) || this.K || this.G || this.m || this.k.isInProgress() || !this.N) {
                return;
            }
            FT7 ft7P8 = this.E.p8();
            boolean z = this.O[0] >= (((float) H0()) * this.u) * 0.5f;
            long jA0 = A0();
            long jB0 = B0();
            if (jA0 == -9223372036854775807L || jB0 < 15000) {
                return;
            }
            if (this.j != null) {
                this.E.q8().z(this.j, z, this.E.e8());
            } else {
                this.E.q8().y(ft7P8, z, this.E.e8());
            }
            if (this.p) {
                return;
            }
            this.p = true;
            m1(true);
            if (this.Q) {
                return;
            }
            AbstractC21455b.n1(this.R, 1500L);
            this.Q = true;
        }
    }
}
