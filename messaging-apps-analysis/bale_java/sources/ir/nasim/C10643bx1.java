package ir.nasim;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.bx1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C10643bx1 {
    private int a = -1;
    private int b = 0;
    private final ScaleGestureDetector c;
    private VelocityTracker d;
    private boolean e;
    private float f;
    private float g;
    private final float h;
    private final float i;
    private InterfaceC15870kJ4 j;

    C10643bx1(Context context, InterfaceC15870kJ4 interfaceC15870kJ4) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.h = viewConfiguration.getScaledTouchSlop();
        this.j = interfaceC15870kJ4;
        this.c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f = b(motionEvent);
            this.g = c(motionEvent);
            this.e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.e && this.d != null) {
                this.f = b(motionEvent);
                this.g = c(motionEvent);
                this.d.addMovement(motionEvent);
                this.d.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                float xVelocity = this.d.getXVelocity();
                float yVelocity = this.d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.i) {
                    this.j.c(this.f, this.g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f = fB - this.f;
            float f2 = fC - this.g;
            if (!this.e) {
                this.e = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.h);
            }
            if (this.e) {
                this.j.a(f, f2);
                this.f = fB;
                this.g = fC;
                VelocityTracker velocityTracker2 = this.d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker3 = this.d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.d = null;
            }
        } else if (action == 6) {
            int iB = C11657dN7.b(motionEvent.getAction());
            if (motionEvent.getPointerId(iB) == this.a) {
                int i = iB == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i);
                this.f = motionEvent.getX(i);
                this.g = motionEvent.getY(i);
            }
        }
        int i2 = this.a;
        this.b = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return true;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: ir.nasim.bx1$a */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            C10643bx1.this.j.d(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), false);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }
}
