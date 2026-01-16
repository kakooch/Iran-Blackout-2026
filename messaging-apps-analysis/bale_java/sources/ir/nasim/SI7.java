package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class SI7 {
    public static final a e = new a(null);
    private long a;
    private final long b;
    private final int c;
    private final boolean d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public SI7(long j, long j2, int i, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = z;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public final int c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SI7)) {
            return false;
        }
        SI7 si7 = (SI7) obj;
        return this.a == si7.a && this.b == si7.b && this.c == si7.c && this.d == si7.d;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "UserPresenceEntity(peerUID=" + this.a + ", lastSeen=" + this.b + ", state=" + this.c + ", unknown=" + this.d + Separators.RPAREN;
    }
}
