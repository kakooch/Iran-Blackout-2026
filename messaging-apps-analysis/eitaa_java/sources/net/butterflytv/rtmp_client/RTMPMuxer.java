package net.butterflytv.rtmp_client;

/* loaded from: classes3.dex */
public class RTMPMuxer {
    public native int close();

    public native int open(String str, int i, int i2);

    public native int writeAudio(byte[] bArr, int i, int i2, long j);

    public native int writeVideo(byte[] bArr, int i, int i2, long j);

    static {
        System.loadLibrary("rtmp-jni");
    }
}
