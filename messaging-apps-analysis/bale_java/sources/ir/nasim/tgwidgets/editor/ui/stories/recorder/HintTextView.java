package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;

/* loaded from: classes7.dex */
public class HintTextView extends View {
    private final AnimatedTextView.a a;

    public HintTextView(Context context) {
        super(context);
        AnimatedTextView.a aVar = new AnimatedTextView.a(true, true, true);
        this.a = aVar;
        aVar.G(0.35f, 0L, 300L, InterpolatorC12631ew1.h);
        aVar.R(-1);
        aVar.S(AbstractC21455b.F(14.0f));
        aVar.v().setShadowLayer(AbstractC21455b.F(1.4f), 0.0f, AbstractC21455b.F(0.4f), 1275068416);
        aVar.I(1);
        aVar.setCallback(this);
        aVar.L(AbstractC21455b.h.x);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.a.setBounds(0, 0, getWidth(), getHeight());
        this.a.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a.L(getMeasuredWidth());
    }

    public void setText(CharSequence charSequence, boolean z) {
        this.a.P(charSequence, z);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.a || super.verifyDrawable(drawable);
    }
}
