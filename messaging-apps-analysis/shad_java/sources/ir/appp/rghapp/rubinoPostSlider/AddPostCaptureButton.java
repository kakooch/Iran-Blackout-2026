package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class AddPostCaptureButton extends View {
    private AddPostCaptureButtonDelegate delegate;
    private Runnable longPressed;
    private Paint mInnerCircle;
    private Paint mOutterCircle;
    private boolean processRelease;
    private int strokeWidth;

    public interface AddPostCaptureButtonDelegate {
        boolean captureLongPressed();

        void captureReleased();

        void didTouchShutterButton();
    }

    public AddPostCaptureButton(Context context) {
        super(context);
        this.longPressed = new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.AddPostCaptureButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (AddPostCaptureButton.this.delegate == null || AddPostCaptureButton.this.delegate.captureLongPressed()) {
                    return;
                }
                AddPostCaptureButton.this.processRelease = false;
            }
        };
        initPaints();
    }

    public void setDelegate(AddPostCaptureButtonDelegate addPostCaptureButtonDelegate) {
        this.delegate = addPostCaptureButtonDelegate;
    }

    private void initPaints() {
        this.strokeWidth = AndroidUtilities.dp(15.0f);
        Paint paint = new Paint(1);
        this.mInnerCircle = paint;
        paint.setColor(0);
        this.mInnerCircle.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mOutterCircle = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mOutterCircle.setStrokeWidth(this.strokeWidth);
        this.mOutterCircle.setColor(Theme.getColor(Theme.key_rubino_add_post_CaptureButtonColor));
    }

    private void setHighlighted(boolean z) {
        this.mOutterCircle.setColor(Theme.getColor(z ? Theme.key_rubino_add_post_CaptureButtonColorHighlight : Theme.key_rubino_add_post_CaptureButtonColor));
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            AndroidUtilities.runOnUIThread(this.longPressed, 800L);
            this.processRelease = true;
            setHighlighted(true);
            AddPostCaptureButtonDelegate addPostCaptureButtonDelegate = this.delegate;
            if (addPostCaptureButtonDelegate != null) {
                addPostCaptureButtonDelegate.didTouchShutterButton();
            }
        } else if (action == 1) {
            setHighlighted(false);
            AndroidUtilities.cancelRunOnUIThread(this.longPressed);
            if (this.processRelease) {
                this.delegate.captureReleased();
            }
        } else if (action == 3) {
            setHighlighted(false);
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        int iMin = Math.min(measuredWidth, measuredHeight);
        float f = measuredWidth;
        float f2 = measuredHeight;
        canvas.drawCircle(f, f2, iMin - (this.strokeWidth / 2.0f), this.mOutterCircle);
        canvas.drawCircle(f, f2, iMin - this.strokeWidth, this.mInnerCircle);
    }
}
