package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.Channel;
import io.grpc.Metadata;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory implements Factory<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> {
    private final Provider<Channel> channelProvider;
    private final Provider<Metadata> metadataProvider;
    private final GrpcClientModule module;

    public GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(GrpcClientModule grpcClientModule, Provider<Channel> provider, Provider<Metadata> provider2) {
        this.module = grpcClientModule;
        this.channelProvider = provider;
        this.metadataProvider = provider2;
    }

    @Override // javax.inject.Provider
    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub get() {
        return providesInAppMessagingSdkServingStub(this.module, this.channelProvider.get(), this.metadataProvider.get());
    }

    public static GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory create(GrpcClientModule grpcClientModule, Provider<Channel> provider, Provider<Metadata> provider2) {
        return new GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory(grpcClientModule, provider, provider2);
    }

    public static InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub providesInAppMessagingSdkServingStub(GrpcClientModule grpcClientModule, Channel channel, Metadata metadata) {
        return (InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub) Preconditions.checkNotNull(grpcClientModule.providesInAppMessagingSdkServingStub(channel, metadata), "Cannot return null from a non-@Nullable @Provides method");
    }
}
