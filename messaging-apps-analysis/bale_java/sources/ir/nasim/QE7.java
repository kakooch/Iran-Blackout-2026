package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QE7 extends AbstractC20556sC7 {
    private final C11458d25 a;
    private final long b;
    private final long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QE7(C11458d25 c11458d25, long j, long j2) {
        super(null);
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = j;
        this.c = j2;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QE7)) {
            return false;
        }
        QE7 qe7 = (QE7) obj;
        return AbstractC13042fc3.d(this.a, qe7.a) && this.b == qe7.b && this.c == qe7.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "UpdateMessageRead(peer=" + this.a + ", startDate=" + this.b + ", readDate=" + this.c + Separators.RPAREN;
    }
}
