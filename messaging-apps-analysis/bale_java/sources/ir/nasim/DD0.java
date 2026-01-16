package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class DD0 {
    private static String a(C17585nD0 c17585nD0, Integer num, List list) {
        if (num == null || !list.contains("0") || !list.contains("1")) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) c17585nD0.c("0").a(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return "1";
            }
            return null;
        }
        if (num.intValue() == 0 && ((Integer) c17585nD0.c("1").a(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return "0";
        }
        return null;
    }

    static List b(SA0 sa0, ED0 ed0) throws InitializationException {
        String strA;
        try {
            ArrayList arrayList = new ArrayList();
            List<String> listAsList = Arrays.asList(sa0.c().d());
            if (ed0 == null) {
                Iterator it = listAsList.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next());
                }
                return arrayList;
            }
            try {
                strA = a(sa0.c(), ed0.d(), listAsList);
            } catch (IllegalStateException unused) {
                strA = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str : listAsList) {
                if (!str.equals(strA)) {
                    arrayList2.add(sa0.f(str));
                }
            }
            Iterator it2 = ed0.b(arrayList2).iterator();
            while (it2.hasNext()) {
                arrayList.add(((InterfaceC14623iD0) ((InterfaceC14021hD0) it2.next())).b());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e) {
            throw new InitializationException(MD0.a(e));
        } catch (CameraUnavailableException e2) {
            throw new InitializationException(e2);
        }
    }
}
