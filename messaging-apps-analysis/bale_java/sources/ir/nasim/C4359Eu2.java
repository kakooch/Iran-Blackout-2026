package ir.nasim;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Eu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4359Eu2 {
    private final List a;
    private final boolean b;

    public C4359Eu2(InterfaceC4125Du2... interfaceC4125Du2Arr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (interfaceC4125Du2Arr.length > 0) {
            InterfaceC4125Du2 interfaceC4125Du2 = interfaceC4125Du2Arr[0];
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.size() != 1) {
                throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + AbstractC15401jX0.A0(list, null, null, null, 0, null, null, 63, null) + ']').toString());
            }
            AbstractC13610gX0.D(arrayList, list);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        this.a = arrayList2;
        if (arrayList2.size() > 0) {
            AbstractC18350oW3.a(arrayList2.get(0));
            throw null;
        }
        this.b = false;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C4359Eu2) && AbstractC13042fc3.d(this.a, ((C4359Eu2) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
