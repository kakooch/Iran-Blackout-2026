package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;

/* loaded from: classes7.dex */
public class MuteButtonHint extends View {
    private final Paint a;
    private final AnimatedTextView.a b;
    private final Path c;
    private Runnable d;
    private boolean e;
    private C9151Ys f;

    public MuteButtonHint(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.a = paint;
        AnimatedTextView.a aVar = new AnimatedTextView.a(false, false, false);
        this.b = aVar;
        this.c = new Path();
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
        this.f = new C9151Ys(this, 0L, 350L, interpolatorC12631ew1);
        paint.setColor(-869783512);
        paint.setPathEffect(new CornerPathEffect(AbstractC21455b.F(6.0f)));
        aVar.C = true;
        aVar.G(0.4f, 0L, 450L, interpolatorC12631ew1);
        aVar.I(5);
        aVar.setCallback(this);
        aVar.S(AbstractC21455b.F(14.0f));
        aVar.R(-1);
        aVar.L(AbstractC21455b.h.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        b(true);
    }

    public void b(boolean z) {
        d(false, z);
    }

    public void d(boolean z, boolean z2) {
        Runnable runnable;
        if (!z && (runnable = this.d) != null) {
            AbstractC21455b.t(runnable);
            this.d = null;
        }
        this.e = z;
        if (!z2) {
            this.f.f(z, true);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float fE = this.f.e(this.e);
        if (fE <= 0.0f) {
            return;
        }
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float F = AbstractC21455b.F(22.0f) + this.b.t();
        float F2 = measuredWidth - AbstractC21455b.F(72.0f);
        this.c.rewind();
        float f = measuredWidth - F;
        this.c.moveTo(f - AbstractC21455b.F(8.0f), AbstractC21455b.F(6.0f));
        this.c.lineTo(f - AbstractC21455b.F(8.0f), measuredHeight);
        this.c.lineTo(measuredWidth - AbstractC21455b.F(8.0f), measuredHeight);
        this.c.lineTo(measuredWidth - AbstractC21455b.F(8.0f), AbstractC21455b.F(6.0f));
        this.c.lineTo(AbstractC21455b.F(7.0f) + F2, AbstractC21455b.F(6.0f));
        this.c.lineTo(AbstractC21455b.F(1.0f) + F2, 0.0f);
        this.c.lineTo(F2 - AbstractC21455b.F(1.0f), 0.0f);
        this.c.lineTo(F2 - AbstractC21455b.F(7.0f), AbstractC21455b.F(6.0f));
        this.c.close();
        this.a.setAlpha((int) (204.0f * fE));
        canvas.drawPath(this.c, this.a);
        this.b.setAlpha((int) (fE * 255.0f));
        Rect rect = AbstractC21455b.y;
        rect.set((int) (f + AbstractC21455b.F(3.0f)), AbstractC21455b.F(13.0f), (int) (measuredWidth - AbstractC21455b.F(19.0f)), (int) (measuredHeight - AbstractC21455b.F(7.0f)));
        canvas.save();
        canvas.clipRect(rect);
        this.b.setBounds(rect);
        this.b.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        this.b.L(size - AbstractC21455b.F(22.0f));
        setMeasuredDimension(size, AbstractC21455b.F(38.0f));
    }

    public void setMuted(boolean z) {
        String str;
        int i;
        AnimatedTextView.a aVar = this.b;
        if (z) {
            str = "StorySoundMuted";
            i = TD5.tgwidget_StorySoundMuted;
        } else {
            str = "StorySoundNotMuted";
            i = TD5.tgwidget_StorySoundNotMuted;
        }
        aVar.P(FH3.E(str, i), !FH3.D && this.e);
        d(true, true);
        Runnable runnable = this.d;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.nasim.nn4
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };
        this.d = runnable2;
        AbstractC21455b.n1(runnable2, 3500L);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.b || super.verifyDrawable(drawable);
    }
}
