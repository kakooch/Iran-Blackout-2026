package io.sentry.android.replay.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import ir.nasim.AbstractC13042fc3;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class b {
    private final long a;
    private final MediaMuxer b;
    private boolean c;
    private int d;
    private int e;
    private long f;

    public b(String str, float f) {
        AbstractC13042fc3.i(str, "path");
        this.a = (long) (TimeUnit.SECONDS.toMicros(1L) / f);
        this.b = new MediaMuxer(str, 0);
    }

    public long a() {
        if (this.e == 0) {
            return 0L;
        }
        return TimeUnit.MILLISECONDS.convert(this.f + this.a, TimeUnit.MICROSECONDS);
    }

    public boolean b() {
        return this.c;
    }

    public void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AbstractC13042fc3.i(byteBuffer, "encodedData");
        AbstractC13042fc3.i(bufferInfo, "bufferInfo");
        long j = this.a;
        int i = this.e;
        this.e = i + 1;
        long j2 = j * i;
        this.f = j2;
        bufferInfo.presentationTimeUs = j2;
        this.b.writeSampleData(this.d, byteBuffer, bufferInfo);
    }

    public void d() {
        this.b.stop();
        this.b.release();
    }

    public void e(MediaFormat mediaFormat) {
        AbstractC13042fc3.i(mediaFormat, "videoFormat");
        this.d = this.b.addTrack(mediaFormat);
        this.b.start();
        this.c = true;
    }
}
