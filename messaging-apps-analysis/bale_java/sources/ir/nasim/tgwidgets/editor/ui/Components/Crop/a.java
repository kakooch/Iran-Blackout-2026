package ir.nasim.tgwidgets.editor.ui.Components.Crop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class a {
    private ScaleGestureDetector a;
    private b b;
    private float c;
    private float d;
    private final float f;
    private VelocityTracker g;
    private boolean h;
    private long k;
    private boolean l;
    private final float e = AbstractC21455b.F(1.0f);
    private int i = -1;
    private int j = 0;

    /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.Crop.a$a, reason: collision with other inner class name */
    class ScaleGestureDetectorOnScaleGestureListenerC1585a implements ScaleGestureDetector.OnScaleGestureListener {
        ScaleGestureDetectorOnScaleGestureListenerC1585a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            a.this.b.d(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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

    public interface b {
        void a(float f, float f2);

        void b();

        void c(float f, float f2, float f3, float f4);

        void d(float f, float f2, float f3);
    }

    public a(Context context) {
        this.f = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.a = new ScaleGestureDetector(context, new ScaleGestureDetectorOnScaleGestureListenerC1585a());
    }

    float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.j);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.j);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.a.isInProgress();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.Crop.a.f(android.view.MotionEvent):boolean");
    }

    public void g(b bVar) {
        this.b = bVar;
    }
}
