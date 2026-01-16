package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class WD7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final long d;
    private final int e;
    private final boolean f;

    public WD7(int i, long j, int i2, long j2, int i3, boolean z) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = j2;
        this.e = i3;
        this.f = z;
    }

    public final long a() {
        return this.d;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final long d() {
        return this.b;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WD7)) {
            return false;
        }
        WD7 wd7 = (WD7) obj;
        return this.a == wd7.a && this.b == wd7.b && this.c == wd7.c && this.d == wd7.d && this.e == wd7.e && this.f == wd7.f;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "UpdateGroupInviteObsolete(groupId=" + this.a + ", rid=" + this.b + ", inviteUid=" + this.c + ", date=" + this.d + ", seq=" + this.e + ", isJoined=" + this.f + Separators.RPAREN;
    }
}
