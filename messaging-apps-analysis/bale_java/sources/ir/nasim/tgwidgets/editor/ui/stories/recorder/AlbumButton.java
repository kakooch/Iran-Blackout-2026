package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C13010fZ0;
import ir.nasim.C24687z23;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;

/* loaded from: classes7.dex */
public class AlbumButton extends View {
    private final ImageReceiver a;
    private final CharSequence b;
    private final CharSequence c;
    private final TextPaint d;
    private StaticLayout e;
    private float f;
    private float g;
    private final TextPaint h;
    private StaticLayout i;
    private float j;
    private float k;
    final float l;

    public AlbumButton(Context context, MediaController.m mVar, CharSequence charSequence, int i, m.h hVar) throws InterruptedException {
        String str;
        super(context);
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.a = imageReceiver;
        TextPaint textPaint = new TextPaint(1);
        this.d = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        this.h = textPaint2;
        this.l = 30.0f;
        setPadding(AbstractC21455b.F(16.0f), 0, AbstractC21455b.F(16.0f), 0);
        setBackground(ir.nasim.tgwidgets.editor.ui.ActionBar.m.v0(false));
        setMinimumWidth(AbstractC21455b.F(196.0f));
        setLayoutParams(new LinearLayout.LayoutParams(-1, 48));
        int i2 = ir.nasim.tgwidgets.editor.ui.ActionBar.m.l7;
        textPaint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, hVar));
        textPaint.setTextSize(AbstractC21455b.F(16.0f));
        textPaint2.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i2, hVar));
        textPaint2.setAlpha(102);
        textPaint2.setTextSize(AbstractC21455b.F(13.0f));
        this.b = "" + ((Object) charSequence);
        this.c = "" + i;
        imageReceiver.k1(AbstractC21455b.F(4.0f));
        Drawable drawableMutate = context.getResources().getDrawable(AbstractC23598xB5.msg_media_gallery).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(1308622847, PorterDuff.Mode.MULTIPLY));
        C13010fZ0 c13010fZ0 = new C13010fZ0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(6.0f), -13750737), drawableMutate);
        c13010fZ0.d(false);
        c13010fZ0.e(AbstractC21455b.F(18.0f), AbstractC21455b.F(18.0f));
        if (mVar != null && (str = mVar.b) != null) {
            imageReceiver.R0(C24687z23.g(str), "30.0_30.0", null, null, c13010fZ0, null, 0);
            return;
        }
        if (mVar == null || mVar.A == null) {
            imageReceiver.W0(c13010fZ0);
            return;
        }
        if (mVar.D) {
            imageReceiver.R0(C24687z23.g("vthumb://" + mVar.u + ":" + mVar.A), "30.0_30.0", null, null, c13010fZ0, null, 0);
            return;
        }
        imageReceiver.R0(C24687z23.g("thumb://" + mVar.u + ":" + mVar.A), "30.0_30.0", null, null, c13010fZ0, null, 0);
    }

    private void a(int i) {
        StaticLayout staticLayout = this.e;
        if (staticLayout == null || staticLayout.getWidth() != i) {
            TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.b, this.d, i, truncateAt);
            TextPaint textPaint = this.d;
            int iMax = Math.max(0, i);
            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
            StaticLayout staticLayout2 = new StaticLayout(charSequenceEllipsize, textPaint, iMax, alignment, 1.0f, 0.0f, false);
            this.e = staticLayout2;
            this.g = staticLayout2.getLineCount() > 0 ? this.e.getLineLeft(0) : 0.0f;
            float lineWidth = this.e.getLineCount() > 0 ? this.e.getLineWidth(0) : 0.0f;
            this.f = lineWidth;
            int iF = i - ((int) (lineWidth + AbstractC21455b.F(8.0f)));
            StaticLayout staticLayout3 = new StaticLayout(TextUtils.ellipsize(this.c, this.h, iF, truncateAt), this.h, Math.max(0, iF), alignment, 1.0f, 0.0f, false);
            this.i = staticLayout3;
            this.k = staticLayout3.getLineCount() > 0 ? this.i.getLineLeft(0) : 0.0f;
            this.j = this.i.getLineCount() > 0 ? this.i.getLineWidth(0) : 0.0f;
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float paddingLeft = getPaddingLeft();
        this.a.Y0(paddingLeft, (getMeasuredHeight() - AbstractC21455b.F(30.0f)) / 2.0f, AbstractC21455b.F(30.0f), AbstractC21455b.F(30.0f));
        this.a.e(canvas);
        float F = paddingLeft + AbstractC21455b.F(30.0f) + AbstractC21455b.F(12.0f);
        if (this.e != null) {
            canvas.save();
            canvas.translate(F - this.g, (getMeasuredHeight() - this.e.getHeight()) / 2.0f);
            this.e.draw(canvas);
            F = F + this.f + AbstractC21455b.F(6.0f);
            canvas.restore();
        }
        if (this.i != null) {
            canvas.save();
            canvas.translate(F - this.k, ((getMeasuredHeight() - this.i.getHeight()) / 2.0f) + AbstractC21455b.H(1.6f));
            this.i.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.a.q0();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        this.a.s0();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        a((((View.MeasureSpec.getSize(i) - AbstractC21455b.F(30.0f)) - AbstractC21455b.F(12.0f)) - getPaddingLeft()) - getPaddingRight());
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension((int) Math.min(getPaddingLeft() + AbstractC21455b.F(30.0f) + AbstractC21455b.F(12.0f) + this.f + AbstractC21455b.F(8.0f) + this.j + getPaddingRight(), View.MeasureSpec.getSize(i)), AbstractC21455b.F(48.0f));
        } else if (View.MeasureSpec.getMode(i) == 1073741824) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), AbstractC21455b.F(48.0f));
        }
    }
}
