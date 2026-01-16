package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.el, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC12519el {
    public static final List a(C11907dl c11907dl) {
        String strV;
        AbstractC13042fc3.i(c11907dl, "<this>");
        long jMax = 0;
        boolean z = false;
        List listR = null;
        for (J44 j44 : c11907dl.r()) {
            C23345wl7 c23345wl7L = j44.F().l();
            if (c23345wl7L != null && (strV = c23345wl7L.v()) != null && (!AbstractC20762sZ6.n0(strV)) && !z) {
                if (listR == null) {
                    listR = j44.R();
                } else {
                    listR = ((J44) AbstractC15401jX0.q0(c11907dl.r())).R();
                    z = true;
                }
            }
            jMax = Math.max(jMax, d(j44));
        }
        if (listR == null) {
            listR = ((J44) AbstractC15401jX0.q0(c11907dl.r())).R();
        }
        return c(listR, jMax);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String b(C11907dl c11907dl) {
        String strV;
        C23345wl7 c23345wl7T;
        AbstractC13042fc3.i(c11907dl, "<this>");
        List listR = c11907dl.r();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listR, 10));
        Iterator it = listR.iterator();
        while (true) {
            strV = null;
            if (!it.hasNext()) {
                break;
            }
            C24967zW1 c24967zW1H = ((J44) it.next()).H();
            if (c24967zW1H != null && (c23345wl7T = c24967zW1H.t()) != null) {
                strV = c23345wl7T.v();
            }
            arrayList.add(strV);
        }
        Iterator it2 = arrayList.iterator();
        boolean z = false;
        String str = null;
        while (true) {
            if (it2.hasNext()) {
                Object next = it2.next();
                String str2 = (String) next;
                if (!(str2 == null || str2.length() == 0)) {
                    if (z) {
                        break;
                    }
                    str = next;
                    z = true;
                }
            } else if (z) {
                strV = str;
            }
        }
        return strV;
    }

    private static final List c(List list, long j) {
        if (j <= 0) {
            return list;
        }
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (AbstractC13042fc3.d(((GG5) it.next()).u(), "👁️")) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return AbstractC15401jX0.S0(list, new GG5("👁️", AbstractC10360bX0.m(), j));
        }
        List listP1 = AbstractC15401jX0.p1(list);
        GG5 gg5 = (GG5) listP1.remove(i);
        listP1.add(new GG5(gg5.u(), gg5.y(), Math.max(j, gg5.s())));
        return listP1;
    }

    private static final long d(J44 j44) {
        Object next;
        Iterator it = j44.R().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((GG5) next).u(), "👁️")) {
                break;
            }
        }
        GG5 gg5 = (GG5) next;
        if (gg5 != null) {
            return gg5.s();
        }
        return 0L;
    }
}
