package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20574sE7 extends AbstractC20556sC7 {
    private final int a;
    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final boolean f;

    public C20574sE7(int i, long j, int i2, int i3, long j2, boolean z) {
        super(null);
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = i3;
        this.e = j2;
        this.f = z;
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
        if (!(obj instanceof C20574sE7)) {
            return false;
        }
        C20574sE7 c20574sE7 = (C20574sE7) obj;
        return this.a == c20574sE7.a && this.b == c20574sE7.b && this.c == c20574sE7.c && this.d == c20574sE7.d && this.e == c20574sE7.e && this.f == c20574sE7.f;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "UpdateGroupUserInvitedObsolete(groupId=" + this.a + ", rid=" + this.b + ", uid=" + this.c + ", inviterUid=" + this.d + ", date=" + this.e + ", isJoined=" + this.f + Separators.RPAREN;
    }
}
