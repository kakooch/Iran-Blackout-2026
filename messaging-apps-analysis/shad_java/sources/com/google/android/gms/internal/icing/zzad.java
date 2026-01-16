package com.google.android.gms.internal.icing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes.dex */
public final class zzad extends zzb implements zzaa {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    }

    @Override // com.google.android.gms.internal.icing.zzaa
    public final void zza(zzac zzacVar, com.google.firebase.appindexing.internal.zza[] zzaVarArr) throws RemoteException {
        Parcel parcelZza = zza();
        zzd.zza(parcelZza, zzacVar);
        parcelZza.writeTypedArray(zzaVarArr, 0);
        zzb(7, parcelZza);
    }
}
