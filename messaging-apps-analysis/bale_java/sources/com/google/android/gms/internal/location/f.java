package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* loaded from: classes3.dex */
final class f implements C2060d.b {
    final /* synthetic */ LocationAvailability a;

    f(h hVar, LocationAvailability locationAvailability) {
        this.a = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.C2060d.b
    public final /* synthetic */ void a(Object obj) {
        ((LocationCallback) obj).onLocationAvailability(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.C2060d.b
    public final void b() {
    }
}
