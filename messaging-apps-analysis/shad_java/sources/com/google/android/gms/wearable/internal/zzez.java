package com.google.android.gms.wearable.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;

/* loaded from: classes3.dex */
public final class zzez extends MessageClient {
    private final MessageApi zzei;

    public zzez(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zzei = new zzeu();
    }

    @Override // com.google.android.gms.wearable.MessageClient
    public final Task<Integer> sendMessage(String str, String str2, byte[] bArr) {
        return PendingResultUtil.toTask(this.zzei.sendMessage(asGoogleApiClient(), str, str2, bArr), zzfa.zzbx);
    }
}
