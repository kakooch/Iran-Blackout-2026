package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzd extends zza implements zzf {
    zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzf
    public final Bundle zzd(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, bundle);
        Parcel parcelZzz = zzz(1, parcelZza);
        Bundle bundle2 = (Bundle) zzc.zzc(parcelZzz, Bundle.CREATOR);
        parcelZzz.recycle();
        return bundle2;
    }
}
