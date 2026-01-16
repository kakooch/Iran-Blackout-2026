package io.grpc;

/* loaded from: classes3.dex */
public class StatusException extends Exception {
    private final boolean a;

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.a ? super.fillInStackTrace() : this;
    }
}
