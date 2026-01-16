package ir.eitaa.messenger.video;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MediaController;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class AudioRecoder {
    private final MediaCodec decoder;
    private ByteBuffer[] decoderInputBuffers;
    private ByteBuffer[] decoderOutputBuffers;
    private final MediaCodec encoder;
    private ByteBuffer[] encoderInputBuffers;
    private ByteBuffer[] encoderOutputBuffers;
    private final MediaExtractor extractor;
    public final MediaFormat format;
    private final int trackIndex;
    private final MediaCodec.BufferInfo decoderOutputBufferInfo = new MediaCodec.BufferInfo();
    private final MediaCodec.BufferInfo encoderOutputBufferInfo = new MediaCodec.BufferInfo();
    private boolean extractorDone = false;
    private boolean decoderDone = false;
    private boolean encoderDone = false;
    private int pendingAudioDecoderOutputBufferIndex = -1;
    private final int TIMEOUT_USEC = 2500;
    public long startTime = 0;
    public long endTime = 0;

    public AudioRecoder(MediaFormat inputAudioFormat, MediaExtractor extractor, int trackIndex) throws IOException {
        this.extractor = extractor;
        this.trackIndex = trackIndex;
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(inputAudioFormat.getString("mime"));
        this.decoder = mediaCodecCreateDecoderByType;
        mediaCodecCreateDecoderByType.configure(inputAudioFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.AUIDO_MIME_TYPE);
        this.encoder = mediaCodecCreateEncoderByType;
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(MediaController.AUIDO_MIME_TYPE, inputAudioFormat.getInteger("sample-rate"), inputAudioFormat.getInteger("channel-count"));
        this.format = mediaFormatCreateAudioFormat;
        mediaFormatCreateAudioFormat.setInteger("bitrate", 65536);
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        mediaCodecCreateEncoderByType.start();
        this.decoderInputBuffers = mediaCodecCreateDecoderByType.getInputBuffers();
        this.decoderOutputBuffers = mediaCodecCreateDecoderByType.getOutputBuffers();
        this.encoderInputBuffers = mediaCodecCreateEncoderByType.getInputBuffers();
        this.encoderOutputBuffers = mediaCodecCreateEncoderByType.getOutputBuffers();
    }

    public void release() {
        try {
            this.encoder.stop();
            this.decoder.stop();
            this.extractor.unselectTrack(this.trackIndex);
            this.extractor.release();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean step(MP4Builder muxer, int audioTrackIndex) throws Exception {
        int iDequeueOutputBuffer;
        int iDequeueInputBuffer;
        int iDequeueOutputBuffer2;
        int iDequeueInputBuffer2;
        ByteBuffer inputBuffer;
        if (!this.extractorDone && (iDequeueInputBuffer2 = this.decoder.dequeueInputBuffer(2500L)) != -1) {
            if (Build.VERSION.SDK_INT >= 21) {
                inputBuffer = this.decoder.getInputBuffer(iDequeueInputBuffer2);
            } else {
                inputBuffer = this.decoderInputBuffers[iDequeueInputBuffer2];
            }
            int sampleData = this.extractor.readSampleData(inputBuffer, 0);
            long sampleTime = this.extractor.getSampleTime();
            long j = this.endTime;
            if (j > 0 && sampleTime >= j) {
                this.encoderDone = true;
                this.decoderOutputBufferInfo.flags |= 4;
            }
            if (sampleData >= 0) {
                this.decoder.queueInputBuffer(iDequeueInputBuffer2, 0, sampleData, this.extractor.getSampleTime(), this.extractor.getSampleFlags());
            }
            boolean z = !this.extractor.advance();
            this.extractorDone = z;
            if (z) {
                this.decoder.queueInputBuffer(this.decoder.dequeueInputBuffer(2500L), 0, 0, 0L, 4);
            }
        }
        if (!this.decoderDone && this.pendingAudioDecoderOutputBufferIndex == -1 && (iDequeueOutputBuffer2 = this.decoder.dequeueOutputBuffer(this.decoderOutputBufferInfo, 2500L)) != -1) {
            if (iDequeueOutputBuffer2 == -3) {
                this.decoderOutputBuffers = this.decoder.getOutputBuffers();
            } else if (iDequeueOutputBuffer2 != -2) {
                if ((this.decoderOutputBufferInfo.flags & 2) != 0) {
                    this.decoder.releaseOutputBuffer(iDequeueOutputBuffer2, false);
                } else {
                    this.pendingAudioDecoderOutputBufferIndex = iDequeueOutputBuffer2;
                }
            }
        }
        if (this.pendingAudioDecoderOutputBufferIndex != -1 && (iDequeueInputBuffer = this.encoder.dequeueInputBuffer(2500L)) != -1) {
            ByteBuffer byteBuffer = this.encoderInputBuffers[iDequeueInputBuffer];
            MediaCodec.BufferInfo bufferInfo = this.decoderOutputBufferInfo;
            int i = bufferInfo.size;
            long j2 = bufferInfo.presentationTimeUs;
            if (i >= 0) {
                ByteBuffer byteBufferDuplicate = this.decoderOutputBuffers[this.pendingAudioDecoderOutputBufferIndex].duplicate();
                byteBufferDuplicate.position(this.decoderOutputBufferInfo.offset);
                byteBufferDuplicate.limit(this.decoderOutputBufferInfo.offset + i);
                byteBuffer.position(0);
                byteBuffer.put(byteBufferDuplicate);
                this.encoder.queueInputBuffer(iDequeueInputBuffer, 0, i, j2, this.decoderOutputBufferInfo.flags);
            }
            this.decoder.releaseOutputBuffer(this.pendingAudioDecoderOutputBufferIndex, false);
            this.pendingAudioDecoderOutputBufferIndex = -1;
            if ((this.decoderOutputBufferInfo.flags & 4) != 0) {
                this.decoderDone = true;
            }
        }
        if (!this.encoderDone && (iDequeueOutputBuffer = this.encoder.dequeueOutputBuffer(this.encoderOutputBufferInfo, 2500L)) != -1) {
            if (iDequeueOutputBuffer == -3) {
                this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            } else if (iDequeueOutputBuffer != -2) {
                ByteBuffer byteBuffer2 = this.encoderOutputBuffers[iDequeueOutputBuffer];
                MediaCodec.BufferInfo bufferInfo2 = this.encoderOutputBufferInfo;
                if ((bufferInfo2.flags & 2) != 0) {
                    this.encoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                } else {
                    if (bufferInfo2.size != 0) {
                        muxer.writeSampleData(audioTrackIndex, byteBuffer2, bufferInfo2, false);
                    }
                    if ((this.encoderOutputBufferInfo.flags & 4) != 0) {
                        this.encoderDone = true;
                    }
                    this.encoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
            }
        }
        return this.encoderDone;
    }
}
