package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.PaymentData;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
final class zzad extends zzac {
    private final TaskCompletionSource<PaymentData> zzfo;

    public zzad(TaskCompletionSource<PaymentData> taskCompletionSource) {
        this.zzfo = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.wallet.zzac, com.google.android.gms.internal.wallet.zzv
    public final void zza(Status status, PaymentData paymentData, Bundle bundle) {
        AutoResolveHelper.zza(status, paymentData, this.zzfo);
    }
}
