package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.a30, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9489a30 {
    private final long a;
    private final int b;
    private final double c;
    private final String d;

    public C9489a30(long j, int i, double d, String str) {
        this.a = j;
        this.b = i;
        this.c = d;
        this.d = str;
    }

    public final int a() {
        return this.b;
    }

    public final double b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9489a30)) {
            return false;
        }
        C9489a30 c9489a30 = (C9489a30) obj;
        return this.a == c9489a30.a && this.b == c9489a30.b && Double.compare(this.c, c9489a30.c) == 0 && AbstractC13042fc3.d(this.d, c9489a30.d);
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31;
        String str = this.d;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BandwidthAdjustment(version=" + this.a + ", chunkSizeInByte=" + this.b + ", transferCapacity=" + this.c + ", description=" + this.d + Separators.RPAREN;
    }
}
