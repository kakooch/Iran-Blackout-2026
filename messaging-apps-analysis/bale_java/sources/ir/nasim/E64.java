package ir.nasim;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes5.dex */
public final class E64 extends GestureDetector.SimpleOnGestureListener {
    private SA2 a;
    private SA2 b;
    private SA2 c;

    public final SA2 a() {
        return this.a;
    }

    public final SA2 b() {
        return this.b;
    }

    public final void c(SA2 sa2) {
        this.a = sa2;
    }

    public final void d(SA2 sa2) {
        this.c = sa2;
    }

    public final void e(SA2 sa2) {
        this.b = sa2;
    }

    public final void f() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        SA2 sa2 = this.c;
        if (sa2 != null) {
            return ((Boolean) sa2.invoke()).booleanValue();
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        SA2 sa2 = this.b;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        SA2 sa2 = this.a;
        if (sa2 != null) {
            return ((Boolean) sa2.invoke()).booleanValue();
        }
        return false;
    }
}
