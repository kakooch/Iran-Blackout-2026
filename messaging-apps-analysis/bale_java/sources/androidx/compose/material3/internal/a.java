package androidx.compose.material3.internal;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
final class a extends CancellationException {
    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
