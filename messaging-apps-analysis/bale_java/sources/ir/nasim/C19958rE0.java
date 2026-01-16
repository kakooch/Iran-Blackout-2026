package ir.nasim;

import android.os.Handler;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.j;
import ir.nasim.InterfaceC11560dD0;
import ir.nasim.XC0;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.rE0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19958rE0 implements InterfaceC24505yj7 {
    static final j.a I = j.a.a("camerax.core.appConfig.cameraFactoryProvider", InterfaceC11560dD0.a.class);
    static final j.a J = j.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", XC0.a.class);
    static final j.a K = j.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", D.c.class);
    static final j.a L = j.a.a("camerax.core.appConfig.cameraExecutor", Executor.class);
    static final j.a M = j.a.a("camerax.core.appConfig.schedulerHandler", Handler.class);
    static final j.a N = j.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
    static final j.a O = j.a.a("camerax.core.appConfig.availableCamerasLimiter", ED0.class);
    static final j.a P = j.a.a("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE);
    static final j.a Q = j.a.a("camerax.core.appConfig.cameraProviderInitRetryPolicy", InterfaceC21050t16.class);
    static final j.a R = j.a.a("camerax.core.appConfig.quirksSettings", androidx.camera.core.impl.t.class);
    private final androidx.camera.core.impl.r H;

    /* renamed from: ir.nasim.rE0$a */
    public static final class a {
        private final androidx.camera.core.impl.q a;

        public a() {
            this(androidx.camera.core.impl.q.Z());
        }

        private androidx.camera.core.impl.p b() {
            return this.a;
        }

        public C19958rE0 a() {
            return new C19958rE0(androidx.camera.core.impl.r.X(this.a));
        }

        public a c(InterfaceC11560dD0.a aVar) {
            b().p(C19958rE0.I, aVar);
            return this;
        }

        public a d(XC0.a aVar) {
            b().p(C19958rE0.J, aVar);
            return this;
        }

        public a e(Class cls) {
            b().p(InterfaceC24505yj7.G, cls);
            if (b().g(InterfaceC24505yj7.F, null) == null) {
                f(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public a f(String str) {
            b().p(InterfaceC24505yj7.F, str);
            return this;
        }

        public a g(D.c cVar) {
            b().p(C19958rE0.K, cVar);
            return this;
        }

        private a(androidx.camera.core.impl.q qVar) {
            this.a = qVar;
            Class cls = (Class) qVar.g(InterfaceC24505yj7.G, null);
            if (cls == null || cls.equals(C19367qE0.class)) {
                e(C19367qE0.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    /* renamed from: ir.nasim.rE0$b */
    public interface b {
        C19958rE0 getCameraXConfig();
    }

    C19958rE0(androidx.camera.core.impl.r rVar) {
        this.H = rVar;
    }

    public ED0 V(ED0 ed0) {
        return (ED0) this.H.g(O, ed0);
    }

    public Executor W(Executor executor) {
        return (Executor) this.H.g(L, executor);
    }

    public InterfaceC11560dD0.a X(InterfaceC11560dD0.a aVar) {
        return (InterfaceC11560dD0.a) this.H.g(I, aVar);
    }

    public long Y() {
        return ((Long) this.H.g(P, -1L)).longValue();
    }

    public InterfaceC21050t16 Z() {
        InterfaceC21050t16 interfaceC21050t16 = (InterfaceC21050t16) this.H.g(Q, InterfaceC21050t16.b);
        Objects.requireNonNull(interfaceC21050t16);
        return interfaceC21050t16;
    }

    public XC0.a a0(XC0.a aVar) {
        return (XC0.a) this.H.g(J, aVar);
    }

    public androidx.camera.core.impl.t b0() {
        return (androidx.camera.core.impl.t) this.H.g(R, null);
    }

    public Handler c0(Handler handler) {
        return (Handler) this.H.g(M, handler);
    }

    public D.c d0(D.c cVar) {
        return (D.c) this.H.g(K, cVar);
    }

    @Override // androidx.camera.core.impl.u
    public androidx.camera.core.impl.j getConfig() {
        return this.H;
    }
}
