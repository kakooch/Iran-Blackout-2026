package ir.nasim;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.view.View;

/* renamed from: ir.nasim.sK2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20623sK2 {
    public static final float a(float f, float f2, float f3) {
        return Math.min(f3, Math.max(f, f2));
    }

    public static final int b(View view, int i) {
        AbstractC13042fc3.j(view, "$receiver");
        Resources resources = view.getResources();
        AbstractC13042fc3.e(resources, "resources");
        return (int) (i * resources.getDisplayMetrics().density);
    }

    public static final PorterDuffColorFilter c(int i) {
        return new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    public static final Paint d(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(c(i));
        return paint;
    }

    public static final boolean e(Bitmap bitmap, int i, int i2) {
        return bitmap != null && bitmap.getHeight() == i2 && bitmap.getWidth() == i;
    }

    public static final C19938rB7 f(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        bitmap.eraseColor(0);
        return C19938rB7.a;
    }

    public static final Canvas g(Bitmap bitmap) {
        AbstractC13042fc3.j(bitmap, "$receiver");
        return new Canvas(bitmap);
    }

    public static final RectF h(int i, int i2, int i3, int i4) {
        return new RectF(i, i2, i3, i4);
    }

    public static final void i(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    public static final Paint j(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        return paint;
    }

    public static final int k(int i, int i2) {
        if (i2 < 0 || 255 < i2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return (i & 16777215) | (i2 << 24);
    }
}
