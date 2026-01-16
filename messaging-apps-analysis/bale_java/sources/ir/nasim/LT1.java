package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
enum LT1 implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
