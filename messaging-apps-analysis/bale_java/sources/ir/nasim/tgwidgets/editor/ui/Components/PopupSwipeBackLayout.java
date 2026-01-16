package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.C22477vI7;
import ir.nasim.C4347Et;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.U22;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarMenuSlider;
import ir.nasim.tgwidgets.editor.ui.ActionBar.ActionBarPopupWindow;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class PopupSwipeBackLayout extends FrameLayout {
    SparseIntArray a;
    public float b;
    private float c;
    private GestureDetectorCompat d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Paint h;
    private Paint i;
    private int j;
    private Path k;
    private RectF l;
    private ArrayList m;
    private boolean n;
    private float o;
    private ValueAnimator p;
    private int q;
    private C4347Et r;
    m.h s;
    private int t;
    private Rect u;
    float v;
    float w;

    class a extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!PopupSwipeBackLayout.this.f && !PopupSwipeBackLayout.this.g && f >= 600.0f) {
                PopupSwipeBackLayout.this.r();
                PopupSwipeBackLayout.this.q(0.0f, f / 6000.0f);
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onScroll(android.view.MotionEvent r12, android.view.MotionEvent r13, float r14, float r15) {
            /*
                r11 = this;
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                boolean r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.d(r0)
                r1 = 1065353216(0x3f800000, float:1.0)
                if (r0 != 0) goto L80
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                boolean r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.f(r0)
                if (r0 != 0) goto L80
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                boolean r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.e(r0)
                r2 = 1
                if (r0 != 0) goto L7b
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r0 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                float r0 = r0.b
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L7b
                int r0 = r11.a
                int r0 = -r0
                float r0 = (float) r0
                int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
                if (r0 > 0) goto L7b
                float r14 = java.lang.Math.abs(r14)
                r0 = 1069547520(0x3fc00000, float:1.5)
                float r15 = r15 * r0
                float r15 = java.lang.Math.abs(r15)
                int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
                if (r14 < 0) goto L7b
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                float r15 = r14.b
                r0 = 1056964608(0x3f000000, float:0.5)
                int r15 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
                r0 = 0
                if (r15 <= 0) goto L47
                r15 = r2
                goto L48
            L47:
                r15 = r0
            L48:
                android.view.View r15 = r14.getChildAt(r15)
                boolean r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.p(r14, r13, r15)
                if (r14 != 0) goto L7b
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.k(r14, r2)
                r9 = 0
                r10 = 0
                r3 = 0
                r5 = 0
                r7 = 3
                r8 = 0
                android.view.MotionEvent r14 = android.view.MotionEvent.obtain(r3, r5, r7, r8, r9, r10)
            L63:
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r15 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                int r15 = r15.getChildCount()
                if (r0 >= r15) goto L77
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r15 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                android.view.View r15 = r15.getChildAt(r0)
                r15.dispatchTouchEvent(r14)
                int r0 = r0 + 1
                goto L63
            L77:
                r14.recycle()
                goto L80
            L7b:
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.l(r14, r2)
            L80:
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                boolean r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.d(r14)
                if (r14 == 0) goto Lb3
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                r15 = -1082130432(0xffffffffbf800000, float:-1.0)
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.m(r14, r15)
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r14 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                float r13 = r13.getX()
                float r12 = r12.getX()
                float r13 = r13 - r12
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r12 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                int r12 = r12.getWidth()
                float r12 = (float) r12
                float r13 = r13 / r12
                float r12 = java.lang.Math.min(r1, r13)
                r13 = 0
                float r12 = java.lang.Math.max(r13, r12)
                float r1 = r1 - r12
                r14.b = r1
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r12 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                r12.u()
            Lb3:
                ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout r12 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.this
                boolean r12 = ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.d(r12)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.PopupSwipeBackLayout.a.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ float a;

        b(float f) {
            this.a = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PopupSwipeBackLayout.this.r.b();
            PopupSwipeBackLayout popupSwipeBackLayout = PopupSwipeBackLayout.this;
            float f = this.a;
            popupSwipeBackLayout.b = f;
            if (f <= 0.0f) {
                popupSwipeBackLayout.q = -1;
            }
            PopupSwipeBackLayout.this.u();
            PopupSwipeBackLayout.this.f = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            PopupSwipeBackLayout.this.f = true;
            PopupSwipeBackLayout.this.c = this.a;
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            PopupSwipeBackLayout.this.f = false;
            PopupSwipeBackLayout.this.p = null;
        }
    }

    public interface d {
    }

    public PopupSwipeBackLayout(Context context, m.h hVar) {
        super(context);
        this.a = new SparseIntArray();
        this.c = -1.0f;
        this.h = new Paint(1);
        this.i = new Paint();
        this.j = 0;
        this.k = new Path();
        this.l = new RectF();
        this.m = new ArrayList();
        this.q = -1;
        this.r = new C4347Et();
        this.t = -1;
        this.u = new Rect();
        this.s = hVar;
        this.d = new GestureDetectorCompat(context, new a(ViewConfiguration.get(context).getScaledTouchSlop()));
        this.h.setColor(-16777216);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(ValueAnimator valueAnimator) {
        this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        u();
    }

    private boolean C(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f) {
            return true;
        }
        if (this.d.a(motionEvent) || !(action == 1 || action == 3)) {
            return this.e;
        }
        if (this.e) {
            r();
            q(this.b >= 0.5f ? 1.0f : 0.0f, 0.0f);
            return false;
        }
        if (!this.g) {
            return false;
        }
        r();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(float f, float f2) {
        ValueAnimator duration = ValueAnimator.ofFloat(this.b, f).setDuration((long) (Math.max(0.5f, Math.abs(this.b - f) - Math.min(0.2f, f2)) * 300.0f));
        duration.setInterpolator(InterpolatorC12631ew1.f);
        int i = C22477vI7.f;
        this.r.a();
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Ri5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.z(valueAnimator);
            }
        });
        duration.addListener(new b(f));
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.e = false;
        this.g = false;
    }

    private void w() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (i == 0) {
                if (this.b == 1.0f && childAt.getVisibility() != 4) {
                    childAt.setVisibility(4);
                }
                if (this.b != 1.0f && childAt.getVisibility() != 0) {
                    childAt.setVisibility(0);
                }
            } else if (i == this.q) {
                if (this.b == 0.0f && childAt.getVisibility() != 4) {
                    childAt.setVisibility(4);
                }
                if (this.b != 0.0f && childAt.getVisibility() != 0) {
                    childAt.setVisibility(0);
                }
            } else {
                childAt.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(MotionEvent motionEvent, View view) {
        view.getHitRect(this.u);
        if (this.u.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && (view.canScrollHorizontally(-1) || (view instanceof ActionBarMenuSlider))) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (x(motionEvent, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(ValueAnimator valueAnimator) {
        this.b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        u();
    }

    public void B(int i) {
        if (this.f) {
            return;
        }
        this.q = i;
        this.o = this.a.get(i);
        q(1.0f, 0.0f);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (getChildCount() == 0) {
            return;
        }
        View childAt = getChildAt(0);
        float top = childAt.getTop();
        float measuredWidth = childAt.getMeasuredWidth();
        float measuredHeight = childAt.getMeasuredHeight();
        int i = this.q;
        if (i != -1 && i < getChildCount()) {
            View childAt2 = getChildAt(this.q);
            float top2 = childAt2.getTop();
            float measuredWidth2 = childAt2.getMeasuredWidth();
            float measuredHeight2 = this.o;
            if (measuredHeight2 == 0.0f) {
                measuredHeight2 = childAt2.getMeasuredHeight();
            }
            if (childAt.getMeasuredWidth() != 0 && childAt.getMeasuredHeight() != 0 && childAt2.getMeasuredWidth() != 0 && childAt2.getMeasuredHeight() != 0) {
                top = AbstractC21455b.T0(top, top2, this.b);
                measuredWidth = AbstractC21455b.T0(measuredWidth, measuredWidth2, this.b);
                measuredHeight = AbstractC21455b.T0(measuredHeight, measuredHeight2, this.b);
            }
        }
        int iSave = canvas.save();
        this.k.rewind();
        int iF = AbstractC21455b.F(6.0f);
        this.l.set(0.0f, top, measuredWidth, measuredHeight + top);
        float f = iF;
        this.k.addRoundRect(this.l, f, f, Path.Direction.CW);
        canvas.clipPath(this.k);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (C(motionEvent)) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        RectF rectF = this.l;
        if (rectF != null) {
            rectF.contains(motionEvent.getX(), motionEvent.getY());
        }
        if (actionMasked == 0 && !this.l.contains(motionEvent.getX(), motionEvent.getY())) {
            callOnClick();
            return true;
        }
        int i = this.q;
        if (i < 0 || i >= getChildCount()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(this.q);
        if (this.b > 0.5f) {
            childAt = childAt2;
        }
        boolean zDispatchTouchEvent = childAt.dispatchTouchEvent(motionEvent);
        return (!zDispatchTouchEvent && actionMasked == 0) || zDispatchTouchEvent || onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        int iIndexOfChild = indexOfChild(view);
        int iSave = canvas.save();
        if (iIndexOfChild != 0) {
            int i = this.j;
            if (i == 0) {
                this.i.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.n7, this.s));
            } else {
                this.i.setColor(i);
            }
            canvas.drawRect(view.getX(), 0.0f, view.getX() + view.getMeasuredWidth(), getMeasuredHeight(), this.i);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (iIndexOfChild == 0) {
            this.h.setAlpha((int) (this.b * 64.0f));
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.h);
        }
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if ((childAt.getLayoutParams() instanceof FrameLayout.LayoutParams) && ((FrameLayout.LayoutParams) childAt.getLayoutParams()).gravity == 80) {
                int i6 = i4 - i2;
                childAt.layout(0, i6 - childAt.getMeasuredHeight(), childAt.getMeasuredWidth(), i6);
            } else {
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        u();
    }

    public void s() {
        t(true);
    }

    public void setForegroundColor(int i) {
        this.j = i;
    }

    public void setNewForegroundHeight(int i, int i2, boolean z) {
        this.a.put(i, i2);
        int i3 = this.q;
        if (i == i3 && i3 >= 0 && i3 < getChildCount()) {
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.p = null;
            }
            if (!z) {
                this.o = i2;
                u();
                return;
            }
            View childAt = getChildAt(this.q);
            float measuredHeight = this.o;
            if (measuredHeight == 0.0f) {
                measuredHeight = childAt.getMeasuredHeight();
            }
            ValueAnimator duration = ValueAnimator.ofFloat(measuredHeight, i2).setDuration(240L);
            duration.setInterpolator(U22.e);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Si5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.A(valueAnimator2);
                }
            });
            this.f = true;
            duration.addListener(new c());
            duration.start();
            this.p = duration;
        }
    }

    public void setOnHeightUpdateListener(d dVar) {
    }

    public void setSwipeBackDisallowed(boolean z) {
        this.n = z;
    }

    public void t(boolean z) {
        if (this.f) {
            return;
        }
        if (z) {
            q(0.0f, 0.0f);
            return;
        }
        this.q = -1;
        this.b = 0.0f;
        u();
    }

    public void u() {
        v(true);
    }

    public void v(boolean z) {
        float measuredWidth;
        float measuredHeight;
        View childAt = null;
        if (this.v != this.c || this.w != this.b) {
            if (!this.m.isEmpty() && this.m.size() > 0) {
                AbstractC18350oW3.a(this.m.get(0));
                throw null;
            }
            this.v = this.c;
            this.w = this.b;
        }
        View childAt2 = getChildAt(0);
        int i = this.q;
        if (i >= 0 && i < getChildCount()) {
            childAt = getChildAt(this.q);
        }
        childAt2.setTranslationX((-this.b) * getWidth() * 0.5f);
        float f = ((1.0f - this.b) * 0.05f) + 0.95f;
        childAt2.setScaleX(f);
        childAt2.setScaleY(f);
        if (childAt != null) {
            childAt.setTranslationX((1.0f - this.b) * getWidth());
        }
        w();
        float measuredWidth2 = childAt2.getMeasuredWidth();
        float measuredHeight2 = childAt2.getMeasuredHeight();
        if (childAt != null) {
            measuredWidth = childAt.getMeasuredWidth();
            measuredHeight = this.o;
            if (measuredHeight == 0.0f) {
                measuredHeight = childAt.getMeasuredHeight();
            }
        } else {
            measuredWidth = 0.0f;
            measuredHeight = 0.0f;
        }
        if (childAt2.getMeasuredWidth() == 0 || childAt2.getMeasuredHeight() == 0) {
            return;
        }
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = (ActionBarPopupWindow.ActionBarPopupWindowLayout) getParent();
        float f2 = this.b;
        float paddingTop = measuredHeight2 + ((measuredHeight - measuredHeight2) * f2) + actionBarPopupWindowLayout.getPaddingTop() + actionBarPopupWindowLayout.getPaddingBottom();
        actionBarPopupWindowLayout.a = false;
        actionBarPopupWindowLayout.setBackScaleX(((measuredWidth2 + ((measuredWidth - measuredWidth2) * f2)) + (actionBarPopupWindowLayout.getPaddingLeft() + actionBarPopupWindowLayout.getPaddingRight())) / actionBarPopupWindowLayout.getMeasuredWidth());
        if (z) {
            actionBarPopupWindowLayout.setBackScaleY(paddingTop / actionBarPopupWindowLayout.getMeasuredHeight());
        }
        actionBarPopupWindowLayout.a = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt3 = getChildAt(i2);
            childAt3.setPivotX(0.0f);
            childAt3.setPivotY(0.0f);
        }
        invalidate();
    }

    public boolean y() {
        return this.b > 0.0f;
    }
}
