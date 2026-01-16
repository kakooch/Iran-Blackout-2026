package org.rbmain.ui.Components;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.stetho.websocket.CloseCodes;

/* loaded from: classes5.dex */
public class GestureDetector2 {
    public static final int DOUBLE_TAP_TIMEOUT;
    private static final int TAP_TIMEOUT;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private MotionEvent mCurrentDownEvent;
    private MotionEvent mCurrentMotionEvent;
    private boolean mDeferConfirmSingleTap;
    private OnDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private int mDoubleTapTouchSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mIgnoreNextUpEvent;
    private boolean mInContextClick;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    private final OnGestureListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;

    public interface OnDoubleTapListener {
        boolean canDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    public interface OnGestureListener {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);

        void onUp(MotionEvent motionEvent);
    }

    static {
        ViewConfiguration.getLongPressTimeout();
        TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    }

    private class GestureHandler extends Handler {
        GestureHandler() {
        }

        GestureHandler(Handler handler) {
            super(handler.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GestureDetector2.this.mListener.onShowPress(GestureDetector2.this.mCurrentDownEvent);
                return;
            }
            if (i == 2) {
                GestureDetector2.this.dispatchLongPress();
                return;
            }
            if (i == 3) {
                if (GestureDetector2.this.mDoubleTapListener != null) {
                    if (!GestureDetector2.this.mStillDown) {
                        GestureDetector2.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetector2.this.mCurrentDownEvent);
                        return;
                    } else {
                        GestureDetector2.this.mDeferConfirmSingleTap = true;
                        return;
                    }
                }
                return;
            }
            throw new RuntimeException("Unknown message " + message);
        }
    }

    @Deprecated
    public GestureDetector2(OnGestureListener onGestureListener) {
        this(null, onGestureListener, null);
    }

    public GestureDetector2(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetector2(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        } else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
        }
        init(context);
    }

    private void init(Context context) {
        int scaledTouchSlop;
        int touchSlop;
        int i;
        if (this.mListener == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.mIsLongpressEnabled = true;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            i = 100;
            this.mMinimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
            this.mMaximumFlingVelocity = ViewConfiguration.getMaximumFlingVelocity();
            scaledTouchSlop = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop2 = viewConfiguration.getScaledTouchSlop();
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop2;
            i = scaledDoubleTapSlop;
        }
        this.mTouchSlopSquare = touchSlop * touchSlop;
        this.mDoubleTapTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.mDoubleTapSlopSquare = i * i;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mDoubleTapListener = onDoubleTapListener;
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mIsLongpressEnabled = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent2;
        boolean zOnFling;
        OnDoubleTapListener onDoubleTapListener;
        int i;
        boolean z;
        int action = motionEvent.getAction();
        MotionEvent motionEvent3 = this.mCurrentMotionEvent;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
        }
        this.mCurrentMotionEvent = MotionEvent.obtain(motionEvent);
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i2 = action & 255;
        boolean z2 = i2 == 6;
        int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                x += motionEvent.getX(i3);
                y += motionEvent.getY(i3);
            }
        }
        float f = z2 ? pointerCount - 1 : pointerCount;
        float f2 = x / f;
        float f3 = y / f;
        if (i2 == 0) {
            this.mDeferConfirmSingleTap = false;
            OnDoubleTapListener onDoubleTapListener2 = this.mDoubleTapListener;
            if (onDoubleTapListener2 == null) {
                zOnDoubleTap = false;
            } else {
                if (onDoubleTapListener2.canDoubleTap(motionEvent)) {
                    boolean zHasMessages = this.mHandler.hasMessages(3);
                    if (zHasMessages) {
                        this.mHandler.removeMessages(3);
                    }
                    MotionEvent motionEvent4 = this.mCurrentDownEvent;
                    if (motionEvent4 != null && (motionEvent2 = this.mPreviousUpEvent) != null && zHasMessages && isConsideredDoubleTap(motionEvent4, motionEvent2, motionEvent)) {
                        this.mIsDoubleTapping = true;
                        zOnDoubleTap = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    } else {
                        this.mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
                    }
                } else {
                    this.mDeferConfirmSingleTap = true;
                }
                zOnDoubleTap = false;
            }
            this.mLastFocusX = f2;
            this.mDownFocusX = f2;
            this.mLastFocusY = f3;
            this.mDownFocusY = f3;
            MotionEvent motionEvent5 = this.mCurrentDownEvent;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            if (this.mIsLongpressEnabled) {
                this.mHandler.removeMessages(2);
                Handler handler = this.mHandler;
                handler.sendMessageAtTime(handler.obtainMessage(2, 0, 0), this.mCurrentDownEvent.getDownTime() + ViewConfiguration.getLongPressTimeout());
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
            return zOnDoubleTap | this.mListener.onDown(motionEvent);
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    cancel();
                    return false;
                }
                if (i2 == 5) {
                    this.mLastFocusX = f2;
                    this.mDownFocusX = f2;
                    this.mLastFocusY = f3;
                    this.mDownFocusY = f3;
                    cancelTaps();
                    return false;
                }
                if (i2 != 6) {
                    return false;
                }
                this.mLastFocusX = f2;
                this.mDownFocusX = f2;
                this.mLastFocusY = f3;
                this.mDownFocusY = f3;
                this.mVelocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE, this.mMaximumFlingVelocity);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex2);
                float xVelocity = this.mVelocityTracker.getXVelocity(pointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                for (int i4 = 0; i4 < pointerCount; i4++) {
                    if (i4 != actionIndex2) {
                        int pointerId2 = motionEvent.getPointerId(i4);
                        if ((this.mVelocityTracker.getXVelocity(pointerId2) * xVelocity) + (this.mVelocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                            this.mVelocityTracker.clear();
                            return false;
                        }
                    }
                }
                return false;
            }
            if (this.mInLongPress || this.mInContextClick) {
                return false;
            }
            int i5 = Build.VERSION.SDK_INT;
            int i6 = 29;
            int classification = i5 >= 29 ? motionEvent.getClassification() : 0;
            boolean zHasMessages2 = this.mHandler.hasMessages(2);
            float f4 = this.mLastFocusX - f2;
            float f5 = this.mLastFocusY - f3;
            if (this.mIsDoubleTapping) {
                OnDoubleTapListener onDoubleTapListener3 = this.mDoubleTapListener;
                zOnFling = (onDoubleTapListener3 != null && onDoubleTapListener3.onDoubleTapEvent(motionEvent)) | false;
                i = classification;
                z = zHasMessages2;
            } else {
                if (this.mAlwaysInTapRegion) {
                    int i7 = (int) (f2 - this.mDownFocusX);
                    int i8 = (int) (f3 - this.mDownFocusY);
                    int i9 = (i7 * i7) + (i8 * i8);
                    int i10 = this.mTouchSlopSquare;
                    if (zHasMessages2 && (i5 >= 29 && classification == 1)) {
                        if (i9 > i10) {
                            this.mHandler.removeMessages(2);
                            i = classification;
                            z = zHasMessages2;
                            long longPressTimeout = ViewConfiguration.getLongPressTimeout();
                            Handler handler2 = this.mHandler;
                            handler2.sendMessageAtTime(handler2.obtainMessage(2, 0, 0), motionEvent.getDownTime() + ((long) (longPressTimeout * 2.0f)));
                        } else {
                            i = classification;
                            z = zHasMessages2;
                        }
                        i10 = (int) (i10 * 4.0f);
                    } else {
                        i = classification;
                        z = zHasMessages2;
                    }
                    if (i9 > i10) {
                        zOnFling = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f4, f5);
                        this.mLastFocusX = f2;
                        this.mLastFocusY = f3;
                        this.mAlwaysInTapRegion = false;
                        this.mHandler.removeMessages(3);
                        this.mHandler.removeMessages(1);
                        this.mHandler.removeMessages(2);
                    } else {
                        zOnFling = false;
                    }
                    if (i9 > this.mDoubleTapTouchSlopSquare) {
                        this.mAlwaysInBiggerTapRegion = false;
                    }
                } else {
                    i = classification;
                    z = zHasMessages2;
                    if (Math.abs(f4) >= 1.0f || Math.abs(f5) >= 1.0f) {
                        zOnFling = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f4, f5);
                        this.mLastFocusX = f2;
                        this.mLastFocusY = f3;
                    } else {
                        zOnFling = false;
                    }
                }
                i6 = 29;
            }
            if (i5 >= i6) {
                if ((i == 2) && z) {
                    this.mHandler.removeMessages(2);
                    Handler handler3 = this.mHandler;
                    handler3.sendMessage(handler3.obtainMessage(2, 0, 0));
                }
            }
        } else {
            this.mStillDown = false;
            this.mListener.onUp(motionEvent);
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.mIsDoubleTapping) {
                OnDoubleTapListener onDoubleTapListener4 = this.mDoubleTapListener;
                zOnFling = (onDoubleTapListener4 != null && onDoubleTapListener4.onDoubleTapEvent(motionEvent)) | false;
            } else {
                if (this.mInLongPress) {
                    this.mHandler.removeMessages(3);
                    this.mInLongPress = false;
                } else if (this.mAlwaysInTapRegion && !this.mIgnoreNextUpEvent) {
                    boolean zOnSingleTapUp = this.mListener.onSingleTapUp(motionEvent);
                    if (this.mDeferConfirmSingleTap && (onDoubleTapListener = this.mDoubleTapListener) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                    }
                    zOnFling = zOnSingleTapUp;
                } else if (!this.mIgnoreNextUpEvent) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId3 = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(CloseCodes.NORMAL_CLOSURE, this.mMaximumFlingVelocity);
                    float yVelocity2 = velocityTracker.getYVelocity(pointerId3);
                    float xVelocity2 = velocityTracker.getXVelocity(pointerId3);
                    if (Math.abs(yVelocity2) > this.mMinimumFlingVelocity || Math.abs(xVelocity2) > this.mMinimumFlingVelocity) {
                        zOnFling = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity2, yVelocity2);
                    }
                }
                zOnFling = false;
            }
            MotionEvent motionEvent6 = this.mPreviousUpEvent;
            if (motionEvent6 != null) {
                motionEvent6.recycle();
            }
            this.mPreviousUpEvent = motionEventObtain;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            this.mIsDoubleTapping = false;
            this.mDeferConfirmSingleTap = false;
            this.mIgnoreNextUpEvent = false;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
        return zOnFling;
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.mIsDoubleTapping = false;
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = false;
        this.mInContextClick = false;
        this.mIgnoreNextUpEvent = false;
    }

    private void cancelTaps() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mIsDoubleTapping = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = false;
        this.mInContextClick = false;
        this.mIgnoreNextUpEvent = false;
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.mAlwaysInBiggerTapRegion) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime > DOUBLE_TAP_TIMEOUT || eventTime < 40) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.mDoubleTapSlopSquare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLongPress() {
        this.mHandler.removeMessages(3);
        this.mDeferConfirmSingleTap = false;
        this.mInLongPress = true;
        this.mListener.onLongPress(this.mCurrentDownEvent);
    }
}
