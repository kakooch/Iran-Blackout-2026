package com.google.android.gms.internal.p001authapiphone;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.0 */
/* loaded from: classes.dex */
public final class zzk extends zzb implements zzh {
    zzk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzh
    public final void zza(zzj zzjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzd.zza(parcelZza, zzjVar);
        zza(1, parcelZza);
    }
}
