package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.oE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18192oE7 extends AbstractC20556sC7 {
    private final int a;
    private final W06 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18192oE7(int i, W06 w06) {
        super(null);
        AbstractC13042fc3.i(w06, "restriction");
        this.a = i;
        this.b = w06;
    }

    public final int a() {
        return this.a;
    }

    public final W06 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18192oE7)) {
            return false;
        }
        C18192oE7 c18192oE7 = (C18192oE7) obj;
        return this.a == c18192oE7.a && this.b == c18192oE7.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UpdateGroupRestrictionChanged(groupId=" + this.a + ", restriction=" + this.b + Separators.RPAREN;
    }
}
