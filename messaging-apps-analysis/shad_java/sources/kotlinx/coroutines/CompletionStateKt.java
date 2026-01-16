package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

/* compiled from: CompletionState.kt */
/* loaded from: classes4.dex */
public final class CompletionStateKt {
    public static /* synthetic */ Object toState$default(Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return toState(obj, (Function1<? super Throwable, Unit>) function1);
    }

    public static final <T> Object toState(Object obj, Function1<? super Throwable, Unit> function1) {
        Throwable thM543exceptionOrNullimpl = Result.m543exceptionOrNullimpl(obj);
        if (thM543exceptionOrNullimpl == null) {
            return function1 != null ? new CompletedWithCancellation(obj, function1) : obj;
        }
        return new CompletedExceptionally(thM543exceptionOrNullimpl, false, 2, null);
    }

    public static final <T> Object toState(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable thM543exceptionOrNullimpl = Result.m543exceptionOrNullimpl(obj);
        if (thM543exceptionOrNullimpl != null) {
            if (DebugKt.getRECOVER_STACK_TRACES() && (cancellableContinuation instanceof CoroutineStackFrame)) {
                thM543exceptionOrNullimpl = StackTraceRecoveryKt.recoverFromStackFrame(thM543exceptionOrNullimpl, (CoroutineStackFrame) cancellableContinuation);
            }
            obj = new CompletedExceptionally(thM543exceptionOrNullimpl, false, 2, null);
        }
        return obj;
    }

    public static final <T> Object recoverResult(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.Companion;
            Throwable thRecoverFromStackFrame = ((CompletedExceptionally) obj).cause;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                thRecoverFromStackFrame = StackTraceRecoveryKt.recoverFromStackFrame(thRecoverFromStackFrame, (CoroutineStackFrame) continuation);
            }
            return Result.m542constructorimpl(ResultKt.createFailure(thRecoverFromStackFrame));
        }
        Result.Companion companion2 = Result.Companion;
        return Result.m542constructorimpl(obj);
    }
}
