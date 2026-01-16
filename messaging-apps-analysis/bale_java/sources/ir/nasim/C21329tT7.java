package ir.nasim;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.video.PlaceholderSurface;

/* renamed from: ir.nasim.tT7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21329tT7 {
    private final C16762lp2 a = new C16762lp2();
    private final b b;
    private final e c;
    private boolean d;
    private Surface e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;

    /* renamed from: ir.nasim.tT7$a */
    private static final class a {
        public static void a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                AbstractC18815pI3.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.tT7$b */
    interface b {

        /* renamed from: ir.nasim.tT7$b$a */
        public interface a {
            void a(Display display);
        }

        void a();

        void b(a aVar);
    }

    /* renamed from: ir.nasim.tT7$e */
    private static final class e implements Choreographer.FrameCallback, Handler.Callback {
        private static final e f = new e();
        public volatile long a = -9223372036854775807L;
        private final Handler b;
        private final HandlerThread c;
        private Choreographer d;
        private int e;

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.c = handlerThread;
            handlerThread.start();
            Handler handlerU = AbstractC9683aN7.u(handlerThread.getLooper(), this);
            this.b = handlerU;
            handlerU.sendEmptyMessage(0);
        }

        private void b() {
            Choreographer choreographer = this.d;
            if (choreographer != null) {
                int i = this.e + 1;
                this.e = i;
                if (i == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.d = Choreographer.getInstance();
            } catch (RuntimeException e) {
                AbstractC18815pI3.l("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e);
            }
        }

        public static e d() {
            return f;
        }

        private void f() {
            Choreographer choreographer = this.d;
            if (choreographer != null) {
                int i = this.e - 1;
                this.e = i;
                if (i == 0) {
                    choreographer.removeFrameCallback(this);
                    this.a = -9223372036854775807L;
                }
            }
        }

        public void a() {
            this.b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.a = j;
            ((Choreographer) AbstractC20011rK.e(this.d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                c();
                return true;
            }
            if (i == 1) {
                b();
                return true;
            }
            if (i != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public C21329tT7(Context context) {
        b bVarF = f(context);
        this.b = bVarF;
        this.c = bVarF != null ? e.d() : null;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    private static boolean c(long j, long j2) {
        return Math.abs(j - j2) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (AbstractC9683aN7.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        a.a(surface, 0.0f);
    }

    private static long e(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            j5 = j3 + j5;
            j4 = j5;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private static b f(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b bVarD = AbstractC9683aN7.a >= 17 ? d.d(applicationContext) : null;
        return bVarD == null ? c.c(applicationContext) : bVarD;
    }

    private void n() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.k = refreshRate;
            this.l = (refreshRate * 80) / 100;
        } else {
            AbstractC18815pI3.k("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            this.k = -9223372036854775807L;
            this.l = -9223372036854775807L;
        }
    }

    private void q() {
        if (AbstractC9683aN7.a < 30 || this.e == null) {
            return;
        }
        float fB = this.a.e() ? this.a.b() : this.f;
        float f = this.g;
        if (fB == f) {
            return;
        }
        if (fB != -1.0f && f != -1.0f) {
            if (Math.abs(fB - this.g) < ((!this.a.e() || this.a.d() < 5000000000L) ? 1.0f : 0.02f)) {
                return;
            }
        } else if (fB == -1.0f && this.a.c() < 30) {
            return;
        }
        this.g = fB;
        r(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void r(boolean r4) {
        /*
            r3 = this;
            int r0 = ir.nasim.AbstractC9683aN7.a
            r1 = 30
            if (r0 < r1) goto L30
            android.view.Surface r0 = r3.e
            if (r0 == 0) goto L30
            int r1 = r3.j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L30
        L11:
            boolean r1 = r3.d
            if (r1 == 0) goto L21
            float r1 = r3.g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            float r2 = r3.i
            float r1 = r1 * r2
            goto L22
        L21:
            r1 = 0
        L22:
            if (r4 != 0) goto L2b
            float r4 = r3.h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L2b
            return
        L2b:
            r3.h = r1
            ir.nasim.C21329tT7.a.a(r0, r1)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21329tT7.r(boolean):void");
    }

    public long b(long j) {
        long j2;
        if (this.p == -1 || !this.a.e()) {
            j2 = j;
        } else {
            long jA = this.q + ((long) ((this.a.a() * (this.m - this.p)) / this.i));
            if (c(j, jA)) {
                j2 = jA;
            } else {
                n();
                j2 = j;
            }
        }
        this.n = this.m;
        this.o = j2;
        e eVar = this.c;
        if (eVar == null || this.k == -9223372036854775807L) {
            return j2;
        }
        long j3 = eVar.a;
        return j3 == -9223372036854775807L ? j2 : e(j2, j3, this.k) - this.l;
    }

    public void g(float f) {
        this.f = f;
        this.a.g();
        q();
    }

    public void h(long j) {
        long j2 = this.n;
        if (j2 != -1) {
            this.p = j2;
            this.q = this.o;
        }
        this.m++;
        this.a.f(j * 1000);
        q();
    }

    public void i(float f) {
        this.i = f;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.d = true;
        n();
        if (this.b != null) {
            ((e) AbstractC20011rK.e(this.c)).a();
            this.b.b(new b.a() { // from class: ir.nasim.rT7
                @Override // ir.nasim.C21329tT7.b.a
                public final void a(Display display) {
                    this.a.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.d = false;
        b bVar = this.b;
        if (bVar != null) {
            bVar.a();
            ((e) AbstractC20011rK.e(this.c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.e == surface) {
            return;
        }
        d();
        this.e = surface;
        r(true);
    }

    public void o(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        r(true);
    }

    /* renamed from: ir.nasim.tT7$c */
    private static final class c implements b {
        private final WindowManager a;

        private c(WindowManager windowManager) {
            this.a = windowManager;
        }

        public static b c(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // ir.nasim.C21329tT7.b
        public void b(b.a aVar) {
            aVar.a(this.a.getDefaultDisplay());
        }

        @Override // ir.nasim.C21329tT7.b
        public void a() {
        }
    }

    /* renamed from: ir.nasim.tT7$d */
    private static final class d implements b, DisplayManager.DisplayListener {
        private final DisplayManager a;
        private b.a b;

        private d(DisplayManager displayManager) {
            this.a = displayManager;
        }

        private Display c() {
            return this.a.getDisplay(0);
        }

        public static b d(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        @Override // ir.nasim.C21329tT7.b
        public void a() {
            this.a.unregisterDisplayListener(this);
            this.b = null;
        }

        @Override // ir.nasim.C21329tT7.b
        public void b(b.a aVar) {
            this.b = aVar;
            this.a.registerDisplayListener(this, AbstractC9683aN7.v());
            aVar.a(c());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            b.a aVar = this.b;
            if (aVar == null || i != 0) {
                return;
            }
            aVar.a(c());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }
}
