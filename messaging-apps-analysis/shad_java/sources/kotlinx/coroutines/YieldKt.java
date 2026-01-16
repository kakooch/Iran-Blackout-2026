package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Yield.kt */
/* loaded from: classes4.dex */
public final class YieldKt {
    public static final void checkCompletion(CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }
}
