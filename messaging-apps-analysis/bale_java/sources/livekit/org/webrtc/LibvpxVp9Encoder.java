package livekit.org.webrtc;

import java.util.List;

/* loaded from: classes8.dex */
public class LibvpxVp9Encoder extends WrappedNativeVideoEncoder {
    static native long nativeCreate(long j);

    static native List<String> nativeGetSupportedScalabilityModes();

    static native boolean nativeIsSupported();

    static List<String> scalabilityModes() {
        return nativeGetSupportedScalabilityModes();
    }

    @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
    public long createNative(long j) {
        return nativeCreate(j);
    }

    @Override // livekit.org.webrtc.WrappedNativeVideoEncoder, livekit.org.webrtc.VideoEncoder
    public boolean isHardwareEncoder() {
        return false;
    }
}
