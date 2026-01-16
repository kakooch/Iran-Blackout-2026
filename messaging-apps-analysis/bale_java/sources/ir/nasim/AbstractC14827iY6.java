package ir.nasim;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.impl.AbstractC1920a;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.j;
import ir.nasim.C18667p27;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.iY6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14827iY6 {
    public static final j.a a = j.a.a("camera2.streamSpec.streamUseCase", Long.TYPE);
    private static final Map b;
    private static final Map c;

    static {
        HashMap map = new HashMap();
        b = map;
        HashMap map2 = new HashMap();
        c = map2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            D.b bVar = D.b.PREVIEW;
            hashSet.add(bVar);
            D.b bVar2 = D.b.METERING_REPEATING;
            hashSet.add(bVar2);
            map.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(bVar);
            hashSet2.add(bVar2);
            hashSet2.add(D.b.IMAGE_ANALYSIS);
            map.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            D.b bVar3 = D.b.IMAGE_CAPTURE;
            hashSet3.add(bVar3);
            map.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            D.b bVar4 = D.b.VIDEO_CAPTURE;
            hashSet4.add(bVar4);
            map.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(bVar);
            hashSet5.add(bVar3);
            hashSet5.add(bVar4);
            map2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(bVar);
            hashSet6.add(bVar4);
            map2.put(3L, hashSet6);
        }
    }

    public static boolean a(Map map, Map map2, List list) {
        for (int i = 0; i < list.size(); i++) {
            long jF = ((AbstractC19849r27) list.get(i)).f();
            if (map.containsKey(Integer.valueOf(i))) {
                AbstractC1920a abstractC1920a = (AbstractC1920a) map.get(Integer.valueOf(i));
                if (!g(abstractC1920a.b().size() == 1 ? (D.b) abstractC1920a.b().get(0) : D.b.STREAM_SHARING, jF, abstractC1920a.b())) {
                    return false;
                }
            } else {
                if (!map2.containsKey(Integer.valueOf(i))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                androidx.camera.core.impl.C c2 = (androidx.camera.core.impl.C) map2.get(Integer.valueOf(i));
                if (!g(c2.N(), jF, c2.N() == D.b.STREAM_SHARING ? ((C13625gY6) c2).V() : Collections.emptyList())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean b(Set set, Set set2) {
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            if (!set.contains((Long) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(C19349qC0 c19349qC0, List list) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) c19349qC0.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long j : jArr) {
            hashSet.add(Long.valueOf(j));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((AbstractC19849r27) it.next()).f()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC1920a abstractC1920a = (AbstractC1920a) it.next();
            if (j(abstractC1920a.e(), (D.b) abstractC1920a.b().get(0))) {
                return true;
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.impl.C c2 = (androidx.camera.core.impl.C) it2.next();
            if (j(c2, c2.N())) {
                return true;
            }
        }
        return false;
    }

    public static BB0 e(androidx.camera.core.impl.C c2) {
        androidx.camera.core.impl.q qVarZ = androidx.camera.core.impl.q.Z();
        j.a aVar = BB0.J;
        if (c2.b(aVar)) {
            qVarZ.p(aVar, (Long) c2.a(aVar));
        }
        j.a aVar2 = androidx.camera.core.impl.C.z;
        if (c2.b(aVar2)) {
            qVarZ.p(aVar2, (Boolean) c2.a(aVar2));
        }
        j.a aVar3 = androidx.camera.core.impl.m.I;
        if (c2.b(aVar3)) {
            qVarZ.p(aVar3, (Integer) c2.a(aVar3));
        }
        j.a aVar4 = androidx.camera.core.impl.n.h;
        if (c2.b(aVar4)) {
            qVarZ.p(aVar4, (Integer) c2.a(aVar4));
        }
        return new BB0(qVarZ);
    }

    private static androidx.camera.core.impl.j f(androidx.camera.core.impl.j jVar, long j) {
        j.a aVar = a;
        if (jVar.b(aVar) && ((Long) jVar.a(aVar)).longValue() == j) {
            return null;
        }
        androidx.camera.core.impl.q qVarA0 = androidx.camera.core.impl.q.a0(jVar);
        qVarA0.p(aVar, Long.valueOf(j));
        return new BB0(qVarA0);
    }

    private static boolean g(D.b bVar, long j, List list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (bVar != D.b.STREAM_SHARING) {
            Map map = b;
            return map.containsKey(Long.valueOf(j)) && ((Set) map.get(Long.valueOf(j))).contains(bVar);
        }
        Map map2 = c;
        if (!map2.containsKey(Long.valueOf(j))) {
            return false;
        }
        Set set = (Set) map2.get(Long.valueOf(j));
        if (list.size() != set.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!set.contains((D.b) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(C19349qC0 c19349qC0) {
        long[] jArr;
        return (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) c19349qC0.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
    }

    private static boolean i(List list, List list2, Set set) {
        boolean z;
        boolean z2;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        if (it.hasNext()) {
            AbstractC1920a abstractC1920a = (AbstractC1920a) it.next();
            androidx.camera.core.impl.j jVarE = abstractC1920a.e();
            j.a aVar = BB0.J;
            if (jVarE.b(aVar) && ((Long) abstractC1920a.e().a(aVar)).longValue() != 0) {
                z = true;
                z2 = false;
            } else {
                z2 = true;
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.impl.C c2 = (androidx.camera.core.impl.C) it2.next();
            j.a aVar2 = BB0.J;
            if (c2.b(aVar2)) {
                Long l = (Long) c2.a(aVar2);
                if (l.longValue() != 0) {
                    if (z2) {
                        o();
                    }
                    hashSet.add(l);
                    z = true;
                } else if (z) {
                    o();
                }
            } else if (z) {
                o();
            }
            z2 = true;
        }
        return !z2 && b(set, hashSet);
    }

    private static boolean j(androidx.camera.core.impl.j jVar, D.b bVar) {
        if (((Boolean) jVar.g(androidx.camera.core.impl.C.z, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        j.a aVar = androidx.camera.core.impl.m.I;
        return jVar.b(aVar) && AbstractC3333Ak7.b(bVar, ((Integer) jVar.a(aVar)).intValue()) == 5;
    }

    public static boolean k(C19349qC0 c19349qC0, List list, Map map, Map map2) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        ArrayList<androidx.camera.core.impl.C> arrayList = new ArrayList(map.keySet());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC4980Hj5.g(((AbstractC1920a) it.next()).e());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AbstractC4980Hj5.g(((androidx.camera.core.impl.w) AbstractC4980Hj5.g((androidx.camera.core.impl.w) map.get((androidx.camera.core.impl.C) it2.next()))).d());
        }
        long[] jArr = (long[]) c19349qC0.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(Long.valueOf(j));
            }
            if (i(list, arrayList, hashSet)) {
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    AbstractC1920a abstractC1920a = (AbstractC1920a) it3.next();
                    androidx.camera.core.impl.j jVarE = abstractC1920a.e();
                    androidx.camera.core.impl.j jVarF = f(jVarE, ((Long) jVarE.a(BB0.J)).longValue());
                    if (jVarF != null) {
                        map2.put(abstractC1920a, abstractC1920a.i(jVarF));
                    }
                }
                for (androidx.camera.core.impl.C c2 : arrayList) {
                    androidx.camera.core.impl.w wVar = (androidx.camera.core.impl.w) map.get(c2);
                    androidx.camera.core.impl.j jVarD = wVar.d();
                    androidx.camera.core.impl.j jVarF2 = f(jVarD, ((Long) jVarD.a(BB0.J)).longValue());
                    if (jVarF2 != null) {
                        map.put(c2, wVar.g().d(jVarF2).a());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void l(Map map, Map map2, Map map3, Map map4, List list) {
        for (int i = 0; i < list.size(); i++) {
            long jF = ((AbstractC19849r27) list.get(i)).f();
            if (map3.containsKey(Integer.valueOf(i))) {
                AbstractC1920a abstractC1920a = (AbstractC1920a) map3.get(Integer.valueOf(i));
                androidx.camera.core.impl.j jVarF = f(abstractC1920a.e(), jF);
                if (jVarF != null) {
                    map2.put(abstractC1920a, abstractC1920a.i(jVarF));
                }
            } else {
                if (!map4.containsKey(Integer.valueOf(i))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                androidx.camera.core.impl.C c2 = (androidx.camera.core.impl.C) map4.get(Integer.valueOf(i));
                androidx.camera.core.impl.w wVar = (androidx.camera.core.impl.w) map.get(c2);
                androidx.camera.core.impl.j jVarF2 = f(wVar.d(), jF);
                if (jVarF2 != null) {
                    map.put(c2, wVar.g().d(jVarF2).a());
                }
            }
        }
    }

    public static void m(Collection collection, Collection collection2, Map map) {
        ArrayList arrayList = new ArrayList(collection2);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.v vVar = (androidx.camera.core.impl.v) it.next();
            androidx.camera.core.impl.j jVarF = vVar.f();
            j.a aVar = a;
            if (jVarF.b(aVar) && vVar.n().size() != 1) {
                PI3.c("StreamUseCaseUtil", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Integer.valueOf(vVar.n().size())));
                return;
            }
            if (vVar.f().b(aVar)) {
                Iterator it2 = collection.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    androidx.camera.core.impl.v vVar2 = (androidx.camera.core.impl.v) it2.next();
                    if (((androidx.camera.core.impl.C) arrayList.get(i)).N() == D.b.METERING_REPEATING) {
                        AbstractC4980Hj5.j(!vVar2.n().isEmpty(), "MeteringRepeating should contain a surface");
                        map.put((DeferrableSurface) vVar2.n().get(0), 1L);
                    } else {
                        androidx.camera.core.impl.j jVarF2 = vVar2.f();
                        j.a aVar2 = a;
                        if (jVarF2.b(aVar2) && !vVar2.n().isEmpty()) {
                            map.put((DeferrableSurface) vVar2.n().get(0), (Long) vVar2.f().a(aVar2));
                        }
                    }
                    i++;
                }
                return;
            }
        }
    }

    public static boolean n(C18667p27.b bVar) {
        return bVar.a() == 0 && bVar.b() == 8;
    }

    private static void o() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
