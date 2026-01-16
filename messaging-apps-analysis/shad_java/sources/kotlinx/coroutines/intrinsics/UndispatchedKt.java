package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: Undispatched.kt */
/* loaded from: classes4.dex */
public final class UndispatchedKt {
    public static final <R, T> void startCoroutineUndispatched(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Continuation continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        try {
            CoroutineContext context = continuation.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                if (function2 != null) {
                    Object objInvoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuationProbeCoroutineCreated);
                    if (objInvoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        Result.Companion companion = Result.Companion;
                        continuationProbeCoroutineCreated.resumeWith(Result.m542constructorimpl(objInvoke));
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } finally {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            continuationProbeCoroutineCreated.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(ScopeCoroutine<? super T> scopeCoroutine, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        scopeCoroutine.initParentJob$kotlinx_coroutines_core();
        try {
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false, 2, null);
        }
        if (function2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        completedExceptionally = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, scopeCoroutine);
        if (completedExceptionally != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() && (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
                Continuation<? super T> continuation = scopeCoroutine.uCont;
                if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                    throw StackTraceRecoveryKt.recoverFromStackFrame(th2, (CoroutineStackFrame) continuation);
                }
                throw th2;
            }
            return JobSupportKt.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}
