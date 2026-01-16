package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/* loaded from: classes3.dex */
public abstract class AbstractManagedChannelImplBuilder<T extends ManagedChannelBuilder<T>> extends ManagedChannelBuilder<T> {
    protected int maxInboundMessageSize = 4194304;

    protected abstract ManagedChannelBuilder<?> delegate();

    protected AbstractManagedChannelImplBuilder() {
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannel build() {
        return delegate().build();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
