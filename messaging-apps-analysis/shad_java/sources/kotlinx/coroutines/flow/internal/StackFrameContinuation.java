package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
final class StackFrameContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    private final CoroutineContext context;
    private final Continuation<T> uCont;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackFrameContinuation(Continuation<? super T> continuation, CoroutineContext coroutineContext) {
        this.uCont = continuation;
        this.context = coroutineContext;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.uCont;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        this.uCont.resumeWith(obj);
    }
}
