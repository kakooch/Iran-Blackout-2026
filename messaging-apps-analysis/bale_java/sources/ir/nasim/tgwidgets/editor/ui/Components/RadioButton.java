package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
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
        this.i = AbstractC21455b.F(16.0f);
        if (j == null) {
            Paint paint = new Paint(1);
            j = paint;
            paint.setStrokeWidth(AbstractC21455b.F(2.0f));
            j.setStyle(Paint.Style.STROKE);
            l = new Paint(1);
            Paint paint2 = new Paint(1);
            k = paint2;
            paint2.setColor(0);
            k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        try {
            this.a = Bitmap.createBitmap(AbstractC21455b.F(this.i), AbstractC21455b.F(this.i), Bitmap.Config.ARGB_4444);
            this.b = new Canvas(this.a);
        } catch (Throwable th) {
            AbstractC6403Nl2.d(th);
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

    public int getColor() {
        return this.d;
    }

    @Keep
    public float getProgress() {
        return this.e;
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
                this.a = null;
            }
            try {
                this.a = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                this.b = new Canvas(this.a);
            } catch (Throwable th) {
                AbstractC6403Nl2.d(th);
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
            int iRgb = Color.rgb(Color.red(this.d) + ((int) ((Color.red(this.c) - r3) * f3)), Color.green(this.d) + ((int) ((Color.green(this.c) - r7) * f3)), Color.blue(this.d) + ((int) ((Color.blue(this.c) - r9) * f3)));
            j.setColor(iRgb);
            l.setColor(iRgb);
        }
        Bitmap bitmap3 = this.a;
        if (bitmap3 != null) {
            bitmap3.eraseColor(0);
            float f4 = (this.i / 2) - ((f + 1.0f) * AbstractC21455b.g);
            this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, f4, j);
            if (this.e <= 0.5f) {
                this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, f4 - AbstractC21455b.F(1.0f), l);
                this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (f4 - AbstractC21455b.F(1.0f)) * (1.0f - f), k);
            } else {
                this.b.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, (this.i / 4) + (((f4 - AbstractC21455b.F(1.0f)) - (this.i / 4)) * f), l);
            }
            canvas.drawBitmap(this.a, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.d = i;
        invalidate();
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

    public void setCheckedColor(int i) {
        this.c = i;
        invalidate();
    }

    public void setColor(int i, int i2) {
        this.d = i;
        this.c = i2;
        invalidate();
    }

    @Keep
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
