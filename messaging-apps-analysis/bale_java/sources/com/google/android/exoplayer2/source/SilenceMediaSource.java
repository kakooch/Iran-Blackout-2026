package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class SilenceMediaSource extends BaseMediaSource {
    private static final X j;
    private static final C2018a0 k;
    private static final byte[] l;
    private final long h;
    private final C2018a0 i;

    public static final class Factory {
    }

    private static final class SilenceMediaPeriod implements MediaPeriod {
        private static final TrackGroupArray c = new TrackGroupArray(new TrackGroup(SilenceMediaSource.j));
        private final long a;
        private final ArrayList b = new ArrayList();

        public SilenceMediaPeriod(long j) {
            this.a = j;
        }

        private long b(long j) {
            return AbstractC9683aN7.q(j, 0L, this.a);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long a() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean c() {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean d(long j) {
            return false;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long e() {
            return Long.MIN_VALUE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void f(long j) {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            long jB = b(j);
            for (int i = 0; i < interfaceC13679ge2Arr.length; i++) {
                SampleStream sampleStream = sampleStreamArr[i];
                if (sampleStream != null && (interfaceC13679ge2Arr[i] == null || !zArr[i])) {
                    this.b.remove(sampleStream);
                    sampleStreamArr[i] = null;
                }
                if (sampleStreamArr[i] == null && interfaceC13679ge2Arr[i] != null) {
                    SilenceSampleStream silenceSampleStream = new SilenceSampleStream(this.a);
                    silenceSampleStream.a(jB);
                    this.b.add(silenceSampleStream);
                    sampleStreamArr[i] = silenceSampleStream;
                    zArr2[i] = true;
                }
            }
            return jB;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long k(long j) {
            long jB = b(j);
            for (int i = 0; i < this.b.size(); i++) {
                ((SilenceSampleStream) this.b.get(i)).a(jB);
            }
            return jB;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long l() {
            return -9223372036854775807L;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void m(MediaPeriod.Callback callback, long j) {
            callback.j(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void q() {
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long r(long j, C22738vk6 c22738vk6) {
            return b(j);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray t() {
            return c;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void u(long j, boolean z) {
        }
    }

    private static final class SilenceSampleStream implements SampleStream {
        private final long a;
        private boolean b;
        private long c;

        public SilenceSampleStream(long j) {
            this.a = SilenceMediaSource.l0(j);
            a(0L);
        }

        public void a(long j) {
            this.c = AbstractC9683aN7.q(SilenceMediaSource.l0(j), 0L, this.a);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            if (!this.b || (i & 2) != 0) {
                c21664tv2.b = SilenceMediaSource.j;
                this.b = true;
                return -5;
            }
            long j = this.a;
            long j2 = this.c;
            long j3 = j - j2;
            if (j3 == 0) {
                decoderInputBuffer.o(4);
                return -4;
            }
            decoderInputBuffer.e = SilenceMediaSource.m0(j2);
            decoderInputBuffer.o(1);
            int iMin = (int) Math.min(SilenceMediaSource.l.length, j3);
            if ((i & 4) == 0) {
                decoderInputBuffer.z(iMin);
                decoderInputBuffer.c.put(SilenceMediaSource.l, 0, iMin);
            }
            if ((i & 1) == 0) {
                this.c += iMin;
            }
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            long j2 = this.c;
            a(j);
            return (int) ((this.c - j2) / SilenceMediaSource.l.length);
        }
    }

    static {
        X xG = new X.b().g0("audio/raw").J(2).h0(44100).a0(2).G();
        j = xG;
        k = new C2018a0.c().e("SilenceMediaSource").j(Uri.EMPTY).g(xG.l).a();
        l = new byte[AbstractC9683aN7.c0(2, 2) * 1024];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l0(long j2) {
        return AbstractC9683aN7.c0(2, 2) * ((j2 * 44100) / 1000000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long m0(long j2) {
        return ((j2 / AbstractC9683aN7.c0(2, 2)) * 1000000) / 44100;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void J() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j2) {
        return new SilenceMediaPeriod(this.h);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        f0(new SinglePeriodTimeline(this.h, true, false, false, null, this.i));
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.i;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
    }
}
