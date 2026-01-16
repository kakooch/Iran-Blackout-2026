package com.google.android.gms.internal.p001authapiphone;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.0 */
/* loaded from: classes.dex */
public final class zzaa extends SmsRetrieverClient {
    public zzaa(Context context) {
        super(context);
    }

    @Override // com.google.android.gms.auth.api.phone.SmsRetrieverClient
    public final Task<Void> startSmsRetriever() {
        return doWrite(TaskApiCall.builder().run(new RemoteCall(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzz
            private final zzaa zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                ((zzh) ((zzx) obj).getService()).zza(new zzab(this.zza, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzad.zzc).build());
    }
}
