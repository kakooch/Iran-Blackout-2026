package ir.eitaa.ui.Components;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes3.dex */
public class GestureDetector2 {
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
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    public static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();

    public interface OnDoubleTapListener {
        boolean canDoubleTap(MotionEvent e);

        boolean onDoubleTap(MotionEvent e);

        boolean onDoubleTapEvent(MotionEvent e);

        boolean onSingleTapConfirmed(MotionEvent e);
    }

    public interface OnGestureListener {
        boolean onDown(MotionEvent e);

        boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);

        void onLongPress(MotionEvent e);

        boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

        void onShowPress(MotionEvent e);

        boolean onSingleTapUp(MotionEvent e);

        void onUp(MotionEvent e);
    }

    private class GestureHandler extends Handler {
        GestureHandler() {
        }

        GestureHandler(Handler handler) {
            super(handler.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int i = msg.what;
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
            throw new RuntimeException("Unknown message " + msg);
        }
    }

    public GestureDetector2(Context context, OnGestureListener listener) {
        this(context, listener, null);
    }

    public GestureDetector2(Context context, OnGestureListener listener, Handler handler) {
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        } else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = listener;
        if (listener instanceof OnDoubleTapListener) {
            setOnDoubleTapListener((OnDoubleTapListener) listener);
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

    public void setIsLongpressEnabled(boolean isLongpressEnabled) {
        this.mIsLongpressEnabled = isLongpressEnabled;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent;
        boolean zOnFling;
        OnDoubleTapListener onDoubleTapListener;
        int i;
        boolean z;
        int action = ev.getAction();
        MotionEvent motionEvent2 = this.mCurrentMotionEvent;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.mCurrentMotionEvent = MotionEvent.obtain(ev);
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        int i2 = action & 255;
        boolean z2 = i2 == 6;
        int actionIndex = z2 ? ev.getActionIndex() : -1;
        int pointerCount = ev.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                x += ev.getX(i3);
                y += ev.getY(i3);
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
                if (onDoubleTapListener2.canDoubleTap(ev)) {
                    boolean zHasMessages = this.mHandler.hasMessages(3);
                    if (zHasMessages) {
                        this.mHandler.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.mCurrentDownEvent;
                    if (motionEvent3 != null && (motionEvent = this.mPreviousUpEvent) != null && zHasMessages && isConsideredDoubleTap(motionEvent3, motionEvent, ev)) {
                        this.mIsDoubleTapping = true;
                        zOnDoubleTap = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | false | this.mDoubleTapListener.onDoubleTapEvent(ev);
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
            MotionEvent motionEvent4 = this.mCurrentDownEvent;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.mCurrentDownEvent = MotionEvent.obtain(ev);
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
            return zOnDoubleTap | this.mListener.onDown(ev);
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
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                int actionIndex2 = ev.getActionIndex();
                int pointerId = ev.getPointerId(actionIndex2);
                float xVelocity = this.mVelocityTracker.getXVelocity(pointerId);
                float yVelocity = this.mVelocityTracker.getYVelocity(pointerId);
                for (int i4 = 0; i4 < pointerCount; i4++) {
                    if (i4 != actionIndex2) {
                        int pointerId2 = ev.getPointerId(i4);
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
            int classification = i5 >= 29 ? ev.getClassification() : 0;
            boolean zHasMessages2 = this.mHandler.hasMessages(2);
            float f4 = this.mLastFocusX - f2;
            float f5 = this.mLastFocusY - f3;
            if (this.mIsDoubleTapping) {
                OnDoubleTapListener onDoubleTapListener3 = this.mDoubleTapListener;
                zOnFling = (onDoubleTapListener3 != null && onDoubleTapListener3.onDoubleTapEvent(ev)) | false;
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
                            handler2.sendMessageAtTime(handler2.obtainMessage(2, 0, 0), ev.getDownTime() + ((long) (longPressTimeout * 2.0f)));
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
                        zOnFling = this.mListener.onScroll(this.mCurrentDownEvent, ev, f4, f5);
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
                        zOnFling = this.mListener.onScroll(this.mCurrentDownEvent, ev, f4, f5);
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
            this.mListener.onUp(ev);
            MotionEvent motionEventObtain = MotionEvent.obtain(ev);
            if (this.mIsDoubleTapping) {
                OnDoubleTapListener onDoubleTapListener4 = this.mDoubleTapListener;
                zOnFling = (onDoubleTapListener4 != null && onDoubleTapListener4.onDoubleTapEvent(ev)) | false;
            } else {
                if (this.mInLongPress) {
                    this.mHandler.removeMessages(3);
                    this.mInLongPress = false;
                } else if (this.mAlwaysInTapRegion && !this.mIgnoreNextUpEvent) {
                    boolean zOnSingleTapUp = this.mListener.onSingleTapUp(ev);
                    if (this.mDeferConfirmSingleTap && (onDoubleTapListener = this.mDoubleTapListener) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(ev);
                    }
                    zOnFling = zOnSingleTapUp;
                } else if (!this.mIgnoreNextUpEvent) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId3 = ev.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
                    float yVelocity2 = velocityTracker.getYVelocity(pointerId3);
                    float xVelocity2 = velocityTracker.getXVelocity(pointerId3);
                    if (Math.abs(yVelocity2) > this.mMinimumFlingVelocity || Math.abs(xVelocity2) > this.mMinimumFlingVelocity) {
                        zOnFling = this.mListener.onFling(this.mCurrentDownEvent, ev, xVelocity2, yVelocity2);
                    }
                }
                zOnFling = false;
            }
            MotionEvent motionEvent5 = this.mPreviousUpEvent;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
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

    private boolean isConsideredDoubleTap(MotionEvent firstDown, MotionEvent firstUp, MotionEvent secondDown) {
        if (!this.mAlwaysInBiggerTapRegion) {
            return false;
        }
        long eventTime = secondDown.getEventTime() - firstUp.getEventTime();
        if (eventTime > DOUBLE_TAP_TIMEOUT || eventTime < 40) {
            return false;
        }
        int x = ((int) firstDown.getX()) - ((int) secondDown.getX());
        int y = ((int) firstDown.getY()) - ((int) secondDown.getY());
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
