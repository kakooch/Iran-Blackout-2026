package ir.eitaa.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;

/* loaded from: classes3.dex */
public class VideoForwardDrawable extends Drawable {
    private static final int[] playPath = {10, 7, 26, 16, 10, 25};
    private boolean animating;
    private float animationProgress;
    private Path clippingPath;
    private VideoForwardDrawableDelegate delegate;
    private float enterAnimationProgress;
    private boolean isOneShootAnimation;
    private boolean isRound;
    private long lastAnimationTime;
    private int lastClippingPath;
    private boolean leftSide;
    private boolean showing;
    private long time;
    private String timeStr;
    private Paint paint = new Paint(1);
    private TextPaint textPaint = new TextPaint(1);
    private Path path1 = new Path();

    public interface VideoForwardDrawableDelegate {
        void invalidate();

        void onAnimationEnd();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public void setTime(long dt) {
        this.time = dt;
        if (dt >= 1000) {
            this.timeStr = LocaleController.formatPluralString("Seconds", (int) (dt / 1000));
        } else {
            this.timeStr = null;
        }
    }

    public VideoForwardDrawable(boolean isRound) {
        this.isRound = isRound;
        this.paint.setColor(-1);
        this.textPaint.setColor(-1);
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.path1.reset();
        int i = 0;
        while (true) {
            if (i >= playPath.length / 2) {
                this.path1.close();
                return;
            }
            if (i == 0) {
                int i2 = i * 2;
                this.path1.moveTo(AndroidUtilities.dp(r0[i2]), AndroidUtilities.dp(r0[i2 + 1]));
            } else {
                int i3 = i * 2;
                this.path1.lineTo(AndroidUtilities.dp(r0[i3]), AndroidUtilities.dp(r0[i3 + 1]));
            }
            i++;
        }
    }

    public boolean isAnimating() {
        return this.animating;
    }

    public void startAnimation() {
        this.animating = true;
        this.animationProgress = 0.0f;
        invalidateSelf();
    }

    public void setOneShootAnimation(boolean isOneShootAnimation) {
        if (this.isOneShootAnimation != isOneShootAnimation) {
            this.isOneShootAnimation = isOneShootAnimation;
            this.timeStr = null;
            this.time = 0L;
            this.animationProgress = 0.0f;
        }
    }

    public void setLeftSide(boolean value) {
        boolean z = this.leftSide;
        if (z == value && this.animationProgress >= 1.0f && this.isOneShootAnimation) {
            return;
        }
        if (z != value) {
            this.time = 0L;
            this.timeStr = null;
        }
        this.leftSide = value;
        startAnimation();
    }

    public void setDelegate(VideoForwardDrawableDelegate videoForwardDrawableDelegate) {
        this.delegate = videoForwardDrawableDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
        this.textPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0286  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.VideoForwardDrawable.draw(android.graphics.Canvas):void");
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
        invalidate();
    }

    private void invalidate() {
        VideoForwardDrawableDelegate videoForwardDrawableDelegate = this.delegate;
        if (videoForwardDrawableDelegate != null) {
            videoForwardDrawableDelegate.invalidate();
        } else {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return AndroidUtilities.dp(32.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return AndroidUtilities.dp(32.0f);
    }

    public void addTime(long time) {
        long j = this.time + time;
        this.time = j;
        this.timeStr = LocaleController.formatPluralString("Seconds", (int) (j / 1000));
    }
}
