package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class MT1 implements Executor {
    private static volatile MT1 a;

    MT1() {
    }

    static Executor a() {
        if (a != null) {
            return a;
        }
        synchronized (MT1.class) {
            try {
                if (a == null) {
                    a = new MT1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
