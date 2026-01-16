package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.C17561nA3;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.QY0;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.ui.ActionBar.SimpleTextView;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class LinkSpanDrawable {
    private static final ArrayList x = new ArrayList();
    private int a;
    private int b;
    private Paint c;
    private Paint d;
    private int e;
    private int f;
    private final ArrayList g;
    private int h;
    private final CharacterStyle i;
    private final m.h j;
    private final float k;
    private final float l;
    private final Path m;
    private Rect n;
    private float o;
    private long p;
    private long q;
    private final long r;
    private final long s;
    private final boolean t;
    private final float u;
    private final float v;
    private final boolean w;

    public static class ClickableSmallTextView extends SimpleTextView {
        private m.h f1;
        private a g1;
        private Paint h1;
        private LinkSpanDrawable i1;

        public ClickableSmallTextView(Context context) {
            this(context, null);
        }

        private int getLinkColor() {
            return QY0.k(getTextColor(), (int) (Color.alpha(getTextColor()) * 0.1175f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(LinkSpanDrawable linkSpanDrawable) {
            if (this.i1 == linkSpanDrawable) {
                performLongClick();
                this.i1 = null;
                this.g1.e();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.SimpleTextView, android.view.View
        protected void onDraw(Canvas canvas) {
            if (isClickable()) {
                RectF rectF = AbstractC21455b.x;
                rectF.set(0.0f, 0.0f, getPaddingLeft() + getTextWidth() + getPaddingRight(), getHeight());
                this.h1.setColor(getLinkColor());
                canvas.drawRoundRect(rectF, AbstractC21455b.F(4.0f), AbstractC21455b.F(4.0f), this.h1);
            }
            super.onDraw(canvas);
            if (isClickable() && this.g1.g(canvas)) {
                invalidate();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.ActionBar.SimpleTextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!isClickable()) {
                return super.onTouchEvent(motionEvent);
            }
            if (this.g1 != null) {
                if (motionEvent.getAction() == 0) {
                    final LinkSpanDrawable linkSpanDrawable = new LinkSpanDrawable(null, this.f1, motionEvent.getX(), motionEvent.getY());
                    linkSpanDrawable.g(getLinkColor());
                    this.i1 = linkSpanDrawable;
                    this.g1.c(linkSpanDrawable);
                    C17561nA3 c17561nA3D = this.i1.d();
                    c17561nA3D.d(null, 0, 0.0f, 0.0f);
                    c17561nA3D.addRect(0.0f, 0.0f, getPaddingLeft() + getTextWidth() + getPaddingRight(), getHeight(), Path.Direction.CW);
                    AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.FA3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.n(linkSpanDrawable);
                        }
                    }, ViewConfiguration.getLongPressTimeout());
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    this.g1.e();
                    if (this.i1 != null) {
                        performClick();
                    }
                    this.i1 = null;
                    return true;
                }
                if (motionEvent.getAction() == 3) {
                    this.g1.e();
                    this.i1 = null;
                    return true;
                }
            }
            return this.i1 != null || super.onTouchEvent(motionEvent);
        }

        public ClickableSmallTextView(Context context, m.h hVar) {
            super(context);
            this.g1 = new a(this);
            this.h1 = new Paint(1);
            this.f1 = hVar;
        }
    }

    public static class LinksTextView extends AppCompatTextView {
        private boolean h;
        private a i;
        private m.h j;
        private LinkSpanDrawable k;
        private boolean l;
        private boolean m;
        private boolean n;

        public interface a {
        }

        public LinksTextView(Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(LinkSpanDrawable linkSpanDrawable, ClickableSpan clickableSpan) {
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            if (!this.h) {
                canvas.save();
                if (!this.l) {
                    canvas.translate(this.m ? 0.0f : getPaddingLeft(), this.n ? 0.0f : getPaddingTop());
                }
                if (this.i.g(canvas)) {
                    invalidate();
                }
                canvas.restore();
            }
            super.onDraw(canvas);
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.i != null) {
                Layout layout = getLayout();
                final ClickableSpan clickableSpanS = s((int) motionEvent.getX(), (int) motionEvent.getY());
                if (clickableSpanS != null && motionEvent.getAction() == 0) {
                    final LinkSpanDrawable linkSpanDrawable = new LinkSpanDrawable(clickableSpanS, this.j, motionEvent.getX(), motionEvent.getY());
                    this.k = linkSpanDrawable;
                    this.i.c(linkSpanDrawable);
                    SpannableString spannableString = new SpannableString(layout.getText());
                    int spanStart = spannableString.getSpanStart(this.k.c());
                    int spanEnd = spannableString.getSpanEnd(this.k.c());
                    C17561nA3 c17561nA3D = this.k.d();
                    c17561nA3D.c(layout, spanStart, getPaddingTop());
                    layout.getSelectionPath(spanStart, spanEnd, c17561nA3D);
                    AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.IA3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.t(linkSpanDrawable, clickableSpanS);
                        }
                    }, ViewConfiguration.getLongPressTimeout());
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    this.i.e();
                    LinkSpanDrawable linkSpanDrawable2 = this.k;
                    if (linkSpanDrawable2 != null && linkSpanDrawable2.c() == clickableSpanS) {
                        if (this.k.c() != null) {
                            ((ClickableSpan) this.k.c()).onClick(this);
                        }
                        this.k = null;
                        return true;
                    }
                    this.k = null;
                }
                if (motionEvent.getAction() == 3) {
                    this.i.e();
                    this.k = null;
                }
            }
            return this.k != null || super.onTouchEvent(motionEvent);
        }

        public ClickableSpan s(int i, int i2) {
            Layout layout = getLayout();
            if (layout == null) {
                return null;
            }
            int paddingLeft = i - getPaddingLeft();
            int paddingTop = i2 - getPaddingTop();
            int lineForVertical = layout.getLineForVertical(paddingTop);
            float f = paddingLeft;
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
            float lineLeft = layout.getLineLeft(lineForVertical);
            if (lineLeft <= f && lineLeft + layout.getLineWidth(lineForVertical) >= f && paddingTop >= 0 && paddingTop <= layout.getHeight()) {
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) new SpannableString(layout.getText()).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0 && !AbstractC21455b.v0()) {
                    return clickableSpanArr[0];
                }
            }
            return null;
        }

        public void setDisablePaddingsOffset(boolean z) {
            this.l = z;
        }

        public void setDisablePaddingsOffsetX(boolean z) {
            this.m = z;
        }

        public void setDisablePaddingsOffsetY(boolean z) {
            this.n = z;
        }

        public void setOnLinkLongPressListener(a aVar) {
        }

        public void setOnLinkPressListener(a aVar) {
        }

        public LinksTextView(Context context, m.h hVar) {
            super(context);
            this.h = false;
            this.i = new a(this);
            this.j = hVar;
        }
    }

    public LinkSpanDrawable(CharacterStyle characterStyle, m.h hVar, float f, float f2) {
        this(characterStyle, hVar, f, f2, true);
    }

    public boolean b(Canvas canvas) {
        float f;
        int iF = this.w ? 0 : AbstractC21455b.F(4.0f);
        boolean z = this.a != iF;
        if (this.c == null) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.c.setColor(this.b);
            this.e = Color.alpha(this.b);
        }
        if (this.d == null) {
            Paint paint2 = new Paint(1);
            this.d = paint2;
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
            this.d.setColor(this.b);
            this.f = Color.alpha(this.b);
        }
        if (z) {
            this.a = iF;
            if (iF <= 0) {
                this.c.setPathEffect(null);
                this.d.setPathEffect(null);
            } else {
                this.c.setPathEffect(new CornerPathEffect(this.a));
                this.d.setPathEffect(new CornerPathEffect(this.a));
            }
        }
        if (this.n == null && this.h > 0) {
            C17561nA3 c17561nA3 = (C17561nA3) this.g.get(0);
            RectF rectF = AbstractC21455b.x;
            c17561nA3.computeBounds(rectF, false);
            this.n = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            for (int i = 1; i < this.h; i++) {
                C17561nA3 c17561nA32 = (C17561nA3) this.g.get(i);
                RectF rectF2 = AbstractC21455b.x;
                c17561nA32.computeBounds(rectF2, false);
                Rect rect = this.n;
                rect.left = Math.min(rect.left, (int) rectF2.left);
                Rect rect2 = this.n;
                rect2.top = Math.min(rect2.top, (int) rectF2.top);
                Rect rect3 = this.n;
                rect3.right = Math.max(rect3.right, (int) rectF2.right);
                Rect rect4 = this.n;
                rect4.bottom = Math.max(rect4.bottom, (int) rectF2.bottom);
            }
            this.o = (float) Math.sqrt(Math.max(Math.max(Math.pow(this.n.left - this.k, 2.0d) + Math.pow(this.n.top - this.l, 2.0d), Math.pow(this.n.right - this.k, 2.0d) + Math.pow(this.n.top - this.l, 2.0d)), Math.max(Math.pow(this.n.left - this.k, 2.0d) + Math.pow(this.n.bottom - this.l, 2.0d), Math.pow(this.n.right - this.k, 2.0d) + Math.pow(this.n.bottom - this.l, 2.0d))));
        }
        if (this.w) {
            for (int i2 = 0; i2 < this.h; i2++) {
                canvas.drawPath((Path) this.g.get(i2), this.d);
            }
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.p < 0) {
            this.p = jElapsedRealtime;
        }
        float interpolation = InterpolatorC12631ew1.f.getInterpolation(Math.min(1.0f, (jElapsedRealtime - this.p) / this.r));
        float fMin = this.q < 0 ? 0.0f : Math.min(1.0f, Math.max(0.0f, ((jElapsedRealtime - 75) - r12) / 100.0f));
        if (this.t) {
            long j = jElapsedRealtime - this.p;
            long j2 = this.r;
            float fMax = Math.max(0.0f, (j - (j2 * 2)) / (this.s - (j2 * 2)));
            f = (fMax > 1.0f ? 1.0f - (((jElapsedRealtime - this.p) - this.s) / this.r) : fMax * 0.5f) * (1.0f - fMin);
        } else {
            f = 1.0f;
        }
        float f2 = 1.0f - fMin;
        this.c.setAlpha((int) (this.e * 0.2f * Math.min(1.0f, interpolation * 5.0f) * f2));
        float f3 = 1.0f - f;
        this.c.setStrokeWidth(Math.min(1.0f, f3) * AbstractC21455b.F(5.0f));
        for (int i3 = 0; i3 < this.h; i3++) {
            canvas.drawPath((Path) this.g.get(i3), this.c);
        }
        this.d.setAlpha((int) (this.f * 0.8f * f2));
        this.d.setStrokeWidth(Math.min(1.0f, f3) * AbstractC21455b.F(5.0f));
        if (interpolation < 1.0f) {
            float f4 = interpolation * this.o;
            canvas.save();
            this.m.reset();
            this.m.addCircle(this.k, this.l, f4, Path.Direction.CW);
            canvas.clipPath(this.m);
            for (int i4 = 0; i4 < this.h; i4++) {
                canvas.drawPath((Path) this.g.get(i4), this.d);
            }
            canvas.restore();
        } else {
            for (int i5 = 0; i5 < this.h; i5++) {
                canvas.drawPath((Path) this.g.get(i5), this.d);
            }
        }
        return interpolation < 1.0f || this.q >= 0 || (this.t && jElapsedRealtime - this.p < this.s + this.r);
    }

    public CharacterStyle c() {
        return this.i;
    }

    public C17561nA3 d() {
        ArrayList arrayList = x;
        C17561nA3 c17561nA3 = !arrayList.isEmpty() ? (C17561nA3) arrayList.remove(0) : new C17561nA3(true);
        c17561nA3.reset();
        this.g.add(c17561nA3);
        this.h = this.g.size();
        return c17561nA3;
    }

    public void e() {
        this.q = Math.max(this.p + this.r, SystemClock.elapsedRealtime());
    }

    public void f() {
        if (this.g.isEmpty()) {
            return;
        }
        x.addAll(this.g);
        this.g.clear();
        this.h = 0;
    }

    public void g(int i) {
        this.b = i;
        Paint paint = this.c;
        if (paint != null) {
            paint.setColor(i);
            this.e = Color.alpha(i);
        }
        Paint paint2 = this.d;
        if (paint2 != null) {
            paint2.setColor(i);
            this.f = Color.alpha(i);
        }
    }

    public LinkSpanDrawable(CharacterStyle characterStyle, m.h hVar, float f, float f2, boolean z) {
        this.g = new ArrayList();
        this.h = 0;
        this.m = new Path();
        this.p = -1L;
        this.q = -1L;
        this.u = 0.2f;
        this.v = 0.8f;
        this.w = !ir.nasim.tgwidgets.editor.messenger.v.e(33248);
        this.i = characterStyle;
        this.j = hVar;
        g(ir.nasim.tgwidgets.editor.ui.ActionBar.m.j0(ir.nasim.tgwidgets.editor.ui.ActionBar.m.mc, hVar));
        this.k = f;
        this.l = f2;
        long tapTimeout = ViewConfiguration.getTapTimeout();
        long longPressTimeout = ViewConfiguration.getLongPressTimeout();
        this.s = longPressTimeout;
        this.r = (long) Math.min(tapTimeout * 1.8f, longPressTimeout * 0.8f);
        this.t = false;
    }

    public static class a {
        private View a;
        private ArrayList b = new ArrayList();
        private int c = 0;
        private ArrayList d = new ArrayList();
        private int e = 0;

        public a() {
        }

        private void h() {
            j(null, true);
        }

        private void i(Object obj) {
            j(obj, true);
        }

        private void j(Object obj, boolean z) {
            View view;
            if (obj instanceof View) {
                ((View) obj).invalidate();
            } else {
                if (!z || (view = this.a) == null) {
                    return;
                }
                view.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(LinkSpanDrawable linkSpanDrawable) {
            n(linkSpanDrawable, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(LinkSpanDrawable linkSpanDrawable) {
            n(linkSpanDrawable, false);
        }

        private void m(int i, boolean z) {
            if (i < 0 || i >= this.c) {
                return;
            }
            if (!z) {
                Pair pair = (Pair) this.b.remove(i);
                ((LinkSpanDrawable) pair.first).f();
                this.c = this.b.size();
                i(pair.second);
                return;
            }
            Pair pair2 = (Pair) this.b.get(i);
            final LinkSpanDrawable linkSpanDrawable = (LinkSpanDrawable) pair2.first;
            if (linkSpanDrawable.q < 0) {
                linkSpanDrawable.e();
                i(pair2.second);
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.GA3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.l(linkSpanDrawable);
                    }
                }, Math.max(0L, (linkSpanDrawable.q - SystemClock.elapsedRealtime()) + 175));
            }
        }

        public void c(LinkSpanDrawable linkSpanDrawable) {
            d(linkSpanDrawable, null);
        }

        public void d(LinkSpanDrawable linkSpanDrawable, Object obj) {
            this.b.add(new Pair(linkSpanDrawable, obj));
            this.c++;
            i(obj);
        }

        public void e() {
            f(true);
        }

        public void f(boolean z) {
            if (z) {
                for (int i = 0; i < this.c; i++) {
                    m(i, true);
                }
            } else if (this.c > 0) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    ((LinkSpanDrawable) ((Pair) this.b.get(i2)).first).f();
                    j(((Pair) this.b.get(i2)).second, false);
                }
                this.b.clear();
                this.c = 0;
                h();
            }
        }

        public boolean g(Canvas canvas) {
            if (this.e > 0) {
                AbstractC18350oW3.a(((Pair) this.d.get(0)).first);
                throw null;
            }
            boolean z = false;
            for (int i = 0; i < this.c; i++) {
                z = ((LinkSpanDrawable) ((Pair) this.b.get(i)).first).b(canvas) || z;
            }
            return z;
        }

        public void n(final LinkSpanDrawable linkSpanDrawable, boolean z) {
            Pair pair;
            if (linkSpanDrawable == null) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= this.c) {
                    pair = null;
                    break;
                } else {
                    if (((Pair) this.b.get(i)).first == linkSpanDrawable) {
                        pair = (Pair) this.b.get(i);
                        break;
                    }
                    i++;
                }
            }
            if (pair == null) {
                return;
            }
            if (!z) {
                this.b.remove(pair);
                linkSpanDrawable.f();
                this.c = this.b.size();
                i(pair.second);
                return;
            }
            if (linkSpanDrawable.q < 0) {
                linkSpanDrawable.e();
                i(pair.second);
                AbstractC21455b.n1(new Runnable() { // from class: ir.nasim.HA3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k(linkSpanDrawable);
                    }
                }, Math.max(0L, (linkSpanDrawable.q - SystemClock.elapsedRealtime()) + 175));
            }
        }

        public a(View view) {
            this.a = view;
        }
    }
}
