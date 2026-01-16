package ir.nasim.tgwidgets.editor.ui.stories;

import android.animation.ValueAnimator;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12098e22;
import ir.nasim.AbstractC6403Nl2;
import ir.nasim.C16463lJ6;
import ir.nasim.FH3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.TD5;
import ir.nasim.TI6;
import ir.nasim.WL6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan;
import ir.nasim.tgwidgets.editor.ui.Components.LinkSpanDrawable;
import ir.nasim.tgwidgets.editor.ui.Components.spoilers.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public class StoryCaptionView extends NestedScrollView {
    private final C16463lJ6 A0;
    public StoryCaptionTextView B0;
    private boolean C0;
    private float D0;
    private float E0;
    private float F0;
    private Method G0;
    private OverScroller H0;
    private boolean I0;
    private int J0;
    private int K0;
    private float L0;
    private boolean M0;
    private int N0;
    FrameLayout O0;
    public boolean P0;
    private boolean Q0;
    public int R0;
    int S0;
    GradientDrawable T0;
    boolean U0;
    boolean V0;
    private final Paint z0;

    public class StoryCaptionTextView extends View {
        public boolean A;
        int B;
        int D;
        private AnimatedEmojiSpan.b G;
        private AnimatedEmojiSpan.b H;
        AtomicReference J;
        private final PorterDuffColorFilter a;
        private LinkSpanDrawable b;
        private AnimatedEmojiSpan c;
        private LinkSpanDrawable.a d;
        TextPaint e;
        TextPaint f;
        private final Paint g;
        private final Paint h;
        int i;
        StaticLayout j;
        StaticLayout k;
        StaticLayout l;
        a[] m;
        CharSequence n;
        int o;
        float p;
        float q;
        boolean r;
        float s;
        float t;
        float u;
        private ir.nasim.tgwidgets.editor.ui.Components.spoilers.a v;
        protected List w;
        private Stack x;
        private boolean y;
        private Path z;

        public class a {
            private AnimatedEmojiSpan.b a;
            StaticLayout b;
            float c;
            float d;
            float e;
            float f;

            public a() {
            }
        }

        public StoryCaptionTextView(Context context, m.h hVar) {
            super(context);
            this.d = new LinkSpanDrawable.a(this);
            this.e = new TextPaint(1);
            this.f = new TextPaint(1);
            Paint paint = new Paint();
            this.g = paint;
            Paint paint2 = new Paint(1);
            this.h = paint2;
            this.i = 0;
            this.n = "";
            this.r = false;
            this.w = new ArrayList();
            this.x = new Stack();
            this.z = new Path();
            this.A = true;
            this.J = new AtomicReference();
            this.e.setColor(-1);
            this.e.linkColor = m.j0(m.Ja, hVar);
            this.e.setTextSize(AbstractC21455b.F(15.0f));
            this.f.setColor(-1);
            this.f.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            this.f.setTextSize(AbstractC21455b.F(16.0f));
            paint.setColor(-16777216);
            PorterDuff.Mode mode = PorterDuff.Mode.DST_OUT;
            paint.setXfermode(new PorterDuffXfermode(mode));
            paint2.setShader(new LinearGradient(0.0f, 0.0f, AbstractC21455b.F(16.0f), 0.0f, new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
            paint2.setXfermode(new PorterDuffXfermode(mode));
            this.v = new ir.nasim.tgwidgets.editor.ui.Components.spoilers.a(this, this.w, new a.b() { // from class: ir.nasim.dQ6
                @Override // ir.nasim.tgwidgets.editor.ui.Components.spoilers.a.b
                public final void a(TI6 ti6, float f, float f2) {
                    this.a.j(ti6, f, f2);
                }
            });
            this.a = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }

        private void f() {
            this.d.e();
            this.b = null;
            invalidate();
        }

        private void g(StaticLayout staticLayout, Canvas canvas) {
            if (this.w.isEmpty()) {
                staticLayout.draw(canvas);
            } else {
                TI6.z(this, false, -1, 0, this.J, staticLayout, this.w, canvas, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h() {
            this.y = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            post(new Runnable() { // from class: ir.nasim.fQ6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(TI6 ti6, float f, float f2) {
            if (this.y) {
                return;
            }
            ti6.D(new Runnable() { // from class: ir.nasim.eQ6
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i();
                }
            });
            float fSqrt = (float) Math.sqrt(Math.pow(getWidth(), 2.0d) + Math.pow(getHeight(), 2.0d));
            Iterator it = this.w.iterator();
            while (it.hasNext()) {
                ((TI6) it.next()).I(f, f2, fSqrt);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            this.d.e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(LinkSpanDrawable linkSpanDrawable) {
            LinkSpanDrawable linkSpanDrawable2 = this.b;
            if (linkSpanDrawable == linkSpanDrawable2 && linkSpanDrawable2 != null && (linkSpanDrawable2.c() instanceof URLSpan)) {
                StoryCaptionView.this.k0((URLSpan) this.b.c(), this, new Runnable() { // from class: ir.nasim.gQ6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k();
                    }
                });
                this.b = null;
            }
        }

        private StaticLayout m(TextPaint textPaint, CharSequence charSequence, int i) {
            return StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i).setBreakStrategy(0).setHyphenationFrequency(0).setAlignment(FH3.D ? WL6.b() : WL6.a()).build();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
            /*
                r6 = this;
                android.text.StaticLayout r0 = r6.j
                if (r0 == 0) goto L2c
                android.graphics.RectF r1 = ir.nasim.tgwidgets.editor.messenger.AbstractC21455b.x
                float r2 = r6.u
                float r3 = r6.t
                int r0 = r0.getWidth()
                float r0 = (float) r0
                float r0 = r0 + r2
                float r4 = r6.t
                android.text.StaticLayout r5 = r6.j
                int r5 = r5.getHeight()
                float r5 = (float) r5
                float r4 = r4 + r5
                r1.set(r2, r3, r0, r4)
                float r0 = r7.getX()
                float r2 = r7.getY()
                boolean r0 = r1.contains(r0, r2)
                if (r0 == 0) goto L2c
                goto L3a
            L2c:
                boolean r0 = r6.A
                if (r0 == 0) goto L3a
                ir.nasim.tgwidgets.editor.ui.Components.spoilers.a r0 = r6.v
                boolean r0 = r0.c(r7)
                if (r0 == 0) goto L3a
                r7 = 1
                return r7
            L3a:
                boolean r7 = super.dispatchTouchEvent(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.StoryCaptionView.StoryCaptionTextView.dispatchTouchEvent(android.view.MotionEvent):boolean");
        }

        public Paint getPaint() {
            return this.e;
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AnimatedEmojiSpan.i(this, this.G);
            AnimatedEmojiSpan.i(this, this.H);
            if (this.m == null) {
                return;
            }
            int i = 0;
            while (true) {
                a[] aVarArr = this.m;
                if (i >= aVarArr.length) {
                    return;
                }
                a aVar = aVarArr[i];
                if (aVar != null) {
                    AnimatedEmojiSpan.i(this, aVar.a);
                }
                i++;
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            StaticLayout staticLayout;
            if (this.j != null) {
                canvas.saveLayerAlpha(this.p - this.B, this.q, getMeasuredWidth(), getMeasuredHeight() - this.D, 255, 31);
            } else {
                canvas.save();
            }
            canvas.save();
            canvas.translate(this.p, this.q);
            if (this.d.g(canvas)) {
                invalidate();
            }
            canvas.restore();
            if (this.w.isEmpty() && (staticLayout = this.l) != null) {
                if (staticLayout != null) {
                    canvas.save();
                    canvas.translate(this.p, this.q);
                    g(this.l, canvas);
                    AnimatedEmojiSpan.b bVarL = AnimatedEmojiSpan.l(0, this, this.H, this.l);
                    this.H = bVarL;
                    AnimatedEmojiSpan.f(canvas, this.l, bVarL, 0.0f, this.w, 0.0f, 0.0f, 0.0f, 1.0f, this.a);
                    canvas.restore();
                }
                if (this.m != null) {
                    int i = 0;
                    while (true) {
                        a[] aVarArr = this.m;
                        if (i >= aVarArr.length) {
                            break;
                        }
                        a aVar = aVarArr[i];
                        canvas.save();
                        float f = aVar.c;
                        float f2 = aVar.e;
                        if (f == f2) {
                            this.e.setAlpha((int) (this.s * 255.0f));
                            canvas.translate(this.p + aVar.e, this.q + aVar.f);
                            g(aVar.b, canvas);
                            aVar.b.draw(canvas);
                            aVar.a = AnimatedEmojiSpan.l(0, this, aVar.a, aVar.b);
                            AnimatedEmojiSpan.f(canvas, aVar.b, aVar.a, 0.0f, this.w, 0.0f, 0.0f, 0.0f, this.s, this.a);
                            this.e.setAlpha(255);
                        } else {
                            canvas.translate(this.p + AbstractC21455b.T0(f, f2, this.s), this.q + AbstractC21455b.T0(aVar.d, aVar.f, InterpolatorC12631ew1.g.getInterpolation(this.s)));
                            aVar.b.draw(canvas);
                            aVar.a = AnimatedEmojiSpan.l(0, this, aVar.a, aVar.b);
                            AnimatedEmojiSpan.f(canvas, aVar.b, aVar.a, 0.0f, this.w, 0.0f, 0.0f, 0.0f, 1.0f, this.a);
                        }
                        canvas.restore();
                        i++;
                    }
                }
            } else if (this.k != null) {
                canvas.save();
                canvas.translate(this.p, this.q);
                g(this.k, canvas);
                AnimatedEmojiSpan.b bVarL2 = AnimatedEmojiSpan.l(0, this, this.G, this.k);
                this.G = bVarL2;
                AnimatedEmojiSpan.f(canvas, this.k, bVarL2, 0.0f, this.w, 0.0f, 0.0f, 0.0f, 1.0f, this.a);
                canvas.restore();
            }
            if (this.j != null) {
                float scrollY = this.t + StoryCaptionView.this.getScrollY();
                int iC = (int) ((1.0f - Utilities.c(this.s / 0.5f, 1.0f, 0.0f)) * 255.0f);
                this.h.setAlpha(iC);
                this.g.setAlpha(iC);
                this.f.setAlpha(iC);
                canvas.save();
                canvas.translate(this.u - AbstractC21455b.F(32.0f), scrollY);
                canvas.drawRect(0.0f, 0.0f, AbstractC21455b.F(32.0f), this.j.getHeight() + this.D, this.h);
                canvas.restore();
                canvas.drawRect(this.u - AbstractC21455b.F(16.0f), scrollY, getMeasuredWidth(), this.j.getHeight() + scrollY + this.D, this.g);
                canvas.save();
                canvas.translate(this.u, scrollY);
                this.j.draw(canvas);
                canvas.restore();
            }
            canvas.restore();
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            int i3 = (i2 + i) << 16;
            this.B = AbstractC21455b.F(16.0f);
            this.D = AbstractC21455b.F(8.0f);
            if (this.i != i3) {
                this.i = i3;
                int size = View.MeasureSpec.getSize(i) - (this.B * 2);
                StaticLayout staticLayoutM = m(this.e, this.n, size);
                this.k = staticLayoutM;
                this.o = staticLayoutM.getHeight();
                this.p = this.B;
                this.q = this.D;
                float fMeasureText = this.e.measureText(Separators.SP);
                if (this.k.getLineCount() > 3) {
                    String strE = FH3.E("ShowMore", TD5.tgwidget_ShowMore);
                    this.j = m(this.f, strE, size);
                    float lineTop = this.k.getLineTop(2) + this.k.getTopPadding();
                    this.t = (this.q + lineTop) - AbstractC21455b.H(0.3f);
                    this.u = (View.MeasureSpec.getSize(i) - this.B) - this.f.measureText(strE);
                    this.l = m(this.e, this.n.subSequence(0, this.k.getLineEnd(2)), size);
                    this.x.addAll(this.w);
                    this.w.clear();
                    TI6.o(this, this.k, this.x, this.w);
                    float lineRight = this.k.getLineRight(2) + fMeasureText;
                    if (this.m != null) {
                        int i4 = 0;
                        while (true) {
                            a[] aVarArr = this.m;
                            if (i4 >= aVarArr.length) {
                                break;
                            }
                            a aVar = aVarArr[i4];
                            if (aVar != null) {
                                AnimatedEmojiSpan.i(this, aVar.a);
                            }
                            i4++;
                        }
                    }
                    this.m = new a[this.k.getLineCount() - 3];
                    if (this.w.isEmpty()) {
                        for (int i5 = 3; i5 < this.k.getLineCount(); i5++) {
                            int lineStart = this.k.getLineStart(i5);
                            int lineEnd = this.k.getLineEnd(i5);
                            StaticLayout staticLayoutM2 = m(this.e, this.n.subSequence(Math.min(lineStart, lineEnd), Math.max(lineStart, lineEnd)), size);
                            a aVar2 = new a();
                            this.m[i5 - 3] = aVar2;
                            aVar2.b = staticLayoutM2;
                            aVar2.e = this.k.getLineLeft(i5);
                            aVar2.f = this.k.getLineTop(i5) + this.k.getTopPadding();
                            if (lineRight < this.u - AbstractC21455b.F(16.0f)) {
                                aVar2.d = lineTop;
                                aVar2.c = lineRight;
                                lineRight += staticLayoutM2.getLineRight(0) + fMeasureText;
                            } else {
                                aVar2.d = aVar2.f;
                                aVar2.c = aVar2.e;
                            }
                        }
                    }
                } else {
                    this.j = null;
                    this.l = null;
                    this.x.addAll(this.w);
                    this.w.clear();
                    TI6.o(this, this.k, this.x, this.w);
                }
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec((this.D * 2) + this.o, 1073741824));
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouchEvent(android.view.MotionEvent r12) {
            /*
                Method dump skipped, instructions count: 397
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.stories.StoryCaptionView.StoryCaptionTextView.onTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        public void setPressed(boolean z) {
            boolean z2 = z != isPressed();
            super.setPressed(z);
            if (z2) {
                invalidate();
            }
        }

        public void setText(CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            this.y = false;
            this.n = charSequence;
            this.i = 0;
            requestLayout();
        }

        @Override // android.view.View
        public void setTranslationY(float f) {
            if (getTranslationY() != f) {
                super.setTranslationY(f);
                StoryCaptionView.this.invalidate();
            }
        }
    }

    public StoryCaptionView(Context context, m.h hVar) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        super(context);
        Paint paint = new Paint(1);
        this.z0 = paint;
        this.L0 = 1.0f;
        this.N0 = -1;
        this.S0 = QY0.k(-16777216, 51);
        this.T0 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, this.S0});
        this.O0 = new FrameLayout(context);
        setClipChildren(false);
        setOverScrollMode(2);
        E.p(this);
        StoryCaptionTextView storyCaptionTextView = new StoryCaptionTextView(getContext(), hVar);
        this.B0 = storyCaptionTextView;
        this.O0.addView(storyCaptionTextView, -1, -2);
        addView(this.O0, new ViewGroup.LayoutParams(-1, -2));
        paint.setColor(-16777216);
        setFadingEdgeLength(AbstractC21455b.F(12.0f));
        setVerticalFadingEdgeEnabled(true);
        setWillNotDraw(false);
        C16463lJ6 c16463lJ6 = new C16463lJ6(this.B0, AbstractC12098e22.n, 0.0f);
        this.A0 = c16463lJ6;
        c16463lJ6.x().f(100.0f);
        c16463lJ6.n(1.0f);
        c16463lJ6.c(new AbstractC12098e22.r() { // from class: ir.nasim.bQ6
            @Override // ir.nasim.AbstractC12098e22.r
            public final void a(AbstractC12098e22 abstractC12098e22, float f, float f2) {
                this.a.h0(abstractC12098e22, f, f2);
            }
        });
        c16463lJ6.x().d(1.0f);
        try {
            Method declaredMethod = NestedScrollView.class.getDeclaredMethod("a", null);
            this.G0 = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception e) {
            this.G0 = null;
            AbstractC6403Nl2.d(e);
        }
        try {
            Field declaredField = NestedScrollView.class.getDeclaredField("d");
            declaredField.setAccessible(true);
            this.H0 = (OverScroller) declaredField.get(this);
        } catch (Exception e2) {
            this.H0 = null;
            AbstractC6403Nl2.d(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(float f, float f2, float f3, float f4, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        setScrollY((int) AbstractC21455b.T0(f, f2, fFloatValue));
        this.B0.s = AbstractC21455b.T0(f3, f4, fFloatValue);
        this.B0.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(AbstractC12098e22 abstractC12098e22, float f, float f2) {
        this.D0 = f;
        this.F0 = f2;
    }

    private void l0(float f) {
        if (!this.A0.h()) {
            this.A0.q(f);
            this.A0.s();
        }
        if (getScrollY() < AbstractC21455b.F(2.0f)) {
            f0();
        }
    }

    private void m0(int i, int i2) {
        int iE0 = e0(i, i2);
        if (iE0 >= 0) {
            if (this.M0) {
                this.N0 = iE0;
            } else {
                ((ViewGroup.MarginLayoutParams) this.O0.getLayoutParams()).topMargin = iE0;
                this.N0 = -1;
            }
        }
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean Z(int i, int i2) {
        if (i2 == 0) {
            this.A0.d();
            this.C0 = true;
            this.D0 = this.B0.getTranslationY();
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView
    public void b0(int i) {
        OverScroller overScroller;
        if (this.C0 && i == 0) {
            this.C0 = false;
            if (this.D0 == 0.0f || (overScroller = this.H0) == null || !overScroller.isFinished()) {
                return;
            }
            l0(this.F0);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void computeScroll() {
        OverScroller overScroller;
        super.computeScroll();
        if (this.C0 || this.D0 == 0.0f || (overScroller = this.H0) == null || !overScroller.isFinished()) {
            return;
        }
        l0(0.0f);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void draw(Canvas canvas) {
        if (this.Q0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int scrollY = getScrollY();
        int iSave = canvas.save();
        int i = height + scrollY;
        canvas.clipRect(0, scrollY, width, this.R0 + i);
        canvas.clipRect(0, scrollY, width, i);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public int e0(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return -1;
        }
        StoryCaptionTextView storyCaptionTextView = this.B0;
        int iHashCode = storyCaptionTextView.n.hashCode();
        Point point = AbstractC21455b.h;
        boolean z = point.x > point.y;
        if (this.J0 == iHashCode && this.I0 == z && this.K0 == i2) {
            return -1;
        }
        this.J0 = iHashCode;
        this.I0 = z;
        this.K0 = i2;
        storyCaptionTextView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, RecyclerView.UNDEFINED_DURATION));
        int lineCount = storyCaptionTextView.k.getLineCount();
        if (lineCount <= 3) {
            return i2 - storyCaptionTextView.getMeasuredHeight();
        }
        return i2 - (storyCaptionTextView.e.getFontMetricsInt(null) * (Math.min(3, lineCount) + 1));
    }

    public void f0() {
        if (this.U0) {
            this.U0 = false;
            final float scrollY = getScrollY();
            final float f = this.B0.s;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            final float f2 = 0.0f;
            final float f3 = 0.0f;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.aQ6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.g0(scrollY, f2, f, f3, valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(250L);
            valueAnimatorOfFloat.setInterpolator(InterpolatorC12631ew1.f);
            valueAnimatorOfFloat.start();
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected float getBottomFadingEdgeStrength() {
        return 1.0f;
    }

    public float getMaxTop() {
        return this.O0.getTop() - (this.O0.getBottom() - getMeasuredHeight());
    }

    public int getPendingMarginTopDiff() {
        int i = this.N0;
        if (i >= 0) {
            return i - ((ViewGroup.MarginLayoutParams) this.O0.getLayoutParams()).topMargin;
        }
        return 0;
    }

    public float getProgressToBlackout() {
        return Utilities.c((getScrollY() - this.B0.getTranslationY()) / Math.min(this.K0, AbstractC21455b.F(40.0f)), 1.0f, 0.0f);
    }

    public float getTextTop() {
        return (this.O0.getTop() + this.B0.getTranslationY()) - getScrollY();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected float getTopFadingEdgeStrength() {
        return 1.0f;
    }

    public void i0(AnimatedEmojiSpan animatedEmojiSpan) {
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getParent() != null) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // androidx.core.widget.NestedScrollView
    public boolean j(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        iArr[1] = 0;
        if (this.C0) {
            float f = this.D0;
            if ((f > 0.0f && i2 > 0) || (f < 0.0f && i2 < 0)) {
                float f2 = i2;
                float f3 = f - f2;
                if (f > 0.0f) {
                    if (f3 < 0.0f) {
                        this.D0 = 0.0f;
                        iArr[1] = (int) (0 + f2 + f3);
                    } else {
                        this.D0 = f3;
                        iArr[1] = i2;
                    }
                } else if (f3 > 0.0f) {
                    this.D0 = 0.0f;
                    iArr[1] = (int) (0 + f2 + f3);
                } else {
                    this.D0 = f3;
                    iArr[1] = i2;
                }
                this.B0.setTranslationY(this.D0);
                return true;
            }
        }
        return false;
    }

    public void j0(CharacterStyle characterStyle, View view) {
    }

    public void k0(URLSpan uRLSpan, View view, Runnable runnable) {
    }

    @Override // androidx.core.widget.NestedScrollView
    public void l(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        int iRound;
        float f;
        if (i4 == 0 || (iRound = Math.round(i4 * (1.0f - Math.abs((-this.D0) / this.O0.getTop())))) == 0) {
            return;
        }
        if (this.C0) {
            float f2 = this.D0 - iRound;
            this.D0 = f2;
            this.B0.setTranslationY(f2);
            return;
        }
        if (this.A0.h()) {
            return;
        }
        OverScroller overScroller = this.H0;
        float currVelocity = overScroller != null ? overScroller.getCurrVelocity() : Float.NaN;
        if (Float.isNaN(currVelocity)) {
            f = 0.0f;
        } else {
            Point point = AbstractC21455b.h;
            float fMin = Math.min(point.x > point.y ? 3000.0f : 5000.0f, currVelocity);
            iRound = (int) ((iRound * fMin) / currVelocity);
            f = fMin * (-this.E0);
        }
        if (iRound != 0) {
            float f3 = this.D0 - iRound;
            this.D0 = f3;
            this.B0.setTranslationY(f3);
        }
        l0(f);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.B0.s != 1.0f || this.P0 || (motionEvent.getAction() == 0 && motionEvent.getY() < (this.O0.getTop() - getScrollY()) + this.B0.getTranslationY())) {
            if (this.V0) {
                this.V0 = false;
                invalidate();
            }
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.V0 = true;
            invalidate();
        } else if (this.V0 && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            this.V0 = false;
            invalidate();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m0(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        super.onMeasure(i, i2);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.B0.s != 1.0f || this.P0 || (motionEvent.getAction() == 0 && motionEvent.getY() < (this.O0.getTop() - getScrollY()) + this.B0.getTranslationY())) {
            if (this.V0) {
                this.V0 = false;
                invalidate();
            }
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.V0 = true;
            invalidate();
        } else if (this.V0 && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            this.V0 = false;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
        invalidate();
    }

    @Override // androidx.core.widget.NestedScrollView
    public void u(int i) {
        super.u(i);
        this.E0 = Math.signum(i);
        this.F0 = 0.0f;
    }
}
