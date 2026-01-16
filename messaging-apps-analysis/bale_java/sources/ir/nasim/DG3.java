package ir.nasim;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;

/* loaded from: classes8.dex */
public final class DG3 extends Drawable {
    private static final a i = new a(null);
    private static final int j = (int) ((4 * AbstractC3742Cd6.c()) + 0.5d);
    private static final float k = (int) ((2 * AbstractC3742Cd6.c()) + 0.5d);
    private final int a;
    private final int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private long g;
    private final Paint h;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ DG3(int i2, float f, int i3, int i4, int i5, ED1 ed1) {
        this((i5 & 1) != 0 ? -1 : i2, (i5 & 2) != 0 ? k : f, (i5 & 4) != 0 ? 102 : i3, (i5 & 8) != 0 ? j : i4);
    }

    public static /* synthetic */ void b(DG3 dg3, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        dg3.a(i2, z);
    }

    public final void a(int i2, boolean z) {
        if (z) {
            this.e = 0.0f;
        }
        this.f = AbstractC23053wG5.m(i2, 0, 100) * 3.6f;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Math.max(16, (int) (jCurrentAnimationTimeMillis - this.g));
        int i2 = this.d;
        int iSaveLayerAlpha = i2 != 255 ? canvas.saveLayerAlpha(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, i2) : canvas.save();
        try {
            int iSave = canvas.save();
            canvas.translate(getBounds().left + ((getBounds().width() - this.c) / 2.0f), getBounds().top + ((getBounds().height() - this.c) / 2.0f));
            try {
                int color = this.h.getColor();
                Paint paint = this.h;
                paint.setColor(QY0.k(paint.getColor(), this.a));
                int i3 = this.c;
                canvas.drawCircle(i3 / 2.0f, i3 / 2.0f, i3 / 2.0f, this.h);
                this.h.setColor(color);
                int i4 = this.c;
                canvas.drawArc(0.0f, 0.0f, i4, i4, this.e, this.f, false, this.h);
                canvas.restoreToCount(iSaveLayerAlpha);
                float f = this.e + 5;
                this.e = f;
                if (f >= 360.0f) {
                    this.e = f - 360;
                }
                this.g = jCurrentAnimationTimeMillis;
                invalidateSelf();
            } finally {
                canvas.restoreToCount(iSave);
            }
        } catch (Throwable th) {
            canvas.restoreToCount(iSaveLayerAlpha);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        AbstractC13042fc3.i(rect, "bounds");
        super.onBoundsChange(rect);
        this.c = AbstractC20723sV3.d(AbstractC23053wG5.d((Math.min(rect.width(), rect.height()) - (this.b * 2)) - this.h.getStrokeWidth(), 0.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.d = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.h.setColorFilter(colorFilter);
    }

    public DG3(int i2, float f, int i3, int i4) {
        this.a = i3;
        this.b = i4;
        this.d = 255;
        Paint paint = new Paint(1);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(f);
        this.h = paint;
    }
}
