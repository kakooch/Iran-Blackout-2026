package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    protected abstract boolean isBufferAlwaysEmpty();

    protected abstract boolean isBufferEmpty();

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ <R> Object receiveSuspend(int i, Continuation<? super R> continuation) {
        ReceiveElement receiveElementWithUndeliveredHandler;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (this.onUndeliveredElement == null) {
            if (orCreateCancellableContinuation == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            }
            receiveElementWithUndeliveredHandler = new ReceiveElement(orCreateCancellableContinuation, i);
        } else if (orCreateCancellableContinuation != null) {
            receiveElementWithUndeliveredHandler = new ReceiveElementWithUndeliveredHandler(orCreateCancellableContinuation, i, this.onUndeliveredElement);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
        }
        while (true) {
            if (enqueueReceive(receiveElementWithUndeliveredHandler)) {
                removeReceiveOnCancel(orCreateCancellableContinuation, receiveElementWithUndeliveredHandler);
                break;
            }
            Object objPollInternal = pollInternal();
            if (objPollInternal instanceof Closed) {
                receiveElementWithUndeliveredHandler.resumeReceiveClosed((Closed) objPollInternal);
                break;
            }
            if (objPollInternal != AbstractChannelKt.POLL_FAILED) {
                orCreateCancellableContinuation.resume(receiveElementWithUndeliveredHandler.resumeValue(objPollInternal), receiveElementWithUndeliveredHandler.resumeOnCancellationFun(objPollInternal));
                break;
            }
        }
        Object result = orCreateCancellableContinuation.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    protected Object pollInternal() {
        while (true) {
            Send sendTakeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (sendTakeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            Symbol symbolTryResumeSend = sendTakeFirstSendOrPeekClosed.tryResumeSend(null);
            if (symbolTryResumeSend != null) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(symbolTryResumeSend == CancellableContinuationImplKt.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                sendTakeFirstSendOrPeekClosed.completeResumeSend();
                return sendTakeFirstSendOrPeekClosed.getPollResult();
            }
            sendTakeFirstSendOrPeekClosed.undeliveredElement();
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return getClosedForReceive() != null && isBufferEmpty();
    }

    protected boolean enqueueReceiveInternal(final Receive<? super E> receive) {
        int iTryCondAddNext;
        LockFreeLinkedListNode prevNode;
        if (isBufferAlwaysEmpty()) {
            LockFreeLinkedListNode queue = getQueue();
            do {
                prevNode = queue.getPrevNode();
                if (!(!(prevNode instanceof Send))) {
                    return false;
                }
            } while (!prevNode.addNext(receive, queue));
        } else {
            LockFreeLinkedListNode queue2 = getQueue();
            LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(receive, receive, this) { // from class: kotlinx.coroutines.channels.AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1
                final /* synthetic */ AbstractChannel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(receive);
                    this.this$0 = this;
                }

                @Override // kotlinx.coroutines.internal.AtomicOp
                public Object prepare(LockFreeLinkedListNode lockFreeLinkedListNode) {
                    if (this.this$0.isBufferEmpty()) {
                        return null;
                    }
                    return LockFreeLinkedListKt.getCONDITION_FALSE();
                }
            };
            do {
                LockFreeLinkedListNode prevNode2 = queue2.getPrevNode();
                if (!(!(prevNode2 instanceof Send))) {
                    return false;
                }
                iTryCondAddNext = prevNode2.tryCondAddNext(receive, queue2, condAddOp);
                if (iTryCondAddNext != 1) {
                }
            } while (iTryCondAddNext != 2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean enqueueReceive(Receive<? super E> receive) {
        boolean zEnqueueReceiveInternal = enqueueReceiveInternal(receive);
        if (zEnqueueReceiveInternal) {
            onReceiveEnqueued();
        }
        return zEnqueueReceiveInternal;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveOrClosed-ZYPwvRU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object mo546receiveOrClosedZYPwvRU(kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ValueOrClosed<? extends E>> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.AbstractChannel r0 = (kotlinx.coroutines.channels.AbstractChannel) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L69
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.pollInternal()
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED
            if (r5 == r2) goto L5b
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L54
            kotlinx.coroutines.channels.ValueOrClosed$Companion r0 = kotlinx.coroutines.channels.ValueOrClosed.Companion
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            java.lang.Throwable r5 = r5.closeCause
            kotlinx.coroutines.channels.ValueOrClosed$Closed r0 = new kotlinx.coroutines.channels.ValueOrClosed$Closed
            r0.<init>(r5)
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m549constructorimpl(r0)
            goto L5a
        L54:
            kotlinx.coroutines.channels.ValueOrClosed$Companion r0 = kotlinx.coroutines.channels.ValueOrClosed.Companion
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m549constructorimpl(r5)
        L5a:
            return r5
        L5b:
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r4.receiveSuspend(r2, r0)
            if (r5 != r1) goto L69
            return r1
        L69:
            kotlinx.coroutines.channels.ValueOrClosed r5 = (kotlinx.coroutines.channels.ValueOrClosed) r5
            java.lang.Object r5 = r5.m556unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.mo546receiveOrClosedZYPwvRU(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (isClosedForReceive()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled");
        }
        cancelInternal$kotlinx_coroutines_core(cancellationException);
    }

    public final boolean cancelInternal$kotlinx_coroutines_core(Throwable th) {
        boolean zClose = close(th);
        onCancelIdempotent(zClose);
        return zClose;
    }

    protected void onCancelIdempotent(boolean z) {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objM560constructorimpl$default = InlineList.m560constructorimpl$default(null, 1, null);
        while (true) {
            LockFreeLinkedListNode prevNode = closedForSend.getPrevNode();
            if (prevNode instanceof LockFreeLinkedListHead) {
                if (objM560constructorimpl$default == null) {
                    return;
                }
                if (objM560constructorimpl$default instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) objM560constructorimpl$default;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((Send) arrayList.get(size)).resumeSendClosed(closedForSend);
                    }
                    return;
                }
                ((Send) objM560constructorimpl$default).resumeSendClosed(closedForSend);
                return;
            }
            if (DebugKt.getASSERTIONS_ENABLED() && !(prevNode instanceof Send)) {
                throw new AssertionError();
            }
            if (!prevNode.remove()) {
                prevNode.helpRemove();
            } else {
                objM560constructorimpl$default = InlineList.m561plusUZ7vuAc(objM560constructorimpl$default, (Send) prevNode);
            }
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> receiveOrClosedTakeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (receiveOrClosedTakeFirstReceiveOrPeekClosed != null && !(receiveOrClosedTakeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return receiveOrClosedTakeFirstReceiveOrPeekClosed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.invokeOnCancellation(new RemoveReceiveOnCancel(receive));
    }

    /* compiled from: AbstractChannel.kt */
    private final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        private final Receive<?> receive;

        public RemoveReceiveOnCancel(Receive<?> receive) {
            this.receive = receive;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            if (this.receive.remove()) {
                AbstractChannel.this.onReceiveDequeued();
            }
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    private static class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<Object> cont;
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.cont = cancellableContinuation;
            this.receiveMode = i;
        }

        public final Object resumeValue(E e) {
            if (this.receiveMode != 2) {
                return e;
            }
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            return ValueOrClosed.m548boximpl(ValueOrClosed.m549constructorimpl(e));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Symbol tryResumeReceive(E e, LockFreeLinkedListNode.PrepareOp prepareOp) {
            Object objTryResume = this.cont.tryResume(resumeValue(e), null, resumeOnCancellationFun(e));
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

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            int i = this.receiveMode;
            if (i == 1 && closed.closeCause == null) {
                CancellableContinuation<Object> cancellableContinuation = this.cont;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m542constructorimpl(null));
            } else {
                if (i == 2) {
                    CancellableContinuation<Object> cancellableContinuation2 = this.cont;
                    ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
                    ValueOrClosed valueOrClosedM548boximpl = ValueOrClosed.m548boximpl(ValueOrClosed.m549constructorimpl(new ValueOrClosed.Closed(closed.closeCause)));
                    Result.Companion companion3 = Result.Companion;
                    cancellableContinuation2.resumeWith(Result.m542constructorimpl(valueOrClosedM548boximpl));
                    return;
                }
                CancellableContinuation<Object> cancellableContinuation3 = this.cont;
                Throwable receiveException = closed.getReceiveException();
                Result.Companion companion4 = Result.Companion;
                cancellableContinuation3.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(receiveException)));
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.getHexAddress(this) + "[receiveMode=" + this.receiveMode + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    private static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        public final Function1<E, Unit> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveElementWithUndeliveredHandler(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.onUndeliveredElement = function1;
        }

        @Override // kotlinx.coroutines.channels.Receive
        public Function1<Throwable, Unit> resumeOnCancellationFun(E e) {
            return OnUndeliveredElementKt.bindCancellationFun(this.onUndeliveredElement, e, this.cont.getContext());
        }
    }
}
