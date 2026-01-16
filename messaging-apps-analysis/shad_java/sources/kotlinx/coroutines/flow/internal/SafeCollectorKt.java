package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SafeCollector.kt */
/* loaded from: classes4.dex */
public final class SafeCollectorKt {
    private static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> emitFun = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(new SafeCollectorKt$emitFun$1(), 3);
}
