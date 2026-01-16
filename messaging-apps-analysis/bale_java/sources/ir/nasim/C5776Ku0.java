package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ku0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5776Ku0 {
    private final long a;
    private final String b;

    public C5776Ku0(long j, String str) {
        AbstractC13042fc3.i(str, "name");
        this.a = j;
        this.b = str;
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5776Ku0)) {
            return false;
        }
        C5776Ku0 c5776Ku0 = (C5776Ku0) obj;
        return this.a == c5776Ku0.a && AbstractC13042fc3.d(this.b, c5776Ku0.b);
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CallBarPeer(callId=" + this.a + ", name=" + this.b + Separators.RPAREN;
    }
}
