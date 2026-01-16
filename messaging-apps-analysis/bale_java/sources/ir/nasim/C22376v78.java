package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.v78, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22376v78 {
    private final List a;

    public C22376v78(List list) {
        AbstractC13042fc3.i(list, "roomInvitedUserStates");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22376v78) && AbstractC13042fc3.d(this.a, ((C22376v78) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "WebSocketRoomState(roomInvitedUserStates=" + this.a + Separators.RPAREN;
    }
}
