package com.google.android.gms.wearable;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable;

/* loaded from: classes3.dex */
public abstract class CapabilityClient extends GoogleApi<Wearable.WearableOptions> {
    public CapabilityClient(Context context, GoogleApi.Settings settings) {
        super(context, Wearable.API, (Api.ApiOptions) null, settings);
    }

    public abstract Task<CapabilityInfo> getCapability(String str, int i);
}
