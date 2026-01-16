package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;

/* loaded from: classes7.dex */
public class VideoTimeView extends View {
    private final Paint a;
    private final AnimatedTextView.a b;
    private boolean c;

    public VideoTimeView(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.a = paint;
        this.c = true;
        paint.setColor(RecyclerView.UNDEFINED_DURATION);
        AnimatedTextView.a aVar = new AnimatedTextView.a(false, true, true);
        this.b = aVar;
        aVar.G(0.2f, 0L, 200L, InterpolatorC12631ew1.h);
        aVar.S(AbstractC21455b.F(13.0f));
        aVar.R(-1);
        aVar.T(AbstractC21455b.q0("fonts/rmedium.ttf"));
        aVar.setCallback(this);
        aVar.I(1);
        setTime(0L, false);
    }

    public void a(boolean z, boolean z2) {
        if (z == this.c && z2) {
            return;
        }
        this.c = z;
        animate().cancel();
        if (z2) {
            animate().translationY(z ? 0.0f : AbstractC21455b.F(6.0f)).alpha(z ? 1.0f : 0.0f).scaleX(z ? 1.0f : 0.8f).scaleY(z ? 1.0f : 0.8f).setInterpolator(InterpolatorC12631ew1.h).setDuration(220L).start();
            return;
        }
        setTranslationY(z ? 0.0f : AbstractC21455b.F(6.0f));
        setScaleX(z ? 1.0f : 0.8f);
        setScaleY(z ? 1.0f : 0.8f);
        setAlpha(z ? 1.0f : 0.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fT = this.b.t();
        RectF rectF = AbstractC21455b.x;
        rectF.set(((getWidth() - fT) / 2.0f) - AbstractC21455b.F(6.0f), AbstractC21455b.F(2.0f), ((getWidth() + fT) / 2.0f) + AbstractC21455b.F(6.0f), AbstractC21455b.F(23.0f));
        canvas.drawRoundRect(rectF, AbstractC21455b.F(5.0f), AbstractC21455b.F(5.0f), this.a);
        this.b.setBounds((int) rectF.left, ((int) rectF.top) - AbstractC21455b.F(1.0f), (int) rectF.right, (int) rectF.bottom);
        this.b.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(25.0f), 1073741824));
    }

    public void setTime(long j, boolean z) {
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = j2 - j3;
        long j5 = j4 / 60;
        long j6 = (j4 - (j5 * 60)) / 60;
        StringBuilder sb = new StringBuilder(8);
        if (j6 < 10) {
            sb.append('0');
        }
        sb.append(j6);
        sb.append(':');
        if (j5 < 10) {
            sb.append('0');
        }
        sb.append(j5);
        sb.append(':');
        if (j3 < 10) {
            sb.append('0');
        }
        sb.append(j3);
        if (TextUtils.equals(sb, this.b.w())) {
            return;
        }
        this.b.r();
        this.b.P(sb, z && !FH3.D);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return this.b == drawable || super.verifyDrawable(drawable);
    }
}
