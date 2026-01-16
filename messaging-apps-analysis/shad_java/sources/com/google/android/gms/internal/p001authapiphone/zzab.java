package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.0 */
/* loaded from: classes.dex */
final class zzab extends zzm {
    private final /* synthetic */ TaskCompletionSource zza;

    zzab(zzaa zzaaVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzj
    public final void zza(Status status) {
        TaskUtil.setResultOrApiException(status, this.zza);
    }
}
