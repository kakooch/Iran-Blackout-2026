package ir.nasim;

import ir.nasim.ZV;

/* loaded from: classes2.dex */
final class PS extends ZV {
    private final ZV.a a;
    private final long b;

    PS(ZV.a aVar, long j) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.a = aVar;
        this.b = j;
    }

    @Override // ir.nasim.ZV
    public long b() {
        return this.b;
    }

    @Override // ir.nasim.ZV
    public ZV.a c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZV)) {
            return false;
        }
        ZV zv = (ZV) obj;
        return this.a.equals(zv.c()) && this.b == zv.b();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.a + ", nextRequestWaitMillis=" + this.b + "}";
    }
}
