package kotlinx.coroutines.flow.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    protected final Flow<S> flow;

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return collect$suspendImpl((ChannelFlowOperator) this, (FlowCollector) flowCollector, (Continuation) continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object collectTo(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return collectTo$suspendImpl(this, producerScope, continuation);
    }

    protected abstract Object flowCollect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation);

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(Flow<? extends S> flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.flow = flow;
    }

    final /* synthetic */ Object collectWithContextUndispatched(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        Object objWithContextUndispatched$default = ChannelFlowKt.withContextUndispatched$default(coroutineContext, ChannelFlowKt.withUndispatchedContextCollector(flowCollector, continuation.getContext()), null, new AnonymousClass2(null), continuation, 4, null);
        return objWithContextUndispatched$default == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContextUndispatched$default : Unit.INSTANCE;
    }

    /* compiled from: ChannelFlow.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {164}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        private FlowCollector p$0;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.p$0 = (FlowCollector) obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector<? super T> flowCollector = this.p$0;
                ChannelFlowOperator channelFlowOperator = ChannelFlowOperator.this;
                this.L$0 = flowCollector;
                this.label = 1;
                if (channelFlowOperator.flowCollect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    static /* synthetic */ Object collectTo$suspendImpl(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object objFlowCollect = channelFlowOperator.flowCollect(new SendingCollector(producerScope), continuation);
        return objFlowCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlowCollect : Unit.INSTANCE;
    }

    static /* synthetic */ Object collect$suspendImpl(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        if (channelFlowOperator.capacity == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext coroutineContextPlus = context.plus(channelFlowOperator.context);
            if (Intrinsics.areEqual(coroutineContextPlus, context)) {
                Object objFlowCollect = channelFlowOperator.flowCollect(flowCollector, continuation);
                return objFlowCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlowCollect : Unit.INSTANCE;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
            if (Intrinsics.areEqual((ContinuationInterceptor) coroutineContextPlus.get(key), (ContinuationInterceptor) context.get(key))) {
                Object objCollectWithContextUndispatched = channelFlowOperator.collectWithContextUndispatched(flowCollector, coroutineContextPlus, continuation);
                return objCollectWithContextUndispatched == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectWithContextUndispatched : Unit.INSTANCE;
            }
        }
        Object objCollect = super.collect(flowCollector, continuation);
        return objCollect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.flow + " -> " + super.toString();
    }
}
