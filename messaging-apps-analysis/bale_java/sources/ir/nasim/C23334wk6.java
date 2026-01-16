package ir.nasim;

/* renamed from: ir.nasim.wk6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23334wk6 {
    public static final C23334wk6 c = new C23334wk6(0, 0);
    public final long a;
    public final long b;

    public C23334wk6(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C23334wk6.class != obj.getClass()) {
            return false;
        }
        C23334wk6 c23334wk6 = (C23334wk6) obj;
        return this.a == c23334wk6.a && this.b == c23334wk6.b;
    }

    public int hashCode() {
        return (((int) this.a) * 31) + ((int) this.b);
    }

    public String toString() {
        return "[timeUs=" + this.a + ", position=" + this.b + "]";
    }
}
