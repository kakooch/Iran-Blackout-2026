package ir.nasim;

import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.QuirkSettingsLoader;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.C19958rE0;
import ir.nasim.InterfaceC21050t16;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.qE0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19367qE0 {
    private static final Object o = new Object();
    private static final SparseArray p = new SparseArray();
    final CD0 a;
    private final Object b;
    private final C19958rE0 c;
    private final Executor d;
    private final Handler e;
    private final HandlerThread f;
    private InterfaceC11560dD0 g;
    private XC0 h;
    private androidx.camera.core.impl.D i;
    private final InterfaceC21050t16 j;
    private final InterfaceFutureC15215jC3 k;
    private a l;
    private InterfaceFutureC15215jC3 m;
    private final Integer n;

    /* renamed from: ir.nasim.qE0$a */
    private enum a {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    public C19367qE0(Context context, C19958rE0.b bVar) {
        this(context, bVar, new QuirkSettingsLoader());
    }

    private static C19958rE0.b g(Context context) {
        ComponentCallbacks2 componentCallbacks2B = AbstractC17322mm1.b(context);
        if (componentCallbacks2B instanceof C19958rE0.b) {
            return (C19958rE0.b) componentCallbacks2B;
        }
        try {
            Context contextA = AbstractC17322mm1.a(context);
            Bundle bundle = contextA.getPackageManager().getServiceInfo(new ComponentName(contextA, (Class<?>) MetadataHolderService.class), 640).metaData;
            String string = bundle != null ? bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            if (string != null) {
                return (C19958rE0.b) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
            }
            PI3.c("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (ClassNotFoundException e2) {
            e = e2;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (IllegalAccessException e3) {
            e = e3;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InstantiationException e4) {
            e = e4;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NoSuchMethodException e5) {
            e = e5;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NullPointerException e6) {
            e = e6;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InvocationTargetException e7) {
            e = e7;
            PI3.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        }
    }

    private static void j(Integer num) {
        synchronized (o) {
            try {
                if (num == null) {
                    return;
                }
                AbstractC4980Hj5.c(num.intValue(), 3, 6, "minLogLevel");
                SparseArray sparseArray = p;
                sparseArray.put(num.intValue(), Integer.valueOf(sparseArray.get(num.intValue()) != null ? 1 + ((Integer) sparseArray.get(num.intValue())).intValue() : 1));
                r();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void k(final Executor executor, final long j, final int i, final Context context, final AbstractC16967mA0.a aVar) {
        executor.execute(new Runnable() { // from class: ir.nasim.pE0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.n(context, executor, i, aVar, j);
            }
        });
    }

    private InterfaceFutureC15215jC3 l(final Context context) {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3A;
        synchronized (this.b) {
            AbstractC4980Hj5.j(this.l == a.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.l = a.INITIALIZING;
            interfaceFutureC15215jC3A = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.oE0
                @Override // ir.nasim.AbstractC16967mA0.c
                public final Object a(AbstractC16967mA0.a aVar) {
                    return this.a.o(context, aVar);
                }
            });
        }
        return interfaceFutureC15215jC3A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Executor executor, long j, int i, Context context, AbstractC16967mA0.a aVar) {
        k(executor, j, i + 1, context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0112 A[Catch: all -> 0x006d, TryCatch #4 {all -> 0x006d, blocks: (B:3:0x0014, B:5:0x001c, B:7:0x0040, B:9:0x005a, B:11:0x0064, B:20:0x0076, B:22:0x0085, B:23:0x0088, B:25:0x0093, B:26:0x009f, B:27:0x00a0, B:28:0x00ac, B:29:0x00ad, B:30:0x00b9, B:31:0x00ba, B:35:0x00d3, B:36:0x0112, B:37:0x0114, B:40:0x011a, B:42:0x0120, B:43:0x0128, B:45:0x012c, B:46:0x0159, B:48:0x015d, B:49:0x0162, B:54:0x016f, B:38:0x0115, B:39:0x0119), top: B:59:0x0014, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void n(android.content.Context r17, final java.util.concurrent.Executor r18, final int r19, final ir.nasim.AbstractC16967mA0.a r20, final long r21) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19367qE0.n(android.content.Context, java.util.concurrent.Executor, int, ir.nasim.mA0$a, long):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Context context, AbstractC16967mA0.a aVar) {
        k(this.d, SystemClock.elapsedRealtime(), 1, context, aVar);
        return "CameraX initInternal";
    }

    private void p() {
        synchronized (this.b) {
            this.l = a.INITIALIZED;
        }
    }

    private void q(InterfaceC21050t16.b bVar) throws Throwable {
        if (C16807lt7.d()) {
            C16807lt7.f("CX:CameraProvider-RetryStatus", bVar != null ? bVar.j() : -1);
        }
    }

    private static void r() {
        SparseArray sparseArray = p;
        if (sparseArray.size() == 0) {
            PI3.i();
            return;
        }
        if (sparseArray.get(3) != null) {
            PI3.j(3);
            return;
        }
        if (sparseArray.get(4) != null) {
            PI3.j(4);
        } else if (sparseArray.get(5) != null) {
            PI3.j(5);
        } else if (sparseArray.get(6) != null) {
            PI3.j(6);
        }
    }

    private static void s(Context context, androidx.camera.core.impl.t tVar, InterfaceC21819uB2 interfaceC21819uB2) {
        if (tVar != null) {
            PI3.a("CameraX", "QuirkSettings from CameraXConfig: " + tVar);
        } else {
            tVar = (androidx.camera.core.impl.t) interfaceC21819uB2.apply(context);
            PI3.a("CameraX", "QuirkSettings from app metadata: " + tVar);
        }
        if (tVar == null) {
            tVar = C5826Kz5.b;
            PI3.a("CameraX", "QuirkSettings by default: " + tVar);
        }
        C5826Kz5.b().d(tVar);
    }

    public XC0 d() {
        XC0 xc0 = this.h;
        if (xc0 != null) {
            return xc0;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public InterfaceC11560dD0 e() {
        InterfaceC11560dD0 interfaceC11560dD0 = this.g;
        if (interfaceC11560dD0 != null) {
            return interfaceC11560dD0;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public CD0 f() {
        return this.a;
    }

    public androidx.camera.core.impl.D h() {
        androidx.camera.core.impl.D d = this.i;
        if (d != null) {
            return d;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public InterfaceFutureC15215jC3 i() {
        return this.k;
    }

    C19367qE0(Context context, C19958rE0.b bVar, InterfaceC21819uB2 interfaceC21819uB2) {
        this.a = new CD0();
        this.b = new Object();
        this.l = a.UNINITIALIZED;
        this.m = WB2.l(null);
        if (bVar != null) {
            this.c = bVar.getCameraXConfig();
        } else {
            C19958rE0.b bVarG = g(context);
            if (bVarG == null) {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
            this.c = bVarG.getCameraXConfig();
        }
        s(context, this.c.b0(), interfaceC21819uB2);
        Executor executorW = this.c.W(null);
        Handler handlerC0 = this.c.c0(null);
        this.d = executorW == null ? new ExecutorC10796cD0() : executorW;
        if (handlerC0 == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.f = handlerThread;
            handlerThread.start();
            this.e = AbstractC18913pT2.a(handlerThread.getLooper());
        } else {
            this.f = null;
            this.e = handlerC0;
        }
        Integer num = (Integer) this.c.g(C19958rE0.N, null);
        this.n = num;
        j(num);
        this.j = new InterfaceC21050t16.a(this.c.Z()).a();
        this.k = l(context);
    }
}
