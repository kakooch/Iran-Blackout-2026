package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class AX1 {
    private final int a;
    private final int b;

    public AX1(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AX1)) {
            return false;
        }
        AX1 ax1 = (AX1) obj;
        return this.a == ax1.a && this.b == ax1.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "DownloadChunkRange(startRange=" + this.a + ", endRange=" + this.b + Separators.RPAREN;
    }
}
