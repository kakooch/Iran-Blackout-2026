package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes3.dex */
public final class Q20 {
    private final float a;
    private final float b;
    private final int c;
    private final int d;

    public Q20(float f, float f2, int i, int i2) {
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q20)) {
            return false;
        }
        Q20 q20 = (Q20) obj;
        return Float.compare(this.a, q20.a) == 0 && Float.compare(this.b, q20.b) == 0 && this.c == q20.c && this.d == q20.d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "BalloonLayoutInfo(x=" + this.a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + Separators.RPAREN;
    }
}
