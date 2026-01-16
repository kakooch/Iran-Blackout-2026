package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.IcyDataSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC22885vz1;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C19445qM6;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.C3962Dc1;
import ir.nasim.C8292Vi5;
import ir.nasim.EW4;
import ir.nasim.InterfaceC10465bf2;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC22148uk6;
import ir.nasim.InterfaceC4589Ft7;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class ProgressiveMediaPeriod implements MediaPeriod, InterfaceC10465bf2, Loader.b, Loader.f, SampleQueue.UpstreamFormatChangedListener {
    private static final Map D0 = L();
    private static final X E0 = new X.b().U("icy").g0("application/x-icy").G();
    private boolean A;
    private int A0;
    private boolean B0;
    private boolean C0;
    private boolean D;
    private boolean G;
    private int H;
    private boolean J;
    private long Y;
    private final Uri a;
    private final com.google.android.exoplayer2.upstream.a b;
    private final com.google.android.exoplayer2.drm.i c;
    private final com.google.android.exoplayer2.upstream.j d;
    private final MediaSourceEventListener.EventDispatcher e;
    private final h.a f;
    private final Listener g;
    private final InterfaceC19684qm h;
    private final String i;
    private final long j;
    private final ProgressiveMediaExtractor l;
    private MediaPeriod.Callback q;
    private IcyHeaders r;
    private boolean u;
    private boolean v;
    private boolean w;
    private TrackState x;
    private InterfaceC22148uk6 y;
    private boolean z0;
    private final Loader k = new Loader("ProgressiveMediaPeriod");
    private final C3962Dc1 m = new C3962Dc1();
    private final Runnable n = new Runnable() { // from class: com.google.android.exoplayer2.source.f
        @Override // java.lang.Runnable
        public final void run() {
            this.a.U();
        }
    };
    private final Runnable o = new Runnable() { // from class: com.google.android.exoplayer2.source.g
        @Override // java.lang.Runnable
        public final void run() {
            this.a.R();
        }
    };
    private final Handler p = AbstractC9683aN7.v();
    private TrackId[] t = new TrackId[0];
    private SampleQueue[] s = new SampleQueue[0];
    private long Z = -9223372036854775807L;
    private long z = -9223372036854775807L;
    private int B = 1;

    final class ExtractingLoadable implements Loader.e, IcyDataSource.Listener {
        private final Uri b;
        private final C19445qM6 c;
        private final ProgressiveMediaExtractor d;
        private final InterfaceC10465bf2 e;
        private final C3962Dc1 f;
        private volatile boolean h;
        private long j;
        private InterfaceC4589Ft7 l;
        private boolean m;
        private final C8292Vi5 g = new C8292Vi5();
        private boolean i = true;
        private final long a = LoadEventInfo.a();
        private com.google.android.exoplayer2.upstream.b k = i(0);

        public ExtractingLoadable(Uri uri, com.google.android.exoplayer2.upstream.a aVar, ProgressiveMediaExtractor progressiveMediaExtractor, InterfaceC10465bf2 interfaceC10465bf2, C3962Dc1 c3962Dc1) {
            this.b = uri;
            this.c = new C19445qM6(aVar);
            this.d = progressiveMediaExtractor;
            this.e = interfaceC10465bf2;
            this.f = c3962Dc1;
        }

        private com.google.android.exoplayer2.upstream.b i(long j) {
            return new b.C0164b().i(this.b).h(j).f(ProgressiveMediaPeriod.this.i).b(6).e(ProgressiveMediaPeriod.D0).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(long j, long j2) {
            this.g.a = j;
            this.j = j2;
            this.i = true;
            this.m = false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void a() {
            int iB = 0;
            while (iB == 0 && !this.h) {
                try {
                    long j = this.g.a;
                    com.google.android.exoplayer2.upstream.b bVarI = i(j);
                    this.k = bVarI;
                    long jB = this.c.b(bVarI);
                    if (jB != -1) {
                        jB += j;
                        ProgressiveMediaPeriod.this.Z();
                    }
                    long j2 = jB;
                    ProgressiveMediaPeriod.this.r = IcyHeaders.a(this.c.d());
                    InterfaceC18631oz1 icyDataSource = this.c;
                    if (ProgressiveMediaPeriod.this.r != null && ProgressiveMediaPeriod.this.r.f != -1) {
                        icyDataSource = new IcyDataSource(this.c, ProgressiveMediaPeriod.this.r.f, this);
                        InterfaceC4589Ft7 interfaceC4589Ft7O = ProgressiveMediaPeriod.this.O();
                        this.l = interfaceC4589Ft7O;
                        interfaceC4589Ft7O.c(ProgressiveMediaPeriod.E0);
                    }
                    long jE = j;
                    this.d.c(icyDataSource, this.b, this.c.d(), j, j2, this.e);
                    if (ProgressiveMediaPeriod.this.r != null) {
                        this.d.d();
                    }
                    if (this.i) {
                        this.d.a(jE, this.j);
                        this.i = false;
                    }
                    while (true) {
                        long j3 = jE;
                        while (iB == 0 && !this.h) {
                            try {
                                this.f.a();
                                iB = this.d.b(this.g);
                                jE = this.d.e();
                                if (jE > ProgressiveMediaPeriod.this.j + j3) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f.d();
                        ProgressiveMediaPeriod.this.p.post(ProgressiveMediaPeriod.this.o);
                    }
                    if (iB == 1) {
                        iB = 0;
                    } else if (this.d.e() != -1) {
                        this.g.a = this.d.e();
                    }
                    AbstractC22885vz1.a(this.c);
                } catch (Throwable th) {
                    if (iB != 1 && this.d.e() != -1) {
                        this.g.a = this.d.e();
                    }
                    AbstractC22885vz1.a(this.c);
                    throw th;
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.IcyDataSource.Listener
        public void b(EW4 ew4) {
            long jMax = !this.m ? this.j : Math.max(ProgressiveMediaPeriod.this.N(true), this.j);
            int iA = ew4.a();
            InterfaceC4589Ft7 interfaceC4589Ft7 = (InterfaceC4589Ft7) AbstractC20011rK.e(this.l);
            interfaceC4589Ft7.d(ew4, iA);
            interfaceC4589Ft7.b(jMax, 1, iA, 0, null);
            this.m = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
            this.h = true;
        }
    }

    interface Listener {
        void C(long j, boolean z, boolean z2);
    }

    private final class SampleStreamImpl implements SampleStream {
        private final int a;

        public SampleStreamImpl(int i) {
            this.a = i;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() throws IOException {
            ProgressiveMediaPeriod.this.Y(this.a);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return ProgressiveMediaPeriod.this.Q(this.a);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            return ProgressiveMediaPeriod.this.e0(this.a, c21664tv2, decoderInputBuffer, i);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            return ProgressiveMediaPeriod.this.i0(this.a, j);
        }
    }

    private static final class TrackId {
        public final int a;
        public final boolean b;

        public TrackId(int i, boolean z) {
            this.a = i;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || TrackId.class != obj.getClass()) {
                return false;
            }
            TrackId trackId = (TrackId) obj;
            return this.a == trackId.a && this.b == trackId.b;
        }

        public int hashCode() {
            return (this.a * 31) + (this.b ? 1 : 0);
        }
    }

    private static final class TrackState {
        public final TrackGroupArray a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;

        public TrackState(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.a = trackGroupArray;
            this.b = zArr;
            int i = trackGroupArray.a;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    public ProgressiveMediaPeriod(Uri uri, com.google.android.exoplayer2.upstream.a aVar, ProgressiveMediaExtractor progressiveMediaExtractor, com.google.android.exoplayer2.drm.i iVar, h.a aVar2, com.google.android.exoplayer2.upstream.j jVar, MediaSourceEventListener.EventDispatcher eventDispatcher, Listener listener, InterfaceC19684qm interfaceC19684qm, String str, int i) {
        this.a = uri;
        this.b = aVar;
        this.c = iVar;
        this.f = aVar2;
        this.d = jVar;
        this.e = eventDispatcher;
        this.g = listener;
        this.h = interfaceC19684qm;
        this.i = str;
        this.j = i;
        this.l = progressiveMediaExtractor;
    }

    private void J() {
        AbstractC20011rK.g(this.v);
        AbstractC20011rK.e(this.x);
        AbstractC20011rK.e(this.y);
    }

    private boolean K(ExtractingLoadable extractingLoadable, int i) {
        InterfaceC22148uk6 interfaceC22148uk6;
        if (this.J || !((interfaceC22148uk6 = this.y) == null || interfaceC22148uk6.i() == -9223372036854775807L)) {
            this.A0 = i;
            return true;
        }
        if (this.v && !k0()) {
            this.z0 = true;
            return false;
        }
        this.G = this.v;
        this.Y = 0L;
        this.A0 = 0;
        for (SampleQueue sampleQueue : this.s) {
            sampleQueue.Q();
        }
        extractingLoadable.j(0L, 0L);
        return true;
    }

    private static Map L() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    private int M() {
        int iB = 0;
        for (SampleQueue sampleQueue : this.s) {
            iB += sampleQueue.B();
        }
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long N(boolean z) {
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.s.length; i++) {
            if (z || ((TrackState) AbstractC20011rK.e(this.x)).c[i]) {
                jMax = Math.max(jMax, this.s[i].u());
            }
        }
        return jMax;
    }

    private boolean P() {
        return this.Z != -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        if (this.C0) {
            return;
        }
        ((MediaPeriod.Callback) AbstractC20011rK.e(this.q)).g(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.J = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.C0 || this.v || !this.u || this.y == null) {
            return;
        }
        for (SampleQueue sampleQueue : this.s) {
            if (sampleQueue.A() == null) {
                return;
            }
        }
        this.m.d();
        int length = this.s.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            X xG = (X) AbstractC20011rK.e(this.s[i].A());
            String str = xG.l;
            boolean zO = AbstractC24462yf4.o(str);
            boolean z = zO || AbstractC24462yf4.r(str);
            zArr[i] = z;
            this.w = z | this.w;
            IcyHeaders icyHeaders = this.r;
            if (icyHeaders != null) {
                if (zO || this.t[i].b) {
                    Metadata metadata = xG.j;
                    xG = xG.c().Z(metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders)).G();
                }
                if (zO && xG.f == -1 && xG.g == -1 && icyHeaders.a != -1) {
                    xG = xG.c().I(icyHeaders.a).G();
                }
            }
            trackGroupArr[i] = new TrackGroup(Integer.toString(i), xG.d(this.c.a(xG)));
        }
        this.x = new TrackState(new TrackGroupArray(trackGroupArr), zArr);
        this.v = true;
        ((MediaPeriod.Callback) AbstractC20011rK.e(this.q)).j(this);
    }

    private void V(int i) {
        J();
        TrackState trackState = this.x;
        boolean[] zArr = trackState.d;
        if (zArr[i]) {
            return;
        }
        X xD = trackState.a.c(i).d(0);
        this.e.i(AbstractC24462yf4.k(xD.l), xD, 0, null, this.Y);
        zArr[i] = true;
    }

    private void W(int i) {
        J();
        boolean[] zArr = this.x.b;
        if (this.z0 && zArr[i]) {
            if (this.s[i].F(false)) {
                return;
            }
            this.Z = 0L;
            this.z0 = false;
            this.G = true;
            this.Y = 0L;
            this.A0 = 0;
            for (SampleQueue sampleQueue : this.s) {
                sampleQueue.Q();
            }
            ((MediaPeriod.Callback) AbstractC20011rK.e(this.q)).g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.p.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h
            @Override // java.lang.Runnable
            public final void run() {
                this.a.S();
            }
        });
    }

    private InterfaceC4589Ft7 d0(TrackId trackId) {
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            if (trackId.equals(this.t[i])) {
                return this.s[i];
            }
        }
        SampleQueue sampleQueueK = SampleQueue.k(this.h, this.c, this.f);
        sampleQueueK.X(this);
        int i2 = length + 1;
        TrackId[] trackIdArr = (TrackId[]) Arrays.copyOf(this.t, i2);
        trackIdArr[length] = trackId;
        this.t = (TrackId[]) AbstractC9683aN7.k(trackIdArr);
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.s, i2);
        sampleQueueArr[length] = sampleQueueK;
        this.s = (SampleQueue[]) AbstractC9683aN7.k(sampleQueueArr);
        return sampleQueueK;
    }

    private boolean g0(boolean[] zArr, long j) {
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            if (!this.s[i].T(j, false) && (zArr[i] || !this.w)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void T(InterfaceC22148uk6 interfaceC22148uk6) {
        this.y = this.r == null ? interfaceC22148uk6 : new InterfaceC22148uk6.b(-9223372036854775807L);
        this.z = interfaceC22148uk6.i();
        boolean z = !this.J && interfaceC22148uk6.i() == -9223372036854775807L;
        this.A = z;
        this.B = z ? 7 : 1;
        this.g.C(this.z, interfaceC22148uk6.g(), this.A);
        if (this.v) {
            return;
        }
        U();
    }

    private void j0() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.a, this.b, this.l, this, this.m);
        if (this.v) {
            AbstractC20011rK.g(P());
            long j = this.z;
            if (j != -9223372036854775807L && this.Z > j) {
                this.B0 = true;
                this.Z = -9223372036854775807L;
                return;
            }
            extractingLoadable.j(((InterfaceC22148uk6) AbstractC20011rK.e(this.y)).c(this.Z).a.b, this.Z);
            for (SampleQueue sampleQueue : this.s) {
                sampleQueue.V(this.Z);
            }
            this.Z = -9223372036854775807L;
        }
        this.A0 = M();
        this.e.A(new LoadEventInfo(extractingLoadable.a, extractingLoadable.k, this.k.n(extractingLoadable, this, this.d.b(this.B))), 1, -1, null, 0, null, extractingLoadable.j, this.z);
    }

    private boolean k0() {
        return this.G || P();
    }

    InterfaceC4589Ft7 O() {
        return d0(new TrackId(0, true));
    }

    boolean Q(int i) {
        return !k0() && this.s[i].F(this.B0);
    }

    void X() throws IOException {
        this.k.k(this.d.b(this.B));
    }

    void Y(int i) throws IOException {
        this.s[i].I();
        X();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        return e();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void g(ExtractingLoadable extractingLoadable, long j, long j2, boolean z) {
        C19445qM6 c19445qM6 = extractingLoadable.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.a, extractingLoadable.k, c19445qM6.o(), c19445qM6.p(), j, j2, c19445qM6.n());
        this.d.d(extractingLoadable.a);
        this.e.r(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.j, this.z);
        if (z) {
            return;
        }
        for (SampleQueue sampleQueue : this.s) {
            sampleQueue.Q();
        }
        if (this.H > 0) {
            ((MediaPeriod.Callback) AbstractC20011rK.e(this.q)).g(this);
        }
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public InterfaceC4589Ft7 b(int i, int i2) {
        return d0(new TrackId(i, false));
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void j(ExtractingLoadable extractingLoadable, long j, long j2) {
        InterfaceC22148uk6 interfaceC22148uk6;
        if (this.z == -9223372036854775807L && (interfaceC22148uk6 = this.y) != null) {
            boolean zG = interfaceC22148uk6.g();
            long jN = N(true);
            long j3 = jN == Long.MIN_VALUE ? 0L : jN + 10000;
            this.z = j3;
            this.g.C(j3, zG, this.A);
        }
        C19445qM6 c19445qM6 = extractingLoadable.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.a, extractingLoadable.k, c19445qM6.o(), c19445qM6.p(), j, j2, c19445qM6.n());
        this.d.d(extractingLoadable.a);
        this.e.u(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.j, this.z);
        this.B0 = true;
        ((MediaPeriod.Callback) AbstractC20011rK.e(this.q)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.k.i() && this.m.e();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public Loader.c n(ExtractingLoadable extractingLoadable, long j, long j2, IOException iOException, int i) {
        boolean z;
        ExtractingLoadable extractingLoadable2;
        Loader.c cVarG;
        C19445qM6 c19445qM6 = extractingLoadable.c;
        LoadEventInfo loadEventInfo = new LoadEventInfo(extractingLoadable.a, extractingLoadable.k, c19445qM6.o(), c19445qM6.p(), j, j2, c19445qM6.n());
        long jA = this.d.a(new j.c(loadEventInfo, new MediaLoadData(1, -1, null, 0, null, AbstractC9683aN7.c1(extractingLoadable.j), AbstractC9683aN7.c1(this.z)), iOException, i));
        if (jA == -9223372036854775807L) {
            cVarG = Loader.g;
        } else {
            int iM = M();
            if (iM > this.A0) {
                extractingLoadable2 = extractingLoadable;
                z = true;
            } else {
                z = false;
                extractingLoadable2 = extractingLoadable;
            }
            cVarG = K(extractingLoadable2, iM) ? Loader.g(z, jA) : Loader.f;
        }
        boolean z2 = !cVarG.c();
        this.e.w(loadEventInfo, 1, -1, null, 0, null, extractingLoadable.j, this.z, iOException, z2);
        if (z2) {
            this.d.d(extractingLoadable.a);
        }
        return cVarG;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        if (this.B0 || this.k.h() || this.z0) {
            return false;
        }
        if (this.v && this.H == 0) {
            return false;
        }
        boolean zF = this.m.f();
        if (this.k.i()) {
            return zF;
        }
        j0();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        long jN;
        J();
        if (this.B0 || this.H == 0) {
            return Long.MIN_VALUE;
        }
        if (P()) {
            return this.Z;
        }
        if (this.w) {
            int length = this.s.length;
            jN = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                TrackState trackState = this.x;
                if (trackState.b[i] && trackState.c[i] && !this.s[i].E()) {
                    jN = Math.min(jN, this.s[i].u());
                }
            }
        } else {
            jN = Long.MAX_VALUE;
        }
        if (jN == Long.MAX_VALUE) {
            jN = N(false);
        }
        return jN == Long.MIN_VALUE ? this.Y : jN;
    }

    int e0(int i, C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (k0()) {
            return -3;
        }
        V(i);
        int iN = this.s[i].N(c21664tv2, decoderInputBuffer, i2, this.B0);
        if (iN == -3) {
            W(i);
        }
        return iN;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
    }

    public void f0() {
        if (this.v) {
            for (SampleQueue sampleQueue : this.s) {
                sampleQueue.M();
            }
        }
        this.k.m(this);
        this.p.removeCallbacksAndMessages(null);
        this.q = null;
        this.C0 = true;
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void h(X x) {
        this.p.post(this.n);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long i(InterfaceC13679ge2[] interfaceC13679ge2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        InterfaceC13679ge2 interfaceC13679ge2;
        J();
        TrackState trackState = this.x;
        TrackGroupArray trackGroupArray = trackState.a;
        boolean[] zArr3 = trackState.c;
        int i = this.H;
        int i2 = 0;
        for (int i3 = 0; i3 < interfaceC13679ge2Arr.length; i3++) {
            SampleStream sampleStream = sampleStreamArr[i3];
            if (sampleStream != null && (interfaceC13679ge2Arr[i3] == null || !zArr[i3])) {
                int i4 = ((SampleStreamImpl) sampleStream).a;
                AbstractC20011rK.g(zArr3[i4]);
                this.H--;
                zArr3[i4] = false;
                sampleStreamArr[i3] = null;
            }
        }
        boolean z = !this.D ? j == 0 : i != 0;
        for (int i5 = 0; i5 < interfaceC13679ge2Arr.length; i5++) {
            if (sampleStreamArr[i5] == null && (interfaceC13679ge2 = interfaceC13679ge2Arr[i5]) != null) {
                AbstractC20011rK.g(interfaceC13679ge2.length() == 1);
                AbstractC20011rK.g(interfaceC13679ge2.g(0) == 0);
                int iD = trackGroupArray.d(interfaceC13679ge2.l());
                AbstractC20011rK.g(!zArr3[iD]);
                this.H++;
                zArr3[iD] = true;
                sampleStreamArr[i5] = new SampleStreamImpl(iD);
                zArr2[i5] = true;
                if (!z) {
                    SampleQueue sampleQueue = this.s[iD];
                    z = (sampleQueue.T(j, true) || sampleQueue.x() == 0) ? false : true;
                }
            }
        }
        if (this.H == 0) {
            this.z0 = false;
            this.G = false;
            if (this.k.i()) {
                SampleQueue[] sampleQueueArr = this.s;
                int length = sampleQueueArr.length;
                while (i2 < length) {
                    sampleQueueArr[i2].p();
                    i2++;
                }
                this.k.e();
            } else {
                SampleQueue[] sampleQueueArr2 = this.s;
                int length2 = sampleQueueArr2.length;
                while (i2 < length2) {
                    sampleQueueArr2[i2].Q();
                    i2++;
                }
            }
        } else if (z) {
            j = k(j);
            while (i2 < sampleStreamArr.length) {
                if (sampleStreamArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.D = true;
        return j;
    }

    int i0(int i, long j) {
        if (k0()) {
            return 0;
        }
        V(i);
        SampleQueue sampleQueue = this.s[i];
        int iZ = sampleQueue.z(j, this.B0);
        sampleQueue.Y(iZ);
        if (iZ == 0) {
            W(i);
        }
        return iZ;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long k(long j) {
        J();
        boolean[] zArr = this.x.b;
        if (!this.y.g()) {
            j = 0;
        }
        int i = 0;
        this.G = false;
        this.Y = j;
        if (P()) {
            this.Z = j;
            return j;
        }
        if (this.B != 7 && g0(zArr, j)) {
            return j;
        }
        this.z0 = false;
        this.Z = j;
        this.B0 = false;
        if (this.k.i()) {
            SampleQueue[] sampleQueueArr = this.s;
            int length = sampleQueueArr.length;
            while (i < length) {
                sampleQueueArr[i].p();
                i++;
            }
            this.k.e();
        } else {
            this.k.f();
            SampleQueue[] sampleQueueArr2 = this.s;
            int length2 = sampleQueueArr2.length;
            while (i < length2) {
                sampleQueueArr2[i].Q();
                i++;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long l() {
        if (!this.G) {
            return -9223372036854775807L;
        }
        if (!this.B0 && M() <= this.A0) {
            return -9223372036854775807L;
        }
        this.G = false;
        return this.Y;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void m(MediaPeriod.Callback callback, long j) {
        this.q = callback;
        this.m.f();
        j0();
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void o(final InterfaceC22148uk6 interfaceC22148uk6) {
        this.p.post(new Runnable() { // from class: com.google.android.exoplayer2.source.i
            @Override // java.lang.Runnable
            public final void run() {
                this.a.T(interfaceC22148uk6);
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void p() {
        for (SampleQueue sampleQueue : this.s) {
            sampleQueue.O();
        }
        this.l.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void q() throws IOException {
        X();
        if (this.B0 && !this.v) {
            throw ParserException.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long r(long j, C22738vk6 c22738vk6) {
        J();
        if (!this.y.g()) {
            return 0L;
        }
        InterfaceC22148uk6.a aVarC = this.y.c(j);
        return c22738vk6.a(j, aVarC.a.a, aVarC.b.a);
    }

    @Override // ir.nasim.InterfaceC10465bf2
    public void s() {
        this.u = true;
        this.p.post(this.n);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray t() {
        J();
        return this.x.a;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void u(long j, boolean z) {
        J();
        if (P()) {
            return;
        }
        boolean[] zArr = this.x.c;
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].o(j, z, zArr[i]);
        }
    }
}
