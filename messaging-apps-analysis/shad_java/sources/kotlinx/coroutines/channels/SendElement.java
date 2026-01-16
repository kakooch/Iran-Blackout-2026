package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public class SendElement<E> extends Send {
    public final CancellableContinuation<Unit> cont;
    private final E pollResult;

    @Override // kotlinx.coroutines.channels.Send
    public E getPollResult() {
        return this.pollResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendElement(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.pollResult = e;
        this.cont = cancellableContinuation;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
        Object objTryResume = this.cont.tryResume(Unit.INSTANCE, null);
        if (objTryResume == null) {
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(objTryResume == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        return CancellableContinuationImplKt.RESUME_TOKEN;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend() {
        this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
    }

    @Override // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed<?> closed) {
        CancellableContinuation<Unit> cancellableContinuation = this.cont;
        Throwable sendException = closed.getSendException();
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(sendException)));
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '(' + getPollResult() + ')';
    }
}
