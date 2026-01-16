package ir.nasim;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class HO {
    private ByteBuffer[] a;
    private ByteBuffer[] b;
    private ByteBuffer[] c;
    private ByteBuffer[] d;
    private final MediaCodec g;
    private final MediaCodec h;
    private final MediaExtractor i;
    private final int n;
    public final MediaFormat r;
    private final MediaCodec.BufferInfo e = new MediaCodec.BufferInfo();
    private final MediaCodec.BufferInfo f = new MediaCodec.BufferInfo();
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private int m = -1;
    private final int o = 2500;
    public long p = 0;
    public long q = 0;

    public HO(MediaFormat mediaFormat, MediaExtractor mediaExtractor, int i) throws IOException {
        this.i = mediaExtractor;
        this.n = i;
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(mediaFormat.getString("mime"));
        this.g = mediaCodecCreateDecoderByType;
        mediaCodecCreateDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.h = mediaCodecCreateEncoderByType;
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", mediaFormat.getInteger("sample-rate"), mediaFormat.getInteger("channel-count"));
        this.r = mediaFormatCreateAudioFormat;
        mediaFormatCreateAudioFormat.setInteger("bitrate", 65536);
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        mediaCodecCreateEncoderByType.start();
        this.a = mediaCodecCreateDecoderByType.getInputBuffers();
        this.b = mediaCodecCreateDecoderByType.getOutputBuffers();
        this.c = mediaCodecCreateEncoderByType.getInputBuffers();
        this.d = mediaCodecCreateEncoderByType.getOutputBuffers();
    }

    public void a() {
        try {
            this.h.stop();
            this.g.stop();
            this.i.unselectTrack(this.n);
            this.i.release();
        } catch (Exception e) {
            AbstractC6403Nl2.d(e);
        }
    }

    public boolean b(FL3 fl3, int i) throws MediaCodec.CryptoException {
        int iDequeueOutputBuffer;
        int iDequeueInputBuffer;
        int iDequeueOutputBuffer2;
        int iDequeueInputBuffer2;
        if (!this.j && (iDequeueInputBuffer2 = this.g.dequeueInputBuffer(2500L)) != -1) {
            int sampleData = this.i.readSampleData(this.g.getInputBuffer(iDequeueInputBuffer2), 0);
            long sampleTime = this.i.getSampleTime();
            long j = this.q;
            if (j > 0 && sampleTime >= j) {
                this.l = true;
                this.e.flags |= 4;
            }
            if (sampleData >= 0) {
                this.g.queueInputBuffer(iDequeueInputBuffer2, 0, sampleData, this.i.getSampleTime(), this.i.getSampleFlags());
            }
            boolean z = !this.i.advance();
            this.j = z;
            if (z) {
                this.g.queueInputBuffer(this.g.dequeueInputBuffer(2500L), 0, 0, 0L, 4);
            }
        }
        if (!this.k && this.m == -1 && (iDequeueOutputBuffer2 = this.g.dequeueOutputBuffer(this.e, 2500L)) != -1) {
            if (iDequeueOutputBuffer2 == -3) {
                this.b = this.g.getOutputBuffers();
            } else if (iDequeueOutputBuffer2 != -2) {
                if ((this.e.flags & 2) != 0) {
                    this.g.releaseOutputBuffer(iDequeueOutputBuffer2, false);
                } else {
                    this.m = iDequeueOutputBuffer2;
                }
            }
        }
        if (this.m != -1 && (iDequeueInputBuffer = this.h.dequeueInputBuffer(2500L)) != -1) {
            ByteBuffer byteBuffer = this.c[iDequeueInputBuffer];
            MediaCodec.BufferInfo bufferInfo = this.e;
            int i2 = bufferInfo.size;
            long j2 = bufferInfo.presentationTimeUs;
            if (i2 >= 0) {
                ByteBuffer byteBufferDuplicate = this.b[this.m].duplicate();
                byteBufferDuplicate.position(this.e.offset);
                byteBufferDuplicate.limit(this.e.offset + i2);
                byteBuffer.position(0);
                byteBuffer.put(byteBufferDuplicate);
                this.h.queueInputBuffer(iDequeueInputBuffer, 0, i2, j2, this.e.flags);
            }
            this.g.releaseOutputBuffer(this.m, false);
            this.m = -1;
            if ((this.e.flags & 4) != 0) {
                this.k = true;
            }
        }
        if (!this.l && (iDequeueOutputBuffer = this.h.dequeueOutputBuffer(this.f, 2500L)) != -1) {
            if (iDequeueOutputBuffer == -3) {
                this.d = this.h.getOutputBuffers();
            } else if (iDequeueOutputBuffer != -2) {
                ByteBuffer byteBuffer2 = this.d[iDequeueOutputBuffer];
                MediaCodec.BufferInfo bufferInfo2 = this.f;
                if ((bufferInfo2.flags & 2) != 0) {
                    this.h.releaseOutputBuffer(iDequeueOutputBuffer, false);
                } else {
                    if (bufferInfo2.size != 0) {
                        fl3.s(i, byteBuffer2, bufferInfo2, false);
                    }
                    if ((this.f.flags & 4) != 0) {
                        this.l = true;
                    }
                    this.h.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
            }
        }
        return this.l;
    }
}
