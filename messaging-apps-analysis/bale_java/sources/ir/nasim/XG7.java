package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class XG7 {
    private final long a;
    private final int b;

    public XG7(long j, int i) {
        this.a = j;
        this.b = i;
    }

    public static /* synthetic */ XG7 d(XG7 xg7, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = xg7.a;
        }
        if ((i2 & 2) != 0) {
            i = xg7.b;
        }
        return xg7.c(j, i);
    }

    public final long a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final XG7 c(long j, int i) {
        return new XG7(j, i);
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XG7)) {
            return false;
        }
        XG7 xg7 = (XG7) obj;
        return this.a == xg7.a && this.b == xg7.b;
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "UploadConfiguration(version=" + this.a + ", concurrentChunks=" + this.b + Separators.RPAREN;
    }
}
