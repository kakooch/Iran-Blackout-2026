package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20592sG7 extends AbstractC20556sC7 {
    private final int a;
    private final EnumC24265yK1 b;
    private final String c;

    public C20592sG7(int i, EnumC24265yK1 enumC24265yK1, String str) {
        super(null);
        this.a = i;
        this.b = enumC24265yK1;
        this.c = str;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20592sG7)) {
            return false;
        }
        C20592sG7 c20592sG7 = (C20592sG7) obj;
        return this.a == c20592sG7.a && this.b == c20592sG7.b && AbstractC13042fc3.d(this.c, c20592sG7.c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        EnumC24265yK1 enumC24265yK1 = this.b;
        int iHashCode2 = (iHashCode + (enumC24265yK1 == null ? 0 : enumC24265yK1.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UpdateUserOffline(uid=" + this.a + ", deviceType=" + this.b + ", deviceCategory=" + this.c + Separators.RPAREN;
    }
}
