package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.b, Loader.f {
    public final int a;
    private final int[] b;
    private final X[] c;
    private final ChunkSource d;
    private final SequenceableLoader.Callback e;
    private final MediaSourceEventListener.EventDispatcher f;
    private final j g;
    private final Loader h;
    private final ChunkHolder i;
    private final ArrayList j;
    private final List k;
    private final SampleQueue l;
    private final SampleQueue[] m;
    private final BaseMediaChunkOutput n;
    private Chunk o;
    private X p;
    private ReleaseCallback q;
    private long r;
    private long s;
    private int t;
    private BaseMediaChunk u;
    boolean v;

    public final class EmbeddedSampleStream implements SampleStream {
        private final SampleQueue a;
        private final int b;
        private boolean c;
        final /* synthetic */ ChunkSampleStream d;

        private void a() {
            if (this.c) {
                return;
            }
            this.d.f.i(this.d.b[this.b], this.d.c[this.b], 0, null, this.d.s);
            this.c = true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() {
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return !this.d.F() && this.a.F(this.d.v);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            if (this.d.F()) {
                return -3;
            }
            if (this.d.u != null && this.d.u.i(this.b + 1) <= this.a.x()) {
                return -3;
            }
            a();
            return this.a.N(c21664tv2, decoderInputBuffer, i, this.d.v);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            if (this.d.F()) {
                return 0;
            }
            int iZ = this.a.z(j, this.d.v);
            if (this.d.u != null) {
                iZ = Math.min(iZ, this.d.u.i(this.b + 1) - this.a.x());
            }
            this.a.Y(iZ);
            if (iZ > 0) {
                a();
            }
            return iZ;
        }
    }

    public interface ReleaseCallback<T extends ChunkSource> {
        void a(ChunkSampleStream chunkSampleStream);
    }

    private void A(int i) {
        AbstractC20011rK.g(!this.h.i());
        int size = this.j.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (!D(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = C().h;
        BaseMediaChunk baseMediaChunkB = B(i);
        if (this.j.isEmpty()) {
            this.r = this.s;
        }
        this.v = false;
        this.f.D(this.a, baseMediaChunkB.g, j);
    }

    private BaseMediaChunk B(int i) {
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.j.get(i);
        ArrayList arrayList = this.j;
        AbstractC9683aN7.M0(arrayList, i, arrayList.size());
        this.t = Math.max(this.t, this.j.size());
        int i2 = 0;
        this.l.r(baseMediaChunk.i(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.m;
            if (i2 >= sampleQueueArr.length) {
                return baseMediaChunk;
            }
            SampleQueue sampleQueue = sampleQueueArr[i2];
            i2++;
            sampleQueue.r(baseMediaChunk.i(i2));
        }
    }

    private BaseMediaChunk C() {
        return (BaseMediaChunk) this.j.get(r0.size() - 1);
    }

    private boolean D(int i) {
        int iX;
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.j.get(i);
        if (this.l.x() > baseMediaChunk.i(0)) {
            return true;
        }
        int i2 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.m;
            if (i2 >= sampleQueueArr.length) {
                return false;
            }
            iX = sampleQueueArr[i2].x();
            i2++;
        } while (iX <= baseMediaChunk.i(i2));
        return true;
    }

    private boolean E(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void G() {
        int iL = L(this.l.x(), this.t - 1);
        while (true) {
            int i = this.t;
            if (i > iL) {
                return;
            }
            this.t = i + 1;
            H(i);
        }
    }

    private void H(int i) {
        BaseMediaChunk baseMediaChunk = (BaseMediaChunk) this.j.get(i);
        X x = baseMediaChunk.d;
        if (!x.equals(this.p)) {
            this.f.i(this.a, x, baseMediaChunk.e, baseMediaChunk.f, baseMediaChunk.g);
        }
        this.p = x;
    }

    private int L(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.j.size()) {
                return this.j.size() - 1;
            }
        } while (((BaseMediaChunk) this.j.get(i2)).i(0) <= i);
        return i2 - 1;
    }

    private void M() {
        this.l.Q();
        for (SampleQueue sampleQueue : this.m) {
            sampleQueue.Q();
        }
    }

    boolean F() {
        return this.r != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void g(Chunk chunk, long j, long j2, boolean z) {
        this.o = null;
        this.u = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), j, j2, chunk.b());
        this.g.d(chunk.a);
        this.f.r(loadEventInfo, chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        if (z) {
            return;
        }
        if (F()) {
            M();
        } else if (E(chunk)) {
            B(this.j.size() - 1);
            if (this.j.isEmpty()) {
                this.r = this.s;
            }
        }
        this.e.g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void j(Chunk chunk, long j, long j2) {
        this.o = null;
        this.d.c(chunk);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), j, j2, chunk.b());
        this.g.d(chunk.a);
        this.f.u(loadEventInfo, chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        this.e.g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public Loader.c n(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.c cVarG;
        long jB = chunk.b();
        boolean zE = E(chunk);
        int size = this.j.size() - 1;
        boolean z = (jB != 0 && zE && D(size)) ? false : true;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), j, j2, jB);
        j.c cVar = new j.c(loadEventInfo, new MediaLoadData(chunk.c, this.a, chunk.d, chunk.e, chunk.f, AbstractC9683aN7.c1(chunk.g), AbstractC9683aN7.c1(chunk.h)), iOException, i);
        if (!this.d.d(chunk, z, cVar, this.g)) {
            cVarG = null;
        } else if (z) {
            cVarG = Loader.f;
            if (zE) {
                AbstractC20011rK.g(B(size) == chunk);
                if (this.j.isEmpty()) {
                    this.r = this.s;
                }
            }
        } else {
            AbstractC18815pI3.k("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            cVarG = null;
        }
        if (cVarG == null) {
            long jA = this.g.a(cVar);
            cVarG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.g;
        }
        boolean z2 = !cVarG.c();
        this.f.w(loadEventInfo, chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h, iOException, z2);
        if (z2) {
            this.o = null;
            this.g.d(chunk.a);
            this.e.g(this);
        }
        return cVarG;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        if (F()) {
            return this.r;
        }
        if (this.v) {
            return Long.MIN_VALUE;
        }
        return C().h;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void b() throws IOException {
        this.h.j();
        this.l.I();
        if (this.h.i()) {
            return;
        }
        this.d.b();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.h.i();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        List listEmptyList;
        long j2;
        if (this.v || this.h.i() || this.h.h()) {
            return false;
        }
        boolean zF = F();
        if (zF) {
            listEmptyList = Collections.emptyList();
            j2 = this.r;
        } else {
            listEmptyList = this.k;
            j2 = C().h;
        }
        this.d.f(j, j2, listEmptyList, this.i);
        ChunkHolder chunkHolder = this.i;
        boolean z = chunkHolder.b;
        Chunk chunk = chunkHolder.a;
        chunkHolder.a();
        if (z) {
            this.r = -9223372036854775807L;
            this.v = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        this.o = chunk;
        if (E(chunk)) {
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
            if (zF) {
                long j3 = baseMediaChunk.g;
                long j4 = this.r;
                if (j3 != j4) {
                    this.l.V(j4);
                    for (SampleQueue sampleQueue : this.m) {
                        sampleQueue.V(this.r);
                    }
                }
                this.r = -9223372036854775807L;
            }
            baseMediaChunk.k(this.n);
            this.j.add(baseMediaChunk);
        } else if (chunk instanceof InitializationChunk) {
            ((InitializationChunk) chunk).g(this.n);
        }
        this.f.A(new LoadEventInfo(chunk.a, chunk.b, this.h.n(chunk, this, this.g.b(chunk.c))), chunk.c, this.a, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        if (this.v) {
            return Long.MIN_VALUE;
        }
        if (F()) {
            return this.r;
        }
        long jMax = this.s;
        BaseMediaChunk baseMediaChunkC = C();
        if (!baseMediaChunkC.h()) {
            if (this.j.size() > 1) {
                baseMediaChunkC = (BaseMediaChunk) this.j.get(r2.size() - 2);
            } else {
                baseMediaChunkC = null;
            }
        }
        if (baseMediaChunkC != null) {
            jMax = Math.max(jMax, baseMediaChunkC.h);
        }
        return Math.max(jMax, this.l.u());
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
        if (this.h.h() || F()) {
            return;
        }
        if (!this.h.i()) {
            int iE = this.d.e(j, this.k);
            if (iE < this.j.size()) {
                A(iE);
                return;
            }
            return;
        }
        Chunk chunk = (Chunk) AbstractC20011rK.e(this.o);
        if (!(E(chunk) && D(this.j.size() - 1)) && this.d.a(j, chunk, this.k)) {
            this.h.e();
            if (E(chunk)) {
                this.u = (BaseMediaChunk) chunk;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean h() {
        return !F() && this.l.F(this.v);
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
        if (F()) {
            return -3;
        }
        BaseMediaChunk baseMediaChunk = this.u;
        if (baseMediaChunk != null && baseMediaChunk.i(0) <= this.l.x()) {
            return -3;
        }
        G();
        return this.l.N(c21664tv2, decoderInputBuffer, i, this.v);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void p() {
        this.l.O();
        for (SampleQueue sampleQueue : this.m) {
            sampleQueue.O();
        }
        this.d.release();
        ReleaseCallback releaseCallback = this.q;
        if (releaseCallback != null) {
            releaseCallback.a(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int s(long j) {
        if (F()) {
            return 0;
        }
        int iZ = this.l.z(j, this.v);
        BaseMediaChunk baseMediaChunk = this.u;
        if (baseMediaChunk != null) {
            iZ = Math.min(iZ, baseMediaChunk.i(0) - this.l.x());
        }
        this.l.Y(iZ);
        G();
        return iZ;
    }
}
