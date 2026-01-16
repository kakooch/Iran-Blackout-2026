package ir.nasim;

/* renamed from: ir.nasim.pT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C18910pT extends BI3 {
    private final long a;

    C18910pT(long j) {
        this.a = j;
    }

    @Override // ir.nasim.BI3
    public long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BI3) && this.a == ((BI3) obj).c();
    }

    public int hashCode() {
        long j = this.a;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}
