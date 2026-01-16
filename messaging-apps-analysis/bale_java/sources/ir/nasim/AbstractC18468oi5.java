package ir.nasim;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: ir.nasim.oi5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC18468oi5 {
    private static final InterfaceC13051fd2 a;
    private static volatile InterfaceC13051fd2 b;

    /* renamed from: ir.nasim.oi5$b */
    private static class b implements InterfaceC13051fd2 {
        private b() {
        }

        @Override // ir.nasim.InterfaceC13051fd2
        public ExecutorService a(ThreadFactory threadFactory, EnumC10570bp7 enumC10570bp7) {
            return b(1, threadFactory, enumC10570bp7);
        }

        public ExecutorService b(int i, ThreadFactory threadFactory, EnumC10570bp7 enumC10570bp7) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        b bVar = new b();
        a = bVar;
        b = bVar;
    }

    public static InterfaceC13051fd2 a() {
        return b;
    }
}
