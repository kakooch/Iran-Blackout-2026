package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Keep;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class CheckBox extends View {
    private static Paint r;
    private static Paint s;
    private static Paint t;
    private static Paint u;
    private Drawable a;
    private TextPaint b;
    private Bitmap c;
    private Bitmap d;
    private Canvas e;
    private Canvas f;
    private boolean g;
    private boolean h;
    private float i;
    private ObjectAnimator j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private String q;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator.equals(CheckBox.this.j)) {
                CheckBox.this.j = null;
            }
            if (CheckBox.this.m) {
                return;
            }
            CheckBox.this.q = null;
        }
    }

    public CheckBox(Context context, int i) {
        super(context);
        this.k = true;
        this.n = 22;
        if (r == null) {
            r = new Paint(1);
            Paint paint = new Paint(1);
            s = paint;
            paint.setColor(0);
            Paint paint2 = s;
            PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
            paint2.setXfermode(new PorterDuffXfermode(mode));
            Paint paint3 = new Paint(1);
            t = paint3;
            paint3.setColor(0);
            Paint paint4 = t;
            Paint.Style style = Paint.Style.STROKE;
            paint4.setStyle(style);
            t.setXfermode(new PorterDuffXfermode(mode));
            Paint paint5 = new Paint(1);
            u = paint5;
            paint5.setColor(-1);
            u.setStyle(style);
        }
        t.setStrokeWidth(AbstractC21455b.F(28.0f));
        u.setStrokeWidth(AbstractC21455b.F(2.0f));
        TextPaint textPaint = new TextPaint(1);
        this.b = textPaint;
        textPaint.setTextSize(AbstractC21455b.F(18.0f));
        this.b.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
        this.a = context.getResources().getDrawable(i).mutate();
    }

    private void e(boolean z) {
        this.k = z;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", z ? 1.0f : 0.0f);
        this.j = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new a());
        this.j.setDuration(300L);
        this.j.start();
    }

    private void f() {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.j = null;
        }
    }

    public boolean g() {
        return this.m;
    }

    @Keep
    public float getProgress() {
        return this.i;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0137  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.CheckBox.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.CheckBox");
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(this.m);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.p = i;
        invalidate();
    }

    public void setCheckColor(int i) {
        this.a.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY));
        this.b.setColor(i);
        invalidate();
    }

    public void setCheckOffset(int i) {
        this.o = i;
    }

    public void setChecked(boolean z, boolean z2) {
        setChecked(-1, z, z2);
    }

    public void setColor(int i, int i2) {
        this.p = i;
        this.a.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.MULTIPLY));
        this.b.setColor(i2);
        invalidate();
    }

    public void setDrawBackground(boolean z) {
        this.g = z;
    }

    public void setHasBorder(boolean z) {
        this.h = z;
    }

    public void setNum(int i) {
        if (i >= 0) {
            this.q = "" + (i + 1);
        } else if (this.j == null) {
            this.q = null;
        }
        invalidate();
    }

    @Keep
    public void setProgress(float f) {
        if (this.i == f) {
            return;
        }
        this.i = f;
        invalidate();
    }

    public void setSize(int i) {
        this.n = i;
        if (i == 40) {
            this.b.setTextSize(AbstractC21455b.F(24.0f));
        }
    }

    public void setStrokeWidth(int i) {
        u.setStrokeWidth(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0 && this.c == null) {
            try {
                int iF = AbstractC21455b.F(this.n);
                int iF2 = AbstractC21455b.F(this.n);
                Bitmap.Config config = Bitmap.Config.ARGB_4444;
                this.c = Bitmap.createBitmap(iF, iF2, config);
                this.e = new Canvas(this.c);
                this.d = Bitmap.createBitmap(AbstractC21455b.F(this.n), AbstractC21455b.F(this.n), config);
                this.f = new Canvas(this.d);
            } catch (Throwable unused) {
            }
        }
    }

    public void setChecked(int i, boolean z, boolean z2) {
        if (i >= 0) {
            this.q = "" + (i + 1);
            invalidate();
        }
        if (z == this.m) {
            return;
        }
        this.m = z;
        if (this.l && z2) {
            e(z);
        } else {
            f();
            setProgress(z ? 1.0f : 0.0f);
        }
    }
}
