package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class FD3 {
    private final long a;
    private final C11458d25 b;
    private final int c;
    private final boolean d;
    private final long e;
    private final long f;

    public FD3(long j, C11458d25 c11458d25, int i, boolean z, long j2, long j3) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = j;
        this.b = c11458d25;
        this.c = i;
        this.d = z;
        this.e = j2;
        this.f = j3;
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.f;
    }

    public final long c() {
        return this.e;
    }

    public final C11458d25 d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FD3)) {
            return false;
        }
        FD3 fd3 = (FD3) obj;
        return this.a == fd3.a && AbstractC13042fc3.d(this.b, fd3.b) && this.c == fd3.c && this.d == fd3.d && this.e == fd3.e && this.f == fd3.f;
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "LiveStreamData(key=" + this.a + ", peer=" + this.b + ", userCount=" + this.c + ", isLive=" + this.d + ", messageRid=" + this.e + ", messageDate=" + this.f + Separators.RPAREN;
    }
}
