package livekit.org.webrtc;

import java.util.List;

/* loaded from: classes8.dex */
public class SoftwareVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "SoftwareVideoDecoderFactory";
    private final long nativeFactory = nativeCreateFactory();

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreate(long j, long j2, VideoCodecInfo videoCodecInfo);

    private static native long nativeCreateFactory();

    private static native List<VideoCodecInfo> nativeGetSupportedCodecs(long j);

    private static native boolean nativeIsSupported(long j, VideoCodecInfo videoCodecInfo);

    @Override // livekit.org.webrtc.VideoDecoderFactory
    public VideoDecoder createDecoder(final VideoCodecInfo videoCodecInfo) {
        if (nativeIsSupported(this.nativeFactory, videoCodecInfo)) {
            return new WrappedNativeVideoDecoder(this) { // from class: livekit.org.webrtc.SoftwareVideoDecoderFactory.1
                final /* synthetic */ SoftwareVideoDecoderFactory this$0;

                {
                    this.this$0 = this;
                }

                @Override // livekit.org.webrtc.WrappedNativeVideoDecoder, livekit.org.webrtc.VideoDecoder
                public long createNative(long j) {
                    return SoftwareVideoDecoderFactory.nativeCreate(this.this$0.nativeFactory, j, videoCodecInfo);
                }
            };
        }
        Logging.w(TAG, "Trying to create decoder for unsupported format. " + String.valueOf(videoCodecInfo));
        return null;
    }

    @Override // livekit.org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return (VideoCodecInfo[]) nativeGetSupportedCodecs(this.nativeFactory).toArray(new VideoCodecInfo[0]);
    }
}
