package org.webrtc;

/* loaded from: classes3.dex */
public class AudioTrack extends MediaStreamTrack {
    private static native void nativeSetVolume(long track, double volume);

    public AudioTrack(long nativeTrack) {
        super(nativeTrack);
    }

    public void setVolume(double volume) {
        nativeSetVolume(getNativeAudioTrack(), volume);
    }

    long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }
}
