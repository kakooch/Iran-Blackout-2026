package io.grpc;

import io.grpc.NameResolver;

/* loaded from: classes3.dex */
public abstract class NameResolverProvider extends NameResolver.Factory {
    protected abstract boolean isAvailable();

    protected abstract int priority();

    protected String getScheme() {
        return getDefaultScheme();
    }
}
