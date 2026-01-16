package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import ir.nasim.AbstractC19849r27;
import ir.nasim.C19258q27;
import ir.nasim.InterfaceC5592Jz5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements InterfaceC5592Jz5 {
    private static final C19258q27 a = c();
    private static final C19258q27 b = d();
    private static final Set c = new HashSet(Arrays.asList("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"));
    private static final Set d = new HashSet(Arrays.asList("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26"));

    private static C19258q27 c() {
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.YUV;
        c19258q27.a(AbstractC19849r27.a(bVar, AbstractC19849r27.a.VGA));
        c19258q27.a(AbstractC19849r27.a(AbstractC19849r27.b.PRIV, AbstractC19849r27.a.PREVIEW));
        c19258q27.a(AbstractC19849r27.a(bVar, AbstractC19849r27.a.MAXIMUM));
        return c19258q27;
    }

    private static C19258q27 d() {
        C19258q27 c19258q27 = new C19258q27();
        AbstractC19849r27.b bVar = AbstractC19849r27.b.PRIV;
        c19258q27.a(AbstractC19849r27.a(bVar, AbstractC19849r27.a.PREVIEW));
        c19258q27.a(AbstractC19849r27.a(bVar, AbstractC19849r27.a.VGA));
        c19258q27.a(AbstractC19849r27.a(AbstractC19849r27.b.YUV, AbstractC19849r27.a.MAXIMUM));
        return c19258q27;
    }

    private List f(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("1")) {
            arrayList.add(a);
        }
        return arrayList;
    }

    private static boolean g() {
        String str = Build.DEVICE;
        return "heroqltevzw".equalsIgnoreCase(str) || "heroqltetmo".equalsIgnoreCase(str);
    }

    static boolean h() {
        return g() || i() || j();
    }

    private static boolean i() {
        if (!"google".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        return c.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    private static boolean j() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        Iterator it = d.iterator();
        while (it.hasNext()) {
            if (upperCase.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public List e(String str) {
        return g() ? f(str) : (i() || j()) ? Collections.singletonList(b) : Collections.emptyList();
    }
}
