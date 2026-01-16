package com.pedro.rtplibrary.rtmp;

import android.media.MediaCodec;
import android.view.SurfaceView;
import com.pedro.rtplibrary.base.Camera1Base;
import java.nio.ByteBuffer;
import net.ossrs.rtmp.ConnectCheckerRtmp;
import net.ossrs.rtmp.SrsFlvMuxer;

/* loaded from: classes3.dex */
public class RtmpCamera1 extends Camera1Base {
    private SrsFlvMuxer srsFlvMuxer;

    public RtmpCamera1(SurfaceView surfaceView, ConnectCheckerRtmp connectCheckerRtmp) {
        super(surfaceView);
        this.srsFlvMuxer = new SrsFlvMuxer(connectCheckerRtmp);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    protected void prepareAudioRtp(boolean z, int i) {
        this.srsFlvMuxer.setIsStereo(z);
        this.srsFlvMuxer.setSampleRate(i);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    protected void startStreamRtp(String str) {
        if (this.videoEncoder.getRotation() == 90 || this.videoEncoder.getRotation() == 270) {
            this.srsFlvMuxer.setVideoResolution(this.videoEncoder.getHeight(), this.videoEncoder.getWidth());
        } else {
            this.srsFlvMuxer.setVideoResolution(this.videoEncoder.getWidth(), this.videoEncoder.getHeight());
        }
        this.srsFlvMuxer.start(str);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    protected void stopStreamRtp() throws InterruptedException {
        this.srsFlvMuxer.stop();
    }

    public void setReTries(int i) {
        this.srsFlvMuxer.setReTries(i);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    public boolean shouldRetry(String str) {
        return this.srsFlvMuxer.shouldRetry(str);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    public void reConnect(long j) throws InterruptedException {
        this.srsFlvMuxer.reConnect(j);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    protected void getAacDataRtp(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.srsFlvMuxer.sendAudio(byteBuffer, bufferInfo);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    protected void onSpsPpsVpsRtp(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        this.srsFlvMuxer.setSpsPPs(byteBuffer, byteBuffer2);
    }

    @Override // com.pedro.rtplibrary.base.Camera1Base
    protected void getH264DataRtp(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.srsFlvMuxer.sendVideo(byteBuffer, bufferInfo);
    }
}
