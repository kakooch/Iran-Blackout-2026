package ir.nasim;

import ir.nasim.AI3;
import java.util.List;

/* renamed from: ir.nasim.oT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C18319oT extends AI3 {
    private final long a;
    private final long b;
    private final AbstractC21997uV0 c;
    private final Integer d;
    private final String e;
    private final List f;
    private final EnumC23479wz5 g;

    /* renamed from: ir.nasim.oT$b */
    static final class b extends AI3.a {
        private Long a;
        private Long b;
        private AbstractC21997uV0 c;
        private Integer d;
        private String e;
        private List f;
        private EnumC23479wz5 g;

        b() {
        }

        @Override // ir.nasim.AI3.a
        public AI3 a() {
            String str = "";
            if (this.a == null) {
                str = " requestTimeMs";
            }
            if (this.b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new C18319oT(this.a.longValue(), this.b.longValue(), this.c, this.d, this.e, this.f, this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AI3.a
        public AI3.a b(AbstractC21997uV0 abstractC21997uV0) {
            this.c = abstractC21997uV0;
            return this;
        }

        @Override // ir.nasim.AI3.a
        public AI3.a c(List list) {
            this.f = list;
            return this;
        }

        @Override // ir.nasim.AI3.a
        AI3.a d(Integer num) {
            this.d = num;
            return this;
        }

        @Override // ir.nasim.AI3.a
        AI3.a e(String str) {
            this.e = str;
            return this;
        }

        @Override // ir.nasim.AI3.a
        public AI3.a f(EnumC23479wz5 enumC23479wz5) {
            this.g = enumC23479wz5;
            return this;
        }

        @Override // ir.nasim.AI3.a
        public AI3.a g(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.AI3.a
        public AI3.a h(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    @Override // ir.nasim.AI3
    public AbstractC21997uV0 b() {
        return this.c;
    }

    @Override // ir.nasim.AI3
    public List c() {
        return this.f;
    }

    @Override // ir.nasim.AI3
    public Integer d() {
        return this.d;
    }

    @Override // ir.nasim.AI3
    public String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        AbstractC21997uV0 abstractC21997uV0;
        Integer num;
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AI3)) {
            return false;
        }
        AI3 ai3 = (AI3) obj;
        if (this.a == ai3.g() && this.b == ai3.h() && ((abstractC21997uV0 = this.c) != null ? abstractC21997uV0.equals(ai3.b()) : ai3.b() == null) && ((num = this.d) != null ? num.equals(ai3.d()) : ai3.d() == null) && ((str = this.e) != null ? str.equals(ai3.e()) : ai3.e() == null) && ((list = this.f) != null ? list.equals(ai3.c()) : ai3.c() == null)) {
            EnumC23479wz5 enumC23479wz5 = this.g;
            if (enumC23479wz5 == null) {
                if (ai3.f() == null) {
                    return true;
                }
            } else if (enumC23479wz5.equals(ai3.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.AI3
    public EnumC23479wz5 f() {
        return this.g;
    }

    @Override // ir.nasim.AI3
    public long g() {
        return this.a;
    }

    @Override // ir.nasim.AI3
    public long h() {
        return this.b;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        AbstractC21997uV0 abstractC21997uV0 = this.c;
        int iHashCode = (i ^ (abstractC21997uV0 == null ? 0 : abstractC21997uV0.hashCode())) * 1000003;
        Integer num = this.d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        EnumC23479wz5 enumC23479wz5 = this.g;
        return iHashCode4 ^ (enumC23479wz5 != null ? enumC23479wz5.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.b + ", clientInfo=" + this.c + ", logSource=" + this.d + ", logSourceName=" + this.e + ", logEvents=" + this.f + ", qosTier=" + this.g + "}";
    }

    private C18319oT(long j, long j2, AbstractC21997uV0 abstractC21997uV0, Integer num, String str, List list, EnumC23479wz5 enumC23479wz5) {
        this.a = j;
        this.b = j2;
        this.c = abstractC21997uV0;
        this.d = num;
        this.e = str;
        this.f = list;
        this.g = enumC23479wz5;
    }
}
