package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;

/* loaded from: classes3.dex */
public final class InAppMessagingSdkServingGrpc {
    private static volatile MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod;

    /* renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc$1, reason: invalid class name */
    class AnonymousClass1 implements AbstractStub.StubFactory<Object> {
    }

    private InAppMessagingSdkServingGrpc() {
    }

    public static MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod() {
        MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> methodDescriptorBuild = getFetchEligibleCampaignsMethod;
        if (methodDescriptorBuild == null) {
            synchronized (InAppMessagingSdkServingGrpc.class) {
                methodDescriptorBuild = getFetchEligibleCampaignsMethod;
                if (methodDescriptorBuild == null) {
                    methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName("google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing", "FetchEligibleCampaigns")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(FetchEligibleCampaignsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(FetchEligibleCampaignsResponse.getDefaultInstance())).build();
                    getFetchEligibleCampaignsMethod = methodDescriptorBuild;
                }
            }
        }
        return methodDescriptorBuild;
    }

    public static InAppMessagingSdkServingBlockingStub newBlockingStub(Channel channel) {
        return (InAppMessagingSdkServingBlockingStub) AbstractBlockingStub.newStub(new AbstractStub.StubFactory<InAppMessagingSdkServingBlockingStub>() { // from class: com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public InAppMessagingSdkServingBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new InAppMessagingSdkServingBlockingStub(channel2, callOptions, null);
            }
        }, channel);
    }

    public static final class InAppMessagingSdkServingBlockingStub extends AbstractBlockingStub<InAppMessagingSdkServingBlockingStub> {
        /* synthetic */ InAppMessagingSdkServingBlockingStub(Channel channel, CallOptions callOptions, AnonymousClass1 anonymousClass1) {
            this(channel, callOptions);
        }

        private InAppMessagingSdkServingBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingBlockingStub build(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingBlockingStub(channel, callOptions);
        }

        public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return (FetchEligibleCampaignsResponse) ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions(), fetchEligibleCampaignsRequest);
        }
    }
}
