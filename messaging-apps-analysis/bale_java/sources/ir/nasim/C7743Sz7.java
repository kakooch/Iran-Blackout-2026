package ir.nasim;

/* renamed from: ir.nasim.Sz7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7743Sz7 implements Comparable {
    public static final a b = new a(null);
    private final byte a;

    /* renamed from: ir.nasim.Sz7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ C7743Sz7(byte b2) {
        this.a = b2;
    }

    public static final /* synthetic */ C7743Sz7 a(byte b2) {
        return new C7743Sz7(b2);
    }

    public static boolean i(byte b2, Object obj) {
        return (obj instanceof C7743Sz7) && b2 == ((C7743Sz7) obj).p();
    }

    public static int j(byte b2) {
        return Byte.hashCode(b2);
    }

    public static String o(byte b2) {
        return String.valueOf(b2 & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return AbstractC13042fc3.k(p() & 255, ((C7743Sz7) obj).p() & 255);
    }

    public boolean equals(Object obj) {
        return i(this.a, obj);
    }

    public int hashCode() {
        return j(this.a);
    }

    public final /* synthetic */ byte p() {
        return this.a;
    }

    public String toString() {
        return o(this.a);
    }

    public static byte h(byte b2) {
        return b2;
    }
}
