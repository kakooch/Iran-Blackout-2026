package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.uE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21851uE7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final int d;
    private final long e;

    public C21851uE7(int i, long j, int i2, int i3, long j2) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = i3;
        this.e = j2;
    }

    public final long a() {
        return this.e;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.d;
    }

    public final long d() {
        return this.b;
    }

    public final int e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21851uE7)) {
            return false;
        }
        C21851uE7 c21851uE7 = (C21851uE7) obj;
        return this.a == c21851uE7.a && this.b == c21851uE7.b && this.c == c21851uE7.c && this.d == c21851uE7.d && this.e == c21851uE7.e;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "UpdateGroupUserKickObsolete(groupId=" + this.a + ", rid=" + this.b + ", uid=" + this.c + ", kickerUid=" + this.d + ", date=" + this.e + Separators.RPAREN;
    }
}
