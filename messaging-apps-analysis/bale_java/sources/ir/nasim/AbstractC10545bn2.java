package ir.nasim;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.bn2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC10545bn2 {
    private static final int a(String str) {
        int iK0;
        char c = File.separatorChar;
        int iK02 = AbstractC20762sZ6.k0(str, c, 0, false, 4, null);
        if (iK02 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (iK0 = AbstractC20762sZ6.k0(str, c, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iK03 = AbstractC20762sZ6.k0(str, c, iK0 + 1, false, 4, null);
            return iK03 >= 0 ? iK03 + 1 : str.length();
        }
        if (iK02 > 0 && str.charAt(iK02 - 1) == ':') {
            return iK02 + 1;
        }
        if (iK02 == -1 && AbstractC20762sZ6.b0(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean b(File file) {
        AbstractC13042fc3.i(file, "<this>");
        String path = file.getPath();
        AbstractC13042fc3.h(path, "getPath(...)");
        return a(path) > 0;
    }

    public static final C7609Sl2 c(File file) {
        List listM;
        AbstractC13042fc3.i(file, "<this>");
        String path = file.getPath();
        AbstractC13042fc3.f(path);
        int iA = a(path);
        String strSubstring = path.substring(0, iA);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(iA);
        AbstractC13042fc3.h(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            listM = AbstractC10360bX0.m();
        } else {
            List listM0 = AbstractC20762sZ6.M0(strSubstring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listM0, 10));
            Iterator it = listM0.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            listM = arrayList;
        }
        return new C7609Sl2(new File(strSubstring), listM);
    }
}
