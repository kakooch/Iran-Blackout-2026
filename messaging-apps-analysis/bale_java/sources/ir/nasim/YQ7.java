package ir.nasim;

import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public final class YQ7 {
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private Drawable h;
    private boolean i;
    private CharSequence j;
    private final Integer k;
    private final Integer l;
    private final Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Integer q;
    private Integer r;

    public YQ7(Integer num, Integer num2, Integer num3, Integer num4, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z, CharSequence charSequence, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12) {
        AbstractC13042fc3.i(charSequence, "contentDescription");
        this.a = num;
        this.b = num2;
        this.c = num3;
        this.d = num4;
        this.e = drawable;
        this.f = drawable2;
        this.g = drawable3;
        this.h = drawable4;
        this.i = z;
        this.j = charSequence;
        this.k = num5;
        this.l = num6;
        this.m = num7;
        this.n = num8;
        this.o = num9;
        this.p = num10;
        this.q = num11;
        this.r = num12;
    }

    public final void A(boolean z) {
        this.i = z;
    }

    public final Integer a() {
        return this.k;
    }

    public final Integer b() {
        return this.n;
    }

    public final CharSequence c() {
        return this.j;
    }

    public final Drawable d() {
        return this.g;
    }

    public final Integer e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YQ7)) {
            return false;
        }
        YQ7 yq7 = (YQ7) obj;
        return AbstractC13042fc3.d(this.a, yq7.a) && AbstractC13042fc3.d(this.b, yq7.b) && AbstractC13042fc3.d(this.c, yq7.c) && AbstractC13042fc3.d(this.d, yq7.d) && AbstractC13042fc3.d(this.e, yq7.e) && AbstractC13042fc3.d(this.f, yq7.f) && AbstractC13042fc3.d(this.g, yq7.g) && AbstractC13042fc3.d(this.h, yq7.h) && this.i == yq7.i && AbstractC13042fc3.d(this.j, yq7.j) && AbstractC13042fc3.d(this.k, yq7.k) && AbstractC13042fc3.d(this.l, yq7.l) && AbstractC13042fc3.d(this.m, yq7.m) && AbstractC13042fc3.d(this.n, yq7.n) && AbstractC13042fc3.d(this.o, yq7.o) && AbstractC13042fc3.d(this.p, yq7.p) && AbstractC13042fc3.d(this.q, yq7.q) && AbstractC13042fc3.d(this.r, yq7.r);
    }

    public final Drawable f() {
        return this.f;
    }

    public final Integer g() {
        return this.b;
    }

    public final Drawable h() {
        return this.e;
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.c;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.d;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Drawable drawable = this.e;
        int iHashCode5 = (iHashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        Drawable drawable2 = this.f;
        int iHashCode6 = (iHashCode5 + (drawable2 == null ? 0 : drawable2.hashCode())) * 31;
        Drawable drawable3 = this.g;
        int iHashCode7 = (iHashCode6 + (drawable3 == null ? 0 : drawable3.hashCode())) * 31;
        Drawable drawable4 = this.h;
        int iHashCode8 = (((((iHashCode7 + (drawable4 == null ? 0 : drawable4.hashCode())) * 31) + Boolean.hashCode(this.i)) * 31) + this.j.hashCode()) * 31;
        Integer num5 = this.k;
        int iHashCode9 = (iHashCode8 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.l;
        int iHashCode10 = (iHashCode9 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.m;
        int iHashCode11 = (iHashCode10 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.n;
        int iHashCode12 = (iHashCode11 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.o;
        int iHashCode13 = (iHashCode12 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.p;
        int iHashCode14 = (iHashCode13 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.q;
        int iHashCode15 = (iHashCode14 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.r;
        return iHashCode15 + (num12 != null ? num12.hashCode() : 0);
    }

    public final Integer i() {
        return this.a;
    }

    public final Drawable j() {
        return this.h;
    }

    public final Integer k() {
        return this.d;
    }

    public final Integer l() {
        return this.q;
    }

    public final Integer m() {
        return this.m;
    }

    public final Integer n() {
        return this.l;
    }

    public final Integer o() {
        return this.r;
    }

    public final Integer p() {
        return this.o;
    }

    public final Integer q() {
        return this.p;
    }

    public final boolean r() {
        return this.i;
    }

    public final void s(Drawable drawable) {
        this.g = drawable;
    }

    public final void t(Integer num) {
        this.c = num;
    }

    public String toString() {
        Integer num = this.a;
        Integer num2 = this.b;
        Integer num3 = this.c;
        Integer num4 = this.d;
        Drawable drawable = this.e;
        Drawable drawable2 = this.f;
        Drawable drawable3 = this.g;
        Drawable drawable4 = this.h;
        boolean z = this.i;
        CharSequence charSequence = this.j;
        return "VectorTextViewParams(drawableStartRes=" + num + ", drawableEndRes=" + num2 + ", drawableBottomRes=" + num3 + ", drawableTopRes=" + num4 + ", drawableStart=" + drawable + ", drawableEnd=" + drawable2 + ", drawableBottom=" + drawable3 + ", drawableTop=" + drawable4 + ", isRtlLayout=" + z + ", contentDescription=" + ((Object) charSequence) + ", compoundDrawablePadding=" + this.k + ", iconWidth=" + this.l + ", iconHeight=" + this.m + ", compoundDrawablePaddingRes=" + this.n + ", tintColor=" + this.o + ", widthRes=" + this.p + ", heightRes=" + this.q + ", squareSizeRes=" + this.r + Separators.RPAREN;
    }

    public final void u(Drawable drawable) {
        this.f = drawable;
    }

    public final void v(Integer num) {
        this.b = num;
    }

    public final void w(Drawable drawable) {
        this.e = drawable;
    }

    public final void x(Integer num) {
        this.a = num;
    }

    public final void y(Drawable drawable) {
        this.h = drawable;
    }

    public final void z(Integer num) {
        this.d = num;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ YQ7(Integer num, Integer num2, Integer num3, Integer num4, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, boolean z, CharSequence charSequence, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, int i, ED1 ed1) {
        CharSequence charSequence2;
        Integer num13 = (i & 1) != 0 ? null : num;
        Integer num14 = (i & 2) != 0 ? null : num2;
        Integer num15 = (i & 4) != 0 ? null : num3;
        Integer num16 = (i & 8) != 0 ? null : num4;
        Drawable drawable5 = (i & 16) != 0 ? null : drawable;
        Drawable drawable6 = (i & 32) != 0 ? null : drawable2;
        Drawable drawable7 = (i & 64) != 0 ? null : drawable3;
        Drawable drawable8 = (i & 128) != 0 ? null : drawable4;
        boolean z2 = (i & 256) != 0 ? false : z;
        if ((i & 512) != 0) {
            DY6 dy6 = DY6.a;
            charSequence2 = "";
        } else {
            charSequence2 = charSequence;
        }
        this(num13, num14, num15, num16, drawable5, drawable6, drawable7, drawable8, z2, charSequence2, (i & 1024) != 0 ? null : num5, (i & 2048) != 0 ? null : num6, (i & 4096) != 0 ? null : num7, (i & 8192) != 0 ? null : num8, (i & 16384) != 0 ? null : num9, (i & 32768) != 0 ? null : num10, (i & 65536) != 0 ? null : num11, (i & 131072) != 0 ? null : num12);
    }
}
