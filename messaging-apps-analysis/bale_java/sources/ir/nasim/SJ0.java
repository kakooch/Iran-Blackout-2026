package ir.nasim;

import java.util.concurrent.CancellationException;

/* loaded from: classes8.dex */
abstract /* synthetic */ class SJ0 {
    public static final void a(VI5 vi5, Throwable th) {
        if (th != null) {
            cancellationExceptionA = th instanceof CancellationException ? (CancellationException) th : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = AbstractC15450jc2.a("Channel was consumed, consumer had failed", th);
            }
        }
        vi5.g(cancellationExceptionA);
    }
}
