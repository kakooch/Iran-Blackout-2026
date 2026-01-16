package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public final class SendElementWithUndeliveredHandler<E> extends SendElement<E> {
    public final Function1<E, Unit> onUndeliveredElement;

    /* JADX WARN: Multi-variable type inference failed */
    public SendElementWithUndeliveredHandler(E e, CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super E, Unit> function1) {
        super(e, cancellableContinuation);
        this.onUndeliveredElement = function1;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean remove() {
        if (!super.remove()) {
            return false;
        }
        undeliveredElement();
        return true;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void undeliveredElement() {
        OnUndeliveredElementKt.callUndeliveredElement(this.onUndeliveredElement, getPollResult(), this.cont.getContext());
    }
}
