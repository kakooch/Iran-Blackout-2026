package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.s18, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20449s18 {
    private final int a;
    private final long b;

    public C20449s18(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20449s18)) {
            return false;
        }
        C20449s18 c20449s18 = (C20449s18) obj;
        return this.a == c20449s18.a && this.b == c20449s18.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "Voters(userId=" + this.a + ", votedAt=" + this.b + Separators.RPAREN;
    }
}
