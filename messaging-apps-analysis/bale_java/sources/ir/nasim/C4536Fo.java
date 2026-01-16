package ir.nasim;

/* renamed from: ir.nasim.Fo, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C4536Fo implements InterfaceC22143uk1 {
    private final int b;

    private /* synthetic */ C4536Fo(int i) {
        this.b = i;
    }

    public static final /* synthetic */ C4536Fo a(int i) {
        return new C4536Fo(i);
    }

    public static boolean c(int i, Object obj) {
        return (obj instanceof C4536Fo) && i == ((C4536Fo) obj).f();
    }

    public static int d(int i) {
        return Integer.hashCode(i);
    }

    public static String e(int i) {
        return "AndroidContentDataType(androidAutofillType=" + i + ')';
    }

    public boolean equals(Object obj) {
        return c(this.b, obj);
    }

    public final /* synthetic */ int f() {
        return this.b;
    }

    public int hashCode() {
        return d(this.b);
    }

    public String toString() {
        return e(this.b);
    }

    public static int b(int i) {
        return i;
    }
}
