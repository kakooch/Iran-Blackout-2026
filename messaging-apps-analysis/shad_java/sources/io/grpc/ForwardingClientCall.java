package io.grpc;

import io.grpc.ClientCall;

/* loaded from: classes3.dex */
public abstract class ForwardingClientCall<ReqT, RespT> extends PartialForwardingClientCall<ReqT, RespT> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ClientCall
    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        delegate().start(listener, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.grpc.ClientCall
    public void sendMessage(ReqT reqt) {
        delegate().sendMessage(reqt);
    }

    public static abstract class SimpleForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private final ClientCall<ReqT, RespT> delegate;

        protected SimpleForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        @Override // io.grpc.PartialForwardingClientCall
        protected ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }
    }
}
