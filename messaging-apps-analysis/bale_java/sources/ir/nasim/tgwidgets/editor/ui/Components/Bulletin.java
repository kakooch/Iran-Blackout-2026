package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC13799gq2;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC14047hG;
import ir.nasim.AbstractC18106o57;
import ir.nasim.R62;
import ir.nasim.U00;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h;
import ir.nasim.tgwidgets.editor.ui.Components.LinkSpanDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class Bulletin {
    private static final HashMap g = new HashMap();
    private static final HashMap h = new HashMap();
    private static Bulletin i;
    public int a;
    private final Layout b;
    private int d;
    private boolean e;
    private final Runnable c = new Runnable() { // from class: ir.nasim.sm0
        @Override // java.lang.Runnable
        public final void run() {
            this.a.d();
        }
    };
    public boolean f = true;

    public static abstract class Button extends FrameLayout implements Layout.c {
        public Button(Context context) {
            super(context);
        }
    }

    public static class ButtonLayout extends Layout {
        private Button q;
        public c r;
        private int s;
        m.h t;

        public ButtonLayout(Context context, m.h hVar) {
            super(context, hVar);
            this.t = hVar;
        }

        public Button getButton() {
            return this.q;
        }

        @Override // android.view.ViewGroup
        protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
            Button button = this.q;
            if (button != null && view != button) {
                i2 += button.getMeasuredWidth() - AbstractC21455b.F(12.0f);
            }
            super.measureChildWithMargins(view, i, i2, i3, i4);
            if (view != this.q) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                this.s = Math.max(this.s, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + view.getMeasuredWidth());
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            this.s = 0;
            super.onMeasure(i, i2);
            if (this.q == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
                return;
            }
            setMeasuredDimension(this.s + this.q.getMeasuredWidth(), getMeasuredHeight());
        }

        public void setButton(Button button) {
            Button button2 = this.q;
            if (button2 != null) {
                f(button2);
                removeView(this.q);
            }
            this.q = button;
            if (button != null) {
                b(button);
                addView(button, 0, AbstractC13840gu3.e(-2.0f, -2.0f, 8388629));
            }
        }

        public void setTimer() {
            c cVar = new c(getContext(), this.t);
            this.r = cVar;
            cVar.b = 5000L;
            addView(this.r, AbstractC13840gu3.f(20.0f, 20.0f, 8388627, 21.0f, 0.0f, 21.0f, 0.0f));
        }
    }

    public static abstract class Layout extends FrameLayout {
        public static final AbstractC13799gq2 o = new a("offsetY");
        public static final Property p = new b("offsetY");
        private final List a;
        public boolean b;
        public boolean c;
        a d;
        public float e;
        protected Bulletin f;
        Drawable g;
        private boolean h;
        private int i;
        private int j;
        private final m.h k;
        private LinearGradient l;
        private Matrix m;
        private Paint n;

        class a extends AbstractC13799gq2 {
            a(String str) {
                super(str);
            }

            @Override // ir.nasim.AbstractC13799gq2
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public float a(Layout layout) {
                return layout.e;
            }

            @Override // ir.nasim.AbstractC13799gq2
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(Layout layout, float f) {
                layout.setInOutOffset(f);
            }
        }

        class b extends AbstractC21469h.e {
            b(String str) {
                super(str);
            }

            @Override // android.util.Property
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Float get(Layout layout) {
                return Float.valueOf(layout.e);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.AbstractC21469h.e
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(Layout layout, float f) {
                layout.setInOutOffset(f);
            }
        }

        public interface c {
        }

        public Layout(Context context, m.h hVar) {
            super(context);
            this.a = new ArrayList();
            this.i = -2;
            this.j = 1;
            this.k = hVar;
            setMinimumHeight(AbstractC21455b.F(48.0f));
            setBackground(c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.tg));
            h();
            setPadding(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f));
            setWillNotDraw(false);
        }

        private boolean e() {
            if (!AbstractC21455b.F0()) {
                Point point = AbstractC21455b.h;
                if (point.x < point.y) {
                    return false;
                }
            }
            return true;
        }

        private void h() {
            boolean zE = e();
            int i = zE ? this.i : -1;
            if (zE) {
                i = (this.h ? 48 : 80) | this.j;
            } else if (this.h) {
                i = 48;
            }
            setLayoutParams(AbstractC13840gu3.d(i, -2, i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInOutOffset(float f) {
            this.e = f;
            g();
        }

        private void setTop(boolean z) {
            this.h = z;
            h();
        }

        public void b(c cVar) {
            this.a.add(cVar);
        }

        protected int c(int i) {
            return ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, this.k);
        }

        public boolean d() {
            return this.b || this.c;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            a aVar;
            if (this.f == null) {
                return;
            }
            this.g.setBounds(AbstractC21455b.F(8.0f), AbstractC21455b.F(8.0f), getMeasuredWidth() - AbstractC21455b.F(8.0f), getMeasuredHeight() - AbstractC21455b.F(8.0f));
            if (!d() || (aVar = this.d) == null) {
                this.g.draw(canvas);
                super.dispatchDraw(canvas);
                return;
            }
            float fB = aVar.b(this.f.a) - getY();
            float measuredHeight = (((View) getParent()).getMeasuredHeight() - getBottomOffset()) - getY();
            boolean zA = this.d.a(this.f.a);
            canvas.save();
            canvas.clipRect(0.0f, fB, getMeasuredWidth(), measuredHeight);
            if (zA) {
                canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255, 31);
            }
            this.g.draw(canvas);
            super.dispatchDraw(canvas);
            if (zA) {
                if (this.n == null) {
                    Paint paint = new Paint(1);
                    this.n = paint;
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                    this.l = new LinearGradient(0.0f, 0.0f, 0.0f, AbstractC21455b.F(8.0f), this.h ? new int[]{-16777216, 0} : new int[]{0, -16777216}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                    Matrix matrix = new Matrix();
                    this.m = matrix;
                    this.l.setLocalMatrix(matrix);
                    this.n.setShader(this.l);
                }
                canvas.save();
                this.m.reset();
                this.m.postTranslate(0.0f, this.h ? fB : measuredHeight - AbstractC21455b.F(8.0f));
                this.l.setLocalMatrix(this.m);
                if (this.h) {
                    canvas.drawRect(0.0f, fB, getWidth(), fB + AbstractC21455b.F(8.0f), this.n);
                } else {
                    canvas.drawRect(0.0f, measuredHeight - AbstractC21455b.F(8.0f), getWidth(), measuredHeight, this.n);
                }
                canvas.restore();
                canvas.restore();
            }
            canvas.restore();
            invalidate();
        }

        public void f(c cVar) {
            this.a.remove(cVar);
        }

        public void g() {
            float bottomOffset = 0.0f;
            if (this.d != null) {
                if (this.h) {
                    bottomOffset = 0.0f - r0.b(this.f != null ? r2.a : 0);
                } else {
                    bottomOffset = 0.0f + getBottomOffset();
                }
            }
            setTranslationY((-bottomOffset) + (this.e * (this.h ? -1 : 1)));
        }

        protected CharSequence getAccessibilityText() {
            return null;
        }

        public float getBottomOffset() {
            return 0.0f;
        }

        public Bulletin getBulletin() {
            return this.f;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            h();
        }

        protected void setBackground(int i) {
            this.g = ir.nasim.tgwidgets.editor.ui.ActionBar.m.W(AbstractC21455b.F(10.0f), i);
        }
    }

    public static class LoadingLottieLayout extends LottieLayout implements b {
        public LinkSpanDrawable.LinksTextView x;

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.LottieLayout
        public void setTextColor(int i) {
            super.setTextColor(i);
            LinkSpanDrawable.LinksTextView linksTextView = this.x;
            if (linksTextView != null) {
                linksTextView.setTextColor(i);
            }
        }
    }

    public static class LottieLayout extends ButtonLayout {
        public RLottieImageView u;
        public LinkSpanDrawable.LinksTextView v;
        private int w;

        class a extends LinkSpanDrawable.LinksTextView {
            a(Context context) {
                super(context);
            }

            @Override // android.widget.TextView
            public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
                super.setText(R62.S(charSequence, getPaint().getFontMetricsInt(), AbstractC21455b.F(13.0f), false), bufferType);
            }
        }

        public LottieLayout(Context context, m.h hVar) {
            super(context, hVar);
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.u = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.u, AbstractC13840gu3.e(56.0f, 48.0f, 8388627));
            a aVar = new a(context);
            this.v = aVar;
            ir.nasim.tgwidgets.editor.messenger.E.p(aVar);
            this.v.setDisablePaddingsOffset(true);
            this.v.setSingleLine();
            this.v.setTypeface(Typeface.SANS_SERIF);
            this.v.setTextSize(1, 15.0f);
            this.v.setEllipsize(TextUtils.TruncateAt.END);
            this.v.setPadding(0, AbstractC21455b.F(8.0f), 0, AbstractC21455b.F(8.0f));
            addView(this.v, AbstractC13840gu3.f(-2.0f, -2.0f, 8388627, 56.0f, 0.0f, 8.0f, 0.0f));
            this.v.setLinkTextColor(c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.ug));
            setTextColor(c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.vg));
            setBackground(c(ir.nasim.tgwidgets.editor.ui.ActionBar.m.tg));
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.Layout
        public CharSequence getAccessibilityText() {
            return this.v.getText();
        }

        public void setAnimation(int i, String... strArr) {
            setAnimation(i, 32, 32, strArr);
        }

        public void setIconPaddingBottom(int i) {
            this.u.setLayoutParams(AbstractC13840gu3.f(56.0f, 48 - i, 8388627, 0.0f, 0.0f, 0.0f, i));
        }

        public void setTextColor(int i) {
            this.w = i;
            this.v.setTextColor(i);
        }

        public void setAnimation(int i, int i2, int i3, String... strArr) {
            this.u.setAnimation(i, i2, i3);
            for (String str : strArr) {
                this.u.setLayerColor(str + ".**", this.w);
            }
        }

        public void setAnimation(AbstractC18106o57 abstractC18106o57, int i, int i2, String... strArr) throws InterruptedException {
            this.u.setAutoRepeat(true);
            this.u.setAnimation(abstractC18106o57, i, i2);
            for (String str : strArr) {
                this.u.setLayerColor(str + ".**", this.w);
            }
        }

        public LottieLayout(Context context, m.h hVar, int i, int i2) {
            this(context, hVar);
            setBackground(i);
            setTextColor(i2);
        }
    }

    public static class MultiLineLayout extends ButtonLayout {
        public final TextView u;

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.Layout
        public CharSequence getAccessibilityText() {
            return this.u.getText();
        }
    }

    public static class SimpleLayout extends ButtonLayout {
        public final LinkSpanDrawable.LinksTextView u;

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.Layout
        public CharSequence getAccessibilityText() {
            return this.u.getText();
        }
    }

    public static class TwoLineLayout extends ButtonLayout {
        public final TextView u;
        public final TextView v;

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.Layout
        public CharSequence getAccessibilityText() {
            return ((Object) this.u.getText()) + ".\n" + ((Object) this.v.getText());
        }
    }

    public static class TwoLineLottieLayout extends ButtonLayout {
        public final RLottieImageView u;
        public final LinkSpanDrawable.LinksTextView v;
        public final LinkSpanDrawable.LinksTextView w;
        private final int x;

        @Override // ir.nasim.tgwidgets.editor.ui.Components.Bulletin.Layout
        public CharSequence getAccessibilityText() {
            return ((Object) this.v.getText()) + ".\n" + ((Object) this.w.getText());
        }

        public void setAnimation(int i, String... strArr) {
            setAnimation(i, 32, 32, strArr);
        }

        public void setAnimation(int i, int i2, int i3, String... strArr) {
            this.u.setAnimation(i, i2, i3);
            for (String str : strArr) {
                this.u.setLayerColor(str + ".**", this.x);
            }
        }
    }

    public static final class UndoButton extends Button {
    }

    public interface a {
        default boolean a(int i) {
            return false;
        }

        default int b(int i) {
            return 0;
        }
    }

    public interface b {
    }

    private static class c extends View {
        private final Paint a;
        private long b;
        private int c;
        private String d;
        private int e;
        StaticLayout f;
        StaticLayout g;
        int h;
        float i;
        private TextPaint j;
        private long k;
        RectF l;

        public c(Context context, m.h hVar) {
            super(context);
            this.i = 1.0f;
            this.l = new RectF();
            TextPaint textPaint = new TextPaint(1);
            this.j = textPaint;
            textPaint.setTextSize(AbstractC21455b.F(12.0f));
            this.j.setTypeface(AbstractC21455b.q0("fonts/rmedium.ttf"));
            TextPaint textPaint2 = this.j;
            int i = ir.nasim.tgwidgets.editor.ui.ActionBar.m.vg;
            textPaint2.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, hVar));
            Paint paint = new Paint(1);
            this.a = paint;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(AbstractC21455b.F(2.0f));
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setColor(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(i, hVar));
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int iCeil = this.b > 0 ? (int) Math.ceil(r0 / 1000.0f) : 0;
            this.l.set(AbstractC21455b.F(1.0f), AbstractC21455b.F(1.0f), getMeasuredWidth() - AbstractC21455b.F(1.0f), getMeasuredHeight() - AbstractC21455b.F(1.0f));
            if (this.c != iCeil) {
                this.c = iCeil;
                this.d = String.valueOf(Math.max(0, iCeil));
                StaticLayout staticLayout = this.f;
                if (staticLayout != null) {
                    this.g = staticLayout;
                    this.i = 0.0f;
                    this.h = this.e;
                }
                this.e = (int) Math.ceil(this.j.measureText(r0));
                this.f = new StaticLayout(this.d, this.j, Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            float f = this.i;
            if (f < 1.0f) {
                float f2 = f + 0.10666667f;
                this.i = f2;
                if (f2 > 1.0f) {
                    this.i = 1.0f;
                } else {
                    invalidate();
                }
            }
            int alpha = this.j.getAlpha();
            if (this.g != null) {
                float f3 = this.i;
                if (f3 < 1.0f) {
                    this.j.setAlpha((int) (alpha * (1.0f - f3)));
                    canvas.save();
                    canvas.translate(this.l.centerX() - (this.h / 2.0f), (this.l.centerY() - (this.g.getHeight() / 2.0f)) + (AbstractC21455b.F(10.0f) * this.i));
                    this.g.draw(canvas);
                    this.j.setAlpha(alpha);
                    canvas.restore();
                }
            }
            if (this.f != null) {
                float f4 = this.i;
                if (f4 != 1.0f) {
                    this.j.setAlpha((int) (alpha * f4));
                }
                canvas.save();
                canvas.translate(this.l.centerX() - (this.e / 2.0f), (this.l.centerY() - (this.f.getHeight() / 2.0f)) - (AbstractC21455b.F(10.0f) * (1.0f - this.i)));
                this.f.draw(canvas);
                if (this.i != 1.0f) {
                    this.j.setAlpha(alpha);
                }
                canvas.restore();
            }
            canvas.drawArc(this.l, -90.0f, (Math.max(0L, this.b) / 5000.0f) * (-360.0f), false, this.a);
            if (this.k != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.b -= jCurrentTimeMillis - this.k;
                this.k = jCurrentTimeMillis;
            } else {
                this.k = System.currentTimeMillis();
            }
            invalidate();
        }
    }

    private Bulletin(ir.nasim.tgwidgets.editor.ui.ActionBar.c cVar, FrameLayout frameLayout, Layout layout, int i2) {
        this.e = true;
        this.b = layout;
        this.e = true ^ (layout instanceof b);
        this.d = i2;
    }

    public static void a(FrameLayout frameLayout, a aVar) {
        g.put(frameLayout, aVar);
    }

    public static Bulletin b(FrameLayout frameLayout) {
        int childCount = frameLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = frameLayout.getChildAt(i2);
            if (childAt instanceof Layout) {
                return ((Layout) childAt).f;
            }
        }
        return null;
    }

    public static Bulletin c() {
        return i;
    }

    public static void f(FrameLayout frameLayout) {
        g(frameLayout, true);
    }

    public static void g(FrameLayout frameLayout, boolean z) {
        Bulletin bulletinB = b(frameLayout);
        if (bulletinB != null) {
            bulletinB.h(z && j(), 0L);
        }
    }

    private static boolean j() {
        return ir.nasim.tgwidgets.editor.messenger.C.m().getBoolean("view_animations", true);
    }

    public static Bulletin k(FrameLayout frameLayout, Layout layout, int i2) {
        return new Bulletin(null, frameLayout, layout, i2);
    }

    public static void l(FrameLayout frameLayout) {
        g.remove(frameLayout);
    }

    public void d() {
        h(j(), 0L);
    }

    public void e(long j) {
        h(j(), j);
    }

    public void h(boolean z, long j) {
    }

    public boolean i() {
        return false;
    }

    public Bulletin m() {
        return n(false);
    }

    public Bulletin n(boolean z) {
        CharSequence accessibilityText = this.b.getAccessibilityText();
        U00.d(AbstractC14047hG.a, "Bulletin!= " + ((Object) accessibilityText));
        return this;
    }
}
