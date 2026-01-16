package io.grpc;

/* loaded from: classes3.dex */
public class StatusRuntimeException extends RuntimeException {
    private final boolean fillInStackTrace;
    private final Status status;
    private final Metadata trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    public StatusRuntimeException(Status status, Metadata metadata) {
        this(status, metadata, true);
    }

    StatusRuntimeException(Status status, Metadata metadata, boolean z) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = metadata;
        this.fillInStackTrace = z;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.fillInStackTrace ? super.fillInStackTrace() : this;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Metadata getTrailers() {
        return this.trailers;
    }
}
