package ir.appp.rghapp.components;

import android.util.Log;
import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class SSHScaleGestureDetector {
    private boolean mActive0MostRecent;
    private int mActiveId0;
    private int mActiveId1;
    public MotionEvent mCurrEvent;
    private float mCurrFingerDiffX;
    private float mCurrFingerDiffY;
    private float mCurrLen;
    private float mCurrPressure;
    private SSHVector2D mCurrSpanVector = new SSHVector2D();
    private float mFocusX;
    private float mFocusY;
    private boolean mGestureInProgress;
    private boolean mInvalidGesture;
    private final OnScaleGestureListener mListener;
    private MotionEvent mPrevEvent;
    private float mPrevFingerDiffX;
    private float mPrevFingerDiffY;
    private float mPrevLen;
    private float mPrevPressure;
    private float mScaleFactor;

    public interface OnScaleGestureListener {
        boolean onScale(SSHScaleGestureDetector sSHScaleGestureDetector);

        boolean onScaleBegin(SSHScaleGestureDetector sSHScaleGestureDetector);

        void onScaleEnd(SSHScaleGestureDetector sSHScaleGestureDetector);
    }

    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
    }

    public SSHScaleGestureDetector(OnScaleGestureListener onScaleGestureListener) {
        this.mListener = onScaleGestureListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.components.SSHScaleGestureDetector.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private int findNewActiveIndex(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != i2 && i3 != iFindPointerIndex) {
                return i3;
            }
        }
        return -1;
    }

    private void setContext(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.mCurrEvent;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.mCurrEvent = MotionEvent.obtain(motionEvent);
        this.mCurrLen = -1.0f;
        this.mPrevLen = -1.0f;
        this.mScaleFactor = -1.0f;
        this.mCurrSpanVector.set(0.0f, 0.0f);
        MotionEvent motionEvent3 = this.mPrevEvent;
        int iFindPointerIndex = motionEvent3.findPointerIndex(this.mActiveId0);
        int iFindPointerIndex2 = motionEvent3.findPointerIndex(this.mActiveId1);
        int iFindPointerIndex3 = motionEvent.findPointerIndex(this.mActiveId0);
        int iFindPointerIndex4 = motionEvent.findPointerIndex(this.mActiveId1);
        if (iFindPointerIndex < 0 || iFindPointerIndex2 < 0 || iFindPointerIndex3 < 0 || iFindPointerIndex4 < 0) {
            this.mInvalidGesture = true;
            Log.e("ScaleGestureDetector", "Invalid MotionEvent stream detected.", new Throwable());
            if (this.mGestureInProgress) {
                this.mListener.onScaleEnd(this);
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
        this.mCurrSpanVector.set(x4, y4);
        this.mPrevFingerDiffX = x2 - x;
        this.mPrevFingerDiffY = y2 - y;
        this.mCurrFingerDiffX = x4;
        this.mCurrFingerDiffY = y4;
        this.mFocusX = x3 + (x4 * 0.5f);
        this.mFocusY = y3 + (y4 * 0.5f);
        motionEvent.getEventTime();
        motionEvent3.getEventTime();
        this.mCurrPressure = motionEvent.getPressure(iFindPointerIndex3) + motionEvent.getPressure(iFindPointerIndex4);
        this.mPrevPressure = motionEvent3.getPressure(iFindPointerIndex) + motionEvent3.getPressure(iFindPointerIndex2);
    }

    private void reset() {
        MotionEvent motionEvent = this.mPrevEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.mPrevEvent = null;
        }
        MotionEvent motionEvent2 = this.mCurrEvent;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.mCurrEvent = null;
        }
        this.mGestureInProgress = false;
        this.mActiveId0 = -1;
        this.mActiveId1 = -1;
        this.mInvalidGesture = false;
    }

    public boolean isInProgress() {
        return this.mGestureInProgress;
    }

    public float getFocusX() {
        return this.mFocusX;
    }

    public float getFocusY() {
        return this.mFocusY;
    }

    public float getCurrentSpan() {
        if (this.mCurrLen == -1.0f) {
            float f = this.mCurrFingerDiffX;
            float f2 = this.mCurrFingerDiffY;
            this.mCurrLen = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.mCurrLen;
    }

    public SSHVector2D getCurrentSpanVector() {
        return this.mCurrSpanVector;
    }

    public float getPreviousSpan() {
        if (this.mPrevLen == -1.0f) {
            float f = this.mPrevFingerDiffX;
            float f2 = this.mPrevFingerDiffY;
            this.mPrevLen = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.mPrevLen;
    }

    public float getScaleFactor() {
        if (this.mScaleFactor == -1.0f) {
            this.mScaleFactor = getCurrentSpan() / getPreviousSpan();
        }
        return this.mScaleFactor;
    }
}
