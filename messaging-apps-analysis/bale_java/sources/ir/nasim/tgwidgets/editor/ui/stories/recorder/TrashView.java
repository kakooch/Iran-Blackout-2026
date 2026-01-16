package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.AbstractC19363qD5;
import ir.nasim.C5713Kn0;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;
import ir.nasim.tgwidgets.editor.ui.Components.RLottieDrawable;

/* loaded from: classes7.dex */
public class TrashView extends View {
    private final RLottieDrawable a;
    private final AnimatedTextView.a b;
    private final Paint c;
    private final Paint d;
    private final C5713Kn0 e;
    private boolean f;
    private final C9151Ys g;

    public TrashView(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.c = paint;
        Paint paint2 = new Paint(1);
        this.d = paint2;
        this.e = new C5713Kn0(this);
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
        this.g = new C9151Ys(this, 0L, 240L, interpolatorC12631ew1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(AbstractC21455b.H(2.66f));
        paint.setShadowLayer(AbstractC21455b.H(3.0f), 0.0f, AbstractC21455b.F(1.66f), 805306368);
        paint2.setColor(855638016);
        RLottieDrawable rLottieDrawable = new RLottieDrawable(AbstractC19363qD5.group_pip_delete_icon, "" + AbstractC19363qD5.group_pip_delete_icon, AbstractC21455b.F(48.0f), AbstractC21455b.F(48.0f), true, (int[]) null);
        this.a = rLottieDrawable;
        rLottieDrawable.o0(this);
        rLottieDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
        rLottieDrawable.q0(true);
        rLottieDrawable.l0(0);
        rLottieDrawable.b0(true);
        rLottieDrawable.start();
        AnimatedTextView.a aVar = new AnimatedTextView.a(true, true, false);
        this.b = aVar;
        aVar.G(0.3f, 0L, 250L, interpolatorC12631ew1);
        aVar.L(AbstractC21455b.h.x);
        aVar.S(AbstractC21455b.F(14.0f));
        aVar.R(-1);
        aVar.N(AbstractC21455b.H(1.33f), 0.0f, AbstractC21455b.F(1.0f), 1073741824);
        aVar.O(FH3.E("TrashHintDrag", TD5.tgwidget_TrashHintDrag));
        aVar.I(17);
    }

    public void a(boolean z, boolean z2) {
        String str;
        int i;
        this.e.i(z);
        AnimatedTextView.a aVar = this.b;
        if (z || z2) {
            str = "TrashHintRelease";
            i = TD5.tgwidget_TrashHintRelease;
        } else {
            str = "TrashHintDrag";
            i = TD5.tgwidget_TrashHintDrag;
        }
        aVar.O(FH3.E(str, i));
        boolean z3 = z && !z2;
        this.f = z3;
        if (z3) {
            if (this.a.H() > 34) {
                this.a.h0(0, false);
            }
            this.a.l0(33);
            this.a.start();
        } else {
            this.a.l0(z2 ? 66 : 0);
            this.a.start();
        }
        invalidate();
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float F = AbstractC21455b.F(30.0f);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float F2 = (AbstractC21455b.F(3.0f) * this.g.e(this.f)) + F;
        canvas.drawCircle(width, height, F2, this.d);
        canvas.drawCircle(width, height, F2, this.c);
        float F3 = AbstractC21455b.F(48.0f) / 2.0f;
        this.a.setBounds((int) (width - F3), (int) (height - F3), (int) (width + F3), (int) (F3 + height));
        this.a.draw(canvas);
        this.b.setBounds(0, (int) (height + F + AbstractC21455b.F(7.0f)), getWidth(), getHeight());
        this.b.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, AbstractC21455b.F(120.0f));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.b || super.verifyDrawable(drawable);
    }
}
