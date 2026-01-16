package livekit.org.webrtc;

/* loaded from: classes8.dex */
class BaseBitrateAdjuster implements BitrateAdjuster {
    protected int targetBitrateBps;
    protected double targetFramerateFps;

    BaseBitrateAdjuster() {
    }

    @Override // livekit.org.webrtc.BitrateAdjuster
    public int getAdjustedBitrateBps() {
        return this.targetBitrateBps;
    }

    @Override // livekit.org.webrtc.BitrateAdjuster
    public double getAdjustedFramerateFps() {
        return this.targetFramerateFps;
    }

    @Override // livekit.org.webrtc.BitrateAdjuster
    public void reportEncodedFrame(int i) {
    }

    @Override // livekit.org.webrtc.BitrateAdjuster
    public void setTargets(int i, double d) {
        this.targetBitrateBps = i;
        this.targetFramerateFps = d;
    }
}
