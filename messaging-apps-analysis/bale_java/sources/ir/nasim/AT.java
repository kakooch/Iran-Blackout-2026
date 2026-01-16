package ir.nasim;

import ir.nasim.AbstractC4075Do6;

/* loaded from: classes2.dex */
final class AT extends AbstractC4075Do6 {
    private final AbstractC5792Kv7 a;
    private final String b;
    private final AbstractC18976pa2 c;
    private final InterfaceC19191pv7 d;
    private final C11515d82 e;

    static final class b extends AbstractC4075Do6.a {
        private AbstractC5792Kv7 a;
        private String b;
        private AbstractC18976pa2 c;
        private InterfaceC19191pv7 d;
        private C11515d82 e;

        b() {
        }

        @Override // ir.nasim.AbstractC4075Do6.a
        public AbstractC4075Do6 a() {
            String str = "";
            if (this.a == null) {
                str = " transportContext";
            }
            if (this.b == null) {
                str = str + " transportName";
            }
            if (this.c == null) {
                str = str + " event";
            }
            if (this.d == null) {
                str = str + " transformer";
            }
            if (this.e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AT(this.a, this.b, this.c, this.d, this.e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // ir.nasim.AbstractC4075Do6.a
        AbstractC4075Do6.a b(C11515d82 c11515d82) {
            if (c11515d82 == null) {
                throw new NullPointerException("Null encoding");
            }
            this.e = c11515d82;
            return this;
        }

        @Override // ir.nasim.AbstractC4075Do6.a
        AbstractC4075Do6.a c(AbstractC18976pa2 abstractC18976pa2) {
            if (abstractC18976pa2 == null) {
                throw new NullPointerException("Null event");
            }
            this.c = abstractC18976pa2;
            return this;
        }

        @Override // ir.nasim.AbstractC4075Do6.a
        AbstractC4075Do6.a d(InterfaceC19191pv7 interfaceC19191pv7) {
            if (interfaceC19191pv7 == null) {
                throw new NullPointerException("Null transformer");
            }
            this.d = interfaceC19191pv7;
            return this;
        }

        @Override // ir.nasim.AbstractC4075Do6.a
        public AbstractC4075Do6.a e(AbstractC5792Kv7 abstractC5792Kv7) {
            if (abstractC5792Kv7 == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.a = abstractC5792Kv7;
            return this;
        }

        @Override // ir.nasim.AbstractC4075Do6.a
        public AbstractC4075Do6.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.b = str;
            return this;
        }
    }

    @Override // ir.nasim.AbstractC4075Do6
    public C11515d82 b() {
        return this.e;
    }

    @Override // ir.nasim.AbstractC4075Do6
    AbstractC18976pa2 c() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC4075Do6
    InterfaceC19191pv7 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4075Do6)) {
            return false;
        }
        AbstractC4075Do6 abstractC4075Do6 = (AbstractC4075Do6) obj;
        return this.a.equals(abstractC4075Do6.f()) && this.b.equals(abstractC4075Do6.g()) && this.c.equals(abstractC4075Do6.c()) && this.d.equals(abstractC4075Do6.e()) && this.e.equals(abstractC4075Do6.b());
    }

    @Override // ir.nasim.AbstractC4075Do6
    public AbstractC5792Kv7 f() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC4075Do6
    public String g() {
        return this.b;
    }

    public int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.a + ", transportName=" + this.b + ", event=" + this.c + ", transformer=" + this.d + ", encoding=" + this.e + "}";
    }

    private AT(AbstractC5792Kv7 abstractC5792Kv7, String str, AbstractC18976pa2 abstractC18976pa2, InterfaceC19191pv7 interfaceC19191pv7, C11515d82 c11515d82) {
        this.a = abstractC5792Kv7;
        this.b = str;
        this.c = abstractC18976pa2;
        this.d = interfaceC19191pv7;
        this.e = c11515d82;
    }
}
