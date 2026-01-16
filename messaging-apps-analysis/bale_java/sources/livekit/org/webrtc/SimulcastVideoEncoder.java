package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class SimulcastVideoEncoder extends WrappedNativeVideoEncoder {
    VideoEncoderFactory fallback;
    VideoCodecInfo info;
    VideoEncoderFactory primary;

    public SimulcastVideoEncoder(VideoEncoderFactory videoEncoderFactory, VideoEncoderFactory videoEncoderFactory2, VideoCodecInfo videoCodecInfo) {
        this.primary = videoEncoderFactory;
        this.fallback = videoEncoderFactory2;
        this.info = videoCodecInfo;
    }

    static native long nativeCreateEncoder(long j, VideoEncoderFactory videoEncoderFactory, VideoEncoderFactory videoEncoderFactory2, VideoCodecInfo videoCodecInfo);

    @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
    public long createNative(long j) {
        return nativeCreateEncoder(j, this.primary, this.fallback, this.info);
    }

    @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }
}
