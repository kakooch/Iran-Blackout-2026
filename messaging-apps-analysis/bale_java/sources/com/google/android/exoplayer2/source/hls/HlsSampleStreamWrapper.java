package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC17264mg3;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC6974Pt7;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C11015cb2;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.EW4;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import ir.nasim.P12;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class HlsSampleStreamWrapper implements Loader.b, Loader.f, SequenceableLoader, InterfaceC10465bf2, SampleQueue.UpstreamFormatChangedListener {
    private static final Set P0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    private int A;
    private Set A0;
    private int B;
    private int[] B0;
    private int C0;
    private boolean D;
    private boolean D0;
    private boolean[] E0;
    private boolean[] F0;
    private boolean G;
    private long G0;
    private int H;
    private long H0;
    private boolean I0;
    private X J;
    private boolean J0;
    private boolean K0;
    private boolean L0;
    private long M0;
    private DrmInitData N0;
    private HlsMediaChunk O0;
    private X Y;
    private boolean Z;
    private final String a;
    private final int b;
    private final Callback c;
    private final HlsChunkSource d;
    private final InterfaceC19684qm e;
    private final X f;
    private final i g;
    private final h.a h;
    private final j i;
    private final MediaSourceEventListener.EventDispatcher k;
    private final int l;
    private final ArrayList n;
    private final List o;
    private final Runnable p;
    private final Runnable q;
    private final Handler r;
    private final ArrayList s;
    private final Map t;
    private Chunk u;
    private HlsSampleQueue[] v;
    private Set x;
    private SparseIntArray y;
    private InterfaceC4589Ft7 z;
    private TrackGroupArray z0;
    private final Loader j = new Loader("Loader:HlsSampleStreamWrapper");
    private final HlsChunkSource.HlsChunkHolder m = new HlsChunkSource.HlsChunkHolder();
    private int[] w = new int[0];

    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void b();

        void h(Uri uri);
    }

    private static class EmsgUnwrappingTrackOutput implements InterfaceC4589Ft7 {
        private static final X g = new X.b().g0("application/id3").G();
        private static final X h = new X.b().g0("application/x-emsg").G();
        private final C11015cb2 a = new C11015cb2();
        private final InterfaceC4589Ft7 b;
        private final X c;
        private X d;
        private byte[] e;
        private int f;

        public EmsgUnwrappingTrackOutput(InterfaceC4589Ft7 interfaceC4589Ft7, int i) {
            this.b = interfaceC4589Ft7;
            if (i == 1) {
                this.c = g;
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i);
                }
                this.c = h;
            }
            this.e = new byte[0];
            this.f = 0;
        }

        private boolean g(EventMessage eventMessage) {
            X xZ = eventMessage.Z();
            return xZ != null && AbstractC9683aN7.c(this.c.l, xZ.l);
        }

        private void h(int i) {
            byte[] bArr = this.e;
            if (bArr.length < i) {
                this.e = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        private EW4 i(int i, int i2) {
            int i3 = this.f - i2;
            EW4 ew4 = new EW4(Arrays.copyOfRange(this.e, i3 - i, i3));
            byte[] bArr = this.e;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.f = i2;
            return ew4;
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public void a(EW4 ew4, int i, int i2) {
            h(this.f + i);
            ew4.j(this.e, this.f, i);
            this.f += i;
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public void b(long j, int i, int i2, int i3, InterfaceC4589Ft7.a aVar) {
            AbstractC20011rK.e(this.d);
            EW4 ew4I = i(i2, i3);
            if (!AbstractC9683aN7.c(this.d.l, this.c.l)) {
                if (!"application/x-emsg".equals(this.d.l)) {
                    AbstractC18815pI3.k("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.d.l);
                    return;
                }
                EventMessage eventMessageC = this.a.c(ew4I);
                if (!g(eventMessageC)) {
                    AbstractC18815pI3.k("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.c.l, eventMessageC.Z()));
                    return;
                }
                ew4I = new EW4((byte[]) AbstractC20011rK.e(eventMessageC.R1()));
            }
            int iA = ew4I.a();
            this.b.d(ew4I, iA);
            this.b.b(j, i, iA, i3, aVar);
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public void c(X x) {
            this.d = x;
            this.b.c(this.c);
        }

        @Override // ir.nasim.InterfaceC4589Ft7
        public int e(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z, int i2) throws EOFException {
            h(this.f + i);
            int i3 = interfaceC18631oz1.read(this.e, this.f, i);
            if (i3 != -1) {
                this.f += i3;
                return i3;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
    }

    private static final class HlsSampleQueue extends SampleQueue {
        private final Map H;
        private DrmInitData I;

        private Metadata b0(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int iE = metadata.e();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= iE) {
                    i2 = -1;
                    break;
                }
                Metadata.Entry entryD = metadata.d(i2);
                if ((entryD instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entryD).b)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (iE == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[iE - 1];
            while (i < iE) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.d(i);
                }
                i++;
            }
            return new Metadata(entryArr);
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue, ir.nasim.InterfaceC4589Ft7
        public void b(long j, int i, int i2, int i3, InterfaceC4589Ft7.a aVar) {
            super.b(j, i, i2, i3, aVar);
        }

        public void c0(DrmInitData drmInitData) {
            this.I = drmInitData;
            D();
        }

        public void d0(HlsMediaChunk hlsMediaChunk) {
            Z(hlsMediaChunk.k);
        }

        @Override // com.google.android.exoplayer2.source.SampleQueue
        public X t(X x) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = x.o;
            }
            if (drmInitData2 != null && (drmInitData = (DrmInitData) this.H.get(drmInitData2.c)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadataB0 = b0(x.j);
            if (drmInitData2 != x.o || metadataB0 != x.j) {
                x = x.c().O(drmInitData2).Z(metadataB0).G();
            }
            return super.t(x);
        }

        private HlsSampleQueue(InterfaceC19684qm interfaceC19684qm, i iVar, h.a aVar, Map map) {
            super(interfaceC19684qm, iVar, aVar);
            this.H = map;
        }
    }

    public HlsSampleStreamWrapper(String str, int i, Callback callback, HlsChunkSource hlsChunkSource, Map map, InterfaceC19684qm interfaceC19684qm, long j, X x, i iVar, h.a aVar, j jVar, MediaSourceEventListener.EventDispatcher eventDispatcher, int i2) {
        this.a = str;
        this.b = i;
        this.c = callback;
        this.d = hlsChunkSource;
        this.t = map;
        this.e = interfaceC19684qm;
        this.f = x;
        this.g = iVar;
        this.h = aVar;
        this.i = jVar;
        this.k = eventDispatcher;
        this.l = i2;
        Set set = P0;
        this.x = new HashSet(set.size());
        this.y = new SparseIntArray(set.size());
        this.v = new HlsSampleQueue[0];
        this.F0 = new boolean[0];
        this.E0 = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        this.o = Collections.unmodifiableList(arrayList);
        this.s = new ArrayList();
        this.p = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.a
            @Override // java.lang.Runnable
            public final void run() {
                this.a.T();
            }
        };
        this.q = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.b
            @Override // java.lang.Runnable
            public final void run() {
                this.a.c0();
            }
        };
        this.r = AbstractC9683aN7.v();
        this.G0 = j;
        this.H0 = j;
    }

    private boolean A(int i) {
        for (int i2 = i; i2 < this.n.size(); i2++) {
            if (((HlsMediaChunk) this.n.get(i2)).n) {
                return false;
            }
        }
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) this.n.get(i);
        for (int i3 = 0; i3 < this.v.length; i3++) {
            if (this.v[i3].x() > hlsMediaChunk.m(i3)) {
                return false;
            }
        }
        return true;
    }

    private static P12 C(int i, int i2) {
        AbstractC18815pI3.k("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new P12();
    }

    private SampleQueue D(int i, int i2) {
        int length = this.v.length;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        HlsSampleQueue hlsSampleQueue = new HlsSampleQueue(this.e, this.g, this.h, this.t);
        hlsSampleQueue.V(this.G0);
        if (z) {
            hlsSampleQueue.c0(this.N0);
        }
        hlsSampleQueue.U(this.M0);
        HlsMediaChunk hlsMediaChunk = this.O0;
        if (hlsMediaChunk != null) {
            hlsSampleQueue.d0(hlsMediaChunk);
        }
        hlsSampleQueue.X(this);
        int i3 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.w, i3);
        this.w = iArrCopyOf;
        iArrCopyOf[length] = i;
        this.v = (HlsSampleQueue[]) AbstractC9683aN7.E0(this.v, hlsSampleQueue);
        boolean[] zArrCopyOf = Arrays.copyOf(this.F0, i3);
        this.F0 = zArrCopyOf;
        zArrCopyOf[length] = z;
        this.D0 |= z;
        this.x.add(Integer.valueOf(i2));
        this.y.append(i2, length);
        if (M(i2) > M(this.A)) {
            this.B = length;
            this.A = i2;
        }
        this.E0 = Arrays.copyOf(this.E0, i3);
        return hlsSampleQueue;
    }

    private TrackGroupArray E(TrackGroup[] trackGroupArr) {
        for (int i = 0; i < trackGroupArr.length; i++) {
            TrackGroup trackGroup = trackGroupArr[i];
            X[] xArr = new X[trackGroup.a];
            for (int i2 = 0; i2 < trackGroup.a; i2++) {
                X xD = trackGroup.d(i2);
                xArr[i2] = xD.d(this.g.a(xD));
            }
            trackGroupArr[i] = new TrackGroup(trackGroup.b, xArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private static X F(X x, X x2, boolean z) {
        String strD;
        String strG;
        if (x == null) {
            return x2;
        }
        int iK = AbstractC24462yf4.k(x2.l);
        if (AbstractC9683aN7.H(x.i, iK) == 1) {
            strD = AbstractC9683aN7.I(x.i, iK);
            strG = AbstractC24462yf4.g(strD);
        } else {
            strD = AbstractC24462yf4.d(x.i, x2.l);
            strG = x2.l;
        }
        X.b bVarK = x2.c().U(x.a).W(x.b).X(x.c).i0(x.d).e0(x.e).I(z ? x.f : -1).b0(z ? x.g : -1).K(strD);
        if (iK == 2) {
            bVarK.n0(x.q).S(x.r).R(x.s);
        }
        if (strG != null) {
            bVarK.g0(strG);
        }
        int i = x.y;
        if (i != -1 && iK == 1) {
            bVarK.J(i);
        }
        Metadata metadataB = x.j;
        if (metadataB != null) {
            Metadata metadata = x2.j;
            if (metadata != null) {
                metadataB = metadata.b(metadataB);
            }
            bVarK.Z(metadataB);
        }
        return bVarK.G();
    }

    private void G(int i) {
        AbstractC20011rK.g(!this.j.i());
        while (true) {
            if (i >= this.n.size()) {
                i = -1;
                break;
            } else if (A(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = K().h;
        HlsMediaChunk hlsMediaChunkH = H(i);
        if (this.n.isEmpty()) {
            this.H0 = this.G0;
        } else {
            ((HlsMediaChunk) AbstractC17264mg3.c(this.n)).o();
        }
        this.K0 = false;
        this.k.D(this.A, hlsMediaChunkH.g, j);
    }

    private HlsMediaChunk H(int i) {
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) this.n.get(i);
        ArrayList arrayList = this.n;
        AbstractC9683aN7.M0(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.v.length; i2++) {
            this.v[i2].r(hlsMediaChunk.m(i2));
        }
        return hlsMediaChunk;
    }

    private boolean I(HlsMediaChunk hlsMediaChunk) {
        int i = hlsMediaChunk.k;
        int length = this.v.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.E0[i2] && this.v[i2].L() == i) {
                return false;
            }
        }
        return true;
    }

    private static boolean J(X x, X x2) {
        String str = x.l;
        String str2 = x2.l;
        int iK = AbstractC24462yf4.k(str);
        if (iK != 3) {
            return iK == AbstractC24462yf4.k(str2);
        }
        if (AbstractC9683aN7.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || x.G == x2.G;
        }
        return false;
    }

    private HlsMediaChunk K() {
        return (HlsMediaChunk) this.n.get(r0.size() - 1);
    }

    private InterfaceC4589Ft7 L(int i, int i2) {
        AbstractC20011rK.a(P0.contains(Integer.valueOf(i2)));
        int i3 = this.y.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.x.add(Integer.valueOf(i2))) {
            this.w[i3] = i;
        }
        return this.w[i3] == i ? this.v[i3] : C(i, i2);
    }

    private static int M(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    private void N(HlsMediaChunk hlsMediaChunk) {
        this.O0 = hlsMediaChunk;
        this.J = hlsMediaChunk.d;
        this.H0 = -9223372036854775807L;
        this.n.add(hlsMediaChunk);
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        for (HlsSampleQueue hlsSampleQueue : this.v) {
            aVarL.a(Integer.valueOf(hlsSampleQueue.B()));
        }
        hlsMediaChunk.n(this, aVarL.h());
        for (HlsSampleQueue hlsSampleQueue2 : this.v) {
            hlsSampleQueue2.d0(hlsMediaChunk);
            if (hlsMediaChunk.n) {
                hlsSampleQueue2.a0();
            }
        }
    }

    private static boolean O(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean P() {
        return this.H0 != -9223372036854775807L;
    }

    private void S() {
        int i = this.z0.a;
        int[] iArr = new int[i];
        this.B0 = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                HlsSampleQueue[] hlsSampleQueueArr = this.v;
                if (i3 >= hlsSampleQueueArr.length) {
                    break;
                }
                if (J((X) AbstractC20011rK.i(hlsSampleQueueArr[i3].A()), this.z0.c(i2).d(0))) {
                    this.B0[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        Iterator it = this.s.iterator();
        while (it.hasNext()) {
            ((HlsSampleStream) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (!this.Z && this.B0 == null && this.D) {
            for (HlsSampleQueue hlsSampleQueue : this.v) {
                if (hlsSampleQueue.A() == null) {
                    return;
                }
            }
            if (this.z0 != null) {
                S();
                return;
            }
            z();
            l0();
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        this.D = true;
        T();
    }

    private void g0() {
        for (HlsSampleQueue hlsSampleQueue : this.v) {
            hlsSampleQueue.R(this.I0);
        }
        this.I0 = false;
    }

    private boolean h0(long j) {
        int length = this.v.length;
        for (int i = 0; i < length; i++) {
            if (!this.v[i].T(j, false) && (this.F0[i] || !this.D0)) {
                return false;
            }
        }
        return true;
    }

    private void l0() {
        this.G = true;
    }

    private void q0(SampleStream[] sampleStreamArr) {
        this.s.clear();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream != null) {
                this.s.add((HlsSampleStream) sampleStream);
            }
        }
    }

    private void x() {
        AbstractC20011rK.g(this.G);
        AbstractC20011rK.e(this.z0);
        AbstractC20011rK.e(this.A0);
    }

    private void z() {
        X x;
        int length = this.v.length;
        int i = -2;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = ((X) AbstractC20011rK.i(this.v[i3].A())).l;
            int i4 = AbstractC24462yf4.r(str) ? 2 : AbstractC24462yf4.o(str) ? 1 : AbstractC24462yf4.q(str) ? 3 : -2;
            if (M(i4) > M(i)) {
                i2 = i3;
                i = i4;
            } else if (i4 == i && i2 != -1) {
                i2 = -1;
            }
            i3++;
        }
        TrackGroup trackGroupJ = this.d.j();
        int i5 = trackGroupJ.a;
        this.C0 = -1;
        this.B0 = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.B0[i6] = i6;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        int i7 = 0;
        while (i7 < length) {
            X x2 = (X) AbstractC20011rK.i(this.v[i7].A());
            if (i7 == i2) {
                X[] xArr = new X[i5];
                for (int i8 = 0; i8 < i5; i8++) {
                    X xD = trackGroupJ.d(i8);
                    if (i == 1 && (x = this.f) != null) {
                        xD = xD.l(x);
                    }
                    xArr[i8] = i5 == 1 ? x2.l(xD) : F(xD, x2, true);
                }
                trackGroupArr[i7] = new TrackGroup(this.a, xArr);
                this.C0 = i7;
            } else {
                X x3 = (i == 2 && AbstractC24462yf4.o(x2.l)) ? this.f : null;
                StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(":muxed:");
                sb.append(i7 < i2 ? i7 : i7 - 1);
                trackGroupArr[i7] = new TrackGroup(sb.toString(), F(x3, x2, false));
            }
            i7++;
        }
        this.z0 = E(trackGroupArr);
        AbstractC20011rK.g(this.A0 == null);
        this.A0 = Collections.emptySet();
    }

    public void B() {
        if (this.G) {
            return;
        }
        d(this.G0);
    }

    public boolean Q(int i) {
        return !P() && this.v[i].F(this.K0);
    }

    public boolean R() {
        return this.A == 2;
    }

    public void U() {
        this.j.j();
        this.d.n();
    }

    public void V(int i) {
        U();
        this.v[i].I();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void g(Chunk chunk, long j, long j2, boolean z) {
        this.u = null;
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), j, j2, chunk.b());
        this.i.d(chunk.a);
        this.k.r(loadEventInfo, chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        if (z) {
            return;
        }
        if (P() || this.H == 0) {
            g0();
        }
        if (this.H > 0) {
            this.c.g(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void j(Chunk chunk, long j, long j2) {
        this.u = null;
        this.d.p(chunk);
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), j, j2, chunk.b());
        this.i.d(chunk.a);
        this.k.u(loadEventInfo, chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        if (this.G) {
            this.c.g(this);
        } else {
            d(this.G0);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Loader.c n(Chunk chunk, long j, long j2, IOException iOException, int i) {
        Loader.c cVarG;
        int i2;
        boolean zO = O(chunk);
        if (zO && !((HlsMediaChunk) chunk).q() && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).d) == 410 || i2 == 404)) {
            return Loader.d;
        }
        long jB = chunk.b();
        LoadEventInfo loadEventInfo = new LoadEventInfo(chunk.a, chunk.b, chunk.f(), chunk.e(), j, j2, jB);
        j.c cVar = new j.c(loadEventInfo, new MediaLoadData(chunk.c, this.b, chunk.d, chunk.e, chunk.f, AbstractC9683aN7.c1(chunk.g), AbstractC9683aN7.c1(chunk.h)), iOException, i);
        j.b bVarC = this.i.c(AbstractC6974Pt7.c(this.d.k()), cVar);
        boolean zM = (bVarC == null || bVarC.a != 2) ? false : this.d.m(chunk, bVarC.b);
        if (zM) {
            if (zO && jB == 0) {
                ArrayList arrayList = this.n;
                AbstractC20011rK.g(((HlsMediaChunk) arrayList.remove(arrayList.size() - 1)) == chunk);
                if (this.n.isEmpty()) {
                    this.H0 = this.G0;
                } else {
                    ((HlsMediaChunk) AbstractC17264mg3.c(this.n)).o();
                }
            }
            cVarG = Loader.f;
        } else {
            long jA = this.i.a(cVar);
            cVarG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.g;
        }
        Loader.c cVar2 = cVarG;
        boolean z = !cVar2.c();
        this.k.w(loadEventInfo, chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h, iOException, z);
        if (z) {
            this.u = null;
            this.i.d(chunk.a);
        }
        if (zM) {
            if (this.G) {
                this.c.g(this);
            } else {
                d(this.G0);
            }
        }
        return cVar2;
    }

    public void Z() {
        this.x.clear();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        if (P()) {
            return this.H0;
        }
        if (this.K0) {
            return Long.MIN_VALUE;
        }
        return K().h;
    }

    public boolean a0(Uri uri, j.c cVar, boolean z) {
        j.b bVarC;
        if (!this.d.o(uri)) {
            return true;
        }
        long j = (z || (bVarC = this.i.c(AbstractC6974Pt7.c(this.d.k()), cVar)) == null || bVarC.a != 2) ? -9223372036854775807L : bVarC.b;
        return this.d.q(uri, j) && j != -9223372036854775807L;
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public InterfaceC4589Ft7 b(int i, int i2) {
        InterfaceC4589Ft7 interfaceC4589Ft7D;
        if (!P0.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                InterfaceC4589Ft7[] interfaceC4589Ft7Arr = this.v;
                if (i3 >= interfaceC4589Ft7Arr.length) {
                    interfaceC4589Ft7D = null;
                    break;
                }
                if (this.w[i3] == i) {
                    interfaceC4589Ft7D = interfaceC4589Ft7Arr[i3];
                    break;
                }
                i3++;
            }
        } else {
            interfaceC4589Ft7D = L(i, i2);
        }
        if (interfaceC4589Ft7D == null) {
            if (this.L0) {
                return C(i, i2);
            }
            interfaceC4589Ft7D = D(i, i2);
        }
        if (i2 != 5) {
            return interfaceC4589Ft7D;
        }
        if (this.z == null) {
            this.z = new EmsgUnwrappingTrackOutput(interfaceC4589Ft7D, this.l);
        }
        return this.z;
    }

    public void b0() {
        if (this.n.isEmpty()) {
            return;
        }
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) AbstractC17264mg3.c(this.n);
        int iC = this.d.c(hlsMediaChunk);
        if (iC == 1) {
            hlsMediaChunk.v();
        } else if (iC == 2 && !this.K0 && this.j.i()) {
            this.j.e();
        }
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.j.i();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        List listEmptyList;
        long jMax;
        if (this.K0 || this.j.i() || this.j.h()) {
            return false;
        }
        if (P()) {
            listEmptyList = Collections.emptyList();
            jMax = this.H0;
            for (HlsSampleQueue hlsSampleQueue : this.v) {
                hlsSampleQueue.V(this.H0);
            }
        } else {
            listEmptyList = this.o;
            HlsMediaChunk hlsMediaChunkK = K();
            jMax = hlsMediaChunkK.h() ? hlsMediaChunkK.h : Math.max(this.G0, hlsMediaChunkK.g);
        }
        List list = listEmptyList;
        long j2 = jMax;
        this.m.a();
        this.d.e(j, j2, list, this.G || !list.isEmpty(), this.m);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.m;
        boolean z = hlsChunkHolder.b;
        Chunk chunk = hlsChunkHolder.a;
        Uri uri = hlsChunkHolder.c;
        if (z) {
            this.H0 = -9223372036854775807L;
            this.K0 = true;
            return true;
        }
        if (chunk == null) {
            if (uri != null) {
                this.c.h(uri);
            }
            return false;
        }
        if (O(chunk)) {
            N((HlsMediaChunk) chunk);
        }
        this.u = chunk;
        this.k.A(new LoadEventInfo(chunk.a, chunk.b, this.j.n(chunk, this, this.i.b(chunk.c))), chunk.c, this.b, chunk.d, chunk.e, chunk.f, chunk.g, chunk.h);
        return true;
    }

    public void d0(TrackGroup[] trackGroupArr, int i, int... iArr) {
        this.z0 = E(trackGroupArr);
        this.A0 = new HashSet();
        for (int i2 : iArr) {
            this.A0.add(this.z0.c(i2));
        }
        this.C0 = i;
        Handler handler = this.r;
        final Callback callback = this.c;
        Objects.requireNonNull(callback);
        handler.post(new Runnable() { // from class: ir.nasim.qY2
            @Override // java.lang.Runnable
            public final void run() {
                callback.b();
            }
        });
        l0();
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        */
    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        /*
            r7 = this;
            boolean r0 = r7.K0
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.P()
            if (r0 == 0) goto L10
            long r0 = r7.H0
            return r0
        L10:
            long r0 = r7.G0
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = r7.K()
            boolean r3 = r2.h()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList r2 = r7.n
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList r2 = r7.n
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.HlsMediaChunk r2 = (com.google.android.exoplayer2.source.hls.HlsMediaChunk) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.D
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r2 = r7.v
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.u()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.e():long");
    }

    public int e0(int i, C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (P()) {
            return -3;
        }
        int i3 = 0;
        if (!this.n.isEmpty()) {
            int i4 = 0;
            while (i4 < this.n.size() - 1 && I((HlsMediaChunk) this.n.get(i4))) {
                i4++;
            }
            AbstractC9683aN7.M0(this.n, 0, i4);
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) this.n.get(0);
            X x = hlsMediaChunk.d;
            if (!x.equals(this.Y)) {
                this.k.i(this.b, x, hlsMediaChunk.e, hlsMediaChunk.f, hlsMediaChunk.g);
            }
            this.Y = x;
        }
        if (!this.n.isEmpty() && !((HlsMediaChunk) this.n.get(0)).q()) {
            return -3;
        }
        int iN = this.v[i].N(c21664tv2, decoderInputBuffer, i2, this.K0);
        if (iN == -5) {
            X xL = (X) AbstractC20011rK.e(c21664tv2.b);
            if (i == this.B) {
                int iL = this.v[i].L();
                while (i3 < this.n.size() && ((HlsMediaChunk) this.n.get(i3)).k != iL) {
                    i3++;
                }
                xL = xL.l(i3 < this.n.size() ? ((HlsMediaChunk) this.n.get(i3)).d : (X) AbstractC20011rK.e(this.J));
            }
            c21664tv2.b = xL;
        }
        return iN;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
        if (this.j.h() || P()) {
            return;
        }
        if (this.j.i()) {
            AbstractC20011rK.e(this.u);
            if (this.d.v(j, this.u, this.o)) {
                this.j.e();
                return;
            }
            return;
        }
        int size = this.o.size();
        while (size > 0 && this.d.c((HlsMediaChunk) this.o.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.o.size()) {
            G(size);
        }
        int iH = this.d.h(j, this.o);
        if (iH < this.n.size()) {
            G(iH);
        }
    }

    public void f0() {
        if (this.G) {
            for (HlsSampleQueue hlsSampleQueue : this.v) {
                hlsSampleQueue.M();
            }
        }
        this.j.m(this);
        this.r.removeCallbacksAndMessages(null);
        this.Z = true;
        this.s.clear();
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void h(X x) {
        this.r.post(this.p);
    }

    public boolean i0(long j, boolean z) {
        this.G0 = j;
        if (P()) {
            this.H0 = j;
            return true;
        }
        if (this.D && !z && h0(j)) {
            return false;
        }
        this.H0 = j;
        this.K0 = false;
        this.n.clear();
        if (this.j.i()) {
            if (this.D) {
                for (HlsSampleQueue hlsSampleQueue : this.v) {
                    hlsSampleQueue.p();
                }
            }
            this.j.e();
        } else {
            this.j.f();
            g0();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(ir.nasim.InterfaceC13679ge2[] r20, boolean[] r21, com.google.android.exoplayer2.source.SampleStream[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.j0(ir.nasim.ge2[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long, boolean):boolean");
    }

    public void k0(DrmInitData drmInitData) {
        if (AbstractC9683aN7.c(this.N0, drmInitData)) {
            return;
        }
        this.N0 = drmInitData;
        int i = 0;
        while (true) {
            HlsSampleQueue[] hlsSampleQueueArr = this.v;
            if (i >= hlsSampleQueueArr.length) {
                return;
            }
            if (this.F0[i]) {
                hlsSampleQueueArr[i].c0(drmInitData);
            }
            i++;
        }
    }

    public void m0(boolean z) {
        this.d.t(z);
    }

    public void n0(long j) {
        if (this.M0 != j) {
            this.M0 = j;
            for (HlsSampleQueue hlsSampleQueue : this.v) {
                hlsSampleQueue.U(j);
            }
        }
    }

    public int o0(int i, long j) {
        if (P()) {
            return 0;
        }
        HlsSampleQueue hlsSampleQueue = this.v[i];
        int iZ = hlsSampleQueue.z(j, this.K0);
        HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) AbstractC17264mg3.d(this.n, null);
        if (hlsMediaChunk != null && !hlsMediaChunk.q()) {
            iZ = Math.min(iZ, hlsMediaChunk.m(i) - hlsSampleQueue.x());
        }
        hlsSampleQueue.Y(iZ);
        return iZ;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void p() {
        for (HlsSampleQueue hlsSampleQueue : this.v) {
            hlsSampleQueue.O();
        }
    }

    public void p0(int i) {
        x();
        AbstractC20011rK.e(this.B0);
        int i2 = this.B0[i];
        AbstractC20011rK.g(this.E0[i2]);
        this.E0[i2] = false;
    }

    public void q() throws ParserException {
        U();
        if (this.K0 && !this.G) {
            throw ParserException.a("Loading finished before preparation is complete.", null);
        }
    }

    public long r(long j, C22738vk6 c22738vk6) {
        return this.d.b(j, c22738vk6);
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void s() {
        this.L0 = true;
        this.r.post(this.q);
    }

    public TrackGroupArray t() {
        x();
        return this.z0;
    }

    public void u(long j, boolean z) {
        if (!this.D || P()) {
            return;
        }
        int length = this.v.length;
        for (int i = 0; i < length; i++) {
            this.v[i].o(j, z, this.E0[i]);
        }
    }

    public int y(int i) {
        x();
        AbstractC20011rK.e(this.B0);
        int i2 = this.B0[i];
        if (i2 == -1) {
            return this.A0.contains(this.z0.c(i)) ? -3 : -2;
        }
        boolean[] zArr = this.E0;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void o(InterfaceC22148uk6 interfaceC22148uk6) {
    }
}
