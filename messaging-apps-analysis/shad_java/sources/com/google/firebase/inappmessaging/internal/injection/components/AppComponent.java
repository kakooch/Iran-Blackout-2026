package com.google.firebase.inappmessaging.internal.injection.components;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;

/* loaded from: classes3.dex */
public interface AppComponent {

    public interface Builder {
        Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper);

        Builder apiClientModule(ApiClientModule apiClientModule);

        AppComponent build();

        Builder grpcClientModule(GrpcClientModule grpcClientModule);

        Builder transportFactory(TransportFactory transportFactory);

        Builder universalComponent(UniversalComponent universalComponent);
    }

    FirebaseInAppMessaging providesFirebaseInAppMessaging();
}
