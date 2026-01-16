package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.CapabilityApi;

/* loaded from: classes3.dex */
public final class zzo implements CapabilityApi {
    @Override // com.google.android.gms.wearable.CapabilityApi
    public final PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient googleApiClient, String str, int i) {
        boolean z = true;
        if (i != 0 && i != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return googleApiClient.enqueue(new zzp(this, googleApiClient, str, i));
    }
}
