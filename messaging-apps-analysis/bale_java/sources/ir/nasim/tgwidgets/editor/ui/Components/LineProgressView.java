package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class LineProgressView extends View {
    private static DecelerateInterpolator j;
    private static Paint k;
    private long a;
    private float b;
    private float c;
    private long d;
    private float e;
    private float f;
    private int g;
    private int h;
    private RectF i;

    public LineProgressView(Context context) {
        super(context);
        this.f = 1.0f;
        this.i = new RectF();
        if (j == null) {
            j = new DecelerateInterpolator();
            Paint paint = new Paint(1);
            k = paint;
            paint.setStrokeCap(Paint.Cap.ROUND);
            k.setStrokeWidth(AbstractC21455b.F(2.0f));
        }
    }

    private void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.a;
        this.a = jCurrentTimeMillis;
        float f = this.e;
        if (f != 1.0f) {
            float f2 = this.b;
            if (f != f2) {
                float f3 = this.c;
                float f4 = f2 - f3;
                if (f4 > 0.0f) {
                    long j3 = this.d + j2;
                    this.d = j3;
                    if (j3 >= 300) {
                        this.e = f2;
                        this.c = f2;
                        this.d = 0L;
                    } else {
                        this.e = f3 + (f4 * j.getInterpolation(j3 / 300.0f));
                    }
                }
                invalidate();
            }
        }
        float f5 = this.e;
        if (f5 < 1.0f || f5 != 1.0f) {
            return;
        }
        float f6 = this.f;
        if (f6 != 0.0f) {
            float f7 = f6 - (j2 / 200.0f);
            this.f = f7;
            if (f7 <= 0.0f) {
                this.f = 0.0f;
            }
            invalidate();
        }
    }

    public float getCurrentProgress() {
        return this.b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.g;
        if (i != 0 && this.e != 1.0f) {
            k.setColor(i);
            k.setAlpha((int) (this.f * 255.0f));
            getWidth();
            this.i.set(0.0f, 0.0f, getWidth(), getHeight());
            canvas.drawRoundRect(this.i, getHeight() / 2.0f, getHeight() / 2.0f, k);
        }
        k.setColor(this.h);
        k.setAlpha((int) (this.f * 255.0f));
        this.i.set(0.0f, 0.0f, getWidth() * this.e, getHeight());
        canvas.drawRoundRect(this.i, getHeight() / 2.0f, getHeight() / 2.0f, k);
        a();
    }

    public void setBackColor(int i) {
        this.g = i;
    }

    public void setProgress(float f, boolean z) {
        if (z) {
            this.c = this.e;
        } else {
            this.e = f;
            this.c = f;
        }
        if (f != 1.0f) {
            this.f = 1.0f;
        }
        this.b = f;
        this.d = 0L;
        this.a = System.currentTimeMillis();
        invalidate();
    }

    public void setProgressColor(int i) {
        this.h = i;
    }
}
