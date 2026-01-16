package ir.nasim;

import ai.bale.proto.CollectionsStruct$MapValue;
import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13464gG7 extends AbstractC20556sC7 {
    private final int a;
    private final CollectionsStruct$MapValue b;

    public C13464gG7(int i, CollectionsStruct$MapValue collectionsStruct$MapValue) {
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
        if (!(obj instanceof C13464gG7)) {
            return false;
        }
        C13464gG7 c13464gG7 = (C13464gG7) obj;
        return this.a == c13464gG7.a && AbstractC13042fc3.d(this.b, c13464gG7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        CollectionsStruct$MapValue collectionsStruct$MapValue = this.b;
        return iHashCode + (collectionsStruct$MapValue == null ? 0 : collectionsStruct$MapValue.hashCode());
    }

    public String toString() {
        return "UpdateUserFullExtChanged(uid=" + this.a + ", ext=" + this.b + Separators.RPAREN;
    }
}
