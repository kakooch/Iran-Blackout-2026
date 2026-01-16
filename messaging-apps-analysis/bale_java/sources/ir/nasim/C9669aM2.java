package ir.nasim;

import ai.bale.proto.MeetStruct$GroupCall;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aM2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9669aM2 implements InterfaceC9449Zz0 {
    private final MeetStruct$GroupCall a;

    public C9669aM2(MeetStruct$GroupCall meetStruct$GroupCall) {
        AbstractC13042fc3.i(meetStruct$GroupCall, "protoCall");
        this.a = meetStruct$GroupCall;
    }

    public final MeetStruct$GroupCall a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9669aM2) && AbstractC13042fc3.d(this.a, ((C9669aM2) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "GroupCallStarted(protoCall=" + this.a + Separators.RPAREN;
    }
}
