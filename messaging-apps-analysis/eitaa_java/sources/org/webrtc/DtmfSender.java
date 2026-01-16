package org.webrtc;

/* loaded from: classes3.dex */
public class DtmfSender {
    private long nativeDtmfSender;

    private static native boolean nativeCanInsertDtmf(long dtmfSender);

    private static native int nativeDuration(long dtmfSender);

    private static native boolean nativeInsertDtmf(long dtmfSender, String tones, int duration, int interToneGap);

    private static native int nativeInterToneGap(long dtmfSender);

    private static native String nativeTones(long dtmfSender);

    public DtmfSender(long nativeDtmfSender) {
        this.nativeDtmfSender = nativeDtmfSender;
    }

    public boolean canInsertDtmf() {
        checkDtmfSenderExists();
        return nativeCanInsertDtmf(this.nativeDtmfSender);
    }

    public boolean insertDtmf(String tones, int duration, int interToneGap) {
        checkDtmfSenderExists();
        return nativeInsertDtmf(this.nativeDtmfSender, tones, duration, interToneGap);
    }

    public String tones() {
        checkDtmfSenderExists();
        return nativeTones(this.nativeDtmfSender);
    }

    public int duration() {
        checkDtmfSenderExists();
        return nativeDuration(this.nativeDtmfSender);
    }

    public int interToneGap() {
        checkDtmfSenderExists();
        return nativeInterToneGap(this.nativeDtmfSender);
    }

    public void dispose() {
        checkDtmfSenderExists();
        JniCommon.nativeReleaseRef(this.nativeDtmfSender);
        this.nativeDtmfSender = 0L;
    }

    private void checkDtmfSenderExists() {
        if (this.nativeDtmfSender == 0) {
            throw new IllegalStateException("DtmfSender has been disposed.");
        }
    }
}
