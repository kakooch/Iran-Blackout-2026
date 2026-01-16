package kotlinx.coroutines;

import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes4.dex */
final class RemoveOnCancel extends BeforeResumeCancelHandler {
    private final LockFreeLinkedListNode node;

    public RemoveOnCancel(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.node = lockFreeLinkedListNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th) {
        this.node.remove();
    }

    public String toString() {
        return "RemoveOnCancel[" + this.node + ']';
    }
}
