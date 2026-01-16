package io.appmetrica.analytics.location.internal;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.location.impl.g;
import io.appmetrica.analytics.location.impl.i;
import io.appmetrica.analytics.location.impl.j;
import io.appmetrica.analytics.location.impl.k;
import io.appmetrica.analytics.location.impl.o;
import io.appmetrica.analytics.location.impl.p;
import io.appmetrica.analytics.location.impl.q;
import io.appmetrica.analytics.locationapi.internal.CacheArguments;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory;
import io.appmetrica.analytics.locationapi.internal.LocationClient;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001b\u0010 J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001d\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u0003R\u001a\u0010(\u001a\u00020#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010.\u001a\u00020)8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lio/appmetrica/analytics/location/internal/LocationClientImpl;", "Lio/appmetrica/analytics/locationapi/internal/LocationClient;", "<init>", "()V", "Landroid/content/Context;", "context", "Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;", "permissionExtractor", "Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;", "executor", "", "Lio/appmetrica/analytics/coreapi/internal/backport/Consumer;", "Landroid/location/Location;", "consumers", "Lir/nasim/rB7;", "init", "(Landroid/content/Context;Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;Ljava/util/List;)V", "Lio/appmetrica/analytics/locationapi/internal/CacheArguments;", "cacheArguments", "updateCacheArguments", "(Lio/appmetrica/analytics/locationapi/internal/CacheArguments;)V", "Lio/appmetrica/analytics/locationapi/internal/LocationFilter;", "locationFilter", "updateLocationFilter", "(Lio/appmetrica/analytics/locationapi/internal/LocationFilter;)V", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProvider;", "lastKnownLocationExtractorProvider", "registerLocationSource", "(Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProvider;)V", "unregisterLocationSource", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProvider;", "locationReceiverProvider", "(Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProvider;)V", "startLocationTracking", "stopLocationTracking", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "b", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "getLastKnownExtractorProviderFactory", "()Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "lastKnownExtractorProviderFactory", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "c", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "getLocationReceiverProviderFactory", "()Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "locationReceiverProviderFactory", "getLocation", "()Landroid/location/Location;", "location", "location_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class LocationClientImpl implements LocationClient {
    private k a;
    private final g b;
    private final o c;
    private i d;

    public LocationClientImpl() {
        q qVar = new q();
        this.b = new g(qVar);
        this.c = new o(qVar);
        this.d = new i();
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public LastKnownLocationExtractorProviderFactory getLastKnownExtractorProviderFactory() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized Location getLocation() {
        k kVar;
        kVar = this.a;
        return kVar != null ? kVar.a() : null;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public LocationReceiverProviderFactory getLocationReceiverProviderFactory() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void init(Context context, PermissionExtractor permissionExtractor, IHandlerExecutor executor, List<? extends Consumer<Location>> consumers) {
        if (this.a == null) {
            this.a = new k(context, permissionExtractor, executor, new p(consumers, this.d));
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void registerLocationSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(lastKnownLocationExtractorProvider);
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public synchronized void startLocationTracking() {
        k kVar = this.a;
        if (kVar != null) {
            kVar.startLocationTracking();
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public synchronized void stopLocationTracking() {
        k kVar = this.a;
        if (kVar != null) {
            kVar.stopLocationTracking();
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void unregisterLocationSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.b(lastKnownLocationExtractorProvider);
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void updateCacheArguments(CacheArguments cacheArguments) {
        i iVar = new i(this.d.a, cacheArguments);
        this.d = iVar;
        k kVar = this.a;
        if (kVar != null) {
            kVar.d.execute(new j(kVar, iVar));
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void updateLocationFilter(LocationFilter locationFilter) {
        i iVar = new i(locationFilter, this.d.b);
        this.d = iVar;
        k kVar = this.a;
        if (kVar != null) {
            kVar.d.execute(new j(kVar, iVar));
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void registerLocationSource(LocationReceiverProvider locationReceiverProvider) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(locationReceiverProvider);
        }
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationClient
    public synchronized void unregisterLocationSource(LocationReceiverProvider locationReceiverProvider) {
        k kVar = this.a;
        if (kVar != null) {
            kVar.b(locationReceiverProvider);
        }
    }
}
