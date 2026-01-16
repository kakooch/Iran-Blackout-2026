package ir.nasim;

import ai.bale.proto.MeetStruct$GroupCall;
import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QD7 extends AbstractC20556sC7 {
    private final MeetStruct$GroupCall a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QD7(MeetStruct$GroupCall meetStruct$GroupCall) {
        super(null);
        AbstractC13042fc3.i(meetStruct$GroupCall, "groupCall");
        this.a = meetStruct$GroupCall;
    }

    public final MeetStruct$GroupCall a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QD7) && AbstractC13042fc3.d(this.a, ((QD7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateGroupCallStarted(groupCall=" + this.a + Separators.RPAREN;
    }
}
