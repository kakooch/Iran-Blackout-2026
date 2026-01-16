package ir.nasim;

import android.util.Rational;
import android.util.Size;
import ir.nasim.AbstractC19420qK;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.m27, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C16894m27 {
    private final int a;
    private final int b;
    private final Rational c;
    private final boolean d;

    C16894m27(InterfaceC14623iD0 interfaceC14623iD0, Rational rational) {
        this.a = interfaceC14623iD0.a();
        this.b = interfaceC14623iD0.d();
        this.c = rational;
        boolean z = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z = false;
        }
        this.d = z;
    }

    private static Size a(Size size, int i, int i2, int i3) {
        return (size == null || !e(i, i2, i3)) ? size : new Size(size.getHeight(), size.getWidth());
    }

    private static Rational b(Size size, List list) {
        if (size == null) {
            return null;
        }
        for (Rational rational : C16303l27.k(list)) {
            if (AbstractC19420qK.a(size, rational)) {
                return rational;
            }
        }
        return new Rational(size.getWidth(), size.getHeight());
    }

    private Rational c(androidx.camera.core.impl.o oVar, List list) {
        if (oVar.x()) {
            return C16303l27.n(oVar.A(), this.d);
        }
        Size sizeD = d(oVar);
        if (sizeD != null) {
            return b(sizeD, list);
        }
        return null;
    }

    private Size d(androidx.camera.core.impl.o oVar) {
        return a(oVar.M(null), oVar.C(0), this.b, this.a);
    }

    private static boolean e(int i, int i2, int i3) {
        int iA = AbstractC22425vD0.a(AbstractC22425vD0.b(i), i3, 1 == i2);
        return iA == 90 || iA == 270;
    }

    List f(List list, androidx.camera.core.impl.C c) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<Size> arrayList = new ArrayList(list);
        Collections.sort(arrayList, new C15686k01(true));
        ArrayList arrayList2 = new ArrayList();
        androidx.camera.core.impl.o oVar = (androidx.camera.core.impl.o) c;
        Size sizeI = oVar.i(null);
        Size size = (Size) arrayList.get(0);
        if (sizeI == null || AbstractC10811cE6.b(size) < AbstractC10811cE6.b(sizeI)) {
            sizeI = size;
        }
        Size sizeD = d(oVar);
        Size size2 = AbstractC10811cE6.c;
        int iB = AbstractC10811cE6.b(size2);
        if (AbstractC10811cE6.b(sizeI) < iB) {
            size2 = AbstractC10811cE6.a;
        } else if (sizeD != null && AbstractC10811cE6.b(sizeD) < iB) {
            size2 = sizeD;
        }
        for (Size size3 : arrayList) {
            if (AbstractC10811cE6.b(size3) <= AbstractC10811cE6.b(sizeI) && AbstractC10811cE6.b(size3) >= AbstractC10811cE6.b(size2) && !arrayList2.contains(size3)) {
                arrayList2.add(size3);
            }
        }
        if (arrayList2.isEmpty()) {
            throw new IllegalArgumentException("All supported output sizes are filtered out according to current resolution selection settings. \nminSize = " + size2 + "\nmaxSize = " + sizeI + "\ninitial size list: " + arrayList);
        }
        Rational rationalC = c(oVar, arrayList2);
        if (sizeD == null) {
            sizeD = oVar.I(null);
        }
        ArrayList arrayList3 = new ArrayList();
        new HashMap();
        if (rationalC == null) {
            arrayList3.addAll(arrayList2);
            if (sizeD != null) {
                C16303l27.q(arrayList3, sizeD, true);
            }
        } else {
            Map mapO = C16303l27.o(arrayList2);
            if (sizeD != null) {
                Iterator it = mapO.keySet().iterator();
                while (it.hasNext()) {
                    C16303l27.q((List) mapO.get((Rational) it.next()), sizeD, true);
                }
            }
            ArrayList arrayList4 = new ArrayList(mapO.keySet());
            Collections.sort(arrayList4, new AbstractC19420qK.a(rationalC, this.c));
            Iterator it2 = arrayList4.iterator();
            while (it2.hasNext()) {
                for (Size size4 : (List) mapO.get((Rational) it2.next())) {
                    if (!arrayList3.contains(size4)) {
                        arrayList3.add(size4);
                    }
                }
            }
        }
        return arrayList3;
    }
}
