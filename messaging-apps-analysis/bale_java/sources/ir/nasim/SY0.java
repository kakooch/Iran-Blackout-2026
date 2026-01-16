package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class SY0 extends ReplacementSpan {
    int a;
    Drawable b;
    int d;
    private float f;
    private int g;
    private int h;
    private final int i;
    private Runnable k;
    boolean c = true;
    private int e = 0;
    private float j = 1.0f;

    public SY0(Drawable drawable, int i) {
        this.b = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        this.i = i;
    }

    public void a(float f) {
        this.j = f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Runnable runnable = this.k;
        if (runnable != null) {
            runnable.run();
        } else {
            int color = this.c ? paint.getColor() : ir.nasim.tgwidgets.editor.ui.ActionBar.m.i0(this.d);
            if (this.a != color) {
                this.a = color;
                this.b.setColorFilter(new PorterDuffColorFilter(this.a, PorterDuff.Mode.MULTIPLY));
            }
        }
        canvas.save();
        Drawable drawable = this.b;
        int iF = i5 - (drawable != null ? drawable.getBounds().bottom : i5);
        int i6 = this.i;
        if (i6 != 1) {
            if (i6 == 2) {
                int i7 = i3 + ((i5 - i3) / 2);
                Drawable drawable2 = this.b;
                iF = i7 - (drawable2 != null ? drawable2.getBounds().height() / 2 : 0);
            } else if (i6 == 0) {
                int i8 = i5 - i3;
                int intrinsicHeight = this.g;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.b.getIntrinsicHeight();
                }
                iF = AbstractC21455b.F(this.e) + i3 + ((i8 - intrinsicHeight) / 2);
            }
        }
        canvas.translate(f + this.f, iF);
        if (this.b != null) {
            float f2 = this.j;
            if (f2 != 1.0f) {
                canvas.scale(f2, f2, 0.0f, r2.getBounds().centerY());
            }
            this.b.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        int i3 = this.h;
        if (i3 != 0) {
            return (int) (this.j * i3);
        }
        float f = this.j;
        int intrinsicWidth = this.g;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.b.getIntrinsicWidth();
        }
        return (int) (f * intrinsicWidth);
    }
}
