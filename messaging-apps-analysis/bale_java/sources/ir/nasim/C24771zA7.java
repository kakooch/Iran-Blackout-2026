package ir.nasim;

/* renamed from: ir.nasim.zA7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C24771zA7 implements Comparable {
    public static final a b = new a(null);
    private final short a;

    /* renamed from: ir.nasim.zA7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C24771zA7(short s) {
        this.a = s;
    }

    public static final /* synthetic */ C24771zA7 a(short s) {
        return new C24771zA7(s);
    }

    public static boolean i(short s, Object obj) {
        return (obj instanceof C24771zA7) && s == ((C24771zA7) obj).p();
    }

    public static int j(short s) {
        return Short.hashCode(s);
    }

    public static String o(short s) {
        return String.valueOf(s & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return AbstractC13042fc3.k(p() & 65535, ((C24771zA7) obj).p() & 65535);
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ short p() {
        return this.a;
    }

    public String toString() {
        return o(this.a);
    }

    public static short h(short s) {
        return s;
    }
}
