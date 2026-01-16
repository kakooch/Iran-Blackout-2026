package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: ConflatedChannel.kt */
/* loaded from: classes4.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {
    private final ReentrantLock lock;
    private Object value;

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.lock = new ReentrantLock();
        this.value = AbstractChannelKt.EMPTY;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return this.value == AbstractChannelKt.EMPTY;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E e) {
        ReceiveOrClosed<E> receiveOrClosedTakeFirstReceiveOrPeekClosed;
        Symbol symbolTryResumeReceive;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            if (this.value == AbstractChannelKt.EMPTY) {
                do {
                    receiveOrClosedTakeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (receiveOrClosedTakeFirstReceiveOrPeekClosed != null) {
                        if (receiveOrClosedTakeFirstReceiveOrPeekClosed instanceof Closed) {
                            Intrinsics.checkNotNull(receiveOrClosedTakeFirstReceiveOrPeekClosed);
                            return receiveOrClosedTakeFirstReceiveOrPeekClosed;
                        }
                        Intrinsics.checkNotNull(receiveOrClosedTakeFirstReceiveOrPeekClosed);
                        symbolTryResumeReceive = receiveOrClosedTakeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
                    }
                } while (symbolTryResumeReceive == null);
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(symbolTryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                Intrinsics.checkNotNull(receiveOrClosedTakeFirstReceiveOrPeekClosed);
                receiveOrClosedTakeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                Intrinsics.checkNotNull(receiveOrClosedTakeFirstReceiveOrPeekClosed);
                return receiveOrClosedTakeFirstReceiveOrPeekClosed.getOfferResult();
            }
            UndeliveredElementException undeliveredElementExceptionUpdateValueLocked = updateValueLocked(e);
            if (undeliveredElementExceptionUpdateValueLocked != null) {
                throw undeliveredElementExceptionUpdateValueLocked;
            }
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            Symbol symbol = AbstractChannelKt.EMPTY;
            if (obj != symbol) {
                this.value = symbol;
                Unit unit = Unit.INSTANCE;
                return obj;
            }
            Object closedForSend = getClosedForSend();
            if (closedForSend == null) {
                closedForSend = AbstractChannelKt.POLL_FAILED;
            }
            return closedForSend;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean z) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionUpdateValueLocked = updateValueLocked(AbstractChannelKt.EMPTY);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(z);
            if (undeliveredElementExceptionUpdateValueLocked != null) {
                throw undeliveredElementExceptionUpdateValueLocked;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final UndeliveredElementException updateValueLocked(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.value;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default = null;
        if (obj2 != AbstractChannelKt.EMPTY && (function1 = this.onUndeliveredElement) != null) {
            undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, obj2, null, 2, null);
        }
        this.value = obj;
        return undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean enqueueReceiveInternal(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueReceiveInternal(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(value=" + this.value + ')';
    }
}
