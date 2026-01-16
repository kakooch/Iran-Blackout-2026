package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;

/* loaded from: classes7.dex */
public class CheckBoxSquare extends View {
    private RectF a;
    private Bitmap b;
    private Canvas c;
    private float d;
    private ObjectAnimator e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private final m.h m;

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

    protected int c(int i) {
        return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.m);
    }

    public boolean d() {
        return this.g;
    }

    @Keep
    public float getProgress() {
        return this.d;
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
        int iC = c(this.j);
        int iC2 = c(this.k);
        float f3 = this.d;
        if (f3 <= 0.5f) {
            f2 = f3 / 0.5f;
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.a0.setColor(Color.rgb(Color.red(iC) + ((int) ((Color.red(iC2) - Color.red(iC)) * f2)), Color.green(iC) + ((int) ((Color.green(iC2) - Color.green(iC)) * f2)), Color.blue(iC) + ((int) ((Color.blue(iC2) - Color.blue(iC)) * f2))));
            f = f2;
        } else {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.a0.setColor(iC2);
            f = 2.0f - (f3 / 0.5f);
            f2 = 1.0f;
        }
        if (this.h) {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.a0.setColor(c(this.i ? ir.nasim.tgwidgets.editor.ui.ActionBar.m.l4 : ir.nasim.tgwidgets.editor.ui.ActionBar.m.I5));
        }
        float F = AbstractC21455b.F(1.0f) * f;
        this.a.set(F, F, AbstractC21455b.F(18.0f) - F, AbstractC21455b.F(18.0f) - F);
        this.b.eraseColor(0);
        this.c.drawRoundRect(this.a, AbstractC21455b.F(2.0f), AbstractC21455b.F(2.0f), ir.nasim.tgwidgets.editor.ui.ActionBar.m.a0);
        if (f2 != 1.0f) {
            float fMin = Math.min(AbstractC21455b.F(7.0f), (AbstractC21455b.F(7.0f) * f2) + F);
            this.a.set(AbstractC21455b.F(2.0f) + fMin, AbstractC21455b.F(2.0f) + fMin, AbstractC21455b.F(16.0f) - fMin, AbstractC21455b.F(16.0f) - fMin);
            this.c.drawRect(this.a, ir.nasim.tgwidgets.editor.ui.ActionBar.m.Y);
        }
        if (this.d > 0.5f) {
            ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z.setColor(c(this.l));
            float f4 = 1.0f - f;
            this.c.drawLine(AbstractC21455b.F(7.0f), (int) AbstractC21455b.H(13.0f), (int) (AbstractC21455b.F(7.0f) - (AbstractC21455b.F(3.0f) * f4)), (int) (AbstractC21455b.H(13.0f) - (AbstractC21455b.F(3.0f) * f4)), ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z);
            this.c.drawLine((int) AbstractC21455b.H(7.0f), (int) AbstractC21455b.H(13.0f), (int) (AbstractC21455b.H(7.0f) + (AbstractC21455b.F(7.0f) * f4)), (int) (AbstractC21455b.H(13.0f) - (AbstractC21455b.F(7.0f) * f4)), ir.nasim.tgwidgets.editor.ui.ActionBar.m.Z);
        }
        canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
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

    public void setColors(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        invalidate();
    }

    public void setDisabled(boolean z) {
        this.h = z;
        invalidate();
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
