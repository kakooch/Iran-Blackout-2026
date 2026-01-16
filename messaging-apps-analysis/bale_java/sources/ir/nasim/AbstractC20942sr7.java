package ir.nasim;

/* renamed from: ir.nasim.sr7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20942sr7 {
    private final int a;

    /* renamed from: ir.nasim.sr7$a */
    public static final class a extends AbstractC20942sr7 {
        public static final a b = new a();

        private a() {
            super(WD5.have_problem, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public int hashCode() {
            return 1905934678;
        }

        public String toString() {
            return "SomethingWentWrong";
        }
    }

    /* renamed from: ir.nasim.sr7$b */
    public static final class b extends AbstractC20942sr7 {
        public static final b b = new b();

        private b() {
            super(WD5.web_app_not_available, null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return -1990208582;
        }

        public String toString() {
            return "WebAppNotAvailable";
        }
    }

    public /* synthetic */ AbstractC20942sr7(int i, ED1 ed1) {
        this(i);
    }

    public final int a() {
        return this.a;
    }

    private AbstractC20942sr7(int i) {
        this.a = i;
    }
}
