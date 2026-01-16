package io.grpc;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public abstract class CallCredentials {

    public static abstract class MetadataApplier {
    }

    public static abstract class RequestInfo {
    }

    public abstract void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier);
}
