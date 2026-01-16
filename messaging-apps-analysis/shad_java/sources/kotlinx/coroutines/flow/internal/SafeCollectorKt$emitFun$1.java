package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
final /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements Function3<FlowCollector<? super Object>, Object, Continuation<? super Unit>, Object> {
    SafeCollectorKt$emitFun$1() {
        super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Object> flowCollector, Object obj, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<Object>) flowCollector, obj, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<Object> flowCollector, Object obj, Continuation<? super Unit> continuation) {
        InlineMarker.mark(0);
        Object objEmit = flowCollector.emit(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return objEmit;
    }
}
