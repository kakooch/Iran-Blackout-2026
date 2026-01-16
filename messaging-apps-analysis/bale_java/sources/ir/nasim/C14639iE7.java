package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14639iE7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final String d;
    private final long e;

    public C14639iE7(int i, long j, int i2, String str, long j2) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = j2;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14639iE7)) {
            return false;
        }
        C14639iE7 c14639iE7 = (C14639iE7) obj;
        return this.a == c14639iE7.a && this.b == c14639iE7.b && this.c == c14639iE7.c && AbstractC13042fc3.d(this.d, c14639iE7.d) && this.e == c14639iE7.e;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        String str = this.d;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "UpdateGroupNicknameChanged(groupId=" + this.a + ", rid=" + this.b + ", uid=" + this.c + ", nick=" + this.d + ", date=" + this.e + Separators.RPAREN;
    }
}
