package org.rbmain.ui.ActionBar;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes4.dex */
public class MenuDrawable extends Drawable {
    private int currentAnimationTime;
    private float currentRotation;
    private float finalRotation;
    private int iconColor;
    private long lastFrameTime;
    private boolean reverseAngle;
    private Paint paint = new Paint(1);
    private boolean rotateToBack = true;
    private DecelerateInterpolator interpolator = new DecelerateInterpolator();
    private boolean rtlLayout = true;

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

    public MenuDrawable() {
        this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
    }

    public void setRotateToBack(boolean z) {
        this.rotateToBack = z;
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
                this.currentAnimationTime = (int) (f2 * 200.0f);
            } else {
                this.currentAnimationTime = (int) ((1.0f - f2) * 200.0f);
            }
            this.lastFrameTime = SystemClock.elapsedRealtime();
            this.finalRotation = f;
        } else {
            this.currentRotation = f;
            this.finalRotation = f;
        }
        invalidateSelf();
    }

    private boolean isRtlLayout() {
        return LocaleController.isRTL && this.rtlLayout;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fDp;
        float fDp2;
        float fDp3;
        float f;
        float fDp4;
        float fAbs;
        if (this.currentRotation != this.finalRotation) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.lastFrameTime;
            if (j != 0) {
                int i = (int) (this.currentAnimationTime + (jElapsedRealtime - j));
                this.currentAnimationTime = i;
                if (i >= 200) {
                    this.currentRotation = this.finalRotation;
                } else if (this.currentRotation < this.finalRotation) {
                    this.currentRotation = this.interpolator.getInterpolation(i / 200.0f) * this.finalRotation;
                } else {
                    this.currentRotation = 1.0f - this.interpolator.getInterpolation(i / 200.0f);
                }
            }
            this.lastFrameTime = jElapsedRealtime;
            invalidateSelf();
        }
        canvas.save();
        canvas.translate(getIntrinsicWidth() / 2, getIntrinsicHeight() / 2);
        int color = this.iconColor;
        if (color == 0) {
            color = Theme.getColor(Theme.key_actionBarDefaultIcon);
        }
        if (isRtlLayout()) {
            canvas.rotate(180.0f);
        }
        if (this.rotateToBack) {
            canvas.rotate(this.currentRotation * (this.reverseAngle ? -180 : 180));
            this.paint.setColor(color);
            this.paint.setAlpha((int) (this.currentRotation * 255.0f));
            canvas.drawLine(-AndroidUtilities.dp(9.0f), 0.0f, AndroidUtilities.dp(9.0f) - (AndroidUtilities.dp(3.0f) * this.currentRotation), 0.0f, this.paint);
            fDp = (AndroidUtilities.dp(5.0f) * (1.0f - Math.abs(this.currentRotation))) - (AndroidUtilities.dp(0.5f) * Math.abs(this.currentRotation));
            fDp2 = AndroidUtilities.dp(9.0f) - (AndroidUtilities.dp(2.5f) * Math.abs(this.currentRotation));
            fDp3 = AndroidUtilities.dp(5.0f) + (AndroidUtilities.dp(2.0f) * Math.abs(this.currentRotation));
            f = -AndroidUtilities.dp(9.0f);
            fDp4 = AndroidUtilities.dp(7.5f);
            fAbs = Math.abs(this.currentRotation);
        } else {
            canvas.rotate(this.currentRotation * (this.reverseAngle ? -225 : 135));
            this.paint.setColor(AndroidUtilities.getOffsetColor(color, Theme.getColor(Theme.key_actionBarActionModeDefaultIcon), this.currentRotation, 1.0f));
            this.paint.setAlpha((int) (this.currentRotation * 255.0f));
            canvas.drawLine((-AndroidUtilities.dp(9.0f)) + (AndroidUtilities.dp(1.0f) * this.currentRotation), 0.0f, AndroidUtilities.dp(9.0f) - (AndroidUtilities.dp(1.0f) * this.currentRotation), 0.0f, this.paint);
            fDp = (AndroidUtilities.dp(5.0f) * (1.0f - Math.abs(this.currentRotation))) - (AndroidUtilities.dp(0.5f) * Math.abs(this.currentRotation));
            fDp2 = AndroidUtilities.dp(9.0f) - (AndroidUtilities.dp(9.0f) * Math.abs(this.currentRotation));
            fDp3 = AndroidUtilities.dp(5.0f) + (AndroidUtilities.dp(3.0f) * Math.abs(this.currentRotation));
            f = -AndroidUtilities.dp(9.0f);
            fDp4 = AndroidUtilities.dp(9.0f);
            fAbs = Math.abs(this.currentRotation);
        }
        float f2 = f + (fDp4 * fAbs);
        float f3 = fDp;
        float f4 = fDp2;
        float f5 = fDp3;
        canvas.drawLine(f2, -f5, f4, -f3, this.paint);
        canvas.drawLine(f2, f5, f4, f3, this.paint);
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

    public void setIconColor(int i) {
        this.iconColor = i;
    }
}
