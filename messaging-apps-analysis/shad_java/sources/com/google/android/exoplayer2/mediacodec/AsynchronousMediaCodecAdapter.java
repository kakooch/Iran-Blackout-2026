package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class AsynchronousMediaCodecAdapter extends MediaCodec.Callback implements MediaCodecAdapter {
    private final MediaCodecInputBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private Handler handler;
    private final HandlerThread handlerThread;
    private IllegalStateException internalException;
    private final Object lock;
    private final MediaCodecAsyncCallback mediaCodecAsyncCallback;
    private long pendingFlushCount;
    private int state;

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, int i) {
        this(mediaCodec, false, i, new HandlerThread(createThreadLabel(i)));
    }

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i) {
        this(mediaCodec, z, i, new HandlerThread(createThreadLabel(i)));
    }

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i, HandlerThread handlerThread) {
        MediaCodecInputBufferEnqueuer synchronousMediaCodecBufferEnqueuer;
        this.lock = new Object();
        this.mediaCodecAsyncCallback = new MediaCodecAsyncCallback();
        this.codec = mediaCodec;
        this.handlerThread = handlerThread;
        if (z) {
            synchronousMediaCodecBufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, i);
        } else {
            synchronousMediaCodecBufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(mediaCodec);
        }
        this.bufferEnqueuer = synchronousMediaCodecBufferEnqueuer;
        this.state = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.handlerThread.start();
        Handler handler = new Handler(this.handlerThread.getLooper());
        this.handler = handler;
        this.codec.setCallback(this, handler);
        this.codec.configure(mediaFormat, surface, mediaCrypto, i);
        this.state = 1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void start() {
        this.bufferEnqueuer.start();
        this.codec.start();
        this.state = 2;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueInputBufferIndex() {
        synchronized (this.lock) {
            if (isFlushing()) {
                return -1;
            }
            maybeThrowException();
            return this.mediaCodecAsyncCallback.dequeueInputBufferIndex();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.lock) {
            if (isFlushing()) {
                return -1;
            }
            maybeThrowException();
            return this.mediaCodecAsyncCallback.dequeueOutputBufferIndex(bufferInfo);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaFormat getOutputFormat() {
        MediaFormat outputFormat;
        synchronized (this.lock) {
            outputFormat = this.mediaCodecAsyncCallback.getOutputFormat();
        }
        return outputFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void flush() {
        synchronized (this.lock) {
            this.bufferEnqueuer.flush();
            this.codec.flush();
            this.pendingFlushCount++;
            ((Handler) Util.castNonNull(this.handler)).post(new Runnable() { // from class: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onFlushCompleted();
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public void shutdown() {
        synchronized (this.lock) {
            if (this.state == 2) {
                this.bufferEnqueuer.shutdown();
            }
            int i = this.state;
            if (i == 1 || i == 2) {
                this.handlerThread.quit();
                this.mediaCodecAsyncCallback.flush();
                this.pendingFlushCount++;
            }
            this.state = 3;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter
    public MediaCodec getCodec() {
        return this.codec;
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onInputBufferAvailable(mediaCodec, i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onOutputBufferAvailable(mediaCodec, i, bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onError(mediaCodec, codecException);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.lock) {
            this.mediaCodecAsyncCallback.onOutputFormatChanged(mediaCodec, mediaFormat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlushCompleted() {
        synchronized (this.lock) {
            onFlushCompletedSynchronized();
        }
    }

    private void onFlushCompletedSynchronized() {
        if (this.state == 3) {
            return;
        }
        long j = this.pendingFlushCount - 1;
        this.pendingFlushCount = j;
        if (j > 0) {
            return;
        }
        if (j < 0) {
            this.internalException = new IllegalStateException();
            return;
        }
        this.mediaCodecAsyncCallback.flush();
        try {
            this.codec.start();
        } catch (IllegalStateException e) {
            this.internalException = e;
        } catch (Exception e2) {
            this.internalException = new IllegalStateException(e2);
        }
    }

    private boolean isFlushing() {
        return this.pendingFlushCount > 0;
    }

    private void maybeThrowException() throws IllegalStateException {
        maybeThrowInternalException();
        this.mediaCodecAsyncCallback.maybeThrowMediaCodecException();
    }

    private void maybeThrowInternalException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException == null) {
            return;
        }
        this.internalException = null;
        throw illegalStateException;
    }

    private static String createThreadLabel(int i) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }
}
