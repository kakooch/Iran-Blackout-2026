package ir.eitaa.ui.Components.Paint.Views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector;

/* loaded from: classes3.dex */
public class EntitiesContainerView extends FrameLayout implements ScaleGestureDetector.OnScaleGestureListener, RotationGestureDetector.OnRotationGestureListener {
    private EntitiesContainerViewDelegate delegate;
    private ScaleGestureDetector gestureDetector;
    private boolean hasTransformed;
    private float previousAngle;
    private float previousScale;
    private RotationGestureDetector rotationGestureDetector;

    public interface EntitiesContainerViewDelegate {
        void onEntityDeselect();

        EntityView onSelectedEntityRequest();

        boolean shouldReceiveTouches();
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector.OnRotationGestureListener
    public void onRotationEnd(RotationGestureDetector rotationDetector) {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
    }

    public EntitiesContainerView(Context context, EntitiesContainerViewDelegate entitiesContainerViewDelegate) {
        super(context);
        this.previousScale = 1.0f;
        this.gestureDetector = new ScaleGestureDetector(context, this);
        this.rotationGestureDetector = new RotationGestureDetector(this);
        this.delegate = entitiesContainerViewDelegate;
    }

    public int entitiesCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof EntityView) {
                i++;
            }
        }
        return i;
    }

    public void bringViewToFront(EntityView view) {
        if (indexOfChild(view) != getChildCount() - 1) {
            removeView(view);
            addView(view, getChildCount());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return ev.getPointerCount() == 2 && this.delegate.shouldReceiveTouches();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        EntitiesContainerViewDelegate entitiesContainerViewDelegate;
        if (this.delegate.onSelectedEntityRequest() == null) {
            return false;
        }
        if (event.getPointerCount() == 1) {
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                this.hasTransformed = false;
            } else if (actionMasked == 1 || actionMasked == 2) {
                if (!this.hasTransformed && (entitiesContainerViewDelegate = this.delegate) != null) {
                    entitiesContainerViewDelegate.onEntityDeselect();
                }
                return false;
            }
        }
        this.gestureDetector.onTouchEvent(event);
        this.rotationGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        float scaleFactor = detector.getScaleFactor();
        this.delegate.onSelectedEntityRequest().scale(scaleFactor / this.previousScale);
        this.previousScale = scaleFactor;
        return false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        this.previousScale = 1.0f;
        this.hasTransformed = true;
        return true;
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector.OnRotationGestureListener
    public void onRotationBegin(RotationGestureDetector rotationDetector) {
        this.previousAngle = rotationDetector.getStartAngle();
        this.hasTransformed = true;
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.RotationGestureDetector.OnRotationGestureListener
    public void onRotation(RotationGestureDetector rotationDetector) {
        EntityView entityViewOnSelectedEntityRequest = this.delegate.onSelectedEntityRequest();
        float angle = rotationDetector.getAngle();
        entityViewOnSelectedEntityRequest.rotate(entityViewOnSelectedEntityRequest.getRotation() + (this.previousAngle - angle));
        this.previousAngle = angle;
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        if (child instanceof TextPaintView) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
            child.measure(FrameLayout.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + widthUsed, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            super.measureChildWithMargins(child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
        }
    }
}
