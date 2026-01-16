package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import ir.nasim.Bo8;
import ir.nasim.InterfaceC20883sl8;

/* loaded from: classes3.dex */
final class i4 implements Bo8 {
    public final InterfaceC20883sl8 a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    i4(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC20883sl8 interfaceC20883sl8) {
        this.b = appMeasurementDynamiteService;
        this.a = interfaceC20883sl8;
    }

    @Override // ir.nasim.Bo8
    public final void a(String str, String str2, Bundle bundle, long j) {
        try {
            this.a.b(str, str2, bundle, j);
        } catch (RemoteException e) {
            H1 h1 = this.b.a;
            if (h1 != null) {
                h1.b().w().b("Event interceptor threw exception", e);
            }
        }
    }
}
