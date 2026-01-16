package ir.nasim.features.media.components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.C22078ud6;
import ir.nasim.JF5;
import ir.nasim.XY6;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes6.dex */
public class NumberTextView extends View {
    private ArrayList a;
    private ArrayList b;
    private TextPaint c;
    private ObjectAnimator d;
    private float e;
    private int f;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NumberTextView.this.d = null;
            NumberTextView.this.b.clear();
        }
    }

    public NumberTextView(Context context) {
        super(context);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new TextPaint(1);
        this.e = 0.0f;
        this.f = 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.a.isEmpty()) {
            return;
        }
        float height = ((StaticLayout) this.a.get(0)).getHeight();
        canvas.save();
        canvas.translate(getPaddingLeft(), (getMeasuredHeight() - height) / 2.0f);
        int iMax = Math.max(this.a.size(), this.b.size());
        int i = 0;
        while (i < iMax) {
            canvas.save();
            StaticLayout staticLayout = i < this.b.size() ? (StaticLayout) this.b.get(i) : null;
            StaticLayout staticLayout2 = i < this.a.size() ? (StaticLayout) this.a.get(i) : null;
            float f = this.e;
            if (f > 0.0f) {
                if (staticLayout != null) {
                    this.c.setAlpha((int) (f * 255.0f));
                    canvas.save();
                    canvas.translate(0.0f, (this.e - 1.0f) * height);
                    staticLayout.draw(canvas);
                    canvas.restore();
                    if (staticLayout2 != null) {
                        this.c.setAlpha((int) ((1.0f - this.e) * 255.0f));
                        canvas.translate(0.0f, this.e * height);
                    }
                } else {
                    this.c.setAlpha(255);
                }
            } else if (f < 0.0f) {
                if (staticLayout != null) {
                    this.c.setAlpha((int) ((-f) * 255.0f));
                    canvas.save();
                    canvas.translate(0.0f, (this.e + 1.0f) * height);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                if (staticLayout2 != null) {
                    if (i == iMax - 1 || staticLayout != null) {
                        this.c.setAlpha((int) ((this.e + 1.0f) * 255.0f));
                        canvas.translate(0.0f, this.e * height);
                    } else {
                        this.c.setAlpha(255);
                    }
                }
            } else if (staticLayout2 != null) {
                this.c.setAlpha(255);
            }
            if (staticLayout2 != null) {
                staticLayout2.draw(canvas);
            }
            canvas.restore();
            canvas.translate(staticLayout2 != null ? staticLayout2.getLineWidth(0) : staticLayout.getLineWidth(0) + C22078ud6.a(1.0f), 0.0f);
            i++;
        }
        canvas.restore();
    }

    public void setNumber(int i, boolean z) {
        if (this.f == i && z) {
            return;
        }
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.d = null;
        }
        this.b.clear();
        this.b.addAll(this.a);
        this.a.clear();
        Locale locale = Locale.US;
        String str = String.format(locale, "%d", Integer.valueOf(this.f));
        String str2 = String.format(locale, "%d", Integer.valueOf(i));
        boolean z2 = i > this.f;
        this.f = i;
        this.e = 0.0f;
        int i2 = 0;
        while (i2 < str2.length()) {
            int i3 = i2 + 1;
            String strSubstring = str2.substring(i2, i3);
            if (JF5.g()) {
                strSubstring = XY6.e(strSubstring);
            }
            String str3 = strSubstring;
            String strSubstring2 = (this.b.isEmpty() || i2 >= str.length()) ? null : str.substring(i2, i3);
            if (strSubstring2 == null || !strSubstring2.equals(str3)) {
                this.a.add(new StaticLayout(str3, this.c, (int) Math.ceil(r13.measureText(str3)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false));
            } else {
                this.a.add((StaticLayout) this.b.get(i2));
                this.b.set(i2, null);
            }
            i2 = i3;
        }
        if (z && !this.b.isEmpty()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "progress", z2 ? -1.0f : 1.0f, 0.0f);
            this.d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(150L);
            this.d.addListener(new a());
            this.d.start();
        }
        invalidate();
    }

    public void setTextColor(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        this.c.setTextSize(C22078ud6.a(i));
        this.b.clear();
        this.a.clear();
        setNumber(this.f, false);
    }

    public void setTypeface(Typeface typeface) {
        this.c.setTypeface(typeface);
        this.b.clear();
        this.a.clear();
        setNumber(this.f, false);
    }

    public NumberTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new TextPaint(1);
        this.e = 0.0f;
        this.f = 1;
    }

    public NumberTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new TextPaint(1);
        this.e = 0.0f;
        this.f = 1;
    }
}
