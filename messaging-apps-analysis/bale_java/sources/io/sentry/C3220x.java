package io.sentry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: io.sentry.x, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3220x implements D {
    private final Map a = Collections.synchronizedMap(new WeakHashMap());
    private final C3155n3 b;

    public C3220x(C3155n3 c3155n3) {
        this.b = (C3155n3) io.sentry.util.u.c(c3155n3, "options are required");
    }

    private static List d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th.getCause() != null) {
            arrayList.add(th.getCause());
            th = th.getCause();
        }
        return arrayList;
    }

    private static boolean e(Map map, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (map.containsKey(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.sentry.D
    public L2 b(L2 l2, I i) {
        if (this.b.isEnableDeduplication()) {
            Throwable thO = l2.O();
            if (thO != null) {
                if (this.a.containsKey(thO) || e(this.a, d(thO))) {
                    this.b.getLogger().c(Y2.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", l2.G());
                    return null;
                }
                this.a.put(thO, null);
            }
        } else {
            this.b.getLogger().c(Y2.DEBUG, "Event deduplication is disabled.", new Object[0]);
        }
        return l2;
    }
}
