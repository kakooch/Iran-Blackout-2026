package io.grpc;

import com.google.common.base.MoreObjects;

/* loaded from: classes3.dex */
abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    protected abstract ClientCall<?, ?> delegate();

    PartialForwardingClientCall() {
    }

    @Override // io.grpc.ClientCall
    public void request(int i) {
        delegate().request(i);
    }

    @Override // io.grpc.ClientCall
    public void cancel(String str, Throwable th) {
        delegate().cancel(str, th);
    }

    @Override // io.grpc.ClientCall
    public void halfClose() {
        delegate().halfClose();
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
    }
}
