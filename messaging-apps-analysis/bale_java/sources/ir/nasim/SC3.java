package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class SC3 {
    private final long a;
    private final int b;
    private final int c;
    private final boolean d;
    private final long e;
    private final long f;

    public SC3(long j, int i, int i2, boolean z, long j2, long j3) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = j2;
        this.f = j3;
    }

    public final int a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        return this.f;
    }

    public final long d() {
        return this.e;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SC3)) {
            return false;
        }
        SC3 sc3 = (SC3) obj;
        return this.a == sc3.a && this.b == sc3.b && this.c == sc3.c && this.d == sc3.d && this.e == sc3.e && this.f == sc3.f;
    }

    public final boolean f() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "LiveInfo(key=" + this.a + ", groupId=" + this.b + ", userCount=" + this.c + ", isLive=" + this.d + ", mainMessageId=" + this.e + ", mainMessageDate=" + this.f + Separators.RPAREN;
    }
}
