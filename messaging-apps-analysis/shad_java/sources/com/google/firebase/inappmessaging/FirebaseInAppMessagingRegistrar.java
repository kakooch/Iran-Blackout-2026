package com.google.firebase.inappmessaging;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.component.AbtComponent;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerAppComponent;
import com.google.firebase.inappmessaging.internal.injection.components.DaggerUniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.components.UniversalComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.AnalyticsEventsModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.AppMeasurementModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class FirebaseInAppMessagingRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInAppMessaging.class).add(Dependency.required((Class<?>) Context.class)).add(Dependency.required((Class<?>) FirebaseInstallationsApi.class)).add(Dependency.required((Class<?>) FirebaseApp.class)).add(Dependency.required((Class<?>) AbtComponent.class)).add(Dependency.deferred(AnalyticsConnector.class)).add(Dependency.required((Class<?>) TransportFactory.class)).add(Dependency.required((Class<?>) Subscriber.class)).factory(new ComponentFactory() { // from class: com.google.firebase.inappmessaging.FirebaseInAppMessagingRegistrar$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return this.f$0.providesFirebaseInAppMessaging(componentContainer);
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-fiam", "20.1.2"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FirebaseInAppMessaging providesFirebaseInAppMessaging(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class);
        Deferred deferred = componentContainer.getDeferred(AnalyticsConnector.class);
        Subscriber subscriber = (Subscriber) componentContainer.get(Subscriber.class);
        UniversalComponent universalComponentBuild = DaggerUniversalComponent.builder().applicationModule(new ApplicationModule((Application) firebaseApp.getApplicationContext())).appMeasurementModule(new AppMeasurementModule(deferred, subscriber)).analyticsEventsModule(new AnalyticsEventsModule()).programmaticContextualTriggerFlowableModule(new ProgrammaticContextualTriggerFlowableModule(new ProgramaticContextualTriggers())).build();
        return DaggerAppComponent.builder().abtIntegrationHelper(new AbtIntegrationHelper(((AbtComponent) componentContainer.get(AbtComponent.class)).get("fiam"))).apiClientModule(new ApiClientModule(firebaseApp, firebaseInstallationsApi, universalComponentBuild.clock())).grpcClientModule(new GrpcClientModule(firebaseApp)).universalComponent(universalComponentBuild).transportFactory((TransportFactory) componentContainer.get(TransportFactory.class)).build().providesFirebaseInAppMessaging();
    }
}
