package ir.nasim;

import android.gov.nist.core.Separators;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import ir.nasim.AbstractC19420qK;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.l27, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C16303l27 {
    private final InterfaceC14623iD0 a;
    private final int b;
    private final int c;
    private final Rational d;
    private final C16894m27 e;

    public C16303l27(InterfaceC14623iD0 interfaceC14623iD0, Size size) {
        this.a = interfaceC14623iD0;
        this.b = interfaceC14623iD0.a();
        this.c = interfaceC14623iD0.d();
        Rational rationalH = size != null ? h(size) : i(interfaceC14623iD0);
        this.d = rationalH;
        this.e = new C16894m27(interfaceC14623iD0, rationalH);
    }

    private static LinkedHashMap a(List list, C18829pK c18829pK, Rational rational) {
        return b(o(list), c18829pK, rational);
    }

    private static LinkedHashMap b(Map map, C18829pK c18829pK, Rational rational) {
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        Rational rationalN = n(c18829pK.b(), z);
        if (c18829pK.a() == 0) {
            Rational rationalN2 = n(c18829pK.b(), z);
            Iterator it = new ArrayList(map.keySet()).iterator();
            while (it.hasNext()) {
                Rational rational2 = (Rational) it.next();
                if (!rational2.equals(rationalN2)) {
                    map.remove(rational2);
                }
            }
        }
        ArrayList<Rational> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList, new AbstractC19420qK.a(rationalN, rational));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Rational rational3 : arrayList) {
            linkedHashMap.put(rational3, (List) map.get(rational3));
        }
        return linkedHashMap;
    }

    private List c(List list, C22601vW5 c22601vW5, int i) {
        if (c22601vW5.a() != 1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(this.a.e(i));
        Collections.sort(arrayList, new C15686k01(true));
        return arrayList;
    }

    private static void d(LinkedHashMap linkedHashMap, Size size) {
        int iB = AbstractC10811cE6.b(size);
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            List<Size> list = (List) linkedHashMap.get((Rational) it.next());
            ArrayList arrayList = new ArrayList();
            for (Size size2 : list) {
                if (AbstractC10811cE6.b(size2) <= iB) {
                    arrayList.add(size2);
                }
            }
            list.clear();
            list.addAll(arrayList);
        }
    }

    private static List e(List list, InterfaceC21354tW5 interfaceC21354tW5, int i, int i2, int i3) {
        if (interfaceC21354tW5 == null) {
            return list;
        }
        List listA = interfaceC21354tW5.a(new ArrayList(list), AbstractC22425vD0.a(AbstractC22425vD0.b(i), i2, i3 == 1));
        if (list.containsAll(listA)) {
            return listA;
        }
        throw new IllegalArgumentException("The returned sizes list of the resolution filter must be a subset of the provided sizes list.");
    }

    private static void f(LinkedHashMap linkedHashMap, C23787xW5 c23787xW5) {
        if (c23787xW5 == null) {
            return;
        }
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            g((List) linkedHashMap.get((Rational) it.next()), c23787xW5);
        }
    }

    private static void g(List list, C23787xW5 c23787xW5) {
        if (list.isEmpty()) {
            return;
        }
        int iB = c23787xW5.b();
        if (c23787xW5.equals(C23787xW5.c)) {
            return;
        }
        Size sizeA = c23787xW5.a();
        if (iB == 0) {
            s(list, sizeA);
            return;
        }
        if (iB == 1) {
            q(list, sizeA, true);
            return;
        }
        if (iB == 2) {
            q(list, sizeA, false);
        } else if (iB == 3) {
            r(list, sizeA, true);
        } else {
            if (iB != 4) {
                return;
            }
            r(list, sizeA, false);
        }
    }

    private Rational h(Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational i(InterfaceC14623iD0 interfaceC14623iD0) {
        List listH = interfaceC14623iD0.h(256);
        if (listH.isEmpty()) {
            return null;
        }
        Size size = (Size) Collections.max(listH, new C15686k01());
        return new Rational(size.getWidth(), size.getHeight());
    }

    private List j(List list, int i) {
        List listL = l(list, i);
        if (listL == null) {
            listL = this.a.h(i);
        }
        ArrayList arrayList = new ArrayList(listL);
        Collections.sort(arrayList, new C15686k01(true));
        if (arrayList.isEmpty()) {
            PI3.l("SupportedOutputSizesCollector", "The retrieved supported resolutions from camera info internal is empty. Format is " + i + Separators.DOT);
        }
        return arrayList;
    }

    static List k(List list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AbstractC19420qK.a);
        arrayList.add(AbstractC19420qK.c);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            Rational rational = new Rational(size.getWidth(), size.getHeight());
            if (!arrayList.contains(rational)) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        arrayList.add(rational);
                        break;
                    }
                    if (AbstractC19420qK.a(size, (Rational) it2.next())) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    private List l(List list, int i) {
        Size[] sizeArr;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (((Integer) pair.first).intValue() == i) {
                    sizeArr = (Size[]) pair.second;
                    break;
                }
            }
            sizeArr = null;
        } else {
            sizeArr = null;
        }
        if (sizeArr == null) {
            return null;
        }
        return Arrays.asList(sizeArr);
    }

    static Rational n(int i, boolean z) {
        if (i != -1) {
            if (i == 0) {
                return z ? AbstractC19420qK.a : AbstractC19420qK.b;
            }
            if (i == 1) {
                return z ? AbstractC19420qK.c : AbstractC19420qK.d;
            }
            PI3.c("SupportedOutputSizesCollector", "Undefined target aspect ratio: " + i);
        }
        return null;
    }

    static Map o(List list) {
        HashMap map = new HashMap();
        Iterator it = k(list).iterator();
        while (it.hasNext()) {
            map.put((Rational) it.next(), new ArrayList());
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Size size = (Size) it2.next();
            for (Rational rational : map.keySet()) {
                if (AbstractC19420qK.a(size, rational)) {
                    ((List) map.get(rational)).add(size);
                }
            }
        }
        return map;
    }

    public static List p(C22601vW5 c22601vW5, List list, Size size, int i, Rational rational, int i2, int i3) {
        LinkedHashMap linkedHashMapA = a(list, c22601vW5.b(), rational);
        if (size != null) {
            d(linkedHashMapA, size);
        }
        f(linkedHashMapA, c22601vW5.d());
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMapA.values().iterator();
        while (it.hasNext()) {
            for (Size size2 : (List) it.next()) {
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
        }
        c22601vW5.c();
        return e(arrayList, null, i, i2, i3);
    }

    static void q(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Size size3 = (Size) list.get(size2);
            if (size3.getWidth() >= size.getWidth() && size3.getHeight() >= size.getHeight()) {
                break;
            }
            arrayList.add(0, size3);
        }
        list.removeAll(arrayList);
        Collections.reverse(list);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void r(List list, Size size, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Size size2 = (Size) list.get(i);
            if (size2.getWidth() <= size.getWidth() && size2.getHeight() <= size.getHeight()) {
                break;
            }
            arrayList.add(0, size2);
        }
        list.removeAll(arrayList);
        if (z) {
            list.addAll(arrayList);
        }
    }

    private static void s(List list, Size size) {
        boolean zContains = list.contains(size);
        list.clear();
        if (zContains) {
            list.add(size);
        }
    }

    public List m(androidx.camera.core.impl.C c) {
        androidx.camera.core.impl.o oVar = (androidx.camera.core.impl.o) c;
        List listH = oVar.H(null);
        if (listH != null) {
            return listH;
        }
        C22601vW5 c22601vW5G = oVar.G(null);
        List listJ = j(oVar.k(null), c.getInputFormat());
        if (c22601vW5G == null) {
            return this.e.f(listJ, c);
        }
        Size sizeI = ((androidx.camera.core.impl.o) c).i(null);
        int iC = oVar.C(0);
        if (!c.S(false)) {
            listJ = c(listJ, c22601vW5G, c.getInputFormat());
        }
        return p(oVar.l(), listJ, sizeI, iC, this.d, this.b, this.c);
    }
}
