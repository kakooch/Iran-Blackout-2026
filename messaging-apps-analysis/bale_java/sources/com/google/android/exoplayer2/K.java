package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.A0;
import com.google.android.exoplayer2.C2019b;
import com.google.android.exoplayer2.C2023d;
import com.google.android.exoplayer2.G0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.W;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.z0;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AO5;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC7218Qt7;
import ir.nasim.AbstractC9253Zd2;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.BO5;
import ir.nasim.C12372eV7;
import ir.nasim.C15493jg5;
import ir.nasim.C16831lw1;
import ir.nasim.C16988mC3;
import ir.nasim.C22738vk6;
import ir.nasim.C3962Dc1;
import ir.nasim.C4797Gp2;
import ir.nasim.C6740Ot7;
import ir.nasim.C7452Rt7;
import ir.nasim.CY3;
import ir.nasim.InterfaceC10699c30;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC19509qT7;
import ir.nasim.InterfaceC21161tD0;
import ir.nasim.InterfaceC22769vn7;
import ir.nasim.InterfaceC23757xT2;
import ir.nasim.InterfaceC3582Bm;
import ir.nasim.InterfaceC3749Ce4;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.JB1;
import ir.nasim.LU7;
import ir.nasim.MB1;
import ir.nasim.NV0;
import ir.nasim.QD6;
import ir.nasim.RF3;
import ir.nasim.RS7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
final class K extends AbstractC2025e implements InterfaceC2037k {
    private final C2023d A;
    private final G0 B;
    private final L0 C;
    private final M0 D;
    private final long E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private C22738vk6 L;
    private ShuffleOrder M;
    private boolean N;
    private z0.b O;
    private C2020b0 P;
    private C2020b0 Q;
    private X R;
    private X S;
    private AudioTrack T;
    private Object U;
    private Surface V;
    private SurfaceHolder W;
    private SphericalGLSurfaceView X;
    private boolean Y;
    private TextureView Z;
    private int a0;
    final C7452Rt7 b;
    private int b0;
    final z0.b c;
    private QD6 c0;
    private final C3962Dc1 d;
    private JB1 d0;
    private final Context e;
    private JB1 e0;
    private final z0 f;
    private int f0;
    private final D0[] g;
    private com.google.android.exoplayer2.audio.a g0;
    private final AbstractC7218Qt7 h;
    private float h0;
    private final InterfaceC23757xT2 i;
    private boolean i0;
    private final W.f j;
    private C16831lw1 j0;
    private final W k;
    private boolean k0;
    private final C16988mC3 l;
    private boolean l0;
    private final CopyOnWriteArraySet m;
    private boolean m0;
    private final J0.b n;
    private boolean n0;
    private final List o;
    private C2035j o0;
    private final boolean p;
    private C12372eV7 p0;
    private final MediaSource.Factory q;
    private C2020b0 q0;
    private final InterfaceC3582Bm r;
    private x0 r0;
    private final Looper s;
    private int s0;
    private final InterfaceC10699c30 t;
    private int t0;
    private final long u;
    private long u0;
    private final long v;
    private final NV0 w;
    private final c x;
    private final d y;
    private final C2019b z;

    private static final class b {
        public static C15493jg5 a(Context context, K k, boolean z) {
            CY3 cy3I = CY3.i(context);
            if (cy3I == null) {
                AbstractC18815pI3.k("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new C15493jg5(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z) {
                k.E(cy3I);
            }
            return new C15493jg5(cy3I.t());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c implements LU7, com.google.android.exoplayer2.audio.b, InterfaceC22769vn7, InterfaceC3749Ce4, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, C2023d.b, C2019b.InterfaceC0159b, G0.b, InterfaceC2037k.a {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S(z0.d dVar) {
            dVar.O0(K.this.P);
        }

        @Override // ir.nasim.LU7
        public void A(JB1 jb1) {
            K.this.d0 = jb1;
            K.this.r.A(jb1);
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void D(JB1 jb1) {
            K.this.e0 = jb1;
            K.this.r.D(jb1);
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void E(X x, MB1 mb1) {
            K.this.S = x;
            K.this.r.E(x, mb1);
        }

        @Override // ir.nasim.LU7
        public void G(int i, long j) {
            K.this.r.G(i, j);
        }

        @Override // ir.nasim.LU7
        public void I(Object obj, long j) {
            K.this.r.I(obj, j);
            if (K.this.U == obj) {
                K.this.l.l(26, new C16988mC3.a() { // from class: ir.nasim.Yd2
                    @Override // ir.nasim.C16988mC3.a
                    public final void invoke(Object obj2) {
                        ((z0.d) obj2).s();
                    }
                });
            }
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void L(Exception exc) {
            K.this.r.L(exc);
        }

        @Override // ir.nasim.LU7
        public void M(X x, MB1 mb1) {
            K.this.R = x;
            K.this.r.M(x, mb1);
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void N(int i, long j, long j2) {
            K.this.r.N(i, j, j2);
        }

        @Override // ir.nasim.LU7
        public void O(long j, int i) {
            K.this.r.O(j, i);
        }

        @Override // com.google.android.exoplayer2.G0.b
        public void a(int i) {
            final C2035j c2035jX1 = K.X1(K.this.B);
            if (c2035jX1.equals(K.this.o0)) {
                return;
            }
            K.this.o0 = c2035jX1;
            K.this.l.l(29, new C16988mC3.a() { // from class: com.google.android.exoplayer2.Q
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).M0(c2035jX1);
                }
            });
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void b(final boolean z) {
            if (K.this.i0 == z) {
                return;
            }
            K.this.i0 = z;
            K.this.l.l(23, new C16988mC3.a() { // from class: com.google.android.exoplayer2.T
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).b(z);
                }
            });
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void c(Exception exc) {
            K.this.r.c(exc);
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void d(JB1 jb1) {
            K.this.r.d(jb1);
            K.this.S = null;
            K.this.e0 = null;
        }

        @Override // com.google.android.exoplayer2.C2019b.InterfaceC0159b
        public void e() {
            K.this.j3(false, -1, 3);
        }

        @Override // ir.nasim.LU7
        public void f(String str) {
            K.this.r.f(str);
        }

        @Override // ir.nasim.LU7
        public void g(String str, long j, long j2) {
            K.this.r.g(str, j, j2);
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void h(Surface surface) {
            K.this.e3(null);
        }

        @Override // ir.nasim.InterfaceC22769vn7
        public void i(final C16831lw1 c16831lw1) {
            K.this.j0 = c16831lw1;
            K.this.l.l(27, new C16988mC3.a() { // from class: com.google.android.exoplayer2.M
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).i(c16831lw1);
                }
            });
        }

        @Override // ir.nasim.LU7
        public void j(JB1 jb1) {
            K.this.r.j(jb1);
            K.this.R = null;
            K.this.d0 = null;
        }

        @Override // com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView.b
        public void k(Surface surface) {
            K.this.e3(surface);
        }

        @Override // ir.nasim.LU7
        public void l(final C12372eV7 c12372eV7) {
            K.this.p0 = c12372eV7;
            K.this.l.l(25, new C16988mC3.a() { // from class: com.google.android.exoplayer2.S
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).l(c12372eV7);
                }
            });
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void m(String str) {
            K.this.r.m(str);
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void n(String str, long j, long j2) {
            K.this.r.n(str, j, j2);
        }

        @Override // ir.nasim.InterfaceC3749Ce4
        public void o(final Metadata metadata) {
            K k = K.this;
            k.q0 = k.q0.c().K(metadata).H();
            C2020b0 c2020b0V1 = K.this.V1();
            if (!c2020b0V1.equals(K.this.P)) {
                K.this.P = c2020b0V1;
                K.this.l.i(14, new C16988mC3.a() { // from class: com.google.android.exoplayer2.N
                    @Override // ir.nasim.C16988mC3.a
                    public final void invoke(Object obj) {
                        this.a.S((z0.d) obj);
                    }
                });
            }
            K.this.l.i(28, new C16988mC3.a() { // from class: com.google.android.exoplayer2.O
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).o(metadata);
                }
            });
            K.this.l.f();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            K.this.d3(surfaceTexture);
            K.this.R2(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            K.this.e3(null);
            K.this.R2(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            K.this.R2(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.google.android.exoplayer2.G0.b
        public void p(final int i, final boolean z) {
            K.this.l.l(30, new C16988mC3.a() { // from class: com.google.android.exoplayer2.P
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).r1(i, z);
                }
            });
        }

        @Override // com.google.android.exoplayer2.InterfaceC2037k.a
        public void s(boolean z) {
            K.this.m3();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            K.this.R2(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (K.this.Y) {
                K.this.e3(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (K.this.Y) {
                K.this.e3(null);
            }
            K.this.R2(0, 0);
        }

        @Override // com.google.android.exoplayer2.C2023d.b
        public void t(float f) {
            K.this.Y2();
        }

        @Override // ir.nasim.InterfaceC22769vn7
        public void u(final List list) {
            K.this.l.l(27, new C16988mC3.a() { // from class: com.google.android.exoplayer2.L
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).u(list);
                }
            });
        }

        @Override // com.google.android.exoplayer2.C2023d.b
        public void v(int i) {
            boolean zX = K.this.X();
            K.this.j3(zX, i, K.i2(zX, i));
        }

        @Override // com.google.android.exoplayer2.audio.b
        public void w(long j) {
            K.this.r.w(j);
        }

        @Override // ir.nasim.LU7
        public void y(Exception exc) {
            K.this.r.y(exc);
        }
    }

    private static final class d implements InterfaceC19509qT7, InterfaceC21161tD0, A0.b {
        private InterfaceC19509qT7 a;
        private InterfaceC21161tD0 b;
        private InterfaceC19509qT7 c;
        private InterfaceC21161tD0 d;

        private d() {
        }

        @Override // ir.nasim.InterfaceC19509qT7
        public void a(long j, long j2, X x, MediaFormat mediaFormat) {
            InterfaceC19509qT7 interfaceC19509qT7 = this.c;
            if (interfaceC19509qT7 != null) {
                interfaceC19509qT7.a(j, j2, x, mediaFormat);
            }
            InterfaceC19509qT7 interfaceC19509qT72 = this.a;
            if (interfaceC19509qT72 != null) {
                interfaceC19509qT72.a(j, j2, x, mediaFormat);
            }
        }

        @Override // ir.nasim.InterfaceC21161tD0
        public void b(long j, float[] fArr) {
            InterfaceC21161tD0 interfaceC21161tD0 = this.d;
            if (interfaceC21161tD0 != null) {
                interfaceC21161tD0.b(j, fArr);
            }
            InterfaceC21161tD0 interfaceC21161tD02 = this.b;
            if (interfaceC21161tD02 != null) {
                interfaceC21161tD02.b(j, fArr);
            }
        }

        @Override // ir.nasim.InterfaceC21161tD0
        public void c() {
            InterfaceC21161tD0 interfaceC21161tD0 = this.d;
            if (interfaceC21161tD0 != null) {
                interfaceC21161tD0.c();
            }
            InterfaceC21161tD0 interfaceC21161tD02 = this.b;
            if (interfaceC21161tD02 != null) {
                interfaceC21161tD02.c();
            }
        }

        @Override // com.google.android.exoplayer2.A0.b
        public void q(int i, Object obj) {
            if (i == 7) {
                this.a = (InterfaceC19509qT7) obj;
                return;
            }
            if (i == 8) {
                this.b = (InterfaceC21161tD0) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.c = null;
                this.d = null;
            } else {
                this.c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    private static final class e implements InterfaceC2030g0 {
        private final Object a;
        private J0 b;

        public e(Object obj, J0 j0) {
            this.a = obj;
            this.b = j0;
        }

        @Override // com.google.android.exoplayer2.InterfaceC2030g0
        public Object a() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.InterfaceC2030g0
        public J0 b() {
            return this.b;
        }
    }

    static {
        AbstractC9253Zd2.a("goog.exo.exoplayer");
    }

    public K(InterfaceC2037k.b bVar, z0 z0Var) throws Throwable {
        Context applicationContext;
        InterfaceC3582Bm interfaceC3582Bm;
        c cVar;
        d dVar;
        Handler handler;
        D0[] d0ArrA;
        AbstractC7218Qt7 abstractC7218Qt7;
        InterfaceC10699c30 interfaceC10699c30;
        Looper looper;
        NV0 nv0;
        C7452Rt7 c7452Rt7;
        W.f fVar;
        int i;
        final K k = this;
        C3962Dc1 c3962Dc1 = new C3962Dc1();
        k.d = c3962Dc1;
        try {
            AbstractC18815pI3.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.3] [" + AbstractC9683aN7.e + "]");
            applicationContext = bVar.a.getApplicationContext();
            k.e = applicationContext;
            interfaceC3582Bm = (InterfaceC3582Bm) bVar.i.apply(bVar.b);
            k.r = interfaceC3582Bm;
            k.g0 = bVar.k;
            k.a0 = bVar.p;
            k.b0 = bVar.q;
            k.i0 = bVar.o;
            k.E = bVar.x;
            cVar = new c();
            k.x = cVar;
            dVar = new d();
            k.y = dVar;
            handler = new Handler(bVar.j);
            d0ArrA = ((BO5) bVar.d.get()).a(handler, cVar, cVar, cVar, cVar);
            k.g = d0ArrA;
            AbstractC20011rK.g(d0ArrA.length > 0);
            abstractC7218Qt7 = (AbstractC7218Qt7) bVar.f.get();
            k.h = abstractC7218Qt7;
            k.q = (MediaSource.Factory) bVar.e.get();
            interfaceC10699c30 = (InterfaceC10699c30) bVar.h.get();
            k.t = interfaceC10699c30;
            k.p = bVar.r;
            k.L = bVar.s;
            k.u = bVar.t;
            k.v = bVar.u;
            k.N = bVar.y;
            looper = bVar.j;
            k.s = looper;
            nv0 = bVar.b;
            k.w = nv0;
            z0 z0Var2 = z0Var == null ? k : z0Var;
            k.f = z0Var2;
            k.l = new C16988mC3(looper, nv0, new C16988mC3.b() { // from class: com.google.android.exoplayer2.t
                @Override // ir.nasim.C16988mC3.b
                public final void a(Object obj, C4797Gp2 c4797Gp2) {
                    this.a.r2((z0.d) obj, c4797Gp2);
                }
            });
            k.m = new CopyOnWriteArraySet();
            k.o = new ArrayList();
            k.M = new ShuffleOrder.DefaultShuffleOrder(0);
            c7452Rt7 = new C7452Rt7(new AO5[d0ArrA.length], new InterfaceC13679ge2[d0ArrA.length], K0.b, null);
            k.b = c7452Rt7;
            k.n = new J0.b();
            z0.b bVarE = new z0.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).d(29, abstractC7218Qt7.e()).e();
            k.c = bVarE;
            k.O = new z0.b.a().b(bVarE).a(4).a(10).e();
            k.i = nv0.a(looper, null);
            fVar = new W.f() { // from class: com.google.android.exoplayer2.u
                @Override // com.google.android.exoplayer2.W.f
                public final void a(W.e eVar) {
                    this.a.t2(eVar);
                }
            };
            k.j = fVar;
            k.r0 = x0.j(c7452Rt7);
            interfaceC3582Bm.n1(z0Var2, looper);
            i = AbstractC9683aN7.a;
        } catch (Throwable th) {
            th = th;
        }
        try {
            W w = new W(d0ArrA, abstractC7218Qt7, c7452Rt7, (RF3) bVar.g.get(), interfaceC10699c30, k.F, k.G, interfaceC3582Bm, k.L, bVar.v, bVar.w, k.N, looper, nv0, fVar, i < 31 ? new C15493jg5() : b.a(applicationContext, k, bVar.z), bVar.A);
            k = this;
            k.k = w;
            k.h0 = 1.0f;
            k.F = 0;
            C2020b0 c2020b0 = C2020b0.z0;
            k.P = c2020b0;
            k.Q = c2020b0;
            k.q0 = c2020b0;
            k.s0 = -1;
            if (i < 21) {
                k.f0 = k.n2(0);
            } else {
                k.f0 = AbstractC9683aN7.D(applicationContext);
            }
            k.j0 = C16831lw1.c;
            k.k0 = true;
            k.m0(interfaceC3582Bm);
            interfaceC10699c30.f(new Handler(looper), interfaceC3582Bm);
            k.S1(cVar);
            long j = bVar.c;
            if (j > 0) {
                w.v(j);
            }
            C2019b c2019b = new C2019b(bVar.a, handler, cVar);
            k.z = c2019b;
            c2019b.b(bVar.n);
            C2023d c2023d = new C2023d(bVar.a, handler, cVar);
            k.A = c2023d;
            c2023d.m(bVar.l ? k.g0 : null);
            G0 g0 = new G0(bVar.a, handler, cVar);
            k.B = g0;
            g0.i(AbstractC9683aN7.e0(k.g0.c));
            L0 l0 = new L0(bVar.a);
            k.C = l0;
            l0.a(bVar.m != 0);
            M0 m0 = new M0(bVar.a);
            k.D = m0;
            m0.a(bVar.m == 2);
            k.o0 = X1(g0);
            k.p0 = C12372eV7.e;
            k.c0 = QD6.c;
            abstractC7218Qt7.i(k.g0);
            k.X2(1, 10, Integer.valueOf(k.f0));
            k.X2(2, 10, Integer.valueOf(k.f0));
            k.X2(1, 3, k.g0);
            k.X2(2, 4, Integer.valueOf(k.a0));
            k.X2(2, 5, Integer.valueOf(k.b0));
            k.X2(1, 9, Boolean.valueOf(k.i0));
            k.X2(2, 7, dVar);
            k.X2(6, 8, dVar);
            c3962Dc1.f();
        } catch (Throwable th2) {
            th = th2;
            k = this;
            k.d.f();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(z0.d dVar) {
        dVar.l0(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B2(x0 x0Var, int i, z0.d dVar) {
        dVar.u0(x0Var.a, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C2(int i, z0.e eVar, z0.e eVar2, z0.d dVar) {
        dVar.B2(i);
        dVar.R(eVar, eVar2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E2(x0 x0Var, z0.d dVar) {
        dVar.q2(x0Var.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F2(x0 x0Var, z0.d dVar) {
        dVar.Z2(x0Var.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G2(x0 x0Var, z0.d dVar) {
        dVar.T2(x0Var.i.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I2(x0 x0Var, z0.d dVar) {
        dVar.X(x0Var.g);
        dVar.V2(x0Var.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J2(x0 x0Var, z0.d dVar) {
        dVar.c4(x0Var.l, x0Var.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K2(x0 x0Var, z0.d dVar) {
        dVar.E0(x0Var.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L2(x0 x0Var, int i, z0.d dVar) {
        dVar.S4(x0Var.l, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M2(x0 x0Var, z0.d dVar) {
        dVar.S(x0Var.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N2(x0 x0Var, z0.d dVar) {
        dVar.r5(p2(x0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O2(x0 x0Var, z0.d dVar) {
        dVar.B(x0Var.n);
    }

    private x0 P2(x0 x0Var, J0 j0, Pair pair) {
        AbstractC20011rK.a(j0.v() || pair != null);
        J0 j02 = x0Var.a;
        x0 x0VarI = x0Var.i(j0);
        if (j0.v()) {
            MediaSource.MediaPeriodId mediaPeriodIdK = x0.k();
            long jB0 = AbstractC9683aN7.B0(this.u0);
            x0 x0VarB = x0VarI.c(mediaPeriodIdK, jB0, jB0, jB0, 0L, TrackGroupArray.d, this.b, AbstractC12710f43.V()).b(mediaPeriodIdK);
            x0VarB.p = x0VarB.r;
            return x0VarB;
        }
        Object obj = x0VarI.b.a;
        boolean z = !obj.equals(((Pair) AbstractC9683aN7.j(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = z ? new MediaSource.MediaPeriodId(pair.first) : x0VarI.b;
        long jLongValue = ((Long) pair.second).longValue();
        long jB02 = AbstractC9683aN7.B0(l0());
        if (!j02.v()) {
            jB02 -= j02.m(obj, this.n).r();
        }
        if (z || jLongValue < jB02) {
            AbstractC20011rK.g(!mediaPeriodId.c());
            x0 x0VarB2 = x0VarI.c(mediaPeriodId, jLongValue, jLongValue, jLongValue, 0L, z ? TrackGroupArray.d : x0VarI.h, z ? this.b : x0VarI.i, z ? AbstractC12710f43.V() : x0VarI.j).b(mediaPeriodId);
            x0VarB2.p = jLongValue;
            return x0VarB2;
        }
        if (jLongValue == jB02) {
            int iG = j0.g(x0VarI.k.a);
            if (iG == -1 || j0.k(iG, this.n).c != j0.m(mediaPeriodId.a, this.n).c) {
                j0.m(mediaPeriodId.a, this.n);
                long jF = mediaPeriodId.c() ? this.n.f(mediaPeriodId.b, mediaPeriodId.c) : this.n.d;
                x0VarI = x0VarI.c(mediaPeriodId, x0VarI.r, x0VarI.r, x0VarI.d, jF - x0VarI.r, x0VarI.h, x0VarI.i, x0VarI.j).b(mediaPeriodId);
                x0VarI.p = jF;
            }
        } else {
            AbstractC20011rK.g(!mediaPeriodId.c());
            long jMax = Math.max(0L, x0VarI.q - (jLongValue - jB02));
            long j = x0VarI.p;
            if (x0VarI.k.equals(x0VarI.b)) {
                j = jLongValue + jMax;
            }
            x0VarI = x0VarI.c(mediaPeriodId, jLongValue, jLongValue, jLongValue, jMax, x0VarI.h, x0VarI.i, x0VarI.j);
            x0VarI.p = j;
        }
        return x0VarI;
    }

    private Pair Q2(J0 j0, int i, long j) {
        if (j0.v()) {
            this.s0 = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.u0 = j;
            this.t0 = 0;
            return null;
        }
        if (i == -1 || i >= j0.u()) {
            i = j0.f(this.G);
            j = j0.s(i, this.a).e();
        }
        return j0.o(this.a, this.n, i, AbstractC9683aN7.B0(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R2(final int i, final int i2) {
        if (i == this.c0.b() && i2 == this.c0.a()) {
            return;
        }
        this.c0 = new QD6(i, i2);
        this.l.l(24, new C16988mC3.a() { // from class: com.google.android.exoplayer2.x
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((z0.d) obj).b2(i, i2);
            }
        });
    }

    private long S2(J0 j0, MediaSource.MediaPeriodId mediaPeriodId, long j) {
        j0.m(mediaPeriodId.a, this.n);
        return j + this.n.r();
    }

    private List T1(int i, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            u0.c cVar = new u0.c((MediaSource) list.get(i2), this.p);
            arrayList.add(cVar);
            this.o.add(i2 + i, new e(cVar.b, cVar.a.E0()));
        }
        this.M = this.M.g(i, arrayList.size());
        return arrayList;
    }

    private x0 U2(int i, int i2) {
        int iR0 = r0();
        J0 j0N = N();
        int size = this.o.size();
        this.H++;
        V2(i, i2);
        J0 j0Y1 = Y1();
        x0 x0VarP2 = P2(this.r0, j0Y1, h2(j0N, j0Y1));
        int i3 = x0VarP2.e;
        if (i3 != 1 && i3 != 4 && i < i2 && i2 == size && iR0 >= x0VarP2.a.u()) {
            x0VarP2 = x0VarP2.g(4);
        }
        this.k.p0(i, i2, this.M);
        return x0VarP2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C2020b0 V1() {
        J0 j0N = N();
        if (j0N.v()) {
            return this.q0;
        }
        return this.q0.c().J(j0N.s(r0(), this.a).c.e).H();
    }

    private void V2(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.o.remove(i3);
        }
        this.M = this.M.a(i, i2);
    }

    private void W2() {
        if (this.X != null) {
            a2(this.y).n(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND).m(null).l();
            this.X.i(this.x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.x) {
                AbstractC18815pI3.k("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener(null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.x);
            this.W = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C2035j X1(G0 g0) {
        return new C2035j(0, g0.d(), g0.c());
    }

    private void X2(int i, int i2, Object obj) {
        for (D0 d0 : this.g) {
            if (d0.g() == i) {
                a2(d0).n(i2).m(obj).l();
            }
        }
    }

    private J0 Y1() {
        return new B0(this.o, this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2() {
        X2(1, 2, Float.valueOf(this.h0 * this.A.g()));
    }

    private List Z1(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(this.q.a((C2018a0) list.get(i)));
        }
        return arrayList;
    }

    private A0 a2(A0.b bVar) {
        int iE2 = e2();
        W w = this.k;
        J0 j0 = this.r0.a;
        if (iE2 == -1) {
            iE2 = 0;
        }
        return new A0(w, bVar, j0, iE2, this.w, w.D());
    }

    private Pair b2(x0 x0Var, x0 x0Var2, boolean z, int i, boolean z2, boolean z3) {
        J0 j0 = x0Var2.a;
        J0 j02 = x0Var.a;
        if (j02.v() && j0.v()) {
            return new Pair(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (j02.v() != j0.v()) {
            return new Pair(Boolean.TRUE, 3);
        }
        if (j0.s(j0.m(x0Var2.b.a, this.n).c, this.a).a.equals(j02.s(j02.m(x0Var.b.a, this.n).c, this.a).a)) {
            return (z && i == 0 && x0Var2.b.d < x0Var.b.d) ? new Pair(Boolean.TRUE, 0) : (z && i == 1 && z3) ? new Pair(Boolean.TRUE, 2) : new Pair(Boolean.FALSE, -1);
        }
        if (z && i == 0) {
            i2 = 1;
        } else if (z && i == 1) {
            i2 = 2;
        } else if (!z2) {
            throw new IllegalStateException();
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i2));
    }

    private void b3(List list, int i, long j, boolean z) {
        int iF;
        long j2;
        int iE2 = e2();
        long jD0 = D0();
        this.H++;
        if (!this.o.isEmpty()) {
            V2(0, this.o.size());
        }
        List listT1 = T1(0, list);
        J0 j0Y1 = Y1();
        if (!j0Y1.v() && i >= j0Y1.u()) {
            throw new IllegalSeekPositionException(j0Y1, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            iF = j0Y1.f(this.G);
        } else if (i == -1) {
            iF = iE2;
            j2 = jD0;
        } else {
            iF = i;
            j2 = j;
        }
        x0 x0VarP2 = P2(this.r0, j0Y1, Q2(j0Y1, iF, j2));
        int i2 = x0VarP2.e;
        if (iF != -1 && i2 != 1) {
            i2 = (j0Y1.v() || iF >= j0Y1.u()) ? 4 : 2;
        }
        x0 x0VarG = x0VarP2.g(i2);
        this.k.O0(listT1, iF, AbstractC9683aN7.B0(j2), this.M);
        k3(x0VarG, 0, 1, false, (this.r0.b.a.equals(x0VarG.b.a) || this.r0.a.v()) ? false : true, 4, d2(x0VarG), -1, false);
    }

    private void c3(SurfaceHolder surfaceHolder) {
        this.Y = false;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.x);
        Surface surface = this.W.getSurface();
        if (surface == null || !surface.isValid()) {
            R2(0, 0);
        } else {
            Rect surfaceFrame = this.W.getSurfaceFrame();
            R2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    private long d2(x0 x0Var) {
        return x0Var.a.v() ? AbstractC9683aN7.B0(this.u0) : x0Var.b.c() ? x0Var.r : S2(x0Var.a, x0Var.b, x0Var.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        e3(surface);
        this.V = surface;
    }

    private int e2() {
        if (this.r0.a.v()) {
            return this.s0;
        }
        x0 x0Var = this.r0;
        return x0Var.a.m(x0Var.b.a, this.n).c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(Object obj) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        D0[] d0Arr = this.g;
        int length = d0Arr.length;
        int i = 0;
        while (true) {
            z = true;
            if (i >= length) {
                break;
            }
            D0 d0 = d0Arr[i];
            if (d0.g() == 2) {
                arrayList.add(a2(d0).n(1).m(obj).l());
            }
            i++;
        }
        Object obj2 = this.U;
        if (obj2 == null || obj2 == obj) {
            z = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((A0) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z = false;
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z) {
            h3(false, ExoPlaybackException.n(new ExoTimeoutException(3), 1003));
        }
    }

    private Pair h2(J0 j0, J0 j02) {
        long jL0 = l0();
        if (j0.v() || j02.v()) {
            boolean z = !j0.v() && j02.v();
            int iE2 = z ? -1 : e2();
            if (z) {
                jL0 = -9223372036854775807L;
            }
            return Q2(j02, iE2, jL0);
        }
        Pair pairO = j0.o(this.a, this.n, r0(), AbstractC9683aN7.B0(jL0));
        Object obj = ((Pair) AbstractC9683aN7.j(pairO)).first;
        if (j02.g(obj) != -1) {
            return pairO;
        }
        Object objA0 = W.A0(this.a, this.n, this.F, this.G, obj, j0, j02);
        if (objA0 == null) {
            return Q2(j02, -1, -9223372036854775807L);
        }
        j02.m(objA0, this.n);
        int i = this.n.c;
        return Q2(j02, i, j02.s(i, this.a).e());
    }

    private void h3(boolean z, ExoPlaybackException exoPlaybackException) {
        x0 x0VarB;
        if (z) {
            x0VarB = U2(0, this.o.size()).e(null);
        } else {
            x0 x0Var = this.r0;
            x0VarB = x0Var.b(x0Var.b);
            x0VarB.p = x0VarB.r;
            x0VarB.q = 0L;
        }
        x0 x0VarG = x0VarB.g(1);
        if (exoPlaybackException != null) {
            x0VarG = x0VarG.e(exoPlaybackException);
        }
        x0 x0Var2 = x0VarG;
        this.H++;
        this.k.j1();
        k3(x0Var2, 0, 1, false, x0Var2.a.v() && !this.r0.a.v(), 4, d2(x0Var2), -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i2(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private void i3() {
        z0.b bVar = this.O;
        z0.b bVarF = AbstractC9683aN7.F(this.f, this.c);
        this.O = bVarF;
        if (bVarF.equals(bVar)) {
            return;
        }
        this.l.i(13, new C16988mC3.a() { // from class: com.google.android.exoplayer2.B
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                this.a.A2((z0.d) obj);
            }
        });
    }

    private z0.e j2(long j) {
        C2018a0 c2018a0;
        Object obj;
        int iG;
        Object obj2;
        int iR0 = r0();
        if (this.r0.a.v()) {
            c2018a0 = null;
            obj = null;
            iG = -1;
            obj2 = null;
        } else {
            x0 x0Var = this.r0;
            Object obj3 = x0Var.b.a;
            x0Var.a.m(obj3, this.n);
            iG = this.r0.a.g(obj3);
            obj = obj3;
            obj2 = this.r0.a.s(iR0, this.a).a;
            c2018a0 = this.a.c;
        }
        long jC1 = AbstractC9683aN7.c1(j);
        long jC12 = this.r0.b.c() ? AbstractC9683aN7.c1(l2(this.r0)) : jC1;
        MediaSource.MediaPeriodId mediaPeriodId = this.r0.b;
        return new z0.e(obj2, iR0, c2018a0, obj, iG, jC1, jC12, mediaPeriodId.b, mediaPeriodId.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        x0 x0Var = this.r0;
        if (x0Var.l == z2 && x0Var.m == i3) {
            return;
        }
        this.H++;
        x0 x0VarD = x0Var.d(z2, i3);
        this.k.R0(z2, i3);
        k3(x0VarD, 0, i2, false, false, 5, -9223372036854775807L, -1, false);
    }

    private z0.e k2(int i, x0 x0Var, int i2) {
        int i3;
        Object obj;
        C2018a0 c2018a0;
        Object obj2;
        int i4;
        long jL2;
        long jL22;
        J0.b bVar = new J0.b();
        if (x0Var.a.v()) {
            i3 = i2;
            obj = null;
            c2018a0 = null;
            obj2 = null;
            i4 = -1;
        } else {
            Object obj3 = x0Var.b.a;
            x0Var.a.m(obj3, bVar);
            int i5 = bVar.c;
            int iG = x0Var.a.g(obj3);
            Object obj4 = x0Var.a.s(i5, this.a).a;
            c2018a0 = this.a.c;
            obj2 = obj3;
            i4 = iG;
            obj = obj4;
            i3 = i5;
        }
        if (i == 0) {
            if (x0Var.b.c()) {
                MediaSource.MediaPeriodId mediaPeriodId = x0Var.b;
                jL2 = bVar.f(mediaPeriodId.b, mediaPeriodId.c);
                jL22 = l2(x0Var);
            } else {
                jL2 = x0Var.b.e != -1 ? l2(this.r0) : bVar.e + bVar.d;
                jL22 = jL2;
            }
        } else if (x0Var.b.c()) {
            jL2 = x0Var.r;
            jL22 = l2(x0Var);
        } else {
            jL2 = bVar.e + x0Var.r;
            jL22 = jL2;
        }
        long jC1 = AbstractC9683aN7.c1(jL2);
        long jC12 = AbstractC9683aN7.c1(jL22);
        MediaSource.MediaPeriodId mediaPeriodId2 = x0Var.b;
        return new z0.e(obj, i3, c2018a0, obj2, i4, jC1, jC12, mediaPeriodId2.b, mediaPeriodId2.c);
    }

    private void k3(final x0 x0Var, final int i, final int i2, boolean z, boolean z2, final int i3, long j, int i4, boolean z3) {
        x0 x0Var2 = this.r0;
        this.r0 = x0Var;
        boolean z4 = !x0Var2.a.equals(x0Var.a);
        Pair pairB2 = b2(x0Var, x0Var2, z2, i3, z4, z3);
        boolean zBooleanValue = ((Boolean) pairB2.first).booleanValue();
        final int iIntValue = ((Integer) pairB2.second).intValue();
        C2020b0 c2020b0V1 = this.P;
        if (zBooleanValue) {
            c2018a0 = x0Var.a.v() ? null : x0Var.a.s(x0Var.a.m(x0Var.b.a, this.n).c, this.a).c;
            this.q0 = C2020b0.z0;
        }
        if (zBooleanValue || !x0Var2.j.equals(x0Var.j)) {
            this.q0 = this.q0.c().L(x0Var.j).H();
            c2020b0V1 = V1();
        }
        boolean z5 = !c2020b0V1.equals(this.P);
        this.P = c2020b0V1;
        boolean z6 = x0Var2.l != x0Var.l;
        boolean z7 = x0Var2.e != x0Var.e;
        if (z7 || z6) {
            m3();
        }
        boolean z8 = x0Var2.g;
        boolean z9 = x0Var.g;
        boolean z10 = z8 != z9;
        if (z10) {
            l3(z9);
        }
        if (z4) {
            this.l.i(0, new C16988mC3.a() { // from class: com.google.android.exoplayer2.w
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.B2(x0Var, i, (z0.d) obj);
                }
            });
        }
        if (z2) {
            final z0.e eVarK2 = k2(i3, x0Var2, i4);
            final z0.e eVarJ2 = j2(j);
            this.l.i(11, new C16988mC3.a() { // from class: com.google.android.exoplayer2.H
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.C2(i3, eVarK2, eVarJ2, (z0.d) obj);
                }
            });
        }
        if (zBooleanValue) {
            this.l.i(1, new C16988mC3.a() { // from class: com.google.android.exoplayer2.I
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).D4(c2018a0, iIntValue);
                }
            });
        }
        if (x0Var2.f != x0Var.f) {
            this.l.i(10, new C16988mC3.a() { // from class: com.google.android.exoplayer2.J
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.E2(x0Var, (z0.d) obj);
                }
            });
            if (x0Var.f != null) {
                this.l.i(10, new C16988mC3.a() { // from class: com.google.android.exoplayer2.m
                    @Override // ir.nasim.C16988mC3.a
                    public final void invoke(Object obj) {
                        K.F2(x0Var, (z0.d) obj);
                    }
                });
            }
        }
        C7452Rt7 c7452Rt7 = x0Var2.i;
        C7452Rt7 c7452Rt72 = x0Var.i;
        if (c7452Rt7 != c7452Rt72) {
            this.h.f(c7452Rt72.e);
            this.l.i(2, new C16988mC3.a() { // from class: com.google.android.exoplayer2.n
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.G2(x0Var, (z0.d) obj);
                }
            });
        }
        if (z5) {
            final C2020b0 c2020b0 = this.P;
            this.l.i(14, new C16988mC3.a() { // from class: com.google.android.exoplayer2.o
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).O0(c2020b0);
                }
            });
        }
        if (z10) {
            this.l.i(3, new C16988mC3.a() { // from class: com.google.android.exoplayer2.p
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.I2(x0Var, (z0.d) obj);
                }
            });
        }
        if (z7 || z6) {
            this.l.i(-1, new C16988mC3.a() { // from class: com.google.android.exoplayer2.q
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.J2(x0Var, (z0.d) obj);
                }
            });
        }
        if (z7) {
            this.l.i(4, new C16988mC3.a() { // from class: com.google.android.exoplayer2.r
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.K2(x0Var, (z0.d) obj);
                }
            });
        }
        if (z6) {
            this.l.i(5, new C16988mC3.a() { // from class: com.google.android.exoplayer2.D
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.L2(x0Var, i2, (z0.d) obj);
                }
            });
        }
        if (x0Var2.m != x0Var.m) {
            this.l.i(6, new C16988mC3.a() { // from class: com.google.android.exoplayer2.E
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.M2(x0Var, (z0.d) obj);
                }
            });
        }
        if (p2(x0Var2) != p2(x0Var)) {
            this.l.i(7, new C16988mC3.a() { // from class: com.google.android.exoplayer2.F
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.N2(x0Var, (z0.d) obj);
                }
            });
        }
        if (!x0Var2.n.equals(x0Var.n)) {
            this.l.i(12, new C16988mC3.a() { // from class: com.google.android.exoplayer2.G
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.O2(x0Var, (z0.d) obj);
                }
            });
        }
        if (z) {
            this.l.i(-1, new C16988mC3.a() { // from class: ir.nasim.Wd2
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).X2();
                }
            });
        }
        i3();
        this.l.f();
        if (x0Var2.o != x0Var.o) {
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((InterfaceC2037k.a) it.next()).s(x0Var.o);
            }
        }
    }

    private static long l2(x0 x0Var) {
        J0.d dVar = new J0.d();
        J0.b bVar = new J0.b();
        x0Var.a.m(x0Var.b.a, bVar);
        return x0Var.c == -9223372036854775807L ? x0Var.a.s(bVar.c, dVar).f() : bVar.r() + x0Var.c;
    }

    private void l3(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m2, reason: merged with bridge method [inline-methods] */
    public void s2(W.e eVar) {
        long j;
        boolean z;
        long jS2;
        int i = this.H - eVar.c;
        this.H = i;
        boolean z2 = true;
        if (eVar.d) {
            this.I = eVar.e;
            this.J = true;
        }
        if (eVar.f) {
            this.K = eVar.g;
        }
        if (i == 0) {
            J0 j0 = eVar.b.a;
            if (!this.r0.a.v() && j0.v()) {
                this.s0 = -1;
                this.u0 = 0L;
                this.t0 = 0;
            }
            if (!j0.v()) {
                List listJ = ((B0) j0).J();
                AbstractC20011rK.g(listJ.size() == this.o.size());
                for (int i2 = 0; i2 < listJ.size(); i2++) {
                    ((e) this.o.get(i2)).b = (J0) listJ.get(i2);
                }
            }
            if (this.J) {
                if (eVar.b.b.equals(this.r0.b) && eVar.b.d == this.r0.r) {
                    z2 = false;
                }
                if (z2) {
                    if (j0.v() || eVar.b.b.c()) {
                        jS2 = eVar.b.d;
                    } else {
                        x0 x0Var = eVar.b;
                        jS2 = S2(j0, x0Var.b, x0Var.d);
                    }
                    j = jS2;
                } else {
                    j = -9223372036854775807L;
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.J = false;
            k3(eVar.b, 1, this.K, false, z, this.I, j, -1, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m3() {
        int iP = p();
        if (iP != 1) {
            if (iP == 2 || iP == 3) {
                this.C.b(X() && !c2());
                this.D.b(X());
                return;
            } else if (iP != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    private int n2(int i) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i);
        }
        return this.T.getAudioSessionId();
    }

    private void n3() {
        this.d.c();
        if (Thread.currentThread() != O().getThread()) {
            String strA = AbstractC9683aN7.A("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), O().getThread().getName());
            if (this.k0) {
                throw new IllegalStateException(strA);
            }
            AbstractC18815pI3.l("ExoPlayerImpl", strA, this.l0 ? null : new IllegalStateException());
            this.l0 = true;
        }
    }

    private static boolean p2(x0 x0Var) {
        return x0Var.e == 3 && x0Var.l && x0Var.m == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(z0.d dVar, C4797Gp2 c4797Gp2) {
        dVar.M3(this.f, new z0.c(c4797Gp2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(final W.e eVar) {
        this.i.h(new Runnable() { // from class: com.google.android.exoplayer2.A
            @Override // java.lang.Runnable
            public final void run() {
                this.a.s2(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u2(z0.d dVar) {
        dVar.Z2(ExoPlaybackException.n(new ExoTimeoutException(1), 1003));
    }

    @Override // com.google.android.exoplayer2.z0
    public C2020b0 A0() {
        n3();
        return this.P;
    }

    @Override // com.google.android.exoplayer2.z0
    public int B() {
        n3();
        return this.F;
    }

    @Override // com.google.android.exoplayer2.z0
    public void D(boolean z) {
        n3();
        int iP = this.A.p(z, p());
        j3(z, iP, i2(z, iP));
    }

    @Override // com.google.android.exoplayer2.z0
    public long D0() {
        n3();
        return AbstractC9683aN7.c1(d2(this.r0));
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void E(InterfaceC6170Mm interfaceC6170Mm) {
        this.r.c5((InterfaceC6170Mm) AbstractC20011rK.e(interfaceC6170Mm));
    }

    @Override // com.google.android.exoplayer2.z0
    public long E0() {
        n3();
        return this.u;
    }

    @Override // com.google.android.exoplayer2.z0
    public K0 F() {
        n3();
        return this.r0.i.d;
    }

    @Override // com.google.android.exoplayer2.z0
    public C16831lw1 H() {
        n3();
        return this.j0;
    }

    @Override // com.google.android.exoplayer2.z0
    public int I() {
        n3();
        if (k()) {
            return this.r0.b.b;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void J(boolean z) {
        n3();
        if (this.n0) {
            return;
        }
        this.z.b(z);
    }

    @Override // com.google.android.exoplayer2.AbstractC2025e
    public void K0(int i, long j, int i2, boolean z) {
        n3();
        AbstractC20011rK.a(i >= 0);
        this.r.N0();
        J0 j0 = this.r0.a;
        if (j0.v() || i < j0.u()) {
            this.H++;
            if (k()) {
                AbstractC18815pI3.k("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                W.e eVar = new W.e(this.r0);
                eVar.b(1);
                this.j.a(eVar);
                return;
            }
            int i3 = p() != 1 ? 2 : 1;
            int iR0 = r0();
            x0 x0VarP2 = P2(this.r0.g(i3), j0, Q2(j0, i, j));
            this.k.C0(j0, i, AbstractC9683aN7.B0(j));
            k3(x0VarP2, 0, 1, true, true, 1, d2(x0VarP2), iR0, z);
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public int M() {
        n3();
        return this.r0.m;
    }

    @Override // com.google.android.exoplayer2.z0
    public J0 N() {
        n3();
        return this.r0.a;
    }

    @Override // com.google.android.exoplayer2.z0
    public Looper O() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.z0
    public C6740Ot7 P() {
        n3();
        return this.h.b();
    }

    @Override // com.google.android.exoplayer2.z0
    public void R(TextureView textureView) {
        n3();
        if (textureView == null) {
            i0();
            return;
        }
        W2();
        this.Z = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            AbstractC18815pI3.k("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            e3(null);
            R2(0, 0);
        } else {
            d3(surfaceTexture);
            R2(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void S(final com.google.android.exoplayer2.audio.a aVar, boolean z) {
        n3();
        if (this.n0) {
            return;
        }
        if (!AbstractC9683aN7.c(this.g0, aVar)) {
            this.g0 = aVar;
            X2(1, 3, aVar);
            this.B.i(AbstractC9683aN7.e0(aVar.c));
            this.l.i(20, new C16988mC3.a() { // from class: com.google.android.exoplayer2.z
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).k4(aVar);
                }
            });
        }
        this.A.m(z ? aVar : null);
        this.h.i(aVar);
        boolean zX = X();
        int iP = this.A.p(zX, p());
        j3(zX, iP, i2(zX, iP));
        this.l.f();
    }

    public void S1(InterfaceC2037k.a aVar) {
        this.m.add(aVar);
    }

    @Override // com.google.android.exoplayer2.z0
    public void T(final C6740Ot7 c6740Ot7) {
        n3();
        if (!this.h.e() || c6740Ot7.equals(this.h.b())) {
            return;
        }
        this.h.j(c6740Ot7);
        this.l.l(19, new C16988mC3.a() { // from class: com.google.android.exoplayer2.C
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((z0.d) obj).Q4(c6740Ot7);
            }
        });
    }

    public void T2(InterfaceC6170Mm interfaceC6170Mm) {
        n3();
        this.r.d5((InterfaceC6170Mm) AbstractC20011rK.e(interfaceC6170Mm));
    }

    public void U1(int i, List list) {
        n3();
        AbstractC20011rK.a(i >= 0);
        int iMin = Math.min(i, this.o.size());
        J0 j0N = N();
        this.H++;
        List listT1 = T1(iMin, list);
        J0 j0Y1 = Y1();
        x0 x0VarP2 = P2(this.r0, j0Y1, h2(j0N, j0Y1));
        this.k.m(iMin, listT1, this.M);
        k3(x0VarP2, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.exoplayer2.z0
    public z0.b V() {
        n3();
        return this.O;
    }

    public void W1(SurfaceHolder surfaceHolder) {
        n3();
        if (surfaceHolder == null || surfaceHolder != this.W) {
            return;
        }
        i0();
    }

    @Override // com.google.android.exoplayer2.z0
    public boolean X() {
        n3();
        return this.r0.l;
    }

    @Override // com.google.android.exoplayer2.z0
    public void Y(final boolean z) {
        n3();
        if (this.G != z) {
            this.G = z;
            this.k.Y0(z);
            this.l.i(9, new C16988mC3.a() { // from class: com.google.android.exoplayer2.y
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).Q0(z);
                }
            });
            i3();
            this.l.f();
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public long Z() {
        n3();
        return 3000L;
    }

    public void Z2(List list) {
        n3();
        a3(list, true);
    }

    public void a3(List list, boolean z) {
        n3();
        b3(list, -1, -9223372036854775807L, z);
    }

    @Override // com.google.android.exoplayer2.z0
    public com.google.android.exoplayer2.audio.a b() {
        n3();
        return this.g0;
    }

    @Override // com.google.android.exoplayer2.z0
    public int b0() {
        n3();
        if (this.r0.a.v()) {
            return this.t0;
        }
        x0 x0Var = this.r0;
        return x0Var.a.g(x0Var.b.a);
    }

    @Override // com.google.android.exoplayer2.z0
    public y0 c() {
        n3();
        return this.r0.n;
    }

    public boolean c2() {
        n3();
        return this.r0.o;
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void d(MediaSource mediaSource) {
        n3();
        Z2(Collections.singletonList(mediaSource));
    }

    @Override // com.google.android.exoplayer2.z0
    public void d0(TextureView textureView) {
        n3();
        if (textureView == null || textureView != this.Z) {
            return;
        }
        i0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void e(y0 y0Var) {
        n3();
        if (y0Var == null) {
            y0Var = y0.d;
        }
        if (this.r0.n.equals(y0Var)) {
            return;
        }
        x0 x0VarF = this.r0.f(y0Var);
        this.H++;
        this.k.T0(y0Var);
        k3(x0VarF, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.exoplayer2.z0
    public C12372eV7 e0() {
        n3();
        return this.p0;
    }

    @Override // com.google.android.exoplayer2.z0
    public long f() {
        n3();
        if (!k()) {
            return a0();
        }
        x0 x0Var = this.r0;
        MediaSource.MediaPeriodId mediaPeriodId = x0Var.b;
        x0Var.a.m(mediaPeriodId.a, this.n);
        return AbstractC9683aN7.c1(this.n.f(mediaPeriodId.b, mediaPeriodId.c));
    }

    @Override // com.google.android.exoplayer2.z0
    public float f0() {
        n3();
        return this.h0;
    }

    public C2035j f2() {
        n3();
        return this.o0;
    }

    public void f3(SurfaceHolder surfaceHolder) {
        n3();
        if (surfaceHolder == null) {
            i0();
            return;
        }
        W2();
        this.Y = true;
        this.W = surfaceHolder;
        surfaceHolder.addCallback(this.x);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            e3(null);
            R2(0, 0);
        } else {
            e3(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            R2(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public void g(float f) {
        n3();
        final float fO = AbstractC9683aN7.o(f, 0.0f, 1.0f);
        if (this.h0 == fO) {
            return;
        }
        this.h0 = fO;
        Y2();
        this.l.l(22, new C16988mC3.a() { // from class: com.google.android.exoplayer2.s
            @Override // ir.nasim.C16988mC3.a
            public final void invoke(Object obj) {
                ((z0.d) obj).f3(fO);
            }
        });
    }

    public int g2() {
        n3();
        return this.B.f();
    }

    public void g3(boolean z) {
        n3();
        this.A.p(X(), 1);
        h3(z, null);
        this.j0 = new C16831lw1(AbstractC12710f43.V(), this.r0.r);
    }

    @Override // com.google.android.exoplayer2.z0
    public int h0() {
        n3();
        if (k()) {
            return this.r0.b.c;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.z0
    public void i0() {
        n3();
        W2();
        e3(null);
        R2(0, 0);
    }

    @Override // com.google.android.exoplayer2.z0
    public void j(Surface surface) {
        n3();
        W2();
        e3(surface);
        int i = surface == null ? 0 : -1;
        R2(i, i);
    }

    @Override // com.google.android.exoplayer2.z0
    public boolean k() {
        n3();
        return this.r0.b.c();
    }

    @Override // com.google.android.exoplayer2.z0
    public long k0() {
        n3();
        return this.v;
    }

    @Override // com.google.android.exoplayer2.z0
    public long l() {
        n3();
        return AbstractC9683aN7.c1(this.r0.q);
    }

    @Override // com.google.android.exoplayer2.z0
    public long l0() {
        n3();
        if (!k()) {
            return D0();
        }
        x0 x0Var = this.r0;
        x0Var.a.m(x0Var.b.a, this.n);
        x0 x0Var2 = this.r0;
        return x0Var2.c == -9223372036854775807L ? x0Var2.a.s(r0(), this.a).e() : this.n.q() + AbstractC9683aN7.c1(this.r0.c);
    }

    @Override // com.google.android.exoplayer2.z0
    public void m0(z0.d dVar) {
        this.l.c((z0.d) AbstractC20011rK.e(dVar));
    }

    @Override // com.google.android.exoplayer2.z0
    public void n0(int i, List list) {
        n3();
        U1(i, Z1(list));
    }

    @Override // com.google.android.exoplayer2.z0
    public void o(z0.d dVar) {
        n3();
        this.l.k((z0.d) AbstractC20011rK.e(dVar));
    }

    @Override // com.google.android.exoplayer2.z0
    public long o0() {
        n3();
        if (!k()) {
            return w0();
        }
        x0 x0Var = this.r0;
        return x0Var.k.equals(x0Var.b) ? AbstractC9683aN7.c1(this.r0.p) : f();
    }

    public boolean o2() {
        n3();
        return this.r0.g;
    }

    @Override // com.google.android.exoplayer2.z0
    public int p() {
        n3();
        return this.r0.e;
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void q0(ShuffleOrder shuffleOrder) {
        n3();
        this.M = shuffleOrder;
        J0 j0Y1 = Y1();
        x0 x0VarP2 = P2(this.r0, j0Y1, Q2(j0Y1, r0(), D0()));
        this.H++;
        this.k.a1(shuffleOrder);
        k3(x0VarP2, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.exoplayer2.z0
    public void r() {
        n3();
        boolean zX = X();
        int iP = this.A.p(zX, 2);
        j3(zX, iP, i2(zX, iP));
        x0 x0Var = this.r0;
        if (x0Var.e != 1) {
            return;
        }
        x0 x0VarE = x0Var.e(null);
        x0 x0VarG = x0VarE.g(x0VarE.a.v() ? 4 : 2);
        this.H++;
        this.k.k0();
        k3(x0VarG, 1, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.exoplayer2.z0
    public int r0() {
        n3();
        int iE2 = e2();
        if (iE2 == -1) {
            return 0;
        }
        return iE2;
    }

    @Override // com.google.android.exoplayer2.z0
    public void release() {
        AudioTrack audioTrack;
        AbstractC18815pI3.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.3] [" + AbstractC9683aN7.e + "] [" + AbstractC9253Zd2.b() + "]");
        n3();
        if (AbstractC9683aN7.a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.z.b(false);
        this.B.h();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.k.m0()) {
            this.l.l(10, new C16988mC3.a() { // from class: com.google.android.exoplayer2.l
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    K.u2((z0.d) obj);
                }
            });
        }
        this.l.j();
        this.i.f(null);
        this.t.c(this.r);
        x0 x0VarG = this.r0.g(1);
        this.r0 = x0VarG;
        x0 x0VarB = x0VarG.b(x0VarG.b);
        this.r0 = x0VarB;
        x0VarB.p = x0VarB.r;
        this.r0.q = 0L;
        this.r.release();
        this.h.g();
        W2();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.m0) {
            AbstractC18350oW3.a(AbstractC20011rK.e(null));
            throw null;
        }
        this.j0 = C16831lw1.c;
        this.n0 = true;
    }

    @Override // com.google.android.exoplayer2.z0
    public void s(final int i) {
        n3();
        if (this.F != i) {
            this.F = i;
            this.k.V0(i);
            this.l.i(8, new C16988mC3.a() { // from class: com.google.android.exoplayer2.v
                @Override // ir.nasim.C16988mC3.a
                public final void invoke(Object obj) {
                    ((z0.d) obj).J(i);
                }
            });
            i3();
            this.l.f();
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public void stop() {
        n3();
        g3(false);
    }

    @Override // com.google.android.exoplayer2.z0
    public void t0(SurfaceView surfaceView) {
        n3();
        W1(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.google.android.exoplayer2.z0
    public void u(List list, boolean z) {
        n3();
        a3(Z1(list), z);
    }

    @Override // com.google.android.exoplayer2.z0
    public void v(SurfaceView surfaceView) {
        n3();
        if (surfaceView instanceof RS7) {
            W2();
            e3(surfaceView);
            c3(surfaceView.getHolder());
        } else {
            if (!(surfaceView instanceof SphericalGLSurfaceView)) {
                f3(surfaceView == null ? null : surfaceView.getHolder());
                return;
            }
            W2();
            this.X = (SphericalGLSurfaceView) surfaceView;
            a2(this.y).n(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND).m(this.X).l();
            this.X.d(this.x);
            e3(this.X.getVideoSurface());
            c3(surfaceView.getHolder());
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public boolean v0() {
        n3();
        return this.G;
    }

    @Override // com.google.android.exoplayer2.z0
    public long w0() {
        n3();
        if (this.r0.a.v()) {
            return this.u0;
        }
        x0 x0Var = this.r0;
        if (x0Var.k.d != x0Var.b.d) {
            return x0Var.a.s(r0(), this.a).g();
        }
        long j = x0Var.p;
        if (this.r0.k.c()) {
            x0 x0Var2 = this.r0;
            J0.b bVarM = x0Var2.a.m(x0Var2.k.a, this.n);
            long j2 = bVarM.j(this.r0.k.b);
            j = j2 == Long.MIN_VALUE ? bVarM.d : j2;
        }
        x0 x0Var3 = this.r0;
        return AbstractC9683aN7.c1(S2(x0Var3.a, x0Var3.k, j));
    }

    @Override // com.google.android.exoplayer2.z0
    public void z(int i, int i2) {
        n3();
        AbstractC20011rK.a(i >= 0 && i2 >= i);
        int size = this.o.size();
        int iMin = Math.min(i2, size);
        if (i >= size || i == iMin) {
            return;
        }
        x0 x0VarU2 = U2(i, iMin);
        k3(x0VarU2, 0, 1, false, !x0VarU2.b.a.equals(this.r0.b.a), 4, d2(x0VarU2), -1, false);
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void z0(MediaSource mediaSource, boolean z) {
        n3();
        a3(Collections.singletonList(mediaSource), z);
    }

    @Override // com.google.android.exoplayer2.z0, com.google.android.exoplayer2.InterfaceC2037k
    public ExoPlaybackException a() {
        n3();
        return this.r0.f;
    }
}
