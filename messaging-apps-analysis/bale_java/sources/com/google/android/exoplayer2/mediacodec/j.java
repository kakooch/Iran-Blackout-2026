package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.X;
import ir.nasim.C8171Uv1;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface j {

    public static final class a {
        public final k a;
        public final MediaFormat b;
        public final X c;
        public final Surface d;
        public final MediaCrypto e;
        public final int f;

        private a(k kVar, MediaFormat mediaFormat, X x, Surface surface, MediaCrypto mediaCrypto, int i) {
            this.a = kVar;
            this.b = mediaFormat;
            this.c = x;
            this.d = surface;
            this.e = mediaCrypto;
            this.f = i;
        }

        public static a a(k kVar, MediaFormat mediaFormat, X x, MediaCrypto mediaCrypto) {
            return new a(kVar, mediaFormat, x, null, mediaCrypto, 0);
        }

        public static a b(k kVar, MediaFormat mediaFormat, X x, Surface surface, MediaCrypto mediaCrypto) {
            return new a(kVar, mediaFormat, x, surface, mediaCrypto, 0);
        }
    }

    public interface b {
        j a(a aVar);
    }

    public interface c {
        void a(j jVar, long j, long j2);
    }

    void a(c cVar, Handler handler);

    void b(int i);

    void c(Surface surface);

    void d(int i, int i2, C8171Uv1 c8171Uv1, long j, int i3);

    boolean e();

    void f(int i, long j);

    void flush();

    int g();

    ByteBuffer getInputBuffer(int i);

    ByteBuffer getOutputBuffer(int i);

    MediaFormat getOutputFormat();

    int h(MediaCodec.BufferInfo bufferInfo);

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void release();

    void releaseOutputBuffer(int i, boolean z);

    void setParameters(Bundle bundle);
}
