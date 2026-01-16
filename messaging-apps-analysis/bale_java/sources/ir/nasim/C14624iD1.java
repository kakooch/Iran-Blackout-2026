package ir.nasim;

import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.C2035j;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.z0;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC13937h43;
import ir.nasim.C16988mC3;
import ir.nasim.InterfaceC6170Mm;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* renamed from: ir.nasim.iD1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C14624iD1 implements InterfaceC3582Bm {
    private final NV0 a;
    private final J0.b b;
    private final J0.d c;
    private final a d;
    private final SparseArray e;
    private C16988mC3 f;
    private com.google.android.exoplayer2.z0 g;
    private InterfaceC23757xT2 h;
    private boolean i;

    /* renamed from: ir.nasim.iD1$a */
    private static final class a {
        private final J0.b a;
        private AbstractC12710f43 b = AbstractC12710f43.V();
        private AbstractC13937h43 c = AbstractC13937h43.p();
        private MediaSource.MediaPeriodId d;
        private MediaSource.MediaPeriodId e;
        private MediaSource.MediaPeriodId f;

        public a(J0.b bVar) {
            this.a = bVar;
        }

        private void b(AbstractC13937h43.a aVar, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.J0 j0) {
            if (mediaPeriodId == null) {
                return;
            }
            if (j0.g(mediaPeriodId.a) != -1) {
                aVar.d(mediaPeriodId, j0);
                return;
            }
            com.google.android.exoplayer2.J0 j02 = (com.google.android.exoplayer2.J0) this.c.get(mediaPeriodId);
            if (j02 != null) {
                aVar.d(mediaPeriodId, j02);
            }
        }

        private static MediaSource.MediaPeriodId c(com.google.android.exoplayer2.z0 z0Var, AbstractC12710f43 abstractC12710f43, MediaSource.MediaPeriodId mediaPeriodId, J0.b bVar) {
            com.google.android.exoplayer2.J0 j0N = z0Var.N();
            int iB0 = z0Var.b0();
            Object objR = j0N.v() ? null : j0N.r(iB0);
            int iH = (z0Var.k() || j0N.v()) ? -1 : j0N.k(iB0, bVar).h(AbstractC9683aN7.B0(z0Var.D0()) - bVar.r());
            for (int i = 0; i < abstractC12710f43.size(); i++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) abstractC12710f43.get(i);
                if (i(mediaPeriodId2, objR, z0Var.k(), z0Var.I(), z0Var.h0(), iH)) {
                    return mediaPeriodId2;
                }
            }
            if (abstractC12710f43.isEmpty() && mediaPeriodId != null) {
                if (i(mediaPeriodId, objR, z0Var.k(), z0Var.I(), z0Var.h0(), iH)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean i(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z, int i, int i2, int i3) {
            if (mediaPeriodId.a.equals(obj)) {
                return (z && mediaPeriodId.b == i && mediaPeriodId.c == i2) || (!z && mediaPeriodId.b == -1 && mediaPeriodId.e == i3);
            }
            return false;
        }

        private void m(com.google.android.exoplayer2.J0 j0) {
            AbstractC13937h43.a aVarB = AbstractC13937h43.b();
            if (this.b.isEmpty()) {
                b(aVarB, this.e, j0);
                if (!EG4.a(this.f, this.e)) {
                    b(aVarB, this.f, j0);
                }
                if (!EG4.a(this.d, this.e) && !EG4.a(this.d, this.f)) {
                    b(aVarB, this.d, j0);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    b(aVarB, (MediaSource.MediaPeriodId) this.b.get(i), j0);
                }
                if (!this.b.contains(this.d)) {
                    b(aVarB, this.d, j0);
                }
            }
            this.c = aVarB.b();
        }

        public MediaSource.MediaPeriodId d() {
            return this.d;
        }

        public MediaSource.MediaPeriodId e() {
            if (this.b.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) AbstractC17264mg3.c(this.b);
        }

        public com.google.android.exoplayer2.J0 f(MediaSource.MediaPeriodId mediaPeriodId) {
            return (com.google.android.exoplayer2.J0) this.c.get(mediaPeriodId);
        }

        public MediaSource.MediaPeriodId g() {
            return this.e;
        }

        public MediaSource.MediaPeriodId h() {
            return this.f;
        }

        public void j(com.google.android.exoplayer2.z0 z0Var) {
            this.d = c(z0Var, this.b, this.e, this.a);
        }

        public void k(List list, MediaSource.MediaPeriodId mediaPeriodId, com.google.android.exoplayer2.z0 z0Var) {
            this.b = AbstractC12710f43.O(list);
            if (!list.isEmpty()) {
                this.e = (MediaSource.MediaPeriodId) list.get(0);
                this.f = (MediaSource.MediaPeriodId) AbstractC20011rK.e(mediaPeriodId);
            }
            if (this.d == null) {
                this.d = c(z0Var, this.b, this.e, this.a);
            }
            m(z0Var.N());
        }

        public void l(com.google.android.exoplayer2.z0 z0Var) {
            this.d = c(z0Var, this.b, this.e, this.a);
            m(z0Var.N());
        }
    }

    public C14624iD1(NV0 nv0) {
        this.a = (NV0) AbstractC20011rK.e(nv0);
        this.f = new C16988mC3(AbstractC9683aN7.N(), nv0, new C16988mC3.b() { // from class: ir.nasim.tC1
            @Override // ir.nasim.C16988mC3.b
            public final void a(Object obj, C4797Gp2 c4797Gp2) {
                C14624iD1.v1((InterfaceC6170Mm) obj, c4797Gp2);
            }
        });
        J0.b bVar = new J0.b();
        this.b = bVar;
        this.c = new J0.d();
        this.d = new a(bVar);
        this.e = new SparseArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B1(InterfaceC6170Mm.a aVar, JB1 jb1, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.A0(aVar, jb1);
        interfaceC6170Mm.L0(aVar, 1, jb1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C1(InterfaceC6170Mm.a aVar, JB1 jb1, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.Y(aVar, jb1);
        interfaceC6170Mm.p(aVar, 1, jb1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C2(InterfaceC6170Mm.a aVar, JB1 jb1, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.j0(aVar, jb1);
        interfaceC6170Mm.L0(aVar, 2, jb1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D1(InterfaceC6170Mm.a aVar, com.google.android.exoplayer2.X x, MB1 mb1, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.X0(aVar, x);
        interfaceC6170Mm.m0(aVar, x, mb1);
        interfaceC6170Mm.V0(aVar, 1, x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D2(InterfaceC6170Mm.a aVar, JB1 jb1, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.h0(aVar, jb1);
        interfaceC6170Mm.p(aVar, 2, jb1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F2(InterfaceC6170Mm.a aVar, com.google.android.exoplayer2.X x, MB1 mb1, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.P(aVar, x);
        interfaceC6170Mm.U0(aVar, x, mb1);
        interfaceC6170Mm.V0(aVar, 2, x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G2(InterfaceC6170Mm.a aVar, C12372eV7 c12372eV7, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.C0(aVar, c12372eV7);
        interfaceC6170Mm.z(aVar, c12372eV7.a, c12372eV7.b, c12372eV7.c, c12372eV7.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(com.google.android.exoplayer2.z0 z0Var, InterfaceC6170Mm interfaceC6170Mm, C4797Gp2 c4797Gp2) {
        interfaceC6170Mm.H0(z0Var, new InterfaceC6170Mm.b(c4797Gp2, this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K2() {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 1028, new C16988mC3.a() { // from class: ir.nasim.XC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).b0(aVarL1);
            }
        });
        this.f.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R1(InterfaceC6170Mm.a aVar, int i, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.o0(aVar);
        interfaceC6170Mm.n0(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V1(InterfaceC6170Mm.a aVar, boolean z, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.p0(aVar, z);
        interfaceC6170Mm.v(aVar, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m2(InterfaceC6170Mm.a aVar, int i, z0.e eVar, z0.e eVar2, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.x(aVar, i);
        interfaceC6170Mm.F(aVar, eVar, eVar2, i);
    }

    private InterfaceC6170Mm.a o1(MediaSource.MediaPeriodId mediaPeriodId) {
        AbstractC20011rK.e(this.g);
        com.google.android.exoplayer2.J0 j0F = mediaPeriodId == null ? null : this.d.f(mediaPeriodId);
        if (mediaPeriodId != null && j0F != null) {
            return m1(j0F, j0F.m(mediaPeriodId.a, this.b).c, mediaPeriodId);
        }
        int iR0 = this.g.r0();
        com.google.android.exoplayer2.J0 j0N = this.g.N();
        if (iR0 >= j0N.u()) {
            j0N = com.google.android.exoplayer2.J0.a;
        }
        return m1(j0N, iR0, null);
    }

    private InterfaceC6170Mm.a p1() {
        return o1(this.d.e());
    }

    private InterfaceC6170Mm.a q1(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AbstractC20011rK.e(this.g);
        if (mediaPeriodId != null) {
            return this.d.f(mediaPeriodId) != null ? o1(mediaPeriodId) : m1(com.google.android.exoplayer2.J0.a, i, mediaPeriodId);
        }
        com.google.android.exoplayer2.J0 j0N = this.g.N();
        if (i >= j0N.u()) {
            j0N = com.google.android.exoplayer2.J0.a;
        }
        return m1(j0N, i, null);
    }

    private InterfaceC6170Mm.a s1() {
        return o1(this.d.g());
    }

    private InterfaceC6170Mm.a t1() {
        return o1(this.d.h());
    }

    private InterfaceC6170Mm.a u1(PlaybackException playbackException) {
        MediaPeriodId mediaPeriodId;
        return (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).n) == null) ? l1() : o1(new MediaSource.MediaPeriodId(mediaPeriodId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z1(InterfaceC6170Mm.a aVar, String str, long j, long j2, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.f1(aVar, str, j);
        interfaceC6170Mm.r0(aVar, str, j2, j);
        interfaceC6170Mm.i0(aVar, 1, str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z2(InterfaceC6170Mm.a aVar, String str, long j, long j2, InterfaceC6170Mm interfaceC6170Mm) {
        interfaceC6170Mm.T(aVar, str, j);
        interfaceC6170Mm.G0(aVar, str, j2, j);
        interfaceC6170Mm.i0(aVar, 2, str, j);
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void A(final JB1 jb1) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1015, new C16988mC3.a() { // from class: ir.nasim.pC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.D2(aVarT1, jb1, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void B(final com.google.android.exoplayer2.y0 y0Var) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 12, new C16988mC3.a() { // from class: ir.nasim.aC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).e(aVarL1, y0Var);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void D(final JB1 jb1) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1007, new C16988mC3.a() { // from class: ir.nasim.KC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.C1(aVarT1, jb1, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void D4(final C2018a0 c2018a0, final int i) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 1, new C16988mC3.a() { // from class: ir.nasim.lC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).R0(aVarL1, c2018a0, i);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void E(final com.google.android.exoplayer2.X x, final MB1 mb1) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1009, new C16988mC3.a() { // from class: ir.nasim.XB1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.D1(aVarT1, x, mb1, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void E0(final int i) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 4, new C16988mC3.a() { // from class: ir.nasim.qC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).H(aVarL1, i);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void G(final int i, final long j) {
        final InterfaceC6170Mm.a aVarS1 = s1();
        L2(aVarS1, 1018, new C16988mC3.a() { // from class: ir.nasim.BC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).c1(aVarS1, i, j);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void I(final Object obj, final long j) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 26, new C16988mC3.a() { // from class: ir.nasim.VC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj2) {
                ((InterfaceC6170Mm) obj2).C(aVarT1, obj, j);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void J(final int i) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 8, new C16988mC3.a() { // from class: ir.nasim.wC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).g1(aVarL1, i);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void L(final Exception exc) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1029, new C16988mC3.a() { // from class: ir.nasim.hD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).t0(aVarT1, exc);
            }
        });
    }

    protected final void L2(InterfaceC6170Mm.a aVar, int i, C16988mC3.a aVar2) {
        this.e.put(i, aVar);
        this.f.l(i, aVar2);
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void M(final com.google.android.exoplayer2.X x, final MB1 mb1) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1017, new C16988mC3.a() { // from class: ir.nasim.oC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.F2(aVarT1, x, mb1, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void M0(final C2035j c2035j) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 29, new C16988mC3.a() { // from class: ir.nasim.PC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).F0(aVarL1, c2035j);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void N(final int i, final long j, final long j2) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1011, new C16988mC3.a() { // from class: ir.nasim.WC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).a0(aVarT1, i, j, j2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void N0() {
        if (this.i) {
            return;
        }
        final InterfaceC6170Mm.a aVarL1 = l1();
        this.i = true;
        L2(aVarL1, -1, new C16988mC3.a() { // from class: ir.nasim.dC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).a(aVarL1);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void O(final long j, final int i) {
        final InterfaceC6170Mm.a aVarS1 = s1();
        L2(aVarS1, 1021, new C16988mC3.a() { // from class: ir.nasim.GC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).S0(aVarS1, j, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void O0(final C2020b0 c2020b0) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 14, new C16988mC3.a() { // from class: ir.nasim.YB1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).f0(aVarL1, c2020b0);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.h
    public final void Q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1023, new C16988mC3.a() { // from class: ir.nasim.ZC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).d1(aVarQ1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void Q0(final boolean z) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 9, new C16988mC3.a() { // from class: ir.nasim.WB1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).W(aVarL1, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void Q4(final C6740Ot7 c6740Ot7) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 19, new C16988mC3.a() { // from class: ir.nasim.aD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).h(aVarL1, c6740Ot7);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void R(final z0.e eVar, final z0.e eVar2, final int i) {
        if (i == 1) {
            this.i = false;
        }
        this.d.j((com.google.android.exoplayer2.z0) AbstractC20011rK.e(this.g));
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 11, new C16988mC3.a() { // from class: ir.nasim.JC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.m2(aVarL1, i, eVar, eVar2, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void S(final int i) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 6, new C16988mC3.a() { // from class: ir.nasim.EC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).w0(aVarL1, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void S4(final boolean z, final int i) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 5, new C16988mC3.a() { // from class: ir.nasim.gC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).a1(aVarL1, z, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void T(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, new C16988mC3.a() { // from class: ir.nasim.bC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).k0(aVarQ1, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void T2(final com.google.android.exoplayer2.K0 k0) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 2, new C16988mC3.a() { // from class: ir.nasim.AC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).K(aVarL1, k0);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.h
    public final void U(int i, MediaSource.MediaPeriodId mediaPeriodId, final int i2) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1022, new C16988mC3.a() { // from class: ir.nasim.MC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.R1(aVarQ1, i2, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.h
    public final void V(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1027, new C16988mC3.a() { // from class: ir.nasim.yC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).r(aVarQ1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void V2(final boolean z) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 3, new C16988mC3.a() { // from class: ir.nasim.NC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.V1(aVarL1, z, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void V3(List list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.d.k(list, mediaPeriodId, (com.google.android.exoplayer2.z0) AbstractC20011rK.e(this.g));
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void W(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1003, new C16988mC3.a() { // from class: ir.nasim.jC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).Y0(aVarQ1, loadEventInfo, mediaLoadData, iOException, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void X2() {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, -1, new C16988mC3.a() { // from class: ir.nasim.fC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).P0(aVarL1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.h
    public final void Y(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1025, new C16988mC3.a() { // from class: ir.nasim.bD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).K0(aVarQ1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void Z2(final PlaybackException playbackException) {
        final InterfaceC6170Mm.a aVarU1 = u1(playbackException);
        L2(aVarU1, 10, new C16988mC3.a() { // from class: ir.nasim.kC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).b1(aVarU1, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void a(int i, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1004, new C16988mC3.a() { // from class: ir.nasim.hC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).q(aVarQ1, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void b(final boolean z) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 23, new C16988mC3.a() { // from class: ir.nasim.dD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).y0(aVarT1, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void b2(final int i, final int i2) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 24, new C16988mC3.a() { // from class: ir.nasim.iC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).s0(aVarT1, i, i2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void c(final Exception exc) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1014, new C16988mC3.a() { // from class: ir.nasim.FC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).Z(aVarT1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void c4(final boolean z, final int i) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, -1, new C16988mC3.a() { // from class: ir.nasim.cC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).h1(aVarL1, z, i);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public void c5(InterfaceC6170Mm interfaceC6170Mm) {
        AbstractC20011rK.e(interfaceC6170Mm);
        this.f.c(interfaceC6170Mm);
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void d(final JB1 jb1) {
        final InterfaceC6170Mm.a aVarS1 = s1();
        L2(aVarS1, 1013, new C16988mC3.a() { // from class: ir.nasim.uC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.B1(aVarS1, jb1, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public void d5(InterfaceC6170Mm interfaceC6170Mm) {
        this.f.k(interfaceC6170Mm);
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void e(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1002, new C16988mC3.a() { // from class: ir.nasim.YC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).W0(aVarQ1, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void f(final String str) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1019, new C16988mC3.a() { // from class: ir.nasim.SC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).q0(aVarT1, str);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void f3(final float f) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 22, new C16988mC3.a() { // from class: ir.nasim.OC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).k(aVarT1, f);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void g(final String str, final long j, final long j2) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1016, new C16988mC3.a() { // from class: ir.nasim.sC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.z2(aVarT1, str, j2, j, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void h(int i, MediaSource.MediaPeriodId mediaPeriodId, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, new C16988mC3.a() { // from class: ir.nasim.CC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).J0(aVarQ1, loadEventInfo, mediaLoadData);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void i(final C16831lw1 c16831lw1) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 27, new C16988mC3.a() { // from class: ir.nasim.mC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).D0(aVarL1, c16831lw1);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void j(final JB1 jb1) {
        final InterfaceC6170Mm.a aVarS1 = s1();
        L2(aVarS1, 1020, new C16988mC3.a() { // from class: ir.nasim.rC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.C2(aVarS1, jb1, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC10699c30.a
    public final void k(final int i, final long j, final long j2) {
        final InterfaceC6170Mm.a aVarP1 = p1();
        L2(aVarP1, 1006, new C16988mC3.a() { // from class: ir.nasim.cD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).B0(aVarP1, i, j, j2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void k4(final com.google.android.exoplayer2.audio.a aVar) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 20, new C16988mC3.a() { // from class: ir.nasim.fD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).e1(aVarT1, aVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void l(final C12372eV7 c12372eV7) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 25, new C16988mC3.a() { // from class: ir.nasim.UC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.G2(aVarT1, c12372eV7, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void l0(final z0.b bVar) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 13, new C16988mC3.a() { // from class: ir.nasim.nC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).x0(aVarL1, bVar);
            }
        });
    }

    protected final InterfaceC6170Mm.a l1() {
        return o1(this.d.d());
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void m(final String str) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1012, new C16988mC3.a() { // from class: ir.nasim.vC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).Q(aVarT1, str);
            }
        });
    }

    protected final InterfaceC6170Mm.a m1(com.google.android.exoplayer2.J0 j0, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        MediaSource.MediaPeriodId mediaPeriodId2 = j0.v() ? null : mediaPeriodId;
        long jElapsedRealtime = this.a.elapsedRealtime();
        boolean z = j0.equals(this.g.N()) && i == this.g.r0();
        long jE = 0;
        if (mediaPeriodId2 == null || !mediaPeriodId2.c()) {
            if (z) {
                jE = this.g.l0();
            } else if (!j0.v()) {
                jE = j0.s(i, this.c).e();
            }
        } else if (z && this.g.I() == mediaPeriodId2.b && this.g.h0() == mediaPeriodId2.c) {
            jE = this.g.D0();
        }
        return new InterfaceC6170Mm.a(jElapsedRealtime, j0, i, mediaPeriodId2, jE, this.g.N(), this.g.r0(), this.d.d(), this.g.D0(), this.g.l());
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void n(final String str, final long j, final long j2) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1008, new C16988mC3.a() { // from class: ir.nasim.VB1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                C14624iD1.z1(aVarT1, str, j2, j, (InterfaceC6170Mm) obj);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public void n1(final com.google.android.exoplayer2.z0 z0Var, Looper looper) {
        AbstractC20011rK.g(this.g == null || this.d.b.isEmpty());
        this.g = (com.google.android.exoplayer2.z0) AbstractC20011rK.e(z0Var);
        this.h = this.a.a(looper, null);
        this.f = this.f.e(looper, new C16988mC3.b() { // from class: ir.nasim.eC1
            @Override // ir.nasim.C16988mC3.b
            public final void a(Object obj, C4797Gp2 c4797Gp2) {
                this.a.J2(z0Var, (InterfaceC6170Mm) obj, c4797Gp2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void o(final Metadata metadata) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 28, new C16988mC3.a() { // from class: ir.nasim.RC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).d0(aVarL1, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.h
    public final void q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1026, new C16988mC3.a() { // from class: ir.nasim.TC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).v0(aVarQ1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void q2(final PlaybackException playbackException) {
        final InterfaceC6170Mm.a aVarU1 = u1(playbackException);
        L2(aVarU1, 10, new C16988mC3.a() { // from class: ir.nasim.DC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).g0(aVarU1, playbackException);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void r1(final int i, final boolean z) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 30, new C16988mC3.a() { // from class: ir.nasim.QC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).I0(aVarL1, i, z);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void r5(final boolean z) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 7, new C16988mC3.a() { // from class: ir.nasim.eD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).Z0(aVarL1, z);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public void release() {
        ((InterfaceC23757xT2) AbstractC20011rK.i(this.h)).h(new Runnable() { // from class: ir.nasim.ZB1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.K2();
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void u(final List list) {
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 27, new C16988mC3.a() { // from class: ir.nasim.zC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).z0(aVarL1, list);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public final void u0(com.google.android.exoplayer2.J0 j0, final int i) {
        this.d.l((com.google.android.exoplayer2.z0) AbstractC20011rK.e(this.g));
        final InterfaceC6170Mm.a aVarL1 = l1();
        L2(aVarL1, 0, new C16988mC3.a() { // from class: ir.nasim.LC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).U(aVarL1, i);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void v(int i, MediaSource.MediaPeriodId mediaPeriodId, final MediaLoadData mediaLoadData) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, WebSocketProtocol.CLOSE_NO_STATUS_CODE, new C16988mC3.a() { // from class: ir.nasim.HC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).T0(aVarQ1, mediaLoadData);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void w(final long j) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1010, new C16988mC3.a() { // from class: ir.nasim.xC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).V(aVarT1, j);
            }
        });
    }

    @Override // ir.nasim.InterfaceC3582Bm
    public final void y(final Exception exc) {
        final InterfaceC6170Mm.a aVarT1 = t1();
        L2(aVarT1, 1030, new C16988mC3.a() { // from class: ir.nasim.gD1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).c0(aVarT1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.h
    public final void z(int i, MediaSource.MediaPeriodId mediaPeriodId, final Exception exc) {
        final InterfaceC6170Mm.a aVarQ1 = q1(i, mediaPeriodId);
        L2(aVarQ1, 1024, new C16988mC3.a() { // from class: ir.nasim.IC1
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((InterfaceC6170Mm) obj).e0(aVarQ1, exc);
            }
        });
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void s() {
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void B2(int i) {
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void X(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v1(InterfaceC6170Mm interfaceC6170Mm, C4797Gp2 c4797Gp2) {
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void M3(com.google.android.exoplayer2.z0 z0Var, z0.c cVar) {
    }
}
