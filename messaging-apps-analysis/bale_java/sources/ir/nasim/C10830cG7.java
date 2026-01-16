package ir.nasim;

import ai.bale.proto.PeersStruct$ExInfo;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10830cG7 extends AbstractC20556sC7 {
    private final int a;
    private final PeersStruct$ExInfo b;

    public C10830cG7(int i, PeersStruct$ExInfo peersStruct$ExInfo) {
        super(null);
        this.a = i;
        this.b = peersStruct$ExInfo;
    }

    public final PeersStruct$ExInfo a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10830cG7)) {
            return false;
        }
        C10830cG7 c10830cG7 = (C10830cG7) obj;
        return this.a == c10830cG7.a && AbstractC13042fc3.d(this.b, c10830cG7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        PeersStruct$ExInfo peersStruct$ExInfo = this.b;
        return iHashCode + (peersStruct$ExInfo == null ? 0 : peersStruct$ExInfo.hashCode());
    }

    public String toString() {
        return "UpdateUserExInfoChanged(uid=" + this.a + ", exInfo=" + this.b + Separators.RPAREN;
    }
}
