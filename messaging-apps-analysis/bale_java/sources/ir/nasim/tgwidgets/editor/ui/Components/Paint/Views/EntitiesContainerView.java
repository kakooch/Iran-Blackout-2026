package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a;

/* loaded from: classes7.dex */
public class EntitiesContainerView extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener, a.InterfaceC1586a {
    private a a;
    private ScaleGestureDetector b;
    private ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a c;
    private float d;
    private float e;
    private boolean f;

    public interface a {
        void a();

        EntityView b();

        boolean c();
    }

    public EntitiesContainerView(Context context, a aVar) {
        super(context);
        this.d = 1.0f;
        this.b = new ScaleGestureDetector(context, this);
        this.c = new ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a(this);
        this.a = aVar;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a.InterfaceC1586a
    public void a(ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a aVar) {
        EntityView entityViewB = this.a.b();
        float fB = aVar.b();
        entityViewB.V(entityViewB.getRotation() + (this.e - fB));
        this.e = fB;
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a.InterfaceC1586a
    public void b(ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a aVar) {
    }

    @Override // ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a.InterfaceC1586a
    public void c(ir.nasim.tgwidgets.editor.ui.Components.Paint.Views.a aVar) {
        this.e = aVar.c();
        this.f = true;
    }

    public int d() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof EntityView) {
                i++;
            }
        }
        return i;
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (!(view instanceof TextPaintView)) {
            super.measureChildWithMargins(view, i, i2, i3, i4);
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return motionEvent.getPointerCount() == 2 && this.a.c();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        this.a.b().Z(scaleFactor / this.d);
        this.d = scaleFactor;
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.d = 1.0f;
        this.f = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.a.b() == null) {
            return false;
        }
        if (motionEvent.getPointerCount() == 1) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f = false;
            } else if (actionMasked == 1 || actionMasked == 2) {
                if (!this.f && (aVar = this.a) != null) {
                    aVar.a();
                }
                return false;
            }
        }
        this.b.onTouchEvent(motionEvent);
        this.c.d(motionEvent);
        return true;
    }
}
