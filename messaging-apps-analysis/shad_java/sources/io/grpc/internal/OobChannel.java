package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.InternalInstrumented;
import io.grpc.InternalLogId;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import io.grpc.internal.ClientCallImpl;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class OobChannel extends ManagedChannel implements InternalInstrumented<Object> {
    private final String authority;
    private final CallTracer channelCallsTracer;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private final Executor executor;
    private final InternalLogId logId;
    private InternalSubchannel subchannel;
    private final ClientCallImpl.ClientStreamProvider transportProvider;

    static {
        Logger.getLogger(OobChannel.class.getName());
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return new ClientCallImpl(methodDescriptor, callOptions.getExecutor() == null ? this.executor : callOptions.getExecutor(), callOptions, this.transportProvider, this.deadlineCancellationExecutor, this.channelCallsTracer, null);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.authority;
    }

    InternalSubchannel getInternalSubchannel() {
        return this.subchannel;
    }

    @Override // io.grpc.InternalWithLogId
    public InternalLogId getLogId() {
        return this.logId;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("logId", this.logId.getId()).add("authority", this.authority).toString();
    }
}
