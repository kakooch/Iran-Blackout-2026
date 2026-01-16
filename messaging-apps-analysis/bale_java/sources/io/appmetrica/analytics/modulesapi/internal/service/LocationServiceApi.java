package io.appmetrica.analytics.modulesapi.internal.service;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/LocationServiceApi;", "", "Lio/appmetrica/analytics/locationapi/internal/LocationControllerObserver;", "locationControllerObserver", "Lir/nasim/rB7;", "registerControllerObserver", "(Lio/appmetrica/analytics/locationapi/internal/LocationControllerObserver;)V", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProvider;", "lastKnownLocationExtractorProvider", "registerSource", "(Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProvider;)V", "unregisterSource", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProvider;", "locationReceiverProvider", "(Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProvider;)V", "Lio/appmetrica/analytics/locationapi/internal/LocationFilter;", "locationFilter", "updateLocationFilter", "(Lio/appmetrica/analytics/locationapi/internal/LocationFilter;)V", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;", "getPermissionExtractor", "()Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;", "permissionExtractor", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "getLastKnownExtractorProviderFactory", "()Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "lastKnownExtractorProviderFactory", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "getLocationReceiverProviderFactory", "()Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "locationReceiverProviderFactory", "modules-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface LocationServiceApi {
    LastKnownLocationExtractorProviderFactory getLastKnownExtractorProviderFactory();

    Location getLocation();

    LocationReceiverProviderFactory getLocationReceiverProviderFactory();

    PermissionExtractor getPermissionExtractor();

    void registerControllerObserver(LocationControllerObserver locationControllerObserver);

    void registerSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider);

    void registerSource(LocationReceiverProvider locationReceiverProvider);

    void unregisterSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider);

    void unregisterSource(LocationReceiverProvider locationReceiverProvider);

    void updateLocationFilter(LocationFilter locationFilter);
}
