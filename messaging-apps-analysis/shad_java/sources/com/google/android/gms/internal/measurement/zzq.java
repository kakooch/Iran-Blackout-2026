package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzq extends zza implements zzs {
    zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, bundle);
        zzc(1, parcelZza);
    }
}
