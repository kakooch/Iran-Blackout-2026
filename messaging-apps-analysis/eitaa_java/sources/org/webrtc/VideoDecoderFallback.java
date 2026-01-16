package org.webrtc;

/* loaded from: classes3.dex */
public class VideoDecoderFallback extends WrappedNativeVideoDecoder {
    private final VideoDecoder fallback;
    private final VideoDecoder primary;

    private static native long nativeCreateDecoder(VideoDecoder fallback, VideoDecoder primary);

    public VideoDecoderFallback(VideoDecoder fallback, VideoDecoder primary) {
        this.fallback = fallback;
        this.primary = primary;
    }

    @Override // org.webrtc.WrappedNativeVideoDecoder, org.webrtc.VideoDecoder
    public long createNativeVideoDecoder() {
        return nativeCreateDecoder(this.fallback, this.primary);
    }
}
