package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class T74 {
    private final C11458d25 a;
    private final long b;
    private final long c;

    public T74(C11458d25 c11458d25, long j, long j2) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = j;
        this.c = j2;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.c;
    }

    public final C11458d25 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T74)) {
            return false;
        }
        T74 t74 = (T74) obj;
        return AbstractC13042fc3.d(this.a, t74.a) && this.b == t74.b && this.c == t74.c;
    }

    public final long f() {
        return this.b;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "MessageUniqueId(peer=" + this.a + ", rid=" + this.b + ", date=" + this.c + Separators.RPAREN;
    }
}
