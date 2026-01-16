package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;

/* loaded from: classes2.dex */
class j extends RecyclerView.o implements RecyclerView.s {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.t C;
    private final int a;
    private final int b;
    final StateListDrawable c;
    final Drawable d;
    private final int e;
    private final int f;
    private final StateListDrawable g;
    private final Drawable h;
    private final int i;
    private final int j;
    int k;
    int l;
    float m;
    int n;
    int o;
    float p;
    private RecyclerView s;
    final ValueAnimator z;
    private int q = 0;
    private int r = 0;
    private boolean t = false;
    private boolean u = false;
    private int v = 0;
    private int w = 0;
    private final int[] x = new int[2];
    private final int[] y = new int[2];

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.s(SIPTransactionStack.BASE_TIMER_INTERVAL);
        }
    }

    class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            j.this.D(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    private class c extends AnimatorListenerAdapter {
        private boolean a = false;

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                this.a = false;
                return;
            }
            if (((Float) j.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                j jVar = j.this;
                jVar.A = 0;
                jVar.A(0);
            } else {
                j jVar2 = j.this;
                jVar2.A = 2;
                jVar2.x();
            }
        }
    }

    private class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            j.this.c.setAlpha(iFloatValue);
            j.this.d.setAlpha(iFloatValue);
            j.this.x();
        }
    }

    j(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        this.A = 0;
        this.B = new a();
        this.C = new b();
        this.c = stateListDrawable;
        this.d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i, drawable.getIntrinsicWidth());
        this.i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i, drawable2.getIntrinsicWidth());
        this.a = i2;
        this.b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new c());
        valueAnimatorOfFloat.addUpdateListener(new d());
        l(recyclerView);
    }

    private void B() {
        this.s.addItemDecoration(this);
        this.s.addOnItemTouchListener(this);
        this.s.addOnScrollListener(this.C);
    }

    private void E(float f) {
        int[] iArrR = r();
        float fMax = Math.max(iArrR[0], Math.min(iArrR[1], f));
        if (Math.abs(this.l - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.m, fMax, iArrR, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
        if (iZ != 0) {
            this.s.scrollBy(0, iZ);
        }
        this.m = fMax;
    }

    private void m() {
        this.s.removeCallbacks(this.B);
    }

    private void n() {
        this.s.removeItemDecoration(this);
        this.s.removeOnItemTouchListener(this);
        this.s.removeOnScrollListener(this.C);
        m();
    }

    private void o(Canvas canvas) {
        int i = this.r;
        int i2 = this.i;
        int i3 = this.o;
        int i4 = this.n;
        this.g.setBounds(0, 0, i4, i2);
        this.h.setBounds(0, 0, this.q, this.j);
        canvas.translate(0.0f, i - i2);
        this.h.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void p(Canvas canvas) {
        int i = this.q;
        int i2 = this.e;
        int i3 = i - i2;
        int i4 = this.l;
        int i5 = this.k;
        int i6 = i4 - (i5 / 2);
        this.c.setBounds(0, 0, i2, i5);
        this.d.setBounds(0, 0, this.f, this.r);
        if (!u()) {
            canvas.translate(i3, 0.0f);
            this.d.draw(canvas);
            canvas.translate(0.0f, i6);
            this.c.draw(canvas);
            canvas.translate(-i3, -i6);
            return;
        }
        this.d.draw(canvas);
        canvas.translate(this.e, i6);
        canvas.scale(-1.0f, 1.0f);
        this.c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.e, -i6);
    }

    private int[] q() {
        int[] iArr = this.y;
        int i = this.b;
        iArr[0] = i;
        iArr[1] = this.q - i;
        return iArr;
    }

    private int[] r() {
        int[] iArr = this.x;
        int i = this.b;
        iArr[0] = i;
        iArr[1] = this.r - i;
        return iArr;
    }

    private void t(float f) {
        int[] iArrQ = q();
        float fMax = Math.max(iArrQ[0], Math.min(iArrQ[1], f));
        if (Math.abs(this.o - fMax) < 2.0f) {
            return;
        }
        int iZ = z(this.p, fMax, iArrQ, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
        if (iZ != 0) {
            this.s.scrollBy(iZ, 0);
        }
        this.p = fMax;
    }

    private boolean u() {
        return AbstractC12990fW7.A(this.s) == 1;
    }

    private void y(int i) {
        m();
        this.s.postDelayed(this.B, i);
    }

    private int z(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    void A(int i) {
        if (i == 2 && this.v != 2) {
            this.c.setState(D);
            m();
        }
        if (i == 0) {
            x();
        } else {
            C();
        }
        if (this.v == 2 && i != 2) {
            this.c.setState(E);
            y(1200);
        } else if (i == 1) {
            y(1500);
        }
        this.v = i;
    }

    public void C() {
        int i = this.A;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0L);
        this.z.start();
    }

    void D(int i, int i2) {
        int iComputeVerticalScrollRange = this.s.computeVerticalScrollRange();
        int i3 = this.r;
        this.t = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.a;
        int iComputeHorizontalScrollRange = this.s.computeHorizontalScrollRange();
        int i4 = this.q;
        boolean z = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.a;
        this.u = z;
        boolean z2 = this.t;
        if (!z2 && !z) {
            if (this.v != 0) {
                A(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i3;
            this.l = (int) ((f * (i2 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.k = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.u) {
            float f2 = i4;
            this.o = (int) ((f2 * (i + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.n = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.v;
        if (i5 == 0 || i5 == 1) {
            A(1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (zW || zV) {
                if (zV) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zW) {
                    this.w = 2;
                    this.m = (int) motionEvent.getY();
                }
                A(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.m = 0.0f;
            this.p = 0.0f;
            A(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            C();
            if (this.w == 1) {
                t(motionEvent.getX());
            }
            if (this.w == 2) {
                E(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.v;
        if (i == 1) {
            boolean zW = w(motionEvent.getX(), motionEvent.getY());
            boolean zV = v(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zW && !zV) {
                return false;
            }
            if (zV) {
                this.w = 1;
                this.p = (int) motionEvent.getX();
            } else if (zW) {
                this.w = 2;
                this.m = (int) motionEvent.getY();
            }
            A(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void e(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            A(0);
        } else if (this.A != 0) {
            if (this.t) {
                p(canvas);
            }
            if (this.u) {
                o(canvas);
            }
        }
    }

    public void l(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            n();
        }
        this.s = recyclerView;
        if (recyclerView != null) {
            B();
        }
    }

    void s(int i) {
        int i2 = this.A;
        if (i2 == 1) {
            this.z.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.z.setDuration(i);
        this.z.start();
    }

    boolean v(float f, float f2) {
        if (f2 >= this.r - this.i) {
            int i = this.o;
            int i2 = this.n;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean w(float f, float f2) {
        if (!u() ? f >= this.q - this.e : f <= this.e) {
            int i = this.l;
            int i2 = this.k;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    void x() {
        this.s.invalidate();
    }
}
