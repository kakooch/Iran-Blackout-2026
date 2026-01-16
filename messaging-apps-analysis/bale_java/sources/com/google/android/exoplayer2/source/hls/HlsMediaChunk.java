package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC11612dI7;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC14083hK;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.C15493jg5;
import ir.nasim.C5045Hq7;
import ir.nasim.E03;
import ir.nasim.EW4;
import ir.nasim.InterfaceC9845af2;
import ir.nasim.RD1;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class HlsMediaChunk extends MediaChunk {
    private static final AtomicInteger M = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final C15493jg5 C;
    private HlsMediaChunkExtractor D;
    private HlsSampleStreamWrapper E;
    private int F;
    private boolean G;
    private volatile boolean H;
    private boolean I;
    private AbstractC12710f43 J;
    private boolean K;
    private boolean L;
    public final int k;
    public final int l;
    public final Uri m;
    public final boolean n;
    public final int o;
    private final com.google.android.exoplayer2.upstream.a p;
    private final com.google.android.exoplayer2.upstream.b q;
    private final HlsMediaChunkExtractor r;
    private final boolean s;
    private final boolean t;
    private final C5045Hq7 u;
    private final HlsExtractorFactory v;
    private final List w;
    private final DrmInitData x;
    private final E03 y;
    private final EW4 z;

    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, X x, boolean z, com.google.android.exoplayer2.upstream.a aVar2, com.google.android.exoplayer2.upstream.b bVar2, boolean z2, Uri uri, List list, int i, Object obj, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, C5045Hq7 c5045Hq7, DrmInitData drmInitData, HlsMediaChunkExtractor hlsMediaChunkExtractor, E03 e03, EW4 ew4, boolean z6, C15493jg5 c15493jg5) {
        super(aVar, bVar, x, i, obj, j, j2, j3);
        this.A = z;
        this.o = i2;
        this.L = z3;
        this.l = i3;
        this.q = bVar2;
        this.p = aVar2;
        this.G = bVar2 != null;
        this.B = z2;
        this.m = uri;
        this.s = z5;
        this.u = c5045Hq7;
        this.t = z4;
        this.v = hlsExtractorFactory;
        this.w = list;
        this.x = drmInitData;
        this.r = hlsMediaChunkExtractor;
        this.y = e03;
        this.z = ew4;
        this.n = z6;
        this.C = c15493jg5;
        this.J = AbstractC12710f43.V();
        this.k = M.getAndIncrement();
    }

    private static com.google.android.exoplayer2.upstream.a i(com.google.android.exoplayer2.upstream.a aVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return aVar;
        }
        AbstractC20011rK.e(bArr2);
        return new Aes128DataSource(aVar, bArr, bArr2);
    }

    public static HlsMediaChunk j(HlsExtractorFactory hlsExtractorFactory, com.google.android.exoplayer2.upstream.a aVar, X x, long j, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, Uri uri, List list, int i, Object obj, boolean z, TimestampAdjusterProvider timestampAdjusterProvider, HlsMediaChunk hlsMediaChunk, byte[] bArr, byte[] bArr2, boolean z2, C15493jg5 c15493jg5) {
        boolean z3;
        com.google.android.exoplayer2.upstream.a aVarI;
        com.google.android.exoplayer2.upstream.b bVar;
        boolean z4;
        E03 e03;
        EW4 ew4;
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder.a;
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0164b().i(AbstractC11612dI7.d(hlsMediaPlaylist.a, segmentBase.a)).h(segmentBase.i).g(segmentBase.j).b(segmentBaseHolder.d ? 8 : 0).a();
        boolean z5 = bArr != null;
        com.google.android.exoplayer2.upstream.a aVarI2 = i(aVar, bArr, z5 ? l((String) AbstractC20011rK.e(segmentBase.h)) : null);
        HlsMediaPlaylist.Segment segment = segmentBase.b;
        if (segment != null) {
            boolean z6 = bArr2 != null;
            byte[] bArrL = z6 ? l((String) AbstractC20011rK.e(segment.h)) : null;
            z3 = z5;
            bVar = new com.google.android.exoplayer2.upstream.b(AbstractC11612dI7.d(hlsMediaPlaylist.a, segment.a), segment.i, segment.j);
            aVarI = i(aVar, bArr2, bArrL);
            z4 = z6;
        } else {
            z3 = z5;
            aVarI = null;
            bVar = null;
            z4 = false;
        }
        long j2 = j + segmentBase.e;
        long j3 = j2 + segmentBase.c;
        int i2 = hlsMediaPlaylist.j + segmentBase.d;
        if (hlsMediaChunk != null) {
            com.google.android.exoplayer2.upstream.b bVar2 = hlsMediaChunk.q;
            boolean z7 = bVar == bVar2 || (bVar != null && bVar2 != null && bVar.a.equals(bVar2.a) && bVar.g == hlsMediaChunk.q.g);
            boolean z8 = uri.equals(hlsMediaChunk.m) && hlsMediaChunk.I;
            e03 = hlsMediaChunk.y;
            ew4 = hlsMediaChunk.z;
            hlsMediaChunkExtractor = (z7 && z8 && !hlsMediaChunk.K && hlsMediaChunk.l == i2) ? hlsMediaChunk.D : null;
        } else {
            e03 = new E03();
            ew4 = new EW4(10);
            hlsMediaChunkExtractor = null;
        }
        return new HlsMediaChunk(hlsExtractorFactory, aVarI2, bVarA, x, z3, aVarI, bVar, z4, uri, list, i, obj, j2, j3, segmentBaseHolder.b, segmentBaseHolder.c, !segmentBaseHolder.d, i2, segmentBase.k, z, timestampAdjusterProvider.a(i2), segmentBase.f, hlsMediaChunkExtractor, e03, ew4, z2, c15493jg5);
    }

    private void k(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z, boolean z2) {
        com.google.android.exoplayer2.upstream.b bVarE;
        long position;
        long j;
        if (z) {
            z = this.F != 0;
            bVarE = bVar;
        } else {
            bVarE = bVar.e(this.F);
        }
        try {
            RD1 rd1U = u(aVar, bVarE, z2);
            if (z) {
                rd1U.k(this.F);
            }
            while (!this.H && this.D.a(rd1U)) {
                try {
                    try {
                    } catch (EOFException e) {
                        if ((this.d.e & 16384) == 0) {
                            throw e;
                        }
                        this.D.c();
                        position = rd1U.getPosition();
                        j = bVar.g;
                    }
                } catch (Throwable th) {
                    this.F = (int) (rd1U.getPosition() - bVar.g);
                    throw th;
                }
            }
            position = rd1U.getPosition();
            j = bVar.g;
            this.F = (int) (position - j);
        } finally {
            AbstractC22885vz1.a(aVar);
        }
    }

    private static byte[] l(String str) {
        if (AbstractC14083hK.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static boolean p(HlsChunkSource.SegmentBaseHolder segmentBaseHolder, HlsMediaPlaylist hlsMediaPlaylist) {
        HlsMediaPlaylist.SegmentBase segmentBase = segmentBaseHolder.a;
        return segmentBase instanceof HlsMediaPlaylist.Part ? ((HlsMediaPlaylist.Part) segmentBase).l || (segmentBaseHolder.c == 0 && hlsMediaPlaylist.c) : hlsMediaPlaylist.c;
    }

    private void r() {
        k(this.i, this.b, this.A, true);
    }

    private void s() {
        if (this.G) {
            AbstractC20011rK.e(this.p);
            AbstractC20011rK.e(this.q);
            k(this.p, this.q, this.B, false);
            this.F = 0;
            this.G = false;
        }
    }

    private long t(InterfaceC9845af2 interfaceC9845af2) {
        interfaceC9845af2.e();
        try {
            this.z.O(10);
            interfaceC9845af2.m(this.z.e(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.z.I() != 4801587) {
            return -9223372036854775807L;
        }
        this.z.T(3);
        int iE = this.z.E();
        int i = iE + 10;
        if (i > this.z.b()) {
            byte[] bArrE = this.z.e();
            this.z.O(i);
            System.arraycopy(bArrE, 0, this.z.e(), 0, 10);
        }
        interfaceC9845af2.m(this.z.e(), 10, iE);
        Metadata metadataE = this.y.e(this.z.e(), iE);
        if (metadataE == null) {
            return -9223372036854775807L;
        }
        int iE2 = metadataE.e();
        for (int i2 = 0; i2 < iE2; i2++) {
            Metadata.Entry entryD = metadataE.d(i2);
            if (entryD instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entryD;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.b)) {
                    System.arraycopy(privFrame.c, 0, this.z.e(), 0, 8);
                    this.z.S(0);
                    this.z.R(8);
                    return this.z.y() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    private RD1 u(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) throws InterruptedIOException {
        long jB = aVar.b(bVar);
        if (z) {
            try {
                this.u.h(this.s, this.g);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        RD1 rd1 = new RD1(aVar, bVar.g, jB);
        if (this.D == null) {
            long jT = t(rd1);
            rd1.e();
            HlsMediaChunkExtractor hlsMediaChunkExtractor = this.r;
            HlsMediaChunkExtractor hlsMediaChunkExtractorF = hlsMediaChunkExtractor != null ? hlsMediaChunkExtractor.f() : this.v.a(bVar.a, this.d, this.w, this.u, aVar.d(), rd1, this.C);
            this.D = hlsMediaChunkExtractorF;
            if (hlsMediaChunkExtractorF.e()) {
                this.E.n0(jT != -9223372036854775807L ? this.u.b(jT) : this.g);
            } else {
                this.E.n0(0L);
            }
            this.E.Z();
            this.D.b(this.E);
        }
        this.E.k0(this.x);
        return rd1;
    }

    public static boolean w(HlsMediaChunk hlsMediaChunk, Uri uri, HlsMediaPlaylist hlsMediaPlaylist, HlsChunkSource.SegmentBaseHolder segmentBaseHolder, long j) {
        if (hlsMediaChunk == null) {
            return false;
        }
        if (uri.equals(hlsMediaChunk.m) && hlsMediaChunk.I) {
            return false;
        }
        return !p(segmentBaseHolder, hlsMediaPlaylist) || j + segmentBaseHolder.a.e < hlsMediaChunk.h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void a() {
        HlsMediaChunkExtractor hlsMediaChunkExtractor;
        AbstractC20011rK.e(this.E);
        if (this.D == null && (hlsMediaChunkExtractor = this.r) != null && hlsMediaChunkExtractor.d()) {
            this.D = this.r;
            this.G = false;
        }
        s();
        if (this.H) {
            return;
        }
        if (!this.t) {
            r();
        }
        this.I = !this.H;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void c() {
        this.H = true;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean h() {
        return this.I;
    }

    public int m(int i) {
        AbstractC20011rK.g(!this.n);
        if (i >= this.J.size()) {
            return 0;
        }
        return ((Integer) this.J.get(i)).intValue();
    }

    public void n(HlsSampleStreamWrapper hlsSampleStreamWrapper, AbstractC12710f43 abstractC12710f43) {
        this.E = hlsSampleStreamWrapper;
        this.J = abstractC12710f43;
    }

    public void o() {
        this.K = true;
    }

    public boolean q() {
        return this.L;
    }

    public void v() {
        this.L = true;
    }
}
