package ir.nasim;

/* loaded from: classes8.dex */
public final class GJ0 {
    public static final b b = new b(null);
    private static final c c = new c();
    private final Object a;

    public static final class a extends c {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && AbstractC13042fc3.d(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // ir.nasim.GJ0.c
        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public final Object a(Throwable th) {
            return GJ0.c(new a(th));
        }

        public final Object b() {
            return GJ0.c(GJ0.c);
        }

        public final Object c(Object obj) {
            return GJ0.c(obj);
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ GJ0(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ GJ0 b(Object obj) {
        return new GJ0(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof GJ0) && AbstractC13042fc3.d(obj, ((GJ0) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return g(this.a);
    }

    public final /* synthetic */ Object k() {
        return this.a;
    }

    public String toString() {
        return j(this.a);
    }

    public static Object c(Object obj) {
        return obj;
    }
}
