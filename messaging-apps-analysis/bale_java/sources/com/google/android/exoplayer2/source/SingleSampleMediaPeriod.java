package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C19445qM6;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class SingleSampleMediaPeriod implements MediaPeriod, Loader.b {
    private final com.google.android.exoplayer2.upstream.b a;
    private final a.InterfaceC0163a b;
    private final InterfaceC25209zu7 c;
    private final com.google.android.exoplayer2.upstream.j d;
    private final MediaSourceEventListener.EventDispatcher e;
    private final TrackGroupArray f;
    private final long h;
    final X j;
    final boolean k;
    boolean l;
    byte[] m;
    int n;
    private final ArrayList g = new ArrayList();
    final Loader i = new Loader("SingleSampleMediaPeriod");

    private final class SampleStreamImpl implements SampleStream {
        private int a;
        private boolean b;

        private SampleStreamImpl() {
        }

        private void a() {
            if (this.b) {
                return;
            }
            SingleSampleMediaPeriod.this.e.i(AbstractC24462yf4.k(SingleSampleMediaPeriod.this.j.l), SingleSampleMediaPeriod.this.j, 0, null, 0L);
            this.b = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (singleSampleMediaPeriod.k) {
                return;
            }
            singleSampleMediaPeriod.i.j();
        }

        public void c() {
            if (this.a == 2) {
                this.a = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return SingleSampleMediaPeriod.this.l;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            a();
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            boolean z = singleSampleMediaPeriod.l;
            if (z && singleSampleMediaPeriod.m == null) {
                this.a = 2;
            }
            int i2 = this.a;
            if (i2 == 2) {
                decoderInputBuffer.o(4);
                return -4;
            }
            if ((i & 2) != 0 || i2 == 0) {
                c21664tv2.b = singleSampleMediaPeriod.j;
                this.a = 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            AbstractC20011rK.e(singleSampleMediaPeriod.m);
            decoderInputBuffer.o(1);
            decoderInputBuffer.e = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.z(SingleSampleMediaPeriod.this.n);
                ByteBuffer byteBuffer = decoderInputBuffer.c;
                SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                byteBuffer.put(singleSampleMediaPeriod2.m, 0, singleSampleMediaPeriod2.n);
            }
            if ((i & 1) == 0) {
                this.a = 2;
            }
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            a();
            if (j <= 0 || this.a == 2) {
                return 0;
            }
            this.a = 2;
            return 1;
        }
    }

    static final class SourceLoadable implements Loader.e {
        public final long a = LoadEventInfo.a();
        public final com.google.android.exoplayer2.upstream.b b;
        private final C19445qM6 c;
        private byte[] d;

        public SourceLoadable(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.upstream.a aVar) {
            this.b = bVar;
            this.c = new C19445qM6(aVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void a() {
            this.c.q();
            try {
                this.c.b(this.b);
                int i = 0;
                while (i != -1) {
                    int iN = (int) this.c.n();
                    byte[] bArr = this.d;
                    if (bArr == null) {
                        this.d = new byte[1024];
                    } else if (iN == bArr.length) {
                        this.d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    C19445qM6 c19445qM6 = this.c;
                    byte[] bArr2 = this.d;
                    i = c19445qM6.read(bArr2, iN, bArr2.length - iN);
                }
                AbstractC22885vz1.a(this.c);
            } catch (Throwable th) {
                AbstractC22885vz1.a(this.c);
                throw th;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
        }
    }

    public SingleSampleMediaPeriod(com.google.android.exoplayer2.upstream.b bVar, a.InterfaceC0163a interfaceC0163a, InterfaceC25209zu7 interfaceC25209zu7, X x, long j, com.google.android.exoplayer2.upstream.j jVar, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.a = bVar;
        this.b = interfaceC0163a;
        this.c = interfaceC25209zu7;
        this.j = x;
        this.h = j;
        this.d = jVar;
        this.e = eventDispatcher;
        this.k = z;
        this.f = new TrackGroupArray(new TrackGroup(x));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        return (this.l || this.i.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.i.i();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        if (this.l || this.i.i() || this.i.h()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.a aVarA = this.b.a();
        InterfaceC25209zu7 interfaceC25209zu7 = this.c;
        if (interfaceC25209zu7 != null) {
            aVarA.i(interfaceC25209zu7);
        }
        SourceLoadable sourceLoadable = new SourceLoadable(this.a, aVarA);
        this.e.A(new LoadEventInfo(sourceLoadable.a, this.a, this.i.n(sourceLoadable, this, this.d.b(1))), 1, -1, this.j, 0, null, 0L, this.h);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        return this.l ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void g(SourceLoadable sourceLoadable, long j, long j2, boolean z) {
        C19445qM6 c19445qM6 = sourceLoadable.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.a, sourceLoadable.b, c19445qM6.o(), c19445qM6.p(), j, j2, c19445qM6.n());
        this.d.d(sourceLoadable.a);
        this.e.r(loadEventInfo, 1, -1, null, 0, null, 0L, this.h);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        for (int i = 0; i < interfaceC13679ge2Arr.length; i++) {
            SampleStream sampleStream = sampleStreamArr[i];
            if (sampleStream != null && (interfaceC13679ge2Arr[i] == null || !zArr[i])) {
                this.g.remove(sampleStream);
                sampleStreamArr[i] = null;
            }
            if (sampleStreamArr[i] == null && interfaceC13679ge2Arr[i] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.g.add(sampleStreamImpl);
                sampleStreamArr[i] = sampleStreamImpl;
                zArr2[i] = true;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long k(long j) {
        for (int i = 0; i < this.g.size(); i++) {
            ((SampleStreamImpl) this.g.get(i)).c();
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long l() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void m(MediaPeriod.Callback callback, long j) {
        callback.j(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(SourceLoadable sourceLoadable, long j, long j2) {
        this.n = (int) sourceLoadable.c.n();
        this.m = (byte[]) AbstractC20011rK.e(sourceLoadable.d);
        this.l = true;
        C19445qM6 c19445qM6 = sourceLoadable.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.a, sourceLoadable.b, c19445qM6.o(), c19445qM6.p(), j, j2, this.n);
        this.d.d(sourceLoadable.a);
        this.e.u(loadEventInfo, 1, -1, this.j, 0, null, 0L, this.h);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Loader.c n(SourceLoadable sourceLoadable, long j, long j2, IOException iOException, int i) {
        Loader.c cVarG;
        C19445qM6 c19445qM6 = sourceLoadable.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(sourceLoadable.a, sourceLoadable.b, c19445qM6.o(), c19445qM6.p(), j, j2, c19445qM6.n());
        long jA = this.d.a(new j.c(loadEventInfo, new MediaLoadData(1, -1, this.j, 0, null, 0L, AbstractC9683aN7.c1(this.h)), iOException, i));
        boolean z = jA == -9223372036854775807L || i >= this.d.b(1);
        if (this.k && z) {
            AbstractC18815pI3.l("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.l = true;
            cVarG = Loader.f;
        } else {
            cVarG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.g;
        }
        Loader.c cVar = cVarG;
        boolean z2 = !cVar.c();
        this.e.w(loadEventInfo, 1, -1, this.j, 0, null, 0L, this.h, iOException, z2);
        if (z2) {
            this.d.d(sourceLoadable.a);
        }
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void q() {
    }

    public void s() {
        this.i.l();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray t() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void u(long j, boolean z) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long r(long j, C22738vk6 c22738vk6) {
        return j;
    }
}
