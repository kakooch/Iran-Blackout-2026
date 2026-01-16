package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kG7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15846kG7 extends AbstractC20556sC7 {
    private final int a;
    private final EnumC24265yK1 b;
    private final String c;
    private final Long d;

    public C15846kG7(int i, EnumC24265yK1 enumC24265yK1, String str, Long l) {
        super(null);
        this.a = i;
        this.b = enumC24265yK1;
        this.c = str;
        this.d = l;
    }

    public final Long a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15846kG7)) {
            return false;
        }
        C15846kG7 c15846kG7 = (C15846kG7) obj;
        return this.a == c15846kG7.a && this.b == c15846kG7.b && AbstractC13042fc3.d(this.c, c15846kG7.c) && AbstractC13042fc3.d(this.d, c15846kG7.d);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        EnumC24265yK1 enumC24265yK1 = this.b;
        int iHashCode2 = (iHashCode + (enumC24265yK1 == null ? 0 : enumC24265yK1.hashCode())) * 31;
        String str = this.c;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.d;
        return iHashCode3 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "UpdateUserLastSeenUnknown(uid=" + this.a + ", deviceType=" + this.b + ", deviceCategory=" + this.c + ", date=" + this.d + Separators.RPAREN;
    }
}
