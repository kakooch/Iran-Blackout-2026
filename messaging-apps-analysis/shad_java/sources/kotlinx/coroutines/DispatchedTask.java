package kotlinx.coroutines;

import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes4.dex */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        Intrinsics.checkNotNull(th);
        CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objM542constructorimpl;
        Object objM542constructorimpl2;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.taskContext;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            if (delegate$kotlinx_coroutines_core == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
            Continuation<T> continuation = dispatchedContinuation.continuation;
            CoroutineContext context = continuation.getContext();
            Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                Job job = (exceptionalResult$kotlinx_coroutines_core == null && DispatchedTaskKt.isCancellableMode(this.resumeMode)) ? (Job) context.get(Job.Key) : null;
                if (job != null && !job.isActive()) {
                    Throwable cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    Result.Companion companion = Result.Companion;
                    if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
                        cancellationException = StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, (CoroutineStackFrame) continuation);
                    }
                    continuation.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.Companion companion2 = Result.Companion;
                    continuation.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    T successfulResult$kotlinx_coroutines_core = getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                    Result.Companion companion3 = Result.Companion;
                    continuation.resumeWith(Result.m542constructorimpl(successfulResult$kotlinx_coroutines_core));
                }
                Unit unit = Unit.INSTANCE;
                try {
                    Result.Companion companion4 = Result.Companion;
                    taskContext.afterTask();
                    objM542constructorimpl2 = Result.m542constructorimpl(unit);
                } catch (Throwable th) {
                    Result.Companion companion5 = Result.Companion;
                    objM542constructorimpl2 = Result.m542constructorimpl(ResultKt.createFailure(th));
                }
                handleFatalException$kotlinx_coroutines_core(null, Result.m543exceptionOrNullimpl(objM542constructorimpl2));
            } finally {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        } catch (Throwable th2) {
            try {
                Result.Companion companion6 = Result.Companion;
                taskContext.afterTask();
                objM542constructorimpl = Result.m542constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion7 = Result.Companion;
                objM542constructorimpl = Result.m542constructorimpl(ResultKt.createFailure(th3));
            }
            handleFatalException$kotlinx_coroutines_core(th2, Result.m543exceptionOrNullimpl(objM542constructorimpl));
        }
    }
}
