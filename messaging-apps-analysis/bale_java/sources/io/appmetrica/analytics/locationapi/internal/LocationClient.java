package io.appmetrica.analytics.locationapi.internal;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J=\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u0019\u0010\u001eJ\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001b\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010)\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lio/appmetrica/analytics/locationapi/internal/LocationClient;", "Lio/appmetrica/analytics/locationapi/internal/LocationControllerObserver;", "Landroid/content/Context;", "context", "Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;", "permissionExtractor", "Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;", "executor", "", "Lio/appmetrica/analytics/coreapi/internal/backport/Consumer;", "Landroid/location/Location;", "consumers", "Lir/nasim/rB7;", "init", "(Landroid/content/Context;Lio/appmetrica/analytics/coreapi/internal/system/PermissionExtractor;Lio/appmetrica/analytics/coreapi/internal/executors/IHandlerExecutor;Ljava/util/List;)V", "Lio/appmetrica/analytics/locationapi/internal/CacheArguments;", "cacheArguments", "updateCacheArguments", "(Lio/appmetrica/analytics/locationapi/internal/CacheArguments;)V", "Lio/appmetrica/analytics/locationapi/internal/LocationFilter;", "locationFilter", "updateLocationFilter", "(Lio/appmetrica/analytics/locationapi/internal/LocationFilter;)V", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProvider;", "lastKnownLocationExtractorProvider", "registerLocationSource", "(Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProvider;)V", "unregisterLocationSource", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProvider;", "locationReceiverProvider", "(Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProvider;)V", "Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "getLastKnownExtractorProviderFactory", "()Lio/appmetrica/analytics/locationapi/internal/LastKnownLocationExtractorProviderFactory;", "lastKnownExtractorProviderFactory", "Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "getLocationReceiverProviderFactory", "()Lio/appmetrica/analytics/locationapi/internal/LocationReceiverProviderFactory;", "locationReceiverProviderFactory", "getLocation", "()Landroid/location/Location;", "location", "location-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public interface LocationClient extends LocationControllerObserver {
    LastKnownLocationExtractorProviderFactory getLastKnownExtractorProviderFactory();

    Location getLocation();

    LocationReceiverProviderFactory getLocationReceiverProviderFactory();

    void init(Context context, PermissionExtractor permissionExtractor, IHandlerExecutor executor, List<? extends Consumer<Location>> consumers);

    void registerLocationSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider);

    void registerLocationSource(LocationReceiverProvider locationReceiverProvider);

    void unregisterLocationSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider);

    void unregisterLocationSource(LocationReceiverProvider locationReceiverProvider);

    void updateCacheArguments(CacheArguments cacheArguments);

    void updateLocationFilter(LocationFilter locationFilter);
}
