package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class TY0 {
    private final long a;
    private final long b;

    public /* synthetic */ TY0(long j, long j2, ED1 ed1) {
        this(j, j2);
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TY0)) {
            return false;
        }
        TY0 ty0 = (TY0) obj;
        return C24381yX0.q(this.a, ty0.a) && C24381yX0.q(this.b, ty0.b);
    }

    public int hashCode() {
        return (C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b);
    }

    public String toString() {
        return "Colors(message=" + C24381yX0.x(this.a) + ", messageIcon=" + C24381yX0.x(this.b) + Separators.RPAREN;
    }

    private TY0(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
