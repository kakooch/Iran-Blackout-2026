package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.zae;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zaam implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final /* synthetic */ zaaf zaa;

    private zaam(zaaf zaafVar) {
        this.zaa = zaafVar;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ((zae) Preconditions.checkNotNull(this.zaa.zak)).zaa(new zaak(this.zaa));
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.zab.lock();
        try {
            if (!this.zaa.zaa(connectionResult)) {
                this.zaa.zab(connectionResult);
            } else {
                this.zaa.zag();
                this.zaa.zae();
            }
        } finally {
            this.zaa.zab.unlock();
        }
    }

    /* synthetic */ zaam(zaaf zaafVar, zaae zaaeVar) {
        this(zaafVar);
    }
}
