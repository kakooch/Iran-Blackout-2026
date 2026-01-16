package ir.nasim;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.nD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17585nD0 {
    private final b a;
    private final Map b = new ArrayMap(4);

    /* renamed from: ir.nasim.nD0$a */
    static final class a extends CameraManager.AvailabilityCallback {
        private final Executor a;
        final CameraManager.AvailabilityCallback b;
        private final Object c = new Object();
        private boolean d = false;

        a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
            this.a = executor;
            this.b = availabilityCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            AbstractC11404cx.a(this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(String str) {
            this.b.onCameraAvailable(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str) {
            this.b.onCameraUnavailable(str);
        }

        void g() {
            synchronized (this.c) {
                this.d = true;
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.c) {
                try {
                    if (!this.d) {
                        this.a.execute(new Runnable() { // from class: ir.nasim.lD0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.d();
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(final String str) {
            synchronized (this.c) {
                try {
                    if (!this.d) {
                        this.a.execute(new Runnable() { // from class: ir.nasim.kD0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.e(str);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(final String str) {
            synchronized (this.c) {
                try {
                    if (!this.d) {
                        this.a.execute(new Runnable() { // from class: ir.nasim.mD0
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.f(str);
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: ir.nasim.nD0$b */
    public interface b {
        static b g(Context context, Handler handler) {
            int i = Build.VERSION.SDK_INT;
            return i >= 30 ? new C19358qD0(context) : i >= 29 ? new C18767pD0(context) : i >= 28 ? C18176oD0.i(context) : C19949rD0.h(context, handler);
        }

        void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback);

        CameraCharacteristics b(String str);

        Set c();

        void d(String str, Executor executor, CameraDevice.StateCallback stateCallback);

        String[] e();

        void f(CameraManager.AvailabilityCallback availabilityCallback);
    }

    private C17585nD0(b bVar) {
        this.a = bVar;
    }

    public static C17585nD0 a(Context context) {
        return b(context, AbstractC11653dN3.a());
    }

    public static C17585nD0 b(Context context, Handler handler) {
        return new C17585nD0(b.g(context, handler));
    }

    public C19349qC0 c(String str) {
        C19349qC0 c19349qC0E;
        synchronized (this.b) {
            c19349qC0E = (C19349qC0) this.b.get(str);
            if (c19349qC0E == null) {
                try {
                    c19349qC0E = C19349qC0.e(this.a.b(str), str);
                    this.b.put(str, c19349qC0E);
                } catch (AssertionError e) {
                    throw new CameraAccessExceptionCompat(10002, e.getMessage(), e);
                }
            }
        }
        return c19349qC0E;
    }

    public String[] d() {
        return this.a.e();
    }

    public Set e() {
        return this.a.c();
    }

    public void f(String str, Executor executor, CameraDevice.StateCallback stateCallback) {
        this.a.d(str, executor, stateCallback);
    }

    public void g(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.a(executor, availabilityCallback);
    }

    public void h(CameraManager.AvailabilityCallback availabilityCallback) {
        this.a.f(availabilityCallback);
    }
}
