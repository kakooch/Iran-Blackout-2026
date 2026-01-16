package ir.nasim;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.gF2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13450gF2 {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final Handler f;
    private final c g;
    private b h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private MotionEvent p;
    private MotionEvent q;
    private MotionEvent r;
    private boolean s;
    private float t;
    private float u;
    private float v;
    private float w;
    private boolean x;
    private VelocityTracker y;
    private static final int z = ViewConfiguration.getLongPressTimeout();
    private static final int A = ViewConfiguration.getTapTimeout();
    public static final int B = ViewConfiguration.getDoubleTapTimeout();

    /* renamed from: ir.nasim.gF2$b */
    public interface b {
        boolean b(MotionEvent motionEvent);

        boolean onDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    /* renamed from: ir.nasim.gF2$c */
    public interface c {
        void a(MotionEvent motionEvent);

        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public C13450gF2(Context context, c cVar) {
        this(context, cVar, null);
    }

    private void g() {
        this.f.removeMessages(1);
        this.f.removeMessages(2);
        this.f.removeMessages(3);
        this.y.recycle();
        this.y = null;
        this.s = false;
        this.i = false;
        this.m = false;
        this.n = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.o = false;
    }

    private void h() {
        this.f.removeMessages(1);
        this.f.removeMessages(2);
        this.f.removeMessages(3);
        this.s = false;
        this.m = false;
        this.n = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.o = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.f.removeMessages(3);
        this.j = false;
        this.k = true;
        this.g.onLongPress(this.p);
    }

    private void j(Context context) {
        int scaledTouchSlop;
        int touchSlop;
        int i;
        if (this.g == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.x = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.d = ViewConfiguration.getMinimumFlingVelocity();
            this.e = ViewConfiguration.getMaximumFlingVelocity();
            i = 100;
            scaledTouchSlop = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop2 = viewConfiguration.getScaledTouchSlop();
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.d = viewConfiguration.getScaledMinimumFlingVelocity();
            this.e = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop2;
            i = scaledDoubleTapSlop;
        }
        this.a = touchSlop * touchSlop;
        this.b = scaledTouchSlop * scaledTouchSlop;
        this.c = i * i;
    }

    private boolean k(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.n) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime > B || eventTime < 40) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.c;
    }

    public boolean l(MotionEvent motionEvent) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent2;
        boolean zOnFling;
        b bVar;
        int i;
        boolean z2;
        boolean zOnScroll;
        int i2;
        int action = motionEvent.getAction();
        MotionEvent motionEvent3 = this.q;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
        }
        this.q = MotionEvent.obtain(motionEvent);
        if (this.y == null) {
            this.y = VelocityTracker.obtain();
        }
        this.y.addMovement(motionEvent);
        int i3 = action & 255;
        boolean z3 = i3 == 6;
        int actionIndex = z3 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (actionIndex != i4) {
                x += motionEvent.getX(i4);
                y += motionEvent.getY(i4);
            }
        }
        float f = z3 ? pointerCount - 1 : pointerCount;
        float f2 = x / f;
        float f3 = y / f;
        if (i3 == 0) {
            this.j = false;
            b bVar2 = this.h;
            if (bVar2 == null) {
                zOnDoubleTap = false;
            } else {
                if (bVar2.b(motionEvent)) {
                    boolean zHasMessages = this.f.hasMessages(3);
                    if (zHasMessages) {
                        this.f.removeMessages(3);
                    }
                    MotionEvent motionEvent4 = this.p;
                    if (motionEvent4 == null || (motionEvent2 = this.r) == null || !zHasMessages || !k(motionEvent4, motionEvent2, motionEvent)) {
                        this.f.sendEmptyMessageDelayed(3, B);
                    } else {
                        this.s = true;
                        zOnDoubleTap = this.h.onDoubleTap(this.p) | this.h.onDoubleTapEvent(motionEvent);
                    }
                } else {
                    this.j = true;
                }
                zOnDoubleTap = false;
            }
            this.t = f2;
            this.v = f2;
            this.u = f3;
            this.w = f3;
            MotionEvent motionEvent5 = this.p;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.p = MotionEvent.obtain(motionEvent);
            this.m = true;
            this.n = true;
            this.i = true;
            this.k = false;
            if (this.x) {
                this.f.removeMessages(2);
                Handler handler = this.f;
                handler.sendMessageDelayed(handler.obtainMessage(2, 0, 0), ViewConfiguration.getLongPressTimeout());
            }
            this.f.sendEmptyMessageAtTime(1, this.p.getDownTime() + A);
            return zOnDoubleTap | this.g.onDown(motionEvent);
        }
        if (i3 == 1) {
            this.i = false;
            this.g.a(motionEvent);
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.s) {
                b bVar3 = this.h;
                zOnFling = bVar3 != null && bVar3.onDoubleTapEvent(motionEvent);
            } else if (this.k) {
                this.f.removeMessages(3);
                this.k = false;
            } else if (this.m && !this.o) {
                boolean zOnSingleTapUp = this.g.onSingleTapUp(motionEvent);
                if (this.j && (bVar = this.h) != null) {
                    bVar.onSingleTapConfirmed(motionEvent);
                }
                zOnFling = zOnSingleTapUp;
            } else if (!this.o) {
                VelocityTracker velocityTracker = this.y;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.e);
                float yVelocity = velocityTracker.getYVelocity(pointerId);
                float xVelocity = velocityTracker.getXVelocity(pointerId);
                if (Math.abs(yVelocity) > this.d || Math.abs(xVelocity) > this.d) {
                    zOnFling = this.g.onFling(this.p, motionEvent, xVelocity, yVelocity);
                }
            }
            MotionEvent motionEvent6 = this.r;
            if (motionEvent6 != null) {
                motionEvent6.recycle();
            }
            this.r = motionEventObtain;
            VelocityTracker velocityTracker2 = this.y;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.y = null;
            }
            this.s = false;
            this.j = false;
            this.o = false;
            this.f.removeMessages(1);
            this.f.removeMessages(2);
            return zOnFling;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                g();
                return false;
            }
            if (i3 == 5) {
                this.t = f2;
                this.v = f2;
                this.u = f3;
                this.w = f3;
                h();
                return false;
            }
            if (i3 != 6) {
                return false;
            }
            this.t = f2;
            this.v = f2;
            this.u = f3;
            this.w = f3;
            this.y.computeCurrentVelocity(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, this.e);
            int actionIndex2 = motionEvent.getActionIndex();
            int pointerId2 = motionEvent.getPointerId(actionIndex2);
            float xVelocity2 = this.y.getXVelocity(pointerId2);
            float yVelocity2 = this.y.getYVelocity(pointerId2);
            for (int i5 = 0; i5 < pointerCount; i5++) {
                if (i5 != actionIndex2) {
                    int pointerId3 = motionEvent.getPointerId(i5);
                    if ((this.y.getXVelocity(pointerId3) * xVelocity2) + (this.y.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                        this.y.clear();
                        return false;
                    }
                }
            }
            return false;
        }
        if (this.k || this.l) {
            return false;
        }
        int i6 = Build.VERSION.SDK_INT;
        int classification = i6 >= 29 ? motionEvent.getClassification() : 0;
        boolean zHasMessages2 = this.f.hasMessages(2);
        float f4 = this.t - f2;
        float f5 = this.u - f3;
        if (this.s) {
            b bVar4 = this.h;
            zOnScroll = bVar4 != null && bVar4.onDoubleTapEvent(motionEvent);
            i2 = 29;
            i = classification;
            z2 = zHasMessages2;
        } else {
            if (this.m) {
                int i7 = (int) (f2 - this.v);
                int i8 = (int) (f3 - this.w);
                int i9 = (i7 * i7) + (i8 * i8);
                int i10 = this.a;
                boolean z4 = i6 >= 29 && classification == 1;
                if (zHasMessages2 && z4) {
                    if (i9 > i10) {
                        this.f.removeMessages(2);
                        i = classification;
                        z2 = zHasMessages2;
                        long longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        Handler handler2 = this.f;
                        handler2.sendMessageDelayed(handler2.obtainMessage(2, 0, 0), (long) (longPressTimeout * 2.0f));
                    } else {
                        i = classification;
                        z2 = zHasMessages2;
                    }
                    i10 = (int) (i10 * 4.0f);
                } else {
                    i = classification;
                    z2 = zHasMessages2;
                }
                if (i9 > i10) {
                    boolean zOnScroll2 = this.g.onScroll(this.p, motionEvent, f4, f5);
                    this.t = f2;
                    this.u = f3;
                    this.m = false;
                    this.f.removeMessages(3);
                    this.f.removeMessages(1);
                    this.f.removeMessages(2);
                    zOnScroll = zOnScroll2;
                } else {
                    zOnScroll = false;
                }
                if (i9 > this.b) {
                    this.n = false;
                }
            } else {
                i = classification;
                z2 = zHasMessages2;
                if (Math.abs(f4) >= 1.0f || Math.abs(f5) >= 1.0f) {
                    zOnScroll = this.g.onScroll(this.p, motionEvent, f4, f5);
                    this.t = f2;
                    this.u = f3;
                } else {
                    zOnScroll = false;
                }
            }
            i2 = 29;
        }
        if (i6 >= i2 && i == 2 && z2) {
            this.f.removeMessages(2);
            Handler handler3 = this.f;
            handler3.sendMessage(handler3.obtainMessage(2, 0, 0));
        }
        return zOnScroll;
    }

    public void m(boolean z2) {
        this.x = z2;
    }

    public void n(b bVar) {
        this.h = bVar;
    }

    /* renamed from: ir.nasim.gF2$a */
    private class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                C13450gF2.this.g.onShowPress(C13450gF2.this.p);
                return;
            }
            if (i == 2) {
                C13450gF2.this.i();
                return;
            }
            if (i != 3) {
                throw new RuntimeException("Unknown message " + message);
            }
            if (C13450gF2.this.h != null) {
                if (C13450gF2.this.i) {
                    C13450gF2.this.j = true;
                } else {
                    C13450gF2.this.h.onSingleTapConfirmed(C13450gF2.this.p);
                }
            }
        }

        a(Handler handler) {
            super(handler.getLooper());
        }
    }

    public C13450gF2(Context context, c cVar, Handler handler) {
        if (handler != null) {
            this.f = new a(handler);
        } else {
            this.f = new a();
        }
        this.g = cVar;
        if (cVar instanceof b) {
            n((b) cVar);
        }
        j(context);
    }
}
