package ir.nasim;

import ir.nasim.AbstractC7747Ta2;
import java.util.Map;

/* renamed from: ir.nasim.cT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C10939cT extends AbstractC7747Ta2 {
    private final String a;
    private final Integer b;
    private final X72 c;
    private final long d;
    private final long e;
    private final Map f;

    /* renamed from: ir.nasim.cT$b */
    static final class b extends AbstractC7747Ta2.a {
        private String a;
        private Integer b;
        private X72 c;
        private Long d;
        private Long e;
        private Map f;

        b() {
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        public AbstractC7747Ta2 d() {
            String str = "";
            if (this.a == null) {
                str = " transportName";
            }
            if (this.c == null) {
                str = str + " encodedPayload";
            }
            if (this.d == null) {
                str = str + " eventMillis";
            }
            if (this.e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C10939cT(this.a, this.b, this.c, this.d.longValue(), this.e.longValue(), this.f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        protected Map e() {
            Map map = this.f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        protected AbstractC7747Ta2.a f(Map map) {
            if (map == null) {
                throw new NullPointerException("Null autoMetadata");
            }
            this.f = map;
            return this;
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        public AbstractC7747Ta2.a g(Integer num) {
            this.b = num;
            return this;
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        public AbstractC7747Ta2.a h(X72 x72) {
            if (x72 == null) {
                throw new NullPointerException("Null encodedPayload");
            }
            this.c = x72;
            return this;
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        public AbstractC7747Ta2.a i(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        public AbstractC7747Ta2.a j(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.a = str;
            return this;
        }

        @Override // ir.nasim.AbstractC7747Ta2.a
        public AbstractC7747Ta2.a k(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }

    @Override // ir.nasim.AbstractC7747Ta2
    protected Map c() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC7747Ta2
    public Integer d() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC7747Ta2
    public X72 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC7747Ta2)) {
            return false;
        }
        AbstractC7747Ta2 abstractC7747Ta2 = (AbstractC7747Ta2) obj;
        return this.a.equals(abstractC7747Ta2.j()) && ((num = this.b) != null ? num.equals(abstractC7747Ta2.d()) : abstractC7747Ta2.d() == null) && this.c.equals(abstractC7747Ta2.e()) && this.d == abstractC7747Ta2.f() && this.e == abstractC7747Ta2.k() && this.f.equals(abstractC7747Ta2.c());
    }

    @Override // ir.nasim.AbstractC7747Ta2
    public long f() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j = this.d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode();
    }

    @Override // ir.nasim.AbstractC7747Ta2
    public String j() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC7747Ta2
    public long k() {
        return this.e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + "}";
    }

    private C10939cT(String str, Integer num, X72 x72, long j, long j2, Map map) {
        this.a = str;
        this.b = num;
        this.c = x72;
        this.d = j;
        this.e = j2;
        this.f = map;
    }
}
