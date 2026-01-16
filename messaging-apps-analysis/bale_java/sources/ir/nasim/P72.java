package ir.nasim;

/* loaded from: classes7.dex */
public abstract class P72 {

    public static final class a extends P72 {
        private final Throwable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable th) {
            super(null);
            AbstractC13042fc3.i(th, "error");
            this.a = th;
        }
    }

    public static final class b extends P72 {
        public static final b a = new b();

        private b() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public int hashCode() {
            return 150108098;
        }

        public String toString() {
            return "Idle";
        }
    }

    public static final class c extends P72 {
        public static final c a = new c();

        private c() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof c);
        }

        public int hashCode() {
            return -1442007676;
        }

        public String toString() {
            return "IsLoading";
        }
    }

    public static final class d extends P72 {
        private final boolean a;

        public d(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }
    }

    private P72() {
    }

    public /* synthetic */ P72(ED1 ed1) {
        this();
    }
}
