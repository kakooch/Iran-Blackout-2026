package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.C9151Ys;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class ToggleButton extends View {
    private Drawable a;
    private int b;
    private Bitmap c;
    private final Paint d;
    private final Paint e;
    private float f;
    private final C9151Ys g;
    private final Path h;

    public ToggleButton(Context context, int i, int i2) {
        super(context);
        Paint paint = new Paint(1);
        this.d = paint;
        Paint paint2 = new Paint(3);
        this.e = paint2;
        this.g = new C9151Ys(this, 0L, 350L, InterpolatorC12631ew1.h);
        this.h = new Path();
        this.a = context.getResources().getDrawable(i).mutate();
        this.b = i2;
        paint.setColor(-1);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.c == null) {
            this.c = BitmapFactory.decodeResource(getResources(), this.b);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.c;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fC = this.g.c(this.f);
        int intrinsicWidth = this.a.getIntrinsicWidth();
        int intrinsicHeight = this.a.getIntrinsicHeight();
        Rect rect = AbstractC21455b.y;
        rect.set((getWidth() - intrinsicWidth) / 2, (getHeight() - intrinsicHeight) / 2, (getWidth() + intrinsicWidth) / 2, (getHeight() + intrinsicHeight) / 2);
        if (fC <= 0.0f) {
            this.a.setBounds(rect);
            this.a.draw(canvas);
        } else if (fC < 1.0f) {
            canvas.save();
            this.h.rewind();
            this.h.addCircle(getWidth() / 2.0f, getHeight() / 2.0f, AbstractC21455b.F(16.0f) * fC, Path.Direction.CW);
            canvas.clipPath(this.h, Region.Op.DIFFERENCE);
            this.a.setBounds(rect);
            this.a.draw(canvas);
            canvas.restore();
        }
        if (fC > 0.0f) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255, 31);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, AbstractC21455b.F(16.0f) * fC, this.d);
            canvas.save();
            Bitmap bitmap = this.c;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, this.e);
            }
            canvas.restore();
            canvas.restore();
        }
    }

    public void setValue(boolean z) {
        this.f = z ? 1.0f : 0.0f;
        invalidate();
    }
}
