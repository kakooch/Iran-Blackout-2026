package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
public final class CancellableContinuationKt {
    public static final <T> CancellableContinuationImpl<T> getOrCreateCancellableContinuation(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 2);
        }
        CancellableContinuationImpl<T> cancellableContinuationImplClaimReusableCancellableContinuation = ((DispatchedContinuation) continuation).claimReusableCancellableContinuation();
        if (cancellableContinuationImplClaimReusableCancellableContinuation != null) {
            if (!cancellableContinuationImplClaimReusableCancellableContinuation.resetStateReusable()) {
                cancellableContinuationImplClaimReusableCancellableContinuation = null;
            }
            if (cancellableContinuationImplClaimReusableCancellableContinuation != null) {
                return cancellableContinuationImplClaimReusableCancellableContinuation;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void removeOnCancellation(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.invokeOnCancellation(new RemoveOnCancel(lockFreeLinkedListNode));
    }

    public static final void disposeOnCancellation(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.invokeOnCancellation(new DisposeOnCancel(disposableHandle));
    }
}
