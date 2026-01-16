package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoDecoder {

    /* renamed from: org.webrtc.VideoDecoder$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @CalledByNative
        public static long $default$createNativeVideoDecoder(VideoDecoder videoDecoder) {
            return 0L;
        }
    }

    public interface Callback {
        void onDecodedFrame(VideoFrame frame, Integer decodeTimeMs, Integer qp);
    }

    @CalledByNative
    long createNativeVideoDecoder();

    @CalledByNative
    VideoCodecStatus decode(EncodedImage frame, DecodeInfo info);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    boolean getPrefersLateDecoding();

    @CalledByNative
    VideoCodecStatus initDecode(Settings settings, Callback decodeCallback);

    @CalledByNative
    VideoCodecStatus release();

    public static class Settings {
        public final int height;
        public final int numberOfCores;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int numberOfCores, int width, int height) {
            this.numberOfCores = numberOfCores;
            this.width = width;
            this.height = height;
        }
    }

    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean isMissingFrames, long renderTimeMs) {
            this.isMissingFrames = isMissingFrames;
            this.renderTimeMs = renderTimeMs;
        }
    }
}
