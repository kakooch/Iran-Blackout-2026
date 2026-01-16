package ir.nasim;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class MY7 {
    public static final InterfaceC15194jA0 a(Collection collection) {
        Integer numD;
        AbstractC13042fc3.i(collection, "descriptors");
        collection.isEmpty();
        Iterator it = collection.iterator();
        InterfaceC15194jA0 interfaceC15194jA0 = null;
        while (it.hasNext()) {
            InterfaceC15194jA0 interfaceC15194jA02 = (InterfaceC15194jA0) it.next();
            if (interfaceC15194jA0 == null || ((numD = QI1.d(interfaceC15194jA0.getVisibility(), interfaceC15194jA02.getVisibility())) != null && numD.intValue() < 0)) {
                interfaceC15194jA0 = interfaceC15194jA02;
            }
        }
        AbstractC13042fc3.f(interfaceC15194jA0);
        return interfaceC15194jA0;
    }
}
