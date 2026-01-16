package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
abstract class zac<T> extends zad {
    protected final TaskCompletionSource<T> zab;

    public zac(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zab = taskCompletionSource;
    }

    protected abstract void zab(GoogleApiManager.zaa<?> zaaVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(Status status) {
        this.zab.trySetException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public void zaa(Exception exc) {
        this.zab.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final void zaa(GoogleApiManager.zaa<?> zaaVar) throws DeadObjectException {
        try {
            zab(zaaVar);
        } catch (DeadObjectException e) {
            zaa(zab.zab(e));
            throw e;
        } catch (RemoteException e2) {
            zaa(zab.zab(e2));
        } catch (RuntimeException e3) {
            zaa(e3);
        }
    }
}
