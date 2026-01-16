package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ImpressionStorageClient_Factory implements Factory<ImpressionStorageClient> {
    private final Provider<ProtoStorageClient> storageClientProvider;

    public ImpressionStorageClient_Factory(Provider<ProtoStorageClient> provider) {
        this.storageClientProvider = provider;
    }

    @Override // javax.inject.Provider
    public ImpressionStorageClient get() {
        return newInstance(this.storageClientProvider.get());
    }

    public static ImpressionStorageClient_Factory create(Provider<ProtoStorageClient> provider) {
        return new ImpressionStorageClient_Factory(provider);
    }

    public static ImpressionStorageClient newInstance(ProtoStorageClient protoStorageClient) {
        return new ImpressionStorageClient(protoStorageClient);
    }
}
