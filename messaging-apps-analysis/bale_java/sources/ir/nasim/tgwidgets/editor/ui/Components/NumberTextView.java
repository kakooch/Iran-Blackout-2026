package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import androidx.annotation.Keep;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class NumberTextView extends View {
    private ArrayList a;
    private ArrayList b;
    private TextPaint c;
    private ObjectAnimator d;
    private float e;
    private int f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NumberTextView.this.d = null;
            NumberTextView.this.b.clear();
        }
    }

    public interface b {
    }

    public NumberTextView(Context context) {
        super(context);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new TextPaint(1);
        this.e = 0.0f;
        this.f = 1;
    }

    public float getOldTextWidth() {
        return this.j;
    }

    @Keep
    public float getProgress() {
        return this.e;
    }

    public float getTextWidth() {
        return this.i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float measuredWidth;
        float lineWidth;
        if (this.a.isEmpty()) {
            return;
        }
        float height = ((StaticLayout) this.a.get(0)).getHeight();
        float F = this.g ? AbstractC21455b.F(4.0f) : height;
        if (this.h) {
            measuredWidth = (getMeasuredWidth() - this.i) / 2.0f;
            lineWidth = ((getMeasuredWidth() - this.j) / 2.0f) - measuredWidth;
        } else {
            measuredWidth = 0.0f;
            lineWidth = 0.0f;
        }
        canvas.save();
        canvas.translate(getPaddingLeft() + measuredWidth, (getMeasuredHeight() - height) / 2.0f);
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
                    canvas.translate(lineWidth, (this.e - 1.0f) * F);
                    staticLayout.draw(canvas);
                    canvas.restore();
                    if (staticLayout2 != null) {
                        this.c.setAlpha((int) ((1.0f - this.e) * 255.0f));
                        canvas.translate(0.0f, this.e * F);
                    }
                } else {
                    this.c.setAlpha(255);
                }
            } else if (f < 0.0f) {
                if (staticLayout != null) {
                    this.c.setAlpha((int) ((-f) * 255.0f));
                    canvas.save();
                    canvas.translate(lineWidth, (this.e + 1.0f) * F);
                    staticLayout.draw(canvas);
                    canvas.restore();
                }
                if (staticLayout2 != null) {
                    if (i == iMax - 1 || staticLayout != null) {
                        this.c.setAlpha((int) ((this.e + 1.0f) * 255.0f));
                        canvas.translate(0.0f, this.e * F);
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
            canvas.translate(staticLayout2 != null ? staticLayout2.getLineWidth(0) : staticLayout.getLineWidth(0) + AbstractC21455b.F(1.0f), 0.0f);
            if (staticLayout2 != null && staticLayout != null) {
                lineWidth += staticLayout.getLineWidth(0) - staticLayout2.getLineWidth(0);
            }
            i++;
        }
        canvas.restore();
    }

    public void setAddNumber() {
        this.g = true;
    }

    public void setCenterAlign(boolean z) {
        this.h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e A[PHI: r4 r6
      0x004e: PHI (r4v15 java.lang.String) = (r4v7 java.lang.String), (r4v17 java.lang.String) binds: [B:16:0x0072, B:12:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x004e: PHI (r6v7 java.lang.String) = (r6v4 java.lang.String), (r6v11 java.lang.String) binds: [B:16:0x0072, B:12:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[PHI: r4 r6
      0x0050: PHI (r4v8 java.lang.String) = (r4v7 java.lang.String), (r4v17 java.lang.String) binds: [B:16:0x0072, B:12:0x004c] A[DONT_GENERATE, DONT_INLINE]
      0x0050: PHI (r6v5 java.lang.String) = (r6v4 java.lang.String), (r6v11 java.lang.String) binds: [B:16:0x0072, B:12:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setNumber(int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.NumberTextView.setNumber(int, boolean):void");
    }

    public void setOnTextWidthProgressChangedListener(b bVar) {
    }

    @Keep
    public void setProgress(float f) {
        if (this.e == f) {
            return;
        }
        this.e = f;
        invalidate();
    }

    public void setTextColor(int i) {
        this.c.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        this.c.setTextSize(AbstractC21455b.F(i));
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
}
