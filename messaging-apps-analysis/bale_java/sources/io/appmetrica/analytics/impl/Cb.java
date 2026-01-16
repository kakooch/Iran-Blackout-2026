package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.locationapi.internal.CacheArguments;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProvider;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractorProviderFactory;
import io.appmetrica.analytics.locationapi.internal.LocationClient;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import io.appmetrica.analytics.locationapi.internal.LocationFilter;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProvider;
import io.appmetrica.analytics.locationapi.internal.LocationReceiverProviderFactory;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleLocationSourcesServiceController;

/* loaded from: classes3.dex */
public final class Cb implements Bb, InterfaceC2668kl {
    public final Context a;
    public final Fb b;
    public final LocationClient c;
    public final C2858sk d;
    public final C3001yj e;
    public final LastKnownLocationExtractorProviderFactory f;
    public final LocationReceiverProviderFactory g;

    public Cb(Context context, Fb fb, LocationClient locationClient) {
        this.a = context;
        this.b = fb;
        this.c = locationClient;
        Kb kb = new Kb();
        this.d = new C2858sk(new C2724n5(kb, C2586ha.h().m().getAskForPermissionStrategy()));
        this.e = C2586ha.h().m();
        ((Ib) fb).a(kb, true);
        ((Ib) fb).a(locationClient, true);
        this.f = locationClient.getLastKnownExtractorProviderFactory();
        this.g = locationClient.getLocationReceiverProviderFactory();
    }

    public final C2858sk a() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.Bb
    public final void b(Object obj) {
        ((Ib) this.b).a(obj);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final LastKnownLocationExtractorProviderFactory getLastKnownExtractorProviderFactory() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.impl.Bb, io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final Location getLocation() {
        return this.c.getLocation();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final LocationReceiverProviderFactory getLocationReceiverProviderFactory() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final PermissionExtractor getPermissionExtractor() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.impl.Bb
    public final void init() {
        this.c.init(this.a, this.d, C2586ha.C.d.c(), this.e.d());
        ModuleLocationSourcesServiceController moduleLocationSourcesServiceControllerE = this.e.e();
        if (moduleLocationSourcesServiceControllerE != null) {
            moduleLocationSourcesServiceControllerE.init();
        } else {
            LocationClient locationClient = this.c;
            locationClient.registerLocationSource(locationClient.getLastKnownExtractorProviderFactory().getGplLastKnownLocationExtractorProvider());
            LocationClient locationClient2 = this.c;
            locationClient2.registerLocationSource(locationClient2.getLastKnownExtractorProviderFactory().getNetworkLastKnownLocationExtractorProvider());
        }
        ((Ib) this.b).a(this.e.f());
        C2586ha.C.u.a(this);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerControllerObserver(LocationControllerObserver locationControllerObserver) {
        ((Ib) this.b).a(locationControllerObserver, true);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        this.c.registerLocationSource(lastKnownLocationExtractorProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LastKnownLocationExtractorProvider lastKnownLocationExtractorProvider) {
        this.c.unregisterLocationSource(lastKnownLocationExtractorProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void updateLocationFilter(LocationFilter locationFilter) {
        this.c.updateLocationFilter(locationFilter);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2668kl
    public final void a(C2549fl c2549fl) {
        C2889u3 c2889u3 = c2549fl.y;
        if (c2889u3 != null) {
            long j = c2889u3.a;
            this.c.updateCacheArguments(new CacheArguments(j, 2 * j));
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void registerSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.registerLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi
    public final void unregisterSource(LocationReceiverProvider locationReceiverProvider) {
        this.c.unregisterLocationSource(locationReceiverProvider);
    }

    @Override // io.appmetrica.analytics.impl.Bb
    public final void a(Object obj) {
        ((Ib) this.b).b(obj);
    }

    @Override // io.appmetrica.analytics.impl.Bb
    public final void a(boolean z) {
        ((Ib) this.b).a(z);
    }
}
