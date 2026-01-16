package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* renamed from: ir.nasim.bn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10550bn7 {
    private final TextPaint a;
    private final TextUtils.TruncateAt b;
    private final boolean c;
    private final boolean d;
    private final C18586ou3 e;
    private final boolean f;
    private Ja8 g;
    private final Layout h;
    private final int i;
    private final int j;
    private final int k;
    private final float l;
    private final float m;
    private final boolean n;
    private final Paint.FontMetricsInt o;
    private final int p;
    private final C5122Hz3[] q;
    private final Rect r;
    private C13249fu3 s;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v5 */
    public C10550bn7(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, float f2, float f3, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int[] iArr2, C18586ou3 c18586ou3) {
        boolean z3;
        boolean z4;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout layoutA;
        this.a = textPaint;
        this.b = truncateAt;
        this.c = z;
        this.d = z2;
        this.e = c18586ou3;
        this.r = new Rect();
        int length = charSequence.length();
        TextDirectionHeuristic textDirectionHeuristicK = AbstractC15565jn7.k(i2);
        Layout.Alignment alignmentA = C6659Ok7.a.a(i);
        boolean z5 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, C19595qd0.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics metricsE = c18586ou3.e();
            double d = f;
            int iCeil = (int) Math.ceil(d);
            if (metricsE == null || c18586ou3.i() > f || z5) {
                z3 = true;
                this.n = false;
                z4 = false;
                textDirectionHeuristic = textDirectionHeuristicK;
                layoutA = C15899kM6.a.a(charSequence, textPaint, iCeil, 0, charSequence.length(), textDirectionHeuristicK, alignmentA, i3, truncateAt, (int) Math.ceil(d), f2, f3, i8, z, z2, i4, i5, i6, i7, iArr, iArr2);
            } else {
                this.n = true;
                z3 = true;
                layoutA = C14918ii0.a.a(charSequence, textPaint, iCeil, metricsE, alignmentA, z, z2, truncateAt, iCeil);
                textDirectionHeuristic = textDirectionHeuristicK;
                z4 = false;
            }
            this.h = layoutA;
            Trace.endSection();
            int iMin = Math.min(layoutA.getLineCount(), i3);
            this.i = iMin;
            int i9 = iMin - 1;
            this.f = (iMin >= i3 && (layoutA.getEllipsisCount(i9) > 0 || layoutA.getLineEnd(i9) != charSequence.length())) ? z3 : z4;
            long jL = AbstractC15565jn7.l(this);
            C5122Hz3[] c5122Hz3ArrJ = AbstractC15565jn7.j(this);
            this.q = c5122Hz3ArrJ;
            long jI = c5122Hz3ArrJ != null ? AbstractC15565jn7.i(c5122Hz3ArrJ) : AbstractC15565jn7.b;
            this.j = Math.max(AbstractC15363jS7.c(jL), AbstractC15363jS7.c(jI));
            this.k = Math.max(AbstractC15363jS7.b(jL), AbstractC15363jS7.b(jI));
            Paint.FontMetricsInt fontMetricsIntH = AbstractC15565jn7.h(this, textPaint, textDirectionHeuristic, c5122Hz3ArrJ);
            this.p = fontMetricsIntH != null ? fontMetricsIntH.bottom - ((int) s(i9)) : z4;
            this.o = fontMetricsIntH;
            this.l = AbstractC9522a63.b(layoutA, i9, null, 2, null);
            this.m = AbstractC9522a63.d(layoutA, i9, null, 2, null);
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public static /* synthetic */ float B(C10550bn7 c10550bn7, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c10550bn7.A(i, z);
    }

    public static /* synthetic */ float E(C10550bn7 c10550bn7, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c10550bn7.D(i, z);
    }

    private final float g(int i) {
        if (i == this.i - 1) {
            return this.l + this.m;
        }
        return 0.0f;
    }

    private final C13249fu3 j() {
        C13249fu3 c13249fu3 = this.s;
        if (c13249fu3 != null) {
            AbstractC13042fc3.f(c13249fu3);
            return c13249fu3;
        }
        C13249fu3 c13249fu32 = new C13249fu3(this.h);
        this.s = c13249fu32;
        return c13249fu32;
    }

    public final float A(int i, boolean z) {
        return j().c(i, true, z) + g(q(i));
    }

    public final int[] C(RectF rectF, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        return Build.VERSION.SDK_INT >= 34 ? C25151zp.a.c(this, rectF, i, interfaceC14603iB2) : AbstractC11935dn7.d(this, this.h, j(), rectF, i, interfaceC14603iB2);
    }

    public final float D(int i, boolean z) {
        return j().c(i, false, z) + g(q(i));
    }

    public final void F(int i, int i2, Path path) {
        this.h.getSelectionPath(i, i2, path);
        if (this.j == 0 || path.isEmpty()) {
            return;
        }
        path.offset(0.0f, this.j);
    }

    public final CharSequence G() {
        return this.h.getText();
    }

    public final TextPaint H() {
        return this.a;
    }

    public final Ja8 I() {
        Ja8 ja8 = this.g;
        if (ja8 != null) {
            return ja8;
        }
        Ja8 ja82 = new Ja8(this.h.getText(), 0, this.h.getText().length(), this.a.getTextLocale());
        this.g = ja82;
        return ja82;
    }

    public final boolean J() {
        if (this.n) {
            C14918ii0 c14918ii0 = C14918ii0.a;
            Layout layout = this.h;
            AbstractC13042fc3.g(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return c14918ii0.b((BoringLayout) layout);
        }
        C15899kM6 c15899kM6 = C15899kM6.a;
        Layout layout2 = this.h;
        AbstractC13042fc3.g(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return c15899kM6.c((StaticLayout) layout2, this.d);
    }

    public final boolean K(int i) {
        return AbstractC15565jn7.m(this.h, i);
    }

    public final boolean L(int i) {
        return this.h.isRtlCharAt(i);
    }

    public final void M(Canvas canvas) {
        if (canvas.getClipBounds(this.r)) {
            int i = this.j;
            if (i != 0) {
                canvas.translate(0.0f, i);
            }
            C6893Pk7 c6893Pk7 = AbstractC15565jn7.a;
            c6893Pk7.a(canvas);
            this.h.draw(c6893Pk7);
            int i2 = this.j;
            if (i2 != 0) {
                canvas.translate(0.0f, (-1) * i2);
            }
        }
    }

    public final void a(int i, int i2, float[] fArr, int i3) {
        float fD;
        float fE;
        int length = G().length();
        int i4 = 1;
        if (!(i >= 0)) {
            N73.a("startOffset must be > 0");
        }
        if (!(i < length)) {
            N73.a("startOffset must be less than text length");
        }
        if (!(i2 > i)) {
            N73.a("endOffset must be greater than startOffset");
        }
        if (!(i2 <= length)) {
            N73.a("endOffset must be smaller or equal to text length");
        }
        if (!(fArr.length - i3 >= (i2 - i) * 4)) {
            N73.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
        }
        int iQ = q(i);
        int iQ2 = q(i2 - 1);
        NY2 ny2 = new NY2(this);
        if (iQ > iQ2) {
            return;
        }
        int i5 = iQ;
        int i6 = i3;
        while (true) {
            int iV = v(i5);
            int iP = p(i5);
            int iMin = Math.min(i2, iP);
            float fW = w(i5);
            float fL = l(i5);
            int i7 = z(i5) == i4 ? i4 : 0;
            int i8 = i7 ^ 1;
            for (int iMax = Math.max(i, iV); iMax < iMin; iMax++) {
                boolean zL = L(iMax);
                if (i7 != 0 && !zL) {
                    fD = ny2.b(iMax);
                    fE = ny2.c(iMax + 1);
                } else if (i7 != 0 && zL) {
                    fE = ny2.d(iMax);
                    fD = ny2.e(iMax + 1);
                } else if (i8 == 0 || !zL) {
                    fD = ny2.d(iMax);
                    fE = ny2.e(iMax + 1);
                } else {
                    fE = ny2.b(iMax);
                    fD = ny2.c(iMax + 1);
                }
                fArr[i6] = fD;
                fArr[i6 + 1] = fW;
                fArr[i6 + 2] = fE;
                fArr[i6 + 3] = fL;
                i6 += 4;
            }
            if (i5 == iQ2) {
                return;
            }
            i5++;
            i4 = 1;
        }
    }

    public final void b(int i, float[] fArr) {
        float fD;
        float fE;
        int iV = v(i);
        int iP = p(i);
        int i2 = 0;
        if (!(fArr.length >= (iP - iV) * 2)) {
            N73.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        NY2 ny2 = new NY2(this);
        boolean z = z(i) == 1;
        while (iV < iP) {
            boolean zL = L(iV);
            if (z && !zL) {
                fD = ny2.b(iV);
                fE = ny2.c(iV + 1);
            } else if (z && zL) {
                fE = ny2.d(iV);
                fD = ny2.e(iV + 1);
            } else if (zL) {
                fE = ny2.b(iV);
                fD = ny2.c(iV + 1);
            } else {
                fD = ny2.d(iV);
                fE = ny2.e(iV + 1);
            }
            fArr[i2] = fD;
            fArr[i2 + 1] = fE;
            i2 += 2;
            iV++;
        }
    }

    public final RectF c(int i) {
        float fD;
        float fD2;
        float fA;
        float fA2;
        int iQ = q(i);
        float fW = w(iQ);
        float fL = l(iQ);
        boolean z = z(iQ) == 1;
        boolean zIsRtlCharAt = this.h.isRtlCharAt(i);
        if (!z || zIsRtlCharAt) {
            if (z && zIsRtlCharAt) {
                fA = D(i, false);
                fA2 = D(i + 1, true);
            } else if (zIsRtlCharAt) {
                fA = A(i, false);
                fA2 = A(i + 1, true);
            } else {
                fD = D(i, false);
                fD2 = D(i + 1, true);
            }
            float f = fA;
            fD = fA2;
            fD2 = f;
        } else {
            fD = A(i, false);
            fD2 = A(i + 1, true);
        }
        return new RectF(fD, fW, fD2, fL);
    }

    public final boolean d() {
        return this.f;
    }

    public final boolean e() {
        return this.d;
    }

    public final int f() {
        return (this.f ? this.h.getLineBottom(this.i - 1) : this.h.getHeight()) + this.j + this.k + this.p;
    }

    public final boolean h() {
        return this.c;
    }

    public final Layout i() {
        return this.h;
    }

    public final float k(int i) {
        return this.j + ((i != this.i + (-1) || this.o == null) ? this.h.getLineBaseline(i) : w(i) - this.o.ascent);
    }

    public final float l(int i) {
        if (i != this.i - 1 || this.o == null) {
            return this.j + this.h.getLineBottom(i) + (i == this.i + (-1) ? this.k : 0);
        }
        return this.h.getLineBottom(i - 1) + this.o.bottom;
    }

    public final int m() {
        return this.i;
    }

    public final int n(int i) {
        return this.h.getEllipsisCount(i);
    }

    public final int o(int i) {
        return this.h.getEllipsisStart(i);
    }

    public final int p(int i) {
        return (AbstractC15565jn7.m(this.h, i) && this.b == TextUtils.TruncateAt.END) ? this.h.getText().length() : this.h.getLineEnd(i);
    }

    public final int q(int i) {
        return this.h.getLineForOffset(i);
    }

    public final int r(int i) {
        return this.h.getLineForVertical(i - this.j);
    }

    public final float s(int i) {
        return l(i) - w(i);
    }

    public final float t(int i) {
        return this.h.getLineLeft(i) + (i == this.i + (-1) ? this.l : 0.0f);
    }

    public final float u(int i) {
        return this.h.getLineRight(i) + (i == this.i + (-1) ? this.m : 0.0f);
    }

    public final int v(int i) {
        return this.h.getLineStart(i);
    }

    public final float w(int i) {
        return this.h.getLineTop(i) + (i == 0 ? 0 : this.j);
    }

    public final int x(int i) {
        return (AbstractC15565jn7.m(this.h, i) && this.b == TextUtils.TruncateAt.END) ? this.h.getLineStart(i) + this.h.getEllipsisStart(i) : j().e(i);
    }

    public final int y(int i, float f) {
        return this.h.getOffsetForHorizontal(i, f + ((-1) * g(i)));
    }

    public final int z(int i) {
        return this.h.getParagraphDirection(i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C10550bn7(CharSequence charSequence, float f, TextPaint textPaint, int i, TextUtils.TruncateAt truncateAt, int i2, float f2, float f3, boolean z, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr, int[] iArr2, C18586ou3 c18586ou3, int i9, ED1 ed1) {
        int i10 = (i9 & 8) != 0 ? 0 : i;
        TextUtils.TruncateAt truncateAt2 = (i9 & 16) != 0 ? null : truncateAt;
        int i11 = (i9 & 32) != 0 ? 2 : i2;
        this(charSequence, f, textPaint, i10, truncateAt2, i11, (i9 & 64) != 0 ? 1.0f : f2, (i9 & 128) != 0 ? 0.0f : f3, (i9 & 256) != 0 ? false : z, (i9 & 512) != 0 ? true : z2, (i9 & 1024) != 0 ? Integer.MAX_VALUE : i3, (i9 & 2048) != 0 ? 0 : i4, (i9 & 4096) != 0 ? 0 : i5, (i9 & 8192) != 0 ? 0 : i6, (i9 & 16384) != 0 ? 0 : i7, (32768 & i9) != 0 ? 0 : i8, (65536 & i9) != 0 ? null : iArr, (131072 & i9) != 0 ? null : iArr2, (i9 & 262144) != 0 ? new C18586ou3(charSequence, textPaint, i11) : c18586ou3);
    }
}
