package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class DraftSavedHint extends View {
    private final Paint a;
    private final TextPaint b;
    private final StaticLayout c;
    private final float d;
    private final float e;
    private final Path f;
    private Runnable g;
    private boolean h;
    private final C9151Ys i;

    public DraftSavedHint(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.a = paint;
        TextPaint textPaint = new TextPaint(1);
        this.b = textPaint;
        this.f = new Path();
        C9151Ys c9151Ys = new C9151Ys(this);
        this.i = c9151Ys;
        paint.setColor(-869783512);
        paint.setPathEffect(new CornerPathEffect(AbstractC21455b.F(6.0f)));
        textPaint.setTextSize(AbstractC21455b.F(14.0f));
        textPaint.setColor(-1);
        StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(FH3.E("StoryDraftSaved", TD5.tgwidget_StoryDraftSaved), textPaint, AbstractC21455b.h.x, TextUtils.TruncateAt.END), textPaint, AbstractC21455b.h.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.c = staticLayout;
        this.d = staticLayout.getLineCount() > 0 ? staticLayout.getLineWidth(0) : 0.0f;
        this.e = staticLayout.getLineCount() > 0 ? staticLayout.getLineLeft(0) : 0.0f;
        c9151Ys.d(0.0f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        b(true);
    }

    public void b(boolean z) {
        e(false, z);
    }

    public void d() {
        this.i.d(0.0f, true);
        e(true, true);
        Runnable runnable = this.g;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: ir.nasim.vZ1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        };
        this.g = runnable2;
        AbstractC21455b.n1(runnable2, 3500L);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float fE = this.i.e(this.h);
        if (fE <= 0.0f) {
            return;
        }
        canvas.save();
        canvas.translate(0.0f, (this.h ? InterpolatorC12631ew1.k.getInterpolation(fE) : 1.0f) * AbstractC21455b.F(12.0f));
        float interpolation = InterpolatorC12631ew1.h.getInterpolation(fE);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float F = AbstractC21455b.F(22.0f) + this.d;
        float fMin = (measuredWidth / 2.0f) - Math.min(AbstractC21455b.F(135.0f), 0.35f * measuredWidth);
        float fMax = Math.max(AbstractC21455b.F(8.0f), fMin - (F / 2.0f));
        this.f.rewind();
        this.f.moveTo(fMax, 0.0f);
        float f = F + fMax;
        this.f.lineTo(f, 0.0f);
        this.f.lineTo(f, measuredHeight - AbstractC21455b.F(18.0f));
        this.f.lineTo(AbstractC21455b.F(7.0f) + fMin, measuredHeight - AbstractC21455b.F(18.0f));
        this.f.lineTo(AbstractC21455b.F(1.0f) + fMin, measuredHeight - AbstractC21455b.F(12.0f));
        this.f.lineTo(fMin - AbstractC21455b.F(1.0f), measuredHeight - AbstractC21455b.F(12.0f));
        this.f.lineTo(fMin - AbstractC21455b.F(7.0f), measuredHeight - AbstractC21455b.F(18.0f));
        this.f.lineTo(fMax, measuredHeight - AbstractC21455b.F(18.0f));
        this.f.close();
        this.a.setAlpha((int) (204.0f * interpolation));
        canvas.drawPath(this.f, this.a);
        canvas.save();
        canvas.translate((fMax + AbstractC21455b.F(11.0f)) - this.e, ((measuredHeight - AbstractC21455b.F(18.0f)) - this.c.getHeight()) / 2.0f);
        this.b.setAlpha((int) (interpolation * 255.0f));
        this.c.draw(canvas);
        canvas.restore();
        canvas.restore();
    }

    public void e(boolean z, boolean z2) {
        Runnable runnable;
        if (!z && (runnable = this.g) != null) {
            AbstractC21455b.t(runnable);
            this.g = null;
        }
        this.h = z;
        if (!z2) {
            this.i.f(z, true);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), AbstractC21455b.F(50.0f));
    }
}
