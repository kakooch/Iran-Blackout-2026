package ir.nasim;

import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.jc2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15450jc2 {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
