package ir.nasim.webapp.ui;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u00002\u00060\u0002j\u0002`\u0001B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lir/nasim/webapp/ui/AnchoredDragFinishedSignal;", "Lkotlinx/coroutines/CancellationException;", "Ljava/util/concurrent/CancellationException;", "<init>", "()V", "fillInStackTrace", "", "webapp_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AnchoredDragFinishedSignal extends CancellationException {
    public AnchoredDragFinishedSignal() {
        super("Anchored drag finished");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
