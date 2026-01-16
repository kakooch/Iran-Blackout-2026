package com.github.faucamp.simplertmp;

import com.github.faucamp.simplertmp.io.RtmpConnection;
import java.io.IOException;
import net.ossrs.rtmp.ConnectCheckerRtmp;

/* loaded from: classes.dex */
public class DefaultRtmpPublisher implements RtmpPublisher {
    private RtmpConnection rtmpConnection;

    public DefaultRtmpPublisher(ConnectCheckerRtmp connectCheckerRtmp) {
        this.rtmpConnection = new RtmpConnection(connectCheckerRtmp);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public boolean connect(String str) {
        return this.rtmpConnection.connect(str);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public boolean publish(String str) {
        return this.rtmpConnection.publish(str);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void close() {
        this.rtmpConnection.close();
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void publishVideoData(byte[] bArr, int i, int i2) throws IOException {
        this.rtmpConnection.publishVideoData(bArr, i, i2);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void publishAudioData(byte[] bArr, int i, int i2) throws IOException {
        this.rtmpConnection.publishAudioData(bArr, i, i2);
    }

    @Override // com.github.faucamp.simplertmp.RtmpPublisher
    public void setVideoResolution(int i, int i2) {
        this.rtmpConnection.setVideoResolution(i, i2);
    }
}
