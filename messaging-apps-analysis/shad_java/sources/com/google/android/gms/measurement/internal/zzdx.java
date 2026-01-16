package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzdx extends com.google.android.gms.internal.measurement.zza implements zzdz {
    zzdx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzd(zzas zzasVar, zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzasVar);
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zze(zzkg zzkgVar, zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzkgVar);
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzf(zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(4, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzh(zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final byte[] zzj(zzas zzasVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzasVar);
        parcelZza.writeString(str);
        Parcel parcelZzz = zzz(9, parcelZza);
        byte[] bArrCreateByteArray = parcelZzz.createByteArray();
        parcelZzz.recycle();
        return bArrCreateByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzk(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final String zzl(zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        Parcel parcelZzz = zzz(11, parcelZza);
        String string = parcelZzz.readString();
        parcelZzz.recycle();
        return string;
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzm(zzaa zzaaVar, zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzaaVar);
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(12, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzkg> zzo(String str, String str2, boolean z, zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        com.google.android.gms.internal.measurement.zzc.zzb(parcelZza, z);
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        Parcel parcelZzz = zzz(14, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzz.createTypedArrayList(zzkg.CREATOR);
        parcelZzz.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzkg> zzp(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        com.google.android.gms.internal.measurement.zzc.zzb(parcelZza, z);
        Parcel parcelZzz = zzz(15, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzz.createTypedArrayList(zzkg.CREATOR);
        parcelZzz.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzaa> zzq(String str, String str2, zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        Parcel parcelZzz = zzz(16, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzz.createTypedArrayList(zzaa.CREATOR);
        parcelZzz.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final List<zzaa> zzr(String str, String str2, String str3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        parcelZza.writeString(str2);
        parcelZza.writeString(str3);
        Parcel parcelZzz = zzz(17, parcelZza);
        ArrayList arrayListCreateTypedArrayList = parcelZzz.createTypedArrayList(zzaa.CREATOR);
        parcelZzz.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzs(zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(18, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzt(Bundle bundle, zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, bundle);
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.measurement.internal.zzdz
    public final void zzu(zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.measurement.zzc.zzd(parcelZza, zzpVar);
        zzc(20, parcelZza);
    }
}
