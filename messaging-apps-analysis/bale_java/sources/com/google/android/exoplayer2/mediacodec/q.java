package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.j;
import ir.nasim.AbstractC19762qt7;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C8171Uv1;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class q implements j {
    private final MediaCodec a;
    private ByteBuffer[] b;
    private ByteBuffer[] c;

    public static class b implements j.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.mediacodec.q$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // com.google.android.exoplayer2.mediacodec.j.b
        public j a(j.a aVar) throws Throwable {
            MediaCodec mediaCodecB;
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                mediaCodecB = b(aVar);
            } catch (IOException e) {
                e = e;
            } catch (RuntimeException e2) {
                e = e2;
            }
            try {
                AbstractC19762qt7.a("configureCodec");
                mediaCodecB.configure(aVar.b, aVar.d, aVar.e, aVar.f);
                AbstractC19762qt7.c();
                AbstractC19762qt7.a("startCodec");
                mediaCodecB.start();
                AbstractC19762qt7.c();
                return new q(mediaCodecB);
            } catch (IOException | RuntimeException e3) {
                e = e3;
                mediaCodec = mediaCodecB;
                if (mediaCodec != 0) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        protected MediaCodec b(j.a aVar) throws IOException {
            AbstractC20011rK.e(aVar.a);
            String str = aVar.a.a;
            AbstractC19762qt7.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            AbstractC19762qt7.c();
            return mediaCodecCreateByCodecName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(j.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void a(final j.c cVar, Handler handler) {
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: ir.nasim.D47
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.a.j(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void b(int i) {
        this.a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void c(Surface surface) {
        this.a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void d(int i, int i2, C8171Uv1 c8171Uv1, long j, int i3) throws MediaCodec.CryptoException {
        this.a.queueSecureInputBuffer(i, i2, c8171Uv1.a(), j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public boolean e() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void f(int i, long j) {
        this.a.releaseOutputBuffer(i, j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void flush() {
        this.a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public int g() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public ByteBuffer getInputBuffer(int i) {
        return AbstractC9683aN7.a >= 21 ? this.a.getInputBuffer(i) : ((ByteBuffer[]) AbstractC9683aN7.j(this.b))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public ByteBuffer getOutputBuffer(int i) {
        return AbstractC9683aN7.a >= 21 ? this.a.getOutputBuffer(i) : ((ByteBuffer[]) AbstractC9683aN7.j(this.c))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public MediaFormat getOutputFormat() {
        return this.a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public int h(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && AbstractC9683aN7.a < 21) {
                this.c = this.a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) throws MediaCodec.CryptoException {
        this.a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void release() {
        this.b = null;
        this.c = null;
        this.a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void releaseOutputBuffer(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void setParameters(Bundle bundle) {
        this.a.setParameters(bundle);
    }

    private q(MediaCodec mediaCodec) {
        this.a = mediaCodec;
        if (AbstractC9683aN7.a < 21) {
            this.b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }
}
