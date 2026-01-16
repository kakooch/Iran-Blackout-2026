package ir.nasim.features.smiles.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC22360v62;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C5495Jo7;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.R62;
import ir.nasim.RF6;
import ir.nasim.SA2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class c extends View {
    private final int a;
    private final InterfaceC9173Yu3 b;
    private final InterfaceC9173Yu3 c;
    private final Drawable[] d;
    private String e;
    private int f;
    private int g;
    private final Paint h;
    private final RectF i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.a = C5495Jo7.a.s0();
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.features.smiles.widget.a
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return c.d(this.a);
            }
        });
        this.c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.features.smiles.widget.b
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return c.c(this.a);
            }
        });
        this.d = new Drawable[6];
        this.h = new Paint(1);
        this.i = new RectF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable c(c cVar) {
        AbstractC13042fc3.i(cVar, "this$0");
        Drawable drawableF = AbstractC4043Dl1.f(cVar.getContext(), KB5.stickers_back_arrow);
        AbstractC13042fc3.f(drawableF);
        drawableF.setColorFilter(new PorterDuffColorFilter(cVar.a, PorterDuff.Mode.MULTIPLY));
        return drawableF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable d(c cVar) {
        AbstractC13042fc3.i(cVar, "this$0");
        Drawable drawableF = AbstractC4043Dl1.f(cVar.getContext(), KB5.stickers_back_all);
        AbstractC13042fc3.f(drawableF);
        drawableF.setColorFilter(new PorterDuffColorFilter(cVar.a, PorterDuff.Mode.MULTIPLY));
        return drawableF;
    }

    private final Drawable e() {
        return (Drawable) this.c.getValue();
    }

    private final Drawable f() {
        return (Drawable) this.b.getValue();
    }

    public final int g() {
        return this.g;
    }

    public final void h(String str, int i) {
        String strM;
        AbstractC13042fc3.i(str, "emoji");
        this.e = str;
        this.f = i;
        int length = this.d.length;
        int i2 = 0;
        while (i2 < length) {
            if (i2 != 0) {
                strM = R62.a.m(str, i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "🏿" : "🏾" : "🏽" : "🏼" : "🏻");
            } else {
                strM = str;
            }
            this.d[i2] = R62.a.y(strM);
            i2++;
        }
        invalidate();
    }

    public final void i(int i) {
        if (this.g == i) {
            return;
        }
        this.g = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        Drawable drawableF = f();
        int measuredWidth = getMeasuredWidth();
        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
        float f = 4;
        drawableF.setBounds(0, 0, measuredWidth, aVar.f(AbstractC22360v62.b - f));
        drawableF.draw(canvas);
        Drawable drawableE = e();
        float f2 = (AbstractC22360v62.b - f) - 5.1f;
        drawableE.setBounds(this.f - aVar.f(9.0f), aVar.f(f2), this.f + aVar.f(9.0f), aVar.f(f2 + 8));
        drawableE.draw(canvas);
        float f3 = this.g;
        RF6 rf6 = RF6.a;
        float fE = (rf6.e() * f3) + aVar.f((f3 * 4.0f) + 5.0f);
        float f4 = aVar.f(9.0f);
        this.i.set(fE, f4 - aVar.g(3.5f), rf6.e() + fE, rf6.e() + f4 + aVar.f(3.0f));
        this.h.setColor(C5495Jo7.a.r0());
        float f5 = aVar.f(4.0f);
        canvas.drawRoundRect(this.i, f5, f5, this.h);
        if (this.e != null) {
            int length = this.d.length;
            for (int i = 0; i < length; i++) {
                Drawable drawable = this.d[i];
                if (drawable != null) {
                    RF6 rf62 = RF6.a;
                    float f6 = i;
                    float fE2 = (rf62.e() * f6) + AbstractC7426Rr.a.f((f6 * 4.0f) + 5.0f);
                    float fMin = ((1.0f - (Math.min(0.5f, Math.abs(f6 - f3)) * 2.0f)) * 0.1f) + 0.9f;
                    canvas.save();
                    canvas.scale(fMin, fMin, (rf62.e() / 2.0f) + fE2, (rf62.e() / 2.0f) + f4);
                    drawable.setBounds((int) fE2, (int) f4, (int) (fE2 + rf62.e()), (int) (rf62.e() + f4));
                    drawable.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }
}
