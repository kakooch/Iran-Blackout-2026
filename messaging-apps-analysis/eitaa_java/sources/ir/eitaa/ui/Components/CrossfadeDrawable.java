package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class CrossfadeDrawable extends Drawable {
    private final Drawable bottomDrawable;
    private float progress;
    private final Drawable topDrawable;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public CrossfadeDrawable(Drawable topDrawable, Drawable bottomDrawable) {
        this.topDrawable = topDrawable;
        this.bottomDrawable = bottomDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect bounds) {
        this.topDrawable.setBounds(bounds);
        this.bottomDrawable.setBounds(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f = this.progress;
        if (f < 1.0f) {
            this.topDrawable.setAlpha((int) ((1.0f - f) * 255.0f));
            this.topDrawable.draw(canvas);
        }
        float f2 = this.progress;
        if (f2 > 0.0f) {
            this.bottomDrawable.setAlpha((int) (f2 * 255.0f));
            this.bottomDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.topDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.topDrawable.getIntrinsicHeight();
    }

    public void setProgress(float value) {
        this.progress = value;
    }
}
