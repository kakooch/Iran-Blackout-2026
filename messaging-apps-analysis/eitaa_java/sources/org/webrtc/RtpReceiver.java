package org.webrtc;

import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class RtpReceiver {
    private MediaStreamTrack cachedTrack;
    private long nativeObserver;
    private long nativeRtpReceiver;

    public interface Observer {
        @CalledByNative("Observer")
        void onFirstPacketReceived(MediaStreamTrack.MediaType media_type);
    }

    private static native String nativeGetId(long rtpReceiver);

    private static native RtpParameters nativeGetParameters(long rtpReceiver);

    private static native long nativeGetTrack(long rtpReceiver);

    private static native void nativeSetFrameDecryptor(long rtpReceiver, long nativeFrameDecryptor);

    private static native long nativeSetObserver(long rtpReceiver, Observer observer);

    private static native void nativeUnsetObserver(long rtpReceiver, long nativeObserver);

    @CalledByNative
    public RtpReceiver(long nativeRtpReceiver) {
        this.nativeRtpReceiver = nativeRtpReceiver;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(nativeRtpReceiver));
    }

    public MediaStreamTrack track() {
        return this.cachedTrack;
    }

    public RtpParameters getParameters() {
        checkRtpReceiverExists();
        return nativeGetParameters(this.nativeRtpReceiver);
    }

    public String id() {
        checkRtpReceiverExists();
        return nativeGetId(this.nativeRtpReceiver);
    }

    @CalledByNative
    public void dispose() {
        checkRtpReceiverExists();
        this.cachedTrack.dispose();
        long j = this.nativeObserver;
        if (j != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j);
            this.nativeObserver = 0L;
        }
        JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
        this.nativeRtpReceiver = 0L;
    }

    public void SetObserver(Observer observer) {
        checkRtpReceiverExists();
        long j = this.nativeObserver;
        if (j != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j);
        }
        this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, observer);
    }

    public void setFrameDecryptor(FrameDecryptor frameDecryptor) {
        checkRtpReceiverExists();
        nativeSetFrameDecryptor(this.nativeRtpReceiver, frameDecryptor.getNativeFrameDecryptor());
    }

    private void checkRtpReceiverExists() {
        if (this.nativeRtpReceiver == 0) {
            throw new IllegalStateException("RtpReceiver has been disposed.");
        }
    }
}
