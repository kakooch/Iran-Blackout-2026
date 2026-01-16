package ir.nasim.tgwidgets.editor.ui.Components;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import ir.nasim.C9151Ys;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;

/* loaded from: classes7.dex */
public class n extends Drawable {
    private AnimatedTextView.a c;
    private boolean d;
    private Paint a = new Paint(1);
    private final Drawable.Callback b = new a();
    private C9151Ys e = new C9151Ys(new Runnable() { // from class: ir.nasim.KL4
        @Override // java.lang.Runnable
        public final void run() {
            this.a.invalidateSelf();
        }
    }, 250, InterpolatorC12631ew1.h);

    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            n.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            n.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            n.this.unscheduleSelf(runnable);
        }
    }

    public n() {
        this.a.setColor(-1);
    }

    public void a(Float f, boolean z) {
        if (f == null && this.c == null) {
            return;
        }
        if (this.c == null) {
            AnimatedTextView.a aVar = new AnimatedTextView.a();
            this.c = aVar;
            aVar.setCallback(this.b);
            this.c.G(0.3f, 0L, 165L, InterpolatorC12631ew1.h);
            this.c.I(1);
            this.c.T(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.c.S(AbstractC21455b.F(7.0f));
            this.c.R(-1);
            this.c.v().setStyle(Paint.Style.FILL_AND_STROKE);
            this.c.v().setStrokeWidth(AbstractC21455b.H(0.1f));
            this.c.v().setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        }
        if (f == null) {
            this.c.r();
            this.c.P("", z);
            this.d = false;
        } else {
            String strA = F.a(f.floatValue());
            if (strA.length() <= 1) {
                strA = strA + TokenNames.X;
            }
            if (!TextUtils.equals(strA, this.c.w())) {
                this.c.r();
                this.c.P(strA, z);
                this.d = !TextUtils.isEmpty(strA);
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds() == null) {
            return;
        }
        int iCenterX = getBounds().centerX();
        int iCenterY = getBounds().centerY();
        float f = iCenterX;
        float f2 = iCenterY;
        canvas.drawCircle(f, f2 - AbstractC21455b.H(6.0f), AbstractC21455b.H(2.0f), this.a);
        canvas.drawCircle(f, f2, AbstractC21455b.H(2.0f), this.a);
        canvas.drawCircle(f, f2 + AbstractC21455b.H(6.0f), AbstractC21455b.H(2.0f), this.a);
        if (this.c != null) {
            canvas.save();
            int iF = iCenterX - AbstractC21455b.F(11.6f);
            int iF2 = iCenterY + AbstractC21455b.F(4.0f);
            float fC = this.e.c(this.d ? 1.0f : 0.0f);
            int alpha = this.a.getAlpha();
            if (fC < 1.0f) {
                this.a.setAlpha((int) (fC * 255.0f));
            }
            RectF rectF = AbstractC21455b.x;
            float f3 = iF;
            float f4 = iF2;
            rectF.set((f3 - AbstractC21455b.H(1.5f)) - (this.c.t() / 2.0f), f4 - AbstractC21455b.H(4.0f), f3 + AbstractC21455b.H(1.5f) + (this.c.t() / 2.0f), f4 + AbstractC21455b.H(5.0f));
            canvas.drawRoundRect(rectF, AbstractC21455b.H(2.0f), AbstractC21455b.H(2.0f), this.a);
            canvas.save();
            this.c.setBounds(iF, iF2, iF, iF2);
            this.c.draw(canvas);
            canvas.restore();
            this.a.setAlpha(alpha);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AbstractC21455b.F(45.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AbstractC21455b.F(45.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
