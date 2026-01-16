package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: SharingStarted.kt */
/* loaded from: classes4.dex */
final class StartedLazily implements SharingStarted {
    public String toString() {
        return "SharingStarted.Lazily";
    }

    /* compiled from: SharingStarted.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {210}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super SharingCommand>, Continuation<? super Unit>, Object> {
        final /* synthetic */ StateFlow $subscriptionCount;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        private FlowCollector p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StateFlow stateFlow, Continuation continuation) {
            super(2, continuation);
            this.$subscriptionCount = stateFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$subscriptionCount, continuation);
            anonymousClass1.p$ = (FlowCollector) obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.p$;
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = false;
                StateFlow stateFlow = this.$subscriptionCount;
                StartedLazily$command$1$invokeSuspend$$inlined$collect$1 startedLazily$command$1$invokeSuspend$$inlined$collect$1 = new StartedLazily$command$1$invokeSuspend$$inlined$collect$1(flowCollector, ref$BooleanRef);
                this.L$0 = flowCollector;
                this.L$1 = ref$BooleanRef;
                this.L$2 = stateFlow;
                this.label = 1;
                if (stateFlow.collect(startedLazily$command$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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

    @Override // kotlinx.coroutines.flow.SharingStarted
    public Flow<SharingCommand> command(StateFlow<Integer> stateFlow) {
        return FlowKt.flow(new AnonymousClass1(stateFlow, null));
    }
}
