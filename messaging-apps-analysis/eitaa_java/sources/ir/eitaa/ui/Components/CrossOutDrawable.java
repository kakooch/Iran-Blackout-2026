package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class CrossOutDrawable extends Drawable {
    int color;
    String colorKey;
    boolean cross;
    Drawable iconDrawable;
    private float lenOffsetBottom;
    private float lenOffsetTop;
    float progress;
    private float xOffset;
    final Paint xRefPaint;
    RectF rectF = new RectF();
    Paint paint = new Paint(1);

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

    public CrossOutDrawable(Context context, int iconRes, String colorKey) {
        Paint paint = new Paint(1);
        this.xRefPaint = paint;
        this.iconDrawable = ContextCompat.getDrawable(context, iconRes);
        this.colorKey = colorKey;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(AndroidUtilities.dpf2(1.7f));
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(-16777216);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(AndroidUtilities.dpf2(2.5f));
    }

    public void setCrossOut(boolean cross, boolean animated) {
        if (this.cross != cross) {
            this.cross = cross;
            if (!animated) {
                this.progress = cross ? 1.0f : 0.0f;
            } else {
                this.progress = cross ? 0.0f : 1.0f;
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.CrossOutDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.iconDrawable.setBounds(left, top, right, bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.iconDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.iconDrawable.getIntrinsicWidth();
    }

    public void setOffsets(float xOffset, float lenOffsetTop, float lenOffsetBottom) {
        this.xOffset = xOffset;
        this.lenOffsetTop = lenOffsetTop;
        this.lenOffsetBottom = lenOffsetBottom;
        invalidateSelf();
    }

    public void setStrokeWidth(float w) {
        this.paint.setStrokeWidth(w);
        this.xRefPaint.setStrokeWidth(w * 1.47f);
    }

    public float getProgress() {
        return this.progress;
    }
}
