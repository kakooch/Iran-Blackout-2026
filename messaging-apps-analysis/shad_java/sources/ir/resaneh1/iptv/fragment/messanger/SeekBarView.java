package ir.resaneh1.iptv.fragment.messanger;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SeekBarView extends FrameLayout {
    public float bufferedProgress;
    public SeekBarViewDelegate delegate;
    public Paint innerPaint1;
    public Paint outerPaint1;
    public boolean pressed;
    public float progressToSet;
    public boolean reportChanges;
    public int thumbDX;
    public int thumbHeight;
    public int thumbWidth;
    public int thumbX;

    public interface SeekBarViewDelegate {
        void onSeekBarDrag(float f);
    }

    public SeekBarView(Context context) {
        super(context);
        setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.innerPaint1 = paint;
        paint.setColor(419430400);
        Paint paint2 = new Paint(1);
        this.outerPaint1 = paint2;
        paint2.setColor(-14438417);
        this.thumbWidth = AndroidUtilities.dp(24.0f);
        this.thumbHeight = AndroidUtilities.dp(24.0f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return onTouch(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouch(motionEvent);
    }

    public void setReportChanges(boolean z) {
        this.reportChanges = z;
    }

    public void setDelegate(SeekBarViewDelegate seekBarViewDelegate) {
        this.delegate = seekBarViewDelegate;
    }

    public boolean onTouch(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            int measuredHeight = (getMeasuredHeight() - this.thumbWidth) / 2;
            if (motionEvent.getY() >= 0.0f && motionEvent.getY() <= getMeasuredHeight()) {
                if (this.thumbX - measuredHeight > motionEvent.getX() || motionEvent.getX() > this.thumbX + this.thumbWidth + measuredHeight) {
                    int x = ((int) motionEvent.getX()) - (this.thumbWidth / 2);
                    this.thumbX = x;
                    if (x < 0) {
                        this.thumbX = 0;
                    } else if (x > getMeasuredWidth() - this.thumbWidth) {
                        this.thumbX = getMeasuredWidth() - this.thumbWidth;
                    }
                }
                this.thumbDX = (int) (motionEvent.getX() - this.thumbX);
                this.pressed = true;
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.pressed) {
                if (motionEvent.getAction() == 1) {
                    this.delegate.onSeekBarDrag(this.thumbX / (getMeasuredWidth() - this.thumbWidth));
                }
                this.pressed = false;
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 2 && this.pressed) {
            int x2 = (int) (motionEvent.getX() - this.thumbDX);
            this.thumbX = x2;
            if (x2 < 0) {
                this.thumbX = 0;
            } else if (x2 > getMeasuredWidth() - this.thumbWidth) {
                this.thumbX = getMeasuredWidth() - this.thumbWidth;
            }
            if (this.reportChanges) {
                this.delegate.onSeekBarDrag(this.thumbX / (getMeasuredWidth() - this.thumbWidth));
            }
            invalidate();
            return true;
        }
        return false;
    }

    public void setProgress(float f) {
        if (getMeasuredWidth() == 0) {
            this.progressToSet = f;
            return;
        }
        this.progressToSet = -1.0f;
        int iCeil = (int) Math.ceil((getMeasuredWidth() - this.thumbWidth) * f);
        if (this.thumbX != iCeil) {
            this.thumbX = iCeil;
            if (iCeil < 0) {
                this.thumbX = 0;
            } else if (iCeil > getMeasuredWidth() - this.thumbWidth) {
                this.thumbX = getMeasuredWidth() - this.thumbWidth;
            }
            invalidate();
        }
    }

    public void setBufferedProgress(float f) {
        this.bufferedProgress = f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.progressToSet < 0.0f || getMeasuredWidth() <= 0) {
            return;
        }
        setProgress(this.progressToSet);
        this.progressToSet = -1.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredHeight = (getMeasuredHeight() - this.thumbHeight) / 2;
        canvas.drawRect(this.thumbWidth / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), getMeasuredWidth() - (this.thumbWidth / 2), (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.innerPaint1);
        if (this.bufferedProgress > 0.0f) {
            canvas.drawRect(this.thumbWidth / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), (this.thumbWidth / 2) + (this.bufferedProgress * (getMeasuredWidth() - this.thumbWidth)), (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.innerPaint1);
        }
        canvas.drawRect(this.thumbWidth / 2, (getMeasuredHeight() / 2) - AndroidUtilities.dp(1.0f), (this.thumbWidth / 2) + this.thumbX, (getMeasuredHeight() / 2) + AndroidUtilities.dp(1.0f), this.outerPaint1);
        canvas.drawCircle(this.thumbX + (this.thumbWidth / 2), measuredHeight + (this.thumbHeight / 2), AndroidUtilities.dp(this.pressed ? 8.0f : 6.0f), this.outerPaint1);
    }
}
