package ir.nasim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.R62;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public class TI6 extends Drawable {
    public static final int A = x();
    public static final int B = y();
    public static final float[] C = {0.3f, 0.6f, 1.0f};
    private static Path D = new Path();
    private static Paint E;
    private Paint[] a;
    private Stack b;
    private int c;
    float[][] d;
    private float[] e;
    private int[] f;
    private RectF g;
    private ArrayList h;
    private View i;
    private long j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private boolean p;
    private Runnable q;
    private ValueAnimator r;
    private List s;
    private int t;
    private TimeInterpolator u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    public boolean z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Iterator it = TI6.this.h.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (TI6.this.b.size() < TI6.this.c) {
                    TI6.this.b.push(dVar);
                }
                it.remove();
            }
            if (TI6.this.q != null) {
                TI6.this.q.run();
                TI6.this.q = null;
            }
            TI6.this.r = null;
            TI6.this.invalidateSelf();
        }
    }

    class b extends Path {
        final /* synthetic */ View a;
        final /* synthetic */ Layout b;
        final /* synthetic */ Stack c;
        final /* synthetic */ List d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;

        b(View view, Layout layout, Stack stack, List list, int i, int i2) {
            this.a = view;
            this.b = layout;
            this.c = stack;
            this.d = list;
            this.e = i;
            this.f = i2;
        }

        @Override // android.graphics.Path
        public void addRect(float f, float f2, float f3, float f4, Path.Direction direction) {
            TI6.j(this.a, this.b, f, f2, f3, f4, this.c, this.d, this.e, this.f);
        }
    }

    private static class d {
        private float a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private int h;

        private d() {
        }
    }

    public TI6() {
        float[] fArr = C;
        this.a = new Paint[fArr.length];
        this.b = new Stack();
        this.d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, fArr.length, A * 2);
        this.e = new float[14];
        this.f = new int[fArr.length];
        this.h = new ArrayList();
        this.n = -1.0f;
        this.s = new ArrayList();
        this.t = 255;
        this.u = new TimeInterpolator() { // from class: ir.nasim.SI6
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f) {
                return TI6.v(f);
            }
        };
        for (int i = 0; i < C.length; i++) {
            this.a[i] = new Paint();
            if (i == 0) {
                this.a[i].setStrokeWidth(AbstractC21455b.F(1.4f));
                this.a[i].setStyle(Paint.Style.STROKE);
                this.a[i].setStrokeCap(Paint.Cap.ROUND);
            } else {
                this.a[i].setStrokeWidth(AbstractC21455b.F(1.2f));
                this.a[i].setStyle(Paint.Style.STROKE);
                this.a[i].setStrokeCap(Paint.Cap.ROUND);
            }
        }
        this.w = AbstractC8662Wx6.h() == 0;
        this.x = true;
        A(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(View view, Layout layout, float f, float f2, float f3, float f4, Stack stack, List list, int i, int i2) {
        TI6 ti6 = (stack == null || stack.isEmpty()) ? new TI6() : (TI6) stack.remove(0);
        ti6.G(-1.0f);
        ti6.setBounds((int) Math.max(f, i), (int) f2, (int) Math.min(f3, i2 <= 0 ? 2.1474836E9f : i2), (int) f4);
        ti6.A(layout.getPaint().getColor());
        ti6.F(U22.c);
        ti6.K();
        if (view != null) {
            ti6.E(view);
        }
        list.add(ti6);
    }

    private static void k(View view, Layout layout, int i, int i2, int i3, int i4, Stack stack, List list) {
        layout.getSelectionPath(i3, i4, new b(view, layout, stack, list, i, i2));
    }

    public static void l(View view, Layout layout, int i, int i2, Spanned spanned, Stack stack, List list) {
        int iMin;
        int iMax;
        if (layout == null) {
            return;
        }
        ir.nasim.tgwidgets.editor.ui.Components.G[] gArr = (ir.nasim.tgwidgets.editor.ui.Components.G[]) spanned.getSpans(0, layout.getText().length(), ir.nasim.tgwidgets.editor.ui.Components.G.class);
        for (int i3 = 0; i3 < gArr.length; i3++) {
            if (gArr[i3].a()) {
                int spanStart = spanned.getSpanStart(gArr[i3]);
                int spanEnd = spanned.getSpanEnd(gArr[i3]);
                if (i == -1 && i2 == -1) {
                    int lineForOffset = layout.getLineForOffset(spanEnd);
                    iMin = Integer.MAX_VALUE;
                    iMax = RecyclerView.UNDEFINED_DURATION;
                    for (int lineForOffset2 = layout.getLineForOffset(spanStart); lineForOffset2 <= lineForOffset; lineForOffset2++) {
                        iMin = Math.min(iMin, (int) layout.getLineLeft(lineForOffset2));
                        iMax = Math.max(iMax, (int) layout.getLineRight(lineForOffset2));
                    }
                } else {
                    iMin = i;
                    iMax = i2;
                }
                k(view, layout, iMin, iMax, spanStart, spanEnd, stack, list);
            }
        }
        if (!(view instanceof TextView) || stack == null) {
            return;
        }
        stack.clear();
    }

    public static void m(View view, Layout layout, int i, int i2, Stack stack, List list) {
        if (layout.getText() instanceof Spanned) {
            l(view, layout, i, i2, (Spanned) layout.getText(), stack, list);
        }
    }

    public static void n(View view, Layout layout, Spanned spanned, Stack stack, List list) {
        if (layout == null) {
            return;
        }
        l(view, layout, -1, -1, spanned, stack, list);
    }

    public static void o(View view, Layout layout, Stack stack, List list) {
        if (layout.getText() instanceof Spanned) {
            n(view, layout, (Spanned) layout.getText(), stack, list);
        }
    }

    public static void p(TextView textView, Stack stack, List list) {
        int measuredWidth = textView.getMeasuredWidth();
        Layout layout = textView.getLayout();
        if (measuredWidth <= 0) {
            measuredWidth = -2;
        }
        l(textView, layout, 0, measuredWidth, (Spanned) textView.getText(), stack, list);
    }

    private void q(d dVar, int i) {
        dVar.a = getBounds().left + (Utilities.c.nextFloat() * getBounds().width());
        dVar.b = getBounds().top + (Utilities.c.nextFloat() * getBounds().height());
    }

    private boolean u(int i, int i2, int i3, int i4, float f, float f2) {
        if (f < i || f > i3 || f2 < i2 + AbstractC21455b.F(2.5f) || f2 > i4 - AbstractC21455b.F(2.5f)) {
            return true;
        }
        for (int i5 = 0; i5 < this.s.size(); i5++) {
            if (((RectF) this.s.get(i5)).contains(f, f2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(int i, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.n = fFloatValue;
        setAlpha((int) (i * (1.0f - fFloatValue)));
        this.p = true;
        invalidateSelf();
    }

    private static int x() {
        return AbstractC8662Wx6.h() != 2 ? 100 : 150;
    }

    private static int y() {
        return AbstractC8662Wx6.h() != 2 ? 10 : 30;
    }

    public static void z(View view, boolean z, int i, int i2, AtomicReference atomicReference, Layout layout, List list, Canvas canvas, boolean z2) {
        ir.nasim.tgwidgets.editor.ui.Components.G[] gArr;
        int i3;
        if (list.isEmpty()) {
            layout.draw(canvas);
            return;
        }
        Layout layoutBuild = (Layout) atomicReference.get();
        int i4 = 0;
        if (layoutBuild == null || !layout.getText().toString().equals(layoutBuild.getText().toString()) || layout.getWidth() != layoutBuild.getWidth() || layout.getHeight() != layoutBuild.getHeight()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(layout.getText());
            if (layout.getText() instanceof Spannable) {
                Spannable spannable = (Spannable) layout.getText();
                ir.nasim.tgwidgets.editor.ui.Components.G[] gArr2 = (ir.nasim.tgwidgets.editor.ui.Components.G[]) spannable.getSpans(0, spannable.length(), ir.nasim.tgwidgets.editor.ui.Components.G.class);
                int length = gArr2.length;
                int i5 = 0;
                while (i5 < length) {
                    ir.nasim.tgwidgets.editor.ui.Components.G g = gArr2[i5];
                    if (g.a()) {
                        R62.c[] cVarArr = (R62.c[]) spannable.getSpans(spannable.getSpanStart(g), spannable.getSpanEnd(g), R62.c.class);
                        int length2 = cVarArr.length;
                        int i6 = i4;
                        while (i6 < length2) {
                            R62.c cVar = cVarArr[i6];
                            spannableStringBuilder.setSpan(new c(cVar), spannable.getSpanStart(cVar), spannable.getSpanEnd(cVar), spannable.getSpanFlags(g));
                            spannableStringBuilder.removeSpan(cVar);
                            i6++;
                            gArr2 = gArr2;
                            length = length;
                            cVarArr = cVarArr;
                        }
                        gArr = gArr2;
                        i3 = length;
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(0), spannable.getSpanStart(g), spannable.getSpanEnd(g), spannable.getSpanFlags(g));
                        spannableStringBuilder.removeSpan(g);
                    } else {
                        gArr = gArr2;
                        i3 = length;
                    }
                    i5++;
                    gArr2 = gArr;
                    length = i3;
                    i4 = 0;
                }
            }
            layoutBuild = StaticLayout.Builder.obtain(spannableStringBuilder, 0, spannableStringBuilder.length(), layout.getPaint(), layout.getWidth()).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(layout.getSpacingAdd(), layout.getSpacingMultiplier()).build();
            atomicReference.set(layoutBuild);
        }
        if (list.isEmpty()) {
            layout.draw(canvas);
        } else {
            canvas.save();
            canvas.translate(0.0f, i2);
            layoutBuild.draw(canvas);
            canvas.restore();
        }
        if (list.isEmpty()) {
            return;
        }
        D.rewind();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Rect bounds = ((TI6) it.next()).getBounds();
            D.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CW);
        }
        if (!list.isEmpty() && ((TI6) list.get(0)).n != -1.0f) {
            canvas.save();
            canvas.clipPath(D);
            D.rewind();
            if (!list.isEmpty()) {
                ((TI6) list.get(0)).s(D);
            }
            canvas.clipPath(D);
            canvas.translate(0.0f, -view.getPaddingTop());
            layout.draw(canvas);
            canvas.restore();
        }
        boolean z3 = ((TI6) list.get(0)).n != -1.0f;
        if (z3) {
            int measuredWidth = view.getMeasuredWidth();
            if (z2 && (view.getParent() instanceof View)) {
                measuredWidth = ((View) view.getParent()).getMeasuredWidth();
            }
            canvas.saveLayer(0.0f, 0.0f, measuredWidth, view.getMeasuredHeight(), null, 31);
        } else {
            canvas.save();
        }
        canvas.translate(0.0f, -view.getPaddingTop());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            TI6 ti6 = (TI6) it2.next();
            ti6.B(z);
            if (ti6.r() != view) {
                ti6.E(view);
            }
            if (ti6.H()) {
                ti6.A(QY0.c(i, ir.nasim.tgwidgets.editor.ui.ActionBar.m.v1.getColor(), Math.max(0.0f, ti6.t())));
            } else {
                ti6.A(i);
            }
            ti6.draw(canvas);
        }
        if (z3) {
            D.rewind();
            ((TI6) list.get(0)).s(D);
            if (E == null) {
                Paint paint = new Paint(1);
                E = paint;
                paint.setColor(-16777216);
                E.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            canvas.drawPath(D, E);
        }
        canvas.restore();
    }

    public void A(int i) {
        if (this.y == i) {
            return;
        }
        int i2 = 0;
        while (true) {
            float[] fArr = C;
            if (i2 >= fArr.length) {
                this.y = i;
                return;
            } else {
                this.a[i2].setColor(QY0.k(i, (int) (this.t * fArr[i2])));
                i2++;
            }
        }
    }

    public void B(boolean z) {
        this.v = z;
    }

    public void C(int i) {
        this.c = i;
        while (this.b.size() + this.h.size() < i) {
            this.b.push(new d());
        }
    }

    public void D(Runnable runnable) {
        this.q = runnable;
    }

    public void E(View view) {
        this.i = view;
    }

    public void F(TimeInterpolator timeInterpolator) {
        this.u = timeInterpolator;
    }

    public void G(float f) {
        ValueAnimator valueAnimator;
        this.n = f;
        if (f == -1.0f && (valueAnimator = this.r) != null) {
            valueAnimator.cancel();
        }
        this.p = true;
    }

    public boolean H() {
        boolean z = this.p;
        this.p = false;
        return z;
    }

    public void I(float f, float f2, float f3) {
        J(f, f2, f3, false);
    }

    public void J(float f, float f2, float f3, boolean z) {
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.n = z ? 1.0f : 0.0f;
        this.o = z;
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final int alpha = this.o ? 255 : this.a[C.length - 1].getAlpha();
        ValueAnimator duration = ValueAnimator.ofFloat(this.n, z ? 0.0f : 1.0f).setDuration((long) AbstractC22000uV3.a(this.m * 0.3f, 250.0f, 550.0f));
        this.r = duration;
        duration.setInterpolator(this.u);
        this.r.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.RI6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.a.w(alpha, valueAnimator2);
            }
        });
        this.r.addListener(new a());
        this.r.start();
        invalidateSelf();
    }

    public void K() {
        int iWidth = getBounds().width() / AbstractC21455b.F(6.0f);
        int i = B;
        C(AbstractC22000uV3.b(iWidth * i, i, A));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        d dVar;
        int i;
        float f;
        if (!this.z) {
            XI6.d().e().setColorFilter(new PorterDuffColorFilter(this.y, PorterDuff.Mode.SRC_IN));
            canvas.drawRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, XI6.d().e());
            if (ir.nasim.tgwidgets.editor.messenger.v.e(128)) {
                invalidateSelf();
                XI6.d().c();
                return;
            }
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iMin = (int) Math.min(jCurrentTimeMillis - this.j, 34L);
        this.j = jCurrentTimeMillis;
        int i2 = getBounds().left;
        int i3 = getBounds().top;
        int i4 = getBounds().right;
        int i5 = getBounds().bottom;
        int i6 = 0;
        for (int i7 = 0; i7 < C.length; i7++) {
            this.f[i7] = 0;
        }
        int i8 = 0;
        while (i8 < this.h.size()) {
            d dVar2 = (d) this.h.get(i8);
            float f2 = iMin;
            dVar2.g = Math.min(dVar2.g + f2, dVar2.f);
            if (dVar2.g >= dVar2.f || u(i2, i3, i4, i5, dVar2.a, dVar2.b)) {
                if (this.b.size() < this.c) {
                    this.b.push(dVar2);
                }
                this.h.remove(i8);
                i8--;
            } else {
                float f3 = (dVar2.e * f2) / 500.0f;
                dVar2.a += dVar2.c * f3;
                dVar2.b += dVar2.d * f3;
                int i9 = dVar2.h;
                this.d[i9][this.f[i9] * 2] = dVar2.a;
                this.d[i9][(this.f[i9] * 2) + 1] = dVar2.b;
                int[] iArr = this.f;
                iArr[i9] = iArr[i9] + 1;
            }
            i8++;
        }
        int size = this.h.size();
        int i10 = this.c;
        if (size < i10) {
            int size2 = i10 - this.h.size();
            float f4 = -1.0f;
            Arrays.fill(this.e, -1.0f);
            int i11 = 0;
            while (i11 < size2) {
                float[] fArr = this.e;
                int i12 = i11 % 14;
                float fNextFloat = fArr[i12];
                if (fNextFloat == f4) {
                    fNextFloat = Utilities.c.nextFloat();
                    fArr[i12] = fNextFloat;
                }
                float f5 = fNextFloat;
                d dVar3 = !this.b.isEmpty() ? (d) this.b.pop() : new d();
                int i13 = i6;
                while (true) {
                    q(dVar3, i11);
                    int i14 = i13 + 1;
                    dVar = dVar3;
                    i = size2;
                    f = f5;
                    if (!u(i2, i3, i4, i5, dVar3.a, dVar3.b) || i14 >= 4) {
                        break;
                    }
                    f5 = f;
                    dVar3 = dVar;
                    i13 = i14;
                    size2 = i;
                }
                double d2 = ((f * 3.141592653589793d) * 2.0d) - 3.141592653589793d;
                float fCos = (float) Math.cos(d2);
                float fSin = (float) Math.sin(d2);
                dVar.c = fCos;
                dVar.d = fSin;
                dVar.g = 0.0f;
                dVar.f = Math.abs(Utilities.c.nextInt(2000)) + AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
                dVar.e = (f * 6.0f) + 4.0f;
                dVar.h = Utilities.c.nextInt(C.length);
                this.h.add(dVar);
                int i15 = dVar.h;
                this.d[i15][this.f[i15] * 2] = dVar.a;
                this.d[i15][(this.f[i15] * 2) + 1] = dVar.b;
                int[] iArr2 = this.f;
                iArr2[i15] = iArr2[i15] + 1;
                i11++;
                size2 = i;
                i6 = 0;
                f4 = -1.0f;
            }
        }
        for (int length = this.x ? 0 : C.length - 1; length < C.length; length++) {
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < this.h.size(); i18++) {
                d dVar4 = (d) this.h.get(i18);
                RectF rectF = this.g;
                if ((rectF == null || rectF.contains(dVar4.a, dVar4.b)) && (dVar4.h == length || !this.x)) {
                    int i19 = (i18 - i17) * 2;
                    this.d[length][i19] = dVar4.a;
                    this.d[length][i19 + 1] = dVar4.b;
                    i16 += 2;
                } else {
                    i17++;
                }
            }
            canvas.drawPoints(this.d[length], 0, i16, this.a[length]);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        View view = this.i;
        if (view != null) {
            if (view.getParent() == null || !this.v) {
                view.invalidate();
            } else {
                ((View) view.getParent()).invalidate();
            }
        }
    }

    public View r() {
        return this.i;
    }

    public void s(Path path) {
        path.addCircle(this.k, this.l, this.m * AbstractC22000uV3.a(this.n, 0.0f, 1.0f), Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.t = i;
        int i2 = 0;
        while (true) {
            float[] fArr = C;
            if (i2 >= fArr.length) {
                return;
            }
            this.a[i2].setAlpha((int) (fArr[i2] * i));
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!getBounds().contains((int) dVar.a, (int) dVar.b)) {
                it.remove();
            }
            if (this.b.size() < this.c) {
                this.b.push(dVar);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        for (Paint paint : this.a) {
            paint.setColorFilter(colorFilter);
        }
    }

    public float t() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float v(float f) {
        return f;
    }

    class c extends ReplacementSpan {
        final /* synthetic */ R62.c a;

        c(R62.c cVar) {
            this.a = cVar;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return this.a.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        }
    }
}
