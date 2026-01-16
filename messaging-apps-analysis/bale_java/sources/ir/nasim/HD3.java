package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class HD3 {
    public static final a f = new a(null);
    private final long a;
    private final long b;
    private final long c;
    private final long d;
    private final int e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public HD3(long j, long j2, long j3, long j4, int i) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.e = i;
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.d;
    }

    public final long c() {
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
        if (!(obj instanceof HD3)) {
            return false;
        }
        HD3 hd3 = (HD3) obj;
        return this.a == hd3.a && this.b == hd3.b && this.c == hd3.c && this.d == hd3.d && this.e == hd3.e;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "LiveStreamEntity(liveKey=" + this.a + ", peerUniqueId=" + this.b + ", messageRid=" + this.c + ", messageDate=" + this.d + ", userCount=" + this.e + Separators.RPAREN;
    }
}
