package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Mz5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C6293Mz5 {
    private final List a;

    public C6293Mz5(List list) {
        this.a = new ArrayList(list);
    }

    public static String d(C6293Mz5 c6293Mz5) {
        ArrayList arrayList = new ArrayList();
        Iterator it = c6293Mz5.a.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC5592Jz5) it.next()).getClass().getSimpleName());
        }
        return AbstractC6059Lz5.a(" | ", arrayList);
    }

    public boolean a(Class cls) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(((InterfaceC5592Jz5) it.next()).getClass())) {
                return true;
            }
        }
        return false;
    }

    public InterfaceC5592Jz5 b(Class cls) {
        for (InterfaceC5592Jz5 interfaceC5592Jz5 : this.a) {
            if (interfaceC5592Jz5.getClass() == cls) {
                return interfaceC5592Jz5;
            }
        }
        return null;
    }

    public List c(Class cls) {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC5592Jz5 interfaceC5592Jz5 : this.a) {
            if (cls.isAssignableFrom(interfaceC5592Jz5.getClass())) {
                arrayList.add(interfaceC5592Jz5);
            }
        }
        return arrayList;
    }
}
