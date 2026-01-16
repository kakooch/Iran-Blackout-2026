package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Hl2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4995Hl2 {
    private final long a;
    private final long b;

    public C4995Hl2(long j, long j2) {
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
        if (!(obj instanceof C4995Hl2)) {
            return false;
        }
        C4995Hl2 c4995Hl2 = (C4995Hl2) obj;
        return this.a == c4995Hl2.a && this.b == c4995Hl2.b;
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "FileLocation(fileId=" + this.a + ", accessHash=" + this.b + Separators.RPAREN;
    }
}
