package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.j;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class r implements j {
    protected static final Comparator I;
    private static final r J;
    protected final TreeMap H;

    static {
        Comparator comparator = new Comparator() { // from class: ir.nasim.JL4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return androidx.camera.core.impl.r.Y((j.a) obj, (j.a) obj2);
            }
        };
        I = comparator;
        J = new r(new TreeMap(comparator));
    }

    r(TreeMap treeMap) {
        this.H = treeMap;
    }

    public static r W() {
        return J;
    }

    public static r X(j jVar) {
        if (r.class.equals(jVar.getClass())) {
            return (r) jVar;
        }
        TreeMap treeMap = new TreeMap(I);
        for (j.a aVar : jVar.e()) {
            Set<j.c> setF = jVar.f(aVar);
            ArrayMap arrayMap = new ArrayMap();
            for (j.c cVar : setF) {
                arrayMap.put(cVar, jVar.d(aVar, cVar));
            }
            treeMap.put(aVar, arrayMap);
        }
        return new r(treeMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Y(j.a aVar, j.a aVar2) {
        return aVar.c().compareTo(aVar2.c());
    }

    @Override // androidx.camera.core.impl.j
    public Object a(j.a aVar) {
        Map map = (Map) this.H.get(aVar);
        if (map != null) {
            return map.get((j.c) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }

    @Override // androidx.camera.core.impl.j
    public boolean b(j.a aVar) {
        return this.H.containsKey(aVar);
    }

    @Override // androidx.camera.core.impl.j
    public void c(String str, j.b bVar) {
        for (Map.Entry entry : this.H.tailMap(j.a.a(str, Void.class)).entrySet()) {
            if (!((j.a) entry.getKey()).c().startsWith(str) || !bVar.a((j.a) entry.getKey())) {
                return;
            }
        }
    }

    @Override // androidx.camera.core.impl.j
    public Object d(j.a aVar, j.c cVar) {
        Map map = (Map) this.H.get(aVar);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + aVar);
        }
        if (map.containsKey(cVar)) {
            return map.get(cVar);
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar + " with priority=" + cVar);
    }

    @Override // androidx.camera.core.impl.j
    public Set e() {
        return Collections.unmodifiableSet(this.H.keySet());
    }

    @Override // androidx.camera.core.impl.j
    public Set f(j.a aVar) {
        Map map = (Map) this.H.get(aVar);
        return map == null ? Collections.emptySet() : Collections.unmodifiableSet(map.keySet());
    }

    @Override // androidx.camera.core.impl.j
    public Object g(j.a aVar, Object obj) {
        try {
            return a(aVar);
        } catch (IllegalArgumentException unused) {
            return obj;
        }
    }

    @Override // androidx.camera.core.impl.j
    public j.c h(j.a aVar) {
        Map map = (Map) this.H.get(aVar);
        if (map != null) {
            return (j.c) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + aVar);
    }
}
