package ir.nasim;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class Wp8 implements InterfaceC24546yn8 {
    private Wp8() {
    }

    @Override // ir.nasim.InterfaceC24546yn8
    public final ExecutorService a(ThreadFactory threadFactory, int i) {
        return b(1, threadFactory, 9);
    }

    @Override // ir.nasim.InterfaceC24546yn8
    public final ExecutorService b(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
