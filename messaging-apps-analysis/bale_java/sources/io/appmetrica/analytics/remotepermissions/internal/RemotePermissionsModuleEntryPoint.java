package io.appmetrica.analytics.remotepermissions.internal;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider;
import io.appmetrica.analytics.modulesapi.internal.service.LocationServiceExtension;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServicesDatabase;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleEventServiceHandlerFactory;
import io.appmetrica.analytics.remotepermissions.impl.a;
import io.appmetrica.analytics.remotepermissions.impl.b;
import io.appmetrica.analytics.remotepermissions.impl.d;
import io.appmetrica.analytics.remotepermissions.impl.e;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC4597Fu6;
import ir.nasim.AbstractC4616Fw7;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00118\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lio/appmetrica/analytics/remotepermissions/internal/RemotePermissionsModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServiceEntryPoint;", "Lio/appmetrica/analytics/remotepermissions/impl/a;", "Lio/appmetrica/analytics/modulesapi/internal/common/AskForPermissionStrategyModuleProvider;", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigUpdateListener;", "<init>", "()V", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleRemoteConfig;", "config", "Lir/nasim/rB7;", "onRemoteConfigUpdated", "(Lio/appmetrica/analytics/modulesapi/internal/service/ModuleRemoteConfig;)V", "Lio/appmetrica/analytics/modulesapi/internal/service/ServiceContext;", "serviceContext", "initialConfig", "initServiceSide", "(Lio/appmetrica/analytics/modulesapi/internal/service/ServiceContext;Lio/appmetrica/analytics/modulesapi/internal/service/ModuleRemoteConfig;)V", "", "e", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/coreapi/internal/permission/PermissionStrategy;", "getAskForPermissionStrategy", "()Lio/appmetrica/analytics/coreapi/internal/permission/PermissionStrategy;", "askForPermissionStrategy", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "f", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "getRemoteConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "remoteConfigExtensionConfiguration", "Lio/appmetrica/analytics/modulesapi/internal/service/event/ModuleEventServiceHandlerFactory;", "moduleEventServiceHandlerFactory", "Lio/appmetrica/analytics/modulesapi/internal/service/event/ModuleEventServiceHandlerFactory;", "getModuleEventServiceHandlerFactory", "()Lio/appmetrica/analytics/modulesapi/internal/service/event/ModuleEventServiceHandlerFactory;", "Lio/appmetrica/analytics/modulesapi/internal/service/LocationServiceExtension;", "locationServiceExtension", "Lio/appmetrica/analytics/modulesapi/internal/service/LocationServiceExtension;", "getLocationServiceExtension", "()Lio/appmetrica/analytics/modulesapi/internal/service/LocationServiceExtension;", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServicesDatabase;", "moduleServicesDatabase", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServicesDatabase;", "getModuleServicesDatabase", "()Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServicesDatabase;", "remote-permissions_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class RemotePermissionsModuleEntryPoint implements ModuleServiceEntryPoint<a>, AskForPermissionStrategyModuleProvider, RemoteConfigUpdateListener<a> {
    private final d a = new d();
    private final b b = new b();
    private final RemotePermissionsModuleEntryPoint c = this;
    private final e d = new e();

    /* renamed from: e, reason: from kotlin metadata */
    private final String identifier = "rp";
    private final RemotePermissionsModuleEntryPoint$remoteConfigExtensionConfiguration$1 f = new RemoteConfigExtensionConfiguration<a>() { // from class: io.appmetrica.analytics.remotepermissions.internal.RemotePermissionsModuleEntryPoint$remoteConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Map<String, Integer> getBlocks() {
            return AbstractC19460qO3.g(AbstractC4616Fw7.a("permissions", 1));
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public List<String> getFeatures() {
            return AbstractC10360bX0.m();
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public JsonParser<a> getJsonParser() {
            return this.a.a;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Converter<a, byte[]> getProtobufConverter() {
            return this.a.b;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public RemoteConfigUpdateListener<a> getRemoteConfigUpdateListener() {
            return this.a.c;
        }
    };

    @Override // io.appmetrica.analytics.modulesapi.internal.common.AskForPermissionStrategyModuleProvider
    public PermissionStrategy getAskForPermissionStrategy() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public LocationServiceExtension getLocationServiceExtension() {
        return null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public ModuleEventServiceHandlerFactory getModuleEventServiceHandlerFactory() {
        return null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public ModuleServicesDatabase getModuleServicesDatabase() {
        return null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public RemoteConfigExtensionConfiguration<a> getRemoteConfigExtensionConfiguration() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public void initServiceSide(ServiceContext serviceContext, ModuleRemoteConfig<a> initialConfig) {
        Set setD;
        e eVar = this.d;
        a featuresConfig = initialConfig.getFeaturesConfig();
        if (featuresConfig == null || (setD = featuresConfig.a) == null) {
            setD = AbstractC4597Fu6.d();
        }
        synchronized (eVar) {
            eVar.a = setD;
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener
    public void onRemoteConfigUpdated(ModuleRemoteConfig<a> config) {
        Set setD;
        e eVar = this.d;
        a featuresConfig = config.getFeaturesConfig();
        if (featuresConfig == null || (setD = featuresConfig.a) == null) {
            setD = AbstractC4597Fu6.d();
        }
        synchronized (eVar) {
            eVar.a = setD;
        }
    }
}
