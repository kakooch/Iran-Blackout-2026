package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public final class StateFlowKt {
    private static final Symbol NONE = new Symbol("NONE");
    private static final Symbol PENDING = new Symbol("PENDING");

    public static final <T> MutableStateFlow<T> MutableStateFlow(T t) {
        if (t == null) {
            t = (T) NullSurrogateKt.NULL;
        }
        return new StateFlowImpl(t);
    }

    public static final void increment(MutableStateFlow<Integer> mutableStateFlow, int i) {
        int iIntValue;
        do {
            iIntValue = mutableStateFlow.getValue().intValue();
        } while (!mutableStateFlow.compareAndSet(Integer.valueOf(iIntValue), Integer.valueOf(iIntValue + i)));
    }

    public static final <T> Flow<T> fuseStateFlow(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        return (((i < 0 || 1 < i) && i != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? SharedFlowKt.fuseSharedFlow(stateFlow, coroutineContext, i, bufferOverflow) : stateFlow;
    }
}
