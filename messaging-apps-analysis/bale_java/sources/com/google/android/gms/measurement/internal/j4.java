package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import ir.nasim.Do8;
import ir.nasim.InterfaceC20883sl8;

/* loaded from: classes3.dex */
final class j4 implements Do8 {
    public final InterfaceC20883sl8 a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    j4(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC20883sl8 interfaceC20883sl8) {
        this.b = appMeasurementDynamiteService;
        this.a = interfaceC20883sl8;
    }

    @Override // ir.nasim.Do8
    public final void a(String str, String str2, Bundle bundle, long j) {
        try {
            this.a.b(str, str2, bundle, j);
        } catch (RemoteException e) {
            H1 h1 = this.b.a;
            if (h1 != null) {
                h1.b().w().b("Event listener threw exception", e);
            }
        }
    }
}
