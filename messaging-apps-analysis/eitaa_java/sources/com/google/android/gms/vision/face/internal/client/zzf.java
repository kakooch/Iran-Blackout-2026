package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzm;

/* loaded from: classes.dex */
public final class zzf extends com.google.android.gms.internal.vision.zza implements zze {
    zzf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zze
    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzm zzmVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        com.google.android.gms.internal.vision.zzc.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        com.google.android.gms.internal.vision.zzc.zza(parcelObtainAndWriteInterfaceToken, zzmVar);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelTransactAndReadException.createTypedArray(FaceParcel.CREATOR);
        parcelTransactAndReadException.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zze
    public final void zzn() throws RemoteException {
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken());
    }
}
