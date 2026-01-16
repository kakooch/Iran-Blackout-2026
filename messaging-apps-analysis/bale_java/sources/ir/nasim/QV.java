package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class QV {
    private final long a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final PV f;

    public QV(long j, double d, double d2, double d3, double d4, PV pv) {
        AbstractC13042fc3.i(pv, "optimizerConfiguration");
        this.a = j;
        this.b = d;
        this.c = d2;
        this.d = d3;
        this.e = d4;
        this.f = pv;
    }

    public final QV a(long j, double d, double d2, double d3, double d4, PV pv) {
        AbstractC13042fc3.i(pv, "optimizerConfiguration");
        return new QV(j, d, d2, d3, d4, pv);
    }

    public final PV c() {
        return this.f;
    }

    public final double d() {
        return this.b;
    }

    public final long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QV)) {
            return false;
        }
        QV qv = (QV) obj;
        return this.a == qv.a && Double.compare(this.b, qv.b) == 0 && Double.compare(this.c, qv.c) == 0 && Double.compare(this.d, qv.d) == 0 && Double.compare(this.e, qv.e) == 0 && AbstractC13042fc3.d(this.f, qv.f);
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.a) * 31) + Double.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        long j = this.a;
        double d = this.d;
        double d2 = this.e;
        double d3 = this.c;
        double d4 = this.b;
        return "Configuration(version=" + j + ", minRttInNanos=" + d + ", avgRttInNanos=" + d2 + ", avgBandwidthInBps=" + d3 + ", transferCapacityInByte=" + d4 + ", estimatedBDP=" + ((d / 1.0E9d) * d3) + ", chunkCount=" + ((float) (d4 / this.f.a())) + Separators.RPAREN;
    }

    public /* synthetic */ QV(long j, double d, double d2, double d3, double d4, PV pv, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0L : j, d, (i & 4) != 0 ? 0.0d : d2, (i & 8) != 0 ? Double.MAX_VALUE : d3, (i & 16) != 0 ? Double.MIN_VALUE : d4, pv);
    }
}
