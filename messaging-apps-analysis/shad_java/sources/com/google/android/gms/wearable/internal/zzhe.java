package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.wearable.MessageApi;

/* loaded from: classes3.dex */
final class zzhe extends zzgm<MessageApi.SendMessageResult> {
    public zzhe(BaseImplementation$ResultHolder<MessageApi.SendMessageResult> baseImplementation$ResultHolder) {
        super(baseImplementation$ResultHolder);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzek
    public final void zza(zzga zzgaVar) {
        zza((zzhe) new zzey(zzgd.zzb(zzgaVar.statusCode), zzgaVar.zzeh));
    }
}
