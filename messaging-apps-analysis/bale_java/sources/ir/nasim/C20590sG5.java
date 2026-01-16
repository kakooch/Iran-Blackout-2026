package ir.nasim;

import java.util.Random;

/* renamed from: ir.nasim.sG5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20590sG5 {
    public static final C20590sG5 a = new C20590sG5();
    private static final Random b = new Random();

    private C20590sG5() {
    }

    public static final long a() {
        long jAbs;
        Random random = b;
        synchronized (random) {
            jAbs = Math.abs(random.nextLong());
        }
        return jAbs;
    }
}
