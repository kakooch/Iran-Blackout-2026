package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.j;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class q extends r implements p {
    private static final j.c K = j.c.OPTIONAL;

    private q(TreeMap treeMap) {
        super(treeMap);
    }

    public static q Z() {
        return new q(new TreeMap(r.I));
    }

    public static q a0(j jVar) {
        TreeMap treeMap = new TreeMap(r.I);
        for (j.a aVar : jVar.e()) {
            Set<j.c> setF = jVar.f(aVar);
            ArrayMap arrayMap = new ArrayMap();
            for (j.c cVar : setF) {
                arrayMap.put(cVar, jVar.d(aVar, cVar));
            }
            treeMap.put(aVar, arrayMap);
        }
        return new q(treeMap);
    }

    public Object b0(j.a aVar) {
        return this.H.remove(aVar);
    }

    @Override // androidx.camera.core.impl.p
    public void n(j.a aVar, j.c cVar, Object obj) {
        Map map = (Map) this.H.get(aVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.H.put(aVar, arrayMap);
            arrayMap.put(cVar, obj);
            return;
        }
        j.c cVar2 = (j.c) Collections.min(map.keySet());
        if (Objects.equals(map.get(cVar2), obj) || !j.y(cVar2, cVar)) {
            map.put(cVar, obj);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + aVar.c() + ", existing value (" + cVar2 + ")=" + map.get(cVar2) + ", conflicting (" + cVar + ")=" + obj);
    }

    @Override // androidx.camera.core.impl.p
    public void p(j.a aVar, Object obj) {
        n(aVar, K, obj);
    }
}
