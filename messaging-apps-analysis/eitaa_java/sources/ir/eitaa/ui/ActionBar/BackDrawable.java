package ir.eitaa.ui.ActionBar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class BackDrawable extends Drawable {
    private boolean alwaysClose;
    private int arrowRotation;
    private int currentAnimationTime;
    private float currentRotation;
    private float finalRotation;
    private long lastFrameTime;
    private boolean reverseAngle;
    private Paint paint = new Paint(1);
    private DecelerateInterpolator interpolator = new DecelerateInterpolator();
    private int color = -1;
    private int rotatedColor = -9079435;
    private float animationTime = 300.0f;
    private boolean rotated = true;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public BackDrawable(boolean close) {
        this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.alwaysClose = close;
    }

    public void setColor(int value) {
        this.color = value;
        invalidateSelf();
    }

    public void setRotatedColor(int value) {
        this.rotatedColor = value;
        invalidateSelf();
    }

    public void setArrowRotation(int angle) {
        this.arrowRotation = angle;
        invalidateSelf();
    }

    public void setRotation(float rotation, boolean animated) {
        this.lastFrameTime = 0L;
        float f = this.currentRotation;
        if (f == 1.0f) {
            this.reverseAngle = true;
        } else if (f == 0.0f) {
            this.reverseAngle = false;
        }
        this.lastFrameTime = 0L;
        if (animated) {
            if (f < rotation) {
                this.currentAnimationTime = (int) (f * this.animationTime);
            } else {
                this.currentAnimationTime = (int) ((1.0f - f) * this.animationTime);
            }
            this.lastFrameTime = System.currentTimeMillis();
            this.finalRotation = rotation;
        } else {
            this.currentRotation = rotation;
            this.finalRotation = rotation;
        }
        invalidateSelf();
    }

    public void setAnimationTime(float value) {
        this.animationTime = value;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        if (this.currentRotation != this.finalRotation) {
            if (this.lastFrameTime != 0) {
                int iCurrentTimeMillis = (int) (this.currentAnimationTime + (System.currentTimeMillis() - this.lastFrameTime));
                this.currentAnimationTime = iCurrentTimeMillis;
                float f2 = iCurrentTimeMillis;
                float f3 = this.animationTime;
                if (f2 >= f3) {
                    this.currentRotation = this.finalRotation;
                } else if (this.currentRotation < this.finalRotation) {
                    this.currentRotation = this.interpolator.getInterpolation(iCurrentTimeMillis / f3) * this.finalRotation;
                } else {
                    this.currentRotation = 1.0f - this.interpolator.getInterpolation(iCurrentTimeMillis / f3);
                }
            }
            this.lastFrameTime = System.currentTimeMillis();
            invalidateSelf();
        }
        this.paint.setColor(Color.rgb(Color.red(this.color) + (this.rotated ? (int) ((Color.red(this.rotatedColor) - Color.red(this.color)) * this.currentRotation) : 0), Color.green(this.color) + (this.rotated ? (int) ((Color.green(this.rotatedColor) - Color.green(this.color)) * this.currentRotation) : 0), Color.blue(this.color) + (this.rotated ? (int) ((Color.blue(this.rotatedColor) - Color.blue(this.color)) * this.currentRotation) : 0)));
        canvas.save();
        canvas.translate(getIntrinsicWidth() / 2, getIntrinsicHeight() / 2);
        int i = this.arrowRotation;
        if (i != 0) {
            canvas.rotate(i);
        }
        float f4 = this.currentRotation;
        if (this.alwaysClose) {
            canvas.rotate((f4 * (this.reverseAngle ? -180 : 180)) + 135.0f);
            f = 1.0f;
        } else {
            canvas.rotate((this.reverseAngle ? -225 : 135) * f4);
            f = f4;
        }
        canvas.drawLine((-AndroidUtilities.dp(7.0f)) - (AndroidUtilities.dp(1.0f) * f), 0.0f, AndroidUtilities.dp(8.0f), 0.0f, this.paint);
        float f5 = -AndroidUtilities.dp(0.5f);
        float fDp = AndroidUtilities.dp(7.0f) + (AndroidUtilities.dp(1.0f) * f);
        float fDp2 = (-AndroidUtilities.dp(7.0f)) + (AndroidUtilities.dp(7.0f) * f);
        float fDp3 = AndroidUtilities.dp(0.5f) - (AndroidUtilities.dp(0.5f) * f);
        canvas.drawLine(fDp2, -f5, fDp3, -fDp, this.paint);
        canvas.drawLine(fDp2, f5, fDp3, fDp, this.paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(24.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(24.0f);
    }
}
