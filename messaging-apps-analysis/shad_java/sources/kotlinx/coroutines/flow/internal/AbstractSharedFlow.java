package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* compiled from: AbstractSharedFlow.kt */
/* loaded from: classes4.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    private MutableStateFlow<Integer> _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;

    protected abstract S createSlot();

    protected abstract S[] createSlotArray(int i);

    protected final S allocateSlot() {
        S s;
        MutableStateFlow<Integer> mutableStateFlow;
        synchronized (this) {
            S[] sArr = this.slots;
            if (sArr == null) {
                sArr = (S[]) createSlotArray(2);
                this.slots = sArr;
            } else if (this.nCollectors >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.slots = (S[]) ((AbstractSharedFlowSlot[]) objArrCopyOf);
                sArr = (S[]) ((AbstractSharedFlowSlot[]) objArrCopyOf);
            }
            int i = this.nextIndex;
            do {
                s = sArr[i];
                if (s == null) {
                    s = (S) createSlot();
                    sArr[i] = s;
                }
                i++;
                if (i >= sArr.length) {
                    i = 0;
                }
                if (s == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                }
            } while (!s.allocateLocked(this));
            this.nextIndex = i;
            this.nCollectors++;
            mutableStateFlow = this._subscriptionCount;
        }
        if (mutableStateFlow != null) {
            StateFlowKt.increment(mutableStateFlow, 1);
        }
        return s;
    }

    protected final void freeSlot(S s) {
        MutableStateFlow<Integer> mutableStateFlow;
        int i;
        Continuation<Unit>[] continuationArrFreeLocked;
        synchronized (this) {
            int i2 = this.nCollectors - 1;
            this.nCollectors = i2;
            mutableStateFlow = this._subscriptionCount;
            if (i2 == 0) {
                this.nextIndex = 0;
            }
            if (s != null) {
                continuationArrFreeLocked = s.freeLocked(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            }
        }
        for (Continuation<Unit> continuation : continuationArrFreeLocked) {
            if (continuation != null) {
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m542constructorimpl(unit));
            }
        }
        if (mutableStateFlow != null) {
            StateFlowKt.increment(mutableStateFlow, -1);
        }
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        MutableStateFlow<Integer> MutableStateFlow;
        synchronized (this) {
            MutableStateFlow = this._subscriptionCount;
            if (MutableStateFlow == null) {
                MutableStateFlow = StateFlowKt.MutableStateFlow(Integer.valueOf(this.nCollectors));
                this._subscriptionCount = MutableStateFlow;
            }
        }
        return MutableStateFlow;
    }

    protected final S[] getSlots() {
        return this.slots;
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }
}
