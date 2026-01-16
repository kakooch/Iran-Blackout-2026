package ir.eitaa.ui.Components.voip;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class FabBackgroundDrawable extends Drawable {
    private Paint bgPaint = new Paint(1);
    private Bitmap shadowBitmap;
    private Paint shadowPaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public FabBackgroundDrawable() {
        Paint paint = new Paint();
        this.shadowPaint = paint;
        paint.setColor(1275068416);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.shadowBitmap == null) {
            onBoundsChange(getBounds());
        }
        int iMin = Math.min(getBounds().width(), getBounds().height());
        Bitmap bitmap = this.shadowBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, getBounds().centerX() - (this.shadowBitmap.getWidth() / 2), getBounds().centerY() - (this.shadowBitmap.getHeight() / 2), this.shadowPaint);
        }
        float f = iMin / 2;
        canvas.drawCircle(f, f, r0 - AndroidUtilities.dp(4.0f), this.bgPaint);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        int iMin = Math.min(bounds.width(), bounds.height());
        if (iMin <= 0) {
            this.shadowBitmap = null;
            return;
        }
        this.shadowBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(this.shadowBitmap);
        Paint paint = new Paint(1);
        paint.setShadowLayer(AndroidUtilities.dp(3.33333f), 0.0f, AndroidUtilities.dp(0.666f), -1);
        float f = iMin / 2;
        canvas.drawCircle(f, f, r7 - AndroidUtilities.dp(4.0f), paint);
    }

    @Keep
    public void setColor(int color) {
        this.bgPaint.setColor(color);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect padding) {
        int iDp = AndroidUtilities.dp(4.0f);
        padding.set(iDp, iDp, iDp, iDp);
        return true;
    }
}
