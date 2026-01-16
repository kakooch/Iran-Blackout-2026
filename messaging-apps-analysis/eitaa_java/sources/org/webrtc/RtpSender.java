package org.webrtc;

import java.util.List;

/* loaded from: classes3.dex */
public class RtpSender {
    private MediaStreamTrack cachedTrack;
    private final DtmfSender dtmfSender;
    private long nativeRtpSender;
    private boolean ownsTrack = true;

    private static native long nativeGetDtmfSender(long rtpSender);

    private static native String nativeGetId(long rtpSender);

    private static native RtpParameters nativeGetParameters(long rtpSender);

    private static native List<String> nativeGetStreams(long rtpSender);

    private static native long nativeGetTrack(long rtpSender);

    private static native void nativeSetFrameEncryptor(long rtpSender, long nativeFrameEncryptor);

    private static native boolean nativeSetParameters(long rtpSender, RtpParameters parameters);

    private static native void nativeSetStreams(long rtpSender, List<String> streamIds);

    private static native boolean nativeSetTrack(long rtpSender, long nativeTrack);

    @CalledByNative
    public RtpSender(long nativeRtpSender) {
        this.nativeRtpSender = nativeRtpSender;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(nativeRtpSender));
        long jNativeGetDtmfSender = nativeGetDtmfSender(nativeRtpSender);
        this.dtmfSender = jNativeGetDtmfSender != 0 ? new DtmfSender(jNativeGetDtmfSender) : null;
    }

    public boolean setTrack(MediaStreamTrack track, boolean takeOwnership) {
        checkRtpSenderExists();
        if (!nativeSetTrack(this.nativeRtpSender, track == null ? 0L : track.getNativeMediaStreamTrack())) {
            return false;
        }
        MediaStreamTrack mediaStreamTrack = this.cachedTrack;
        if (mediaStreamTrack != null && this.ownsTrack) {
            mediaStreamTrack.dispose();
        }
        this.cachedTrack = track;
        this.ownsTrack = takeOwnership;
        return true;
    }

    public MediaStreamTrack track() {
        return this.cachedTrack;
    }

    public void setStreams(List<String> streamIds) {
        checkRtpSenderExists();
        nativeSetStreams(this.nativeRtpSender, streamIds);
    }

    public List<String> getStreams() {
        checkRtpSenderExists();
        return nativeGetStreams(this.nativeRtpSender);
    }

    public boolean setParameters(RtpParameters parameters) {
        checkRtpSenderExists();
        return nativeSetParameters(this.nativeRtpSender, parameters);
    }

    public RtpParameters getParameters() {
        checkRtpSenderExists();
        return nativeGetParameters(this.nativeRtpSender);
    }

    public String id() {
        checkRtpSenderExists();
        return nativeGetId(this.nativeRtpSender);
    }

    public DtmfSender dtmf() {
        return this.dtmfSender;
    }

    public void setFrameEncryptor(FrameEncryptor frameEncryptor) {
        checkRtpSenderExists();
        nativeSetFrameEncryptor(this.nativeRtpSender, frameEncryptor.getNativeFrameEncryptor());
    }

    public void dispose() {
        checkRtpSenderExists();
        DtmfSender dtmfSender = this.dtmfSender;
        if (dtmfSender != null) {
            dtmfSender.dispose();
        }
        MediaStreamTrack mediaStreamTrack = this.cachedTrack;
        if (mediaStreamTrack != null && this.ownsTrack) {
            mediaStreamTrack.dispose();
        }
        JniCommon.nativeReleaseRef(this.nativeRtpSender);
        this.nativeRtpSender = 0L;
    }

    long getNativeRtpSender() {
        checkRtpSenderExists();
        return this.nativeRtpSender;
    }

    private void checkRtpSenderExists() {
        if (this.nativeRtpSender == 0) {
            throw new IllegalStateException("RtpSender has been disposed.");
        }
    }
}
