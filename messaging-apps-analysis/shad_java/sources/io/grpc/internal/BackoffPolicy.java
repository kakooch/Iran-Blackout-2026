package io.grpc.internal;

/* loaded from: classes3.dex */
public interface BackoffPolicy {

    public interface Provider {
        BackoffPolicy get();
    }

    long nextBackoffNanos();
}
