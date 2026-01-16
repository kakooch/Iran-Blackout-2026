package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC11612dI7;
import ir.nasim.AbstractC11828dd0;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC17264mg3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC8236Vc3;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class HlsChunkSource {
    private final HlsExtractorFactory a;
    private final com.google.android.exoplayer2.upstream.a b;
    private final com.google.android.exoplayer2.upstream.a c;
    private final TimestampAdjusterProvider d;
    private final Uri[] e;
    private final X[] f;
    private final HlsPlaylistTracker g;
    private final TrackGroup h;
    private final List i;
    private final C15493jg5 k;
    private boolean l;
    private IOException n;
    private Uri o;
    private boolean p;
    private InterfaceC13679ge2 q;
    private boolean s;
    private final FullSegmentEncryptionKeyCache j = new FullSegmentEncryptionKeyCache(4);
    private byte[] m = AbstractC9683aN7.f;
    private long r = -9223372036854775807L;

    private static final class EncryptionKeyChunk extends DataChunk {
        private byte[] l;

        public EncryptionKeyChunk(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, X x, int i, Object obj, byte[] bArr) {
            super(aVar, bVar, 3, x, i, obj, bArr);
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void g(byte[] bArr, int i) {
            this.l = Arrays.copyOf(bArr, i);
        }

        public byte[] j() {
            return this.l;
        }
    }

    public static final class HlsChunkHolder {
        public Chunk a;
        public boolean b;
        public Uri c;

        public HlsChunkHolder() {
            a();
        }

        public void a() {
            this.a = null;
            this.b = false;
            this.c = null;
        }
    }

    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final List e;
        private final long f;
        private final String g;

        public HlsMediaPlaylistSegmentIterator(String str, long j, List list) {
            super(0L, list.size() - 1);
            this.g = str;
            this.f = j;
            this.e = list;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long a() {
            c();
            return this.f + ((HlsMediaPlaylist.SegmentBase) this.e.get((int) d())).e;
        }

        @Override // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long b() {
            c();
            HlsMediaPlaylist.SegmentBase segmentBase = (HlsMediaPlaylist.SegmentBase) this.e.get((int) d());
            return this.f + segmentBase.e + segmentBase.c;
        }
    }

    private static final class InitializationTrackSelection extends AbstractC11828dd0 {
        private int h;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.h = v(trackGroup.d(iArr[0]));
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public int a() {
            return this.h;
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public Object i() {
            return null;
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public void p(long j, long j2, long j3, List list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (c(this.h, jElapsedRealtime)) {
                for (int i = this.b - 1; i >= 0; i--) {
                    if (!c(i, jElapsedRealtime)) {
                        this.h = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // ir.nasim.InterfaceC13679ge2
        public int s() {
            return 0;
        }
    }

    static final class SegmentBaseHolder {
        public final HlsMediaPlaylist.SegmentBase a;
        public final long b;
        public final int c;
        public final boolean d;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j, int i) {
            this.a = segmentBase;
            this.b = j;
            this.c = i;
            this.d = (segmentBase instanceof HlsMediaPlaylist.Part) && ((HlsMediaPlaylist.Part) segmentBase).m;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, X[] xArr, HlsDataSourceFactory hlsDataSourceFactory, InterfaceC25209zu7 interfaceC25209zu7, TimestampAdjusterProvider timestampAdjusterProvider, List list, C15493jg5 c15493jg5) {
        this.a = hlsExtractorFactory;
        this.g = hlsPlaylistTracker;
        this.e = uriArr;
        this.f = xArr;
        this.d = timestampAdjusterProvider;
        this.i = list;
        this.k = c15493jg5;
        com.google.android.exoplayer2.upstream.a aVarA = hlsDataSourceFactory.a(1);
        this.b = aVarA;
        if (interfaceC25209zu7 != null) {
            aVarA.i(interfaceC25209zu7);
        }
        this.c = hlsDataSourceFactory.a(3);
        this.h = new TrackGroup(xArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < uriArr.length; i++) {
            if ((xArr[i].e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.q = new InitializationTrackSelection(this.h, AbstractC8236Vc3.l(arrayList));
    }

    private static Uri d(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.SegmentBase segmentBase) {
        String str;
        if (segmentBase == null || (str = segmentBase.g) == null) {
            return null;
        }
        return AbstractC11612dI7.d(hlsMediaPlaylist.a, str);
    }

    private Pair f(HlsMediaChunk hlsMediaChunk, boolean z, HlsMediaPlaylist hlsMediaPlaylist, long j, long j2) {
        if (hlsMediaChunk != null && !z) {
            if (!hlsMediaChunk.h()) {
                return new Pair(Long.valueOf(hlsMediaChunk.j), Integer.valueOf(hlsMediaChunk.o));
            }
            Long lValueOf = Long.valueOf(hlsMediaChunk.o == -1 ? hlsMediaChunk.g() : hlsMediaChunk.j);
            int i = hlsMediaChunk.o;
            return new Pair(lValueOf, Integer.valueOf(i != -1 ? i + 1 : -1));
        }
        long j3 = hlsMediaPlaylist.u + j;
        if (hlsMediaChunk != null && !this.p) {
            j2 = hlsMediaChunk.g;
        }
        if (!hlsMediaPlaylist.o && j2 >= j3) {
            return new Pair(Long.valueOf(hlsMediaPlaylist.k + hlsMediaPlaylist.r.size()), -1);
        }
        long j4 = j2 - j;
        int i2 = 0;
        int iG = AbstractC9683aN7.g(hlsMediaPlaylist.r, Long.valueOf(j4), true, !this.g.i() || hlsMediaChunk == null);
        long j5 = iG + hlsMediaPlaylist.k;
        if (iG >= 0) {
            HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment) hlsMediaPlaylist.r.get(iG);
            List list = j4 < segment.e + segment.c ? segment.m : hlsMediaPlaylist.s;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                HlsMediaPlaylist.Part part = (HlsMediaPlaylist.Part) list.get(i2);
                if (j4 >= part.e + part.c) {
                    i2++;
                } else if (part.l) {
                    j5 += list == hlsMediaPlaylist.s ? 1L : 0L;
                    i = i2;
                }
            }
        }
        return new Pair(Long.valueOf(j5), Integer.valueOf(i));
    }

    private static SegmentBaseHolder g(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
        int i2 = (int) (j - hlsMediaPlaylist.k);
        if (i2 == hlsMediaPlaylist.r.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < hlsMediaPlaylist.s.size()) {
                return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) hlsMediaPlaylist.s.get(i), j, i);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment) hlsMediaPlaylist.r.get(i2);
        if (i == -1) {
            return new SegmentBaseHolder(segment, j, -1);
        }
        if (i < segment.m.size()) {
            return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) segment.m.get(i), j, i);
        }
        int i3 = i2 + 1;
        if (i3 < hlsMediaPlaylist.r.size()) {
            return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) hlsMediaPlaylist.r.get(i3), j + 1, -1);
        }
        if (hlsMediaPlaylist.s.isEmpty()) {
            return null;
        }
        return new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) hlsMediaPlaylist.s.get(0), j + 1, 0);
    }

    static List i(HlsMediaPlaylist hlsMediaPlaylist, long j, int i) {
        int i2 = (int) (j - hlsMediaPlaylist.k);
        if (i2 < 0 || hlsMediaPlaylist.r.size() < i2) {
            return AbstractC12710f43.V();
        }
        ArrayList arrayList = new ArrayList();
        if (i2 < hlsMediaPlaylist.r.size()) {
            if (i != -1) {
                HlsMediaPlaylist.Segment segment = (HlsMediaPlaylist.Segment) hlsMediaPlaylist.r.get(i2);
                if (i == 0) {
                    arrayList.add(segment);
                } else if (i < segment.m.size()) {
                    List list = segment.m;
                    arrayList.addAll(list.subList(i, list.size()));
                }
                i2++;
            }
            List list2 = hlsMediaPlaylist.r;
            arrayList.addAll(list2.subList(i2, list2.size()));
            i = 0;
        }
        if (hlsMediaPlaylist.n != -9223372036854775807L) {
            int i3 = i != -1 ? i : 0;
            if (i3 < hlsMediaPlaylist.s.size()) {
                List list3 = hlsMediaPlaylist.s;
                arrayList.addAll(list3.subList(i3, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Chunk l(Uri uri, int i) {
        if (uri == null) {
            return null;
        }
        byte[] bArrC = this.j.c(uri);
        if (bArrC != null) {
            this.j.b(uri, bArrC);
            return null;
        }
        return new EncryptionKeyChunk(this.c, new b.C0164b().i(uri).b(1).a(), this.f[i], this.q.s(), this.q.i(), this.m);
    }

    private long s(long j) {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    private void w(HlsMediaPlaylist hlsMediaPlaylist) {
        this.r = hlsMediaPlaylist.o ? -9223372036854775807L : hlsMediaPlaylist.e() - this.g.c();
    }

    public MediaChunkIterator[] a(HlsMediaChunk hlsMediaChunk, long j) {
        int i;
        int iE = hlsMediaChunk == null ? -1 : this.h.e(hlsMediaChunk.d);
        int length = this.q.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z = false;
        int i2 = 0;
        while (i2 < length) {
            int iG = this.q.g(i2);
            Uri uri = this.e[iG];
            if (this.g.h(uri)) {
                HlsMediaPlaylist hlsMediaPlaylistO = this.g.o(uri, z);
                AbstractC20011rK.e(hlsMediaPlaylistO);
                long jC = hlsMediaPlaylistO.h - this.g.c();
                i = i2;
                Pair pairF = f(hlsMediaChunk, iG != iE ? true : z, hlsMediaPlaylistO, jC, j);
                mediaChunkIteratorArr[i] = new HlsMediaPlaylistSegmentIterator(hlsMediaPlaylistO.a, jC, i(hlsMediaPlaylistO, ((Long) pairF.first).longValue(), ((Integer) pairF.second).intValue()));
            } else {
                mediaChunkIteratorArr[i2] = MediaChunkIterator.a;
                i = i2;
            }
            i2 = i + 1;
            z = false;
        }
        return mediaChunkIteratorArr;
    }

    public long b(long j, C22738vk6 c22738vk6) {
        int iA = this.q.a();
        Uri[] uriArr = this.e;
        HlsMediaPlaylist hlsMediaPlaylistO = (iA >= uriArr.length || iA == -1) ? null : this.g.o(uriArr[this.q.q()], true);
        if (hlsMediaPlaylistO == null || hlsMediaPlaylistO.r.isEmpty() || !hlsMediaPlaylistO.c) {
            return j;
        }
        long jC = hlsMediaPlaylistO.h - this.g.c();
        long j2 = j - jC;
        int iG = AbstractC9683aN7.g(hlsMediaPlaylistO.r, Long.valueOf(j2), true, true);
        long j3 = ((HlsMediaPlaylist.Segment) hlsMediaPlaylistO.r.get(iG)).e;
        return c22738vk6.a(j2, j3, iG != hlsMediaPlaylistO.r.size() - 1 ? ((HlsMediaPlaylist.Segment) hlsMediaPlaylistO.r.get(iG + 1)).e : j3) + jC;
    }

    public int c(HlsMediaChunk hlsMediaChunk) {
        if (hlsMediaChunk.o == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) AbstractC20011rK.e(this.g.o(this.e[this.h.e(hlsMediaChunk.d)], false));
        int i = (int) (hlsMediaChunk.j - hlsMediaPlaylist.k);
        if (i < 0) {
            return 1;
        }
        List list = i < hlsMediaPlaylist.r.size() ? ((HlsMediaPlaylist.Segment) hlsMediaPlaylist.r.get(i)).m : hlsMediaPlaylist.s;
        if (hlsMediaChunk.o >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = (HlsMediaPlaylist.Part) list.get(hlsMediaChunk.o);
        if (part.m) {
            return 0;
        }
        return AbstractC9683aN7.c(Uri.parse(AbstractC11612dI7.c(hlsMediaPlaylist.a, part.a)), hlsMediaChunk.b.a) ? 1 : 2;
    }

    public void e(long j, long j2, List list, boolean z, HlsChunkHolder hlsChunkHolder) {
        HlsMediaPlaylist hlsMediaPlaylist;
        long jC;
        Uri uri;
        int i;
        HlsMediaChunk hlsMediaChunk = list.isEmpty() ? null : (HlsMediaChunk) AbstractC17264mg3.c(list);
        int iE = hlsMediaChunk == null ? -1 : this.h.e(hlsMediaChunk.d);
        long jMax = j2 - j;
        long jS = s(j);
        if (hlsMediaChunk != null && !this.p) {
            long jD = hlsMediaChunk.d();
            jMax = Math.max(0L, jMax - jD);
            if (jS != -9223372036854775807L) {
                jS = Math.max(0L, jS - jD);
            }
        }
        this.q.p(j, jMax, jS, list, a(hlsMediaChunk, j2));
        int iQ = this.q.q();
        boolean z2 = iE != iQ;
        Uri uri2 = this.e[iQ];
        if (!this.g.h(uri2)) {
            hlsChunkHolder.c = uri2;
            this.s &= uri2.equals(this.o);
            this.o = uri2;
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylistO = this.g.o(uri2, true);
        AbstractC20011rK.e(hlsMediaPlaylistO);
        this.p = hlsMediaPlaylistO.c;
        w(hlsMediaPlaylistO);
        long jC2 = hlsMediaPlaylistO.h - this.g.c();
        Pair pairF = f(hlsMediaChunk, z2, hlsMediaPlaylistO, jC2, j2);
        long jLongValue = ((Long) pairF.first).longValue();
        int iIntValue = ((Integer) pairF.second).intValue();
        if (jLongValue >= hlsMediaPlaylistO.k || hlsMediaChunk == null || !z2) {
            hlsMediaPlaylist = hlsMediaPlaylistO;
            jC = jC2;
            uri = uri2;
            i = iQ;
        } else {
            Uri uri3 = this.e[iE];
            HlsMediaPlaylist hlsMediaPlaylistO2 = this.g.o(uri3, true);
            AbstractC20011rK.e(hlsMediaPlaylistO2);
            jC = hlsMediaPlaylistO2.h - this.g.c();
            Pair pairF2 = f(hlsMediaChunk, false, hlsMediaPlaylistO2, jC, j2);
            jLongValue = ((Long) pairF2.first).longValue();
            iIntValue = ((Integer) pairF2.second).intValue();
            i = iE;
            uri = uri3;
            hlsMediaPlaylist = hlsMediaPlaylistO2;
        }
        if (jLongValue < hlsMediaPlaylist.k) {
            this.n = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder segmentBaseHolderG = g(hlsMediaPlaylist, jLongValue, iIntValue);
        if (segmentBaseHolderG == null) {
            if (!hlsMediaPlaylist.o) {
                hlsChunkHolder.c = uri;
                this.s &= uri.equals(this.o);
                this.o = uri;
                return;
            } else {
                if (z || hlsMediaPlaylist.r.isEmpty()) {
                    hlsChunkHolder.b = true;
                    return;
                }
                segmentBaseHolderG = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) AbstractC17264mg3.c(hlsMediaPlaylist.r), (hlsMediaPlaylist.k + hlsMediaPlaylist.r.size()) - 1, -1);
            }
        }
        this.s = false;
        this.o = null;
        Uri uriD = d(hlsMediaPlaylist, segmentBaseHolderG.a.b);
        Chunk chunkL = l(uriD, i);
        hlsChunkHolder.a = chunkL;
        if (chunkL != null) {
            return;
        }
        Uri uriD2 = d(hlsMediaPlaylist, segmentBaseHolderG.a);
        Chunk chunkL2 = l(uriD2, i);
        hlsChunkHolder.a = chunkL2;
        if (chunkL2 != null) {
            return;
        }
        boolean zW = HlsMediaChunk.w(hlsMediaChunk, uri, hlsMediaPlaylist, segmentBaseHolderG, jC);
        if (zW && segmentBaseHolderG.d) {
            return;
        }
        hlsChunkHolder.a = HlsMediaChunk.j(this.a, this.b, this.f[i], jC, hlsMediaPlaylist, segmentBaseHolderG, uri, this.i, this.q.s(), this.q.i(), this.l, this.d, hlsMediaChunk, this.j.a(uriD2), this.j.a(uriD), zW, this.k);
    }

    public int h(long j, List list) {
        return (this.n != null || this.q.length() < 2) ? list.size() : this.q.o(j, list);
    }

    public TrackGroup j() {
        return this.h;
    }

    public InterfaceC13679ge2 k() {
        return this.q;
    }

    public boolean m(Chunk chunk, long j) {
        InterfaceC13679ge2 interfaceC13679ge2 = this.q;
        return interfaceC13679ge2.b(interfaceC13679ge2.k(this.h.e(chunk.d)), j);
    }

    public void n() throws IOException {
        IOException iOException = this.n;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.o;
        if (uri == null || !this.s) {
            return;
        }
        this.g.b(uri);
    }

    public boolean o(Uri uri) {
        return AbstractC9683aN7.r(this.e, uri);
    }

    public void p(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.m = encryptionKeyChunk.h();
            this.j.b(encryptionKeyChunk.b.a, (byte[]) AbstractC20011rK.e(encryptionKeyChunk.j()));
        }
    }

    public boolean q(Uri uri, long j) {
        int iK;
        int i = 0;
        while (true) {
            Uri[] uriArr = this.e;
            if (i >= uriArr.length) {
                i = -1;
                break;
            }
            if (uriArr[i].equals(uri)) {
                break;
            }
            i++;
        }
        if (i == -1 || (iK = this.q.k(i)) == -1) {
            return true;
        }
        this.s |= uri.equals(this.o);
        return j == -9223372036854775807L || (this.q.b(iK, j) && this.g.k(uri, j));
    }

    public void r() {
        this.n = null;
    }

    public void t(boolean z) {
        this.l = z;
    }

    public void u(InterfaceC13679ge2 interfaceC13679ge2) {
        this.q = interfaceC13679ge2;
    }

    public boolean v(long j, Chunk chunk, List list) {
        if (this.n != null) {
            return false;
        }
        return this.q.d(j, chunk, list);
    }
}
