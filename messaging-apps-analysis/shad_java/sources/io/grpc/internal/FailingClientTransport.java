package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalLogId;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* loaded from: classes3.dex */
class FailingClientTransport implements ClientTransport {
    final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;

    FailingClientTransport(Status status, ClientStreamListener.RpcProgress rpcProgress) {
        Preconditions.checkArgument(!status.isOk(), "error must not be OK");
        this.error = status;
        this.rpcProgress = rpcProgress;
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions, ClientStreamTracer[] clientStreamTracerArr) {
        return new FailingClientStream(this.error, this.rpcProgress, clientStreamTracerArr);
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
