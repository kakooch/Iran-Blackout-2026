package com.google.android.exoplayer2t.util;

import com.google.android.exoplayer2t.PlaybackParameters;

/* loaded from: classes.dex */
public interface MediaClock {
    PlaybackParameters getPlaybackParameters();

    long getPositionUs();

    void setPlaybackParameters(PlaybackParameters playbackParameters);
}
