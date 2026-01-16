package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.text.TextUtils;
import androidx.camera.core.impl.AbstractC1920a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* renamed from: ir.nasim.m22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C16889m22 {
    private final C19349qC0 a;
    private final C19253q22 b;
    private final boolean c;

    /* renamed from: ir.nasim.m22$a */
    static final class a {
        static C15116j22 a(C19349qC0 c19349qC0) {
            Long l = (Long) c19349qC0.a(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (l != null) {
                return AbstractC16298l22.b(l.longValue());
            }
            return null;
        }
    }

    C16889m22(C19349qC0 c19349qC0) {
        this.a = c19349qC0;
        this.b = C19253q22.a(c19349qC0);
        int[] iArr = (int[]) c19349qC0.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean z = false;
        if (iArr != null) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (iArr[i] == 18) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.c = z;
    }

    private static boolean a(C15116j22 c15116j22, C15116j22 c15116j222) {
        AbstractC4980Hj5.j(c15116j222.e(), "Fully specified range is not actually fully specified.");
        if (c15116j22.b() == 2 && c15116j222.b() == 1) {
            return false;
        }
        if (c15116j22.b() == 2 || c15116j22.b() == 0 || c15116j22.b() == c15116j222.b()) {
            return c15116j22.a() == 0 || c15116j22.a() == c15116j222.a();
        }
        return false;
    }

    private static boolean b(C15116j22 c15116j22, C15116j22 c15116j222, Set set) {
        if (set.contains(c15116j222)) {
            return a(c15116j22, c15116j222);
        }
        PI3.a("DynamicRangeResolver", String.format("Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  %s\nCandidate dynamic range:\n  %s", c15116j22, c15116j222));
        return false;
    }

    private static C15116j22 c(C15116j22 c15116j22, Collection collection, Set set) {
        if (c15116j22.b() == 1) {
            return null;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C15116j22 c15116j222 = (C15116j22) it.next();
            AbstractC4980Hj5.h(c15116j222, "Fully specified DynamicRange cannot be null.");
            int iB = c15116j222.b();
            AbstractC4980Hj5.j(c15116j222.e(), "Fully specified DynamicRange must have fully defined encoding.");
            if (iB != 1 && b(c15116j22, c15116j222, set)) {
                return c15116j222;
            }
        }
        return null;
    }

    private static boolean e(C15116j22 c15116j22) {
        return Objects.equals(c15116j22, C15116j22.c);
    }

    private static boolean f(C15116j22 c15116j22) {
        return c15116j22.b() == 2 || (c15116j22.b() != 0 && c15116j22.a() == 0) || (c15116j22.b() == 0 && c15116j22.a() != 0);
    }

    private C15116j22 h(C15116j22 c15116j22, Set set, Set set2, Set set3, String str) {
        C15116j22 c15116j22A;
        if (c15116j22.e()) {
            if (set.contains(c15116j22)) {
                return c15116j22;
            }
            return null;
        }
        int iB = c15116j22.b();
        int iA = c15116j22.a();
        if (iB == 1 && iA == 0) {
            C15116j22 c15116j222 = C15116j22.d;
            if (set.contains(c15116j222)) {
                return c15116j222;
            }
            return null;
        }
        C15116j22 c15116j22C = c(c15116j22, set2, set);
        if (c15116j22C != null) {
            PI3.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from existing attached surface.\n%s\n->\n%s", str, c15116j22, c15116j22C));
            return c15116j22C;
        }
        C15116j22 c15116j22C2 = c(c15116j22, set3, set);
        if (c15116j22C2 != null) {
            PI3.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from concurrently bound use case.\n%s\n->\n%s", str, c15116j22, c15116j22C2));
            return c15116j22C2;
        }
        C15116j22 c15116j223 = C15116j22.d;
        if (b(c15116j22, c15116j223, set)) {
            PI3.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s to no compatible HDR dynamic ranges.\n%s\n->\n%s", str, c15116j22, c15116j223));
            return c15116j223;
        }
        if (iB == 2 && (iA == 10 || iA == 0)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (Build.VERSION.SDK_INT >= 33) {
                c15116j22A = a.a(this.a);
                if (c15116j22A != null) {
                    linkedHashSet.add(c15116j22A);
                }
            } else {
                c15116j22A = null;
            }
            linkedHashSet.add(C15116j22.f);
            C15116j22 c15116j22C3 = c(c15116j22, linkedHashSet, set);
            if (c15116j22C3 != null) {
                PI3.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from %s 10-bit supported dynamic range.\n%s\n->\n%s", str, c15116j22C3.equals(c15116j22A) ? "recommended" : ParameterNames.REQUIRED, c15116j22, c15116j22C3));
                return c15116j22C3;
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            C15116j22 c15116j224 = (C15116j22) it.next();
            AbstractC4980Hj5.j(c15116j224.e(), "Candidate dynamic range must be fully specified.");
            if (!c15116j224.equals(C15116j22.d) && a(c15116j22, c15116j224)) {
                PI3.a("DynamicRangeResolver", String.format("Resolved dynamic range for use case %s from validated dynamic range constraints or supported HDR dynamic ranges.\n%s\n->\n%s", str, c15116j22, c15116j224));
                return c15116j224;
            }
        }
        return null;
    }

    private C15116j22 i(Set set, Set set2, Set set3, androidx.camera.core.impl.C c, Set set4) {
        C15116j22 c15116j22F = c.F();
        C15116j22 c15116j22H = h(c15116j22F, set4, set2, set3, c.P());
        if (c15116j22H == null) {
            throw new IllegalArgumentException(String.format("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  %s\nRequested dynamic range:\n  %s\nSupported dynamic ranges:\n  %s\nConstrained set of concurrent dynamic ranges:\n  %s", c.P(), c15116j22F, TextUtils.join("\n  ", set), TextUtils.join("\n  ", set4)));
        }
        j(set4, c15116j22H, this.b);
        return c15116j22H;
    }

    private static void j(Set set, C15116j22 c15116j22, C19253q22 c19253q22) {
        AbstractC4980Hj5.j(!set.isEmpty(), "Cannot update already-empty constraints.");
        Set setB = c19253q22.b(c15116j22);
        if (setB.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet(set);
        set.retainAll(setB);
        if (set.isEmpty()) {
            throw new IllegalArgumentException(String.format("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  %s\nConstraints:\n  %s\nExisting constraints:\n  %s", c15116j22, TextUtils.join("\n  ", setB), TextUtils.join("\n  ", hashSet)));
        }
    }

    boolean d() {
        return this.c;
    }

    Map g(List list, List list2, List list3) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((AbstractC1920a) it.next()).c());
        }
        Set setC = this.b.c();
        HashSet hashSet = new HashSet(setC);
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            j(hashSet, (C15116j22) it2.next(), this.b);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            androidx.camera.core.impl.C c = (androidx.camera.core.impl.C) list2.get(((Integer) it3.next()).intValue());
            C15116j22 c15116j22F = c.F();
            if (e(c15116j22F)) {
                arrayList3.add(c);
            } else if (f(c15116j22F)) {
                arrayList2.add(c);
            } else {
                arrayList.add(c);
            }
        }
        HashMap map = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList<androidx.camera.core.impl.C> arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        for (androidx.camera.core.impl.C c2 : arrayList4) {
            C15116j22 c15116j22I = i(setC, linkedHashSet, linkedHashSet2, c2, hashSet);
            map.put(c2, c15116j22I);
            if (!linkedHashSet.contains(c15116j22I)) {
                linkedHashSet2.add(c15116j22I);
            }
        }
        return map;
    }
}
