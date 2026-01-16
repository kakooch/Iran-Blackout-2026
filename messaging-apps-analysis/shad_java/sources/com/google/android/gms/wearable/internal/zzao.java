package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;

/* loaded from: classes3.dex */
public final class zzao extends ChannelClient {
    /* JADX INFO: Access modifiers changed from: private */
    public static zzay zza(Channel channel) {
        Preconditions.checkNotNull(channel, "channel must not be null");
        return (zzay) channel;
    }
}
