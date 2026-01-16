package io.appmetrica.analytics.location.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionResolutionStrategy;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor;

/* loaded from: classes3.dex */
public class u implements LastKnownLocationExtractor {
    public final Context a;
    public final PermissionResolutionStrategy b;
    public final LocationListener c;
    public final String d;

    public u(Context context, PermissionResolutionStrategy permissionResolutionStrategy, LocationListener locationListener, String str) {
        this.a = context;
        this.b = permissionResolutionStrategy;
        this.c = locationListener;
        this.d = str;
    }

    public final Context a() {
        return this.a;
    }

    public final LocationListener b() {
        return this.c;
    }

    public final PermissionResolutionStrategy c() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.locationapi.internal.LastKnownLocationExtractor
    public final void updateLastKnownLocation() {
        if (this.b.hasNecessaryPermissions(this.a)) {
            Location location = (Location) SystemServiceUtils.accessSystemServiceByNameSafely(this.a, "location", "getting last known location for provider " + this.d, "location manager", new FunctionWithThrowable() { // from class: ir.nasim.Ce8
                @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
                public final Object apply(Object obj) {
                    return io.appmetrica.analytics.location.impl.u.a(this.a, (LocationManager) obj);
                }
            });
            if (location != null) {
                this.c.onLocationChanged(location);
            }
        }
    }

    public static final Location a(u uVar, LocationManager locationManager) {
        return locationManager.getLastKnownLocation(uVar.d);
    }
}
