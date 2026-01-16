package livekit.org.webrtc;

import java.util.List;

/* loaded from: classes8.dex */
public class SoftwareVideoEncoderFactory implements VideoEncoderFactory {
    private static final String TAG = "SoftwareVideoEncoderFactory";
    private final long nativeFactory = nativeCreateFactory();

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeCreate(long j, long j2, VideoCodecInfo videoCodecInfo);

    private static native long nativeCreateFactory();

    private static native List<VideoCodecInfo> nativeGetSupportedCodecs(long j);

    private static native boolean nativeIsSupported(long j, VideoCodecInfo videoCodecInfo);

    @Override // livekit.org.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(final VideoCodecInfo videoCodecInfo) {
        if (nativeIsSupported(this.nativeFactory, videoCodecInfo)) {
            return new WrappedNativeVideoEncoder(this) { // from class: livekit.org.webrtc.SoftwareVideoEncoderFactory.1
                final /* synthetic */ SoftwareVideoEncoderFactory this$0;

                {
                    this.this$0 = this;
                }

                @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
                public long createNative(long j) {
                    return SoftwareVideoEncoderFactory.nativeCreate(this.this$0.nativeFactory, j, videoCodecInfo);
                }

                @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
                public boolean isHardwareEncoder() {
                    return false;
                }
            };
        }
        Logging.w(TAG, "Trying to create encoder for unsupported format. " + String.valueOf(videoCodecInfo));
        return null;
    }

    @Override // livekit.org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        return (VideoCodecInfo[]) nativeGetSupportedCodecs(this.nativeFactory).toArray(new VideoCodecInfo[0]);
    }
}
