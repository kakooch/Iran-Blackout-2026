package ir.nasim.tgwidgets.editor.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.Keep;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class AnimatedArrowDrawable extends Drawable {
    private Paint a;
    private Path b;
    private float c;
    private float d;
    private long e;
    private boolean f;

    private void a() {
        if (this.d != this.c) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.e;
            this.e = jElapsedRealtime;
            float f = this.c;
            float f2 = this.d;
            if (f < f2) {
                float f3 = f + (j / 180.0f);
                this.c = f3;
                if (f3 > f2) {
                    this.c = f2;
                }
            } else {
                float f4 = f - (j / 180.0f);
                this.c = f4;
                if (f4 < f2) {
                    this.c = f2;
                }
            }
            b();
            invalidateSelf();
        }
    }

    private void b() {
        this.b.reset();
        float f = (this.c * 2.0f) - 1.0f;
        if (this.f) {
            this.b.moveTo(AbstractC21455b.F(3.0f), AbstractC21455b.F(6.0f) - (AbstractC21455b.F(2.0f) * f));
            this.b.lineTo(AbstractC21455b.F(8.0f), AbstractC21455b.F(6.0f) + (AbstractC21455b.F(2.0f) * f));
            this.b.lineTo(AbstractC21455b.F(13.0f), AbstractC21455b.F(6.0f) - (AbstractC21455b.F(2.0f) * f));
        } else {
            this.b.moveTo(AbstractC21455b.F(4.5f), AbstractC21455b.F(12.0f) - (AbstractC21455b.F(4.0f) * f));
            this.b.lineTo(AbstractC21455b.F(13.0f), AbstractC21455b.F(12.0f) + (AbstractC21455b.F(4.0f) * f));
            this.b.lineTo(AbstractC21455b.F(21.5f), AbstractC21455b.F(12.0f) - (AbstractC21455b.F(4.0f) * f));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawPath(this.b, this.a);
        a();
    }

    @Keep
    public float getAnimationProgress() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AbstractC21455b.F(26.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AbstractC21455b.F(26.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Keep
    public void setAnimationProgress(float f) {
        this.c = f;
        this.d = f;
        b();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
