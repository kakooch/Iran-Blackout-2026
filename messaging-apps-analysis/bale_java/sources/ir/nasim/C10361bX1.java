package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.bX1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10361bX1 {
    private final long a;
    private final long b;
    private final Integer c;

    public C10361bX1(long j, long j2, Integer num) {
        this.a = j;
        this.b = j2;
        this.c = num;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public final Integer c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10361bX1)) {
            return false;
        }
        C10361bX1 c10361bX1 = (C10361bX1) obj;
        return this.a == c10361bX1.a && this.b == c10361bX1.b && AbstractC13042fc3.d(this.c, c10361bX1.c);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31;
        Integer num = this.c;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "DomainFileLocation(fileId=" + this.a + ", accessHash=" + this.b + ", fileStorageVersion=" + this.c + Separators.RPAREN;
    }
}
