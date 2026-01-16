package ir.nasim.features.media.components;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C5495Jo7;

/* loaded from: classes6.dex */
public class CheckBoxSquare extends View {
    private static Paint h;
    private static Paint i;
    private static Paint j;
    private RectF a;
    private Bitmap b;
    private Canvas c;
    private float d;
    private ObjectAnimator e;
    private boolean f;
    private boolean g;

    public CheckBoxSquare(Context context) {
        super(context);
        this.a = new RectF();
        this.b = Bitmap.createBitmap(AbstractC7426Rr.z(18.0f), AbstractC7426Rr.z(18.0f), Bitmap.Config.ARGB_4444);
        this.c = new Canvas(this.b);
    }

    private void a(boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", z ? 1.0f : 0.0f);
        this.e = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(300L);
        this.e.start();
    }

    private void b() {
        ObjectAnimator objectAnimator = this.e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private Paint getBackgroundPaint() {
        if (j == null) {
            j = new Paint(1);
        }
        return j;
    }

    private Paint getCheckPaint() {
        if (h == null) {
            Paint paint = new Paint(1);
            h = paint;
            paint.setStyle(Paint.Style.STROKE);
            h.setStrokeWidth(AbstractC7426Rr.z(2.0f));
        }
        return h;
    }

    private Paint getEraserPaint() {
        if (i == null) {
            Paint paint = new Paint(1);
            i = paint;
            paint.setColor(0);
            i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        return i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        if (getVisibility() != 0) {
            return;
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        int iQ2 = c5495Jo7.q2();
        int iT2 = c5495Jo7.t2();
        Paint backgroundPaint = getBackgroundPaint();
        float f3 = this.d;
        if (f3 <= 0.5f) {
            f = f3 / 0.5f;
            backgroundPaint.setColor(Color.rgb(Color.red(iQ2) + ((int) ((Color.red(iT2) - Color.red(iQ2)) * f)), Color.green(iQ2) + ((int) ((Color.green(iT2) - Color.green(iQ2)) * f)), Color.blue(iQ2) + ((int) ((Color.blue(iT2) - Color.blue(iQ2)) * f))));
            f2 = f;
        } else {
            f = 2.0f - (f3 / 0.5f);
            backgroundPaint.setColor(iT2);
            f2 = 1.0f;
        }
        float fZ = AbstractC7426Rr.z(1.0f) * f;
        this.a.set(fZ, fZ, AbstractC7426Rr.z(18.0f) - fZ, AbstractC7426Rr.z(18.0f) - fZ);
        this.b.eraseColor(0);
        this.c.drawRoundRect(this.a, AbstractC7426Rr.z(2.0f), AbstractC7426Rr.z(2.0f), backgroundPaint);
        if (f2 != 1.0f) {
            float fMin = Math.min(AbstractC7426Rr.z(7.0f), (AbstractC7426Rr.z(7.0f) * f2) + fZ);
            this.a.set(AbstractC7426Rr.z(2.0f) + fMin, AbstractC7426Rr.z(2.0f) + fMin, AbstractC7426Rr.z(16.0f) - fMin, AbstractC7426Rr.z(16.0f) - fMin);
            this.c.drawRect(this.a, getEraserPaint());
        }
        if (this.d > 0.5f) {
            Paint checkPaint = getCheckPaint();
            checkPaint.setColor(c5495Jo7.f0());
            float f4 = 1.0f - f;
            this.c.drawLine(AbstractC7426Rr.z(7.5f), (int) AbstractC7426Rr.A(13.5f), (int) (AbstractC7426Rr.z(7.5f) - (AbstractC7426Rr.z(5.0f) * f4)), (int) (AbstractC7426Rr.A(13.5f) - (AbstractC7426Rr.z(5.0f) * f4)), checkPaint);
            this.c.drawLine((int) AbstractC7426Rr.A(6.5f), (int) AbstractC7426Rr.A(13.5f), (int) (AbstractC7426Rr.A(6.5f) + (AbstractC7426Rr.z(9.0f) * f4)), (int) (AbstractC7426Rr.A(13.5f) - (AbstractC7426Rr.z(9.0f) * f4)), checkPaint);
        }
        canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void setChecked(boolean z, boolean z2) {
        if (z == this.g) {
            return;
        }
        this.g = z;
        if (this.f && z2) {
            a(z);
        } else {
            b();
            setProgress(z ? 1.0f : 0.0f);
        }
    }

    @Keep
    public void setProgress(float f) {
        if (this.d == f) {
            return;
        }
        this.d = f;
        invalidate();
    }
}
