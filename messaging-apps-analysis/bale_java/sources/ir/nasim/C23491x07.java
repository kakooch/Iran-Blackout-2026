package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* renamed from: ir.nasim.x07, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23491x07 {
    private final View a;
    private StaticLayout b;
    private StaticLayout c;
    private StaticLayout d;
    public boolean e;
    private boolean f;
    private boolean g;
    private float h;
    private float i;
    ValueAnimator j;

    /* renamed from: ir.nasim.x07$a */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C23491x07.this.e = false;
        }
    }

    public C23491x07(View view) {
        this.a = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        this.i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.invalidate();
    }

    public void b() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.e = false;
    }

    public void c(StaticLayout staticLayout, CharSequence charSequence, CharSequence charSequence2, TextPaint textPaint) {
        String string;
        String string2;
        boolean z;
        if (staticLayout == null || charSequence.equals(charSequence2)) {
            return;
        }
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (charSequence.length() > charSequence2.length()) {
            string = charSequence.toString();
            string2 = charSequence2.toString();
            z = true;
        } else {
            string = charSequence2.toString();
            string2 = charSequence.toString();
            z = false;
        }
        int iIndexOf = string.indexOf(string2);
        if (iIndexOf >= 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string);
            if (iIndexOf != 0) {
                spannableStringBuilder2.setSpan(new N72(), 0, iIndexOf, 0);
            }
            if (string2.length() + iIndexOf != string.length()) {
                spannableStringBuilder2.setSpan(new N72(), string2.length() + iIndexOf, string.length(), 0);
            }
            spannableStringBuilder.setSpan(new N72(), iIndexOf, string2.length() + iIndexOf, 0);
            int iF = AbstractC21455b.F(400.0f);
            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
            this.b = new StaticLayout(spannableStringBuilder, textPaint, iF, alignment, 1.0f, 0.0f, false);
            StaticLayout staticLayout2 = new StaticLayout(spannableStringBuilder2, textPaint, AbstractC21455b.F(400.0f), alignment, 1.0f, 0.0f, false);
            this.d = staticLayout2;
            this.e = true;
            this.f = z;
            this.h = iIndexOf == 0 ? 0.0f : -staticLayout2.getPrimaryHorizontal(iIndexOf);
            this.c = null;
            this.g = false;
        } else {
            int iF2 = AbstractC21455b.F(400.0f);
            Layout.Alignment alignment2 = Layout.Alignment.ALIGN_NORMAL;
            this.b = new StaticLayout(charSequence2, textPaint, iF2, alignment2, 1.0f, 0.0f, false);
            this.c = new StaticLayout(charSequence, textPaint, AbstractC21455b.F(400.0f), alignment2, 1.0f, 0.0f, false);
            this.d = null;
            this.e = true;
            this.g = true;
            this.h = 0.0f;
        }
        this.i = 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.j = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.w07
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.e(valueAnimator2);
            }
        });
        this.j.addListener(new a());
        this.j.setDuration(150L);
        this.j.setInterpolator(InterpolatorC12631ew1.f);
        this.j.start();
    }

    public void d(Canvas canvas, TextPaint textPaint) {
        if (this.e) {
            float f = this.h * (this.f ? this.i : 1.0f - this.i);
            int alpha = textPaint.getAlpha();
            if (this.d != null) {
                canvas.save();
                canvas.translate(f, 0.0f);
                this.d.draw(canvas);
                canvas.restore();
            }
            if (this.b != null) {
                float f2 = this.f ? 1.0f - this.i : this.i;
                canvas.save();
                textPaint.setAlpha((int) (alpha * f2));
                canvas.translate(f, 0.0f);
                if (this.g) {
                    float f3 = (f2 * 0.1f) + 0.9f;
                    canvas.scale(f3, f3, f, this.a.getMeasuredHeight() / 2.0f);
                }
                this.b.draw(canvas);
                canvas.restore();
                textPaint.setAlpha(alpha);
            }
            if (this.c != null) {
                float f4 = this.f ? this.i : 1.0f - this.i;
                canvas.save();
                textPaint.setAlpha((int) (alpha * (this.f ? this.i : 1.0f - this.i)));
                canvas.translate(f, 0.0f);
                if (this.g) {
                    float f5 = (f4 * 0.1f) + 0.9f;
                    canvas.scale(f5, f5, f, this.a.getMeasuredHeight() / 2.0f);
                }
                this.c.draw(canvas);
                canvas.restore();
                textPaint.setAlpha(alpha);
            }
        }
    }
}
