package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* loaded from: classes5.dex */
public final class AE7 extends AbstractC20556sC7 {
    private final MessageIdentifier a;
    private final ExPeer b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AE7(MessageIdentifier messageIdentifier, ExPeer exPeer) {
        super(null);
        AbstractC13042fc3.i(messageIdentifier, "messageId");
        AbstractC13042fc3.i(exPeer, "peer");
        this.a = messageIdentifier;
        this.b = exPeer;
    }

    public final MessageIdentifier a() {
        return this.a;
    }

    public final ExPeer b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AE7)) {
            return false;
        }
        AE7 ae7 = (AE7) obj;
        return AbstractC13042fc3.d(this.a, ae7.a) && AbstractC13042fc3.d(this.b, ae7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateMentionReadByMe(messageId=" + this.a + ", peer=" + this.b + Separators.RPAREN;
    }
}
