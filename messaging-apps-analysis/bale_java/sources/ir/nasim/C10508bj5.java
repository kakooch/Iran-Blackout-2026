package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.bj5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10508bj5 {
    private final long a;
    private final long b;
    private final int c;

    public C10508bj5(long j, long j2, int i) {
        this.a = j;
        this.b = j2;
        this.c = i;
    }

    public final int a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10508bj5)) {
            return false;
        }
        C10508bj5 c10508bj5 = (C10508bj5) obj;
        return this.a == c10508bj5.a && this.b == c10508bj5.b && this.c == c10508bj5.c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "PostInfo(rid=" + this.a + ", date=" + this.b + ", channelId=" + this.c + Separators.RPAREN;
    }
}
