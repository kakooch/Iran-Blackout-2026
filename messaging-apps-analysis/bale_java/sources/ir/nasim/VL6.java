package ir.nasim;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes3.dex */
final class VL6 {
    static final int n = 1;
    private CharSequence a;
    private final TextPaint b;
    private final int c;
    private int e;
    private boolean l;
    private int d = 0;
    private Layout.Alignment f = Layout.Alignment.ALIGN_NORMAL;
    private int g = Integer.MAX_VALUE;
    private float h = 0.0f;
    private float i = 1.0f;
    private int j = n;
    private boolean k = true;
    private TextUtils.TruncateAt m = null;

    static class a extends Exception {
    }

    private VL6(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i;
        this.e = charSequence.length();
    }

    public static VL6 b(CharSequence charSequence, TextPaint textPaint, int i) {
        return new VL6(charSequence, textPaint, i);
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int iMax = Math.max(0, this.c);
        CharSequence charSequenceEllipsize = this.a;
        if (this.g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.b, iMax, this.m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.e);
        this.e = iMin;
        if (this.l && this.g == 1) {
            this.f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.d, iMin, this.b, iMax);
        builderObtain.setAlignment(this.f);
        builderObtain.setIncludePad(this.k);
        builderObtain.setTextDirection(this.l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.g);
        float f = this.h;
        if (f != 0.0f || this.i != 1.0f) {
            builderObtain.setLineSpacing(f, this.i);
        }
        if (this.g > 1) {
            builderObtain.setHyphenationFrequency(this.j);
        }
        return builderObtain.build();
    }

    public VL6 c(Layout.Alignment alignment) {
        this.f = alignment;
        return this;
    }

    public VL6 d(TextUtils.TruncateAt truncateAt) {
        this.m = truncateAt;
        return this;
    }

    public VL6 e(int i) {
        this.j = i;
        return this;
    }

    public VL6 f(boolean z) {
        this.k = z;
        return this;
    }

    public VL6 g(boolean z) {
        this.l = z;
        return this;
    }

    public VL6 h(float f, float f2) {
        this.h = f;
        this.i = f2;
        return this;
    }

    public VL6 i(int i) {
        this.g = i;
        return this;
    }
}
