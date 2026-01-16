package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class G26 {
    private final int a;
    private final long b;

    public G26(int i, long j) {
        this.a = i;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G26)) {
            return false;
        }
        G26 g26 = (G26) obj;
        return this.a == g26.a && this.b == g26.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "RoomInvitedUserState(peerId=" + this.a + ", invitedDateMs=" + this.b + Separators.RPAREN;
    }
}
