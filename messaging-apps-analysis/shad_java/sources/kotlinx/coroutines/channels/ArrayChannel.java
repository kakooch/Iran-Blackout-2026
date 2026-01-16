package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: ArrayChannel.kt */
/* loaded from: classes4.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {
    private Object[] buffer;
    private final int capacity;
    private int head;
    private final ReentrantLock lock;
    private final BufferOverflow onBufferOverflow;
    private volatile int size;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    public ArrayChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.lock = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        ArraysKt___ArraysJvmKt.fill$default(objArr, AbstractChannelKt.EMPTY, 0, 0, 6, null);
        Unit unit = Unit.INSTANCE;
        this.buffer = objArr;
        this.size = 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E e) {
        ReceiveOrClosed<E> receiveOrClosedTakeFirstReceiveOrPeekClosed;
        Symbol symbolTryResumeReceive;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            Symbol symbolUpdateBufferSize = updateBufferSize(i);
            if (symbolUpdateBufferSize != null) {
                return symbolUpdateBufferSize;
            }
            if (i == 0) {
                do {
                    receiveOrClosedTakeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                    if (receiveOrClosedTakeFirstReceiveOrPeekClosed != null) {
                        if (receiveOrClosedTakeFirstReceiveOrPeekClosed instanceof Closed) {
                            this.size = i;
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
                this.size = i;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                Intrinsics.checkNotNull(receiveOrClosedTakeFirstReceiveOrPeekClosed);
                receiveOrClosedTakeFirstReceiveOrPeekClosed.completeResumeReceive(e);
                Intrinsics.checkNotNull(receiveOrClosedTakeFirstReceiveOrPeekClosed);
                return receiveOrClosedTakeFirstReceiveOrPeekClosed.getOfferResult();
            }
            enqueueElement(i, e);
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object enqueueSend(Send send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.enqueueSend(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    private final Symbol updateBufferSize(int i) {
        if (i < this.capacity) {
            this.size = i + 1;
            return null;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i2 == 1) {
            return AbstractChannelKt.OFFER_FAILED;
        }
        if (i2 == 2) {
            return AbstractChannelKt.OFFER_SUCCESS;
        }
        if (i2 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void enqueueElement(int i, E e) {
        if (i < this.capacity) {
            ensureCapacity(i);
            Object[] objArr = this.buffer;
            objArr[(this.head + i) % objArr.length] = e;
            return;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(this.onBufferOverflow == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.buffer;
        int i2 = this.head;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.head = (i2 + 1) % objArr2.length;
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.buffer;
        if (i >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[iMin];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.buffer;
                objArr2[i2] = objArr3[(this.head + i2) % objArr3.length];
            }
            ArraysKt___ArraysJvmKt.fill(objArr2, AbstractChannelKt.EMPTY, i, iMin);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object pollInternal() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object closedForSend = getClosedForSend();
                if (closedForSend == null) {
                    closedForSend = AbstractChannelKt.POLL_FAILED;
                }
                return closedForSend;
            }
            Object[] objArr = this.buffer;
            int i2 = this.head;
            Object obj = objArr[i2];
            Send send = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object pollResult = AbstractChannelKt.POLL_FAILED;
            if (i == this.capacity) {
                Send send2 = null;
                while (true) {
                    Send sendTakeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
                    if (sendTakeFirstSendOrPeekClosed == null) {
                        send = send2;
                        break;
                    }
                    Intrinsics.checkNotNull(sendTakeFirstSendOrPeekClosed);
                    Symbol symbolTryResumeSend = sendTakeFirstSendOrPeekClosed.tryResumeSend(null);
                    if (symbolTryResumeSend != null) {
                        if (DebugKt.getASSERTIONS_ENABLED()) {
                            if (!(symbolTryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN)) {
                                throw new AssertionError();
                            }
                        }
                        Intrinsics.checkNotNull(sendTakeFirstSendOrPeekClosed);
                        pollResult = sendTakeFirstSendOrPeekClosed.getPollResult();
                        send = sendTakeFirstSendOrPeekClosed;
                        z = true;
                    } else {
                        Intrinsics.checkNotNull(sendTakeFirstSendOrPeekClosed);
                        sendTakeFirstSendOrPeekClosed.undeliveredElement();
                        send2 = sendTakeFirstSendOrPeekClosed;
                    }
                }
            }
            if (pollResult != AbstractChannelKt.POLL_FAILED && !(pollResult instanceof Closed)) {
                this.size = i;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i) % objArr2.length] = pollResult;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            if (z) {
                Intrinsics.checkNotNull(send);
                send.completeResumeSend();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
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

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void onCancelIdempotent(boolean z) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.buffer[this.head];
                if (function1 != null && obj != AbstractChannelKt.EMPTY) {
                    undeliveredElementExceptionCallUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, obj, undeliveredElementExceptionCallUndeliveredElementCatchingException);
                }
                Object[] objArr = this.buffer;
                int i3 = this.head;
                objArr[i3] = AbstractChannelKt.EMPTY;
                this.head = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.onCancelIdempotent(z);
            if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
                throw undeliveredElementExceptionCallUndeliveredElementCatchingException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }
}
