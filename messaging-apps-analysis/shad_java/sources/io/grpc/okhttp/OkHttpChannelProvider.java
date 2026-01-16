package io.grpc.okhttp;

import io.grpc.InternalServiceProviders;
import io.grpc.ManagedChannelProvider;

/* loaded from: classes3.dex */
public final class OkHttpChannelProvider extends ManagedChannelProvider {
    @Override // io.grpc.ManagedChannelProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.ManagedChannelProvider
    public int priority() {
        return InternalServiceProviders.isAndroid(OkHttpChannelProvider.class.getClassLoader()) ? 8 : 3;
    }

    @Override // io.grpc.ManagedChannelProvider
    public OkHttpChannelBuilder builderForTarget(String str) {
        return OkHttpChannelBuilder.forTarget(str);
    }
}
