package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.C2060d;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes3.dex */
final class e implements C2060d.b {
    final /* synthetic */ LocationResult a;

    e(h hVar, LocationResult locationResult) {
        this.a = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.C2060d.b
    public final /* synthetic */ void a(Object obj) {
        ((LocationCallback) obj).onLocationResult(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.C2060d.b
    public final void b() {
    }
}
