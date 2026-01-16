package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ow3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6763Ow3 {
    public static final List b(EN6 en6, List list, AbstractC18977pa3 abstractC18977pa3, int i, int i2, int i3, int i4, UA2 ua2) {
        if (en6 == null || !(!list.isEmpty()) || abstractC18977pa3.b == 0) {
            return AbstractC10360bX0.m();
        }
        AbstractC18977pa3 abstractC18977pa3A = en6.a(((InterfaceC24630yw3) AbstractC15401jX0.q0(list)).getIndex(), ((InterfaceC24630yw3) AbstractC15401jX0.C0(list)).getIndex(), abstractC18977pa3);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (abstractC18977pa3.c(((InterfaceC24630yw3) obj).getIndex())) {
                arrayList2.add(obj);
            }
        }
        int[] iArr = abstractC18977pa3A.a;
        int i6 = 0;
        for (int i7 = abstractC18977pa3A.b; i6 < i7; i7 = i7) {
            int i8 = iArr[i6];
            Iterator it = list.iterator();
            int i9 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i9 = -1;
                    break;
                }
                if (((InterfaceC24630yw3) it.next()).getIndex() == i8) {
                    break;
                }
                i9++;
            }
            InterfaceC24630yw3 interfaceC24630yw3 = i9 == -1 ? (InterfaceC24630yw3) ua2.invoke(Integer.valueOf(i8)) : (InterfaceC24630yw3) list.remove(i9);
            int iB = en6.b(arrayList2, i8, interfaceC24630yw3.k(), i9 == -1 ? RecyclerView.UNDEFINED_DURATION : c(interfaceC24630yw3), i, i2, i3, i4);
            interfaceC24630yw3.g(true);
            interfaceC24630yw3.j(iB, 0, i3, i4);
            arrayList.add(interfaceC24630yw3);
            i6++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(InterfaceC24630yw3 interfaceC24630yw3) {
        long jM = interfaceC24630yw3.m(0);
        return interfaceC24630yw3.i() ? C22045ua3.l(jM) : C22045ua3.k(jM);
    }
}
