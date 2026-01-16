package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExceptions.common.kt */
/* loaded from: classes4.dex */
public final class FlowExceptions_commonKt {
    public static final void checkOwnership(AbortFlowException abortFlowException, FlowCollector<?> flowCollector) {
        if (abortFlowException.getOwner() != flowCollector) {
            throw abortFlowException;
        }
    }
}
