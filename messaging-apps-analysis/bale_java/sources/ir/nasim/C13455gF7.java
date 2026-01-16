package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.gF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13455gF7 extends AbstractC20556sC7 {
    private final long a;
    private final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13455gF7(long j, List list) {
        super(null);
        AbstractC13042fc3.i(list, "peerStates");
        this.a = j;
        this.b = list;
    }

    public final long a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13455gF7)) {
            return false;
        }
        C13455gF7 c13455gF7 = (C13455gF7) obj;
        return this.a == c13455gF7.a && AbstractC13042fc3.d(this.b, c13455gF7.b);
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdatePeersStateChanged(callId=" + this.a + ", peerStates=" + this.b + Separators.RPAREN;
    }
}
