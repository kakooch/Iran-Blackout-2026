package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class LibvpxVp8Decoder extends WrappedNativeVideoDecoder {
    static native long nativeCreateDecoder(long j);

    @Override // livekit.org.webrtc.WrappedNativeVideoDecoder, livekit.org.webrtc.VideoDecoder
    public long createNative(long j) {
        return nativeCreateDecoder(j);
    }
}
