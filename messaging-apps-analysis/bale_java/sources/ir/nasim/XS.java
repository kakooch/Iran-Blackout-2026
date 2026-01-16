package ir.nasim;

import ir.nasim.AbstractC21997uV0;

/* loaded from: classes2.dex */
final class XS extends AbstractC21997uV0 {
    private final AbstractC21997uV0.b a;
    private final AbstractC7863Tn b;

    static final class b extends AbstractC21997uV0.a {
        private AbstractC21997uV0.b a;
        private AbstractC7863Tn b;

        b() {
        }

        @Override // ir.nasim.AbstractC21997uV0.a
        public AbstractC21997uV0 a() {
            return new XS(this.a, this.b);
        }

        @Override // ir.nasim.AbstractC21997uV0.a
        public AbstractC21997uV0.a b(AbstractC7863Tn abstractC7863Tn) {
            this.b = abstractC7863Tn;
            return this;
        }

        @Override // ir.nasim.AbstractC21997uV0.a
        public AbstractC21997uV0.a c(AbstractC21997uV0.b bVar) {
            this.a = bVar;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC21997uV0
    public AbstractC7863Tn b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC21997uV0
    public AbstractC21997uV0.b c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC21997uV0)) {
            return false;
        }
        AbstractC21997uV0 abstractC21997uV0 = (AbstractC21997uV0) obj;
        AbstractC21997uV0.b bVar = this.a;
        if (bVar != null ? bVar.equals(abstractC21997uV0.c()) : abstractC21997uV0.c() == null) {
            AbstractC7863Tn abstractC7863Tn = this.b;
            if (abstractC7863Tn == null) {
                if (abstractC21997uV0.b() == null) {
                    return true;
                }
            } else if (abstractC7863Tn.equals(abstractC21997uV0.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC21997uV0.b bVar = this.a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC7863Tn abstractC7863Tn = this.b;
        return iHashCode ^ (abstractC7863Tn != null ? abstractC7863Tn.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.a + ", androidClientInfo=" + this.b + "}";
    }

    private XS(AbstractC21997uV0.b bVar, AbstractC7863Tn abstractC7863Tn) {
        this.a = bVar;
        this.b = abstractC7863Tn;
    }
}
