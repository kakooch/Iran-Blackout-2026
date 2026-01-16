package kotlinx.coroutines.channels;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes4.dex */
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    protected final Function1<E, Unit> onUndeliveredElement;
    private final LockFreeLinkedListHead queue = new LockFreeLinkedListHead();
    private volatile Object onCloseHandler = null;

    protected String getBufferDebugString() {
        return BuildConfig.FLAVOR;
    }

    protected abstract boolean isBufferAlwaysFull();

    protected abstract boolean isBufferFull();

    protected void onClosedIdempotent(LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractSendChannel(Function1<? super E, Unit> function1) {
        this.onUndeliveredElement = function1;
    }

    protected final LockFreeLinkedListHead getQueue() {
        return this.queue;
    }

    protected Object offerInternal(E e) {
        ReceiveOrClosed<E> receiveOrClosedTakeFirstReceiveOrPeekClosed;
        Symbol symbolTryResumeReceive;
        do {
            receiveOrClosedTakeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
            if (receiveOrClosedTakeFirstReceiveOrPeekClosed == null) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            symbolTryResumeReceive = receiveOrClosedTakeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
        } while (symbolTryResumeReceive == null);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(symbolTryResumeReceive == CancellableContinuationImplKt.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        receiveOrClosedTakeFirstReceiveOrPeekClosed.completeResumeReceive(e);
        return receiveOrClosedTakeFirstReceiveOrPeekClosed.getOfferResult();
    }

    protected final Closed<?> getClosedForSend() {
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (!(prevNode instanceof Closed)) {
            prevNode = null;
        }
        Closed<?> closed = (Closed) prevNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    protected final Closed<?> getClosedForReceive() {
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (!(nextNode instanceof Closed)) {
            nextNode = null;
        }
        Closed<?> closed = (Closed) nextNode;
        if (closed == null) {
            return null;
        }
        helpClose(closed);
        return closed;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final kotlinx.coroutines.channels.Send takeFirstSendOrPeekClosed() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r4.queue
        L2:
            java.lang.Object r1 = r0.getNext()
            if (r1 == 0) goto L2f
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L28
        Lf:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.Send
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            kotlinx.coroutines.channels.Send r2 = (kotlinx.coroutines.channels.Send) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L22
            boolean r2 = r1.isRemoved()
            if (r2 != 0) goto L22
            goto L28
        L22:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r1.removeOrNext()
            if (r2 != 0) goto L2b
        L28:
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1
            return r1
        L2b:
            r2.helpRemovePrev()
            goto L2
        L2f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L38
        L37:
            throw r0
        L38:
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.takeFirstSendOrPeekClosed():kotlinx.coroutines.channels.Send");
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final ReceiveOrClosed<?> sendBuffered(E e) {
        LockFreeLinkedListNode prevNode;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.queue;
        SendBuffered sendBuffered = new SendBuffered(e);
        do {
            prevNode = lockFreeLinkedListHead.getPrevNode();
            if (prevNode instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) prevNode;
            }
        } while (!prevNode.addNext(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return getClosedForSend() != null;
    }

    protected final boolean isFullImpl() {
        return !(this.queue.getNextNode() instanceof ReceiveOrClosed) && isBufferFull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(E e, Continuation<? super Unit> continuation) {
        Object objSendSuspend;
        return (offerInternal(e) != AbstractChannelKt.OFFER_SUCCESS && (objSendSuspend = sendSuspend(e, continuation)) == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objSendSuspend : Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(E e) throws Throwable {
        Object objOfferInternal = offerInternal(e);
        if (objOfferInternal == AbstractChannelKt.OFFER_SUCCESS) {
            return true;
        }
        if (objOfferInternal == AbstractChannelKt.OFFER_FAILED) {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(e, closedForSend));
        }
        if (objOfferInternal instanceof Closed) {
            throw StackTraceRecoveryKt.recoverStackTrace(helpCloseAndGetSendException(e, (Closed) objOfferInternal));
        }
        throw new IllegalStateException(("offerInternal returned " + objOfferInternal).toString());
    }

    private final Throwable helpCloseAndGetSendException(E e, Closed<?> closed) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        helpClose(closed);
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, closed.getSendException());
            throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        }
        return closed.getSendException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void helpCloseAndResumeWithSendException(Continuation<?> continuation, E e, Closed<?> closed) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        helpClose(closed);
        Throwable sendException = closed.getSendException();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, sendException);
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(undeliveredElementExceptionCallUndeliveredElementCatchingException$default)));
        } else {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m542constructorimpl(ResultKt.createFailure(sendException)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object enqueueSend(final kotlinx.coroutines.channels.Send r5) {
        /*
            r4 = this;
            boolean r0 = r4.isBufferAlwaysFull()
            if (r0 == 0) goto L18
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r4.queue
        L8:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r0.getPrevNode()
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r2 == 0) goto L11
            return r1
        L11:
            boolean r1 = r1.addNext(r5, r0)
            if (r1 == 0) goto L8
            goto L39
        L18:
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r4.queue
            kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 r1 = new kotlinx.coroutines.channels.AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1
            r1.<init>(r5, r5, r4)
        L1f:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r0.getPrevNode()
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r3 == 0) goto L28
            return r2
        L28:
            int r2 = r2.tryCondAddNext(r5, r0, r1)
            r3 = 1
            if (r2 == r3) goto L34
            r3 = 2
            if (r2 == r3) goto L33
            goto L1f
        L33:
            r3 = 0
        L34:
            if (r3 != 0) goto L39
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED
            return r5
        L39:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.enqueueSend(kotlinx.coroutines.channels.Send):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        boolean z;
        Closed<?> closed = new Closed<>(th);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.queue;
        while (true) {
            LockFreeLinkedListNode prevNode = lockFreeLinkedListNode.getPrevNode();
            z = true;
            if (!(!(prevNode instanceof Closed))) {
                z = false;
                break;
            }
            if (prevNode.addNext(closed, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z) {
            LockFreeLinkedListNode prevNode2 = this.queue.getPrevNode();
            if (prevNode2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            }
            closed = (Closed) prevNode2;
        }
        helpClose(closed);
        if (z) {
            invokeOnCloseHandler(th);
        }
        return z;
    }

    private final void invokeOnCloseHandler(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (symbol = AbstractChannelKt.HANDLER_INVOKED) || !onCloseHandler$FU.compareAndSet(this, obj, symbol)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        function1.invoke(closedForSend.closeCause);
    }

    private final void helpClose(Closed<?> closed) {
        Object objM560constructorimpl$default = InlineList.m560constructorimpl$default(null, 1, null);
        while (true) {
            LockFreeLinkedListNode prevNode = closed.getPrevNode();
            if (!(prevNode instanceof Receive)) {
                prevNode = null;
            }
            Receive receive = (Receive) prevNode;
            if (receive == null) {
                break;
            } else if (!receive.remove()) {
                receive.helpRemove();
            } else {
                objM560constructorimpl$default = InlineList.m561plusUZ7vuAc(objM560constructorimpl$default, receive);
            }
        }
        if (objM560constructorimpl$default != null) {
            if (objM560constructorimpl$default instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objM560constructorimpl$default;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Receive) arrayList.get(size)).resumeReceiveClosed(closed);
                }
            } else {
                ((Receive) objM560constructorimpl$default).resumeReceiveClosed(closed);
            }
        }
        onClosedIdempotent(closed);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0060 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ java.lang.Object sendSuspend(E r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r3 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r5)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
        L8:
            boolean r1 = r3.isFullImpl()
            if (r1 == 0) goto L58
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r1 = r3.onUndeliveredElement
            if (r1 != 0) goto L18
            kotlinx.coroutines.channels.SendElement r1 = new kotlinx.coroutines.channels.SendElement
            r1.<init>(r4, r0)
            goto L1f
        L18:
            kotlinx.coroutines.channels.SendElementWithUndeliveredHandler r1 = new kotlinx.coroutines.channels.SendElementWithUndeliveredHandler
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r3.onUndeliveredElement
            r1.<init>(r4, r0, r2)
        L1f:
            java.lang.Object r2 = r3.enqueueSend(r1)
            if (r2 != 0) goto L29
            kotlinx.coroutines.CancellableContinuationKt.removeOnCancellation(r0, r1)
            goto L7a
        L29:
            boolean r1 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r1 == 0) goto L33
            kotlinx.coroutines.channels.Closed r2 = (kotlinx.coroutines.channels.Closed) r2
            access$helpCloseAndResumeWithSendException(r3, r0, r4, r2)
            goto L7a
        L33:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.AbstractChannelKt.ENQUEUE_FAILED
            if (r2 != r1) goto L38
            goto L58
        L38:
            boolean r1 = r2 instanceof kotlinx.coroutines.channels.Receive
            if (r1 == 0) goto L3d
            goto L58
        L3d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "enqueueSend returned "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L58:
            java.lang.Object r1 = r3.offerInternal(r4)
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_SUCCESS
            if (r1 != r2) goto L6c
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.Result.m542constructorimpl(r4)
            r0.resumeWith(r4)
            goto L7a
        L6c:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.OFFER_FAILED
            if (r1 != r2) goto L71
            goto L8
        L71:
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L88
            kotlinx.coroutines.channels.Closed r1 = (kotlinx.coroutines.channels.Closed) r1
            access$helpCloseAndResumeWithSendException(r3, r0, r4, r1)
        L7a:
            java.lang.Object r4 = r0.getResult()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r0) goto L87
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r5)
        L87:
            return r4
        L88:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offerInternal returned "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            goto La4
        La3:
            throw r5
        La4:
            goto La3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.sendSuspend(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected kotlinx.coroutines.channels.ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        /*
            r4 = this;
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r4.queue
        L2:
            java.lang.Object r1 = r0.getNext()
            if (r1 == 0) goto L2f
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L28
        Lf:
            boolean r3 = r1 instanceof kotlinx.coroutines.channels.ReceiveOrClosed
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            kotlinx.coroutines.channels.ReceiveOrClosed r2 = (kotlinx.coroutines.channels.ReceiveOrClosed) r2
            boolean r2 = r2 instanceof kotlinx.coroutines.channels.Closed
            if (r2 == 0) goto L22
            boolean r2 = r1.isRemoved()
            if (r2 != 0) goto L22
            goto L28
        L22:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = r1.removeOrNext()
            if (r2 != 0) goto L2b
        L28:
            kotlinx.coroutines.channels.ReceiveOrClosed r1 = (kotlinx.coroutines.channels.ReceiveOrClosed) r1
            return r1
        L2b:
            r2.helpRemovePrev()
            goto L2
        L2f:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L38
        L37:
            throw r0
        L38:
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractSendChannel.takeFirstReceiveOrPeekClosed():kotlinx.coroutines.channels.ReceiveOrClosed");
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + '{' + getQueueDebugStateString() + '}' + getBufferDebugString();
    }

    private final String getQueueDebugStateString() {
        String string;
        LockFreeLinkedListNode nextNode = this.queue.getNextNode();
        if (nextNode == this.queue) {
            return "EmptyQueue";
        }
        if (nextNode instanceof Closed) {
            string = nextNode.toString();
        } else if (nextNode instanceof Receive) {
            string = "ReceiveQueued";
        } else if (nextNode instanceof Send) {
            string = "SendQueued";
        } else {
            string = "UNEXPECTED:" + nextNode;
        }
        LockFreeLinkedListNode prevNode = this.queue.getPrevNode();
        if (prevNode == nextNode) {
            return string;
        }
        String str = string + ",queueSize=" + countQueueSize();
        if (!(prevNode instanceof Closed)) {
            return str;
        }
        return str + ",closedForSend=" + prevNode;
    }

    private final int countQueueSize() {
        Object next = this.queue.getNext();
        if (next == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        int i = 0;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(nextNode, r0); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof LockFreeLinkedListNode) {
                i++;
            }
        }
        return i;
    }

    /* compiled from: AbstractChannel.kt */
    public static final class SendBuffered<E> extends Send {
        public final E element;

        @Override // kotlinx.coroutines.channels.Send
        public void completeResumeSend() {
        }

        @Override // kotlinx.coroutines.channels.Send
        public void resumeSendClosed(Closed<?> closed) {
        }

        public SendBuffered(E e) {
            this.element = e;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Object getPollResult() {
            return this.element;
        }

        @Override // kotlinx.coroutines.channels.Send
        public Symbol tryResumeSend(LockFreeLinkedListNode.PrepareOp prepareOp) {
            return CancellableContinuationImplKt.RESUME_TOKEN;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.getHexAddress(this) + '(' + this.element + ')';
        }
    }
}
