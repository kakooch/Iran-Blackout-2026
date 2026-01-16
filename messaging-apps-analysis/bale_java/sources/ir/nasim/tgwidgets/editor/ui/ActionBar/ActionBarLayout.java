package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22000uV3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C4347Et;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.C;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.l;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class ActionBarLayout extends FrameLayout implements l {
    private static Drawable g1;
    private static Drawable h1;
    private static Paint i1;
    private boolean A;
    private ArrayList A0;
    private ArrayList B;
    private ArrayList B0;
    private AnimatorSet C0;
    private ArrayList D;
    C4347Et D0;
    private float E0;
    private boolean F0;
    l.b G;
    private m.k G0;
    public m.f H;
    private boolean H0;
    private int I0;
    public m.f J;
    private boolean J0;
    private boolean K0;
    private boolean L0;
    private long M0;
    private boolean N0;
    private int O0;
    private Runnable P0;
    private Runnable Q0;
    private boolean R0;
    private View S0;
    private boolean T0;
    private Runnable U0;
    private String V0;
    private int W0;
    private Runnable X0;
    protected Activity Y0;
    private List Z0;
    public boolean a;
    private Rect a1;
    private boolean b;
    private Runnable b1;
    private Runnable c;
    private int c1;
    private Runnable d;
    private int[] d1;
    private boolean e;
    ArrayList e1;
    private boolean f;
    Runnable f1;
    private boolean g;
    private ColorDrawable h;
    public LayoutContainer i;
    private LayoutContainer j;
    private DrawerLayoutContainer k;
    private ActionBar l;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout m;
    private AnimatorSet n;
    private DecelerateInterpolator o;
    private OvershootInterpolator p;
    private AccelerateDecelerateInterpolator q;
    public float r;
    private boolean s;
    protected boolean t;
    private int u;
    private int v;
    protected boolean w;
    private VelocityTracker x;
    private boolean y;
    private boolean z;
    private ArrayList z0;

    public class LayoutContainer extends FrameLayout {
        private Rect a;
        private boolean b;
        private int c;
        private Paint d;
        private int e;
        private boolean f;
        private float g;
        private float h;
        private boolean i;

        public LayoutContainer(Context context) {
            super(context);
            this.a = new Rect();
            this.d = new Paint();
            setWillNotDraw(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ValueAnimator valueAnimator) {
            m.d0.setAlpha(((Float) valueAnimator.getAnimatedValue()).intValue());
            if (ActionBarLayout.this.k != null) {
                ActionBarLayout.this.k.invalidate();
            }
            LayoutContainer layoutContainer = ActionBarLayout.this.i;
            if (layoutContainer != null) {
                layoutContainer.invalidate();
            }
            ActionBarLayout.this.invalidate();
        }

        public void c(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.g = motionEvent.getX();
                this.h = motionEvent.getY();
                this.i = false;
            } else if ((motionEvent.getAction() == 2 || motionEvent.getAction() == 1) && ActionBarLayout.this.m != null && ActionBarLayout.this.a) {
                if (!this.i && Math.sqrt(Math.pow(this.g - motionEvent.getX(), 2.0d) + Math.pow(this.h - motionEvent.getY(), 2.0d)) > AbstractC21455b.F(30.0f)) {
                    this.i = true;
                }
                if (this.i && (ActionBarLayout.this.m.getSwipeBack() == null || !ActionBarLayout.this.m.getSwipeBack().y())) {
                    for (int i = 0; i < ActionBarLayout.this.m.getItemsCount(); i++) {
                        ActionBarMenuSubItem actionBarMenuSubItem = (ActionBarMenuSubItem) ActionBarLayout.this.m.l(i);
                        if (actionBarMenuSubItem != null) {
                            Drawable background = actionBarMenuSubItem.getBackground();
                            Rect rect = AbstractC21455b.y;
                            actionBarMenuSubItem.getGlobalVisibleRect(rect);
                            boolean zContains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
                            boolean z = background.getState().length == 2;
                            if (motionEvent.getAction() == 2) {
                                if (zContains != z) {
                                    background.setState(zContains ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : new int[0]);
                                    if (zContains) {
                                        try {
                                            actionBarMenuSubItem.performHapticFeedback(9, 1);
                                        } catch (Exception unused) {
                                        }
                                    }
                                }
                            } else if (motionEvent.getAction() == 1 && zContains) {
                                actionBarMenuSubItem.performClick();
                            }
                        }
                    }
                }
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (ActionBarLayout.this.m != null && ActionBarLayout.this.a) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(m.d0.getAlpha(), 0.0f);
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.P4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.a.b(valueAnimator);
                        }
                    });
                    valueAnimatorOfFloat.setDuration(150L);
                    InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.f;
                    valueAnimatorOfFloat.setInterpolator(interpolatorC12631ew1);
                    valueAnimatorOfFloat.start();
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(ActionBarLayout.this.i, (Property<LayoutContainer, Float>) View.TRANSLATION_Y, 0.0f);
                    objectAnimatorOfFloat.setDuration(150L);
                    objectAnimatorOfFloat.setInterpolator(interpolatorC12631ew1);
                    objectAnimatorOfFloat.start();
                }
                ActionBarLayout.this.a = false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
            /*
                r5 = this;
                r5.c(r6)
                ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.this
                boolean r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.n(r0)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L17
                ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.this
                ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.o(r0)
                if (r0 != 0) goto L17
                r0 = r1
                goto L18
            L17:
                r0 = r2
            L18:
                if (r0 != 0) goto L22
                ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout r3 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.this
                boolean r3 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.p(r3)
                if (r3 == 0) goto L30
            L22:
                int r3 = r6.getActionMasked()
                if (r3 == 0) goto L47
                int r3 = r6.getActionMasked()
                r4 = 5
                if (r3 != r4) goto L30
                goto L47
            L30:
                if (r0 == 0) goto L3b
                ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout r0 = ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.this     // Catch: java.lang.Throwable -> L39
                ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout$LayoutContainer r0 = r0.i     // Catch: java.lang.Throwable -> L39
                if (r5 == r0) goto L42
                goto L3b
            L39:
                r6 = move-exception
                goto L44
            L3b:
                boolean r6 = super.dispatchTouchEvent(r6)     // Catch: java.lang.Throwable -> L39
                if (r6 == 0) goto L42
                goto L43
            L42:
                r1 = r2
            L43:
                return r1
            L44:
                ir.nasim.AbstractC6403Nl2.d(r6)
            L47:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarLayout.LayoutContainer.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            int measuredHeight;
            int y;
            if (!ActionBarLayout.this.Z0.isEmpty()) {
                AbstractC18350oW3.a(ActionBarLayout.this.Z0.get(ActionBarLayout.this.Z0.size() - 1));
            }
            if (view instanceof ActionBar) {
                return super.drawChild(canvas, view, j);
            }
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = getChildAt(i);
                if (childAt == view || !(childAt instanceof ActionBar) || childAt.getVisibility() != 0) {
                    i++;
                } else if (((ActionBar) childAt).getCastShadows()) {
                    measuredHeight = childAt.getMeasuredHeight();
                    y = (int) childAt.getY();
                }
            }
            measuredHeight = 0;
            y = 0;
            boolean zDrawChild = super.drawChild(canvas, view, j);
            if (measuredHeight != 0 && ActionBarLayout.g1 != null) {
                int i2 = y + measuredHeight;
                ActionBarLayout.g1.setBounds(0, i2, getMeasuredWidth(), ActionBarLayout.g1.getIntrinsicHeight() + i2);
                ActionBarLayout.g1.draw(canvas);
            }
            return zDrawChild;
        }

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return Build.VERSION.SDK_INT >= 28;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.c != 0) {
                int i = m.N4;
                if (this.e != m.i0(i)) {
                    Paint paint = this.d;
                    int iI0 = m.i0(i);
                    this.e = iI0;
                    paint.setColor(iI0);
                }
                canvas.drawRect(0.0f, (getMeasuredHeight() - this.c) - 3, getMeasuredWidth(), getMeasuredHeight(), this.d);
            }
            super.onDraw(canvas);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredHeight;
            int childCount = getChildCount();
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    measuredHeight = 0;
                    break;
                }
                View childAt = getChildAt(i5);
                if (childAt instanceof ActionBar) {
                    measuredHeight = childAt.getMeasuredHeight();
                    childAt.layout(0, 0, childAt.getMeasuredWidth(), measuredHeight);
                    break;
                }
                i5++;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (!(childAt2 instanceof ActionBar)) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getFitsSystemWindows()) {
                        int i7 = layoutParams.leftMargin;
                        childAt2.layout(i7, layoutParams.topMargin, childAt2.getMeasuredWidth() + i7, layoutParams.topMargin + childAt2.getMeasuredHeight());
                    } else {
                        int i8 = layoutParams.leftMargin;
                        childAt2.layout(i8, layoutParams.topMargin + measuredHeight, childAt2.getMeasuredWidth() + i8, layoutParams.topMargin + measuredHeight + childAt2.getMeasuredHeight());
                    }
                }
            }
            View rootView = getRootView();
            getWindowVisibleDisplayFrame(this.a);
            int height = (rootView.getHeight() - (this.a.top != 0 ? AbstractC21455b.d : 0)) - AbstractC21455b.s0(rootView);
            Rect rect = this.a;
            this.b = height - (rect.bottom - rect.top) > 0;
            if (ActionBarLayout.this.c != null) {
                ActionBarLayout actionBarLayout = ActionBarLayout.this;
                if (actionBarLayout.i.b || actionBarLayout.j.b) {
                    return;
                }
                AbstractC21455b.t(ActionBarLayout.this.c);
                ActionBarLayout.this.c.run();
                ActionBarLayout.this.c = null;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int measuredHeight;
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            boolean z = size2 > size;
            if (this.f != z && ActionBarLayout.this.B()) {
                ActionBarLayout.this.b();
            }
            this.f = z;
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    measuredHeight = 0;
                    break;
                }
                View childAt = getChildAt(i3);
                if (childAt instanceof ActionBar) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                    measuredHeight = childAt.getMeasuredHeight();
                    break;
                }
                i3++;
            }
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (!(childAt2 instanceof ActionBar)) {
                    if (childAt2.getFitsSystemWindows()) {
                        measureChildWithMargins(childAt2, i, 0, i2, 0);
                    } else {
                        measureChildWithMargins(childAt2, i, 0, i2, measuredHeight);
                    }
                }
            }
            setMeasuredDimension(size, size2);
        }

        public void setFragmentPanTranslationOffset(int i) {
            this.c = i;
            invalidate();
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarLayout.this.H(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ActionBarLayout.this.M0 = System.currentTimeMillis();
        }
    }

    public ActionBarLayout(Context context) {
        super(context);
        this.a = false;
        this.o = new DecelerateInterpolator(1.5f);
        this.p = new OvershootInterpolator(1.02f);
        this.q = new AccelerateDecelerateInterpolator();
        this.B = new ArrayList();
        this.D = new ArrayList();
        this.G = new l.b();
        this.z0 = new ArrayList();
        this.B0 = new ArrayList();
        this.D0 = new C4347Et();
        this.a1 = new Rect();
        this.c1 = -1;
        this.d1 = new int[2];
        this.e1 = new ArrayList();
        this.f1 = new Runnable() { // from class: ir.nasim.N4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.G();
            }
        };
        this.Y0 = (Activity) context;
        if (h1 == null) {
            h1 = getResources().getDrawable(AbstractC23598xB5.layer_shadow);
            g1 = getResources().getDrawable(AbstractC23598xB5.header_shadow).mutate();
            i1 = new Paint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(int i, l.c cVar, Runnable runnable) {
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                getLastFragment();
            } else if ((this.f || this.A) && this.Z0.size() > 1) {
                AbstractC18350oW3.a(this.Z0.get(r0.size() - 2));
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(c cVar) {
        L(cVar, false);
        setVisibility(8);
        View view = this.S0;
        if (view != null) {
            view.setVisibility(8);
        }
        DrawerLayoutContainer drawerLayoutContainer = this.k;
        if (drawerLayoutContainer != null) {
            drawerLayoutContainer.setAllowOpenDrawer(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        if (this.b) {
            getLastFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z) {
        I();
        J();
        Runnable runnable = this.c;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
            this.c = null;
        }
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            if (z) {
                animatorSet.cancel();
            }
            this.n = null;
        }
        Runnable runnable2 = this.U0;
        if (runnable2 != null) {
            AbstractC21455b.t(runnable2);
            this.U0 = null;
        }
        setAlpha(1.0f);
        this.i.setAlpha(1.0f);
        this.i.setScaleX(1.0f);
        this.i.setScaleY(1.0f);
        this.j.setAlpha(1.0f);
        this.j.setScaleX(1.0f);
        this.j.setScaleY(1.0f);
    }

    private void I() {
        if (!this.z || this.P0 == null) {
            return;
        }
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            this.n = null;
            animatorSet.cancel();
        }
        this.z = false;
        this.A = false;
        this.M0 = 0L;
        Runnable runnable = this.P0;
        this.P0 = null;
        if (runnable != null) {
            runnable.run();
        }
        w();
        w();
    }

    private void J() {
        Runnable runnable;
        if (!this.z || (runnable = this.Q0) == null) {
            return;
        }
        this.z = false;
        this.A = false;
        this.M0 = 0L;
        this.Q0 = null;
        runnable.run();
        w();
    }

    private void L(c cVar, boolean z) {
        if (this.Z0.contains(cVar)) {
            if (z) {
                List list = this.Z0;
                if (list.get(list.size() - 1) == cVar) {
                    throw null;
                }
            }
            List list2 = this.Z0;
            if (list2.get(list2.size() - 1) == cVar && this.Z0.size() <= 1) {
                throw null;
            }
            throw null;
        }
    }

    private void w() {
        if (this.J0) {
            K(this.K0, this.L0);
            this.J0 = false;
        } else if (this.F0) {
            c(this.G0, this.I0, this.H0, false);
            this.G0 = null;
            this.F0 = false;
        }
    }

    private void z(Canvas canvas, ViewGroup viewGroup) {
        if (viewGroup.getChildAt(0) != null) {
            this.h.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.h.draw(canvas);
            if (this.m == null) {
                int iF = AbstractC21455b.F(32.0f);
                int measuredWidth = (getMeasuredWidth() - iF) / 2;
                int top = (int) ((r1.getTop() + viewGroup.getTranslationY()) - AbstractC21455b.F(12));
                m.d0.setBounds(measuredWidth, top, iF + measuredWidth, (iF / 2) + top);
                m.d0.draw(canvas);
            }
        }
    }

    public void A() {
        this.g = true;
        this.f = false;
        AbstractC18350oW3.a(this.Z0.get(r1.size() - 2));
        List list = this.Z0;
        AbstractC18350oW3.a(list.get(list.size() - 1));
        throw null;
    }

    public boolean B() {
        return this.f || this.A;
    }

    public boolean C() {
        return this.z || this.w;
    }

    public void K(boolean z, boolean z2) {
        if (this.z || this.t) {
            this.J0 = true;
            this.K0 = z;
            this.L0 = z2;
            return;
        }
        int size = this.Z0.size();
        if (!z) {
            size--;
        }
        if (this.f) {
            size--;
        }
        if (size > 0) {
            AbstractC18350oW3.a(this.Z0.get(0));
            throw null;
        }
        if (z2) {
            M();
        }
    }

    public void M() {
        if (this.Z0.isEmpty()) {
            return;
        }
        v(this.Z0.size() - 1);
    }

    public boolean N() {
        return false;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public void a(final l.c cVar, final Runnable runnable) throws IOException {
        m.k kVar;
        if (this.z || this.t) {
            this.F0 = true;
            this.G0 = cVar.a;
            this.H0 = cVar.c;
            this.I0 = cVar.b;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        AnimatorSet animatorSet = this.C0;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.C0 = null;
        }
        final int size = cVar.e ? 1 : this.Z0.size();
        final Runnable runnable2 = new Runnable() { // from class: ir.nasim.L4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.D(size, cVar, runnable);
            }
        };
        if (size < 1 || !cVar.f) {
            runnable2.run();
            return;
        }
        int i = cVar.b;
        if (i != -1 && (kVar = cVar.a) != null) {
            kVar.F(i);
            m.a1(cVar.a, true, false, true, false);
        }
        if (runnable != null) {
            m.B(cVar.a, cVar.c, new Runnable() { // from class: ir.nasim.M4
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC21455b.m1(runnable2);
                }
            });
        } else {
            m.y(cVar.a, cVar.c);
            runnable2.run();
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public void b() {
        if (this.f || this.A) {
            Runnable runnable = this.d;
            if (runnable != null) {
                AbstractC21455b.t(runnable);
                this.d = null;
            }
            x(true);
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public void d(float f) {
        if (this.f && this.m == null && !this.A) {
            float translationY = this.i.getTranslationY();
            float f2 = -f;
            if (f2 > 0.0f) {
                f2 = 0.0f;
            } else if (f2 < (-AbstractC21455b.F(60.0f))) {
                A();
                f2 = 0.0f;
            }
            if (translationY != f2) {
                this.i.setTranslationY(f2);
                invalidate();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        return (keyEvent != null && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) ? super.dispatchKeyEventPreIme(keyEvent) : super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutContainer layoutContainer;
        DrawerLayoutContainer drawerLayoutContainer = this.k;
        if (drawerLayoutContainer != null && drawerLayoutContainer.h() && ((this.f || this.A || this.g) && view == this.i)) {
            this.k.invalidate();
            return false;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingRight = ((int) this.r) + getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft() + width;
        if (view == this.j) {
            paddingLeft2 = AbstractC21455b.F(1.0f) + paddingRight;
        } else if (view == this.i) {
            paddingLeft = paddingRight;
        }
        int iSave = canvas.save();
        if (!C() && !this.f) {
            canvas.clipRect(paddingLeft, 0, paddingLeft2, getHeight());
        }
        if ((this.f || this.A) && view == (layoutContainer = this.i)) {
            z(canvas, layoutContainer);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        if (paddingRight != 0 || this.c1 != -1) {
            int i = this.c1;
            if (i == -1) {
                i = width - paddingRight;
            }
            if (view == this.i) {
                float fA = AbstractC22000uV3.a(i / AbstractC21455b.F(20.0f), 0.0f, 1.0f);
                Drawable drawable = h1;
                drawable.setBounds(paddingRight - drawable.getIntrinsicWidth(), view.getTop(), paddingRight, view.getBottom());
                h1.setAlpha((int) (fA * 255.0f));
                h1.draw(canvas);
            } else if (view == this.j) {
                i1.setColor(Color.argb((int) (AbstractC22000uV3.a(i / width, 0.0f, 0.8f) * 153.0f), 0, 0, 0));
                if (this.c1 != -1) {
                    canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), i1);
                } else {
                    canvas.drawRect(paddingLeft, 0.0f, paddingLeft2, getHeight(), i1);
                }
            }
        }
        return zDrawChild;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public void e(Canvas canvas, Drawable drawable) {
        View childAt;
        if (this.f || this.A || this.g) {
            LayoutContainer layoutContainer = this.i;
            z(canvas, layoutContainer);
            if (layoutContainer.getAlpha() < 1.0f) {
                canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (layoutContainer.getAlpha() * 255.0f), 31);
            } else {
                canvas.save();
            }
            canvas.concat(layoutContainer.getMatrix());
            layoutContainer.draw(canvas);
            if (drawable != null && (childAt = layoutContainer.getChildAt(0)) != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                Rect rect = new Rect();
                childAt.getLocalVisibleRect(rect);
                rect.offset(marginLayoutParams.leftMargin, marginLayoutParams.topMargin);
                rect.top += AbstractC21455b.d - 1;
                drawable.setAlpha((int) (layoutContainer.getAlpha() * 255.0f));
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public boolean f() {
        if (this.A) {
            return false;
        }
        if (this.z && this.M0 < System.currentTimeMillis() - 1500) {
            H(true);
        }
        return this.z;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public /* bridge */ /* synthetic */ c getBackgroundFragment() {
        super.getBackgroundFragment();
        return null;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public /* bridge */ /* synthetic */ BottomSheet getBottomSheet() {
        return super.getBottomSheet();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public float getCurrentPreviewFragmentAlpha() {
        if (this.f || this.A || this.g) {
            return this.i.getAlpha();
        }
        return 0.0f;
    }

    public DrawerLayoutContainer getDrawerLayoutContainer() {
        return this.k;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public List<c> getFragmentStack() {
        return this.Z0;
    }

    public c getLastFragment() {
        if (this.Z0.isEmpty()) {
            return null;
        }
        AbstractC18350oW3.a(this.Z0.get(r0.size() - 1));
        return null;
    }

    public m.f getMessageDrawableOutMediaStart() {
        return this.J;
    }

    public m.f getMessageDrawableOutStart() {
        return this.H;
    }

    public FrameLayout getOverlayContainerView() {
        return this;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public /* bridge */ /* synthetic */ Activity getParentActivity() {
        return super.getParentActivity();
    }

    @Keep
    public float getThemeAnimationValue() {
        return this.E0;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public /* bridge */ /* synthetic */ ViewGroup getView() {
        return super.getView();
    }

    @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.l
    public /* bridge */ /* synthetic */ Window getWindow() {
        return super.getWindow();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.Z0.isEmpty() || this.Z0.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(this.Z0.get(0));
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.w || f() || onTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ActionBar actionBar;
        if (i == 82 && !f() && !this.t && (actionBar = this.l) != null) {
            actionBar.u();
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.Z0.isEmpty()) {
            AbstractC18350oW3.a(this.Z0.get(r0.size() - 1));
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (f() || this.N0 || this.w) {
            return false;
        }
        if (this.Z0.size() > 1) {
            if (motionEvent != null && motionEvent.getAction() == 0) {
                List list = this.Z0;
                AbstractC18350oW3.a(list.get(list.size() - 1));
                throw null;
            }
            if (motionEvent != null && motionEvent.getAction() == 2 && motionEvent.getPointerId(0) == this.O0) {
                if (this.x == null) {
                    this.x = VelocityTracker.obtain();
                }
                int iMax = Math.max(0, (int) (motionEvent.getX() - this.u));
                int iAbs = Math.abs(((int) motionEvent.getY()) - this.v);
                this.x.addMovement(motionEvent);
                if (!this.z && !this.f && this.s && !this.t && iMax >= AbstractC21455b.h0(0.4f, true) && Math.abs(iMax) / 3 > iAbs) {
                    List list2 = this.Z0;
                    AbstractC18350oW3.a(list2.get(list2.size() - 1));
                    throw null;
                }
                if (this.t) {
                    if (!this.y) {
                        if (this.Y0.getCurrentFocus() != null) {
                            AbstractC21455b.t0(this.Y0.getCurrentFocus());
                        }
                        List list3 = this.Z0;
                        AbstractC18350oW3.a(list3.get(list3.size() - 1));
                        throw null;
                    }
                    float f = iMax;
                    this.i.setTranslationX(f);
                    setInnerTranslationX(f);
                }
            } else if (motionEvent != null && motionEvent.getPointerId(0) == this.O0 && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 6)) {
                if (this.x == null) {
                    this.x = VelocityTracker.obtain();
                }
                this.x.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                List list4 = this.Z0;
                AbstractC18350oW3.a(list4.get(list4.size() - 1));
                if (!this.f && !this.A && !this.t) {
                    throw null;
                }
                if (this.t) {
                    this.i.getX();
                    new AnimatorSet();
                    this.x.getXVelocity();
                    this.x.getYVelocity();
                    this.i.getMeasuredWidth();
                    throw null;
                }
                this.s = false;
                this.t = false;
                VelocityTracker velocityTracker = this.x;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.x = null;
                }
            } else if (motionEvent == null) {
                this.s = false;
                this.t = false;
                VelocityTracker velocityTracker2 = this.x;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.x = null;
                }
            }
        }
        return this.t;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        onTouchEvent(null);
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setBackgroundView(View view) {
        this.S0 = view;
    }

    public void setDelegate(l.a aVar) {
    }

    public void setDrawerLayoutContainer(DrawerLayoutContainer drawerLayoutContainer) {
        this.k = drawerLayoutContainer;
    }

    public void setFragmentPanTranslationOffset(int i) {
        LayoutContainer layoutContainer = this.i;
        if (layoutContainer != null) {
            layoutContainer.setFragmentPanTranslationOffset(i);
        }
    }

    public void setFragmentStack(List<c> list) {
        this.Z0 = list;
        LayoutContainer layoutContainer = new LayoutContainer(this.Y0);
        this.j = layoutContainer;
        addView(layoutContainer);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 51;
        this.j.setLayoutParams(layoutParams);
        LayoutContainer layoutContainer2 = new LayoutContainer(this.Y0);
        this.i = layoutContainer2;
        addView(layoutContainer2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = -1;
        layoutParams2.gravity = 51;
        this.i.setLayoutParams(layoutParams2);
        Iterator it = this.Z0.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }

    public void setFragmentStackChangedListener(Runnable runnable) {
        this.b1 = runnable;
    }

    public void setHighlightActionButtons(boolean z) {
        this.a = z;
    }

    public void setInBubbleMode(boolean z) {
        this.e = z;
    }

    @Keep
    public void setInnerTranslationX(float f) {
        this.r = f;
        invalidate();
        if (this.Z0.size() < 2 || this.i.getMeasuredWidth() <= 0) {
            return;
        }
        this.i.getMeasuredWidth();
        List list = this.Z0;
        AbstractC18350oW3.a(list.get(list.size() - 2));
        throw null;
    }

    public void setRemoveActionBarExtraHeight(boolean z) {
        this.T0 = z;
    }

    @Keep
    public void setThemeAnimationValue(float f) {
        this.E0 = f;
        int size = this.z0.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.z0.get(i);
            int[] iArr = (int[]) this.B.get(i);
            int[] iArr2 = (int[]) this.D.get(i);
            if (arrayList.size() > 0) {
                int iRed = Color.red(iArr2[0]);
                int iGreen = Color.green(iArr2[0]);
                int iBlue = Color.blue(iArr2[0]);
                int iAlpha = Color.alpha(iArr2[0]);
                int iRed2 = Color.red(iArr[0]);
                int iGreen2 = Color.green(iArr[0]);
                int iBlue2 = Color.blue(iArr[0]);
                Color.argb(Math.min(255, (int) (Color.alpha(iArr[0]) + ((iAlpha - r5) * f))), Math.min(255, (int) (iRed2 + ((iRed - iRed2) * f))), Math.min(255, (int) (iGreen2 + ((iGreen - iGreen2) * f))), Math.min(255, (int) (iBlue2 + ((iBlue - iBlue2) * f))));
                AbstractC18350oW3.a(arrayList.get(0));
                throw null;
            }
        }
        int size2 = this.B0.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AbstractC18350oW3.a(this.B0.get(i2));
        }
        ArrayList arrayList2 = this.A0;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(this.A0.get(0));
        throw null;
    }

    public void setTitleOverlayText(String str, int i, Runnable runnable) {
        this.V0 = str;
        this.W0 = i;
        this.X0 = runnable;
        if (this.Z0.size() <= 0) {
            return;
        }
        AbstractC18350oW3.a(this.Z0.get(0));
        throw null;
    }

    public void setUseAlphaAnimations(boolean z) {
        this.R0 = z;
    }

    public void v(int i) {
        if (this.Z0.isEmpty()) {
            return;
        }
        if (!this.Z0.isEmpty() && this.Z0.size() - 1 == i) {
            AbstractC18350oW3.a(this.Z0.get(i));
            throw null;
        }
        if (i > 0) {
            AbstractC18350oW3.a(this.Z0.get(0));
            throw null;
        }
        AbstractC18350oW3.a(this.Z0.get(i));
        throw null;
    }

    public void x(boolean z) {
        y(z, false);
    }

    public void y(boolean z, boolean z2) {
        getLastFragment();
        if (f() || this.Z0.isEmpty()) {
            return;
        }
        if (this.Y0.getCurrentFocus() != null) {
            AbstractC21455b.t0(this.Y0.getCurrentFocus());
        }
        setInnerTranslationX(0.0f);
        if (!z2 && !this.f && !this.A && z) {
            C.m().getBoolean("view_animations", true);
        }
        List list = this.Z0;
        AbstractC18350oW3.a(list.get(list.size() - 1));
        if (this.Z0.size() > 1) {
            List list2 = this.Z0;
            AbstractC18350oW3.a(list2.get(list2.size() - 2));
        }
        final c cVar = null;
        if (!this.R0 || z2) {
            L(null, false);
            setVisibility(8);
            View view = this.S0;
            if (view == null) {
                throw null;
            }
            view.setVisibility(8);
            throw null;
        }
        this.M0 = System.currentTimeMillis();
        this.z = true;
        this.P0 = new Runnable(cVar) { // from class: ir.nasim.O4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.F(null);
            }
        };
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        arrayList.add(ObjectAnimator.ofFloat(this, (Property<ActionBarLayout, Float>) property, 1.0f, 0.0f));
        View view2 = this.S0;
        if (view2 != null) {
            arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 1.0f, 0.0f));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        this.n = animatorSet;
        animatorSet.playTogether(arrayList);
        this.n.setInterpolator(this.q);
        this.n.setDuration(200L);
        this.n.addListener(new a());
        this.n.start();
        throw null;
    }
}
