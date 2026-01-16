package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.b;
import ir.nasim.Gm8;

/* loaded from: classes3.dex */
public final class Z0 extends com.google.android.gms.common.internal.b {
    public Z0(Context context, Looper looper, b.a aVar, b.InterfaceC0173b interfaceC0173b) {
        super(context, looper, 93, aVar, interfaceC0173b, null);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String E() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String F() {
        return "com.google.android.gms.measurement.START";
    }

    @Override // com.google.android.gms.common.internal.b, com.google.android.gms.common.api.a.f
    public final int n() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.b
    public final /* synthetic */ IInterface s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof Gm8 ? (Gm8) iInterfaceQueryLocalInterface : new T0(iBinder);
    }
}
