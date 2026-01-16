package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC18106o57;
import ir.nasim.C22477vI7;
import ir.nasim.TI6;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class AnimatedEmojiSpan extends ReplacementSpan {
    public long a;
    public AbstractC18106o57 b;
    private float c;
    public boolean d;
    public boolean e;
    public boolean f;
    private Paint.FontMetricsInt g;
    private float h;
    public int i;
    public String j;
    protected int k;
    boolean l;
    boolean m;
    float n;
    float o;
    private boolean p;
    public boolean q;

    public static class TextViewEmojis extends AppCompatTextView {
        b h;

        public TextViewEmojis(Context context) {
            super(context);
        }

        @Override // android.widget.TextView, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.h = AnimatedEmojiSpan.l(0, this, this.h, getLayout());
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AnimatedEmojiSpan.i(this, this.h);
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            AnimatedEmojiSpan.e(canvas, getLayout(), this.h, 0.0f, null, 0.0f, 0.0f, 0.0f, 1.0f);
        }

        @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.h = AnimatedEmojiSpan.l(0, this, this.h, getLayout());
        }

        @Override // android.widget.TextView
        public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
            super.setText(charSequence, bufferType);
            this.h = AnimatedEmojiSpan.l(0, this, this.h, getLayout());
        }
    }

    public static class a implements c {
        private final View a;
        private final boolean b;
        public Layout c;
        public AnimatedEmojiSpan d;
        public Rect e;
        public C21463b f;
        public boolean g;
        public float h;
        public float i;
        public d j;
        public boolean k;
        private ImageReceiver.a[] l = new ImageReceiver.a[2];

        public a(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        public void d(Canvas canvas, long j, float f, float f2, float f3, ColorFilter colorFilter) {
            if (!(f == 0.0f && f2 == 0.0f) && e(f, f2)) {
                this.g = true;
                return;
            }
            this.g = false;
            if (this.f.l() != null) {
                C21463b c21463b = this.f;
                if (colorFilter == null) {
                    colorFilter = ir.nasim.tgwidgets.editor.ui.ActionBar.m.r2;
                }
                c21463b.setColorFilter(colorFilter);
                this.f.v(j);
                this.f.f(canvas, this.e, f3 * this.i);
            }
        }

        public boolean e(float f, float f2) {
            Rect rect = this.e;
            return ((float) rect.bottom) < f || ((float) rect.top) > f2;
        }

        public void f(long j, int i) {
            C21463b c21463b = this.f;
            if (c21463b == null) {
                return;
            }
            ImageReceiver imageReceiverL = c21463b.l();
            this.f.w(j);
            this.f.setBounds(this.e);
            if (imageReceiverL != null) {
                AnimatedEmojiSpan animatedEmojiSpan = this.d;
                if (animatedEmojiSpan != null && animatedEmojiSpan.b == null && this.f.j() != null) {
                    this.d.b = this.f.j();
                }
                imageReceiverL.setAlpha(this.i);
                imageReceiverL.Z0(this.e);
                ImageReceiver.a[] aVarArr = this.l;
                aVarArr[i] = imageReceiverL.I0(aVarArr[i], i);
                ImageReceiver.a aVar = this.l[i];
                aVar.b = this.i;
                aVar.I(this.e);
                this.l[i].c = j;
            }
        }

        public void g(int i) {
            ImageReceiver.a aVar = this.l[i];
            if (aVar != null) {
                aVar.H();
            }
        }

        @Override // ir.nasim.tgwidgets.editor.ui.Components.AnimatedEmojiSpan.c
        public void invalidate() {
            View view = this.a;
            if (view != null) {
                if (!this.b || view.getParent() == null) {
                    this.a.invalidate();
                } else {
                    ((View) this.a.getParent()).invalidate();
                }
            }
        }
    }

    public static class b {
        public ArrayList a = new ArrayList();
        HashMap b = new HashMap();
        ArrayList c = new ArrayList();

        public void a(Layout layout, a aVar) {
            this.a.add(aVar);
            d dVar = (d) this.b.get(layout);
            if (dVar == null) {
                dVar = new d(aVar.a, layout, aVar.b);
                this.b.put(layout, dVar);
                this.c.add(dVar);
            }
            dVar.a(aVar);
            aVar.f.d(aVar);
        }

        public void b() {
            for (int i = 0; i < this.a.size(); i++) {
                ((a) this.a.get(i)).d.l = false;
            }
        }

        public void c(boolean z) {
            for (int i = 0; i < this.a.size(); i++) {
                ((a) this.a.get(i)).d.p = z;
            }
        }

        public void d() {
            while (this.a.size() > 0) {
                e(0);
            }
        }

        public void e(int i) {
            a aVar = (a) this.a.remove(i);
            d dVar = (d) this.b.get(aVar.c);
            if (dVar == null) {
                throw new RuntimeException("!!!");
            }
            dVar.d(aVar);
            if (dVar.c.isEmpty()) {
                this.b.remove(aVar.c);
                this.c.remove(dVar);
            }
            aVar.f.u(aVar);
        }
    }

    public interface c {
        void invalidate();
    }

    private static class d {
        Layout a;
        final View b;
        ArrayList c = new ArrayList();
        j d;
        private boolean e;

        class a extends j {
            private final ArrayList x = new ArrayList();

            a() {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.j
            public void f(Canvas canvas) {
                for (int i = 0; i < this.x.size(); i++) {
                    a aVar = (a) this.x.get(i);
                    if (aVar != null && aVar.l[this.v] != null) {
                        aVar.f.g(canvas, aVar.l[this.v], true);
                    }
                }
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.j
            public void g(Canvas canvas, float f) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < d.this.c.size(); i++) {
                    a aVar = (a) d.this.c.get(i);
                    if (aVar.d.l) {
                        aVar.d(canvas, jCurrentTimeMillis, 0.0f, 0.0f, f, null);
                    }
                }
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.j
            public void j() {
                for (int i = 0; i < this.x.size(); i++) {
                    if (this.x.get(i) != null) {
                        ((a) this.x.get(i)).g(this.v);
                    }
                }
                this.x.clear();
                View view = d.this.b;
                if (view == null || view.getParent() == null) {
                    return;
                }
                ((View) d.this.b.getParent()).invalidate();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.j
            public void k() {
                super.k();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.j
            public void l() {
                View view = d.this.b;
                if (view == null || view.getParent() == null) {
                    return;
                }
                ((View) d.this.b.getParent()).invalidate();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.Components.j
            public void m(long j) {
                this.x.clear();
                this.x.addAll(d.this.c);
                int i = 0;
                while (i < this.x.size()) {
                    a aVar = (a) this.x.get(i);
                    if (aVar.d.l) {
                        aVar.f(j, this.v);
                    } else {
                        this.x.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        public d(View view, Layout layout, boolean z) {
            this.a = layout;
            this.b = view;
            this.e = z;
        }

        private void b() {
            j jVar;
            if (this.e && this.c.size() >= 10 && this.d == null && ir.nasim.tgwidgets.editor.messenger.v.e(16388)) {
                a aVar = new a();
                this.d = aVar;
                aVar.n = AbstractC21455b.F(3.0f);
                this.d.h();
                return;
            }
            if (this.c.size() >= 10 || (jVar = this.d) == null) {
                return;
            }
            jVar.i();
            this.d = null;
        }

        public void a(a aVar) {
            this.c.add(aVar);
            aVar.j = this;
            b();
        }

        public void c(Canvas canvas, List list, long j, float f, float f2, float f3, float f4, ColorFilter colorFilter) {
            C21463b c21463b;
            for (int i = 0; i < this.c.size(); i++) {
                a aVar = (a) this.c.get(i);
                if (aVar != null && (c21463b = aVar.f) != null) {
                    c21463b.setColorFilter(colorFilter);
                    AnimatedEmojiSpan animatedEmojiSpan = aVar.d;
                    if (animatedEmojiSpan.l) {
                        float f5 = animatedEmojiSpan.k / 2.0f;
                        float f6 = animatedEmojiSpan.n;
                        float f7 = animatedEmojiSpan.o;
                        aVar.e.set((int) (f6 - f5), (int) (f7 - f5), (int) (f6 + f5), (int) (f7 + f5));
                        float fMax = (list == null || list.isEmpty() || !aVar.k) ? 1.0f : Math.max(0.0f, ((TI6) list.get(0)).t());
                        aVar.h = f3;
                        aVar.i = fMax;
                        if (this.d == null) {
                            aVar.d(canvas, j, f, f2, f4, colorFilter);
                        }
                    }
                }
            }
            j jVar = this.d;
            if (jVar != null) {
                jVar.d(canvas, j, this.a.getWidth(), this.a.getHeight() + AbstractC21455b.F(2.0f), f4);
            }
        }

        public void d(a aVar) {
            this.c.remove(aVar);
            aVar.j = null;
            b();
        }
    }

    public AnimatedEmojiSpan(AbstractC18106o57 abstractC18106o57, Paint.FontMetricsInt fontMetricsInt) {
        this(abstractC18106o57.c, 1.2f, fontMetricsInt);
        this.b = abstractC18106o57;
    }

    public static AnimatedEmojiSpan c(AnimatedEmojiSpan animatedEmojiSpan) {
        AbstractC18106o57 abstractC18106o57 = animatedEmojiSpan.b;
        AnimatedEmojiSpan animatedEmojiSpan2 = abstractC18106o57 != null ? new AnimatedEmojiSpan(abstractC18106o57, animatedEmojiSpan.g) : new AnimatedEmojiSpan(animatedEmojiSpan.a, animatedEmojiSpan.c, animatedEmojiSpan.g);
        animatedEmojiSpan2.q = animatedEmojiSpan.q;
        return animatedEmojiSpan2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.text.SpannableString] */
    public static CharSequence d(CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return charSequence;
        }
        Spanned spanned = (Spanned) charSequence;
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class);
        if (characterStyleArr != null && characterStyleArr.length > 0) {
            AnimatedEmojiSpan[] animatedEmojiSpanArr = (AnimatedEmojiSpan[]) spanned.getSpans(0, spanned.length(), AnimatedEmojiSpan.class);
            if (animatedEmojiSpanArr != null && animatedEmojiSpanArr.length <= 0) {
                return charSequence;
            }
            charSequence = new SpannableString(spanned);
            for (int i = 0; i < characterStyleArr.length; i++) {
                CharacterStyle characterStyle = characterStyleArr[i];
                if (characterStyle != null && (characterStyle instanceof AnimatedEmojiSpan)) {
                    int spanStart = spanned.getSpanStart(characterStyle);
                    int spanEnd = spanned.getSpanEnd(characterStyleArr[i]);
                    AnimatedEmojiSpan animatedEmojiSpan = (AnimatedEmojiSpan) characterStyleArr[i];
                    charSequence.removeSpan(animatedEmojiSpan);
                    charSequence.setSpan(c(animatedEmojiSpan), spanStart, spanEnd, 33);
                }
            }
        }
        return charSequence;
    }

    public static void e(Canvas canvas, Layout layout, b bVar, float f, List list, float f2, float f3, float f4, float f5) {
        f(canvas, layout, bVar, f, list, f2, f3, f4, f5, null);
    }

    public static void f(Canvas canvas, Layout layout, b bVar, float f, List list, float f2, float f3, float f4, float f5, ColorFilter colorFilter) {
        if (canvas == null || layout == null || bVar == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < bVar.c.size(); i++) {
            d dVar = (d) bVar.c.get(i);
            if (dVar.a == layout) {
                dVar.c(canvas, list, jCurrentTimeMillis, f2, f3, f4, f5, colorFilter);
                return;
            }
        }
    }

    private static boolean h(Layout layout, int i, int i2) {
        if (layout != null && (layout.getText() instanceof Spanned)) {
            G[] gArr = (G[]) ((Spanned) layout.getText()).getSpans(Math.max(0, i), Math.min(layout.getText().length() - 1, i2), G.class);
            for (int i3 = 0; gArr != null && i3 < gArr.length; i3++) {
                G g = gArr[i3];
                if (g != null && g.a()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void i(View view, b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.d();
    }

    public static b l(int i, View view, b bVar, Layout... layoutArr) {
        return n(i, view, false, bVar, layoutArr);
    }

    public static b m(int i, View view, boolean z, b bVar, boolean z2, Layout... layoutArr) {
        AnimatedEmojiSpan[] animatedEmojiSpanArr;
        a aVar;
        int i2;
        b bVar2 = bVar;
        if (layoutArr == null || layoutArr.length <= 0) {
            if (bVar2 == null) {
                return null;
            }
            bVar2.a.clear();
            bVar.d();
            return null;
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 < layoutArr.length) {
            Layout layout = layoutArr[i4];
            if (layout == null || !(layout.getText() instanceof Spanned)) {
                animatedEmojiSpanArr = null;
            } else {
                Spanned spanned = (Spanned) layout.getText();
                animatedEmojiSpanArr = (AnimatedEmojiSpan[]) spanned.getSpans(i3, spanned.length(), AnimatedEmojiSpan.class);
                int i5 = i3;
                while (animatedEmojiSpanArr != null && i5 < animatedEmojiSpanArr.length) {
                    AnimatedEmojiSpan animatedEmojiSpanC = animatedEmojiSpanArr[i5];
                    if (animatedEmojiSpanC != null) {
                        if (z2 && (layout.getText() instanceof Spannable)) {
                            int spanStart = spanned.getSpanStart(animatedEmojiSpanC);
                            int spanEnd = spanned.getSpanEnd(animatedEmojiSpanC);
                            Spannable spannable = (Spannable) spanned;
                            spannable.removeSpan(animatedEmojiSpanC);
                            animatedEmojiSpanC = c(animatedEmojiSpanC);
                            spannable.setSpan(animatedEmojiSpanC, spanStart, spanEnd, 33);
                        }
                        if (bVar2 == null) {
                            bVar2 = new b();
                        }
                        int i6 = i3;
                        while (true) {
                            if (i6 >= bVar2.a.size()) {
                                aVar = null;
                                break;
                            }
                            if (((a) bVar2.a.get(i6)).d == animatedEmojiSpanC && ((a) bVar2.a.get(i6)).c == layout) {
                                aVar = (a) bVar2.a.get(i6);
                                break;
                            }
                            i6++;
                        }
                        if (aVar == null) {
                            a aVar2 = new a(view, z);
                            aVar2.c = layout;
                            if (animatedEmojiSpanC.d) {
                                i2 = 8;
                            } else {
                                i2 = animatedEmojiSpanC.i;
                                if (i2 < 0) {
                                    i2 = i;
                                }
                            }
                            if (animatedEmojiSpanC.j != null) {
                                aVar2.f = C21463b.r(C22477vI7.f, i2, animatedEmojiSpanC.g(), animatedEmojiSpanC.j);
                            } else {
                                AbstractC18106o57 abstractC18106o57 = animatedEmojiSpanC.b;
                                if (abstractC18106o57 != null) {
                                    aVar2.f = C21463b.s(C22477vI7.f, i2, abstractC18106o57);
                                } else {
                                    aVar2.f = C21463b.q(C22477vI7.f, i2, animatedEmojiSpanC.a);
                                }
                            }
                            aVar2.k = h(layout, spanned.getSpanStart(animatedEmojiSpanC), spanned.getSpanEnd(animatedEmojiSpanC));
                            aVar2.e = new Rect();
                            aVar2.d = animatedEmojiSpanC;
                            bVar2.a(layout, aVar2);
                        } else {
                            aVar.k = h(layout, spanned.getSpanStart(animatedEmojiSpanC), spanned.getSpanEnd(animatedEmojiSpanC));
                        }
                    }
                    i5++;
                    i3 = 0;
                }
            }
            if (bVar2 != null) {
                int i7 = 0;
                while (i7 < bVar2.a.size()) {
                    if (((a) bVar2.a.get(i7)).c == layout) {
                        AnimatedEmojiSpan animatedEmojiSpan = ((a) bVar2.a.get(i7)).d;
                        for (int i8 = 0; animatedEmojiSpanArr != null && i8 < animatedEmojiSpanArr.length; i8++) {
                            if (animatedEmojiSpanArr[i8] == animatedEmojiSpan) {
                                break;
                            }
                        }
                        bVar2.e(i7);
                        i7--;
                    }
                    i7++;
                }
            }
            i4++;
            i3 = 0;
        }
        if (bVar2 != null) {
            int i9 = 0;
            while (i9 < bVar2.a.size()) {
                Layout layout2 = ((a) bVar2.a.get(i9)).c;
                int i10 = 0;
                while (true) {
                    if (i10 >= layoutArr.length) {
                        bVar2.e(i9);
                        i9--;
                        break;
                    }
                    if (layoutArr[i10] == layout2) {
                        break;
                    }
                    i10++;
                }
                i9++;
            }
        }
        return bVar2;
    }

    public static b n(int i, View view, boolean z, b bVar, Layout... layoutArr) {
        return m(i, view, z, bVar, false, layoutArr);
    }

    public void b(Paint.FontMetricsInt fontMetricsInt, int i) {
        this.g = fontMetricsInt;
        this.i = i;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.p) {
            this.l = true;
            float f2 = f + (this.k / 2.0f);
            float f3 = i3 + ((i5 - i3) / 2.0f);
            if (f2 == this.n && f3 == this.o) {
                return;
            }
            this.n = f2;
            this.o = f3;
            this.m = true;
        }
    }

    public long g() {
        AbstractC18106o57 abstractC18106o57 = this.b;
        return abstractC18106o57 != null ? abstractC18106o57.c : this.a;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt == null && this.f) {
            fontMetricsInt = paint.getFontMetricsInt();
        }
        int i3 = fontMetricsInt == null ? 0 : fontMetricsInt.ascent;
        int i4 = fontMetricsInt == null ? 0 : fontMetricsInt.descent;
        Paint.FontMetricsInt fontMetricsInt2 = this.g;
        if (fontMetricsInt2 == null) {
            int i5 = (int) this.h;
            int iF = AbstractC21455b.F(8.0f);
            int iF2 = AbstractC21455b.F(10.0f);
            if (fontMetricsInt != null) {
                float f = (-iF2) - iF;
                float f2 = this.c;
                fontMetricsInt.top = (int) (f * f2);
                float f3 = iF2 - iF;
                fontMetricsInt.bottom = (int) (f3 * f2);
                fontMetricsInt.ascent = (int) (f * f2);
                fontMetricsInt.descent = (int) (f3 * f2);
                fontMetricsInt.leading = 0;
            }
            this.k = (int) (i5 * this.c);
        } else {
            this.k = (int) (this.h * this.c);
            if (fontMetricsInt != null) {
                if (this.e) {
                    float fAbs = Math.abs(fontMetricsInt2.bottom) + Math.abs(this.g.top);
                    fontMetricsInt.ascent = (int) Math.ceil((this.g.top / fAbs) * this.k);
                    fontMetricsInt.descent = (int) Math.ceil((this.g.bottom / fAbs) * this.k);
                    fontMetricsInt.top = (int) Math.ceil((this.g.top / fAbs) * this.k);
                    fontMetricsInt.bottom = (int) Math.ceil((this.g.bottom / fAbs) * this.k);
                } else {
                    fontMetricsInt.ascent = fontMetricsInt2.ascent;
                    fontMetricsInt.descent = fontMetricsInt2.descent;
                    fontMetricsInt.top = fontMetricsInt2.top;
                    fontMetricsInt.bottom = fontMetricsInt2.bottom;
                }
            }
        }
        if (fontMetricsInt != null && this.f) {
            int i6 = fontMetricsInt.ascent;
            int i7 = fontMetricsInt.descent;
            int i8 = ((i3 - i6) + (i4 - i7)) / 2;
            fontMetricsInt.ascent = i6 + i8;
            fontMetricsInt.descent = i7 - i8;
        }
        return this.k - 1;
    }

    public void j(Paint.FontMetricsInt fontMetricsInt) {
        this.g = fontMetricsInt;
        if (fontMetricsInt != null) {
            float fAbs = Math.abs(fontMetricsInt.descent) + Math.abs(this.g.ascent);
            this.h = fAbs;
            if (fAbs == 0.0f) {
                this.h = AbstractC21455b.F(20.0f);
            }
        }
    }

    public void k(Paint.FontMetricsInt fontMetricsInt, int i, int i2) {
        this.g = fontMetricsInt;
        this.h = i;
        this.i = i2;
    }

    public AnimatedEmojiSpan(long j, Paint.FontMetricsInt fontMetricsInt) {
        this(j, 1.2f, fontMetricsInt);
    }

    public AnimatedEmojiSpan(long j, float f, Paint.FontMetricsInt fontMetricsInt) {
        this.e = false;
        this.f = false;
        this.h = AbstractC21455b.F(20.0f);
        this.i = -1;
        this.p = true;
        this.a = j;
        this.c = f;
        this.g = fontMetricsInt;
        if (fontMetricsInt != null) {
            float fAbs = Math.abs(fontMetricsInt.descent) + Math.abs(fontMetricsInt.ascent);
            this.h = fAbs;
            if (fAbs == 0.0f) {
                this.h = AbstractC21455b.F(20.0f);
            }
        }
    }
}
