package j$.time.zone;

import j$.util.AbstractC0102a;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class g {
    private static final CopyOnWriteArrayList a;
    private static final ConcurrentMap b;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        a = copyOnWriteArrayList;
        b = new ConcurrentHashMap(512, 0.75f, 2);
        ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new e(arrayList));
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected g() {
    }

    public static c a(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("zoneId");
        }
        ConcurrentMap concurrentMap = b;
        g gVar = (g) concurrentMap.get(str);
        if (gVar != null) {
            return gVar.b(str, z);
        }
        if (concurrentMap.isEmpty()) {
            throw new d("No time-zone data files registered");
        }
        throw new d("Unknown time-zone ID: " + str);
    }

    public static void d(g gVar) {
        if (gVar == null) {
            throw new NullPointerException("provider");
        }
        for (String str : gVar.c()) {
            AbstractC0102a.w(str, "zoneId");
            if (((g) b.putIfAbsent(str, gVar)) != null) {
                throw new d("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + gVar);
            }
        }
        a.add(gVar);
    }

    protected abstract c b(String str, boolean z);

    protected abstract Set c();
}
