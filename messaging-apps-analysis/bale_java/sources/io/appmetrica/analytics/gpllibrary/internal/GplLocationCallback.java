package io.appmetrica.analytics.gpllibrary.internal;

import android.location.LocationListener;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes3.dex */
class GplLocationCallback extends LocationCallback {
    private final LocationListener a;

    GplLocationCallback(LocationListener locationListener) {
        this.a = locationListener;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public void onLocationResult(LocationResult locationResult) {
        this.a.onLocationChanged(locationResult.P());
    }
}
