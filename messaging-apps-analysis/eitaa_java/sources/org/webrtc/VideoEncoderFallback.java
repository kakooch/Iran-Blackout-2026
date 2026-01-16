package org.webrtc;

/* loaded from: classes3.dex */
public class VideoEncoderFallback extends WrappedNativeVideoEncoder {
    private final VideoEncoder fallback;
    private final VideoEncoder primary;

    private static native long nativeCreateEncoder(VideoEncoder fallback, VideoEncoder primary);

    public VideoEncoderFallback(VideoEncoder fallback, VideoEncoder primary) {
        this.fallback = fallback;
        this.primary = primary;
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public long createNativeVideoEncoder() {
        return nativeCreateEncoder(this.fallback, this.primary);
    }

    @Override // org.webrtc.WrappedNativeVideoEncoder, org.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return this.primary.isHardwareEncoder();
    }
}
