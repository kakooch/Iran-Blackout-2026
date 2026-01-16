package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.AbstractC1920a;
import androidx.camera.core.impl.B;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.i;
import androidx.camera.core.impl.v;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.C5168Ie4;
import ir.nasim.GD0;
import ir.nasim.InterfaceC15221jD0;
import ir.nasim.InterfaceC18096o47;
import ir.nasim.KD0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ir.nasim.iB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C14601iB0 implements InterfaceC15221jD0 {
    private C5168Ie4 A;
    private final C19253q22 A0;
    private final C15248jG0 B;
    private final C18667p27 B0;
    private final h C0;
    private final InterfaceC18096o47.b D;
    private final Set G;
    private androidx.camera.core.impl.f H;
    final Object J;
    boolean Y;
    private final C21341tV1 Z;
    private final androidx.camera.core.impl.B a;
    private final C17585nD0 b;
    private final Executor c;
    private final ScheduledExecutorService d;
    volatile i e = i.INITIALIZED;
    private final PC3 f;
    private final HD0 g;
    private final PA0 h;
    private final j i;
    final C18749pB0 j;
    CameraDevice k;
    int l;
    InterfaceC13457gG0 m;
    final AtomicInteger n;
    AbstractC16967mA0.a o;
    final Map p;
    private int q;
    final e r;
    final f s;
    final MC0 t;
    final KD0 u;
    private final boolean v;
    private final boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    private final C19349qC0 z0;

    /* renamed from: ir.nasim.iB0$a */
    class a implements InterfaceC21808uA0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC21808uA0
        public CamcorderProfile a(int i, int i2) {
            return CamcorderProfile.get(i, i2);
        }

        @Override // ir.nasim.InterfaceC21808uA0
        public boolean b(int i, int i2) {
            return CamcorderProfile.hasProfile(i, i2);
        }
    }

    /* renamed from: ir.nasim.iB0$b */
    class b extends CameraDevice.StateCallback {
        final /* synthetic */ AbstractC16967mA0.a a;

        b(AbstractC16967mA0.a aVar) {
            this.a = aVar;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            C14601iB0.this.T("openCameraConfigAndClose camera closed");
            this.a.c(null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            C14601iB0.this.T("openCameraConfigAndClose camera disconnected");
            this.a.c(null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            C14601iB0.this.T("openCameraConfigAndClose camera error " + i);
            this.a.c(null);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(final CameraDevice cameraDevice) {
            C14601iB0.this.T("openCameraConfigAndClose camera opened");
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3Q = C14601iB0.this.Q(cameraDevice);
            Objects.requireNonNull(cameraDevice);
            interfaceFutureC15215jC3Q.j(new Runnable() { // from class: ir.nasim.jB0
                @Override // java.lang.Runnable
                public final void run() {
                    cameraDevice.close();
                }
            }, C14601iB0.this.c);
        }
    }

    /* renamed from: ir.nasim.iB0$d */
    class d implements MB2 {
        final /* synthetic */ InterfaceC13457gG0 a;

        d(InterfaceC13457gG0 interfaceC13457gG0) {
            this.a = interfaceC13457gG0;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) throws Throwable {
            if (C14601iB0.this.t.c() == 2 && C14601iB0.this.e == i.OPENED) {
                C14601iB0.this.G0(i.CONFIGURED);
            }
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) throws Throwable {
            if (th instanceof DeferrableSurface.SurfaceClosedException) {
                androidx.camera.core.impl.v vVarV = C14601iB0.this.V(((DeferrableSurface.SurfaceClosedException) th).a());
                if (vVarV != null) {
                    C14601iB0.this.B0(vVarV);
                    return;
                }
                return;
            }
            if (th instanceof CancellationException) {
                C14601iB0.this.T("Unable to configure camera cancelled");
                return;
            }
            i iVar = C14601iB0.this.e;
            i iVar2 = i.OPENED;
            if (iVar == iVar2) {
                C14601iB0.this.H0(iVar2, GD0.a.b(4, th));
            }
            PI3.d("Camera2CameraImpl", "Unable to configure camera " + C14601iB0.this, th);
            C14601iB0 c14601iB0 = C14601iB0.this;
            if (c14601iB0.m == this.a) {
                c14601iB0.E0(false);
            }
        }
    }

    /* renamed from: ir.nasim.iB0$e */
    final class e extends CameraManager.AvailabilityCallback implements KD0.c {
        private final String a;
        private boolean b = true;

        e(String str) {
            this.a = str;
        }

        @Override // ir.nasim.KD0.c
        public void a() throws Throwable {
            if (C14601iB0.this.e == i.PENDING_OPEN) {
                C14601iB0.this.P0(false);
            }
        }

        boolean b() {
            return this.b;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String str) throws Throwable {
            if (this.a.equals(str)) {
                this.b = true;
                if (C14601iB0.this.e == i.PENDING_OPEN) {
                    C14601iB0.this.P0(false);
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String str) {
            if (this.a.equals(str)) {
                this.b = false;
            }
        }
    }

    /* renamed from: ir.nasim.iB0$f */
    final class f implements KD0.b {
        f() {
        }

        @Override // ir.nasim.KD0.b
        public void a() {
            if (C14601iB0.this.e == i.OPENED) {
                C14601iB0.this.z0();
            }
        }
    }

    /* renamed from: ir.nasim.iB0$g */
    final class g implements CameraControlInternal.b {
        g() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.b
        public void a() {
            C14601iB0.this.Q0();
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.b
        public void b(List list) {
            C14601iB0.this.J0((List) AbstractC4980Hj5.g(list));
        }
    }

    /* renamed from: ir.nasim.iB0$i */
    enum i {
        RELEASED,
        RELEASING,
        INITIALIZED,
        PENDING_OPEN,
        CLOSING,
        REOPENING_QUIRK,
        REOPENING,
        OPENING,
        OPENED,
        CONFIGURED
    }

    /* renamed from: ir.nasim.iB0$j */
    final class j extends CameraDevice.StateCallback {
        private final Executor a;
        private final ScheduledExecutorService b;
        private b c;
        ScheduledFuture d;
        private final a e;

        /* renamed from: ir.nasim.iB0$j$a */
        class a {
            private final long a;
            private long b = -1;

            a(long j) {
                this.a = j;
            }

            boolean a() {
                if (b() < d()) {
                    return true;
                }
                e();
                return false;
            }

            long b() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (this.b == -1) {
                    this.b = jUptimeMillis;
                }
                return jUptimeMillis - this.b;
            }

            int c() {
                if (!j.this.f()) {
                    return 700;
                }
                long jB = b();
                return jB <= 120000 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : jB <= 300000 ? 2000 : 4000;
            }

            int d() {
                if (!j.this.f()) {
                    long j = this.a;
                    return j > 0 ? Math.min((int) j, AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND) : AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
                }
                long j2 = this.a;
                if (j2 > 0) {
                    return Math.min((int) j2, 1800000);
                }
                return 1800000;
            }

            void e() {
                this.b = -1L;
            }
        }

        /* renamed from: ir.nasim.iB0$j$b */
        class b implements Runnable {
            private Executor a;
            private boolean b = false;

            b(Executor executor) {
                this.a = executor;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c() throws Throwable {
                if (this.b) {
                    return;
                }
                AbstractC4980Hj5.i(C14601iB0.this.e == i.REOPENING || C14601iB0.this.e == i.REOPENING_QUIRK);
                if (j.this.f()) {
                    C14601iB0.this.O0(true);
                } else {
                    C14601iB0.this.P0(true);
                }
            }

            void b() {
                this.b = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.execute(new Runnable() { // from class: ir.nasim.mB0
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.a.c();
                    }
                });
            }
        }

        j(Executor executor, ScheduledExecutorService scheduledExecutorService, long j) {
            this.a = executor;
            this.b = scheduledExecutorService;
            this.e = new a(j);
        }

        private void b(CameraDevice cameraDevice, int i) throws Throwable {
            AbstractC4980Hj5.j(C14601iB0.this.e == i.OPENING || C14601iB0.this.e == i.OPENED || C14601iB0.this.e == i.CONFIGURED || C14601iB0.this.e == i.REOPENING || C14601iB0.this.e == i.REOPENING_QUIRK, "Attempt to handle open error from non open state: " + C14601iB0.this.e);
            if (i == 1 || i == 2 || i == 4) {
                PI3.a("Camera2CameraImpl", String.format("Attempt to reopen camera[%s] after error[%s]", cameraDevice.getId(), C14601iB0.Z(i)));
                c(i);
                return;
            }
            PI3.c("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + C14601iB0.Z(i) + " closing camera.");
            C14601iB0.this.H0(i.CLOSING, GD0.a.a(i == 3 ? 5 : 6));
            C14601iB0.this.O(false);
        }

        private void c(int i) throws Throwable {
            int i2 = 1;
            AbstractC4980Hj5.j(C14601iB0.this.l != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i == 1) {
                i2 = 2;
            } else if (i != 2) {
                i2 = 3;
            }
            C14601iB0.this.H0(i.REOPENING, GD0.a.a(i2));
            C14601iB0.this.O(false);
        }

        boolean a() {
            if (this.d == null) {
                return false;
            }
            C14601iB0.this.T("Cancelling scheduled re-open: " + this.c);
            this.c.b();
            this.c = null;
            this.d.cancel(false);
            this.d = null;
            return true;
        }

        void d() {
            this.e.e();
        }

        void e() throws Throwable {
            AbstractC4980Hj5.i(this.c == null);
            AbstractC4980Hj5.i(this.d == null);
            if (!this.e.a()) {
                PI3.c("Camera2CameraImpl", "Camera reopening attempted for " + this.e.d() + "ms without success.");
                C14601iB0.this.I0(i.PENDING_OPEN, null, false);
                return;
            }
            this.c = new b(this.a);
            C14601iB0.this.T("Attempting camera re-open in " + this.e.c() + "ms: " + this.c + " activeResuming = " + C14601iB0.this.Y);
            this.d = this.b.schedule(this.c, (long) this.e.c(), TimeUnit.MILLISECONDS);
        }

        boolean f() {
            int i;
            C14601iB0 c14601iB0 = C14601iB0.this;
            return c14601iB0.Y && ((i = c14601iB0.l) == 1 || i == 2);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) throws Throwable {
            C14601iB0.this.T("CameraDevice.onClosed()");
            AbstractC4980Hj5.j(C14601iB0.this.k == null, "Unexpected onClose callback on camera device: " + cameraDevice);
            int iOrdinal = C14601iB0.this.e.ordinal();
            if (iOrdinal == 1 || iOrdinal == 4) {
                AbstractC4980Hj5.i(C14601iB0.this.d0());
                C14601iB0.this.R();
                return;
            }
            if (iOrdinal != 5 && iOrdinal != 6) {
                throw new IllegalStateException("Camera closed while in state: " + C14601iB0.this.e);
            }
            C14601iB0 c14601iB0 = C14601iB0.this;
            if (c14601iB0.l == 0) {
                c14601iB0.P0(false);
                return;
            }
            c14601iB0.T("Camera closed due to error: " + C14601iB0.Z(C14601iB0.this.l));
            e();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) throws Throwable {
            C14601iB0.this.T("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) throws Throwable {
            C14601iB0 c14601iB0 = C14601iB0.this;
            c14601iB0.k = cameraDevice;
            c14601iB0.l = i;
            c14601iB0.C0.b();
            int iOrdinal = C14601iB0.this.e.ordinal();
            if (iOrdinal != 1) {
                switch (iOrdinal) {
                    case 4:
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        PI3.a("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", cameraDevice.getId(), C14601iB0.Z(i), C14601iB0.this.e.name()));
                        b(cameraDevice, i);
                        return;
                    default:
                        throw new IllegalStateException("onError() should not be possible from state: " + C14601iB0.this.e);
                }
            }
            PI3.c("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", cameraDevice.getId(), C14601iB0.Z(i), C14601iB0.this.e.name()));
            C14601iB0.this.O(false);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) throws Throwable {
            C14601iB0.this.T("CameraDevice.onOpened()");
            C14601iB0 c14601iB0 = C14601iB0.this;
            c14601iB0.k = cameraDevice;
            c14601iB0.l = 0;
            d();
            int iOrdinal = C14601iB0.this.e.ordinal();
            if (iOrdinal == 1 || iOrdinal == 4) {
                AbstractC4980Hj5.i(C14601iB0.this.d0());
                C14601iB0.this.k.close();
                C14601iB0.this.k = null;
            } else {
                if (iOrdinal != 5 && iOrdinal != 6 && iOrdinal != 7) {
                    throw new IllegalStateException("onOpened() should not be possible from state: " + C14601iB0.this.e);
                }
                C14601iB0.this.G0(i.OPENED);
                KD0 kd0 = C14601iB0.this.u;
                String id = cameraDevice.getId();
                C14601iB0 c14601iB02 = C14601iB0.this;
                if (kd0.j(id, c14601iB02.t.b(c14601iB02.k.getId()))) {
                    C14601iB0.this.z0();
                }
            }
        }
    }

    /* renamed from: ir.nasim.iB0$k */
    static abstract class k {
        k() {
        }

        static k a(String str, Class cls, androidx.camera.core.impl.v vVar, androidx.camera.core.impl.C c, Size size, androidx.camera.core.impl.w wVar, List list) {
            return new SS(str, cls, vVar, c, size, wVar, list);
        }

        static k b(AbstractC15273jI7 abstractC15273jI7, boolean z) {
            return a(C14601iB0.b0(abstractC15273jI7), abstractC15273jI7.getClass(), z ? abstractC15273jI7.v() : abstractC15273jI7.t(), abstractC15273jI7.i(), abstractC15273jI7.e(), abstractC15273jI7.d(), C14601iB0.Y(abstractC15273jI7));
        }

        abstract List c();

        abstract androidx.camera.core.impl.v d();

        abstract androidx.camera.core.impl.w e();

        abstract Size f();

        abstract androidx.camera.core.impl.C g();

        abstract String h();

        abstract Class i();
    }

    C14601iB0(Context context, C17585nD0 c17585nD0, String str, C18749pB0 c18749pB0, MC0 mc0, KD0 kd0, Executor executor, Handler handler, C21341tV1 c21341tV1, long j2) throws CameraUnavailableException {
        PC3 pc3 = new PC3();
        this.f = pc3;
        this.l = 0;
        this.n = new AtomicInteger(0);
        this.p = new LinkedHashMap();
        this.q = 0;
        this.x = false;
        this.y = false;
        this.z = true;
        this.G = new HashSet();
        this.H = AbstractC21826uC0.a();
        this.J = new Object();
        this.Y = false;
        this.C0 = new h(this, null);
        this.b = c17585nD0;
        this.t = mc0;
        this.u = kd0;
        ScheduledExecutorService scheduledExecutorServiceD = AbstractC20567sE0.d(handler);
        this.d = scheduledExecutorServiceD;
        Executor executorE = AbstractC20567sE0.e(executor);
        this.c = executorE;
        this.i = new j(executorE, scheduledExecutorServiceD, j2);
        this.a = new androidx.camera.core.impl.B(str);
        pc3.g(InterfaceC15221jD0.a.CLOSED);
        HD0 hd0 = new HD0(kd0);
        this.g = hd0;
        C15248jG0 c15248jG0 = new C15248jG0(executorE);
        this.B = c15248jG0;
        this.Z = c21341tV1;
        try {
            C19349qC0 c19349qC0C = c17585nD0.c(str);
            this.z0 = c19349qC0C;
            PA0 pa0 = new PA0(c19349qC0C, scheduledExecutorServiceD, executorE, new g(), c18749pB0.g());
            this.h = pa0;
            this.j = c18749pB0;
            c18749pB0.p(pa0);
            c18749pB0.s(hd0.a());
            this.A0 = C19253q22.a(c19349qC0C);
            this.m = u0();
            this.D = new InterfaceC18096o47.b(executorE, scheduledExecutorServiceD, handler, c15248jG0, c18749pB0.g(), androidx.camera.camera2.internal.compat.quirk.b.c());
            this.v = c18749pB0.g().a(LegacyCameraOutputConfigNullPointerQuirk.class);
            this.w = c18749pB0.g().a(LegacyCameraSurfaceCleanupQuirk.class);
            e eVar = new e(str);
            this.r = eVar;
            f fVar = new f();
            this.s = fVar;
            kd0.g(this, executorE, fVar, eVar);
            c17585nD0.g(executorE, eVar);
            this.B0 = new C18667p27(context, str, c17585nD0, new a());
        } catch (CameraAccessExceptionCompat e2) {
            throw MD0.a(e2);
        }
    }

    private void A0() throws Throwable {
        int iOrdinal = this.e.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            O0(false);
            return;
        }
        if (iOrdinal != 4) {
            T("open() ignored due to being in state: " + this.e);
            return;
        }
        G0(i.REOPENING);
        if (d0() || this.y || this.l != 0) {
            return;
        }
        AbstractC4980Hj5.j(this.k != null, "Camera Device should be open if session close is not complete");
        G0(i.OPENED);
        z0();
    }

    private void D0() {
        if (this.A != null) {
            this.a.w(this.A.f() + this.A.hashCode());
            this.a.x(this.A.f() + this.A.hashCode());
            this.A.c();
            this.A = null;
        }
    }

    private void F0(final String str, final androidx.camera.core.impl.v vVar, final androidx.camera.core.impl.C c2, final androidx.camera.core.impl.w wVar, final List list) {
        this.c.execute(new Runnable() { // from class: ir.nasim.fB0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.s0(str, vVar, c2, wVar, list);
            }
        });
    }

    private Collection K0(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(k.b((AbstractC15273jI7) it.next(), this.z));
        }
        return arrayList;
    }

    private void L() {
        C5168Ie4 c5168Ie4 = this.A;
        if (c5168Ie4 != null) {
            String strA0 = a0(c5168Ie4);
            androidx.camera.core.impl.B b2 = this.a;
            androidx.camera.core.impl.v vVarH = this.A.h();
            androidx.camera.core.impl.C cI = this.A.i();
            D.b bVar = D.b.METERING_REPEATING;
            b2.v(strA0, vVarH, cI, null, Collections.singletonList(bVar));
            this.a.u(strA0, this.A.h(), this.A.i(), null, Collections.singletonList(bVar));
        }
    }

    private void M() {
        androidx.camera.core.impl.v vVarC = this.a.g().c();
        androidx.camera.core.impl.i iVarJ = vVarC.j();
        int size = iVarJ.i().size();
        int size2 = vVarC.n().size();
        if (vVarC.n().isEmpty()) {
            return;
        }
        if (iVarJ.i().isEmpty()) {
            if (this.A == null) {
                this.A = new C5168Ie4(this.j.m(), this.Z, new C5168Ie4.c() { // from class: ir.nasim.UA0
                    @Override // ir.nasim.C5168Ie4.c
                    public final void a() {
                        this.a.f0();
                    }
                });
            }
            if (e0()) {
                L();
                return;
            } else {
                PI3.c("Camera2CameraImpl", "Failed to add a repeating surface, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly.");
                return;
            }
        }
        if (size2 == 1 && size == 1) {
            D0();
            return;
        }
        if (size >= 2) {
            D0();
            return;
        }
        if (this.A != null && !e0()) {
            D0();
            return;
        }
        PI3.a("Camera2CameraImpl", "No need to remove a previous mMeteringRepeating, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
    }

    private void M0(Collection collection) throws Throwable {
        Size sizeF;
        boolean zIsEmpty = this.a.h().isEmpty();
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        Rational rational = null;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (!this.a.o(kVar.h())) {
                this.a.v(kVar.h(), kVar.d(), kVar.g(), kVar.e(), kVar.c());
                arrayList.add(kVar.h());
                if (kVar.i() == C8112Uo5.class && (sizeF = kVar.f()) != null) {
                    rational = new Rational(sizeF.getWidth(), sizeF.getHeight());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        T("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
        if (zIsEmpty) {
            this.h.R(true);
            this.h.C();
        }
        M();
        R0();
        Q0();
        E0(false);
        if (this.e == i.OPENED) {
            z0();
        } else {
            A0();
        }
        if (rational != null) {
            this.h.S(rational);
        }
    }

    private boolean N(i.a aVar) {
        if (!aVar.l().isEmpty()) {
            PI3.l("Camera2CameraImpl", "The capture config builder already has surface inside.");
            return false;
        }
        Iterator it = this.a.f().iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.i iVarJ = ((androidx.camera.core.impl.v) it.next()).j();
            List listI = iVarJ.i();
            if (!listI.isEmpty()) {
                if (iVarJ.h() != 0) {
                    aVar.q(iVarJ.h());
                }
                if (iVarJ.l() != 0) {
                    aVar.t(iVarJ.l());
                }
                Iterator it2 = listI.iterator();
                while (it2.hasNext()) {
                    aVar.f((DeferrableSurface) it2.next());
                }
            }
        }
        if (!aVar.l().isEmpty()) {
            return true;
        }
        PI3.l("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void k0(Collection collection) throws Throwable {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (this.a.o(kVar.h())) {
                this.a.t(kVar.h());
                arrayList.add(kVar.h());
                if (kVar.i() == C8112Uo5.class) {
                    z = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        T("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
        if (z) {
            this.h.S(null);
        }
        M();
        if (this.a.i().isEmpty()) {
            this.h.U(false);
        } else {
            R0();
        }
        if (this.a.h().isEmpty()) {
            this.h.r();
            E0(false);
            this.h.R(false);
            this.m = u0();
            P();
            return;
        }
        Q0();
        E0(false);
        if (this.e == i.OPENED) {
            z0();
        }
    }

    private void P() throws Throwable {
        T("Closing camera.");
        switch (this.e.ordinal()) {
            case 3:
                AbstractC4980Hj5.i(this.k == null);
                G0(i.INITIALIZED);
                break;
            case 4:
            default:
                T("close() ignored due to being in state: " + this.e);
                break;
            case 5:
            case 6:
            case 7:
                if (!this.i.a() && !this.C0.c()) {
                    z = false;
                }
                this.C0.a();
                G0(i.CLOSING);
                if (z) {
                    AbstractC4980Hj5.i(d0());
                    R();
                    break;
                }
                break;
            case 8:
            case 9:
                G0(i.CLOSING);
                O(false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceFutureC15215jC3 Q(CameraDevice cameraDevice) {
        final C12839fG0 c12839fG0 = new C12839fG0(this.A0);
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        final Surface surface = new Surface(surfaceTexture);
        final W33 w33 = new W33(surface);
        w33.k().j(new Runnable() { // from class: ir.nasim.WA0
            @Override // java.lang.Runnable
            public final void run() {
                C14601iB0.h0(surface, surfaceTexture);
            }
        }, AbstractC20567sE0.a());
        v.b bVar = new v.b();
        bVar.h(w33);
        bVar.w(1);
        T("Start configAndClose.");
        return NB2.a(WB2.A(c12839fG0.h(bVar.o(), cameraDevice, this.D.a()))).e(new FK() { // from class: ir.nasim.XA0
            @Override // ir.nasim.FK
            public final InterfaceFutureC15215jC3 apply(Object obj) {
                return C14601iB0.i0(c12839fG0, w33, (Void) obj);
            }
        }, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() throws Throwable {
        AbstractC4980Hj5.i(this.e == i.RELEASING || this.e == i.CLOSING);
        AbstractC4980Hj5.i(this.p.isEmpty());
        if (!this.x) {
            W();
            return;
        }
        if (this.y) {
            T("Ignored since configAndClose is processing");
            return;
        }
        if (!this.r.b()) {
            this.x = false;
            W();
            T("Ignore configAndClose and finish the close flow directly since camera is unavailable.");
        } else {
            T("Open camera to configAndClose");
            InterfaceFutureC15215jC3 interfaceFutureC15215jC3X0 = x0();
            this.y = true;
            interfaceFutureC15215jC3X0.j(new Runnable() { // from class: ir.nasim.TA0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.a.j0();
                }
            }, this.c);
        }
    }

    private void R0() {
        Iterator it = this.a.i().iterator();
        boolean zK = false;
        while (it.hasNext()) {
            zK |= ((androidx.camera.core.impl.C) it.next()).K(false);
        }
        this.h.U(zK);
    }

    private CameraDevice.StateCallback S() {
        ArrayList arrayList = new ArrayList(this.a.g().c().c());
        arrayList.add(this.B.c());
        arrayList.add(this.i);
        return WC0.a(arrayList);
    }

    private void U(String str, Throwable th) {
        PI3.b("Camera2CameraImpl", String.format("{%s} %s", toString(), str), th);
    }

    private int X() {
        synchronized (this.J) {
            try {
                return this.t.c() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static List Y(AbstractC15273jI7 abstractC15273jI7) {
        if (abstractC15273jI7.f() == null) {
            return null;
        }
        return C12398eY6.e0(abstractC15273jI7);
    }

    static String Z(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    static String a0(C5168Ie4 c5168Ie4) {
        return c5168Ie4.f() + c5168Ie4.hashCode();
    }

    static String b0(AbstractC15273jI7 abstractC15273jI7) {
        return abstractC15273jI7.n() + abstractC15273jI7.hashCode();
    }

    private boolean e0() {
        ArrayList arrayList = new ArrayList();
        int iX = X();
        for (B.b bVar : this.a.j()) {
            if (bVar.c() == null || bVar.c().get(0) != D.b.METERING_REPEATING) {
                if (bVar.e() == null || bVar.c() == null) {
                    PI3.l("Camera2CameraImpl", "Invalid stream spec or capture types in " + bVar);
                    return false;
                }
                androidx.camera.core.impl.v vVarD = bVar.d();
                androidx.camera.core.impl.C cF = bVar.f();
                for (DeferrableSurface deferrableSurface : vVarD.n()) {
                    arrayList.add(AbstractC1920a.a(this.B0.M(iX, cF.getInputFormat(), deferrableSurface.h()), cF.getInputFormat(), deferrableSurface.h(), bVar.e().b(), bVar.c(), bVar.e().d(), cF.w(null)));
                }
            }
        }
        AbstractC4980Hj5.g(this.A);
        HashMap map = new HashMap();
        map.put(this.A.i(), Collections.singletonList(this.A.e()));
        try {
            this.B0.A(iX, arrayList, map, false, false);
            T("Surface combination with metering repeating supported!");
            return true;
        } catch (IllegalArgumentException e2) {
            U("Surface combination with metering repeating  not supported!", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        if (c0()) {
            F0(a0(this.A), this.A.h(), this.A.i(), null, Collections.singletonList(D.b.METERING_REPEATING));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(List list) {
        try {
            M0(list);
        } finally {
            this.h.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InterfaceFutureC15215jC3 i0(C12839fG0 c12839fG0, DeferrableSurface deferrableSurface, Void r2) {
        c12839fG0.close();
        deferrableSurface.d();
        return c12839fG0.d(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0() throws Throwable {
        this.y = false;
        this.x = false;
        T("OpenCameraConfigAndClose is done, state: " + this.e);
        int iOrdinal = this.e.ordinal();
        if (iOrdinal == 1 || iOrdinal == 4) {
            AbstractC4980Hj5.i(d0());
            W();
            return;
        }
        if (iOrdinal != 6) {
            T("OpenCameraConfigAndClose finished while in state: " + this.e);
            return;
        }
        if (this.l == 0) {
            P0(false);
            return;
        }
        T("OpenCameraConfigAndClose in error: " + Z(this.l));
        this.i.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(AbstractC16967mA0.a aVar) {
        C5168Ie4 c5168Ie4 = this.A;
        if (c5168Ie4 == null) {
            aVar.c(Boolean.FALSE);
        } else {
            aVar.c(Boolean.valueOf(this.a.o(a0(c5168Ie4))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object m0(final AbstractC16967mA0.a aVar) {
        try {
            this.c.execute(new Runnable() { // from class: ir.nasim.YA0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l0(aVar);
                }
            });
            return "isMeteringRepeatingAttached";
        } catch (RejectedExecutionException unused) {
            aVar.f(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
            return "isMeteringRepeatingAttached";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(String str, androidx.camera.core.impl.v vVar, androidx.camera.core.impl.C c2, androidx.camera.core.impl.w wVar, List list) {
        T("Use case " + str + " ACTIVE");
        this.a.u(str, vVar, c2, wVar, list);
        this.a.y(str, vVar, c2, wVar, list);
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(String str) {
        T("Use case " + str + " INACTIVE");
        this.a.x(str);
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(String str, androidx.camera.core.impl.v vVar, androidx.camera.core.impl.C c2, androidx.camera.core.impl.w wVar, List list) {
        T("Use case " + str + " UPDATED");
        this.a.y(str, vVar, c2, wVar, list);
        Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q0(AbstractC16967mA0.a aVar) {
        try {
            ArrayList arrayList = new ArrayList(this.a.g().c().c());
            arrayList.add(this.B.c());
            arrayList.add(new b(aVar));
            this.b.f(this.j.b(), this.c, WC0.a(arrayList));
            return "configAndCloseTask";
        } catch (CameraAccessExceptionCompat | SecurityException e2) {
            U("Unable to open camera for configAndClose: " + e2.getMessage(), e2);
            aVar.f(e2);
            return "configAndCloseTask";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(v.d dVar, androidx.camera.core.impl.v vVar) {
        dVar.a(vVar, v.g.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(String str, androidx.camera.core.impl.v vVar, androidx.camera.core.impl.C c2, androidx.camera.core.impl.w wVar, List list) throws Throwable {
        T("Use case " + str + " RESET");
        this.a.y(str, vVar, c2, wVar, list);
        M();
        E0(false);
        Q0();
        if (this.e == i.OPENED) {
            z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(boolean z) throws Throwable {
        this.Y = z;
        if (z && this.e == i.PENDING_OPEN) {
            O0(false);
        }
    }

    private InterfaceC13457gG0 u0() {
        C12839fG0 c12839fG0;
        synchronized (this.J) {
            c12839fG0 = new C12839fG0(this.A0, this.j.g());
        }
        return c12839fG0;
    }

    private void v0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            String strB0 = b0(abstractC15273jI7);
            if (!this.G.contains(strB0)) {
                this.G.add(strB0);
                abstractC15273jI7.K();
                abstractC15273jI7.I();
            }
        }
    }

    private void w0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC15273jI7 abstractC15273jI7 = (AbstractC15273jI7) it.next();
            String strB0 = b0(abstractC15273jI7);
            if (this.G.contains(strB0)) {
                abstractC15273jI7.L();
                this.G.remove(strB0);
            }
        }
    }

    private InterfaceFutureC15215jC3 x0() {
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.hB0
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.q0(aVar);
            }
        });
    }

    private void y0(boolean z) throws Throwable {
        if (!z) {
            this.i.d();
        }
        this.i.a();
        this.C0.a();
        T("Opening camera.");
        G0(i.OPENING);
        try {
            this.b.f(this.j.b(), this.c, S());
        } catch (CameraAccessExceptionCompat e2) {
            T("Unable to open camera due to " + e2.getMessage());
            if (e2.d() != 10001) {
                this.C0.d();
            } else {
                H0(i.INITIALIZED, GD0.a.b(7, e2));
            }
        } catch (SecurityException e3) {
            T("Unable to open camera due to " + e3.getMessage());
            G0(i.REOPENING);
            this.i.e();
        }
    }

    void B0(final androidx.camera.core.impl.v vVar) {
        ScheduledExecutorService scheduledExecutorServiceC = AbstractC20567sE0.c();
        final v.d dVarD = vVar.d();
        if (dVarD != null) {
            U("Posting surface closed", new Throwable());
            scheduledExecutorServiceC.execute(new Runnable() { // from class: ir.nasim.dB0
                @Override // java.lang.Runnable
                public final void run() {
                    C14601iB0.r0(dVarD, vVar);
                }
            });
        }
    }

    InterfaceFutureC15215jC3 C0(InterfaceC13457gG0 interfaceC13457gG0, boolean z) {
        interfaceC13457gG0.close();
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3D = interfaceC13457gG0.d(z);
        T("Releasing session in state " + this.e.name());
        this.p.put(interfaceC13457gG0, interfaceFutureC15215jC3D);
        WB2.g(interfaceFutureC15215jC3D, new c(interfaceC13457gG0), AbstractC20567sE0.a());
        return interfaceFutureC15215jC3D;
    }

    void E0(boolean z) throws Throwable {
        AbstractC4980Hj5.i(this.m != null);
        T("Resetting Capture Session");
        InterfaceC13457gG0 interfaceC13457gG0 = this.m;
        androidx.camera.core.impl.v vVarF = interfaceC13457gG0.f();
        List listE = interfaceC13457gG0.e();
        InterfaceC13457gG0 interfaceC13457gG0U0 = u0();
        this.m = interfaceC13457gG0U0;
        interfaceC13457gG0U0.g(vVarF);
        this.m.a(listE);
        if (this.e.ordinal() != 8) {
            T("Skipping Capture Session state check due to current camera state: " + this.e + " and previous session status: " + interfaceC13457gG0.b());
        } else if (this.v && interfaceC13457gG0.b()) {
            T("Close camera before creating new session");
            G0(i.REOPENING_QUIRK);
        }
        if (this.w && interfaceC13457gG0.b()) {
            T("ConfigAndClose is required when close the camera.");
            this.x = true;
        }
        C0(interfaceC13457gG0, z);
    }

    void G0(i iVar) throws Throwable {
        H0(iVar, null);
    }

    void H0(i iVar, GD0.a aVar) throws Throwable {
        I0(iVar, aVar, true);
    }

    void I0(i iVar, GD0.a aVar, boolean z) throws Throwable {
        InterfaceC15221jD0.a aVar2;
        T("Transitioning camera internal state: " + this.e + " --> " + iVar);
        L0(iVar, aVar);
        this.e = iVar;
        switch (iVar) {
            case RELEASED:
                aVar2 = InterfaceC15221jD0.a.RELEASED;
                break;
            case RELEASING:
                aVar2 = InterfaceC15221jD0.a.RELEASING;
                break;
            case INITIALIZED:
                aVar2 = InterfaceC15221jD0.a.CLOSED;
                break;
            case PENDING_OPEN:
                aVar2 = InterfaceC15221jD0.a.PENDING_OPEN;
                break;
            case CLOSING:
            case REOPENING_QUIRK:
                aVar2 = InterfaceC15221jD0.a.CLOSING;
                break;
            case REOPENING:
            case OPENING:
                aVar2 = InterfaceC15221jD0.a.OPENING;
                break;
            case OPENED:
                aVar2 = InterfaceC15221jD0.a.OPEN;
                break;
            case CONFIGURED:
                aVar2 = InterfaceC15221jD0.a.CONFIGURED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + iVar);
        }
        this.u.e(this, aVar2, z);
        this.f.g(aVar2);
        this.g.c(aVar2, aVar);
    }

    void J0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.i iVar = (androidx.camera.core.impl.i) it.next();
            i.a aVarJ = i.a.j(iVar);
            if (iVar.k() == 5 && iVar.d() != null) {
                aVarJ.n(iVar.d());
            }
            if (!iVar.i().isEmpty() || !iVar.m() || N(aVarJ)) {
                arrayList.add(aVarJ.h());
            }
        }
        T("Issue capture request");
        this.m.a(arrayList);
    }

    void L0(i iVar, GD0.a aVar) throws Throwable {
        if (C16807lt7.d()) {
            C16807lt7.f("CX:C2State[" + this + "]", iVar.ordinal());
            if (aVar != null) {
                this.q++;
            }
            if (this.q > 0) {
                C16807lt7.f("CX:C2StateErrorCode[" + this + "]", aVar != null ? aVar.d() : 0);
            }
        }
    }

    void O(boolean z) throws Throwable {
        AbstractC4980Hj5.j(this.e == i.CLOSING || this.e == i.RELEASING || (this.e == i.REOPENING && this.l != 0), "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.e + " (error: " + Z(this.l) + Separators.RPAREN);
        E0(z);
        this.m.c();
    }

    void O0(boolean z) throws Throwable {
        T("Attempting to force open the camera.");
        if (this.u.i(this)) {
            y0(z);
        } else {
            T("No cameras available. Waiting for available camera before opening camera.");
            G0(i.PENDING_OPEN);
        }
    }

    void P0(boolean z) throws Throwable {
        T("Attempting to open the camera.");
        if (this.r.b() && this.u.i(this)) {
            y0(z);
        } else {
            T("No cameras available. Waiting for available camera before opening camera.");
            G0(i.PENDING_OPEN);
        }
    }

    void Q0() {
        v.h hVarE = this.a.e();
        if (!hVarE.e()) {
            this.h.Q();
            this.m.g(this.h.t());
            return;
        }
        this.h.T(hVarE.c().o());
        hVarE.b(this.h.t());
        this.m.g(hVarE.c());
    }

    void T(String str) {
        U(str, null);
    }

    androidx.camera.core.impl.v V(DeferrableSurface deferrableSurface) {
        for (androidx.camera.core.impl.v vVar : this.a.h()) {
            if (vVar.n().contains(deferrableSurface)) {
                return vVar;
            }
        }
        return null;
    }

    void W() throws Throwable {
        AbstractC4980Hj5.i(this.e == i.RELEASING || this.e == i.CLOSING);
        AbstractC4980Hj5.i(this.p.isEmpty());
        this.k = null;
        if (this.e == i.CLOSING) {
            G0(i.INITIALIZED);
            return;
        }
        this.b.h(this.r);
        G0(i.RELEASED);
        AbstractC16967mA0.a aVar = this.o;
        if (aVar != null) {
            aVar.c(null);
            this.o = null;
        }
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public CameraControlInternal b() {
        return this.h;
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void c(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC4980Hj5.g(abstractC15273jI7);
        final String strB0 = b0(abstractC15273jI7);
        this.c.execute(new Runnable() { // from class: ir.nasim.bB0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o0(strB0);
            }
        });
    }

    boolean c0() {
        try {
            return ((Boolean) AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.VA0
                @Override // ir.nasim.AbstractC16967mA0.c
                public final Object a(AbstractC16967mA0.a aVar) {
                    return this.a.m0(aVar);
                }
            }).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e2);
        }
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public androidx.camera.core.impl.f d() {
        return this.H;
    }

    boolean d0() {
        return this.p.isEmpty();
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void e(final boolean z) {
        this.c.execute(new Runnable() { // from class: ir.nasim.gB0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.t0(z);
            }
        });
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void f(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC4980Hj5.g(abstractC15273jI7);
        F0(b0(abstractC15273jI7), this.z ? abstractC15273jI7.v() : abstractC15273jI7.t(), abstractC15273jI7.i(), abstractC15273jI7.d(), Y(abstractC15273jI7));
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void g(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC4980Hj5.g(abstractC15273jI7);
        final String strB0 = b0(abstractC15273jI7);
        final androidx.camera.core.impl.v vVarV = this.z ? abstractC15273jI7.v() : abstractC15273jI7.t();
        final androidx.camera.core.impl.C cI = abstractC15273jI7.i();
        final androidx.camera.core.impl.w wVarD = abstractC15273jI7.d();
        final List listY = Y(abstractC15273jI7);
        this.c.execute(new Runnable() { // from class: ir.nasim.aB0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.p0(strB0, vVarV, cI, wVarD, listY);
            }
        });
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void h(Collection collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        this.h.C();
        v0(new ArrayList(arrayList));
        final ArrayList arrayList2 = new ArrayList(K0(arrayList));
        try {
            this.c.execute(new Runnable() { // from class: ir.nasim.ZA0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g0(arrayList2);
                }
            });
        } catch (RejectedExecutionException e2) {
            U("Unable to attach use cases.", e2);
            this.h.r();
        }
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void i(Collection collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList(K0(arrayList));
        w0(new ArrayList(arrayList));
        this.c.execute(new Runnable() { // from class: ir.nasim.eB0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.a.k0(arrayList2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public InterfaceC14623iD0 j() {
        return this.j;
    }

    @Override // ir.nasim.AbstractC15273jI7.b
    public void k(AbstractC15273jI7 abstractC15273jI7) {
        AbstractC4980Hj5.g(abstractC15273jI7);
        final String strB0 = b0(abstractC15273jI7);
        final androidx.camera.core.impl.v vVarV = this.z ? abstractC15273jI7.v() : abstractC15273jI7.t();
        final androidx.camera.core.impl.C cI = abstractC15273jI7.i();
        final androidx.camera.core.impl.w wVarD = abstractC15273jI7.d();
        final List listY = Y(abstractC15273jI7);
        this.c.execute(new Runnable() { // from class: ir.nasim.cB0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n0(strB0, vVarV, cI, wVarD, listY);
            }
        });
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void n(androidx.camera.core.impl.f fVar) {
        if (fVar == null) {
            fVar = AbstractC21826uC0.a();
        }
        fVar.E(null);
        this.H = fVar;
        synchronized (this.J) {
        }
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public HG4 o() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC15221jD0
    public void q(boolean z) {
        this.z = z;
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.j.b());
    }

    void z0() {
        AbstractC4980Hj5.i(this.e == i.OPENED);
        v.h hVarG = this.a.g();
        if (!hVarG.e()) {
            T("Unable to create capture session due to conflicting configurations");
            return;
        }
        if (!this.u.j(this.k.getId(), this.t.b(this.k.getId()))) {
            T("Unable to create capture session in camera operating mode = " + this.t.c());
            return;
        }
        HashMap map = new HashMap();
        AbstractC14827iY6.m(this.a.h(), this.a.i(), map);
        this.m.i(map);
        InterfaceC13457gG0 interfaceC13457gG0 = this.m;
        WB2.g(interfaceC13457gG0.h(hVarG.c(), (CameraDevice) AbstractC4980Hj5.g(this.k), this.D.a()), new d(interfaceC13457gG0), this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ir.nasim.iB0$h */
    class h {
        private a a;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ir.nasim.iB0$h$a */
        class a {
            private final ScheduledFuture a;
            private final AtomicBoolean b = new AtomicBoolean(false);

            a() {
                this.a = C14601iB0.this.d.schedule(new Runnable() { // from class: ir.nasim.kB0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d();
                    }
                }, 2000L, TimeUnit.MILLISECONDS);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void d() {
                if (this.b.getAndSet(true)) {
                    return;
                }
                C14601iB0.this.c.execute(new Runnable() { // from class: ir.nasim.lB0
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.a.e();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void e() throws Throwable {
                if (C14601iB0.this.e == i.OPENING) {
                    C14601iB0.this.T("Camera onError timeout, reopen it.");
                    C14601iB0.this.G0(i.REOPENING);
                    C14601iB0.this.i.e();
                } else {
                    C14601iB0.this.T("Camera skip reopen at state: " + C14601iB0.this.e);
                }
            }

            public void c() {
                this.b.set(true);
                this.a.cancel(true);
            }

            public boolean f() {
                return this.b.get();
            }
        }

        private h() {
            this.a = null;
        }

        public void a() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.c();
            }
            this.a = null;
        }

        public void b() {
            C14601iB0.this.T("Camera receive onErrorCallback");
            a();
        }

        public boolean c() {
            a aVar = this.a;
            return (aVar == null || aVar.f()) ? false : true;
        }

        public void d() {
            if (C14601iB0.this.e != i.OPENING) {
                C14601iB0.this.T("Don't need the onError timeout handler.");
                return;
            }
            C14601iB0.this.T("Camera waiting for onError.");
            a();
            this.a = new a();
        }

        /* synthetic */ h(C14601iB0 c14601iB0, a aVar) {
            this();
        }
    }

    /* renamed from: ir.nasim.iB0$c */
    class c implements MB2 {
        final /* synthetic */ InterfaceC13457gG0 a;

        c(InterfaceC13457gG0 interfaceC13457gG0) {
            this.a = interfaceC13457gG0;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            C14601iB0.this.p.remove(this.a);
            int iOrdinal = C14601iB0.this.e.ordinal();
            if (iOrdinal != 1 && iOrdinal != 4) {
                if (iOrdinal != 5 && (iOrdinal != 6 || C14601iB0.this.l == 0)) {
                    return;
                } else {
                    C14601iB0.this.T("Camera reopen required. Checking if the current camera can be closed safely.");
                }
            }
            if (C14601iB0.this.d0()) {
                C14601iB0 c14601iB0 = C14601iB0.this;
                if (c14601iB0.k != null) {
                    c14601iB0.T("closing camera");
                    AbstractC8646Ww.a(C14601iB0.this.k);
                    C14601iB0.this.k = null;
                }
            }
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
        }
    }
}
