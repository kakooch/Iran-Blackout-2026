package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;

/* loaded from: classes3.dex */
abstract class ForwardingManagedChannel extends ManagedChannel {
    private final ManagedChannel delegate;

    ForwardingManagedChannel(ManagedChannel managedChannel) {
        this.delegate = managedChannel;
    }

    @Override // io.grpc.Channel
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
        return this.delegate.newCall(methodDescriptor, callOptions);
    }

    @Override // io.grpc.Channel
    public String authority() {
        return this.delegate.authority();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
    }
}
