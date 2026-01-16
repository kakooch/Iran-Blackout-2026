package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.ew0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12630ew0 {
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final EnumC17523n65 g;
    private final EnumC10879cM2 h;
    private final C4763Gl4 i;

    public C12630ew0(long j, long j2, long j3, long j4, long j5, long j6, EnumC17523n65 enumC17523n65, EnumC10879cM2 enumC10879cM2, C4763Gl4 c4763Gl4) {
        AbstractC13042fc3.i(enumC17523n65, "personalCallStatus");
        AbstractC13042fc3.i(enumC10879cM2, "groupCallStatus");
        AbstractC13042fc3.i(c4763Gl4, "multiPeerStatus");
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = enumC17523n65;
        this.h = enumC10879cM2;
        this.i = c4763Gl4;
    }

    public final EnumC10879cM2 a() {
        return this.h;
    }

    public final long b() {
        return this.a;
    }

    public final long c() {
        return this.e;
    }

    public final C4763Gl4 d() {
        return this.i;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12630ew0)) {
            return false;
        }
        C12630ew0 c12630ew0 = (C12630ew0) obj;
        return this.a == c12630ew0.a && this.b == c12630ew0.b && this.c == c12630ew0.c && this.d == c12630ew0.d && this.e == c12630ew0.e && this.f == c12630ew0.f && this.g == c12630ew0.g && this.h == c12630ew0.h && AbstractC13042fc3.d(this.i, c12630ew0.i);
    }

    public final EnumC17523n65 f() {
        return this.g;
    }

    public final long g() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return "CallLog(id=" + this.a + ", peerId=" + this.b + ", startDate=" + this.c + ", duration=" + this.d + ", initiatorId=" + this.e + ", finisherId=" + this.f + ", personalCallStatus=" + this.g + ", groupCallStatus=" + this.h + ", multiPeerStatus=" + this.i + Separators.RPAREN;
    }
}
