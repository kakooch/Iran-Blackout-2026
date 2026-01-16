package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
final class ThreadState {
    private Object[] a;
    private final CoroutineContext context;
    private int i;

    public ThreadState(CoroutineContext coroutineContext, int i) {
        this.context = coroutineContext;
        this.a = new Object[i];
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    public final void append(Object obj) {
        Object[] objArr = this.a;
        int i = this.i;
        this.i = i + 1;
        objArr[i] = obj;
    }

    public final Object take() {
        Object[] objArr = this.a;
        int i = this.i;
        this.i = i + 1;
        return objArr[i];
    }

    public final void start() {
        this.i = 0;
    }
}
