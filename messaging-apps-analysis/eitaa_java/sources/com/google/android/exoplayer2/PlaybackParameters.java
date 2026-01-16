package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    public PlaybackParameters(float speed) {
        this(speed, 1.0f, false);
    }

    public PlaybackParameters(float speed, float pitch) {
        this(speed, pitch, false);
    }

    public PlaybackParameters(float speed, float pitch, boolean skipSilence) {
        Assertions.checkArgument(speed > 0.0f);
        Assertions.checkArgument(pitch > 0.0f);
        this.speed = speed;
        this.pitch = pitch;
        this.skipSilence = skipSilence;
        this.scaledUsPerMs = Math.round(speed * 1000.0f);
    }

    public long getMediaTimeUsForPlayoutTimeMs(long timeMs) {
        return timeMs * this.scaledUsPerMs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        return this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch && this.skipSilence == playbackParameters.skipSilence;
    }

    public int hashCode() {
        return ((((527 + Float.floatToRawIntBits(this.speed)) * 31) + Float.floatToRawIntBits(this.pitch)) * 31) + (this.skipSilence ? 1 : 0);
    }
}
