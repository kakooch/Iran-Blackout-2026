package ir.nasim;

import java.io.Serializable;

/* renamed from: ir.nasim.a16, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9475a16 implements Serializable {
    public static final a b = new a(null);
    private final Object a;

    /* renamed from: ir.nasim.a16$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.a16$b */
    public static final class b implements Serializable {
        public final Throwable a;

        public b(Throwable th) {
            AbstractC13042fc3.i(th, "exception");
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && AbstractC13042fc3.d(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.a + ')';
        }
    }

    private /* synthetic */ C9475a16(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ C9475a16 a(Object obj) {
        return new C9475a16(obj);
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof C9475a16) && AbstractC13042fc3.d(obj, ((C9475a16) obj2).l());
    }

    public static final boolean d(Object obj, Object obj2) {
        return AbstractC13042fc3.d(obj, obj2);
    }

    public static final Throwable e(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).a;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof b;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof b);
    }

    public static String k(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public int hashCode() {
        return f(this.a);
    }

    public final /* synthetic */ Object l() {
        return this.a;
    }

    public String toString() {
        return k(this.a);
    }

    public static Object b(Object obj) {
        return obj;
    }
}
