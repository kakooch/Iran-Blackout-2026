package kotlinx.coroutines.flow.internal;

import ir.nasim.InterfaceC4806Gq2;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lir/nasim/Gq2;", "owner", "<init>", "(Lir/nasim/Gq2;)V", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "a", "Lir/nasim/Gq2;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final class AbortFlowException extends CancellationException {

    /* renamed from: a, reason: from kotlin metadata */
    public final transient InterfaceC4806Gq2 owner;

    public AbortFlowException(InterfaceC4806Gq2 interfaceC4806Gq2) {
        super("Flow was aborted, no more elements needed");
        this.owner = interfaceC4806Gq2;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
