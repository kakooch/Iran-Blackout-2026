package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* loaded from: classes5.dex */
public class J37 implements View.OnTouchListener {
    private int a;
    private int b;
    private int c;
    private long d;
    private View e;
    private d f;
    private int g = 1;
    private float h;
    private float i;
    private boolean j;
    private int k;
    private Object l;
    private VelocityTracker m;
    private float n;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            J37.this.e();
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup.LayoutParams a;
        final /* synthetic */ int b;

        b(ViewGroup.LayoutParams layoutParams, int i) {
            this.a = layoutParams;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            J37.this.f.b(J37.this.e, J37.this.l);
            J37.this.e.setAlpha(1.0f);
            J37.this.e.setTranslationX(0.0f);
            this.a.height = this.b;
            J37.this.e.setLayoutParams(this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ViewGroup.LayoutParams a;

        c(ViewGroup.LayoutParams layoutParams) {
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            J37.this.e.setLayoutParams(this.a);
        }
    }

    public interface d {
        boolean a(Object obj);

        void b(View view, Object obj);
    }

    public J37(View view, Object obj, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = view.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime);
        this.e = view;
        this.l = obj;
        this.f = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        int height = this.e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.d);
        duration.addListener(new b(layoutParams, height));
        duration.addUpdateListener(new c(layoutParams));
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        motionEvent.offsetLocation(this.n, 0.0f);
        if (this.g < 2) {
            this.g = this.e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = motionEvent.getRawX();
            this.i = motionEvent.getRawY();
            if (this.f.a(this.l)) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.m = velocityTrackerObtain;
                velocityTrackerObtain.addMovement(motionEvent);
            }
            return false;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.h;
                    float rawY = motionEvent.getRawY() - this.i;
                    if (Math.abs(rawX) > this.a && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                        this.j = true;
                        this.k = rawX > 0.0f ? this.a : -this.a;
                        this.e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.e.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (this.j) {
                        this.n = rawX;
                        this.e.setTranslationX(rawX - this.k);
                        this.e.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX) * 2.0f) / this.g))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && this.m != null) {
                this.e.animate().translationX(0.0f).alpha(1.0f).setDuration(this.d).setListener(null);
                this.m.recycle();
                this.m = null;
                this.n = 0.0f;
                this.h = 0.0f;
                this.i = 0.0f;
                this.j = false;
            }
        } else if (this.m != null) {
            float rawX2 = motionEvent.getRawX() - this.h;
            this.m.addMovement(motionEvent);
            this.m.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            float xVelocity = this.m.getXVelocity();
            float fAbs = Math.abs(xVelocity);
            float fAbs2 = Math.abs(this.m.getYVelocity());
            if (Math.abs(rawX2) > this.g / 2 && this.j) {
                z = rawX2 > 0.0f;
            } else if (this.b > fAbs || fAbs > this.c || fAbs2 >= fAbs || fAbs2 >= fAbs || !this.j) {
                z = false;
                z = false;
            } else {
                z = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX2 > 0.0f ? 1 : (rawX2 == 0.0f ? 0 : -1)) < 0);
                z = this.m.getXVelocity() > 0.0f;
            }
            if (z) {
                this.e.animate().translationX(z ? this.g : -this.g).alpha(0.0f).setDuration(this.d).setListener(new a());
            } else if (this.j) {
                this.e.animate().translationX(0.0f).alpha(1.0f).setDuration(this.d).setListener(null);
            }
            this.m.recycle();
            this.m = null;
            this.n = 0.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = false;
        }
        return false;
    }
}
