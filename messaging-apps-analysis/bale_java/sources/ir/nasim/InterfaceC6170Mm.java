package ir.nasim;

import android.util.SparseArray;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.C2020b0;
import com.google.android.exoplayer2.C2035j;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.z0;
import java.io.IOException;
import java.util.List;

/* renamed from: ir.nasim.Mm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC6170Mm {

    /* renamed from: ir.nasim.Mm$a */
    public static final class a {
        public final long a;
        public final com.google.android.exoplayer2.J0 b;
        public final int c;
        public final MediaSource.MediaPeriodId d;
        public final long e;
        public final com.google.android.exoplayer2.J0 f;
        public final int g;
        public final MediaSource.MediaPeriodId h;
        public final long i;
        public final long j;

        public a(long j, com.google.android.exoplayer2.J0 j0, int i, MediaSource.MediaPeriodId mediaPeriodId, long j2, com.google.android.exoplayer2.J0 j02, int i2, MediaSource.MediaPeriodId mediaPeriodId2, long j3, long j4) {
            this.a = j;
            this.b = j0;
            this.c = i;
            this.d = mediaPeriodId;
            this.e = j2;
            this.f = j02;
            this.g = i2;
            this.h = mediaPeriodId2;
            this.i = j3;
            this.j = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.e == aVar.e && this.g == aVar.g && this.i == aVar.i && this.j == aVar.j && EG4.a(this.b, aVar.b) && EG4.a(this.d, aVar.d) && EG4.a(this.f, aVar.f) && EG4.a(this.h, aVar.h);
        }

        public int hashCode() {
            return EG4.b(Long.valueOf(this.a), this.b, Integer.valueOf(this.c), this.d, Long.valueOf(this.e), this.f, Integer.valueOf(this.g), this.h, Long.valueOf(this.i), Long.valueOf(this.j));
        }
    }

    /* renamed from: ir.nasim.Mm$b */
    public static final class b {
        private final C4797Gp2 a;
        private final SparseArray b;

        public b(C4797Gp2 c4797Gp2, SparseArray sparseArray) {
            this.a = c4797Gp2;
            SparseArray sparseArray2 = new SparseArray(c4797Gp2.d());
            for (int i = 0; i < c4797Gp2.d(); i++) {
                int iC = c4797Gp2.c(i);
                sparseArray2.append(iC, (a) AbstractC20011rK.e((a) sparseArray.get(iC)));
            }
            this.b = sparseArray2;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public int b(int i) {
            return this.a.c(i);
        }

        public a c(int i) {
            return (a) AbstractC20011rK.e((a) this.b.get(i));
        }

        public int d() {
            return this.a.d();
        }
    }

    default void K0(a aVar) {
    }

    default void P0(a aVar) {
    }

    default void a(a aVar) {
    }

    default void b0(a aVar) {
    }

    default void d1(a aVar) {
    }

    default void o0(a aVar) {
    }

    default void r(a aVar) {
    }

    default void v0(a aVar) {
    }

    default void A0(a aVar, JB1 jb1) {
    }

    default void C0(a aVar, C12372eV7 c12372eV7) {
    }

    default void D0(a aVar, C16831lw1 c16831lw1) {
    }

    default void F0(a aVar, C2035j c2035j) {
    }

    default void H(a aVar, int i) {
    }

    default void H0(com.google.android.exoplayer2.z0 z0Var, b bVar) {
    }

    default void K(a aVar, com.google.android.exoplayer2.K0 k0) {
    }

    default void P(a aVar, com.google.android.exoplayer2.X x) {
    }

    default void Q(a aVar, String str) {
    }

    default void T0(a aVar, MediaLoadData mediaLoadData) {
    }

    default void U(a aVar, int i) {
    }

    default void V(a aVar, long j) {
    }

    default void W(a aVar, boolean z) {
    }

    default void X0(a aVar, com.google.android.exoplayer2.X x) {
    }

    default void Y(a aVar, JB1 jb1) {
    }

    default void Z(a aVar, Exception exc) {
    }

    default void Z0(a aVar, boolean z) {
    }

    default void b1(a aVar, PlaybackException playbackException) {
    }

    default void c0(a aVar, Exception exc) {
    }

    default void d0(a aVar, Metadata metadata) {
    }

    default void e(a aVar, com.google.android.exoplayer2.y0 y0Var) {
    }

    default void e0(a aVar, Exception exc) {
    }

    default void e1(a aVar, com.google.android.exoplayer2.audio.a aVar2) {
    }

    default void f0(a aVar, C2020b0 c2020b0) {
    }

    default void g0(a aVar, PlaybackException playbackException) {
    }

    default void g1(a aVar, int i) {
    }

    default void h(a aVar, C6740Ot7 c6740Ot7) {
    }

    default void h0(a aVar, JB1 jb1) {
    }

    default void j0(a aVar, JB1 jb1) {
    }

    default void k(a aVar, float f) {
    }

    default void n0(a aVar, int i) {
    }

    default void p0(a aVar, boolean z) {
    }

    default void q(a aVar, MediaLoadData mediaLoadData) {
    }

    default void q0(a aVar, String str) {
    }

    default void t0(a aVar, Exception exc) {
    }

    default void v(a aVar, boolean z) {
    }

    default void w0(a aVar, int i) {
    }

    default void x(a aVar, int i) {
    }

    default void x0(a aVar, z0.b bVar) {
    }

    default void y0(a aVar, boolean z) {
    }

    default void z0(a aVar, List list) {
    }

    default void C(a aVar, Object obj, long j) {
    }

    default void I0(a aVar, int i, boolean z) {
    }

    default void J0(a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void L0(a aVar, int i, JB1 jb1) {
    }

    default void R0(a aVar, C2018a0 c2018a0, int i) {
    }

    default void S0(a aVar, long j, int i) {
    }

    default void T(a aVar, String str, long j) {
    }

    default void U0(a aVar, com.google.android.exoplayer2.X x, MB1 mb1) {
    }

    default void V0(a aVar, int i, com.google.android.exoplayer2.X x) {
    }

    default void W0(a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void a1(a aVar, boolean z, int i) {
    }

    default void c1(a aVar, int i, long j) {
    }

    default void f1(a aVar, String str, long j) {
    }

    default void h1(a aVar, boolean z, int i) {
    }

    default void k0(a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void m0(a aVar, com.google.android.exoplayer2.X x, MB1 mb1) {
    }

    default void p(a aVar, int i, JB1 jb1) {
    }

    default void s0(a aVar, int i, int i2) {
    }

    default void B0(a aVar, int i, long j, long j2) {
    }

    default void F(a aVar, z0.e eVar, z0.e eVar2, int i) {
    }

    default void G0(a aVar, String str, long j, long j2) {
    }

    default void a0(a aVar, int i, long j, long j2) {
    }

    default void i0(a aVar, int i, String str, long j) {
    }

    default void r0(a aVar, String str, long j, long j2) {
    }

    default void Y0(a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    default void z(a aVar, int i, int i2, int i3, float f) {
    }
}
