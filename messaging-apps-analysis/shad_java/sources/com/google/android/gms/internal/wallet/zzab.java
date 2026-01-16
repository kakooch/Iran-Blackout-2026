package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-wallet@@18.1.2 */
/* loaded from: classes3.dex */
final class zzab extends zzac {
    private final TaskCompletionSource<Boolean> zzfo;

    zzab(TaskCompletionSource<Boolean> taskCompletionSource) {
        this.zzfo = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.wallet.zzac, com.google.android.gms.internal.wallet.zzv
    public final void zza(int i, boolean z, Bundle bundle) {
        TaskUtil.setResultOrApiException(new Status(i), Boolean.valueOf(z), this.zzfo);
    }

    @Override // com.google.android.gms.internal.wallet.zzac, com.google.android.gms.internal.wallet.zzv
    public final void zza(Status status, boolean z, Bundle bundle) {
        TaskUtil.setResultOrApiException(status, Boolean.valueOf(z), this.zzfo);
    }
}
