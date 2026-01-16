package ir.nasim;

/* renamed from: ir.nasim.u76, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC21784u76 {
    private static boolean a;
    private static boolean b;
    private static boolean c;

    public static boolean a() {
        return b;
    }

    public static boolean b() {
        return c;
    }

    public static boolean c() {
        return !d();
    }

    public static boolean d() {
        return a;
    }

    public static void e(Runnable runnable) {
        if (c()) {
            runnable.run();
        }
    }

    public static void f(boolean z) {
        b = z;
    }

    public static void g(boolean z) {
        c = z;
    }

    public static void h(boolean z) {
        a = z;
    }
}
