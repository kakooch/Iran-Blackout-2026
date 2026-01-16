package ir.nasim;

import ai.bale.proto.CollectionsStruct$MapValue;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.eG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12237eG7 extends AbstractC20556sC7 {
    private final int a;
    private final CollectionsStruct$MapValue b;

    public C12237eG7(int i, CollectionsStruct$MapValue collectionsStruct$MapValue) {
        super(null);
        this.a = i;
        this.b = collectionsStruct$MapValue;
    }

    public final CollectionsStruct$MapValue a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12237eG7)) {
            return false;
        }
        C12237eG7 c12237eG7 = (C12237eG7) obj;
        return this.a == c12237eG7.a && AbstractC13042fc3.d(this.b, c12237eG7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.b;
        return iHashCode + (collectionsStruct$MapValue == null ? 0 : collectionsStruct$MapValue.hashCode());
    }

    public String toString() {
        return "UpdateUserExtChanged(uid=" + this.a + ", ext=" + this.b + Separators.RPAREN;
    }
}
