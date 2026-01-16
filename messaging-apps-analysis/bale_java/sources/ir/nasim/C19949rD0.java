package ir.nasim;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import ir.nasim.C17585nD0;
import ir.nasim.NC0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.rD0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C19949rD0 implements C17585nD0.b {
    final CameraManager a;
    final Object b;

    /* renamed from: ir.nasim.rD0$a */
    static final class a {
        final Map a = new HashMap();
        final Handler b;

        a(Handler handler) {
            this.b = handler;
        }
    }

    C19949rD0(Context context, Object obj) {
        this.a = (CameraManager) context.getSystemService("camera");
        this.b = obj;
    }

    static C19949rD0 h(Context context, Handler handler) {
        return new C19949rD0(context, new a(handler));
    }

    @Override // ir.nasim.C17585nD0.b
    public void a(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        C17585nD0.a aVar;
        if (executor == null) {
            throw new IllegalArgumentException("executor was null");
        }
        a aVar2 = (a) this.b;
        if (availabilityCallback != null) {
            synchronized (aVar2.a) {
                try {
                    aVar = (C17585nD0.a) aVar2.a.get(availabilityCallback);
                    if (aVar == null) {
                        aVar = new C17585nD0.a(executor, availabilityCallback);
                        aVar2.a.put(availabilityCallback, aVar);
                    }
                } finally {
                }
            }
        } else {
            aVar = null;
        }
        this.a.registerAvailabilityCallback(aVar, aVar2.b);
    }

    @Override // ir.nasim.C17585nD0.b
    public CameraCharacteristics b(String str) throws CameraAccessExceptionCompat {
        try {
            return this.a.getCameraCharacteristics(str);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }

    @Override // ir.nasim.C17585nD0.b
    public Set c() {
        return Collections.emptySet();
    }

    @Override // ir.nasim.C17585nD0.b
    public void d(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessException, CameraAccessExceptionCompat {
        AbstractC4980Hj5.g(executor);
        AbstractC4980Hj5.g(stateCallback);
        try {
            this.a.openCamera(str, new NC0.b(executor, stateCallback), ((a) this.b).b);
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }

    @Override // ir.nasim.C17585nD0.b
    public String[] e() throws CameraAccessExceptionCompat {
        try {
            return this.a.getCameraIdList();
        } catch (CameraAccessException e) {
            throw CameraAccessExceptionCompat.e(e);
        }
    }

    @Override // ir.nasim.C17585nD0.b
    public void f(CameraManager.AvailabilityCallback availabilityCallback) {
        C17585nD0.a aVar;
        if (availabilityCallback != null) {
            a aVar2 = (a) this.b;
            synchronized (aVar2.a) {
                aVar = (C17585nD0.a) aVar2.a.remove(availabilityCallback);
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.g();
        }
        this.a.unregisterAvailabilityCallback(aVar);
    }
}
