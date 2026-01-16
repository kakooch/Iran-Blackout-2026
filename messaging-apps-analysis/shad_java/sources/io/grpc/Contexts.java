package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.Status;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class Contexts {
    public static Status statusFromCancelled(Context context) {
        Preconditions.checkNotNull(context, "context must not be null");
        if (!context.isCancelled()) {
            return null;
        }
        Throwable thCancellationCause = context.cancellationCause();
        if (thCancellationCause == null) {
            return Status.CANCELLED.withDescription("io.grpc.Context was cancelled without error");
        }
        if (thCancellationCause instanceof TimeoutException) {
            return Status.DEADLINE_EXCEEDED.withDescription(thCancellationCause.getMessage()).withCause(thCancellationCause);
        }
        Status statusFromThrowable = Status.fromThrowable(thCancellationCause);
        if (Status.Code.UNKNOWN.equals(statusFromThrowable.getCode()) && statusFromThrowable.getCause() == thCancellationCause) {
            return Status.CANCELLED.withDescription("Context cancelled").withCause(thCancellationCause);
        }
        return statusFromThrowable.withCause(thCancellationCause);
    }
}
