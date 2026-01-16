package ir.nasim;

/* renamed from: ir.nasim.gG3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13460gG3 {
    private final boolean a;

    /* renamed from: ir.nasim.gG3$a */
    public static final class a extends AbstractC13460gG3 {
        private final Throwable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(false, null);
            AbstractC13042fc3.i(th, "error");
            this.b = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (a() == aVar.a() && AbstractC13042fc3.d(this.b, aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Boolean.hashCode(a()) + this.b.hashCode();
        }

        public String toString() {
            return "Error(endOfPaginationReached=" + a() + ", error=" + this.b + ')';
        }
    }

    /* renamed from: ir.nasim.gG3$b */
    public static final class b extends AbstractC13460gG3 {
        public static final b b = new b();

        private b() {
            super(false, null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && a() == ((b) obj).a();
        }

        public int hashCode() {
            return Boolean.hashCode(a());
        }

        public String toString() {
            return "Loading(endOfPaginationReached=" + a() + ')';
        }
    }

    /* renamed from: ir.nasim.gG3$c */
    public static final class c extends AbstractC13460gG3 {
        public static final a b = new a(null);
        private static final c c = new c(true);
        private static final c d = new c(false);

        /* renamed from: ir.nasim.gG3$c$a */
        public static final class a {
            private a() {
            }

            public final c a() {
                return c.c;
            }

            public final c b() {
                return c.d;
            }

            public /* synthetic */ a(ED1 ed1) {
                this();
            }
        }

        public c(boolean z) {
            super(z, null);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && a() == ((c) obj).a();
        }

        public int hashCode() {
            return Boolean.hashCode(a());
        }

        public String toString() {
            return "NotLoading(endOfPaginationReached=" + a() + ')';
        }
    }

    public /* synthetic */ AbstractC13460gG3(boolean z, ED1 ed1) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }

    private AbstractC13460gG3(boolean z) {
        this.a = z;
    }
}
