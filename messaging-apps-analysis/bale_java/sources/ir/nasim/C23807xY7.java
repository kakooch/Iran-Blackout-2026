package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xY7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23807xY7 {
    private final long a;
    private final long b;
    private final long c;

    public C23807xY7(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public static /* synthetic */ C23807xY7 e(C23807xY7 c23807xY7, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c23807xY7.a;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = c23807xY7.b;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = c23807xY7.c;
        }
        return c23807xY7.d(j4, j5, j3);
    }

    public final long a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final C23807xY7 d(long j, long j2, long j3) {
        return new C23807xY7(j, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23807xY7)) {
            return false;
        }
        C23807xY7 c23807xY7 = (C23807xY7) obj;
        return this.a == c23807xY7.a && this.b == c23807xY7.b && this.c == c23807xY7.c;
    }

    public final long f() {
        return this.b;
    }

    public final long g() {
        return this.a;
    }

    public final long h() {
        return this.c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "ViewsResponse(rid=" + this.a + ", date=" + this.b + ", viewsCardinally=" + this.c + Separators.RPAREN;
    }
}
