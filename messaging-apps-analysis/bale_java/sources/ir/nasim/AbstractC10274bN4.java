package ir.nasim;

/* renamed from: ir.nasim.bN4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10274bN4 {

    /* renamed from: ir.nasim.bN4$a */
    public static final class a extends AbstractC10274bN4 {
        private final V05 a;

        public a(V05 v05) {
            super(null);
            this.a = v05;
        }

        @Override // ir.nasim.AbstractC10274bN4
        public CK5 a() {
            return this.a.getBounds();
        }

        public final V05 b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bN4$b */
    public static final class b extends AbstractC10274bN4 {
        private final CK5 a;

        public b(CK5 ck5) {
            super(null);
            this.a = ck5;
        }

        @Override // ir.nasim.AbstractC10274bN4
        public CK5 a() {
            return this.a;
        }

        public final CK5 b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* renamed from: ir.nasim.bN4$c */
    public static final class c extends AbstractC10274bN4 {
        private final I46 a;
        private final V05 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(I46 i46) {
            super(0 == true ? 1 : 0);
            V05 v05 = null;
            this.a = i46;
            if (!J46.e(i46)) {
                V05 v05A = AbstractC21611tq.a();
                V05.p(v05A, i46, null, 2, null);
                v05 = v05A;
            }
            this.b = v05;
        }

        @Override // ir.nasim.AbstractC10274bN4
        public CK5 a() {
            return J46.d(this.a);
        }

        public final I46 b() {
            return this.a;
        }

        public final V05 c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && AbstractC13042fc3.d(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private AbstractC10274bN4() {
    }

    public abstract CK5 a();

    public /* synthetic */ AbstractC10274bN4(ED1 ed1) {
        this();
    }
}
