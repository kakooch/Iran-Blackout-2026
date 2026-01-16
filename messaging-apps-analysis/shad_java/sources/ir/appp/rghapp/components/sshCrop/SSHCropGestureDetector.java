package ir.appp.rghapp.components.sshCrop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SSHCropGestureDetector {
    private final ScaleGestureDetector mDetector;
    private boolean mIsDragging;
    float mLastTouchX;
    float mLastTouchY;
    private SSHCropGestureListener mListener;
    final float mMinimumVelocity;
    private VelocityTracker mVelocityTracker;
    private boolean started;
    final float mTouchSlop = AndroidUtilities.dp(1.0f);
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;

    public interface SSHCropGestureListener {
        void onDrag(float f, float f2);

        void onFling(float f, float f2, float f3, float f4);

        void onScale(float f, float f2, float f3);
    }

    public SSHCropGestureDetector(Context context) {
        this.mMinimumVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.mDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: ir.appp.rghapp.components.sshCrop.SSHCropGestureDetector.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                SSHCropGestureDetector.this.mListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
        });
    }

    float getActiveX(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    float getActiveY(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public void setOnGestureListener(SSHCropGestureListener sSHCropGestureListener) {
        this.mListener = sSHCropGestureListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.components.sshCrop.SSHCropGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
