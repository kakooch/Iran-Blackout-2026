package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.rbmain.tgnet.ConnectionsManager;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
final /* synthetic */ class FlowKt__MergeKt {
    static {
        SystemPropsKt.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, ConnectionsManager.DEFAULT_DATACENTER_ID);
    }

    public static final <T, R> Flow<R> transformLatest(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, flow, null, 0, null, 28, null);
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* compiled from: Merge.kt */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {214, 214}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1, reason: invalid class name */
    static final class AnonymousClass1<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2 $transform;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        private FlowCollector p$;
        private Object p$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function2 function2, Continuation continuation) {
            super(3, continuation);
            this.$transform = function2;
        }

        public final Continuation<Unit> create(FlowCollector<? super R> flowCollector, T t, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, continuation);
            anonymousClass1.p$ = flowCollector;
            anonymousClass1.p$0 = t;
            return anonymousClass1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create((FlowCollector) obj, obj2, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Object obj2;
            FlowCollector flowCollector2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector3 = this.p$;
                Object obj3 = this.p$0;
                Function2 function2 = this.$transform;
                this.L$0 = flowCollector3;
                this.L$1 = obj3;
                this.L$2 = flowCollector3;
                this.label = 1;
                Object objInvoke = function2.invoke(obj3, this);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector3;
                obj2 = obj3;
                obj = objInvoke;
                flowCollector2 = flowCollector3;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                FlowCollector flowCollector4 = (FlowCollector) this.L$2;
                obj2 = this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector2 = flowCollector4;
            }
            this.L$0 = flowCollector;
            this.L$1 = obj2;
            this.label = 2;
            if (flowCollector2.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T, R> Flow<R> mapLatest(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt.transformLatest(flow, new AnonymousClass1(function2, null));
    }
}
