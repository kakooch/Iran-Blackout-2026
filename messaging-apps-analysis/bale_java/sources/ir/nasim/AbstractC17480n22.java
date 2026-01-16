package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.n22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17480n22 {
    private static C15116j22 a(List list) {
        if (list.isEmpty()) {
            return null;
        }
        C15116j22 c15116j22 = (C15116j22) list.get(0);
        Integer numValueOf = Integer.valueOf(c15116j22.b());
        Integer numValueOf2 = Integer.valueOf(c15116j22.a());
        for (int i = 1; i < list.size(); i++) {
            C15116j22 c15116j222 = (C15116j22) list.get(i);
            numValueOf = c(numValueOf, Integer.valueOf(c15116j222.b()));
            numValueOf2 = b(numValueOf2, Integer.valueOf(c15116j222.a()));
            if (numValueOf == null || numValueOf2 == null) {
                return null;
            }
        }
        return new C15116j22(numValueOf.intValue(), numValueOf2.intValue());
    }

    private static Integer b(Integer num, Integer num2) {
        if (num.equals(0)) {
            return num2;
        }
        if (num2.equals(0) || num.equals(num2)) {
            return num;
        }
        return null;
    }

    private static Integer c(Integer num, Integer num2) {
        if (num.equals(0)) {
            return num2;
        }
        if (num2.equals(0)) {
            return num;
        }
        if (num.equals(2) && !num2.equals(1)) {
            return num2;
        }
        if ((!num2.equals(2) || num.equals(1)) && !num.equals(num2)) {
            return null;
        }
        return num;
    }

    public static C15116j22 d(Set set) {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((androidx.camera.core.impl.C) it.next()).F());
        }
        return a(arrayList);
    }
}
