package ir.nasim;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import ir.nasim.NC0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class VC0 implements NC0.a {
    final CameraDevice a;
    final Object b;

    static class a {
        final Handler a;

        a(Handler handler) {
            this.a = handler;
        }
    }

    VC0(CameraDevice cameraDevice, Object obj) {
        this.a = (CameraDevice) AbstractC4980Hj5.g(cameraDevice);
        this.b = obj;
    }

    private static void b(CameraDevice cameraDevice, List list) {
        String id = cameraDevice.getId();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strC = ((C15315jN4) it.next()).c();
            if (strC != null && !strC.isEmpty()) {
                PI3.l("CameraDeviceCompat", "Camera " + id + ": Camera doesn't support physicalCameraId " + strC + ". Ignoring.");
            }
        }
    }

    static void c(CameraDevice cameraDevice, C8626Wt6 c8626Wt6) {
        AbstractC4980Hj5.g(cameraDevice);
        AbstractC4980Hj5.g(c8626Wt6);
        AbstractC4980Hj5.g(c8626Wt6.e());
        List listC = c8626Wt6.c();
        if (listC == null) {
            throw new IllegalArgumentException("Invalid output configurations");
        }
        if (c8626Wt6.a() == null) {
            throw new IllegalArgumentException("Invalid executor");
        }
        b(cameraDevice, listC);
    }

    static List d(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((C15315jN4) it.next()).d());
        }
        return arrayList;
    }
}
