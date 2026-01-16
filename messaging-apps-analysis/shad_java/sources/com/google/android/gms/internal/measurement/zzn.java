package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzn extends zza implements zzp {
    zzn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j);
        zzc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zzd(parcelZza, bundle);
        zzc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeLong(j);
        zzc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void generateEventId(zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzsVar);
        zzc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getCachedAppInstanceId(zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzsVar);
        zzc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zze(parcelZza, zzsVar);
        zzc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getCurrentScreenClass(zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzsVar);
        zzc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getCurrentScreenName(zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzsVar);
        zzc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getGmpAppId(zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzsVar);
        zzc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc.zze(parcelZza, zzsVar);
        zzc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zzb(parcelZza, z);
        zzc.zze(parcelZza, zzsVar);
        zzc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void initialize(IObjectWrapper iObjectWrapper, zzy zzyVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zzd(parcelZza, zzyVar);
        parcelZza.writeLong(j);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zzd(parcelZza, bundle);
        zzc.zzb(parcelZza, z);
        zzc.zzb(parcelZza, z2);
        parcelZza.writeLong(j);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(5);
        parcelZza.writeString(str);
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, iObjectWrapper2);
        zzc.zze(parcelZza, iObjectWrapper3);
        zzc(33, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zzd(parcelZza, bundle);
        parcelZza.writeLong(j);
        zzc(27, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeLong(j);
        zzc(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeLong(j);
        zzc(29, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeLong(j);
        zzc(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzsVar, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zze(parcelZza, zzsVar);
        parcelZza.writeLong(j);
        zzc(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeLong(j);
        zzc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeLong(j);
        zzc(26, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void registerOnMeasurementEventListener(zzv zzvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, zzvVar);
        zzc(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, bundle);
        parcelZza.writeLong(j);
        zzc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zze(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        parcelZza.writeLong(j);
        zzc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, z);
        zzc(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzp
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zze(parcelZza, iObjectWrapper);
        zzc.zzb(parcelZza, z);
        parcelZza.writeLong(j);
        zzc(4, parcelZza);
    }
}
