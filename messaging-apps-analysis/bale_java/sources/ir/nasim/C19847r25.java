package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.r25, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19847r25 {
    public static final a d = new a(null);
    private final int a;
    private final long b;
    private final long c;

    /* renamed from: ir.nasim.r25$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C19847r25(int i, long j, long j2) {
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    public static /* synthetic */ C19847r25 b(C19847r25 c19847r25, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c19847r25.a;
        }
        if ((i2 & 2) != 0) {
            j = c19847r25.b;
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = c19847r25.c;
        }
        return c19847r25.a(i, j3, j2);
    }

    public final C19847r25 a(int i, long j, long j2) {
        return new C19847r25(i, j, j2);
    }

    public final long c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19847r25)) {
            return false;
        }
        C19847r25 c19847r25 = (C19847r25) obj;
        return this.a == c19847r25.a && this.b == c19847r25.b && this.c == c19847r25.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "PeerClicksEntity(id=" + this.a + ", peerId=" + this.b + ", clickCounts=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C19847r25(int i, long j, long j2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i, j, j2);
    }
}
