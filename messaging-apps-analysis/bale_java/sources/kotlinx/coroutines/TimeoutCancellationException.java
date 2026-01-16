package kotlinx.coroutines;

import ir.nasim.InterfaceC13730gj3;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "", DialogEntity.COLUMN_MESSAGE, "Lir/nasim/gj3;", "coroutine", "<init>", "(Ljava/lang/String;Lir/nasim/gj3;)V", "(Ljava/lang/String;)V", "a", "Lir/nasim/gj3;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes8.dex */
public final class TimeoutCancellationException extends CancellationException {

    /* renamed from: a, reason: from kotlin metadata */
    public final transient InterfaceC13730gj3 coroutine;

    public TimeoutCancellationException(String str, InterfaceC13730gj3 interfaceC13730gj3) {
        super(str);
        this.coroutine = interfaceC13730gj3;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }
}
