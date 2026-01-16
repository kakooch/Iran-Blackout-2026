package com.google.android.gms.wearable;

@Deprecated
/* loaded from: classes3.dex */
public interface ChannelApi$ChannelListener {
    void onChannelClosed(Channel channel, int i, int i2);

    void onChannelOpened(Channel channel);

    void onInputClosed(Channel channel, int i, int i2);

    void onOutputClosed(Channel channel, int i, int i2);
}
