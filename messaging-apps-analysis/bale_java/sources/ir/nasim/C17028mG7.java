package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17028mG7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;

    public C17028mG7(int i, String str) {
        super(null);
        this.a = i;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17028mG7)) {
            return false;
        }
        C17028mG7 c17028mG7 = (C17028mG7) obj;
        return this.a == c17028mG7.a && AbstractC13042fc3.d(this.b, c17028mG7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UpdateUserLocalNameChanged(uid=" + this.a + ", localName=" + this.b + Separators.RPAREN;
    }
}
