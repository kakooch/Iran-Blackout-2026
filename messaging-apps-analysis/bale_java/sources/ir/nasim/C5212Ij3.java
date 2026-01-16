package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.Ij3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5212Ij3 {
    private final C23464wy a;
    private int b;
    private final List c;
    private final List d;
    private final long e;
    private final int f;
    private int g;
    private final byte[] h;
    private final long i;
    private final boolean j;

    public C5212Ij3(C23464wy c23464wy, int i, List list, List list2, long j, int i2, int i3, byte[] bArr, long j2, boolean z) {
        AbstractC13042fc3.i(c23464wy, "group");
        AbstractC13042fc3.i(list, "users");
        AbstractC13042fc3.i(list2, "userPeers");
        AbstractC13042fc3.i(bArr, "state");
        this.a = c23464wy;
        this.b = i;
        this.c = list;
        this.d = list2;
        this.e = j;
        this.f = i2;
        this.g = i3;
        this.h = bArr;
        this.i = j2;
        this.j = z;
    }

    public final long a() {
        return this.i;
    }

    public final C23464wy b() {
        return this.a;
    }

    public final int c() {
        return this.g;
    }

    public final int d() {
        return this.b;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5212Ij3)) {
            return false;
        }
        C5212Ij3 c5212Ij3 = (C5212Ij3) obj;
        return AbstractC13042fc3.d(this.a, c5212Ij3.a) && this.b == c5212Ij3.b && AbstractC13042fc3.d(this.c, c5212Ij3.c) && AbstractC13042fc3.d(this.d, c5212Ij3.d) && this.e == c5212Ij3.e && this.f == c5212Ij3.f && this.g == c5212Ij3.g && AbstractC13042fc3.d(this.h, c5212Ij3.h) && this.i == c5212Ij3.i && this.j == c5212Ij3.j;
    }

    public final int f() {
        return this.f;
    }

    public final byte[] g() {
        return this.h;
    }

    public final List h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((((((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Arrays.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Boolean.hashCode(this.j);
    }

    public final boolean i() {
        return this.j;
    }

    public String toString() {
        return "JoinGroupResponseEntity(group=" + this.a + ", inviterUserId=" + this.b + ", users=" + this.c + ", userPeers=" + this.d + ", rid=" + this.e + ", seq=" + this.f + ", groupSeq=" + this.g + ", state=" + Arrays.toString(this.h) + ", date=" + this.i + ", isJoined=" + this.j + Separators.RPAREN;
    }
}
