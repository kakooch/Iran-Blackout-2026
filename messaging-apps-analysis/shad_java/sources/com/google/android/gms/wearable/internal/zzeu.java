package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.MessageApi;

/* loaded from: classes3.dex */
public final class zzeu implements MessageApi {
    @Override // com.google.android.gms.wearable.MessageApi
    public final PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        return googleApiClient.enqueue(new zzev(this, googleApiClient, str, str2, bArr));
    }
}
