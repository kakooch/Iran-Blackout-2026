package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14657iG7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final EnumC24265yK1 c;
    private final String d;

    public C14657iG7(int i, long j, EnumC24265yK1 enumC24265yK1, String str) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = enumC24265yK1;
        this.d = str;
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14657iG7)) {
            return false;
        }
        C14657iG7 c14657iG7 = (C14657iG7) obj;
        return this.a == c14657iG7.a && this.b == c14657iG7.b && this.c == c14657iG7.c && AbstractC13042fc3.d(this.d, c14657iG7.d);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31;
        EnumC24265yK1 enumC24265yK1 = this.c;
        int iHashCode2 = (iHashCode + (enumC24265yK1 == null ? 0 : enumC24265yK1.hashCode())) * 31;
        String str = this.d;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UpdateUserLastSeen(uid=" + this.a + ", date=" + this.b + ", deviceType=" + this.c + ", deviceCategory=" + this.d + Separators.RPAREN;
    }
}
