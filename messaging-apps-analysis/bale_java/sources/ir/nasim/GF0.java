package ir.nasim;

import android.hardware.camera2.CameraCaptureSession;
import ir.nasim.KB0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class GF0 {
    static CameraCaptureSession.CaptureCallback a(JB0 jb0) {
        if (jb0 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        b(jb0, arrayList);
        return arrayList.size() == 1 ? (CameraCaptureSession.CaptureCallback) arrayList.get(0) : AbstractC19340qB0.a(arrayList);
    }

    static void b(JB0 jb0, List list) {
        if (jb0 instanceof KB0.a) {
            Iterator it = ((KB0.a) jb0).e().iterator();
            while (it.hasNext()) {
                b((JB0) it.next(), list);
            }
        } else if (jb0 instanceof FF0) {
            list.add(((FF0) jb0).f());
        } else {
            list.add(new EF0(jb0));
        }
    }
}
