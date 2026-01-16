package net.ossrs.rtmp;

/* loaded from: classes4.dex */
public interface ConnectCheckerRtmp {
    void onAuthErrorRtmp();

    void onAuthSuccessRtmp();

    void onConnectionFailedRtmp(String str);

    void onConnectionSuccessRtmp();

    void onDisconnectRtmp();

    void onNewBitrateRtmp(long j);
}
