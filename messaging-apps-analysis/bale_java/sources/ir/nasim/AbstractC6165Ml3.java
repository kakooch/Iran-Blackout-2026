package ir.nasim;

/* renamed from: ir.nasim.Ml3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC6165Ml3 {

    /* renamed from: ir.nasim.Ml3$a */
    public static final class a extends AbstractC6165Ml3 {
        private final String a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "desc");
            this.a = str;
            this.b = str2;
        }

        @Override // ir.nasim.AbstractC6165Ml3
        public String a() {
            return c() + ':' + b();
        }

        @Override // ir.nasim.AbstractC6165Ml3
        public String b() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC6165Ml3
        public String c() {
            return this.a;
        }

        public final String d() {
            return this.a;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    /* renamed from: ir.nasim.Ml3$b */
    public static final class b extends AbstractC6165Ml3 {
        private final String a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            AbstractC13042fc3.i(str, "name");
            AbstractC13042fc3.i(str2, "desc");
            this.a = str;
            this.b = str2;
        }

        @Override // ir.nasim.AbstractC6165Ml3
        public String a() {
            return AbstractC13042fc3.q(c(), b());
        }

        @Override // ir.nasim.AbstractC6165Ml3
        public String b() {
            return this.b;
        }

        @Override // ir.nasim.AbstractC6165Ml3
        public String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return AbstractC13042fc3.d(this.a, bVar.a) && AbstractC13042fc3.d(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    private AbstractC6165Ml3() {
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return a();
    }

    public /* synthetic */ AbstractC6165Ml3(ED1 ed1) {
        this();
    }
}
