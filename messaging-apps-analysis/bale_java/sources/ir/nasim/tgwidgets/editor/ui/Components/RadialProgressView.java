package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Keep;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;

/* loaded from: classes7.dex */
public class RadialProgressView extends View {
    private long a;
    private float b;
    private float c;
    private boolean d;
    private float e;
    private RectF f;
    private boolean g;
    private float h;
    private int i;
    private DecelerateInterpolator j;
    private AccelerateInterpolator k;
    private Paint l;
    private int m;
    private float n;
    private float o;
    private int p;
    private float q;
    private boolean r;
    private float s;
    private boolean t;
    private final m.h u;

    public RadialProgressView(Context context) {
        this(context, null);
    }

    private int a(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.u);
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.a;
        if (j > 17) {
            j = 17;
        }
        this.a = jCurrentTimeMillis;
        c(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(long r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.RadialProgressView.c(long):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f.set((getMeasuredWidth() - this.m) / 2, (getMeasuredHeight() - this.m) / 2, r0 + r2, r1 + r2);
        RectF rectF = this.f;
        float f = this.b;
        float f2 = this.c;
        this.h = f2;
        canvas.drawArc(rectF, f, f2, false, this.l);
        b();
    }

    @Override // android.view.View
    @Keep
    public void setAlpha(float f) {
        super.setAlpha(f);
        if (this.g) {
            Drawable background = getBackground();
            int i = (int) (f * 255.0f);
            if (background != null) {
                background.setAlpha(i);
            }
            this.l.setAlpha(i);
        }
    }

    public void setNoProgress(boolean z) {
        this.t = z;
    }

    public void setProgress(float f) {
        this.n = f;
        if (this.q > f) {
            this.q = f;
        }
        this.o = this.q;
        this.p = 0;
    }

    public void setProgressColor(int i) {
        this.i = i;
        this.l.setColor(i);
    }

    public void setSize(int i) {
        this.m = i;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.l.setStrokeWidth(AbstractC21455b.F(f));
    }

    public void setUseSelfAlpha(boolean z) {
        this.g = z;
    }

    public RadialProgressView(Context context, m.h hVar) {
        super(context);
        this.f = new RectF();
        this.t = true;
        this.u = hVar;
        this.m = AbstractC21455b.F(40.0f);
        this.i = a(ir.nasim.tgwidgets.editor.ui.ActionBar.m.R4);
        this.j = new DecelerateInterpolator();
        this.k = new AccelerateInterpolator();
        Paint paint = new Paint(1);
        this.l = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.l.setStrokeCap(Paint.Cap.ROUND);
        this.l.setStrokeWidth(AbstractC21455b.F(3.0f));
        this.l.setColor(this.i);
    }
}
