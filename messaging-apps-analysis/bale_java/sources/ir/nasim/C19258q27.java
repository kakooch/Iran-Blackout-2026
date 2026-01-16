package ir.nasim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.q27, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19258q27 {
    private final List a = new ArrayList();

    private static void b(List list, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= i2) {
                    iArr[i2] = i3;
                    b(list, i, iArr, i2 + 1);
                    break;
                } else if (i3 == iArr[i4]) {
                    break;
                } else {
                    i4++;
                }
            }
        }
    }

    private List c(int i) {
        ArrayList arrayList = new ArrayList();
        b(arrayList, i, new int[i], 0);
        return arrayList;
    }

    public boolean a(AbstractC19849r27 abstractC19849r27) {
        return this.a.add(abstractC19849r27);
    }

    public List d(List list) {
        int i;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.a.size()) {
            return null;
        }
        List listC = c(this.a.size());
        AbstractC19849r27[] abstractC19849r27Arr = new AbstractC19849r27[list.size()];
        Iterator it = listC.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            int[] iArr = (int[]) it.next();
            boolean zG = true;
            while (i < this.a.size()) {
                if (iArr[i] < list.size()) {
                    zG &= ((AbstractC19849r27) this.a.get(i)).g((AbstractC19849r27) list.get(iArr[i]));
                    if (!zG) {
                        break;
                    }
                    abstractC19849r27Arr[iArr[i]] = (AbstractC19849r27) this.a.get(i);
                }
                i++;
            }
            if (zG) {
                i = 1;
                break;
            }
        }
        if (i != 0) {
            return Arrays.asList(abstractC19849r27Arr);
        }
        return null;
    }
}
