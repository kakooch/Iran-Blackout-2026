package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.Rf2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C7321Rf2 extends Drawable {
    private static final Paint c;
    private Bitmap a;
    private Rect b;

    static {
        Paint paint = new Paint();
        c = paint;
        paint.setAntiAlias(true);
    }

    public C7321Rf2(Bitmap bitmap) {
        this.a = bitmap;
        this.b = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.a.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.a, this.b, getBounds(), c);
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
