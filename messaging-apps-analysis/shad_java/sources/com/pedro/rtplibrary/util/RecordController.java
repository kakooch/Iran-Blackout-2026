package com.pedro.rtplibrary.util;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class RecordController {
    private MediaFormat audioFormat;
    private Listener listener;
    private MediaMuxer mediaMuxer;
    private MediaFormat videoFormat;
    private Status status = Status.STOPPED;
    private int videoTrack = -1;
    private int audioTrack = -1;
    private long pauseTime = 0;
    private MediaCodec.BufferInfo videoInfo = new MediaCodec.BufferInfo();
    private MediaCodec.BufferInfo audioInfo = new MediaCodec.BufferInfo();

    public interface Listener {
        void onStatusChange(Status status);
    }

    public enum Status {
        STARTED,
        STOPPED,
        RECORDING,
        PAUSED,
        RESUMED
    }

    public boolean isRunning() {
        Status status = this.status;
        return status == Status.STARTED || status == Status.RECORDING || status == Status.RESUMED || status == Status.PAUSED;
    }

    public boolean isRecording() {
        return this.status == Status.RECORDING;
    }

    public void resetFormats() {
        this.videoFormat = null;
        this.audioFormat = null;
    }

    public void recordVideo(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        MediaFormat mediaFormat;
        Status status = this.status;
        if (status == Status.STARTED && bufferInfo.flags == 1 && (mediaFormat = this.videoFormat) != null && this.audioFormat != null) {
            this.videoTrack = this.mediaMuxer.addTrack(mediaFormat);
            this.audioTrack = this.mediaMuxer.addTrack(this.audioFormat);
            this.mediaMuxer.start();
            Status status2 = Status.RECORDING;
            this.status = status2;
            Listener listener = this.listener;
            if (listener != null) {
                listener.onStatusChange(status2);
            }
        } else if (status == Status.RESUMED && bufferInfo.flags == 1) {
            Status status3 = Status.RECORDING;
            this.status = status3;
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onStatusChange(status3);
            }
        }
        if (this.status == Status.RECORDING) {
            updateFormat(this.videoInfo, bufferInfo);
            this.mediaMuxer.writeSampleData(this.videoTrack, byteBuffer, this.videoInfo);
        }
    }

    public void recordAudio(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.status == Status.RECORDING) {
            updateFormat(this.audioInfo, bufferInfo);
            this.mediaMuxer.writeSampleData(this.audioTrack, byteBuffer, this.audioInfo);
        }
    }

    public void setVideoFormat(MediaFormat mediaFormat) {
        this.videoFormat = mediaFormat;
    }

    public void setAudioFormat(MediaFormat mediaFormat) {
        this.audioFormat = mediaFormat;
    }

    private void updateFormat(MediaCodec.BufferInfo bufferInfo, MediaCodec.BufferInfo bufferInfo2) {
        bufferInfo.flags = bufferInfo2.flags;
        bufferInfo.offset = bufferInfo2.offset;
        bufferInfo.size = bufferInfo2.size;
        bufferInfo.presentationTimeUs = bufferInfo2.presentationTimeUs - this.pauseTime;
    }
}
