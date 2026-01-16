package livekit.org.webrtc;

/* loaded from: classes8.dex */
public interface VideoDecoderFactory {
    @CalledByNative
    VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    default VideoCodecInfo[] getSupportedCodecs() {
        return new VideoCodecInfo[0];
    }
}
