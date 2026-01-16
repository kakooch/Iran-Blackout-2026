package kotlinx.coroutines;

import kotlinx.coroutines.Job;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public abstract class JobNode<J extends Job> extends CompletionHandlerBase implements DisposableHandle, Incomplete {
    public final J job;

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    public JobNode(J j) {
        this.job = j;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        J j = this.job;
        if (j == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ((JobSupport) j).removeNode$kotlinx_coroutines_core(this);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + "[job@" + DebugStringsKt.getHexAddress(this.job) + ']';
    }
}
