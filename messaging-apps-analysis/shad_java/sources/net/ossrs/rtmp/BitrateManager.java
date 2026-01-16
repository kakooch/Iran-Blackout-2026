package net.ossrs.rtmp;

/* loaded from: classes4.dex */
public class BitrateManager {
    private long bitrate;
    private ConnectCheckerRtmp connectCheckerRtmp;
    private long timeStamp = System.currentTimeMillis();

    public BitrateManager(ConnectCheckerRtmp connectCheckerRtmp) {
        this.connectCheckerRtmp = connectCheckerRtmp;
    }

    public synchronized void calculateBitrate(long j) {
        this.bitrate += j;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.timeStamp;
        if (jCurrentTimeMillis >= 1000) {
            this.connectCheckerRtmp.onNewBitrateRtmp(this.bitrate / (jCurrentTimeMillis / 1000));
            this.timeStamp = System.currentTimeMillis();
            this.bitrate = 0L;
        }
    }
}
