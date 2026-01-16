package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.icing.zzaa;
import com.google.android.gms.internal.icing.zzaj;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
final class zzq extends zzs {
    private final /* synthetic */ zza[] zza;

    zzq(zzr zzrVar, zza[] zzaVarArr) {
        this.zza = zzaVarArr;
    }

    @Override // com.google.firebase.appindexing.internal.zzs
    protected final void zza(zzaa zzaaVar) throws RemoteException {
        zzaaVar.zza(new zzaj.zzc(this), this.zza);
    }
}
