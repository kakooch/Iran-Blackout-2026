package ir.nasim;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.audio.n;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.z0;
import ir.nasim.AbstractC9190Yw2;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.tgwidgets.editor.messenger.E;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class FT7 implements z0.d, InterfaceC6170Mm, E.d {
    static int D;
    Handler A;
    boolean B;
    public InterfaceC2037k a;
    private InterfaceC2037k b;
    private AbstractC15323jO3 c;
    private a.InterfaceC0163a d;
    private TextureView e;
    private Surface f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Uri j;
    private boolean k;
    private boolean l;
    private boolean m;
    private d n;
    private b o;
    private int p;
    private boolean q;
    private Uri r;
    private Uri s;
    private String t;
    private String u;
    private boolean v;
    private boolean w;
    private int x;
    private boolean y;
    ProgressiveMediaSource.Factory z;

    class a implements z0.d {
        a() {
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void c4(boolean z, int i) {
            if (FT7.this.l || i != 3) {
                return;
            }
            FT7.this.l = true;
            FT7.this.o1();
        }
    }

    public interface b {
        void a(boolean z, boolean z2, float[] fArr);

        boolean b();
    }

    private class c extends ME1 {
        public c(Context context) {
            super(context);
        }

        @Override // ir.nasim.ME1
        protected AudioSink c(Context context, boolean z, boolean z2, boolean z3) {
            return new DefaultAudioSink.f().g(SM.c(context)).k(z).j(z2).i(new AudioProcessor[]{new com.google.android.exoplayer2.audio.n(FT7.this.new e())}).l(z3 ? 1 : 0).f();
        }
    }

    public FT7() {
        this(true, false);
    }

    private void B1() {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k == null) {
            return;
        }
        boolean zX = interfaceC2037k.X();
        int iP = this.a.p();
        if (this.q == zX && this.p == iP) {
            return;
        }
        this.n.c(zX, iP);
        this.q = zX;
        this.p = iP;
    }

    private MediaSource C1(Uri uri, String str) {
        C2018a0 c2018a0A = new C2018a0.c().j(uri).a();
        str.hashCode();
        if (this.z == null) {
            this.z = new ProgressiveMediaSource.Factory(this.d);
        }
        return this.z.a(c2018a0A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        if (this.l && this.k && this.m) {
            E1();
        }
    }

    private void p1() {
        if (this.a == null) {
            ME1 cVar = this.o != null ? new c(AbstractC14047hG.a) : new ME1(AbstractC14047hG.a);
            cVar.j(2);
            InterfaceC2037k interfaceC2037kI = new InterfaceC2037k.b(AbstractC14047hG.a).u(cVar).v(this.c).i();
            this.a = interfaceC2037kI;
            interfaceC2037kI.E(this);
            this.a.m0(this);
            TextureView textureView = this.e;
            if (textureView != null) {
                this.a.R(textureView);
            } else {
                Surface surface = this.f;
                if (surface != null) {
                    this.a.j(surface);
                }
            }
            this.a.D(this.h);
            this.a.s(this.w ? 2 : 0);
        }
        if (this.i && this.b == null) {
            InterfaceC2037k interfaceC2037kI2 = new InterfaceC2037k.b(AbstractC14047hG.a).v(this.c).i();
            this.b = interfaceC2037kI2;
            interfaceC2037kI2.m0(new a());
            this.b.D(this.h);
        }
    }

    public boolean A1() {
        InterfaceC2037k interfaceC2037k;
        return (this.i && this.m) || ((interfaceC2037k = this.a) != null && interfaceC2037k.X());
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void C(InterfaceC6170Mm.a aVar, Object obj, long j) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.b(aVar);
        }
    }

    public void D1() {
        this.m = false;
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.D(false);
        }
        InterfaceC2037k interfaceC2037k2 = this.b;
        if (interfaceC2037k2 != null) {
            interfaceC2037k2.D(false);
        }
        if (this.o != null) {
            this.A.removeCallbacksAndMessages(null);
            this.o.a(false, true, null);
        }
    }

    public void E1() {
        this.m = true;
        if (!this.i || (this.l && this.k)) {
            InterfaceC2037k interfaceC2037k = this.a;
            if (interfaceC2037k != null) {
                interfaceC2037k.D(true);
            }
            InterfaceC2037k interfaceC2037k2 = this.b;
            if (interfaceC2037k2 != null) {
                interfaceC2037k2.D(true);
                return;
            }
            return;
        }
        InterfaceC2037k interfaceC2037k3 = this.a;
        if (interfaceC2037k3 != null) {
            interfaceC2037k3.D(false);
        }
        InterfaceC2037k interfaceC2037k4 = this.b;
        if (interfaceC2037k4 != null) {
            interfaceC2037k4.D(false);
        }
    }

    public void F1(Uri uri, String str) {
        G1(uri, str, 3);
    }

    public void G1(Uri uri, String str, int i) {
        this.r = uri;
        this.t = str;
        this.s = null;
        this.u = null;
        boolean z = false;
        this.v = false;
        this.k = false;
        this.i = false;
        this.j = uri;
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.startsWith("file")) {
            z = true;
        }
        this.g = z;
        p1();
        this.a.z0(C1(uri, str), true);
        this.a.r();
    }

    public void H1(boolean z) {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.release();
            this.a = null;
        }
        InterfaceC2037k interfaceC2037k2 = this.b;
        if (interfaceC2037k2 != null) {
            interfaceC2037k2.release();
            this.b = null;
        }
        if (this.y) {
            ir.nasim.tgwidgets.editor.messenger.E.j().u(this, ir.nasim.tgwidgets.editor.messenger.E.j3);
        }
        D--;
    }

    public void I1(long j) {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.x(j);
        }
    }

    public void J1(b bVar) {
        this.o = bVar;
    }

    public void K1(d dVar) {
        this.n = dVar;
    }

    public void L1(boolean z) {
        if (this.w != z) {
            this.w = z;
            InterfaceC2037k interfaceC2037k = this.a;
            if (interfaceC2037k != null) {
                interfaceC2037k.s(z ? 2 : 0);
            }
        }
    }

    public void M1(boolean z) {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.g(z ? 0.0f : 1.0f);
        }
        InterfaceC2037k interfaceC2037k2 = this.b;
        if (interfaceC2037k2 != null) {
            interfaceC2037k2.g(z ? 0.0f : 1.0f);
        }
    }

    public void N1(boolean z) {
        this.m = z;
        if (z && this.i && (!this.l || !this.k)) {
            InterfaceC2037k interfaceC2037k = this.a;
            if (interfaceC2037k != null) {
                interfaceC2037k.D(false);
            }
            InterfaceC2037k interfaceC2037k2 = this.b;
            if (interfaceC2037k2 != null) {
                interfaceC2037k2.D(false);
                return;
            }
            return;
        }
        this.h = z;
        InterfaceC2037k interfaceC2037k3 = this.a;
        if (interfaceC2037k3 != null) {
            interfaceC2037k3.D(z);
        }
        InterfaceC2037k interfaceC2037k4 = this.b;
        if (interfaceC2037k4 != null) {
            interfaceC2037k4.D(z);
        }
    }

    public void O1(float f) {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.e(new com.google.android.exoplayer2.y0(f, f > 1.0f ? 0.98f : 1.0f));
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void P0(InterfaceC6170Mm.a aVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.d(aVar);
        }
    }

    public void P1(int i) {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.S(new a.e().f(i == 0 ? 2 : 1).a(), false);
        }
        InterfaceC2037k interfaceC2037k2 = this.b;
        if (interfaceC2037k2 != null) {
            interfaceC2037k2.S(new a.e().f(i != 0 ? 1 : 2).a(), true);
        }
    }

    public void Q1(Surface surface) {
        if (this.f == surface) {
            return;
        }
        this.f = surface;
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k == null) {
            return;
        }
        interfaceC2037k.j(surface);
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void R(z0.e eVar, z0.e eVar2, int i) {
        if (i == 0) {
            this.x++;
        }
    }

    public void R1(TextureView textureView) {
        if (this.e == textureView) {
            return;
        }
        this.e = textureView;
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k == null) {
            return;
        }
        interfaceC2037k.R(textureView);
    }

    public void S1(float f) {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            interfaceC2037k.g(f);
        }
        InterfaceC2037k interfaceC2037k2 = this.b;
        if (interfaceC2037k2 != null) {
            interfaceC2037k2.g(f);
        }
    }

    @Override // ir.nasim.InterfaceC6170Mm
    public void a(InterfaceC6170Mm.a aVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.a(aVar);
        }
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void c4(boolean z, int i) {
        B1();
        if (z && i == 3 && !z1() && this.y) {
            ir.nasim.tgwidgets.editor.messenger.E.j().s(ir.nasim.tgwidgets.editor.messenger.E.j3, this);
        }
        if (!this.k && i == 3) {
            this.k = true;
            o1();
        }
        if (i != 3) {
            this.A.removeCallbacksAndMessages(null);
            b bVar = this.o;
            if (bVar != null) {
                bVar.a(false, true, null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void l(C12372eV7 c12372eV7) {
        this.n.e(c12372eV7.a, c12372eV7.b, c12372eV7.c, c12372eV7.d);
        super.l(c12372eV7);
    }

    public long q1() {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            return this.g ? interfaceC2037k.o0() : interfaceC2037k.f();
        }
        return 0L;
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void s() {
        this.n.s();
    }

    public long s1() {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            return interfaceC2037k.D0();
        }
        return 0L;
    }

    @Override // ir.nasim.tgwidgets.editor.messenger.E.d
    public void t(int i, int i2, Object... objArr) {
        if (i == ir.nasim.tgwidgets.editor.messenger.E.j3 && ((FT7) objArr[0]) != this && A1()) {
            D1();
        }
    }

    public Uri t1() {
        return this.j;
    }

    public long u1() {
        InterfaceC2037k interfaceC2037k = this.a;
        if (interfaceC2037k != null) {
            return interfaceC2037k.f();
        }
        return 0L;
    }

    public l.b v1(l.b bVar) {
        return bVar == null ? new l.b() : bVar;
    }

    public boolean w1() {
        return this.a.X();
    }

    public int x1() {
        return this.a.p();
    }

    public boolean y1() {
        return this.w;
    }

    public boolean z1() {
        InterfaceC2037k interfaceC2037k = this.a;
        return interfaceC2037k != null && interfaceC2037k.f0() == 0.0f;
    }

    public FT7(boolean z, boolean z2) {
        this.A = new Handler(Looper.getMainLooper());
        this.B = z2;
        this.d = new C4449Fe2(AbstractC14047hG.a, "Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20150101 Firefox/47.0 (Chrome)");
        YF1 yf1 = new YF1(AbstractC14047hG.a);
        this.c = yf1;
        if (z2) {
            yf1.j(yf1.b().B().J(1, true).A());
        }
        this.p = 1;
        this.y = z;
        if (z) {
            ir.nasim.tgwidgets.editor.messenger.E.j().e(this, ir.nasim.tgwidgets.editor.messenger.E.j3);
        }
        D++;
    }

    public interface d {
        void c(boolean z, int i);

        void e(int i, int i2, int i3, float f);

        void s();

        default void a(InterfaceC6170Mm.a aVar) {
        }

        default void b(InterfaceC6170Mm.a aVar) {
        }

        default void d(InterfaceC6170Mm.a aVar) {
        }
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void B(com.google.android.exoplayer2.y0 y0Var) {
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void J(int i) {
    }

    @Override // com.google.android.exoplayer2.z0.d
    public void b2(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e implements n.a {
        ByteBuffer e;
        long g;
        private final int a = 1024;
        private final int b = 8192;
        AbstractC9190Yw2.a c = new AbstractC9190Yw2.a(1024, 48000.0f);
        float[] d = new float[1024];
        int f = 0;

        public e() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(8192);
            this.e = byteBufferAllocateDirect;
            byteBufferAllocateDirect.position(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            FT7.this.A.removeCallbacksAndMessages(null);
            FT7.this.o.a(false, true, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(float[] fArr) {
            FT7.this.o.a(true, true, fArr);
        }

        @Override // com.google.android.exoplayer2.audio.n.a
        public void a(ByteBuffer byteBuffer) {
            if (FT7.this.o == null) {
                return;
            }
            if (byteBuffer == AudioProcessor.a || !FT7.this.m) {
                FT7.this.A.postDelayed(new Runnable() { // from class: ir.nasim.GT7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                }, 80L);
                return;
            }
            if (FT7.this.o.b()) {
                int iLimit = byteBuffer.limit();
                int i = 0;
                if (iLimit > 8192) {
                    FT7.this.A.removeCallbacksAndMessages(null);
                    FT7.this.o.a(false, true, null);
                    return;
                }
                this.e.put(byteBuffer);
                int i2 = this.f + iLimit;
                this.f = i2;
                if (i2 >= 1024) {
                    this.e.position(0);
                    for (int i3 = 0; i3 < 1024; i3++) {
                        this.d[i3] = this.e.getShort() / 32768.0f;
                    }
                    this.e.rewind();
                    this.f = 0;
                    this.c.n(this.d);
                    float f = 0.0f;
                    int i4 = 0;
                    while (true) {
                        float f2 = 1.0f;
                        if (i4 >= 1024) {
                            break;
                        }
                        float f3 = this.c.g()[i4];
                        float f4 = this.c.f()[i4];
                        float fSqrt = ((float) Math.sqrt((f3 * f3) + (f4 * f4))) / 30.0f;
                        if (fSqrt <= 1.0f) {
                            f2 = fSqrt < 0.0f ? 0.0f : fSqrt;
                        }
                        f += f2 * f2;
                        i4++;
                    }
                    float fSqrt2 = (float) Math.sqrt(f / 1024);
                    final float[] fArr = new float[7];
                    fArr[6] = fSqrt2;
                    if (fSqrt2 < 0.4f) {
                        while (i < 7) {
                            fArr[i] = 0.0f;
                            i++;
                        }
                    } else {
                        while (i < 6) {
                            int i5 = 170 * i;
                            float f5 = this.c.g()[i5];
                            float f6 = this.c.f()[i5];
                            float fSqrt3 = (float) (Math.sqrt((f5 * f5) + (f6 * f6)) / 30.0d);
                            fArr[i] = fSqrt3;
                            if (fSqrt3 > 1.0f) {
                                fArr[i] = 1.0f;
                            } else if (fSqrt3 < 0.0f) {
                                fArr[i] = 0.0f;
                            }
                            i++;
                        }
                    }
                    if (System.currentTimeMillis() - this.g < 64) {
                        return;
                    }
                    this.g = System.currentTimeMillis();
                    FT7.this.A.postDelayed(new Runnable() { // from class: ir.nasim.HT7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.f(fArr);
                        }
                    }, 130L);
                }
            }
        }

        @Override // com.google.android.exoplayer2.audio.n.a
        public void b(int i, int i2, int i3) {
        }
    }
}
