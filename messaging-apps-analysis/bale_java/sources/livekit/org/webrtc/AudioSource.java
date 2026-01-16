package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class AudioSource extends MediaSource {
    public AudioSource(long j) {
        super(j);
    }

    long getNativeAudioSource() {
        return getNativeMediaSource();
    }
}
