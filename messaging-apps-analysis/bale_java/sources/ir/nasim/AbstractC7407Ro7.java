package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Ro7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC7407Ro7 {
    private static final AbstractC8114Uo7 a = AbstractC20507s76.j();

    public static FC6 a() {
        ArrayList arrayList = (ArrayList) a.a();
        return (arrayList == null || arrayList.size() == 0) ? new C4082Dp4() : (FC6) arrayList.get(arrayList.size() - 1);
    }

    public static void b() {
        ArrayList arrayList = (ArrayList) a.a();
        if (arrayList == null || arrayList.size() == 0) {
            throw new RuntimeException("Current Thread doesn't have Active Dispatchers");
        }
        arrayList.remove(arrayList.size() - 1);
    }

    public static void c(FC6 fc6) {
        AbstractC8114Uo7 abstractC8114Uo7 = a;
        if (abstractC8114Uo7.a() != null) {
            ((ArrayList) abstractC8114Uo7.a()).add(fc6);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(fc6);
        abstractC8114Uo7.b(arrayList);
    }
}
