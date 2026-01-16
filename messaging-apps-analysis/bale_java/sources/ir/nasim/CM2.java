package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class CM2 {
    private final int a;
    private final long b;

    public CM2(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CM2)) {
            return false;
        }
        CM2 cm2 = (CM2) obj;
        return this.a == cm2.a && this.b == cm2.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "GroupOutPeer(groupId=" + this.a + ", accessHash=" + this.b + Separators.RPAREN;
    }
}
