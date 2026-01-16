package ir.nasim;

import ir.nasim.AbstractC7895Tq4;

/* renamed from: ir.nasim.qT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C19501qT extends AbstractC7895Tq4 {
    private final AbstractC7895Tq4.c a;
    private final AbstractC7895Tq4.b b;

    /* renamed from: ir.nasim.qT$b */
    static final class b extends AbstractC7895Tq4.a {
        private AbstractC7895Tq4.c a;
        private AbstractC7895Tq4.b b;

        b() {
        }

        @Override // ir.nasim.AbstractC7895Tq4.a
        public AbstractC7895Tq4 a() {
            return new C19501qT(this.a, this.b);
        }

        @Override // ir.nasim.AbstractC7895Tq4.a
        public AbstractC7895Tq4.a b(AbstractC7895Tq4.b bVar) {
            this.b = bVar;
            return this;
        }

        @Override // ir.nasim.AbstractC7895Tq4.a
        public AbstractC7895Tq4.a c(AbstractC7895Tq4.c cVar) {
            this.a = cVar;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC7895Tq4
    public AbstractC7895Tq4.b b() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC7895Tq4
    public AbstractC7895Tq4.c c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC7895Tq4)) {
            return false;
        }
        AbstractC7895Tq4 abstractC7895Tq4 = (AbstractC7895Tq4) obj;
        AbstractC7895Tq4.c cVar = this.a;
        if (cVar != null ? cVar.equals(abstractC7895Tq4.c()) : abstractC7895Tq4.c() == null) {
            AbstractC7895Tq4.b bVar = this.b;
            if (bVar == null) {
                if (abstractC7895Tq4.b() == null) {
                    return true;
                }
            } else if (bVar.equals(abstractC7895Tq4.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC7895Tq4.c cVar = this.a;
        int iHashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC7895Tq4.b bVar = this.b;
        return iHashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.a + ", mobileSubtype=" + this.b + "}";
    }

    private C19501qT(AbstractC7895Tq4.c cVar, AbstractC7895Tq4.b bVar) {
        this.a = cVar;
        this.b = bVar;
    }
}
