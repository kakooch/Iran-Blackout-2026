package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class LibvpxVp8Encoder extends WrappedNativeVideoEncoder {
    static native long nativeCreate(long j);

    @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
    public long createNative(long j) {
        return nativeCreate(j);
    }

    @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }
}
