package ir.nasim;

import ir.nasim.AbstractC10416ba3;

/* renamed from: ir.nasim.kT, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C15955kT extends AbstractC10416ba3 {
    private final String a;
    private final String b;
    private final String c;
    private final AbstractC23405wr7 d;
    private final AbstractC10416ba3.b e;

    /* renamed from: ir.nasim.kT$b */
    static final class b extends AbstractC10416ba3.a {
        private String a;
        private String b;
        private String c;
        private AbstractC23405wr7 d;
        private AbstractC10416ba3.b e;

        b() {
        }

        @Override // ir.nasim.AbstractC10416ba3.a
        public AbstractC10416ba3 a() {
            return new C15955kT(this.a, this.b, this.c, this.d, this.e);
        }

        @Override // ir.nasim.AbstractC10416ba3.a
        public AbstractC10416ba3.a b(AbstractC23405wr7 abstractC23405wr7) {
            this.d = abstractC23405wr7;
            return this;
        }

        @Override // ir.nasim.AbstractC10416ba3.a
        public AbstractC10416ba3.a c(String str) {
            this.b = str;
            return this;
        }

        @Override // ir.nasim.AbstractC10416ba3.a
        public AbstractC10416ba3.a d(String str) {
            this.c = str;
            return this;
        }

        @Override // ir.nasim.AbstractC10416ba3.a
        public AbstractC10416ba3.a e(AbstractC10416ba3.b bVar) {
            this.e = bVar;
            return this;
        }

        @Override // ir.nasim.AbstractC10416ba3.a
        public AbstractC10416ba3.a f(String str) {
            this.a = str;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC10416ba3
    public AbstractC23405wr7 b() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC10416ba3
    public String c() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC10416ba3
    public String d() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC10416ba3
    public AbstractC10416ba3.b e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC10416ba3)) {
            return false;
        }
        AbstractC10416ba3 abstractC10416ba3 = (AbstractC10416ba3) obj;
        String str = this.a;
        if (str != null ? str.equals(abstractC10416ba3.f()) : abstractC10416ba3.f() == null) {
            String str2 = this.b;
            if (str2 != null ? str2.equals(abstractC10416ba3.c()) : abstractC10416ba3.c() == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(abstractC10416ba3.d()) : abstractC10416ba3.d() == null) {
                    AbstractC23405wr7 abstractC23405wr7 = this.d;
                    if (abstractC23405wr7 != null ? abstractC23405wr7.equals(abstractC10416ba3.b()) : abstractC10416ba3.b() == null) {
                        AbstractC10416ba3.b bVar = this.e;
                        if (bVar == null) {
                            if (abstractC10416ba3.e() == null) {
                                return true;
                            }
                        } else if (bVar.equals(abstractC10416ba3.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // ir.nasim.AbstractC10416ba3
    public String f() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AbstractC23405wr7 abstractC23405wr7 = this.d;
        int iHashCode4 = (iHashCode3 ^ (abstractC23405wr7 == null ? 0 : abstractC23405wr7.hashCode())) * 1000003;
        AbstractC10416ba3.b bVar = this.e;
        return iHashCode4 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.a + ", fid=" + this.b + ", refreshToken=" + this.c + ", authToken=" + this.d + ", responseCode=" + this.e + "}";
    }

    private C15955kT(String str, String str2, String str3, AbstractC23405wr7 abstractC23405wr7, AbstractC10416ba3.b bVar) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = abstractC23405wr7;
        this.e = bVar;
    }
}
