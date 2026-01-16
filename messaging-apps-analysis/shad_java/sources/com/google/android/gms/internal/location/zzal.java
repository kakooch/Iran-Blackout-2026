package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsRequest;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes.dex */
public final class zzal extends zza implements zzam {
    zzal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final Location zzm() throws RemoteException {
        Parcel parcelZzw = zzw(7, zza());
        Location location = (Location) zzc.zzb(parcelZzw, Location.CREATOR);
        parcelZzw.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final Location zzn(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzw = zzw(80, parcelZza);
        Location location = (Location) zzc.zzb(parcelZzw, Location.CREATOR);
        parcelZzw.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zzo(zzbc zzbcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzbcVar);
        zzx(59, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zzp(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zza(parcelZza, z);
        zzx(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zzt(LocationSettingsRequest locationSettingsRequest, zzao zzaoVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, locationSettingsRequest);
        zzc.zzd(parcelZza, zzaoVar);
        parcelZza.writeString(null);
        zzx(63, parcelZza);
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zzu(zzl zzlVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzc(parcelZza, zzlVar);
        zzx(75, parcelZza);
    }
}
