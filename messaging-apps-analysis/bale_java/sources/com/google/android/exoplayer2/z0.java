package com.google.android.exoplayer2;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.InterfaceC2029g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C12372eV7;
import ir.nasim.C16831lw1;
import ir.nasim.C4797Gp2;
import ir.nasim.C6740Ot7;
import ir.nasim.EG4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public interface z0 {

    public static final class b implements InterfaceC2029g {
        public static final b b = new a().e();
        private static final String c = AbstractC9683aN7.r0(0);
        public static final InterfaceC2029g.a d = new InterfaceC2029g.a() { // from class: ir.nasim.ag5
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return z0.b.e(bundle);
            }
        };
        private final C4797Gp2 a;

        public static final class a {
            private static final int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
            private final C4797Gp2.b a = new C4797Gp2.b();

            public a a(int i) {
                this.a.a(i);
                return this;
            }

            public a b(b bVar) {
                this.a.b(bVar.a);
                return this;
            }

            public a c(int... iArr) {
                this.a.c(iArr);
                return this;
            }

            public a d(int i, boolean z) {
                this.a.d(i, z);
                return this;
            }

            public b e() {
                return new b(this.a.e());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b e(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(c);
            if (integerArrayList == null) {
                return b;
            }
            a aVar = new a();
            for (int i = 0; i < integerArrayList.size(); i++) {
                aVar.a(integerArrayList.get(i).intValue());
            }
            return aVar.e();
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            Bundle bundle = new Bundle();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < this.a.d(); i++) {
                arrayList.add(Integer.valueOf(this.a.c(i)));
            }
            bundle.putIntegerArrayList(c, arrayList);
            return bundle;
        }

        public boolean d(int i) {
            return this.a.a(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        private b(C4797Gp2 c4797Gp2) {
            this.a = c4797Gp2;
        }
    }

    public static final class c {
        private final C4797Gp2 a;

        public c(C4797Gp2 c4797Gp2) {
            this.a = c4797Gp2;
        }

        public boolean a(int i) {
            return this.a.a(i);
        }

        public boolean b(int... iArr) {
            return this.a.b(iArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                return this.a.equals(((c) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public static final class e implements InterfaceC2029g {
        private static final String k = AbstractC9683aN7.r0(0);
        private static final String l = AbstractC9683aN7.r0(1);
        private static final String m = AbstractC9683aN7.r0(2);
        private static final String n = AbstractC9683aN7.r0(3);
        private static final String o = AbstractC9683aN7.r0(4);
        private static final String p = AbstractC9683aN7.r0(5);
        private static final String q = AbstractC9683aN7.r0(6);
        public static final InterfaceC2029g.a r = new InterfaceC2029g.a() { // from class: ir.nasim.bg5
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return z0.e.c(bundle);
            }
        };
        public final Object a;
        public final int b;
        public final int c;
        public final C2018a0 d;
        public final Object e;
        public final int f;
        public final long g;
        public final long h;
        public final int i;
        public final int j;

        public e(Object obj, int i, C2018a0 c2018a0, Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.a = obj;
            this.b = i;
            this.c = i;
            this.d = c2018a0;
            this.e = obj2;
            this.f = i2;
            this.g = j;
            this.h = j2;
            this.i = i3;
            this.j = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e c(Bundle bundle) {
            int i = bundle.getInt(k, 0);
            Bundle bundle2 = bundle.getBundle(l);
            return new e(null, i, bundle2 == null ? null : (C2018a0) C2018a0.o.a(bundle2), null, bundle.getInt(m, 0), bundle.getLong(n, 0L), bundle.getLong(o, 0L), bundle.getInt(p, -1), bundle.getInt(q, -1));
        }

        @Override // com.google.android.exoplayer2.InterfaceC2029g
        public Bundle a() {
            return d(true, true);
        }

        public Bundle d(boolean z, boolean z2) {
            Bundle bundle = new Bundle();
            bundle.putInt(k, z2 ? this.c : 0);
            C2018a0 c2018a0 = this.d;
            if (c2018a0 != null && z) {
                bundle.putBundle(l, c2018a0.a());
            }
            bundle.putInt(m, z2 ? this.f : 0);
            bundle.putLong(n, z ? this.g : 0L);
            bundle.putLong(o, z ? this.h : 0L);
            bundle.putInt(p, z ? this.i : -1);
            bundle.putInt(q, z ? this.j : -1);
            return bundle;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.c == eVar.c && this.f == eVar.f && this.g == eVar.g && this.h == eVar.h && this.i == eVar.i && this.j == eVar.j && EG4.a(this.a, eVar.a) && EG4.a(this.e, eVar.e) && EG4.a(this.d, eVar.d);
        }

        public int hashCode() {
            return EG4.b(this.a, Integer.valueOf(this.c), this.d, this.e, Integer.valueOf(this.f), Long.valueOf(this.g), Long.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j));
        }
    }

    int A();

    C2020b0 A0();

    int B();

    void B0(int i, C2018a0 c2018a0);

    void C();

    void C0(List list);

    void D(boolean z);

    long D0();

    long E0();

    K0 F();

    boolean F0();

    boolean G();

    C16831lw1 H();

    int I();

    boolean K(int i);

    boolean L();

    int M();

    J0 N();

    Looper O();

    C6740Ot7 P();

    void Q();

    void R(TextureView textureView);

    void T(C6740Ot7 c6740Ot7);

    void U(int i, long j);

    b V();

    void W(C2018a0 c2018a0);

    boolean X();

    void Y(boolean z);

    long Z();

    PlaybackException a();

    long a0();

    com.google.android.exoplayer2.audio.a b();

    int b0();

    y0 c();

    void c0(C2018a0 c2018a0);

    void d0(TextureView textureView);

    void e(y0 y0Var);

    C12372eV7 e0();

    long f();

    float f0();

    void g(float f);

    boolean g0();

    void h();

    int h0();

    boolean i();

    void i0();

    void j(Surface surface);

    void j0(int i);

    boolean k();

    long k0();

    long l();

    long l0();

    void m();

    void m0(d dVar);

    C2018a0 n();

    void n0(int i, List list);

    void o(d dVar);

    long o0();

    int p();

    boolean p0();

    void q();

    void r();

    int r0();

    void release();

    void s(int i);

    int s0();

    void stop();

    void t();

    void t0(SurfaceView surfaceView);

    void u(List list, boolean z);

    void u0(List list);

    void v(SurfaceView surfaceView);

    boolean v0();

    void w(int i);

    long w0();

    void x(long j);

    void x0();

    int y();

    void y0();

    void z(int i, int i2);

    public interface d {
        default void B(y0 y0Var) {
        }

        default void B2(int i) {
        }

        default void D4(C2018a0 c2018a0, int i) {
        }

        default void E0(int i) {
        }

        default void J(int i) {
        }

        default void M0(C2035j c2035j) {
        }

        default void M3(z0 z0Var, c cVar) {
        }

        default void O0(C2020b0 c2020b0) {
        }

        default void Q0(boolean z) {
        }

        default void R(e eVar, e eVar2, int i) {
        }

        default void S(int i) {
        }

        default void S4(boolean z, int i) {
        }

        default void T2(K0 k0) {
        }

        default void V2(boolean z) {
        }

        default void X(boolean z) {
        }

        default void X2() {
        }

        default void Z2(PlaybackException playbackException) {
        }

        default void b(boolean z) {
        }

        default void b2(int i, int i2) {
        }

        default void c4(boolean z, int i) {
        }

        default void f3(float f) {
        }

        default void k4(com.google.android.exoplayer2.audio.a aVar) {
        }

        default void l0(b bVar) {
        }

        default void o(Metadata metadata) {
        }

        default void q2(PlaybackException playbackException) {
        }

        default void r1(int i, boolean z) {
        }

        default void r5(boolean z) {
        }

        default void s() {
        }

        default void u(List list) {
        }

        default void u0(J0 j0, int i) {
        }

        default void Q4(C6740Ot7 c6740Ot7) {
        }

        default void i(C16831lw1 c16831lw1) {
        }

        default void l(C12372eV7 c12372eV7) {
        }
    }
}
