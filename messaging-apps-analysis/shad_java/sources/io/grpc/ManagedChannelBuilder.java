package io.grpc;

import io.grpc.ManagedChannelBuilder;

/* loaded from: classes3.dex */
public abstract class ManagedChannelBuilder<T extends ManagedChannelBuilder<T>> {
    public abstract ManagedChannel build();

    public static ManagedChannelBuilder<?> forTarget(String str) {
        return ManagedChannelProvider.provider().builderForTarget(str);
    }
}
