package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/* loaded from: classes7.dex */
public class AnimatedTextView extends View {
    private final a a;
    private int b;
    private int c;
    private CharSequence d;
    private boolean e;
    public boolean f;
    private boolean g;

    public static class a extends Drawable {
        private boolean A;
        public boolean B;
        public boolean C;
        private int D;
        private float E;
        private boolean F;
        private LinearGradient G;
        private Matrix H;
        private Paint I;
        private boolean J;
        private float K;
        private float L;
        private float M;
        private int N;
        private final TextPaint a;
        private int b;
        private boolean c;
        private float d;
        private float e;
        private b[] f;
        private CharSequence g;
        private float h;
        private float i;
        private b[] j;
        private CharSequence k;
        private float l;
        private boolean m;
        private ValueAnimator n;
        private CharSequence o;
        private boolean p;
        private long q;
        private long r;
        private TimeInterpolator s;
        private float t;
        private int u;
        private final Rect v;
        private boolean w;
        private boolean x;
        private boolean y;
        private Runnable z;

        /* renamed from: ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView$a$a, reason: collision with other inner class name */
        class C1584a extends AnimatorListenerAdapter {
            C1584a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.j = null;
                a.this.k = null;
                a.this.h = 0.0f;
                a.this.l = 0.0f;
                a.this.invalidateSelf();
                a.this.n = null;
                if (a.this.o == null) {
                    if (a.this.z != null) {
                        a.this.z.run();
                    }
                } else {
                    a aVar = a.this;
                    aVar.Q(aVar.o, true, a.this.p);
                    a.this.o = null;
                    a.this.p = false;
                }
            }
        }

        private static class b {
            StaticLayout a;
            float b;
            int c;
            float d;
            float e;

            public b(StaticLayout staticLayout, float f, int i) {
                this.a = staticLayout;
                this.b = f;
                this.c = i;
                float lineWidth = 0.0f;
                this.d = (staticLayout == null || staticLayout.getLineCount() <= 0) ? 0.0f : staticLayout.getLineLeft(0);
                if (staticLayout != null && staticLayout.getLineCount() > 0) {
                    lineWidth = staticLayout.getLineWidth(0);
                }
                this.e = lineWidth;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        interface c {
            void a(CharSequence charSequence, int i, int i2);
        }

        private static class d implements CharSequence {
            private final CharSequence[] a;
            private final int b;

            public d(CharSequence charSequence) {
                if (charSequence == null) {
                    this.a = new CharSequence[0];
                    this.b = 0;
                    return;
                }
                this.b = charSequence.length();
                int i = 0;
                for (int i2 = 0; i2 < this.b; i2++) {
                    if (charSequence.charAt(i2) == ' ') {
                        i++;
                    }
                }
                this.a = new CharSequence[i + 1];
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int i6 = this.b;
                    if (i3 > i6) {
                        return;
                    }
                    if (i3 == i6 || charSequence.charAt(i3) == ' ') {
                        int i7 = i4 + 1;
                        this.a[i4] = charSequence.subSequence(i5, (i3 < this.b ? 1 : 0) + i3);
                        i5 = i3 + 1;
                        i4 = i7;
                    }
                    i3++;
                }
            }

            public CharSequence a() {
                return TextUtils.concat(this.a);
            }

            public CharSequence b(int i) {
                if (i < 0) {
                    return null;
                }
                CharSequence[] charSequenceArr = this.a;
                if (i >= charSequenceArr.length) {
                    return null;
                }
                return charSequenceArr[i];
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                int i2 = 0;
                while (true) {
                    CharSequence[] charSequenceArr = this.a;
                    if (i2 >= charSequenceArr.length) {
                        return (char) 0;
                    }
                    if (i < charSequenceArr[i2].length()) {
                        return this.a[i2].charAt(i);
                    }
                    i -= this.a[i2].length();
                    i2++;
                }
            }

            @Override // java.lang.CharSequence
            public IntStream chars() {
                return a().chars();
            }

            @Override // java.lang.CharSequence
            public IntStream codePoints() {
                return a().codePoints();
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return TextUtils.concat((CharSequence[]) Arrays.copyOfRange(this.a, i, i2));
            }

            @Override // java.lang.CharSequence
            public String toString() {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                while (true) {
                    CharSequence[] charSequenceArr = this.a;
                    if (i >= charSequenceArr.length) {
                        return sb.toString();
                    }
                    sb.append(charSequenceArr[i]);
                    i++;
                }
            }
        }

        public a() {
            this(false, false, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i, ArrayList arrayList, ArrayList arrayList2, CharSequence charSequence, int i2, int i3) {
            StaticLayout staticLayoutE = E(charSequence, i - ((int) Math.ceil(Math.min(this.d, this.h))));
            b bVar = new b(staticLayoutE, this.d, arrayList.size());
            b bVar2 = new b(staticLayoutE, this.h, arrayList.size());
            arrayList2.add(bVar);
            arrayList.add(bVar2);
            float f = bVar.e;
            this.d += f;
            this.h += f;
            this.e = Math.max(this.e, staticLayoutE.getHeight());
            this.i = Math.max(this.i, staticLayoutE.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void B(int i, ArrayList arrayList, CharSequence charSequence, int i2, int i3) {
            b bVar = new b(E(charSequence, i - ((int) Math.ceil(this.d))), this.d, -1);
            arrayList.add(bVar);
            this.d += bVar.e;
            this.e = Math.max(this.e, r1.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void C(int i, ArrayList arrayList, CharSequence charSequence, int i2, int i3) {
            b bVar = new b(E(charSequence, i - ((int) Math.ceil(this.h))), this.h, -1);
            arrayList.add(bVar);
            this.h += bVar.e;
            this.i = Math.max(this.i, r1.getHeight());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void D(ValueAnimator valueAnimator) {
            this.l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            invalidateSelf();
        }

        private StaticLayout E(CharSequence charSequence, int i) {
            if (i <= 0) {
                Point point = AbstractC21455b.h;
                i = Math.min(point.x, point.y);
            }
            return StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.a, i).setMaxLines(1).setLineSpacing(0.0f, 1.0f).setAlignment(Layout.Alignment.ALIGN_NORMAL).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(i).build();
        }

        public static boolean F(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
            if (!(charSequence instanceof d) || !(charSequence2 instanceof d)) {
                return (charSequence == null && charSequence2 == null) || !(charSequence == null || charSequence2 == null || charSequence.charAt(i) != charSequence2.charAt(i2));
            }
            CharSequence charSequenceB = ((d) charSequence).b(i);
            CharSequence charSequenceB2 = ((d) charSequence2).b(i2);
            return (charSequenceB == null && charSequenceB2 == null) || (charSequenceB != null && charSequenceB.equals(charSequenceB2));
        }

        private void q(float f) {
            this.a.setAlpha((int) (this.u * f));
            if (this.J) {
                this.a.setShadowLayer(this.K, this.L, this.M, ir.nasim.tgwidgets.editor.ui.ActionBar.m.Q0(this.N, f));
            }
        }

        private void s(CharSequence charSequence, CharSequence charSequence2, c cVar, c cVar2, c cVar3) {
            boolean z = false;
            if (this.C) {
                cVar3.a(charSequence, 0, charSequence.length());
                cVar2.a(charSequence2, 0, charSequence2.length());
                return;
            }
            if (!this.x) {
                int iMin = Math.min(charSequence2.length(), charSequence.length());
                int length = 0;
                int length2 = 0;
                int i = 0;
                int i2 = 0;
                boolean z2 = true;
                while (length <= iMin) {
                    boolean z3 = (length >= iMin || !F(charSequence2, charSequence, length, length2)) ? z : true;
                    if (z2 != z3 || length == iMin) {
                        if (length == iMin) {
                            length = charSequence2.length();
                            length2 = charSequence.length();
                        }
                        int i3 = length - i;
                        int i4 = length2 - i2;
                        if (i3 > 0 || i4 > 0) {
                            if (i3 == i4 && z2) {
                                cVar.a(charSequence2.subSequence(i, length), i, length);
                            } else {
                                if (i3 > 0) {
                                    cVar2.a(charSequence2.subSequence(i, length), i, length);
                                }
                                if (i4 > 0) {
                                    cVar3.a(charSequence.subSequence(i2, length2), i2, length2);
                                }
                            }
                        }
                        i = length;
                        i2 = length2;
                        z2 = z3;
                    }
                    if (z3) {
                        length2++;
                    }
                    length++;
                    z = false;
                }
                return;
            }
            int iMin2 = Math.min(charSequence2.length(), charSequence.length());
            if (!this.y) {
                int i5 = 0;
                int i6 = 0;
                boolean z4 = true;
                while (i5 <= iMin2) {
                    boolean z5 = i5 < iMin2 && F(charSequence2, charSequence, i5, i5);
                    if (z4 != z5 || i5 == iMin2) {
                        if (i5 - i6 > 0) {
                            if (z4) {
                                cVar.a(charSequence2.subSequence(i6, i5), i6, i5);
                            } else {
                                cVar2.a(charSequence2.subSequence(i6, i5), i6, i5);
                                cVar3.a(charSequence.subSequence(i6, i5), i6, i5);
                            }
                        }
                        i6 = i5;
                        z4 = z5;
                    }
                    i5++;
                }
                if (charSequence2.length() - iMin2 > 0) {
                    cVar2.a(charSequence2.subSequence(iMin2, charSequence2.length()), iMin2, charSequence2.length());
                }
                if (charSequence.length() - iMin2 > 0) {
                    cVar3.a(charSequence.subSequence(iMin2, charSequence.length()), iMin2, charSequence.length());
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i7 = 0;
            boolean z6 = true;
            boolean z7 = true;
            for (int i8 = 0; i8 <= iMin2; i8++) {
                int length3 = (charSequence2.length() - i8) - 1;
                int length4 = (charSequence.length() - i8) - 1;
                boolean z8 = length3 >= 0 && length4 >= 0 && F(charSequence2, charSequence, length3, length4);
                if (z6 != z8 || i8 == iMin2) {
                    int i9 = i8 - i7;
                    if (i9 > 0) {
                        if (arrayList.size() != 0) {
                            z6 = z7;
                        }
                        arrayList.add(Integer.valueOf(i9));
                        z7 = z6;
                    }
                    i7 = i8;
                    z6 = z8;
                }
            }
            int length5 = charSequence2.length() - iMin2;
            int length6 = charSequence.length() - iMin2;
            if (length5 > 0) {
                cVar2.a(charSequence2.subSequence(0, length5), 0, length5);
            }
            if (length6 > 0) {
                cVar3.a(charSequence.subSequence(0, length6), 0, length6);
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int iIntValue = ((Integer) arrayList.get(size)).intValue();
                if ((size % 2 == 0) != z7) {
                    int i10 = length5 + iIntValue;
                    cVar2.a(charSequence2.subSequence(length5, i10), length5, i10);
                    int i11 = length6 + iIntValue;
                    cVar3.a(charSequence.subSequence(length6, i11), length6, i11);
                } else if (charSequence2.length() > charSequence.length()) {
                    int i12 = length5 + iIntValue;
                    cVar.a(charSequence2.subSequence(length5, i12), length5, i12);
                } else {
                    int i13 = length6 + iIntValue;
                    cVar.a(charSequence.subSequence(length6, i13), length6, i13);
                }
                length5 += iIntValue;
                length6 += iIntValue;
            }
        }

        public void G(float f, long j, long j2, TimeInterpolator timeInterpolator) {
            this.t = f;
            this.q = j;
            this.r = j2;
            this.s = timeInterpolator;
        }

        public void H(boolean z) {
            this.F = z;
            invalidateSelf();
        }

        public void I(int i) {
            this.b = i;
        }

        public void J(boolean z, boolean z2, boolean z3) {
            this.w = z;
            this.x = z2;
            this.y = z3;
        }

        public void K(Runnable runnable) {
            this.z = runnable;
        }

        public void L(int i) {
            this.D = i;
        }

        public void M(float f) {
            this.E = f;
            invalidateSelf();
        }

        public void N(float f, float f2, float f3, int i) {
            this.J = true;
            TextPaint textPaint = this.a;
            this.K = f;
            this.L = f2;
            this.M = f3;
            this.N = i;
            textPaint.setShadowLayer(f, f2, f3, i);
        }

        public void O(CharSequence charSequence) {
            P(charSequence, true);
        }

        public void P(CharSequence charSequence, boolean z) {
            Q(charSequence, z, true);
        }

        public void Q(CharSequence charSequence, boolean z, boolean z2) {
            if (this.g == null || charSequence == null) {
                z = false;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            final int iWidth = this.D;
            if (iWidth <= 0) {
                iWidth = this.v.width();
            }
            if (!z) {
                ValueAnimator valueAnimator = this.n;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.n = null;
                this.o = null;
                this.p = false;
                this.l = 0.0f;
                if (!charSequence.equals(this.g)) {
                    this.f = new b[]{new b(E(charSequence, iWidth), 0.0f, -1)};
                    this.g = charSequence;
                    this.d = this.f[0].e;
                    this.e = r11.a.getHeight();
                    this.c = AbstractC21455b.D0(this.g);
                }
                this.j = null;
                this.k = null;
                this.h = 0.0f;
                this.i = 0.0f;
                invalidateSelf();
                return;
            }
            if (this.A) {
                ValueAnimator valueAnimator2 = this.n;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                    this.n = null;
                }
            } else if (z()) {
                this.o = charSequence;
                this.p = z2;
                return;
            }
            if (charSequence.equals(this.g)) {
                return;
            }
            this.k = this.g;
            this.g = charSequence;
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            this.e = 0.0f;
            this.d = 0.0f;
            this.i = 0.0f;
            this.h = 0.0f;
            this.c = AbstractC21455b.D0(this.g);
            s(this.w ? new d(this.k) : this.k, this.w ? new d(this.g) : this.g, new c() { // from class: ir.nasim.tgwidgets.editor.ui.Components.e
                @Override // ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView.a.c
                public final void a(CharSequence charSequence2, int i, int i2) {
                    this.a.A(iWidth, arrayList2, arrayList, charSequence2, i, i2);
                }
            }, new c() { // from class: ir.nasim.tgwidgets.editor.ui.Components.f
                @Override // ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView.a.c
                public final void a(CharSequence charSequence2, int i, int i2) {
                    this.a.B(iWidth, arrayList, charSequence2, i, i2);
                }
            }, new c() { // from class: ir.nasim.tgwidgets.editor.ui.Components.g
                @Override // ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView.a.c
                public final void a(CharSequence charSequence2, int i, int i2) {
                    this.a.C(iWidth, arrayList2, charSequence2, i, i2);
                }
            });
            b[] bVarArr = this.f;
            if (bVarArr == null || bVarArr.length != arrayList.size()) {
                this.f = new b[arrayList.size()];
            }
            arrayList.toArray(this.f);
            b[] bVarArr2 = this.j;
            if (bVarArr2 == null || bVarArr2.length != arrayList2.size()) {
                this.j = new b[arrayList2.size()];
            }
            arrayList2.toArray(this.j);
            ValueAnimator valueAnimator3 = this.n;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
            this.m = z2;
            this.l = 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.n = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.pt
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    this.a.D(valueAnimator4);
                }
            });
            this.n.addListener(new C1584a());
            this.n.setStartDelay(this.q);
            this.n.setDuration(this.r);
            this.n.setInterpolator(this.s);
            this.n.start();
        }

        public void R(int i) {
            this.a.setColor(i);
            this.u = Color.alpha(i);
        }

        public void S(float f) {
            this.a.setTextSize(f);
        }

        public void T(Typeface typeface) {
            this.a.setTypeface(typeface);
        }

        /* JADX WARN: Removed duplicated region for block: B:81:0x016c  */
        @Override // android.graphics.drawable.Drawable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void draw(android.graphics.Canvas r18) {
            /*
                Method dump skipped, instructions count: 616
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.AnimatedTextView.a.draw(android.graphics.Canvas):void");
        }

        @Override // android.graphics.drawable.Drawable
        public Rect getDirtyBounds() {
            return this.v;
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        public void r() {
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.u = i;
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(Rect rect) {
            super.setBounds(rect);
            this.v.set(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.a.setColorFilter(colorFilter);
        }

        public float t() {
            return (this.f == null || this.j == null) ? this.d : AbstractC21455b.T0(this.h, this.d, this.l);
        }

        public float u() {
            return this.e;
        }

        public TextPaint v() {
            return this.a;
        }

        public CharSequence w() {
            return this.g;
        }

        public int x() {
            return this.a.getColor();
        }

        public float y() {
            return Math.max(this.d, this.h);
        }

        public boolean z() {
            ValueAnimator valueAnimator = this.n;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        public a(boolean z, boolean z2, boolean z3) {
            this.a = new TextPaint(1);
            this.b = 0;
            this.c = false;
            this.l = 0.0f;
            this.m = true;
            this.q = 0L;
            this.r = 450L;
            this.s = InterpolatorC12631ew1.h;
            this.t = 1.0f;
            this.u = 255;
            this.v = new Rect();
            this.J = false;
            this.w = z;
            this.x = z2;
            this.y = z3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            this.v.set(i, i2, i3, i4);
        }
    }

    public AnimatedTextView(Context context) {
        this(context, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        CharSequence charSequence = this.d;
        if (charSequence != null) {
            setText(charSequence, this.e, true);
            this.d = null;
            this.e = false;
        }
    }

    public a getDrawable() {
        return this.a;
    }

    public TextPaint getPaint() {
        return this.a.v();
    }

    public CharSequence getText() {
        return this.a.w();
    }

    public int getTextColor() {
        return this.a.x();
    }

    public int getTextHeight() {
        return getPaint().getFontMetricsInt().descent - getPaint().getFontMetricsInt().ascent;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.a.setBounds(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
        this.a.draw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.TextView");
        accessibilityNodeInfo.setText(getText());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.c;
        if (i3 > 0) {
            size = Math.min(size, i3);
        }
        if (this.b != size && getLayoutParams().width != 0) {
            this.a.setBounds(getPaddingLeft(), getPaddingTop(), size - getPaddingRight(), size2 - getPaddingBottom());
            setText(this.a.w(), false);
        }
        this.b = size;
        if (this.f && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            size = getPaddingRight() + getPaddingLeft() + ((int) Math.ceil(this.a.y()));
        }
        setMeasuredDimension(size, size2);
    }

    public void setAnimationProperties(float f, long j, long j2, TimeInterpolator timeInterpolator) {
        this.a.G(f, j, j2, timeInterpolator);
    }

    public void setEllipsizeByGradient(boolean z) {
        this.a.H(z);
    }

    public void setGravity(int i) {
        this.a.I(i);
    }

    public void setIgnoreRTL(boolean z) {
        this.a.B = z;
    }

    public void setMaxWidth(int i) {
        this.c = i;
    }

    public void setRightPadding(float f) {
        this.a.M(f);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true, true);
    }

    public void setTextColor(int i) {
        this.a.R(i);
        invalidate();
    }

    public void setTextSize(float f) {
        this.a.S(f);
    }

    public void setTypeface(Typeface typeface) {
        this.a.T(typeface);
    }

    public AnimatedTextView(Context context, boolean z, boolean z2, boolean z3) {
        super(context);
        this.f = true;
        this.g = true;
        a aVar = new a(z, z2, z3);
        this.a = aVar;
        aVar.setCallback(this);
        aVar.K(new Runnable() { // from class: ir.nasim.ot
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    public void setText(CharSequence charSequence, boolean z) {
        setText(charSequence, z, true);
    }

    public void setText(CharSequence charSequence, boolean z, boolean z2) {
        boolean z3 = !this.g && z;
        this.g = false;
        if (z3) {
            if (this.a.A) {
                if (this.a.n != null) {
                    this.a.n.cancel();
                    this.a.n = null;
                }
            } else if (this.a.z()) {
                this.d = charSequence;
                this.e = z2;
                return;
            }
        }
        int iY = (int) this.a.y();
        this.a.setBounds(getPaddingLeft(), getPaddingTop(), this.b - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
        this.a.Q(charSequence, z3, z2);
        float f = iY;
        if (f < this.a.y() || !(z3 || f == this.a.y())) {
            requestLayout();
        }
    }
}
