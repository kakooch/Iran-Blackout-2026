package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.EventLoopImplBase;

/* compiled from: EventLoop.kt */
/* loaded from: classes4.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    protected abstract Thread getThread();

    protected final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            TimeSource timeSource = TimeSourceKt.getTimeSource();
            if (timeSource != null) {
                timeSource.unpark(thread);
            } else {
                LockSupport.unpark(thread);
            }
        }
    }

    protected final void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this != DefaultExecutor.INSTANCE)) {
                throw new AssertionError();
            }
        }
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }
}
