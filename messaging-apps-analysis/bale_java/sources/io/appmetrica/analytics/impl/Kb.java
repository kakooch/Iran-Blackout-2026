package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import ir.nasim.AbstractC10360bX0;
import java.util.List;

/* loaded from: classes3.dex */
public final class Kb implements PermissionStrategy, LocationControllerObserver {
    public static final Jb b = new Jb();
    public static final List c = AbstractC10360bX0.p("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
    public volatile boolean a;

    @Override // io.appmetrica.analytics.coreapi.internal.permission.PermissionStrategy
    public final boolean forbidUsePermission(String str) {
        if (c.contains(str)) {
            return !this.a;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final void startLocationTracking() {
        this.a = true;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LocationControllerObserver
    public final void stopLocationTracking() {
        this.a = false;
    }

    public final String toString() {
        return "LocationFlagStrategy(enabled=" + this.a + ", locationPermissions=" + c + ')';
    }
}
