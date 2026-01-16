package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.A0;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.C2033i;
import com.google.android.exoplayer2.D0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.upstream.DataSourceException;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AO5;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC3895Cu6;
import ir.nasim.AbstractC7218Qt7;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C22738vk6;
import ir.nasim.C5954Ln7;
import ir.nasim.C7452Rt7;
import ir.nasim.InterfaceC10699c30;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC23757xT2;
import ir.nasim.InterfaceC24899zO5;
import ir.nasim.InterfaceC3582Bm;
import ir.nasim.NV0;
import ir.nasim.Q17;
import ir.nasim.RF3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class W implements Handler.Callback, MediaPeriod.Callback, AbstractC7218Qt7.a, u0.d, C2033i.a, A0.a {
    private boolean A;
    private int A0;
    private boolean B;
    private h B0;
    private long C0;
    private boolean D;
    private int D0;
    private boolean E0;
    private ExoPlaybackException F0;
    private boolean G;
    private long G0;
    private int H;
    private long H0 = -9223372036854775807L;
    private boolean J;
    private boolean Y;
    private boolean Z;
    private final D0[] a;
    private final Set b;
    private final InterfaceC24899zO5[] c;
    private final AbstractC7218Qt7 d;
    private final C7452Rt7 e;
    private final RF3 f;
    private final InterfaceC10699c30 g;
    private final InterfaceC23757xT2 h;
    private final HandlerThread i;
    private final Looper j;
    private final J0.d k;
    private final J0.b l;
    private final long m;
    private final boolean n;
    private final C2033i o;
    private final ArrayList p;
    private final NV0 q;
    private final f r;
    private final C2028f0 s;
    private final u0 t;
    private final Z u;
    private final long v;
    private C22738vk6 w;
    private x0 x;
    private e y;
    private boolean z;
    private boolean z0;

    class a implements D0.a {
        a() {
        }

        @Override // com.google.android.exoplayer2.D0.a
        public void a() {
            W.this.Z = true;
        }

        @Override // com.google.android.exoplayer2.D0.a
        public void b() {
            W.this.h.i(2);
        }
    }

    private static final class b {
        private final List a;
        private final ShuffleOrder b;
        private final int c;
        private final long d;

        /* synthetic */ b(List list, ShuffleOrder shuffleOrder, int i, long j, a aVar) {
            this(list, shuffleOrder, i, j);
        }

        private b(List list, ShuffleOrder shuffleOrder, int i, long j) {
            this.a = list;
            this.b = shuffleOrder;
            this.c = i;
            this.d = j;
        }
    }

    private static class c {
    }

    private static final class d implements Comparable {
        public final A0 a;
        public int b;
        public long c;
        public Object d;

        public d(A0 a0) {
            this.a = a0;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.d;
            if ((obj == null) != (dVar.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - dVar.b;
            return i != 0 ? i : AbstractC9683aN7.n(this.c, dVar.c);
        }

        public void h(int i, long j, Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }
    }

    public static final class e {
        private boolean a;
        public x0 b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public e(x0 x0Var) {
            this.b = x0Var;
        }

        public void b(int i) {
            this.a |= i > 0;
            this.c += i;
        }

        public void c(int i) {
            this.a = true;
            this.f = true;
            this.g = i;
        }

        public void d(x0 x0Var) {
            this.a |= this.b != x0Var;
            this.b = x0Var;
        }

        public void e(int i) {
            if (this.d && this.e != 5) {
                AbstractC20011rK.a(i == 5);
                return;
            }
            this.a = true;
            this.d = true;
            this.e = i;
        }
    }

    public interface f {
        void a(e eVar);
    }

    private static final class g {
        public final MediaSource.MediaPeriodId a;
        public final long b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public g(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, boolean z, boolean z2, boolean z3) {
            this.a = mediaPeriodId;
            this.b = j;
            this.c = j2;
            this.d = z;
            this.e = z2;
            this.f = z3;
        }
    }

    private static final class h {
        public final J0 a;
        public final int b;
        public final long c;

        public h(J0 j0, int i, long j) {
            this.a = j0;
            this.b = i;
            this.c = j;
        }
    }

    public W(D0[] d0Arr, AbstractC7218Qt7 abstractC7218Qt7, C7452Rt7 c7452Rt7, RF3 rf3, InterfaceC10699c30 interfaceC10699c30, int i, boolean z, InterfaceC3582Bm interfaceC3582Bm, C22738vk6 c22738vk6, Z z2, long j, boolean z3, Looper looper, NV0 nv0, f fVar, C15493jg5 c15493jg5, Looper looper2) {
        this.r = fVar;
        this.a = d0Arr;
        this.d = abstractC7218Qt7;
        this.e = c7452Rt7;
        this.f = rf3;
        this.g = interfaceC10699c30;
        this.H = i;
        this.J = z;
        this.w = c22738vk6;
        this.u = z2;
        this.v = j;
        this.G0 = j;
        this.A = z3;
        this.q = nv0;
        this.m = rf3.c();
        this.n = rf3.a();
        x0 x0VarJ = x0.j(c7452Rt7);
        this.x = x0VarJ;
        this.y = new e(x0VarJ);
        this.c = new InterfaceC24899zO5[d0Arr.length];
        for (int i2 = 0; i2 < d0Arr.length; i2++) {
            d0Arr[i2].u(i2, c15493jg5);
            this.c[i2] = d0Arr[i2].w();
        }
        this.o = new C2033i(this, nv0);
        this.p = new ArrayList();
        this.b = AbstractC3895Cu6.h();
        this.k = new J0.d();
        this.l = new J0.b();
        abstractC7218Qt7.c(this, interfaceC10699c30);
        this.E0 = true;
        InterfaceC23757xT2 interfaceC23757xT2A = nv0.a(looper, null);
        this.s = new C2028f0(interfaceC3582Bm, interfaceC23757xT2A);
        this.t = new u0(this, interfaceC3582Bm, interfaceC23757xT2A, c15493jg5);
        if (looper2 != null) {
            this.i = null;
            this.j = looper2;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.i = handlerThread;
            handlerThread.start();
            this.j = handlerThread.getLooper();
        }
        this.h = nv0.a(this.j, this);
    }

    private long A() {
        C2022c0 c2022c0Q = this.s.q();
        if (c2022c0Q == null) {
            return 0L;
        }
        long jL = c2022c0Q.l();
        if (!c2022c0Q.d) {
            return jL;
        }
        int i = 0;
        while (true) {
            D0[] d0Arr = this.a;
            if (i >= d0Arr.length) {
                return jL;
            }
            if (S(d0Arr[i]) && this.a[i].i() == c2022c0Q.c[i]) {
                long jC = this.a[i].C();
                if (jC == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(jC, jL);
            }
            i++;
        }
    }

    static Object A0(J0.d dVar, J0.b bVar, int i, boolean z, Object obj, J0 j0, J0 j02) {
        int iG = j0.g(obj);
        int iN = j0.n();
        int i2 = iG;
        int iG2 = -1;
        for (int i3 = 0; i3 < iN && iG2 == -1; i3++) {
            i2 = j0.i(i2, bVar, dVar, i, z);
            if (i2 == -1) {
                break;
            }
            iG2 = j02.g(j0.r(i2));
        }
        if (iG2 == -1) {
            return null;
        }
        return j02.r(iG2);
    }

    private void B0(long j, long j2) {
        this.h.j(2, j + j2);
    }

    private Pair C(J0 j0) {
        if (j0.v()) {
            return Pair.create(x0.k(), 0L);
        }
        Pair pairO = j0.o(this.k, this.l, j0.f(this.J), -9223372036854775807L);
        MediaSource.MediaPeriodId mediaPeriodIdB = this.s.B(j0, pairO.first, 0L);
        long jLongValue = ((Long) pairO.second).longValue();
        if (mediaPeriodIdB.c()) {
            j0.m(mediaPeriodIdB.a, this.l);
            jLongValue = mediaPeriodIdB.c == this.l.o(mediaPeriodIdB.b) ? this.l.k() : 0L;
        }
        return Pair.create(mediaPeriodIdB, Long.valueOf(jLongValue));
    }

    private void D0(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.s.p().f.a;
        long jG0 = G0(mediaPeriodId, this.x.r, true, false);
        if (jG0 != this.x.r) {
            x0 x0Var = this.x;
            this.x = N(mediaPeriodId, jG0, x0Var.c, x0Var.d, z, 5);
        }
    }

    private long E() {
        return F(this.x.p);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[Catch: all -> 0x00af, TryCatch #1 {all -> 0x00af, blocks: (B:22:0x00a2, B:24:0x00ac, B:29:0x00b6, B:31:0x00bc, B:32:0x00bf, B:34:0x00c5, B:36:0x00cf, B:38:0x00d7, B:42:0x00df, B:44:0x00e9, B:46:0x00f9, B:50:0x0103, B:54:0x0115, B:58:0x011e), top: B:74:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void E0(com.google.android.exoplayer2.W.h r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.W.E0(com.google.android.exoplayer2.W$h):void");
    }

    private long F(long j) {
        C2022c0 c2022c0J = this.s.j();
        if (c2022c0J == null) {
            return 0L;
        }
        return Math.max(0L, j - c2022c0J.y(this.C0));
    }

    private long F0(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) {
        return G0(mediaPeriodId, j, this.s.p() != this.s.q(), z);
    }

    private void G(MediaPeriod mediaPeriod) {
        if (this.s.v(mediaPeriod)) {
            this.s.y(this.C0);
            X();
        }
    }

    private long G0(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z, boolean z2) throws ExoPlaybackException {
        l1();
        this.D = false;
        if (z2 || this.x.e == 3) {
            c1(2);
        }
        C2022c0 c2022c0P = this.s.p();
        C2022c0 c2022c0J = c2022c0P;
        while (c2022c0J != null && !mediaPeriodId.equals(c2022c0J.f.a)) {
            c2022c0J = c2022c0J.j();
        }
        if (z || c2022c0P != c2022c0J || (c2022c0J != null && c2022c0J.z(j) < 0)) {
            for (D0 d0 : this.a) {
                p(d0);
            }
            if (c2022c0J != null) {
                while (this.s.p() != c2022c0J) {
                    this.s.b();
                }
                this.s.z(c2022c0J);
                c2022c0J.x(1000000000000L);
                s();
            }
        }
        if (c2022c0J != null) {
            this.s.z(c2022c0J);
            if (!c2022c0J.d) {
                c2022c0J.f = c2022c0J.f.b(j);
            } else if (c2022c0J.e) {
                j = c2022c0J.a.k(j);
                c2022c0J.a.u(j - this.m, this.n);
            }
            u0(j);
            X();
        } else {
            this.s.f();
            u0(j);
        }
        I(false);
        this.h.i(2);
        return j;
    }

    private void H(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackExceptionL = ExoPlaybackException.l(iOException, i);
        C2022c0 c2022c0P = this.s.p();
        if (c2022c0P != null) {
            exoPlaybackExceptionL = exoPlaybackExceptionL.j(c2022c0P.f.a);
        }
        AbstractC18815pI3.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionL);
        k1(false, false);
        this.x = this.x.e(exoPlaybackExceptionL);
    }

    private void H0(A0 a0) {
        if (a0.f() == -9223372036854775807L) {
            I0(a0);
            return;
        }
        if (this.x.a.v()) {
            this.p.add(new d(a0));
            return;
        }
        d dVar = new d(a0);
        J0 j0 = this.x.a;
        if (!w0(dVar, j0, j0, this.H, this.J, this.k, this.l)) {
            a0.k(false);
        } else {
            this.p.add(dVar);
            Collections.sort(this.p);
        }
    }

    private void I(boolean z) {
        C2022c0 c2022c0J = this.s.j();
        MediaSource.MediaPeriodId mediaPeriodId = c2022c0J == null ? this.x.b : c2022c0J.f.a;
        boolean z2 = !this.x.k.equals(mediaPeriodId);
        if (z2) {
            this.x = this.x.b(mediaPeriodId);
        }
        x0 x0Var = this.x;
        x0Var.p = c2022c0J == null ? x0Var.r : c2022c0J.i();
        this.x.q = E();
        if ((z2 || z) && c2022c0J != null && c2022c0J.d) {
            n1(c2022c0J.n(), c2022c0J.o());
        }
    }

    private void I0(A0 a0) {
        if (a0.c() != this.j) {
            this.h.e(15, a0).a();
            return;
        }
        o(a0);
        int i = this.x.e;
        if (i == 3 || i == 2) {
            this.h.i(2);
        }
    }

    private void J(J0 j0, boolean z) throws Throwable {
        int i;
        int i2;
        boolean z2;
        g gVarY0 = y0(j0, this.x, this.B0, this.s, this.H, this.J, this.k, this.l);
        MediaSource.MediaPeriodId mediaPeriodId = gVarY0.a;
        long j = gVarY0.c;
        boolean z3 = gVarY0.d;
        long jF0 = gVarY0.b;
        boolean z4 = (this.x.b.equals(mediaPeriodId) && jF0 == this.x.r) ? false : true;
        h hVar = null;
        try {
            if (gVarY0.e) {
                if (this.x.e != 1) {
                    c1(4);
                }
                s0(false, false, false, true);
            }
            try {
                if (z4) {
                    i2 = 4;
                    z2 = false;
                    if (!j0.v()) {
                        for (C2022c0 c2022c0P = this.s.p(); c2022c0P != null; c2022c0P = c2022c0P.j()) {
                            if (c2022c0P.f.a.equals(mediaPeriodId)) {
                                c2022c0P.f = this.s.r(j0, c2022c0P.f);
                                c2022c0P.A();
                            }
                        }
                        jF0 = F0(mediaPeriodId, jF0, z3);
                    }
                } else {
                    try {
                        try {
                            i2 = 4;
                            z2 = false;
                            if (!this.s.F(j0, this.C0, A())) {
                                D0(false);
                            }
                        } catch (Throwable th) {
                            th = th;
                            i = 4;
                            hVar = null;
                            x0 x0Var = this.x;
                            h hVar2 = hVar;
                            q1(j0, mediaPeriodId, x0Var.a, x0Var.b, gVarY0.f ? jF0 : -9223372036854775807L);
                            if (z4 || j != this.x.c) {
                                x0 x0Var2 = this.x;
                                Object obj = x0Var2.b.a;
                                J0 j02 = x0Var2.a;
                                this.x = N(mediaPeriodId, jF0, j, this.x.d, z4 && z && !j02.v() && !j02.m(obj, this.l).f, j0.g(obj) == -1 ? i : 3);
                            }
                            t0();
                            x0(j0, this.x.a);
                            this.x = this.x.i(j0);
                            if (!j0.v()) {
                                this.B0 = hVar2;
                            }
                            I(false);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i = 4;
                    }
                }
                x0 x0Var3 = this.x;
                q1(j0, mediaPeriodId, x0Var3.a, x0Var3.b, gVarY0.f ? jF0 : -9223372036854775807L);
                if (z4 || j != this.x.c) {
                    x0 x0Var4 = this.x;
                    Object obj2 = x0Var4.b.a;
                    J0 j03 = x0Var4.a;
                    this.x = N(mediaPeriodId, jF0, j, this.x.d, (!z4 || !z || j03.v() || j03.m(obj2, this.l).f) ? z2 : true, j0.g(obj2) == -1 ? i2 : 3);
                }
                t0();
                x0(j0, this.x.a);
                this.x = this.x.i(j0);
                if (!j0.v()) {
                    this.B0 = null;
                }
                I(z2);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            i = 4;
        }
    }

    private void J0(final A0 a0) {
        Looper looperC = a0.c();
        if (looperC.getThread().isAlive()) {
            this.q.a(looperC, null).h(new Runnable() { // from class: com.google.android.exoplayer2.V
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.W(a0);
                }
            });
        } else {
            AbstractC18815pI3.k("TAG", "Trying to send message on a dead thread.");
            a0.k(false);
        }
    }

    private void K(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.s.v(mediaPeriod)) {
            C2022c0 c2022c0J = this.s.j();
            c2022c0J.p(this.o.c().a, this.x.a);
            n1(c2022c0J.n(), c2022c0J.o());
            if (c2022c0J == this.s.p()) {
                u0(c2022c0J.f.b);
                s();
                x0 x0Var = this.x;
                MediaSource.MediaPeriodId mediaPeriodId = x0Var.b;
                long j = c2022c0J.f.b;
                this.x = N(mediaPeriodId, j, x0Var.c, j, false, 5);
            }
            X();
        }
    }

    private void K0(long j) {
        for (D0 d0 : this.a) {
            if (d0.i() != null) {
                L0(d0, j);
            }
        }
    }

    private void L(y0 y0Var, float f2, boolean z, boolean z2) {
        if (z) {
            if (z2) {
                this.y.b(1);
            }
            this.x = this.x.f(y0Var);
        }
        r1(y0Var.a);
        for (D0 d0 : this.a) {
            if (d0 != null) {
                d0.z(f2, y0Var.a);
            }
        }
    }

    private void L0(D0 d0, long j) {
        d0.l();
        if (d0 instanceof C5954Ln7) {
            ((C5954Ln7) d0).i0(j);
        }
    }

    private void M(y0 y0Var, boolean z) {
        L(y0Var, y0Var.a, true, z);
    }

    private void M0(boolean z, AtomicBoolean atomicBoolean) {
        if (this.Y != z) {
            this.Y = z;
            if (!z) {
                for (D0 d0 : this.a) {
                    if (!S(d0) && this.b.remove(d0)) {
                        d0.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    private x0 N(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, boolean z, int i) {
        AbstractC12710f43 abstractC12710f43V;
        TrackGroupArray trackGroupArray;
        C7452Rt7 c7452Rt7;
        this.E0 = (!this.E0 && j == this.x.r && mediaPeriodId.equals(this.x.b)) ? false : true;
        t0();
        x0 x0Var = this.x;
        TrackGroupArray trackGroupArray2 = x0Var.h;
        C7452Rt7 c7452Rt72 = x0Var.i;
        ?? r1 = x0Var.j;
        if (this.t.s()) {
            C2022c0 c2022c0P = this.s.p();
            TrackGroupArray trackGroupArrayN = c2022c0P == null ? TrackGroupArray.d : c2022c0P.n();
            C7452Rt7 c7452Rt7O = c2022c0P == null ? this.e : c2022c0P.o();
            AbstractC12710f43 abstractC12710f43W = w(c7452Rt7O.c);
            if (c2022c0P != null) {
                C2024d0 c2024d0 = c2022c0P.f;
                if (c2024d0.c != j2) {
                    c2022c0P.f = c2024d0.a(j2);
                }
            }
            trackGroupArray = trackGroupArrayN;
            c7452Rt7 = c7452Rt7O;
            abstractC12710f43V = abstractC12710f43W;
        } else if (mediaPeriodId.equals(this.x.b)) {
            abstractC12710f43V = r1;
            trackGroupArray = trackGroupArray2;
            c7452Rt7 = c7452Rt72;
        } else {
            trackGroupArray = TrackGroupArray.d;
            c7452Rt7 = this.e;
            abstractC12710f43V = AbstractC12710f43.V();
        }
        if (z) {
            this.y.e(i);
        }
        return this.x.c(mediaPeriodId, j, j2, j3, E(), trackGroupArray, c7452Rt7, abstractC12710f43V);
    }

    private void N0(b bVar) throws Throwable {
        this.y.b(1);
        if (bVar.c != -1) {
            this.B0 = new h(new B0(bVar.a, bVar.b), bVar.c, bVar.d);
        }
        J(this.t.B(bVar.a, bVar.b), false);
    }

    private boolean O(D0 d0, C2022c0 c2022c0) {
        C2022c0 c2022c0J = c2022c0.j();
        return c2022c0.f.f && c2022c0J.d && ((d0 instanceof C5954Ln7) || (d0 instanceof com.google.android.exoplayer2.metadata.a) || d0.C() >= c2022c0J.m());
    }

    private boolean P() {
        C2022c0 c2022c0Q = this.s.q();
        if (!c2022c0Q.d) {
            return false;
        }
        int i = 0;
        while (true) {
            D0[] d0Arr = this.a;
            if (i >= d0Arr.length) {
                return true;
            }
            D0 d0 = d0Arr[i];
            SampleStream sampleStream = c2022c0Q.c[i];
            if (d0.i() != sampleStream || (sampleStream != null && !d0.j() && !O(d0, c2022c0Q))) {
                break;
            }
            i++;
        }
        return false;
    }

    private void P0(boolean z) {
        if (z == this.z0) {
            return;
        }
        this.z0 = z;
        if (z || !this.x.o) {
            return;
        }
        this.h.i(2);
    }

    private static boolean Q(boolean z, MediaSource.MediaPeriodId mediaPeriodId, long j, MediaSource.MediaPeriodId mediaPeriodId2, J0.b bVar, long j2) {
        if (!z && j == j2 && mediaPeriodId.a.equals(mediaPeriodId2.a)) {
            return (mediaPeriodId.c() && bVar.u(mediaPeriodId.b)) ? (bVar.l(mediaPeriodId.b, mediaPeriodId.c) == 4 || bVar.l(mediaPeriodId.b, mediaPeriodId.c) == 2) ? false : true : mediaPeriodId2.c() && bVar.u(mediaPeriodId2.b);
        }
        return false;
    }

    private void Q0(boolean z) throws ExoPlaybackException {
        this.A = z;
        t0();
        if (!this.B || this.s.q() == this.s.p()) {
            return;
        }
        D0(true);
        I(false);
    }

    private boolean R() {
        C2022c0 c2022c0J = this.s.j();
        return (c2022c0J == null || c2022c0J.k() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean S(D0 d0) {
        return d0.getState() != 0;
    }

    private void S0(boolean z, int i, boolean z2, int i2) {
        this.y.b(z2 ? 1 : 0);
        this.y.c(i2);
        this.x = this.x.d(z, i);
        this.D = false;
        h0(z);
        if (!f1()) {
            l1();
            p1();
            return;
        }
        int i3 = this.x.e;
        if (i3 == 3) {
            i1();
            this.h.i(2);
        } else if (i3 == 2) {
            this.h.i(2);
        }
    }

    private boolean T() {
        C2022c0 c2022c0P = this.s.p();
        long j = c2022c0P.f.e;
        return c2022c0P.d && (j == -9223372036854775807L || this.x.r < j || !f1());
    }

    private static boolean U(x0 x0Var, J0.b bVar) {
        MediaSource.MediaPeriodId mediaPeriodId = x0Var.b;
        J0 j0 = x0Var.a;
        return j0.v() || j0.m(mediaPeriodId.a, bVar).f;
    }

    private void U0(y0 y0Var) {
        this.o.e(y0Var);
        M(this.o.c(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean V() {
        return Boolean.valueOf(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(A0 a0) {
        try {
            o(a0);
        } catch (ExoPlaybackException e2) {
            AbstractC18815pI3.d("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void W0(int i) throws ExoPlaybackException {
        this.H = i;
        if (!this.s.G(this.x.a, i)) {
            D0(true);
        }
        I(false);
    }

    private void X() {
        boolean zE1 = e1();
        this.G = zE1;
        if (zE1) {
            this.s.j().d(this.C0);
        }
        m1();
    }

    private void X0(C22738vk6 c22738vk6) {
        this.w = c22738vk6;
    }

    private void Y() {
        this.y.d(this.x);
        if (this.y.a) {
            this.r.a(this.y);
            this.y = new e(this.x);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0079, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Z(long r9, long r11) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.W.Z(long, long):void");
    }

    private void Z0(boolean z) throws ExoPlaybackException {
        this.J = z;
        if (!this.s.H(this.x.a, z)) {
            D0(true);
        }
        I(false);
    }

    private void a0() {
        C2024d0 c2024d0O;
        this.s.y(this.C0);
        if (this.s.D() && (c2024d0O = this.s.o(this.C0, this.x)) != null) {
            C2022c0 c2022c0G = this.s.g(this.c, this.d, this.f.e(), this.t, c2024d0O, this.e);
            c2022c0G.a.m(this, c2024d0O.b);
            if (this.s.p() == c2022c0G) {
                u0(c2024d0O.b);
            }
            I(false);
        }
        if (!this.G) {
            X();
        } else {
            this.G = R();
            m1();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b0() {
        /*
            r14 = this;
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r14.d1()
            if (r2 == 0) goto L61
            if (r1 == 0) goto Ld
            r14.Y()
        Ld:
            com.google.android.exoplayer2.f0 r1 = r14.s
            com.google.android.exoplayer2.c0 r1 = r1.b()
            java.lang.Object r1 = ir.nasim.AbstractC20011rK.e(r1)
            com.google.android.exoplayer2.c0 r1 = (com.google.android.exoplayer2.C2022c0) r1
            com.google.android.exoplayer2.x0 r2 = r14.x
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.b
            java.lang.Object r2 = r2.a
            com.google.android.exoplayer2.d0 r3 = r1.f
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r3.a
            java.lang.Object r3 = r3.a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L45
            com.google.android.exoplayer2.x0 r2 = r14.x
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.b
            int r4 = r2.b
            r5 = -1
            if (r4 != r5) goto L45
            com.google.android.exoplayer2.d0 r4 = r1.f
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r4.a
            int r6 = r4.b
            if (r6 != r5) goto L45
            int r2 = r2.e
            int r4 = r4.e
            if (r2 == r4) goto L45
            r2 = r3
            goto L46
        L45:
            r2 = r0
        L46:
            com.google.android.exoplayer2.d0 r1 = r1.f
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r1.a
            long r10 = r1.b
            long r8 = r1.c
            r12 = r2 ^ 1
            r13 = 0
            r4 = r14
            r6 = r10
            com.google.android.exoplayer2.x0 r1 = r4.N(r5, r6, r8, r10, r12, r13)
            r14.x = r1
            r14.t0()
            r14.p1()
            r1 = r3
            goto L2
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.W.b0():void");
    }

    private void b1(ShuffleOrder shuffleOrder) throws Throwable {
        this.y.b(1);
        J(this.t.C(shuffleOrder), false);
    }

    private void c0() {
        C2022c0 c2022c0Q = this.s.q();
        if (c2022c0Q == null) {
            return;
        }
        int i = 0;
        if (c2022c0Q.j() != null && !this.B) {
            if (P()) {
                if (c2022c0Q.j().d || this.C0 >= c2022c0Q.j().m()) {
                    C7452Rt7 c7452Rt7O = c2022c0Q.o();
                    C2022c0 c2022c0C = this.s.c();
                    C7452Rt7 c7452Rt7O2 = c2022c0C.o();
                    J0 j0 = this.x.a;
                    q1(j0, c2022c0C.f.a, j0, c2022c0Q.f.a, -9223372036854775807L);
                    if (c2022c0C.d && c2022c0C.a.l() != -9223372036854775807L) {
                        K0(c2022c0C.m());
                        return;
                    }
                    for (int i2 = 0; i2 < this.a.length; i2++) {
                        boolean zC = c7452Rt7O.c(i2);
                        boolean zC2 = c7452Rt7O2.c(i2);
                        if (zC && !this.a[i2].s()) {
                            boolean z = this.c[i2].g() == -2;
                            AO5 ao5 = c7452Rt7O.b[i2];
                            AO5 ao52 = c7452Rt7O2.b[i2];
                            if (!zC2 || !ao52.equals(ao5) || z) {
                                L0(this.a[i2], c2022c0C.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!c2022c0Q.f.i && !this.B) {
            return;
        }
        while (true) {
            D0[] d0Arr = this.a;
            if (i >= d0Arr.length) {
                return;
            }
            D0 d0 = d0Arr[i];
            SampleStream sampleStream = c2022c0Q.c[i];
            if (sampleStream != null && d0.i() == sampleStream && d0.j()) {
                long j = c2022c0Q.f.e;
                L0(d0, (j == -9223372036854775807L || j == Long.MIN_VALUE) ? -9223372036854775807L : c2022c0Q.l() + c2022c0Q.f.e);
            }
            i++;
        }
    }

    private void c1(int i) {
        x0 x0Var = this.x;
        if (x0Var.e != i) {
            if (i != 2) {
                this.H0 = -9223372036854775807L;
            }
            this.x = x0Var.g(i);
        }
    }

    private void d0() throws ExoPlaybackException {
        C2022c0 c2022c0Q = this.s.q();
        if (c2022c0Q == null || this.s.p() == c2022c0Q || c2022c0Q.g || !q0()) {
            return;
        }
        s();
    }

    private boolean d1() {
        C2022c0 c2022c0P;
        C2022c0 c2022c0J;
        return f1() && !this.B && (c2022c0P = this.s.p()) != null && (c2022c0J = c2022c0P.j()) != null && this.C0 >= c2022c0J.m() && c2022c0J.g;
    }

    private void e0() throws Throwable {
        J(this.t.i(), true);
    }

    private boolean e1() {
        if (!R()) {
            return false;
        }
        C2022c0 c2022c0J = this.s.j();
        long jF = F(c2022c0J.k());
        long jY = c2022c0J == this.s.p() ? c2022c0J.y(this.C0) : c2022c0J.y(this.C0) - c2022c0J.f.b;
        boolean zI = this.f.i(jY, jF, this.o.c().a);
        if (zI || jF >= 500000) {
            return zI;
        }
        if (this.m <= 0 && !this.n) {
            return zI;
        }
        this.s.p().a.u(this.x.r, false);
        return this.f.i(jY, jF, this.o.c().a);
    }

    private void f0(c cVar) {
        this.y.b(1);
        throw null;
    }

    private boolean f1() {
        x0 x0Var = this.x;
        return x0Var.l && x0Var.m == 0;
    }

    private void g0() {
        for (C2022c0 c2022c0P = this.s.p(); c2022c0P != null; c2022c0P = c2022c0P.j()) {
            for (InterfaceC13679ge2 interfaceC13679ge2 : c2022c0P.o().c) {
                if (interfaceC13679ge2 != null) {
                    interfaceC13679ge2.j();
                }
            }
        }
    }

    private boolean g1(boolean z) {
        if (this.A0 == 0) {
            return T();
        }
        if (!z) {
            return false;
        }
        x0 x0Var = this.x;
        if (!x0Var.g) {
            return true;
        }
        long jC = h1(x0Var.a, this.s.p().f.a) ? this.u.c() : -9223372036854775807L;
        C2022c0 c2022c0J = this.s.j();
        return (c2022c0J.q() && c2022c0J.f.i) || (c2022c0J.f.a.c() && !c2022c0J.d) || this.f.d(E(), this.o.c().a, this.D, jC);
    }

    private void h0(boolean z) {
        for (C2022c0 c2022c0P = this.s.p(); c2022c0P != null; c2022c0P = c2022c0P.j()) {
            for (InterfaceC13679ge2 interfaceC13679ge2 : c2022c0P.o().c) {
                if (interfaceC13679ge2 != null) {
                    interfaceC13679ge2.m(z);
                }
            }
        }
    }

    private boolean h1(J0 j0, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.c() || j0.v()) {
            return false;
        }
        j0.s(j0.m(mediaPeriodId.a, this.l).c, this.k);
        if (!this.k.i()) {
            return false;
        }
        J0.d dVar = this.k;
        return dVar.i && dVar.f != -9223372036854775807L;
    }

    private void i0() {
        for (C2022c0 c2022c0P = this.s.p(); c2022c0P != null; c2022c0P = c2022c0P.j()) {
            for (InterfaceC13679ge2 interfaceC13679ge2 : c2022c0P.o().c) {
                if (interfaceC13679ge2 != null) {
                    interfaceC13679ge2.t();
                }
            }
        }
    }

    private void i1() {
        this.D = false;
        this.o.g();
        for (D0 d0 : this.a) {
            if (S(d0)) {
                d0.start();
            }
        }
    }

    private void k1(boolean z, boolean z2) {
        s0(z || !this.Y, false, true, false);
        this.y.b(z2 ? 1 : 0);
        this.f.f();
        c1(1);
    }

    private void l(b bVar, int i) throws Throwable {
        this.y.b(1);
        u0 u0Var = this.t;
        if (i == -1) {
            i = u0Var.q();
        }
        J(u0Var.f(i, bVar.a, bVar.b), false);
    }

    private void l0() {
        this.y.b(1);
        s0(false, false, false, true);
        this.f.b();
        c1(this.x.a.v() ? 4 : 2);
        this.t.v(this.g.d());
        this.h.i(2);
    }

    private void l1() {
        this.o.h();
        for (D0 d0 : this.a) {
            if (S(d0)) {
                u(d0);
            }
        }
    }

    private void m1() {
        C2022c0 c2022c0J = this.s.j();
        boolean z = this.G || (c2022c0J != null && c2022c0J.a.c());
        x0 x0Var = this.x;
        if (z != x0Var.g) {
            this.x = x0Var.a(z);
        }
    }

    private void n() throws ExoPlaybackException {
        D0(true);
    }

    private void n0() {
        s0(true, false, true, false);
        this.f.h();
        c1(1);
        HandlerThread handlerThread = this.i;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        synchronized (this) {
            this.z = true;
            notifyAll();
        }
    }

    private void n1(TrackGroupArray trackGroupArray, C7452Rt7 c7452Rt7) {
        this.f.g(this.a, trackGroupArray, c7452Rt7.c);
    }

    private void o(A0 a0) {
        if (a0.j()) {
            return;
        }
        try {
            a0.g().q(a0.i(), a0.e());
        } finally {
            a0.k(true);
        }
    }

    private void o0(int i, int i2, ShuffleOrder shuffleOrder) throws Throwable {
        this.y.b(1);
        J(this.t.z(i, i2, shuffleOrder), false);
    }

    private void o1() throws ExoPlaybackException {
        if (this.x.a.v() || !this.t.s()) {
            return;
        }
        a0();
        c0();
        d0();
        b0();
    }

    private void p(D0 d0) {
        if (S(d0)) {
            this.o.a(d0);
            u(d0);
            d0.f();
            this.A0--;
        }
    }

    private void p1() {
        C2022c0 c2022c0P = this.s.p();
        if (c2022c0P == null) {
            return;
        }
        long jL = c2022c0P.d ? c2022c0P.a.l() : -9223372036854775807L;
        if (jL != -9223372036854775807L) {
            u0(jL);
            if (jL != this.x.r) {
                x0 x0Var = this.x;
                this.x = N(x0Var.b, jL, x0Var.c, jL, true, 5);
            }
        } else {
            long jI = this.o.i(c2022c0P != this.s.q());
            this.C0 = jI;
            long jY = c2022c0P.y(jI);
            Z(this.x.r, jY);
            this.x.r = jY;
        }
        this.x.p = this.s.j().i();
        this.x.q = E();
        x0 x0Var2 = this.x;
        if (x0Var2.l && x0Var2.e == 3 && h1(x0Var2.a, x0Var2.b) && this.x.n.a == 1.0f) {
            float fB = this.u.b(x(), E());
            if (this.o.c().a != fB) {
                this.o.e(this.x.n.e(fB));
                L(this.x.n, this.o.c().a, false, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q() throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.W.q():void");
    }

    private boolean q0() {
        C2022c0 c2022c0Q = this.s.q();
        C7452Rt7 c7452Rt7O = c2022c0Q.o();
        int i = 0;
        boolean z = false;
        while (true) {
            D0[] d0Arr = this.a;
            if (i >= d0Arr.length) {
                return !z;
            }
            D0 d0 = d0Arr[i];
            if (S(d0)) {
                boolean z2 = d0.i() != c2022c0Q.c[i];
                if (!c7452Rt7O.c(i) || z2) {
                    if (!d0.s()) {
                        d0.t(y(c7452Rt7O.c[i]), c2022c0Q.c[i], c2022c0Q.m(), c2022c0Q.l());
                    } else if (d0.d()) {
                        p(d0);
                    } else {
                        z = true;
                    }
                }
            }
            i++;
        }
    }

    private void q1(J0 j0, MediaSource.MediaPeriodId mediaPeriodId, J0 j02, MediaSource.MediaPeriodId mediaPeriodId2, long j) {
        if (!h1(j0, mediaPeriodId)) {
            y0 y0Var = mediaPeriodId.c() ? y0.d : this.x.n;
            if (this.o.c().equals(y0Var)) {
                return;
            }
            this.o.e(y0Var);
            return;
        }
        j0.s(j0.m(mediaPeriodId.a, this.l).c, this.k);
        this.u.a((C2018a0.g) AbstractC9683aN7.j(this.k.k));
        if (j != -9223372036854775807L) {
            this.u.e(z(j0, mediaPeriodId.a, j));
            return;
        }
        if (AbstractC9683aN7.c(!j02.v() ? j02.s(j02.m(mediaPeriodId2.a, this.l).c, this.k).a : null, this.k.a)) {
            return;
        }
        this.u.e(-9223372036854775807L);
    }

    private void r(int i, boolean z) throws ExoPlaybackException {
        D0 d0 = this.a[i];
        if (S(d0)) {
            return;
        }
        C2022c0 c2022c0Q = this.s.q();
        boolean z2 = c2022c0Q == this.s.p();
        C7452Rt7 c7452Rt7O = c2022c0Q.o();
        AO5 ao5 = c7452Rt7O.b[i];
        X[] xArrY = y(c7452Rt7O.c[i]);
        boolean z3 = f1() && this.x.e == 3;
        boolean z4 = !z && z3;
        this.A0++;
        this.b.add(d0);
        d0.m(ao5, xArrY, c2022c0Q.c[i], this.C0, z4, z2, c2022c0Q.m(), c2022c0Q.l());
        d0.q(11, new a());
        this.o.b(d0);
        if (z3) {
            d0.start();
        }
    }

    private void r0() throws ExoPlaybackException {
        float f2 = this.o.c().a;
        C2022c0 c2022c0Q = this.s.q();
        boolean z = true;
        for (C2022c0 c2022c0P = this.s.p(); c2022c0P != null && c2022c0P.d; c2022c0P = c2022c0P.j()) {
            C7452Rt7 c7452Rt7V = c2022c0P.v(f2, this.x.a);
            if (!c7452Rt7V.a(c2022c0P.o())) {
                if (z) {
                    C2022c0 c2022c0P2 = this.s.p();
                    boolean z2 = this.s.z(c2022c0P2);
                    boolean[] zArr = new boolean[this.a.length];
                    long jB = c2022c0P2.b(c7452Rt7V, this.x.r, z2, zArr);
                    x0 x0Var = this.x;
                    boolean z3 = (x0Var.e == 4 || jB == x0Var.r) ? false : true;
                    x0 x0Var2 = this.x;
                    this.x = N(x0Var2.b, jB, x0Var2.c, x0Var2.d, z3, 5);
                    if (z3) {
                        u0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.a.length];
                    int i = 0;
                    while (true) {
                        D0[] d0Arr = this.a;
                        if (i >= d0Arr.length) {
                            break;
                        }
                        D0 d0 = d0Arr[i];
                        boolean zS = S(d0);
                        zArr2[i] = zS;
                        SampleStream sampleStream = c2022c0P2.c[i];
                        if (zS) {
                            if (sampleStream != d0.i()) {
                                p(d0);
                            } else if (zArr[i]) {
                                d0.D(this.C0);
                            }
                        }
                        i++;
                    }
                    t(zArr2);
                } else {
                    this.s.z(c2022c0P);
                    if (c2022c0P.d) {
                        c2022c0P.a(c7452Rt7V, Math.max(c2022c0P.f.b, c2022c0P.y(this.C0)), false);
                    }
                }
                I(true);
                if (this.x.e != 4) {
                    X();
                    p1();
                    this.h.i(2);
                    return;
                }
                return;
            }
            if (c2022c0P == c2022c0Q) {
                z = false;
            }
        }
    }

    private void r1(float f2) {
        for (C2022c0 c2022c0P = this.s.p(); c2022c0P != null; c2022c0P = c2022c0P.j()) {
            for (InterfaceC13679ge2 interfaceC13679ge2 : c2022c0P.o().c) {
                if (interfaceC13679ge2 != null) {
                    interfaceC13679ge2.h(f2);
                }
            }
        }
    }

    private void s() throws ExoPlaybackException {
        t(new boolean[this.a.length]);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6 A[PHI: r4 r5 r7
      0x00a6: PHI (r4v3 com.google.android.exoplayer2.source.MediaSource$MediaPeriodId) = 
      (r4v2 com.google.android.exoplayer2.source.MediaSource$MediaPeriodId)
      (r4v9 com.google.android.exoplayer2.source.MediaSource$MediaPeriodId)
     binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r5v2 long) = (r5v1 long), (r5v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:30:0x0079, B:32:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void s0(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.W.s0(boolean, boolean, boolean, boolean):void");
    }

    private synchronized void s1(Q17 q17, long j) {
        long jElapsedRealtime = this.q.elapsedRealtime() + j;
        boolean z = false;
        while (!((Boolean) q17.get()).booleanValue() && j > 0) {
            try {
                this.q.b();
                wait(j);
            } catch (InterruptedException unused) {
                z = true;
            }
            j = jElapsedRealtime - this.q.elapsedRealtime();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void t(boolean[] zArr) throws ExoPlaybackException {
        C2022c0 c2022c0Q = this.s.q();
        C7452Rt7 c7452Rt7O = c2022c0Q.o();
        for (int i = 0; i < this.a.length; i++) {
            if (!c7452Rt7O.c(i) && this.b.remove(this.a[i])) {
                this.a[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (c7452Rt7O.c(i2)) {
                r(i2, zArr[i2]);
            }
        }
        c2022c0Q.g = true;
    }

    private void t0() {
        C2022c0 c2022c0P = this.s.p();
        this.B = c2022c0P != null && c2022c0P.f.h && this.A;
    }

    private void u(D0 d0) {
        if (d0.getState() == 2) {
            d0.stop();
        }
    }

    private void u0(long j) {
        C2022c0 c2022c0P = this.s.p();
        long jZ = c2022c0P == null ? j + 1000000000000L : c2022c0P.z(j);
        this.C0 = jZ;
        this.o.d(jZ);
        for (D0 d0 : this.a) {
            if (S(d0)) {
                d0.D(this.C0);
            }
        }
        g0();
    }

    private static void v0(J0 j0, d dVar, J0.d dVar2, J0.b bVar) {
        int i = j0.s(j0.m(dVar.d, bVar).c, dVar2).p;
        Object obj = j0.l(i, bVar, true).b;
        long j = bVar.d;
        dVar.h(i, j != -9223372036854775807L ? j - 1 : Long.MAX_VALUE, obj);
    }

    private AbstractC12710f43 w(InterfaceC13679ge2[] interfaceC13679ge2Arr) {
        AbstractC12710f43.a aVar = new AbstractC12710f43.a();
        boolean z = false;
        for (InterfaceC13679ge2 interfaceC13679ge2 : interfaceC13679ge2Arr) {
            if (interfaceC13679ge2 != null) {
                Metadata metadata = interfaceC13679ge2.e(0).j;
                if (metadata == null) {
                    aVar.a(new Metadata(new Metadata.Entry[0]));
                } else {
                    aVar.a(metadata);
                    z = true;
                }
            }
        }
        return z ? aVar.h() : AbstractC12710f43.V();
    }

    private static boolean w0(d dVar, J0 j0, J0 j02, int i, boolean z, J0.d dVar2, J0.b bVar) {
        Object obj = dVar.d;
        if (obj == null) {
            Pair pairZ0 = z0(j0, new h(dVar.a.h(), dVar.a.d(), dVar.a.f() == Long.MIN_VALUE ? -9223372036854775807L : AbstractC9683aN7.B0(dVar.a.f())), false, i, z, dVar2, bVar);
            if (pairZ0 == null) {
                return false;
            }
            dVar.h(j0.g(pairZ0.first), ((Long) pairZ0.second).longValue(), pairZ0.first);
            if (dVar.a.f() == Long.MIN_VALUE) {
                v0(j0, dVar, dVar2, bVar);
            }
            return true;
        }
        int iG = j0.g(obj);
        if (iG == -1) {
            return false;
        }
        if (dVar.a.f() == Long.MIN_VALUE) {
            v0(j0, dVar, dVar2, bVar);
            return true;
        }
        dVar.b = iG;
        j02.m(dVar.d, bVar);
        if (bVar.f && j02.s(bVar.c, dVar2).o == j02.g(dVar.d)) {
            Pair pairO = j0.o(dVar2, bVar, j0.m(dVar.d, bVar).c, dVar.c + bVar.r());
            dVar.h(j0.g(pairO.first), ((Long) pairO.second).longValue(), pairO.first);
        }
        return true;
    }

    private long x() {
        x0 x0Var = this.x;
        return z(x0Var.a, x0Var.b.a, x0Var.r);
    }

    private void x0(J0 j0, J0 j02) {
        if (j0.v() && j02.v()) {
            return;
        }
        for (int size = this.p.size() - 1; size >= 0; size--) {
            if (!w0((d) this.p.get(size), j0, j02, this.H, this.J, this.k, this.l)) {
                ((d) this.p.get(size)).a.k(false);
                this.p.remove(size);
            }
        }
        Collections.sort(this.p);
    }

    private static X[] y(InterfaceC13679ge2 interfaceC13679ge2) {
        int length = interfaceC13679ge2 != null ? interfaceC13679ge2.length() : 0;
        X[] xArr = new X[length];
        for (int i = 0; i < length; i++) {
            xArr[i] = interfaceC13679ge2.e(i);
        }
        return xArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.W.g y0(com.google.android.exoplayer2.J0 r30, com.google.android.exoplayer2.x0 r31, com.google.android.exoplayer2.W.h r32, com.google.android.exoplayer2.C2028f0 r33, int r34, boolean r35, com.google.android.exoplayer2.J0.d r36, com.google.android.exoplayer2.J0.b r37) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.W.y0(com.google.android.exoplayer2.J0, com.google.android.exoplayer2.x0, com.google.android.exoplayer2.W$h, com.google.android.exoplayer2.f0, int, boolean, com.google.android.exoplayer2.J0$d, com.google.android.exoplayer2.J0$b):com.google.android.exoplayer2.W$g");
    }

    private long z(J0 j0, Object obj, long j) {
        j0.s(j0.m(obj, this.l).c, this.k);
        J0.d dVar = this.k;
        if (dVar.f != -9223372036854775807L && dVar.i()) {
            J0.d dVar2 = this.k;
            if (dVar2.i) {
                return AbstractC9683aN7.B0(dVar2.d() - this.k.f) - (j + this.l.r());
            }
        }
        return -9223372036854775807L;
    }

    private static Pair z0(J0 j0, h hVar, boolean z, int i, boolean z2, J0.d dVar, J0.b bVar) {
        Pair pairO;
        Object objA0;
        J0 j02 = hVar.a;
        if (j0.v()) {
            return null;
        }
        J0 j03 = j02.v() ? j0 : j02;
        try {
            pairO = j03.o(dVar, bVar, hVar.b, hVar.c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (j0.equals(j03)) {
            return pairO;
        }
        if (j0.g(pairO.first) != -1) {
            return (j03.m(pairO.first, bVar).f && j03.s(bVar.c, dVar).o == j03.g(pairO.first)) ? j0.o(dVar, bVar, j0.m(pairO.first, bVar).c, hVar.c) : pairO;
        }
        if (z && (objA0 = A0(dVar, bVar, i, z2, pairO.first, j03, j0)) != null) {
            return j0.o(dVar, bVar, j0.m(objA0, bVar).c, -9223372036854775807L);
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.C2033i.a
    public void B(y0 y0Var) {
        this.h.e(16, y0Var).a();
    }

    public void C0(J0 j0, int i, long j) {
        this.h.e(3, new h(j0, i, j)).a();
    }

    public Looper D() {
        return this.j;
    }

    public void O0(List list, int i, long j, ShuffleOrder shuffleOrder) {
        this.h.e(17, new b(list, shuffleOrder, i, j, null)).a();
    }

    public void R0(boolean z, int i) {
        this.h.g(1, z ? 1 : 0, i).a();
    }

    public void T0(y0 y0Var) {
        this.h.e(4, y0Var).a();
    }

    public void V0(int i) {
        this.h.g(11, i, 0).a();
    }

    public void Y0(boolean z) {
        this.h.g(12, z ? 1 : 0, 0).a();
    }

    @Override // ir.nasim.AbstractC7218Qt7.a
    public void a() {
        this.h.i(10);
    }

    public void a1(ShuffleOrder shuffleOrder) {
        this.h.e(21, shuffleOrder).a();
    }

    @Override // com.google.android.exoplayer2.u0.d
    public void c() {
        this.h.i(22);
    }

    @Override // com.google.android.exoplayer2.A0.a
    public synchronized void d(A0 a0) {
        if (!this.z && this.j.getThread().isAlive()) {
            this.h.e(14, a0).a();
            return;
        }
        AbstractC18815pI3.k("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        a0.k(false);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        int i;
        C2022c0 c2022c0Q;
        int i2 = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        try {
            switch (message.what) {
                case 0:
                    l0();
                    break;
                case 1:
                    S0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    q();
                    break;
                case 3:
                    E0((h) message.obj);
                    break;
                case 4:
                    U0((y0) message.obj);
                    break;
                case 5:
                    X0((C22738vk6) message.obj);
                    break;
                case 6:
                    k1(false, true);
                    break;
                case 7:
                    n0();
                    return true;
                case 8:
                    K((MediaPeriod) message.obj);
                    break;
                case 9:
                    G((MediaPeriod) message.obj);
                    break;
                case 10:
                    r0();
                    break;
                case 11:
                    W0(message.arg1);
                    break;
                case 12:
                    Z0(message.arg1 != 0);
                    break;
                case 13:
                    M0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    H0((A0) message.obj);
                    break;
                case 15:
                    J0((A0) message.obj);
                    break;
                case 16:
                    M((y0) message.obj, false);
                    break;
                case 17:
                    N0((b) message.obj);
                    break;
                case 18:
                    l((b) message.obj, message.arg1);
                    break;
                case 19:
                    AbstractC18350oW3.a(message.obj);
                    f0(null);
                    break;
                case 20:
                    o0(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    b1((ShuffleOrder) message.obj);
                    break;
                case 22:
                    e0();
                    break;
                case 23:
                    Q0(message.arg1 != 0);
                    break;
                case 24:
                    P0(message.arg1 == 1);
                    break;
                case 25:
                    n();
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.i == 1 && (c2022c0Q = this.s.q()) != null) {
                e = e.j(c2022c0Q.f.a);
            }
            if (e.o && this.F0 == null) {
                AbstractC18815pI3.l("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.F0 = e;
                InterfaceC23757xT2 interfaceC23757xT2 = this.h;
                interfaceC23757xT2.b(interfaceC23757xT2.e(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.F0;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.F0;
                }
                AbstractC18815pI3.d("ExoPlayerImplInternal", "Playback error", e);
                k1(true, false);
                this.x = this.x.e(e);
            }
        } catch (ParserException e3) {
            int i3 = e3.b;
            if (i3 == 1) {
                i = e3.a ? 3001 : 3003;
            } else {
                if (i3 == 4) {
                    i = e3.a ? 3002 : 3004;
                }
                H(e3, i2);
            }
            i2 = i;
            H(e3, i2);
        } catch (DrmSession.DrmSessionException e4) {
            H(e4, e4.a);
        } catch (BehindLiveWindowException e5) {
            H(e5, 1002);
        } catch (DataSourceException e6) {
            H(e6, e6.a);
        } catch (IOException e7) {
            H(e7, 2000);
        } catch (RuntimeException e8) {
            if ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) {
                i2 = 1004;
            }
            ExoPlaybackException exoPlaybackExceptionN = ExoPlaybackException.n(e8, i2);
            AbstractC18815pI3.d("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionN);
            k1(true, false);
            this.x = this.x.e(exoPlaybackExceptionN);
        }
        Y();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void j(MediaPeriod mediaPeriod) {
        this.h.e(8, mediaPeriod).a();
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void g(MediaPeriod mediaPeriod) {
        this.h.e(9, mediaPeriod).a();
    }

    public void j1() {
        this.h.a(6).a();
    }

    public void k0() {
        this.h.a(0).a();
    }

    public void m(int i, List list, ShuffleOrder shuffleOrder) {
        this.h.d(18, i, 0, new b(list, shuffleOrder, -1, -9223372036854775807L, null)).a();
    }

    public synchronized boolean m0() {
        if (!this.z && this.j.getThread().isAlive()) {
            this.h.i(7);
            s1(new Q17() { // from class: com.google.android.exoplayer2.U
                @Override // ir.nasim.Q17
                public final Object get() {
                    return this.a.V();
                }
            }, this.v);
            return this.z;
        }
        return true;
    }

    public void p0(int i, int i2, ShuffleOrder shuffleOrder) {
        this.h.d(20, i, i2, shuffleOrder).a();
    }

    public void v(long j) {
        this.G0 = j;
    }
}
