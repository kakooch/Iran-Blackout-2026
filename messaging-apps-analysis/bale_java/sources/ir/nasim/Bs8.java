package ir.nasim;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class Bs8 extends ThreadPoolExecutor {
    final /* synthetic */ Gu8 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Bs8(Gu8 gu8) {
        super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
        this.a = gu8;
        setThreadFactory(new St8(null));
        allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new C13825gs8(this, runnable, obj);
    }
}
