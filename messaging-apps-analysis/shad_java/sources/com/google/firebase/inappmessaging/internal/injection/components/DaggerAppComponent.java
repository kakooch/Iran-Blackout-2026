package com.google.firebase.inappmessaging.internal.injection.components;

import android.app.Application;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging_Factory;
import com.google.firebase.inappmessaging.dagger.internal.DoubleCheck;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.InstanceFactory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.internal.AbtIntegrationHelper;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.ApiClient;
import com.google.firebase.inappmessaging.internal.CampaignCacheClient;
import com.google.firebase.inappmessaging.internal.DataCollectionHelper;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory;
import com.google.firebase.inappmessaging.internal.DisplayCallbacksFactory_Factory;
import com.google.firebase.inappmessaging.internal.GrpcClient;
import com.google.firebase.inappmessaging.internal.GrpcClient_Factory;
import com.google.firebase.inappmessaging.internal.ImpressionStorageClient;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager_Factory;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.ProviderInstaller;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import com.google.firebase.inappmessaging.internal.Schedulers;
import com.google.firebase.inappmessaging.internal.SharedPreferencesUtils;
import com.google.firebase.inappmessaging.internal.TestDeviceHelper;
import com.google.firebase.inappmessaging.internal.injection.components.AppComponent;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesApiClientFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesDataCollectionHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseAppFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesFirebaseInstallationsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesSharedPreferencesUtilsFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.ApiClientModule_ProvidesTestDeviceHelperFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesApiKeyHeadersFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule_ProvidesMetricsLoggerClientFactory;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.Channel;
import io.grpc.Metadata;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DaggerAppComponent implements AppComponent {
    private Provider<AbtIntegrationHelper> abtIntegrationHelperProvider;
    private Provider<AnalyticsConnector> analyticsConnectorProvider;
    private Provider<AnalyticsEventsManager> analyticsEventsManagerProvider;
    private Provider<ConnectableFlowable<String>> appForegroundEventFlowableProvider;
    private Provider<RateLimit> appForegroundRateLimitProvider;
    private Provider<Application> applicationProvider;
    private Provider<CampaignCacheClient> campaignCacheClientProvider;
    private Provider<Clock> clockProvider;
    private Provider<DeveloperListenerManager> developerListenerManagerProvider;
    private Provider<DisplayCallbacksFactory> displayCallbacksFactoryProvider;
    private Provider<Subscriber> firebaseEventsSubscriberProvider;
    private Provider<FirebaseInAppMessaging> firebaseInAppMessagingProvider;
    private Provider<Channel> gRPCChannelProvider;
    private Provider<GrpcClient> grpcClientProvider;
    private Provider<ImpressionStorageClient> impressionStorageClientProvider;
    private Provider<InAppMessageStreamManager> inAppMessageStreamManagerProvider;
    private Provider<ProviderInstaller> probiderInstallerProvider;
    private Provider<ConnectableFlowable<String>> programmaticContextualTriggerFlowableProvider;
    private Provider<ProgramaticContextualTriggers> programmaticContextualTriggersProvider;
    private Provider<ApiClient> providesApiClientProvider;
    private Provider<Metadata> providesApiKeyHeadersProvider;
    private Provider<DataCollectionHelper> providesDataCollectionHelperProvider;
    private Provider<FirebaseApp> providesFirebaseAppProvider;
    private Provider<FirebaseInstallationsApi> providesFirebaseInstallationsProvider;
    private Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> providesInAppMessagingSdkServingStubProvider;
    private Provider<MetricsLoggerClient> providesMetricsLoggerClientProvider;
    private Provider<SharedPreferencesUtils> providesSharedPreferencesUtilsProvider;
    private Provider<TestDeviceHelper> providesTestDeviceHelperProvider;
    private Provider<RateLimiterClient> rateLimiterClientProvider;
    private Provider<Schedulers> schedulersProvider;
    private Provider<TransportFactory> transportFactoryProvider;
    private final UniversalComponent universalComponent;

    private DaggerAppComponent(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule, UniversalComponent universalComponent, AbtIntegrationHelper abtIntegrationHelper, TransportFactory transportFactory) {
        this.universalComponent = universalComponent;
        initialize(apiClientModule, grpcClientModule, universalComponent, abtIntegrationHelper, transportFactory);
    }

    public static AppComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(ApiClientModule apiClientModule, GrpcClientModule grpcClientModule, UniversalComponent universalComponent, AbtIntegrationHelper abtIntegrationHelper, TransportFactory transportFactory) {
        this.appForegroundEventFlowableProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable(universalComponent);
        this.programmaticContextualTriggerFlowableProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable(universalComponent);
        this.campaignCacheClientProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient(universalComponent);
        this.clockProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock(universalComponent);
        this.gRPCChannelProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel(universalComponent);
        GrpcClientModule_ProvidesApiKeyHeadersFactory grpcClientModule_ProvidesApiKeyHeadersFactoryCreate = GrpcClientModule_ProvidesApiKeyHeadersFactory.create(grpcClientModule);
        this.providesApiKeyHeadersProvider = grpcClientModule_ProvidesApiKeyHeadersFactoryCreate;
        Provider<InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub> provider = DoubleCheck.provider(GrpcClientModule_ProvidesInAppMessagingSdkServingStubFactory.create(grpcClientModule, this.gRPCChannelProvider, grpcClientModule_ProvidesApiKeyHeadersFactoryCreate));
        this.providesInAppMessagingSdkServingStubProvider = provider;
        this.grpcClientProvider = DoubleCheck.provider(GrpcClient_Factory.create(provider));
        this.applicationProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application(universalComponent);
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_probiderinstaller = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller(universalComponent);
        this.probiderInstallerProvider = com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_probiderinstaller;
        this.providesApiClientProvider = DoubleCheck.provider(ApiClientModule_ProvidesApiClientFactory.create(apiClientModule, this.grpcClientProvider, this.applicationProvider, com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_probiderinstaller));
        this.analyticsEventsManagerProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager(universalComponent);
        this.schedulersProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers(universalComponent);
        this.impressionStorageClientProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient(universalComponent);
        this.rateLimiterClientProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient(universalComponent);
        this.appForegroundRateLimitProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit(universalComponent);
        ApiClientModule_ProvidesSharedPreferencesUtilsFactory apiClientModule_ProvidesSharedPreferencesUtilsFactoryCreate = ApiClientModule_ProvidesSharedPreferencesUtilsFactory.create(apiClientModule);
        this.providesSharedPreferencesUtilsProvider = apiClientModule_ProvidesSharedPreferencesUtilsFactoryCreate;
        this.providesTestDeviceHelperProvider = ApiClientModule_ProvidesTestDeviceHelperFactory.create(apiClientModule, apiClientModule_ProvidesSharedPreferencesUtilsFactoryCreate);
        this.providesFirebaseInstallationsProvider = ApiClientModule_ProvidesFirebaseInstallationsFactory.create(apiClientModule);
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_firebaseeventssubscriber = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber(universalComponent);
        this.firebaseEventsSubscriberProvider = com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_firebaseeventssubscriber;
        this.providesDataCollectionHelperProvider = ApiClientModule_ProvidesDataCollectionHelperFactory.create(apiClientModule, this.providesSharedPreferencesUtilsProvider, com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_firebaseeventssubscriber);
        Factory factoryCreate = InstanceFactory.create(abtIntegrationHelper);
        this.abtIntegrationHelperProvider = factoryCreate;
        this.inAppMessageStreamManagerProvider = DoubleCheck.provider(InAppMessageStreamManager_Factory.create(this.appForegroundEventFlowableProvider, this.programmaticContextualTriggerFlowableProvider, this.campaignCacheClientProvider, this.clockProvider, this.providesApiClientProvider, this.analyticsEventsManagerProvider, this.schedulersProvider, this.impressionStorageClientProvider, this.rateLimiterClientProvider, this.appForegroundRateLimitProvider, this.providesTestDeviceHelperProvider, this.providesFirebaseInstallationsProvider, this.providesDataCollectionHelperProvider, factoryCreate));
        this.programmaticContextualTriggersProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers(universalComponent);
        this.providesFirebaseAppProvider = ApiClientModule_ProvidesFirebaseAppFactory.create(apiClientModule);
        this.transportFactoryProvider = InstanceFactory.create(transportFactory);
        this.analyticsConnectorProvider = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector(universalComponent);
        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_developerlistenermanager = new com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager(universalComponent);
        this.developerListenerManagerProvider = com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_developerlistenermanager;
        Provider<MetricsLoggerClient> provider2 = DoubleCheck.provider(TransportClientModule_ProvidesMetricsLoggerClientFactory.create(this.providesFirebaseAppProvider, this.transportFactoryProvider, this.analyticsConnectorProvider, this.providesFirebaseInstallationsProvider, this.clockProvider, com_google_firebase_inappmessaging_internal_injection_components_universalcomponent_developerlistenermanager));
        this.providesMetricsLoggerClientProvider = provider2;
        DisplayCallbacksFactory_Factory displayCallbacksFactory_FactoryCreate = DisplayCallbacksFactory_Factory.create(this.impressionStorageClientProvider, this.clockProvider, this.schedulersProvider, this.rateLimiterClientProvider, this.campaignCacheClientProvider, this.appForegroundRateLimitProvider, provider2, this.providesDataCollectionHelperProvider);
        this.displayCallbacksFactoryProvider = displayCallbacksFactory_FactoryCreate;
        this.firebaseInAppMessagingProvider = DoubleCheck.provider(FirebaseInAppMessaging_Factory.create(this.inAppMessageStreamManagerProvider, this.programmaticContextualTriggersProvider, this.providesDataCollectionHelperProvider, this.providesFirebaseInstallationsProvider, displayCallbacksFactory_FactoryCreate, this.developerListenerManagerProvider));
    }

    @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent
    public FirebaseInAppMessaging providesFirebaseInAppMessaging() {
        return this.firebaseInAppMessagingProvider.get();
    }

    private static final class Builder implements AppComponent.Builder {
        private AbtIntegrationHelper abtIntegrationHelper;
        private ApiClientModule apiClientModule;
        private GrpcClientModule grpcClientModule;
        private TransportFactory transportFactory;
        private UniversalComponent universalComponent;

        private Builder() {
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder abtIntegrationHelper(AbtIntegrationHelper abtIntegrationHelper) {
            this.abtIntegrationHelper = (AbtIntegrationHelper) Preconditions.checkNotNull(abtIntegrationHelper);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder apiClientModule(ApiClientModule apiClientModule) {
            this.apiClientModule = (ApiClientModule) Preconditions.checkNotNull(apiClientModule);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder grpcClientModule(GrpcClientModule grpcClientModule) {
            this.grpcClientModule = (GrpcClientModule) Preconditions.checkNotNull(grpcClientModule);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder universalComponent(UniversalComponent universalComponent) {
            this.universalComponent = (UniversalComponent) Preconditions.checkNotNull(universalComponent);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public Builder transportFactory(TransportFactory transportFactory) {
            this.transportFactory = (TransportFactory) Preconditions.checkNotNull(transportFactory);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.internal.injection.components.AppComponent.Builder
        public AppComponent build() {
            Preconditions.checkBuilderRequirement(this.abtIntegrationHelper, AbtIntegrationHelper.class);
            Preconditions.checkBuilderRequirement(this.apiClientModule, ApiClientModule.class);
            Preconditions.checkBuilderRequirement(this.grpcClientModule, GrpcClientModule.class);
            Preconditions.checkBuilderRequirement(this.universalComponent, UniversalComponent.class);
            Preconditions.checkBuilderRequirement(this.transportFactory, TransportFactory.class);
            return new DaggerAppComponent(this.apiClientModule, this.grpcClientModule, this.universalComponent, this.abtIntegrationHelper, this.transportFactory);
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable implements Provider<ConnectableFlowable<String>> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundEventFlowable(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConnectableFlowable<String> get() {
            return (ConnectableFlowable) Preconditions.checkNotNull(this.universalComponent.appForegroundEventFlowable(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable implements Provider<ConnectableFlowable<String>> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggerFlowable(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConnectableFlowable<String> get() {
            return (ConnectableFlowable) Preconditions.checkNotNull(this.universalComponent.programmaticContextualTriggerFlowable(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient implements Provider<CampaignCacheClient> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_campaignCacheClient(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public CampaignCacheClient get() {
            return (CampaignCacheClient) Preconditions.checkNotNull(this.universalComponent.campaignCacheClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock implements Provider<Clock> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_clock(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Clock get() {
            return (Clock) Preconditions.checkNotNull(this.universalComponent.clock(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel implements Provider<Channel> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_gRPCChannel(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Channel get() {
            return (Channel) Preconditions.checkNotNull(this.universalComponent.gRPCChannel(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application implements Provider<Application> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_application(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNull(this.universalComponent.application(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller implements Provider<ProviderInstaller> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_probiderInstaller(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ProviderInstaller get() {
            return (ProviderInstaller) Preconditions.checkNotNull(this.universalComponent.probiderInstaller(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager implements Provider<AnalyticsEventsManager> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsEventsManager(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AnalyticsEventsManager get() {
            return (AnalyticsEventsManager) Preconditions.checkNotNull(this.universalComponent.analyticsEventsManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers implements Provider<Schedulers> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_schedulers(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Schedulers get() {
            return (Schedulers) Preconditions.checkNotNull(this.universalComponent.schedulers(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient implements Provider<ImpressionStorageClient> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_impressionStorageClient(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ImpressionStorageClient get() {
            return (ImpressionStorageClient) Preconditions.checkNotNull(this.universalComponent.impressionStorageClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient implements Provider<RateLimiterClient> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_rateLimiterClient(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public RateLimiterClient get() {
            return (RateLimiterClient) Preconditions.checkNotNull(this.universalComponent.rateLimiterClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit implements Provider<RateLimit> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_appForegroundRateLimit(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public RateLimit get() {
            return (RateLimit) Preconditions.checkNotNull(this.universalComponent.appForegroundRateLimit(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber implements Provider<Subscriber> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_firebaseEventsSubscriber(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Subscriber get() {
            return (Subscriber) Preconditions.checkNotNull(this.universalComponent.firebaseEventsSubscriber(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers implements Provider<ProgramaticContextualTriggers> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_programmaticContextualTriggers(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ProgramaticContextualTriggers get() {
            return (ProgramaticContextualTriggers) Preconditions.checkNotNull(this.universalComponent.programmaticContextualTriggers(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector implements Provider<AnalyticsConnector> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_analyticsConnector(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AnalyticsConnector get() {
            return (AnalyticsConnector) Preconditions.checkNotNull(this.universalComponent.analyticsConnector(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager implements Provider<DeveloperListenerManager> {
        private final UniversalComponent universalComponent;

        com_google_firebase_inappmessaging_internal_injection_components_UniversalComponent_developerListenerManager(UniversalComponent universalComponent) {
            this.universalComponent = universalComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public DeveloperListenerManager get() {
            return (DeveloperListenerManager) Preconditions.checkNotNull(this.universalComponent.developerListenerManager(), "Cannot return null from a non-@Nullable component method");
        }
    }
}
