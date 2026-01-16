package kotlinx.coroutines;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public final class EventLoop_commonKt {
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
