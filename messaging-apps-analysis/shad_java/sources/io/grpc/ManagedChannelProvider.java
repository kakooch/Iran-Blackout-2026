package io.grpc;

/* loaded from: classes3.dex */
public abstract class ManagedChannelProvider {
    protected abstract ManagedChannelBuilder<?> builderForTarget(String str);

    protected abstract boolean isAvailable();

    protected abstract int priority();

    public static ManagedChannelProvider provider() {
        ManagedChannelProvider managedChannelProviderProvider = ManagedChannelRegistry.getDefaultRegistry().provider();
        if (managedChannelProviderProvider != null) {
            return managedChannelProviderProvider;
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    public static final class ProviderNotFoundException extends RuntimeException {
        public ProviderNotFoundException(String str) {
            super(str);
        }
    }
}
