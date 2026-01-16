package ir.eitaa.ui.Components.Crop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class CropGestureDetector {
    private ScaleGestureDetector mDetector;
    private boolean mIsDragging;
    private float mLastTouchX;
    private float mLastTouchY;
    private CropGestureListener mListener;
    private final float mMinimumVelocity;
    private VelocityTracker mVelocityTracker;
    private boolean started;
    private long touchTime;
    private final float mTouchSlop = AndroidUtilities.dp(1.0f);
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;

    public interface CropGestureListener {
        void onDrag(float dx, float dy);

        void onFling(float startX, float startY, float velocityX, float velocityY);

        void onScale(float scaleFactor, float focusX, float focusY);

        void onTapUp();
    }

    public CropGestureDetector(Context context) {
        this.mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.mDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: ir.eitaa.ui.Components.Crop.CropGestureDetector.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector detector) {
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                float scaleFactor = detector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                CropGestureDetector.this.mListener.onScale(scaleFactor, detector.getFocusX(), detector.getFocusY());
                return true;
            }
        });
    }

    float getActiveX(MotionEvent ev) {
        try {
            return ev.getX(this.mActivePointerIndex);
        } catch (Exception unused) {
            return ev.getX();
        }
    }

    float getActiveY(MotionEvent ev) {
        try {
            return ev.getY(this.mActivePointerIndex);
        } catch (Exception unused) {
            return ev.getY();
        }
    }

    public void setOnGestureListener(CropGestureListener listener) {
        this.mListener = listener;
    }

    public boolean isScaling() {
        return this.mDetector.isInProgress();
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.Crop.CropGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
