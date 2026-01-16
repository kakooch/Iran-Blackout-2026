package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.wE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23037wE7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final long d;

    public C23037wE7(int i, long j, int i2, long j2) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = j2;
    }

    public final long a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23037wE7)) {
            return false;
        }
        C23037wE7 c23037wE7 = (C23037wE7) obj;
        return this.a == c23037wE7.a && this.b == c23037wE7.b && this.c == c23037wE7.c && this.d == c23037wE7.d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "UpdateGroupUserLeaveObsolete(groupId=" + this.a + ", rid=" + this.b + ", uid=" + this.c + ", date=" + this.d + Separators.RPAREN;
    }
}
