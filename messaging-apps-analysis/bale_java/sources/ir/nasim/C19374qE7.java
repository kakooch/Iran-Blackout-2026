package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.qE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19374qE7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final String d;
    private final long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19374qE7(int i, long j, int i2, String str, long j2) {
        super(null);
        AbstractC13042fc3.i(str, "title");
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = j2;
    }

    public final long a() {
        return this.e;
    }

    public final int b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19374qE7)) {
            return false;
        }
        C19374qE7 c19374qE7 = (C19374qE7) obj;
        return this.a == c19374qE7.a && this.b == c19374qE7.b && this.c == c19374qE7.c && AbstractC13042fc3.d(this.d, c19374qE7.d) && this.e == c19374qE7.e;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "UpdateGroupTitleChangedObsolete(groupId=" + this.a + ", rid=" + this.b + ", uid=" + this.c + ", title=" + this.d + ", date=" + this.e + Separators.RPAREN;
    }
}
