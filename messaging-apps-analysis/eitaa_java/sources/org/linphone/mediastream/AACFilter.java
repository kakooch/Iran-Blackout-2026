package org.linphone.mediastream;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import ir.eitaa.messenger.MediaController;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes3.dex */
public class AACFilter {
    private static AACFilter singleton;
    int bitrate;
    int channelCount;
    MediaCodec decoder;
    MediaCodec.BufferInfo decoderBufferInfo;
    ByteBuffer[] decoderInputBuffers;
    ByteBuffer[] decoderOutputBuffers;
    MediaCodec encoder;
    MediaCodec.BufferInfo encoderBufferInfo;
    ByteBuffer[] encoderInputBuffers;
    ByteBuffer[] encoderOutputBuffers;
    boolean initialized = false;
    int sampleRate;

    public static AACFilter instance() {
        if (singleton == null) {
            singleton = new AACFilter();
        }
        return singleton;
    }

    public boolean preprocess(int i, int i2, int i3, boolean z) throws IOException {
        MediaFormat mediaFormatCreateAudioFormat;
        if (this.initialized) {
            return true;
        }
        this.sampleRate = i;
        this.channelCount = i2;
        this.bitrate = i3;
        try {
            MediaFormat mediaFormatCreateAudioFormat2 = MediaFormat.createAudioFormat(MediaController.AUIDO_MIME_TYPE, i, i2);
            mediaFormatCreateAudioFormat2.setInteger("aac-profile", 39);
            mediaFormatCreateAudioFormat2.setInteger("bitrate", i3);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName("OMX.google.aac.encoder");
            this.encoder = mediaCodecCreateByCodecName;
            mediaCodecCreateByCodecName.configure(mediaFormatCreateAudioFormat2, (Surface) null, (MediaCrypto) null, 1);
            this.encoder.start();
            this.encoderBufferInfo = new MediaCodec.BufferInfo();
            byte[] bArr = null;
            for (int i4 = 0; bArr == null && i4 < 1000; i4++) {
                int iDequeueOutputBuffer = this.encoder.dequeueOutputBuffer(this.encoderBufferInfo, 0L);
                if (iDequeueOutputBuffer >= 0) {
                    MediaCodec.BufferInfo bufferInfo = this.encoderBufferInfo;
                    if (bufferInfo.flags == 2) {
                        bArr = new byte[bufferInfo.size];
                        this.encoder.getOutputBuffers()[iDequeueOutputBuffer].get(bArr, 0, this.encoderBufferInfo.size);
                        this.encoder.getOutputBuffers()[iDequeueOutputBuffer].position(0);
                        this.encoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    }
                }
            }
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            this.encoderInputBuffers = this.encoder.getInputBuffers();
            if (bArr == null) {
                Log.e("Sigh, failed to read asc from encoder");
            }
            Log.i("AAC encoder initialized");
            try {
                if (bArr != null) {
                    mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(MediaController.AUIDO_MIME_TYPE, 0, 0);
                    mediaFormatCreateAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
                } else {
                    mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(MediaController.AUIDO_MIME_TYPE, i, i2);
                    mediaFormatCreateAudioFormat.setInteger("bitrate", i3);
                }
                MediaCodec mediaCodecCreateByCodecName2 = MediaCodec.createByCodecName("OMX.google.aac.decoder");
                this.decoder = mediaCodecCreateByCodecName2;
                mediaCodecCreateByCodecName2.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 0);
                this.decoder.start();
                this.decoderOutputBuffers = this.decoder.getOutputBuffers();
                this.decoderInputBuffers = this.decoder.getInputBuffers();
                this.decoderBufferInfo = new MediaCodec.BufferInfo();
                Log.i("AAC decoder initialized");
                this.initialized = true;
                return true;
            } catch (Exception e) {
                Log.e(e, "Unable to create AAC Decoder");
                return false;
            }
        } catch (Exception e2) {
            Log.e(e2, "Unable to create AAC Encoder");
            return false;
        }
    }

    public boolean pushToDecoder(byte[] bArr, int i) {
        if (bArr != null) {
            try {
                MediaCodec mediaCodec = this.decoder;
                if (mediaCodec != null) {
                    return queueData(mediaCodec, this.decoderInputBuffers, bArr, i);
                }
            } catch (Exception e) {
                Log.e(e, "Push to decoder failed");
            }
        }
        return false;
    }

    public int pullFromDecoder(byte[] bArr) {
        try {
            int iDequeueData = dequeueData(this.decoder, this.decoderOutputBuffers, this.decoderBufferInfo, bArr);
            if (iDequeueData != -3) {
                return iDequeueData;
            }
            this.decoderOutputBuffers = this.decoder.getOutputBuffers();
            return pullFromDecoder(bArr);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean pushToEncoder(byte[] bArr, int i) {
        if (bArr != null) {
            try {
                MediaCodec mediaCodec = this.encoder;
                if (mediaCodec != null) {
                    return queueData(mediaCodec, this.encoderInputBuffers, bArr, i);
                }
            } catch (Exception e) {
                Log.e(e, "Push to encoder failed");
            }
        }
        return false;
    }

    public int pullFromEncoder(byte[] bArr) {
        try {
            int iDequeueData = dequeueData(this.encoder, this.encoderOutputBuffers, this.encoderBufferInfo, bArr);
            if (iDequeueData != -3) {
                return iDequeueData;
            }
            this.encoderOutputBuffers = this.encoder.getOutputBuffers();
            return pullFromDecoder(bArr);
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean postprocess() {
        if (this.initialized) {
            this.encoder.flush();
            Log.i("Stopping encoder");
            this.encoder.stop();
            Log.i("Stopping decoder");
            this.decoder.flush();
            this.decoder.stop();
            Log.i("Release encoder");
            this.encoder.release();
            Log.i("Release decoder");
            this.decoder.release();
            this.encoder = null;
            this.decoder = null;
            this.initialized = false;
        }
        return true;
    }

    private static boolean queueData(MediaCodec mediaCodec, ByteBuffer[] byteBufferArr, byte[] bArr, int i) throws MediaCodec.CryptoException {
        int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
        if (iDequeueInputBuffer < 0) {
            return false;
        }
        byteBufferArr[iDequeueInputBuffer].position(0);
        byteBufferArr[iDequeueInputBuffer].put(bArr, 0, i);
        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, i, 0L, 0);
        return true;
    }

    private static int dequeueData(MediaCodec mediaCodec, ByteBuffer[] byteBufferArr, MediaCodec.BufferInfo bufferInfo, byte[] bArr) {
        for (int i = 0; i < 1; i++) {
            int iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 100L);
            if (iDequeueOutputBuffer >= 0) {
                if (bArr.length < bufferInfo.size) {
                    Log.e("array is too small " + bArr.length + " < " + bufferInfo.size);
                }
                if (bufferInfo.flags == 2) {
                    Log.i("JUST READ MediaCodec.BUFFER_FLAG_CODEC_CONFIG buffer");
                }
                byteBufferArr[iDequeueOutputBuffer].get(bArr, 0, bufferInfo.size);
                byteBufferArr[iDequeueOutputBuffer].position(0);
                mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                return bufferInfo.size;
            }
            if (iDequeueOutputBuffer == -3) {
                return -3;
            }
            if (iDequeueOutputBuffer == -2) {
                Log.i("MediaCodec.INFO_OUTPUT_FORMAT_CHANGED");
                Log.i("CHANNEL_COUNT: " + mediaCodec.getOutputFormat().getInteger("channel-count"));
                Log.i("SAMPLE_RATE: " + mediaCodec.getOutputFormat().getInteger("sample-rate"));
            }
        }
        return 0;
    }
}
