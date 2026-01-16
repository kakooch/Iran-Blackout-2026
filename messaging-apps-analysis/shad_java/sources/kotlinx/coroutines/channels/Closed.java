package kotlinx.coroutines.channels;

import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    public final Throwable closeCause;

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(E e) {
    }

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Closed<E> getOfferResult() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Closed<E> getPollResult() {
        return this;
    }

    public Closed(Throwable th) {
        this.closeCause = th;
    }

    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedSendChannelException("Channel was closed");
    }

    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedReceiveChannelException("Channel was closed");
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Symbol tryResumeReceive(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed<?> closed) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed@" + DebugStringsKt.getHexAddress(this) + '[' + this.closeCause + ']';
    }
}
