package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* loaded from: classes5.dex */
public final class IE7 extends AbstractC20556sC7 {
    private final ExPeer a;
    private final MessageIdentifier b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IE7(ExPeer exPeer, MessageIdentifier messageIdentifier) {
        super(null);
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(messageIdentifier, "messageId");
        this.a = exPeer;
        this.b = messageIdentifier;
    }

    public final ExPeer a() {
        return this.a;
    }

    public final MessageIdentifier b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IE7)) {
            return false;
        }
        IE7 ie7 = (IE7) obj;
        return AbstractC13042fc3.d(this.a, ie7.a) && AbstractC13042fc3.d(this.b, ie7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateMessageNewReaction(exPeer=" + this.a + ", messageId=" + this.b + Separators.RPAREN;
    }
}
