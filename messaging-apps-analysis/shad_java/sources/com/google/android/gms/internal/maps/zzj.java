package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.gms:play-services-maps@@17.0.1 */
/* loaded from: classes.dex */
public final class zzj extends zza implements zzl {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzd() throws RemoteException {
        zzc(1, zza());
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzf(LatLng latLng) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, latLng);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzh(double d) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeDouble(d);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final double zzi() throws RemoteException {
        Parcel parcelZzH = zzH(6, zza());
        double d = parcelZzH.readDouble();
        parcelZzH.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzl(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final void zzn(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final boolean zzt(zzl zzlVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, zzlVar);
        Parcel parcelZzH = zzH(17, parcelZza);
        boolean zZza = zzc.zza(parcelZzH);
        parcelZzH.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.maps.zzl
    public final int zzu() throws RemoteException {
        Parcel parcelZzH = zzH(18, zza());
        int i = parcelZzH.readInt();
        parcelZzH.recycle();
        return i;
    }
}
