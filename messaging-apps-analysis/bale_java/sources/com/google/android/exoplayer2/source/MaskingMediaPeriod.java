package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC19684qm;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public final MediaSource.MediaPeriodId a;
    private final long b;
    private final InterfaceC19684qm c;
    private MediaSource d;
    private MediaPeriod e;
    private MediaPeriod.Callback f;
    private PrepareListener g;
    private boolean h;
    private long i = -9223372036854775807L;

    public interface PrepareListener {
        void a(MediaSource.MediaPeriodId mediaPeriodId);

        void b(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        this.a = mediaPeriodId;
        this.c = interfaceC19684qm;
        this.b = j;
    }

    private long s(long j) {
        long j2 = this.i;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).a();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        MediaPeriod mediaPeriod = this.e;
        return mediaPeriod != null && mediaPeriod.c();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        MediaPeriod mediaPeriod = this.e;
        return mediaPeriod != null && mediaPeriod.d(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).e();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
        ((MediaPeriod) AbstractC9683aN7.j(this.e)).f(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.i;
        if (j3 == -9223372036854775807L || j != this.b) {
            j2 = j;
        } else {
            this.i = -9223372036854775807L;
            j2 = j3;
        }
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).i(interfaceC13679ge2Arr, zArr, sampleStreamArr, zArr2, j2);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void j(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) AbstractC9683aN7.j(this.f)).j(this);
        PrepareListener prepareListener = this.g;
        if (prepareListener != null) {
            prepareListener.a(this.a);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long k(long j) {
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).k(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long l() {
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).l();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void m(MediaPeriod.Callback callback, long j) {
        this.f = callback;
        MediaPeriod mediaPeriod = this.e;
        if (mediaPeriod != null) {
            mediaPeriod.m(this, s(this.b));
        }
    }

    public void n(MediaSource.MediaPeriodId mediaPeriodId) {
        long jS = s(this.b);
        MediaPeriod mediaPeriodB = ((MediaSource) AbstractC20011rK.e(this.d)).b(mediaPeriodId, this.c, jS);
        this.e = mediaPeriodB;
        if (this.f != null) {
            mediaPeriodB.m(this, jS);
        }
    }

    public long o() {
        return this.i;
    }

    public long p() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void q() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.e;
            if (mediaPeriod != null) {
                mediaPeriod.q();
            } else {
                MediaSource mediaSource = this.d;
                if (mediaSource != null) {
                    mediaSource.J();
                }
            }
        } catch (IOException e) {
            PrepareListener prepareListener = this.g;
            if (prepareListener == null) {
                throw e;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            prepareListener.b(this.a, e);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long r(long j, C22738vk6 c22738vk6) {
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).r(j, c22738vk6);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray t() {
        return ((MediaPeriod) AbstractC9683aN7.j(this.e)).t();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void u(long j, boolean z) {
        ((MediaPeriod) AbstractC9683aN7.j(this.e)).u(j, z);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void g(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) AbstractC9683aN7.j(this.f)).g(this);
    }

    public void w(long j) {
        this.i = j;
    }

    public void x() {
        if (this.e != null) {
            ((MediaSource) AbstractC20011rK.e(this.d)).s(this.e);
        }
    }

    public void y(MediaSource mediaSource) {
        AbstractC20011rK.g(this.d == null);
        this.d = mediaSource;
    }

    public void z(PrepareListener prepareListener) {
        this.g = prepareListener;
    }
}
