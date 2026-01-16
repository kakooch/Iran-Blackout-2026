package ir.nasim;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes8.dex */
public final class YM3 {
    public static final YM3 a;
    public static final WM3 b;

    static {
        YM3 ym3 = new YM3();
        a = ym3;
        AbstractC10110b57.f("kotlinx.coroutines.fast.service.loader", true);
        b = ym3.a();
    }

    private YM3() {
    }

    private final WM3 a() {
        Object next;
        WM3 wm3E;
        try {
            List listK = AbstractC11342cq6.K(AbstractC9962aq6.c(ServiceLoader.load(XM3.class, XM3.class.getClassLoader()).iterator()));
            Iterator it = listK.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iC = ((XM3) next).c();
                    do {
                        Object next2 = it.next();
                        int iC2 = ((XM3) next2).c();
                        if (iC < iC2) {
                            next = next2;
                            iC = iC2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            XM3 xm3 = (XM3) next;
            if (xm3 != null && (wm3E = ZM3.e(xm3, listK)) != null) {
                return wm3E;
            }
            return ZM3.b(null, null, 3, null);
        } catch (Throwable th) {
            return ZM3.b(th, null, 2, null);
        }
    }
}
