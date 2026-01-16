package ir.nasim;

/* renamed from: ir.nasim.Fr7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4571Fr7 {

    /* renamed from: ir.nasim.Fr7$a */
    public static final class a extends AbstractC4571Fr7 {
        private final I5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(I5 i5) {
            super(null);
            AbstractC13042fc3.i(i5, "items");
            this.a = i5;
        }

        public final I5 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Fr7$b */
    public static final class b extends AbstractC4571Fr7 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 325570240;
        }

        public String toString() {
            return "Normal";
        }
    }

    /* renamed from: ir.nasim.Fr7$c */
    public static final class c extends AbstractC4571Fr7 {
        private final OP5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(OP5 op5) {
            super(null);
            AbstractC13042fc3.i(op5, "reportType");
            this.a = op5;
        }

        public final OP5 a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Fr7$d */
    public static final class d extends AbstractC4571Fr7 {
        private final boolean a;
        private final boolean b;

        public /* synthetic */ d(boolean z, boolean z2, int i, ED1 ed1) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean a() {
            return this.b;
        }

        public d(boolean z, boolean z2) {
            super(null);
            this.a = z;
            this.b = z2;
        }
    }

    /* renamed from: ir.nasim.Fr7$e */
    public static final class e extends AbstractC4571Fr7 {
        private final I5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(I5 i5) {
            super(null);
            AbstractC13042fc3.i(i5, "items");
            this.a = i5;
        }

        public final I5 a() {
            return this.a;
        }
    }

    private AbstractC4571Fr7() {
    }

    public /* synthetic */ AbstractC4571Fr7(ED1 ed1) {
        this();
    }
}
