package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* loaded from: classes2.dex */
final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private final MediaPeriod[] a;
    private final CompositeSequenceableLoaderFactory c;
    private MediaPeriod.Callback f;
    private TrackGroupArray g;
    private SequenceableLoader i;
    private final ArrayList d = new ArrayList();
    private final HashMap e = new HashMap();
    private final IdentityHashMap b = new IdentityHashMap();
    private MediaPeriod[] h = new MediaPeriod[0];

    private static final class ForwardingTrackSelection implements InterfaceC13679ge2 {
        private final InterfaceC13679ge2 a;
        private final TrackGroup b;

        public ForwardingTrackSelection(InterfaceC13679ge2 interfaceC13679ge2, TrackGroup trackGroup) {
            this.a = interfaceC13679ge2;
            this.b = trackGroup;
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public int a() {
            return this.a.a();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public boolean b(int i, long j) {
            return this.a.b(i, j);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public boolean c(int i, long j) {
            return this.a.c(i, j);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public boolean d(long j, Chunk chunk, List list) {
            return this.a.d(j, chunk, list);
        }

        @Override // ir.nasim.InterfaceC5774Kt7
        public X e(int i) {
            return this.a.e(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            return this.a.equals(forwardingTrackSelection.a) && this.b.equals(forwardingTrackSelection.b);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void f() {
            this.a.f();
        }

        @Override // ir.nasim.InterfaceC5774Kt7
        public int g(int i) {
            return this.a.g(i);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void h(float f) {
            this.a.h(f);
        }

        public int hashCode() {
            return ((527 + this.b.hashCode()) * 31) + this.a.hashCode();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public Object i() {
            return this.a.i();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void j() {
            this.a.j();
        }

        @Override // ir.nasim.InterfaceC5774Kt7
        public int k(int i) {
            return this.a.k(i);
        }

        @Override // ir.nasim.InterfaceC5774Kt7
        public TrackGroup l() {
            return this.b;
        }

        @Override // ir.nasim.InterfaceC5774Kt7
        public int length() {
            return this.a.length();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void m(boolean z) {
            this.a.m(z);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void n() {
            this.a.n();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public int o(long j, List list) {
            return this.a.o(j, list);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void p(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.a.p(j, j2, j3, list, mediaChunkIteratorArr);
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public int q() {
            return this.a.q();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public X r() {
            return this.a.r();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public int s() {
            return this.a.s();
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void t() {
            this.a.t();
        }
    }

    private static final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        private final MediaPeriod a;
        private final long b;
        private MediaPeriod.Callback c;

        public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long j) {
            this.a = mediaPeriod;
            this.b = j;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long a() {
            long jA = this.a.a();
            if (jA == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.b + jA;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean c() {
            return this.a.c();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public boolean d(long j) {
            return this.a.d(j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public long e() {
            long jE = this.a.e();
            if (jE == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.b + jE;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
        public void f(long j) {
            this.a.f(j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
            SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
            int i = 0;
            while (true) {
                SampleStream sampleStreamA = null;
                if (i >= sampleStreamArr.length) {
                    break;
                }
                TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr[i];
                if (timeOffsetSampleStream != null) {
                    sampleStreamA = timeOffsetSampleStream.a();
                }
                sampleStreamArr2[i] = sampleStreamA;
                i++;
            }
            long jI = this.a.i(interfaceC13679ge2Arr, zArr, sampleStreamArr2, zArr2, j - this.b);
            for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
                SampleStream sampleStream = sampleStreamArr2[i2];
                if (sampleStream == null) {
                    sampleStreamArr[i2] = null;
                } else {
                    SampleStream sampleStream2 = sampleStreamArr[i2];
                    if (sampleStream2 == null || ((TimeOffsetSampleStream) sampleStream2).a() != sampleStream) {
                        sampleStreamArr[i2] = new TimeOffsetSampleStream(sampleStream, this.b);
                    }
                }
            }
            return jI + this.b;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
        public void j(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) AbstractC20011rK.e(this.c)).j(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long k(long j) {
            return this.a.k(j - this.b) + this.b;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long l() {
            long jL = this.a.l();
            if (jL == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.b + jL;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void m(MediaPeriod.Callback callback, long j) {
            this.c = callback;
            this.a.m(this, j - this.b);
        }

        @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public void g(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) AbstractC20011rK.e(this.c)).g(this);
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void q() {
            this.a.q();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public long r(long j, C22738vk6 c22738vk6) {
            return this.a.r(j - this.b, c22738vk6) + this.b;
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public TrackGroupArray t() {
            return this.a.t();
        }

        @Override // com.google.android.exoplayer2.source.MediaPeriod
        public void u(long j, boolean z) {
            this.a.u(j - this.b, z);
        }
    }

    private static final class TimeOffsetSampleStream implements SampleStream {
        private final SampleStream a;
        private final long b;

        public TimeOffsetSampleStream(SampleStream sampleStream, long j) {
            this.a = sampleStream;
            this.b = j;
        }

        public SampleStream a() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() {
            this.a.b();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return this.a.h();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            int iO = this.a.o(c21664tv2, decoderInputBuffer, i);
            if (iO == -4) {
                decoderInputBuffer.e = Math.max(0L, decoderInputBuffer.e + this.b);
            }
            return iO;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            return this.a.s(j - this.b);
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.c = compositeSequenceableLoaderFactory;
        this.a = mediaPeriodArr;
        this.i = compositeSequenceableLoaderFactory.a(new SequenceableLoader[0]);
        for (int i = 0; i < mediaPeriodArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.a[i] = new TimeOffsetMediaPeriod(mediaPeriodArr[i], j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        return this.i.a();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.i.c();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        if (this.d.isEmpty()) {
            return this.i.d(j);
        }
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            ((MediaPeriod) this.d.get(i)).d(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        return this.i.e();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
        this.i.f(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        SampleStream sampleStream;
        int[] iArr = new int[interfaceC13679ge2Arr.length];
        int[] iArr2 = new int[interfaceC13679ge2Arr.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            sampleStream = null;
            if (i2 >= interfaceC13679ge2Arr.length) {
                break;
            }
            SampleStream sampleStream2 = sampleStreamArr[i2];
            Integer num = sampleStream2 != null ? (Integer) this.b.get(sampleStream2) : null;
            iArr[i2] = num == null ? -1 : num.intValue();
            InterfaceC13679ge2 interfaceC13679ge2 = interfaceC13679ge2Arr[i2];
            if (interfaceC13679ge2 != null) {
                String str = interfaceC13679ge2.l().b;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        this.b.clear();
        int length = interfaceC13679ge2Arr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[interfaceC13679ge2Arr.length];
        InterfaceC13679ge2[] interfaceC13679ge2Arr2 = new InterfaceC13679ge2[interfaceC13679ge2Arr.length];
        ArrayList arrayList = new ArrayList(this.a.length);
        long j2 = j;
        int i3 = 0;
        InterfaceC13679ge2[] interfaceC13679ge2Arr3 = interfaceC13679ge2Arr2;
        while (i3 < this.a.length) {
            for (int i4 = i; i4 < interfaceC13679ge2Arr.length; i4++) {
                sampleStreamArr3[i4] = iArr[i4] == i3 ? sampleStreamArr[i4] : sampleStream;
                if (iArr2[i4] == i3) {
                    InterfaceC13679ge2 interfaceC13679ge22 = (InterfaceC13679ge2) AbstractC20011rK.e(interfaceC13679ge2Arr[i4]);
                    interfaceC13679ge2Arr3[i4] = new ForwardingTrackSelection(interfaceC13679ge22, (TrackGroup) AbstractC20011rK.e((TrackGroup) this.e.get(interfaceC13679ge22.l())));
                } else {
                    interfaceC13679ge2Arr3[i4] = sampleStream;
                }
            }
            int i5 = i3;
            ArrayList arrayList2 = arrayList;
            InterfaceC13679ge2[] interfaceC13679ge2Arr4 = interfaceC13679ge2Arr3;
            long jI = this.a[i3].i(interfaceC13679ge2Arr3, zArr, sampleStreamArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jI;
            } else if (jI != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < interfaceC13679ge2Arr.length; i6++) {
                if (iArr2[i6] == i5) {
                    SampleStream sampleStream3 = (SampleStream) AbstractC20011rK.e(sampleStreamArr3[i6]);
                    sampleStreamArr2[i6] = sampleStreamArr3[i6];
                    this.b.put(sampleStream3, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    AbstractC20011rK.g(sampleStreamArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.a[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            interfaceC13679ge2Arr3 = interfaceC13679ge2Arr4;
            i = 0;
            sampleStream = null;
        }
        int i7 = i;
        System.arraycopy(sampleStreamArr2, i7, sampleStreamArr, i7, length);
        MediaPeriod[] mediaPeriodArr = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[i7]);
        this.h = mediaPeriodArr;
        this.i = this.c.a(mediaPeriodArr);
        return j2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void j(MediaPeriod mediaPeriod) {
        this.d.remove(mediaPeriod);
        if (!this.d.isEmpty()) {
            return;
        }
        int i = 0;
        for (MediaPeriod mediaPeriod2 : this.a) {
            i += mediaPeriod2.t().a;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.a;
            if (i2 >= mediaPeriodArr.length) {
                this.g = new TrackGroupArray(trackGroupArr);
                ((MediaPeriod.Callback) AbstractC20011rK.e(this.f)).j(this);
                return;
            }
            TrackGroupArray trackGroupArrayT = mediaPeriodArr[i2].t();
            int i4 = trackGroupArrayT.a;
            int i5 = 0;
            while (i5 < i4) {
                TrackGroup trackGroupC = trackGroupArrayT.c(i5);
                TrackGroup trackGroupC2 = trackGroupC.c(i2 + ":" + trackGroupC.b);
                this.e.put(trackGroupC2, trackGroupC);
                trackGroupArr[i3] = trackGroupC2;
                i5++;
                i3++;
            }
            i2++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long k(long j) {
        long jK = this.h[0].k(j);
        int i = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.h;
            if (i >= mediaPeriodArr.length) {
                return jK;
            }
            if (mediaPeriodArr[i].k(jK) != jK) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long l() {
        long j = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.h) {
            long jL = mediaPeriod.l();
            if (jL == -9223372036854775807L) {
                if (j != -9223372036854775807L && mediaPeriod.k(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == -9223372036854775807L) {
                for (MediaPeriod mediaPeriod2 : this.h) {
                    if (mediaPeriod2 == mediaPeriod) {
                        break;
                    }
                    if (mediaPeriod2.k(jL) != jL) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jL;
            } else if (jL != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void m(MediaPeriod.Callback callback, long j) {
        this.f = callback;
        Collections.addAll(this.d, this.a);
        for (MediaPeriod mediaPeriod : this.a) {
            mediaPeriod.m(this, j);
        }
    }

    public MediaPeriod n(int i) {
        MediaPeriod mediaPeriod = this.a[i];
        return mediaPeriod instanceof TimeOffsetMediaPeriod ? ((TimeOffsetMediaPeriod) mediaPeriod).a : mediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void g(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) AbstractC20011rK.e(this.f)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void q() {
        for (MediaPeriod mediaPeriod : this.a) {
            mediaPeriod.q();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long r(long j, C22738vk6 c22738vk6) {
        MediaPeriod[] mediaPeriodArr = this.h;
        return (mediaPeriodArr.length > 0 ? mediaPeriodArr[0] : this.a[0]).r(j, c22738vk6);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray t() {
        return (TrackGroupArray) AbstractC20011rK.e(this.g);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void u(long j, boolean z) {
        for (MediaPeriod mediaPeriod : this.h) {
            mediaPeriod.u(j, z);
        }
    }
}
