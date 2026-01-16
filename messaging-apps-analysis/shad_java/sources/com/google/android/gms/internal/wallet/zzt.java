package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
public interface zzt extends IInterface {
    void zza(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzv zzvVar) throws RemoteException;

    void zza(PaymentDataRequest paymentDataRequest, Bundle bundle, zzv zzvVar) throws RemoteException;
}
