package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class HS7 {
    private final long a;

    public HS7(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HS7) && this.a == ((HS7) obj).a;
    }

    public int hashCode() {
        return Long.hashCode(this.a);
    }

    public String toString() {
        return "VideoData(createdAt=" + this.a + Separators.RPAREN;
    }
}
