package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class KC7 extends AbstractC20556sC7 {
    private final boolean a;
    private final long b;

    public KC7(boolean z, long j) {
        super(null);
        this.a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KC7)) {
            return false;
        }
        KC7 kc7 = (KC7) obj;
        return this.a == kc7.a && this.b == kc7.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "UpdateCallJoinRequestAnswered(isAllowed=" + this.a + ", callId=" + this.b + Separators.RPAREN;
    }
}
