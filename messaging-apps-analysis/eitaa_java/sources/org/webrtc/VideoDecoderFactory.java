package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoDecoderFactory {
    @Deprecated
    VideoDecoder createDecoder(String codecType);

    @CalledByNative
    VideoDecoder createDecoder(VideoCodecInfo info);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();

    /* renamed from: org.webrtc.VideoDecoderFactory$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @CalledByNative
        public static VideoCodecInfo[] $default$getSupportedCodecs(VideoDecoderFactory videoDecoderFactory) {
            return new VideoCodecInfo[0];
        }

        @Deprecated
        public static VideoDecoder $default$createDecoder(VideoDecoderFactory _this, String str) {
            throw new UnsupportedOperationException("Deprecated and not implemented.");
        }
    }
}
