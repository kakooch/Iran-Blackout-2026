package ir.nasim;

import ir.nasim.AbstractC4684Gc6;
import java.util.Set;

/* renamed from: ir.nasim.zT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C24938zT extends AbstractC4684Gc6.b {
    private final long a;
    private final long b;
    private final Set c;

    /* renamed from: ir.nasim.zT$b */
    static final class b extends AbstractC4684Gc6.b.a {
        private Long a;
        private Long b;
        private Set c;

        b() {
        }

        @Override // ir.nasim.AbstractC4684Gc6.b.a
        public AbstractC4684Gc6.b a() {
            String str = "";
            if (this.a == null) {
                str = " delta";
            }
            if (this.b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C24938zT(this.a.longValue(), this.b.longValue(), this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC4684Gc6.b.a
        public AbstractC4684Gc6.b.a b(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.AbstractC4684Gc6.b.a
        public AbstractC4684Gc6.b.a c(Set set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.c = set;
            return this;
        }

        @Override // ir.nasim.AbstractC4684Gc6.b.a
        public AbstractC4684Gc6.b.a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    @Override // ir.nasim.AbstractC4684Gc6.b
    long b() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC4684Gc6.b
    Set c() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC4684Gc6.b
    long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4684Gc6.b)) {
            return false;
        }
        AbstractC4684Gc6.b bVar = (AbstractC4684Gc6.b) obj;
        return this.a == bVar.b() && this.b == bVar.d() && this.c.equals(bVar.c());
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.b;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.b + ", flags=" + this.c + "}";
    }

    private C24938zT(long j, long j2, Set set) {
        this.a = j;
        this.b = j2;
        this.c = set;
    }
}
