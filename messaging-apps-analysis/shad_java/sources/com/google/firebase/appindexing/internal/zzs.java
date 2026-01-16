package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.icing.zzaa;
import com.google.android.gms.internal.icing.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
abstract class zzs extends TaskApiCall<zzah, Void> implements BaseImplementation$ResultHolder<Status> {
    private TaskCompletionSource<Void> zza;

    zzs() {
        super(null, false, 9004);
    }

    protected abstract void zza(zzaa zzaaVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.zza = taskCompletionSource;
        zza((zzaa) ((zzah) anyClient).getService());
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        if (status.isSuccess()) {
            this.zza.setResult(null);
        } else {
            this.zza.setException(zzae.zza(status, "User Action indexing error, please try again."));
        }
    }
}
