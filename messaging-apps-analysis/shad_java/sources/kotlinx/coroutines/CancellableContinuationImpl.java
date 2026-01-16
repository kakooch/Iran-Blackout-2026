package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes4.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    private final CoroutineContext context;
    private final Continuation<T> delegate;

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    protected String nameString() {
        return "CancellableContinuation";
    }

    private final void callCancelHandler(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.context = continuation.getContext();
        this._decision = 0;
        this._state = Active.INSTANCE;
        this._parentHandle = null;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.context;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    public void initCancellability() {
        setupCancellation();
    }

    private final boolean isReusable() {
        Continuation<T> continuation = this.delegate;
        return (continuation instanceof DispatchedContinuation) && ((DispatchedContinuation) continuation).isReusable(this);
    }

    public final boolean resetStateReusable() {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.resumeMode == 2)) {
                throw new AssertionError();
            }
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(getParentHandle() != NonDisposableHandle.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(obj instanceof NotCompleted))) {
            throw new AssertionError();
        }
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        this._decision = 0;
        this._state = Active.INSTANCE;
        return true;
    }

    private final void setupCancellation() {
        Job job;
        if (checkCompleted() || getParentHandle() != null || (job = (Job) this.delegate.getContext().get(Job.Key)) == null) {
            return;
        }
        DisposableHandle disposableHandleInvokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ChildContinuation(job, this), 2, null);
        setParentHandle(disposableHandleInvokeOnCompletion$default);
        if (!isCompleted() || isReusable()) {
            return;
        }
        disposableHandleInvokeOnCompletion$default.dispose();
        setParentHandle(NonDisposableHandle.INSTANCE);
    }

    private final boolean checkCompleted() {
        Throwable thCheckPostponedCancellation;
        boolean zIsCompleted = isCompleted();
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            return zIsCompleted;
        }
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        if (dispatchedContinuation == null || (thCheckPostponedCancellation = dispatchedContinuation.checkPostponedCancellation(this)) == null) {
            return zIsCompleted;
        }
        if (!zIsCompleted) {
            cancel(thCheckPostponedCancellation);
        }
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    private final boolean cancelLater(Throwable th) {
        if (!DispatchedTaskKt.isReusableMode(this.resumeMode)) {
            return false;
        }
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        if (dispatchedContinuation != null) {
            return dispatchedContinuation.postponeCancellation(th);
        }
        return false;
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th) {
        if (cancelLater(th)) {
            return;
        }
        cancel(th);
        detachChildIfNonResuable();
    }

    public final void callCancelHandler(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void callOnCancellation(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public Throwable getContinuationCancellationCause(Job job) {
        return job.getCancellationException();
    }

    public final Object getResult() {
        Job job;
        setupCancellation();
        if (trySuspend()) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                throw StackTraceRecoveryKt.recoverFromStackFrame(th, this);
            }
            throw th;
        }
        if (DispatchedTaskKt.isCancellableMode(this.resumeMode) && (job = (Job) getContext().get(Job.Key)) != null && !job.isActive()) {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                throw StackTraceRecoveryKt.recoverFromStackFrame(cancellationException, this);
            }
            throw cancellationException;
        }
        return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object obj) {
        resumeImpl$default(this, CompletionStateKt.toState(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t, Function1<? super Throwable, Unit> function1) {
        resumeImpl(t, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(Function1<? super Throwable, Unit> function1) {
        CancelHandler cancelHandlerMakeCancelHandler = makeCancelHandler(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (_state$FU.compareAndSet(this, obj, cancelHandlerMakeCancelHandler)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                multipleHandlersError(function1, obj);
            } else {
                boolean z = obj instanceof CompletedExceptionally;
                if (z) {
                    if (!((CompletedExceptionally) obj).makeHandled()) {
                        multipleHandlersError(function1, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        if (!z) {
                            obj = null;
                        }
                        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                        callCancelHandler(function1, completedExceptionally != null ? completedExceptionally.cause : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        multipleHandlersError(function1, obj);
                    }
                    if (cancelHandlerMakeCancelHandler instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (completedContinuation.getCancelled()) {
                        callCancelHandler(function1, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (_state$FU.compareAndSet(this, obj, CompletedContinuation.copy$default(completedContinuation, null, cancelHandlerMakeCancelHandler, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (cancelHandlerMakeCancelHandler instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (_state$FU.compareAndSet(this, obj, new CompletedContinuation(obj, cancelHandlerMakeCancelHandler, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    private final void multipleHandlersError(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final CancelHandler makeCancelHandler(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final void dispatchResume(int i) {
        if (tryResume()) {
            return;
        }
        DispatchedTaskKt.dispatch(this, i);
    }

    private final Object resumedState(NotCompleted notCompleted, Object obj, int i, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof CompletedExceptionally) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!DebugKt.getASSERTIONS_ENABLED()) {
                return obj;
            }
            if (function1 == null) {
                return obj;
            }
            throw new AssertionError();
        }
        if (!DispatchedTaskKt.isCancellableMode(i) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(notCompleted instanceof CancelHandler) || (notCompleted instanceof BeforeResumeCancelHandler)) && obj2 == null)) {
            return obj;
        }
        if (!(notCompleted instanceof CancelHandler)) {
            notCompleted = null;
        }
        return new CompletedContinuation(obj, (CancelHandler) notCompleted, function1, obj2, null, 16, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.resumeImpl(obj, i, function1);
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void detachChildIfNonResuable() {
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        setParentHandle(NonDisposableHandle.INSTANCE);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t, Object obj) {
        return tryResumeImpl(t, obj, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object tryResume(T t, Object obj, Function1<? super Throwable, Unit> function1) {
        return tryResumeImpl(t, obj, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(Object obj) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        dispatchResume(this.resumeMode);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        resumeImpl$default(this, t, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof CompletedContinuation ? (T) ((CompletedContinuation) obj).result : obj;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core == null) {
            return null;
        }
        Continuation<T> continuation = this.delegate;
        return (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? StackTraceRecoveryKt.recoverFromStackFrame(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame) continuation) : exceptionalResult$kotlinx_coroutines_core;
    }

    public String toString() {
        return nameString() + '(' + DebugStringsKt.toDebugString(this.delegate) + "){" + getState$kotlinx_coroutines_core() + "}@" + DebugStringsKt.getHexAddress(this);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (obj2 instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                if (!(!completedContinuation.getCancelled())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (_state$FU.compareAndSet(this, obj2, CompletedContinuation.copy$default(completedContinuation, null, null, null, null, th, 15, null))) {
                    completedContinuation.invokeHandlers(this, th);
                    return;
                }
            } else if (_state$FU.compareAndSet(this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    public boolean cancel(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!_state$FU.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        if (!z) {
            obj = null;
        }
        CancelHandler cancelHandler = (CancelHandler) obj;
        if (cancelHandler != null) {
            callCancelHandler(cancelHandler, th);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    private final boolean trySuspend() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    private final boolean tryResume() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final void resumeImpl(Object obj, int i, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.makeResumed()) {
                        if (function1 != null) {
                            callOnCancellation(function1, cancelledContinuation.cause);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(obj);
                throw new KotlinNothingValueException();
            }
        } while (!_state$FU.compareAndSet(this, obj2, resumedState((NotCompleted) obj2, obj, i, function1, null)));
        detachChildIfNonResuable();
        dispatchResume(i);
    }

    private final Symbol tryResumeImpl(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else {
                if (!(obj3 instanceof CompletedContinuation) || obj2 == null) {
                    return null;
                }
                CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                if (completedContinuation.idempotentResume != obj2) {
                    return null;
                }
                if (!DebugKt.getASSERTIONS_ENABLED() || Intrinsics.areEqual(completedContinuation.result, obj)) {
                    return CancellableContinuationImplKt.RESUME_TOKEN;
                }
                throw new AssertionError();
            }
        } while (!_state$FU.compareAndSet(this, obj3, resumedState((NotCompleted) obj3, obj, this.resumeMode, function1, obj2)));
        detachChildIfNonResuable();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }
}
