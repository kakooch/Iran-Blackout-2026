package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public final class zzw extends zzb implements zzt {
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wallet.internal.IOwService");
    }

    @Override // com.google.android.gms.internal.wallet.zzt
    public final void zza(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzv zzvVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(parcelObtainAndWriteInterfaceToken, isReadyToPayRequest);
        zzd.zza(parcelObtainAndWriteInterfaceToken, bundle);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzvVar);
        zza(14, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.wallet.zzt
    public final void zza(PaymentDataRequest paymentDataRequest, Bundle bundle, zzv zzvVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(parcelObtainAndWriteInterfaceToken, paymentDataRequest);
        zzd.zza(parcelObtainAndWriteInterfaceToken, bundle);
        zzd.zza(parcelObtainAndWriteInterfaceToken, zzvVar);
        zza(19, parcelObtainAndWriteInterfaceToken);
    }
}
