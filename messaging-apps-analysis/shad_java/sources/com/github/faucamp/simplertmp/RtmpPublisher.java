package com.github.faucamp.simplertmp;

/* loaded from: classes.dex */
public interface RtmpPublisher {
    void close();

    boolean connect(String str);

    boolean publish(String str);

    void publishAudioData(byte[] bArr, int i, int i2);

    void publishVideoData(byte[] bArr, int i, int i2);

    void setVideoResolution(int i, int i2);
}
