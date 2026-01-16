package ir.nasim;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
final class Ru8 implements Executor {
    Ru8() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
