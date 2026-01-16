package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class EC7 extends AbstractC20556sC7 {
    private final MeetStruct$Call a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EC7(MeetStruct$Call meetStruct$Call, List list) {
        super(null);
        AbstractC13042fc3.i(meetStruct$Call, "call");
        AbstractC13042fc3.i(list, "participants");
        this.a = meetStruct$Call;
        this.b = list;
    }

    public final MeetStruct$Call a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EC7)) {
            return false;
        }
        EC7 ec7 = (EC7) obj;
        return AbstractC13042fc3.d(this.a, ec7.a) && AbstractC13042fc3.d(this.b, ec7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateCallAccepted(call=" + this.a + ", participants=" + this.b + Separators.RPAREN;
    }
}
