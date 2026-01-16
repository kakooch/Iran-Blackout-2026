package ir.nasim;

/* renamed from: ir.nasim.ch5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11078ch5 {
    private final int a;

    private /* synthetic */ C11078ch5(int i) {
        this.a = i;
    }

    public static final /* synthetic */ C11078ch5 a(int i) {
        return new C11078ch5(i);
    }

    public static boolean c(int i, Object obj) {
        return (obj instanceof C11078ch5) && i == ((C11078ch5) obj).f();
    }

    public static int d(int i) {
        return Integer.hashCode(i);
    }

    public static String e(int i) {
        return "PointerKeyboardModifiers(packedValue=" + i + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ int f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }

    public static int b(int i) {
        return i;
    }
}
