package ir.nasim;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: ir.nasim.Gi2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4734Gi2 extends GestureDetector.SimpleOnGestureListener {
    private SA2 a;
    private SA2 b;
    private SA2 c;
    private SA2 d;

    public final SA2 a() {
        return this.a;
    }

    public final SA2 b() {
        return this.d;
    }

    public final SA2 c() {
        return this.c;
    }

    public final void d(SA2 sa2) {
        this.a = sa2;
    }

    public final void e(SA2 sa2) {
        this.d = sa2;
    }

    public final void f(SA2 sa2) {
        this.c = sa2;
    }

    public final void g(SA2 sa2) {
        this.b = sa2;
    }

    public final void h() {
        this.a = null;
        this.b = null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        SA2 sa2 = this.a;
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

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        SA2 sa2 = this.b;
        if (sa2 != null) {
            return ((Boolean) sa2.invoke()).booleanValue();
        }
        return false;
    }
}
