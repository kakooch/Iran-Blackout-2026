package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.MessageIdentifier;

/* renamed from: ir.nasim.mE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17010mE7 extends AbstractC20556sC7 {
    private final int a;
    private final MessageIdentifier b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17010mE7(int i, MessageIdentifier messageIdentifier) {
        super(null);
        AbstractC13042fc3.i(messageIdentifier, "messageId");
        this.a = i;
        this.b = messageIdentifier;
    }

    public final int a() {
        return this.a;
    }

    public final MessageIdentifier b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17010mE7)) {
            return false;
        }
        C17010mE7 c17010mE7 = (C17010mE7) obj;
        return this.a == c17010mE7.a && AbstractC13042fc3.d(this.b, c17010mE7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateGroupPinRemoved(groupId=" + this.a + ", messageId=" + this.b + Separators.RPAREN;
    }
}
