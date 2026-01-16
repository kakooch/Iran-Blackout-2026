package ir.nasim;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: ir.nasim.sE0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20567sE0 {
    public static Executor a() {
        return MT1.a();
    }

    public static Executor b() {
        return ExecutorC3275Ae3.a();
    }

    public static ScheduledExecutorService c() {
        return AbstractC12296eN3.a();
    }

    public static ScheduledExecutorService d(Handler handler) {
        return new ScheduledExecutorServiceC22571vT2(handler);
    }

    public static Executor e(Executor executor) {
        return new ExecutorC12576eq6(executor);
    }
}
