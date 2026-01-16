package ir.nasim;

/* loaded from: classes3.dex */
public final class MG1 {
    public static final MG1 a = new MG1();
    private static final ThreadLocal b = new ThreadLocal();
    private static final ThreadLocal c;

    static {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(Boolean.FALSE);
        c = threadLocal;
    }

    private MG1() {
    }

    public final ThreadLocal a() {
        return b;
    }

    public final ThreadLocal b() {
        return c;
    }
}
