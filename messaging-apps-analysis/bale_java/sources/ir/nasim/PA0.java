package ir.nasim;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.v;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.BB0;
import ir.nasim.C24677z13;
import ir.nasim.VF0;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class PA0 implements CameraControlInternal {
    final b b;
    final Executor c;
    private final Object d = new Object();
    private final C19349qC0 e;
    private final CameraControlInternal.b f;
    private final v.b g;
    private final C4098Dr2 h;
    private final Nc8 i;
    private final C13834gt7 j;
    private final C25044ze2 k;
    Sc8 l;
    private final DA0 m;
    private final C21143tB0 n;
    private final HV7 o;
    private int p;
    private C24677z13.f q;
    private volatile boolean r;
    private volatile int s;
    private final C3546Bi t;
    private final IS u;
    private final AtomicLong v;
    private volatile InterfaceFutureC15215jC3 w;
    private int x;
    private long y;
    private final a z;

    static final class a extends JB0 {
        Set a = new HashSet();
        Map b = new ArrayMap();

        a() {
        }

        @Override // ir.nasim.JB0
        public void a(final int i) {
            for (final JB0 jb0 : this.a) {
                try {
                    ((Executor) this.b.get(jb0)).execute(new Runnable() { // from class: ir.nasim.OA0
                        @Override // java.lang.Runnable
                        public final void run() {
                            jb0.a(i);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    PI3.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e);
                }
            }
        }

        @Override // ir.nasim.JB0
        public void b(final int i, final QB0 qb0) {
            for (final JB0 jb0 : this.a) {
                try {
                    ((Executor) this.b.get(jb0)).execute(new Runnable() { // from class: ir.nasim.NA0
                        @Override // java.lang.Runnable
                        public final void run() {
                            jb0.b(i, qb0);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    PI3.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e);
                }
            }
        }

        @Override // ir.nasim.JB0
        public void c(final int i, final LB0 lb0) {
            for (final JB0 jb0 : this.a) {
                try {
                    ((Executor) this.b.get(jb0)).execute(new Runnable() { // from class: ir.nasim.MA0
                        @Override // java.lang.Runnable
                        public final void run() {
                            jb0.c(i, lb0);
                        }
                    });
                } catch (RejectedExecutionException e) {
                    PI3.d("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e);
                }
            }
        }

        void h(Executor executor, JB0 jb0) {
            this.a.add(jb0);
            this.b.put(jb0, executor);
        }

        void l(JB0 jb0) {
            this.a.remove(jb0);
            this.b.remove(jb0);
        }
    }

    static final class b extends CameraCaptureSession.CaptureCallback {
        final Set a = new HashSet();
        private final Executor b;

        b(Executor executor) {
            this.b = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (c cVar : this.a) {
                if (cVar.a(totalCaptureResult)) {
                    hashSet.add(cVar);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.a.removeAll(hashSet);
        }

        void b(c cVar) {
            this.a.add(cVar);
        }

        void d(c cVar) {
            this.a.remove(cVar);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, final TotalCaptureResult totalCaptureResult) {
            this.b.execute(new Runnable() { // from class: ir.nasim.QA0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(totalCaptureResult);
                }
            });
        }
    }

    public interface c {
        boolean a(TotalCaptureResult totalCaptureResult);
    }

    PA0(C19349qC0 c19349qC0, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal.b bVar, C6293Mz5 c6293Mz5) {
        v.b bVar2 = new v.b();
        this.g = bVar2;
        this.p = 0;
        this.r = false;
        this.s = 2;
        this.v = new AtomicLong(0L);
        this.w = WB2.l(null);
        this.x = 1;
        this.y = 0L;
        a aVar = new a();
        this.z = aVar;
        this.e = c19349qC0;
        this.f = bVar;
        this.c = executor;
        this.o = new HV7(executor);
        b bVar3 = new b(executor);
        this.b = bVar3;
        bVar2.w(this.x);
        bVar2.j(FF0.e(bVar3));
        bVar2.j(aVar);
        this.k = new C25044ze2(this, c19349qC0, executor);
        this.h = new C4098Dr2(this, scheduledExecutorService, executor, c6293Mz5);
        this.i = new Nc8(this, c19349qC0, executor);
        this.j = new C13834gt7(this, c19349qC0, executor);
        this.l = new Wc8(c19349qC0);
        this.t = new C3546Bi(c6293Mz5);
        this.u = new IS(c6293Mz5);
        this.m = new DA0(this, executor);
        this.n = new C21143tB0(this, c19349qC0, c6293Mz5, executor, scheduledExecutorService);
    }

    private boolean D() {
        return A() > 0;
    }

    private static boolean E(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    static boolean F(TotalCaptureResult totalCaptureResult, long j) {
        Long l;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        return (tag instanceof C14935ij7) && (l = (Long) ((C14935ij7) tag).d("CameraControlSessionUpdateId")) != null && l.longValue() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(Executor executor, JB0 jb0) {
        this.z.h(executor, jb0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(JB0 jb0) {
        this.z.l(jb0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(AbstractC16967mA0.a aVar) {
        WB2.u(Y(X()), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object L(final AbstractC16967mA0.a aVar) {
        this.c.execute(new Runnable() { // from class: ir.nasim.JA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.K(aVar);
            }
        });
        return "updateSessionConfigAsync";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean M(long j, AbstractC16967mA0.a aVar, TotalCaptureResult totalCaptureResult) {
        if (!F(totalCaptureResult, j)) {
            return false;
        }
        aVar.c(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object N(final long j, final AbstractC16967mA0.a aVar) {
        p(new c() { // from class: ir.nasim.LA0
            @Override // ir.nasim.PA0.c
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                return PA0.M(j, aVar, totalCaptureResult);
            }
        });
        return "waitForSessionUpdateId:" + j;
    }

    private InterfaceFutureC15215jC3 Y(final long j) {
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.KA0
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.N(j, aVar);
            }
        });
    }

    public static int w(C19349qC0 c19349qC0, int i) {
        int[] iArr = (int[]) c19349qC0.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return E(i, iArr) ? i : E(1, iArr) ? 1 : 0;
    }

    private int y(int i) {
        int[] iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return E(i, iArr) ? i : E(1, iArr) ? 1 : 0;
    }

    int A() {
        int i;
        synchronized (this.d) {
            i = this.p;
        }
        return i;
    }

    public Nc8 B() {
        return this.i;
    }

    void C() {
        synchronized (this.d) {
            this.p++;
        }
    }

    void O(c cVar) {
        this.b.d(cVar);
    }

    void P(final JB0 jb0) {
        this.c.execute(new Runnable() { // from class: ir.nasim.GA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.J(jb0);
            }
        });
    }

    void Q() {
        T(1);
    }

    void R(boolean z) {
        PI3.a("Camera2CameraControlImp", "setActive: isActive = " + z);
        this.h.n(z);
        this.i.f(z);
        this.j.d(z);
        this.k.b(z);
        this.m.t(z);
        if (z) {
            return;
        }
        this.q = null;
        this.o.a();
    }

    public void S(Rational rational) {
        this.h.o(rational);
    }

    void T(int i) {
        this.x = i;
        this.h.p(i);
        this.n.a(this.x);
    }

    public void U(boolean z) {
        this.l.c(z);
    }

    void V(List list) {
        this.f.b(list);
    }

    public InterfaceFutureC15215jC3 W() {
        return WB2.t(AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.HA0
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.L(aVar);
            }
        }));
    }

    long X() {
        this.y = this.v.getAndIncrement();
        this.f.a();
        return this.y;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void a(v.b bVar) {
        this.l.a(bVar);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void b(C24677z13.f fVar) {
        this.q = fVar;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect c() {
        Rect rect = (Rect) this.e.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        return ("robolectric".equals(Build.FINGERPRINT) && rect == null) ? new Rect(0, 0, 4000, 3000) : (Rect) AbstractC4980Hj5.g(rect);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void d(int i) {
        if (!D()) {
            PI3.l("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.s = i;
        PI3.a("Camera2CameraControlImp", "setFlashMode: mFlashMode = " + this.s);
        Sc8 sc8 = this.l;
        boolean z = true;
        if (this.s != 1 && this.s != 0) {
            z = false;
        }
        sc8.b(z);
        this.w = W();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public androidx.camera.core.impl.j e() {
        return this.m.n();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void f(androidx.camera.core.impl.j jVar) {
        this.m.g(VF0.a.e(jVar).d()).j(new Runnable() { // from class: ir.nasim.FA0
            @Override // java.lang.Runnable
            public final void run() {
                PA0.G();
            }
        }, AbstractC20567sE0.a());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void g() {
        this.m.j().j(new Runnable() { // from class: ir.nasim.IA0
            @Override // java.lang.Runnable
            public final void run() {
                PA0.I();
            }
        }, AbstractC20567sE0.a());
    }

    void p(c cVar) {
        this.b.b(cVar);
    }

    void q(final Executor executor, final JB0 jb0) {
        this.c.execute(new Runnable() { // from class: ir.nasim.EA0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.H(executor, jb0);
            }
        });
    }

    void r() {
        synchronized (this.d) {
            try {
                int i = this.p;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.p = i - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void s(boolean z) {
        this.r = z;
        if (!z) {
            i.a aVar = new i.a();
            aVar.r(this.x);
            aVar.s(true);
            BB0.a aVar2 = new BB0.a();
            aVar2.f(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(v(1)));
            aVar2.f(CaptureRequest.FLASH_MODE, 0);
            aVar.e(aVar2.c());
            V(Collections.singletonList(aVar.h()));
        }
        X();
    }

    public androidx.camera.core.impl.v t() {
        this.g.w(this.x);
        this.g.s(u());
        this.g.n("CameraControlSessionUpdateId", Long.valueOf(this.y));
        return this.g.o();
    }

    androidx.camera.core.impl.j u() {
        BB0.a aVar = new BB0.a();
        CaptureRequest.Key key = CaptureRequest.CONTROL_MODE;
        j.c cVar = j.c.REQUIRED;
        aVar.g(key, 1, cVar);
        this.h.b(aVar);
        this.t.a(aVar);
        this.i.a(aVar);
        int iA = this.h.l() ? 5 : 1;
        if (this.r) {
            aVar.g(CaptureRequest.FLASH_MODE, 2, cVar);
        } else {
            int i = this.s;
            if (i == 0) {
                iA = this.u.a(2);
            } else if (i == 1) {
                iA = 3;
            } else if (i == 2) {
                iA = 1;
            }
        }
        aVar.g(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(v(iA)), cVar);
        aVar.g(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(y(1)), cVar);
        this.k.c(aVar);
        this.m.i(aVar);
        return aVar.c();
    }

    int v(int i) {
        return w(this.e, i);
    }

    int x(int i) {
        int[] iArr = (int[]) this.e.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (E(i, iArr)) {
            return i;
        }
        if (E(4, iArr)) {
            return 4;
        }
        return E(1, iArr) ? 1 : 0;
    }

    public C13834gt7 z() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I() {
    }
}
