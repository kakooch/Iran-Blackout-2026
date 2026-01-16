package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zax implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult zaa;
    private final /* synthetic */ zav zab;

    zax(zav zavVar, BasePendingResult basePendingResult) {
        this.zab = zavVar;
        this.zaa = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
