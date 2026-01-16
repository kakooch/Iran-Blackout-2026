package ir.nasim.components.radiobutton.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import ir.nasim.C19406qI3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;

/* loaded from: classes4.dex */
public class RadioButton extends View {
    private static Paint j;
    private static Paint k;
    private static Paint l;
    private Bitmap a;
    private Canvas b;
    private int c;
    private int d;
    private float e;
    private ObjectAnimator f;
    private boolean g;
    private boolean h;
    private int i;

    public RadioButton(Context context) {
        super(context);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        this.c = c5495Jo7.t2();
        this.d = c5495Jo7.t2();
        this.i = C22078ud6.a(16.0f);
        if (j == null) {
            Paint paint = new Paint(1);
            j = paint;
            paint.setStrokeWidth(C22078ud6.a(2.0f));
            j.setStyle(Paint.Style.STROKE);
            l = new Paint(1);
            Paint paint2 = new Paint(1);
            k = paint2;
            paint2.setColor(0);
            k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        try {
            this.a = Bitmap.createBitmap(C22078ud6.a(this.i), C22078ud6.a(this.i), Bitmap.Config.ARGB_4444);
            this.b = new Canvas(this.a);
        } catch (Throwable th) {
            C19406qI3.d("baleMessages", th);
        }
    }

    private void a(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", z ? 1.0f : 0.0f);
        this.f = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
        this.f.start();
    }

    private void b() {
        ObjectAnimator objectAnimator = this.f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.g = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        Bitmap bitmap = this.a;
        if (bitmap == null || bitmap.getWidth() != getMeasuredWidth()) {
            Bitmap bitmap2 = this.a;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            try {
                this.a = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                this.b = new Canvas(this.a);
            } catch (Throwable th) {
                C19406qI3.d("baleMessages", th);
            }
        }
        float f2 = this.e;
        if (f2 <= 0.5f) {
            j.setColor(this.d);
            l.setColor(this.d);
            f = this.e / 0.5f;
        } else {
            f = 2.0f - (f2 / 0.5f);
            float f3 = 1.0f - f;
            int iRgb = Color.rgb(Color.red(this.d) + ((int) ((Color.red(this.c) - r2) * f3)), Color.green(this.d) + ((int) ((Color.green(this.c) - r6) * f3)), Color.blue(this.d) + ((int) ((Color.blue(this.c) - r8) * f3)));
            j.setColor(iRgb);
            l.setColor(iRgb);
        }
        Bitmap bitmap3 = this.a;
        if (bitmap3 != null) {
            bitmap3.eraseColor(0);
            float f4 = (this.i / 2) - ((f + 1.0f) * getContext().getResources().getDisplayMetrics().density);
            this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, f4, j);
            if (this.e <= 0.5f) {
                this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, f4 - C22078ud6.a(1.0f), l);
                this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (f4 - C22078ud6.a(1.0f)) * (1.0f - f), k);
            } else {
                this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (this.i / 4) + (((f4 - C22078ud6.a(1.0f)) - (this.i / 4)) * f), l);
            }
            canvas.drawBitmap(this.a, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (z == this.h) {
            return;
        }
        this.h = z;
        if (this.g && z2) {
            a(z);
        } else {
            b();
            setProgress(z ? 1.0f : 0.0f);
        }
    }

    public void setColor(int i, int i2) {
        this.d = i;
        this.c = i2;
        invalidate();
    }

    public void setProgress(float f) {
        if (this.e == f) {
            return;
        }
        this.e = f;
        invalidate();
    }

    public void setSize(int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
    }
}
