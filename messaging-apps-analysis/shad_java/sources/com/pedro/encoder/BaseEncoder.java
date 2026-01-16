package com.pedro.encoder;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.pedro.encoder.utils.CodecUtil;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class BaseEncoder implements EncoderCallback {
    protected MediaCodec codec;
    protected long presentTimeUs;
    private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    protected volatile boolean running = false;
    protected boolean isBufferMode = true;
    protected CodecUtil.Force force = CodecUtil.Force.FIRST_COMPATIBLE_FOUND;

    protected abstract void checkBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    protected abstract Frame getInputFrame() throws InterruptedException;

    protected abstract void sendBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    public abstract void start(boolean z);

    protected abstract void stopImp();

    public void start() {
        start(true);
    }

    public void stop() {
        this.running = false;
        stopImp();
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            final MediaCodec[] mediaCodecArr = {mediaCodec};
            this.codec = null;
            final HandlerThread handlerThread = new HandlerThread("codecrelease");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable(this) { // from class: com.pedro.encoder.BaseEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        mediaCodecArr[0].release();
                        mediaCodecArr[0] = null;
                    } catch (IllegalStateException | NullPointerException unused) {
                        mediaCodecArr[0] = null;
                    }
                    if (Build.VERSION.SDK_INT >= 18) {
                        handlerThread.quitSafely();
                    } else {
                        handlerThread.quit();
                    }
                }
            });
        }
    }

    protected void getDataFromEncoder(Frame frame) throws IllegalStateException, MediaCodec.CryptoException {
        int iDequeueInputBuffer;
        if (this.isBufferMode && (iDequeueInputBuffer = this.codec.dequeueInputBuffer(0L)) >= 0) {
            inputAvailable(this.codec, iDequeueInputBuffer, frame);
        }
        while (this.running) {
            int iDequeueOutputBuffer = this.codec.dequeueOutputBuffer(this.bufferInfo, 0L);
            if (iDequeueOutputBuffer == -2) {
                formatChanged(this.codec, this.codec.getOutputFormat());
            } else if (iDequeueOutputBuffer < 0) {
                return;
            } else {
                outputAvailable(this.codec, iDequeueOutputBuffer, this.bufferInfo);
            }
        }
    }

    private void processInput(ByteBuffer byteBuffer, MediaCodec mediaCodec, int i, Frame frame) throws IllegalStateException, MediaCodec.CryptoException {
        if (frame == null) {
            try {
                frame = getInputFrame();
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        byteBuffer.clear();
        byteBuffer.put(frame.getBuffer(), frame.getOffset(), frame.getSize());
        mediaCodec.queueInputBuffer(i, 0, frame.getSize(), (System.nanoTime() / 1000) - this.presentTimeUs, 0);
    }

    private void processOutput(ByteBuffer byteBuffer, MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) throws IllegalStateException {
        checkBuffer(byteBuffer, bufferInfo);
        sendBuffer(byteBuffer, bufferInfo);
        mediaCodec.releaseOutputBuffer(i, false);
    }

    public boolean isRunning() {
        return this.running;
    }

    public void inputAvailable(MediaCodec mediaCodec, int i, Frame frame) throws IllegalStateException, MediaCodec.CryptoException {
        ByteBuffer inputBuffer;
        if (Build.VERSION.SDK_INT >= 21) {
            inputBuffer = mediaCodec.getInputBuffer(i);
        } else {
            inputBuffer = mediaCodec.getInputBuffers()[i];
        }
        processInput(inputBuffer, mediaCodec, i, frame);
    }

    public void outputAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) throws IllegalStateException {
        ByteBuffer outputBuffer;
        if (Build.VERSION.SDK_INT >= 21) {
            outputBuffer = mediaCodec.getOutputBuffer(i);
        } else {
            outputBuffer = mediaCodec.getOutputBuffers()[i];
        }
        processOutput(outputBuffer, mediaCodec, i, bufferInfo);
    }
}
