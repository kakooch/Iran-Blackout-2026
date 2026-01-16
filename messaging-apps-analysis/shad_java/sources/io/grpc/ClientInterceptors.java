package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ClientCall;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ClientInterceptors {

    /* renamed from: io.grpc.ClientInterceptors$1, reason: invalid class name */
    class AnonymousClass1 implements ClientInterceptor {
    }

    public static Channel intercept(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return intercept(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> list) {
        Preconditions.checkNotNull(channel, "channel");
        Iterator<? extends ClientInterceptor> it = list.iterator();
        while (it.hasNext()) {
            channel = new InterceptorChannel(channel, it.next(), null);
        }
        return channel;
    }

    private static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        /* synthetic */ InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor, AnonymousClass1 anonymousClass1) {
            this(channel, clientInterceptor);
        }

        private InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor) {
            this.channel = channel;
            this.interceptor = (ClientInterceptor) Preconditions.checkNotNull(clientInterceptor, "interceptor");
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return this.interceptor.interceptCall(methodDescriptor, callOptions, this.channel);
        }

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }
    }

    static {
        new ClientCall<Object, Object>() { // from class: io.grpc.ClientInterceptors.2
            @Override // io.grpc.ClientCall
            public void cancel(String str, Throwable th) {
            }

            @Override // io.grpc.ClientCall
            public void halfClose() {
            }

            @Override // io.grpc.ClientCall
            public void request(int i) {
            }

            @Override // io.grpc.ClientCall
            public void sendMessage(Object obj) {
            }

            @Override // io.grpc.ClientCall
            public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
            }
        };
    }
}
