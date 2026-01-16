package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class LibvpxVp9Decoder extends WrappedNativeVideoDecoder {
    static native long nativeCreateDecoder();

    static native boolean nativeIsSupported();

    @Override // livekit.org.webrtc.WrappedNativeVideoDecoder, livekit.org.webrtc.VideoDecoder
    public long createNative(long j) {
        return nativeCreateDecoder();
    }
}
