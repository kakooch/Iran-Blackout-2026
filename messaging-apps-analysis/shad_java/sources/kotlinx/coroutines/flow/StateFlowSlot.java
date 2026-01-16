package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    volatile Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        if (this._state != null) {
            return false;
        }
        this._state = StateFlowKt.NONE;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation<Unit>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final boolean takePending() {
        Object andSet = _state$FU.getAndSet(this, StateFlowKt.NONE);
        Intrinsics.checkNotNull(andSet);
        if (!DebugKt.getASSERTIONS_ENABLED() || (!(andSet instanceof CancellableContinuationImpl))) {
            return andSet == StateFlowKt.PENDING;
        }
        throw new AssertionError();
    }

    public final Object awaitPending(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (DebugKt.getASSERTIONS_ENABLED() && !Boxing.boxBoolean(!(this._state instanceof CancellableContinuationImpl)).booleanValue()) {
            throw new AssertionError();
        }
        if (!_state$FU.compareAndSet(this, StateFlowKt.NONE, cancellableContinuationImpl)) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!Boxing.boxBoolean(this._state == StateFlowKt.PENDING).booleanValue()) {
                    throw new AssertionError();
                }
            }
            Unit unit = Unit.INSTANCE;
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m542constructorimpl(unit));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void makePending() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == StateFlowKt.PENDING) {
                return;
            }
            if (obj == StateFlowKt.NONE) {
                if (_state$FU.compareAndSet(this, obj, StateFlowKt.PENDING)) {
                    return;
                }
            } else if (_state$FU.compareAndSet(this, obj, StateFlowKt.NONE)) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                ((CancellableContinuationImpl) obj).resumeWith(Result.m542constructorimpl(unit));
                return;
            }
        }
    }
}
