package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class SC7 extends AbstractC20556sC7 {
    private final long a;

    public SC7(long j) {
        super(null);
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SC7) && this.a == ((SC7) obj).a;
    }

    public int hashCode() {
        return Long.hashCode(this.a);
    }

    public String toString() {
        return "UpdateCallUpgraded(callId=" + this.a + Separators.RPAREN;
    }
}
