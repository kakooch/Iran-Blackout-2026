package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes.dex */
public final class zzn extends zza implements zzo {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final Location zzd() throws RemoteException {
        Parcel parcelZzb = zzb(7, zza());
        Location location = (Location) zzc.zza(parcelZzb, Location.CREATOR);
        parcelZzb.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzh(LocationSettingsRequest locationSettingsRequest, zzs zzsVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, locationSettingsRequest);
        zzc.zze(parcelZza, zzsVar);
        parcelZza.writeString(null);
        zzc(63, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzj(LastLocationRequest lastLocationRequest, zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, lastLocationRequest);
        zzc.zze(parcelZza, zzqVar);
        zzc(82, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzk(zzdb zzdbVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzdbVar);
        zzc.zzd(parcelZza, locationRequest);
        zzc.zze(parcelZza, iStatusCallback);
        zzc(88, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzy(zzdb zzdbVar, IStatusCallback iStatusCallback) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzdbVar);
        zzc.zze(parcelZza, iStatusCallback);
        zzc(89, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzo
    public final void zzz(zzdf zzdfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzdfVar);
        zzc(59, parcelZza);
    }
}
