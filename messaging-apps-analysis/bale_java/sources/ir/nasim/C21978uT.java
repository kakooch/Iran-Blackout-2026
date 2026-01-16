package ir.nasim;

/* renamed from: ir.nasim.uT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C21978uT extends U45 {
    private final long a;
    private final AbstractC5792Kv7 b;
    private final AbstractC7747Ta2 c;

    C21978uT(long j, AbstractC5792Kv7 abstractC5792Kv7, AbstractC7747Ta2 abstractC7747Ta2) {
        this.a = j;
        if (abstractC5792Kv7 == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.b = abstractC5792Kv7;
        if (abstractC7747Ta2 == null) {
            throw new NullPointerException("Null event");
        }
        this.c = abstractC7747Ta2;
    }

    @Override // ir.nasim.U45
    public AbstractC7747Ta2 b() {
        return this.c;
    }

    @Override // ir.nasim.U45
    public long c() {
        return this.a;
    }

    @Override // ir.nasim.U45
    public AbstractC5792Kv7 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof U45)) {
            return false;
        }
        U45 u45 = (U45) obj;
        return this.a == u45.c() && this.b.equals(u45.d()) && this.c.equals(u45.b());
    }

    public int hashCode() {
        long j = this.a;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.b + ", event=" + this.c + "}";
    }
}
