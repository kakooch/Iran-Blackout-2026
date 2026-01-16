package io.appmetrica.analytics.modulesapi.internal.service;

import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/appmetrica/analytics/modulesapi/internal/service/LocationServiceExtension;", "", "locationConsumer", "Lio/appmetrica/analytics/coreapi/internal/backport/Consumer;", "Landroid/location/Location;", "getLocationConsumer", "()Lio/appmetrica/analytics/coreapi/internal/backport/Consumer;", "locationControllerAppStateToggle", "Lio/appmetrica/analytics/coreapi/internal/control/Toggle;", "getLocationControllerAppStateToggle", "()Lio/appmetrica/analytics/coreapi/internal/control/Toggle;", "locationSourcesController", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleLocationSourcesServiceController;", "getLocationSourcesController", "()Lio/appmetrica/analytics/modulesapi/internal/service/ModuleLocationSourcesServiceController;", "modules-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface LocationServiceExtension {
    Consumer<Location> getLocationConsumer();

    Toggle getLocationControllerAppStateToggle();

    ModuleLocationSourcesServiceController getLocationSourcesController();
}
