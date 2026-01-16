package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes3.dex */
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    private ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

    public final void saveThreadContext(CoroutineContext coroutineContext, Object obj) {
        this.threadStateToRecover.set(TuplesKt.to(coroutineContext, obj));
    }

    public final boolean clearThreadContext() {
        if (this.threadStateToRecover.get() == null) {
            return false;
        }
        this.threadStateToRecover.set(null);
        return true;
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void afterResume(Object obj) {
        Pair<CoroutineContext, Object> pair = this.threadStateToRecover.get();
        if (pair != null) {
            ThreadContextKt.restoreThreadContext(pair.component1(), pair.component2());
            this.threadStateToRecover.set(null);
        }
        Object objRecoverResult = CompletionStateKt.recoverResult(obj, this.uCont);
        Continuation<T> continuation = this.uCont;
        CoroutineContext context = continuation.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        UndispatchedCoroutine<?> undispatchedCoroutineUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS ? CoroutineContextKt.updateUndispatchedCompletion(continuation, context, objUpdateThreadContext) : null;
        try {
            this.uCont.resumeWith(objRecoverResult);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (undispatchedCoroutineUpdateUndispatchedCompletion == null || undispatchedCoroutineUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }
}
