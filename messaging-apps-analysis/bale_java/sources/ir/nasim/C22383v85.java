package ir.nasim;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: ir.nasim.v85, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22383v85 extends GestureDetector.SimpleOnGestureListener {
    private final C24159y85 a;
    private final a b;

    /* renamed from: ir.nasim.v85$a */
    public interface a {
        void a();
    }

    public C22383v85(C24159y85 c24159y85, a aVar) {
        AbstractC13042fc3.i(c24159y85, "viewState");
        AbstractC13042fc3.i(aVar, "onSingleTapUpCallback");
        this.a = c24159y85;
        this.b = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "event");
        return this.a.h() != null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "event");
        return this.a.h() != null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        return this.a.h() != null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AbstractC13042fc3.i(motionEvent, "event1");
        AbstractC13042fc3.i(motionEvent2, "event2");
        return this.a.h() != null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AbstractC13042fc3.i(motionEvent, "event1");
        AbstractC13042fc3.i(motionEvent2, "event2");
        return this.a.h() != null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "event");
        return this.a.h() != null;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "e");
        this.b.a();
        return this.a.h() != null;
    }
}
