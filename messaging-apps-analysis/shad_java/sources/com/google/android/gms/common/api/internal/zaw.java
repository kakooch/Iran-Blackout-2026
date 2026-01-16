package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Add missing generic type declarations: [TResult] */
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zaw<TResult> implements OnCompleteListener<TResult> {
    private final /* synthetic */ TaskCompletionSource zaa;
    private final /* synthetic */ zav zab;

    zaw(zav zavVar, TaskCompletionSource taskCompletionSource) {
        this.zab = zavVar;
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<TResult> task) {
        this.zab.zab.remove(this.zaa);
    }
}
