package ir.nasim;

import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;

/* loaded from: classes5.dex */
public final class E15 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final String g;

    public E15(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        AbstractC13042fc3.i(str, ParameterNames.TAG);
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = str;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.e;
    }

    public final int d() {
        return this.f;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E15)) {
            return false;
        }
        E15 e15 = (E15) obj;
        return this.a == e15.a && this.b == e15.b && this.c == e15.c && this.d == e15.d && this.e == e15.e && this.f == e15.f && AbstractC13042fc3.d(this.g, e15.g);
    }

    public final String f() {
        return this.g;
    }

    public final int g() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "PatternWallpaperModel(firstColor=" + this.a + ", secondColor=" + this.b + ", thirdColor=" + this.c + ", fourthColor=" + this.d + ", pattern=" + this.e + ", patternTint=" + this.f + ", tag=" + this.g + Separators.RPAREN;
    }
}
