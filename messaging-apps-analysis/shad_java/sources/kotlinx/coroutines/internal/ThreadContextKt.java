package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class ThreadContextKt {
    private static final Symbol ZERO = new Symbol("ZERO");
    private static final Function2<Object, CoroutineContext.Element, Object> countAll = new Function2<Object, CoroutineContext.Element, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, CoroutineContext.Element element) {
            if (!(element instanceof ThreadContextElement)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? element : Integer.valueOf(iIntValue + 1);
        }
    };
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = new Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.functions.Function2
        public final ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (!(element instanceof ThreadContextElement)) {
                element = null;
            }
            return (ThreadContextElement) element;
        }
    };
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = new Function2<ThreadState, CoroutineContext.Element, ThreadState>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.functions.Function2
        public final ThreadState invoke(ThreadState threadState, CoroutineContext.Element element) {
            if (element instanceof ThreadContextElement) {
                threadState.append(((ThreadContextElement) element).updateThreadContext(threadState.getContext()));
            }
            return threadState;
        }
    };
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> restoreState = new Function2<ThreadState, CoroutineContext.Element, ThreadState>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$restoreState$1
        @Override // kotlin.jvm.functions.Function2
        public final ThreadState invoke(ThreadState threadState, CoroutineContext.Element element) {
            if (element instanceof ThreadContextElement) {
                ((ThreadContextElement) element).restoreThreadContext(threadState.getContext(), threadState.take());
            }
            return threadState;
        }
    };

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, countAll);
        Intrinsics.checkNotNull(objFold);
        return objFold;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return ZERO;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == ZERO) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).start();
            coroutineContext.fold(obj, restoreState);
        } else {
            Object objFold = coroutineContext.fold(null, findOne);
            if (objFold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((ThreadContextElement) objFold).restoreThreadContext(coroutineContext, obj);
        }
    }
}
