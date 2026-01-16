package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.Mq7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6214Mq7 extends Drawable {
    private final Paint a;
    private Bitmap b;

    public C6214Mq7(Drawable drawable, int i) {
        Paint paint = new Paint();
        this.a = paint;
        if (!(drawable instanceof BitmapDrawable)) {
            throw new RuntimeException("BitmapDrawable is required");
        }
        this.b = ((BitmapDrawable) drawable).getBitmap();
        paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.b, (getBounds().width() - this.b.getWidth()) / 2, (getBounds().height() - this.b.getHeight()) / 2, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.b.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.b.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
