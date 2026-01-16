package com.facebook.stetho.inspector.jsonrpc;

/* loaded from: classes.dex */
public class PendingRequest {
    public final PendingRequestCallback callback;
    public final long requestId;

    public PendingRequest(long j, PendingRequestCallback pendingRequestCallback) {
        this.requestId = j;
        this.callback = pendingRequestCallback;
    }
}
