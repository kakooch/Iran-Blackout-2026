package ir.nasim;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.j;
import ir.nasim.VF0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.uB0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC21817uB0 {

    /* renamed from: ir.nasim.uB0$a */
    static class a {
        static CaptureRequest.Builder a(CameraDevice cameraDevice, TotalCaptureResult totalCaptureResult) {
            return cameraDevice.createReprocessCaptureRequest(totalCaptureResult);
        }
    }

    private static void a(androidx.camera.core.impl.i iVar, CaptureRequest.Builder builder) {
        if (iVar.e().equals(androidx.camera.core.impl.w.a)) {
            return;
        }
        builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, iVar.e());
    }

    private static void b(CaptureRequest.Builder builder, androidx.camera.core.impl.j jVar) {
        VF0 vf0D = VF0.a.e(jVar).d();
        for (j.a aVar : vf0D.e()) {
            CaptureRequest.Key key = (CaptureRequest.Key) aVar.d();
            try {
                builder.set(key, vf0D.a(aVar));
            } catch (IllegalArgumentException unused) {
                PI3.c("Camera2CaptureRequestBuilder", "CaptureRequest.Key is not supported: " + key);
            }
        }
    }

    private static void c(CaptureRequest.Builder builder, int i, C24515yk7 c24515yk7) {
        for (Map.Entry entry : c24515yk7.a(i).entrySet()) {
            builder.set((CaptureRequest.Key) entry.getKey(), entry.getValue());
        }
    }

    static void d(androidx.camera.core.impl.i iVar, CaptureRequest.Builder builder) {
        if (iVar.h() == 1 || iVar.l() == 1) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        } else if (iVar.h() == 2) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        } else if (iVar.l() == 2) {
            builder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        }
    }

    public static CaptureRequest e(androidx.camera.core.impl.i iVar, CameraDevice cameraDevice, Map map, boolean z, C24515yk7 c24515yk7) throws CameraAccessException {
        CaptureRequest.Builder builderCreateCaptureRequest;
        if (cameraDevice == null) {
            return null;
        }
        List listG = g(iVar.i(), map);
        if (listG.isEmpty()) {
            return null;
        }
        QB0 qb0D = iVar.d();
        if (iVar.k() == 5 && qb0D != null && (qb0D.d() instanceof TotalCaptureResult)) {
            PI3.a("Camera2CaptureRequestBuilder", "createReprocessCaptureRequest");
            builderCreateCaptureRequest = a.a(cameraDevice, (TotalCaptureResult) qb0D.d());
        } else {
            PI3.a("Camera2CaptureRequestBuilder", "createCaptureRequest");
            if (iVar.k() == 5) {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(z ? 1 : 2);
            } else {
                builderCreateCaptureRequest = cameraDevice.createCaptureRequest(iVar.k());
            }
        }
        c(builderCreateCaptureRequest, iVar.k(), c24515yk7);
        a(iVar, builderCreateCaptureRequest);
        d(iVar, builderCreateCaptureRequest);
        androidx.camera.core.impl.j jVarG = iVar.g();
        j.a aVar = androidx.camera.core.impl.i.i;
        if (jVarG.b(aVar)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, (Integer) iVar.g().a(aVar));
        }
        androidx.camera.core.impl.j jVarG2 = iVar.g();
        j.a aVar2 = androidx.camera.core.impl.i.j;
        if (jVarG2.b(aVar2)) {
            builderCreateCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) iVar.g().a(aVar2)).byteValue()));
        }
        b(builderCreateCaptureRequest, iVar.g());
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            builderCreateCaptureRequest.addTarget((Surface) it.next());
        }
        builderCreateCaptureRequest.setTag(iVar.j());
        return builderCreateCaptureRequest.build();
    }

    public static CaptureRequest f(androidx.camera.core.impl.i iVar, CameraDevice cameraDevice, C24515yk7 c24515yk7) throws CameraAccessException {
        if (cameraDevice == null) {
            return null;
        }
        PI3.a("Camera2CaptureRequestBuilder", "template type = " + iVar.k());
        CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(iVar.k());
        c(builderCreateCaptureRequest, iVar.k(), c24515yk7);
        b(builderCreateCaptureRequest, iVar.g());
        return builderCreateCaptureRequest.build();
    }

    private static List g(List list, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Surface surface = (Surface) map.get((DeferrableSurface) it.next());
            if (surface == null) {
                throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
            }
            arrayList.add(surface);
        }
        return arrayList;
    }
}
