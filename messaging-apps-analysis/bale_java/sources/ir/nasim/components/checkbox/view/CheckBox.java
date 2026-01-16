package ir.nasim.components.checkbox.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;

/* loaded from: classes4.dex */
public class CheckBox extends View {
    private static Paint o;
    private static Paint p;
    private static Paint q;
    private static Paint r;
    private Drawable a;
    private Bitmap b;
    private Bitmap c;
    private Canvas d;
    private Canvas e;
    private boolean f;
    private float g;
    private ObjectAnimator h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;

    public CheckBox(Context context, int i) {
        super(context);
        this.i = true;
        this.l = 22;
        this.n = -10567099;
        if (o == null) {
            o = new Paint(1);
            Paint paint = new Paint(1);
            p = paint;
            paint.setColor(0);
            Paint paint2 = p;
            PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
            paint2.setXfermode(new PorterDuffXfermode(mode));
            Paint paint3 = new Paint(1);
            q = paint3;
            paint3.setColor(0);
            Paint paint4 = q;
            Paint.Style style = Paint.Style.STROKE;
            paint4.setStyle(style);
            q.setStrokeWidth(C22078ud6.a(28.0f));
            q.setXfermode(new PorterDuffXfermode(mode));
            Paint paint5 = new Paint(1);
            r = paint5;
            paint5.setColor(C5495Jo7.a.f0());
            r.setStyle(style);
            r.setStrokeWidth(C22078ud6.a(2.0f));
        }
        this.a = context.getResources().getDrawable(i);
    }

    private void a(boolean z) {
        this.i = z;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", z ? 1.0f : 0.0f);
        this.h = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.h.start();
    }

    private void b() {
        ObjectAnimator objectAnimator = this.h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.components.checkbox.view.CheckBox.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCheckOffset(int i) {
        this.m = i;
    }

    public void setChecked(boolean z, boolean z2) {
        if (z == this.k) {
            return;
        }
        this.k = z;
        if (this.j && z2) {
            a(z);
        } else {
            b();
            setProgress(z ? 1.0f : 0.0f);
        }
    }

    public void setColor(int i) {
        this.n = i;
    }

    public void setDrawBackground(boolean z) {
        this.f = z;
    }

    public void setProgress(float f) {
        if (this.g == f) {
            return;
        }
        this.g = f;
        invalidate();
    }

    public void setSize(int i) {
        this.l = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0 && this.b == null) {
            int iA = C22078ud6.a(this.l);
            int iA2 = C22078ud6.a(this.l);
            Bitmap.Config config = Bitmap.Config.ARGB_4444;
            this.b = Bitmap.createBitmap(iA, iA2, config);
            this.d = new Canvas(this.b);
            this.c = Bitmap.createBitmap(C22078ud6.a(this.l), C22078ud6.a(this.l), config);
            this.e = new Canvas(this.c);
        }
    }
}
