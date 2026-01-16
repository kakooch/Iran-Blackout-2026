package livekit.org.webrtc;

/* loaded from: classes8.dex */
public class FrameCryptorFactory {
    public static FrameCryptor createFrameCryptorForRtpReceiver(PeerConnectionFactory peerConnectionFactory, RtpReceiver rtpReceiver, String str, FrameCryptorAlgorithm frameCryptorAlgorithm, FrameCryptorKeyProvider frameCryptorKeyProvider) {
        return nativeCreateFrameCryptorForRtpReceiver(peerConnectionFactory.getNativeOwnedFactoryAndThreads(), rtpReceiver.getNativeRtpReceiver(), str, frameCryptorAlgorithm.getValue(), frameCryptorKeyProvider.getNativeKeyProvider());
    }

    public static FrameCryptor createFrameCryptorForRtpSender(PeerConnectionFactory peerConnectionFactory, RtpSender rtpSender, String str, FrameCryptorAlgorithm frameCryptorAlgorithm, FrameCryptorKeyProvider frameCryptorKeyProvider) {
        return nativeCreateFrameCryptorForRtpSender(peerConnectionFactory.getNativeOwnedFactoryAndThreads(), rtpSender.getNativeRtpSender(), str, frameCryptorAlgorithm.getValue(), frameCryptorKeyProvider.getNativeKeyProvider());
    }

    public static FrameCryptorKeyProvider createFrameCryptorKeyProvider(boolean z, byte[] bArr, int i, byte[] bArr2, int i2, int i3, boolean z2) {
        return nativeCreateFrameCryptorKeyProvider(z, bArr, i, bArr2, i2, i3, z2);
    }

    private static native FrameCryptor nativeCreateFrameCryptorForRtpReceiver(long j, long j2, String str, int i, long j3);

    private static native FrameCryptor nativeCreateFrameCryptorForRtpSender(long j, long j2, String str, int i, long j3);

    private static native FrameCryptorKeyProvider nativeCreateFrameCryptorKeyProvider(boolean z, byte[] bArr, int i, byte[] bArr2, int i2, int i3, boolean z2);
}
