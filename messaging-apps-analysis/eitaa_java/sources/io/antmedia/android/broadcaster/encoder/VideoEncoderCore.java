package io.antmedia.android.broadcaster.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import io.antmedia.android.broadcaster.network.IMediaMuxer;
import ir.eitaa.messenger.MediaController;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class VideoEncoderCore {
    private static final String TAG = "VideoEncoderCore";
    private MediaCodec mEncoder;
    private Surface mInputSurface;
    private boolean mMuxerStarted;
    private IMediaMuxer mWriterHandler;
    private Map<Integer, Object> reservedBuffers = new HashMap();
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();

    public VideoEncoderCore(int width, int height, int bitRate, int frameRate, IMediaMuxer writerHandler) throws IOException {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MediaController.VIDEO_MIME_TYPE, width, height);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", bitRate);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", frameRate);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.VIDEO_MIME_TYPE);
        this.mEncoder = mediaCodecCreateEncoderByType;
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mInputSurface = this.mEncoder.createInputSurface();
        this.mEncoder.start();
        this.mWriterHandler = writerHandler;
    }

    public static boolean doesEncoderWork(int width, int height, int bitRate, int frameRate) throws Throwable {
        MediaCodec mediaCodecCreateEncoderByType;
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MediaController.VIDEO_MIME_TYPE, width, height);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", bitRate);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", frameRate);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
        MediaCodec mediaCodec = null;
        try {
            try {
                mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(MediaController.VIDEO_MIME_TYPE);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (IllegalStateException e2) {
            e = e2;
        }
        try {
            mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            mediaCodecCreateEncoderByType.createInputSurface();
            mediaCodecCreateEncoderByType.release();
            return true;
        } catch (IOException e3) {
            e = e3;
            mediaCodec = mediaCodecCreateEncoderByType;
            e.printStackTrace();
            mediaCodec.release();
            return false;
        } catch (IllegalStateException e4) {
            e = e4;
            mediaCodec = mediaCodecCreateEncoderByType;
            e.printStackTrace();
            mediaCodec.release();
            return false;
        } catch (Throwable th2) {
            th = th2;
            mediaCodec = mediaCodecCreateEncoderByType;
            mediaCodec.release();
            throw th;
        }
    }

    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    public void release() {
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mEncoder.release();
            this.mEncoder = null;
        }
    }

    public void drainEncoder(boolean endOfStream) {
        MediaCodec mediaCodec = this.mEncoder;
        if (mediaCodec == null) {
            return;
        }
        if (endOfStream) {
            mediaCodec.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.mEncoder.getOutputBuffers();
        while (true) {
            int iDequeueOutputBuffer = this.mEncoder.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (iDequeueOutputBuffer == -1) {
                if (!endOfStream) {
                    return;
                }
            } else if (iDequeueOutputBuffer == -3) {
                outputBuffers = this.mEncoder.getOutputBuffers();
                Log.d("VideoEncoder", "INFO_OUTPUT_BUFFERS_CHANGED");
            } else if (iDequeueOutputBuffer == -2) {
                if (this.mMuxerStarted) {
                    throw new RuntimeException("format changed twice");
                }
                MediaFormat outputFormat = this.mEncoder.getOutputFormat();
                ByteBuffer byteBuffer = outputFormat.getByteBuffer("csd-0");
                ByteBuffer byteBuffer2 = outputFormat.getByteBuffer("csd-1");
                int iLimit = byteBuffer.limit() + byteBuffer2.limit();
                byte[] bArr = new byte[iLimit];
                byteBuffer.get(bArr, 0, byteBuffer.limit());
                byteBuffer2.get(bArr, byteBuffer.limit(), byteBuffer2.limit());
                this.mWriterHandler.writeVideo(bArr, iLimit, 0);
                Log.d(TAG, "encoder output format changed: " + outputFormat);
                this.mMuxerStarted = true;
            } else if (iDequeueOutputBuffer < 0) {
                Log.w(TAG, "unexpected result from encoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
            } else {
                ByteBuffer byteBuffer3 = outputBuffers[iDequeueOutputBuffer];
                if (byteBuffer3 == null) {
                    throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                }
                MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                if ((bufferInfo.flags & 2) != 0) {
                    bufferInfo.size = 0;
                }
                if (bufferInfo.size != 0) {
                    if (!this.mMuxerStarted) {
                        throw new RuntimeException("muxer hasn't started");
                    }
                    byteBuffer3.position(bufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
                    byteBuffer3.limit(bufferInfo2.offset + bufferInfo2.size);
                    MediaCodec.BufferInfo bufferInfo3 = this.mBufferInfo;
                    int i = (int) (bufferInfo3.presentationTimeUs / 1000);
                    byte[] buffer = getBuffer(bufferInfo3.size, this.mWriterHandler.getLastVideoFrameTimeStamp(), i);
                    byteBuffer3.get(buffer, 0, this.mBufferInfo.size);
                    byteBuffer3.position(this.mBufferInfo.offset);
                    this.mWriterHandler.writeVideo(buffer, this.mBufferInfo.size, i);
                }
                this.mEncoder.releaseOutputBuffer(iDequeueOutputBuffer, false);
                if ((this.mBufferInfo.flags & 4) != 0) {
                    if (!endOfStream) {
                        Log.w(TAG, "reached end of stream unexpectedly");
                    }
                    this.reservedBuffers.clear();
                    return;
                }
            }
        }
    }

    private byte[] getBuffer(int size, int lastSentFrameTimestamp, int currentTimeStamp) {
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

    public void stopMuxer() {
        IMediaMuxer iMediaMuxer = this.mWriterHandler;
        if (iMediaMuxer != null) {
            iMediaMuxer.stopMuxer();
            this.mWriterHandler = null;
        }
    }
}
