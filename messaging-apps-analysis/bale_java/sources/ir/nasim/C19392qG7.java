package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19392qG7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;

    public C19392qG7(int i, String str) {
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
        if (!(obj instanceof C19392qG7)) {
            return false;
        }
        C19392qG7 c19392qG7 = (C19392qG7) obj;
        return this.a == c19392qG7.a && AbstractC13042fc3.d(this.b, c19392qG7.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UpdateUserNickChanged(uid=" + this.a + ", nickname=" + this.b + Separators.RPAREN;
    }
}
