package ir.nasim;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import ja.burhanrashid52.photoeditor.Vector2D;

/* renamed from: ir.nasim.mc6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17227mc6 {
    public static final a v = new a(null);
    private final b a;
    private boolean b;
    private MotionEvent c;
    private MotionEvent d;
    private final Vector2D e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private boolean r;
    private int s;
    private int t;
    private boolean u;

    /* renamed from: ir.nasim.mc6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.mc6$b */
    public interface b {
        boolean a(View view, C17227mc6 c17227mc6);

        void b(View view, C17227mc6 c17227mc6);

        boolean c(View view, C17227mc6 c17227mc6);
    }

    /* renamed from: ir.nasim.mc6$c */
    public static class c implements b {
        @Override // ir.nasim.C17227mc6.b
        public void b(View view, C17227mc6 c17227mc6) {
            AbstractC13042fc3.i(view, "view");
            AbstractC13042fc3.i(c17227mc6, "detector");
        }
    }

    public C17227mc6(b bVar) {
        AbstractC13042fc3.i(bVar, "mListener");
        this.a = bVar;
        this.e = new Vector2D();
    }

    private final int a(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        if (pointerCount <= 0) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 != i2 && i3 != iFindPointerIndex) {
                return i3;
            }
            if (i4 >= pointerCount) {
                return -1;
            }
            i3 = i4;
        }
    }

    private final float b() {
        if (this.l == -1.0f) {
            float f = this.j;
            float f2 = this.k;
            this.l = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.l;
    }

    private final float f() {
        if (this.m == -1.0f) {
            float f = this.h;
            float f2 = this.i;
            this.m = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.m;
    }

    private final void j() {
        MotionEvent motionEvent = this.c;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        this.c = null;
        MotionEvent motionEvent2 = this.d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.d = null;
        this.b = false;
        this.s = -1;
        this.t = -1;
        this.r = false;
    }

    private final void k(View view, MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.d = MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        this.e.set(0.0f, 0.0f);
        MotionEvent motionEvent3 = this.c;
        if (motionEvent3 == null) {
            return;
        }
        AbstractC13042fc3.f(motionEvent3);
        int iFindPointerIndex = motionEvent3.findPointerIndex(this.s);
        int iFindPointerIndex2 = motionEvent3.findPointerIndex(this.t);
        int iFindPointerIndex3 = motionEvent.findPointerIndex(this.s);
        int iFindPointerIndex4 = motionEvent.findPointerIndex(this.t);
        if (iFindPointerIndex < 0 || iFindPointerIndex2 < 0 || iFindPointerIndex3 < 0 || iFindPointerIndex4 < 0) {
            this.r = true;
            Log.e("ScaleGestureDetector", "Invalid MotionEvent stream detected.", new Throwable());
            if (this.b) {
                this.a.b(view, this);
                return;
            }
            return;
        }
        float x = motionEvent3.getX(iFindPointerIndex);
        float y = motionEvent3.getY(iFindPointerIndex);
        float x2 = motionEvent3.getX(iFindPointerIndex2);
        float y2 = motionEvent3.getY(iFindPointerIndex2);
        float x3 = motionEvent.getX(iFindPointerIndex3);
        float y3 = motionEvent.getY(iFindPointerIndex3);
        float x4 = motionEvent.getX(iFindPointerIndex4) - x3;
        float y4 = motionEvent.getY(iFindPointerIndex4) - y3;
        this.e.set(x4, y4);
        this.h = x2 - x;
        this.i = y2 - y;
        this.j = x4;
        this.k = y4;
        this.f = x3 + (x4 * 0.5f);
        this.g = y3 + (y4 * 0.5f);
        this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.o = motionEvent.getPressure(iFindPointerIndex3) + motionEvent.getPressure(iFindPointerIndex4);
        this.p = motionEvent3.getPressure(iFindPointerIndex) + motionEvent3.getPressure(iFindPointerIndex2);
    }

    public final Vector2D c() {
        return this.e;
    }

    public final float d() {
        return this.f;
    }

    public final float e() {
        return this.g;
    }

    public final float g() {
        if (this.n == -1.0f) {
            this.n = b() / f();
        }
        return this.n;
    }

    public final boolean h() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17227mc6.i(android.view.View, android.view.MotionEvent):boolean");
    }
}
