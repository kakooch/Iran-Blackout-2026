package ir.nasim;

import ir.nasim.AbstractC23405wr7;

/* loaded from: classes3.dex */
final class LT extends AbstractC23405wr7 {
    private final String a;
    private final long b;
    private final AbstractC23405wr7.b c;

    static final class b extends AbstractC23405wr7.a {
        private String a;
        private Long b;
        private AbstractC23405wr7.b c;

        b() {
        }

        @Override // ir.nasim.AbstractC23405wr7.a
        public AbstractC23405wr7 a() {
            String str = "";
            if (this.b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new LT(this.a, this.b.longValue(), this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC23405wr7.a
        public AbstractC23405wr7.a b(AbstractC23405wr7.b bVar) {
            this.c = bVar;
            return this;
        }

        @Override // ir.nasim.AbstractC23405wr7.a
        public AbstractC23405wr7.a c(String str) {
            this.a = str;
            return this;
        }

        @Override // ir.nasim.AbstractC23405wr7.a
        public AbstractC23405wr7.a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    @Override // ir.nasim.AbstractC23405wr7
    public AbstractC23405wr7.b b() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC23405wr7
    public String c() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC23405wr7
    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC23405wr7)) {
            return false;
        }
        AbstractC23405wr7 abstractC23405wr7 = (AbstractC23405wr7) obj;
        String str = this.a;
        if (str != null ? str.equals(abstractC23405wr7.c()) : abstractC23405wr7.c() == null) {
            if (this.b == abstractC23405wr7.d()) {
                AbstractC23405wr7.b bVar = this.c;
                if (bVar == null) {
                    if (abstractC23405wr7.b() == null) {
                        return true;
                    }
                } else if (bVar.equals(abstractC23405wr7.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        AbstractC23405wr7.b bVar = this.c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.b + ", responseCode=" + this.c + "}";
    }

    private LT(String str, long j, AbstractC23405wr7.b bVar) {
        this.a = str;
        this.b = j;
        this.c = bVar;
    }
}
