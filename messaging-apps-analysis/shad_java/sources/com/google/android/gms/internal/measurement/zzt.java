package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzt extends zza implements zzv {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zzd(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzc.zzd(parcelZza, bundle);
        parcelZza.writeLong(j);
        zzc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final int zze() throws RemoteException {
        Parcel parcelZzz = zzz(2, zza());
        int i = parcelZzz.readInt();
        parcelZzz.recycle();
        return i;
    }
}
