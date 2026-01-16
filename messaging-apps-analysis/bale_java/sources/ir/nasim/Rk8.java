package ir.nasim;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes3.dex */
final class Rk8 implements ThreadFactory {
    Rk8() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
