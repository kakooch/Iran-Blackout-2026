package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.e30, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12106e30 {
    private long a;

    public C12106e30(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public final void b(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C12106e30) && this.a == ((C12106e30) obj).a;
    }

    public int hashCode() {
        return Long.hashCode(this.a);
    }

    public String toString() {
        return "BandwidthOptimizerFeedback(version=" + this.a + Separators.RPAREN;
    }
}
