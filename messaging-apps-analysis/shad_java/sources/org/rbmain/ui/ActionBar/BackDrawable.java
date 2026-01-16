package org.rbmain.ui.ActionBar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes4.dex */
public class BackDrawable extends Drawable {
    private boolean alwaysClose;
    private int arrowRotation;
    private int currentAnimationTime;
    private float currentRotation;
    private float finalRotation;
    private long lastFrameTime;
    private Paint paint = new Paint(1);
    private boolean reverseAngle = false;
    private DecelerateInterpolator interpolator = new DecelerateInterpolator();
    private int color = -14606047;
    private int rotatedColor = -9079435;
    private float animationTime = 300.0f;
    private boolean rotated = true;
    private boolean rtlLayout = false;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public BackDrawable(boolean z) {
        this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.alwaysClose = z;
        this.arrowRotation = 0;
    }

    public void setColor(int i) {
        this.color = i;
        invalidateSelf();
    }

    public void setRotatedColor(int i) {
        this.rotatedColor = i;
        invalidateSelf();
    }

    public void setArrowRotation(int i) {
        this.arrowRotation = i;
        invalidateSelf();
    }

    public void setRotation(float f, boolean z) {
        this.lastFrameTime = 0L;
        float f2 = this.currentRotation;
        if (f2 == 1.0f) {
            this.reverseAngle = true;
        } else if (f2 == 0.0f) {
            this.reverseAngle = false;
        }
        this.lastFrameTime = 0L;
        if (z) {
            if (f2 < f) {
                this.currentAnimationTime = (int) (f2 * this.animationTime);
            } else {
                this.currentAnimationTime = (int) ((1.0f - f2) * this.animationTime);
            }
            this.lastFrameTime = System.currentTimeMillis();
            this.finalRotation = f;
        } else {
            this.currentRotation = f;
            this.finalRotation = f;
        }
        invalidateSelf();
    }

    public void setAnimationTime(float f) {
        this.animationTime = f;
    }

    public void setRtlLayout(boolean z) {
        this.rtlLayout = z;
    }

    private boolean isRtlLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        if (isRtlLayout() && this.arrowRotation == 0) {
            this.arrowRotation = 180;
        }
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
