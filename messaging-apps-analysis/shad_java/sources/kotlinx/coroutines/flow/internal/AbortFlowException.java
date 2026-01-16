package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExceptions.kt */
/* loaded from: classes4.dex */
public final class AbortFlowException extends CancellationException {
    private final FlowCollector<?> owner;

    public final FlowCollector<?> getOwner() {
        return this.owner;
    }

    public AbortFlowException(FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.owner = flowCollector;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (DebugKt.getDEBUG()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
