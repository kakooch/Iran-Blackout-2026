package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import ir.nasim.F35;
import java.util.Calendar;

/* loaded from: classes.dex */
class l {
    private static l d;
    private final Context a;
    private final LocationManager b;
    private final a c = new a();

    private static class a {
        boolean a;
        long b;

        a() {
        }
    }

    l(Context context, LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }

    static l a(Context context) {
        if (d == null) {
            Context applicationContext = context.getApplicationContext();
            d = new l(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return d;
    }

    private Location b() {
        Location locationC = F35.c(this.a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = F35.c(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.b.isProviderEnabled(str)) {
                return this.b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean e() {
        return this.c.b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j;
        a aVar = this.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        k kVarB = k.b();
        kVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        kVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = kVarB.c == 1;
        long j2 = kVarB.b;
        long j3 = kVarB.a;
        kVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j4 = kVarB.b;
        if (j2 == -1 || j3 == -1) {
            j = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis <= j3) {
                j4 = jCurrentTimeMillis > j2 ? j3 : j2;
            }
            j = j4 + 60000;
        }
        aVar.a = z;
        aVar.b = j;
    }

    boolean d() {
        a aVar = this.c;
        if (e()) {
            return aVar.a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
