package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
final class zacy implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zada zab;

    zacy(zada zadaVar, Result result) {
        this.zab = zadaVar;
        this.zaa = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                BasePendingResult.zaa.set(Boolean.TRUE);
                ((ResultTransform) Preconditions.checkNotNull(this.zab.zaa)).onSuccess(this.zaa);
                zada zadaVar = this.zab;
                zacz unused = zadaVar.zah;
                zacz unused2 = zadaVar.zah;
                throw null;
            } catch (RuntimeException unused3) {
                zada zadaVar2 = this.zab;
                zacz unused4 = zadaVar2.zah;
                zacz unused5 = zadaVar2.zah;
                throw null;
            }
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada zadaVar3 = this.zab;
            zada.zan(this.zaa);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zab.zag.get();
            if (googleApiClient != null) {
                googleApiClient.zap(this.zab);
            }
            throw th;
        }
    }
}
