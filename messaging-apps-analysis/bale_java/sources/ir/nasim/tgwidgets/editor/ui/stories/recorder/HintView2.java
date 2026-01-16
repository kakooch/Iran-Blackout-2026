package ir.nasim.tgwidgets.editor.ui.stories.recorder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.C17561nA3;
import ir.nasim.C5713Kn0;
import ir.nasim.C9151Ys;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView;
import ir.nasim.tgwidgets.editor.ui.Components.LinkSpanDrawable;

/* loaded from: classes7.dex */
public class HintView2 extends View {
    private float A;
    private ValueAnimator A0;
    private boolean B;
    private float B0;
    private final C5713Kn0 C0;
    private boolean D;
    private float D0;
    private float E0;
    private final RectF F0;
    private boolean G;
    private final Path G0;
    private C9151Ys H;
    private float H0;
    private float I0;
    private Runnable J;
    private float J0;
    private float K0;
    private boolean L0;
    private boolean M0;
    private LinkSpanDrawable N0;
    private int a;
    private float b;
    private float c;
    private long d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private Drawable i;
    private boolean j;
    private float k;
    private final RectF l;
    private float m;
    private float n;
    private float o;
    private final Paint p;
    private CharSequence q;
    private AnimatedTextView.a r;
    private boolean s;
    private final TextPaint t;
    private Layout.Alignment u;
    private StaticLayout v;
    private float w;
    private float x;
    private LinkSpanDrawable.a y;
    private float z;
    private final Runnable z0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HintView2.this.B0 = 1.0f;
            HintView2.this.invalidate();
        }
    }

    public HintView2(Context context, int i) {
        super(context);
        this.b = 0.5f;
        this.c = 0.0f;
        this.d = 3500L;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = -1;
        this.k = AbstractC21455b.F(8.0f);
        this.l = new RectF(AbstractC21455b.F(11.0f), AbstractC21455b.F(6.0f), AbstractC21455b.F(11.0f), AbstractC21455b.F(7.0f));
        this.m = AbstractC21455b.F(2.0f);
        this.n = AbstractC21455b.F(7.0f);
        this.o = AbstractC21455b.F(6.0f);
        Paint paint = new Paint(1);
        this.p = paint;
        this.t = new TextPaint(1);
        this.u = Layout.Alignment.ALIGN_NORMAL;
        this.y = new LinkSpanDrawable.a();
        this.B = true;
        this.D = true;
        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.h;
        this.H = new C9151Ys(this, 350L, interpolatorC12631ew1);
        this.z0 = new Runnable() { // from class: ir.nasim.lY2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        };
        this.B0 = 1.0f;
        this.C0 = new C5713Kn0(this, 2.0f);
        this.F0 = new RectF();
        this.G0 = new Path();
        this.M0 = true;
        this.a = i;
        paint.setColor(-869783512);
        paint.setPathEffect(new CornerPathEffect(this.k));
        AnimatedTextView.a aVar = new AnimatedTextView.a(true, true, false);
        this.r = aVar;
        aVar.G(0.4f, 0L, 320L, interpolatorC12631ew1);
        this.r.setCallback(this);
        F(14);
        E(-1);
    }

    private void d() {
        if (this.D) {
            ValueAnimator valueAnimator = this.A0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.A0 = null;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.A0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.kY2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.a.n(valueAnimator2);
                }
            });
            this.A0.addListener(new a());
            this.A0.setInterpolator(InterpolatorC12631ew1.k);
            this.A0.setDuration(300L);
            this.A0.start();
        }
    }

    private boolean e(MotionEvent motionEvent) {
        if (this.v != null) {
            final ClickableSpan clickableSpanM = m((int) motionEvent.getX(), (int) motionEvent.getY());
            if (clickableSpanM != null && motionEvent.getAction() == 0) {
                final LinkSpanDrawable linkSpanDrawable = new LinkSpanDrawable(clickableSpanM, null, motionEvent.getX(), motionEvent.getY());
                this.N0 = linkSpanDrawable;
                this.y.c(linkSpanDrawable);
                SpannableString spannableString = new SpannableString(this.v.getText());
                int spanStart = spannableString.getSpanStart(this.N0.c());
                int spanEnd = spannableString.getSpanEnd(this.N0.c());
                C17561nA3 c17561nA3D = this.N0.d();
                c17561nA3D.c(this.v, spanStart, 0.0f);
                this.v.getSelectionPath(spanStart, spanEnd, c17561nA3D);
                invalidate();
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.jY2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.o(linkSpanDrawable, clickableSpanM);
                    }
                }, ViewConfiguration.getLongPressTimeout());
                q();
                return true;
            }
            if (motionEvent.getAction() == 1) {
                this.y.e();
                invalidate();
                I();
                LinkSpanDrawable linkSpanDrawable2 = this.N0;
                if (linkSpanDrawable2 != null && linkSpanDrawable2.c() == clickableSpanM) {
                    if (this.N0.c() != null) {
                        ((ClickableSpan) this.N0.c()).onClick(this);
                    }
                    this.N0 = null;
                    return true;
                }
                this.N0 = null;
            }
            if (motionEvent.getAction() == 3) {
                this.y.e();
                invalidate();
                I();
                this.N0 = null;
            }
        }
        return this.N0 != null;
    }

    private boolean f(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() == 0 && h(motionEvent, 0.0f, 0.0f)) {
            this.D0 = x;
            this.E0 = y;
            this.C0.i(true);
            return true;
        }
        if (motionEvent.getAction() == 1) {
            k();
            this.C0.i(false);
            return true;
        }
        if (motionEvent.getAction() != 3) {
            return false;
        }
        this.C0.i(false);
        return true;
    }

    private static boolean g(CharSequence charSequence, char c) {
        if (charSequence == null) {
            return false;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private int getTextMaxWidth() {
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        RectF rectF = this.l;
        int iMin = measuredWidth - ((int) (rectF.left + rectF.right));
        int i = this.h;
        if (i > 0) {
            iMin = Math.min(i, iMin);
        }
        return Math.max(0, iMin);
    }

    public static int i(CharSequence charSequence, TextPaint textPaint) {
        double dCeil;
        if (charSequence == null) {
            return 0;
        }
        float fJ = j(charSequence, textPaint);
        int length = charSequence.toString().length();
        int i = length / 2;
        if (length <= 0 || g(charSequence, '\n')) {
            dCeil = Math.ceil(fJ);
        } else {
            int i2 = i - 1;
            int i3 = i + 1;
            while (true) {
                if (i2 < 0 || i3 >= length) {
                    break;
                }
                if (charSequence.charAt(i2) == ' ') {
                    i = i2;
                    break;
                }
                if (charSequence.charAt(i3) == ' ') {
                    i = i3;
                    break;
                }
                i2--;
                i3++;
            }
            dCeil = Math.ceil(Math.max(0.3f * fJ, (Math.max(i + 0.5f, (length - i) + 0.5f) / length) * fJ));
        }
        return (int) dCeil;
    }

    private static int j(CharSequence charSequence, TextPaint textPaint) {
        if (!(charSequence instanceof Spannable)) {
            return (int) textPaint.measureText(charSequence.toString());
        }
        if (new StaticLayout(charSequence, textPaint, 99999, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() > 0) {
            return (int) Math.ceil(r0.getLineWidth(0));
        }
        return 0;
    }

    private ClickableSpan m(int i, int i2) {
        StaticLayout staticLayout = this.v;
        if (staticLayout == null) {
            return null;
        }
        int i3 = (int) (i - this.z);
        int i4 = (int) (i2 - this.A);
        int lineForVertical = staticLayout.getLineForVertical(i4);
        float f = i3;
        int offsetForHorizontal = this.v.getOffsetForHorizontal(lineForVertical, f);
        float lineLeft = this.v.getLineLeft(lineForVertical);
        if (lineLeft <= f && lineLeft + this.v.getLineWidth(lineForVertical) >= f && i4 >= 0 && i4 <= this.v.getHeight()) {
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) new SpannableString(this.v.getText()).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0 && !AbstractC21455b.v0()) {
                return clickableSpanArr[0];
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.B0 = Math.max(1.0f, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(LinkSpanDrawable linkSpanDrawable, ClickableSpan clickableSpan) {
    }

    private void p(CharSequence charSequence, int i) {
        this.v = new StaticLayout(charSequence, this.t, i, this.u, 1.0f, 0.0f, false);
        float fMin = i;
        float fMax = 0.0f;
        for (int i2 = 0; i2 < this.v.getLineCount(); i2++) {
            fMin = Math.min(fMin, this.v.getLineLeft(i2));
            fMax = Math.max(fMax, this.v.getLineRight(i2));
        }
        this.x = Math.max(0.0f, fMax - fMin);
        this.w = fMin;
    }

    private void r(float f, float f2) {
        float fC;
        int i = this.a;
        if (i == 1 || i == 3) {
            float fC2 = Utilities.c(AbstractC21455b.U0(getPaddingLeft(), getMeasuredWidth() - getPaddingRight(), this.b) + this.c, getMeasuredWidth() - getPaddingRight(), getPaddingLeft());
            float fMin = Math.min(Math.max(getPaddingLeft(), fC2 - (f / 2.0f)) + f, getMeasuredWidth() - getPaddingRight());
            float f3 = fMin - f;
            float f4 = this.k;
            float f5 = this.n;
            fC = Utilities.c(fC2, (fMin - f4) - f5, f4 + f3 + f5);
            if (this.a == 1) {
                this.F0.set(f3, getPaddingTop() + this.o, fMin, getPaddingTop() + this.o + f2);
            } else {
                this.F0.set(f3, ((getMeasuredHeight() - this.o) - getPaddingBottom()) - f2, fMin, (getMeasuredHeight() - this.o) - getPaddingBottom());
            }
        } else {
            float fC3 = Utilities.c(AbstractC21455b.U0(getPaddingTop(), getMeasuredHeight() - getPaddingBottom(), this.b) + this.c, getMeasuredHeight() - getPaddingBottom(), getPaddingTop());
            float fMin2 = Math.min(Math.max(getPaddingTop(), fC3 - (f2 / 2.0f)) + f2, getMeasuredHeight() - getPaddingBottom());
            float f6 = fMin2 - f2;
            float f7 = this.k;
            float f8 = this.n;
            fC = Utilities.c(fC3, (fMin2 - f7) - f8, f7 + f6 + f8);
            if (this.a == 0) {
                this.F0.set(getPaddingLeft() + this.o, f6, getPaddingLeft() + this.o + f, fMin2);
            } else {
                this.F0.set(((getMeasuredWidth() - getPaddingRight()) - this.o) - f, f6, (getMeasuredWidth() - getPaddingRight()) - this.o, fMin2);
            }
        }
        this.G0.rewind();
        Path path = this.G0;
        RectF rectF = this.F0;
        path.moveTo(rectF.left, rectF.bottom);
        if (this.a == 0) {
            this.G0.lineTo(this.F0.left, this.n + fC + AbstractC21455b.F(2.0f));
            this.G0.lineTo(this.F0.left, this.n + fC);
            this.G0.lineTo(this.F0.left - this.o, AbstractC21455b.F(1.0f) + fC);
            float f9 = this.F0.left;
            float f10 = this.o;
            this.H0 = f9 - f10;
            this.I0 = fC;
            this.G0.lineTo(f9 - f10, fC - AbstractC21455b.F(1.0f));
            this.G0.lineTo(this.F0.left, fC - this.n);
            this.G0.lineTo(this.F0.left, (fC - this.n) - AbstractC21455b.F(2.0f));
        }
        Path path2 = this.G0;
        RectF rectF2 = this.F0;
        path2.lineTo(rectF2.left, rectF2.top);
        if (this.a == 1) {
            this.G0.lineTo((fC - this.n) - AbstractC21455b.F(2.0f), this.F0.top);
            this.G0.lineTo(fC - this.n, this.F0.top);
            this.G0.lineTo(fC - AbstractC21455b.F(1.0f), this.F0.top - this.o);
            this.H0 = fC;
            this.I0 = this.F0.top - this.o;
            this.G0.lineTo(AbstractC21455b.F(1.0f) + fC, this.F0.top - this.o);
            this.G0.lineTo(this.n + fC, this.F0.top);
            this.G0.lineTo(this.n + fC + AbstractC21455b.F(2.0f), this.F0.top);
        }
        Path path3 = this.G0;
        RectF rectF3 = this.F0;
        path3.lineTo(rectF3.right, rectF3.top);
        if (this.a == 2) {
            this.G0.lineTo(this.F0.right, (fC - this.n) - AbstractC21455b.F(2.0f));
            this.G0.lineTo(this.F0.right, fC - this.n);
            this.G0.lineTo(this.F0.right + this.o, fC - AbstractC21455b.F(1.0f));
            float f11 = this.F0.right;
            float f12 = this.o;
            this.H0 = f11 + f12;
            this.I0 = fC;
            this.G0.lineTo(f11 + f12, AbstractC21455b.F(1.0f) + fC);
            this.G0.lineTo(this.F0.right, this.n + fC);
            this.G0.lineTo(this.F0.right, this.n + fC + AbstractC21455b.F(2.0f));
        }
        Path path4 = this.G0;
        RectF rectF4 = this.F0;
        path4.lineTo(rectF4.right, rectF4.bottom);
        if (this.a == 3) {
            this.G0.lineTo(this.n + fC + AbstractC21455b.F(2.0f), this.F0.bottom);
            this.G0.lineTo(this.n + fC, this.F0.bottom);
            this.G0.lineTo(AbstractC21455b.F(1.0f) + fC, this.F0.bottom + this.o);
            this.H0 = fC;
            this.I0 = this.F0.bottom + this.o;
            this.G0.lineTo(fC - AbstractC21455b.F(1.0f), this.F0.bottom + this.o);
            this.G0.lineTo(fC - this.n, this.F0.bottom);
            this.G0.lineTo((fC - this.n) - AbstractC21455b.F(2.0f), this.F0.bottom);
        }
        this.G0.close();
        this.L0 = true;
    }

    public HintView2 A(Runnable runnable) {
        this.J = runnable;
        return this;
    }

    public HintView2 B(CharSequence charSequence) {
        if (getMeasuredWidth() < 0) {
            this.q = charSequence;
        } else if (this.s) {
            p(charSequence, getTextMaxWidth());
        } else {
            this.r.P(charSequence, false);
        }
        return this;
    }

    public HintView2 C(CharSequence charSequence, boolean z) {
        if (getMeasuredWidth() < 0) {
            this.q = charSequence;
        } else {
            this.r.P(charSequence, !FH3.D && z);
        }
        return this;
    }

    public HintView2 D(Layout.Alignment alignment) {
        this.u = alignment;
        return this;
    }

    public HintView2 E(int i) {
        this.r.R(i);
        this.t.setColor(i);
        return this;
    }

    public HintView2 F(int i) {
        float f = i;
        this.r.S(AbstractC21455b.F(f));
        this.t.setTextSize(AbstractC21455b.F(f));
        return this;
    }

    public HintView2 G() {
        if (this.G) {
            d();
        }
        this.G = true;
        invalidate();
        AbstractC21455b.t(this.z0);
        long j = this.d;
        if (j > 0) {
            AbstractC21455b.n1(this.z0, j);
        }
        Runnable runnable = this.J;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
        }
        return this;
    }

    public boolean H() {
        return this.G;
    }

    public void I() {
        AbstractC21455b.t(this.z0);
        long j = this.d;
        if (j > 0) {
            AbstractC21455b.n1(this.z0, j);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        float fU;
        if (this.s && this.v == null) {
            return;
        }
        float fE = this.H.e(this.G && !this.M0);
        if (this.M0) {
            this.M0 = false;
            invalidate();
        }
        if (fE <= 0.0f) {
            return;
        }
        float fT = this.s ? this.x : this.r.t();
        if (this.s) {
            StaticLayout staticLayout = this.v;
            fU = staticLayout != null ? staticLayout.getHeight() : 0;
        } else {
            fU = this.r.u();
        }
        if (this.j) {
            if (this.i == null) {
                Drawable drawableMutate = getContext().getResources().getDrawable(AbstractC23598xB5.msg_mini_close_tooltip).mutate();
                this.i = drawableMutate;
                drawableMutate.setColorFilter(new PorterDuffColorFilter(2113929215, PorterDuff.Mode.MULTIPLY));
            }
            fT += this.m + this.i.getIntrinsicWidth();
            fU = Math.max(this.i.getIntrinsicHeight(), fU);
        }
        RectF rectF = this.l;
        float f = rectF.left + fT + rectF.right;
        float f2 = rectF.top + fU + rectF.bottom;
        if (!this.L0 || Math.abs(f - this.J0) > 0.1f || Math.abs(f2 - this.K0) > 0.1f) {
            this.J0 = f;
            this.K0 = f2;
            r(f, f2);
        }
        float f3 = this.g ? fE : 1.0f;
        canvas.save();
        if (fE < 1.0f && this.e) {
            float fT0 = AbstractC21455b.T0(0.5f, 1.0f, fE);
            canvas.scale(fT0, fT0, this.H0, this.I0);
        }
        float fE2 = this.C0.e(0.025f);
        if (fE2 != 1.0f) {
            canvas.scale(fE2, fE2, this.H0, this.I0);
        }
        if (this.B0 != 1.0f) {
            int i = this.a;
            if (i == 3 || i == 1) {
                canvas.translate(0.0f, (this.B0 - 1.0f) * Math.max(i == 3 ? getPaddingBottom() : getPaddingTop(), AbstractC21455b.F(24.0f)) * (this.a == 1 ? -1 : 1));
            } else {
                canvas.translate((this.B0 - 1.0f) * Math.max(i == 0 ? getPaddingLeft() : getPaddingRight(), AbstractC21455b.F(24.0f)) * (this.a == 0 ? -1 : 1), 0.0f);
            }
        }
        int alpha = this.p.getAlpha();
        this.p.setAlpha((int) (alpha * f3));
        canvas.drawPath(this.G0, this.p);
        this.p.setAlpha(alpha);
        if (this.s) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), Math.max(getHeight(), f2), (int) (f3 * 255.0f), 31);
            RectF rectF2 = this.F0;
            float f4 = rectF2.left;
            RectF rectF3 = this.l;
            float f5 = (f4 + rectF3.left) - this.w;
            this.z = f5;
            float f6 = rectF2.top + rectF3.top;
            this.A = f6;
            canvas.translate(f5, f6);
            if (this.y.g(canvas)) {
                invalidate();
            }
            this.v.draw(canvas);
            canvas.restore();
        } else {
            CharSequence charSequence = this.q;
            if (charSequence != null) {
                this.r.P(charSequence, this.G);
                this.q = null;
            }
            AnimatedTextView.a aVar = this.r;
            RectF rectF4 = this.F0;
            float f7 = rectF4.left;
            RectF rectF5 = this.l;
            float f8 = rectF5.left;
            aVar.setBounds((int) (f7 + f8), (int) (rectF4.top + rectF5.top), (int) (f7 + f8 + fT), (int) (rectF4.bottom - rectF5.bottom));
            this.r.setAlpha((int) (f3 * 255.0f));
            this.r.draw(canvas);
        }
        if (this.j) {
            if (this.i == null) {
                Drawable drawableMutate2 = getContext().getResources().getDrawable(AbstractC23598xB5.msg_mini_close_tooltip).mutate();
                this.i = drawableMutate2;
                drawableMutate2.setColorFilter(new PorterDuffColorFilter(2113929215, PorterDuff.Mode.MULTIPLY));
            }
            this.i.setAlpha((int) (f3 * 255.0f));
            Drawable drawable = this.i;
            int intrinsicWidth = (int) ((this.F0.right - (this.l.right * 0.66f)) - drawable.getIntrinsicWidth());
            int iCenterY = (int) (this.F0.centerY() - (this.i.getIntrinsicHeight() / 2.0f));
            RectF rectF6 = this.F0;
            drawable.setBounds(intrinsicWidth, iCenterY, (int) (rectF6.right - (this.l.right * 0.66f)), (int) (rectF6.centerY() + (this.i.getIntrinsicHeight() / 2.0f)));
            this.i.draw(canvas);
        }
        canvas.restore();
    }

    public CharSequence getText() {
        CharSequence charSequence = this.q;
        if (charSequence != null) {
            return charSequence;
        }
        if (!this.s) {
            return this.r.w();
        }
        StaticLayout staticLayout = this.v;
        if (staticLayout != null) {
            return staticLayout.getText();
        }
        return null;
    }

    public TextPaint getTextPaint() {
        return this.s ? this.t : this.r.v();
    }

    public boolean h(MotionEvent motionEvent, float f, float f2) {
        return this.F0.contains(motionEvent.getX() - f, motionEvent.getY() - f2);
    }

    public void k() {
        l(true);
    }

    public void l(boolean z) {
        AbstractC21455b.t(this.z0);
        Runnable runnable = this.J;
        if (runnable != null) {
            AbstractC21455b.t(runnable);
        }
        this.G = false;
        if (!z) {
            this.H.f(false, false);
        }
        invalidate();
        Runnable runnable2 = this.J;
        if (runnable2 != null) {
            AbstractC21455b.n1(runnable2, (long) (this.H.a() * this.H.b()));
        }
        this.y.e();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.L0 = false;
        int textMaxWidth = getTextMaxWidth();
        this.r.L(textMaxWidth);
        if (this.s) {
            CharSequence text = this.q;
            if (text == null) {
                StaticLayout staticLayout = this.v;
                if (staticLayout == null) {
                    return;
                } else {
                    text = staticLayout.getText();
                }
            }
            StaticLayout staticLayout2 = this.v;
            if (staticLayout2 == null || staticLayout2.getWidth() != textMaxWidth) {
                p(text, textMaxWidth);
            }
        } else {
            CharSequence charSequence = this.q;
            if (charSequence != null) {
                this.r.P(charSequence, false);
            }
        }
        this.q = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.B && this.G && (e(motionEvent) || f(motionEvent));
    }

    public void q() {
        AbstractC21455b.t(this.z0);
    }

    public HintView2 s(boolean z, boolean z2, boolean z3) {
        this.r.J(z, z2, z3);
        return this;
    }

    public HintView2 t(boolean z) {
        this.D = z;
        return this;
    }

    public HintView2 u(boolean z) {
        this.j = z;
        if (!this.s) {
            this.l.set(AbstractC21455b.F(11.0f), AbstractC21455b.F(6.0f), AbstractC21455b.F(this.j ? 15.0f : 11.0f), AbstractC21455b.F(7.0f));
        }
        return this;
    }

    public HintView2 v(long j) {
        this.d = j;
        return this;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.r || super.verifyDrawable(drawable);
    }

    public HintView2 w(float f, float f2) {
        if (Math.abs(this.b - f) >= 1.0f || Math.abs(this.c - AbstractC21455b.F(f2)) >= 1.0f) {
            this.L0 = false;
            invalidate();
        }
        this.b = f;
        this.c = AbstractC21455b.F(f2);
        return this;
    }

    public HintView2 x(float f) {
        this.h = AbstractC21455b.F(f);
        return this;
    }

    public HintView2 y(int i) {
        this.h = i;
        return this;
    }

    public HintView2 z(boolean z) {
        this.s = z;
        if (z) {
            this.l.set(AbstractC21455b.F(15.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(15.0f), AbstractC21455b.F(8.0f));
            this.m = AbstractC21455b.F(6.0f);
        } else {
            this.l.set(AbstractC21455b.F(11.0f), AbstractC21455b.F(6.0f), AbstractC21455b.F(this.j ? 15.0f : 11.0f), AbstractC21455b.F(7.0f));
            this.m = AbstractC21455b.F(2.0f);
        }
        return this;
    }
}
