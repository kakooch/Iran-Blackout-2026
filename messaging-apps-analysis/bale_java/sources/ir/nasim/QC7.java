package ir.nasim;

import ai.bale.proto.MeetStruct$Call;
import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QC7 extends AbstractC20556sC7 {
    private final MeetStruct$Call a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QC7(MeetStruct$Call meetStruct$Call) {
        super(null);
        AbstractC13042fc3.i(meetStruct$Call, "call");
        this.a = meetStruct$Call;
    }

    public final MeetStruct$Call a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QC7) && AbstractC13042fc3.d(this.a, ((QC7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateCallStarted(call=" + this.a + Separators.RPAREN;
    }
}
