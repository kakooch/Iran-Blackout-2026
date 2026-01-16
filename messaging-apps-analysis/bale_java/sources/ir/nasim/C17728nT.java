package ir.nasim;

import ir.nasim.AbstractC21883uI3;
import java.util.Arrays;

/* renamed from: ir.nasim.nT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C17728nT extends AbstractC21883uI3 {
    private final long a;
    private final Integer b;
    private final long c;
    private final byte[] d;
    private final String e;
    private final long f;
    private final AbstractC7895Tq4 g;

    /* renamed from: ir.nasim.nT$b */
    static final class b extends AbstractC21883uI3.a {
        private Long a;
        private Integer b;
        private Long c;
        private byte[] d;
        private String e;
        private Long f;
        private AbstractC7895Tq4 g;

        b() {
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        public AbstractC21883uI3 a() {
            String str = "";
            if (this.a == null) {
                str = " eventTimeMs";
            }
            if (this.c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new C17728nT(this.a.longValue(), this.b, this.c.longValue(), this.d, this.e, this.f.longValue(), this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        public AbstractC21883uI3.a b(Integer num) {
            this.b = num;
            return this;
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        public AbstractC21883uI3.a c(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        public AbstractC21883uI3.a d(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        public AbstractC21883uI3.a e(AbstractC7895Tq4 abstractC7895Tq4) {
            this.g = abstractC7895Tq4;
            return this;
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        AbstractC21883uI3.a f(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        AbstractC21883uI3.a g(String str) {
            this.e = str;
            return this;
        }

        @Override // ir.nasim.AbstractC21883uI3.a
        public AbstractC21883uI3.a h(long j) {
            this.f = Long.valueOf(j);
            return this;
        }
    }

    @Override // ir.nasim.AbstractC21883uI3
    public Integer b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC21883uI3
    public long c() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC21883uI3
    public long d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC21883uI3
    public AbstractC7895Tq4 e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC21883uI3)) {
            return false;
        }
        AbstractC21883uI3 abstractC21883uI3 = (AbstractC21883uI3) obj;
        if (this.a == abstractC21883uI3.c() && ((num = this.b) != null ? num.equals(abstractC21883uI3.b()) : abstractC21883uI3.b() == null) && this.c == abstractC21883uI3.d()) {
            if (Arrays.equals(this.d, abstractC21883uI3 instanceof C17728nT ? ((C17728nT) abstractC21883uI3).d : abstractC21883uI3.f()) && ((str = this.e) != null ? str.equals(abstractC21883uI3.g()) : abstractC21883uI3.g() == null) && this.f == abstractC21883uI3.h()) {
                AbstractC7895Tq4 abstractC7895Tq4 = this.g;
                if (abstractC7895Tq4 == null) {
                    if (abstractC21883uI3.e() == null) {
                        return true;
                    }
                } else if (abstractC7895Tq4.equals(abstractC21883uI3.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.AbstractC21883uI3
    public byte[] f() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC21883uI3
    public String g() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC21883uI3
    public long h() {
        return this.f;
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j2 = this.c;
        int iHashCode2 = (((((i ^ iHashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f;
        int i2 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        AbstractC7895Tq4 abstractC7895Tq4 = this.g;
        return i2 ^ (abstractC7895Tq4 != null ? abstractC7895Tq4.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.b + ", eventUptimeMs=" + this.c + ", sourceExtension=" + Arrays.toString(this.d) + ", sourceExtensionJsonProto3=" + this.e + ", timezoneOffsetSeconds=" + this.f + ", networkConnectionInfo=" + this.g + "}";
    }

    private C17728nT(long j, Integer num, long j2, byte[] bArr, String str, long j3, AbstractC7895Tq4 abstractC7895Tq4) {
        this.a = j;
        this.b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = abstractC7895Tq4;
    }
}
