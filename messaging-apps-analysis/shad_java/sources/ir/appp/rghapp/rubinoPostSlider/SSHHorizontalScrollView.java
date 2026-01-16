package ir.appp.rghapp.rubinoPostSlider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SSHHorizontalScrollView extends HorizontalScrollView implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private int activeItem;
    private ObjectAnimator anim;
    private float currentScrollX;
    private OnScrollListener delegate;
    private GestureDetector gestureDetector;
    private int itemWidth;
    private int maxItem;
    private int padding;
    private float prevScrollX;
    private int scrollTo;
    private boolean start;

    public interface OnScrollListener {
        void onIdleScrolling(int i);

        void onStartScrolling();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public SSHHorizontalScrollView(Context context) {
        super(context);
        this.scrollTo = 0;
        this.maxItem = 0;
        this.activeItem = 0;
        this.prevScrollX = 0.0f;
        this.start = true;
        this.itemWidth = 0;
        this.padding = 0;
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public SSHHorizontalScrollView(Context context, int i, int i2, int i3) {
        this(context);
        this.maxItem = i;
        this.itemWidth = i2;
        this.padding = i3;
        this.gestureDetector = new GestureDetector(this);
        setOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (this.gestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        Boolean boolValueOf = Boolean.valueOf(this.gestureDetector.onTouchEvent(motionEvent));
        int rawX = (int) motionEvent.getRawX();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && this.start) {
                this.prevScrollX = rawX;
                this.start = false;
            }
        } else {
            this.start = true;
            float f = rawX;
            this.currentScrollX = f;
            int i2 = this.itemWidth / 10;
            float f2 = this.prevScrollX;
            float f3 = i2;
            if (f2 - f > f3) {
                int i3 = this.activeItem;
                if (i3 < this.maxItem - 1) {
                    this.activeItem = i3 + 1;
                }
            } else if (f - f2 > f3 && (i = this.activeItem) > 0) {
                this.activeItem = i - 1;
            }
            System.out.println("horizontal : " + this.activeItem);
            int i4 = this.activeItem;
            int i5 = (i4 * this.itemWidth) + (i4 > 0 ? ((i4 + 1) * this.padding) - ((AndroidUtilities.displayMetrics.widthPixels - this.itemWidth) / 2) : 0);
            this.scrollTo = i5;
            scrollToByAnimation(i5);
            OnScrollListener onScrollListener = this.delegate;
            if (onScrollListener != null) {
                onScrollListener.onIdleScrolling(this.activeItem);
            }
            boolValueOf = Boolean.TRUE;
        }
        return boolValueOf.booleanValue();
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i) {
        super.fling((int) (Math.min(Math.abs(i), 20) * Math.signum(i)));
    }

    private void scrollToByAnimation(int i) {
        ObjectAnimator objectAnimator = this.anim;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.anim.cancel();
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "scrollX", i);
        this.anim = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(700L);
        this.anim.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.rghapp.rubinoPostSlider.SSHHorizontalScrollView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!SSHHorizontalScrollView.this.start || SSHHorizontalScrollView.this.delegate == null) {
                    return;
                }
                SSHHorizontalScrollView.this.delegate.onStartScrolling();
            }
        });
        this.anim.start();
    }

    public void setDelegate(OnScrollListener onScrollListener) {
        this.delegate = onScrollListener;
    }
}
