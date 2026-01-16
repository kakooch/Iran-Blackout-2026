package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class LF5 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;

    public /* synthetic */ LF5(float f, float f2, float f3, float f4, float f5, ED1 ed1) {
        this(f, f2, f3, f4, f5);
    }

    public final float a() {
        return this.c;
    }

    public final float b() {
        return this.d;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LF5)) {
            return false;
        }
        LF5 lf5 = (LF5) obj;
        return C17784nZ1.s(this.a, lf5.a) && C17784nZ1.s(this.b, lf5.b) && C17784nZ1.s(this.c, lf5.c) && C17784nZ1.s(this.d, lf5.d) && C17784nZ1.s(this.e, lf5.e);
    }

    public int hashCode() {
        return (((((((C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c)) * 31) + C17784nZ1.t(this.d)) * 31) + C17784nZ1.t(this.e);
    }

    public String toString() {
        return "Radii(radius4=" + C17784nZ1.u(this.a) + ", radius8=" + C17784nZ1.u(this.b) + ", radius10=" + C17784nZ1.u(this.c) + ", radius14=" + C17784nZ1.u(this.d) + ", radius100=" + C17784nZ1.u(this.e) + Separators.RPAREN;
    }

    private LF5(float f, float f2, float f3, float f4, float f5) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
    }
}
