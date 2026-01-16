package org.webrtc;

/* loaded from: classes3.dex */
public interface VideoEncoderFactory {

    public interface VideoEncoderSelector {
        @CalledByNative("VideoEncoderSelector")
        VideoCodecInfo onAvailableBitrate(int kbps);

        @CalledByNative("VideoEncoderSelector")
        void onCurrentEncoder(VideoCodecInfo info);

        @CalledByNative("VideoEncoderSelector")
        VideoCodecInfo onEncoderBroken();
    }

    @CalledByNative
    VideoEncoder createEncoder(VideoCodecInfo info);

    @CalledByNative
    VideoEncoderSelector getEncoderSelector();

    @CalledByNative
    VideoCodecInfo[] getImplementations();

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();

    /* renamed from: org.webrtc.VideoEncoderFactory$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @CalledByNative
        public static VideoEncoderSelector $default$getEncoderSelector(VideoEncoderFactory videoEncoderFactory) {
            return null;
        }
    }
}
