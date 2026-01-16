package ir.nasim.features.media.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import ir.nasim.AbstractC7426Rr;

/* loaded from: classes6.dex */
public class RadialProgressView extends View {
    private long a;
    private float b;
    private float c;
    private boolean d;
    private float e;
    private RectF f;
    private int g;
    private DecelerateInterpolator h;
    private AccelerateInterpolator i;
    private Paint j;
    private final float k;
    private final float l;
    private int m;

    public RadialProgressView(Context context) {
        super(context);
        this.f = new RectF();
        this.k = 2000.0f;
        this.l = 500.0f;
        a();
    }

    private void a() {
        this.m = AbstractC7426Rr.z(40.0f);
        this.g = -11371101;
        this.h = new DecelerateInterpolator();
        this.i = new AccelerateInterpolator();
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.j.setStrokeCap(Paint.Cap.ROUND);
        this.j.setStrokeWidth(AbstractC7426Rr.z(3.0f));
        this.j.setColor(this.g);
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.a;
        if (j > 17) {
            j = 17;
        }
        this.a = jCurrentTimeMillis;
        this.b = (this.b + ((360 * j) / 2000.0f)) - (((int) (r0 / 360.0f)) * 360);
        float f = this.e + j;
        this.e = f;
        if (f >= 500.0f) {
            this.e = 500.0f;
        }
        if (this.d) {
            this.c = (this.i.getInterpolation(this.e / 500.0f) * 266.0f) + 4.0f;
        } else {
            this.c = 4.0f - ((1.0f - this.h.getInterpolation(this.e / 500.0f)) * 270.0f);
        }
        if (this.e == 500.0f) {
            boolean z = this.d;
            if (z) {
                this.b += 270.0f;
                this.c = -266.0f;
            }
            this.d = !z;
            this.e = 0.0f;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f.set((getMeasuredWidth() - this.m) / 2, (getMeasuredHeight() - this.m) / 2, r0 + r2, r1 + r2);
        canvas.drawArc(this.f, this.b, this.c, false, this.j);
        b();
    }

    public void setProgressColor(int i) {
        this.g = i;
        this.j.setColor(i);
    }

    public void setSize(int i) {
        this.m = i;
        invalidate();
    }

    public RadialProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new RectF();
        this.k = 2000.0f;
        this.l = 500.0f;
        a();
    }

    public RadialProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new RectF();
        this.k = 2000.0f;
        this.l = 500.0f;
        a();
    }
}
