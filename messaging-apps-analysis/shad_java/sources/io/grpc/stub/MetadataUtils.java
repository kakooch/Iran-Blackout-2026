package io.grpc.stub;

import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

/* loaded from: classes3.dex */
public final class MetadataUtils {
    public static ClientInterceptor newAttachHeadersInterceptor(Metadata metadata) {
        return new HeaderAttachingClientInterceptor(metadata);
    }

    private static final class HeaderAttachingClientInterceptor implements ClientInterceptor {
        private final Metadata extraHeaders;

        HeaderAttachingClientInterceptor(Metadata metadata) {
            this.extraHeaders = (Metadata) Preconditions.checkNotNull(metadata, "extraHeaders");
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new HeaderAttachingClientCall(channel.newCall(methodDescriptor, callOptions));
        }

        private final class HeaderAttachingClientCall<ReqT, RespT> extends ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT> {
            HeaderAttachingClientCall(ClientCall<ReqT, RespT> clientCall) {
                super(clientCall);
            }

            @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
            public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                metadata.merge(HeaderAttachingClientInterceptor.this.extraHeaders);
                super.start(listener, metadata);
            }
        }
    }
}
