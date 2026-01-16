package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.gE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13446gE7 extends AbstractC20556sC7 {
    private final int a;
    private final C25247zz b;

    public C13446gE7(int i, C25247zz c25247zz) {
        super(null);
        this.a = i;
        this.b = c25247zz;
    }

    public final int a() {
        return this.a;
    }

    public final C25247zz b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13446gE7)) {
            return false;
        }
        C13446gE7 c13446gE7 = (C13446gE7) obj;
        return this.a == c13446gE7.a && AbstractC13042fc3.d(this.b, c13446gE7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        C25247zz c25247zz = this.b;
        return iHashCode + (c25247zz == null ? 0 : c25247zz.hashCode());
    }

    public String toString() {
        return "UpdateGroupMessagePinned(groupId=" + this.a + ", message=" + this.b + Separators.RPAREN;
    }
}
