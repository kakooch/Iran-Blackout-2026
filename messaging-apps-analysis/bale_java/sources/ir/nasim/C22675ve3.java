package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ve3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22675ve3 {
    private final int a;
    private final long b;

    public C22675ve3(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22675ve3)) {
            return false;
        }
        C22675ve3 c22675ve3 = (C22675ve3) obj;
        return this.a == c22675ve3.a && this.b == c22675ve3.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "InvitedUserTimerState(peerId=" + this.a + ", timerMs=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C22675ve3(int i, long j, int i2, ED1 ed1) {
        this(i, (i2 & 2) != 0 ? 90000L : j);
    }
}
