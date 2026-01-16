package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.LocationManager;

/* renamed from: io.appmetrica.analytics.impl.y2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2984y2 {
    public final LocationManager a;

    public C2984y2(Context context) {
        this((LocationManager) context.getSystemService("location"));
    }

    public C2984y2(LocationManager locationManager) {
        this.a = locationManager;
    }
}
