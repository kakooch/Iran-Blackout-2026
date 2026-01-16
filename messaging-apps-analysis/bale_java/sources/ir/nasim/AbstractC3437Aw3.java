package ir.nasim;

import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.Aw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3437Aw3 {
    private static final Comparator a = new Comparator() { // from class: ir.nasim.zw3
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC3437Aw3.b((InterfaceC24630yw3) obj, (InterfaceC24630yw3) obj2);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(InterfaceC24630yw3 interfaceC24630yw3, InterfaceC24630yw3 interfaceC24630yw32) {
        return AbstractC13042fc3.k(interfaceC24630yw3.getIndex(), interfaceC24630yw32.getIndex());
    }

    public static final List c(int i, int i2, List list, List list2) {
        if (list.isEmpty()) {
            return AbstractC10360bX0.m();
        }
        List listP1 = AbstractC15401jX0.p1(list2);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC24630yw3 interfaceC24630yw3 = (InterfaceC24630yw3) list.get(i3);
            int index = interfaceC24630yw3.getIndex();
            if (i <= index && index <= i2) {
                listP1.add(interfaceC24630yw3);
            }
        }
        AbstractC12992fX0.B(listP1, a);
        return listP1;
    }
}
