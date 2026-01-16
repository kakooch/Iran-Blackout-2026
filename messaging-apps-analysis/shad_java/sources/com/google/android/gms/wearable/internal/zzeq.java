package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.wearable.zzc;

/* loaded from: classes3.dex */
public final class zzeq extends com.google.android.gms.internal.wearable.zza implements zzep {
    zzeq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wearable.internal.IWearableService");
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzekVar, String str, String str2, byte[] bArr) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzekVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeString(str2);
        parcelObtainAndWriteInterfaceToken.writeByteArray(bArr);
        transactAndReadExceptionReturnVoid(12, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzekVar, String str, int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzekVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        transactAndReadExceptionReturnVoid(42, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzekVar, zzd zzdVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzekVar);
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzdVar);
        transactAndReadExceptionReturnVoid(16, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzc(zzek zzekVar, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzekVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(32, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zza(zzek zzekVar, zzei zzeiVar, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzekVar);
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzeiVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(34, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.wearable.internal.zzep
    public final void zzb(zzek zzekVar, zzei zzeiVar, String str) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzekVar);
        zzc.zza(parcelObtainAndWriteInterfaceToken, zzeiVar);
        parcelObtainAndWriteInterfaceToken.writeString(str);
        transactAndReadExceptionReturnVoid(35, parcelObtainAndWriteInterfaceToken);
    }
}
