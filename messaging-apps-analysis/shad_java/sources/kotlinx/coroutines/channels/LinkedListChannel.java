package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: LinkedListChannel.kt */
/* loaded from: classes4.dex */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean isBufferEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected final boolean isBufferFull() {
        return false;
    }

    public LinkedListChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected Object offerInternal(E e) {
        ReceiveOrClosed<?> receiveOrClosedSendBuffered;
        do {
            Object objOfferInternal = super.offerInternal(e);
            Symbol symbol = AbstractChannelKt.OFFER_SUCCESS;
            if (objOfferInternal == symbol) {
                return symbol;
            }
            if (objOfferInternal == AbstractChannelKt.OFFER_FAILED) {
                receiveOrClosedSendBuffered = sendBuffered(e);
                if (receiveOrClosedSendBuffered == null) {
                    return symbol;
                }
            } else {
                if (objOfferInternal instanceof Closed) {
                    return objOfferInternal;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + objOfferInternal).toString());
            }
        } while (!(receiveOrClosedSendBuffered instanceof Closed));
        return receiveOrClosedSendBuffered;
    }
}
