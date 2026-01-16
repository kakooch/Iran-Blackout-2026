package com.google.android.exoplayer2.mediacodec;

import android.gov.nist.core.Separators;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.mediacodec.j;
import ir.nasim.AbstractC19762qt7;
import ir.nasim.C8171Uv1;
import ir.nasim.Q17;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements j {
    private final MediaCodec a;
    private final e b;
    private final c c;
    private final boolean d;
    private boolean e;
    private int f;

    /* renamed from: com.google.android.exoplayer2.mediacodec.b$b, reason: collision with other inner class name */
    public static final class C0161b implements j.b {
        private final Q17 a;
        private final Q17 b;
        private final boolean c;

        public C0161b(final int i, boolean z) {
            this(new Q17() { // from class: ir.nasim.JL
                @Override // ir.nasim.Q17
                public final Object get() {
                    return b.C0161b.e(i);
                }
            }, new Q17() { // from class: ir.nasim.KL
                @Override // ir.nasim.Q17
                public final Object get() {
                    return b.C0161b.f(i);
                }
            }, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread e(int i) {
            return new HandlerThread(b.m(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i) {
            return new HandlerThread(b.n(i));
        }

        @Override // com.google.android.exoplayer2.mediacodec.j.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(j.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            b bVar;
            String str = aVar.a.a;
            b bVar2 = null;
            try {
                AbstractC19762qt7.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    bVar = new b(mediaCodecCreateByCodecName, (HandlerThread) this.a.get(), (HandlerThread) this.b.get(), this.c);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                mediaCodecCreateByCodecName = null;
            }
            try {
                AbstractC19762qt7.c();
                bVar.p(aVar.b, aVar.d, aVar.e, aVar.f);
                return bVar;
            } catch (Exception e3) {
                e = e3;
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.release();
                } else if (mediaCodecCreateByCodecName != null) {
                    mediaCodecCreateByCodecName.release();
                }
                throw e;
            }
        }

        C0161b(Q17 q17, Q17 q172, boolean z) {
            this.a = q17;
            this.b = q172;
            this.c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m(int i) {
        return o(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n(int i) {
        return o(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String o(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(Separators.RPAREN);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.b.h(this.a);
        AbstractC19762qt7.a("configureCodec");
        this.a.configure(mediaFormat, surface, mediaCrypto, i);
        AbstractC19762qt7.c();
        this.c.q();
        AbstractC19762qt7.a("startCodec");
        this.a.start();
        AbstractC19762qt7.c();
        this.f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(j.c cVar, MediaCodec mediaCodec, long j, long j2) {
        cVar.a(this, j, j2);
    }

    private void r() {
        if (this.d) {
            try {
                this.c.r();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void a(final j.c cVar, Handler handler) {
        r();
        this.a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: com.google.android.exoplayer2.mediacodec.a
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.a.q(cVar, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void b(int i) {
        r();
        this.a.setVideoScalingMode(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void c(Surface surface) {
        r();
        this.a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void d(int i, int i2, C8171Uv1 c8171Uv1, long j, int i3) {
        this.c.n(i, i2, c8171Uv1, j, i3);
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
        this.c.i();
        this.a.flush();
        this.b.e();
        this.a.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public int g() {
        return this.b.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public ByteBuffer getInputBuffer(int i) {
        return this.a.getInputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public ByteBuffer getOutputBuffer(int i) {
        return this.a.getOutputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public MediaFormat getOutputFormat() {
        return this.b.g();
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public int h(MediaCodec.BufferInfo bufferInfo) {
        return this.b.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.c.m(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void release() {
        try {
            if (this.f == 1) {
                this.c.p();
                this.b.o();
            }
            this.f = 2;
            if (this.e) {
                return;
            }
            this.a.release();
            this.e = true;
        } catch (Throwable th) {
            if (!this.e) {
                this.a.release();
                this.e = true;
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void releaseOutputBuffer(int i, boolean z) {
        this.a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.j
    public void setParameters(Bundle bundle) {
        r();
        this.a.setParameters(bundle);
    }

    private b(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z) {
        this.a = mediaCodec;
        this.b = new e(handlerThread);
        this.c = new c(mediaCodec, handlerThread2);
        this.d = z;
        this.f = 0;
    }
}
