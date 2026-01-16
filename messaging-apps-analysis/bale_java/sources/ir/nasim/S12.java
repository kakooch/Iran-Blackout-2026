package ir.nasim;

/* loaded from: classes8.dex */
public abstract class S12 {
    private static final boolean a = false;
    private static final ThreadLocal[] b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal();
        }
        b = threadLocalArr;
    }

    public static final boolean a() {
        return a;
    }
}
