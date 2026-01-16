package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* loaded from: classes7.dex */
public class m {
    private final a a;

    interface a {
        boolean a(MotionEvent motionEvent);

        void b(boolean z);

        void c(long j);
    }

    static class b implements a {
        private static final int w = ViewConfiguration.getTapTimeout();
        private int a;
        private int b;
        private int c;
        private int d;
        private final Handler e;
        final c f;
        GestureDetector.OnDoubleTapListener g;
        boolean h;
        boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        MotionEvent m;
        private MotionEvent n;
        private boolean o;
        private float p;
        private float q;
        private float r;
        private float s;
        private boolean t;
        private long u = ViewConfiguration.getLongPressTimeout();
        private VelocityTracker v;

        b(Context context, c cVar, Handler handler) {
            if (handler != null) {
                this.e = new a(handler);
            } else {
                this.e = new a();
            }
            this.f = cVar;
            if (cVar instanceof GestureDetector.OnDoubleTapListener) {
                i(cVar);
            }
            g(context);
        }

        private void d() {
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.e.removeMessages(3);
            this.v.recycle();
            this.v = null;
            this.o = false;
            this.h = false;
            this.k = false;
            this.l = false;
            this.i = false;
            if (this.j) {
                this.j = false;
            }
        }

        private void e() {
            this.e.removeMessages(1);
            this.e.removeMessages(2);
            this.e.removeMessages(3);
            this.o = false;
            this.k = false;
            this.l = false;
            this.i = false;
            if (this.j) {
                this.j = false;
            }
        }

        private void g(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.t = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.a = scaledTouchSlop * scaledTouchSlop;
            this.b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean h(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > 220) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.b;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.m.a
        public boolean a(MotionEvent motionEvent) {
            boolean zOnDoubleTap;
            MotionEvent motionEvent2;
            boolean zOnFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.v == null) {
                this.v = VelocityTracker.obtain();
            }
            this.v.addMovement(motionEvent);
            int i = action & 255;
            boolean z = i == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float x = 0.0f;
            float y = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    x += motionEvent.getX(i2);
                    y += motionEvent.getY(i2);
                }
            }
            float f = z ? pointerCount - 1 : pointerCount;
            float f2 = x / f;
            float f3 = y / f;
            if (i == 0) {
                if (this.g == null || !this.f.a(motionEvent)) {
                    zOnDoubleTap = false;
                } else {
                    boolean zHasMessages = this.e.hasMessages(3);
                    if (zHasMessages) {
                        this.e.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.m;
                    if (motionEvent3 == null || (motionEvent2 = this.n) == null || !zHasMessages || !h(motionEvent3, motionEvent2, motionEvent)) {
                        this.e.sendEmptyMessageDelayed(3, 220L);
                        zOnDoubleTap = false;
                    } else {
                        this.o = true;
                        zOnDoubleTap = this.g.onDoubleTap(this.m) | this.g.onDoubleTapEvent(motionEvent);
                    }
                }
                this.p = f2;
                this.r = f2;
                this.q = f3;
                this.s = f3;
                MotionEvent motionEvent4 = this.m;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.m = MotionEvent.obtain(motionEvent);
                this.k = true;
                this.l = true;
                this.h = true;
                this.j = false;
                this.i = false;
                if (this.t) {
                    this.e.removeMessages(2);
                    this.e.sendEmptyMessageAtTime(2, this.m.getDownTime() + w + this.u);
                }
                this.e.sendEmptyMessageAtTime(1, this.m.getDownTime() + w);
                return zOnDoubleTap | this.f.onDown(motionEvent);
            }
            if (i == 1) {
                this.h = false;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                if (this.o) {
                    zOnFling = this.g.onDoubleTapEvent(motionEvent);
                } else {
                    if (this.j) {
                        this.e.removeMessages(3);
                        this.j = false;
                    } else if (this.k) {
                        boolean zOnSingleTapUp = this.f.onSingleTapUp(motionEvent);
                        if (this.i && (onDoubleTapListener = this.g) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        zOnFling = zOnSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.v;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.d);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.c || Math.abs(xVelocity) > this.c) {
                            zOnFling = this.f.onFling(this.m, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    zOnFling = false;
                }
                MotionEvent motionEvent5 = this.n;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.n = motionEventObtain;
                VelocityTracker velocityTracker2 = this.v;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.v = null;
                }
                this.o = false;
                this.i = false;
                this.e.removeMessages(1);
                this.e.removeMessages(2);
            } else {
                if (i != 2) {
                    if (i == 3) {
                        d();
                        return false;
                    }
                    if (i == 5) {
                        this.p = f2;
                        this.r = f2;
                        this.q = f3;
                        this.s = f3;
                        e();
                        return false;
                    }
                    if (i != 6) {
                        return false;
                    }
                    this.p = f2;
                    this.r = f2;
                    this.q = f3;
                    this.s = f3;
                    this.v.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.d);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.v.getXVelocity(pointerId2);
                    float yVelocity2 = this.v.getYVelocity(pointerId2);
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        if (i3 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i3);
                            if ((this.v.getXVelocity(pointerId3) * xVelocity2) + (this.v.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.v.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
                if (this.j) {
                    return false;
                }
                float f4 = this.p - f2;
                float f5 = this.q - f3;
                if (this.o) {
                    return this.g.onDoubleTapEvent(motionEvent);
                }
                if (!this.k) {
                    if (Math.abs(f4) < 1.0f && Math.abs(f5) < 1.0f) {
                        return false;
                    }
                    boolean zOnScroll = this.f.onScroll(this.m, motionEvent, f4, f5);
                    this.p = f2;
                    this.q = f3;
                    return zOnScroll;
                }
                int i4 = (int) (f2 - this.r);
                int i5 = (int) (f3 - this.s);
                int i6 = (i4 * i4) + (i5 * i5);
                if (i6 > this.a) {
                    zOnFling = this.f.onScroll(this.m, motionEvent, f4, f5);
                    this.p = f2;
                    this.q = f3;
                    this.k = false;
                    this.e.removeMessages(3);
                    this.e.removeMessages(1);
                    this.e.removeMessages(2);
                } else {
                    zOnFling = false;
                }
                if (i6 > this.a) {
                    this.l = false;
                }
            }
            return zOnFling;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.m.a
        public void b(boolean z) {
            this.t = z;
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.m.a
        public void c(long j) {
            this.u = j;
        }

        void f() {
            this.e.removeMessages(3);
            this.i = false;
            this.j = true;
            this.f.onLongPress(this.m);
        }

        public void i(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.g = onDoubleTapListener;
        }

        private class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    b bVar = b.this;
                    bVar.f.onShowPress(bVar.m);
                    return;
                }
                if (i == 2) {
                    b.this.f();
                    return;
                }
                if (i != 3) {
                    throw new RuntimeException("Unknown message " + message);
                }
                b bVar2 = b.this;
                GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.g;
                if (onDoubleTapListener != null) {
                    if (bVar2.h) {
                        bVar2.i = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.m);
                    }
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    public static class c extends GestureDetector.SimpleOnGestureListener {
        public abstract boolean a(MotionEvent motionEvent);
    }

    public m(Context context, c cVar) {
        this(context, cVar, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    public void b(boolean z) {
        this.a.b(z);
    }

    public void c(long j) {
        this.a.c(j);
    }

    public m(Context context, c cVar, Handler handler) {
        this.a = new b(context, cVar, handler);
    }
}
