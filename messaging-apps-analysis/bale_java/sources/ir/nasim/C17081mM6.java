package ir.nasim;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* renamed from: ir.nasim.mM6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C17081mM6 {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final TextPaint d;
    private final int e;
    private final TextDirectionHeuristic f;
    private final Layout.Alignment g;
    private final int h;
    private final TextUtils.TruncateAt i;
    private final int j;
    private final float k;
    private final float l;
    private final int m;
    private final boolean n;
    private final boolean o;
    private final int p;
    private final int q;
    private final int r;
    private final int s;
    private final int[] t;
    private final int[] u;

    public C17081mM6(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i4, TextUtils.TruncateAt truncateAt, int i5, float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int i9, int i10, int[] iArr, int[] iArr2) {
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = textPaint;
        this.e = i3;
        this.f = textDirectionHeuristic;
        this.g = alignment;
        this.h = i4;
        this.i = truncateAt;
        this.j = i5;
        this.k = f;
        this.l = f2;
        this.m = i6;
        this.n = z;
        this.o = z2;
        this.p = i7;
        this.q = i8;
        this.r = i9;
        this.s = i10;
        this.t = iArr;
        this.u = iArr2;
        if (!(i >= 0 && i <= i2)) {
            N73.a("invalid start value");
        }
        if (!(i2 >= 0 && i2 <= charSequence.length())) {
            N73.a("invalid end value");
        }
        if (!(i4 >= 0)) {
            N73.a("invalid maxLines value");
        }
        if (!(i3 >= 0)) {
            N73.a("invalid width value");
        }
        if (!(i5 >= 0)) {
            N73.a("invalid ellipsizedWidth value");
        }
        if (f >= 0.0f) {
            return;
        }
        N73.a("invalid lineSpacingMultiplier value");
    }

    public final Layout.Alignment a() {
        return this.g;
    }

    public final int b() {
        return this.p;
    }

    public final TextUtils.TruncateAt c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    public final int e() {
        return this.c;
    }

    public final int f() {
        return this.s;
    }

    public final boolean g() {
        return this.n;
    }

    public final int h() {
        return this.m;
    }

    public final int[] i() {
        return this.t;
    }

    public final int j() {
        return this.q;
    }

    public final int k() {
        return this.r;
    }

    public final float l() {
        return this.l;
    }

    public final float m() {
        return this.k;
    }

    public final int n() {
        return this.h;
    }

    public final TextPaint o() {
        return this.d;
    }

    public final int[] p() {
        return this.u;
    }

    public final int q() {
        return this.b;
    }

    public final CharSequence r() {
        return this.a;
    }

    public final TextDirectionHeuristic s() {
        return this.f;
    }

    public final boolean t() {
        return this.o;
    }

    public final int u() {
        return this.e;
    }
}
