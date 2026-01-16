package io.grpc.internal;

import io.grpc.Status;

/* loaded from: classes3.dex */
public interface ManagedClientTransport extends ClientTransport {

    public interface Listener {
        void transportInUse(boolean z);

        void transportReady();

        void transportShutdown(Status status);

        void transportTerminated();
    }

    void shutdown(Status status);

    void shutdownNow(Status status);

    Runnable start(Listener listener);
}
