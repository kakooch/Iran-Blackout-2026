package org.webrtc;

/* loaded from: classes3.dex */
public class AudioSource extends MediaSource {
    public AudioSource(long nativeSource) {
        super(nativeSource);
    }

    long getNativeAudioSource() {
        return getNativeMediaSource();
    }
}
