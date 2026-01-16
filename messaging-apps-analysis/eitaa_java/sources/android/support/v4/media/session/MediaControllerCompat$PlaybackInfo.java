package android.support.v4.media.session;

import androidx.media.AudioAttributesCompat;

/* loaded from: classes.dex */
public final class MediaControllerCompat$PlaybackInfo {
    private final AudioAttributesCompat mAudioAttrsCompat;
    private final int mCurrentVolume;
    private final int mMaxVolume;
    private final int mPlaybackType;
    private final int mVolumeControl;

    MediaControllerCompat$PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
        this(i, new AudioAttributesCompat.Builder().setLegacyStreamType(i2).build(), i3, i4, i5);
    }

    MediaControllerCompat$PlaybackInfo(int i, AudioAttributesCompat audioAttributesCompat, int i2, int i3, int i4) {
        this.mPlaybackType = i;
        this.mAudioAttrsCompat = audioAttributesCompat;
        this.mVolumeControl = i2;
        this.mMaxVolume = i3;
        this.mCurrentVolume = i4;
    }
}
