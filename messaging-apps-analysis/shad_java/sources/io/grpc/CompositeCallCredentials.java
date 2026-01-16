package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class CompositeCallCredentials extends CallCredentials {
    private final CallCredentials credentials1;

    public CompositeCallCredentials(CallCredentials callCredentials, CallCredentials callCredentials2) {
        this.credentials1 = (CallCredentials) Preconditions.checkNotNull(callCredentials, "creds1");
    }

    @Override // io.grpc.CallCredentials
    public void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier) {
        this.credentials1.applyRequestMetadata(requestInfo, executor, new WrappingMetadataApplier(this, requestInfo, executor, metadataApplier, Context.current()));
    }

    private final class WrappingMetadataApplier extends CallCredentials.MetadataApplier {
        private final Executor appExecutor;

        public WrappingMetadataApplier(CompositeCallCredentials compositeCallCredentials, CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier, Context context) {
            this.appExecutor = executor;
        }
    }
}
