package ir.eitaa.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class PlayPauseDrawable extends Drawable {
    private int alpha = 255;
    float duration = 300.0f;
    private long lastUpdateTime;
    private final Paint paint;
    private View parent;
    private boolean pause;
    private float progress;
    private final int size;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public PlayPauseDrawable(int size) {
        this.size = AndroidUtilities.dp(size);
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(-1);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.PlayPauseDrawable.draw(android.graphics.Canvas):void");
    }

    public void setPause(boolean pause) {
        setPause(pause, true);
    }

    public void setPause(boolean pause, boolean animated) {
        if (this.pause != pause) {
            this.pause = pause;
            if (!animated) {
                this.progress = pause ? 1.0f : 0.0f;
            }
            this.lastUpdateTime = AnimationUtils.currentAnimationTimeMillis();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.size;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.size;
    }

    public void setParent(View parent) {
        this.parent = parent;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
