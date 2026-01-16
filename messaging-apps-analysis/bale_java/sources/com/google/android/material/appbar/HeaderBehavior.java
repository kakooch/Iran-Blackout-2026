package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC22000uV3;

/* loaded from: classes3.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private Runnable d;
    OverScroller e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private VelocityTracker j;

    private class a implements Runnable {
        private final CoordinatorLayout a;
        private final View b;

        a(CoordinatorLayout coordinatorLayout, View view) {
            this.a = coordinatorLayout;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.b == null || (overScroller = HeaderBehavior.this.e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.N(this.a, this.b);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.P(this.a, this.b, headerBehavior.e.getCurrY());
            AbstractC12990fW7.h0(this.b, this);
        }
    }

    public HeaderBehavior() {
        this.g = -1;
        this.i = -1;
    }

    private void I() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, android.view.View r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.h = r12
            goto L4c
        L2d:
            int r0 = r11.g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.h
            int r7 = r1 - r0
            r11.h = r0
            int r8 = r11.K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.O(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.j
            int r4 = r11.g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.J(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f = r3
            r11.g = r1
            android.view.VelocityTracker r13 = r11.j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.j = r13
        L81:
            android.view.VelocityTracker r13 = r11.j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    boolean H(View view) {
        return false;
    }

    final boolean J(CoordinatorLayout coordinatorLayout, View view, int i, int i2, float f) {
        Runnable runnable = this.d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.d = null;
        }
        if (this.e == null) {
            this.e = new OverScroller(view.getContext());
        }
        this.e.fling(0, E(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.e.computeScrollOffset()) {
            N(coordinatorLayout, view);
            return false;
        }
        a aVar = new a(coordinatorLayout, view);
        this.d = aVar;
        AbstractC12990fW7.h0(view, aVar);
        return true;
    }

    int K(View view) {
        return -view.getHeight();
    }

    int L(View view) {
        return view.getHeight();
    }

    int M() {
        return E();
    }

    void N(CoordinatorLayout coordinatorLayout, View view) {
    }

    final int O(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return Q(coordinatorLayout, view, M() - i, i2, i3);
    }

    int P(CoordinatorLayout coordinatorLayout, View view, int i) {
        return Q(coordinatorLayout, view, i, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
    }

    int Q(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int iB;
        int iE = E();
        if (i2 == 0 || iE < i2 || iE > i3 || iE == (iB = AbstractC22000uV3.b(i, i2, i3))) {
            return 0;
        }
        G(iB);
        return iE - iB;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f) {
            int i = this.g;
            if (i == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.h) > this.i) {
                this.h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = H(view) && coordinatorLayout.F(view, x, y2);
            this.f = z;
            if (z) {
                this.h = y2;
                this.g = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.i = -1;
    }
}
