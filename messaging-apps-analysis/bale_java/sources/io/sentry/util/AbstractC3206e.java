package io.sentry.util;

import io.sentry.L2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: io.sentry.util.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3206e {
    public static boolean a(List list, L2 l2) {
        if (l2 != null && list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            io.sentry.protocol.k kVarT0 = l2.t0();
            if (kVarT0 != null) {
                String strE = kVarT0.e();
                if (strE != null) {
                    hashSet.add(strE);
                }
                String strD = kVarT0.d();
                if (strD != null) {
                    hashSet.add(strD);
                }
            }
            Throwable thO = l2.O();
            if (thO != null) {
                hashSet.add(thO.toString());
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (hashSet.contains(((io.sentry.G) it.next()).a())) {
                    return true;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                io.sentry.G g = (io.sentry.G) it2.next();
                Iterator it3 = hashSet.iterator();
                while (it3.hasNext()) {
                    if (g.b((String) it3.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
