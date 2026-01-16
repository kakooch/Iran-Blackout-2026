package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.JobKt;

/* compiled from: Context.kt */
/* loaded from: classes4.dex */
final class CancellableFlowImpl<T> implements CancellableFlow<T> {
    private final Flow<T> flow;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableFlowImpl(Flow<? extends T> flow) {
        this.flow = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(final FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object objCollect = this.flow.collect(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.CancellableFlowImpl$collect$$inlined$collect$1
            @Override // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object obj, Continuation continuation2) {
                JobKt.ensureActive(continuation2.getContext());
                Object objEmit = flowCollector.emit(obj, continuation2);
                return objEmit == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }
}
