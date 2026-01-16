package com.google.android.gms.wallet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.wallet.zzaa;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
final class zzab extends TaskApiCall<zzaa, Boolean> {
    private final /* synthetic */ IsReadyToPayRequest zzdw;

    zzab(PaymentsClient paymentsClient, IsReadyToPayRequest isReadyToPayRequest) {
        this.zzdw = isReadyToPayRequest;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        ((zzaa) anyClient).zza(this.zzdw, taskCompletionSource);
    }
}
