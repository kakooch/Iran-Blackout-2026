package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zan implements Runnable {
    final /* synthetic */ zal zaa;
    private final zak zab;

    zan(zal zalVar, zak zakVar) {
        this.zaa = zalVar;
        this.zab = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult connectionResultZab = this.zab.zab();
            if (connectionResultZab.hasResolution()) {
                zal zalVar = this.zaa;
                zalVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zalVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(connectionResultZab.getResolution()), this.zab.zaa(), false), 1);
                return;
            }
            zal zalVar2 = this.zaa;
            if (zalVar2.zac.getErrorResolutionIntent(zalVar2.getActivity(), connectionResultZab.getErrorCode(), null) != null) {
                zal zalVar3 = this.zaa;
                zalVar3.zac.zaa(zalVar3.getActivity(), this.zaa.mLifecycleFragment, connectionResultZab.getErrorCode(), 2, this.zaa);
            } else {
                if (connectionResultZab.getErrorCode() == 18) {
                    Dialog dialogZaa = GoogleApiAvailability.zaa(this.zaa.getActivity(), this.zaa);
                    zal zalVar4 = this.zaa;
                    zalVar4.zac.zaa(zalVar4.getActivity().getApplicationContext(), new zam(this, dialogZaa));
                    return;
                }
                this.zaa.zaa(connectionResultZab, this.zab.zaa());
            }
        }
    }
}
