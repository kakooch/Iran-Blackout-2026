package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.tl2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21564tl2 {
    private final long a;
    private final long b;

    public C21564tl2(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21564tl2)) {
            return false;
        }
        C21564tl2 c21564tl2 = (C21564tl2) obj;
        return this.a == c21564tl2.a && this.b == c21564tl2.b;
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "FileIdAndAccessHash(fileId=" + this.a + ", accessHash=" + this.b + Separators.RPAREN;
    }
}
