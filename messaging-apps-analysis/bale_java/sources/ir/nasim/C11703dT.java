package ir.nasim;

import ir.nasim.AbstractC13649gb2;

/* renamed from: ir.nasim.dT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C11703dT extends AbstractC13649gb2 {
    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;

    /* renamed from: ir.nasim.dT$b */
    static final class b extends AbstractC13649gb2.a {
        private Long a;
        private Integer b;
        private Integer c;
        private Long d;
        private Integer e;

        b() {
        }

        @Override // ir.nasim.AbstractC13649gb2.a
        AbstractC13649gb2 a() {
            String str = "";
            if (this.a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.b == null) {
                str = str + " loadBatchSize";
            }
            if (this.c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C11703dT(this.a.longValue(), this.b.intValue(), this.c.intValue(), this.d.longValue(), this.e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC13649gb2.a
        AbstractC13649gb2.a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // ir.nasim.AbstractC13649gb2.a
        AbstractC13649gb2.a c(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.AbstractC13649gb2.a
        AbstractC13649gb2.a d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // ir.nasim.AbstractC13649gb2.a
        AbstractC13649gb2.a e(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // ir.nasim.AbstractC13649gb2.a
        AbstractC13649gb2.a f(long j) {
            this.a = Long.valueOf(j);
            return this;
        }
    }

    @Override // ir.nasim.AbstractC13649gb2
    int b() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC13649gb2
    long c() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC13649gb2
    int d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC13649gb2
    int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC13649gb2)) {
            return false;
        }
        AbstractC13649gb2 abstractC13649gb2 = (AbstractC13649gb2) obj;
        return this.b == abstractC13649gb2.f() && this.c == abstractC13649gb2.d() && this.d == abstractC13649gb2.b() && this.e == abstractC13649gb2.c() && this.f == abstractC13649gb2.e();
    }

    @Override // ir.nasim.AbstractC13649gb2
    long f() {
        return this.b;
    }

    public int hashCode() {
        long j = this.b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j2 = this.e;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.b + ", loadBatchSize=" + this.c + ", criticalSectionEnterTimeoutMs=" + this.d + ", eventCleanUpAge=" + this.e + ", maxBlobByteSizePerRow=" + this.f + "}";
    }

    private C11703dT(long j, int i, int i2, long j2, int i3) {
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }
}
