package io.appmetrica.analytics.gpllibrary.internal;

import android.location.Location;
import android.location.LocationListener;
import ir.nasim.InterfaceC13497gK4;

/* loaded from: classes3.dex */
class GplOnSuccessListener implements InterfaceC13497gK4 {
    private final LocationListener a;

    GplOnSuccessListener(LocationListener locationListener) {
        this.a = locationListener;
    }

    @Override // ir.nasim.InterfaceC13497gK4
    public void onSuccess(Location location) {
        this.a.onLocationChanged(location);
    }
}
