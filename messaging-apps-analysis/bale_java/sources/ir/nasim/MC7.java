package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;

/* loaded from: classes5.dex */
public final class MC7 extends AbstractC20556sC7 {
    private final ExPeer a;
    private final ExPeer b;
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MC7(ExPeer exPeer, ExPeer exPeer2, String str) {
        super(null);
        AbstractC13042fc3.i(exPeer, "sender");
        AbstractC13042fc3.i(exPeer2, "peer");
        AbstractC13042fc3.i(str, "reaction");
        this.a = exPeer;
        this.b = exPeer2;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final ExPeer b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MC7)) {
            return false;
        }
        MC7 mc7 = (MC7) obj;
        return AbstractC13042fc3.d(this.a, mc7.a) && AbstractC13042fc3.d(this.b, mc7.b) && AbstractC13042fc3.d(this.c, mc7.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "UpdateCallReactionSent(sender=" + this.a + ", peer=" + this.b + ", reaction=" + this.c + Separators.RPAREN;
    }
}
