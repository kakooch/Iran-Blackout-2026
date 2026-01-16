package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iw0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15057iw0 {
    public static final a j = new a(null);
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final EnumC18114o65 f;
    private final EnumC11643dM2 g;
    private final C4997Hl4 h;
    private long i;

    /* renamed from: ir.nasim.iw0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C15057iw0(long j2, long j3, long j4, long j5, long j6, EnumC18114o65 enumC18114o65, EnumC11643dM2 enumC11643dM2, C4997Hl4 c4997Hl4, long j7) {
        AbstractC13042fc3.i(enumC18114o65, "personalCallStatus");
        AbstractC13042fc3.i(enumC11643dM2, "groupCallStatus");
        AbstractC13042fc3.i(c4997Hl4, "multiPeerStatus");
        this.a = j2;
        this.b = j3;
        this.c = j4;
        this.d = j5;
        this.e = j6;
        this.f = enumC18114o65;
        this.g = enumC11643dM2;
        this.h = c4997Hl4;
        this.i = j7;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.e;
    }

    public final EnumC11643dM2 c() {
        return this.g;
    }

    public final long d() {
        return this.i;
    }

    public final long e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15057iw0)) {
            return false;
        }
        C15057iw0 c15057iw0 = (C15057iw0) obj;
        return this.a == c15057iw0.a && this.b == c15057iw0.b && this.c == c15057iw0.c && this.d == c15057iw0.d && this.e == c15057iw0.e && this.f == c15057iw0.f && this.g == c15057iw0.g && AbstractC13042fc3.d(this.h, c15057iw0.h) && this.i == c15057iw0.i;
    }

    public final C4997Hl4 f() {
        return this.h;
    }

    public final long g() {
        return this.c;
    }

    public final EnumC18114o65 h() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Long.hashCode(this.i);
    }

    public final long i() {
        return this.a;
    }

    public String toString() {
        return "CallLogEntity(startDate=" + this.a + ", duration=" + this.b + ", peerId=" + this.c + ", initiatorId=" + this.d + ", finisherId=" + this.e + ", personalCallStatus=" + this.f + ", groupCallStatus=" + this.g + ", multiPeerStatus=" + this.h + ", id=" + this.i + Separators.RPAREN;
    }
}
