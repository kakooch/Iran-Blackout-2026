package ir.nasim.tgwidgets.editor.ui.ActionBar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.AbstractC8814Xl0;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import org.xbill.DNS.SimpleResolver;

/* loaded from: classes7.dex */
public class DrawerLayoutContainer extends FrameLayout {
    private boolean A;
    private boolean B;
    private BitmapDrawable D;
    private boolean G;
    private float H;
    private boolean J;
    private FrameLayout a;
    private View b;
    private Paint c;
    private View d;
    private l e;
    private boolean f;
    private boolean g;
    private int h;
    private int i;
    private int j;
    private VelocityTracker k;
    private boolean l;
    private AnimatorSet m;
    private Rect n;
    private Paint o;
    private Paint p;
    private boolean q;
    private Object r;
    private boolean s;
    private int t;
    private float u;
    private Drawable v;
    private boolean w;
    private boolean x;
    private float y;
    private boolean z;
    private int z0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DrawerLayoutContainer.this.k(true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DrawerLayoutContainer.this.k(false);
        }
    }

    public DrawerLayoutContainer(Context context) {
        super(context);
        this.c = new Paint();
        this.n = new Rect();
        this.o = new Paint();
        this.p = new Paint();
        this.x = true;
        this.A = true;
        this.B = true;
        this.t = (int) ((AbstractC21455b.g * 64.0f) + 0.5f);
        setDescendantFocusability(262144);
        setFocusableInTouchMode(true);
        setFitsSystemWindows(true);
        setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ir.nasim.S02
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                return this.a.i(view, windowInsets);
            }
        });
        setSystemUiVisibility(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE);
        this.v = getResources().getDrawable(AbstractC23598xB5.menu_shadow);
    }

    private void c(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i, boolean z) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = z ? 0 : windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom();
    }

    private void f(View view, Object obj, int i) {
        WindowInsets windowInsetsReplaceSystemWindowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetLeft(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), 0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsetsReplaceSystemWindowInsets = windowInsetsReplaceSystemWindowInsets.replaceSystemWindowInsets(0, windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetTop(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetRight(), windowInsetsReplaceSystemWindowInsets.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(windowInsetsReplaceSystemWindowInsets);
    }

    private View g(ViewGroup viewGroup, float f, float f2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(this.n);
                if (!this.n.contains((int) f, (int) f2)) {
                    continue;
                } else {
                    if (childAt.canScrollHorizontally(-1)) {
                        return childAt;
                    }
                    if (childAt instanceof ViewGroup) {
                        Rect rect = this.n;
                        View viewG = g((ViewGroup) childAt, f - rect.left, f2 - rect.top);
                        if (viewG != null) {
                            return viewG;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets i(View view, WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            boolean zIsVisible = windowInsets.isVisible(WindowInsets.Type.ime());
            int i2 = windowInsets.getInsets(WindowInsets.Type.ime()).bottom;
            if (this.J != zIsVisible || this.z0 != i2) {
                this.J = zIsVisible;
                this.z0 = i2;
                requestLayout();
            }
        }
        DrawerLayoutContainer drawerLayoutContainer = (DrawerLayoutContainer) view;
        if (AbstractC21455b.d != windowInsets.getSystemWindowInsetTop()) {
            drawerLayoutContainer.requestLayout();
        }
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if ((systemWindowInsetTop != 0 || AbstractC21455b.s || this.B) && AbstractC21455b.d != systemWindowInsetTop) {
            AbstractC21455b.d = systemWindowInsetTop;
        }
        boolean z = false;
        this.B = false;
        this.r = windowInsets;
        drawerLayoutContainer.setWillNotDraw(windowInsets.getSystemWindowInsetTop() <= 0 && getBackground() == null);
        if (i >= 28) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null && displayCutout.getBoundingRects().size() != 0) {
                z = true;
            }
            this.q = z;
        }
        invalidate();
        return i >= 30 ? WindowInsets.CONSUMED : windowInsets.consumeSystemWindowInsets();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z) {
        this.g = false;
        this.m = null;
        this.z = z;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.a) {
                childAt.setImportantForAccessibility(z ? 4 : 0);
            }
        }
        sendAccessibilityEvent(32);
    }

    private void m(MotionEvent motionEvent) {
        this.f = false;
        this.g = true;
        if (motionEvent != null) {
            this.h = (int) motionEvent.getX();
        }
        this.l = false;
    }

    private void setScrimOpacity(float f) {
        this.u = f;
        invalidate();
    }

    public void d() {
        AnimatorSet animatorSet = this.m;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.m = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        l lVar;
        super.dispatchDraw(canvas);
        if (!this.G || (lVar = this.e) == null) {
            return;
        }
        BitmapDrawable bitmapDrawable = this.D;
        if (bitmapDrawable != null) {
            bitmapDrawable.setAlpha((int) (lVar.getCurrentPreviewFragmentAlpha() * 255.0f));
            this.D.draw(canvas);
        }
        this.e.e(canvas, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.G || this.e == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 2) {
            float f = this.H;
            if (f == 0.0f) {
                this.H = motionEvent.getY();
                MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
                super.dispatchTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            } else {
                this.e.d(f - motionEvent.getY());
            }
        } else if (actionMasked == 1 || actionMasked == 6 || actionMasked == 3) {
            this.e.b();
        }
        return true;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int iCeil;
        int i2 = 0;
        if (!this.A) {
            return false;
        }
        int height = getHeight();
        boolean z = view != this.a;
        int width = getWidth();
        int iSave = canvas.save();
        if (z) {
            int childCount = getChildCount();
            i = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && childAt != this.a) {
                    i3 = i4;
                }
                if (childAt != view && childAt.getVisibility() == 0 && childAt == this.a && childAt.getHeight() >= height && (iCeil = ((int) Math.ceil(childAt.getX())) + childAt.getMeasuredWidth()) > i) {
                    i = iCeil;
                }
            }
            if (i != 0) {
                canvas.clipRect(i - AbstractC21455b.F(1.0f), 0, width, getHeight());
            }
            i2 = i3;
        } else {
            i = 0;
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        if (this.u <= 0.0f || !z) {
            if (this.v != null) {
                float fMax = Math.max(0.0f, Math.min(this.y / AbstractC21455b.F(20.0f), 1.0f));
                if (fMax != 0.0f) {
                    this.v.setBounds((int) this.y, view.getTop(), ((int) this.y) + this.v.getIntrinsicWidth(), view.getBottom());
                    this.v.setAlpha((int) (fMax * 255.0f));
                    this.v.draw(canvas);
                }
            }
        } else if (indexOfChild(view) == i2) {
            this.o.setColor(((int) (this.u * 153.0f)) << 24);
            canvas.drawRect(i, 0.0f, width, getHeight(), this.o);
        }
        return zDrawChild;
    }

    public void e(boolean z) {
        if (this.a == null) {
            return;
        }
        d();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "drawerPosition", 0.0f));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (z) {
            animatorSet.setDuration(Math.max((int) ((200.0f / this.a.getMeasuredWidth()) * this.y), 50));
        } else {
            animatorSet.setDuration(250L);
        }
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    public boolean h() {
        return this.G;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void j(float f) {
        setDrawerPosition(this.y + f);
    }

    public void l(boolean z) {
        l lVar;
        if (!this.w || this.a == null) {
            return;
        }
        if (AbstractC21455b.F0() && (lVar = this.e) != null && lVar.getParentActivity() != null) {
            AbstractC21455b.t0(this.e.getParentActivity().getCurrentFocus());
        }
        d();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "drawerPosition", this.a.getMeasuredWidth()));
        animatorSet.setInterpolator(new DecelerateInterpolator());
        if (z) {
            animatorSet.setDuration(Math.max((int) ((200.0f / this.a.getMeasuredWidth()) * (this.a.getMeasuredWidth() - this.y)), 50));
        } else {
            animatorSet.setDuration(250L);
        }
        animatorSet.addListener(new a());
        animatorSet.start();
        this.m = animatorSet;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Object obj = this.r;
        if (obj != null) {
            WindowInsets windowInsets = (WindowInsets) obj;
            if (windowInsets.getSystemWindowInsetBottom() > 0) {
                canvas.drawRect(0.0f, getMeasuredHeight() - r1, getMeasuredWidth(), getMeasuredHeight(), this.p);
            }
            if (this.q) {
                this.p.setColor(-16777216);
                int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
                if (systemWindowInsetLeft != 0) {
                    canvas.drawRect(0.0f, 0.0f, systemWindowInsetLeft, getMeasuredHeight(), this.p);
                }
                int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
                if (systemWindowInsetRight != 0) {
                    canvas.drawRect(systemWindowInsetRight, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.p);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.e.f() || onTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.s = true;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (!AbstractC8814Xl0.a) {
                    try {
                        if (this.a != childAt) {
                            childAt.layout(layoutParams.leftMargin, layoutParams.topMargin + getPaddingTop(), layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                        } else {
                            childAt.layout(-childAt.getMeasuredWidth(), layoutParams.topMargin + getPaddingTop(), 0, layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                        }
                    } catch (Exception e) {
                        AbstractC6403Nl2.d(e);
                    }
                } else if (this.a != childAt) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin + getPaddingTop(), layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                } else {
                    childAt.layout(-childAt.getMeasuredWidth(), layoutParams.topMargin + getPaddingTop(), 0, layoutParams.topMargin + childAt.getMeasuredHeight() + getPaddingTop());
                }
            }
        }
        this.s = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        int i3 = size2 - AbstractC21455b.d;
        if (i3 > 0 && i3 < 4096) {
            AbstractC21455b.h.y = i3;
        }
        boolean z = this.r != null;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (z) {
                    if (childAt.getFitsSystemWindows()) {
                        f(childAt, this.r, layoutParams.gravity);
                    } else if (childAt.getTag() == null) {
                        c(layoutParams, this.r, layoutParams.gravity, true);
                    }
                }
                if (this.a != childAt) {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824);
                    int iMakeMeasureSpec2 = layoutParams.height;
                    if (iMakeMeasureSpec2 <= 0) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824);
                    }
                    if ((childAt instanceof ActionBarLayout) && ((ActionBarLayout) childAt).N()) {
                        childAt.forceLayout();
                    }
                    childAt.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    childAt.setPadding(0, 0, 0, 0);
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.t + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i2, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                }
            }
        }
        View view = this.b;
        if (view != null) {
            if (view.getParent() == null) {
                ((FrameLayout) AbstractC21455b.K(getContext()).getWindow().getDecorView()).addView(this.b);
            }
            if (this.b.getLayoutParams().height == AbstractC21455b.e && ((FrameLayout.LayoutParams) this.b.getLayoutParams()).topMargin == View.MeasureSpec.getSize(i2)) {
                return;
            }
            this.b.getLayoutParams().height = AbstractC21455b.e;
            ((FrameLayout.LayoutParams) this.b.getLayoutParams()).topMargin = View.MeasureSpec.getSize(i2);
            this.b.requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.z || view == this.a) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x01a5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.ActionBar.DrawerLayoutContainer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.f && !this.g) {
            onTouchEvent(null);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.s) {
            return;
        }
        super.requestLayout();
    }

    public void setAllowOpenDrawer(boolean z, boolean z2) {
        this.w = z;
        if (z || this.y == 0.0f) {
            return;
        }
        if (z2) {
            e(true);
        } else {
            setDrawerPosition(0.0f);
            k(false);
        }
    }

    @Keep
    public void setDrawerPosition(float f) {
        View view;
        if (this.a == null) {
            return;
        }
        this.y = f;
        if (f > r0.getMeasuredWidth()) {
            this.y = this.a.getMeasuredWidth();
        } else if (this.y < 0.0f) {
            this.y = 0.0f;
        }
        this.a.setTranslationX(this.y);
        if (this.y > 0.0f && (view = this.d) != null && view.getVisibility() != 0) {
            this.d.setVisibility(0);
        }
        int i = this.y > 0.0f ? 0 : 4;
        if (this.a.getVisibility() != i) {
            this.a.setVisibility(i);
        }
        if (this.e.getFragmentStack().isEmpty()) {
            setScrimOpacity(this.y / this.a.getMeasuredWidth());
            return;
        }
        AbstractC18350oW3.a(this.e.getFragmentStack().get(0));
        if (this.y == this.a.getMeasuredWidth() || this.y == 0.0f) {
            throw null;
        }
        this.a.getMeasuredWidth();
        throw null;
    }
}
