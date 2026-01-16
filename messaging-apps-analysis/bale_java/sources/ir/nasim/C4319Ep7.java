package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.Ep7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4319Ep7 extends Drawable {
    private final Paint a;

    public C4319Ep7(Drawable drawable, Shader.TileMode tileMode) {
        AbstractC13042fc3.i(drawable, "drawable");
        AbstractC13042fc3.i(tileMode, "tileMode");
        Paint paint = new Paint(2);
        paint.setShader(new BitmapShader(a(drawable), tileMode, tileMode));
        paint.setXfermode(C5495Jo7.a.J2() ? new PorterDuffXfermode(PorterDuff.Mode.DST_IN) : new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
        this.a = paint;
    }

    private final Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            AbstractC13042fc3.h(bitmap, "getBitmap(...)");
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        AbstractC13042fc3.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public final Paint b() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        canvas.drawPaint(this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
