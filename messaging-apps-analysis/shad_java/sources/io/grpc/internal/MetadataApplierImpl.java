package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;

/* loaded from: classes3.dex */
final class MetadataApplierImpl extends CallCredentials.MetadataApplier {
    DelayedStream delayedStream;
    boolean finalized;
    private final MetadataApplierListener listener;
    private final Object lock = new Object();
    private ClientStream returnedStream;
    private final ClientStreamTracer[] tracers;
    private final ClientTransport transport;

    public interface MetadataApplierListener {
        void onComplete();
    }

    MetadataApplierImpl(ClientTransport clientTransport, MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, MetadataApplierListener metadataApplierListener, ClientStreamTracer[] clientStreamTracerArr) {
        this.transport = clientTransport;
        Context.current();
        this.listener = metadataApplierListener;
        this.tracers = clientStreamTracerArr;
    }

    public void fail(Status status) {
        Preconditions.checkArgument(!status.isOk(), "Cannot fail with OK status");
        Preconditions.checkState(!this.finalized, "apply() or fail() already called");
        finalizeWith(new FailingClientStream(status, this.tracers));
    }

    private void finalizeWith(ClientStream clientStream) {
        boolean z;
        Preconditions.checkState(!this.finalized, "already finalized");
        this.finalized = true;
        synchronized (this.lock) {
            if (this.returnedStream == null) {
                this.returnedStream = clientStream;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.listener.onComplete();
            return;
        }
        Preconditions.checkState(this.delayedStream != null, "delayedStream is null");
        Runnable stream = this.delayedStream.setStream(clientStream);
        if (stream != null) {
            stream.run();
        }
        this.listener.onComplete();
    }

    ClientStream returnStream() {
        synchronized (this.lock) {
            ClientStream clientStream = this.returnedStream;
            if (clientStream != null) {
                return clientStream;
            }
            DelayedStream delayedStream = new DelayedStream();
            this.delayedStream = delayedStream;
            this.returnedStream = delayedStream;
            return delayedStream;
        }
    }
}
