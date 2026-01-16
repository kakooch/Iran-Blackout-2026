package ir.nasim;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Hz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5122Hz3 implements LineHeightSpan {
    private final float a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final float f;
    private final boolean g;
    private int h = RecyclerView.UNDEFINED_DURATION;
    private int i = RecyclerView.UNDEFINED_DURATION;
    private int j = RecyclerView.UNDEFINED_DURATION;
    private int k = RecyclerView.UNDEFINED_DURATION;
    private int l;
    private int m;

    public C5122Hz3(float f, int i, int i2, boolean z, boolean z2, float f2, boolean z3) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
        this.f = f2;
        this.g = z3;
        if ((0.0f <= f2 && f2 <= 1.0f) || f2 == -1.0f) {
            return;
        }
        N73.c("topRatio should be in [0..1] range or -1");
    }

    private final void a(Paint.FontMetricsInt fontMetricsInt) {
        int iCeil = (int) Math.ceil(this.a);
        int iA = iCeil - AbstractC5356Iz3.a(fontMetricsInt);
        if (this.g && iA <= 0) {
            int i = fontMetricsInt.ascent;
            this.i = i;
            int i2 = fontMetricsInt.descent;
            this.j = i2;
            this.h = i;
            this.k = i2;
            this.l = 0;
            this.m = 0;
            return;
        }
        float fAbs = this.f;
        if (fAbs == -1.0f) {
            fAbs = Math.abs(fontMetricsInt.ascent) / AbstractC5356Iz3.a(fontMetricsInt);
        }
        int iCeil2 = (int) (iA <= 0 ? Math.ceil(iA * fAbs) : Math.ceil(iA * (1.0f - fAbs)));
        int i3 = fontMetricsInt.descent;
        int i4 = iCeil2 + i3;
        this.j = i4;
        int i5 = i4 - iCeil;
        this.i = i5;
        if (this.d) {
            i5 = fontMetricsInt.ascent;
        }
        this.h = i5;
        if (this.e) {
            i4 = i3;
        }
        this.k = i4;
        this.l = fontMetricsInt.ascent - i5;
        this.m = i4 - i3;
    }

    public final C5122Hz3 b(int i, int i2, boolean z) {
        return new C5122Hz3(this.a, i, i2, z, this.e, this.f, this.g);
    }

    public final int c() {
        return this.l;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        if (AbstractC5356Iz3.a(fontMetricsInt) <= 0) {
            return;
        }
        boolean z = i == this.b;
        boolean z2 = i2 == this.c;
        if (z && z2 && this.d && this.e) {
            return;
        }
        if (this.h == Integer.MIN_VALUE) {
            a(fontMetricsInt);
        }
        fontMetricsInt.ascent = z ? this.h : this.i;
        fontMetricsInt.descent = z2 ? this.k : this.j;
    }

    public final int d() {
        return this.m;
    }

    public final boolean e() {
        return this.e;
    }
}
