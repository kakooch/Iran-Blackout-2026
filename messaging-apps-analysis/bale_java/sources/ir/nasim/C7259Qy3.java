package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Qy3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C7259Qy3 implements InterfaceC12203eD0 {
    private final int b;

    public C7259Qy3(int i) {
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC12203eD0
    public List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC14021hD0 interfaceC14021hD0 = (InterfaceC14021hD0) it.next();
            AbstractC4980Hj5.b(interfaceC14021hD0 instanceof InterfaceC14623iD0, "The camera info doesn't contain internal implementation.");
            if (interfaceC14021hD0.d() == this.b) {
                arrayList.add(interfaceC14021hD0);
            }
        }
        return arrayList;
    }

    public int b() {
        return this.b;
    }
}
