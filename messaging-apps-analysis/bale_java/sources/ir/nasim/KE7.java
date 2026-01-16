package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class KE7 extends AbstractC20556sC7 {
    private final ExPeer a;
    private final C25247zz b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KE7(ExPeer exPeer, C25247zz c25247zz) {
        super(null);
        AbstractC13042fc3.i(exPeer, "peer");
        this.a = exPeer;
        this.b = c25247zz;
    }

    public final ExPeer a() {
        return this.a;
    }

    public final C25247zz b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KE7)) {
            return false;
        }
        KE7 ke7 = (KE7) obj;
        return AbstractC13042fc3.d(this.a, ke7.a) && AbstractC13042fc3.d(this.b, ke7.b);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C25247zz c25247zz = this.b;
        return iHashCode + (c25247zz == null ? 0 : c25247zz.hashCode());
    }

    public String toString() {
        return "UpdateMessagePinned(peer=" + this.a + ", pinnedMessage=" + this.b + Separators.RPAREN;
    }
}
