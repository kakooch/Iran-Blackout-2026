package ir.aaap.messengercore.utilites;

import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class Objects {
    public static boolean equals(Object obj, Object obj2) {
        if ((obj instanceof ArrayList) && (obj2 instanceof ArrayList)) {
            return equalsArray((ArrayList) obj, (ArrayList) obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean equalsArray(ArrayList<? extends Object> arrayList, ArrayList<? extends Object> arrayList2) {
        if (arrayList == null || arrayList2 == null) {
            return arrayList == null && arrayList2 == null;
        }
        if (arrayList.size() != arrayList2.size()) {
            return false;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (!equals(arrayList.get(i), arrayList2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
