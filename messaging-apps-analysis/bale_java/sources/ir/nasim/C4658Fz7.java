package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: ir.nasim.Fz7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4658Fz7 extends Drawable {
    public static final a d = new a(null);
    public static final int e = 8;
    private final int a;
    private final Paint b;
    private final int c;

    /* renamed from: ir.nasim.Fz7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C4658Fz7() {
        this(0, 1, null);
    }

    private final float a(int i) {
        if ((System.currentTimeMillis() + i) % 1400 > 600) {
            return 0.0f;
        }
        return (float) Math.abs(Math.sin((r0 / 600.0f) * 3.141592653589793d));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fA;
        float fA2;
        float fA3;
        AbstractC13042fc3.i(canvas, "canvas");
        if (JF5.g()) {
            fA3 = (a(400) * 0.3f) + 0.7f;
            fA = (a(200) * 0.3f) + 0.7f;
            fA2 = (a(0) * 0.3f) + 0.7f;
        } else {
            float fA4 = (a(400) * 0.3f) + 0.7f;
            fA = (a(200) * 0.3f) + 0.7f;
            fA2 = fA4;
            fA3 = (a(0) * 0.3f) + 0.7f;
        }
        Rect bounds = getBounds();
        AbstractC13042fc3.h(bounds, "getBounds(...)");
        int iHeight = ((getBounds().height() - C22078ud6.a(6.0f)) / 2) + bounds.top;
        canvas.drawCircle(C22078ud6.a(3.0f), C22078ud6.a(3.0f) + iHeight, fA2 * C22078ud6.a(3.0f), this.b);
        canvas.drawCircle(C22078ud6.a(10.0f), C22078ud6.a(3.0f) + iHeight, fA * C22078ud6.a(3.0f), this.b);
        canvas.drawCircle(C22078ud6.a(17.0f), C22078ud6.a(3.0f) + iHeight, fA3 * C22078ud6.a(3.0f), this.b);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return C22078ud6.a(21.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    public C4658Fz7(int i) {
        this.a = i;
        Paint paint = new Paint();
        this.b = paint;
        this.c = C22078ud6.a(6.0f);
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public /* synthetic */ C4658Fz7(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? C5495Jo7.a.h() : i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
