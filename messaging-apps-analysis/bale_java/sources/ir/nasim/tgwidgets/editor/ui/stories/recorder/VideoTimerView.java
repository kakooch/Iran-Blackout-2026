package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.C9151Ys;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;

/* loaded from: classes7.dex */
public class VideoTimerView extends View {
    private Paint a;
    private Paint b;
    private AnimatedTextView.a c;
    private boolean d;
    private C9151Ys e;

    public VideoTimerView(Context context) {
        super(context);
        this.a = new Paint(1);
        this.b = new Paint(1);
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
        this.e = new C9151Ys(this, 0L, 250L, interpolatorC12631ew1);
        this.b.setColor(-907224);
        this.a.setColor(1056964608);
        AnimatedTextView.a aVar = new AnimatedTextView.a(false, true, true);
        this.c = aVar;
        aVar.G(0.3f, 0L, 250L, interpolatorC12631ew1);
        this.c.S(AbstractC21455b.F(13.0f));
        this.c.R(-1);
        this.c.T(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.c.setCallback(this);
        this.c.I(1);
        setDuration(0L, false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fC = this.e.c(this.d ? 1.0f : 0.0f);
        float F = AbstractC21455b.F(12.66f) * fC;
        float fT = this.c.t() + F;
        RectF rectF = AbstractC21455b.x;
        rectF.set(((getWidth() - fT) / 2.0f) - AbstractC21455b.F(8.0f), AbstractC21455b.F(18.0f), ((getWidth() + fT) / 2.0f) + AbstractC21455b.F(8.0f), AbstractC21455b.F(40.0f));
        canvas.drawRoundRect(rectF, AbstractC21455b.F(18.0f), AbstractC21455b.F(18.0f), this.a);
        if (fC > 0.0f) {
            this.b.setAlpha((int) (Utilities.c((((float) Math.sin(((System.currentTimeMillis() % 2000) / 1000.0f) * 3.141592653589793d)) / 4.0f) + 0.75f, 1.0f, 0.0f) * 255.0f));
            invalidate();
            canvas.drawCircle(rectF.left + AbstractC21455b.F(10.66f), rectF.centerY(), AbstractC21455b.F(4.0f) * fC, this.b);
        }
        this.c.setBounds((int) (rectF.left + F), ((int) rectF.top) - AbstractC21455b.F(1.0f), (int) rectF.right, (int) rectF.bottom);
        this.c.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(45.0f), 1073741824));
    }

    public void setDuration(long j, boolean z) {
        long j2 = j % 60;
        long j3 = (j - j2) / 60;
        StringBuilder sb = new StringBuilder(5);
        if (j3 < 10) {
            sb.append('0');
        }
        sb.append(j3);
        sb.append(':');
        if (j2 < 10) {
            sb.append('0');
        }
        sb.append(j2);
        this.c.P(sb, z);
    }

    public void setRecording(boolean z, boolean z2) {
        this.d = z;
        if (!z2) {
            this.e.d(z ? 1.0f : 0.0f, true);
        }
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return this.c == drawable || super.verifyDrawable(drawable);
    }
}
