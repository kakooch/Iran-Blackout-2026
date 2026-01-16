package com.google.firebase.inappmessaging.internal.injection.modules;

import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

/* loaded from: classes3.dex */
public class GrpcChannelModule {
    public String providesServiceHost() {
        return "firebaseinappmessaging.googleapis.com";
    }

    public Channel providesGrpcChannel(String str) {
        return ManagedChannelBuilder.forTarget(str).build();
    }
}
