package io.antmedia.android.broadcaster.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import ir.eitaa.messenger.MediaController;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class AudioEncoder extends Thread {
    private static long previousPresentationTimeUs;
    private static long roundOffset;
    private static int roundTimes;
    private MediaCodec mAudioEncoder;
    private ByteBuffer[] mAudioInputBuffers;
    private ByteBuffer[] mAudioOutputBuffers;
    private IMediaMuxer mMuxerHandler;
    final int TIMEOUT_USEC = 10000;
    private Map<Integer, Object> reservedBuffers = new HashMap();

    public static long getUnsignedInt(long x) {
        return x & 4294967295L;
    }

    public boolean startAudioEncoder(int sampleRate, int channelCount, int bitrate, int maxInputSize, IMediaMuxer muxerHandler) throws IOException {
        this.mMuxerHandler = muxerHandler;
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(MediaController.AUIDO_MIME_TYPE, sampleRate, channelCount);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("bitrate", bitrate);
        mediaFormatCreateAudioFormat.setInteger("max-input-size", maxInputSize);
        try {
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.AUIDO_MIME_TYPE);
            this.mAudioEncoder = mediaCodecCreateEncoderByType;
            mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mAudioEncoder.start();
            this.mAudioInputBuffers = this.mAudioEncoder.getInputBuffers();
            this.mAudioOutputBuffers = this.mAudioEncoder.getOutputBuffers();
            start();
            return true;
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
            this.mAudioEncoder = null;
            return false;
        }
    }

    public void encodeAudio(byte[] data, int length, long pts) throws MediaCodec.CryptoException, InterruptedException {
        if (this.mAudioEncoder == null) {
            return;
        }
        for (int i = 0; i < 3; i++) {
            int iDequeueInputBuffer = this.mAudioEncoder.dequeueInputBuffer(10000L);
            if (iDequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = this.mAudioInputBuffers[iDequeueInputBuffer];
                byteBuffer.clear();
                int iRemaining = byteBuffer.remaining();
                if (iRemaining < length) {
                    byteBuffer.put(data, 0, iRemaining);
                } else {
                    byteBuffer.put(data, 0, length);
                }
                this.mAudioEncoder.queueInputBuffer(iDequeueInputBuffer, 0, byteBuffer.position(), pts, 0);
                return;
            }
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopEncoding() throws MediaCodec.CryptoException, InterruptedException {
        MediaCodec mediaCodec;
        for (int i = 0; i < 3 && (mediaCodec = this.mAudioEncoder) != null; i++) {
            try {
                int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                if (iDequeueInputBuffer >= 0) {
                    this.mAudioEncoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        roundTimes = 0;
        roundOffset = 0L;
        previousPresentationTimeUs = 0L;
        while (true) {
            int iDequeueOutputBuffer = this.mAudioEncoder.dequeueOutputBuffer(bufferInfo, 10000L);
            if (iDequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = this.mAudioOutputBuffers[iDequeueOutputBuffer];
                if (byteBuffer == null) {
                    System.out.println(" encoded data null audio");
                } else {
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    if (previousPresentationTimeUs < 0 && bufferInfo.presentationTimeUs > 0) {
                        int i = roundTimes + 1;
                        roundTimes = i;
                        roundOffset = i * 4294967296L;
                    }
                    int unsignedInt = (int) ((roundOffset + getUnsignedInt(bufferInfo.presentationTimeUs)) / 1000);
                    byte[] buffer = getBuffer(bufferInfo.size, this.mMuxerHandler.getLastAudioFrameTimeStamp(), unsignedInt);
                    byteBuffer.get(buffer, 0, bufferInfo.size);
                    byteBuffer.position(bufferInfo.offset);
                    this.mMuxerHandler.writeAudio(buffer, bufferInfo.size, unsignedInt);
                    previousPresentationTimeUs = bufferInfo.presentationTimeUs;
                    this.mAudioEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
            } else if (iDequeueOutputBuffer == -3) {
                this.mAudioOutputBuffers = this.mAudioEncoder.getOutputBuffers();
            }
            if ((bufferInfo.flags & 4) != 0) {
                this.reservedBuffers.clear();
                release();
                return;
            }
        }
    }

    public byte[] getBuffer(int size, int lastSentFrameTimestamp, int currentTimeStamp) {
        Iterator<Map.Entry<Integer, Object>> it = this.reservedBuffers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Object> next = it.next();
            if (next.getKey().intValue() <= lastSentFrameTimestamp) {
                byte[] bArr = (byte[]) next.getValue();
                it.remove();
                if (bArr.length >= size) {
                    this.reservedBuffers.put(Integer.valueOf(currentTimeStamp), bArr);
                    return bArr;
                }
            }
        }
        byte[] bArr2 = new byte[size];
        this.reservedBuffers.put(Integer.valueOf(currentTimeStamp), bArr2);
        return bArr2;
    }

    private void release() {
        try {
            MediaCodec mediaCodec = this.mAudioEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAudioEncoder.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
