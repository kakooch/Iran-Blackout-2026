package com.google.android.gms.wearable;

import android.os.Parcelable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.wearable.Wearable;

/* loaded from: classes3.dex */
public abstract class ChannelClient extends GoogleApi<Wearable.WearableOptions> {

    public interface Channel extends Parcelable {
    }

    public static abstract class ChannelCallback {
        public void onChannelClosed(Channel channel, int i, int i2) {
            throw null;
        }

        public void onChannelOpened(Channel channel) {
            throw null;
        }

        public void onInputClosed(Channel channel, int i, int i2) {
            throw null;
        }

        public void onOutputClosed(Channel channel, int i, int i2) {
            throw null;
        }
    }
}
